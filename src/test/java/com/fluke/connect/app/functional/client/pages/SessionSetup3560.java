package com.fluke.connect.app.functional.client.pages;

import org.openqa.selenium.WebElement;
import com.fluke.connect.app.testdata.FCCM;
import com.fluke.connect.app.testdata.FCCM3560;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.FileUtil;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.PropertiesFileType;
import com.fluke.connect.app.utils.Config.ScrollDiection;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SessionSetup3560 extends SessionSetupPage
{
	@AndroidFindBy(id = "gateway_name")
	@iOSXCUITFindBy(id = "Fluke 3561FC Sensors")
	private WebElement fluke3561FCSensorsStaticText;
	
	@AndroidFindBy(id = "start_setup_button")
	@iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH 'START'")
	private WebElement startSessionSetupButton;
	
	@AndroidFindBy(id = "continue_button")
	@iOSXCUITFindBy(iOSNsPredicate = "name CONTAINS 'CONTINUE'")
	private WebElement continueButton;
	
	@AndroidFindBy(id = "continue_btn")
	@iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH 'CONTINUE'")
	private WebElement otherContinueButton;
	
	@AndroidFindBy(id = "saveB")
	@iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH 'CONTINUE'")
	private WebElement continueButton1;
	
	@AndroidFindBy(id = "remote_monitoring_btn_layout")
	@iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH 'CONTINUE'")
	private WebElement assignMachineCategoryContinueButton;
	
	@AndroidFindBy(id = "dialog_ok")
	private WebElement permissionAlertOkButton;
	
	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	private WebElement alertAllowButton;
	
	@AndroidFindBy(id = "template_edit")
	private WebElement templateInfoButton;
	
	@AndroidFindBy(id = "wifi_name_view")
	private WebElement networkSSIDField;
	
	@AndroidFindBy(id = "wifi_password_view")
	private WebElement networkPasswordField;
	
	@AndroidFindBy(id = "save_template")
	private WebElement saveButton;
	
	@AndroidFindBy(id = "wifi_name")
	private WebElement wifiName;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().textStartsWith(\"CONTINUE WITH\")")
	@iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH 'CONTINUE WITH'")
	private WebElement continueWithSensorsButton;
	
	@AndroidFindBy(id = "machine_category_title")
	@iOSXCUITFindBy(accessibility = "Machine Category")
	private WebElement assignMachineCategoryButton;
	
	@AndroidFindBy(id = "assign_asset")
	@iOSXCUITFindBy(iOSNsPredicate = "name == 'ASSIGN ASSET OR TEST POINT'")
	private WebElement assignAssetOrTestPointButton;
	
	@iOSXCUITFindBy(accessibility = "OK￼")
	private WebElement gatewayProvisionOKButton;
	
	@AndroidFindBy(id = "save_continue_btn")
	@iOSXCUITFindBy(iOSNsPredicate = "name CONTAINS 'CONTINUE'")
	private WebElement saveAndContinueButton;
	
	@AndroidFindBy(id = "started_time_and_name")
	@iOSXCUITFindBy(accessibility = "sessionStartTime")
	private WebElement sessionStartTimeStaticText;
	
	@AndroidFindBy(id = "gateway_name")
	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Gateway Name'")
	private WebElement gatewayNameStaticText;
	
	@AndroidFindBy(id = "goto_home_screen_button")
	@iOSXCUITFindBy(accessibility = "Home")
	private WebElement goToHomeScreenButton;
	
	@AndroidFindBy(id = "start_remote_monitoring")
	@iOSXCUITFindBy(accessibility="START MONITORING")
	private WebElement startMonitoringButton;
	
	@iOSXCUITFindBy(accessibility="backBarButton")
	private WebElement backButton;
	
	@AndroidFindBy(id = "save_continue_btn")
	@iOSXCUITFindBy(accessibility="SAVE & CONTINUE")
	private WebElement step2ContinueButton;
	
	@AndroidFindBy(id = "start_remote_monitoring")
	@iOSXCUITFindBy(accessibility="INSTALL SENSORS")
	private WebElement installSensorsButton;
	
	@AndroidFindBy(id = "dialog_ok")
	@iOSXCUITFindBy(accessibility="OK")
	private WebElement instructionsOkButton;
	
	@AndroidFindBy(id = "finish_setup")
	@iOSXCUITFindBy(accessibility="FINISH SETUP")
	private WebElement finishSetupButton;
	
	@AndroidFindBy(id = "dialog_cancel")
	@iOSXCUITFindBy(accessibility="Yes")
	private WebElement finishSetupYesButton;
	
	@AndroidFindBy(id = "default_meas")
	@iOSXCUITFindBy(accessibility = "Default Measurement Unit")
	private WebElement defaultMeasurementUnitCell;
	
	@AndroidFindBy(id = "default_temp_unit")
	@iOSXCUITFindBy(accessibility = "Temperature Unit")
	private WebElement defaultTempratureUnitCell;
	
	@AndroidFindBy(id = "checkbox_custom_alarm")
	@iOSXCUITFindBy(accessibility = "Custom Vibration/Temperature Alarms")
	private WebElement customAlarmCheckbox;
	
	@AndroidFindBy(id = "checkbox_fovs")
	@iOSXCUITFindBy(accessibility = "Fluke Automated Vibration Alarms")
	private WebElement fovsAlarmCheckbox;
	
	@AndroidFindBy(id = "admin_check_box")
	@iOSXCUITFindBy(accessibility = "Team Administrators")
	private WebElement teamAdminAlarmRecipientCheckbox;
	
	//BUG_AUTOMATION
	@AndroidFindBy(id = "action_bar_title")
	private WebElement title;
	
	@AndroidFindBy(id = "dialog_title")
	private WebElement networkError;
	
	@AndroidFindBy(id = "dialog_title")
	private WebElement gatewayProvisionedError;
	
	@AndroidFindBy(id = "dialog_title")
	private WebElement sensorProvisionedError;
	
    @AndroidFindBy(id = "continue_with_sensors")
	private WebElement continueButtonInSensorSelectionScreen;
    
    @AndroidFindBy(id = "remove_sensor_button")
	private WebElement removeSensorButton;
    
    @AndroidFindBy(id = "dialog_ok")
	private WebElement deleteButton;
    
    @AndroidFindBy(id = "start_remote_monitoring")
	private WebElement installSensors;
    
    @AndroidFindBy(id = "tv_sensor_status")
	private WebElement sensorStatus;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().textStartsWith(\"Installation Details\")")
	private WebElement installationDetails;
    
    @AndroidFindBy(id = "tv_fix_connection")
	private WebElement fixConnection;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().textStartsWith(\"REMOVE THIS SENSOR\")")
	private WebElement removeSensors;
    
    @AndroidFindBy(id = "finish_setup")
	private WebElement finishSetup;
    
    @AndroidFindBy(id = "dialog_title")
	private WebElement completeInstallation;
	//
	private GestureUtils gestureUtils;
	
	public SessionSetup3560()
	{
		CommonUtils.initElements(this);
		gestureUtils = new GestureUtils();
	}

	public boolean isGatewayProvisioned(String gatewayName, String networkName, ScrollDiection scrollDirection) throws Exception
	{
		selectGateway(gatewayName, scrollDirection);
		selectNetwork(networkName, scrollDirection);
		return ElementUtils.isDisplayed(120, fluke3561FCSensorsStaticText);
	}
	
	public void selectGateway(String gatewayName, ScrollDiection scrollDirection) throws Exception
	{
		ElementUtils.click(10, startSessionSetupButton);
		ElementUtils.click(10, continueButton);
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			ElementUtils.click(10, permissionAlertOkButton);
			ElementUtils.click(10, alertAllowButton);
			ElementUtils.safeClick(3, permissionAlertOkButton);
		}
		if(ElementUtils.isDisplayed(180, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, gatewayName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, gatewayName, null, null))
		{
			CommonUtils.wait(2);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, gatewayName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, gatewayName, null, null).click();
		}
	}
	
	public void selectNetwork(String networkName, ScrollDiection scrollDirection) throws Exception
	{
		if(ElementUtils.isDisplayed(180, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, networkName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, networkName, null, null))
		{
			CommonUtils.wait(2);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, networkName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, networkName, null, null).click();
		}
		else
		{
			gestureUtils.mScroll(networkName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, networkName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, networkName, null, null).click();
		}
		ElementUtils.click(180, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "button_ok", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "OK", null, null);	
	}
	
	public boolean isSensorProvisioned(String[] sensorName, ScrollDiection scrollDirection) throws Exception
	{
		selectSensor(sensorName, scrollDirection);
		continueWithSensorsButton.click();
		CommonUtils.wait(3);
		ElementUtils.click(180, continueButton);
		return ElementUtils.isDisplayed(180, assignAssetOrTestPointButton);
	}
	
	public void selectSensor(String[] sensorName, ScrollDiection scrollDirection)
	{
		if(ElementUtils.isDisplayed(10, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, sensorName[0], LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, sensorName[0], null, null))
		{
			CommonUtils.wait(2);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, sensorName[0], LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, sensorName[0], null, null).click();
		}
		else
		{
			gestureUtils.mScroll(sensorName[0], LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, scrollDirection);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, sensorName[0], LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, sensorName[0], null, null).click();
		}
	}
	
	public void assignMachineCategory(String machineCategoryName) throws Exception
	{
		gestureUtils.mScroll(machineCategoryName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.click(10, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, machineCategoryName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, machineCategoryName, null, null);
		teamAdminAlarmRecipientCheckbox.click();
		continueButton.click();
	}
	
	public boolean isMonitoringStarted() throws Exception
	{
		startMonitoring();
		boolean flag = ElementUtils.isDisplayed(60, sessionStartTimeStaticText);
		captureSessionTimestamp(Config.getPropertiesFilePath(PropertiesFileType.FCCM_PROPERTIES));
		goToHomeScreenButton.click();
		CommonUtils.wait(30);
		return flag;
	}
	
	public void startMonitoring() throws Exception
	{
		continueButton1.click();
		step2ContinueButton.click();
		installSensorsButton.click();
		instructionsOkButton.click();
		finishSetupButton.click();
		finishSetupYesButton.click();
	}
	
	public String getSessionStartTime()
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			return sessionStartTimeStaticText.getText();
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			return sessionStartTimeStaticText.getText().substring(0, sessionStartTimeStaticText.getText().indexOf(" |")+2);
		return null;
	}
	
	public void captureSessionTimestamp(String propertiesFilePath)  //Config.FCCM_PROPERTIES_FILE_PATH
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			FileUtil.writeProperty(propertiesFilePath, FCCM3560.androidSessionStartTimestamp, getSessionStartTime());
			FileUtil.writeProperty(propertiesFilePath, FCCM3560.iOSSessionStartTimestamp, "null");
			FileUtil.writeProperty(propertiesFilePath, FCCM3560.androidGatewayName, gatewayNameStaticText.getText());
			FileUtil.writeProperty(propertiesFilePath, FCCM3560.iOSGatewayName, "null");	
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			FileUtil.writeProperty(propertiesFilePath, FCCM3560.androidSessionStartTimestamp, "null");
			FileUtil.writeProperty(propertiesFilePath, FCCM3560.iOSSessionStartTimestamp, getSessionStartTime());
			FileUtil.writeProperty(propertiesFilePath, FCCM3560.androidGatewayName, "null");
			FileUtil.writeProperty(propertiesFilePath, FCCM3560.iOSGatewayName, gatewayNameStaticText.getText());
		}
	}
	
	public void selectMeasurementUnit(String measurementUnit, String tempratureUnit)
	{
		defaultMeasurementUnitCell.click();
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, measurementUnit, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, measurementUnit, null, null).click();
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			backButton.click();
		defaultTempratureUnitCell.click();
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, tempratureUnit, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, tempratureUnit, null, null).click();
		saveAndContinueButton.click();
	}
	
	public void selectAlarmType(FCCM.AlarmType alarmType)
	{
		switch(alarmType)
		{
		case FOVS:
			fovsAlarmCheckbox.click();
			break;
		case CUSTOM_VIBRATION_ALARM:
			customAlarmCheckbox.click();
			break;
		default:
				break;
		}
		otherContinueButton.click();
	}
	
	//BUG_AUTOMATION
	public boolean getTextInWiFiSelectionScreen()
	{
		String actualText = title.getText();
		String expectedText = "Connect the Gateway to Wi-Fi";
		if(actualText.equals(expectedText))
		{
			return true;
		}
		return false;
	}
	
	public boolean isNetworkErrorDisplayed() throws Exception
	{
		ElementUtils.click(10, startSessionSetupButton);
		ElementUtils.click(10, continueButton);
		ElementUtils.click(10, permissionAlertOkButton);
		ElementUtils.click(10, alertAllowButton);
		ElementUtils.safeClick(3, permissionAlertOkButton);
		return ElementUtils.isDisplayed(networkError);
	}
	public boolean getSensorText()
	{
		String actual = fluke3561FCSensorsStaticText.getText();
		String expected = "Fluke 3561FC Sensors";
		if(actual.equals(expected))
		{
			return true;
		}
		return false;
	}
	public boolean isNetworkErrorDisplayedAfterSelectingGateway()
	{
		return ElementUtils.isDisplayed(networkError);
	}
	public boolean verifyGatewayProvisionedError()
	{
		String expected = "3502FC Gateway provisioning Error";
		String actual = gatewayProvisionedError.getText();
		if(actual.equals(expected))
		{
			return true;
		}
		return false;
		
	}
	
	public boolean verifySensorProvisionedError()
	{
		String expected = "Sensor Provisioning Error";
		String actual = sensorProvisionedError.getText();
		if(actual.equals(expected))
		{
			return true;
		}
		return false;
		
	}
	public void clickOnContinueButtonInSensorSelection() 
	{
		continueButtonInSensorSelectionScreen.click();
		
	}
	public void clickOnContinueButton() throws Exception
	{
		ElementUtils.click(10, continueButton);
	}
	public void provisionGatewayAndSensor() throws Exception
	{
	    selectGateway(FCCM3560.gatewayNameForProvisioning, ScrollDiection.DOWN);
		selectNetwork(FCCM3560.networkName, ScrollDiection.DOWN);
		selectSensor(FCCM3560.sensorNameForProvisioning, ScrollDiection.DOWN);
	    clickOnContinueButtonInSensorSelection();
		clickOnContinueButton();
        assignAsset(FCCM3560.assetGroupName1, FCCM3560.assetName1, FCCM3560.testPointName1, 0);
		clickOnContinueButton();
		clickOnContinueButton();
		assignMachineCategory(FCCM3560.machineCategoryName);
	}
	public boolean tapOnRemoveSensors()
	{
		removeSensorButton.click();
		deleteButton.click();
		return ElementUtils.isDisplayed(fluke3561FCSensorsStaticText);
	}
	public void tapOnInstallSensor()
	{
		installSensors.click();
		instructionsOkButton.click();
	}
	public boolean checkSensorStatusInVerifyInstallationAndSensorInstallationDetailsScreen()
	{
		String status = sensorStatus.getText();
		clickOnInstallationDetails();
		String status1 = sensorStatus.getText();
		if(status.equals(status1))
		{
			return true;
		}
		return false;
	}
	public void clickOnInstallationDetails()
	{
		installationDetails.click();
	}
	public void clickOnFixConnection()
	{
		fixConnection.click();
	}
	public boolean tapOnRemoveSensorsInFixConnection()
	{
		removeSensors.click();
		instructionsOkButton.click();
		finishSetup.click();
		return ElementUtils.isDisplayed(completeInstallation);
	}
}

    

