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
import com.fluke.connect.app.testdata.FCCM3540;
import com.fluke.connect.app.testdata.SignIn;
import com.fluke.connect.app.testdata.Graph.SessionType;
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
import com.fluke.connect.app.utils.Config.ScrollDiection;

public class CompletedSessionListTests3540 {
	private GestureUtils gestureUtils;
	private SessionListPage sessionListPage;
	private Switcher switcher;
	private MeasurementsHistoryPage measurementHistoryPage;
	private Graph3560Page  graphPage;

	@Parameters({ "completedSessionStartTime3540" })
	@BeforeClass(alwaysRun = true, groups = { FCCM3540.COMPLETED_SESSION_VERIFICATION_TESTS,
			FCCM3540.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3540.COMPLETED_SESSION_LIST_TESTS,
			Config.IOS_3540_SMOKE_EXT_TESTS, Config.ANDROID_SMOKE_TESTS, FCCM3540.UAT_3540 }) //Config.ANDROID_SMOKE_EXTENDED_TESTS
	public void initClass(@Optional("no value") String completedSessionStartTime3540) throws Exception, ParseException {
		if(!DriverManager.isSmokeSuite()) {
			DriverManager.getSignIn().signIn(SignIn.getUID(FeatureList.FCCM3540), SignIn.getPWD(FeatureList.FCCM3540));
	        DriverManager.getSignIn().handleAfterSignInAlertsOtherUser();
		}
		switcher = new Switcher();
		sessionListPage = new SessionListPage();
		gestureUtils = new GestureUtils();
		measurementHistoryPage = new MeasurementsHistoryPage();
		graphPage=new Graph3560Page();
		CommonUtils.wait(5);
		switcher.switchToSession(Switcher.COMPLETED_SESSION);
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			graphPage.clickOnSessionType(SessionType.POWER,"SavedSession");
		SyncUtils.isSynced(measurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.COMPLETED_SESSIONS), switcher.getElement(Switcher.BACK_BUTTON), "Assets", 10, 10);
		FCCM3540.sessionStartTimestampValue = FCCMUtils.getSessionStartTime(completedSessionStartTime3540, Config.FCCM_PROPERTIES_FILE_PATH, FCCM3540.androidCompletedSessionStartTimestamp, FCCM3540.iOSCompletedSessionStartTimestamp);
		// getting given time stamp and gateway name from properties file
		FCCM3540.requiredSessionStartTimestamp = FCCMUtils.getRequiredSessionStartTimestamp(FCCM3540.sessionStartTimestampValue, Config.ANDROID_DATE_SEPRATOR, Config.IOS_DATE_SEPRATOR, null);
		if (!IOSUtils.isPageLoaded(LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_BEGINSWITH, "Loading...", 60))
			throw new Exception();
		CommonUtils.wait(5, 10, 5);
		ElementUtils.isDisplayed(15, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, "Fluke3540FC", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, "Fluke3540FC", LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".sessionGatewayName"); // to ensure active monitoring session page is loaded properly
		IOSUtils.setIOSPageSource();
		gestureUtils.mScroll(FCCM3540.requiredSessionStartTimestamp, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		sessionListPage.initSessionCellElement(FCCM3540.requiredSessionStartTimestamp);
	}

	@Test(priority = 117301, groups = { Config.IOS_3540_SMOKE_EXT_TESTS, Config.ANDROID_SMOKE_TESTS,
			 FCCM3540.UAT_3540}) //Config.ANDROID_SMOKE_EXTENDED_TESTS,
	public void sessionTileVisibleTest() 
	{
		Assert.assertTrue(sessionListPage.getSessionTile().isDisplayed());
	}

	@Test(priority = 117302, groups = {})
	public void sessionTileStatusTest() 
	{
		Assert.assertEquals(sessionListPage.getElementVisibleTextInSessionTileStrict(FCCM3540.sessionStatus[0]), FCCM3540.sessionStatus[0]);
	}

