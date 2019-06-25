package com.fluke.connect.app.utils;

import java.util.HashMap;
import java.util.Map;

import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.ScrollDiection;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

@SuppressWarnings("unchecked")
public class AndroidUtils 
{
	public final static String LOADING_INDICATOR_ID = "android:id/message"; 
	public static int scrollDownSteps = -750;
	public static int scrollUpSteps = 750;
	public static int flexibleScrollDownSteps = -500;
	public static int flexibleScrollUpSteps = 500;
	private static GestureUtils gestureUtils = new GestureUtils();
	
	public static int scrollX = VisualUtils.getAppWidth() / 2;
	public static int scrollYDown = VisualUtils.getAppHeight() / 2 + VisualUtils.getAppHeight() / 4;
	public static int scrollYUp = VisualUtils.getAppHeight() / 2 - VisualUtils.getAppHeight() / 4;
	
	public static void setScrollDimension(int scrollX, int scrollY, ScrollDiection direction)
	{
		AndroidUtils.scrollX = scrollX;
		if(direction == ScrollDiection.DOWN)
		 AndroidUtils.scrollYDown = scrollY;
		else
		 AndroidUtils.scrollYUp = scrollY;
	}
	
	public static Map<String, Integer> scrollDownStepsList = new HashMap<String, Integer>();
	static 
    {
    	scrollDownStepsList.put("Moto Turbo", -90);
    	scrollDownStepsList.put("N6F27M", -125);
    	scrollDownStepsList.put("SM-G920I", -1000);
    	scrollDownStepsList.put("SM-N9208", -1000);
    	scrollDownStepsList.put("SM-N910G", -800);
    scrollDownStepsList.put("ANE-AL00", -750);
    scrollDownStepsList.put("Bottom", -1000);
    }
	
	public static Map<String, Integer> flexibleScrollDownStepsList = new HashMap<String, Integer>();
	static 
    {
	flexibleScrollDownStepsList.put("Moto Turbo", -45);
	flexibleScrollDownStepsList.put("N6F27M", -45);
	flexibleScrollDownStepsList.put("Bottom", -45);
	flexibleScrollDownStepsList.put("SM-G920I", -800);
	flexibleScrollDownStepsList.put("ANE-AL00", -250);
    }
	
	public static Map<String, Integer> scrollUpStepsList = new HashMap<String, Integer>();
	 static 
	    {
	    scrollUpStepsList.put("Moto Turbo", 90);
	    scrollUpStepsList.put("SM-G920I", 1000);
	    scrollUpStepsList.put("Up", 1000);
	    scrollUpStepsList.put("SM-N910G", 200);
	    scrollUpStepsList.put("ANE-AL00", 750);
	    }
	 
	 public static Map<String, Integer> flexibleScrollUpStepsList = new HashMap<String, Integer>();
	 static 
	    {
		 flexibleScrollUpStepsList.put("Moto Turbo", 45);
		 flexibleScrollUpStepsList.put("SM-G920I", 500);
		 flexibleScrollUpStepsList.put("Up", 1000);
		 flexibleScrollUpStepsList.put("ANE-AL00", 250);
	    }
	
	public static AndroidDriver<MobileElement> getAndroidDriver()
	{
		return (AndroidDriver<MobileElement>) DriverManager.getDriver();
	}
	
	public static void back()
	{
		try 
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				getAndroidDriver().pressKey(new KeyEvent().withKey(AndroidKey.BACK));   
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void executeAndroidKeyCode(AndroidKey keyCode)
	{
		try 
		{
			getAndroidDriver().pressKey(new KeyEvent().withKey(keyCode));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
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
	
	public static void launchOtherApp(String appPackage, String appActivity)
	{
		getAndroidDriver().startActivity(new Activity(appPackage, appActivity));
	}

	public static void pressDoneButtonOnNativeKeyBoard(String deviceName, String KeyboardType) 
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			int x= DriverManager.getDriver().manage().window().getSize().getWidth();
			int y= DriverManager.getDriver().manage().window().getSize().getHeight();
			int samsungS6X=160;
			int samsungNote5=470;
			if (KeyboardType == "AlphaNumeric")
			{
				switch(deviceName){
				case ("SM-N9208"):
				{
					gestureUtils.clickOnCordinates(x-150, y-samsungNote5);
					break;
				}
				case("SM-G920I"):
				{
					CommonUtils.wait(10);
					gestureUtils.clickOnCordinates(x-130, y-samsungS6X);
					CommonUtils.wait(10);
					break;
				}
				default:
				}
			}
			else if (KeyboardType == "Numeric")
			{
				switch(deviceName){
				case ("SM-N9208"):
				{
					gestureUtils.clickOnCordinates(x-150, y-samsungNote5);
					break;
				}
				case("SM-G920I"):
				{
					gestureUtils.clickOnCordinates(x-150, y-samsungS6X);
					break;
				}
				default:
				}
			}
		}
	}
	
	public static String getPackageName(String deviceName)
	{
		switch(deviceName)
		{
		case "ANE-AL00":
		case "SM-G920I":
			return "com.android.settings";
		default:
			return "com.android.settings";
		}
	}
	
	public static String getActivityName(String deviceName)
	{
		switch(deviceName)
		{
		case "ANE-AL00":
			return "com.android.settings.HWSettings";
		case "SM-G920I":
			return "com.android.settings.Settings";
		default:
			return "com.android.settings.Settings";
		}
	}
	
	public static boolean isPageLoaded(int timeout)
	{
		return ElementUtils.isNotDisplayed(timeout, ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, LOADING_INDICATOR_ID, null, null, null, null));
	}
}
		
