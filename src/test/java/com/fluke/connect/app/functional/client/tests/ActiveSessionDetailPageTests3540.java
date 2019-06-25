package com.fluke.connect.app.functional.client.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.fluke.connect.app.functional.client.pages.SessionDetailPage3540;
import com.fluke.connect.app.functional.client.pages.SessionDetailPage.SessionDetailPageObjectList;
import com.fluke.connect.app.functional.client.pages.SessionDetailPage3540.SessionDetailPage3540ObjectList;
import com.fluke.connect.app.testdata.FCCM;
import com.fluke.connect.app.testdata.FCCM3540;
import com.fluke.connect.app.testdata.FCCM3540.StudyType;
import com.fluke.connect.app.testdata.FCCM3550;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverFactory;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.IOSUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.ScrollDiection;

import io.appium.java_client.MobileBy;

@SuppressWarnings("unused")
public class ActiveSessionDetailPageTests3540 
{
	private SessionDetailPage3540 sessionDetailPage3540;
	private GestureUtils gestureUtils;
	private String[] mGraphViewList;
	private List<WebElement> mUnitList;
	private String[] mPhaseTypeList;
	private String[] mStudyTypeMapKeyList;
	private String[] mTabList;
	private String[] mUnitPhaseList;
	private String mStudyType;
	private int mStudyTypePointer = 0;
	private int mUnitTypePointer = 0;
	private  String currentTabValue = "1H";
	private String currentStudyTypeValue = "V, A, Hz";
	private String currentWebStudyTypeValue = "V,A,Hz";
	private boolean defaultUnitTypeFlag = false;
	private String defaultMeasurementValue = "--";
	private String currentMeasurementValueUnit;
	private String testFailureState;
	private boolean testFailureFlag = false;
	private String pageSource;
	private String currentPhaseUnit = " ";
	private StringBuilder mValueHolder;
	private int mIntValueHolder;
	private List<WebElement> mElementListHolder;
	private int iterationValue;
	
