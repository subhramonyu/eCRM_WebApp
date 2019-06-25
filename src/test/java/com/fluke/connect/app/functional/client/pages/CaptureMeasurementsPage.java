package com.fluke.connect.app.functional.client.pages;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.fluke.connect.app.functional.client.pages.MeasurementDetailPage.MeasurementDetailPageObjects;
import com.fluke.connect.app.testdata.FCM;
import com.fluke.connect.app.testdata.FCM.DataType;
import com.fluke.connect.app.testdata.FCM.MeasurementType;
import com.fluke.connect.app.testdata.FCM.ShareFormat;
import com.fluke.connect.app.utils.AndroidUtils;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DeviceUtils;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.ScrollDiection;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

import java.time.temporal.ChronoUnit;
import java.util.List;

public class CaptureMeasurementsPage 
{	
	@AndroidFindBy(id = "capture_measurements_text")
	private WebElement captureMeasurementsLink;
	
	@AndroidFindBy(id = "wifi_settings")
	private WebElement goToSettingsLink;
	
	@AndroidFindBy(id = "capture_button_container")
	@iOSXCUITFindBy(iOSNsPredicate =  "label == 'SAVE' OR label == 'Save'")
	private WebElement captureMeasurementSaveButton;
	
	@iOSXCUITFindBy(accessibility = "Use wifi to connect to these tools:")
	private WebElement connectInfoMessage;
	
	@AndroidFindBy(id = "fluke_small_logo")
	@iOSXCUITFindBy(accessibility = "Home")
	private WebElement backButton;
	
	@AndroidFindBy(id = "fluke_small_logo")
	@iOSXCUITFindBy(accessibility = "Back")
	private WebElement backButton1;
	
	@AndroidFindBy(id = "back_button")
	@iOSXCUITFindBy(accessibility = "Save")
	private WebElement backButton2;
	
	@AndroidFindBy(id = "numeric_button")
	private WebElement numericButton;
	
	@AndroidFindBy(id = "graph_button")
	@iOSXCUITFindBy(accessibility="Display Mode")
	private WebElement graphButton;
	
	@AndroidFindBy(id = "com.fluke.deviceApp:id/record_button")
	@iOSXCUITFindBy(accessibility = "Start recording")   
	private WebElement startRecordingButton;	
	
	@AndroidFindBy(id = "com.fluke.deviceApp:id/record_button")
	@iOSXCUITFindBy(accessibility = "Stop recording")
	private WebElement stopRecordingButton;
	
	@AndroidFindBy(id = "device_name")
	@iOSXCUITFindBy(accessibility="device name")
	private WebElement deviceName;
	
	//Android capture measurement permission objects
	@AndroidFindBy(id = "com.fluke.deviceApp:id/dialog_ok")
	private WebElement androidLocationPermissionOkButton;
	
	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	private WebElement androidPermissionAllowButton;
	
	//@AndroidFindBy(id = "android:id/button1")
	@AndroidFindBy(id = "android:id/dialog_ok")
	private WebElement androidEnableLocationServicesOkButton;
	
	@AndroidFindBy(id = "wifi_info_close")
	private WebElement androidWiFiInfoCloseButton;
	
	//manual measurement object
	@iOSXCUITFindBy(accessibility = "Add manual measurement")
	@AndroidFindBy(id = "clipboard_image")
	private WebElement manualMeasurementButton;
	
	@AndroidFindBy(id = "value")
	private WebElement manualMeasurementValueTextField;
	
	@HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
	@iOSXCUITFindBy(accessibility = "Next")
	@iOSXCUITFindBy(accessibility = "NEXT")
	@AndroidFindBy(id = "action_textview")
	private WebElement manualMeasurementNextButton;
	
	@AndroidFindBy(id = "value_unit")   
	private WebElement manualMeasurementUnitTextField;
	
	@iOSXCUITFindBy(accessibility ="Done")
	@AndroidFindBy(id = "action_textview")   
	private WebElement manualMeasurementDoneButton;
	
	//camera measurement objects
	@AndroidFindBy(id = "camera_image")
	@iOSXCUITFindBy(accessibility = "Add camera")
	private WebElement cameraButton;
	
	@AndroidFindBy(id = "close")
	private WebElement cameraCloseButton;
	
	//Capture measurements --> Beaker --> Compensate for Temperature
	@iOSXCUITFindBy(accessibility = "Compensate for Temperature:")
	private WebElement beakerAddTempratureButton;
	
	//capture measurement --> tap device --> measurement unit label
	@iOSXCUITFindBy(accessibility = "unitLabel")
	private WebElement unitLabelStaticText;
	
