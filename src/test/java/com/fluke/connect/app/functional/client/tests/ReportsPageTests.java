package com.fluke.connect.app.functional.client.tests;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.fluke.connect.app.functional.client.pages.AssetsPage;
import com.fluke.connect.app.functional.client.pages.CaptureMeasurementsPage;
import com.fluke.connect.app.functional.client.pages.MeasurementsHistoryPage;
import com.fluke.connect.app.functional.client.pages.ReportsPage;
import com.fluke.connect.app.functional.client.pages.ServiceHatchPage;
import com.fluke.connect.app.functional.client.pages.SettingsPage;
import com.fluke.connect.app.functional.client.pages.Switcher;
import com.fluke.connect.app.functional.client.pages.ReportsPage.ReportPageObjects;
import com.fluke.connect.app.functional.client.pages.ReportsPage.ReportType;
import com.fluke.connect.app.testdata.Reports;
import com.fluke.connect.app.testdata.SignIn;
import com.fluke.connect.app.testdata.Reports.ReportsAttribute;
import com.fluke.connect.app.testdata.Reports.ReportsOptions;
import com.fluke.connect.app.testdata.SignIn.FeatureList;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverFactory;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.Gestures;
import com.fluke.connect.app.utils.PDFUtils;
import com.fluke.connect.app.utils.VisualUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import com.fluke.connect.app.utils.Config.LocatorStrategy;

@SuppressWarnings("unused")
public class ReportsPageTests {
	private ReportsPage reportsPage;
	private boolean testFailureFlag = false;
	private Switcher switcher;
	private SettingsPage settingsPage;
	private ServiceHatchPage serviceHatchPage;
	private CaptureMeasurementsPage captureMeasurementsPage;
	private MeasurementsHistoryPage measurementHistoryPage;
	private AssetsPage assetsPage;
	private Gestures gesture;
	private String mDriverName;

	private String mReportContent = null;
	
	@BeforeClass(groups = {Config.REPORT_TESTS, Config.IOS_SMOKE_TESTS, Config.IOS_REPORT_SMOKE_EXT_TESTS, 
			Config.REPORT_TESTS_WEB, Config.ANDROID_SMOKE_EXTENDED_TESTS, Config.REPORT_UAT_TEST, Config.TEMP})

	public void initClass() throws Exception 
	{
		if(!DriverManager.isSmokeSuite()) {
		DriverManager.getSignIn().signIn(SignIn.getUID(FeatureList.REPORTS), SignIn.getPWD(FeatureList.REPORTS));
        DriverManager.getSignIn().handleAfterSignInAlertsOtherUser();
		}
		reportsPage = new ReportsPage();
		switcher = new Switcher();
		gesture = new Gestures();
		serviceHatchPage = new ServiceHatchPage();
		mDriverName = DriverManager.getDriverName() + " ";
		assetsPage = new AssetsPage();
		switcher.switchToReportsPage();
	}