	@Test(priority = 117303, groups = { FCCM3540.COMPLETED_SESSION_VERIFICATION_TESTS,
			FCCM3540.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3540.COMPLETED_SESSION_LIST_TESTS,
			Config.IOS_3540_SMOKE_EXT_TESTS, Config.ANDROID_SMOKE_TESTS, FCCM3540.UAT_3540}) // Config.ANDROID_SMOKE_EXTENDED_TESTS,
	public void gateWayNameTest() 
	{
		Assert.assertEquals(sessionListPage.getElementVisibleTextInSessionTileStrict(FCCM3540.gatewayNameValue), FCCM3540.gatewayNameValue);
	}

	@Test(priority = 117304, groups = { FCCM3540.COMPLETED_SESSION_VERIFICATION_TESTS,
			FCCM3540.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3540.COMPLETED_SESSION_LIST_TESTS,
			Config.IOS_3540_SMOKE_EXT_TESTS, Config.ANDROID_SMOKE_TESTS, FCCM3540.UAT_3540}) //Config.ANDROID_SMOKE_EXTENDED_TESTS,
	public void startTimeStaticTextVisibleTest() 
	{
		Assert.assertEquals(sessionListPage.getElementVisibleTextInSessionTileStrict(Config.START_TIME_STATIC_TEXT), Config.START_TIME_STATIC_TEXT);
	}

	@Test(priority = 117305, groups = { FCCM3540.COMPLETED_SESSION_VERIFICATION_TESTS,
			FCCM3540.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3540.COMPLETED_SESSION_LIST_TESTS,
			Config.IOS_3540_SMOKE_EXT_TESTS, Config.ANDROID_SMOKE_TESTS, FCCM3540.UAT_3540}) //Config.ANDROID_SMOKE_EXTENDED_TESTS,
	public void sessionStartTimeTest() 
	{
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) 
			Assert.assertTrue(sessionListPage.getElementVisibleTextInSessionTileStrict(FCCM3540.requiredSessionStartTimestamp).contains(FCCM3540.requiredSessionStartTimestamp));
		else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) 
			Assert.assertTrue(sessionListPage.getElementVisibleTextInSessionTile(FCCM3540.requiredSessionStartTimestamp).contains(FCCM3540.requiredSessionStartTimestamp));
		else if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) 
			Assert.assertTrue(ElementUtils.getElement(sessionListPage.getSessionTile(), null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_SPAN_TEXT_CONTAINS,FCCM3540.requiredSessionStartTimestamp).getText().contains(FCCM3540.requiredSessionStartTimestamp));
	}

	@Parameters({ "userName" })
	@Test(priority = 117306, groups = {})
	public void sessionStartUserNameTest(@Optional("null") String userName) 
	{
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER)) 
			Assert.assertEquals(sessionListPage.getElementVisibleTextInSessionTileStrict(DriverManager.getUserName()), DriverManager.getUserName());
		else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) 
			Assert.assertTrue(sessionListPage.getElementVisibleTextInSessionTile(FCCM3540.requiredSessionStartTimestamp).contains(DriverManager.getUserName()));
	}

	@Test(priority = 117307, groups = {FCCM3540.COMPLETED_SESSION_VERIFICATION_TESTS,
			FCCM3540.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3540.COMPLETED_SESSION_LIST_TESTS,
			Config.IOS_3540_SMOKE_EXT_TESTS, Config.ANDROID_SMOKE_TESTS, FCCM3540.UAT_3540}) //Config.ANDROID_SMOKE_EXTENDED_TESTS,
	public void clickOnSessionTileTest() 
	{
		ElementUtils.getElement(sessionListPage.getSessionTile(), LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, FCCM3540.requiredSessionStartTimestamp, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, FCCM3540.requiredSessionStartTimestamp, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_SPAN_TEXT_CONTAINS, FCCM3540.requiredSessionStartTimestamp).click();
	}

	@AfterClass(groups = { FCCM3540.COMPLETED_SESSION_VERIFICATION_TESTS,
			FCCM3540.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3540.COMPLETED_SESSION_LIST_TESTS,
			Config.IOS_3540_SMOKE_EXT_TESTS, Config.ANDROID_SMOKE_TESTS })
	public void tearDown() 
	{
		Config.useExistingPageSource = false;
		IOSUtils.resetIOSPageSource();
	}
}
