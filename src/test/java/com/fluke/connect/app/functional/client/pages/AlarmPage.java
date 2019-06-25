package com.fluke.connect.app.functional.client.pages;

import java.time.temporal.ChronoUnit;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.fluke.connect.app.testdata.FCCM.AlarmType;
import com.fluke.connect.app.testdata.SignIn.FeatureList;
import com.fluke.connect.app.utils.AndroidUtils;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.IOSUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.ScrollDiection;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AlarmPage 
{
	@FindAll({
		@FindBy(how = How.CSS, using = "div[class = 'menuIconSprite']"),
		@FindBy(how = How.CSS, using = "div[data-event='click:alarmsMenuClick']")
	})
	@iOSXCUITFindBy(accessibility = "options gray")
	@AndroidFindBy(id = "add_edit_alarm_menu_icon")
	private WebElement addEditAlarmMenu;
	
	@FindBy(how = How.CSS, using = "li[data-event = 'click:alarmsMenuClick']")
	@iOSXCUITFindBy(accessibility = "Add or Edit Alarms")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Add or Edit Alarm\")")
	private WebElement addEditAlarmButton;
	
	@HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
	@FindBy(how = How.CSS, using = "div[data-event ='click:addAlarmsInSession']")
	@iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH 'Add'")
	@AndroidFindBy(id = "add_alarm_text")
	@AndroidFindBy(id = "add_alarm")
	private WebElement addAlarmButton;
	
	@FindBy(how = How.CSS, using = "div[class = 'c3']")
	@iOSXCUITFindBy(accessibility = "options gray")
	private WebElement editDeleteAlarmButton;
	
	@FindBy(how = How.CSS, using = "li[data-value = 'edit-alarm']")
	@iOSXCUITFindBy(accessibility = "Edit Alarm")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Edit Alarm\")")
	private WebElement editAlarmButton;
	
	@FindBy(how = How.CSS, using = "li[data-value = 'delete-alarm']")
	@iOSXCUITFindBy(accessibility = "Delete Alarm")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Delete Alarm\")")
	private WebElement deleteAlarmButton;
	
	@FindBy(how = How.CSS, using = "#deleteAlarmButton")
	@iOSXCUITFindBy(accessibility = "Delete")
	@AndroidFindBy(id = "dialog_ok")
	private WebElement deleteAlarmButtonInAlert;
	
	@FindBy(how = How.CSS, using = "div[conf-type='above']")
	@iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH 'Above'")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Above\")")
	private WebElement aboveThresholdButton;
	
	@FindBy(how = How.CSS, using = "div[conf-type='below']")
	@iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH 'Below'")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Below\")")
	private WebElement belowThresholdButton;
	
	@FindBy(how = How.CSS, using = "div[conf-type='within']")
	@iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH 'Within'")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Within-Range\")")
	private WebElement withinThresholdButton;
	
	@FindBy(how = How.CSS, using = "div[conf-type='out']")
	@iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH 'Out'")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Out-of-Range\")")
	private WebElement outOfThresholdButton;
	
	@FindBy(how = How.CSS, using = "input[placeholder='Lower range']")
	@iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH 'thresholdvalue2'")
	@AndroidFindBy(id = "lower_limit_ed")
	private WebElement lowerRangeTextField;
	
	@FindBy(how = How.CSS, using = "input[placeholder='Upper range']")
	@iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH 'thresholdvalue3'")
	@AndroidFindBy(id = "upper_limit_ed")
	private WebElement upperRangeTextField;
	
	@FindBy(how = How.CSS, using = "div[class='down-pointer large down_pointer']")
	@iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH 'alarm'")
	@AndroidFindBy(id = "title_text")
	private WebElement unitDropDownPointer;
	
	@iOSXCUITFindBy(className = "XCUIElementTypePickerWheel")
	private WebElement tempratureUnitDropDown;
	
	@FindBy(how = How.CSS, using = "#alarmConfNext")
	@iOSXCUITFindBy(accessibility = "Next")
	@AndroidFindBy(id = "action_bar_item_menu_text")
	private WebElement addAlarmNextButton;
	
	@FindBy(how = How.CSS, using = "input[name='notify_self_toggle']")
	@iOSXCUITFindBy(accessibility = "Me")
	@AndroidFindBy(id = "current_user_check")
	private WebElement notifySelfCheckbox;
	
	@FindBy(how = How.CSS, using = "input[name='notify_admin_toggle']")
	@iOSXCUITFindBy(accessibility = "Team Administrators")
	@AndroidFindBy(id = "admin_check_box")
	private WebElement notifyAdminCheckbox;
	
	@FindBy(how = How.CSS, using = "input[name='notify_team_toggle']")
	@iOSXCUITFindBy(accessibility = "Specific Team Members")
	@AndroidFindBy(id = "select_user_check_box")
	private WebElement notifyTeamCheckbox;
	
	@FindBy(how = How.CSS, using = "#teamMemberOptions")
	private WebElement teamMemberTextField;
	
	@FindBy(how = How.CSS, using = "div[data-event='click:add-team-member']")
	private WebElement addTeamMemberButton;
	
	@FindBy(how = How.CSS, using = "#btnSaveAlarm")
	@iOSXCUITFindBy(accessibility = "SAVE & CONTINUE")
	@AndroidFindBy(id = "action_bar_item_menu_text")
	private WebElement saveAlarmButton;
	
	@FindBy(how = How.CSS, using = "a[data-action='save']")
	private WebElement editAlarmSaveButton;
	
	@FindBy(how = How.CSS, using = ".sidebar-range-value")
	@iOSXCUITFindBy(accessibility = "options gray")
	@AndroidFindBy(id = "menu_button")
	private List<WebElement> alarmCount;
	
	@iOSXCUITFindBy(accessibility = "Done")
	private WebElement keyboardDoneButton;
	
	@iOSXCUITFindBy(accessibility = "cancel white")
	private WebElement cancelButton;
	
	@HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
	@FindBy(how = How.CSS, using = "a[data-event = 'click:navigate-back']")
	@AndroidFindBy(id = "action_bar_item_left")
	@iOSXCUITFindBy(accessibility = "Back")
	@iOSXCUITFindBy(accessibility = "backBarButton")
	private WebElement backButton;
	
	@AndroidFindBy(id = "add_alarm_text")
	@iOSXCUITFindBy(accessibility = "Add Temperature Alarm")
	private WebElement addTempratureAlarm;
	
	@AndroidFindBy(id = "add_vibration_alarm")
	@iOSXCUITFindBy(accessibility = "Add Vibration Alarm")
	private WebElement addVibrationAlarm;
	
	@WithTimeout(time = 5, chronoUnit = ChronoUnit.SECONDS)
	@FindBy(how = How.CSS, using = "div[class = 'c3']")
	@AndroidFindBy(id = "menu_button")
	@iOSXCUITFindBy(accessibility = "options gray")
	private WebElement alarmOptionsButton;
	
	@FindBy(how = How.CSS, using = ".menuIconSprite")
	private WebElement addEditAlarmDialogBoxMenuIcon;
	
	@FindBy(how = How.CSS, using = "li[data-event='click:alarmsMenuClick']")
	private WebElement addEditAlarmsButton;
	
	private GestureUtils gestureUtils;
	
	public AlarmPage()
	{
		CommonUtils.initElements(this, 10);
		gestureUtils = new GestureUtils();
	}
	
	public enum AlarmPageObjectList
	{
		ADD_EDIT_ALARM_MENU, ADD_EDIT_ALARM_BUTTON, ALARM_COUNT, ADD_ALARM,
		BACK_BUTTON, CANCEL_BUTTON,
		ADD_TEMPRATURE_ALARM, ADD_VIBRATION_ALARM
	}
	
	public WebElement getAlarmPageObject(AlarmPageObjectList objectName)
	{
		switch(objectName)
		{
		case ADD_EDIT_ALARM_MENU:
			return addEditAlarmMenu;
		case ADD_EDIT_ALARM_BUTTON:
			return addEditAlarmButton;
		case ADD_ALARM:
			return addAlarmButton;
		case BACK_BUTTON:
			return backButton;
		case CANCEL_BUTTON:
			return cancelButton;
		case ADD_TEMPRATURE_ALARM:
			return addTempratureAlarm;
		case ADD_VIBRATION_ALARM:
			return addVibrationAlarm;
		default:
				return null;
		}
	}
	
	public List<WebElement> getElementsAlarmPage(AlarmPageObjectList objectName)
	{
		switch(objectName)
		{
		case ALARM_COUNT:
			return alarmCount;
		default:
				return null;
		}
	}
	public void addAlarm(AlarmType alarmType, String unit, String upperRange, String lowerRange, ScrollDiection unitScrollDirection, int scrollCounter, boolean adminFlag, boolean teamMemberFlag, String teamMemberUID)
	{
		CommonUtils.wait(1);
		switch (alarmType) 
		{
		case ABOVE_TEMPERATURE:
		case ABOVE_VOLTAGE:
		case ABOVE_VIBRATION:
			ElementUtils.safeClick(10, aboveThresholdButton);
			CommonUtils.wait(1);
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				ElementUtils.sendKeys(upperRangeTextField, String.valueOf(upperRange));
				unitDropDownPointer.click();
				ElementUtils.getElement(null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, "//div[@class='type-name' and contains(text(), '"+unit+"')]").click();
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
					ElementUtils.sendKeys(lowerRangeTextField, String.valueOf(upperRange));
				else
					ElementUtils.sendKeys(upperRangeTextField, String.valueOf(upperRange));
				CommonUtils.wait(1);
				addAlarmMobileKeyboardDoneButton();
				unitDropDownPointer.click();
				if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
					ElementUtils.getElement(unit, null, null).click();
				else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				{
					for(int i = 0; i < scrollCounter; i++)
					{
						gestureUtils.scrollIOSPickerWheel(tempratureUnitDropDown, unitScrollDirection);
					}
				}
			}
			break;
		case BELOW_TEMPERATURE:
		case BELOW_VIBRATION:
			ElementUtils.safeClick(10, belowThresholdButton);
			CommonUtils.wait(1);
			ElementUtils.sendKeys(lowerRangeTextField, String.valueOf(lowerRange));
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				unitDropDownPointer.click();
				ElementUtils.getElement(null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, "//div[@class='type-name' and contains(text(), '"+unit+"')]").click();
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				CommonUtils.wait(1);
				addAlarmMobileKeyboardDoneButton();
				unitDropDownPointer.click();
				if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				{
					ElementUtils.getElement(unit, null, null).click();
				}
				else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				{
					for(int i = 0; i < scrollCounter; i++)
					{
						gestureUtils.scrollIOSPickerWheel(tempratureUnitDropDown, unitScrollDirection);
					}
					CommonUtils.wait(1);
				}
			}
			break;
		case WITHIN_TEMPERATURE:
		case WITHIN_VIBRATION:
			ElementUtils.safeClick(10, withinThresholdButton);
			CommonUtils.wait(2);
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				ElementUtils.sendKeys(upperRangeTextField, String.valueOf(upperRange));
				ElementUtils.sendKeys(lowerRangeTextField, String.valueOf(lowerRange));
				unitDropDownPointer.click();
				ElementUtils.getElement(null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, "//div[@class='type-name' and contains(text(), '"+unit+"')]").click();
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				ElementUtils.sendKeys(upperRangeTextField, String.valueOf(upperRange));
				CommonUtils.wait(1);
				addAlarmMobileKeyboardDoneButton();
				ElementUtils.sendKeys(lowerRangeTextField, String.valueOf(lowerRange));
				CommonUtils.wait(1);
				if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
					addAlarmMobileKeyboardDoneButton();
				unitDropDownPointer.click();
				if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				{
					ElementUtils.getElement(unit, null, null).click();
				}
				else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				{
					for(int i = 0; i < scrollCounter; i++)
					{
						gestureUtils.scrollIOSPickerWheel(tempratureUnitDropDown, unitScrollDirection);
					}
					CommonUtils.wait(1);
				}
			}
			break;
		case OUTOF_TEMPERATURE:
		case OUTOF_VIBRATION:
			ElementUtils.safeClick(10, outOfThresholdButton);
			CommonUtils.wait(1);
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				ElementUtils.sendKeys(upperRangeTextField, String.valueOf(upperRange));
				ElementUtils.sendKeys(lowerRangeTextField, String.valueOf(lowerRange));
				unitDropDownPointer.click();
				ElementUtils.getElement(null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, "//div[@class='type-name' and contains(text(), '"+unit+"')]").click();
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				ElementUtils.sendKeys(upperRangeTextField, String.valueOf(upperRange));
				addAlarmMobileKeyboardDoneButton();
				ElementUtils.sendKeys(lowerRangeTextField, String.valueOf(lowerRange));
				if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
					addAlarmMobileKeyboardDoneButton();
				unitDropDownPointer.click();
				if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
					ElementUtils.getElement(unit, null, null).click();
				else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				{
					for(int i = 0; i < scrollCounter; i++)
					{
						gestureUtils.scrollIOSPickerWheel(tempratureUnitDropDown, unitScrollDirection);
					}
				}
			}
			break;
		default:
			break;
		}
		addAlarmNextButton.click();
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			notifySelfCheckbox.click();
		if(adminFlag)
			notifyAdminCheckbox.click();
		if(teamMemberFlag) {
			notifyTeamCheckbox.click();
			ElementUtils.sendKeys(teamMemberTextField, teamMemberUID);
			addTeamMemberButton.click();
		}
		saveAlarmButton.click();
		CommonUtils.wait(0, 0, 5);
	}
	
	public void deleteAlarm(AlarmType alarmType, String alarmText)  //in case of web it always delete first alarm
	{
		try
		{
			CommonUtils.wait(2);
			IOSUtils.setIOSPageSource();
			WebElement alarmCellElement = null;
			switch(alarmType)
			{
			case ABOVE:
				alarmCellElement = ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_XPATH, "//android.widget.TextView[starts-with(@text, '"+alarmText+"')]/parent::android.widget.RelativeLayout", LocatorStrategy.IOS_LOCATOR_STRATEGY_XPATH_STARTS_WITH_ANCESTOR_CELL, alarmText, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, "//div[starts-with(text(), '"+alarmText+"')]/ancestor::div[@class='sidbar-region']");
				ElementUtils.getElement(alarmCellElement, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "menu_button", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "options gray", LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "div[class = 'c3']").click();
				CommonUtils.wait(2);
				if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
					deleteAlarmButton.click();
				else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
					gestureUtils.getJavaScriptExecutor().executeScript("arguments[0].click();", deleteAlarmButton);
				CommonUtils.wait(2);
				deleteAlarmButtonInAlert.click();
				if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
					CommonUtils.wait(10);
					ElementUtils.isDisplayed(2, addEditAlarmDialogBoxMenuIcon);
				}
				break;
			case BELOW:
				ElementUtils.getElement(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_XPATH, "//android.widget.TextView[starts-with(@text, '"+alarmText+"')]/parent::android.widget.RelativeLayout", LocatorStrategy.IOS_LOCATOR_STRATEGY_XPATH_STARTS_WITH_ANCESTOR_CELL, alarmText, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, "//div[starts-with(text(), '"+alarmText+"')]/ancestor::div[@class='sidbar-region']"), LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "menu_button", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "options gray", LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "div[class = 'c3']").click();
				CommonUtils.wait(2);
				if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
					deleteAlarmButton.click();
				else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
					gestureUtils.getJavaScriptExecutor().executeScript("arguments[0].click();", deleteAlarmButton);
				CommonUtils.wait(2);
				deleteAlarmButtonInAlert.click();
				if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
					CommonUtils.wait(5);
				break;
			case WITHIN:
				ElementUtils.getElement(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_XPATH, "//android.widget.TextView[starts-with(@text, '"+alarmText+"')]/parent::android.widget.RelativeLayout", LocatorStrategy.IOS_LOCATOR_STRATEGY_XPATH_STARTS_WITH_ANCESTOR_CELL, alarmText, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, "//div[starts-with(text(), '"+alarmText+"')]/ancestor::div[@class='sidbar-region']"), LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "menu_button", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "options gray", LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "div[class = 'c3']").click();
				CommonUtils.wait(2);
				if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
					deleteAlarmButton.click();
				else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
					gestureUtils.getJavaScriptExecutor().executeScript("arguments[0].click();", deleteAlarmButton);
				CommonUtils.wait(2);
				deleteAlarmButtonInAlert.click();
				if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
					CommonUtils.wait(5);
				else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
					CommonUtils.wait(2);
				break;
			case OUTOF:
				ElementUtils.getElement(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_XPATH, "//android.widget.TextView[starts-with(@text, '"+alarmText+"')]/parent::android.widget.RelativeLayout", LocatorStrategy.IOS_LOCATOR_STRATEGY_XPATH_STARTS_WITH_ANCESTOR_CELL, alarmText, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, "//div[starts-with(text(), '"+alarmText+"')]/ancestor::div[@class='sidbar-region']"), LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "menu_button", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "options gray", LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "div[class = 'c3']").click();
				CommonUtils.wait(2);
				if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
					deleteAlarmButton.click();
				else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
					gestureUtils.getJavaScriptExecutor().executeScript("arguments[0].click();", deleteAlarmButton);
				CommonUtils.wait(2);
				deleteAlarmButtonInAlert.click();
				if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
					CommonUtils.wait(5);
			default:
				break;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void editAlarm(AlarmType alarmType, String unit, String upperRange, String lowerRange, ScrollDiection unitScrollDirection, int scrollCounter)
	{
		switch(alarmType)
		{
		case ABOVE:
			ElementUtils.getElement(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_XPATH, "//android.widget.TextView[starts-with(@text, 'Above')]/parent::android.widget.RelativeLayout", LocatorStrategy.IOS_LOCATOR_STRATEGY_XPATH_STARTS_WITH_ANCESTOR_CELL, "Above", LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, "//div[starts-with(text(), 'Above')]/ancestor::div[@class='sidbar-region']"), LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "menu_button", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "options gray", LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "div[class = 'c3']").click();
			editAlarmButton.click();
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				upperRangeTextField.clear();
				ElementUtils.sendKeys(upperRangeTextField, upperRange);
				unitDropDownPointer.click();
				ElementUtils.getElement(null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, "//div[@class='type-name' and contains(text(), '"+unit+"')]").click();
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)  || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				upperRangeTextField.clear();
				ElementUtils.sendKeys(upperRangeTextField, upperRange);
				addAlarmMobileKeyboardDoneButton();
				unitDropDownPointer.click();
				if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				{
					ElementUtils.getElement(unit, null, null).click();
				}
				else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				{
					for(int i = 0; i < scrollCounter; i++)
					{
						gestureUtils.scrollIOSPickerWheel(tempratureUnitDropDown, unitScrollDirection);
					}
				}
			}
			break;
		case BELOW:
			ElementUtils.getElement(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_XPATH, "//android.widget.TextView[starts-with(@text, 'Below')]/parent::android.widget.RelativeLayout", LocatorStrategy.IOS_LOCATOR_STRATEGY_XPATH_STARTS_WITH_ANCESTOR_CELL, "Below", LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, "//div[starts-with(text(), 'Below')]/ancestor::div[@class='sidbar-region']"), LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "menu_button", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "options gray", LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "div[class = 'c3']").click();
			editAlarmButton.click();
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				lowerRangeTextField.clear();
				ElementUtils.sendKeys(lowerRangeTextField, lowerRange);
				unitDropDownPointer.click();
				ElementUtils.getElement(null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, "//div[@class='type-name' and contains(text(), '"+unit+"')]").click();
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				lowerRangeTextField.clear();
				ElementUtils.sendKeys(lowerRangeTextField, lowerRange);
				addAlarmMobileKeyboardDoneButton();
				unitDropDownPointer.click();
				if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				{
					ElementUtils.getElement(unit, null, null).click();
				}
				else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				{
					for(int i = 0; i < scrollCounter; i++)
					{
						gestureUtils.scrollIOSPickerWheel(tempratureUnitDropDown, unitScrollDirection);
					}
				}
			}
			break;
		case WITHIN:
			ElementUtils.getElement(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_XPATH, "//android.widget.TextView[starts-with(@text, 'Within')]/parent::android.widget.RelativeLayout", LocatorStrategy.IOS_LOCATOR_STRATEGY_XPATH_STARTS_WITH_ANCESTOR_CELL, "Within", LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, "//div[starts-with(text(), 'Within')]/ancestor::div[@class='sidbar-region']"), LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "menu_button", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "options gray", LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "div[class = 'c3']").click();
			editAlarmButton.click();
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				upperRangeTextField.clear();
				lowerRangeTextField.clear();
				ElementUtils.sendKeys(upperRangeTextField, upperRange);
				ElementUtils.sendKeys(lowerRangeTextField, lowerRange);
				unitDropDownPointer.click();
				ElementUtils.getElement(null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, "//div[@class='type-name' and contains(text(), '"+unit+"')]").click();
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				upperRangeTextField.clear();
				ElementUtils.sendKeys(upperRangeTextField, upperRange);
				addAlarmMobileKeyboardDoneButton();
				lowerRangeTextField.clear();
				ElementUtils.sendKeys(lowerRangeTextField, lowerRange);
				addAlarmMobileKeyboardDoneButton();
				unitDropDownPointer.click();
				if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				{
					ElementUtils.getElement(unit, null, null).click();
				}
				else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				{
					for(int i = 0; i < scrollCounter; i++)
					{
						gestureUtils.scrollIOSPickerWheel(tempratureUnitDropDown, unitScrollDirection);
					}
				}
			}
			break;
		case OUTOF:
			ElementUtils.getElement(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_XPATH, "//android.widget.TextView[starts-with(@text, 'Out')]/parent::android.widget.RelativeLayout", LocatorStrategy.IOS_LOCATOR_STRATEGY_XPATH_STARTS_WITH_ANCESTOR_CELL, "Out", LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, "//div[starts-with(text(), 'Out')]/ancestor::div[@class='sidbar-region']"), LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "menu_button", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "options gray", LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "div[class = 'c3']").click();
			editAlarmButton.click();
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				upperRangeTextField.clear();
				lowerRangeTextField.clear();
				ElementUtils.sendKeys(upperRangeTextField, upperRange);
				ElementUtils.sendKeys(lowerRangeTextField, lowerRange);
				unitDropDownPointer.click();
				ElementUtils.getElement(null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, "//div[@class='type-name' and contains(text(), '"+unit+"')]").click();
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				upperRangeTextField.clear();
				ElementUtils.sendKeys(upperRangeTextField, upperRange);
				addAlarmMobileKeyboardDoneButton();
				lowerRangeTextField.clear();
				ElementUtils.sendKeys(lowerRangeTextField, lowerRange);
				addAlarmMobileKeyboardDoneButton();
				unitDropDownPointer.click();
				if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				{
					ElementUtils.getElement(unit, null, null).click();
				}
				else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				{
					for(int i = 0; i < scrollCounter; i++)
					{
						gestureUtils.scrollIOSPickerWheel(tempratureUnitDropDown, unitScrollDirection);
					}
				}	
			}
			break;
		default:
			break;
		}
		addAlarmNextButton.click();
		notifySelfCheckbox.click();
		saveAlarmButton.click();
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			saveAlarmButton.click();
	}
	
	public void addAlarmMobileKeyboardDoneButton()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			AndroidUtils.back();
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			ElementUtils.safeClick(keyboardDoneButton);
	};
	
	public int getAlarmCount()
	{
		return ElementUtils.getElements(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "menu_button", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "options gray", LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "div[class = 'c3']").size();
	}
	
	public void deleteAllAlarms(int maxCount)
	{
		try
		{
			CommonUtils.wait(2);
			int currentCounter = 0;
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
				while(alarmOptionsButton.isDisplayed())
				{
					alarmOptionsButton.click();
					deleteAlarmButton.click();
					CommonUtils.wait(2);
					deleteAlarmButtonInAlert.click();
					CommonUtils.wait(2);
					currentCounter++;
					if(currentCounter == maxCount)
						break;
				}
			}
			else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
				if(DriverManager.getFeatureName().equals(FeatureList.FCCM3550.getAttributeValue()))
					gestureUtils.webScroll(ScrollDiection.DOWN, 1);
				while(addEditAlarmDialogBoxMenuIcon.isDisplayed())
				{
					if(DriverManager.getFeatureName().equals(FeatureList.FCCM3550.getAttributeValue()))
						gestureUtils.webScroll(ScrollDiection.DOWN, 1);
					addEditAlarmDialogBoxMenuIcon.click();
					addEditAlarmsButton.click();
					if(ElementUtils.isDisplayed(alarmOptionsButton))
						alarmOptionsButton.click();
					else
						break;
					gestureUtils.getJavaScriptExecutor().executeScript("arguments[0].click();", deleteAlarmButton);
					CommonUtils.wait(1);
					deleteAlarmButtonInAlert.click();
					CommonUtils.wait(10);
					currentCounter++;
					if(currentCounter == maxCount)
						break;
				}
				gestureUtils.getActionsWebObject().sendKeys(Keys.ESCAPE).perform();

			}
			
		}
			catch(Throwable e)
			{
				e.printStackTrace();
			}
		}


}
