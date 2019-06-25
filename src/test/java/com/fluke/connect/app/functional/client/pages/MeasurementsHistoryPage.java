package com.fluke.connect.app.functional.client.pages;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

import java.text.ParseException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.fluke.connect.app.functional.client.pages.MeasurementDetailPage.MeasurementDetailPageObjects;
import com.fluke.connect.app.testdata.FCM;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DateAndTimeUtils;
import com.fluke.connect.app.utils.DriverFactory;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.FileUtil;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.Gestures;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.ScrollDiection;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

@SuppressWarnings("unused")
public class MeasurementsHistoryPage 
{
	@FindBy(how = How.CSS, using = "a[href='/saved-session']")
	@AndroidFindBy(id = "completed_sessions_button")
	@iOSXCUITFindBy(accessibility = "View Completed Sessions")
	private WebElement completedSessionsLink;
	
	@FindBy(how = How.CSS, using = "a[href='/remote-monitoring']")
	@AndroidFindBy(id = "active_sessions_button")
	@iOSXCUITFindBy(accessibility = "View Active Monitoring Sessions")
	private WebElement activeMonitoringSessionsLink;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/measurement_device")
	@iOSXCUITFindBy(accessibility="device name")
	private List<WebElement> measurementsList;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/measurement_date")
	@iOSXCUITFindBy(accessibility="added date")
	private WebElement capturedMeasurementDate;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/measurement_date")
	@iOSXCUITFindBy(accessibility="added date")
	private List<WebElement> capturedMeasurementDateList;
	
	@iOSFindBy(accessibility="disclosure_arrow")
	@AndroidFindBy(id="com.fluke.deviceApp:id/equipment_chevron")
	private WebElement assignAssetArrowButton;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/equipment_link")
	@iOSXCUITFindBy(accessibility="Asset")
	private WebElement assignAssetCell;

	@AndroidFindBy(id="com.fluke.deviceApp:id/back_button") 
	@HowToUseLocators(iOSXCUITAutomation = ALL_POSSIBLE)
	@iOSXCUITFindBy(accessibility="SAVE")   
	@iOSXCUITFindBy(accessibility="Save")
	private WebElement doneButton;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/device_value")
	@iOSXCUITFindBy(accessibility="Value")
	private WebElement capturedMeasurementValue;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/device_value_unit")
	@iOSXCUITFindBy(accessibility="Units")
	private WebElement capturedMeasurementUnits;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/back_button")
	@iOSXCUITFindBy(accessibility="Back")
	private WebElement backButton;
	
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/delete")
	@iOSXCUITFindBy(accessibility="Delete")
	private WebElement deleteMeasurementsButton;
	
	@FindBy(how = How.CSS, using = ".iconDelete")
	@AndroidFindBy(id="com.fluke.deviceApp:id/done")
	@iOSXCUITFindBy(accessibility="Delete")
	private WebElement deleteMultipleMeasurementsButton;
	
	@FindBy(how = How.CSS, using = ".major-btn")
	@AndroidFindBy(id="android:id/button1")
	@iOSXCUITFindBy(iOSNsPredicate = "name CONTAINS 'Permanently delete'")
	private WebElement confirmDeleteMultipleMeasurementsButton;
	
	@iOSFindBy(accessibility="In progress")
	private WebElement iOSInProgressLoadingSpinner;
	
	@iOSFindBy(accessibility="Title")
	private WebElement selectedMeasurementCountTitle;
	
	@iOSXCUITFindBy(iOSNsPredicate = "name LIKE 'valueLabel'")
	private List<WebElement> nonScalarMeasurementValueList;
	
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
	
	@iOSXCUITFindBy(accessibility="Work Order")
	private WebElement workOrderButton;
	
	@iOSXCUITFindBy(accessibility = "Title")
	private WebElement saveMeasurementTitleStaticText;
	
	// object for Eevee measurements verification for practice
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/measurement_device")
	private WebElement eeveeMeasurementsTitle;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/data_layout")
	private WebElement measurementsTile;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/measurement_date")
	private WebElement capturedMeasurementDate1;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/primaryValue")
	private WebElement resistanceValue;

	@AndroidFindBy(id="com.fluke.deviceApp:id/secondaryValue")
	private WebElement voltageValue;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/tertiaryValue")
	private WebElement currentValue;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/primaryValueUnit")
	private WebElement resistanceUnit;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/secondaryValueUnit")
	private WebElement voltageUnit;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/tertiaryValueUnit")
	private WebElement currentUnit;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/test_conditions_tab")
	@iOSXCUITFindBy(accessibility = "TEST CONDITIONS")
	private WebElement testConditionTab;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/calculated_results_tab")
	@iOSXCUITFindBy(accessibility = "CALCULATED RESULTS")
	private WebElement calculatedResultsTab;
	
	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeCell' AND name CONTAINS ','")
	private List<WebElement> tiMeasurementList;
	
	@FindBy(how = How.CSS, using = ".measurementSelect")
	private List<WebElement> webMeasurementCellCheckBoxList;

	@FindBy(how = How.CSS, using = "[data-is-thermal-image=\"true\"]")
	private List<WebElement> mulitiplethermalMeasurement;

	@FindBy(how = How.CSS, using = "#measDetailDataMuse")
	private List<WebElement> museMeasurementTitle;
	
	@FindBy(how = How.CSS, using = "#meas-detail-link")
	private WebElement measurementBackbutton;
	
	@FindBy(how = How.CSS, using = ".measDetailImg")
	private WebElement thermalImageDetail;
	
	@FindBy(how=How.CSS,using=".focalCenter")
	private WebElement imgReader;
	
	@FindBy(how=How.CSS,using=".focalCenter")
	private List<WebElement> imgReaders_groupedmesaurements;
	
