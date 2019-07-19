package com.eCRM.client.core;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.time.Duration;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.apache.tools.ant.taskdefs.condition.And;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.internal.annotations.TestAnnotation;

import com.eCRM.client.core.Config.LocatorStrategy;
import com.eCRM.client.core.Config.ScrollDiection;
import com.eCRM.client.pages.LogInPage;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.TapOptions;

@SuppressWarnings({"unused"})
public class CommonUtils 
{
	private static Process process;
	private static int reliableRetryClickCount = 0;
	private static boolean reliableRetryClickFlag = true;
	private static Robot robot;
	private static Wait<WebDriver> fluentWait;
	private static WebElement element;
	private static JavascriptExecutor javaScriptExecutor;
	private static Actions actions;
	private int startX, startY, endX, endY;
	
	
	public CommonUtils() {
		actions = new Actions(DriverManager.getDriver());
		javaScriptExecutor = (JavascriptExecutor) DriverManager.getDriver();
	}
	
	
	

	// ************************* Actions and Events methods **********************************

	
	public static void moveToElement(WebElement element) {
		actions.moveToElement(element).build().perform();
	}

	public static void moveAndClickElement(WebElement element) {
		actions.moveToElement(element).click().build().perform();
	}
	
	
	
	
	
	//*********************** Scroll methods **************************************

