 /**
 * This class provide various methods for scrolling down to a particular session tile, extract 
 * session details from tile, and tap on a particular session tile.
 * 
 * This class use session start date and time as a base to do any interaction with the session tile. 
 */

package com.fluke.connect.app.functional.client.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SessionListPage 
{	
	private WebElement sessionCell;
	
	@AndroidFindBy(id = "action_bar_item_menu_icon")
	@iOSXCUITFindBy(accessibility = "Options Menu")
	private WebElement moreOptionsButton; //... on top header
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"View Session Setup\")")
	@iOSXCUITFindBy(accessibility = "View Session Setup")
	private WebElement viewSessionSetUpButton;
	
	@AndroidFindBy(id = "dialog_ok")
	private WebElement permissionAlertOkButton;
	
	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	private WebElement alertAllowButton;
	
	@AndroidFindBy(id = "add_sensor")
	private WebElement addSensorButton;
	
	@HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
	@AndroidFindBy(id = "action_bar_item_left")
	@iOSXCUITFindBy(accessibility = "Back")
	@iOSXCUITFindBy(accessibility = "backBarButton")
	private WebElement backButton;
	
	
	public SessionListPage() 
	{	
		CommonUtils.initElements(this, 5);
	}
	
	public void initSessionCellElement(String startTime)
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			sessionCell = DriverManager.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[contains(@value,'"+startTime+"')]/ancestor::XCUIElementTypeCell"));
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			sessionCell = DriverManager.getDriver().findElement(By.xpath("//android.widget.TextView[contains(@text,'"+startTime+"')]/ancestor::android.widget.LinearLayout[contains(@resource-id, 'item')]"));
		}
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			sessionCell = DriverManager.getDriver().findElement(By.xpath("//span[contains(text(),'"+startTime+"')]/ancestor::div[@class = 'session_tile_sensor_container']"));
		}
	}
	
	public WebElement getSessionTile()
	{
		return sessionCell;
	}
	
	public WebElement getElementInSessionTile(String elementAttributeValue)
	{
		return ElementUtils.getElement(sessionCell, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, elementAttributeValue, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, elementAttributeValue, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS, elementAttributeValue);
	}
	
	public WebElement getElementInSessionTileStrict(String elementAttributeValue)
	{
		return ElementUtils.getElement(sessionCell, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, elementAttributeValue, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, elementAttributeValue, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS, elementAttributeValue);
	}
	
	public String getElementVisibleTextInSessionTile(String elementAttributeValue)
	{
		return ElementUtils.getElement(sessionCell, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, elementAttributeValue, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, elementAttributeValue, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS, elementAttributeValue).getText();
	}
	
	public String getElementVisibleTextInSessionTileStrict(String elementAttributeValue)
	{
		return ElementUtils.getElement(sessionCell, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, elementAttributeValue, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, elementAttributeValue, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS, elementAttributeValue).getText(); 
	}
	
}
