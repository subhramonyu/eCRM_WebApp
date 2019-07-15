package com.eCRM.client.utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.eCRM.client.utils.Config.LocatorStrategy;
import com.eCRM.client.utils.Config.ScrollDiection;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class IOSUtils 
{
	public static int scrollDownSteps = -200;
	public static int scrollUpSteps = 200;
	public static int flexibleScrollDownSteps = -100;
	public static int flexibleScrollUpSteps = 100;

	@SuppressWarnings("unchecked")
    public static IOSDriver<MobileElement> getIOSDriver()
    {
        return (IOSDriver<MobileElement>) DriverManager.getDriver();
    }
	
	public static Map<String, Integer> scrollDownStepsList = new HashMap<String, Integer>();
	static 
    {
    	scrollDownStepsList.put("iPhone 7", -250);
    	scrollDownStepsList.put("iPhone 6s", -200);
    	scrollDownStepsList.put("iPhone 6", -250);
    	scrollDownStepsList.put("Bottom", -1000);
    }
	
	public static Map<String, Integer> scrollUpStepsList = new HashMap<String, Integer>();
	static 
	    {
	    	scrollUpStepsList.put("iPhone 7", 250);
	    scrollUpStepsList.put("iPhone 6s", 245);
		scrollUpStepsList.put("iPhone 6", 250);
	    scrollUpStepsList.put("Up", 200);
	    }
	
	public static Map<String, Integer> flexibleScrollDownStepsList = new HashMap<String, Integer>();
	static 
    {
	flexibleScrollDownStepsList.put("iPhone 7", -100);
	flexibleScrollDownStepsList.put("iPhone 6s", -100);
	flexibleScrollDownStepsList.put("iPhone 6", -100);
	flexibleScrollDownStepsList.put("Bottom", -1000);
    }
	
	public static Map<String, Integer> flexibleScrollUpStepsList = new HashMap<String, Integer>();
	static 
	    {
		flexibleScrollUpStepsList.put("iPhone 7", 100);
		flexibleScrollUpStepsList.put("iPhone 6s", 100);
		flexibleScrollUpStepsList.put("iPhone 6", 100);
		flexibleScrollUpStepsList.put("Up", 200);
	    }
	
	public static int getScrollSteps(ScrollDiection scrollDirection)
	{
		if(scrollDirection == ScrollDiection.UP)
		{
			if(scrollUpStepsList.containsKey(DriverManager.getDeviceName()))
				return scrollUpStepsList.get(DriverManager.getDeviceName());
			else
				return scrollUpSteps;
		}
		else if(scrollDirection == ScrollDiection.DOWN)
		{
			if(scrollDownStepsList.containsKey(DriverManager.getDeviceName()))
				return scrollDownStepsList.get(DriverManager.getDeviceName());
			else
				return scrollDownSteps;
		}
		else if(scrollDirection == ScrollDiection.FLEXIBLE_UP)
		{
			if(flexibleScrollUpStepsList.containsKey(DriverManager.getDeviceName()))
				return flexibleScrollUpStepsList.get(DriverManager.getDeviceName());
			else
				return flexibleScrollUpSteps;
		}
		else if(scrollDirection == ScrollDiection.FLEXIBLE_DOWN)
		{
			if(flexibleScrollDownStepsList.containsKey(DriverManager.getDeviceName()))
				return flexibleScrollDownStepsList.get(DriverManager.getDeviceName());
			else
				return flexibleScrollDownSteps;
		}
		return 0;
	}
	
	public static void setIOSPageSource()
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			Config.useExistingPageSource = true;
			Config.iOSPageSource = "";
			Config.iOSPageSource = DriverManager.getDriver().getPageSource();
		}
	}
	
	public static void setIOSPageSource(String pageSource)
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			Config.useExistingPageSource = true;
			Config.iOSPageSource = "";
			Config.iOSPageSource = pageSource;
		}
	}
	
	public static void resetIOSPageSource()
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			Config.useExistingPageSource = false;
			Config.iOSPageSource = "";
		}
	}
	
	public static void terminateApp(String bundleID)
	{
		getIOSDriver().terminateApp(bundleID);
	}
	
	public static boolean isPageLoaded(LocatorStrategy locatorStrategy, String attributevalue, int waitSeconds)
	{
		boolean returnFlag = true;
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			WebElement element;
			returnFlag = false;
			for(int i = 0; i < waitSeconds; i++)
			{
				element = null; 
				element = ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_BEGINSWITH, "Loading...", null, null);
				if(element == null)
				{
					returnFlag = true;
					break;
				}
				else
					CommonUtils.wait(1);
			}
		}
		return returnFlag;
	}
	
	public static boolean isPageLoaded(int waitSeconds, String attributeValue)
	{
		boolean returnFlag = true;
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			returnFlag = false;
			for(int i = 0; i < waitSeconds; i++)
			{
				if(DriverManager.getDriver().getPageSource().contains(attributeValue))
					CommonUtils.wait(1);
				else
				{
					returnFlag = true;
					break;
				}
					
			}
		}
		return returnFlag;
	}
	
	public static boolean isPageLoadedWithSetSource(int waitSeconds, String attributeValue)
	{
		boolean returnFlag = true;
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			returnFlag = false;
			for(int i = 0; i < waitSeconds; i++)
			{
				String pageSource = DriverManager.getDriver().getPageSource();
				if(pageSource.contains(attributeValue))
					CommonUtils.wait(1);
				else
				{
					returnFlag = true;
					IOSUtils.setIOSPageSource(pageSource);
					break;
				}
					
			}
		}
		return returnFlag;
	}
}
