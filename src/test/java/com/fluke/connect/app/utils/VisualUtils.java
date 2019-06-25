package com.fluke.connect.app.utils;
 
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import io.appium.java_client.MobileElement;

public class VisualUtils 
{
	public static void saveScreenshot(String outputLocation) 
	{
		try 
		{
			CommonUtils.wait(2);
			File srcFile = ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File(outputLocation));
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}		
	}

	public static void saveElementScreenshot(MobileElement element, String location)
	{
		try 
		{
			File pageScreenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
			BufferedImage fullImg = ImageIO.read(pageScreenshot);
			Point point = element.getLocation();
			int elementWidth = element.getSize().getWidth();
			int elementHeight = element.getSize().getHeight();
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), elementWidth * 2, elementHeight * 2);
				ImageIO.write(eleScreenshot, "png", pageScreenshot);
			}
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), elementWidth, elementHeight);
				ImageIO.write(eleScreenshot, "png", pageScreenshot);
			}
			FileUtils.copyFile(pageScreenshot, new File(location));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void saveElementScreenshot(WebElement element, String location)
	{
		try 
		{
			File pageScreenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
			BufferedImage fullImage = ImageIO.read(pageScreenshot);
			Point point = element.getLocation();
			int elementWidth = element.getSize().getWidth();
			int elementHeight = element.getSize().getHeight();
			if(DriverManager.getDriverName().equals("iOS"))
			{
				BufferedImage elementScreenshot= fullImage.getSubimage(point.getX(), point.getY(), elementWidth * 2, elementHeight * 2);
				ImageIO.write(elementScreenshot, "png", pageScreenshot);
			}
			else if(DriverManager.getDriverName().equals("Android"))
			{
				BufferedImage elementScreenshot= fullImage.getSubimage(point.getX(), point.getY(), elementWidth, elementHeight);
				ImageIO.write(elementScreenshot, "png", pageScreenshot);
			}
			else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				BufferedImage elementScreenshot= fullImage.getSubimage(point.getX(), point.getY(), elementWidth * 2, elementHeight * 2);
				ImageIO.write(elementScreenshot, "png", pageScreenshot);
			}
			FileUtils.copyFile(pageScreenshot, new File(location));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void saveFCCMGraphScreenshot(WebElement element, String location)
	{
		try 
		{
			File pageScreenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
			BufferedImage fullImage = ImageIO.read(pageScreenshot);
			Point point = element.getLocation();
			int elementWidth = element.getSize().getWidth();
			int elementHeight = element.getSize().getHeight();
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				BufferedImage elementScreenshot= fullImage.getSubimage(point.getX() * 2, point.getY() * 2, elementWidth * 2, elementHeight * 2);
				ImageIO.write(elementScreenshot, "png", pageScreenshot);
			}
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				BufferedImage elementScreenshot= fullImage.getSubimage(point.getX(), point.getY(), elementWidth, elementHeight);
				ImageIO.write(elementScreenshot, "png", pageScreenshot);
			}
			else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				BufferedImage elementScreenshot	= fullImage;
				ImageIO.write(elementScreenshot, "png", pageScreenshot);
			}
			FileUtils.copyFile(pageScreenshot, new File(location));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public static boolean compareVisuals(String expectedVisualPath, String actualVisualPath, String deviatedVisualPath)
	{
		boolean returnFlag = true;
		try
		{
			BufferedImage expectedImage = ImageIO.read(new File(expectedVisualPath));
			BufferedImage actualImage = ImageIO.read(new File(actualVisualPath));
			returnFlag = compareImages(expectedImage, actualImage, deviatedVisualPath);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			returnFlag = false;
		}	
		return returnFlag;
	}
	
	public static boolean compareImages(BufferedImage expectedImage, BufferedImage actualImage, String deviatedImagePath)
	{
		boolean returnFlag = true;
		try 
		{
			if (expectedImage.getWidth() != actualImage.getWidth() || expectedImage.getHeight() != actualImage.getHeight()) 
			{
			    returnFlag = false;
			}
			final int imageWidth = expectedImage.getWidth(),
			          imageHeight = expectedImage.getHeight(), 
			          highlightColor = Color.RED.getRGB();
			final int[] expectedImagePixelArray = expectedImage.getRGB(0, 0, imageWidth, imageHeight, null, 0, imageWidth);
			final int[] actualImagePixelArray =  actualImage.getRGB(0, 0, imageWidth, imageHeight, null, 0, imageWidth);
			for (int i = 0; i < expectedImagePixelArray.length; i++) 
			{
				if (expectedImagePixelArray[i] != actualImagePixelArray[i]) 
				{
					expectedImagePixelArray[i] = highlightColor;
					returnFlag = false;
				}
			}
			if(deviatedImagePath != null)
			{
				BufferedImage deviatedImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
				deviatedImage.setRGB(0, 0, imageWidth, imageHeight, expectedImagePixelArray, 0, imageWidth);
				ImageIO.write(deviatedImage, "png", new File(deviatedImagePath));
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			returnFlag = false;
		}
		return returnFlag;
	}
	
	public static java.awt.Dimension getScreenDimensionObject()
	{
		return Toolkit.getDefaultToolkit().getScreenSize();
	}

	public static int getAppHeight()
	{
	   return DriverManager.getDriver().manage().window().getSize().getHeight();
	}

	public static int getAppWidth()
	{
		return DriverManager.getDriver().manage().window().getSize().getWidth();
	}

	public static void startVideoRecordingOniPhoneSimulator(String videoFileName)
	{
		CommonUtils.wait(4);
		CommonUtils.executeCommandOnTerminal("xcrun simctl io booted recordVideo "+videoFileName+".mp4");
		CommonUtils.wait(4);
	}

	public static void stopVideoRecordingOniPhoneSimulator()
	{
		CommonUtils.wait(4);
		CommonUtils.executeCommandOnTerminal("pkill -2 simctl");
		CommonUtils.wait(4);
	}
}