	@Test(alwaysRun = true, priority = 48301, groups = {Config.IOS_SMOKE_TESTS, Config.ANDROID_SMOKE_EXTENDED_TESTS})
	public void deleteThermalImageReportTest() throws Exception 
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			reportsPage.deleteReportIOSSimulator();
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			reportsPage.deleteReport(1);
	}

	@Test(alwaysRun = true, priority = 48302, groups = {Config.IOS_SMOKE_TESTS, Config.ANDROID_SMOKE_EXTENDED_TESTS})
	public void deleteBasicReportTest() throws Exception {
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			reportsPage.deleteReportIOSSimulator();
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			reportsPage.deleteReport(1);
	}

	@Test(alwaysRun = true, priority = 48303, groups = {Config.IOS_SMOKE_TESTS, Config.ANDROID_SMOKE_EXTENDED_TESTS})
	public void createBasicReportTest() throws Exception 
	{
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
				serviceHatchPage.toggleAssetReport(true);
				switcher.switchToReportsPage();
			}
			reportsPage.createBasicReportWithMultipleMeasurements("CNX Report", 2);
	}

	@Test(alwaysRun = true, priority = 48304, groups = {Config.IOS_SMOKE_TESTS, Config.ANDROID_SMOKE_EXTENDED_TESTS})
	public void viewBasicReportTest() throws Exception 
	{
		reportsPage.viewBasicReport();
	}

	@Test(alwaysRun = true, priority = 48305, groups = {Config.IOS_SMOKE_TESTS, Config.ANDROID_SMOKE_EXTENDED_TESTS})
	public void createThermalImageReportTest() {
		reportsPage.createThermalImageReportWithMultipleMeasurements("TI Report", 1);
	}

	@Test(alwaysRun = true, priority = 48306, groups = {Config.IOS_SMOKE_TESTS, Config.ANDROID_SMOKE_EXTENDED_TESTS})
	public void viewThermalImageReportTest() {
		try {
			reportsPage.viewThermalImageReport();
		} catch (Exception e) {
			Assert.fail("Exception Detail: " + e);
		}
	}
	
	//************************************* Reports Test Suite ***************************************************

	@Test(priority = 20048500, groups = {Config.TEMP, Config.REPORT_TESTS, Config.REPORT_UAT_TEST})
	@Severity(SeverityLevel.CRITICAL)
	@Description("Create Basic Report")
	public void createReportBasicTest() throws Exception 
	{
		reportsPage.createReport(ReportType.BASIC_REPORT, 6);
	}

	@Test(priority = 20048501, groups = {Config.TEMP, Config.REPORT_TESTS, Config.REPORT_UAT_TEST}, dependsOnMethods = {"createReportBasicTest"})
	public void verifyBasicReportTypeTest() throws Exception 
	{
		reportsPage.initReportCell(null);
		reportsPage.searchReport("Basic");
		Assert.assertNotNull(reportsPage.isReportType(null, Reports.ReportsAttribute.BASIC_REPORT.getAttributeValue()));
	}
	
	@Test(priority = 20048502, groups = {Config.TEMP, Config.REPORT_TESTS, Config.IOS_REPORT_SMOKE_EXT_TESTS, Config.REPORT_UAT_TEST}, dependsOnMethods = {"createReportBasicTest"})
	public void verifyBasicReportTitleTest() throws Exception 
	{
		Assert.assertNotNull(reportsPage.isReportTitle(mDriverName + Reports.ReportsAttribute.BASIC_REPORT_TITLE.getAttributeValue()));
	}

	@Test(priority = 20048503, groups = {Config.TEMP, Config.REPORT_TESTS, Config.IOS_REPORT_SMOKE_EXT_TESTS, Config.REPORT_UAT_TEST}, dependsOnMethods = {"createReportBasicTest"})
	public void verifyBasicReportSubTitleTest() throws Exception 
	{
		Assert.assertNotNull(reportsPage.isReportSubtitle(mDriverName + Reports.ReportsAttribute.BASIC_REPORT_SUBTITLE.getAttributeValue()));
	}
	
	@Test(priority = 20048503, groups = {Config.REPORT_TESTS, Config.IOS_REPORT_SMOKE_EXT_TESTS, Config.REPORT_UAT_TEST}, dependsOnMethods = {"createReportBasicTest"})
	public void viewReportBasicTest() throws Exception 
	{
		Assert.assertTrue(reportsPage.viewFirstReport());
	}

	@Test(priority = 20048504, groups = {Config.REPORT_TESTS, Config.IOS_REPORT_SMOKE_EXT_TESTS, Config.REPORT_UAT_TEST}, dependsOnMethods = {"viewReportBasicTest"})
	public void shareReportBasicTest() throws Exception 
	{
		reportsPage.shareReport(Config.SHARE_EMAIL_ADDRESS, ReportType.BASIC_REPORT);
		reportsPage.getReportsPageWebElement(ReportPageObjects.SEARCH_FIELD).clear();
	}
	
	@Test(priority = 20048505, groups = {Config.IOS_REPORT_SMOKE_EXT_TESTS}, dependsOnMethods = {"createReportBasicTest"})
	public void editReportBasicTest() throws Exception 
	{
		reportsPage.initElements();
		reportsPage.editReport(ReportType.BASIC_EDIT_REPORT, 4, 3);
	}
	
	@Test(priority = 20048506, groups = { Config.IOS_REPORT_SMOKE_EXT_TESTS}, dependsOnMethods = {"editReportBasicTest"})
	public void verifyEditedBasicReportTitleTest() throws Exception 
	{
		reportsPage.initReportCell(null);
		Assert.assertNotNull(reportsPage.isReportTitle(mDriverName + Reports.ReportsAttribute.BASIC_EDIT_REPORT_TITLE.getAttributeValue()));
	}
	
	@Test(priority = 20048507, groups = { Config.IOS_REPORT_SMOKE_EXT_TESTS}, dependsOnMethods = {"editReportBasicTest"})

	public void verifyEditedBasicReportSubTitleTest() throws Exception 
	{
		Assert.assertNotNull(reportsPage.isReportSubtitle(mDriverName + Reports.ReportsAttribute.BASIC_EDIT_REPORT_SUBTITLE.getAttributeValue()));
	}
	
	@Test(priority = 20048508, groups = { Config.IOS_REPORT_SMOKE_EXT_TESTS}, dependsOnMethods = {"editReportBasicTest"})
	public void viewEditedReportBasicTest() throws Exception 
	{
		Assert.assertTrue(reportsPage.viewFirstReport());
	}
	
	@Test(priority = 20048509, groups = {}, dependsOnMethods = {"editReportBasicTest"})
	public void backReportBasicTest() throws Exception 
	{
		reportsPage.getReportsPageWebElement(ReportPageObjects.REPORTS_BACK_BUTTON).click();
	}
	
	@Test(priority = 20048515, groups = {}, dependsOnMethods = {"viewEditedReportBasicTest"})
	public void editReportFromDetailPageBasicTest() throws Exception 
	{
		reportsPage.initElements();
		reportsPage.editReportFromReportDetailPage(ReportType.BASIC_REPORT, 1);
		Assert.assertTrue(reportsPage.isReportEditedFromDetailPage());
	}
	
	@Test(priority = 20048525, groups = {Config.REPORT_TESTS, Config.REPORT_UAT_TEST})//Config.ANDROID_SMOKE_EXTENDED_TESTS, ,
	public void createReportTITest() throws Exception 
	{
		reportsPage.initElements();
		reportsPage.createReport(ReportType.TI_REPORT, 3);
	}
	
	@Test(priority = 20048526, groups = {Config.REPORT_TESTS, Config.REPORT_UAT_TEST}, dependsOnMethods = {"createReportTITest"}) //Config.ANDROID_SMOKE_EXTENDED_TESTS, 
	public void verifyTIReportTypeTest() throws Exception 
	{
		reportsPage.initReportCell(null);
		reportsPage.searchReport("Thermal");
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertNotNull(reportsPage.isReportType(null, Reports.ReportsAttribute.THERMAL_REPORT.getAttributeValue()));
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			Assert.assertNotNull(reportsPage.isReportType(null, Reports.ReportsAttribute.THERMAL_REPORT_ANDROID.getAttributeValue()));
	}
	
	@Test(priority = 20048527, groups = {Config.REPORT_TESTS, Config.REPORT_UAT_TEST}, dependsOnMethods = {"createReportTITest"}) //Config.ANDROID_REPORT_EXT_SMOKE_TESTS,
	public void verifyTIReportTitleTest() throws Exception 
	{
		Assert.assertNotNull(reportsPage.isReportTitle(mDriverName + Reports.ReportsAttribute.THERMAL_REPORT_TITLE.getAttributeValue()));
	}
	
	@Test(priority = 20048528, groups = {Config.REPORT_TESTS, Config.REPORT_UAT_TEST}, dependsOnMethods = {"createReportTITest"}) //Config.ANDROID_REPORT_EXT_SMOKE_TESTS,
	public void verifyTIReportSubTitleTest() throws Exception 
	{
		Assert.assertNotNull(reportsPage.isReportSubtitle(mDriverName + Reports.ReportsAttribute.THERMAL_REPORT_SUBTITLE.getAttributeValue()));
	}
	
	@Test(priority = 20048529, groups = {Config.REPORT_TESTS, Config.REPORT_UAT_TEST}, dependsOnMethods = {"createReportTITest"}) //Config.ANDROID_REPORT_EXT_SMOKE_TESTS,
	public void viewReportTITest() throws Exception 
	{
		Assert.assertTrue(reportsPage.viewFirstReport());
	}
	
	@Test(priority = 20048530, groups = {Config.REPORT_TESTS, Config.REPORT_UAT_TEST}, dependsOnMethods = {"viewReportTITest"}) //Config.ANDROID_REPORT_EXT_SMOKE_TESTS,
	public void shareReportTITest() throws Exception 
	{
		reportsPage.shareReport(Config.SHARE_EMAIL_ADDRESS, ReportType.TI_REPORT);
		reportsPage.getReportsPageWebElement(ReportPageObjects.SEARCH_FIELD).clear();
	}     
	
	@Test(priority = 20048531, groups = {}, dependsOnMethods = {"createReportTITest"}) //Config.ANDROID_REPORT_EXT_SMOKE_TESTS,
	public void editReportTITest() throws Exception 
	{
		reportsPage.initElements();
		reportsPage.editReport(ReportType.TI_EDIT_REPORT, 2, 1);
	}
	
	@Test(priority = 20048532, groups = {}, dependsOnMethods = {"editReportTITest"}) //Config.ANDROID_REPORT_EXT_SMOKE_TESTS,
	public void verifyEditedTIReportTitleTest() throws Exception 
	{
		reportsPage.initReportCell(null);
		Assert.assertNotNull(reportsPage.isReportTitle(mDriverName + Reports.ReportsAttribute.THERMAL_EDIT_REPORT_TITLE.getAttributeValue()));
	}
	
	@Test(priority = 20048533, groups = {}, dependsOnMethods = {"editReportTITest"}) //Config.ANDROID_REPORT_EXT_SMOKE_TESTS,
	public void verifyEditedTIReportSubTitleTest() throws Exception 
	{
		Assert.assertNotNull(reportsPage.isReportSubtitle(mDriverName + Reports.ReportsAttribute.THERMAL_EDIT_REPORT_SUBTITLE.getAttributeValue()));
	}
	
	@Test(priority = 20048534, groups = {}, dependsOnMethods = {"editReportTITest"}) //Config.ANDROID_REPORT_EXT_SMOKE_TESTS,
	public void viewEditedReportTITest() throws Exception 
	{
		Assert.assertTrue(reportsPage.viewFirstReport());
	}
	
	@Test(priority = 20048540, groups = {}, dependsOnMethods = {"viewEditedReportTITest"})
	public void editReportFromDetailPageTITest() throws Exception 
	{
		reportsPage.initElements();
		reportsPage.editReportFromReportDetailPage(ReportType.TI_REPORT, 1);
		Assert.assertTrue(reportsPage.isReportEditedFromDetailPage());
	}
	
	@Test(priority = 20048550, description = "Test Result Description", groups = {Config.REPORT_TESTS, Config.REPORT_TESTS_WEB, Config.REPORT_UAT_TEST})
	@Severity(SeverityLevel.CRITICAL)
	public void createAssetReportTest() throws Exception 
	{
		reportsPage.initElements();
		Assert.assertTrue(reportsPage.createAssetReport(ReportType.ASSET_REPORT, "Ungrouped Assets", 1));
	}
	
	@Test(priority = 20048551, groups = {Config.REPORT_TESTS_WEB}, dependsOnMethods = {"createAssetReportTest"})
	public void searchAssetReportTest() throws Exception 
	{
		int currentReportCount = reportsPage.getReportsPageWebElements(ReportPageObjects.REPORT_LIST).size();
		reportsPage.getReportsPageWebElement(ReportPageObjects.SEARCH_FIELD).sendKeys(mDriverName + Reports.ReportsAttribute.ASSET_REPORT_TITLE.getAttributeValue());
		Assert.assertTrue(reportsPage.getReportsPageWebElements(ReportPageObjects.REPORT_LIST).size() < currentReportCount);
	}
	
	@Test(priority = 20048552, groups = {Config.REPORT_TESTS, Config.REPORT_TESTS_WEB, Config.REPORT_UAT_TEST}, dependsOnMethods = {"createAssetReportTest"})
	public void verifyAssetReportTypeTest() throws Exception 
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || (DriverManager.getDriverName().equals(Config.IOS_DRIVER))) {
			reportsPage.initReportCell(null);
			reportsPage.searchReport("Asset");
		}
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			reportsPage.initReportCell(mDriverName + Reports.ReportsAttribute.ASSET_REPORT_TITLE.getAttributeValue());
		Assert.assertNotNull(reportsPage.isReportType(null, Reports.ReportsAttribute.ASSET_REPORT.getAttributeValue()));
	}
	
	@Test(priority = 20048553, groups = {Config.REPORT_TESTS, Config.REPORT_TESTS_WEB, Config.REPORT_UAT_TEST}, dependsOnMethods = {"createAssetReportTest"}) 
	public void verifyAssetReportTitleTest() throws Exception 
	{
		Assert.assertNotNull(reportsPage.isReportTitle(mDriverName + Reports.ReportsAttribute.ASSET_REPORT_TITLE.getAttributeValue()));
	}
	
	@Test(priority = 20048554, groups = {Config.REPORT_TESTS, Config.REPORT_TESTS_WEB, Config.REPORT_UAT_TEST}, dependsOnMethods = {"createAssetReportTest"})
	public void verifyAssetReportSubTitleTest() throws Exception 
	{
		Assert.assertNotNull(reportsPage.isReportSubtitle(mDriverName + Reports.ReportsAttribute.ASSET_REPORT_SUBTITLE.getAttributeValue()));
	}
	
	@Test(priority = 20048555, groups = {Config.REPORT_TESTS, Config.REPORT_TESTS_WEB, Config.REPORT_UAT_TEST}, dependsOnMethods = {"createAssetReportTest"})
	public void viewAssetReportTest() throws Exception 
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			Assert.assertTrue(reportsPage.viewAndroidFirstAssetReport());
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(reportsPage.viewFirstReport());
	}
	
	@Test(priority = 20048556, groups = {Config.REPORT_TESTS_WEB}, dependsOnMethods = {"viewAssetReportTest"})
	public void verifyAssetReportTitleInReportContentTest() throws Exception 
	{
		CommonUtils.wait(5);
		DriverManager.getDriver().switchTo().window(reportsPage.getReportsPageAttribute(ReportPageObjects.REPORT_PAGE_CONTENT_URL));
		mReportContent = PDFUtils.getText(DriverManager.getDriver().getCurrentUrl());
		Assert.assertTrue(mReportContent.contains(mDriverName + Reports.ReportsAttribute.ASSET_REPORT_TITLE.getAttributeValue()));
	}
	
	@Test(priority = 20048557, groups = {Config.REPORT_TESTS_WEB}, dependsOnMethods = {"viewAssetReportTest"})
	public void verifyAssetReportSubTitleInReportContentTest() throws Exception 
	{
		Assert.assertTrue(mReportContent.contains(mDriverName + Reports.ReportsAttribute.ASSET_REPORT_SUBTITLE.getAttributeValue()));
	}
	
	@Test(priority = 20048558, groups = {Config.REPORT_TESTS_WEB}, dependsOnMethods = {"viewAssetReportTest"})
	public void verifyAssetReportCompanyNameInReportContentTest() throws Exception 
	{
		Assert.assertTrue(mReportContent.contains(mDriverName + Reports.ReportsAttribute.ASSET_REPORT_COMPANY_NAME.getAttributeValue()));
	}
	
	@Test(priority = 20048559, groups = {Config.REPORT_TESTS_WEB}, dependsOnMethods = {"viewAssetReportTest"})
	public void verifyAssetReportCompanyInformationInReportContentTest() throws Exception 
	{
		Assert.assertTrue(mReportContent.contains(mDriverName + Reports.ReportsAttribute.ASSET_REPORT_COMPANY_INFORMATION.getAttributeValue()));
	}
	
	@Test(priority = 20048560, groups = {Config.REPORT_TESTS_WEB}, dependsOnMethods = {"viewAssetReportTest"})
	public void verifyAssetReportAdditionalInformationInReportContentTest() throws Exception 
	{
		Assert.assertTrue(mReportContent.contains(mDriverName + Reports.ReportsAttribute.ASSET_REPORT_ADDITIONAL_INFORMATION.getAttributeValue()));
	}
	
	@Test(priority = 20048561, groups = {}, dependsOnMethods = {"viewAssetReportTest"})
	public void verifyAssetReportCustomHeaderInReportContentTest() throws Exception 
	{
		Assert.assertTrue(mReportContent.contains(mDriverName + Reports.ReportsAttribute.ASSET_REPORT_CUSTOM_HEADER.getAttributeValue()));
	}
	
	@Test(priority = 20048562, groups = {}, dependsOnMethods = {"viewAssetReportTest"})
	public void verifyAssetReportCustomFooterInReportContentTest() throws Exception 
	{
		Assert.assertTrue(mReportContent.contains(mDriverName + Reports.ReportsAttribute.ASSET_REPORT_CUSTOM_FOOTER.getAttributeValue()));
	}
	
	@Test(priority = 20048563, groups = {Config.REPORT_TESTS_WEB}, dependsOnMethods = {"viewAssetReportTest"})
	public void verifyAssetReportContentTest() throws Exception 
	{
		Assert.assertTrue(mReportContent.contains(Reports.ReportsAttribute.ASSET_REPORT_CONTENT_PREPROD.getAttributeValue()));
	}
	
	@Test(priority = 20048564, groups = {Config.REPORT_TESTS_WEB}, dependsOnMethods = {"viewAssetReportTest"})
	public void switchToAssetReportPageTest() throws Exception 
	{
		DriverManager.getDriver().switchTo().window(reportsPage.getReportsPageAttribute(ReportPageObjects.ASSET_PAGE_URL));
	}
	
	@Test(priority = 20048565, groups = {Config.REPORT_TESTS, Config.REPORT_TESTS_WEB}, dependsOnMethods = {"viewAssetReportTest"})
	public void shareAssetReportTest() throws Exception 
	{
		reportsPage.shareReport(Config.SHARE_EMAIL_ADDRESS, ReportType.ASSET_REPORT);
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || (DriverManager.getDriverName().equals(Config.IOS_DRIVER)))
			reportsPage.getReportsPageWebElement(ReportPageObjects.SEARCH_FIELD).clear();
	}
	
	@Test(priority = 20048566, groups = { Config.REPORT_TESTS_WEB}, dependsOnMethods = {"viewAssetReportTest"})
	public void editAssetReportTest() throws Exception 
	{
		reportsPage.initElements();
		Assert.assertTrue(reportsPage.editAssetReport(ReportType.ASSET_EDIT_REPORT, "Ungrouped Assets", 1));
	}
	
	@Test(priority = 20048567, groups = { Config.REPORT_TESTS_WEB}, dependsOnMethods = {"editAssetReportTest"})
	public void verifyEditedAssetReportTitleTest() throws Exception 
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || (DriverManager.getDriverName().equals(Config.IOS_DRIVER)))
			reportsPage.initReportCell(null);
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			reportsPage.initReportCell(mDriverName + Reports.ReportsAttribute.ASSET_EDIT_REPORT_TITLE.getAttributeValue());
		Assert.assertNotNull(reportsPage.isReportTitle(mDriverName + Reports.ReportsAttribute.ASSET_EDIT_REPORT_TITLE.getAttributeValue()));
	}
	
	@Test(priority = 20048568, groups = { Config.REPORT_TESTS_WEB}, dependsOnMethods = {"editAssetReportTest"})
	public void verifyEditedAssetReportSubTitleTest() throws Exception 
	{
		Assert.assertNotNull(reportsPage.isReportSubtitle(mDriverName + Reports.ReportsAttribute.ASSET_EDIT_REPORT_SUBTITLE.getAttributeValue()));
	}
	
	@Test(priority = 20048569, groups = {Config.REPORT_TESTS_WEB}, dependsOnMethods = {"editAssetReportTest"})
	public void viewEditedAssetReportTest() throws Exception 
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Assert.assertTrue(reportsPage.viewAndroidFirstAssetReport());
			reportsPage.getReportsPageWebElement(ReportPageObjects.ANDROID_ASSET_REPORT_BACK_BUTTON).click();
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			Assert.assertTrue(reportsPage.viewFirstReport());
		    reportsPage.getReportsPageWebElement(ReportPageObjects.REPORTS_BACK_BUTTON).click();
		}
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(reportsPage.viewWebFirstAssetEditReport());
	}
	
	@Test(priority = 20048570, groups = {Config.REPORT_TESTS_WEB}, dependsOnMethods = {"viewEditedAssetReportTest"})
	public void verifyEditedAssetReportTitleInReportContentTest() throws Exception 
	{
		CommonUtils.wait(5);
		DriverManager.getDriver().switchTo().window(reportsPage.getReportsPageAttribute(ReportPageObjects.REPORT_PAGE_EDIT_CONTENT_URL));
		mReportContent = null;
		mReportContent = PDFUtils.getText(DriverManager.getDriver().getCurrentUrl());
		Assert.assertTrue(mReportContent.contains(mDriverName + Reports.ReportsAttribute.ASSET_EDIT_REPORT_TITLE.getAttributeValue()));
	}
	
	@Test(priority = 20048571, groups = {Config.REPORT_TESTS_WEB}, dependsOnMethods = {"viewEditedAssetReportTest"})
	public void verifyEditedAssetReportSubTitleInReportContentTest() throws Exception 
	{
		Assert.assertTrue(mReportContent.contains(mDriverName + Reports.ReportsAttribute.ASSET_EDIT_REPORT_SUBTITLE.getAttributeValue()));
	}
	
	@Test(priority = 20048572, groups = {Config.REPORT_TESTS_WEB}, dependsOnMethods = {"viewEditedAssetReportTest"})
	public void verifyEditedAssetReportCompanyNameInReportContentTest() throws Exception 
	{
		Assert.assertTrue(mReportContent.contains(mDriverName + Reports.ReportsAttribute.ASSET_EDIT_REPORT_COMPANY_NAME.getAttributeValue()));
	}
	
	@Test(priority = 20048573, groups = {Config.REPORT_TESTS_WEB}, dependsOnMethods = {"viewEditedAssetReportTest"})
	public void verifyEditedAssetReportCompanyInformationInReportContentTest() throws Exception 
	{
		Assert.assertTrue(mReportContent.contains(mDriverName + Reports.ReportsAttribute.ASSET_EDIT_REPORT_COMPANY_INFORMATION.getAttributeValue()));
	}
	
	@Test(priority = 20048574, groups = {Config.REPORT_TESTS_WEB}, dependsOnMethods = {"viewEditedAssetReportTest"})
	public void verifyEditedAssetReportAdditionalInformationInReportContentTest() throws Exception 
	{
		Assert.assertTrue(mReportContent.contains(mDriverName + Reports.ReportsAttribute.ASSET_EDIT_REPORT_ADDITIONAL_INFORMATION.getAttributeValue()));
	}
	
	@Test(priority = 20048575, groups = {Config.REPORT_TESTS_WEB}, dependsOnMethods = {"viewEditedAssetReportTest"})
	public void verifyEditAssetReportContentTest() throws Exception 
	{
		Assert.assertTrue(mReportContent.contains(Reports.ReportsAttribute.ASSET_EDIT_REPORT_CONTENT_PREPROD.getAttributeValue()));
	}
	
	@Test(priority = 20048576, groups = {Config.REPORT_TESTS_WEB}, dependsOnMethods = {"viewEditedAssetReportTest"})
	public void switchToAssetReportPage2Test() throws Exception 
	{
		DriverManager.getDriver().switchTo().window(reportsPage.getReportsPageAttribute(ReportPageObjects.ASSET_PAGE_URL));
	}
	
	@Test(priority = 20048577, groups = {Config.REPORT_TESTS_WEB}, dependsOnMethods = {"viewEditedAssetReportTest"})
	public void duplicateAssetReportTest() throws Exception 
	{
		int currentReportCount = reportsPage.getReportsPageWebElements(ReportPageObjects.REPORT_LIST).size();
		reportsPage.duplicateAssetReport();
		Assert.assertTrue(reportsPage.getReportsPageWebElements(ReportPageObjects.REPORT_LIST).size() > currentReportCount);
	}
	
	@Test(priority = 20048600, groups = {Config.REPORT_TESTS, Config.REPORT_UAT_TEST})
	public void filterMyReportsTest() throws Exception 
	{
		reportsPage.sortFilterReport(ReportsAttribute.REPORTS_FILTER.getAttributeValue(), ReportsOptions.FILTER_MY_REPORTS);
		reportsPage.searchReport(ReportsAttribute.REPORTS_SEARCH_KEYWORD.getAttributeValue());
		Assert.assertFalse(ElementUtils.isDisplayed(1, reportsPage.getReportsPageWebElement(ReportPageObjects.REPORTS_OPTIONS_BUTTON)));
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			reportsPage.getReportsPageWebElement(ReportPageObjects.SEARCH_CANCEL_BUTTON).click();
	}
	
	@Test(priority = 20048650, groups = {Config.REPORT_TESTS, Config.REPORT_UAT_TEST})
	public void sortByDateTest() throws Exception 
	{
		reportsPage.initElements();
		reportsPage.sortFilterReport(ReportsAttribute.REPORTS_FILTER.getAttributeValue(), ReportsOptions.FILTER_ALL);
		reportsPage.sortFilterReport(ReportsAttribute.REPORTS_SORT.getAttributeValue(), ReportsOptions.SORT_BY_DATE);
		Assert.assertTrue(reportsPage.getReportsPageWebElement(ReportPageObjects.SORT_STATIC_TEXT).getText().contains("Date"));
	}
	
	@Test(priority = 20048700, groups = {Config.REPORT_TESTS, Config.REPORT_UAT_TEST})
	public void deleteReportTest() throws Exception 
	{
		reportsPage.initElements();
		reportsPage.searchReport(DriverManager.getDriverName());
		reportsPage.deleteReport();
	}
	
	@Test(priority = 20048701, groups = {Config.REPORT_TESTS})
	public void deleteOtherReportTest() throws Exception 
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			reportsPage.initElements();
			reportsPage.getReportsPageWebElement(ReportPageObjects.SEARCH_FIELD).clear();
			reportsPage.searchReport("iOS");
			reportsPage.deleteReport();
		}
	}
	
	@Test(priority = 20048702, groups = {Config.REPORT_TESTS_WEB}) 
	public void deleteAssetReportTest() throws Exception 
	{
		reportsPage.deleteReports();
	}

	@AfterClass(alwaysRun = true, groups = {Config.REPORT_TESTS, Config.IOS_FULL_TESTS, Config.IOS_SMOKE_TESTS ,Config.REPORT_UAT_TEST, Config.ANDROID_REPORT_EXT_SMOKE_TESTS, Config.IOS_REPORT_SMOKE_EXT_TESTS})
	public void classTearDown() throws Exception {
		Config.useExistingPageSource = false;
		CommonUtils.wait(5);
		if(!DriverManager.isSmokeSuite()) { 
			DriverManager.closeApp();
			DriverManager.launchApp();
			DriverManager.getSignIn().handleOnBoardPrompt();
			DriverManager.getSwitcher().signOut();
		}
	}

}
