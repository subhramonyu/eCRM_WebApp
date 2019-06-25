package com.fluke.connect.app.functional.client.pages;

import java.text.ParseException;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.fluke.connect.app.functional.client.pages.AssetsPage.AssetPageObjects;
import com.fluke.connect.app.testdata.FCM;
import com.fluke.connect.app.testdata.FCM.DataType;
import com.fluke.connect.app.testdata.FCM.DeviceList;
import com.fluke.connect.app.testdata.FCM.MeasurementType;
import com.fluke.connect.app.testdata.FCM.ShareFormat;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DateAndTimeUtils;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.FileUtil;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.GestureUtils.ObjectName;
import com.fluke.connect.app.utils.IOSUtils;
import com.google.common.collect.ImmutableMap;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.ScrollDiection;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class MeasurementDetailPage 
{
	@AndroidFindBy(id="com.fluke.deviceApp:id/equipment_chevron")
	private WebElement assignAssetArrowButton;
	
	//iOS three dot button in measurement detail page at the bottom
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSFindBy(accessibility="Actions")
	private WebElement actionButton;
	
	@AndroidFindBy(id = "com.fluke.deviceApp:id/menu_delete")
	@iOSFindBy(accessibility="Delete")
	private WebElement deleteButton;
	
	@AndroidFindBy(id="android:id/button1")
	@iOSFindBy(accessibility="Permanently delete measurement?")
	private WebElement confirmDeleteButton;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/menu_share")
	@iOSXCUITFindBy(accessibility = "Share")
	private WebElement shareButton;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/next")
	private WebElement shareNextButton;
	
	@AndroidFindBy(uiAutomator="new UiSelector().textContains(\"Gmail\")")
	private WebElement selectGmailButton;
	
	@AndroidFindBy(id="com.google.android.gm:id/to")
	private WebElement toEmailAddressTextField;
	
	@AndroidFindBy(id="com.google.android.gm:id/send")
	private WebElement sendEmailButton;
	
	@WithTimeout(time = 5, chronoUnit = ChronoUnit.SECONDS)
	@AndroidFindBy(id="com.fluke.deviceApp:id/close")
	private WebElement androidAssetPopupCloseButton;
	
	@AndroidFindBy(id="equipment_link")
	@iOSFindBy(accessibility="Asset")
	private WebElement assetButton;
	
	@AndroidFindBy(id = "assetPath")
	@iOSFindBy(accessibility="Assigned Equipment Label")
	@FindBy(how = How.CSS, using = "#locked-value")
	private WebElement assignedAssetLabel;
	
	@AndroidFindBy(id = "workOderInfo")
	@iOSXCUITFindBy(accessibility="Assigned Work Order Label")
	@FindBy(how = How.CSS, using = ".workorder #locked")
	private WebElement assignedWorkOrderLabel;
	
	@AndroidFindBy(id = "work_orders_row")
	@iOSXCUITFindBy(accessibility="Work Order")
	@FindBy(how = How.CSS, using = ".workorder #locked")
	private WebElement workOrderButton;
	
	@iOSFindBy(accessibility="Start recording")   
	private WebElement startRecordingButton;	
	
	@iOSFindBy(accessibility="Stop recording")
	private WebElement stopRecordingButton;
	
	@iOSXCUITFindBy(accessibility = "Voice Note")
	private WebElement voiceNoteButton;
	
	@AndroidFindBy(id = "add_text_note")
	@iOSXCUITFindBy(accessibility = "textNote")
	private WebElement textNoteTextArea;
	
	@iOSXCUITFindBy(accessibility = "Start or Stop Recording")
	private WebElement startStopVoiceRecordingButton;
	
	@iOSXCUITFindBy(accessibility = "Keyboard-Done")
	private WebElement keyBoardDoneButton;
	
	@AndroidFindBy(id = "text_note_text")
	@iOSXCUITFindBy(iOSNsPredicate = "name LIKE 'details'")
	private List<WebElement> addedVoiceAndTextNotesList;
	
	@AndroidFindBy(id = "text_note_text")
	@iOSXCUITFindBy(iOSNsPredicate = "name LIKE 'details'")
	private WebElement addedVoiceAndTextNotes;
	
	@iOSXCUITFindBy(accessibility = "OK")
	private WebElement voiceNoteOkButton;
	
	@AndroidFindBy(id = "send_email")
	@iOSXCUITFindBy(accessibility = "checkbox off")
	private WebElement emailMeCheckBox;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"as Text\")")
	private WebElement shareTextOption;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"as CSV\")")
	@iOSXCUITFindBy(iOSNsPredicate = "name LIKE 'Include CSV files'")
	private WebElement shareCSVOption;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"as XLS\")")
	@iOSXCUITFindBy(iOSNsPredicate = "name LIKE 'Include XLS files'")
	private WebElement shareXLSOption;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"as PDF\")")
	@iOSXCUITFindBy(iOSNsPredicate = "name LIKE 'Include PDF'")
	private WebElement sharePDFOption;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"as JPEG\")")
	@iOSXCUITFindBy(iOSNsPredicate = "name LIKE 'Include Graph'")
	private WebElement shareGraphOption;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"as IS-2\")")
	@iOSXCUITFindBy(iOSNsPredicate = "name LIKE 'Include thermal image IS2 files'")
	private WebElement shareTIIS2Option;
	
	@iOSXCUITFindBy(iOSNsPredicate = "name LIKE 'radio button off'")
	private WebElement shareRadioButton;
	
	@AndroidFindBy(id = "next")
	@iOSXCUITFindBy(accessibility = "Next")
	private WebElement shareMeasurementNextButton;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Gmail\")")
	private WebElement androidEmailClient;
	
	@AndroidFindBy(id = "com.google.android.gm:id/to")
	@iOSXCUITFindBy(iOSNsPredicate = "name LIKE 'toField'")
	private WebElement shareMeasurementToEmailTextField;
	
	@AndroidFindBy(id = "com.google.android.gm:id/send")
	@iOSXCUITFindBy(accessibility = "Send")
	private WebElement shareMeasurementSendButton;
	
	//capture measurement --> tap on device --> tap save --> SAVED
	@iOSXCUITFindBy(accessibility = "Title")
	private WebElement saveMeasurementTitleStaticText;
	
	@iOSXCUITFindBy(iOSNsPredicate = "name LIKE 'valueLabel'")
	private List<WebElement> nonScalarMeasurementValueList;
	
	@iOSFindBy(accessibility="Value")
	private List<WebElement> capturedMeasurementValueList;
	
	@iOSFindBy(accessibility="Units")
	private List<WebElement> capturedMeasurementUnitList;
	
	@iOSXCUITFindBy(iOSNsPredicate = "name LIKE 'unitLabel'")
	private List<WebElement> nonScalarMeasurementUnitList;
	
	@iOSXCUITFindBy(iOSNsPredicate = "name LIKE 'device name'")
	private List<WebElement> groupMeasurementDeviceNameList;
	
	@iOSXCUITFindBy(iOSNsPredicate = "name LIKE 'added date'")
	private List<WebElement> groupMeasurementCaptureDateList;
	
	@iOSXCUITFindBy(iOSNsPredicate = "name LIKE 'Value'")
	private List<WebElement> groupMeasurementScalarValueList;
	
	@iOSXCUITFindBy(iOSNsPredicate = "name LIKE 'Units'")
	private List<WebElement> groupMeasurementScalarUnitList;
	
	@iOSXCUITFindBy(iOSNsPredicate = "name LIKE 'valueLabel'")
	private List<WebElement> groupMeasurementNonScalarValueList;
	
	@iOSXCUITFindBy(iOSNsPredicate = "name LIKE 'unitLabel'")
	private List<WebElement> groupMeasurementNonScalarUnitList;
	
	@AndroidFindBy(id = "capture_date_time")
	@iOSXCUITFindBy(iOSNsPredicate = "name LIKE 'added date'")
	private WebElement measurementCaptureDate;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"/\")")
	@iOSXCUITFindBy(iOSNsPredicate = "name CONTAINS '/'")
	private List<WebElement> tiDownloadMeasurementCaptureDate;
	
	@FindBy(how = How.CSS, using = ".averageTIValue")
	@AndroidFindBy(id = "centerPointTemp")
	@iOSXCUITFindBy(iOSNsPredicate = "name LIKE 'valueLabel'")
	private WebElement measurementValue;
	
	@FindBy(how = How.CSS, using = ".unitType")
	@AndroidFindBy(id = "centerPointTemp")
	@iOSXCUITFindBy(iOSNsPredicate = "name LIKE 'unitLabel'")
	private WebElement measurementUnit;
	
	@AndroidFindBy(id="thermal_imager")
	@iOSFindBy(accessibility="device name")
	private WebElement tiDeviceName;
	
	@AndroidFindBy(id="device_name")
	@iOSFindBy(accessibility="device name")
	private WebElement capturedMeasurementDeviceName;
	
	@AndroidFindBy(id = "capture_date_time")
	@iOSFindBy(accessibility = "added date")
	private WebElement capturedMeasurementTimeStampText;
	
	@AndroidFindBy(id = "device_value")
	@iOSFindBy(accessibility = "Value")
	private WebElement capturedMeasurementValue;
	
	@AndroidFindBy(id = "device_value_unit")
	@iOSFindBy(accessibility = "Units")
	private WebElement capturedMeasurementUnit;
	
	@FindBy(how = How.CSS, using = ".subheader-back-link")
	@AndroidFindBy(id = "back_button")
	@iOSXCUITFindBy(accessibility = "Back")
	private WebElement backButton;
	
	@AndroidFindBy(id = "measurement_format_container")
	private WebElement androidShareMeasurementDataCell;
	
	@AndroidFindBy(id = "recorded_format_container")
	private WebElement androidShareRecordedDataCell;
	
	@AndroidFindBy(id = "thermal_images_format_container")
	private WebElement androidShareThermalImagesCell;
	
	@AndroidFindBy(id = "voice_text_format_container")
	private WebElement androidShareTextVoiceNotesCell;
	
	@AndroidFindBy(id = "camera_images_format_container")
	private WebElement androidShareCameraImagesCell;
	
	@FindBy(how = How.CSS, using = ".maxVal")
	@AndroidFindBy(id = "max_temp")
	@iOSXCUITFindBy(accessibility = "maxTempLabel")
	private WebElement tiMaxTempStaticText;
	
	@FindBy(how = How.CSS, using = ".minVal")
	@AndroidFindBy(id = "min_temp")
	@iOSXCUITFindBy(accessibility = "maxTempLabel")
	private WebElement tiMinTempStaticText;
	
	@AndroidFindBy(id = "action_cancel")
	@iOSXCUITFindBy(accessibility = "Cancel")
	@FindBy(how = How.CSS, using = "#dialog_ok")
	private WebElement assignWorkOrderPageCancelButton;
	
	@FindBy(how = How.CSS, using = ".maxUnitType")
	private WebElement webMaxValueUnit;
	
	@FindBy(how = How.CSS, using = ".minUnitType")
	private WebElement webMinValueUnit;
	
	@FindBy(how = How.CSS, using = ".minMaxTIValue")
	private WebElement webMinMaxLabel;
	
	@iOSXCUITFindBy(accessibility = "Save")
	private WebElement measurementSaveButton;
	
	@WithTimeout(chronoUnit = ChronoUnit.SECONDS, time = 4)
	@AndroidFindBy(id = "action_bar_item_left")
	@iOSXCUITFindBy(accessibility = "backBarButton")
	private WebElement assignAssetGroupBackButton;
	
	@FindBy(how = How.CSS, using = "#locked-value")
	private List<WebElement> assignedAssetWorkOrderLabel;
	
	@AndroidFindBy(id = "com.fluke.deviceApp:id/primary_value_unit")	
	private  WebElement captureBeakerMeasurement;
	
	@FindBy(how = How.CSS, using = "a[data-action='assign']")
	private WebElement workOrderAssignButton;
	
	@FindBy(how=How.CSS,using=".equipment-list-filter-new")  //filter button in assign asset page
	@AndroidFindBy(id="com.fluke.deviceApp:id/sortB")
	@iOSXCUITFindBy( iOSNsPredicate = "name = 'Filter Button' AND visible = true")
	private WebElement filterButton;
	
	
	//****CoachMark Related Elements****
	
	@AndroidFindBy(id = "com.fluke.deviceApp:id/title")	
	private  WebElement titleOfCoachMarks;
	
	@AndroidFindBy(id = "com.fluke.deviceApp:id/message")	
	private  WebElement coachMarkMessage;
	
	@WithTimeout(time = 4, chronoUnit = ChronoUnit.SECONDS)
	@AndroidFindBy(id = "com.fluke.deviceApp:id/button")	
	private  WebElement coachMarkNextButton;
	
	@WithTimeout(time = 4, chronoUnit = ChronoUnit.SECONDS)
	@AndroidFindBy(id = "com.fluke.deviceApp:id/title_label")	
	private  WebElement youAreOnTrackTitle;
	
	@WithTimeout(time = 4, chronoUnit = ChronoUnit.SECONDS)
	@AndroidFindBy(id = "com.fluke.deviceApp:id/title_desc")	
	private  WebElement youAreOnTrackTitleDescription;
	
	@WithTimeout(time = 4, chronoUnit = ChronoUnit.SECONDS)
	@AndroidFindBy(id = "com.fluke.deviceApp:id/actionBtn")
	@iOSXCUITFindBy(accessibility = "next")	
	private  WebElement gotItButton;
	
	@WithTimeout(time = 3, chronoUnit = ChronoUnit.SECONDS)
	@AndroidFindBy(id = "com.fluke.deviceApp:id/button")	
	@iOSXCUITFindBy(accessibility = "next")	
	private  WebElement nextButton;
	
	
	private AssetsPage assetPage;
	private boolean voiceNoteAccessFlag;
	final private String DEVICE_NAME_PREFIX = DriverManager.getDriverName() + " "; 
	final private String DATE_SUFFIX = " Date";
	final private String VALUE_SUFFIX = " Value";
	final private String UNIT_SUFFIX = " Unit";
	private String mDateValue;
	private GestureUtils gestureUtils;
	
	public MeasurementDetailPage()
	{
		CommonUtils.initElements(this, 3);
		assetPage = new AssetsPage();
		voiceNoteAccessFlag = true;
		gestureUtils = new GestureUtils();
	}
	
	public enum MeasurementDetailPageObjects
	{
		TI_MEASUREMENT_VALUE, TI_MEASUREMENT_UNIT, TI_MEASUREMENT_DEVICE_NAME, TI_MEASUREMENT_TIME_STAMP,
		DATE_SUFFIX, VALUE_SUFFIX, UNIT_SUFFIX, BACK_BUTTON, ANDROID_ASSET_POPUP_CLOSE_BUTTON,
		TI_MAX_TEMP, TI_MIN_TEMP, 
		
		CAPTURED_MEASUREMENT_DEVICE_NAME, CAPTURED_MEASUREMENT_VALUE, CAPTURED_MEASUREMENT_UNIT,
		
		DEVICE_NAME_PREFIX, ASSIGN_WORKORDER_PAGE_CANCEL_BUTTON, CURRENT_DEPLOYMENT, 
		
		
		MOBILE_SYNC_DEPLOYMENT, WEB_SYNC_ANDROID_DEPLOYMENT, WEB_SYNC_IOS_DEPLOYMENT, 
		
		
		WEB_MAX_UNIT, WEB_MIN_UNIT, WEB_MAX_MIN_LABEL, MEASUREMENT_CAPTURE_DATE,
		
		MEASUREMENT_SAVE_BUTTON, SHARE_BUTTON, ASSIGN_ASSET_GROUP_BACK_BUTTON,CAPTURED_BEAKER_MEASUREMENT_UNIT
	}
	
	public WebElement getMeasurementDetailPageWebElement(MeasurementDetailPageObjects objectName)
	{
		switch(objectName)
		{
		case TI_MEASUREMENT_DEVICE_NAME:
			return tiDeviceName;
		case TI_MEASUREMENT_VALUE:
			return measurementValue;
		case TI_MEASUREMENT_UNIT:
			return measurementUnit;
		case TI_MEASUREMENT_TIME_STAMP:
			return measurementCaptureDate;
		case BACK_BUTTON:
			return backButton;
		case ANDROID_ASSET_POPUP_CLOSE_BUTTON:
			return androidAssetPopupCloseButton;
		case TI_MAX_TEMP:
			return tiMaxTempStaticText;
		case TI_MIN_TEMP:
			return tiMinTempStaticText;
		case ASSIGN_WORKORDER_PAGE_CANCEL_BUTTON:
			return assignWorkOrderPageCancelButton;
		case WEB_MAX_UNIT:
			return webMaxValueUnit;
		case WEB_MIN_UNIT:
			return webMinValueUnit;
		case WEB_MAX_MIN_LABEL:
			return webMinMaxLabel;
		case MEASUREMENT_SAVE_BUTTON:
			return measurementSaveButton;
		case CAPTURED_MEASUREMENT_DEVICE_NAME:
			return capturedMeasurementDeviceName;
		case CAPTURED_MEASUREMENT_VALUE:
			return capturedMeasurementValue;
		case CAPTURED_MEASUREMENT_UNIT:
			return capturedMeasurementUnit;
		case SHARE_BUTTON:
			return shareButton;
		case ASSIGN_ASSET_GROUP_BACK_BUTTON:
			return assignAssetGroupBackButton;
		case CAPTURED_BEAKER_MEASUREMENT_UNIT:
		      return captureBeakerMeasurement;
		case MEASUREMENT_CAPTURE_DATE:
			return measurementCaptureDate;
			default:
				return null;
		}
	}
	
	public Object getMeasurementDetailPageObject(MeasurementDetailPageObjects objectName)
	{
		switch(objectName)
		{
		case DEVICE_NAME_PREFIX:
			return DEVICE_NAME_PREFIX;
		case DATE_SUFFIX:
			return DATE_SUFFIX;
		case VALUE_SUFFIX:
			return VALUE_SUFFIX;
		case UNIT_SUFFIX:
			return UNIT_SUFFIX;
			default:
				return null;
		}	
	}
	
	public enum MeasturementAttributes
	{
		IOS_DEVICE_NAME("device name"),
		IOS_VALUE_LABEL("valueLabel"),
		IOS_CNX_VALUE_LABEL("Value"),
		IOS_UNIT_LABEL("unitLabel"),
		IOS_CNX_UNIT_LABEL("Units"),
		IOS_MAX_MIN_VALUE("maxTempLabel"),
		ANDROID_DEVICE_NAME("measurement_device"),
		ANDROID_VALUE_LABEL("measurement_data"),
		ANDROID_UNIT_LABEL("measurement_data_unit"),
		WEB_DEVICE_NAME(".measUsername"),
		WEB_VALUE(".averageTIValue"),
		WEB_CNX_VALUE(".scalarValue"),
		WEB_MAX_VALUE(".maxVal"),
		WEB_MIN_VALUE(".minVal"),
		WEB_VALUE_UNIT(".unitType"),
		WEB_CNX_UNIT(".scalarUnits"),
		WEB_MAX_UNIT(".maxUnitType"),
		WEB_MIN_UNIT(".minUnitType"),
		WEB_MIN_MAX_LABEL(".minMaxTIValue"),
		WEB_ASSET_LABEL("#locked-value"),
		WEB_WORK_ORDER_LABEL("div[data-meas-group-id *= '-']");
		
		
		private String attributeValue;

		private MeasturementAttributes(String attributeValue) 
	    {
	        this.attributeValue = attributeValue;
	    }

	    public String getAttributeValue() 
	    {
	        return attributeValue;
	    }
	}
	
	public void assignAsset(String assetGroupName, String assetName, String assetTestPointName) throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			handleMeasurementPrompt(3);
		ElementUtils.reliableClick(1, assetButton, assignAssetGroupBackButton, 30);
		assetPage.assignAsset(assetGroupName, assetName, assetTestPointName, 0);
	}
	
	//CM -- Capture Measurements
	public void assignAssetCM(String assetGroupName, String assetName, String assetTestPointName) throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			handlePrompt(GestureUtils.ObjectName.ASSET_PROMPT);
			ElementUtils.reliableClick(1, assetButton, assignAssetGroupBackButton, 30);
		}
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			CommonUtils.wait(3);
			ElementUtils.safeClick(10,2,assetPage.getAssetPageWebElement(AssetPageObjects.ASSIGN_ASSET_DIALOG_OK));
		assetPage.assignAssetCM(assetGroupName, assetName, assetTestPointName, 0);
	}
	
	public void loadAsset(String assetGroupName, String assetName) throws Exception
	{
		ElementUtils.isEnabledReliableClick(1, assetGroupName, filterButton, 9);
		//assetPage.clickOnAssetGroupNameCM(assetGroupName);
		ElementUtils.isDisplayed(5, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, assetName, null, null, null, null);
	}
	
	public boolean isAssetAssigned(String assetName)
	{
		handlePrompt(GestureUtils.ObjectName.WORK_ORDER_PROMPT);
		if(ElementUtils.isDisplayed(5, assignedAssetLabel))
			return assignedAssetLabel.getText().contains(assetName);
		else
			return false;
	}
	
	public void assignWorkOrder(String workOrderTitle) throws Exception
	{
		ElementUtils.reliableClick(1, workOrderButton, assignWorkOrderPageCancelButton, 30);
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			ElementUtils.safeClick(assignWorkOrderPageCancelButton);
		IOSUtils.isPageLoaded(30, "Refreshing Data...");
		gestureUtils.mScroll(workOrderTitle, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, workOrderTitle, LocatorStrategy.IOS_LOCATOR_STRATEGY_PREDICATE_STRING, "type == 'XCUIElementTypeCell' AND name == '"+workOrderTitle+"'", LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS, workOrderTitle).click();
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			ElementUtils.safeClick(workOrderAssignButton);
	}
	
	public boolean isWorkOrderAssigned(String workOrderNumber)
	{
		handlePrompt(GestureUtils.ObjectName.TEXT_NOTE_PROMPT);
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			return assignedWorkOrderLabel.getText().contains(workOrderNumber);
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				return ElementUtils.isDisplayed(5, ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT_CONTAINS, workOrderNumber));
		else
			return false;
	}
	
	public void addTextNote(String textNote)
	{
		textNoteTextArea.click();
		ElementUtils.sendKeys(textNoteTextArea, textNote);
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			ElementUtils.safeClick(keyBoardDoneButton);
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			gestureUtils.getJavaScriptExecutor().executeScript("mobile: performEditorAction", ImmutableMap.of("action", "Done"));
			for(int i = 0; i < 30; i++)
			{
				if(ElementUtils.isDisplayed(addedVoiceAndTextNotes))
					break;
				else {
					CommonUtils.wait(1);
					gestureUtils.getJavaScriptExecutor().executeScript("mobile: performEditorAction", ImmutableMap.of("action", "Done"));
				}
			}
		}
	}
	
	public void addVoiceNote(int voiceNoteDuration)
	{
		voiceNoteButton.click();
		startStopVoiceRecordingButton.click();
		if(voiceNoteAccessFlag) {
			voiceNoteOkButton.click();
			voiceNoteAccessFlag = false;
		}
		CommonUtils.wait(voiceNoteDuration);
		startStopVoiceRecordingButton.click();
		CommonUtils.wait(2);  
	}
	
	public boolean isTextNoteAdded(String textNote)
	{
		for(WebElement element:addedVoiceAndTextNotesList)
		{
			if(element.getText().equals(textNote))
			{
				return true;
			}
		}
		return false;
	}
	
	public void deleteMeasurement() throws Exception
	{
		if(DriverManager.getDriverName().equals("iOS"))
			actionButton.click();
		ElementUtils.reliableClick(3, deleteButton, confirmDeleteButton, 5);
		confirmDeleteButton.click();
	}
	
	
	
	public void clickOnAndroidAssetPopupCloseButton()
	{
		try
		{
			if(DriverManager.getDriverName().equals("Android"))
			{
				androidAssetPopupCloseButton.click();
			}	
		}
		catch(Exception e){ }
	}
	
	public boolean isActionsButtonDisplayed()
	{
		return actionButton.isDisplayed();
	}
	
	public void shareMeasurement(String recipientAddress, DataType dataType, ShareFormat shareFormat, boolean emailMeFlag) throws Exception
	{
		if(emailMeFlag)
			ElementUtils.click(5, emailMeCheckBox);
		configureDataShareOptions(dataType, shareFormat);
		ElementUtils.click(2, shareMeasurementNextButton);
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			ElementUtils.click(2, androidEmailClient);
		shareMeasurementToEmailTextField.click();
		ElementUtils.sendKeys(shareMeasurementToEmailTextField, recipientAddress);
		ElementUtils.click(2, shareMeasurementSendButton);
	}
	
	public void configureDataShareOptions(DataType dataType, ShareFormat shareFormat) throws Exception
	{	
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			switch(dataType)
			{
			case MEASUREMENT_DATA:
				ElementUtils.click(1, androidShareMeasurementDataCell);
				selectShareFormat(shareFormat);
				break;
			case RECORDED_DATA:
				ElementUtils.click(1, androidShareRecordedDataCell);
				selectShareFormat(shareFormat);
				break;
			case THERMAL_IMAGES:
				ElementUtils.click(1, androidShareThermalImagesCell);
				selectShareFormat(shareFormat);
				break;
			case TEXT_VOICE_NOTES:
				ElementUtils.click(1, androidShareTextVoiceNotesCell);
				selectShareFormat(shareFormat);
				break;
			case CAMERA_IMAGES:
				ElementUtils.click(1, androidShareCameraImagesCell);
				selectShareFormat(shareFormat);
				break;
				default:
			}
		}
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			selectShareFormat(shareFormat);
	}
	
	public void selectShareFormat(ShareFormat shareFormat) throws Exception
	{
		switch(shareFormat)
		{
		case TEXT:
			ElementUtils.click(2, shareTextOption);
			break;
		case CSV:
			ElementUtils.click(2, shareCSVOption);
			break;
		case XLS:
			ElementUtils.click(2, shareXLSOption);
		    break;
		case PDF:
			ElementUtils.click(2, sharePDFOption);
		    break;
		case GRAPH:
			ElementUtils.click(2, shareGraphOption);
		    break;
		case IS2:
			ElementUtils.click(2, shareTIIS2Option);
		    break;
		default:
			ElementUtils.click(2, shareRadioButton);
		}
	}
	
	public void captureMeasurementsDetails(String propertiesFilePath, String deviceName, MeasurementType measurementType, int measurementIndex) throws ParseException
	{
		deviceName = DEVICE_NAME_PREFIX + deviceName;
		switch(measurementType)
		{
		case SCALAR:
			FileUtil.writeProperty(propertiesFilePath, deviceName, capturedMeasurementDeviceName.getText());
			FileUtil.writeProperty(propertiesFilePath, deviceName + DATE_SUFFIX, capturedMeasurementTimeStampText.getText());
			FileUtil.writeProperty(propertiesFilePath, deviceName+ VALUE_SUFFIX, capturedMeasurementValue.getText());
			FileUtil.writeProperty(propertiesFilePath, deviceName+ UNIT_SUFFIX, capturedMeasurementUnit.getText());
			break;
		case NON_SCALAR:
			FileUtil.writeProperty(propertiesFilePath, deviceName, this.tiDeviceName.getText());
			FileUtil.writeProperty(propertiesFilePath, deviceName+ DATE_SUFFIX, capturedMeasurementTimeStampText.getText());
			FileUtil.writeProperty(propertiesFilePath, deviceName + " Measurements Count", String.valueOf(nonScalarMeasurementValueList.size()));
			for(int i=0; i< nonScalarMeasurementValueList.size(); i++)
			{
				FileUtil.writeProperty(propertiesFilePath, deviceName+" Value "+i,nonScalarMeasurementValueList.get(i).getText());
			}
			for(int i=0; i< nonScalarMeasurementUnitList.size(); i++)
			{
				FileUtil.writeProperty(propertiesFilePath, deviceName+" Unit "+i,nonScalarMeasurementUnitList.get(i).getText());
			}
			break;
		case GROUP:
			FileUtil.writeProperty(propertiesFilePath, deviceName, deviceName);
			FileUtil.writeProperty(propertiesFilePath, deviceName +" Date", groupMeasurementCaptureDateList.get(0).getText());
			FileUtil.writeProperty(propertiesFilePath, deviceName + " Measurements Scalar Value Count", String.valueOf(groupMeasurementScalarValueList.size()));
			FileUtil.writeProperty(propertiesFilePath, deviceName + " Device Count", String.valueOf(groupMeasurementDeviceNameList.size()));
			for(int i=0;i<groupMeasurementDeviceNameList.size(); i++)
			{
				FileUtil.writeProperty(propertiesFilePath, deviceName +" device "+ i, groupMeasurementDeviceNameList.get(i).getText());
			}
			for(int i=0;i<groupMeasurementCaptureDateList.size(); i++)
			{
				FileUtil.writeProperty(propertiesFilePath, deviceName +" Capture Date "+ i, groupMeasurementCaptureDateList.get(i).getText());
			}
			for(int i=0;i<groupMeasurementScalarValueList.size(); i++)
			{
				FileUtil.writeProperty(propertiesFilePath, deviceName +" Scalar Measurement Value "+ i, groupMeasurementScalarValueList.get(i).getText());
			}
			for(int i=0;i<groupMeasurementScalarUnitList.size(); i++)
			{
				FileUtil.writeProperty(propertiesFilePath, deviceName +" Scalar Measurement Unit "+ i, groupMeasurementScalarUnitList.get(i).getText());
			}
			break;
		case RECORDED:
			FileUtil.writeProperty(propertiesFilePath, deviceName, this.tiDeviceName.getText());
			FileUtil.writeProperty(propertiesFilePath, deviceName+ DATE_SUFFIX, capturedMeasurementTimeStampText.getText());
			break;
		case TI:
			FileUtil.writeProperty(propertiesFilePath, deviceName, this.tiDeviceName.getText());
			FileUtil.writeProperty(propertiesFilePath, deviceName+ DATE_SUFFIX , measurementCaptureDate.getText());
			FileUtil.writeProperty(propertiesFilePath, deviceName+ UNIT_SUFFIX , measurementUnit.getText());
			FileUtil.writeProperty(propertiesFilePath, deviceName+ VALUE_SUFFIX , measurementValue.getText());
			break;
		case TI_DOWNLOAD:
			FileUtil.writeProperty(propertiesFilePath, deviceName +" "+measurementIndex, FCM.DeviceList.TI.getAttributeValue());
			mDateValue = null;
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				mDateValue = tiDownloadMeasurementCaptureDate.get(measurementIndex).getText().replace(",", "");
				mDateValue = DateAndTimeUtils.getDateAsAString(mDateValue, "M/dd/yy hh:mm:ss a", "MM/dd/yy HH:mm");
			}
			else
				mDateValue = tiDownloadMeasurementCaptureDate.get(measurementIndex).getText();
			FileUtil.writeProperty(propertiesFilePath, deviceName+ DATE_SUFFIX +" "+measurementIndex, mDateValue);
			break;
		}
	}
	
	public String getDevicePrefix(MeasurementDetailPageObjects deploymentName)
	{
		switch(deploymentName)
		{
		case CURRENT_DEPLOYMENT:
			return DriverManager.getDriverName() + " ";
		case MOBILE_SYNC_DEPLOYMENT:
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				return Config.IOS_DRIVER + " ";
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				return Config.ANDROID_DRIVER + " ";
		case WEB_SYNC_ANDROID_DEPLOYMENT:
			return Config.ANDROID_DRIVER + " ";
		case WEB_SYNC_IOS_DEPLOYMENT:
			return Config.IOS_DRIVER + " ";
			default:
				return null;
		}
	}
	
	public int getMeasurementIndices(MeasurementDetailPageObjects deploymentName)
	{
		switch(deploymentName)
		{
		case CURRENT_DEPLOYMENT:
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				return Integer.parseInt(DeviceList.ANDROID_TI_DOWNLOAD_START.getAttributeValue());
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				return Integer.parseInt(DeviceList.IOS_TI_DOWNLOAD_START.getAttributeValue());
		case MOBILE_SYNC_DEPLOYMENT:
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				return Integer.parseInt(DeviceList.IOS_TI_DOWNLOAD_START.getAttributeValue());
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				return Integer.parseInt(DeviceList.ANDROID_TI_DOWNLOAD_START.getAttributeValue());
		case WEB_SYNC_ANDROID_DEPLOYMENT:
			return Integer.parseInt(DeviceList.ANDROID_TI_DOWNLOAD_START.getAttributeValue());
		case WEB_SYNC_IOS_DEPLOYMENT:
			return Integer.parseInt(DeviceList.IOS_TI_DOWNLOAD_START.getAttributeValue());
			default:
			return 0;
		}
	}
	
