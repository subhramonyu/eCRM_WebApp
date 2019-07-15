package com.eCRM.client.testpages;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.eCRM.client.testdata.Reports;
import com.eCRM.client.testdata.Reports.ReportsAttribute;
import com.eCRM.client.testdata.Reports.ReportsOptions;
import com.eCRM.client.testpages.ReportsPage.ReportPageObjects;
import com.eCRM.client.utils.AndroidUtils;
import com.eCRM.client.utils.CommonUtils;
import com.eCRM.client.utils.Config;
import com.eCRM.client.utils.DriverManager;
import com.eCRM.client.utils.ElementUtils;
import com.eCRM.client.utils.GestureUtils;
import com.eCRM.client.utils.IOSUtils;
import com.eCRM.client.utils.Config.LocatorStrategy;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

@SuppressWarnings("unused")
public class ReportsPage 
{
	@AndroidFindBy(id = "com.fluke.deviceApp:id/basic_report")
	@iOSFindBy(accessibility = "Basic Report")
	private WebElement basicReportButton;

	@AndroidFindBy(id = "com.fluke.deviceApp:id/thermal_report")
	@iOSFindBy(accessibility = "Thermal Image Report")
	private WebElement thermalImageReportButton;

	
	@AndroidFindBy(id = "com.fluke.deviceApp:id/txt_measurements")
	@iOSFindBy(accessibility = "More Info")
	private WebElement measurementsButton;
	
	@AndroidFindBy(id = "txt_thermal_images")
	private WebElement androidThermalImagesButton;

	@AndroidFindBy(id = "com.fluke.deviceApp:id/txt_thermal_images")
	@iOSFindBy(accessibility = "Thermal Images")
	private WebElement thermalImageMeasurementsButton;

	@AndroidFindBy(id = "com.fluke.deviceApp:id/measurement_date")
	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeCell' AND name CONTAINS ', '")
	private List<WebElement> measurementListThroughAddedDate;

	@AndroidFindBy(id = "com.fluke.deviceApp:id/add")
	@iOSXCUITFindBy(accessibility = "Add")
	private WebElement addButton;

	@AndroidFindBy(id = "com.fluke.deviceApp:id/fluke_small_logo")
	@iOSXCUITFindBy(accessibility = "Back")
	private WebElement backButton;

	@AndroidFindBy(id = "com.fluke.deviceApp:id/fluke_small_logo")
	@iOSXCUITFindBy(accessibility = "Basic Report")
	private WebElement basicReportBackButton;
	
	@AndroidFindBy(id = "com.fluke.deviceApp:id/fluke_small_logo")
	@iOSXCUITFindBy(accessibility = "Thermal Image Report")
	private WebElement thermalImageReportBackButton;
	
	@AndroidFindBy(id = "com.fluke.deviceApp:id/fluke_small_logo")
	@iOSXCUITFindBy(accessibility = "Reports")
	private WebElement reportsBackButton;
	
	@AndroidFindBy(id = "action_bar_item_left")
	private WebElement androidAssetReportBackButton;

	@AndroidFindBy(id = "com.fluke.deviceApp:id/txt_edit_cover_page")
	@iOSXCUITFindBy(accessibility = "Edit Cover Page")
	private WebElement editCoverButton;

	@AndroidFindBy(id = "txt_company_name")
	@iOSXCUITFindBy(accessibility = "Company Name")
	private WebElement companyNameTextField;

	@FindBy(how=How.CSS,using=".blue-button")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/btn_save")
	@iOSXCUITFindBy(accessibility = "Save")
	private WebElement saveButton;
	
	@AndroidFindBy(id = "btn_save")
	@iOSXCUITFindBy(accessibility = "Update")
	private WebElement updateButton;
	
