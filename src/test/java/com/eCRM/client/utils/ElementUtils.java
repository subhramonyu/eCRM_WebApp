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

	
	
	public static List<WebElement> getElements(WebElement parentElement, LocatorStrategy androidLocatorStrategy, String androidAttributeValue, LocatorStrategy iOSLocatorStrategy, String iOSAttributeValue, LocatorStrategy webLocatorStrategy, String webAttributeValue)
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
	

	

	public static boolean isNotDisplayed(int timeoutInSeconds, int pollingTimeInSeconds, LocatorStrategy androidLocatorStrategy, String androidAttributeValue, LocatorStrategy iOSLocatorStrategy, String iOSAttributeValue, LocatorStrategy webLocatorStrategy, String webAttributeValue)
	{
		try
		{
			if(getElement( webLocatorStrategy, webAttributeValue).isDisplayed())
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
	

	public static boolean isDisplayed(int timeoutInSeconds, int pollingTimeInSeconds, LocatorStrategy webLocatorStrategy, String webAttributeValue) 
	{
		try
		{
			if (timeoutInSeconds == 0)
				timeoutInSeconds = TIMEOUT_IN_SECONDS;
			if (pollingTimeInSeconds == 0)
				pollingTimeInSeconds = POLLING_TIME_IN_SECONDS;
			fluentWait = new FluentWait<WebDriver>(DriverManager.getDriver())
					.pollingEvery(Duration.ofSeconds(pollingTimeInSeconds))
					.withTimeout(Duration.ofSeconds(timeoutInSeconds))
					.ignoring(NoSuchElementException.class, Error.class);

			fluentWaitElement = getElement(webLocatorStrategy, webAttributeValue);
			return fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					return fluentWaitElement.isDisplayed();
				}
			});
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
			
				fluentWait = new FluentWait<WebDriver>(DriverManager.getDriver())
						.pollingEvery(Duration.ofSeconds(pollingTimeInSeconds))
						.withTimeout(Duration.ofSeconds(timeoutInSeconds))
							.ignoring(NoSuchElementException.class, Error.class);
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
			
				fluentWait = new FluentWait<WebDriver>(DriverManager.getDriver())
						.pollingEvery(Duration.ofSeconds(pollingTimeInSeconds))
						.withTimeout(Duration.ofSeconds(timeoutInSeconds))
							.ignoring(NoSuchElementException.class, Error.class);
		
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
				fluentWait = new FluentWait<WebDriver>(DriverManager.getDriver())
						.pollingEvery(Duration.ofSeconds(pollingTimeInSeconds))
						.withTimeout(Duration.ofSeconds(timeoutInSeconds))
							.ignoring(NoSuchElementException.class, Error.class);
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
	
	public static void clickIfDisplayedAndEnabled( LocatorStrategy webLocatorStrategy, String webLocatorValue) throws Exception
	{
		try
		{
			WebElement desiredElement = getElement( webLocatorStrategy, webLocatorValue);
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
			js.executeScript("arguments[0].click();", element);
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

	public static void sendKeys(int timeoutInSeconds, int pollingTimeInSeconds, WebElement element, String textToBeTyped)
	{
		try
		{
			if(isDisplayed(timeoutInSeconds, pollingTimeInSeconds, element))
			
				{
					element.sendKeys(textToBeTyped);
				}
			
		}
		catch(Throwable e)
		{
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
	

	
	
	
}