//	**********New Coach Mark Related test Cases**********
	
	public String getCoachMarkTitleAndMessage(FCM.CoachMarkTitleAndMessage messagesAndTitle)
	{
		switch(messagesAndTitle)
		{
		case ADD_ASSET_COACHMARK_TITLE:
			return titleOfCoachMarks.getText();
		case ADD_ASSET_COACHMARK_MESSAGE:
			return coachMarkMessage.getText();
		case ADD_NOTE_COACHMARK_TITLE:
			return titleOfCoachMarks.getText();
		case ADD_NOTE_COACHMARK_MESSAGE:
			return coachMarkMessage.getText();
		case SHARE_COACHMARK_TITLE:
			return titleOfCoachMarks.getText();	
		case SHARE_COACHMARK_MESSAGE:
			return coachMarkMessage.getText();
		case YOU_ARE_ONTRACK_TITLE:
			return youAreOnTrackTitle.getText();
		case YOU_ARE_ONTRACK_DESCRIPTION:
			return youAreOnTrackTitleDescription.getText();
		default:
			return null;
		}
	}
	
	public void assetCoarchMarkInDetailsPage()
	{
		ElementUtils.safeClick(coachMarkNextButton);
		//coachMarkNextButton.click();
	}
	
	public void saveAndDocumentGotItButon()
	{
		ElementUtils.safeClick(coachMarkNextButton);
		//coachMarkNextButton.click();
	}
	public void addNoteCoarchMarkInDetailsPage()
	{
		ElementUtils.safeClick(coachMarkNextButton);
		//coachMarkNextButton.click();
	}
	
	public void shareCoarchMarkInDetailsPage()
	{
		ElementUtils.safeClick(coachMarkNextButton);
		//coachMarkNextButton.click();
	}
	
	public void youAreOnTrackCoarchMarkInDetailsPage()
	{
		ElementUtils.safeClick(gotItButton);
		
	}
	
	public void nextAndGotItButtonClick()
	{
		for(int i=0; i<3;i++)
		{
		CommonUtils.wait(2);
		ElementUtils.safeClick(coachMarkNextButton);
		}
		
		ElementUtils.safeClick(gotItButton);
		
	}
	
	public void handlePrompt(GestureUtils.ObjectName objectName) {
		switch(objectName) {
		case ASSET_PROMPT:
			if(FCM.assetOnBoardFlag) {
				handleMeasurementPrompt(3);
				FCM.assetOnBoardFlag = false; 
			}
			break;
		case WORK_ORDER_PROMPT:
			if(FCM.workOrderOnBoardFlag) {
				handleMeasurementPrompt(2);
				FCM.workOrderOnBoardFlag = false; 
			}
			break;
		case TEXT_NOTE_PROMPT:
			if(FCM.textNoteOnBoardFlag) {
				handleMeasurementPrompt(2);
				FCM.textNoteOnBoardFlag = false;
			}
			break;
		case SHARE_PROMPT:
			if(FCM.shareOnBoardFlag) {
				handleMeasurementPrompt(1);
				FCM.shareOnBoardFlag = false;
			}
			break;
		default:
				break;
		}
	}
	
	public boolean handleMeasurementPrompt(int promptCount) { 
		try {
			boolean returnFlag = false;
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
				if(ElementUtils.isNotNull(2, nextButton)) {
					returnFlag = true;
					for(int i = 0; i < promptCount; i++) {
						CommonUtils.wait(1);
						gestureUtils.clickOnCordinates(nextButton, 30, 30);
					}
				}
			}
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
				if(ElementUtils.isDisplayed(2, nextButton)) {
					returnFlag = true;
					for(int i = 0; i < promptCount; i++) {
						CommonUtils.wait(1);
						ElementUtils.safeClick(nextButton);
					}
				}
			}
			return returnFlag;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