	@FindBy(how = How.CSS, using="a[data-event='click:asset-report-save']")
	@AndroidFindBy(id = "action_bar_item_menu_text")
	@iOSXCUITFindBy(accessibility = "Save")
	private WebElement saveButtonCapital;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'View')]")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Edit\")")
	@iOSXCUITFindBy(accessibility = "Edit")
	private WebElement editButton;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Duplicate')]")
	private WebElement duplicateButton;

	@iOSXCUITFindBy(accessibility = "Done")
	private WebElement doneButton;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'View')]")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/img_report_page")
	@iOSFindBy(className = "XCUIElementTypeScrollView")
	private WebElement reportFrontPage;
	
	@AndroidFindBy(className = "android.webkit.WebView")
	private WebElement androidAssetReportFrontPage;

	@FindBy(how = How.CSS, using = ".create-report-btn")
	@iOSXCUITFindBy(accessibility = "CREATE")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/create_text")
	private WebElement createReportButton;

	@FindBy(how = How.CSS,using = ".asset-report")
	@iOSXCUITFindBy(accessibility = "Asset Report")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/asset_report")
	private WebElement assetReportButton;
	
	@AndroidFindBy(id = "com.fluke.deviceApp:id/layout_view_pdf")
	private WebElement viewPdf;
	
	@AndroidFindBy(id = "txt_additional_info")
	@iOSXCUITFindBy(accessibility = "Additional Information")
	private WebElement addtionalInformationTextField;
	
	@AndroidFindBy(id = "txt_report_subtitle")
	@iOSXCUITFindBy(accessibility = "Report Subtitle")
	private WebElement reportSubtitleTextField;
	
	@AndroidFindBy(id = "txt_report_title")
	@iOSXCUITFindBy(accessibility = "Report Title")
	private WebElement reportTitleTextField;
	
	@AndroidFindBy(id = "txt_company_info")
	@iOSXCUITFindBy(accessibility = "Company Info")
	private WebElement companyInfoTextField;
	
	@FindBy(how = How.CSS, using = ".report-list-row")
	@AndroidFindBy(id = "report_type_layout")
	@iOSXCUITFindBy(className = "XCUIElementTypeCell")
	private WebElement firstReportCell;
	
	@iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH 'Last Modified'")
	private WebElement reportCreationDate;
	
	@AndroidFindBy(id = "btn_share")
	@iOSXCUITFindBy(accessibility = "Share")
	private WebElement shareButton;
	
	@AndroidFindBy(id = "action_bar_item_menu_icon")
	private WebElement androidAssetReportShareButton;
	
	@AndroidFindBy(id = "com.google.android.gm:id/to")
	@iOSXCUITFindBy(accessibility = "toField")
	private WebElement recipientEmailAddressTextField;
	
	@FindBy(how = How.CSS, using = ".iconEmail")
	@AndroidFindBy(id = "com.google.android.gm:id/send")
	@iOSXCUITFindBy(accessibility = "Send")
	private WebElement sendButton;
	
	@AndroidFindBy(id = "report_item_menu")
	@iOSXCUITFindBy(accessibility = "options gray")
	private WebElement reportsOptionButton;
	
	@FindBy(how = How.CSS, using = ".caret")
	private List<WebElement> reportsOptionList;
	
	@iOSXCUITFindBy(accessibility = "Delete")
	private WebElement deleteReportButton;
	
	@FindBy(how = How.CSS, using = "div[data-event = 'click:report-add-asset']")
	@iOSXCUITFindBy(accessibility = "ADD/REMOVE ASSETS")
	private WebElement addRemoveAssetsButton;
	
	@FindBy(how = How.CSS, using = ".equicheckbox")
	@AndroidFindBy(id = "select_asset_check_box")
	@iOSXCUITFindBy(accessibility = "Button")
	private List<WebElement> assetCellList;
	
	@FindBy(how = How.CSS, using = "a[data-event = 'click:add-assets']")
	@AndroidFindBy(id = "add_button")
	@iOSXCUITFindBy(accessibility = "Done")
	private List<WebElement> doneButtonList;
	
	@AndroidFindBy(id = "action_bar_item_menu_text")
	@iOSXCUITFindBy(accessibility = "NEXT")
	private WebElement nextButton;
	
	@FindBy(how = How.CSS, using = "#report-title")
	@AndroidFindBy(id = "report_title_text")
	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND value == 'Report Title'")
	private WebElement assetReportTitleTextField;
	
	@FindBy(how = How.CSS, using = "#report-title")
	@AndroidFindBy(id = "report_title_text")
	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND value CONTAINS 'TITLE'")
	private WebElement editAssetReportTitleTextField;
	
	@FindBy(how = How.CSS, using = "#report-subtitle")
	@AndroidFindBy(id = "report_sub_title_text")
	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND value == 'Report Subtitle'")
	private WebElement assetReportSubtitleTextField;
	
	@FindBy(how = How.CSS, using = "#report-subtitle")
	@AndroidFindBy(id = "report_sub_title_text")
	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND value CONTAINS 'SUBTITLE'")
	private WebElement editAssetReportSubtitleTextField;

	@FindBy(how = How.CSS, using = "#company-name-normal")
	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND value == 'Company Name'")
	private WebElement assetReportCompanyNameTextField;
	
	@FindBy(how = How.CSS, using = "#company-info-normal")
	private WebElement assetReportInformationTextField;
	
	@FindBy(how = How.CSS, using = "#additional-info")
	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextView' AND value CONTAINS 'Additional'")
	private WebElement assetReportAdditionalInformationTextField;

	@FindBy(how = How.CSS, using = "#companyLogoHeader")
	private WebElement assetReportCompanyLogoHeader;
	
	@FindBy(how = How.CSS, using = "div[data-event='click:add-logo-header']")
	private WebElement assetReportCompanyLogoHeaderAddButton;
	
	@FindBy(how = How.CSS, using = "#companyLogoNormal")
	private WebElement assetReportCompanyLogoNormal;
	
	@FindBy(how = How.CSS, using = "div[data-event='click:add-logo-normal']")
	private WebElement assetReportCompanyLogoNormalAddButton;
	
	@FindBy(how = How.CSS, using = "#custom-text-header")
	private WebElement assetReportCustomTextHeader;
	
	@FindBy(how = How.CSS, using = "#custom-text-footer")
	private WebElement assetReportCustomTextFooter;
	
	@FindBy(how = How.CSS, using = ".asset-details-heading")
	@AndroidFindBy(id = "layout_tab2")
	@iOSXCUITFindBy(accessibility = "ASSETS")
	private WebElement assetTab;
	
	@FindBy(how = How.CSS, using = "#headerFormat")
	private WebElement headerFormat;
	
	@FindBy(how = How.CSS, using = "#footerLeftFormat")
	private WebElement footerLeftFormat;
	
	@FindBy(how = How.CSS, using = "#footerRightFormat")
	private WebElement footerRightFormat;
	
	@FindBy(how = How.CSS, using = ".bordered-speech-bubble-list")
	private List<WebElement> formatList;
	
	@AndroidFindBy(id = "thumnail_option_layout")
	@iOSXCUITFindBy(accessibility = "Asset Thumbnail")
	private WebElement assetThumbnailCheckBox;
	
	@AndroidFindBy(id = "status_option_layout")
	@iOSXCUITFindBy(accessibility = "Asset Status")
	private WebElement assetStatusCheckBox;
	
	@AndroidFindBy(id = "wo_option_layout")
	@iOSXCUITFindBy(accessibility = "Asset WorkOrder")
	private WebElement assetWorkOrderCheckBox;
	
	@AndroidFindBy(id = "graph_option_layout")
	@iOSXCUITFindBy(accessibility = "Asset Analysis Graph")
	private WebElement assetAnalysisGraphCheckBox;
	
	@AndroidFindBy(id = "meas_table_option_layout")
	@iOSXCUITFindBy(accessibility = "Measurement Table")
	private WebElement assetMeasurementTableCheckBox;
	
	@AndroidFindBy(id = "thermal_image_option_layout")
	@iOSXCUITFindBy(accessibility = "Thermal Image")
	private WebElement assetThermalImageCheckBox;
	
	@FindBy(how = How.CSS, using = ".ajax-loader")
	@AndroidFindBy(className = "android.widget.ProgressBar")
	@iOSXCUITFindBy(accessibility = "In progress")
	private WebElement progressIndicator;
	
	@FindBy(how = How.CSS, using = ".iconDownload")
	@AndroidFindBy(id = "layout_view_pdf")
	private WebElement viewPDF;
	
	@AndroidFindBy(id = "txt_basic_report")
	private WebElement editAndroidBasicReport;
	
	@AndroidFindBy(id = "txt_thermal_image_report")
	private WebElement editAndroidThermalReport;
	
	@AndroidFindBy(id = "layout_content_header")
	private WebElement androidAssetReportContentPage;
	
	@iOSXCUITFindBy(className = "XCUIElementTypeSearchField")
	@FindBy(how = How.CSS, using  = "#searchReportField")
	@AndroidFindBy(id = "report_search_text")
	private WebElement searchTextField;
	
	@FindBy(how = How.CSS, using  = ".report-list-row")
	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id = 'com.fluke.deviceApp:id/report_item_menu']/parent::android.widget.RelativeLayout/parent::android.widget.RelativeLayout")
	@iOSXCUITFindBy(className = "XCUIElementTypeCell")
	private List<WebElement> reportCellList;
	
	@FindBy(how = How.CSS, using = ".check-box")
	private List<WebElement> checkBoxList;
	
	@FindBy(how = How.CSS, using = ".iconDelete")
	@AndroidFindBy(id = "create_text")
	@iOSXCUITFindBy(accessibility = "DELETE")
	private WebElement reportDeleteButton;
	
	@FindBy(how = How.XPATH, using = "//a[. = 'OK']")
	@iOSXCUITFindBy(accessibility = "Delete")
	private WebElement deleteReportConfirmButton;
	
	@iOSXCUITFindBy(iOSNsPredicate = "name = 'Filter' AND type = 'XCUIElementTypeButton'")
	@AndroidFindBy(id = "sortB")
	private WebElement sortAndFilterButton;
	
	@iOSXCUITFindBy(accessibility = "My Reports Only")
	@AndroidFindBy(id = "filter_by_my_reports_only")
	private WebElement filterMyReports;
	
	@iOSXCUITFindBy(accessibility = "All")
	@AndroidFindBy(id = "filter_by_all")
	private WebElement filterALLReports;
	
	@iOSXCUITFindBy(accessibility = "Date")
	@AndroidFindBy(id = "sort_by_date")
	private WebElement sortByDateButton;
	
	@iOSXCUITFindBy(accessibility = "Created By")
	@AndroidFindBy(id = "sort_by_created_by")
	private WebElement sortCreatedByButton;
	
	@iOSXCUITFindBy(accessibility = "backBarButton")
	@AndroidFindBy(id = "done_button")
	private WebElement sortFilterDoneButton;
	
	@iOSXCUITFindBy(accessibility = "Sort")
	@AndroidFindBy(id = "sort_mode")
	private WebElement sortStaticText;
	
	@iOSXCUITFindBy(iOSNsPredicate = "name == 'Edit logo' OR name == 'imagePlaceholderGrey'")
	@AndroidFindBy(id = "layout_company_logo")
	private WebElement addCompanyLogoButton;
	
	@iOSXCUITFindBy(accessibility = "Take Photo")
	@AndroidFindBy(id = "layout_take_photo")
	private WebElement takePhotoButton;
	
	@iOSXCUITFindBy(accessibility = "OK")
	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	private WebElement takePhotoAllowButton;
	
	@iOSXCUITFindBy(accessibility = "PhotoCapture")
	@AndroidFindBy(id = "com.huawei.camera:id/shutter_button")
	private WebElement capturePhotoButton;
	
	@iOSXCUITFindBy(accessibility = "Use Photo")
	@AndroidFindBy(id = "com.huawei.camera:id/done_button")
	private WebElement capturePhotoDoneButton;
	
	@AndroidFindBy(id = "layout_choose_photo")
	private WebElement useExistingPhotoButton;
	
	@iOSXCUITFindBy(accessibility = "Delete Photo")
	@AndroidFindBy(id = "android:id/button1")
	private WebElement removeExistingMeasurementButton;
	
	@AndroidFindBy(id = "btn_edit")
	private WebElement editButtonInReportDetailPage;
	
	@iOSXCUITFindBy(className = "XCUIElementTypeButton")
	private List<WebElement> buttonListInReportDetailPage;
	
	@iOSXCUITFindBy(accessibility = "Edit")
	private WebElement editMeasurementsInReport;
	
	@iOSXCUITFindBy(iOSNsPredicate = "name CONTAINS 'Delete'")
	private WebElement deleteMeasurementsInReport;
	
	@iOSXCUITFindBy(iOSNsPredicate = "name == 'Delete'")
	private WebElement confirmDeleteMeasurementsInReport;
	
	@iOSXCUITFindBy(accessibility = "Done")
	private WebElement doneDeleteMeasurementsInReport;
	
	@iOSXCUITFindBy(accessibility = "Cancel")
	private WebElement clearSearchField;
	
	@iOSXCUITFindBy(iOSNsPredicate = "label == 'OK' OR label == 'Ok'")
	private WebElement unableToEditOkButton;

	private GestureUtils gestureUtils;
	private Switcher switcher;
	private WebElement mReportCell;
	private WebElement mReportTitle;
	private AssetsPage assetsPage;
	private String mAssetReportPageURL;
	private String mAssetReportContentPageURL;
	private String mAssetEditReportContentPageURL;
	private String mAssetExistingReportContentPageURL;
	private boolean captureLogoPremission;

	public ReportsPage() 
	{
		CommonUtils.initElements(this, 5);
		switcher = new Switcher();
		gestureUtils = new GestureUtils();
		assetsPage = new AssetsPage();
		mAssetReportContentPageURL = null;
		mAssetReportPageURL = null;
		mAssetEditReportContentPageURL = null;
		mAssetExistingReportContentPageURL = null;
	}
	

	public void initElements()
	{
		CommonUtils.initElements(this, 5);
	}
	
	public enum ReportPageObjects
	{
		EDIT_COVER_PAGE, REPORTS_BACK_BUTTON, ANDROID_ASSET_REPORT_BACK_BUTTON, SEARCH_FIELD, REPORT_LIST, 
		REPORT_PAGE_CONTENT_URL, ASSET_PAGE_URL, REPORT_PAGE_EDIT_CONTENT_URL, REPORT_PAGE_EXISTING_CONTENT_URL,
		CHECK_BOX_LIST, SORT_BUTTON, REPORTS_OPTIONS_BUTTON, SORT_STATIC_TEXT, SEARCH_CANCEL_BUTTON, UNABLE_TO_EDIT_OK_BUTTON
	}
	
	public enum ReportType
	{
		BASIC_REPORT, BASIC_EDIT_REPORT, ASSET_REPORT, ASSET_EDIT_REPORT, TI_REPORT, TI_EDIT_REPORT,
	}
	
	public WebElement getReportsPageWebElement(ReportPageObjects objectName)
	{
		switch(objectName)
		{
		case EDIT_COVER_PAGE:
			return editCoverButton;
		case REPORTS_BACK_BUTTON:
			return reportsBackButton;
		case ANDROID_ASSET_REPORT_BACK_BUTTON:
			return androidAssetReportBackButton;
		case SEARCH_FIELD:
			return searchTextField;
		case SORT_BUTTON:
			return sortAndFilterButton;
		case REPORTS_OPTIONS_BUTTON:
			return reportsOptionButton;
		case SORT_STATIC_TEXT:
			return sortStaticText;
		case SEARCH_CANCEL_BUTTON:
			return clearSearchField;
		case UNABLE_TO_EDIT_OK_BUTTON:
			return unableToEditOkButton;
		default:
				return null;
		}
	}
	
	public List<WebElement> getReportsPageWebElements(ReportPageObjects objectName)
	{
		switch(objectName)
		{
		case REPORT_LIST:
			return reportCellList;
		case CHECK_BOX_LIST:
			return checkBoxList;
		default:
				return null;
		}
	}
	
	public String getReportsPageAttribute(ReportPageObjects objectName)
	{
		switch(objectName)
		{
		case REPORT_PAGE_CONTENT_URL:
			return mAssetReportContentPageURL;
		case REPORT_PAGE_EDIT_CONTENT_URL:
			return mAssetEditReportContentPageURL;
		case REPORT_PAGE_EXISTING_CONTENT_URL:
			return mAssetExistingReportContentPageURL;
		case ASSET_PAGE_URL:
			return mAssetReportPageURL;
		default:
				return null;
		}
	}
	
	public void createReport(ReportType reportType, int measurementsCount) throws Exception
	{
		ElementUtils.click(2, createReportButton);
		selectReportType(reportType);
		selectMeasurements(measurementsCount, reportType);
		CommonUtils.wait(2);
		setCoverPageDetails(reportType);
		CommonUtils.wait(2);
		saveButton.click();
	}
	
	public void selectReportType(ReportType reportType) throws Exception
	{
		switch(reportType)
		{
		case BASIC_REPORT:
			basicReportButton.click();
			break;
		case TI_REPORT:
			thermalImageReportButton.click();
			break;
		case ASSET_REPORT:
			assetReportButton.click();
			break;
			default:
			basicReportButton.click();
		}
	}
	
	public void selectMeasurements(int measurementsCount, ReportType reportType) throws Exception
	{
		CommonUtils.wait(2);
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.reliableClick(1, measurementsButton, addButton, 3);  //measurementsButton.click();
			List<WebElement> measurementList = measurementListThroughAddedDate;
			if(measurementList.size() < measurementsCount)
				measurementsCount = measurementList.size();
			for(int i = 0; i < measurementsCount; i++)
			{
				measurementList.get(i).click();
				gestureUtils.mScroll(-500, -200, 1);
			}
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			ElementUtils.reliableClick(1, getAndroidMeasurementsButton(reportType), backButton, 3);
			for(int i = 0; i < measurementsCount; i++)
			{
				CommonUtils.wait(1);
				ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "measurement_date", null, null, null, null).click();
				gestureUtils.mScroll(-800, -200, 1);
			}
		}
		addButton.click();
		backButton.click();
	}
	
	public void removeMeasurements(ReportType reportType, int measurementsCount) throws Exception
	{
		CommonUtils.wait(2);
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			ElementUtils.reliableClick(1, getAndroidMeasurementsButton(reportType), backButton, 3);
			for(int i = 0; i < measurementsCount; i++)
			{
				CommonUtils.wait(1);
				ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "measurement_date", null, null, null, null).click();
				removeExistingMeasurementButton.click();
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.reliableClick(1, measurementsButton, addButton, 3);  
			editMeasurementsInReport.click();
			for(int i = 0; i < measurementsCount; i++)
			{
				deleteMeasurementsInReport.click();
				CommonUtils.wait(1);
				confirmDeleteMeasurementsInReport.click();
			}
			doneDeleteMeasurementsInReport.click();
		}
	}
	
	public WebElement getAndroidMeasurementsButton(ReportType reportType)
	{
		switch(reportType)
		{
		case BASIC_EDIT_REPORT:
		case BASIC_REPORT:
			return measurementsButton;
		case TI_EDIT_REPORT:
		case TI_REPORT:
			return androidThermalImagesButton;
			default:
				return null;
		}
	}
	
	public void captureCompanyLogo()
	{
		
		addCompanyLogoButton.click();
		takePhotoButton.click();
		if(captureLogoPremission)
			ElementUtils.safeClick(takePhotoAllowButton);
		CommonUtils.wait(2);
		capturePhotoButton.click();
		CommonUtils.wait(2);
		capturePhotoDoneButton.click();
		CommonUtils.wait(2);
		
	}
	
	public void deleteCompanyLogo(ReportType reportType)
	{
		addCompanyLogoButton.click();
		ElementUtils.safeClick(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Delete", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Delete Photo", null, null));
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) && reportType == ReportType.ASSET_EDIT_REPORT)
			ElementUtils.safeClick(ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Delete", null, null));
	}
	
	public void setCoverPageDetails(ReportType reportType)
	{
		String driverName = DriverManager.getDriverName() + " ";
		editCoverButton.click();
		switch(reportType)
		{
		case BASIC_REPORT:
			ElementUtils.sendKeys(addtionalInformationTextField, driverName + Reports.ReportsAttribute.BASIC_REPORT_ADDITIONAL_INFORMATION.getAttributeValue());
			ElementUtils.sendKeys(reportSubtitleTextField, driverName + Reports.ReportsAttribute.BASIC_REPORT_SUBTITLE.getAttributeValue());
			ElementUtils.sendKeys(reportTitleTextField, driverName + Reports.ReportsAttribute.BASIC_REPORT_TITLE.getAttributeValue());
			captureLogoPremission = true;
			captureCompanyLogo();
			captureLogoPremission = false;
			ElementUtils.sendKeys(companyInfoTextField, driverName + Reports.ReportsAttribute.BASIC_REPORT_COMPANY_INFORMATION.getAttributeValue());
			ElementUtils.sendKeys(companyNameTextField, driverName + Reports.ReportsAttribute.BASIC_REPORT_COMPANY_NAME.getAttributeValue());
			basicReportBackButton.click();
			break;
		case BASIC_EDIT_REPORT:
			addtionalInformationTextField.click();
			reportSubtitleTextField.clear();
			ElementUtils.sendKeys(reportSubtitleTextField, driverName + Reports.ReportsAttribute.BASIC_EDIT_REPORT_SUBTITLE.getAttributeValue());
			reportTitleTextField.clear();
			ElementUtils.sendKeys(reportTitleTextField, driverName + Reports.ReportsAttribute.BASIC_EDIT_REPORT_TITLE.getAttributeValue());
			deleteCompanyLogo(reportType);
			captureCompanyLogo();
			basicReportBackButton.click();
			break;
		case TI_REPORT:
			ElementUtils.sendKeys(addtionalInformationTextField, driverName + Reports.ReportsAttribute.THERMAL_REPORT_ADDITIONAL_INFORMATION.getAttributeValue());
			ElementUtils.sendKeys(reportSubtitleTextField, driverName + Reports.ReportsAttribute.THERMAL_REPORT_SUBTITLE.getAttributeValue());
			ElementUtils.sendKeys(reportTitleTextField, driverName + Reports.ReportsAttribute.THERMAL_REPORT_TITLE.getAttributeValue());
			captureCompanyLogo();
			ElementUtils.sendKeys(companyInfoTextField, driverName + Reports.ReportsAttribute.THERMAL_REPORT_COMPANY_INFORMATION.getAttributeValue());
			ElementUtils.sendKeys(companyNameTextField, driverName + Reports.ReportsAttribute.THERMAL_REPORT_COMPANY_NAME.getAttributeValue());
			thermalImageReportBackButton.click();
			break;
		case TI_EDIT_REPORT:
			addtionalInformationTextField.click();
			reportSubtitleTextField.clear();
			ElementUtils.sendKeys(reportSubtitleTextField, driverName + Reports.ReportsAttribute.THERMAL_EDIT_REPORT_SUBTITLE.getAttributeValue());
			reportTitleTextField.clear();
			ElementUtils.sendKeys(reportTitleTextField, driverName + Reports.ReportsAttribute.THERMAL_EDIT_REPORT_TITLE.getAttributeValue());
			deleteCompanyLogo(reportType);
			captureCompanyLogo();
			thermalImageReportBackButton.click();
			break;
		default:
			ElementUtils.sendKeys(addtionalInformationTextField, driverName + Reports.ReportsAttribute.BASIC_REPORT_ADDITIONAL_INFORMATION.getAttributeValue());
			ElementUtils.sendKeys(reportSubtitleTextField, driverName + Reports.ReportsAttribute.BASIC_REPORT_SUBTITLE.getAttributeValue());
			ElementUtils.sendKeys(reportTitleTextField, driverName + Reports.ReportsAttribute.BASIC_REPORT_TITLE.getAttributeValue());
			gestureUtils.mScroll(100, 100, 1);
			ElementUtils.sendKeys(companyInfoTextField, driverName + Reports.ReportsAttribute.BASIC_REPORT_COMPANY_INFORMATION.getAttributeValue());
			ElementUtils.sendKeys(companyNameTextField, driverName + Reports.ReportsAttribute.BASIC_REPORT_COMPANY_NAME.getAttributeValue());
			basicReportBackButton.click();
			break;
		}
	}

	public WebElement getReportCell(String attributeValue)
	{
		CommonUtils.wait(2);
		if(attributeValue == null)
			return firstReportCell;
		else
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				return DriverManager.getDriver().findElement(By.xpath("//*[contains(text(), '"+attributeValue+"')]/parent::tr"));
			else
			 return null;
	}
	
	public String getReportCreationDate(WebElement reportCell)
	{
		if(reportCell == null)
		{
			String date = reportCreationDate.getText();
			return date.substring(date.indexOf(": "), date.length());
		}
		else
			return null;
	}
	
	public void initReportCell(String attributeValue)
	{
		ElementUtils.isDisplayed(15, createReportButton);
		mReportCell = null;
		mReportCell = getReportCell(attributeValue);
	}
	
	public WebElement isReportType(String date, String reportType)
	{
		return ElementUtils.getElement(mReportCell, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, reportType, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, reportType, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT, reportType);
	}
	
	public WebElement isReportTitle(String reportTitle)
	{
		CommonUtils.wait(0, 2, 0);
		mReportTitle = null;
		mReportTitle = ElementUtils.getElementReliably(6, mReportCell, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, reportTitle, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, reportTitle, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT_CONTAINS, reportTitle);
		return mReportTitle;
	}
	
	public WebElement isReportSubtitle(String reportSubtitle)
	{
		CommonUtils.wait(0, 2, 0);
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			return ElementUtils.getElementReliably(6, mReportCell, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, reportSubtitle, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, reportSubtitle, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT, reportSubtitle);
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			WebElement reportSubTitle = ElementUtils.getElement(mReportCell, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".report-list-title");
			if(reportSubTitle.getText().contains(reportSubtitle))
					return reportSubTitle;
			else
				return null;
		}
		else
			return null;
	}
	
	public boolean viewFirstReport() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			ElementUtils.reliableClick(1, mReportCell, shareButton, 10);
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			mReportCell.click();
			viewPDF.click();
		}
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || (DriverManager.getDriverName().equals(Config.IOS_DRIVER)))
			return ElementUtils.isDisplayed(10, reportFrontPage);
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			mAssetReportPageURL = DriverManager.getDriver().getWindowHandle();
			ElementUtils.getElement(mReportCell, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".check-box").click();
			viewPDF.click();
			boolean returnFlag = false;
			for(String urlList: DriverManager.getDriver().getWindowHandles())
			{
				if(!mAssetReportPageURL.equals(urlList))
				{
					mAssetReportContentPageURL = urlList;
					returnFlag = true;
				}
			}
			return returnFlag;
		}
		else return false;
	}
	
	public boolean viewAndroidFirstAssetReport() throws Exception
	{
		mReportCell.click();
		return ElementUtils.isDisplayed(10, androidAssetReportFrontPage);
	}
	
	public boolean viewWebFirstAssetEditReport()
	{
		mAssetReportPageURL = DriverManager.getDriver().getWindowHandle();
		ElementUtils.getElement(mReportCell, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".check-box").click();
		viewPDF.click();
		boolean returnFlag = false;
		for(String urlList: DriverManager.getDriver().getWindowHandles())
		{
			if(!(mAssetReportPageURL.equals(urlList)))
			{
				if(!mAssetReportContentPageURL.equals(urlList))
				{
					mAssetEditReportContentPageURL = urlList;
					returnFlag = true;
				}	
			}
		}
	return returnFlag;
	}
	
	public void shareReport(String emailAdress, ReportType reportType)
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || (DriverManager.getDriverName().equals(Config.IOS_DRIVER)))
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			     getAndroidShareButton(reportType).click();
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				shareButton.click();
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, "Gmail", null, null, null, null).click();
			ElementUtils.sendKeys(recipientEmailAddressTextField, emailAdress);
			sendButton.click();
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			     getAndroidReportBackButton(reportType).click();
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				reportsBackButton.click();
		}
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			sendButton.click();
			CommonUtils.wait(10);
			DriverManager.getDriver().switchTo().alert().accept();
		}
		
	}
	
	public WebElement getAndroidShareButton(ReportType reportType)
	{
		switch(reportType)
		{
		case BASIC_EDIT_REPORT:
		case BASIC_REPORT:
		case TI_EDIT_REPORT:
		case TI_REPORT:
			return shareButton;
		case ASSET_EDIT_REPORT:
		case ASSET_REPORT:
			return androidAssetReportShareButton;
			default:
				return null;
		}
	}
	
	public WebElement getAndroidReportBackButton(ReportType reportType)
	{
		switch(reportType)
		{
		case BASIC_EDIT_REPORT:
		case BASIC_REPORT:
		case TI_EDIT_REPORT:
		case TI_REPORT:
			return reportsBackButton;
		case ASSET_EDIT_REPORT:
		case ASSET_REPORT:
			return androidAssetReportBackButton;
		default:
			return null;
		}
	}
	
	public void editReport(ReportType reportType, int measurementsCount, int removeMeasurementsCount) throws Exception
	{
		CommonUtils.wait(2);
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.reliableClick(1, reportsOptionButton, editButton, 5);
			editButton.click();
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			reportsOptionButton.click();
			editButton.click();
			selectAndroidEditReportType(reportType);
		}
		removeMeasurements(reportType, removeMeasurementsCount);
		selectMeasurementsEditReport(measurementsCount, reportType);
		setCoverPageDetails(reportType);
		updateButton.click();
		CommonUtils.wait(10);
	}
	
	public void editReportFromReportDetailPage(ReportType reportType, int measurementsCount) throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			editButtonInReportDetailPage.click();
			selectReportType(reportType);
			ElementUtils.reliableClick(1, getAndroidMeasurementsButton(reportType), backButton, 3);
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			buttonListInReportDetailPage.get(buttonListInReportDetailPage.size() - 1).click();
			ElementUtils.reliableClick(1, measurementsButton, addButton, 3);
		}
		selectMeasurementsEditReport(measurementsCount, reportType);
		updateButton.click();
		CommonUtils.wait(10);
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			reportsBackButton.click();
	}
	
	public boolean isReportEditedFromDetailPage()
	{
		return ElementUtils.isDisplayed(15, createReportButton);
	}
	
	public void selectAndroidEditReportType(ReportType reportType)
	{
		switch(reportType)
		{
		case BASIC_EDIT_REPORT:
			editAndroidBasicReport.click();
			break;
		case TI_EDIT_REPORT:
			editAndroidThermalReport.click();
			break;
			default:
				break;
		}
	}
	
	public void selectMeasurementsEditReport(int measurementsCount, ReportType reportType) throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			addButton.click();
			List<WebElement> measurementList = measurementListThroughAddedDate;
			if(measurementList.size() < measurementsCount)
				measurementsCount = measurementList.size();
			for(int i = 0; i < measurementsCount; i++)
			{
				measurementList.get(i).click();
				gestureUtils.mScroll(-500, -200, 1);
			}
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			addButton.click();
			for(int i = 0; i < measurementsCount; i++)
			{
				CommonUtils.wait(2);
				ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "measurement_date", null, null, null, null).click();
				gestureUtils.mScroll(-800, -200, 1);
			}
		}
		addButton.click();
		ElementUtils.reliableClick(1, backButton, updateButton, 5);
	}
	
	public boolean createAssetReport(ReportType reportType, String assetGroupName, int assetCount) throws Exception
	{
		ElementUtils.click(2, createReportButton);
		selectReportType(reportType);
		selectAssetGroup(assetGroupName);
		selectAssets(assetCount);
		setAssetReportCoverPageDetails(reportType);
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || (DriverManager.getDriverName().equals(Config.IOS_DRIVER)))
				setAssetReportContent();
		saveButtonCapital.click();
		return isAssetReportCreated();
	}
	
	public boolean editAssetReport(ReportType reportType, String assetGroupName, int assetCount) throws Exception
	{
		CommonUtils.wait(2);
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.reliableClick(1, reportsOptionButton, editButton, 5);
			editButton.click();
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			reportsOptionButton.click();
			editButton.click();
		}
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			reportsOptionList.get(1).click();
			editButton.click();
		}
		selectAssetGroup(assetGroupName);
		selectEditAssets(assetCount);
		setAssetReportCoverPageDetails(reportType);
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			nextButton.click();
		saveButtonCapital.click();
		return isAssetReportCreated();
	}
	
	public boolean duplicateAssetReport() throws Exception
	{
		reportsOptionList.get(1).click();
		duplicateButton.click();
		CommonUtils.wait(3);
		DriverManager.getDriver().switchTo().alert().accept();
		saveButtonCapital.click();
		return isAssetReportCreated();
	}
	
	public void searchReport(String reportName)
	{
		ElementUtils.sendKeys(searchTextField, reportName);
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			AndroidUtils.executeAndroidKeyCode(AndroidKey.ENTER);
	}
	
	public void selectAssetGroup(String assetGroupName) throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
				addRemoveAssetsButton.click();
				CommonUtils.wait(2);
			}
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
				CommonUtils.wait(2);
				if(!AndroidUtils.isPageLoaded(10))
					ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, AndroidUtils.LOADING_INDICATOR_ID, null, null, null, null).click();
			}
			assetsPage.clickOnAssetGroupNameCM(assetGroupName);
		}
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			addRemoveAssetsButton.click();
			assetsPage.clickOnAssetGroupName(assetGroupName);
		}		
	}
	
	public void selectAssets(int assetCount) throws Exception
	{
		CommonUtils.wait(5, 10, 1);
		List<WebElement> assetList = assetCellList;
		for(int i = 1; i <= assetCount; i++)
		{
			assetList.get(assetList.size() - i).click();
		}
		doneButtonList.get(doneButtonList.size()-1).click();
	}
	
	public void selectEditAssets(int assetCount) throws Exception
	{
		CommonUtils.wait(5, 10, 1);
		List<WebElement> assetList = assetCellList;
		for(int i = 1; i <= assetCount; i++)
		{
			assetList.get(assetList.size() - i - 1).click();
		}
		doneButtonList.get(doneButtonList.size()-1).click();
	}
	
	public void setAssetReportCoverPageDetails(ReportType reportType)
	{
		String driverName = DriverManager.getDriverName() + " ";
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			nextButton.click();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			androidAssetReportContentPage.click();
		switch(reportType)
		{
		case ASSET_REPORT:
			ElementUtils.sendKeys(assetReportSubtitleTextField, driverName + Reports.ReportsAttribute.ASSET_REPORT_SUBTITLE.getAttributeValue());
			ElementUtils.sendKeys(assetReportTitleTextField, driverName + Reports.ReportsAttribute.ASSET_REPORT_TITLE.getAttributeValue());
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				captureCompanyLogo();
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				gestureUtils.mScroll(200, 200, 2);
				ElementUtils.sendKeys(assetReportCompanyNameTextField, driverName + Reports.ReportsAttribute.ASSET_REPORT_COMPANY_NAME.getAttributeValue());
			}
			else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				ElementUtils.sendKeys(assetReportCompanyLogoHeader, Reports.ReportsAttribute.ASSET_REPORT_HEADER_LOGO.getAttributeValue());
				assetReportCompanyLogoHeaderAddButton.click();
				ElementUtils.sendKeys(assetReportCompanyLogoNormal, Reports.ReportsAttribute.ASSET_REPORT_NORMAL_LOGO.getAttributeValue());
				assetReportCompanyLogoNormalAddButton.click();
				ElementUtils.sendKeys(assetReportCustomTextHeader, driverName + Reports.ReportsAttribute.ASSET_REPORT_CUSTOM_HEADER.getAttributeValue());
				ElementUtils.sendKeys(assetReportCompanyNameTextField, driverName + Reports.ReportsAttribute.ASSET_REPORT_COMPANY_NAME.getAttributeValue());
				ElementUtils.sendKeys(assetReportInformationTextField, driverName + Reports.ReportsAttribute.ASSET_REPORT_COMPANY_INFORMATION.getAttributeValue());
				ElementUtils.sendKeys(assetReportAdditionalInformationTextField, driverName + Reports.ReportsAttribute.ASSET_REPORT_ADDITIONAL_INFORMATION.getAttributeValue());
				ElementUtils.sendKeys(assetReportCustomTextFooter, driverName + Reports.ReportsAttribute.ASSET_REPORT_CUSTOM_FOOTER.getAttributeValue());
			}
			break;
		case ASSET_EDIT_REPORT:
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				assetReportAdditionalInformationTextField.click();
				gestureUtils.mScroll(-100, -100, 1);
			}
			editAssetReportSubtitleTextField.clear();
			ElementUtils.sendKeys(assetReportSubtitleTextField, driverName + Reports.ReportsAttribute.ASSET_EDIT_REPORT_SUBTITLE.getAttributeValue());
			editAssetReportTitleTextField.clear();
			ElementUtils.sendKeys(assetReportTitleTextField, driverName + Reports.ReportsAttribute.ASSET_EDIT_REPORT_TITLE.getAttributeValue());
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				assetReportCompanyNameTextField.clear();
				ElementUtils.sendKeys(assetReportCompanyNameTextField, driverName + Reports.ReportsAttribute.ASSET_EDIT_REPORT_COMPANY_NAME.getAttributeValue());
				assetReportInformationTextField.clear();
				ElementUtils.sendKeys(assetReportInformationTextField, driverName + Reports.ReportsAttribute.ASSET_EDIT_REPORT_COMPANY_INFORMATION.getAttributeValue());
				assetReportAdditionalInformationTextField.clear();
				ElementUtils.sendKeys(assetReportAdditionalInformationTextField, driverName + Reports.ReportsAttribute.ASSET_EDIT_REPORT_ADDITIONAL_INFORMATION.getAttributeValue());
			}
			break;
		default:
			break;
		}
	}
	
	public void setAssetReportContent()
	{
		assetTab.click();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			assetThumbnailCheckBox.click();
			assetStatusCheckBox.click();
			assetWorkOrderCheckBox.click();
			assetAnalysisGraphCheckBox.click();
			assetMeasurementTableCheckBox.click();
			gestureUtils.mScroll(-500, -200, 1);
			assetThermalImageCheckBox.click();
		}
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			headerFormat.click();
			CommonUtils.wait(1);
			gestureUtils.getJavaScriptExecutor().executeScript("arguments[0].click();", ElementUtils.getElement(formatList.get(0), null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT, "Custom Text"));
			GestureUtils.moveToElement(assetTab);
			footerLeftFormat.click();
			CommonUtils.wait(19);
			ElementUtils.getElement(formatList.get(1), null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT, "Created By").click();
			GestureUtils.moveToElement(assetTab);
			footerRightFormat.click();
			GestureUtils.moveToElement(assetTab);
			ElementUtils.getElement(formatList.get(2), null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT, "Custom Text").click();
		}
		
	}
	
	public boolean isAssetReportCreated() throws Exception
	{
		while(true)
		{
			if(ElementUtils.isDisplayed(15, createReportButton))
				break;
		}
		CommonUtils.wait(10, 10, 5);
		for(int i = 0; i < 15; i++)
		{
			if(ElementUtils.isEnabled(1, progressIndicator))
				CommonUtils.wait(1);
			else 
				return true;
		}
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			switcher.switchToAssetsPage();
			CommonUtils.wait(2);
			switcher.switchToReportsPage();
			CommonUtils.wait(10);
		}
		if(ElementUtils.isDisplayed(5, progressIndicator))
			return false;
		else 
			return true;
	}
	
	
	// Used for iOS Simulator in iOS Smoke
	public void deleteReportIOSSimulator() throws Exception {
		ElementUtils.clickIfDisplayedAndEnabled(editButton);
		CommonUtils.wait(1);
		ElementUtils.safeClick("Delete Report", null, null);
		CommonUtils.wait(1);
		ElementUtils.safeClick("Delete", null, null);
		CommonUtils.wait(1);
		ElementUtils.safeClick("Delete", null, null);
		CommonUtils.wait(1);
		ElementUtils.clickIfDisplayedAndEnabled(doneButton);
	}
	
	public void selectMultipleMeasurements(int numberOfMeasurements)
	{
		List<WebElement> measurementList = measurementListThroughAddedDate;
		if(measurementList.size()<numberOfMeasurements)
			numberOfMeasurements = measurementList.size();
		for(int i=0; i<numberOfMeasurements;i++)
		{
			measurementList.get(i).click();
			gestureUtils.mScroll(-350, -200, 1);
		}
	}
	
	public void selectMeasurementsAndCreateReport(String reportName, int measurementsCount) {
		try {
			selectMultipleMeasurements(measurementsCount);
			CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(30, 1, addButton);
			CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(30, 1, backButton);
		} catch (Throwable e) {
			DriverManager.getDriver().findElement(MobileBy.AccessibilityId("Cancel")).click();
		}
		CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(30, 1, editCoverButton);
		ElementUtils.sendKeys(companyNameTextField, reportName);
		if(reportName.contains("CNX"))
			CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(30, 1, basicReportBackButton);
		else if(reportName.contains("TI"))
			CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(30, 1, thermalImageReportBackButton);
		CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(30, 1, saveButton);
		CommonUtils.wait(15);
	} 

	public void createBasicReportWithMultipleMeasurements(String reportName, int measurementsCount) 
	{
		CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(30, 1, createReportButton);
		CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(30, 1, basicReportButton);
		CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(30, 1, measurementsButton);
		selectMeasurementsAndCreateReport(reportName, measurementsCount);
	}

	public void createThermalImageReportWithMultipleMeasurements(String reportName, int measurementsCount) {
		CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(30, 1, createReportButton);
		CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(30, 1, thermalImageReportButton);
		CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(30, 1, thermalImageMeasurementsButton);
		selectMeasurementsAndCreateReport(reportName, measurementsCount);
	}
	
	public void viewBasicReport() throws Exception {
		CommonUtils.isElementDisplayedWithinFluentWait(180, 1, createReportButton);
		CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(60, 1, CommonUtils.getElementByUsingID("Basic Report"));
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(180, 1, viewPdf);
		}
		ElementUtils.safeClick(unableToEditOkButton);
		CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(240, 1, reportFrontPage);
		ElementUtils.clickIfDisplayedAndEnabled(reportsBackButton);
	}

	public void viewThermalImageReport() throws Exception {
		CommonUtils.isElementDisplayedWithinFluentWait(180, 1, createReportButton);
		CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(60, 1,
				ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, "Thermal Report",
						LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Thermal Image Report", null, null));
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(180, 1, viewPdf);
		}
		ElementUtils.safeClick(unableToEditOkButton);
		CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(240, 1, reportFrontPage);
		ElementUtils.clickIfDisplayedAndEnabled(reportsBackButton);
	}
	
	public void deleteReports() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			for(WebElement element: getReportsPageWebElements(ReportPageObjects.CHECK_BOX_LIST))
			{
				element.click();
			}
			initReportCell(Reports.ReportsAttribute.EXISTING_ASSET_REPORT_TITLE.getAttributeValue());
			ElementUtils.getElement(mReportCell, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".check-box").click();
			reportDeleteButton.click();
			deleteReportConfirmButton.click();
			CommonUtils.wait(3);
			DriverManager.getDriver().switchTo().alert().accept();
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			CommonUtils.wait(3);
			List<WebElement> reportsList = reportCellList;
			for(int i = 0; i < reportsList.size(); i++)
			{
				if(i == 0)
					gestureUtils.longPressElement(reportsList.get(i), Duration.ofSeconds(5));
				else if(i > 0)
					reportsList.get(i).click();
				gestureUtils.mScroll(-500, -200, 1);
			}
			reportDeleteButton.click();
			deleteReportConfirmButton.click();
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			CommonUtils.wait(2);
			List<WebElement> reportsList = reportCellList;
			for(int i = 0; i < reportsList.size(); i++)
			{
				if(i == 0)
					gestureUtils.longPressElement(reportsList.get(i), Duration.ofSeconds(5));
				else if(i > 0)
					reportsList.get(i).click();
				gestureUtils.mScroll(-500, -150, 1);
			}
			reportDeleteButton.click();
		}
	}
	
	public void deleteReport()
	{
		int counter = 0;
		while(ElementUtils.isDisplayed(1, reportsOptionButton))
		{
			ElementUtils.safeClick(reportsOptionButton);
			CommonUtils.wait(2);
			ElementUtils.safeClick(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, "Delete", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID	, "Delete", null, null));
			CommonUtils.wait(2);
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				ElementUtils.safeClick(ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID	, "Delete", null, null));
			CommonUtils.wait(2);
			counter++;
			if(counter == 12)
				break;
		}
	}
	
	public void deleteReport(int count)
	{
		int counter = 0;
		while(ElementUtils.isDisplayed(3, reportsOptionButton))
		{
			ElementUtils.safeClick(reportsOptionButton);
			CommonUtils.wait(2);
			ElementUtils.safeClick(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, "Delete", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID	, "Delete", null, null));
			CommonUtils.wait(2);
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				ElementUtils.safeClick(ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID	, "Delete", null, null));
			CommonUtils.wait(2);
			counter++;
			if(counter == count)
				break;
		}
	}
	
	public void sortFilterReport(String actionName, ReportsOptions filterName)
	{
		sortAndFilterButton.click();
		CommonUtils.wait(1);
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, actionName, null, null, null, null).click();
		switch(filterName)
		{
		case FILTER_ALL:
			filterALLReports.click();
			break;
		case FILTER_MY_REPORTS:
			filterMyReports.click();
			break;
		case SORT_BY_DATE:
			sortByDateButton.click();
			break;
		case SORT_CREATED_BY:
			sortCreatedByButton.click();
			break;
		}
		sortFilterDoneButton.click();
	}
	
	
}