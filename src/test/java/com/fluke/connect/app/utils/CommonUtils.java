package com.fluke.connect.app.utils;

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
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.apache.tools.ant.taskdefs.condition.And;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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

import com.fluke.connect.app.functional.client.pages.SignInPage;
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
	private static Process terminalProcess;
	public static String failedWebTestScreenshotLocation = "./screenshots/failed_tests/web/";
	public static String passedWbTestScreenshotLocation = "./screenshots/passed_tests/web/";
	private static int reliableRetryClickCount = 0;
	private static boolean reliableRetryClickFlag = true;
	private static Robot robot;
	private static Wait<WebDriver> fluentWait;
	private static WebElement fluentWaitElement;
	public static void executeCommandOnTerminal(String command)
	{
		try
		{
			terminalProcess = Runtime.getRuntime().exec(command);
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
	
	public static void print(String printContent)
	{
		System.out.println("********************************************************************************************");
		System.out.println("****************************  "+printContent +" ***************************************");
		System.out.println("********************************************************************************************");
	}
	
	public static void wait(int androidWaitTimeInSeconds, int iOSWaitTimeInSeconds, int webWaitTimeInSeconds)
	{
		try 
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Thread.sleep(1000 * androidWaitTimeInSeconds);
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Thread.sleep(1000 * iOSWaitTimeInSeconds);
			}
			else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				Thread.sleep(1000 * webWaitTimeInSeconds);
			}
			
		}
		catch(Exception e){ }
	}
	
	public static void throwNewClickException(WebElement element)
	{
		try 
		{
			throw new Exception("Unable to click element"+ element);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void throwElementNotFoundException(String elementDescription) throws Exception
	{
		throw new Exception("Element Not found"+ elementDescription);
	}
	
	public static void initElements(Object object)
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver(), Duration.ofSeconds(10)), object);
		}
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			PageFactory.initElements(DriverManager.getDriver(), object);
		}
	}
	
	public static void initElements(Object object, int timeoutValueForMobileElement)
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver(), Duration.ofSeconds(timeoutValueForMobileElement)), object);
		}
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			PageFactory.initElements(DriverManager.getDriver(), object);
		}
	}
	
	public static String getUserHomeDirectoryPath()
	{
		return System.getProperty("user.home");
	}
	
	public static double getDoubleValue(String valueToBeConverted)
	{
		try
		{
			return Double.parseDouble(valueToBeConverted);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
	}
	
	public static void resetDefaultTimeout()
	{
		DriverManager.getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}
	
	public static void setDefaultTimeout()
	{
		DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void clickEnterKey()
	{
		try
		{
			robot = new Robot();
			CommonUtils.wait(1);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	
	// ******************  BELOW METHODS DEPRECATED PLEASE USE ELEMENTUTILS CLASS TO USE NEW METHODS ******************
	
	public static void iffDisplayedThenClick(WebElement element)
	{
		try
		{
			if(element.isDisplayed())
			{
				element.click();
			}
		}
		catch(Throwable e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void reliableClick(WebElement elementToBeClicked, WebElement elementToBeVisibleAfterClick, int retryCount) throws Exception
	{
		boolean retryFlag = true;
		boolean retryClickFlag = true;
		int retryCounter = 0;
		ElementUtils.clickIfDisplayedAndEnabled(elementToBeClicked);
		while(retryFlag)
		{
			try 
			{
				if(elementToBeVisibleAfterClick.isDisplayed())
				{
					retryFlag = false;
					retryClickFlag = false;
				}
			}
			catch(Throwable e)
			{
				e.printStackTrace();
			}
			try
			{
				if(retryClickFlag)
				{
					retryCounter++;
					if(retryCounter == retryCount)
					{
						retryFlag = false;
						retryClickFlag = false;
					}
					ElementUtils.clickIfDisplayedAndEnabled(elementToBeClicked);
				}
			}
			catch(Throwable e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void reliableClick(String visibleText, WebElement elementToBeVisibleAfterClick, int retryCount) throws Exception
	{
		boolean retryFlag = true;
		boolean retryClickFlag = true;
		int retryCounter = 0;
		WebElement elementToBeClicked = getElementByUsingID(visibleText);
		ElementUtils.clickIfDisplayedAndEnabled(elementToBeClicked);
		while(retryFlag)
		{
			try 
			{
				if(elementToBeVisibleAfterClick.isDisplayed())
				{
					retryFlag = false;
					retryClickFlag = false;
				}
			}
			catch(Throwable e)
			{
				e.printStackTrace();
			}
			try
			{
				if(retryClickFlag)
				{
					retryCounter++;
					if(retryCounter == retryCount)
					{
						retryFlag = false;
						retryClickFlag = false;
					}
					elementToBeClicked.click();
				}
			}
			catch(Throwable e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void reliableClick(WebElement elementToBeClicked,int retryCount) throws Exception
	{
		boolean retryFlag = true;
		boolean retryClickFlag = true;
		int retryCounter = 0;
		ElementUtils.clickIfDisplayedAndEnabled(elementToBeClicked);
		while(retryFlag)
		{
			try 
			{
				if(!elementToBeClicked.isDisplayed())
				{
					retryFlag = false;
					retryClickFlag = false;
				}
			}
			catch(Throwable e)
			{
				e.printStackTrace();
			}
			try
			{
				if(retryClickFlag)
				{
					retryCounter++;
					if(retryCounter == retryCount)
					{
						retryFlag = false;
						retryClickFlag = false;
					}
					elementToBeClicked.click();
				}
			}
			catch(Throwable e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static boolean isElementDisplayedWithinFluentWait(int timeoutInSeconds, int pollingTimeInSeconds, WebElement elementToBeVisible)
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				fluentWait = new FluentWait<WebDriver>(DriverManager.getDriver())
						.pollingEvery(Duration.ofSeconds(pollingTimeInSeconds))
						.withTimeout(Duration.ofSeconds(timeoutInSeconds))
						.ignoring(Exception.class, Error.class);
			}
			else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				fluentWait = new FluentWait<WebDriver>(DriverManager.getDriver())
						.pollingEvery(Duration.ofSeconds(pollingTimeInSeconds))
						.withTimeout(Duration.ofSeconds(timeoutInSeconds))
						.ignoring(Exception.class, Error.class);
			}
			fluentWaitElement = elementToBeVisible;
			
			return fluentWait.until ( new Function<WebDriver, Boolean>() 
			{
				public Boolean apply(WebDriver driver)
				{
					return fluentWaitElement.isDisplayed();
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
	
	public static boolean isElementDisplayedWithinFluentWait(int timeoutInSeconds, int pollingTimeInSeconds, String elementToBeVisible)
	{
		try
		{
			fluentWait = new FluentWait<WebDriver>(DriverManager.getDriver())
					.pollingEvery(Duration.ofSeconds(pollingTimeInSeconds))
					.withTimeout(Duration.ofSeconds(timeoutInSeconds))
					.ignoring(Exception.class, Error.class);
				fluentWaitElement = getElementByUsingVisibleText(elementToBeVisible);
			return fluentWait.until ( new Function<WebDriver, Boolean>() 
			{
				public Boolean apply(WebDriver driver)
				{
					return fluentWaitElement.isDisplayed();
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
	
	public static boolean isElementDisplayedWithinFluentWaitStrict(int timeoutInSeconds, int pollingTimeInSeconds, String elementToBeVisible)
	{
		try
		{
			fluentWait = new FluentWait<WebDriver>(DriverManager.getDriver())
					.pollingEvery(Duration.ofSeconds(pollingTimeInSeconds))
					.withTimeout(Duration.ofSeconds(timeoutInSeconds))
					.ignoring(Exception.class, Error.class);
				fluentWaitElement = getElementByUsingVisibleTextStrict(elementToBeVisible);
			return fluentWait.until ( new Function<WebDriver, Boolean>() 
			{
				public Boolean apply(WebDriver driver)
				{
					return fluentWaitElement.isDisplayed();
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
	
	public static void ifElementDisplayedWithinFluentWaitThenClick(int timeoutInSeconds, int pollingTimeInSeconds, WebElement elementToBeVisible)
	{
		try 
		{
			if(isElementDisplayedWithinFluentWait(timeoutInSeconds, pollingTimeInSeconds, elementToBeVisible))
			{
				elementToBeVisible.click();
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			
		}
	}
	
	public static boolean isElementEnabledWithinFluentWait(int timeoutInSeconds, int pollingTimeInSeconds, WebElement elementToBeEnabled)
	{
		fluentWait = new FluentWait<WebDriver>(DriverManager.getDriver())
				.pollingEvery(Duration.ofSeconds(pollingTimeInSeconds))
				.withTimeout(Duration.ofSeconds(timeoutInSeconds))
				.ignoring(Exception.class, Error.class);
		
		fluentWaitElement = elementToBeEnabled;
		
		return fluentWait.until ( new Function<WebDriver, Boolean>() 
		{
			public Boolean apply(WebDriver driver)
			{
				return fluentWaitElement.isEnabled();
			}
		}
	);
	}
	
	public static void ifElementEnabledWithinFluentWaitThenClick(int timeoutInSeconds, int pollingTimeInSeconds, WebElement elementToBeEnabled)
	{
		try 
		{
			if(isElementEnabledWithinFluentWait(timeoutInSeconds, pollingTimeInSeconds, elementToBeEnabled))
			{
				ElementUtils.clickIfDisplayedAndEnabled(elementToBeEnabled);
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			//throwNewClickException(elementToBeEnabled);
		}
	}
	
	public static void ifDisplayedThenClick(String elementAccessbilityID) throws Exception
	{
		if(DriverManager.getDriverName().equals("iOS"))
		{
			WebElement element = DriverManager.getDriver().findElement(MobileBy.AccessibilityId(elementAccessbilityID));
			ElementUtils.clickIfDisplayedAndEnabled(element);
		}
		else if(DriverManager.getDriverName().equals("Android"))
		{
			WebElement element = DriverManager.getDriver().findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\""+elementAccessbilityID+"\")"));
			ElementUtils.clickIfDisplayedAndEnabled(element);
		}
	}
	
	public static WebElement getElementByUsingVisibleText(String elementVisibleText)
	{
		if(DriverManager.getDriverName().equals("Android"))
		{
			return DriverManager.getDriver().findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\""+elementVisibleText+"\")"));
		}
		if(DriverManager.getDriverName().equals("iOS"))
		{
			return DriverManager.getDriver().findElement(MobileBy.iOSNsPredicateString("value CONTAINS '"+elementVisibleText+"'"));
		}
		return null;
	}
	
	public static WebElement getElementByUsingVisibleTextStrict(String elementVisibleText)
	{
		if(DriverManager.getDriverName().equals("Android"))
		{
			return DriverManager.getDriver().findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\""+elementVisibleText+"\")"));
		}
		if(DriverManager.getDriverName().equals("iOS"))
		{
			return DriverManager.getDriver().findElement(MobileBy.iOSNsPredicateString("value == '"+elementVisibleText+"'"));
		}
		return null;
	}
	
	public static WebElement getElementByUsingVisibleText(WebElement parentElement, String elementVisibleText)
	{
		if(DriverManager.getDriverName().equals("Android"))
		{
			return parentElement.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\""+elementVisibleText+"\")"));
		}
		if(DriverManager.getDriverName().equals("iOS"))
		{
			return parentElement.findElement(MobileBy.iOSNsPredicateString("value CONTAINS '"+elementVisibleText+"'"));
		}
		return null;
	}
	
	public static WebElement getElementByUsingVisibleTextStrict(WebElement parentElement, String elementVisibleText)
	{
		if(DriverManager.getDriverName().equals("Android"))
		{
			return parentElement.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\""+elementVisibleText+"\")"));
		}
		if(DriverManager.getDriverName().equals("iOS"))
		{
			return parentElement.findElement(MobileBy.iOSNsPredicateString("value == '"+elementVisibleText+"'"));
		}
		return null;
	}
	
	public static WebElement getElementByUsingNameStrict(String elementVisibleText)
	{
		if(DriverManager.getDriverName().equals("Android"))
		{
			return DriverManager.getDriver().findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\""+elementVisibleText+"\")"));
		}
		if(DriverManager.getDriverName().equals("iOS"))
		{
			return DriverManager.getDriver().findElement(MobileBy.iOSNsPredicateString("name == '"+elementVisibleText+"'"));
		}
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			return DriverManager.getDriver().findElement(By.xpath("//"+"div"+"[contains(text(),"+elementVisibleText+")]"));
		}
		return null;
	}
	
	public static WebElement getElementByUsingNameStrict(String androidVisibleText, String iOSVisibleText, String webVisibleText, String webTagName)
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				return DriverManager.getDriver().findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\""+androidVisibleText+"\")"));
			}
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				return DriverManager.getDriver().findElement(MobileBy.iOSNsPredicateString("name == '"+iOSVisibleText+"'"));
			}
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				return DriverManager.getDriver().findElement(By.xpath("\\"+webTagName+"[contains(text(),"+webVisibleText+")]"));
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static WebElement getElementByUsingName(WebElement parentElement, String elementVisibleText)
	{
		if(DriverManager.getDriverName().equals("Android"))
		{
			return parentElement.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\""+elementVisibleText+"\")"));
		}
		if(DriverManager.getDriverName().equals("iOS"))
		{
			return parentElement.findElement(MobileBy.iOSNsPredicateString("name CONTAINS '"+elementVisibleText+"'"));
		}
		return null;
	}
	
	public static WebElement getElementByUsingID(String elementVisibleText)
	{
		if(DriverManager.getDriverName().equals("Android"))
		{
			return DriverManager.getDriver().findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\""+elementVisibleText+"\")"));
		}
		if(DriverManager.getDriverName().equals("iOS"))
		{
			return DriverManager.getDriver().findElement(MobileBy.AccessibilityId(elementVisibleText));
		}
		return null;
	} 

	public static void ifElementIsDisplayedThenClick(String objectName)
	{
		if(DriverManager.getDriverName().equals("iOS"))
		{
			try
			{
				MobileElement element = DriverManager.getDriver().findElement(MobileBy.iOSNsPredicateString("name == '"+objectName+"'"));
				if(element.isDisplayed())
				{
					element.click();
				}
			}
			catch(Throwable e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static boolean isElementDisplayed(WebElement element)
	{
		if(DriverManager.getDriverName().equals("iOS"))
		{
			try
			{
				if(element.isDisplayed())
				{
					return true;
				}
			}
				catch(Throwable e)
				{
					e.printStackTrace();
					return false;
				}
		}
		return false;
	}
	
	
	public static void ifElementIsDisplayedThenTap(WebElement element)
	{
		try
		{
			if(element.isDisplayed())
			{
				new GestureUtils().clickOnElement(element);
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	public static void ifElementIsDisplayedThenTap(String elementAccessbilityId)
	{
		try
		{
			WebElement element = getElementByUsingVisibleText(elementAccessbilityId);
			if(element.isDisplayed())
			{
				new GestureUtils().clickOnElement(element);
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	public static void ifElementIsDisplayedThenTapStrict(String elementAccessbilityId)
	{
		try
		{
			WebElement element = getElementByUsingVisibleTextStrict(elementAccessbilityId);
			if(element.isDisplayed())
			{
				new GestureUtils().clickOnElement(element);
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	public static void ifElementIsDisplayedThenCordinateTap(WebElement element)
	{
		try
		{
			if(element.isDisplayed())
			{
				new GestureUtils().clickOnCordinates(element.getLocation().x, element.getLocation().y);
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	public static void reliableTap(WebElement elementToBeClicked, WebElement elementToBeVisibleAfterClick, int retryCount)
	{
		boolean retryFlag = true;
		boolean retryClickFlag = true;
		int retryCounter = 0;
		ifElementIsDisplayedThenTap(elementToBeClicked);
		while(retryFlag)
		{
			try 
			{
				if(elementToBeVisibleAfterClick.isDisplayed())
				{
					retryFlag = false;
					retryClickFlag = false;
				}
			}
			catch(Throwable e)
			{
				e.printStackTrace();
			}
			try
			{
				if(retryClickFlag)
				{
					retryCounter++;
					if(retryCounter == retryCount)
					{
						retryFlag = false;
						retryClickFlag = false;
					}
					ifElementIsDisplayedThenTap(elementToBeClicked);
				}
			}
			catch(Throwable e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void ifElementIsDisplayedByTextWithinFluentWaitThenClick(int timeoutInSeconds, int pollingTimeInSeconds, String iOSAttributeName, String iOSPredicateString, String androidPredicateString, String iOSAttributeValue, String androidAttributeValue)
	{
		if(isElementDisplayedByTextWithinFluentWait(timeoutInSeconds, pollingTimeInSeconds, iOSAttributeName, iOSPredicateString, androidPredicateString, iOSAttributeValue, androidAttributeValue))
		{
			getElementByUsingVisibleText(iOSAttributeName, iOSPredicateString, androidPredicateString, iOSAttributeValue, androidAttributeValue).click();
		}
	}
	
	public static boolean isElementDisplayedByTextWithinFluentWait(int timeoutInSeconds, int pollingTimeInSeconds, String iOSAttributeName, String iOSPredicateString, String androidPredicateString, String iOSAttributeValue, String androidAttributeValue)
	{
		try
		{
			fluentWait = new FluentWait<WebDriver>(DriverManager.getDriver())
					.pollingEvery(Duration.ofSeconds(pollingTimeInSeconds))
					.withTimeout(Duration.ofSeconds(timeoutInSeconds))
					.ignoring(Exception.class, Error.class);
			
			fluentWaitElement = getElementByUsingVisibleText(iOSAttributeName, iOSPredicateString, androidPredicateString, iOSAttributeValue, androidAttributeValue);
			
			return fluentWait.until (new Function<WebDriver, Boolean>() 
			{
				public Boolean apply(WebDriver driver)
				{
					return fluentWaitElement.isDisplayed();
				}
			}
		);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public static void ifElementIsEnabledByTextWithinFluentWaitThenClick(int timeoutInSeconds, int pollingTimeInSeconds, String iOSAttributeName, String iOSPredicateString, String androidPredicateString, String iOSAttributeValue, String androidAttributeValue)
	{
		if(isElementEnabledByTextWithinFluentWait(timeoutInSeconds, pollingTimeInSeconds, iOSAttributeName, iOSPredicateString, androidPredicateString, iOSAttributeValue, androidAttributeValue))
		{
			getElementByUsingVisibleText(iOSAttributeName, iOSPredicateString, androidPredicateString, iOSAttributeValue, androidAttributeValue).click();
		}
	}
	
	public static boolean isElementEnabledByTextWithinFluentWait(int timeoutInSeconds, int pollingTimeInSeconds, String iOSAttributeName, String iOSPredicateString, String androidPredicateString, String iOSAttributeValue, String androidAttributeValue)
	{
		try
		{
			fluentWait = new FluentWait<WebDriver>(DriverManager.getDriver())
					.pollingEvery(Duration.ofSeconds(pollingTimeInSeconds))
					.withTimeout(Duration.ofSeconds(timeoutInSeconds))
					.ignoring(Exception.class, Error.class);
			
			fluentWaitElement = getElementByUsingVisibleText(iOSAttributeName, iOSPredicateString, androidPredicateString, iOSAttributeValue, androidAttributeValue);
			
			return fluentWait.until (new Function<WebDriver, Boolean>() 
			{
				public Boolean apply(WebDriver driver)
				{
					return fluentWaitElement.isEnabled();
				}
			}
		);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public static WebElement getElementByUsingVisibleText(String iOSattributeName, String iOSPredicateString, String androidPredicateString, String iOSAttributeValue, String androidAttributeValue)
	{
		try
		{
			if(DriverManager.getDriverName().equals("Android"))
			{
				return DriverManager.getDriver().findElement(MobileBy.AndroidUIAutomator("new UiSelector()."+androidPredicateString+"(\""+androidAttributeValue+"\")"));
			}
			if(DriverManager.getDriverName().equals("iOS"))
			{
				return DriverManager.getDriver().findElement(MobileBy.iOSNsPredicateString(""+iOSattributeName+" "+iOSPredicateString+" '"+iOSAttributeValue+"'"));
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static void ifElementIsDisplayedByIdWithinFluentWaitThenClick(int timeoutInSeconds, int pollingTimeInSeconds, String iOSId,  String androidId)
	{
		try
		{
			if(isElementDisplayedByIdWithinFluentWait(timeoutInSeconds, pollingTimeInSeconds, iOSId, androidId))
			{
				getElementById(iOSId, androidId).click();
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	public static boolean isElementDisplayedByIdWithinFluentWait(int timeoutInSeconds, int pollingTimeInSeconds, String iOSId, String androidId)
	{
		fluentWait = new FluentWait<WebDriver>(DriverManager.getDriver())
				.pollingEvery(Duration.ofSeconds(pollingTimeInSeconds))
				.withTimeout(Duration.ofSeconds(timeoutInSeconds))
				.ignoring(Exception.class, Error.class);
		
		fluentWaitElement = getElementById(iOSId, androidId);
		
		return fluentWait.until ( new Function<WebDriver, Boolean>() 
		{
			public Boolean apply(WebDriver driver)
			{
				return fluentWaitElement.isDisplayed();
			}
		}
	);
	}
	
	public static WebElement getElementById(String iOSId, String androidId)
	{
		try
		{
			if(DriverManager.getDriverName().equals("Android"))
			{
				return DriverManager.getDriver().findElement(MobileBy.id(androidId));
			}
			if(DriverManager.getDriverName().equals("iOS"))
			{
				return DriverManager.getDriver().findElement(MobileBy.AccessibilityId(iOSId));
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static String[] split(String mainString, String... sepeartor)
	{
		String getString= Arrays.toString(sepeartor);
		return mainString.split(getString);
	}
}
	