	//Capture measurement --> Manual Measurement --> Enter Value static label
	@iOSXCUITFindBy(accessibility = "ENTER VALUE")
	private WebElement enterValueStaticText;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='added date']")
	private WebElement after_date_time;
	
	@iOSXCUITFindBy(accessibility = "Device info")
	private WebElement deviceInfoButton;
	
	//Capture Measurements --> Fluke Connect logo
	@AndroidFindBy(id = "discover_image")
	@iOSXCUITFindBy(accessibility = "Add device")
	private WebElement addDeviceButton;
	
	//Capture Measurements --> Tap on device --> sharelive call button at bottom right
	@AndroidFindBy(id = "discover_image")
	@iOSXCUITFindBy(accessibility = "Make Sharelive call")
	private WebElement shareliveCallButton;
	
	@AndroidFindBy(id="back_button")  
	@iOSXCUITFindBy(accessibility = "Done")
	private WebElement doneButton;
	
	@AndroidFindBy(id = "com.fluke.deviceApp:id/capture_button")    
	@iOSXCUITFindBy(accessibility = "Save")
	private WebElement saveButton;
	
	@AndroidFindBy(id = "back_button")    
	@iOSXCUITFindBy(accessibility = "Save")
	private WebElement saveButton1;
	
	@AndroidFindBy(id = "com.fluke.deviceApp:id/close")
	@iOSXCUITFindBy(accessibility = "Disconnect device")
	private WebElement disconnectDeviceButton;
	
	@HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
	@AndroidFindBy(id = "logging_link")
	@iOSXCUITFindBy(accessibility = "Device info")
	@iOSXCUITFindBy(accessibility = "Download")
	private WebElement loggingButton;
	
	@AndroidFindBy(id = "logging_memory_clear")
	@iOSXCUITFindBy(accessibility = "Clear")
	private List<WebElement> clearLogButton;
	
	@AndroidFindBy(id = "start_logging_btn")
	@iOSXCUITFindBy(accessibility = "Start Log")
	private WebElement startLoggingButton;
	
	@AndroidFindBy(id = "stop_logging_btn")
	@iOSXCUITFindBy(accessibility = "Start Log")
	private WebElement stopLoggingButton;

	@AndroidFindBy(id = "download_logging_btn")
	@iOSXCUITFindBy(accessibility = "Download")
	private WebElement downloadLogButton;
	
	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(id = "logging_setup_done")
	@AndroidFindBy(id = "device_logging_done")
	@iOSXCUITFindBy(accessibility = "Done")
	private WebElement loggingSetupDoneButton;
	
	@AndroidFindBy(id = "logging_interval_minutes")
	@iOSXCUITFindBy(accessibility = "Interval Minutes")
	private WebElement loggingIntervalInMinutesTextField;
	
	@AndroidFindBy(id = "logging_interval_seconds")
	@iOSXCUITFindBy(accessibility = "Interval Seconds")
	private WebElement loggingIntervalInSecondsTextField;
	
	@AndroidFindBy(id = "duration_toggle")
	@iOSXCUITFindBy(accessibility = "Stop Manually Switch")
	private WebElement durationToggleButton;
	
	@AndroidFindBy(id = "logging_duration_days")
	@iOSXCUITFindBy(accessibility = "Duration Days")
	private WebElement loggingDurationInDaysTextField;
	
	@AndroidFindBy(id = "logging_duration_hours")
	@iOSXCUITFindBy(accessibility = "Duration Hours")
	private WebElement loggingDurationInHoursTextField;
	
	@AndroidFindBy(id = "logging_duration_minutes")
	@iOSXCUITFindBy(accessibility = "Duration Minutes")
	private WebElement loggingDurationInMinutesTextField;
	
	@AndroidFindBy(id = "logging_interval_val")
	@iOSXCUITFindBy(accessibility = "Set Interval")
	private WebElement loggingDurationSetupButton;
	
	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(id = "button1")
	@AndroidFindBy(id = "dialog_ok")
	@iOSXCUITFindBy(accessibility = "OK")
	private WebElement downloadLogOkButton;
	
	@AndroidFindBy(id = "dialog_ok")
	@iOSXCUITFindBy(accessibility = "Delete")
	private WebElement clearLogDeleteConfirmationButton;
	
	@WithTimeout(chronoUnit = ChronoUnit.SECONDS, time = 3)
	@AndroidFindBy(id = "dialog_ok")
	@iOSXCUITFindBy(accessibility = "OK")
	private WebElement downloadLogAcceptConfirmationButton;
	
	@AndroidFindBy(id = "button2")
	@iOSXCUITFindBy(accessibility = "Cancel")
	private WebElement downloadLogCancelButton;
	
	@AndroidFindBy(id = "dialog_ok")
	private WebElement captureMeasurementPermissionOkButton;
	
	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	private WebElement captureMeasurementPermissionAllowButton;
	
	@AndroidFindBy(id = "android:id/button1")
	private WebElement captureMeasurementLocationOkButton;
	
	@AndroidFindBy(id = "close")
	private WebElement measurementHistoryAssetPromptCloseButton;
	
	@AndroidFindBy(uiAutomator="new UiSelector().textContains(\"FLUKE125B\")")
	private WebElement fluke125BToolInCaptureScreen;
	
	@AndroidFindBy(uiAutomator="new UiSelector().textContains(\"FLUKE1738\")")
	@iOSXCUITFindBy(accessibility = "Aron Button")
	private WebElement fluke173XToolInCaptureScreen;
	
	//@AndroidFindBy(uiAutomator="new UiSelector().textContains(\"FLUKE1738\")")
	@iOSXCUITFindBy(accessibility = "Fluke 430-II <19423106>")
	private WebElement fluke437InCaptureScreen;
	
	@AndroidFindBy(id = "device_name")
	private WebElement toolNameAfterConnectingToTool;
	
	@AndroidFindBy(id = "capture_date_time")
	private WebElement capture_date_time;
	
	@AndroidFindBy(id = "close")
    private WebElement assignAssetCoachMarkClose;
	
	@AndroidFindBy(id = "imager_placeholder_for_capture_screen")
	@iOSXCUITFindBy(className = "XCUIElementTypeCell")
	private WebElement measurementObject;
	
	@AndroidFindBy(id = "thermal_show_remote_button")
	@iOSXCUITFindBy(accessibility = "remotecontrol")
	private WebElement tiRempteControlButton;
	
	@AndroidFindBy(id = "thermal_download_button")
	@iOSXCUITFindBy(accessibility = "download from camera")
	private WebElement tiDownloadButton;
	
	@AndroidFindBy(id = "thermal_capture_button")
	@iOSXCUITFindBy(accessibility = "Capture")
	private WebElement tiCaptureButton;
	
	@AndroidFindBy(id = "android:id/button1")
	@iOSXCUITFindBy(accessibility = "Save")
	private WebElement tiSaveButton;
	
	@AndroidFindBy(id = "menu_share")
	@iOSXCUITFindBy(accessibility = "Share")
	private WebElement shareButton;
	
	@AndroidFindBy(id = "download")
	@iOSXCUITFindBy(accessibility = "Download")
	private WebElement downloadTIImagesButtonInMeasurementCell;
	
	@AndroidFindBy(id = "btn_download_some")
	@iOSXCUITFindBy(accessibility = "Select Images to Download")
	private WebElement selectImagesToDownloadButton;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"/\")")
	@iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH 'IR'")
	private List<WebElement> imageDownloadList;
	
	@AndroidFindBy(id = "action_bar_item_menu_icon")
	@iOSXCUITFindBy(accessibility = "DOWNLOAD")
	private WebElement downloadSelectedTIImagesButton;
	
	@AndroidFindBy(id = "dialog_ok")
	@iOSXCUITFindBy(accessibility = "OK")
	private WebElement tiImageDownloadOkButton;
	
	@AndroidFindBy(id = "dialog_cancel")
	@iOSXCUITFindBy(accessibility = "Not now")
	private WebElement tiImageDownloadNotNowButton;
	
	@AndroidFindBy(id = "btn_cancel")
	@iOSXCUITFindBy(accessibility = "Cancel")
	private WebElement downloadTIImagesCancelButton;
	
	@AndroidFindBy(id = "rescan_button")
	private WebElement androidDeviceScanButton;
	
	@AndroidFindBy(id = "capture_device_layout")
	private WebElement liveValueCell;
	
	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeCell' AND name CONTAINS ','")
	private WebElement measurementCellObject;
	
	@iOSXCUITFindBy(accessibility = "Next")
	private WebElement shareCNXLogNextButton;
	
	@iOSXCUITFindBy(accessibility = "Delete")
	private WebElement cnxLogDeleteButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='valueLabel']")
	public List<WebElement> scalarmeasurement;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='valueLabel']")
	public WebElement scalarmeasurement1;
	
	@AndroidFindBy(id = "com.fluke.deviceApp:id/download_button")
	private WebElement download1664Button;

	@AndroidFindBy(id = "com.fluke.deviceApp:id/clear_memory_button")
	private WebElement clear1664Button;

	@AndroidFindBy(id = "com.fluke.deviceApp:id/hudson_memory_value")
	private WebElement memoryvalue;

	@AndroidFindBy(id = "com.fluke.deviceApp:id/measurement_date")
	private WebElement measurementDate;
	
	@AndroidFindBy(id = "com.fluke.deviceApp:id/download_layout")
	private WebElement downloadLayout;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[contains(@name,'376FC')]")
	public List<WebElement> fc376Download ;//XCUIElementTypeCell[@name="Grouped
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[contains(@name,'Grouped')]")
	public WebElement Grouped ;
	
	@iOSXCUITFindBy(accessibility = "Actions")
	public WebElement action ;
	
	@iOSXCUITFindBy(id = "Permanently delete measurement?")
	public WebElement permanentlyDelete ;
	
	@WithTimeout(time = 5, chronoUnit = ChronoUnit.SECONDS)
	@AndroidFindBy(id = "button")
	@iOSXCUITFindBy(accessibility = "next")	
	private  WebElement gotItButton;

	private GestureUtils gestureUtils;
	private Switcher switcher;
	private DeviceUtils phoneSettingsPage;
	private MeasurementDetailPage measurementDetailPage;
	private WebElement mTIDownloadButton;
	
	public CaptureMeasurementsPage()
	{
		CommonUtils.initElements(this, 3);
		gestureUtils = new GestureUtils();
		phoneSettingsPage = new DeviceUtils();
		measurementDetailPage = new MeasurementDetailPage();
		mTIDownloadButton = null;
    }
	
	public enum CaptureMeasurementsPageObject
	{
		TI_IMAGES_DOWNLOAD_BUTTON, BACK_BUTTON, SAVE_BUTTON, DISCONNECT_DEVICE, LIVE_VALUE_CELL, LOGGING_BUTTON, GOT_IT_BUTTON
	}
	
	public WebElement getCaptureMeasurementsPageObject(CaptureMeasurementsPageObject objectName)
	{
		switch(objectName)
		{
		case TI_IMAGES_DOWNLOAD_BUTTON:
			return downloadTIImagesButtonInMeasurementCell;
		case BACK_BUTTON:
			return backButton1;
		case SAVE_BUTTON:
			return saveButton1;
		case DISCONNECT_DEVICE:
			return disconnectDeviceButton;
		case LIVE_VALUE_CELL:
			return liveValueCell;
		case LOGGING_BUTTON:
			return loggingButton;
		case GOT_IT_BUTTON:
			return gotItButton;
			default:
				return null;
		}
	}

	public void connectToRealDevice(String deviceName) throws Exception 
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			androidDeviceScanButton.click();
			ElementUtils.safeClick(androidWiFiInfoCloseButton);
		}
		gestureUtils.mScroll(deviceName, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		gestureUtils.mScroll(-100, -100, 1);
		CommonUtils.wait(5);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_STARTS_WITH, deviceName, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_BEGINSWITH, deviceName, null, null).click();
	}
	
	public void connectToSimulatedDevice(String deviceName) throws Exception 
	{
		CommonUtils.wait(2);
		gestureUtils.mScroll(deviceName, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		CommonUtils.wait(2);
		gestureUtils.mScroll(-100, -100, 1);
		CommonUtils.wait(3);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_STARTS_WITH, deviceName, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, deviceName, null, null).click();
		ElementUtils.isDisplayed(3, shareliveCallButton);
	} 
	
	public void connectToDevice(String iOSdeviceName, String androidDeviceName, LocatorStrategy iOSLocatorStrategy, LocatorStrategy androidLocatorStrategy) throws Exception 
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			ElementUtils.click(1, androidDeviceScanButton);
		CommonUtils.wait(10, 5, 0);
		gestureUtils.mScroll(androidDeviceName, iOSdeviceName, iOSLocatorStrategy, androidLocatorStrategy, ScrollDiection.DOWN);
		CommonUtils.wait(5);
		ElementUtils.getElement(androidLocatorStrategy, androidDeviceName, iOSLocatorStrategy, iOSdeviceName, null, null).click();
		ElementUtils.isDisplayed(1, shareliveCallButton);
	}
	
	public void saveMeasurement() throws Exception
	{
		CommonUtils.wait(1);
		ElementUtils.safeClick(gotItButton);
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			captureMeasurementSaveButton.isEnabled();
			CommonUtils.wait(10);
			captureMeasurementSaveButton.click() ;
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			
			for(int i = 0; i < 60; i++)
			{
				if(DriverManager.getDriver().getPageSource().contains("SAVE"))                        
					break;
				else
					CommonUtils.wait(1);
			}
			gestureUtils.clickOnCordinates(DriverManager.getDriver().manage().window().getSize().width / 2, DriverManager.getDriver().manage().window().getSize().height - 160);
		}
	}
	
	public void saveBeakerMeasurement(boolean captureTempratureMeasurement ,String measurementValue, String measurementUnit) throws Exception
	{
		if(captureTempratureMeasurement)
		{
			ElementUtils.safeClick(beakerAddTempratureButton);
			saveManualMeasurement(measurementValue, measurementUnit);
		}
		CommonUtils.wait(6);
		ElementUtils.clickIfDisplayedAndEnabled(captureMeasurementSaveButton);
	}
	
	public void recordMeasurement(int recordTime) throws Exception
	{
		ElementUtils.clickIfDisplayedAndEnabled(graphButton);
		ElementUtils.clickIfDisplayedAndEnabled(startRecordingButton);
		CommonUtils.wait(recordTime);
		ElementUtils.clickIfDisplayedAndEnabled(stopRecordingButton);
	}
	
	public void downloadTIMeasurement(int numberOfMeasurements, String deviceName, boolean innerDownload) throws Exception
	{
		if(innerDownload)
		{
			ElementUtils.click(1, measurementObject);
			ElementUtils.click(1, tiDownloadButton);
		}	
		else
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				mTIDownloadButton = ElementUtils.getElement("Connected Devices", null, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, null);
				gestureUtils.clickOnCordinates(mTIDownloadButton.getSize().width - 75, mTIDownloadButton.getLocation().y + 25);
				CommonUtils.wait(1);
			}
			else
				ElementUtils.click(1, downloadTIImagesButtonInMeasurementCell);
		}
		ElementUtils.click(1, selectImagesToDownloadButton);
		int downloadStartIndex = measurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT);
		for(int i = downloadStartIndex; i < downloadStartIndex + numberOfMeasurements; i++)
		{
			measurementDetailPage.captureMeasurementsDetails(FCM.MEASUREMENTS_PROPERTIES_FILE_PATH, deviceName, MeasurementType.TI_DOWNLOAD, i);
			ElementUtils.click(2, imageDownloadList.get(i));
		}
		ElementUtils.click(1, downloadSelectedTIImagesButton);
		ElementUtils.click(6, tiImageDownloadNotNowButton);
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			ElementUtils.click(1, downloadTIImagesCancelButton);
		mTIDownloadButton = null;
	}
	
	public void captureTIMeasurement(String deviceName) throws Exception
	{
		CommonUtils.wait(2);
		ElementUtils.safeClick(2, tiRempteControlButton);
		CommonUtils.wait(2);
		ElementUtils.click(6, tiCaptureButton);
		CommonUtils.wait(2);
		ElementUtils.click(6, tiSaveButton);
	}
	
	public void configureCNXLogging(String loggingIntervalInSeconds, String loggingIntervalInMinutes, String loggingDurationInMinutes, String loggingDurationInHours) throws Exception
	{
		ElementUtils.click(2, loggingDurationSetupButton);
		loggingIntervalInSecondsTextField.clear();
		loggingIntervalInSecondsTextField.sendKeys(loggingIntervalInSeconds);
		if(!loggingIntervalInMinutes.equals("0"))
		{
			loggingIntervalInMinutesTextField.clear();
			loggingIntervalInMinutesTextField.sendKeys(loggingIntervalInMinutes);
		}
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) && durationToggleButton.getText().equals("ON"))
			durationToggleButton.click();
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) && durationToggleButton.getText().equals("1"))
			durationToggleButton.click();
		loggingDurationInMinutesTextField.clear();
		loggingDurationInMinutesTextField.sendKeys(loggingDurationInMinutes);
		if(!loggingDurationInHours.equals("0"))
		{
			loggingDurationInHoursTextField.clear();
			loggingDurationInHoursTextField.sendKeys(loggingDurationInHours);
		}
		loggingSetupDoneButton.click();
	}
	
	public void clearCNXLog() throws Exception
	{
		if(ElementUtils.isEnabled(1, clearLogButton.get(0)))
		{
			ElementUtils.click(1, clearLogButton.get(0));
			ElementUtils.safeClick(1, clearLogDeleteConfirmationButton);
			CommonUtils.wait(10);
		}
	}
	
	public void startCNXLogging() throws Exception
	{
		
		ElementUtils.isEnabled(6, startLoggingButton);
		ElementUtils.click(6, startLoggingButton);
	}
	
	public void downloadCNXLog() throws Exception
	{
		if(!downloadLogButton.isEnabled())
			stopLoggingButton.click();
		CommonUtils.wait(2);
		downloadLogButton.click();
		downloadLogAcceptConfirmationButton.click();
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			ElementUtils.safeClick(1, downloadLogAcceptConfirmationButton);
	}
	
	public void shareCNXLog(String recipientAddress) throws Exception
	{
		ElementUtils.click(2, measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.SHARE_BUTTON));
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			measurementCellObject.click();
			shareCNXLogNextButton.click();
		}
		measurementDetailPage.shareMeasurement(recipientAddress, DataType.RECORDED_DATA, ShareFormat.CSV, false);
		doneButton.click();
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			cnxLogDeleteButton.click();
			doneButton.click();
		}
	}
	
	public void saveGroupMeasurement(String[] deviceNameList) throws Exception
	{
		for(int i=0;i<deviceNameList.length;i++)
		{
			ElementUtils.reliableClick(1, addDeviceButton, connectInfoMessage, 5);
			connectToSimulatedDevice(deviceNameList[i]);
		}
		CommonUtils.wait(4);
		ElementUtils.clickIfDisplayedAndEnabled(captureMeasurementSaveButton);
	}
	
	public void clickOnManualMeasureButton() throws Exception
	{
		manualMeasurementButton.click();
	}
	
	public void saveManualMeasurement(String measurementValue, String measurementUnit) throws Exception
	{
		for(int i=0;i < measurementValue.length();i++)
		{
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, String.valueOf(measurementValue.charAt(i)), LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, String.valueOf(measurementValue.charAt(i)), null, null).click();
		}
		manualMeasurementNextButton.click();
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, measurementUnit, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, measurementUnit, null, null).click();
		manualMeasurementDoneButton.click();
	}
	
	public void saveAndDisconnectDevice(int deviceCount) 
	{
		CommonUtils.wait(2); //screen change wait
		saveButton.click();
		switch(deviceCount)
		{
		case 1:
			CommonUtils.wait(2);
			disconnectDeviceButton.click();
			break;
		default:
			for(int i = 0; i < deviceCount; i++)
			{
				CommonUtils.wait(2);
				disconnectDeviceButton.click();
			}
			break;
		}
	}
	
	public void doneAndDisconnectDevice(int deviceCount) 
	{
		CommonUtils.wait(2);
		doneButton.click();
		switch(deviceCount)
		{
		case 1:
			CommonUtils.wait(2);
			disconnectDeviceButton.click();
			break;
		default:
			for(int i = 0; i < deviceCount; i++)
			{
				CommonUtils.wait(2);
				disconnectDeviceButton.click();
			}
			break;
		}
	}
	
	public void clickOnDoneButton() 
	{
		doneButton.click();
	}
	
	public void recordCameraMeasurement(int durationInSeconds)
	{
		cameraButton.click();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			androidPermissionAllowButton.click();
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		startRecordingButton.click();
		CommonUtils.wait(durationInSeconds);
		stopRecordingButton.click();
		CommonUtils.wait(2);
		saveButton.click();
		cameraCloseButton.click();
	}
	
