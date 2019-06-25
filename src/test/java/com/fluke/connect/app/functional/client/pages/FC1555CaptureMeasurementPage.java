package com.fluke.connect.app.functional.client.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.fluke.connect.app.testdata.FCM1555;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.ScrollDiection;
import com.ibm.icu.impl.Assert;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;
import java.util.List;
import java.text.DecimalFormat;

public class FC1555CaptureMeasurementPage 
{

	@AndroidFindBy(id = "capture_button_container")
	@iOSXCUITFindBy(accessibility = "SAVE")
	private WebElement captureMeasurementsLink;

	@AndroidFindBy(id = "wifi_settings")
	private WebElement goToSettingsLink;


	@AndroidFindBy(id = "capture_button")
	@iOSXCUITFindBy(accessibility = "SAVE")
	private WebElement captureMeasurementSaveButton;

	@iOSXCUITFindBy(accessibility = "Use wifi to connect to these tools:")
	private WebElement connectInfoMessage;

	@HowToUseLocators(iOSXCUITAutomation = ALL_POSSIBLE)
	@AndroidFindBy(id = "fluke_small_logo")
	@iOSXCUITFindBy(accessibility = "Home")
	@iOSXCUITFindBy(accessibility = "Back")
	private WebElement backButton;

	@AndroidFindBy(id = "numeric_button")
	private WebElement numericButton;

	@AndroidFindBy(id = "graph_button")
	@iOSXCUITFindBy(accessibility="Display Mode")
	private WebElement graphButton;

	@HowToUseLocators(iOSAutomation = ALL_POSSIBLE)
	@AndroidFindBy(id = "record_button")
	@iOSXCUITFindBy(accessibility = "Start recording")   
	private WebElement startRecordingButton;	

	@HowToUseLocators(iOSAutomation = ALL_POSSIBLE)
	@AndroidFindBy(id = "record_button")
	@iOSXCUITFindBy(accessibility = "Stop recording")
	private WebElement stopRecordingButton;

	@AndroidFindBy(id = "device_name")
	@iOSXCUITFindBy(accessibility="device name")
	private WebElement deviceName;

	//Android capture measurement permission objects
	@AndroidFindBy(id = "dialog_ok")
	private WebElement androidLocationPermissionOkButton;

	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	private WebElement androidPermissionAllowButton;

	@AndroidFindBy(id = "android:id/button1")
	private WebElement androidEnableLocationServicesOkButton;

	@AndroidFindBy(id = "wifi_info_close")
	private WebElement androidWiFiInfoCloseButton;

	//manual measurement object
	@iOSXCUITFindBy(accessibility = "Add manual measurement")
	@AndroidFindBy(id = "clipboard_image")
	private WebElement manualMeasurementButton;

	@AndroidFindBy(id = "value")
	private WebElement manualMeasurementValueTextField;

	@HowToUseLocators(iOSAutomation = ALL_POSSIBLE)
	@iOSXCUITFindBy(accessibility = "NEXT")
	@iOSXCUITFindBy(accessibility = "Next")
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


	@iOSXCUITFindBy(accessibility = "Device info")
	private WebElement deviceInfoButton;

	@AndroidFindBy(id = "logging_link")
	private WebElement deviceInfoLink;

	@AndroidFindBy(id="com.fluke.deviceApp:id/device_logging_info")
	@iOSXCUITFindBy(accessibility = "Title")
	private WebElement deviceInfoStaticText;

	@AndroidFindBy(id="com.fluke.deviceApp:id/device_logging_done")
	@iOSXCUITFindBy(accessibility = "Done")
	private WebElement doneButtonOnDeviceInfoPage;