	public void scroll(int scrollSteps, int scrollCount) 
	{
		for (int i = 0; i < scrollCount; i++) {
			javaScriptExecutor.executeScript("window.scrollBy(0," + scrollSteps + ")",
					"");
		}
	}
		
	
	public boolean scrollToElement(WebElement element) {
		try {
			javaScriptExecutor.executeScript("arguments[0].scrollIntoView();", element);
			if (element.isDisplayed())
				return true;
			else
				return false;
		} catch (Throwable e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean scrollToElement(WebElement element, ScrollDiection scrollDirection,
			int scrollCount) {
		if (isDisplayed(10, 1, element))
			return true;
		for (int i = 0; i < scrollCount; i++) {
			if (scrollDirection == ScrollDiection.DOWN) {
				javaScriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
				CommonUtils.wait(2);
				if (isDisplayed(10, 1, element))
					return true;
			} else if (scrollDirection == ScrollDiection.UP) {
				javaScriptExecutor.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
				CommonUtils.wait(2);
				if (isDisplayed(10, 1, element))
					return true;
			}
		}
		return false;
	}

	
	public void popupScroll(WebElement parentElement, WebElement childElement, ScrollDiection scrollDirection,
			int scrollCount) {
		for (int i = 0; i < scrollCount; i++) {
			if (scrollDirection == ScrollDiection.DOWN) {
				javaScriptExecutor.executeScript("arguments[0].scrollTop = arguments[1];", parentElement, 100);
				if (isDisplayed(10, 1, childElement))
					break;
			} else if (scrollDirection == ScrollDiection.UP) {
						javaScriptExecutor.executeScript("arguments[0].scrollBottom = arguments[1];", parentElement, 100);
				if (isDisplayed(10, 1, childElement))
					break;
			}
		}
		CommonUtils.wait(2);
	}

	public void webPopupScroll(WebElement parentElement, int scrollSteps, int scrollCount) {
		if (scrollSteps <= 0)
			javaScriptExecutor.executeScript("arguments[0].scrollTop = arguments[1];",
					parentElement, Math.abs(scrollSteps));
		else if (scrollSteps > 0)
			javaScriptExecutor.executeScript("arguments[0].scrollBottom = arguments[1];",
					parentElement, Math.abs(scrollSteps));
		CommonUtils.wait(2);
	}

	
	// ***************************************  Find ELEMENT METHODS *************************************************
	
	
	
	
		public static WebElement getElement( LocatorStrategy webLocatorStrategy, String webAttributeValue)
		{
			WebElement returnElement = null;

			try {

				switch (webLocatorStrategy) {
				case WEB_LOCATOR_STRATEGY_ID:
					returnElement = DriverManager.getDriver().findElement(By.id(webAttributeValue));
					break;
				case WEB_LOCATOR_STRATEGY_XPATH:
					returnElement = DriverManager.getDriver().findElement(By.xpath(webAttributeValue));
					break;
				case WEB_LOCATOR_STRATEGY_XPATH_TEXT:
					returnElement = DriverManager.getDriver().findElement(By.xpath("//*[. = '" + webAttributeValue + "']"));
					break;
				case WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS:
					returnElement = DriverManager.getDriver()
							.findElement(By.xpath("//*[contains(text(), '" + webAttributeValue + "')]"));
					break;
				case WEB_LOCATOR_STRATEGY_XPATH_SPAN_TEXT_CONTAINS:
					returnElement = DriverManager.getDriver()
							.findElement(By.xpath("//span[contains(text(), '" + webAttributeValue + "')]"));
					break;
				case WEB_LOCATOR_STRATEGY_CSS:
					returnElement = DriverManager.getDriver().findElement(By.cssSelector(webAttributeValue));
					break;
				case WEB_LOCATOR_STRATEGY_XPATH_TEXT_CONTAINS:
					returnElement = DriverManager.getDriver()
							.findElement(By.xpath("//*[contains(text(), '" + webAttributeValue + "')]"));
					break;
				default:
				}
				return returnElement;

			} catch (Throwable e) {
				return null;
			}
		}

		
		
		public static List<WebElement> getElements(WebElement parentElement, LocatorStrategy webLocatorStrategy, String webAttributeValue)
		{
			try
			{
				List<WebElement> returnElement = null;
				
					switch(webLocatorStrategy)
					{
					    case WEB_LOCATOR_STRATEGY_ID:
					    		returnElement = parentElement.findElements(By.id(webAttributeValue));
					    		break;
					    case WEB_LOCATOR_STRATEGY_XPATH:
							returnElement = parentElement.findElements(By.xpath(webAttributeValue));
							break;
					    case WEB_LOCATOR_STRATEGY_XPATH_TEXT:
							returnElement = parentElement.findElements(By.xpath("//*[. = '"+webAttributeValue+"']"));
							break;
						case WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS:
							returnElement = parentElement.findElements(By.xpath("//div[contains(text(), '"+webAttributeValue+"')]"));
							break;
						case WEB_LOCATOR_STRATEGY_XPATH_SPAN_TEXT_CONTAINS:
							returnElement = parentElement.findElements(By.xpath("//span[contains(text(), '"+webAttributeValue+"')]"));
							break;
						case WEB_LOCATOR_STRATEGY_CSS:
							returnElement = parentElement.findElements(By.cssSelector(webAttributeValue));
							break;
						case WEB_LOCATOR_STRATEGY_CSS_INPUT_DATA_FEATURE:
							returnElement = parentElement.findElements(By.cssSelector("input[data-feature = '"+webAttributeValue+"']"));
							break;
						default:
					}
					return returnElement;
				
			}
			catch(Throwable e)
			{
				e.printStackTrace();
				return null;
			}
			
		}
		
		
		
		// ***************************************  IS DISPLAYED / ENABLED METHODS *************************************************
		
		public static boolean isDisplayed(int timeoutInSeconds, int pollingTimeInSeconds, WebElement aNelement)
		{
			try
			{
				if(timeoutInSeconds == 0)
					timeoutInSeconds = Config.TIMEOUT_IN_SECONDS;
				if(pollingTimeInSeconds == 0)
					pollingTimeInSeconds = Config.POLLING_TIME_IN_SECONDS;
				
					fluentWait = new FluentWait<WebDriver>(DriverManager.getDriver())
							.pollingEvery(Duration.ofSeconds(pollingTimeInSeconds))
							.withTimeout(Duration.ofSeconds(timeoutInSeconds))
								.ignoring(NoSuchElementException.class, Error.class);
				element = aNelement;
				return fluentWait.until ( new Function<WebDriver, Boolean>() 
				{
					public Boolean apply(WebDriver driver)
					{
						return element.isDisplayed();
					}
				}
			);
			}
			catch(Throwable e)
			{
				e.printStackTrace();
				return false;
			}
		}
		
		
		public static boolean isDisplayedAndEnabled(int timeoutInSeconds, int pollingTimeInSeconds, WebElement aNelement)
		{
			try
			{
				if(timeoutInSeconds == 0)
					timeoutInSeconds = Config.TIMEOUT_IN_SECONDS;
				if(pollingTimeInSeconds == 0)
					pollingTimeInSeconds = Config.POLLING_TIME_IN_SECONDS;
					fluentWait = new FluentWait<WebDriver>(DriverManager.getDriver())
							.pollingEvery(Duration.ofSeconds(pollingTimeInSeconds))
							.withTimeout(Duration.ofSeconds(timeoutInSeconds))
								.ignoring(NoSuchElementException.class, Error.class);
				element = aNelement;
				return fluentWait.until (new Function<WebDriver, Boolean>() 
				{
					public Boolean apply(WebDriver driver)
					{
						return (element.isDisplayed() && element.isEnabled());
					}
				}
			);
			}
			catch(Throwable e)
			{
				e.printStackTrace();
				return false;
			}
		}
		
		
		public static boolean isNotNull(int timeoutInSeconds, WebElement element)
		{
			for(int i = 0; i < timeoutInSeconds; i++)
			{
				try
				{
					if(element != null)
						return true;
				}
				catch(Exception e)
				{ 
					CommonUtils.wait(timeoutInSeconds);
				}
			}
			return false;
		}
		
		// *************************************** CLICK METHODS ********************************************************
		
		
		
		public static void click(int timeoutInSeconds, int pollingTimeInSeconds, WebElement element)
		{
			try
			{
				if(isDisplayed(timeoutInSeconds, pollingTimeInSeconds, element))
				element.click();
			}
			catch(Throwable e)
			{
				e.printStackTrace();
			}
		}
		

		public static void click(int timeoutInSeconds, int pollingTimeInSeconds, WebElement elementToBeClicked, WebElement elementToBeVisibleAfterClick, int retryCount) throws Exception
		{
			try
			{
				boolean retryFlag = true;
				int retryCounter = 0;
				boolean clickFlag = false;
				while(retryFlag)
				{
					if(isDisplayedAndEnabled(timeoutInSeconds, pollingTimeInSeconds, elementToBeClicked))
					{
						elementToBeClicked.click();
						clickFlag = true;
					}
					if(clickFlag && isDisplayed(10, 1, elementToBeVisibleAfterClick))
					{
						retryFlag = false;
					}
					else if(retryCounter == retryCount)
					{
						retryFlag = false;
					}
					else
					{
						retryCounter++;
					}
				}
			}
			catch(Throwable e)
			{
				e.printStackTrace();
				throw new Exception();
			}
		}
		
		public  static void click(WebElement element)
		{
			try 
			{
				javaScriptExecutor.executeScript("arguments[0].click();", element);
			}
			catch (NoSuchElementException e)
	        {
				e.printStackTrace();	
	        }
		}
		
		
		
		// ***************************************  SEND KEYS METHODS *************************************************
		
		
		public static void sendKeys(WebElement element, String textToBeTyped)
		{
			try {
				element.sendKeys(textToBeTyped);

			} catch (Throwable e) {
				e.printStackTrace();
			}
		}

		
		public static void sendKeys(int timeoutInSeconds, int pollingTimeInSeconds, WebElement element, String textToBeTyped, int retryCount)
		{
			try
			{
				boolean retryFlag = true;
				boolean setTextFlag = false;
				int retryCounter = 0;
				while(retryFlag)
				{
					if(isDisplayed(timeoutInSeconds, pollingTimeInSeconds, element))
					{
						
						{
							element.clear();
							element.sendKeys(textToBeTyped);
							setTextFlag = true;
						}
					}
					if(setTextFlag)
					{
						if(element.getAttribute("value").contains(textToBeTyped))
						{
							retryFlag = false;
						}
						else
						{
							retryCounter++;
						}
					}
					if(retryCounter == retryCount)
					{
						retryFlag = false;
					}
					else
					{
						retryCounter++;
					}
				}
			}
			catch(Throwable e)
			{
				e.printStackTrace();
			}
		}
		
	
	
	//************************  Miscellaneous methods *****************************  
	
	
	
		public static void executeCommandOnTerminal(String command)
		{
			try
			{
				process = Runtime.getRuntime().exec(command);
			}
			catch(Exception e){ }
		}
		
		public static void wait(int seconds)
		{
			try 
			{
				Thread.sleep(1000 * seconds);
			}
			catch(Exception e){ }
		}
		
		
		public static String[] split(String mainString, String... sepeartor)
		{
			String getString= Arrays.toString(sepeartor);
			return mainString.split(getString);
		}
		
		public int getScreenWidth() {
			return DriverManager.getDriver().manage().window().getSize().getWidth();
		}

		public int getScreenHeight() {
			return DriverManager.getDriver().manage().window().getSize().getHeight();
		}

		public Point getElementLocation(WebElement element) {
			return element.getLocation();
		}

		public Dimension getElementDimension(WebElement element) {
			return element.getSize();
		}	

		public static String getUserHomeDirectoryPath()
		{
			return System.getProperty("user.home");
		}
		
		public static String getUserCurrentDirectoryPath()
		{
			return System.getProperty("user.dir");
		}
		
}
	

