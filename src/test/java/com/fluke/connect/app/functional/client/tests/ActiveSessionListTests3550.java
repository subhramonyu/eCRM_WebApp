package com.fluke.connect.app.functional.client.tests;

import java.text.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fluke.connect.app.functional.client.pages.Graph3560Page;
import com.fluke.connect.app.functional.client.pages.MeasurementsHistoryPage;
import com.fluke.connect.app.functional.client.pages.SessionListPage;
import com.fluke.connect.app.functional.client.pages.Switcher;
import com.fluke.connect.app.functional.client.pages.MeasurementsHistoryPage.MeasurementHistoryPageObjects;
import com.fluke.connect.app.testdata.FCCM3550;
import com.fluke.connect.app.testdata.Graph.SessionType;
import com.fluke.connect.app.testdata.SignIn;
import com.fluke.connect.app.testdata.SignIn.FeatureList;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.FCCMUtils;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.IOSUtils;
import com.fluke.connect.app.utils.SyncUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.PropertiesFileType;
import com.fluke.connect.app.utils.Config.ScrollDiection;

public class ActiveSessionListTests3550 
{
	private GestureUtils gestureUtils;
	private SessionListPage sessionListPage;
	private Switcher switcher;
	private String sessionStartTimestamp;
	private String requiredSessionStartTimestamp;
	private MeasurementsHistoryPage measurementHistoryPage;
	private Graph3560Page  graphPage;

	@Parameters({ "activeSessionStartTime3550"})
	@BeforeClass(alwaysRun = true, groups = {FCCM3550.SESSION_VERIFICATION_TESTS,FCCM3550.SESSION_VERIFICATION_WEB_TESTS,  
											FCCM3550.SESSION_LIST_TESTS, FCCM3550.UAT_TESTS, FCCM3550.UAT_WEB_TESTS})
	public void initClass( @Optional("no value") String activeSessionStartTime) throws Exception, ParseException 
	{
		if(!DriverManager.isSmokeSuite()) {
		DriverManager.getSignIn().signIn(SignIn.getUID(FeatureList.FCCM3550), SignIn.getPWD(FeatureList.FCCM3550));
        DriverManager.getSignIn().handleAfterSignInAlertsOtherUser();
		}
		switcher = new Switcher();
		sessionListPage = new SessionListPage();
		gestureUtils = new GestureUtils();
		measurementHistoryPage = new MeasurementsHistoryPage();
		graphPage=new Graph3560Page();
		CommonUtils.wait(5);
		switcher.switchToSession(Switcher.ACTIVE_SESSION);
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			graphPage.clickOnSessionType(SessionType.THERMAL,"Active Session");
		SyncUtils.isSynced(measurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.ACTIVE_SESSIONS), switcher.getElement(Switcher.BACK_BUTTON), FCCM3550.testPointName, 10, 10);
		sessionStartTimestamp = FCCMUtils.getSessionStartTime(activeSessionStartTime, Config.getPropertiesFilePath(PropertiesFileType.FCCM_PROPERTIES), FCCM3550.androidSessionStartTimestamp, FCCM3550.iOSSessionStartTimestamp);
		// getting given time stamp and gateway name from properties file
		FCCM3550.requiredSessionStartTimestamp = FCCMUtils.getRequiredSessionStartTimestamp(sessionStartTimestamp, Config.ANDROID_DATE_SEPRATOR, Config.IOS_DATE_SEPRATOR, null);
		CommonUtils.wait(2);
		if(!IOSUtils.isPageLoaded(LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_BEGINSWITH, "Loading...", 60))
			throw new Exception();
		ElementUtils.isDisplayed(5, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, "Sensors", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, "Sensors", LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".sessionGatewaySensorsTitle"); // to ensure active monitoring session page is loaded properly
		IOSUtils.setIOSPageSource();
		gestureUtils.mScroll(FCCM3550.requiredSessionStartTimestamp, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		sessionListPage.initSessionCellElement(FCCM3550.requiredSessionStartTimestamp);
	}

	@Test(priority = 125501, groups = {FCCM3550.SESSION_VERIFICATION_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS, 
			FCCM3550.SESSION_LIST_TESTS, FCCM3550.UAT_TESTS, FCCM3550.UAT_WEB_TESTS})
	public void sessionTileVisibleTest() 
	{
		Assert.assertTrue(sessionListPage.getSessionTile().isDisplayed());
	}

	@Test(priority = 125502, groups = {FCCM3550.SESSION_VERIFICATION_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_LIST_TESTS,
										FCCM3550.UAT_TESTS})
	public void sessionTileStatusTest() 
	{
		Assert.assertEquals(sessionListPage.getElementVisibleTextInSessionTileStrict(FCCM3550.sessionStatus[0]), FCCM3550.sessionStatus[0]);
	}