//	**********below two methods are for android smoke******
	
	public void recordCameraMeasurementForAndroidSmoke(int durationInSeconds)
	{
		cameraButton.click();
		//if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))	
		androidPermissionAllowButton.click();
		measurementDetailPage.saveAndDocumentGotItButon();
		//else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		startRecordingButton.click();
		CommonUtils.wait(durationInSeconds);
		CommonUtils.wait(2);
		stopRecordingButton.click();
		CommonUtils.wait(5);
		//saveButton.click();
		//cameraCloseButton.click();
	}
	
	public void saveCameraMeasurementForAndroidSmoke()
	{
		//cameraButton.click();
		//if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		//androidPermissionAllowButton.click();
		CommonUtils.wait(2);
		saveButton.click();
		CommonUtils.wait(3);
		measurementDetailPage.nextAndGotItButtonClick();
		measurementDetailPage.youAreOnTrackCoarchMarkInDetailsPage();
		clickOnDoneButton();
		measurementDetailPage.youAreOnTrackCoarchMarkInDetailsPage();
		cameraCloseButton.click();
	}
	
//	**********End of Android smoke method******
	
	public void clickBackButton()
	{
		ElementUtils.safeClick(backButton);
	}
	
	public void handleAndroidMeasurementAlerts() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			ElementUtils.safeClick(androidLocationPermissionOkButton);
			ElementUtils.safeClick(androidPermissionAllowButton);
			//ElementUtils.safeClick(androidEnableLocationServicesOkButton);
			//CommonUtils.wait(1);
			//AndroidUtils.getAndroidDriver().pressKey(new KeyEvent().withKey(AndroidKey.BACK));            
		}
	}
	
	public void selectToolWifi(String wiFiTool, String wifiToolssid,String wifiToolPassword) throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			WebElement wifiONOFFButton=ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.android.settings:id/switch_widget", LocatorStrategy.NONE,null,LocatorStrategy.NONE,null);
			if (wifiONOFFButton.getText().equals("OFF"))
			{
				wifiONOFFButton.click();
				CommonUtils.wait(5);
			}
			
			String wifiName =wiFiTool+"<"+wifiToolssid+">";
			CommonUtils.wait(2);
			
			if(DriverManager.getDriverName().equals("Android"))
			{
				ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, wifiName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
				CommonUtils.wait(10);
				ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, wifiName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
				if (ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Network speed", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).isDisplayed())
				{
					ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "CANCEL", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
					CommonUtils.wait(1);
				}
				AndroidUtils.back();
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			String wifiName =wiFiTool+"<"+wifiToolssid+">";
			phoneSettingsPage.openWiFiPageAndTrunOnWiFiIfOff();
			CommonUtils.wait(5);
			phoneSettingsPage.connectToNetwork(wifiName, wifiToolPassword);
			CommonUtils.wait(5);
			if(!phoneSettingsPage.isConnectedToNetwork(wifiName))
			{
				phoneSettingsPage.connectToNetwork(wifiName, wifiToolPassword);
			}
			else
			{
				phoneSettingsPage.clickBackButtonToSettingsPage();
			}
			phoneSettingsPage.launchFCApp();
		}
		
	}
	
	public Boolean capture125BMeasurementTest(String wiFiTool, String wifiToolssid, String flukeWIFI,String wifiToolPassword,String flukeWIFIpassword) throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			//connectToRealDeviceAndroidPopUpHandle();
			goToSettingsLink.click();
			CommonUtils.wait(1);
			selectToolWifi(wiFiTool, wifiToolssid, wifiToolPassword);
			ElementUtils.isDisplayed(200, 3, fluke125BToolInCaptureScreen);
			fluke125BToolInCaptureScreen.click();
			CommonUtils.wait(20);
			ElementUtils.isDisplayed(120, 3, toolNameAfterConnectingToTool);
			ElementUtils.isDisplayed(120, 3, captureMeasurementSaveButton);
			captureMeasurementSaveButton.click();
			CommonUtils.wait(10);
			ElementUtils.safeClick(assignAssetCoachMarkClose);
			ElementUtils.isDisplayed(120, 3, capture_date_time);
			String captureDateTimeAfterCapture = capture_date_time.getText();
			CommonUtils.wait(10);
			doneButton.click();
			CommonUtils.wait(10);
			switcher.switchToMeasurementsPage();
			gestureUtils.mobileScroll(captureDateTimeAfterCapture, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
			capture_date_time.click();
			CommonUtils.wait(10);
			Boolean captureNameIsSameAsWhenCaptured= ElementUtils.isDisplayed(120, 3, capture_date_time);
			doneButton.click();
			
			return captureNameIsSameAsWhenCaptured;
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			selectToolWifi(wiFiTool, wifiToolssid, wifiToolPassword);
			switcher.switchToCaptureMeasurementsHomePage();
			
			return true;
		}
		return true;
		
	}
	
	
	public Boolean capture173XMeasurementTest(String wiFiTool, String wifiToolssid, String flukeWIFI,String wifiToolPassword,String flukeWIFIpassword, Switcher switcher) throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			//switcher.switchToHomePage();
			//captureMeasurementsLink.click();
			//connectToRealDeviceAndroidPopUpHandle();
			goToSettingsLink.click();
			CommonUtils.wait(1);
			selectToolWifi(wiFiTool, wifiToolssid, wifiToolPassword);
			ElementUtils.isDisplayed(200, 3, fluke173XToolInCaptureScreen);
			fluke173XToolInCaptureScreen.click();
			CommonUtils.wait(20);
			ElementUtils.isDisplayed(120, 3, toolNameAfterConnectingToTool);
			ElementUtils.isDisplayed(120, 3, captureMeasurementSaveButton);
			captureMeasurementSaveButton.click();
			CommonUtils.wait(1);
			ElementUtils.safeClick(assignAssetCoachMarkClose);
			/*ElementUtils.isDisplayed(120, 3, capture_date_time);
			String captureDateTimeAfterCapture = capture_date_time.getText();
			*/
			CommonUtils.wait(10);
			doneButton.click();
			CommonUtils.wait(10);
			switcher.switchToMeasurementsPage();
			gestureUtils.mobileScroll(fluke173XToolInCaptureScreen.getText(), Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
			fluke173XToolInCaptureScreen.click();
			CommonUtils.wait(10);
			//Boolean captureNameIsSameAsWhenCaptured= ElementUtils.isDisplayed(120, 3, capture_date_time);
			doneButton.click();
			
			//return captureNameIsSameAsWhenCaptured;
			
			return true;
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			selectToolWifi(wiFiTool, wifiToolssid, wifiToolPassword);
			switcher.switchToCaptureMeasurementsHomePage();
			ElementUtils.isDisplayed(200, 3, fluke173XToolInCaptureScreen);
			fluke173XToolInCaptureScreen.click();
			CommonUtils.wait(20);
			captureMeasurementSaveButton.click();
			CommonUtils.wait(5);
			manualMeasurementDoneButton.click();
			return true;
		}
		return true;
	
		
	}
	
	//download437MeasurementTest
	public Boolean download437MeasurementTest(String wiFiTool, String wifiToolssid, String flukeWIFI,String wifiToolPassword,String flukeWIFIpassword, Switcher switcher) throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			//switcher.switchToHomePage();
			//captureMeasurementsLink.click();
			//connectToRealDeviceAndroidPopUpHandle();
			goToSettingsLink.click();
			CommonUtils.wait(1);
			selectToolWifi(wiFiTool, wifiToolssid, wifiToolPassword);
			ElementUtils.isDisplayed(200, 3, fluke173XToolInCaptureScreen);
			fluke173XToolInCaptureScreen.click();
			CommonUtils.wait(20);
			ElementUtils.isDisplayed(120, 3, toolNameAfterConnectingToTool);
			ElementUtils.isDisplayed(120, 3, captureMeasurementSaveButton);
			captureMeasurementSaveButton.click();
			CommonUtils.wait(1);
			ElementUtils.safeClick(assignAssetCoachMarkClose);
			/*ElementUtils.isDisplayed(120, 3, capture_date_time);
			String captureDateTimeAfterCapture = capture_date_time.getText();
			*/
			CommonUtils.wait(10);
			doneButton.click();
			CommonUtils.wait(10);
			switcher.switchToMeasurementsPage();
			gestureUtils.mobileScroll(fluke173XToolInCaptureScreen.getText(), Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
			fluke173XToolInCaptureScreen.click();
			CommonUtils.wait(10);
			//Boolean captureNameIsSameAsWhenCaptured= ElementUtils.isDisplayed(120, 3, capture_date_time);
			doneButton.click();
			
			//return captureNameIsSameAsWhenCaptured;
			
			return true;
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			selectToolWifi(wiFiTool, wifiToolssid, wifiToolPassword);
			switcher.switchToCaptureMeasurementsHomePage();
			ElementUtils.isDisplayed(200, 3, fluke437InCaptureScreen);
			fluke437InCaptureScreen.click();
			CommonUtils.wait(20);
			//captureMeasurementSaveButton.click();
			//CommonUtils.wait(5);
			//manualMeasurementDoneButton.click();
			return true;
		}
		return true;
	}
	
	
	public void download1664FC(String operation) throws Exception {
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
		ElementUtils.isDisplayed(120, 3, loggingButton);
		ElementUtils.clickIfDisplayedAndEnabled(loggingButton);

		CommonUtils.wait(2);

		if(ElementUtils.isDisplayedAndEnabled(1, 1, downloadLayout)) 
		{
			CommonUtils.wait(2);
			switch (operation) {

			case "Download":
				CommonUtils.wait(1);
				ElementUtils.isDisplayed(3, download1664Button);
				ElementUtils.click(3, download1664Button);
				CommonUtils.wait(5);
				ElementUtils.click(3, androidLocationPermissionOkButton);
		
				ElementUtils.click(3, androidLocationPermissionOkButton);
				CommonUtils.wait(5);
				ElementUtils.click(3, doneButton);
				break;
			case "Clear Memory":
				CommonUtils.wait(1);
				ElementUtils.click(3, clear1664Button);
				ElementUtils.click(3, androidLocationPermissionOkButton);
				ElementUtils.click(3, androidLocationPermissionOkButton);
				CommonUtils.wait(10);
				Assert.assertEquals(memoryvalue.getText(), "Memory is Empty.");
				
				break;

			}

		} else if (memoryvalue.isEnabled()) {
			
			Assert.assertEquals(memoryvalue.getText(), "Memory is Empty.");
		} 
		else {
			
			CommonUtils.wait(2);
		}

	}
	}

	public void museMeasurementtest(Switcher switcher) throws Exception {
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
		CommonUtils.wait(2);

		ElementUtils.click(1, captureMeasurementSaveButton);
		ElementUtils.safeClick(assignAssetCoachMarkClose);
		CommonUtils.wait(2);
		String captureDateTimeAfterCapture = capture_date_time.getText();
		System.out.println("capturedDateValue is:" + capture_date_time.getText());
		CommonUtils.wait(10);
		doneButton.click();
		CommonUtils.wait(10);
		CommonUtils.wait(10);
		switcher.switchToMeasurementsPage();
		gestureUtils.mobileScroll(captureDateTimeAfterCapture, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		measurementDate.click();
		CommonUtils.wait(10);
		ElementUtils.isDisplayed(120, 3, capture_date_time);
		String captureNameIsSameAsWhenCaptured = capture_date_time.getText();
		Assert.assertEquals(captureDateTimeAfterCapture, captureNameIsSameAsWhenCaptured);

	}
		

	
	}
	public void museDownload(Switcher switcher) throws Exception
	{
		
	
		if(ElementUtils.isDisplayed(downloadLogAcceptConfirmationButton))
		
		{ CommonUtils.wait(5);
		 ElementUtils.click(4, downloadLogAcceptConfirmationButton);
		
		 CommonUtils.wait(30);
		
		 String afterTimeDate=after_date_time.getText();
		 
		 ElementUtils.click(4, Grouped);
	      System.out.println("capture screen  :" +scalarmeasurement.size());
	   int s1  =scalarmeasurement.size();
		ElementUtils.click(3, backButton1);
		ElementUtils.click(3, doneButton);
		 CommonUtils.wait(3);
		ElementUtils.click(3,clearLogDeleteConfirmationButton);
		 CommonUtils.wait(3);
		backButton.click();
		switcher.switchToMeasurementsPage();
       
		gestureUtils.mobileScroll(afterTimeDate, ScrollDiection.DOWN);
		ElementUtils.click(3, Grouped);
       System.out.println("capture screen  :" +scalarmeasurement.size());
        int s2=scalarmeasurement.size();
       Assert.assertEquals(s1,s2);
       backButton1.click();
	
		CommonUtils.wait(10);
		
	}
	else if(ElementUtils.isDisplayed(downloadLogCancelButton))
	{
	ElementUtils.isDisplayedAndEnabled(10, 10, downloadLogCancelButton);
	
	downloadLogCancelButton.click();
	 backButton.click();
	}
	else
	{    backButton.click();
	}
	}
	
	
	public void museOperations(String operation) throws Exception
	{
		
		switch(operation)
		{
		case "Download": CommonUtils.wait(5);
		   ElementUtils.click(4, downloadLogAcceptConfirmationButton);
			
		   CommonUtils.wait(30);
		   ElementUtils.click(3, backButton);
		   ElementUtils.click(3, doneButton);
		   CommonUtils.wait(3);
		   ElementUtils.click(3,clearLogDeleteConfirmationButton);
		
			break;
			
		case "Delete Download Measurement":

			 CommonUtils.wait(5);
			 ElementUtils.click(4, downloadLogAcceptConfirmationButton);
			
			 CommonUtils.wait(30);
			
			 //String afterTimeDate=after_date_time.getText();
			 
			 ElementUtils.click(4, Grouped);
			 ElementUtils.click(3,action);
			 
			 ElementUtils.click(3,cnxLogDeleteButton);
			 ElementUtils.click(5,permanentlyDelete);
			  ElementUtils.click(5, doneButton);
			  ElementUtils.click(3,clearLogDeleteConfirmationButton);
			
			break;
		case "Download and Verify":
			museDownload(switcher);
			break;
		}
	}
	
	public void download376FCLog() 
	{
		if(!downloadLogButton.isEnabled())
		{
			startLoggingButton.click();
		CommonUtils.wait(10);
	        stopLoggingButton.click();
		}
		CommonUtils.wait(20);
		downloadLogButton.click();
		downloadLogAcceptConfirmationButton.click();
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			ElementUtils.safeClick(1, downloadLogAcceptConfirmationButton);
		
	}
	
	public void fc376Scroll()
	{   
		int i=fc376Download.size();
		System.out.println("Capture measurement:"+fc376Download.size());
		while(ElementUtils.isNotDisplayed(10, 10, fc376Download.get(i-1)))
		{
		gestureUtils.iOSScrollDown();
		Assert.assertFalse(ElementUtils.isDisplayed(scalarmeasurement1));
		//Switch to Measurements Page
		//Verify the Size in Measurements Page (Verify in both existing and new account - While Execution Update in Code accordingly).
	}
}
}



