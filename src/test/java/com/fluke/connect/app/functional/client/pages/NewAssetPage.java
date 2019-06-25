package com.fluke.connect.app.functional.client.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.Gestures;
import com.fluke.connect.app.utils.Config.LocatorStrategy;

import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class NewAssetPage 
{
	private Gestures gesture= new Gestures();
	
	@FindBy(how=How.CSS,using="input[id=\"equipmentName\"]")
	@AndroidFindBy(id="com.fluke.deviceApp:id/asset_name_text")
	@iOSFindBy(accessibility = "Asset name")
	private WebElement assetNameTextField;
	
	@HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
	@iOSXCUITFindBy(accessibility="Return")
	@iOSXCUITFindBy(accessibility="Done")
	private WebElement keyboardReturnButton;
	
	@FindBy(how=How.CSS,using="#equipmentType")
	@AndroidFindBy(id="com.fluke.deviceApp:id/asset_type_text")
	@iOSFindBy(accessibility = "Asset Type")
	private WebElement assetTypeArrowButton;
	
	@iOSFindBy(accessibility = "Back")
	private WebElement backButton;
	
	@iOSFindBy(accessibility = "ADD COMPONENTS")
	@AndroidFindBy(id="com.fluke.deviceApp:id/add_component")
	private WebElement addComponentsButton;
	
	@iOSFindBy(accessibility = "Component name")
	@AndroidFindBy(id="com.fluke.deviceApp:id/add_component_name")
	private WebElement componentNameTextField;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/action_bar_item_menu_text")
	@iOSFindBy(accessibility = "Save")
	private WebElement saveButton;
	
	@iOSFindBy(accessibility = "ADD ALARMS")
	@AndroidFindBy(id="com.fluke.deviceApp:id/add_alarms")
	private WebElement addAlarmaButton;
	
	@iOSFindBy(accessibility = "Temperature")
	private WebElement tempratureButton;
	
	@iOSFindBy(accessibility = "Temperature Alarm")
	@AndroidFindBy(id="com.fluke.deviceApp:id/temperature_alarm")
	private WebElement tempratureAlarmButton;
	
	@iOSFindBy(accessibility="Above Temperature Alarm")
	private WebElement aboveTempratureAlarmButton;
	
	@iOSFindBy(accessibility="thresholdvalue2")
	@AndroidFindBy(id="com.fluke.deviceApp:id/upper_limit_ed")
	private WebElement aboveTempratureAlarmTextField;
	
	@iOSFindBy(accessibility="Done")
	private WebElement keyboardDoneButton;
	
	@iOSFindBy(accessibility="alarm unit")
	private WebElement alarmUnitDropDownButton;
	
	@FindBy(how=How.CSS,using="[data-event=\"click:add-equipment-done\"]")
	@AndroidFindBy(id="com.fluke.deviceApp:id/action_bar_item_menu_text")
	@iOSFindBy(accessibility="Next")
	private WebElement nextButton;
	
	@iOSFindBy(accessibility="Me")
	private WebElement selfAlarmRecipent;
	
	@iOSFindBy(accessibility="Team Administrators")
	@AndroidFindBy(id="com.fluke.deviceApp:id/admin_check_box")
	private WebElement teamAdminAlarmRecipent;
	
	@iOSFindBy(accessibility="cancel white")
	private WebElement blankAlarmPageCancelButton;
	
	public static boolean isAlarmAdded;
	
	public NewAssetPage()
	{
		CommonUtils.initElements(this);
	}
	
	
	public void newAsset(String assetName, String assetType, String assetStatus)
	{
	 	assetNameTextField.sendKeys(assetName);
		selectAssetType(assetType);
		nextButton.click();
		if(DriverManager.getDriverName().equals("iOS") || DriverManager.getDriverName().equals("Android"))
		{	
			selectAssetStatus(assetStatus);
		}
	}
	
	public void newAssetWithAboveTempratureAlarm(String assetName, String assetType, String componentName, String aboveTempratureValue, String assetStatus)
	{

		if(DriverManager.getDriverName().equals("Android"))
		{
			assetNameTextField.sendKeys(assetName);;
		}
		if(DriverManager.getDriverName().equals("iOS"))
		{
			ElementUtils.sendKeys(assetNameTextField, assetName);
		}		
		selectAssetType(assetType);
		if(DriverManager.getDriverName().equals("iOS"))
		{
			ElementUtils.safeClick(1, 1, keyboardReturnButton);
		}
		addComponentsButton.click();
		if(DriverManager.getDriverName().equals("iOS"))
		{
			ElementUtils.sendKeys(componentNameTextField, componentName);
		}
		if(DriverManager.getDriverName().equals("Android"))
		{
			componentNameTextField.sendKeys(componentName);
		}
		if(DriverManager.getDriverName().equals("iOS"))
		{
			ElementUtils.safeClick(1, 1, keyboardReturnButton);
		}
		saveButton.click();
		CommonUtils.wait(2);
		try
		{
			gesture.scroll("name", "ADD ALARMS", null, "ADD ALARMS", -45, -60, null, null);
			addAlarmaButton.click();
			if(DriverManager.getDriverName().equals("iOS"))
			{
				tempratureButton.click();
			}
			if(DriverManager.getDriverName().equals("Android"))
			{
				CommonUtils.getElementByUsingVisibleText("Temperature").click();
				tempratureAlarmButton.click();
				CommonUtils.getElementByUsingVisibleText("Above Temperature Alarm").click();
				aboveTempratureAlarmTextField.sendKeys(aboveTempratureValue);
			}
			if(DriverManager.getDriverName().equals("iOS"))
			{
				ElementUtils.safeClick(tempratureAlarmButton);
			}
			if(DriverManager.getDriverName().equals("iOS"))
			{
				aboveTempratureAlarmButton.click();
				ElementUtils.sendKeys(aboveTempratureAlarmTextField, aboveTempratureValue);
				keyboardDoneButton.click();
				alarmUnitDropDownButton.click();
				keyboardDoneButton.click();
			}			
			nextButton.click();
			selectAssetName(assetName);
			nextButton.click();
			if(DriverManager.getDriverName().equals("iOS"))
			{
				selfAlarmRecipent.click();
			}
			teamAdminAlarmRecipent.click();
			saveButton.click();
			isAlarmAdded = true;
		}
		catch(Throwable e)
		{
			CommonUtils.ifElementIsDisplayedThenTap(blankAlarmPageCancelButton);
			isAlarmAdded = false;
		}
		CommonUtils.wait(2);
		
		nextButton.click();
	
		selectAssetStatus(assetStatus);
	}
	
	public void selectAssetType(String assetType)
	{
		try
		{
			if(DriverManager.getDriverName().equals("Web"))
			{
				GestureUtils.moveToElement(assetTypeArrowButton);
				CommonUtils.wait(2);
			}
			else
			{
				ElementUtils.clickIfDisplayedAndEnabled(30, 1, assetTypeArrowButton);
			}
			
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, assetType, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, assetType, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS, assetType).click();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void selectAssetStatus(String assetStatus)
	{
		try
		{
			if(DriverManager.getDriverName().equals("iOS"))
			{
				DriverManager.getDriver().findElement(MobileBy.AccessibilityId(assetStatus)).click();
			}
			else if(DriverManager.getDriverName().equals("Android"))
			{
				CommonUtils.getElementByUsingVisibleText(assetStatus).click();

			}
			CommonUtils.wait(2);
			saveButton.click();
			CommonUtils.wait(2);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void selectAssetName(String assetName)
	{
		if(DriverManager.getDriverName().equals("iOS"))
		{
			DriverManager.getDriver().findElement(MobileBy.AccessibilityId(assetName)).click();
		}
		else if(DriverManager.getDriverName().equals("Android"))
		{
			DriverManager.getDriver().findElement(MobileBy.id("com.fluke.deviceApp:id/check_box")).click();
		}
	}
}
