package com.eCRM.client.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.eCRM.client.utils.Config.LocatorStrategy;
import com.google.common.base.Function;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class ElementUtils 
{
	private static Wait<WebDriver> fluentWait;
	private static WebElement fluentWaitElement;
	final private static int TIMEOUT_IN_SECONDS = 15;
	final private static int POLLING_TIME_IN_SECONDS = 1;
	private static JavascriptExecutor js=(JavascriptExecutor)DriverManager.getDriver();
	private static WebElement element;
	
	// ***************************************  GET ELEMENT METHODS *************************************************
	
	
	public static WebElement getElement(String mobileAttributeValue, LocatorStrategy webLocatorStrategy, String webAttributeValue)
	{
		return getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, mobileAttributeValue, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, mobileAttributeValue, webLocatorStrategy, webAttributeValue);
	}
	
	public static WebElement getElement(String visibleText, LocatorStrategy androidLocatorStrategy, LocatorStrategy iOSLocatorStrategy, LocatorStrategy webLocatorStrategy)
	{
		return getElement(androidLocatorStrategy, visibleText, iOSLocatorStrategy, visibleText, webLocatorStrategy, visibleText);
	}
	
	public static WebElement getElement(String mobileAttributeValue, LocatorStrategy androidLocatorStrategy, LocatorStrategy iOSLocatorStrategy, String webAttributeValue, LocatorStrategy webLocatorStrategy)
	{
		return getElement(androidLocatorStrategy, mobileAttributeValue, iOSLocatorStrategy, mobileAttributeValue, webLocatorStrategy, webAttributeValue);
	}
	
	public static WebElement getElement(WebElement parentElement, String mobileAttributeValue, LocatorStrategy webLocatorStrategy, String webAttributeValue)
	{
		return getElement(parentElement, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, mobileAttributeValue, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, mobileAttributeValue, webLocatorStrategy, webAttributeValue);
	}
	
	public static WebElement getElement(WebElement parentElement, String visibleText, LocatorStrategy androidLocatorStrategy, LocatorStrategy iOSLocatorStrategy, LocatorStrategy webLocatorStrategy)
	{
		return getElement(parentElement, androidLocatorStrategy, visibleText, iOSLocatorStrategy, visibleText, webLocatorStrategy, visibleText);
	}
	
	public static WebElement getElement(WebElement parentElement, String mobileAttributeValue, LocatorStrategy androidLocatorStrategy, LocatorStrategy iOSLocatorStrategy, String webAttributeValue, LocatorStrategy webLocatorStrategy)
	{
		return getElement(parentElement, androidLocatorStrategy, mobileAttributeValue, iOSLocatorStrategy, mobileAttributeValue, webLocatorStrategy, webAttributeValue);
	}
	
	public static WebElement getElementReliably(int retryCount, LocatorStrategy androidLocatorStrategy, String androidAttributeValue, LocatorStrategy iOSLocatorStrategy, String iOSAttributeValue, LocatorStrategy webLocatorStrategy, String webAttributeValue)
	{
		WebElement returnElement = null;
		for(int i = 0; i < retryCount; i++)
		{
			returnElement = getElement(androidLocatorStrategy, androidAttributeValue, iOSLocatorStrategy, iOSAttributeValue, webLocatorStrategy, webAttributeValue);
			if(returnElement == null)
				CommonUtils.wait(2);
			else
				return returnElement;
		}
		return returnElement;
	}
	
	public static WebElement getElementReliably(int retryCount, WebElement parentElement, LocatorStrategy androidLocatorStrategy, String androidAttributeValue, LocatorStrategy iOSLocatorStrategy, String iOSAttributeValue, LocatorStrategy webLocatorStrategy, String webAttributeValue)
	{
		WebElement returnElement = null;
		for(int i = 0; i < retryCount; i++)
		{
			returnElement = getElement(parentElement, androidLocatorStrategy, androidAttributeValue, iOSLocatorStrategy, iOSAttributeValue, webLocatorStrategy, webAttributeValue);
			if(returnElement == null)
				CommonUtils.wait(2);
			else
				return returnElement;
		}
		return returnElement;
	}
	
	
	public static WebElement getElement(LocatorStrategy androidLocatorStrategy, String androidAttributeValue, LocatorStrategy iOSLocatorStrategy, String iOSAttributeValue, LocatorStrategy webLocatorStrategy, String webAttributeValue)
	{
		WebElement returnElement = null;
		
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				switch(androidLocatorStrategy)
				{
					case ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS:
						returnElement = DriverManager.getDriver().findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\""+androidAttributeValue+"\")"));
						break;
					case ANDROID_LOCATOR_STRATEGY_TEXT_STARTS_WITH:
						returnElement = DriverManager.getDriver().findElement(MobileBy.AndroidUIAutomator("new UiSelector().textStartsWith(\""+androidAttributeValue+"\")"));
						break;
					case ANDROID_LOCATOR_STRATEGY_TEXT:
						returnElement = DriverManager.getDriver().findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\""+androidAttributeValue+"\")"));
						break;
					case ANDROID_LOCATOR_STRATEGY_ID:
						returnElement = DriverManager.getDriver().findElement(MobileBy.id(androidAttributeValue));
						break;
					case ANDROID_LOCATOR_STRATEGY_XPATH:
						returnElement = DriverManager.getDriver().findElement(MobileBy.xpath(androidAttributeValue));
						break;
					case ANDROID_LOCATOR_STRATEGY_XPATH_WITH_TEXT_VIEW:
						returnElement=DriverManager.getDriver().findElement(By.xpath("//android.widget.TextView[contains(@text,'"+androidAttributeValue+"')]"));
						break;
					default:
				}
			 	return returnElement;
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				switch(iOSLocatorStrategy)
				{
					case IOS_LOCATOR_STRATEGY_ID:
						returnElement = DriverManager.getDriver().findElement(MobileBy.AccessibilityId(iOSAttributeValue));
						break;
					case IOS_LOCATOR_STRATEGY_VALUE:
						returnElement = DriverManager.getDriver().findElement(MobileBy.iOSNsPredicateString("value == '"+iOSAttributeValue+"'"));
						break;
					case IOS_LOCATOR_STRATEGY_LABEL:
						returnElement = DriverManager.getDriver().findElement(MobileBy.iOSNsPredicateString("label == '"+iOSAttributeValue+"'"));
						break;
					case IOS_LOCATOR_STRATEGY_NAME:
						returnElement = DriverManager.getDriver().findElement(MobileBy.iOSNsPredicateString("name == '"+iOSAttributeValue+"'"));
						break;
					case IOS_LOCATOR_STRATEGY_NAME_CONTAINS:
						returnElement = DriverManager.getDriver().findElement(MobileBy.iOSNsPredicateString("name CONTAINS '"+iOSAttributeValue+"'"));
						break;
					case IOS_LOCATOR_STRATEGY_NAME_BEGINSWITH:
						returnElement = DriverManager.getDriver().findElement(MobileBy.iOSNsPredicateString("name BEGINSWITH '"+iOSAttributeValue+"'"));
						break;
					case IOS_LOCATOR_STRATEGY_NAME_ENDSWITH:
						returnElement = DriverManager.getDriver().findElement(MobileBy.iOSNsPredicateString("name ENDSWITH '"+iOSAttributeValue+"'"));
						break;
					case IOS_LOCATOR_STRATEGY_PREDICATE_STRING:
						returnElement = DriverManager.getDriver().findElement(MobileBy.iOSNsPredicateString(iOSAttributeValue));
						break;
					case IOS_LOCATOR_STRATEGY_VALUE_CONTAINS:
						returnElement = DriverManager.getDriver().findElement(MobileBy.iOSNsPredicateString("value CONTAINS '"+iOSAttributeValue+"'"));
						break;
					case IOS_LOCATOR_STRATEGY_VALUE_ENDS_WITH:
						returnElement = DriverManager.getDriver().findElement(MobileBy.iOSNsPredicateString("value ENDSWITH '"+iOSAttributeValue+"'"));
						break;
					case IOS_LOCATOR_STRATEGY_XPATH_NAME_ANCESTOR_CELL:
						returnElement = DriverManager.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@"+iOSLocatorStrategy+" = '"+iOSAttributeValue+"']/ancestor::XCUIElementTypeCell"));
						break;
					case IOS_LOCATOR_STRATEGY_XPATH_STARTS_WITH_ANCESTOR_CELL:
						returnElement = DriverManager.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[starts-with(@value"+", '"+iOSAttributeValue+"')]/ancestor::XCUIElementTypeCell"));
						break;
					case IOS_LOCATOR_STRATEGY_XPATH_NAME_CELL:
						returnElement=DriverManager.getDriver().findElement(By.xpath("//XCUIElementTypeCell[contains(@"+iOSLocatorStrategy+",'"+iOSAttributeValue+"')]"));
						break;
					case IOS_LOCATOR_STRATEGY_XPATH:
						returnElement=DriverManager.getDriver().findElement(By.xpath(iOSAttributeValue));
						break;
					case IOS_LOCATOR_STRATEGY_CLASS_NAME:
						returnElement=DriverManager.getDriver().findElement(By.className(iOSAttributeValue));
						break;
					default:
						break;
				}
				return returnElement;
			}
			else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				switch(webLocatorStrategy)
				{
				    case WEB_LOCATOR_STRATEGY_ID:
				    		returnElement = DriverManager.getDriver().findElement(By.id(webAttributeValue));
				    		break;
					 case WEB_LOCATOR_STRATEGY_XPATH:
							returnElement = DriverManager.getDriver().findElement(By.xpath(webAttributeValue));
							break;
					 case WEB_LOCATOR_STRATEGY_XPATH_TEXT:
							returnElement = DriverManager.getDriver().findElement(By.xpath("//*[. = '"+webAttributeValue+"']"));
							break;
					 case WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS:
							returnElement = DriverManager.getDriver().findElement(By.xpath("//*[contains(text(), '"+webAttributeValue+"')]"));
							break;
					 case WEB_LOCATOR_STRATEGY_XPATH_SPAN_TEXT_CONTAINS:
							returnElement = DriverManager.getDriver().findElement(By.xpath("//span[contains(text(), '"+webAttributeValue+"')]"));
							break;
					case WEB_LOCATOR_STRATEGY_CSS:
						returnElement = DriverManager.getDriver().findElement(By.cssSelector(webAttributeValue));				
						break;
					case WEB_LOCATOR_STRATEGY_XPATH_TEXT_CONTAINS:
						returnElement = DriverManager.getDriver().findElement(By.xpath("//*[contains(text(), '"+webAttributeValue+"')]"));
						break;
					default:
				}
				return returnElement;
			}
		}
		catch(Throwable e)
		{		
			return null;
		}
		return returnElement;
	}

	public static WebElement getElement(WebElement parentElement, LocatorStrategy androidLocatorStrategy, String androidAttributeValue, LocatorStrategy iOSLocatorStrategy, String iOSAttributeValue, LocatorStrategy webLocatorStrategy, String webAttributeValue)
	{
		try
		{
			WebElement returnElement = null;
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				switch(androidLocatorStrategy)
				{
					case ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS:
						returnElement = parentElement.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\""+androidAttributeValue+"\")"));
						break;
					case ANDROID_LOCATOR_STRATEGY_TEXT:
						returnElement = parentElement.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\""+androidAttributeValue+"\")"));
						break;
					case ANDROID_LOCATOR_STRATEGY_ID:
						returnElement = parentElement.findElement(By.id(androidAttributeValue));
						break;	
					default:
				}
				return returnElement;
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				switch(iOSLocatorStrategy)
				{
					case IOS_LOCATOR_STRATEGY_ID:
						returnElement = parentElement.findElement(MobileBy.AccessibilityId(iOSAttributeValue));
						break;
					case IOS_LOCATOR_STRATEGY_VALUE:
						returnElement = parentElement.findElement(MobileBy.iOSNsPredicateString("value == '"+iOSAttributeValue+"'"));
						break;
					case IOS_LOCATOR_STRATEGY_VALUE_CONTAINS:
						returnElement = parentElement.findElement(MobileBy.iOSNsPredicateString("value CONTAINS '"+iOSAttributeValue+"'"));
						break;
					case IOS_LOCATOR_STRATEGY_NAME:
						returnElement = parentElement.findElement(MobileBy.iOSNsPredicateString("name == '"+iOSAttributeValue+"'"));
						break;
					case IOS_LOCATOR_STRATEGY_NAME_CONTAINS:
						returnElement = parentElement.findElement(MobileBy.iOSNsPredicateString("name CONTAINS '"+iOSAttributeValue+"'"));
						break;
					default:	
				}
				return returnElement;
			}
			else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				switch(webLocatorStrategy)
				{
				    case WEB_LOCATOR_STRATEGY_ID:
				    		returnElement = parentElement.findElement(By.id(webAttributeValue));
				    		break;
				    case WEB_LOCATOR_STRATEGY_XPATH:
						returnElement = parentElement.findElement(By.xpath(webAttributeValue));
						break;
				    case WEB_LOCATOR_STRATEGY_XPATH_TEXT:
						returnElement = parentElement.findElement(By.xpath("//*[. = '"+webAttributeValue+"']"));
						break;
					case WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS:
						returnElement = parentElement.findElement(By.xpath("//div[contains(text(), '"+webAttributeValue+"')]"));
						break;
					case WEB_LOCATOR_STRATEGY_XPATH_SPAN_TEXT_CONTAINS:
						returnElement = parentElement.findElement(By.xpath("//span[contains(text(), '"+webAttributeValue+"')]"));
						break;
					case WEB_LOCATOR_STRATEGY_CSS:
						returnElement = parentElement.findElement(By.cssSelector(webAttributeValue));
						break;
					case WEB_LOCATOR_STRATEGY_CSS_INPUT_DATA_FEATURE:
						returnElement = parentElement.findElement(By.cssSelector("input[data-feature = '"+webAttributeValue+"']"));
						break;
					case WEB_LOCATOR_STRATEGY_XPATH_TEXT_CONTAINS:
						returnElement = parentElement.findElement(By.xpath("//*[contains(text(), '"+webAttributeValue+"')]"));
						break;
					default:
				}
				return returnElement;
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<WebElement> getElements(LocatorStrategy androidLocatorStrategy, String androidAttributeValue, LocatorStrategy iOSLocatorStrategy, String iOSAttributeValue, LocatorStrategy webLocatorStrategy, String webAttributeValue)
	{
		try
		{
			List<WebElement> returnElement = null;
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				switch(androidLocatorStrategy)
				{
					case ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS:
						returnElement = DriverManager.getDriver().findElements(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\""+androidAttributeValue+"\")"));
						break;
					case ANDROID_LOCATOR_STRATEGY_TEXT:
						returnElement = DriverManager.getDriver().findElements(MobileBy.AndroidUIAutomator("new UiSelector().text(\""+androidAttributeValue+"\")"));
						break;
					case ANDROID_LOCATOR_STRATEGY_ID:
						returnElement = DriverManager.getDriver().findElements(MobileBy.id(androidAttributeValue));
						break;
					case ANDROID_LOCATOR_STRATEGY_XPATH:
						returnElement = DriverManager.getDriver().findElements(MobileBy.xpath(androidAttributeValue));
						break;
					case ANDROID_LOCATOR_STRATEGY_XPATH_WITH_TEXT_VIEW:
						returnElement=DriverManager.getDriver().findElements(By.xpath("//android.widget.TextView[contains(@text,'"+androidAttributeValue+"')]"));
						break;
					default:
				}
			 	return returnElement;
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				switch(iOSLocatorStrategy)
				{
					case IOS_LOCATOR_STRATEGY_ID:
						returnElement = DriverManager.getDriver().findElements(MobileBy.AccessibilityId(iOSAttributeValue));
						break;
					case IOS_LOCATOR_STRATEGY_VALUE:
						returnElement = DriverManager.getDriver().findElements(MobileBy.iOSNsPredicateString("value == '"+iOSAttributeValue+"'"));
						break;
					case IOS_LOCATOR_STRATEGY_NAME:
						returnElement = DriverManager.getDriver().findElements(MobileBy.iOSNsPredicateString("name == '"+iOSAttributeValue+"'"));
						break;
					case IOS_LOCATOR_STRATEGY_NAME_CONTAINS:
						returnElement = DriverManager.getDriver().findElements(MobileBy.iOSNsPredicateString("name CONTAINS '"+iOSAttributeValue+"'"));
						break;
					case IOS_LOCATOR_STRATEGY_PREDICATE_STRING:
						returnElement = DriverManager.getDriver().findElements(MobileBy.iOSNsPredicateString(iOSAttributeValue));
						break;
					case IOS_LOCATOR_STRATEGY_VALUE_CONTAINS:
						returnElement = DriverManager.getDriver().findElements(MobileBy.iOSNsPredicateString("value CONTAINS '"+iOSAttributeValue+"'"));
						break;
					case IOS_LOCATOR_STRATEGY_XPATH_NAME_ANCESTOR_CELL:
						returnElement = DriverManager.getDriver().findElements(By.xpath("//XCUIElementTypeStaticText[@"+iOSLocatorStrategy+" = '"+iOSAttributeValue+"']/ancestor::XCUIElementTypeCell"));
						break;
					case IOS_LOCATOR_STRATEGY_XPATH_STARTS_WITH_ANCESTOR_CELL:
						returnElement = DriverManager.getDriver().findElements(By.xpath("//XCUIElementTypeStaticText[starts-with(@value"+", '"+iOSAttributeValue+"')]/ancestor::XCUIElementTypeCell"));
						break;
					case IOS_LOCATOR_STRATEGY_XPATH_NAME_CELL:
						returnElement=DriverManager.getDriver().findElements(By.xpath("//XCUIElementTypeCell[contains(@"+iOSLocatorStrategy+",'"+iOSAttributeValue+"')]"));
						break;
					default:
						break;
				}
				return returnElement;
			}
			else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				switch(webLocatorStrategy)
				{
				    case WEB_LOCATOR_STRATEGY_ID:
				    		returnElement = DriverManager.getDriver().findElements(By.id(webAttributeValue));
				    		break;
					 case WEB_LOCATOR_STRATEGY_XPATH:
							returnElement = DriverManager.getDriver().findElements(By.xpath(webAttributeValue));
							break;
					 case WEB_LOCATOR_STRATEGY_XPATH_TEXT:
							returnElement = DriverManager.getDriver().findElements(By.xpath("//*[. = '"+webAttributeValue+"']"));
							break;
					 case WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS:
							returnElement = DriverManager.getDriver().findElements(By.xpath("//div[contains(text(), '"+webAttributeValue+"')]"));
							break;
					 case WEB_LOCATOR_STRATEGY_XPATH_SPAN_TEXT_CONTAINS:
							returnElement = DriverManager.getDriver().findElements(By.xpath("//span[contains(text(), '"+webAttributeValue+"')]"));
							break;
					case WEB_LOCATOR_STRATEGY_CSS:
						returnElement = DriverManager.getDriver().findElements(By.cssSelector(webAttributeValue));
						break;
					case WEB_LOCATOR_STRATEGY_XPATH_TEXT_CONTAINS:
						returnElement = DriverManager.getDriver().findElements(By.xpath("//*[contains(text(), '"+webAttributeValue+"')]"));
					default:
				}
				return returnElement;
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<WebElement> getElements(WebElement parentElement, LocatorStrategy androidLocatorStrategy, String androidAttributeValue, LocatorStrategy iOSLocatorStrategy, String iOSAttributeValue, LocatorStrategy webLocatorStrategy, String webAttributeValue)
	{
		try
		{
			List<WebElement> returnElement = null;
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				switch(androidLocatorStrategy)
				{
					case ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS:
						returnElement = parentElement.findElements(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\""+androidAttributeValue+"\")"));
						break;
					case ANDROID_LOCATOR_STRATEGY_TEXT:
						returnElement = parentElement.findElements(MobileBy.AndroidUIAutomator("new UiSelector().text(\""+androidAttributeValue+"\")"));
						break;
					case ANDROID_LOCATOR_STRATEGY_ID:
						returnElement = parentElement.findElements(By.id(androidAttributeValue));
						break;	
					default:
				}
				return returnElement;
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				switch(iOSLocatorStrategy)
				{
					case IOS_LOCATOR_STRATEGY_ID:
						returnElement = parentElement.findElements(MobileBy.AccessibilityId(iOSAttributeValue));
						break;
					case IOS_LOCATOR_STRATEGY_VALUE:
						returnElement = parentElement.findElements(MobileBy.iOSNsPredicateString("value == '"+iOSAttributeValue+"'"));
						break;
					case IOS_LOCATOR_STRATEGY_VALUE_CONTAINS:
						returnElement = parentElement.findElements(MobileBy.iOSNsPredicateString("value CONTAINS '"+iOSAttributeValue+"'"));
						break;
					case IOS_LOCATOR_STRATEGY_NAME:
						returnElement = parentElement.findElements(MobileBy.iOSNsPredicateString("name == '"+iOSAttributeValue+"'"));
						break;
					case IOS_LOCATOR_STRATEGY_NAME_CONTAINS:
						returnElement = parentElement.findElements(MobileBy.iOSNsPredicateString("name CONTAINS '"+iOSAttributeValue+"'"));
						break;
					default:	
				}
				return returnElement;
			}
			else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
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
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	// ***************************************  END OF GET ELEMENT METHODS *************************************************
	
	
	// ***************************************  IS DISPLAYED / ENABLED METHODS *************************************************
	
	
	public static boolean isDisplayed(LocatorStrategy androidLocatorStrategy, String androidAttributeValue, LocatorStrategy iOSLocatorStrategy, String iOSAttributeValue, LocatorStrategy webLocatorStrategy, String webAttributeValue)
	{
		return isDisplayed(TIMEOUT_IN_SECONDS, POLLING_TIME_IN_SECONDS, androidLocatorStrategy, androidAttributeValue, iOSLocatorStrategy, iOSAttributeValue, webLocatorStrategy, webAttributeValue);
	}
	
	public static boolean isDisplayed(String mobileAttributeValue, LocatorStrategy webLocatorStrategy, String webAttributeValue)
	{
		return isDisplayed(TIMEOUT_IN_SECONDS, POLLING_TIME_IN_SECONDS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, mobileAttributeValue, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, mobileAttributeValue, webLocatorStrategy, webAttributeValue);
	}
	
	public static boolean isDisplayed(int timeoutInSeconds, int pollingTimeInSeconds, String mobileAttributeValue, LocatorStrategy webLocatorStrategy, String webAttributeValue)
	{
		if((DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER)) && mobileAttributeValue == null)
		{
			return false;
		}
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER) && webAttributeValue == null)
		{
			return false;
		}
		else
		{
			return isDisplayed(timeoutInSeconds, pollingTimeInSeconds, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, mobileAttributeValue, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, mobileAttributeValue, webLocatorStrategy, webAttributeValue);
		}
	}
	
	public static boolean isDisplayed(int timeoutInSeconds, int pollingTimeInSeconds, String mobileAttributeValue, LocatorStrategy androidLocatorStrategy, LocatorStrategy iOSLocatorStrategy, LocatorStrategy webLocatorStrategy, String webAttributeValue)
	{
		if((DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER)) && mobileAttributeValue == null)
		{
			return false;
		}
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER) && webAttributeValue == null)
		{
			return false;
		}
		else
		{
			return isDisplayed(timeoutInSeconds, pollingTimeInSeconds, androidLocatorStrategy, mobileAttributeValue, iOSLocatorStrategy, mobileAttributeValue, webLocatorStrategy, webAttributeValue);
		}
	}
	

	public static boolean isNotDisplayed(int timeoutInSeconds, int pollingTimeInSeconds, LocatorStrategy androidLocatorStrategy, String androidAttributeValue, LocatorStrategy iOSLocatorStrategy, String iOSAttributeValue, LocatorStrategy webLocatorStrategy, String webAttributeValue)
	{
		try
		{
			if(getElement(androidLocatorStrategy, androidAttributeValue, iOSLocatorStrategy, iOSAttributeValue, webLocatorStrategy, webAttributeValue).isDisplayed())
			{
				return false;	
			}
				
		}
		catch(NullPointerException e)
		{
			return true;
		}
			
		return false;
		
	}
	
	public static boolean isNotDisplayed(WebElement element)
	{
		try
		{
			if(element.isDisplayed())
				return false;
			else
				return true;
		}
		catch(Exception e)
		{
			return true;
		}
	}
	
	public static boolean isNotDisplayed(WebElement element, int retryCount)
	{
		for(int i = 0; i < retryCount; i++)
		{
			try {
				if(element.isDisplayed())
					CommonUtils.wait(1);
				else
					return true;
			}
			catch(Exception e) {
				return true;
			}
		}
		return false;
	}
	

	public static boolean isDisplayed(int timeoutInSeconds, int pollingTimeInSeconds, LocatorStrategy androidLocatorStrategy, String androidAttributeValue, LocatorStrategy iOSLocatorStrategy, String iOSAttributeValue, LocatorStrategy webLocatorStrategy, String webAttributeValue) 
	{
		try
		{
			if(timeoutInSeconds == 0)
				 timeoutInSeconds = TIMEOUT_IN_SECONDS;
			if(pollingTimeInSeconds == 0)
				pollingTimeInSeconds = POLLING_TIME_IN_SECONDS;
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				fluentWait = new FluentWait<WebDriver>(DriverManager.getDriver())
						.pollingEvery(Duration.ofSeconds(pollingTimeInSeconds))
						.withTimeout(Duration.ofSeconds(timeoutInSeconds))
						 .ignoring(NoSuchElementException.class, Error.class);
			}
			else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				fluentWait = new FluentWait<WebDriver>(DriverManager.getDriver())
						.pollingEvery(Duration.ofSeconds(pollingTimeInSeconds))
						.withTimeout(Duration.ofSeconds(timeoutInSeconds))
							.ignoring(NoSuchElementException.class, Error.class);
			}
			fluentWaitElement = getElement(androidLocatorStrategy, androidAttributeValue, iOSLocatorStrategy, iOSAttributeValue, webLocatorStrategy, webAttributeValue);
			return fluentWait.until (new Function<WebDriver, Boolean>()  
			{
				public Boolean apply(WebDriver driver)
				{
					return fluentWaitElement.isDisplayed();
				}
			}
		);
		}
		catch(TimeoutException e)
		{
			return false;
		}
	}
	
	public static boolean isDisplayed(int timeoutInSeconds, int pollingTimeInSeconds, WebElement element)
	{
		try
		{
			if(timeoutInSeconds == 0)
				timeoutInSeconds = TIMEOUT_IN_SECONDS;
			if(pollingTimeInSeconds == 0)
				pollingTimeInSeconds = POLLING_TIME_IN_SECONDS;
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				fluentWait = new FluentWait<WebDriver>(DriverManager.getDriver())
						.pollingEvery(Duration.ofSeconds(pollingTimeInSeconds))
						.withTimeout(Duration.ofSeconds(timeoutInSeconds))
						     .ignoring(NoSuchElementException.class, Error.class);
			}
			else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				fluentWait = new FluentWait<WebDriver>(DriverManager.getDriver())
						.pollingEvery(Duration.ofSeconds(pollingTimeInSeconds))
						.withTimeout(Duration.ofSeconds(timeoutInSeconds))
							.ignoring(NoSuchElementException.class, Error.class);
			}
			fluentWaitElement = element;
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
	
	public static boolean isNotDisplayed(int timeoutInSeconds, int pollingTimeInSeconds, WebElement element)
	{
		try
		{
			if(timeoutInSeconds == 0)
				timeoutInSeconds = TIMEOUT_IN_SECONDS;
			if(pollingTimeInSeconds == 0)
				pollingTimeInSeconds = POLLING_TIME_IN_SECONDS;
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				fluentWait = new FluentWait<WebDriver>(DriverManager.getDriver())
						.pollingEvery(Duration.ofSeconds(pollingTimeInSeconds))
						.withTimeout(Duration.ofSeconds(timeoutInSeconds))
						     .ignoring(NoSuchElementException.class, Error.class);
			}
			else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				fluentWait = new FluentWait<WebDriver>(DriverManager.getDriver())
						.pollingEvery(Duration.ofSeconds(pollingTimeInSeconds))
						.withTimeout(Duration.ofSeconds(timeoutInSeconds))
							.ignoring(NoSuchElementException.class, Error.class);
			}
			fluentWaitElement = element;
			return fluentWait.until(new Function<WebDriver, Boolean>() 
			{
				public Boolean apply(WebDriver driver) 
				{
					if(fluentWaitElement.isDisplayed())
					{
						return false;
					}
					else
					{
						return true;
					}
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

	public static boolean isDisplayedAndEnabled(int timeoutInSeconds, int pollingTimeInSeconds, WebElement element)
	{
		try
		{
			if(timeoutInSeconds == 0)
				timeoutInSeconds = TIMEOUT_IN_SECONDS;
			if(pollingTimeInSeconds == 0)
				pollingTimeInSeconds = POLLING_TIME_IN_SECONDS;
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				fluentWait = new FluentWait<WebDriver>(DriverManager.getDriver())
						.pollingEvery(Duration.ofSeconds(pollingTimeInSeconds))
						.withTimeout(Duration.ofSeconds(timeoutInSeconds))
						     .ignoring(NoSuchElementException.class, Error.class);
			}
			else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				fluentWait = new FluentWait<WebDriver>(DriverManager.getDriver())
						.pollingEvery(Duration.ofSeconds(pollingTimeInSeconds))
						.withTimeout(Duration.ofSeconds(timeoutInSeconds))
							.ignoring(NoSuchElementException.class, Error.class);
			}
			fluentWaitElement = element;
			return fluentWait.until (new Function<WebDriver, Boolean>() 
			{
				public Boolean apply(WebDriver driver)
				{
					return (fluentWaitElement.isDisplayed() && fluentWaitElement.isEnabled());
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
	
	// ***************************************  END OF IS DISPLAYED / ENABLED METHODS *************************************************
	
	
	// *************************************** CLICK METHODS ********************************************************
	
	public static void clickIfDisplayedAndEnabled(int timeoutInSeconds, int pollingTimeInSeconds, WebElement element) throws Exception 
	{
		try
		{
			if(isDisplayedAndEnabled(timeoutInSeconds, pollingTimeInSeconds, element))
			{
				element.click();
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void clickIfDisplayedAndEnabled(WebElement element) throws Exception
	{
		try
		{
			if(isDisplayedAndEnabled(TIMEOUT_IN_SECONDS, POLLING_TIME_IN_SECONDS, element))
			{
				element.click();
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	public static void clickIfDisplayedAndEnabled(String mobileAttributeValue, LocatorStrategy webLocatorStrategy, String webLocatorValue) throws Exception
	{
		try
		{
			WebElement desiredElement = getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, mobileAttributeValue, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, mobileAttributeValue, webLocatorStrategy, webLocatorValue);
			if(isDisplayedAndEnabled(15, 1, desiredElement))
			{
				desiredElement.click();
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	public static void safeClick(String mobileAttributeValue, LocatorStrategy webLocatorStrategy, String webLocatorValue) 
	{
		try
		{
			WebElement desiredElement = getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, mobileAttributeValue, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, mobileAttributeValue, webLocatorStrategy, webLocatorValue);
			desiredElement.click();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	public static void clickIfDisplayed(int timeoutInSeconds, int pollingTimeInSeconds, String mobileAttributeValue, LocatorStrategy androidLocatorStrategy, LocatorStrategy iOSLocatorStrategy, LocatorStrategy webLocatorStrategy, String webLocatorValue) 
	{
		try
		{
			WebElement desiredElement = getElement(androidLocatorStrategy, mobileAttributeValue, iOSLocatorStrategy, mobileAttributeValue, webLocatorStrategy, webLocatorValue);
			if(isDisplayed(timeoutInSeconds, pollingTimeInSeconds, desiredElement))
			desiredElement.click();
			else
				desiredElement.click();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	public static void safeClick(int timeoutInSeconds, int pollingTimeInSeconds, WebElement element)
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
	
	public static boolean safeClick(WebElement element) 
	{
		try
		{
			element.click();
			return true;
		}
		catch(Throwable e)
		{
			return false;
		}
	}

	public static void reliableClick(int timeoutInSeconds, int pollingTimeInSeconds, WebElement elementToBeClicked, WebElement elementToBeVisibleAfterClick, int retryCount) throws Exception
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
	
	public  static void clickObject(WebElement element)
	{
		try 
		{
			js.executeScript("arguments[0].click();", element);
		}
		catch (NoSuchElementException e)
        {
			e.printStackTrace();	
        }
	}
	
	// ***************************************  END OF CLICK METHODS *************************************************
	
	
	// ***************************************  SEND KEYS METHODS *************************************************
	
	
	public static void sendKeys(WebElement element, String textToBeTyped)
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				{
					((MobileElement) element).setValue(textToBeTyped);
				}
				else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				{
					element.sendKeys(textToBeTyped);
				}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}

	public static void sendKeys(int timeoutInSeconds, int pollingTimeInSeconds, WebElement element, String textToBeTyped)
	{
		try
		{
			if(isDisplayed(timeoutInSeconds, pollingTimeInSeconds, element))
			{
				if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				{
					((MobileElement) element).setValue(textToBeTyped);
				}
				else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				{
					element.sendKeys(textToBeTyped);
				}
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}

	public static void reliableSendKeys(int timeoutInSeconds, int pollingTimeInSeconds, WebElement element, String textToBeTyped, int retryCount)
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
					if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
					{
						element.clear();
						((MobileElement) element).setValue(textToBeTyped);
						setTextFlag = true;
					}
					else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
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
	
	// *************************************** END OF SEND KEYS METHODS *************************************************

	public static boolean isDisplayed(int timeoutInSeconds, LocatorStrategy androidLocatorStrategy, String androidAttributeValue, LocatorStrategy iOSLocatorStrategy, String iOSAttributeValue, LocatorStrategy webLocatorStrategy, String webAttributeValue)
	{
		for(int i = 0; i < timeoutInSeconds; i++)
		{
			try
			{
				return getElement(androidLocatorStrategy, androidAttributeValue, iOSLocatorStrategy, iOSAttributeValue, webLocatorStrategy, webAttributeValue).isDisplayed();
			}
			catch(Exception e)
			{ 
				CommonUtils.wait(1);
			}
		}
		return false;
	}
	
	public static boolean isDisplayed(int timeoutInSeconds, WebElement element)
	{
		for(int i = 0; i < timeoutInSeconds; i++)
		{
			try
			{
				if(element.isDisplayed())
					return true;
			}
			catch(Exception e)
			{ 
				CommonUtils.wait(1);
			}
		}
		return false;
	}
	
	public static boolean isNotDisplayed(int timeoutInSeconds, WebElement element)
	{
		for(int i = 0; i < timeoutInSeconds; i++)
		{
			try
			{
				if(element.isDisplayed())
					CommonUtils.wait(1);
			}
			catch(Exception e)
			{ 
				return true;
			}
		}
		return false;
	}
	
	public static boolean isDisplayed(WebElement element)
	{
		try
		{
			System.out.println("Element Address:"+element);
			if(element.isDisplayed())
			{
				return true;
			}	
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean isEnabled(int timeoutInSeconds, WebElement element)
	{
		for(int i = 0; i < timeoutInSeconds; i++)
		{
			try
			{
				if(element.isEnabled())
					return true;
			}
			catch(Exception e)
			{ 
				CommonUtils.wait(1);
			}
		}
		return false;
	}
	
	public static boolean isEnabled(WebElement element)
	{
		try
		{
			if(element.isEnabled())
			{
				return true;
			}	
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	
	public static void click(int timeoutInSeconds, LocatorStrategy androidLocatorStrategy, String androidAttributeValue, LocatorStrategy iOSLocatorStrategy, String iOSAttributeValue, LocatorStrategy webLocatorStrategy, String webAttributeValue) throws Exception
	{
		element = null;
		for(int i = 0; i < timeoutInSeconds; i++)
		{
			try
			{
				element = getElement(androidLocatorStrategy, androidAttributeValue, iOSLocatorStrategy, iOSAttributeValue, webLocatorStrategy, webAttributeValue);
				element.click();
				return;	
			}
			catch(Exception e)
			{ 
				CommonUtils.wait(1);
			}
		}
		throw new Exception();
	}
	
	public static void safeClick(int timeoutInSeconds, LocatorStrategy androidLocatorStrategy, String androidAttributeValue, LocatorStrategy iOSLocatorStrategy, String iOSAttributeValue, LocatorStrategy webLocatorStrategy, String webAttributeValue)
	{
		 element = null;
		for(int i = 0; i < timeoutInSeconds; i++)
		{
			try
			{
				element = getElement(androidLocatorStrategy, androidAttributeValue, iOSLocatorStrategy, iOSAttributeValue, webLocatorStrategy, webAttributeValue);
				if(element.isDisplayed())
				{
					element.click();
					return;
				}
			}
			catch(Exception e)
			{ 
				CommonUtils.wait(1);
			}
		}
	}
	
	public static void click(int timeoutInSeconds, WebElement element) throws Exception
	{
		for(int i = 0; i < timeoutInSeconds; i++)
		{
			try
			{
				element.click();
				return;	
			}
			catch(Exception e)
			{ 
				CommonUtils.wait(1);
			}
		}
		throw new Exception();
	}
	
	public static void safeClick(int timeoutInSeconds, WebElement element)
	{
		for(int i = 0; i < timeoutInSeconds; i++)
		{
			try
			{
				element.click();
				return;
			}
			catch(Exception e)
			{ 
				CommonUtils.wait(1);
			}
		}
	}
	
	public static void reliableClick(int waitTime, WebElement elementToBeClicked, WebElement elementToBeVisibleAfterClick, int retryCount) throws Exception
	{
		try
		{
			boolean retryFlag = true;
			int retryCounter = 0;
			while(retryFlag)
			{
				safeClick(elementToBeClicked);
				if(isDisplayed(waitTime, elementToBeVisibleAfterClick))
					retryFlag = false;
				else if(retryCounter == retryCount)
					retryFlag = false;
				else
					retryCounter++;
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	public static void reliableSafeClick(int waitTime, WebElement elementToBeClicked, WebElement elementToBeVisibleAfterClick, int retryCount) throws Exception
	{
		try
		{
			boolean retryFlag = true;
			int retryCounter = 0;
			boolean clickFlag = false;
			while(retryFlag)
			{
				if(isDisplayed(waitTime, elementToBeClicked))
				{
					elementToBeClicked.click();
					clickFlag = true;
				}
				if(clickFlag && isDisplayed(waitTime, elementToBeVisibleAfterClick))
					retryFlag = false;
				else if(retryCounter == retryCount)
					retryFlag = false;
				else
					retryCounter++;
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	public static void isEnabledReliableClick(int waitTime, String elementToBeClicked, WebElement elementToBeVisibleAfterClick, int retryCount) throws Exception
	{
		try
		{
			boolean retryFlag = true;
			int retryCounter = 0;
			List<WebElement> elementNameList = new ArrayList<WebElement>();
			WebElement elementName;
			while(retryFlag)
			{
				elementNameList.clear();
				elementName = null;
				elementNameList = ElementUtils.getElements(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, elementToBeClicked, LocatorStrategy.IOS_LOCATOR_STRATEGY_PREDICATE_STRING, "name =='"+elementToBeClicked+"'", LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS, elementToBeClicked);
				
				if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
					elementName = elementNameList.get(elementNameList.size()-1);
					safeClick(elementName);
				}
				if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
					elementName = elementNameList.get(0);
					ElementUtils.isDisplayed(15, elementName);
					js.executeScript("arguments[0].click();", elementName);
				}
				CommonUtils.wait(0, 1, 1);
				if(isEnabled(waitTime, elementToBeVisibleAfterClick))
					retryFlag = false;
				else if(retryCounter == retryCount)
					retryFlag = false;
				else
					retryCounter++;
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	public static void isEnabledReliableClick(int waitTime, WebElement elementToBeClicked, WebElement elementToBeVisibleAfterClick, int retryCount) throws Exception
	{
		try
		{
			boolean retryFlag = true;
			int retryCounter = 0;
			while(retryFlag)
			{
				safeClick(elementToBeClicked);
				CommonUtils.wait(5);
				if(isEnabled(waitTime, elementToBeVisibleAfterClick))
					retryFlag = false;
				else if(retryCounter == retryCount)
					retryFlag = false;
				else
					retryCounter++;
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	public static void isEnabledReliableSafeClick(int waitTime, WebElement elementToBeClicked, WebElement elementToBeVisibleAfterClick, int retryCount) throws Exception
	{
		try
		{
			boolean retryFlag = true;
			int retryCounter = 0;
			boolean clickFlag = false;
			while(retryFlag)
			{
				if(isEnabled(waitTime, elementToBeClicked))
				{
					elementToBeClicked.click();
					clickFlag = true;
				}
				if(clickFlag && isEnabled(waitTime, elementToBeVisibleAfterClick))
					retryFlag = false;
				else if(retryCounter == retryCount)
					retryFlag = false;
				else
					retryCounter++;
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
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
	
}