	@FindBy(how = How.CSS, using = ".filter-label")
	private WebElement filterOption;
	
	@FindBy(how = How.CSS, using = ".filter-item[data-key='thermalImage']")
	private WebElement thermalfilter;
	
	@FindBy(how = How.CSS, using = "#measDetailDataMuse[data-detail-type='image']")
	private List<WebElement>museMeasurementDetail;
	
	@FindBy(how = How.CSS, using = ".right-sidebar-header")
	private WebElement titleMuse;
	
	@FindBy(how = How.CSS, using = "[data-is-grouped='1'] #museBleThermalImage")
	private List<WebElement> groupedMeasurement;
	
	@FindBy(how = How.CSS, using = "#measurementGroups > div > div + div")
	private  WebElement webScroll1;
	
	@AndroidFindBy(id = "sortB")
	@FindBy(how = How.CSS, using = ".current-label")  //for web sort button
	@iOSXCUITFindBy(iOSNsPredicate = "type = 'XCUIElementTypeButton' AND name = 'Filter'")
	private WebElement sortAndFilterButton;
	
	@AndroidFindBy(id = "search_text")
	@iOSXCUITFindBy(className = "XCUIElementTypeSearchField")
	private WebElement searchTextField;
	
	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Search'")
	private WebElement keyboardSearchButton;
	
	@AndroidFindBy(id = "sort_by_date")
	@FindBy(how = How.CSS, using = "li[data-value='date_desc']")
	@iOSXCUITFindBy(accessibility = "Date")
	private WebElement sortByDateRadioButton;
	
	@FindBy(how = How.CSS, using = "li[data-value='date_asc']")
	private WebElement sortByDateAscButton;
	
	@AndroidFindBy(id = "sort_by_equipment")
	@iOSXCUITFindBy(accessibility = "Asset")
	private WebElement sortByAssetRadioButton;
	
	@AndroidFindBy(id = "sort_by_wo")
	@iOSXCUITFindBy(accessibility = "Work Order")
	private WebElement sortByWorkOrderRadioButton;
	
	@AndroidFindBy(id = "filter_by_all")
	@FindBy(how = How.CSS, using = "li[data-key='all']")
	@iOSXCUITFindBy(accessibility = "All")
	private WebElement filterByAllRadioButton;
	
	@AndroidFindBy(id = "filter_by_measurements_only")
	@FindBy(how = How.CSS, using = "li[data-key='measurements']")
	@iOSXCUITFindBy(accessibility = "Measurements Only")
	private WebElement filterByMeasurementsRadioButton;
	
	@AndroidFindBy(id = "filter_by_thermal_images_only")
	@FindBy(how = How.CSS, using = "li[data-key='thermalImage']")
	@iOSXCUITFindBy(accessibility = "Thermal Images Only")
	private WebElement filterByThermalImagesRadioButton;
	
	@AndroidFindBy(id = "filter_by_three_phase_only")
	@FindBy(how = How.CSS, using = "li[data-key='unassigned']")
	@iOSXCUITFindBy(accessibility = "3-Phase Monitor Measurements Only")
	private WebElement filterBy3PhaseRadioButton;
	
	@AndroidFindBy(id = "action_bar_item_menu_text")
	@iOSXCUITFindBy(accessibility = "backBarButton")
	private WebElement sortFilterDoneButton;
	
	@AndroidFindBy(id = "test_point")
	@FindBy(how = How.CSS, using = "#measEquipmentDetail")
	private WebElement tesPointStaticText;
	
	@AndroidFindBy(id = "measurement_header")
	private WebElement sortValueStaticText;
	
	@AndroidFindBy(id = "sort_mode")
	@iOSXCUITFindBy(iOSNsPredicate = "type = 'XCUIElementTypeStaticText' AND name = 'Filter'")
	private WebElement sortModeStaticText;
	
	@AndroidFindBy(id = "wo_name")
	@FindBy(how = How.CSS, using = "#measWorkOrderDetail")
	private WebElement assignedWorkOrderStaticText;
	
	@AndroidFindBy(id = "measurement_date")
	@FindBy(how = How.CSS, using = ".capture-date")
	@iOSXCUITFindBy(accessibility = "added date")
	private WebElement measurementTimestampStaticText;
	
	@FindBy(how = How.CSS, using = ".capture-date")
	private List<WebElement> measurementTimestampList;
	
	@AndroidFindBy(id = "filter_mode")
	@iOSXCUITFindBy(accessibility = "Sort")
	private WebElement filterModeStaticText;
	
	@AndroidFindBy(id = "measurement_device")
	@FindBy(how = How.CSS, using = ".measUsername")
	@iOSXCUITFindBy(accessibility = "device name")
	private WebElement deviceNameStaticText;
	
	@FindBy(how = How.CSS, using = ".translation_missing")
	private WebElement notAuthorizedLabel;
	
	@FindBy(how = How.CSS, using = "#clearAssignment")
	private WebElement clearAssignment;
	
	@FindBy(how = How.CSS, using = "a[data-action = 'clear']")
	private WebElement clearAssignmentConfirmButton;
	
	@FindBy(how = How.CSS, using = ".filter-icon")
	private WebElement webFilterDropDown;
	
	@FindBy(how = How.CSS, using = "#measEquipmentDetail")
	private WebElement assetCell;
	
	@FindBy(how = How.CSS, using = "#measWorkOrderDetail")
	private WebElement workOrderCell;
	
	@iOSXCUITFindBy(accessibility = "Cancel")
	private WebElement searchTextFieldCancelButton;
	
	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeCell' AND name CONTAINS ','")
	private WebElement firstMeasurementCell;
	
