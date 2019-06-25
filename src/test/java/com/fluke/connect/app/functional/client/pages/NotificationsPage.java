package com.fluke.connect.app.functional.client.pages;

import org.openqa.selenium.WebElement;

import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.ScrollDiection;

public class NotificationsPage 
{
	private GestureUtils gestureUtils;
	private WebElement notificationCell;
	
	public NotificationsPage()
	{
		gestureUtils = new GestureUtils();
	}
	
	public WebElement getNotificationCell(String notificationTitleKeyword)
	{
		if(gestureUtils.mScroll(notificationTitleKeyword, null, null, ScrollDiection.DOWN))
		{
			notificationCell = null;
			return ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_XPATH, "//android.widget.TextView[contains(@text, '"+notificationTitleKeyword+"')]/parent::android.widget.LinearLayout/parent::android.widget.LinearLayout", LocatorStrategy.NONE, null, LocatorStrategy.NONE, null);
			
		}
		else
			return null;
	}
	
	public boolean isNotificationDisplayed(String notificationTitleKeyword)
	{
		return gestureUtils.mScroll(notificationTitleKeyword, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
	}
	
	public boolean isNotificationDisplayed(String ... notificationTitleKeyword)
	{
		boolean returnFlag = false;
		String iOSPageSource = DriverManager.getDriver().getPageSource();
		for(int i = 0; i < notificationTitleKeyword.length; i++)
		{
			returnFlag = iOSPageSource.contains(notificationTitleKeyword[i]);
		}
		return returnFlag;
	}
	
	public boolean isNotificationDisplayed(String androidNotificationTitleKeyword, String iOSNotificationTitleKeyword)
	{
		return gestureUtils.mScroll(androidNotificationTitleKeyword, iOSNotificationTitleKeyword, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
	}
	
	public boolean verifyNotificationContent(String contentToBeVerified)
	{
		return ElementUtils.getElement(notificationCell, contentToBeVerified, LocatorStrategy.NONE, null).isDisplayed();
	}
	
	
}
