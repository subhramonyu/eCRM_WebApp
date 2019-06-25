package com.fluke.connect.app.functional.client.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.Gestures;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.ScrollDiection;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class CompletedSessionPage 
{
	@AndroidFindBy(id = "action_bar_item_menu_icon")
	@iOSFindBy(accessibility = "options white")
	private WebElement optionsButton;
	
	@AndroidFindBy(id = "android:id/title")
	@iOSFindBy(accessibility = "Delete")
	private WebElement deleteButton;
	
	@AndroidFindBy(id = "action_bar_item_menu_text")
	@iOSFindBy(accessibility = "Delete")
	private WebElement deleteAgainButton;
	
	@AndroidFindBy(id = "android:id/title")
	@iOSFindBy(accessibility = "Cancel")
	private WebElement cancelButton;
	
	@AndroidFindBy(id = "dialog_ok")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert/descendant::XCUIElementTypeButton[@name = 'Delete']")
	private WebElement alertDeleteButton;
	
	@AndroidFindBy(id = "action_bar_item_left")
	@iOSFindBy(accessibility = "Back")
	private WebElement backButton;
	
	private Gestures gesture;
	private GestureUtils gestureUtils;
	private WebElement sessionCell;
	private boolean sessionDeleteFlag = true;
	
	public CompletedSessionPage()
	{
		CommonUtils.initElements(this);
		gesture = new Gestures();
		gestureUtils = new GestureUtils();
	}
	
	public void clickOnBackButton()
	{
		CommonUtils.ifElementEnabledWithinFluentWaitThenClick(30, 1, backButton);
	}
	
	public void initSessionCellElement(String startTime)
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			sessionCell = DriverManager.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@value='"+startTime+"']/ancestor::XCUIElementTypeCell"));
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			sessionCell = DriverManager.getDriver().findElement(By.xpath("//android.widget.TextView[contains(@text,'"+startTime+"')]/ancestor::android.widget.LinearLayout[contains(@resource-id, 'item')]"));
		}
	}
	
	public WebElement getSessionTile()
	{
		return sessionCell;
	}
	
	public WebElement getElementInSessionTileStrict(String elementAttributeValue)
	{
		return CommonUtils.getElementByUsingVisibleTextStrict(sessionCell, elementAttributeValue);
	}
	
	public WebElement getElementInSessionTile(String elementAttributeValue)
	{
		return CommonUtils.getElementByUsingVisibleText(sessionCell, elementAttributeValue);
	}
	
	public String getElementVisibleTextInSessionTileStrict(String elementAttributeValue)
	{
		return CommonUtils.getElementByUsingVisibleTextStrict(sessionCell, elementAttributeValue).getText();
	}
	
	public WebElement getElementInSessionDetailPage(String elementAttributeValue)
	{
		return CommonUtils.getElementByUsingVisibleText(elementAttributeValue);
	}
	
	public String getElementVisibleTextInSessionDetailPageStrict(String elementAttributeValue)
	{
		return CommonUtils.getElementByUsingVisibleTextStrict(elementAttributeValue).getText();
	}
	
	//click on a session based on session start time
	public void clickOnASession(String iOSObjectName, String iOSObjectValue, String androidObjectValue, int iOSScrollSteps, int androidScrollSteps) throws Exception
	{
		if(gesture.scroll(iOSObjectName, iOSObjectValue, null, androidObjectValue, iOSScrollSteps, androidScrollSteps, null, null))
		{
			initSessionCellElement(iOSObjectValue);  //iOSObjectVale = androidObjectValue = Session Start Time
		    if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		    {
		    	getElementInSessionTile(androidObjectValue).click();
		    }
		    else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		    {
		    	getElementInSessionTileStrict(iOSObjectValue).click();
		    }
		}
		else 
		{
			CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(30, 1, cancelButton);
			throw new Exception("Unable to find, Session Start Time:"+iOSObjectValue);
		}
	}
	
	//delete sessions based on session start time
	public void deleteSessions(String iOSObjectName, int iOSScrollSteps, int androidScrollSteps, String... sessionStartTime) throws Exception
	{
		CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(30, 1, optionsButton);
		CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(30, 1, deleteButton);
		for(int i = 0; i < sessionStartTime.length; i++)
		{
			clickOnASession(iOSObjectName, sessionStartTime[i], sessionStartTime[i], iOSScrollSteps, androidScrollSteps);
		}
		CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(30, 1, deleteAgainButton);
		CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(30, 1, alertDeleteButton);
		CommonUtils.wait(5);  // to ensure session deleted
	}
	
	public boolean areSessionsDeleted(String iOSObjectName, int iOSScrollSteps, int androidScrollSteps, String... sessionStartTime) throws Exception
	{
		deleteSessions(iOSObjectName, iOSScrollSteps, androidScrollSteps, sessionStartTime);
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			for(int i = 0; i < sessionStartTime.length; i++)
			{
				sessionDeleteFlag = gesture.scroll(null, null, null, sessionStartTime[i], 0, -70, null, null);
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			String pageSource = DriverManager.getDriver().getPageSource();
			for(int i = 0; i < sessionStartTime.length; i++)
			{
				sessionDeleteFlag = pageSource.contains(sessionStartTime[i]);
			}
		}
		return sessionDeleteFlag;
	}
	
	public void clickOnASession(String visibleText, LocatorStrategy iOSLocatorStrategy, LocatorStrategy androidLocatorStrategy, ScrollDiection down) throws Exception
	{
		if(gestureUtils.mScroll(visibleText, iOSLocatorStrategy, androidLocatorStrategy, down))
		{
			initSessionCellElement(visibleText);  //iOSObjectVale = androidObjectValue = Session Start Time
		    if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		    {
		    	getElementInSessionTile(visibleText).click();
		    }
		    else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		    {
		    	getElementInSessionTileStrict(visibleText).click();
		    }
		}
		else 
		{
			CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(30, 1, cancelButton);
			throw new Exception("Unable to find, Session Start Time:"+visibleText);
		}
	}
	
	
	// new methods
	public void deleteSessions(String... sessionStartTime) throws Exception
	{
		CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(30, 1, optionsButton);
		CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(30, 1, deleteButton);
		for(int i = 0; i < sessionStartTime.length; i++)
		{
			clickOnASession(sessionStartTime[i], LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		}
		CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(30, 1, deleteAgainButton);
		CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(30, 1, alertDeleteButton);
		CommonUtils.wait(5);  // to ensure session deleted
	}
	
	public boolean areSessionsDeleted(String... sessionStartTime) throws Exception
	{
		deleteSessions(sessionStartTime);
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			for(int i = 0; i < sessionStartTime.length; i++)
			{
				sessionDeleteFlag = gestureUtils.mScroll(sessionStartTime[i], null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			String pageSource = DriverManager.getDriver().getPageSource();
			for(int i = 0; i < sessionStartTime.length; i++)
			{
				sessionDeleteFlag = pageSource.contains(sessionStartTime[i]);
			}
		}
		return sessionDeleteFlag;
	}

	public void deleteFirstSession() throws Exception
	{
		CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(30, 1, optionsButton);
		CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(30, 1, deleteButton);
		clickOnASession("Start Time", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(30, 1, deleteAgainButton);
		CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(30, 1, alertDeleteButton);
		CommonUtils.wait(5);  // to ensure session deleted
	}
	
		
}
