package com.fluke.connect.app.functional.client.pages;

import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.fluke.connect.app.testdata.FCCM3550;
import com.fluke.connect.app.testdata.FCCM.AlarmType;
import com.fluke.connect.app.testdata.FCCM.MeasurementUnit;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DateAndTimeUtils;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.FileUtil;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.ScrollDiection;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SessionSetupPage3550 extends SessionSetupPage
{
	@AndroidFindBy(id = "start_setup_button")
	@iOSXCUITFindBy(accessibility = "3550 overview button")
	private WebElement startSetupButton;
	
	@AndroidFindBy(id = "wifi_password_view")
	@iOSXCUITFindBy(accessibility = "WiFi password text field for 3550")
	private WebElement networkPasswordTextfield;
	
	@iOSXCUITFindBy(accessibility = "Done")
	private WebElement networkPasswordKeyboardDoneButton;
	
	@AndroidFindBy(id = "start_setup_button")
	@iOSXCUITFindBy(accessibility = "CONFIGURE THERMAL IMAGING SENSOR")
	private WebElement configureThermalImagingSensorButton;
	
	@AndroidFindBy(id = "alarm_unit_spinner")
	@iOSXCUITFindBy(accessibility = "changeTemperatureUnit")
	private WebElement changeTempratureUnit;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"F\")")
	@iOSXCUITFindBy(iOSNsPredicate = "name LIKE '?F'")
	private WebElement tempratureUnitFahrenheit;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"C\")")
	@iOSXCUITFindBy(iOSNsPredicate = "name LIKE '?C'")
	private WebElement tempratureUnitCelsius;
	
	@AndroidFindBy(id = "save_energy_toggle")
	@iOSXCUITFindBy(accessibility = "aimVisualLight")
	private List<WebElement> energySaveSwitchButton;
	
	@iOSXCUITFindBy(accessibility = "samplingRateSlider")
	private WebElement samplingRateSlider;
	
	@iOSXCUITFindBy(accessibility = "liveStreamCell")
	private WebElement liveStreamImage;
	
	@HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
	@AndroidFindBy(id = "save_continue_btn")
	@iOSXCUITFindBy(accessibility = "saveAndContinue")
	@iOSXCUITFindBy(accessibility = "SAVE & CONTINUE")
	private WebElement saveAndContinueButton;
	
	@AndroidFindBy(id = "start_remote_monitoring")
	@iOSXCUITFindBy(accessibility = "START REMOTE MONITORING")
	private WebElement startRemoteMonitoringButton;
	
	@AndroidFindBy(id = "goto_home_screen_button")
	@iOSXCUITFindBy(accessibility = "Home")
	private WebElement goToHomeScreenButton;
	
	@AndroidFindBy(id = "config_existing_sensors")
	@iOSXCUITFindBy(iOSNsPredicate = "value CONTAINS 'Existing'")
	private WebElement configureExistingSensor;
	
	@AndroidFindBy(id = "config_new_sensor")
	@iOSXCUITFindBy(iOSNsPredicate = "value CONTAINS 'New'")
	private WebElement configureNewSensor;
	
	@AndroidFindBy(id = "connect_fluke_cloud")
	@iOSXCUITFindBy(accessibility = "CONNECT TO FLUKE CONNECT CLOUD")
	private WebElement connectToFCCloud;
	
	@AndroidFindBy(id = "add_alarm_text")
	@iOSXCUITFindBy(iOSNsPredicate = "name ENDSWITH 'alarm'")
	private WebElement addTempratureAlarmButton;
	
	@AndroidFindBy(id = "saveB")
	@iOSXCUITFindBy(accessibility = "SKIP")
	private WebElement addAlarmSaveAndContinueButton;
	
	@AndroidFindBy(id = "dialog_ok")
	private WebElement androidPermissionOkButton;
	
	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	private WebElement androidPermissionAllowButton;
	
	@AndroidFindBy(id = "button_3")
	@iOSXCUITFindBy(accessibility = "Cancel")
	private WebElement licenseErrorCancelButton; 
	
	@AndroidFindBy(id = "started_time_and_name")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name = 'Start Time']/following-sibling::XCUIElementTypeStaticText")
	private WebElement sessionStartTime;
	
	private AssetsPage assetPage;
	private GestureUtils gestureUtils;
	private AlarmPage alarmPage;
	Switcher switcher;

	public SessionSetupPage3550()
	{
		CommonUtils.initElements(this, 10);
		assetPage = new AssetsPage();
		gestureUtils = new GestureUtils();
		alarmPage = new AlarmPage();
		switcher = new Switcher();
	}
	
		public void selectSensor3550(String sensorName, boolean newSensor, boolean isFirstSession) throws Exception 
		{
			ElementUtils.clickIfDisplayedAndEnabled(30, 1, startSetupButton);
			if(!isFirstSession)
			{
				if(newSensor)
					configureNewSensor.click();
				else
					configureExistingSensor.click();
			}
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				androidPermissionOkButton.click();
				androidPermissionAllowButton.click();
			}
			if(ElementUtils.isDisplayed(30, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, sensorName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, sensorName, null, null))
			{
				CommonUtils.wait(5);
				ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, sensorName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, sensorName, null, null).click();
			}
			else
			{
				gestureUtils.mScroll(sensorName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
				ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, sensorName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, sensorName, null, null).click();
			}
		}
		
		public void selectNetwork3550(String networkName, String password) throws Exception
		{
			if(ElementUtils.isDisplayed(180, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, networkName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, networkName, null, null))
				ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, networkName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, networkName, null, null).click();
			else
			{
				gestureUtils.mScroll(networkName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
				ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, networkName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, networkName, null, null).click();
			}
			if(!networkPasswordTextfield.isDisplayed())
				throw new Exception();
			networkPasswordTextfield.clear();
			ElementUtils.sendKeys(networkPasswordTextfield, password);
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				networkPasswordKeyboardDoneButton.click();
			connectToFCCloud.click();
		}
		
		public void configureThermalImagingSensors(String samplingRate, MeasurementUnit measurementUnit, boolean energySaveMode) throws Exception
		{
			ElementUtils.clickIfDisplayedAndEnabled(180, 1, configureThermalImagingSensorButton);
			changeTempratureUnit.click();
			switch(measurementUnit)
			{
			case FAHRENHEIT:
				tempratureUnitFahrenheit.click();
				break;
			case CELSIUS:
				tempratureUnitCelsius.click();
				break;
				default:
					tempratureUnitFahrenheit.click();
			}
			if(energySaveMode)
				energySaveSwitchButton.get(1).click();
			gestureUtils.mScroll(-75, -100, 1);
			switch(samplingRate)
			{
			case FCCM3550.ONE_MIN:
				gestureUtils.swipe(ScrollDiection.LEFT, samplingRateSlider, 50);
				FileUtil.writeProperty(Config.FCCM_PROPERTIES_FILE_PATH, FCCM3550.SAMPLING_RATE, FCCM3550.ONE_MIN);
				break;
			case FCCM3550.FIVE_MIN:
				FileUtil.writeProperty(Config.FCCM_PROPERTIES_FILE_PATH, FCCM3550.SAMPLING_RATE, FCCM3550.FIVE_MIN);
				break;
			case FCCM3550.TEN_MIN:
				FileUtil.writeProperty(Config.FCCM_PROPERTIES_FILE_PATH, FCCM3550.SAMPLING_RATE, FCCM3550.TEN_MIN);
				break;
			case FCCM3550.THIRTY_MIN:
				FileUtil.writeProperty(Config.FCCM_PROPERTIES_FILE_PATH, FCCM3550.SAMPLING_RATE, FCCM3550.THIRTY_MIN);
				break;
			case FCCM3550.SIXTY_MIN:
				FileUtil.writeProperty(Config.FCCM_PROPERTIES_FILE_PATH, FCCM3550.SAMPLING_RATE, FCCM3550.SIXTY_MIN);
				break;
			case FCCM3550.TWELE_HOUR:
				FileUtil.writeProperty(Config.FCCM_PROPERTIES_FILE_PATH, FCCM3550.SAMPLING_RATE, FCCM3550.TWELE_HOUR);
				break;
			case FCCM3550.TWENTY_FOUR_HOUR:
				FileUtil.writeProperty(Config.FCCM_PROPERTIES_FILE_PATH, FCCM3550.SAMPLING_RATE, FCCM3550.TWENTY_FOUR_HOUR);
				break;
			}
			CommonUtils.wait(7);
			saveAndContinueButton.click();
		}
		
		public void assignAsset3550(String assetGroupName, String assetName, String testPointName, int androidTestPointIndex) throws Exception 
		{
			/*
			assetPage.clickOnAssetGroupName(assetGroupName);
			assetPage.clickOnAssetName(assetName);
			deleteTestPoint(testPointName);
			CommonUtils.wait(2);
			addTestPoint();
			assetPage.clickOnAssetName(assetName);
			assetPage.selectAssetTestPoint(testPointName, androidTestPointIndex);
			 */
			assetPage.assignAsset(assetGroupName, assetName, testPointName, androidTestPointIndex);
			saveAndContinueButton.click();
		}
		
		public void addAlarm(AlarmType alarmType, String unit, int upperRange, int lowerRange, ScrollDiection unitScrollDirection)
		{
			CommonUtils.wait(1);
			addTempratureAlarmButton.click();
			//alarmPage.addAlarm(alarmType, unit, upperRange, lowerRange, unitScrollDirection, 1);
			FileUtil.writeProperty(Config.FCCM_PROPERTIES_FILE_PATH, "FCCM3550 Alarm Type", alarmType.toString());
			FileUtil.writeProperty(Config.FCCM_PROPERTIES_FILE_PATH, "FCCM3550 Alarm Unit", unit.toString());
			FileUtil.writeProperty(Config.FCCM_PROPERTIES_FILE_PATH, "FCCM3550 Alarm Upper Range", String.valueOf(upperRange));
			FileUtil.writeProperty(Config.FCCM_PROPERTIES_FILE_PATH, "FCCM3550 Alarm Lower Range", String.valueOf(lowerRange));
		}
		
		public void startRemoteMonitoring3550() throws ParseException
		{
			String requiredTime;
			String tempSessionStartTime = new String();
			addAlarmSaveAndContinueButton.click();
			startRemoteMonitoringButton.click();
			FileUtil.writeProperty(Config.FCCM_PROPERTIES_FILE_PATH, "FCCM3550 Session Created From", DriverManager.getDriverName());
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				FileUtil.writeProperty(Config.FCCM_PROPERTIES_FILE_PATH, FCCM3550.androidSessionStartTimestamp, sessionStartTime.getText().substring(0, sessionStartTime.getText().indexOf(" |") + 2));
				FileUtil.writeProperty(Config.FCCM_PROPERTIES_FILE_PATH, FCCM3550.iOSSessionStartTimestamp, "null");
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				tempSessionStartTime = sessionStartTime.getText();
				requiredTime = DateAndTimeUtils.getDateAsAString(tempSessionStartTime.split(" ")[1] + " " + tempSessionStartTime.split(" ")[2], "hh:mm a", "HH:mm");
				FileUtil.writeProperty(Config.FCCM_PROPERTIES_FILE_PATH, FCCM3550.iOSSessionStartTimestamp, tempSessionStartTime.split(" ")[0] + ", "+requiredTime);
				FileUtil.writeProperty(Config.FCCM_PROPERTIES_FILE_PATH, FCCM3550.androidSessionStartTimestamp, "null");
			}
			goToHomeScreenButton.click();
		}
		
		public void configureAsset(String assetGroupName, String assetName, String assetType, String assetStatus) throws Exception
		{
			switcher.switchToAssetsPage();
			assetPage.clickOnAssetGroupName(assetGroupName);
			assetPage.deleteAsset(assetName);
			assetPage.addAsset(assetName, assetType, assetStatus);
			assetPage.clickOnBackButton();
			switcher.switchToHomePage();
		}
}