	@FindBy(how=How.CSS,using="[data-more-measurements='false']")
	private WebElement moremeasurements;
	
	private AssetsPage assetPage;
	private MeasurementDetailPage measurementDetailPage;
	private Gestures gesture;
	private GestureUtils gestureUtils;
	private boolean retryFlag;
	private boolean retryClickFlag;
	private int retryCounter;
	private CaptureMeasurementsPage captureMeasurementsPage;
	private String deviceName;
	private String measurementCaptureDate;
	private StringBuilder mDeviceName;
	private StringBuilder mMeasurementCaptureDate;
	private StringBuilder mMeasurementCaptureRequiredDate;
	private StringBuilder mIOSScrollAttribute;
	private StringBuilder mAndroidScrollAttribute;
	private StringBuilder mWebScrollAttribute;
	private WebElement mMeasurementCell;
	public final static String VIEW_ACTIVE_MONITORING_SESSIONS = "view_active_monitoring_sessions";
	public final static String VIEW_COMPLETED_SESSIONS = "view_completed_sessions"; 
	private ScrollDiection mScrollDiection = ScrollDiection.DOWN;
	public static String measurementHistoryFeatureName = null;
	
	
	public MeasurementsHistoryPage()
	{
		CommonUtils.initElements(this, 10);
		assetPage = new AssetsPage();	
		measurementDetailPage = new MeasurementDetailPage();
		gesture = new Gestures();
		gestureUtils = new GestureUtils();
		captureMeasurementsPage = new CaptureMeasurementsPage();
		gestureUtils = new GestureUtils();
		retryFlag = false;
		retryClickFlag = false;
		retryCounter = 0;
		mDeviceName = new StringBuilder();
		mMeasurementCaptureDate = new StringBuilder();
		mMeasurementCaptureRequiredDate = new StringBuilder();
		mIOSScrollAttribute = new StringBuilder();
		mAndroidScrollAttribute = new StringBuilder();
		mWebScrollAttribute = new StringBuilder();
		mMeasurementCell = null;
	}
	
	public enum MeasurementHistoryPageObjects
	{
		TI_MEASUREMENT_LIST, ACTIVE_SESSIONS, COMPLETED_SESSIONS, 
		SORT_BY_DATE, SORT_BY_ASSET, SORT_BY_WORK_ORDER, FILTER_ALL, FILTER_MEASUREMENTS, FILTER_THERMAL_IMAGES, FILTER_3_PHASE,
		SORT_MODE, SORT_VALUE, TEST_POINT, WORK_ORDER, MEASUREMENT_DATE, FILTER_MODE, DEVICE_NAME, SEARCH_TEXT_FIELD,
		SORT_BY_DATE_ASC, MEASUREMENT_DATE_LIST, NOT_AUTHORIZED_LABEL, CLEAR_ASSIGNMENT, SORT_AND_FILTER_BUTTON, FILTER_BUTTON,
		CLEAR_ASSIGNMENT_OK, ASSET_CELL, WORK_ORDER_CELL, KEYBOARD_SEARCH_BUTTON, SEARCH_TEXT_FIELD_CANCEL_BUTTON, FIRST_MEASUREMENT
	}
	
	public enum MeasturementTileAttributes
	{
		IOS_DEVICE_NAME("device name"),
		IOS_VALUE_LABEL("valueLabel"),
		IOS_UNIT_LABEL("unitLabel"),
		IOS_MAX_VALUE(""),
		IOS_MIN_VALUE(""),
		WEB_IMAGE_OBJECT(".measDetailImg");
		
		private String attributeName;

		private MeasturementTileAttributes(String attributeName) 
	    {
	        this.attributeName = attributeName;
	    }

	    public String getAttributeName() 
	    {
	        return attributeName;
	    }
	}
	
	public WebElement getMeasurementHistoryPageObject(MeasurementHistoryPageObjects objectName)
	{
		switch(objectName)
		{
		case ACTIVE_SESSIONS:
			return activeMonitoringSessionsLink;
		case COMPLETED_SESSIONS:
			return completedSessionsLink;
		case SORT_BY_DATE:
			return sortByDateRadioButton;
		case SORT_BY_ASSET:
			return sortByAssetRadioButton;
		case SORT_BY_WORK_ORDER:
			return sortByWorkOrderRadioButton;
		case FILTER_ALL:
			return filterByAllRadioButton;
		case FILTER_MEASUREMENTS:
			return filterByMeasurementsRadioButton;
		case FILTER_THERMAL_IMAGES:
			return filterByThermalImagesRadioButton;
		case FILTER_3_PHASE:
			return filterBy3PhaseRadioButton;
		case SORT_MODE:
			return sortModeStaticText;
		case SORT_VALUE:
			return sortValueStaticText;
		case TEST_POINT:
			return tesPointStaticText;
		case WORK_ORDER:
			return assignedWorkOrderStaticText;
		case MEASUREMENT_DATE:
			return measurementTimestampStaticText;
		case FILTER_MODE:
			return filterModeStaticText;
		case DEVICE_NAME:
			return deviceNameStaticText;
		case SEARCH_TEXT_FIELD:
			return searchTextField;
		case SORT_BY_DATE_ASC:
			return sortByDateAscButton;
		case NOT_AUTHORIZED_LABEL:
			return notAuthorizedLabel;
		case CLEAR_ASSIGNMENT:
			return clearAssignment;
		case SORT_AND_FILTER_BUTTON:
			return sortAndFilterButton;
		case FILTER_BUTTON:
			return webFilterDropDown;
		case CLEAR_ASSIGNMENT_OK:
			return clearAssignmentConfirmButton;
		case ASSET_CELL:
			return assetCell;
		case WORK_ORDER_CELL:
			return workOrderCell;
		case KEYBOARD_SEARCH_BUTTON:
			return keyboardSearchButton;
		case SEARCH_TEXT_FIELD_CANCEL_BUTTON:
			return searchTextFieldCancelButton;
		case FIRST_MEASUREMENT:
			return firstMeasurementCell;
		default:
			return null;
		}
	}
	