	@AndroidFindBy(id="com.fluke.deviceApp:id/logging_device_name_lbl")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Device Name\"]")
	private WebElement deviceNameLabelStaticText;

	@AndroidFindBy(id="com.fluke.deviceApp:id/logging_device_name")
	@iOSXCUITFindBy(className = "XCUIElementTypeTextField")
	private WebElement deviceNameEditTextField;

	@AndroidFindBy(id="com.fluke.deviceApp:id/logging_device_descr_lbl")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Device Description\"]")
	private WebElement deviceDescriptionLabelStaticText;

	@AndroidFindBy(id="com.fluke.deviceApp:id/logging_device_description")
	@iOSXCUITFindBy(accessibility = "FLUKE 1550B")
	private WebElement loggingDeviceDescriptionStaticText;

	@AndroidFindBy(id="com.fluke.deviceApp:id/logging_device_connection")
	@iOSXCUITFindBy(accessibility = "Connection:")
	private WebElement loggingDeviceConnectiontaticText;

	@AndroidFindBy(id="com.fluke.deviceApp:id/device_name")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"1555\"]")
	private WebElement deviceNameInCaptureScreenForConnectedDevice;

	@AndroidFindBy(id="com.fluke.deviceApp:id/capture_date_time")
	@iOSXCUITFindBy(accessibility = "added date")
	private WebElement measurementCaptureDate;

	@AndroidFindBy(id="device_value_unit")
	private WebElement deviceValueUnitForGraphs;

	@AndroidFindBy(id="com.fluke.deviceApp:id/device_value")
	private WebElement deviceValue;


	@AndroidFindBy(id="primary_value_unit")
	private WebElement primaryValueUnit;

	@AndroidFindBy(id="primary_value")
	private WebElement measurementValue;

	@AndroidFindBy(id="com.fluke.deviceApp:id/test_point")
	private WebElement assignedAssetInHistoryPage;

	@AndroidFindBy(id="com.fluke.deviceApp:id/measurement_date")
	private WebElement dateAndTimeAtHistoryPage;

	@AndroidFindBy(id="logging_interval_btn")
	private WebElement loggingIntervalButton;

	//Capture Measurements --> Fluke Connect logo
	@AndroidFindBy(id = "discover_image")
	@iOSXCUITFindBy(accessibility = "Add device")
	private WebElement addDeviceButton;

	//Capture Measurements --> Tap on device --> sharelive call button at bottom right
	@AndroidFindBy(id = "discover_image")
	@iOSXCUITFindBy(accessibility = "Make Sharelive call")
	private WebElement shareliveCallButton;

	@AndroidFindBy(id="back_button")  
	@HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
	@iOSXCUITFindBy(accessibility = "Done")
	@iOSXCUITFindBy(accessibility = "DONE")
	private WebElement doneButton;

	@HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
	@AndroidFindBy(id = "back_button")  
	@iOSXCUITFindBy(accessibility = "SAVE")   
	@iOSXCUITFindBy(accessibility = "Save")
	private WebElement saveButton;

	@AndroidFindBy(id = "com.fluke.deviceApp:id/close")
	@iOSXCUITFindBy(accessibility = "Disconnect device")
	private WebElement disconnectDeviceButton;

	@AndroidFindBy(id = "logging_link")
	@iOSXCUITFindBy(accessibility = "Download")
	private WebElement loggingButton;

	@AndroidFindBy(id = "logging_memory_clear")
	@iOSXCUITFindBy(accessibility = "Clear")
	private WebElement clearLogButton;

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
	private WebElement loggingDurationMinutesTextField;

	@AndroidFindBy(id = "logging_interval_seconds")
	@iOSXCUITFindBy(accessibility = "Interval Seconds")
	private WebElement loggingDurationSecondsTextField;

	@AndroidFindBy(id = "duration_toggle")
	@iOSXCUITFindBy(accessibility = "Stop Manually Switch")
	private WebElement durationToggleButton;

	@AndroidFindBy(id = "logging_duration_days")
	@iOSXCUITFindBy(accessibility = "Duration Days")
	private WebElement loggingStopDurationDaysTextField;

	@AndroidFindBy(id = "logging_duration_hours")
	@iOSXCUITFindBy(accessibility = "Duration Hours")
	private WebElement loggingStopDurationHoursTextField;

	@AndroidFindBy(id = "logging_duration_minutes")
	@iOSXCUITFindBy(accessibility = "Duration Minutes")
	private WebElement loggingStopDurationMinutesTextField;

	@AndroidFindBy(id = "logging_interval_val")
	@iOSXCUITFindBy(accessibility = "Interval Label")
	private WebElement loggingDurationSetupButton;

	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(id = "button1")
	@AndroidFindBy(id = "dialog_ok")
	@iOSXCUITFindBy(accessibility = "OK")
	private WebElement downloadLogOkButton;

	@AndroidFindBy(id = "button2")
	@iOSXCUITFindBy(accessibility = "Cancel")
	private WebElement downloadLogCancelButton;

	@AndroidFindBy(id = "com.fluke.deviceApp:id/dialog_ok")
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

	@AndroidFindBy(id = "device_name")
	private WebElement toolNameAfterConnectingToTool;

	@AndroidFindBy(id = "rescan_button")
	private WebElement captureMeasurementDeviceScanLink;

	@AndroidFindBy(id = "wifi_info_close")
	private WebElement captureMeasurementWifiInfoClose;


	// ****Eevee Related Elements ***
	
	@HowToUseLocators(iOSXCUITAutomation = ALL_POSSIBLE)
	@AndroidFindBy(id = "com.fluke.deviceApp:id/menu")
	@iOSXCUITFindBy(accessibility = "Device info")
	@iOSXCUITFindBy(accessibility = "Download")
	@iOSXCUITFindBy(accessibility = "Disconnect device")
	private WebElement captureMeasurementOptionMenu;
	
	@iOSXCUITFindBy(accessibility="Serial Number")
	private WebElement serialNumber;
	
	@iOSXCUITFindBy(accessibility="Software Version")
	private WebElement softwareVersion;
	
	@iOSXCUITFindBy(accessibility="Firmware Version")
	private WebElement firmwareVersion;

	@AndroidFindBy(id = "dialog_message_main")
	@iOSXCUITFindBy(accessibility = "Are you sure you want to start Remote Control?")
	private WebElement remoteControlStartConfirmationMessage;

	@AndroidFindBy(id = "dialog_ok")
	@iOSXCUITFindBy(accessibility = "Yes")
	private WebElement yesButtonOnStartRemoteControlConfirmationMessage;

	@AndroidFindBy(id = "start_stop_test")
	@iOSXCUITFindBy(accessibility = "START TEST")
	private WebElement startTestButtonOnRemoteControl;

	@AndroidFindBy(id = "start_stop_test")
	@iOSXCUITFindBy(accessibility = "STOP TEST")
	private WebElement stopTestButtonOnRemoteControl;

	@AndroidFindBy(id = "dialog_message_main")
	private WebElement testStartedMessage;

	@AndroidFindBy(id = "dialog_ok")
	private WebElement okButtonAfterTestStarted;

	@AndroidFindBy(id = "dialog_title")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Test completed successfully.\"]")
	private WebElement testCompletionMessage;

	@AndroidFindBy(id = "dialog_ok")
	@iOSXCUITFindBy(accessibility = "Save")
	private WebElement saveButtonAfterTestCompletion;

	@AndroidFindBy(id = "dialog_message_main")
	@iOSXCUITFindBy(accessibility = "Do you want to save the test result?")
	private WebElement doYouWantToSaveConfirmationMessage;

	@AndroidFindBy(id = "dialog_message_main")
	@iOSXCUITFindBy(accessibility = "Are you sure you want to stop Remote Control?")
	private WebElement stopRemoteControlConfirmationMessage;

	@HowToUseLocators(iOSXCUITAutomation = ALL_POSSIBLE)
	@AndroidFindBy(id = "com.fluke.deviceApp:id/dialog_ok")
	@iOSXCUITFindBy(accessibility = "Yes")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Yes\"]")
	private WebElement yesButtonToConfirmStopRemoteControl;
	
	@AndroidFindBy(id = "com.fluke.deviceApp:id/dialog_ok")
	private WebElement okButtonInCaseOfErrorWhileFetchingSettings;

	@AndroidFindBy(id = "dialog_cancel")
	@iOSXCUITFindBy(accessibility = "Cancel")
	private WebElement cancelButtonAfterTestCompletion;

	@AndroidFindBy(id="com.fluke.deviceApp:id/back_button")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Done\"])[1]")
	private WebElement backIconORDone;

	@AndroidFindBy(id="functions_btn") 
	@iOSXCUITFindBy(accessibility="FUNCTIONS")
	private WebElement functionButton;

	@AndroidFindBy(id="done_button") 
	@iOSXCUITFindBy(accessibility="DONE")
	private WebElement doneButtonOnFunctionSetPage;

	@AndroidFindBy(id="test_voltage_spinner")
	@iOSXCUITFindBy(accessibility="Test Voltage")
	private WebElement testVoltageDropdownButton;

	@AndroidFindBy(id="test_function_spinner")
	@iOSXCUITFindBy(accessibility="Test Type")
	private WebElement testTypeDropdownButton;

	@AndroidFindBy(id="time_limit_spinner")
	@iOSXCUITFindBy(accessibility="testDurationValue")
	private WebElement timeLimitTypeDropdownButton;

	@AndroidFindBy(id="humidity_value_textView")
	private WebElement humidityField;

	//@AndroidFindBy(id="eevee_test_type")
	//private WebElement testResultsStaticText;

	@AndroidFindBy(id="com.fluke.deviceApp:id/eevee_test_type")
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Test Results\"]")
	private WebElement testResults;

	@AndroidFindBy(id="com.fluke.deviceApp:id/eevee_test_type")
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Compensation Values\"]")
	private WebElement compensationValue;

	@AndroidFindBy(id="com.fluke.deviceApp:id/eevee_test_type")
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Test Conditions\"]")
	private WebElement testConditions;

	@AndroidFindBy(id="com.fluke.deviceApp:id/eevee_test_type")
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Calculated Results\"]")
	private WebElement calculatedResult;

	@AndroidFindBy(id="com.fluke.deviceApp:id/eevee_test_type")
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Graph\"]")
	private WebElement graphStaticText;

	@AndroidFindBy(id="com.fluke.deviceApp:id/test_duration")
	@iOSXCUITFindBy(accessibility="duration")
	private WebElement testDuration;

	@AndroidFindBy(id="com.fluke.deviceApp:id/primaryValue")
	@iOSXCUITFindBy(accessibility="primaryValue")
	private WebElement primaryValue;

	@AndroidFindBy(id="com.fluke.deviceApp:id/primaryValueUnit")
	//@iOSXCUITFindBy(accessibility="")
	private WebElement primaryUnit;

	@AndroidFindBy(id="com.fluke.deviceApp:id/tertiaryValue")
	@iOSXCUITFindBy(accessibility="tertiaryValue")
	private WebElement tertiaryValue;

	@AndroidFindBy(id="com.fluke.deviceApp:id/tertiaryValueUnit")
	//@iOSXCUITFindBy(accessibility="")
	private WebElement tertiaryUnit;

	@AndroidFindBy(id="com.fluke.deviceApp:id/secondaryValue")
	@iOSXCUITFindBy(accessibility="secondaryValue")
	private WebElement secondaryValue;

	@AndroidFindBy(id="com.fluke.deviceApp:id/secondaryValueUnit")
	//@iOSXCUITFindBy(accessibility="")
	private WebElement secondaryUnit;

	@AndroidFindBy(id="com.fluke.deviceApp:id/measurement_date")
	@iOSXCUITFindBy(accessibility="added date")
	private WebElement measurementDate;


	@AndroidFindBy(id="com.fluke.deviceApp:id/compensated_resistance_value")
	@iOSXCUITFindBy(accessibility="compResistanceActualValue")
	private WebElement compensationResistanceValue;

	@AndroidFindBy(id="com.fluke.deviceApp:id/compensated_resistance_unit")
	@iOSXCUITFindBy(accessibility="compResistanceUnitValue")
	private WebElement compensationResistanceUnit;

	@AndroidFindBy(id="com.fluke.deviceApp:id/temp_compensation_value_textView")
	@iOSXCUITFindBy(xpath="(//XCUIElementTypeTextField[@name=\"tempCompensationValue\"])[1]")
	private WebElement tempTextView;

	@AndroidFindBy(id="com.fluke.deviceApp:id/temp_compensation_value_editText")
	@iOSXCUITFindBy(xpath="(//XCUIElementTypeTextField[@name=\"tempCompensationValue\"])[1]")
	private WebElement tempEditText;

	@AndroidFindBy(id="com.fluke.deviceApp:id/temp_compensation_unit")
	private WebElement compensatedTempUnit;

	@AndroidFindBy(id="com.fluke.deviceApp:id/humidity_value_textView")
	@iOSXCUITFindBy(accessibility="humidityValue")
	private WebElement humidityTextView;

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

	@AndroidFindBy(id="com.fluke.deviceApp:id/voltage_value")
	@iOSXCUITFindBy(accessibility="voltageValue")
	private WebElement setVoltageValue;

	@AndroidFindBy(id="com.fluke.deviceApp:id/ramp_value")
	@iOSXCUITFindBy(accessibility="rampValue")
	private WebElement rampValue;

	@AndroidFindBy(id="com.fluke.deviceApp:id/time_limit_value")
	@iOSXCUITFindBy(accessibility="timeLimitValue")
	private WebElement timeLimitValue;

	@AndroidFindBy(id="com.fluke.deviceApp:id/test_ended_by")
	@iOSXCUITFindBy(accessibility="testEndedValue")
	private WebElement testEndedValue;

	@AndroidFindBy(id="com.fluke.deviceApp:id/capacitance_value")
	@iOSXCUITFindBy(accessibility="capacitanceValue")
	private WebElement capacitanceValue;

	@AndroidFindBy(id="com.fluke.deviceApp:id/pi_value")
	@iOSXCUITFindBy(accessibility="PiValue")
	private WebElement piValue;

	@AndroidFindBy(id="com.fluke.deviceApp:id/dar_value")
	@iOSXCUITFindBy(accessibility="DarValue")
	private WebElement darValue;

	@AndroidFindBy(id="com.fluke.deviceApp:id/graph_button")
	@iOSXCUITFindBy(accessibility = "Display Mode")
	private WebElement graphIconInCapturePage;

	@AndroidFindBy(id="com.fluke.deviceApp:id/graph_layout")
	@iOSXCUITFindBy(accessibility = "view toggle numeric")
	private WebElement graphIconInRemoteControl;

	@AndroidFindBy(id="com.fluke.deviceApp:id/eevee_test_page")
	@iOSXCUITFindBy(className = "XCUIElementTypeScrollView")
	private WebElement eeveeTrendGraph;

	@AndroidFindBy(id="com.fluke.deviceApp:id/equipment_link")
	@iOSXCUITFindBy(accessibility = "Asset")
	private WebElement assignAssetCell;
	
	
	
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

	//@AndroidFindBy(uiAutomator="new UiSelector().textContains(\"FLUKE1738\")")
	@iOSXCUITFindBy(accessibility = "Fluke 430-II <19423106>")
	private WebElement fluke437InCaptureScreen;

	@AndroidFindBy(id = "capture_date_time")
	private WebElement capture_date_time;

	@iOSXCUITFindBy(className = "XCUIElementTypePickerWheel")
	private WebElement iOSPickerWheel;
	
	
	/** Eevee Web Element ***/
	@FindBy(how = How.CSS, using = ".measDetailData[data-detail-type='eevee']")
	private WebElement eeveeMeasurementInMeasurementPage;
	
	@FindBy(how = How.CSS, using = ".asset")
	private WebElement assignAssetLinkInDetailsPage;
	
	
	
	/** Web Analysis Page ***/
	@FindBy(how = How.CSS, using = ".measurement-detail-eevee[data-model-id='0e1992a4-2977-4484-8f4d-74d941ec1743']")
	private WebElement eeveeMeasurement;

	@FindBy(how=How.CSS,using="#graphMagnitude")
	private WebElement highestUnit;
	
	@FindBy(how=How.CSS,using =".eeveePrimaryMagnitude")
	private List<WebElement> carouselPrimaryUnit;
	
	@FindBy(how=How.CSS,using=".eeveePrimaryValue")
	private List<WebElement> carouselPrimaryValue;
	
	@FindBy(how=How.CSS,using=".resValues")
	public WebElement toolTipPrimaryValue;
	
	@FindBy(how=How.CSS,using=".eeveeSavedMeasurements")
	private List<WebElement> carouselMesaurmentList;
	
	@FindBy(how=How.CSS,using="a#nextImage")
	public WebElement arrowNextButton;
	
	private GestureUtils gestureUtils;
	//private Switcher switcher;

	//private DeviceUtils phoneSettingsPage;
	//private MeasurementDetailPage measurementDetailPage;
	//private WebElement mTIDownloadButton;
	
	public String actualresistancevalue;
	
	public FC1555CaptureMeasurementPage()
	{
		CommonUtils.initElements(this, 10);
		gestureUtils = new GestureUtils();
		//phoneSettingsPage = new DeviceUtils();
		//measurementDetailPage = new MeasurementDetailPage();
		//mTIDownloadButton = null;
	}

	
	public enum CaptureEeveeMeasurementsPageObject
	{
		TEST_VOLTAGE_DROPDOWN_BUTTON, TEST_TYPE_DROPDOWN_BUTTON, TIME_LIMIT_DROPDOWN_BUTTON, IOS_PICKER_WHEEL
	}

	public WebElement getCaptureEeveeMeasurementsPageObject(CaptureEeveeMeasurementsPageObject objectName)
	{	switch(objectName)
		{
		case TEST_VOLTAGE_DROPDOWN_BUTTON:
			return testVoltageDropdownButton;
		case TEST_TYPE_DROPDOWN_BUTTON:
			return testTypeDropdownButton;
		case TIME_LIMIT_DROPDOWN_BUTTON:
			return timeLimitTypeDropdownButton;
		case IOS_PICKER_WHEEL:
			return iOSPickerWheel;
		default:
			return null;
		}
	}

	
	public String getRemoteControlMessage(FCM1555.MESSAGES messages)
	{
		switch(messages)
		{
		case REMOTE_CONTROL_CONFIRMATION:
			return remoteControlStartConfirmationMessage.getText();
		case TEST_SUCCESSFULLY_STARTED_CONFIRMATION:
			return testStartedMessage.getText();
		case TEST_SUCCESSFULLY_COMPLETED:
			return testCompletionMessage.getText();
		case DOYOU_WANT_TO_SAVE:
			return doYouWantToSaveConfirmationMessage.getText();
		case STOP_REMOTE_CONTROL_CONFIRMATION:
			return stopRemoteControlConfirmationMessage.getText();
		default:
			return null;
		}
	}

	public String testResultData(FCM1555.TEST_RESULTS measHeader)
	{

		switch(measHeader)
		{
		case TEST_RESULT_HEADER:
			return testResults.getText();
		case TEST_DURATION:
			return testDuration.getText();		
		case PRIMARY_VALUE:
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				return primaryValue.getText()+" "+primaryUnit.getText();
			}
			else
			{
				return primaryValue.getText();
			}
		case SECONDARY_VALUE:
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				return secondaryValue.getText()+" "+secondaryUnit.getText();
			}
			else
			{
				return secondaryValue.getText();
			}
		case TERTIARY_VALUE:
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				return tertiaryValue.getText()+" "+tertiaryUnit.getText();
			}
			else
			{
				return tertiaryValue.getText();
			}
		default:
			break;	
		}
		return null;
	}

	
	
	public String compensationData(FCM1555.COMPENSATION_DATA compensationData)
	{
		switch(compensationData)
		{
		case COMPENSATION_HEADER:
			return compensationValue.getText();
		case COMPENSATION_RESISTANCE:
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				return compensationResistanceValue.getText()+" "+compensationResistanceUnit.getText();
			}
			else
			{
				return compensationResistanceValue.getText();
			}
		case COMPENSATION_TEMPRATURE:
			return tempTextView.getText();
		case COMPENSATION_HUMIDITY:
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				return humidityTextView.getText();//+" "+humidityUnit.getText();
			}
			else
			{
				return humidityTextView.getText();
			}
		default:
			break;
		}
		return null;
	}

	public String getTestConditionData(FCM1555.TEST_CONDITIONS testCondtion)
	{
		//if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		//{
		switch(testCondtion)
		{
		case TEST_CONDITIONS:
			return testConditions.getText();
		case VOLTAGE:
			return setVoltageValue.getText();
		case RAMP:
			return rampValue.getText();
		case TIME_LIMIT:
			return timeLimitValue.getText();
		case TEST_ENDED:
			return testEndedValue.getText();
		default:
			break;
		}
		return null;
	}

	public String calculatedResultData(FCM1555.CALCUTLATED_RESULTS calculatedResults)
	{
		switch(calculatedResults)
		{
		case CALCULATED_RESULTS:
			return calculatedResult.getText();
		case CAPACITANCE:
			return capacitanceValue.getText();
		case PI:
			return piValue.getText();
		case DAR:
			return darValue.getText();
		default:
			break;
		}
		return null;
	}

	public String graph(FCM1555.GRAPH graph)
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			switch(graph)
			{
			case GRAPH:
				return graphStaticText.getText();
			case PRIMARY_AXIS_UNIT:
				//return inGraphPrimaryAxisUnit.getText();
			default:
				break;
			}
		}

		return null;
	}

	public String loggingStaticText(FCM1555.CNX_LOGGING_TEXTS loggingStaticText)
	{
		switch(loggingStaticText)
		{
		case LOGGING_TEXT:
			return ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, loggingStaticText.getMessage(), null, null, null, null).getText();
		case INTERVAL_TEXT:
			return ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, loggingStaticText.getMessage(), null, null, null, null).getText();
		case DURATION_TEXT:
			return ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, loggingStaticText.getMessage(), null, null, null, null).getText();	
		case LOGGING_SETUP_TEXT:
			return ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, loggingStaticText.getMessage(), null, null, null, null).getText();
		case SET_INTERVAL_TEXT:
			return ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, loggingStaticText.getMessage(), null, null, null, null).getText();
		case MANUALLY_STOP_LOGGING_TEXT:
			return ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, loggingStaticText.getMessage(), null, null, null, null).getText();
		case AUTOMATICALLY_STOP_LOGGING_TEXT:
			return ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, loggingStaticText.getMessage(), null, null, null, null).getText();
		default:
			break;
		}
		return null;
	}

	public void clickOnBack()
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			backButton.click();
		}
	}
	
	public String getEeveeMeasurementDate()
	{
		return measurementDate.getText();
	}

	public String getMeasurementCaptureDate()
	{
		return measurementCaptureDate.getText();
	}

	public String getDateAtHistoryPage()
	{
		return dateAndTimeAtHistoryPage.getText();
	}

	public String compensatedresistance(String resistance, String tempratureValue)
	{
		tempTextView.click();
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			tempTextView.clear();
		}
		CommonUtils.wait(1);
		tempEditText.sendKeys(tempratureValue);
		CommonUtils.wait(5);
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(null, null,LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", null, null).click();
		}
		else
		{
			clickOnAndroidDoneButton();
		}
		CommonUtils.wait(10);

		if(resistance.contains(">")||resistance.contains("<"))
		{
			return compensationResistanceValue.getText()+" "+compensationResistanceUnit.getText();
		}
		else if(tempratureValue.equals("00"))
		{
			return compensationResistanceValue.getText()+" "+compensationResistanceUnit.getText();
		}
		//else if(!resistance.contains(">")||!resistance.contains("<") && tempratureValue!="0")
		else 
		{
			double value = Math.pow(0.5, (40 - Double.parseDouble(tempratureValue)) / 10);
			double compensatedResistenceValue = Double.parseDouble(resistance) * value;
			CommonUtils.wait(10);
			return String.valueOf(new DecimalFormat("##.##").format(compensatedResistenceValue))+" "+compensationResistanceUnit.getText();	
		}
	}

	public String getCompensationresistance()
	{
		return compensationResistanceValue.getText()+" "+compensationResistanceUnit.getText();
	}

	public void connectToRealDeviceAndroidPopUpHandle() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			ElementUtils.safeClick(captureMeasurementPermissionOkButton);
			ElementUtils.safeClick(captureMeasurementPermissionAllowButton);
			ElementUtils.safeClick(captureMeasurementLocationOkButton);
			CommonUtils.wait(3);
			//AndroidUtils.clickAndroidBackButton();
			ElementUtils.safeClick(captureMeasurementWifiInfoClose);
			ElementUtils.safeClick(captureMeasurementDeviceScanLink);	
		}	
	} 

	public void connectToRealDevice(String deviceName)
	{
		try{
			
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				ElementUtils.click(1, androidDeviceScanButton);
			CommonUtils.wait(10, 5, 0);
			gestureUtils.mScroll(deviceName, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
			if(!DriverManager.isRealDevice() && DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				gestureUtils.mScroll(-100, -75, 1);
			CommonUtils.wait(5);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, deviceName, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, deviceName, null, null).click();
			ElementUtils.isDisplayed(60, 1, captureMeasurementSaveButton);
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}

	public void saveMeasurement() throws Exception
	{
		ElementUtils.clickIfDisplayedAndEnabled(captureMeasurementSaveButton);
	}
	
	
	public void eeveeOptionMenu(String optionValue) throws Exception
	{

		//graphIconInCapturePage.click();
		CommonUtils.wait(5);
		//ElementUtils.safeClick(graphIconInCapturePage);
		//graphIconInCapturePage.click();
		//CommonUtils.wait(5);
		ElementUtils.safeClick(captureMeasurementOptionMenu);
	//	captureMeasurementOptionMenu.click();

		switch (optionValue)
		{
		case "Start Remote Control":
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, optionValue, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, optionValue, null, null).click();
			break;

		case "Info":
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, optionValue, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, optionValue, null, null).click();
			break;

		case "Download":
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, optionValue, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, optionValue, null, null).click();
			break;

		case "Disconnect":
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, optionValue, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, optionValue, null, null).click();
			break;

		case "Cancel":
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, optionValue, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, optionValue, null, null).click();
			break;

		case "Stop Remote Control":
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, optionValue, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, optionValue, null, null).click();
			break;

		}
	}

	public void clickOnGraphIconInRemoteControl()
	{
		graphIconInRemoteControl.click();	
	}

	public void checkForGraphAvailability()
	{
		try
		{
			eeveeTrendGraph.isDisplayed();
		}

		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}

	public void eeveeRemoteControlConfirmation() throws Exception
	{
		CommonUtils.wait(5);
		ElementUtils.safeClick(yesButtonOnStartRemoteControlConfirmationMessage);
		ElementUtils.isDisplayed(60, 1, startTestButtonOnRemoteControl);
	}

	public void eeveeRemoteControlStartTestRun() throws Exception
	{
		startTestButtonOnRemoteControl.click();
		CommonUtils.wait(2);
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			okButtonAfterTestStarted.click();
		}
	}

	public void eeveeRemoteControlStopTestRun() throws Exception
	{
		stopTestButtonOnRemoteControl.click();
	}

	public void eeveeRemoteControlTestCompletion() throws Exception
	{
		ElementUtils.safeClick(saveButtonAfterTestCompletion);
		CommonUtils.wait(10);
		ElementUtils.isDisplayed(120, 1, backIconORDone);
		//saveButtonAfterTestCompletion.click();
	}

	public void clickOnAndroidDoneButton() 
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			// WebElement  element = ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/fake_action_bar", null, null, null , null);
			int x= DriverManager.getDriver().manage().window().getSize().getWidth();
			int y= DriverManager.getDriver().manage().window().getSize().getHeight();
			int samsungS6X=600;
			int samsungNote5=470;
			if(DriverManager.getDeviceName().equals("SM-N9208"))
				gestureUtils.clickOnCordinates(x-150, y-samsungNote5);
			else if(DriverManager.getDeviceName().equals("SM-G920I"))
				gestureUtils.clickOnCordinates(x-150, y-samsungS6X);
		}
	}

	public void coachMarkClosure() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			ElementUtils.safeClick(assignAssetCoachMarkClose);
		}
	}

	public void clickOncancelButtonAfterTestCompletion() throws Exception
	{
		CommonUtils.wait(2);
		cancelButtonAfterTestCompletion.click();
	}
	
	public void clickOnOkbuttonIncaseOfErrorFetchingSettings()
	{
		if(okButtonInCaseOfErrorWhileFetchingSettings.isDisplayed())
			 {
				okButtonInCaseOfErrorWhileFetchingSettings.click();
			 }
	}

	public void stopRemoteControl() throws Throwable
	{
		ElementUtils.safeClick(yesButtonToConfirmStopRemoteControl);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, "YES", null, null, null, null);
		ElementUtils.isDisplayed(60, 1, captureMeasurementSaveButton);
	}

	public void eeveeTestFunctionSetting() throws Exception
	{
		ElementUtils.safeClick(functionButton);
		ElementUtils.isDisplayed(60, 1, doneButtonOnFunctionSetPage);
	}

	public void clickOnDoneButtonAfterFunctionSetting() throws Exception
	{
		ElementUtils.safeClick(doneButtonOnFunctionSetPage);
		ElementUtils.isDisplayed(60, 1, startTestButtonOnRemoteControl);
	}

	public void captureRealDeviceMeasurement() throws Exception
	{
		CommonUtils.wait(3);
		captureMeasurementSaveButton.click();
		//ElementUtils.clickIfDisplayedAndEnabled(captureMeasurementSaveButton);
	}
	public void infoScreenVerification()
	{
		CommonUtils.wait(1);
		loggingButton.click();
		//ElementUtils.safeClick(deviceInfoLink);
		ElementUtils.isDisplayed(10, 1, doneButtonOnDeviceInfoPage);
	}

	public String getDeviceinfoStaticText()
	{
		return deviceInfoStaticText.getText();
	}

	public String getDeviceNameStaticText()
	{
		return deviceNameLabelStaticText.getText();
	}

	public String getDeviceDescriptionStaticText()
	{
		return deviceDescriptionLabelStaticText.getText();
	}

	public String getLoggingDeviceDescriptionStaticText()
	{
		return loggingDeviceDescriptionStaticText.getText();
	}
	
	public String getLoggingDeviceConnectionStaticText()
	{
		return loggingDeviceConnectiontaticText.getText();
	}
	
	public String getSoftwareVersionStaticTextInInfoPage()
	{
		return softwareVersion.getText();
	}

	public String getSerialNumberStaticTextInInfoPage()
	{
		return serialNumber.getText();
	}
	public String getFirmwareVersionStaticTextInInfoPage()
	{
		return firmwareVersion.getText();
	}
	
	//*********Web Application related methods*****
	
	public void navigationToMeasurementDetailsPage()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			ElementUtils.safeClick(eeveeMeasurementInMeasurementPage);
			ElementUtils.isDisplayed(60, 1, assignAssetLinkInDetailsPage);
		}
	}
	
	public void getTestResultsHeaderText()
	{
		
	}
	
	
	
	
	
	
	public void recordRealDeviceMeasurement(int recordTime) throws Exception
	{
		ElementUtils.clickIfDisplayedAndEnabled(graphButton);
		ElementUtils.clickIfDisplayedAndEnabled(startRecordingButton);
		CommonUtils.wait(recordTime);
		ElementUtils.clickIfDisplayedAndEnabled(stopRecordingButton);
	}

	public void startAndStopLogging(String duration)
	{
		ElementUtils.safeClick(startLoggingButton);
		//CommonUtils.wait(65);
		CommonUtils.wait(Integer.parseInt(duration) * 60 + 5);
		ElementUtils.safeClick(stopLoggingButton);
		ElementUtils.isDisplayed(2, 1, downloadLogButton);
	}

	public void downloadLogs()
	{
		ElementUtils.safeClick(downloadLogButton);
		ElementUtils.isDisplayed(30, 1, downloadLogOkButton);
		ElementUtils.safeClick(downloadLogOkButton);
	}

	public void deviceNameEditText(String deviceName)
	{
		deviceNameEditTextField.clear();
		deviceNameEditTextField.sendKeys(deviceName);
	}

	public void clickOnDoneButtonInDeviceInfoPage()
	{
		doneButtonOnDeviceInfoPage.click();
		CommonUtils.wait(1);
		ElementUtils.isDisplayed(10, 1, captureMeasurementsLink); ///Need to check exact element for save button in capture page after tool connection
	}

	public String getMeasPrimaryValue()
	{
		return measurementValue.getText();
	}

	public String getDeviceValue()
	{
		return deviceValue.getText();
	}
	
	public String[] getConnectedDeviceNameInCapturePage()

	{
		return deviceNameInCaptureScreenForConnectedDevice.getText().split(" ");
	}
	
	public String getConnectedFC1555DeviceNameInCapturePage()

	{
		return deviceNameInCaptureScreenForConnectedDevice.getText();
	}

	public void disconnectDevice()
	{
		disconnectDeviceButton.click();
	}
	public String getMeasurementUnitForRecordedGraph()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			return deviceValueUnitForGraphs.getText();
		}
		return null;
	}

	public String getMeasurementUnitForScalarMeas()
	{
		return primaryValueUnit.getText();
	}

	public String assetNameInHistoryPage()
	{
		return assignedAssetInHistoryPage.getText();
	}

	/*public String getAssetPath()
	{
		return assetPathOfGraphMeas.getText(); ////Need to check this method or need to write this method
	}*/

	public void clickOnManualMeasureButton() throws Exception
	{
		ElementUtils.clickIfDisplayedAndEnabled(manualMeasurementButton);
	}

	public void saveManualMeasurement(String measurementValue, String measurementUnit)
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
		CommonUtils.wait(2);
		doneButton.click();
	}

	public void recordCameraMeasurement(int durationInSeconds)
	{
		cameraButton.click();
		if(DriverManager.getDriverName().equals("Android"))
		{
			androidPermissionAllowButton.click();
		} 
		startRecordingButton.click();
		CommonUtils.wait(durationInSeconds);
		stopRecordingButton.click();
		CommonUtils.wait(2);
		saveButton.click();
		cameraCloseButton.click();
	}

	public void clickBackORDoneButton()
	{
		backIconORDone.click();
	}

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
			ElementUtils.safeClick(androidEnableLocationServicesOkButton);
			//AndroidUtils.getAndroidDriver().pressKey(new KeyEvent().withKey(AndroidKey.BACK));            
			ElementUtils.click(1, androidWiFiInfoCloseButton);
		}
	}
	
	public void clickOnAssignAssetCell()
	{
		ElementUtils.safeClick(assignAssetCell);
	}

	/* Evvee Analysis On Web page Start Here  *///////
	
	
	
	public String unitConversion(int elementCount)
	{
		double convertValue;
		
		String  resistanceCoreValue=carouselPrimaryValue.get(elementCount).getText();
		String resistanceUnit=carouselPrimaryUnit.get(elementCount).getText();	
		if(highestUnit.getText().equals("TΩ"))
		{
			switch(resistanceUnit)
			{
			case "TΩ":
				return resistanceCoreValue;
			case "MΩ":
				if(resistanceCoreValue.startsWith(">"))
				{
					actualresistancevalue=CommonUtils.split(resistanceCoreValue,">")[1];
					convertValue=Double.parseDouble(actualresistancevalue)/100000;
					return ">"+Double.toString(convertValue);
				}
				else if(resistanceCoreValue.startsWith("<"))
				{
					actualresistancevalue=CommonUtils.split(resistanceCoreValue,"<")[1];
					convertValue=Double.parseDouble(actualresistancevalue)/100000;
					return "<"+Double.toString(convertValue);
				}
				else
				{
					convertValue=Double.parseDouble(resistanceCoreValue)/100000;
					return Double.toString(convertValue);
				}
				
			case "GΩ":
				if(resistanceCoreValue.startsWith(">"))
				{
					actualresistancevalue=CommonUtils.split(resistanceCoreValue,">")[1];
					convertValue=Double.parseDouble(actualresistancevalue)/1000;
					return ">"+Double.toString(convertValue);
				}
				else if(resistanceCoreValue.startsWith("<"))
				{
					actualresistancevalue=CommonUtils.split(resistanceCoreValue,"<")[1];
					convertValue=Double.parseDouble(actualresistancevalue)/1000;
					return "<"+Double.toString(convertValue);
				}
				else
				{
					convertValue=Double.parseDouble(resistanceCoreValue)/1000;
					return Double.toString(convertValue);
				}
				default:
			}	
		}
		else if(highestUnit.getText().equals("GΩ"))
		{
			switch(resistanceUnit)
			{
			case "MΩ":
				if(resistanceCoreValue.startsWith(">"))
				{
					actualresistancevalue=CommonUtils.split(resistanceCoreValue,">")[1];
					convertValue=Double.parseDouble(actualresistancevalue)/1000;
					return ">"+Double.toString(convertValue);
				}
				else if(resistanceCoreValue.startsWith("<"))
				{
					actualresistancevalue=CommonUtils.split(resistanceCoreValue,"<")[1];
					convertValue=Double.parseDouble(actualresistancevalue)/1000;
					return "<"+Double.toString(convertValue);
				}
				else 
				{
					convertValue=Double.parseDouble(resistanceCoreValue)/1000;
					return Double.toString(convertValue);
				}
			case "GΩ":
				return resistanceCoreValue;
				default:
			}
		}
		
		else
		{
			return resistanceCoreValue;
		}
		return null;
	}
	
	public int getCarouselSize()
	{
		return carouselMesaurmentList.size();
	}
	
	public void clickOnNextImage()
	{
		arrowNextButton.click();
	}
}