	@Parameters({"activeSessionStudyType"})
	@BeforeClass(alwaysRun = true, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS, FCCM3540.SESSION_DETAIL_PAGE_TESTS, FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.UAT_3540})
	public void initClass(@Optional("null") String activeSessionStudyType)
	{
		CommonUtils.wait(15, 15, 3);
		sessionDetailPage3540 = new SessionDetailPage3540();
		gestureUtils = new GestureUtils();
		mValueHolder = new StringBuilder();
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			ElementUtils.isDisplayed(5, sessionDetailPage3540.getWebGraphLinesObject());
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			ElementUtils.isDisplayed(15, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, FCCM3540.sessionStatus[0], LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, FCCM3540.sessionStatus[0], null, null); //to ensure active monitoring session page is loaded properly
		mStudyType = activeSessionStudyType;
		mGraphViewList = FCCM3540.getGraphViewList(mStudyType);  // "V, A, Hz", "Active Power", "Power Overview", "THD/THC"
		mStudyTypeMapKeyList = FCCM3540.getStudyTypeMapKey(mStudyType);   //"ES3PhaseV", "ES3PhaseA", "ES3PhaseP", "ES3PhaseT"
		Config.appWidthCenterFlag = true;
		Config.useExistingPageSource = true;
		Config.iOSPageSource = DriverManager.getDriver().getPageSource();
		FCCM3540.mStudyType = activeSessionStudyType;
	}
	
	@Test(priority = 114701, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS, FCCM3540.SESSION_DETAIL_PAGE_TESTS, FCCM3540.SESSION_VERIFICATION_TESTS})
	public void sessionTileStatusTest()
	{
		Assert.assertEquals(sessionDetailPage3540.getElementVisibleTextInSessionTileStrict(FCCM3540.sessionStatus[0]), FCCM3540.sessionStatus[0]);
	}
	
	@Test(priority = 114702, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS, FCCM3540.SESSION_DETAIL_PAGE_TESTS,  FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.UAT_3540})
	public void gateWayNameTest()
	{
		Assert.assertEquals(sessionDetailPage3540.getElementVisibleTextInSessionTileStrict(FCCM3540.gatewayNameValue), FCCM3540.gatewayNameValue);
	}
	
	@Test(priority = 114703, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS, FCCM3540.SESSION_DETAIL_PAGE_TESTS, FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.UAT_3540})
	public void startTimeStaticTextVisibleTest()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertEquals(sessionDetailPage3540.getElementVisibleTextInSessionTileStrict(Config.START_TIME_STATIC_TEXT), Config.START_TIME_STATIC_TEXT);
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "#new_design1").getText().contains(Config.START_STATIC_TEXT));
	}
	
	@Test(priority = 114704, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS, FCCM3540.SESSION_DETAIL_PAGE_TESTS, FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.UAT_3540})
	public void sessionStartTimeTest()
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertTrue(sessionDetailPage3540.getElementVisibleTextInSessionTileStrict(FCCM3540.requiredSessionStartTimestamp).contains(FCCM3540.requiredSessionStartTimestamp));
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			Assert.assertTrue(sessionDetailPage3540.getElementVisibleTextInSessionTile(FCCM3540.requiredSessionStartTimestamp).contains(FCCM3540.requiredSessionStartTimestamp));
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "#new_design1").getText().contains(FCCM3540.requiredSessionStartTimestamp));
	}
	
	@Test(priority = 114705, groups = {})
	public void sessionStartUserNameTest()
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertEquals(sessionDetailPage3540.getElementVisibleTextInSessionTileStrict(FCCM3540.sessionStartUserName), DriverManager.getUserName());
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			Assert.assertTrue(sessionDetailPage3540.getElementVisibleTextInSessionTile(FCCM3540.requiredSessionStartTimestamp).contains(DriverManager.getUserName()));
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "#new_design1").getText().contains(DriverManager.getUserName()));
	}
	
	@Test(priority = 114706, groups = {FCCM3540.SESSION_DETAIL_PAGE_TESTS,  FCCM3540.SESSION_VERIFICATION_TESTS})
	public void assetCountTextVisibleTest()
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertTrue(sessionDetailPage3540.getElementInSessionTileStrict(Config.ASSET_STATIC_TEXT+" (1)").isDisplayed());
	}
	
	@Test(priority = 114707, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS, FCCM3540.SESSION_DETAIL_PAGE_TESTS,  FCCM3540.SESSION_VERIFICATION_TESTS})
	public void assetGroupNameTest()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertEquals(sessionDetailPage3540.getElementVisibleTextInSessionTileStrict(FCCM3540.assetGroupName), FCCM3540.assetGroupName);
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertEquals(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".crumbTrailAssetGroupInfo").getText(), FCCM3540.assetGroupName);
	}
	
	@Test(priority = 114708, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS, FCCM3540.SESSION_DETAIL_PAGE_TESTS,  FCCM3540.SESSION_VERIFICATION_TESTS})
	public void assetNameTest()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertEquals(sessionDetailPage3540.getElementVisibleTextInSessionTileStrict(FCCM3540.assetName), FCCM3540.assetName);
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertEquals(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".crumbTrailAssetName").getText(), FCCM3540.assetName);
	}
	
	@Test(priority = 114709, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS, FCCM3540.SESSION_DETAIL_PAGE_TESTS, FCCM3540.SESSION_VERIFICATION_TESTS})
	public void testPointNameTest()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertEquals(sessionDetailPage3540.getElementVisibleTextInSessionTileStrict(FCCM3540.testPointName), FCCM3540.testPointName);
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertEquals(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".assetNameTextSession").getText(), FCCM3540.testPointName);
	} 
	
	@Test(priority = 114710, groups = {FCCM3540.SESSION_DETAIL_PAGE_TESTS, FCCM3540.SESSION_VERIFICATION_TESTS})
	public void monitoringDataStaticTextVisibleTest()
	{
		Assert.assertTrue(ElementUtils.isDisplayed(15, 1, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, FCCM3540.monitoringData, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, FCCM3540.monitoringData, null, null)); 
	}
	
	@Test(priority = 114800, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void graphViewTest()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			for(String graphView: mGraphViewList) {
				ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT_CONTAINS, graphView).isDisplayed();
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			sessionDetailPage3540.getSessionDetailPage3540Object(SessionDetailPage3540ObjectList.STUDY_TYPE_SPINNER).click();
			for(String graphView: mGraphViewList) {
				Assert.assertNotNull(ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_LABEL, graphView, null, null));
			}
			sessionDetailPage3540.getSessionDetailPage3540Object(SessionDetailPage3540ObjectList.CANCEL_BUTTON).click();
		}
	}
	
	@Test(priority = 114801, groups = {FCCM3540.SESSION_VERIFICATION_TESTS})
	public void studyTypeListView()
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			sessionDetailPage3540.getSessionDetailPage3540Object(SessionDetailPage3540ObjectList.UNIT_TYPE_SPINNER).click();
			for(String studyType: FCCM3540.getStudyTypeList(mStudyTypeMapKeyList[0])) {
				Assert.assertNotNull(ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_LABEL, studyType, null, null));
			}
			sessionDetailPage3540.getSessionDetailPage3540Object(SessionDetailPage3540ObjectList.CANCEL_BUTTON).click();
		}
	}
	
	@Test(priority = 114810, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS, FCCM3540.SESSION_DETAIL_PAGE_TESTS, FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.UAT_3540})
	public void graphDisplayedTest()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			gestureUtils.mScroll("Show", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
			Assert.assertTrue(sessionDetailPage3540.isGraphDisplayed());
		}
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(ElementUtils.isDisplayed(5, sessionDetailPage3540.getWebGraphLinesObject()));
	}
	
	@Test(priority = 114815, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS, FCCM3540.SESSION_VERIFICATION_TESTS})
	public void voltageLivePollingTest()
	{
		gestureUtils.webScroll(1, 0, 200);
		//Assert.assertTrue(sessionDetailPage3540.isLivePollingHappening("./graph/bp", "./graph/ap", "./graph/dp", ".png", iterationValue, 2, 60, Config.IOS_LOCATOR_STRATEGY_NAME, FCCM3550.tempratureUnitFahrenheit));
	}
	
	@Test(priority = 114826, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void graphVoltageUnitTest()
	{
		mValueHolder.delete(0, mValueHolder.length());
		mValueHolder.append(sessionDetailPage3540.getUnit(StudyType.VOLTAGE) + " " + sessionDetailPage3540.getPhase(mStudyType, StudyType.VOLTAGE).split(",")[0]);
		Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT_CONTAINS, mValueHolder.toString()).isDisplayed());
	}
	
	@Test(priority = 114827, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void voltagePhaseUnitHeaderTest()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			for(String headerName: sessionDetailPage3540.getUnitHeader(mStudyType, StudyType.VOLTAGE).split(",")) {
				Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT_CONTAINS, headerName.trim()).isDisplayed());
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			gestureUtils.mScroll(-400, -250, 1);
			CommonUtils.wait(2);
			for(String headerName: sessionDetailPage3540.getUnitHeader(mStudyType, StudyType.VOLTAGE).split(",")) {
				Assert.assertNotNull(ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, headerName.trim(), null, null));
			}
		}
	}
	
	@Test(priority = 114828, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void voltagePhaseTest()
	{
		for(String phaseName: sessionDetailPage3540.getPhase(mStudyType, StudyType.VOLTAGE).split(",")) {
			Assert.assertTrue(ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_ENDSWITH, phaseName.trim(), LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT_CONTAINS, phaseName.trim()).isDisplayed());
		}
	}
	
	@Test(priority = 114850, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void voltageValueTest()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.WEB_VOLTAGE_VALUE_LIST)) {
				Assert.assertFalse(element.getText().contains("--"));
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) 
			Assert.assertFalse(DriverManager.getDriver().getPageSource().contains("--"));
		
	}
	
	@Test(priority = 114851, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void voltageUnitTest()
	{
		mUnitList = 	 sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.VOLTAGE_VALUE_UNIT);
		for(int i = 0; i < mUnitList.size(); i++) {
				Assert.assertTrue(mUnitList.get(i).getText().equals(sessionDetailPage3540.getUnit(StudyType.VOLTAGE)));
			}
	}
	
	@Test(priority = 114852, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void voltageRadioButtonTest()
	{
		mElementListHolder = sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.WEB_VOLTAGE_RADIO_BUTTON_LIST);
		Assert.assertTrue(mElementListHolder.size() == 3);
	}
	
	@Test(priority = 114853, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void switchToVoltagePhase3Test()
	{
		mElementListHolder.get(mElementListHolder.size() - 1).click();
		sessionDetailPage3540.isPageLoaded();
		Assert.assertTrue(sessionDetailPage3540.isGraphDisplayed());
	}
	
	@Test(priority = 114854, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void voltageValueInOtherPhaseTest()
	{
		for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.WEB_VOLTAGE_VALUE_LIST))
		{
			Assert.assertFalse(element.getText().contains("--"));
		}
	}
	
	@Test(priority = 114855, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void voltageUnitInOtherPhaseTest()
	{
		for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.VOLTAGE_VALUE_UNIT))
		{
			Assert.assertTrue(element.getText().equals(sessionDetailPage3540.getUnit(StudyType.VOLTAGE)));
		}
	}
	
	@Test(priority = 114860, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void switchTo12HTabTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			sessionDetailPage3540.switchToOtherTab(FCCM.GRAPH_12H_TAB, ScrollDiection.UP);
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			sessionDetailPage3540.switchToOtherTab(FCCM.GRAPH_1D_TAB, ScrollDiection.UP);
	}
	
	@Test(priority = 114861, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void voltageValueIn1DTabTest()
	{
		gestureUtils.mScroll("Show", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
		gestureUtils.mScroll(-400, -250, 1);
		CommonUtils.wait(1, 1, 0);
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.WEB_VOLTAGE_VALUE_LIST)) {
				Assert.assertFalse(element.getText().contains("--"));
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) 
			Assert.assertFalse(DriverManager.getDriver().getPageSource().contains("--"));
		
	}
	
	@Test(priority = 114862, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void voltageUnitIn1DTabTest()
	{
		mUnitList.clear();
		mUnitList = sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.VOLTAGE_VALUE_UNIT);
		for(int i = 0; i < mUnitList.size(); i++) {
				Assert.assertTrue(mUnitList.get(i).getText().equals(sessionDetailPage3540.getUnit(StudyType.VOLTAGE)));
			}
	}
	
	@Test(priority = 114870, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void currentRadioButtonTest()
	{
		mElementListHolder.clear();
		mElementListHolder = sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.WEB_CURRENT_RADIO_BUTTON_LIST);
		Assert.assertTrue(mElementListHolder.size() == 3);
	}
	
	@Test(priority = 114871, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void switchToCurrentPhase1Test()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mElementListHolder.get(0).click();
			sessionDetailPage3540.isPageLoaded();
			Assert.assertTrue(sessionDetailPage3540.isGraphDisplayed());
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			gestureUtils.mScroll("Graph View", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_ENDSWITH, null, ScrollDiection.UP);
			sessionDetailPage3540.getSessionDetailPage3540Object(SessionDetailPage3540ObjectList.UNIT_TYPE_SPINNER).click();
			mElementListHolder = sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.IOS_STUDY_TYPE_LIST);
			mElementListHolder.get(1).click();
			IOSUtils.isPageLoaded(15, "Loading...");
			CommonUtils.wait(3);
		}
	}
	
	@Test(priority = 114872, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void graphCurrentUnitTest()
	{
		mValueHolder.delete(0, mValueHolder.length());
		mValueHolder.append(sessionDetailPage3540.getUnit(StudyType.CURRENT) + " " + sessionDetailPage3540.getPhase(mStudyType, StudyType.CURRENT).split(",")[0]);
		Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT_CONTAINS, mValueHolder.toString()).isDisplayed());
	}
	
	@Test(priority = 114873, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void currentValueTest()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.WEB_CURRENT_VALUE_LIST)) {
				Assert.assertFalse(element.getText().contains("--"));
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) 
			Assert.assertFalse(DriverManager.getDriver().getPageSource().contains("--"));
	}
	
	@Test(priority = 114874, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void currentUnitTest()
	{
		mUnitList.clear();
		mUnitList = sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.CURRENT_VALUE_UNIT);
		for(int i = 0; i < mUnitList.size(); i++) {
			Assert.assertTrue(mUnitList.get(i).getText().equals(sessionDetailPage3540.getUnit(StudyType.CURRENT)));
		}
	}
	
	@Test(priority = 114875, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void switchToCurrentPhase3Test() throws Exception  //For mobiles switching to 1H tab
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mElementListHolder.get(mElementListHolder.size()-1).click();
			sessionDetailPage3540.isPageLoaded();
			Assert.assertTrue(sessionDetailPage3540.isGraphDisplayed());
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			sessionDetailPage3540.switchToOtherTab(FCCM.GRAPH_1H_TAB, ScrollDiection.UP);
		}
	}
	
	@Test(priority = 114876, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void currentValueInPhase3Test()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.WEB_CURRENT_VALUE_LIST)) {
				Assert.assertFalse(element.getText().contains("--"));
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) 
			Assert.assertFalse(DriverManager.getDriver().getPageSource().contains("--"));
	}
	
	@Test(priority = 114877, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void currentUnitInPhase3Test()
	{
		mUnitList.clear();
		mUnitList = sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.CURRENT_VALUE_UNIT);
		for(int i = 0; i < mUnitList.size(); i++) {
			Assert.assertTrue(mUnitList.get(i).getText().equals(sessionDetailPage3540.getUnit(StudyType.CURRENT)));
		}
	}
	
	@Test(priority = 114878, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void switchTo1DTabTest() throws Exception
	{
		sessionDetailPage3540.switchToOtherTab(FCCM.GRAPH_ALL_TAB, ScrollDiection.UP);
	}
	
	@Test(priority = 114879, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void currentValueIn1DTabTest()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.WEB_CURRENT_VALUE_LIST)) {
				Assert.assertFalse(element.getText().contains("--"));
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) 
			Assert.assertFalse(DriverManager.getDriver().getPageSource().contains("--"));
	}
	
	@Test(priority = 114880, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void currentUnitIn1DTabTest()
	{
		mUnitList.clear();
		mUnitList = sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.CURRENT_VALUE_UNIT);
		for(int i = 0; i < mUnitList.size(); i++) {
			Assert.assertTrue(mUnitList.get(i).getText().equals(sessionDetailPage3540.getUnit(StudyType.CURRENT)));
		}
	}
	
	@Test(priority = 114890, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void frequencyRadioButtonTest()
	{
		mElementListHolder.clear();
		mElementListHolder = sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.WEB_FREQUENCY_RADIO_BUTTON_LIST);
		Assert.assertTrue(mElementListHolder.size() == 1);
	}
	
	@Test(priority = 114891, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void switchToFrequencyPhase1Test()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER) ) {
			mElementListHolder.get(0).click();
			sessionDetailPage3540.isPageLoaded();
			Assert.assertTrue(sessionDetailPage3540.isGraphDisplayed());
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) ) {
			sessionDetailPage3540.getSessionDetailPage3540Object(SessionDetailPage3540ObjectList.UNIT_TYPE_SPINNER).click();
			mElementListHolder.get(2).click();
			IOSUtils.isPageLoaded(15, "Loading...");
			CommonUtils.wait(3);
		}
	}
	
	@Test(priority = 114892, groups = {})
	public void graphFrequencyUnitTest()
	{
		mValueHolder.delete(0, mValueHolder.length());
		mValueHolder.append(sessionDetailPage3540.getUnit(StudyType.FREQUENCY));
		Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".graphFilterValueUnit").getText().equals(mValueHolder.toString()));
	}
	
	@Test(priority = 114893, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void frequencyValueTest()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
		for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.WEB_FREQUENCY_VALUE_LIST)) {
			Assert.assertFalse(element.getText().contains("--"));
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			Assert.assertFalse(DriverManager.getDriver().getPageSource().contains("--"));
		}
	}
	
	@Test(priority = 114894, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void frequencyUnitTest()
	{
		mUnitList.clear();
		mUnitList = sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.FREQUENCY_VALUE_UNIT);
		for(int i = 0; i < mUnitList.size(); i++) {
			Assert.assertTrue(mUnitList.get(i).getText().equals(sessionDetailPage3540.getUnit(StudyType.FREQUENCY)));
		}
	}
	
	@Test(priority = 114895, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void switchTo1WTabTest() throws Exception
	{
		sessionDetailPage3540.switchToOtherTab(FCCM.GRAPH_1W_TAB, ScrollDiection.UP);
	}
	
	@Test(priority = 114896, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void frequencyValueIn1WTabTest()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.WEB_FREQUENCY_VALUE_LIST)) {
				Assert.assertFalse(element.getText().contains("--"));
				}
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
				Assert.assertFalse(DriverManager.getDriver().getPageSource().contains("--"));
			}
	}
	
	@Test(priority = 114897, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void frequencyUnitIn1WTabTest()
	{
		mUnitList.clear();
		mUnitList = sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.FREQUENCY_VALUE_UNIT);
		for(int i = 0; i < mUnitList.size(); i++) {
			Assert.assertTrue(mUnitList.get(i).getText().equals(sessionDetailPage3540.getUnit(StudyType.FREQUENCY)));
		}
	}
	
	@Test(priority = 114914, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void switchToActivePowerTabTest()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT_CONTAINS, mGraphViewList[1]).click();
			sessionDetailPage3540.isPageLoaded();
			Assert.assertTrue(sessionDetailPage3540.isGraphDisplayed());
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			sessionDetailPage3540.getSessionDetailPage3540Object(SessionDetailPage3540ObjectList.STUDY_TYPE_SPINNER).click();
			ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, mGraphViewList[1], null, null).click();
			CommonUtils.wait(3);
			IOSUtils.isPageLoaded(15, "Loading...");
		}
	}
	
	@Test(priority = 114916, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void graphActivePowerUnitTest()
	{
		mValueHolder.delete(0, mValueHolder.length());
		mValueHolder.append(sessionDetailPage3540.getUnit(StudyType.ACTIVE_POWER) + " " + sessionDetailPage3540.getPhase(mStudyType, StudyType.ACTIVE_POWER).split(",")[0]);
		Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT_CONTAINS, mValueHolder.toString()).isDisplayed());
	}
	
	@Test(priority = 114918, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void activePowerPhaseTest()
	{
		gestureUtils.mScroll("Show", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
		gestureUtils.mScroll(-400, -250, 1);
		CommonUtils.wait(1, 1, 0);
		for(String phaseName: sessionDetailPage3540.getPhase(mStudyType, StudyType.ACTIVE_POWER).split(",")) {
			Assert.assertTrue(ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, phaseName.trim(), LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT, phaseName.trim()).isDisplayed());
		}
	}
	
	@Test(priority = 114919, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void activePowerValueTest()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.WEB_ACTIVE_POWER_VALUE_LIST)) {
				Assert.assertFalse(element.getText().contains("--"));
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertFalse(DriverManager.getDriver().getPageSource().contains("--"));
	}
	
	@Test(priority = 114920, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void activePowerUnitTest()
	{
		mUnitList.clear();
		mUnitList = sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.ACTIVE_POWER_VALUE_UNIT);
		for(int i = 0; i < mUnitList.size(); i++) {
			Assert.assertTrue(mUnitList.get(i).getText().equals(sessionDetailPage3540.getUnit(StudyType.ACTIVE_POWER)));
		}
	}
	
	@Test(priority = 114922, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void switchTo1MTabTest() throws Exception
	{
		sessionDetailPage3540.switchToOtherTab(FCCM.GRAPH_1M_TAB, ScrollDiection.UP);
	}
	
	@Test(priority = 114923, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void graphActivePowerUnitIn1MTabTest()
	{
		mValueHolder.delete(0, mValueHolder.length());
		mValueHolder.append(sessionDetailPage3540.getUnit(StudyType.ACTIVE_POWER) + " " + sessionDetailPage3540.getPhase(mStudyType, StudyType.ACTIVE_POWER).split(",")[0]);
		Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT_CONTAINS, mValueHolder.toString()).isDisplayed());
	}
	
	@Test(priority = 114924, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void activePowerValueIn1MTabTest()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.WEB_ACTIVE_POWER_VALUE_LIST)) {
				Assert.assertFalse(element.getText().contains("--"));
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertFalse(DriverManager.getDriver().getPageSource().contains("--"));
	}
	
	@Test(priority = 114925, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void activePowerUnitIn1MTabTest()
	{
		mUnitList.clear();
		mUnitList = sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.ACTIVE_POWER_VALUE_UNIT);
		for(int i = 0; i < mUnitList.size(); i++) {
			Assert.assertTrue(mUnitList.get(i).getText().equals(sessionDetailPage3540.getUnit(StudyType.ACTIVE_POWER)));
		}
	}
	
	@Test(priority = 114934, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void poweFactorRadioButtonTest()
	{
		mElementListHolder.clear();
		mElementListHolder = sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.WEB_POWER_FACTOR_RADIO_BUTTON_LIST);
		Assert.assertTrue(mElementListHolder.size() == 1);
	}
	
	@Test(priority = 114935, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void switchToPowerFactorPhase1Test() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mElementListHolder.get(0).click();
			sessionDetailPage3540.isPageLoaded();
			Assert.assertTrue(sessionDetailPage3540.isGraphDisplayed());
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			gestureUtils.mScroll("Graph View", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_ENDSWITH, null, ScrollDiection.UP);
			sessionDetailPage3540.getSessionDetailPage3540Object(SessionDetailPage3540ObjectList.UNIT_TYPE_SPINNER).click();
			mElementListHolder.clear();
			mElementListHolder = sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.IOS_STUDY_TYPE_LIST);
			mElementListHolder.get(1).click();
			IOSUtils.isPageLoaded(15, "Loading...");
			CommonUtils.wait(3);
			sessionDetailPage3540.switchToOtherTab(FCCM.GRAPH_1H_TAB, ScrollDiection.DOWN);
		}
	}
	
	@Test(priority = 114936, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void powerFactorLivePollingTest()
	{
		gestureUtils.webScroll(1, 0, 200);
		gestureUtils.mScroll("Show", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
		Assert.assertTrue(sessionDetailPage3540.isLivePollingHappening("./graph/bp", "./graph/ap", "./graph/dp", ".png", iterationValue, 2, 60, Config.IOS_LOCATOR_STRATEGY_NAME, FCCM3550.tempratureUnitFahrenheit));
	}

	
	@Test(priority = 114937, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void graphPowerFactorUnitTest()
	{
		mValueHolder.delete(0, mValueHolder.length());
		mValueHolder.append(sessionDetailPage3540.getUnit(StudyType.POWER_FACTOR));
		Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".graphFilterValueUnit").getText().equals(mValueHolder.toString()));
	}
	
	@Test(priority = 114938, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void powerFactorValueTest()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.WEB_POWER_FACTOR_VALUE_LIST)) {
				Assert.assertFalse(element.getText().contains("--"));
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) 
			Assert.assertFalse(DriverManager.getDriver().getPageSource().contains("--"));
	}
	
	@Test(priority = 114940, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void switchToALLTabTest() throws Exception
	{
		sessionDetailPage3540.switchToOtherTab(FCCM.GRAPH_ALL_TAB, ScrollDiection.UP);
	}
	
	@Test(priority = 114941, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void powerFactorValueInALLTabTest()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.WEB_POWER_FACTOR_VALUE_LIST)) {
				Assert.assertFalse(element.getText().contains("--"));
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) 
			Assert.assertFalse(DriverManager.getDriver().getPageSource().contains("--"));
	}
	
	@Test(priority = 114950, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void switchToPowerOverviewTabTest()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT_CONTAINS, mGraphViewList[2]).click();
			sessionDetailPage3540.isPageLoaded();
			Assert.assertTrue(sessionDetailPage3540.isGraphDisplayed());
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			gestureUtils.mScroll("Graph View", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_ENDSWITH, null, ScrollDiection.UP);
			sessionDetailPage3540.getSessionDetailPage3540Object(SessionDetailPage3540ObjectList.STUDY_TYPE_SPINNER).click();
			ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, mGraphViewList[3], null, null).click();
			CommonUtils.wait(3);
			IOSUtils.isPageLoaded(15, "Loading...");
		}
	}
	
	@Test(priority = 114951, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void graphPowerOverviewUnitTest()
	{
		mValueHolder.delete(0, mValueHolder.length());
		mValueHolder.append(sessionDetailPage3540.getUnit(StudyType.ACTIVE_POWER) + " " + sessionDetailPage3540.getPhase(mStudyType, StudyType.ACTIVE_POWER).split(",")[0]);
		Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT_CONTAINS, mValueHolder.toString()).isDisplayed());
	}
	
	@Test(priority = 114953, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void powerOverviewValueTest()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.WEB_POWER_FACTOR_VALUE_LIST)) {
				Assert.assertFalse(element.getText().contains("--"));
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) 
			Assert.assertFalse(DriverManager.getDriver().getPageSource().contains("--"));
	}
	
	@Test(priority = 114954, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void powerOverviewUnitTest()
	{
		for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.ACTIVE_POWER_VALUE_UNIT))
		{
			Assert.assertTrue(element.getText().equals(sessionDetailPage3540.getUnit(StudyType.ACTIVE_POWER)));
		}
	}
	
	@Test(priority = 114955, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void switchTo12HPowerOverviewTabTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			sessionDetailPage3540.switchToOtherTab(FCCM.GRAPH_12H_TAB, ScrollDiection.UP);
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			sessionDetailPage3540.switchToOtherTab(FCCM.GRAPH_1D_TAB, ScrollDiection.DOWN);
	}
	
	@Test(priority = 114956, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void graphPowerOverviewUnitIn12HTabTest()
	{
		mValueHolder.delete(0, mValueHolder.length());
		mValueHolder.append(sessionDetailPage3540.getUnit(StudyType.ACTIVE_POWER) + " " + sessionDetailPage3540.getPhase(mStudyType, StudyType.ACTIVE_POWER).split(",")[0]);
		Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT_CONTAINS, mValueHolder.toString()).isDisplayed());
	}
	
	@Test(priority = 114957, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void powerOverviewValueIn12HTabTest()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.WEB_POWER_FACTOR_VALUE_LIST)) {
				Assert.assertFalse(element.getText().contains("--"));
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) 
			Assert.assertFalse(DriverManager.getDriver().getPageSource().contains("--"));
	}
	
	@Test(priority = 114958, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void powerOverviewUnitIn12HTabTest()
	{
		for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.ACTIVE_POWER_VALUE_UNIT))
		{
			Assert.assertTrue(element.getText().equals(sessionDetailPage3540.getUnit(StudyType.ACTIVE_POWER)));
		}
	}
	
	@Test(priority = 114970, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void apparentPoweRadioButtonTest()
	{
		mElementListHolder.clear();
		mElementListHolder = sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.WEB_APPARENT_POWER_RADIO_BUTTON_LIST);
		Assert.assertTrue(mElementListHolder.size() == 1);
	}
	
	@Test(priority = 114971, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void switchToApparentPowerPhase1Test() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mElementListHolder.get(0).click();
			sessionDetailPage3540.isPageLoaded();
			Assert.assertTrue(sessionDetailPage3540.isGraphDisplayed());
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			gestureUtils.mScroll("Graph View", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_ENDSWITH, null, ScrollDiection.UP);
			sessionDetailPage3540.getSessionDetailPage3540Object(SessionDetailPage3540ObjectList.UNIT_TYPE_SPINNER).click();
			mElementListHolder.clear();
			mElementListHolder = sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.IOS_STUDY_TYPE_LIST);
			mElementListHolder.get(1).click();
			IOSUtils.isPageLoaded(15, "Loading...");
			CommonUtils.wait(3);
			sessionDetailPage3540.switchToOtherTab(FCCM.GRAPH_1H_TAB, ScrollDiection.DOWN);
		}
	}
	
	@Test(priority = 114972, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void graphApparentPowerUnitTest()
	{
		mValueHolder.delete(0, mValueHolder.length());
		mValueHolder.append(sessionDetailPage3540.getUnit(StudyType.APPARENT_POWER) + " " + sessionDetailPage3540.getPhase(mStudyType, StudyType.APPARENT_POWER).split(",")[0]);
		Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".graphFilterValueUnit").getText().equals(mValueHolder.toString()));
	}
	
	@Test(priority = 114973, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void apparentPowerValueTest()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.WEB_POWER_FACTOR_VALUE_LIST)) {
				Assert.assertFalse(element.getText().contains("--"));
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) 
			Assert.assertFalse(DriverManager.getDriver().getPageSource().contains("--"));
	}
	
	@Test(priority = 114974, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void apparentPowerUnitTest()
	{
		for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.APPARENT_POWER_VALUE_UNIT))
		{
			Assert.assertTrue(element.getText().equals(sessionDetailPage3540.getUnit(StudyType.APPARENT_POWER)));
		}
	}
	
	@Test(priority = 114975, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void switchTo1DApparentPowerTabTest() throws Exception
	{
		sessionDetailPage3540.switchToOtherTab(FCCM.GRAPH_1D_TAB, ScrollDiection.UP);
	}
	
	@Test(priority = 114976, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void apparentPowerValueIn1DTabTest()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.WEB_APPARENT_POWER_VALUE_LIST)) {
				Assert.assertFalse(element.getText().contains("--"));
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) 
			Assert.assertFalse(DriverManager.getDriver().getPageSource().contains("--"));
	}
	
	@Test(priority = 114977, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void apparentPowerUnitIn1DTabTest()
	{
		for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.APPARENT_POWER_VALUE_UNIT))
		{
			Assert.assertTrue(element.getText().equals(sessionDetailPage3540.getUnit(StudyType.APPARENT_POWER)));
		}
	}
	
	@Test(priority = 114985, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void nonActivePoweRadioButtonTest()
	{
		mElementListHolder.clear();
		mElementListHolder = sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.WEB_NON_ACTIVE_POWER_RADIO_BUTTON_LIST);
		Assert.assertTrue(mElementListHolder.size() == 1);
	}
	
	@Test(priority = 114986, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void switchTononActivePowerPhase1Test()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mElementListHolder.get(0).click();
			sessionDetailPage3540.isPageLoaded();
			Assert.assertTrue(sessionDetailPage3540.isGraphDisplayed());
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			gestureUtils.mScroll("Graph View", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_ENDSWITH, null, ScrollDiection.UP);
			sessionDetailPage3540.getSessionDetailPage3540Object(SessionDetailPage3540ObjectList.UNIT_TYPE_SPINNER).click();
			mElementListHolder.clear();
			mElementListHolder = sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.IOS_STUDY_TYPE_LIST);
			mElementListHolder.get(2).click();
			IOSUtils.isPageLoaded(15, "Loading...");
			CommonUtils.wait(3);
		}
	}
	
	@Test(priority = 114987, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void graphNonActivePowerUnitTest()
	{
		mValueHolder.delete(0, mValueHolder.length());
		mValueHolder.append(sessionDetailPage3540.getUnit(StudyType.NON_ACTIVE_POWER) + " " + sessionDetailPage3540.getPhase(mStudyType, StudyType.NON_ACTIVE_POWER).split(",")[0]);
		Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".graphFilterValueUnit").getText().equals(mValueHolder.toString()));
	}
	
	@Test(priority = 114988, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void nonActivePowerValueTest()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.WEB_POWER_FACTOR_VALUE_LIST)) {
				Assert.assertFalse(element.getText().contains("--"));
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) 
			Assert.assertFalse(DriverManager.getDriver().getPageSource().contains("--"));
	}
	
	@Test(priority = 114989, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void nonActivePowerUnitTest()
	{
		for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.NON_ACTIVE_POWER_VALUE_UNIT))
		{
			Assert.assertTrue(element.getText().equals(sessionDetailPage3540.getUnit(StudyType.NON_ACTIVE_POWER)));
		}
	}
	
	@Test(priority = 114990, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void switchTo1WNonActivePowerTabTest() throws Exception
	{
		sessionDetailPage3540.switchToOtherTab(FCCM.GRAPH_1W_TAB, ScrollDiection.UP);
	}
	
	@Test(priority = 114991, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void nonActivePowerValueIn1WTabTest()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.WEB_NON_ACTIVE_POWER_VALUE_LIST)) {
				Assert.assertFalse(element.getText().contains("--"));
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) 
			Assert.assertFalse(DriverManager.getDriver().getPageSource().contains("--"));
	}
	
	@Test(priority = 114992, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void nonActivePowerUnitIn1WTabTest()
	{
		for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.NON_ACTIVE_POWER_VALUE_UNIT))
		{
			Assert.assertTrue(element.getText().equals(sessionDetailPage3540.getUnit(StudyType.NON_ACTIVE_POWER)));
		}
	}
	
	@Test(priority = 115000, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void switchToTHDTHCTabTest()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT_CONTAINS, mGraphViewList[3]).click();
			sessionDetailPage3540.isPageLoaded();
			Assert.assertTrue(sessionDetailPage3540.isGraphDisplayed());
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			gestureUtils.mScroll("Graph View", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_ENDSWITH, null, ScrollDiection.UP);
			sessionDetailPage3540.getSessionDetailPage3540Object(SessionDetailPage3540ObjectList.STUDY_TYPE_SPINNER).click();
			ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, mGraphViewList[2], null, null).click();
			CommonUtils.wait(3);
			IOSUtils.isPageLoaded(15, "Loading...");
		}
	}
	
	@Test(priority = 115002, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void graphTHDVUnitTest()
	{
		mValueHolder.delete(0, mValueHolder.length());
		mValueHolder.append(sessionDetailPage3540.getUnit(StudyType.THDV) + " " + sessionDetailPage3540.getPhase(mStudyType, StudyType.THDV).split(",")[0]);
		Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT_CONTAINS, mValueHolder.toString()).isDisplayed());
	}
	
	@Test(priority = 115004, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void thdVValueTest()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.WEB_THDV_VALUE_LIST)) {
				Assert.assertFalse(element.getText().contains("--"));
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) 
			Assert.assertFalse(DriverManager.getDriver().getPageSource().contains("--"));
	}
	
	@Test(priority = 115005, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void thdVUnitTest()
	{
		for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.THDV_VALUE_UNIT))
		{
			Assert.assertTrue(element.getText().equals(sessionDetailPage3540.getUnit(StudyType.THDV)));
		}
	}
	
	@Test(priority = 115006, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void thdVRadioButtonTest()
	{
		mElementListHolder = sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.WEB_THDV_RADIO_BUTTON_LIST);
		Assert.assertTrue(mElementListHolder.size() == 3);
	}
	
	@Test(priority = 115007, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void switchToTHDVPhase3Test()
	{
		mElementListHolder.get(mElementListHolder.size() - 1).click();
		sessionDetailPage3540.isPageLoaded();
		Assert.assertTrue(sessionDetailPage3540.isGraphDisplayed());
	}
	
	@Test(priority = 115008, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void thdVValueInPhase3Test()
	{
		for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.WEB_THDV_VALUE_LIST))
		{
			Assert.assertFalse(element.getText().contains("--"));
		}
	}
	
	@Test(priority = 115009, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void thdVUnitInPhase3Test()
	{
		for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.THDV_VALUE_UNIT))
		{
			Assert.assertTrue(element.getText().equals(sessionDetailPage3540.getUnit(StudyType.THDV)));
		}
	}
	
	@Test(priority = 115010, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void switchToTHDV1DTabTest() throws Exception
	{
		sessionDetailPage3540.switchToOtherTab(FCCM.GRAPH_1D_TAB, ScrollDiection.UP);
	}
	
	@Test(priority = 115011, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void thdVValueIn1DTabPhase3Test()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.WEB_THDV_VALUE_LIST)) {
				Assert.assertFalse(element.getText().contains("--"));
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) 
			Assert.assertFalse(DriverManager.getDriver().getPageSource().contains("--"));
	}
	
	@Test(priority = 115012, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void thdVUnitIn1DTabPhase3Test()
	{
		for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.THDV_VALUE_UNIT))
		{
			Assert.assertTrue(element.getText().equals(sessionDetailPage3540.getUnit(StudyType.THDV)));
		}
	}
	
	@Test(priority = 115020, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void thdARadioButtonTest()
	{
		mElementListHolder.clear();
		mElementListHolder = sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.WEB_THDA_RADIO_BUTTON_LIST);
		Assert.assertTrue(mElementListHolder.size() == 3);
	}
	
	@Test(priority = 115021, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void switchToTHDAPhase1Test() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mElementListHolder.get(0).click();
			sessionDetailPage3540.isPageLoaded();
			Assert.assertTrue(sessionDetailPage3540.isGraphDisplayed());
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			sessionDetailPage3540.getSessionDetailPage3540Object(SessionDetailPage3540ObjectList.UNIT_TYPE_SPINNER).click();
			mElementListHolder.clear();
			mElementListHolder = sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.IOS_STUDY_TYPE_LIST);
			mElementListHolder.get(1).click();
			IOSUtils.isPageLoaded(15, "Loading...");
			CommonUtils.wait(3);
			sessionDetailPage3540.switchToOtherTab(FCCM.GRAPH_1H_TAB, ScrollDiection.DOWN);
		}
	}
	
	@Test(priority = 115022, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void graphTHDAUnitTest()
	{
		mValueHolder.delete(0, mValueHolder.length());
		mValueHolder.append(sessionDetailPage3540.getUnit(StudyType.THDA) + " " + sessionDetailPage3540.getPhase(mStudyType, StudyType.THDA).split(",")[0]);
		Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT_CONTAINS, mValueHolder.toString()).isDisplayed());
	}
	
	@Test(priority = 115023, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void thdAValueTest()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.WEB_THDA_VALUE_LIST)) {
				Assert.assertFalse(element.getText().contains("--"));
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) 
			Assert.assertFalse(DriverManager.getDriver().getPageSource().contains("--"));
	}
	
	@Test(priority = 115024, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void thdAUnitTest()
	{
		for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.THDA_VALUE_UNIT))
		{
			Assert.assertTrue(element.getText().equals(sessionDetailPage3540.getUnit(StudyType.THDA)));
		}
	}
	
	@Test(priority = 115025, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void switchToTHDAPhase3Test()
	{
		mElementListHolder.get(mElementListHolder.size()-1).click();
		sessionDetailPage3540.isPageLoaded();
		Assert.assertTrue(sessionDetailPage3540.isGraphDisplayed());
	}
	
	@Test(priority = 115026, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void thdAValueInPhase3Test()
	{
		for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.WEB_THDA_VALUE_LIST))
		{
			Assert.assertFalse(element.getText().contains("--"));
		}
	}
	
	@Test(priority = 115027, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void thdAUnitInPhase3Test()
	{
		for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.THDA_VALUE_UNIT))
		{
			Assert.assertTrue(element.getText().equals(sessionDetailPage3540.getUnit(StudyType.THDA)));
		}
	}
	
	@Test(priority = 115028, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void switchTo1WTHDATabTest() throws Exception
	{
		sessionDetailPage3540.switchToOtherTab(FCCM.GRAPH_1W_TAB, ScrollDiection.UP);
	}
	
	@Test(priority = 115029, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void thdAValueIn1WTabTest()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.WEB_THDA_VALUE_LIST)) {
				Assert.assertFalse(element.getText().contains("--"));
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) 
			Assert.assertFalse(DriverManager.getDriver().getPageSource().contains("--"));
	}
	
	@Test(priority = 115030, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void thdAUnitIn1WTabTest()
	{
		for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.THDA_VALUE_UNIT))
		{
			Assert.assertTrue(element.getText().equals(sessionDetailPage3540.getUnit(StudyType.THDA)));
		}
	}
	
	@Test(priority = 115040, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void thcARadioButtonTest()
	{
		mElementListHolder.clear();
		mElementListHolder = sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.WEB_THCA_RADIO_BUTTON_LIST);
		Assert.assertTrue(mElementListHolder.size() == 3);
	}
	
	@Test(priority = 115041, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void switchToTHCAPhase1Test() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mElementListHolder.get(0).click();
			sessionDetailPage3540.isPageLoaded();
			Assert.assertTrue(sessionDetailPage3540.isGraphDisplayed());
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			sessionDetailPage3540.getSessionDetailPage3540Object(SessionDetailPage3540ObjectList.UNIT_TYPE_SPINNER).click();
			mElementListHolder.clear();
			mElementListHolder = sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.IOS_STUDY_TYPE_LIST);
			mElementListHolder.get(2).click();
			IOSUtils.isPageLoaded(15, "Loading...");
			CommonUtils.wait(3);
			sessionDetailPage3540.switchToOtherTab(FCCM.GRAPH_1H_TAB, ScrollDiection.DOWN);
		}
	}
	
	@Test(priority = 115042, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void graphTHCAUnitTest()
	{
		mValueHolder.delete(0, mValueHolder.length());
		mValueHolder.append(sessionDetailPage3540.getUnit(StudyType.THCA) + " " + sessionDetailPage3540.getPhase(mStudyType, StudyType.THCA).split(",")[0]);
		Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".graphFilterValueUnit").getText().equals(mValueHolder.toString()));
	}
	
	@Test(priority = 115043, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void thcAValueTest()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.WEB_THCA_VALUE_LIST)) {
				Assert.assertFalse(element.getText().contains("--"));
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) 
			Assert.assertFalse(DriverManager.getDriver().getPageSource().contains("--"));
	}
	
	@Test(priority = 115044, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void thcAUnitTest()
	{
		for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.THCA_VALUE_UNIT))
		{
			Assert.assertTrue(element.getText().equals(sessionDetailPage3540.getUnit(StudyType.THCA)));
		}
	}
	
	@Test(priority = 115045, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void switchToTHCAALLTabTest() throws Exception
	{
		sessionDetailPage3540.switchToOtherTab(FCCM.GRAPH_ALL_TAB, ScrollDiection.UP);
	}
	
	@Test(priority = 115046, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void thcAValueIn1WTabTest()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.WEB_THCA_VALUE_LIST)) {
				Assert.assertFalse(element.getText().contains("--"));
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) 
			Assert.assertFalse(DriverManager.getDriver().getPageSource().contains("--"));
	}
	
	@Test(priority = 115047, groups = {FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void thcAUnitIn1WTabTest()
	{
		for(WebElement element: sessionDetailPage3540.getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList.THCA_VALUE_UNIT))
		{
			Assert.assertTrue(element.getText().equals(sessionDetailPage3540.getUnit(StudyType.THCA)));
		}
	}
	
	/*
	
	
	
	@Test(priority = 114801, dataProvider = "mobileTestData", dataProviderClass = FCCM3540.class, groups = {})
	public void measurementValueUnitPhaseTestForAllTabs(String tab, String studyType, String unitPhase, String unit, String phase)
	{
		try
		{
			testFailureState = " ";
			testFailureFlag = false;
			gestureUtils.mobileScroll("Graph View", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.UP);
			if(!currentTabValue.equals(tab))  //to ensure current tab is not being clicked again and again
			{
				sessionDetailPage3540.switchToOtherTab(tab, ScrollDiection.UP);
				currentTabValue = tab;
			}
			if(!currentStudyTypeValue.equals(studyType))  //to ensure current study type is not being clicked again and again
			{
				sessionDetailPage3540.getSessionDetailPage3540Object(SessionDetailPage3540ObjectList.STUDY_TYPE_SPINNER).click();
				ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,  studyType, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME,  studyType, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT, studyType).click();
				CommonUtils.wait(2, 10, 1);
				currentStudyTypeValue = studyType;
				defaultUnitTypeFlag = false;
			}
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				if(defaultUnitTypeFlag)  //to get benefit of default unit and phase selection
				{
					sessionDetailPage3540.getSessionDetailPage3540Object(SessionDetailPage3540ObjectList.UNIT_TYPE_SPINNER).click();
					ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,  unitPhase, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME,  unitPhase, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT, unitPhase).click();
					CommonUtils.wait(2, 1, 1);
				}
				else
				{
					ElementUtils.isDisplayed(unitPhase, null, null);
				}
				defaultUnitTypeFlag = true;
				gestureUtils.mobileScroll("Show", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
				gestureUtils.mScroll(-500, -500, 2);
				for(String phaseValue:phase.split(", "))  //phase validation
				{
					if(phaseValue.equals("Frequency"))
					{
						phaseValue = "Hz";
					}
					try
					{
						currentMeasurementValueUnit = sessionDetailPage3540.getUnit(phaseValue);
						Assert.assertTrue(ElementUtils.isDisplayed(phaseValue, null, null)); 
					}
					catch(Throwable e)
					{
						testFailureFlag = true;
						testFailureState += "In "+tab+" tab For Study Type -- Unit("+studyType+" -- "+unitPhase+") Phase Value is incorrect. Expected: "+phaseValue;
					}
				}
				if(unit.equals("Frequency"))
				{
					unit = "Hz";
				}
				if(unit.equals("Phase A"))
				{
					unit = "kVA";
				}
				try
				{
					Assert.assertTrue(ElementUtils.isDisplayed(unit, null, null));  //unit validation
				}
				catch(Throwable e)
				{
					testFailureFlag = true;
					testFailureState += "In "+tab+" tab For Study Type -- Unit("+studyType+" -- "+unitPhase+") Unit is incorrect. Expected: "+unit;
				}
				try
				{
					WebElement element = ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, defaultMeasurementValue, null, null, null, null);
					boolean validationFlag;
					if(element == null)
						validationFlag = false;
					else
						validationFlag = true;
					Assert.assertFalse(validationFlag); //measurement validation
				}
				catch(Throwable e)
				{
					testFailureFlag = true;
					testFailureState += "In "+tab+" tab For Study Type -- Unit ("+studyType+" -- "+unitPhase+") Measurement value is stale";
				}
				try
				{
					if(currentMeasurementValueUnit != null)
					{
						Assert.assertTrue(ElementUtils.isDisplayed(1, 1, currentMeasurementValueUnit, null, null)); //measurement value unit validation
					}
				}
				catch(Throwable e)
				{
					testFailureFlag = true;
					testFailureState += "In "+tab+" tab For Study Type -- Unit ("+studyType+" -- "+unitPhase+") Measurement value unit is incorrect. Expected: "+currentMeasurementValueUnit;
				}
				if(testFailureFlag)
				{
					throw new Exception();  //if any validation fails exception will triggered
				}
				else
				{
					//ExtentReportUtils.testStepDetails("Verified Measurement value, unit, phase value for Study type -- Unit ("+studyType+" -- "+unitPhase+") In "+tab+ " tab");
				}
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				sessionDetailPage3540.getSessionDetailPage3540Object(SessionDetailPage3540ObjectList.UNIT_TYPE_SPINNER).click();
				List<WebElement> phaseUnit = DriverManager.getDriver().findElements(MobileBy.iOSNsPredicateString("name == '"+unitPhase+"'"));
				for(WebElement element:phaseUnit)
				{
					element.click();
				}
				CommonUtils.wait(1, 10, 1);
				if(!currentPhaseUnit.equals(phase)) //hack over isDisplayed for fast speed
				{
					pageSource = null;
					pageSource = DriverManager.getDriver().getPageSource();
				}
				currentPhaseUnit = phase;
				gestureUtils.mobileScroll("Show", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
				gestureUtils.mScroll(-500, -500, 1);
				for(String phaseValue:phase.split(", "))  //phase validation
				{
					if(phaseValue.equals("Frequency"))
					{
						phaseValue = "Hz";
					}
					try
					{
						//currentMeasurementValueUnit = sessionDetailPage3540.getUnit(phaseValue);
						currentMeasurementValueUnit = sessionDetailPage3540.getUnit(unit);
						Assert.assertTrue(pageSource.contains("\""+phaseValue+"\""));
					}
					catch(Throwable e)
					{
						testFailureFlag = true;
						testFailureState += "In "+tab+" tab For Study Type -- Unit ("+studyType+" -- "+unitPhase+") Phase Value is incorrect. Expected: "+phaseValue;
					}
				}
				if(unit.equals("Frequency"))
				{
					unit = "Hz";
				}
				if(unit.equals("Volts"))
				{
					unit = "V";
				}
				if(unit.equals("Amps"))
				{
					unit = "A";
				}
				if(unit.equals("Phase A"))
				{
					unit = "kVA";
				}
				//if(unit.equals("A"))
				//{
					//unit = "kW";
				//}
				try
				{
					Assert.assertTrue(pageSource.contains(unit)); //unit validation
				}
				catch(Throwable e)
				{
					testFailureFlag = true;
					testFailureState += "In "+tab+" tab For Study Type -- Unit ("+studyType+" -- "+unitPhase+") Unit is incorrect. Expected: "+unit;
				}
				try
				{
					Assert.assertFalse(pageSource.contains(defaultMeasurementValue));  //measurement value validation
				}
				catch(Throwable e)
				{
					testFailureFlag = true;
					testFailureState += "In "+tab+" tab For Study Type -- Unit ("+studyType+" -- "+unitPhase+") Measurement value is stale";
				}
				try
				{
					if(currentMeasurementValueUnit != null)
					{
						if (unit.contains("Power Factor")==false)
						{
						Assert.assertTrue(pageSource.contains("\""+currentMeasurementValueUnit+"\"")); //measurement unit validation
						}
					}
				}
				catch(Throwable e)
				{
					testFailureFlag = true;
					testFailureState += "In "+tab+" tab For Study Type -- Unit ("+studyType+" -- "+unitPhase+") Measurement value unit is incorrect. Expected: "+currentMeasurementValueUnit;
				}
				if(testFailureFlag)
				{
					throw new Exception(); //test failure if any of above validation fails
				}
				else
				{
					//ExtentReportUtils.testStepDetails("Verified Measurement value, unit, phase value for Study type -- Unit ("+studyType+" -- "+unitPhase+") In "+tab+ " tab");
				}
			}
		}
			catch(Throwable e)
			{
				//ExtentReportUtils.testStepDetails(testFailureState);
				testFailureFlag = false;
				Assert.fail(testFailureState);
			}		
	}
	
	@Test(priority = 114802, groups = {})
	public void studyTypeTest()
	{
		for(String studyType: FCCM3540.getGraphViewList(mStudyType))
		{
			ElementUtils.isDisplayed(null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT ,studyType);
		}
	}
	
	@Test(priority = 114803, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void webAddVoltageAlarm()
	{
		ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT, "V,A,Hz").click();
		//sessionDetailPage3540.addAboveVoltageAlarmForWeb();
		Assert.assertTrue(sessionDetailPage3540.addAboveVoltageAlarmForWeb("1")); 
	}
	
	@Test(priority = 114804, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void webEditVoltageAlarm()
	{
		ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT, "V,A,Hz").click();
		Assert.assertTrue(sessionDetailPage3540.editVoltageAlarmForWeb("2")); 
	}
	
	@Test(priority = 114805, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS})
	public void webDeleteVoltageAlarm()
	{
		ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT, "V,A,Hz").click();
		Assert.assertTrue(sessionDetailPage3540.deleteVoltageAlarmForWeb()); 
	}
	
	@Test(priority = 114806, dataProvider = "webTestData", dataProviderClass = FCCM3540.class, groups = {})
	public void measurementValueUnitPhaseTestForAllTabs(String studyType, String tab, String unit, String phase)
	{
		try
		{
			testFailureState = "In "+tab+" tab For Study Type("+studyType+") ";
			testFailureFlag = false;
			if(!currentTabValue.equals(tab))  //to ensure current tab is not being clicked again and again
			{
				sessionDetailPage3540.switchToOtherTab(tab, ScrollDiection.UP);
				currentTabValue = tab;
			}
			if(!currentWebStudyTypeValue.equals(studyType))  //to ensure current study type is not being clicked again and again
			{
				ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT, studyType).click();
				CommonUtils.wait(0, 0, 3);
				currentWebStudyTypeValue = studyType;
			}
			for(String phaseValue:phase.split(", "))  //phase validation
			{
				try
				{
					Assert.assertTrue(sessionDetailPage3540.isPhaseDisplayed(phaseValue)); 
				}
				catch(Throwable e)
				{
					testFailureFlag = true;
					testFailureState += ", Phase Value is incorrect. Expected: "+phaseValue;
				}
			}
			
			try
			{
				Assert.assertTrue(sessionDetailPage3540.isUnitOnGraphAccurate(unit, phase,tab)); //web unit on graph validation
			}
			catch(Throwable e)
			{
				testFailureFlag = true;
				testFailureState += ", For "+unit+" unit on graph is not accurate";
			}
			try
			{
				Assert.assertTrue(sessionDetailPage3540.isUnitDisplayed(unit));  //unit validation
			}
			catch(Throwable e)
			{
				testFailureFlag = true;
				testFailureState += ", Unit is incorrect. Expected: "+unit;
			}
			try
			{
				Assert.assertTrue(sessionDetailPage3540.isMeasurementValueNotStale(unit)); //measurement value validation
			}
			catch(Throwable e)
			{
				testFailureFlag = true;
				testFailureState += ", Measurement value is stale";
			}
			try
			{
				if(currentMeasurementValueUnit != null)
				{
					Assert.assertTrue(sessionDetailPage3540.isMeasurementUnitAccurate(unit)); //measurement unit validation
				}
			}
			catch(Throwable e)
			{
				testFailureFlag = true;
				testFailureState += ", Measurement value unit is incorrect. Expected: "+currentMeasurementValueUnit;
			}
			if(testFailureFlag)
			{
				throw new Exception();  //if any validation fails exception will triggered
			}
			else
			{
				//ExtentReportUtils.testStepDetails("Verified Measurement value, unit, phase value for Study type("+studyType+") In "+tab+ " tab");
			}
			
			try
			{
				if (currentWebStudyTypeValue == "Active Power")
				{
					ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_ID, "radiobtns1_ACTIVE_POWER_Tot").click();
					CommonUtils.wait(0, 0, 3);
				}
			}catch(Throwable e)
			{
				
			}
			
			try
			{
				if (currentWebStudyTypeValue == "Active Power")
				{
					ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_ID, "radiobtns2_ACTIVE_POWER_Tot").click();
					CommonUtils.wait(0, 0, 3);
				}
			}catch(Throwable e)
			{
				
			}
			
		}
		catch(Throwable e)
		{
			//ExtentReportUtils.testStepDetails(testFailureState);
			testFailureFlag = false;
			Assert.fail(testFailureState);
		}	
	}
	
	*/
	
	@AfterClass(alwaysRun = true, groups = {FCCM3540.SESSION_VERIFICATION_WEB_TESTS, FCCM3540.SESSION_DETAIL_PAGE_TESTS,  FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.UAT_3540})
	public void tearDown() throws Exception
	{
		Config.useExistingPageSource = false;
		IOSUtils.resetIOSPageSource();
		if(!DriverManager.isSmokeSuite()) {
			DriverManager.closeApp();
			DriverManager.launchApp();
			DriverManager.getSignIn().handleOnBoardPrompt();
			DriverManager.getSwitcher().signOut();
		}
		
	} 

}



