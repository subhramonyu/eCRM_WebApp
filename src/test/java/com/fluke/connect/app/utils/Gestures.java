/*
 *  This CLASS IS DEPRECATED INSTEAD OF THIS PLEASE USE GESTURE UTILS CLASS 
 */



package com.fluke.connect.app.utils;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.fluke.connect.app.utils.Config.LocatorStrategy;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

@SuppressWarnings({"unused", "rawtypes"})
public class Gestures 
{
	private JavascriptExecutor js;
	private HashMap<String, String> scrollObject;
	private HashMap<String, Object> swipeObject;
	private TouchAction touchAction;
	private int screenWidth;
	private int screenHeight;
	private boolean androidScrollFlag;
	private int androidScrollCounter;
	private String androidPageSourceBeforeScroll;
	private String androidPageSourceAfterScroll;
	public static boolean isAndroidScrollableElementFound;
	private boolean iOSScrollFlag;
	public static boolean isiOSScrollableElementFound;
	
	public Gestures()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			touchAction = new TouchAction((PerformsTouchActions) DriverManager.getDriver());
		}
		screenWidth = 0;
		screenHeight = 0;
		js = (JavascriptExecutor) DriverManager.getDriver();
		scrollObject = new HashMap<String, String>();
		swipeObject = new HashMap<String, Object>();
	}
	
	public void mobileScrollDown(String objectName)
	{
		if(DriverManager.getDriverName().equals("iOS"))
		{
			iOSScrollDown(objectName);
		}
		else if(DriverManager.getDriverName().equals("Android"))
		{
		    androidScrollDown(objectName);
		}
	}
	
	public void mobileScrollDown(String objectName, int scrollSteps)
	{
		if(DriverManager.getDriverName().equals("iOS"))
		{
			iOSScrollDown(objectName);
		}
		else if(DriverManager.getDriverName().equals("Android"))
		{
		    androidScrollDown(objectName, scrollSteps);
		}
	}
	
	public void mobileScrollDownByValue(String objectName, int scrollSteps)
	{
		if(DriverManager.getDriverName().equals("iOS"))
		{
			iOSScrollDownByValue(objectName);
		}
		else if(DriverManager.getDriverName().equals("Android"))
		{
		    androidScrollDown(objectName, scrollSteps);
		}
	}
	
	public void mobileScrollDownByElement(String objectName, int scrollSteps)
	{
		if(DriverManager.getDriverName().equals("iOS"))
		{
			iOSScrollDownByElement(objectName);
		}
		else if(DriverManager.getDriverName().equals("Android"))
		{
		    androidScrollDown(objectName, scrollSteps);
		}
	}
	
	public void mobileScrollDownUnsafe(String objectName, int scrollSteps)
	{
		if(DriverManager.getDriverName().equals("iOS"))
		{
			iOSScrollDownUnsafe(objectName);
		}
		else if(DriverManager.getDriverName().equals("Android"))
		{
		    androidScrollDown(objectName, scrollSteps);
		}
	}
	
	public void mobileFlexibleScroll(int scrollCount, int iOSScrollSteps, int androidScrollSteps)
	{
		int appWidth = VisualUtils.getAppWidth() / 2;
		int appHeight = VisualUtils.getAppHeight() - 20;
		for(int i = 0; i < scrollCount; i++)
		{
			try
			{
				if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				{
					touchAction.press(PointOption.point(appWidth, appHeight - 300)).moveTo(PointOption.point(appWidth, iOSScrollSteps)).release().perform();					
				}
				if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				{
					touchAction.press(PointOption.point(0, VisualUtils.getAppHeight() / 2)).moveTo(PointOption.point(0, androidScrollSteps)).release().perform();					
				}
			}
			catch(Throwable e)
			{
				e.printStackTrace();
			}
		}
	}
	
	// for android object name would be null
	public void mobileScrollDown(String objectName, String objectValue, int iOSScrollSteps, int androidScrollSteps)
	{
		if(DriverManager.getDriverName().equals("iOS"))
		{
			customizediOSScrollDown(objectName, objectValue, iOSScrollSteps);
		}
		else if(DriverManager.getDriverName().equals("Android"))
		{
		    androidScrollDown(objectValue, androidScrollSteps);
		}
	}
	
	public void reliableMobileScrollDown(WebElement element, String objectName, int waitTime)
	{
		CommonUtils.isElementDisplayedWithinFluentWait(60, 1, element);
		CommonUtils.wait(waitTime);
		if(DriverManager.getDriverName().equals("iOS"))
		{
			try
			{
				scrollObject.put("direction", "down");
				scrollObject.put("name", objectName);
				js.executeScript("mobile: scroll", scrollObject);
			}
			catch(Throwable e)
			{
				e.printStackTrace();
			}
		}
		if(DriverManager.getDriverName().equals("Android"))
		{
			try
			{
				DriverManager.getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
						+ ".scrollIntoView(new UiSelector().text("+objectName+"))"));
			}
			catch(Throwable e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void mobileScrollDown(WebElement element, int waitTime)
	{
		CommonUtils.isElementDisplayedWithinFluentWait(60, 1, element);
		CommonUtils.wait(waitTime);
		if(DriverManager.getDriverName().equals("iOS"))
		{
			try
			{
				scrollObject.put("direction", "down");
				js.executeScript("mobile: scroll", scrollObject);
			}
			catch(Throwable e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void mobileScrollDown()
	{
		if(DriverManager.getDriverName().equals("iOS"))
		{
			try
			{
				iOSScrollDown();
			}
			catch(Throwable e)
			{
				e.printStackTrace();
			}
		}
		if(DriverManager.getDriverName().equals("Android"))
		{
			try
			{
				androidScrollDown();
			}
			catch(Throwable e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void mobileScrollUp(WebElement elementToBeScrolled, int scrollSteps)
	{
		if(DriverManager.getDriverName().equals("iOS"))
		{
			try
			{
				iOSSwipeUp(elementToBeScrolled);
			}
			catch(Throwable e)
			{
				e.printStackTrace();
			}
		}
		if(DriverManager.getDriverName().equals("Android"))
		{
			try
			{
				androidScrollUp(scrollSteps);
			}
			catch(Throwable e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void iOSScrollDown(String objectName)
	{
		try
		{
			scrollObject.put("direction", "down");
			scrollObject.put("name", objectName);
			js.executeScript("mobile: scroll", scrollObject);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	public void iOSScrollDownByValue(String objectName)
	{
		try
		{
			scrollObject.put("direction", "down");
			scrollObject.put("predicateString", "value == '" + objectName + "'");
			js.executeScript("mobile: scroll", scrollObject);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	public void iOSScrollDownByElement(String objectName)
	{
		try
		{
			scrollObject.put("direction", "down");
			scrollObject.put("element", ((RemoteWebElement) CommonUtils.getElementByUsingVisibleTextStrict(objectName)).getId());
			js.executeScript("mobile: scroll", scrollObject);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	public void iOSScrollDownUnsafe(String objectName)
	{
		scrollObject.put("direction", "down");
		scrollObject.put("name", objectName);
		js.executeScript("mobile: scroll", scrollObject);
	}
	
	public void customizediOSScrollDown(String elementAttributeName, String elementAttributeValue, int scrollSteps)
	{
		iOSScrollFlag = DriverManager.getDriver().getPageSource().contains(elementAttributeValue);
		if(iOSScrollFlag)
		{
			int appWidth = VisualUtils.getAppWidth() / 2;
			int appHeight = VisualUtils.getAppHeight() - 20;
			MobileElement scrollToDesiredElement = DriverManager.getDriver().findElement(MobileBy.iOSNsPredicateString(""+elementAttributeName+" == '"+elementAttributeValue+"'"));
			while(iOSScrollFlag)
			{
				try
				{
					touchAction.press(PointOption.point(appWidth, appHeight)).moveTo(PointOption.point(appWidth, -scrollSteps)).release().perform();					
					try
					{
						if(scrollToDesiredElement.isDisplayed())
						{
							iOSScrollFlag = false;
							isiOSScrollableElementFound = true;
						}
					}
					catch(Throwable e)
					{
						e.printStackTrace();
					}
				}
				catch(Throwable e)
				{
					e.printStackTrace();
				}
			}
		}
		else
		{
			isiOSScrollableElementFound = false;
		}
	}
	
	public void androidScrollDown(String scrollToElement)
	{
		setAndroidScrollFlag(scrollToElement);
		while(androidScrollFlag)
		{
			try
			{
				androidPageSourceBeforeScroll = DriverManager.getDriver().getPageSource();
				touchAction.press(PointOption.point(VisualUtils.getAppWidth()/2, VisualUtils.getAppHeight()/2)).moveTo(PointOption.point(0, -45)).release().perform();									
				androidPageSourceAfterScroll = DriverManager.getDriver().getPageSource();
			}
			catch(Throwable e)
			{
				e.printStackTrace();
				androidPageSourceAfterScroll = DriverManager.getDriver().getPageSource();

			}
			setAndroidScrollFlag(scrollToElement);
			if(androidScrollFlag)
			{
				if(isReachedToBottom())
				{
					androidScrollFlag = false;
					isAndroidScrollableElementFound = false;
				}
			}
		}
	}
	
	public void androidScrollDown(String scrollToElement, int scrollSteps)
	{
		setAndroidScrollFlag(scrollToElement);
		while(androidScrollFlag)
		{
			try
			{
				androidPageSourceBeforeScroll = DriverManager.getDriver().getPageSource();
				touchAction.press(PointOption.point(0, VisualUtils.getAppHeight()/4)).moveTo(PointOption.point(0, -scrollSteps)).release().perform();									
				androidPageSourceAfterScroll = DriverManager.getDriver().getPageSource();
			}
			catch(Throwable e)
			{
				e.printStackTrace();
				androidPageSourceAfterScroll = DriverManager.getDriver().getPageSource();
			}
			setAndroidScrollFlag(scrollToElement);
			if(androidScrollFlag)
			{
				if(isReachedToBottom())
				{
					androidScrollFlag = false;
					isAndroidScrollableElementFound = false;
				}
			}
		}
	}
	
	public void androidScrollDown()
	{
		androidScrollFlag = true;
		while(androidScrollFlag)
		{
			try
			{
				androidPageSourceBeforeScroll = DriverManager.getDriver().getPageSource();
				touchAction.press(PointOption.point(VisualUtils.getAppWidth()/2, VisualUtils.getAppHeight()/2)).moveTo(PointOption.point(0, -300)).release().perform();									
				androidPageSourceAfterScroll = DriverManager.getDriver().getPageSource();
			}
			catch(Throwable e)
			{
				e.printStackTrace();
				androidPageSourceAfterScroll = DriverManager.getDriver().getPageSource();

			}
			if(androidScrollFlag)
			{
				if(isReachedToBottom())
				{
					androidScrollFlag = false;
				}
			}
		}
	}
	
	public void androidScrollDown(int scrollSteps)
	{
		androidScrollFlag = true;
		while(androidScrollFlag)
		{
			try
			{
				androidPageSourceBeforeScroll = DriverManager.getDriver().getPageSource();
				touchAction.press(PointOption.point(VisualUtils.getAppWidth()/2, VisualUtils.getAppHeight()/2)).moveTo(PointOption.point(0, -scrollSteps)).release().perform();													
				androidPageSourceAfterScroll = DriverManager.getDriver().getPageSource();

			}
			catch(Throwable e)
			{
				e.printStackTrace();
				androidPageSourceAfterScroll = DriverManager.getDriver().getPageSource();
			}
			if(androidScrollFlag)
			{
				if(isReachedToBottom())
				{
					androidScrollFlag = false;
				}
			}
		}
	}
	
	public void androidScrollUp(int scrollSteps)
	{
		androidScrollFlag = true;
		while(androidScrollFlag)
		{
			try
			{
				androidPageSourceBeforeScroll = DriverManager.getDriver().getPageSource();
				touchAction.press(PointOption.point(0, VisualUtils.getAppHeight()-20)).moveTo(PointOption.point(0, scrollSteps)).release().perform();																	
				androidPageSourceAfterScroll = DriverManager.getDriver().getPageSource();
			}
			catch(Throwable e)
			{
				e.printStackTrace();
				androidPageSourceAfterScroll = DriverManager.getDriver().getPageSource();
			}
			if(androidScrollFlag)
			{
				if(isReachedToBottom())
				{
					androidScrollFlag = false;
				}
			}
		}
	}
	
	public boolean androidSingleScrollDown(int scrollSteps)
	{
		androidScrollFlag = true;
		try
		{
			androidPageSourceBeforeScroll = DriverManager.getDriver().getPageSource();
			
			androidPageSourceAfterScroll = DriverManager.getDriver().getPageSource();
			if(androidPageSourceBeforeScroll.equals(androidPageSourceAfterScroll))
			{
				for(int i=0;i<3;i++)
				{
					androidPageSourceBeforeScroll = DriverManager.getDriver().getPageSource();
					touchAction.press(PointOption.point(VisualUtils.getAppWidth()/2, VisualUtils.getAppHeight()/2)).moveTo(PointOption.point(0, -scrollSteps)).release().perform();																						
					androidPageSourceAfterScroll = DriverManager.getDriver().getPageSource();
					if(!androidPageSourceBeforeScroll.equals(androidPageSourceAfterScroll))
					{
						break;
					}
					else if(androidPageSourceBeforeScroll.equals(androidPageSourceAfterScroll) && i == 2)
					{
						androidScrollFlag = false;
						return androidScrollFlag;
					}
				}
				return androidScrollFlag;
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			androidPageSourceAfterScroll = DriverManager.getDriver().getPageSource();
			androidScrollFlag = false;
		}
		return androidScrollFlag;
	}
	
	
	
	public void iOSScrollDown()
	{
		try
		{
			scrollObject.put("direction", "down");
			js.executeScript("mobile: scroll", scrollObject);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	public void iOSCordinateScroll(int x1, int y1, int x2, int y2)
	{
		try
		{
			JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("duration", 0.0);
			params.put("fromX", x1);
			params.put("fromY", y1);
			params.put("toX", x2);
			params.put("toY", y2);
			js.executeScript("mobile: dragFromToForDuration", params);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	public void iOSSwipeDown(Object object)
	{
		swipeObject.put("direction", "down");
		swipeObject.put("element", ((RemoteWebElement) object).getId());
		js.executeScript("mobile: swipe", swipeObject);
	}
	
	public void iOSSwipeUp(Object object)
	{
		swipeObject.put("direction", "up");
		swipeObject.put("element", ((RemoteWebElement) object).getId());
		js.executeScript("mobile: swipe", swipeObject);
	}
	
	public void mobileSwipeUp(Object object)
	{
		swipeObject.put("direction", "up");
		swipeObject.put("element", ((RemoteWebElement) object).getId());
		js.executeScript("mobile: swipe", swipeObject);
	}
	
	public void iOSSwipeLeft()
	{
		try
		{
			swipeObject.put("direction", "left");
			js.executeScript("mobile: swipe", swipeObject);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	public void iOSSwipeRight()
	{
		swipeObject.put("direction", "right");
		js.executeScript("mobile: swipe", swipeObject);
	}
	
	public void iOSSwipeLeft(Object object)
	{
		swipeObject.put("direction", "left");
		swipeObject.put("element", ((RemoteWebElement) object).getId());
		js.executeScript("mobile: swipe", swipeObject);
	}
	
	public void iOSSwipeRight(Object object)
	{
		swipeObject.put("direction", "right");
		swipeObject.put("element", ((RemoteWebElement) object).getId());
		js.executeScript("mobile: swipe", swipeObject);
	}
	
	public void androidScrollToResourceId(String resourceId)
	{
		DriverManager.getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()."
				+ "scrollable(true)).scrollIntoView(new UiSelector().resourceId("+resourceId+"))"));
	}
	
	public void androidScrollToTextValue(String textValue)
	{
		DriverManager.getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
				+ ".scrollIntoView(new UiSelector().text("+textValue+"))"));
	}
	
	public void androidScrollToTextStartsWith(String textValue)
	{
		DriverManager.getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
				+ ".scrollIntoView(new UiSelector().textStartsWith("+textValue+"))"));
	}
	
	public void webBrowserScrollDown(int steps)
	{
		((JavascriptExecutor)DriverManager.getDriver()).executeScript("window.scrollBy(0,1000)");
	}
	
	public void webBrowserScrollUp(int steps)
	{
		((JavascriptExecutor)DriverManager.getDriver()).executeScript("window.scrollBy(0,-"+steps+")","");
	}
	
	public int getScreenWidth()
	{
		return DriverManager.getDriver().manage().window().getSize().getWidth();
	}
	
	public int getScreenHeight()
	{
		return DriverManager.getDriver().manage().window().getSize().getHeight();
	}
	
	public void swipeByCordinates(int x1, int y1, int x2, int y2)
	{
		touchAction.press(PointOption.point(x1, y1)).moveTo(PointOption.point(x2, y2)).release().perform();																								
	}
	
	public void swipeByCordinates(WebElement element, int x1, int y1, int x2, int y2)
	{
		touchAction.press(ElementOption.element(element, x1, y1)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(ElementOption.element(element, x2, y2)).release().perform();
	}
	
	
	/* Use this method in order to perform scroll up and scroll down.
	 * For scroll down scroll steps should be negative and for scroll up steps should be positive.
	 * This method scroll then check objectName == objectValue, it repeats again and again until it reaches the object.
	*/
	public boolean scroll(String iOSObjectName, String iOSObjectValue, String androidObjectName, String androidObjectValue, int iOSScrollSteps, int androidScrollSteps, LocatorStrategy webLocatorStrategy, String webAttributeValue)
	{
		if(DriverManager.getDriverName().equals("iOS"))
		{
			if(iOSObjectName != null)
			{
				return iOSScroll(iOSObjectName, iOSObjectValue, iOSScrollSteps);
			}
			
		}
		else if(DriverManager.getDriverName().equals("Android"))
		{
			return androidScroll(androidObjectValue, androidScrollSteps);
		}
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			if(webLocatorStrategy != null)
			{
				return webScroll(ElementUtils.getElement(null, null, null, null, webLocatorStrategy, webAttributeValue));
			}
		}
		return false;
	}
	
	public boolean iOSScroll(String elementAttributeName, String elementAttributeValue, int scrollSteps)
	{
		try 
		{
			List<MobileElement> scrollToDesiredElement = DriverManager.getDriver().findElements(MobileBy.iOSNsPredicateString(""+elementAttributeName+" == '"+elementAttributeValue+"'"));
			for(MobileElement scrollToElement: scrollToDesiredElement)
			{
				if(scrollToElement.isDisplayed())
				{
					return true;
				}
			}
			iOSScrollFlag = DriverManager.getDriver().getPageSource().contains(elementAttributeValue);
			if(iOSScrollFlag)
			{
				int appWidth = 100;
				int appHeight = VisualUtils.getAppHeight();
				if(scrollSteps < 0)
				{
					appHeight -= 100;
				}
				else
				{
					appHeight = 0;
					appHeight += 100;
				}
				while(iOSScrollFlag)
				{
					touchAction.press(PointOption.point(appWidth, appHeight)).moveTo(PointOption.point(appWidth, scrollSteps)).release().perform();																													
					for(MobileElement scrollToElement: scrollToDesiredElement)
					{
						if(scrollToElement.isDisplayed())
						{
							return true;
						}
					}
				}
			}
			else
			{
				return false;
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			return false;
		}
		return false;
	} 
	
	public boolean androidScroll(String scrollToElement, int androidScrollSteps)
	{
		try
		{
			setAndroidScrollFlag(scrollToElement);
			while(androidScrollFlag)
			{
				int appWidth = 10;
				int appHeight = VisualUtils.getAppHeight();
				if(androidScrollSteps < 0)
				{
					appHeight -= 300;
				}
				else
				{
					appHeight = 0;
					appHeight += 900;
				}
				androidPageSourceBeforeScroll = DriverManager.getDriver().getPageSource();
				touchAction.press(PointOption.point(appWidth, appHeight)).moveTo(PointOption.point(appWidth,androidScrollSteps)).release().perform();																													
				androidPageSourceAfterScroll = DriverManager.getDriver().getPageSource();
				setAndroidScrollFlag(scrollToElement);
				if(androidScrollFlag)
				{
					if(isReachedToBottom())
					{
						androidScrollFlag = false;
						isAndroidScrollableElementFound = false;
					}
				}
			}
			return isAndroidScrollableElementFound;
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public void setAndroidScrollFlag(String scrollToElement)
	{
		try
		{
			if(DriverManager.getDriver().getPageSource().contains(scrollToElement))
			{
				if(CommonUtils.isElementDisplayedWithinFluentWait(2, 1, scrollToElement))
				{
					androidScrollFlag = false;
					isAndroidScrollableElementFound = true;
				}		
			}
			else
			{
				androidScrollFlag = true;
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	//specific to Android scroll
	//bottom can be top end or down end
	public boolean isReachedToBottom()
	{
		try
		{
			if(androidPageSourceBeforeScroll.equals(androidPageSourceAfterScroll))
			{
				androidScrollCounter++;
			}
			else
			{
				androidScrollCounter = 0;
			}
			if(androidScrollCounter == 3)
			{
				return true;
			}
			else 
			{
				return false;
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean webScroll(WebElement element)
	{
		try
		{
			((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView();", element);
			
			if(element.isDisplayed())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	/*
	 * 
	
	 * Use this method in order to perform scroll up and scroll down.
	 * For scroll down scroll steps should be negative and for scroll up steps should be positive.
	 * This method scroll then check "ObjectName PredicateString ObjectValue", it repeats again and again until it reaches the object.
	  */
	public boolean mobileScrollFlexible(String iOSObjectName, String iOSPredicateString, String iOSObjectValue, String androidObjectValue, int iOSScrollSteps, int androidScrollSteps)
	{
		if(DriverManager.getDriverName().equals("iOS"))
		{
			if(iOSObjectName != null)
			{
				return iOSScrollFlexible(iOSObjectName, iOSPredicateString, iOSObjectValue, iOSScrollSteps);
			}
		}
		else if(DriverManager.getDriverName().equals("Android"))
		{
			if(androidObjectValue != null)
			{
				return androidScrollFlexible(androidObjectValue, androidScrollSteps);
			}
		}
		return false;
	} 
	
	public boolean iOSScrollFlexible(String elementAttributeName, String predicateString, String elementAttributeValue, int scrollSteps)
	{
		try 
		{
			MobileElement scrollToDesiredElement = DriverManager.getDriver().findElement(MobileBy.iOSNsPredicateString(""+elementAttributeName+" "+predicateString+" '"+elementAttributeValue+"'"));
			if(scrollToDesiredElement.isDisplayed())
			{
				return true;
			}
			else
			{
				iOSScrollFlag = DriverManager.getDriver().getPageSource().contains(elementAttributeValue);
				if(iOSScrollFlag)
				{
					int appWidth = 100;
					int appHeight = VisualUtils.getAppHeight();
					if(scrollSteps < 0)
					{
						appHeight -= 100;
					}
					else
					{
						appHeight = 0;
						appHeight += 100;
					}
					while(iOSScrollFlag)
					{
						touchAction.press(PointOption.point(appWidth, appHeight)).moveTo(PointOption.point(appWidth, scrollSteps)).release().perform();																																			
						if(scrollToDesiredElement.isDisplayed())
						{
							iOSScrollFlag = false;
							return true;
						}
					}
				}
				else
				{
					return false;
				}
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			return false;
		}
		return false;
	} 
	
	public boolean androidScrollFlexible(String scrollToElement, int androidScrollSteps)
	{
		try
		{
			setAndroidScrollFlagFlexible(scrollToElement);
			while(androidScrollFlag)
			{
				int appWidth = 10;
				int appHeight = VisualUtils.getAppHeight();
				if(androidScrollSteps < 0)
				{
					appHeight -= 100;
				}
				else
				{
					appHeight = 0;
					appHeight += 100;
				}
				androidPageSourceBeforeScroll = DriverManager.getDriver().getPageSource();
				touchAction.press(PointOption.point(appWidth, appHeight)).moveTo(PointOption.point(appWidth, androidScrollSteps)).release().perform();																																							
				androidPageSourceAfterScroll = DriverManager.getDriver().getPageSource();
				setAndroidScrollFlag(scrollToElement);
				if(androidScrollFlag)
				{
					if(isReachedToBottom())
					{
						androidScrollFlag = false;
						isAndroidScrollableElementFound = false;
					}
				}
			}
			return isAndroidScrollableElementFound;
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public void setAndroidScrollFlagFlexible(String scrollToElement)
	{
		try
		{
			if(DriverManager.getDriver().getPageSource().contains(scrollToElement))
			{
				androidScrollFlag = false;
				isAndroidScrollableElementFound = true;
			}
			else
			{
				androidScrollFlag = true;
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	
}