	public List<WebElement> getMeasurementHistoryPageWebElements(MeasurementHistoryPageObjects objectName)
	{
		switch(objectName)
		{
		case TI_MEASUREMENT_LIST:
			return tiMeasurementList;
		case MEASUREMENT_DATE_LIST:
			return measurementTimestampList;
			default:
				return null;
		}
	}
	
	public void resetMeasurementsBasicAttributes()
	{
		mDeviceName.delete(0, mDeviceName.length());
		mMeasurementCaptureDate.delete(0, mMeasurementCaptureDate.length());
		mMeasurementCaptureRequiredDate.delete(0, mMeasurementCaptureRequiredDate.length());
		mIOSScrollAttribute.delete(0, mIOSScrollAttribute.length());
		mAndroidScrollAttribute.delete(0, mAndroidScrollAttribute.length());
		mWebScrollAttribute.delete(0, mWebScrollAttribute.length());
		mMeasurementCell = null;
	}
	
	public String getRequiredMeasurementIndex(int measurementIndex)
	{
		return " "+String.valueOf(measurementIndex);
	}
	
	public void initMeasurementCell(LocatorStrategy androidLocatorStrategy, String androidAttributeValue, LocatorStrategy iOSLocatorStrategy, String iOSAttributeValue, LocatorStrategy webLocatorStrategy, String webAttributeValue)
	{
		gestureUtils.mScroll(androidAttributeValue, iOSAttributeValue, iOSLocatorStrategy, androidLocatorStrategy, getScrollDirection());
		if(getScrollDirection() == ScrollDiection.DOWN)
			gestureUtils.mScroll(-250, -100, 1);
		else
			gestureUtils.mScroll(250, 100, 1);
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			mMeasurementCell = ElementUtils.getElement(null, null, iOSLocatorStrategy, iOSAttributeValue, webLocatorStrategy, webAttributeValue);
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			mMeasurementCell = ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_XPATH, "//android.widget.TextView[contains(@text, '"+ androidAttributeValue +"')]/parent::android.widget.RelativeLayout/parent::android.widget.RelativeLayout",  null, null, null, null);
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			mMeasurementCell = ElementUtils.getElements(null, null,  null, null, webLocatorStrategy, webAttributeValue).get(1);	
	}
	
	public WebElement getMeasurementCell(boolean isPropertyFileProvided, String measurementsPropertyFilePath, String deviceName, String measurementCaptureDate, String anyOtherAttribute, int measurementIndex, MeasurementDetailPageObjects deploymentName, boolean iOSStrictFlag) throws ParseException
	{
		resetMeasurementsBasicAttributes();
		if(isPropertyFileProvided)
		{
			if(measurementIndex < 0)
			{
				mDeviceName.append(FileUtil.readProperty(measurementsPropertyFilePath, deviceName));
				mMeasurementCaptureDate.append(FileUtil.readProperty(measurementsPropertyFilePath, deviceName + measurementDetailPage.getMeasurementDetailPageObject(MeasurementDetailPageObjects.DATE_SUFFIX)));
				FCM.setDateLength(true);
			}
			else
			{
				mDeviceName.append(FileUtil.readProperty(measurementsPropertyFilePath, deviceName + getRequiredMeasurementIndex(measurementIndex)));
				mMeasurementCaptureDate.append(FileUtil.readProperty(measurementsPropertyFilePath, deviceName + measurementDetailPage.getMeasurementDetailPageObject(MeasurementDetailPageObjects.DATE_SUFFIX) + getRequiredMeasurementIndex(measurementIndex)));
				FCM.setDateLength(false);
			}
			if(deploymentName == MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT)
			{
				if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
					mMeasurementCaptureRequiredDate.append(DateAndTimeUtils.getDateAsAString(mMeasurementCaptureDate.toString(), FCM.getDateFormat(Config.IOS_DRIVER), FCM.getDateFormat(Config.ANDROID_DRIVER)));
				else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
					mMeasurementCaptureRequiredDate.append(DateAndTimeUtils.getDateAsAString(mMeasurementCaptureDate.toString(), FCM.getDateFormat(Config.ANDROID_DRIVER), FCM.getDateFormat(Config.IOS_DRIVER)));
			}
			else if(deploymentName == MeasurementDetailPageObjects.WEB_SYNC_IOS_DEPLOYMENT)
				mMeasurementCaptureRequiredDate.append(DateAndTimeUtils.getDateAsAString(mMeasurementCaptureDate.toString(), FCM.getDateFormat(Config.IOS_DRIVER), FCM.getDateFormat(Config.WEB_DRIVER))); 
			else if(deploymentName == MeasurementDetailPageObjects.WEB_SYNC_ANDROID_DEPLOYMENT)
				mMeasurementCaptureRequiredDate.append(DateAndTimeUtils.getDateAsAString(mMeasurementCaptureDate.toString(), FCM.getDateFormat(Config.ANDROID_DRIVER), FCM.getDateFormat(Config.WEB_DRIVER))); 
			else if(deploymentName == null)
				mMeasurementCaptureRequiredDate.append(mMeasurementCaptureDate.toString());
			if(iOSStrictFlag)
				mIOSScrollAttribute.append(mDeviceName+", "+mMeasurementCaptureRequiredDate);
			else
				mIOSScrollAttribute.append(mMeasurementCaptureRequiredDate);
			initMeasurementCell(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, mMeasurementCaptureRequiredDate.toString(), LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, mIOSScrollAttribute.toString(), LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, "//*[contains(text(), '"+mMeasurementCaptureRequiredDate+"')]/ancestor::div[@class = 'measurementContent']");
			return mMeasurementCell;
		}
		return null;
	}
	
	public void setScrollDirection(ScrollDiection direction)
	{
		mScrollDiection = direction;
	}
	
	public ScrollDiection getScrollDirection()
	{
		return mScrollDiection;
	}
	
	public void deleteMultipleMeasurements(int measurementsCount) throws Exception
	{
		deleteMeasurementsButton.click();
		clickOnMultipleMeasurements(measurementsCount);
		deleteMultipleMeasurementsButton.click();
		ElementUtils.click(2, confirmDeleteMultipleMeasurementsButton);
	}
	
	public void deleteMultipleMeasurementsWeb() throws Exception
	{
		for(int i = 0; i < webMeasurementCellCheckBoxList.size() - 3; i++)
		{
			webMeasurementCellCheckBoxList.get(i).click();
		}
		deleteMultipleMeasurementsButton.click();
		ElementUtils.click(2, confirmDeleteMultipleMeasurementsButton);
	}
	
	public void clickOnMultipleMeasurements(int measurementsCount)
	{
		List<WebElement> measurementList = capturedMeasurementDateList;
		if(measurementList.size() < measurementsCount)
			measurementsCount = capturedMeasurementDateList.size();
		for(int i = 0; i <= measurementsCount; i++)
		{
			try
			{
				measurementList.get(i).click();
			}
			catch(Throwable e)
			{
				e.printStackTrace();
			}
			gestureUtils.mScroll(-200, -150, 2);
		}
	}
	
	public void deleteMultipleMeasurements(int measurementsCount, List<WebElement> measurementList) throws Exception
	{
		deleteMeasurementsButton.click();
		clickOnMultipleMeasurements(measurementsCount, measurementList);
		deleteMultipleMeasurementsButton.click();
		ElementUtils.click(2, confirmDeleteMultipleMeasurementsButton);
	}
	
	public void clickOnMultipleMeasurements(int measurementsCount, List<WebElement> measurementList)
	{
		List<WebElement> lMeasurementList = measurementList;
		if(lMeasurementList.size() < measurementsCount)
			measurementsCount = lMeasurementList.size();
		for(int i = 0; i <= measurementsCount; i++)
		{
			try
			{
				lMeasurementList.get(i).click();
			}
			catch(Throwable e)
			{
				e.printStackTrace();
			}
			gestureUtils.mScroll(-240, -240, 2);
		}
	}
	
	public void scrollDownToMeasurement(String deviceName, String propertiesFilePath)
	{
		try
		{
			this.deviceName = null;
			measurementCaptureDate = null;
			this.deviceName = FileUtil.readFromPropertyFile(propertiesFilePath, deviceName);
			measurementCaptureDate = FileUtil.readFromPropertyFile(propertiesFilePath, deviceName+" Date");
		    gesture.mobileScrollDown(this.deviceName+", "+measurementCaptureDate);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	public void scrollDownToMeasurement(String deviceName, String measurementTimestampSource, boolean isPropertyFile)
	{
		try
		{
			if(isPropertyFile)
			{
				this.deviceName = null;
				measurementCaptureDate = null;
				this.deviceName = FileUtil.readFromPropertyFile(measurementTimestampSource, deviceName);
				measurementCaptureDate = FileUtil.readFromPropertyFile(measurementTimestampSource, deviceName+" Date");
			    gesture.mobileScrollDown(this.deviceName+", "+measurementCaptureDate);
			   
			}
			else
			{
				this.deviceName = null;
				measurementCaptureDate = null;
				this.deviceName = deviceName;
				measurementCaptureDate = measurementTimestampSource;
				gestureUtils.scroll(Config.IOS_LOCATOR_STRATEGY_VALUE, measurementCaptureDate, null, measurementCaptureDate, -200, -100, null, null);
			    //gesture.mobileScrollDown(this.deviceName+", "+measurementCaptureDate);
			}
			
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	public void clickOnMeasurementName(String deviceName, String propertiesFilePath)
	{
		try
		{
			scrollDownToMeasurement(deviceName, propertiesFilePath);	
			CommonUtils.ifDisplayedThenClick(this.deviceName+", "+measurementCaptureDate);
		}
		catch(Throwable e)
		{  
			e.printStackTrace();
		}
	}
	
	public void clickOnMeasurementName(String deviceName, String measurementTimestampSource, boolean isPropertyFile)
	{
		try
		{
			if(isPropertyFile)
			{
				scrollDownToMeasurement(deviceName, measurementTimestampSource);	
				CommonUtils.ifDisplayedThenClick(this.deviceName+", "+measurementCaptureDate);
			}
			else
			{
				scrollDownToMeasurement(deviceName, measurementTimestampSource, isPropertyFile);	
				ElementUtils.clickIfDisplayedAndEnabled(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, measurementTimestampSource, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, measurementTimestampSource, null, null));
				//CommonUtils.ifDisplayedThenClick(this.deviceName+", "+measurementCaptureDate);
				//this.deviceName+", "+measurementCaptureDate
			}
			
		}
		catch(Throwable e)
		{  
			e.printStackTrace();
		}
	}
	
	//this method expects device name and capture date is to passed as arguments
	public void clickOnMeasurementTile(String ...measurementAttributes)
	{
		try
		{
			if(DriverManager.getDriverName().equals("iOS"))
			{
				String realDeviceName = null;
				String captureDate = null;
				for(int i=0;i<measurementAttributes.length;i++)
				{
					realDeviceName = measurementAttributes[0];
					captureDate = measurementAttributes[1];
				}
				gesture.mobileScrollDown(realDeviceName+", "+captureDate);
				CommonUtils.ifDisplayedThenClick(realDeviceName+", "+captureDate);
			}
			if(DriverManager.getDriverName().equals("Android"))
			{
				measurementsList.get(0).click();
			}
		}
		catch(Throwable e)
		{  
			e.printStackTrace();
		}
	}

	public void reliableClickOnMeasurementName(String deviceName, String propertiesFilePath)
	{
		retryFlag = true;
		retryClickFlag = true;
		retryCounter = 0;
		clickOnMeasurementName(deviceName, propertiesFilePath);
		while(retryFlag)
		{
			try 
			{
				if(measurementDetailPage.isActionsButtonDisplayed())
				{
					retryFlag = false;
					retryClickFlag = false;
				}
			}
			catch(Throwable e)
			{
				e.printStackTrace();
				retryCounter++;
				if(retryCounter == 2)
				{
					retryFlag = false;
					retryClickFlag = false;
				}
			}
			if(retryClickFlag)
			{
				try
				{
					clickOnMeasurementName(deviceName, propertiesFilePath);
				}
				catch(Throwable e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public void clickOnMultipleMeasurements(String propertiesFilePath, String... measurementsName)
	{
		for(int i=0; i<measurementsName.length;i++)
		{
			for(int j=0; j<3;j++)
			{
				clickOnMeasurementName(measurementsName[i], propertiesFilePath);
				if(selectedMeasurementCountTitle.getText().startsWith(String.valueOf(i+1)))
				{
					break;
				}
			}
		}
	}
	
	
	
	public void reliableClickOnMultipleMeasurementsTile(String deviceName, String[] measurementsCaptureDateList)
	{
		for(int i=0; i<measurementsCaptureDateList.length;i++)
		{
			clickOnMeasurementTile(deviceName, measurementsCaptureDateList[i]);
		}
	}
	
	public void clickOnMultipleMeasurementsTile(String deviceName, String[] measurementsCaptureDateList)
	{
		for(int i=0; i<measurementsCaptureDateList.length;i++)
		{
			clickOnMeasurementTile(deviceName, measurementsCaptureDateList[i]);
		}
	}
	
	public void clickMeasurement(String deviceName)
	{
		try
		{
			if(DriverManager.getDriverName().equals("iOS"))
			{
				String realDeviceName = null;
				String date = null;
				if(deviceName.contains("Work Order"))
				{
					realDeviceName = FileUtil.readFromPropertyFile("./properties/wo.properties", deviceName);
					date = FileUtil.readFromPropertyFile("./properties/wo.properties", deviceName+" Date");

				}
				else
				{
					realDeviceName = FileUtil.readFromPropertyFile(FCM.MEASUREMENTS_PROPERTIES_FILE_PATH, deviceName);
					date = FileUtil.readFromPropertyFile(FCM.MEASUREMENTS_PROPERTIES_FILE_PATH, deviceName+" Date");

				}
				try
				{
					gesture.iOSScrollDown(realDeviceName+", "+date);
				}
				catch(Throwable e)
				{
					e.printStackTrace();
				}
				DriverManager.getDriver().findElement(MobileBy.AccessibilityId(realDeviceName+", "+date)).click();
			}
			if(DriverManager.getDriverName().equals("Android"))
			{
				gesture.androidScrollToTextValue("\""+deviceName+"\"");
				DriverManager.getDriver().findElement(MobileBy.id("measurement_device")).click();
				measurementDetailPage.clickOnAndroidAssetPopupCloseButton();
			}
		}
		catch(Throwable e)
		{  
			e.printStackTrace();
		}
	}
	
	public void reliableClickOnMeasurementName(String deviceName)
	{
		retryFlag = true;
		retryClickFlag = true;
		retryCounter = 0;
		clickMeasurement(deviceName);
		while(retryFlag)
		{
			try 
			{
				if(measurementDetailPage.isActionsButtonDisplayed())
				{
					retryFlag = false;
					retryClickFlag = false;
				}
			}
			catch(Throwable e)
			{
				e.printStackTrace();
				retryCounter++;
				if(retryCounter == 6)
				{
					retryFlag = false;
					retryClickFlag = false;
				}
			}
			if(retryClickFlag)
			{
				try
				{
					clickMeasurement(deviceName);
				}
				catch(Throwable e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public void assignAsset(String deviceName, String propertiesFilePath, String assetGroupName, String assetName, String assetTestPointName) throws Exception
	{
		reliableClickOnMeasurementName(deviceName, propertiesFilePath);
		ElementUtils.clickIfDisplayedAndEnabled(assignAssetCell);
		assetPage.assignAsset(assetGroupName, assetName, assetTestPointName, 0);
		doneButton.click();
	}

	public void assignAsset(String deviceName, String assetGroupName, String assetName, String assetTestPointName) throws Exception
	{
		reliableClickOnMeasurementName(deviceName);
		ElementUtils.clickIfDisplayedAndEnabled(assignAssetCell);
		assetPage.assignAsset(assetGroupName, assetName, assetTestPointName, 0);
		doneButton.click();
	}

	public void deleteSingleMeasurement(String deviceName, String propertiesFilePath) throws Exception
	{
		reliableClickOnMeasurementName(deviceName, propertiesFilePath);
		measurementDetailPage.deleteMeasurement();
	}
	
	public void deleteCapturedMeasurement() throws Exception
	{
		measurementDetailPage.deleteMeasurement();
	}
	
	public void deleteMultipleMeasurements(String propertiesFilePath, String... measurementsName) throws Exception
	{
		ElementUtils.clickIfDisplayedAndEnabled(deleteMeasurementsButton);
		clickOnMultipleMeasurements(3);
		ElementUtils.clickIfDisplayedAndEnabled(deleteMultipleMeasurementsButton);
		DriverManager.getDriver().findElement(MobileBy.iOSNsPredicateString("name CONTAINS 'Permanently delete'")).click();
	}
	
	public String getMeasurementValue()
	{
		return capturedMeasurementValue.getText();
	}
	
	public String getMeasurementUnits()
	{
		return capturedMeasurementUnits.getText();
	}
	
	public void clickOnBackButton()
	{
		backButton.click();
	}
	
	public int getMeasurementsCount()
	{
		return measurementsList.size();	
	}
	
	public void clickOnDoneButton()
	{
		doneButton.click();
	}
	
	private boolean isIosLoadingSpinnerIsShowing()
	{
		return iOSInProgressLoadingSpinner.isDisplayed();
	}
	
	//compares capture measurement vs measurement history value
	public boolean isNonScalarMeasurementValuesCorrect(String deviceName)
	{
		try
		{
			for(int i=0;i<Integer.parseInt(FileUtil.readFromPropertyFile(FCM.MEASUREMENTS_PROPERTIES_FILE_PATH, deviceName + " Measurements Count"));i++)
			{
				if(!FileUtil.readFromPropertyFile(FCM.MEASUREMENTS_PROPERTIES_FILE_PATH, deviceName+" Value "+i).equals(nonScalarMeasurementValueList.get(i).getText()))
				{
					return false;
				}
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	//compares capture measurement vs measurement history unit
	public boolean isNonScalarMeasurementUnitsCorrect(String deviceName)
	{
		try
		{
			for(int i=0;i<Integer.parseInt(FileUtil.readFromPropertyFile(FCM.MEASUREMENTS_PROPERTIES_FILE_PATH, deviceName + " Measurements Count"));i++)
			{
				if(!FileUtil.readFromPropertyFile(FCM.MEASUREMENTS_PROPERTIES_FILE_PATH, deviceName+" Unit "+i).equals(nonScalarMeasurementUnitList.get(i).getText()))
				{
					return false;
				}
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean isScalarMeasurementValueCorrect(String deviceName)
	{
		try
		{
			if(!FileUtil.readFromPropertyFile(FCM.MEASUREMENTS_PROPERTIES_FILE_PATH, deviceName+" Value").equals(capturedMeasurementValue.getText()))
			{
				return false;
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean isScalarMeasurementUnitCorrect(String deviceName)
	{
		try
		{
			if(!FileUtil.readFromPropertyFile(FCM.MEASUREMENTS_PROPERTIES_FILE_PATH, deviceName+" Unit").equals(capturedMeasurementUnits.getText()))
			{
				return false;
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean isGroupMeasurementDevicesCorrect(String deviceName)
	{
		try
		{
			for(int i=0;i<Integer.parseInt(FileUtil.readFromPropertyFile(FCM.MEASUREMENTS_PROPERTIES_FILE_PATH, deviceName + " Device Count"));i++)
			{
				if(!FileUtil.readFromPropertyFile(FCM.MEASUREMENTS_PROPERTIES_FILE_PATH, deviceName+" device "+ i).equals(groupMeasurementDeviceNameList.get(i).getText()))
				{
					return false;
				}
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean isGroupMeasurementScalarValuesCorrect(String deviceName)
	{
		try
		{
			for(int i=0;i<Integer.parseInt(FileUtil.readFromPropertyFile(FCM.MEASUREMENTS_PROPERTIES_FILE_PATH, deviceName + " Measurements Scalar Value Count"));i++)
			{
				if(!FileUtil.readFromPropertyFile(FCM.MEASUREMENTS_PROPERTIES_FILE_PATH, deviceName+" Scalar Measurement Value "+ i).equals(groupMeasurementScalarValueList.get(i).getText()))
				{
					return false;
				}
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean isGroupMeasurementScalarUnitsCorrect(String deviceName)
	{
		try
		{
			for(int i=0;i<Integer.parseInt(FileUtil.readFromPropertyFile(FCM.MEASUREMENTS_PROPERTIES_FILE_PATH, deviceName + " Measurements Scalar Value Count"));i++)
			{
				if(!FileUtil.readFromPropertyFile(FCM.MEASUREMENTS_PROPERTIES_FILE_PATH, deviceName+" Scalar Measurement Unit "+ i).equals(groupMeasurementScalarUnitList.get(i).getText()))
				{
					return false;
				}
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean isGroupMeasurementNonScalarValuesCorrect(String deviceName)
	{
		try
		{
			for(int i=0;i<Integer.parseInt(FileUtil.readFromPropertyFile(FCM.MEASUREMENTS_PROPERTIES_FILE_PATH, deviceName + " Measurements Non Scalar Value Count"));i++)
			{
				if(!FileUtil.readFromPropertyFile(FCM.MEASUREMENTS_PROPERTIES_FILE_PATH, deviceName+" Non-Scalar Measurement Value "+ i).equals(groupMeasurementNonScalarValueList.get(i).getText()))
				{
					return false;
				}
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean isGroupMeasurementNonScalarUnitsCorrect(String deviceName)
	{
		
		try
		{
			for(int i=0;i<Integer.parseInt(FileUtil.readFromPropertyFile(FCM.MEASUREMENTS_PROPERTIES_FILE_PATH, deviceName + " Measurements Non Scalar Value Count"));i++)
			{
				if(!FileUtil.readFromPropertyFile(FCM.MEASUREMENTS_PROPERTIES_FILE_PATH, deviceName+" Non-Scalar Measurement Unit "+ i).equals(groupMeasurementNonScalarUnitList.get(i).getText()))
				{
					return false;
				}
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean isAssignedAssetCorrect(String assetName)
	{
		try
		{
			return measurementDetailPage.isAssetAssigned(assetName);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean isAssignedWorkOrderCorrect(String workOrderNumber)
	{
		try
		{
			return measurementDetailPage.isWorkOrderAssigned(workOrderNumber);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean isAddedTextNoteCorrect(String textNote)
	{
		try
		{
			return measurementDetailPage.isTextNoteAdded(textNote);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public void clickOnViewCompletedSessionsLink()
	{
		CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(30, 1, completedSessionsLink);
	}
	
	public void clickOnViewActiveMonitoringSessionsLink() throws Exception
	{
		ElementUtils.clickIfDisplayedAndEnabled(60, 1, activeMonitoringSessionsLink);
	}
	
	
	public void clickOnTestConditionsTab()
	{
		testConditionTab.click();
	}
	
	public void clickOnCalculatedResultsTab()
	{
		calculatedResultsTab.click();
	}
	
	public void assignAsset(String assetGroupName, String assetName, String assetTestPointName) throws Exception
	{
		ElementUtils.clickIfDisplayedAndEnabled(assignAssetCell);
		assetPage.assignAsset(assetGroupName, assetName, assetTestPointName, 0);
		doneButton.click();
	}
	
	public void assignAssetInIntermediateMeasurementPageAfterDownload(String assetGroupName, String assetName, String assetTestPointName) throws Exception
	{
		ElementUtils.clickIfDisplayedAndEnabled(assignAssetCell);
		assetPage.assignAsset(assetGroupName, assetName, assetTestPointName, 0);
		//doneButton.click();
	}
	public void museCentrePointMeasurement() throws Exception
    
    
    
	{  
		CommonUtils.wait(10);
		
		 ElementUtils.clickIfDisplayedAndEnabled(filterOption);
	     ElementUtils.click(3,thermalfilter);
	    
		 if(museMeasurementDetail.size()>0)	
			{
			
			    gesture.webScroll(museMeasurementTitle.get(0));
				System.out.println(" Muse Thermal Measurements are present");	
				}
		
	     
	     	ElementUtils.clickIfDisplayedAndEnabled(museMeasurementDetail.get(0));
	        
	         Assert.assertTrue(titleMuse.getText().contains("279FC"));
	        CommonUtils.wait(10);
           
	        ElementUtils.isDisplayed(imgReader);
	       ElementUtils.click(3,measurementBackbutton);
	       CommonUtils.wait(10);
	}
		
	public void museGroupedCentrePointMeasurement() throws Exception
	{  
		CommonUtils.wait(10);
		
		 ElementUtils.clickIfDisplayedAndEnabled(filterOption);
	     ElementUtils.click(3,thermalfilter);
	     gesture.webBrowserScrollDown(10);
		 if(museMeasurementDetail.size()>0)	
			{
			  //gesture.webBrowserScrollDown(200);
			   gesture.webScroll(museMeasurementTitle.get(0));
			   
				System.out.println(" Muse Thermal Measurements are present");	
				}
		      
		       CommonUtils.wait(10);
		       
		    gestureUtils.webScroll(LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS,"Grouped Measurement",ScrollDiection.DOWN,1000);
		 
		     
		      
		   
		    if(groupedMeasurement.size()>1)
		    {
		    	
		      for(int i=0;i<groupedMeasurement.size();i++)
		      {
		    	
		     
		      ElementUtils.clickObject(groupedMeasurement.get(i));
		      }
		    }
		     
		    else {
		    	   ElementUtils.clickObject(groupedMeasurement.get(0));
		    }
		    CommonUtils.wait(10);
	         
	       
	      
	   	System.out.println("no of centrepoints"  +imgReaders_groupedmesaurements.size());
	   	Assert.assertEquals(museMeasurementTitle.size(),imgReaders_groupedmesaurements.size());
	    
	       ElementUtils.click(3,measurementBackbutton);
	       CommonUtils.wait(10);
	   }
	
	public void sortAndFilter(MeasurementHistoryPageObjects objectName)
	{
		switch(objectName)
		{
		case SORT_BY_DATE:
			sortByDateRadioButton.click();
			break;
		case SORT_BY_ASSET:
			sortByAssetRadioButton.click();
			break;
		case SORT_BY_WORK_ORDER:
			sortByWorkOrderRadioButton.click();
			break;
		case FILTER_ALL:
			filterByAllRadioButton.click();
			break;
		case FILTER_MEASUREMENTS:
			filterByMeasurementsRadioButton.click();
			break;
		case FILTER_THERMAL_IMAGES:
			filterByThermalImagesRadioButton.click();
			break;
		case FILTER_3_PHASE:
			filterBy3PhaseRadioButton.click();
			break;
		case SORT_BY_DATE_ASC:
			sortByDateAscButton.click();
			break;
		default:
			break;
		}
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			sortFilterDoneButton.click();
	}
	
	public boolean isNotAuthorizedLabelDisplayed()
	{
		try {
			if(notAuthorizedLabel.getText().equals("Not Authorized"))
				return false;
			else
				return true;
		}
		catch(Throwable e)
		{
			return true;
		}
	}
	
	 public void loadallmeasurements()
		{
		   try
		   {
		    
		    for(;;)
		    {
			   gestureUtils.webScroll(ScrollDiection.DOWN, 10);
			   if(ElementUtils.isDisplayed(moremeasurements) == true)
			   {
				   break;
			   }
		     }
		     
		   }catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		}
	
	
	}