	@Test(priority = 125503, groups = {FCCM3550.SESSION_VERIFICATION_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS,
			FCCM3550.SESSION_LIST_TESTS, FCCM3550.UAT_TESTS, FCCM3550.UAT_WEB_TESTS})
	public void gateWayNameTest() 
	{
		Assert.assertEquals(sessionListPage.getElementVisibleTextInSessionTileStrict(FCCM3550.gatewayNameValue), FCCM3550.gatewayNameValue);
	}

	@Test(priority = 125504, groups = {FCCM3550.SESSION_VERIFICATION_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS,
					FCCM3550.SESSION_LIST_TESTS, FCCM3550.UAT_TESTS, FCCM3550.UAT_WEB_TESTS})
	public void sensorsStaticTextVisibleTest() 
	{
		Assert.assertEquals(sessionListPage.getElementVisibleTextInSessionTileStrict(Config.SENSORS_STATIC_TEXT), Config.SENSORS_STATIC_TEXT);
	}

	@Test(priority = 125505, groups = {FCCM3550.SESSION_VERIFICATION_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS,
			FCCM3550.SESSION_LIST_TESTS, FCCM3550.UAT_TESTS, FCCM3550.UAT_WEB_TESTS})
	public void sensorCountAndTypeTest() 
	{
		Assert.assertEquals(sessionListPage.getElementVisibleTextInSessionTileStrict(FCCM3550.sensorsCountAndType), FCCM3550.sensorsCountAndType);
	}

	@Test(priority = 125506, groups = {FCCM3550.SESSION_VERIFICATION_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS,
			FCCM3550.SESSION_LIST_TESTS, FCCM3550.UAT_TESTS, FCCM3550.UAT_WEB_TESTS})
	public void startTimeStaticTextVisibleTest() 
	{
		Assert.assertEquals(sessionListPage.getElementVisibleTextInSessionTileStrict(Config.START_TIME_STATIC_TEXT), Config.START_TIME_STATIC_TEXT);
	}

	@Test(priority = 125507, groups = {FCCM3550.SESSION_VERIFICATION_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS,
			FCCM3550.SESSION_LIST_TESTS, FCCM3550.UAT_TESTS, FCCM3550.UAT_WEB_TESTS})
	public void sessionStartTimeTest() 
	{
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER)) 
			Assert.assertTrue(sessionListPage.getElementVisibleTextInSessionTile(FCCM3550.requiredSessionStartTimestamp).contains(FCCM3550.requiredSessionStartTimestamp));
			else if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) 
			Assert.assertTrue(ElementUtils.getElement(sessionListPage.getSessionTile(), null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_SPAN_TEXT_CONTAINS, FCCM3550.requiredSessionStartTimestamp).getText().contains(FCCM3550.requiredSessionStartTimestamp));
	}

	 @Test(priority = 125508, groups = {})
	public void sessionStartUserNameTest() 
	 {
			if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) 
			Assert.assertEquals(sessionListPage.getElementVisibleTextInSessionTileStrict(FCCM3550.sessionStartUserName), FCCM3550.sessionStartUserName);
			else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) 
			Assert.assertTrue(sessionListPage.getElementVisibleTextInSessionTile(FCCM3550.sessionStartUserName).contains(FCCM3550.sessionStartUserName));
			else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) 
			Assert.assertTrue(sessionListPage.getElementVisibleTextInSessionTile(requiredSessionStartTimestamp).contains(FCCM3550.sessionStartUserName));
	} 

	@Test(priority = 125509, groups = {FCCM3550.SESSION_VERIFICATION_TESTS,
			FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_LIST_TESTS,
			FCCM3550.UAT_TESTS, FCCM3550.UAT_WEB_TESTS})
	public void clickOnSessionTileTest() 
	{
		ElementUtils.getElement(sessionListPage.getSessionTile(), LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, FCCM3550.requiredSessionStartTimestamp,
		LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, FCCM3550.requiredSessionStartTimestamp,
		LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_SPAN_TEXT_CONTAINS,
		FCCM3550.requiredSessionStartTimestamp).click();
	}

	@AfterClass(groups = {FCCM3550.SESSION_VERIFICATION_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS,
			FCCM3550.SESSION_LIST_TESTS, FCCM3550.UAT_TESTS, FCCM3550.UAT_WEB_TESTS})
	public void tearDown() throws Exception {
		Config.useExistingPageSource = false;
		IOSUtils.resetIOSPageSource();
	}
	
}
