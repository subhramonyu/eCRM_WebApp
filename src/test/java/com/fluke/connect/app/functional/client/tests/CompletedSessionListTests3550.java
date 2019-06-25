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
import com.fluke.connect.app.utils.Config.PropertiesFileType;
import com.fluke.connect.app.utils.Config.ScrollDiection;

public class CompletedSessionListTests3550 {
	
	private GestureUtils gestureUtils;
	private SessionListPage sessionListPage;
	private Switcher switcher;
	private String sessionStartTimestamp;
	private String requiredSessionStartTimestamp;
	private MeasurementsHistoryPage measurementHistoryPage;
	private Graph3560Page  graphPage;

	@Parameters({ "activeSessionStartTime3550", "completedSessionStartTime3550" })
	@BeforeClass(alwaysRun = true, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS, FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_LIST_TESTS })
	public void initClass(@Optional("no value") String activeSessionStartTime,
			@Optional("no value") String completedSessionStartTime) throws Exception, ParseException {
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
		switcher.switchToSession(Switcher.COMPLETED_SESSION);
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			graphPage.clickOnSessionType(SessionType.THERMAL,"SavedSession");
		SyncUtils.isSynced(
				measurementHistoryPage
						.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.COMPLETED_SESSIONS),
				switcher.getElement(Switcher.BACK_BUTTON), FCCM3550.testPointName, 10, 10);
		sessionStartTimestamp = FCCMUtils.getSessionStartTime(completedSessionStartTime,
				Config.getPropertiesFilePath(PropertiesFileType.FCCM_PROPERTIES),
				FCCM3550.androidCompletedSessionStartTimestamp, FCCM3550.iOSCompletedSessionStartTimestamp);
		// getting given time stamp and gateway name from properties file
		requiredSessionStartTimestamp = FCCMUtils.getRequiredSessionStartTimestamp(sessionStartTimestamp,
				Config.ANDROID_DATE_SEPRATOR, Config.IOS_DATE_SEPRATOR, null);
		CommonUtils.wait(2);
		if (!IOSUtils.isPageLoaded(LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_BEGINSWITH, "Loading...", 60))
			throw new Exception();
		ElementUtils.isDisplayed(5, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, "Sensors",
				LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, "Sensors", LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,
				".sessionGatewaySensorsTitle"); // to ensure active monitoring session page is loaded properly
		IOSUtils.setIOSPageSource();
		gestureUtils.mScroll(requiredSessionStartTimestamp, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS,
				LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		sessionListPage.initSessionCellElement(requiredSessionStartTimestamp);
	}

	@Test(priority = 128301, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS,
			FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_LIST_TESTS })
	public void sessionTileVisibleTest() {
		try {
			Assert.assertTrue(sessionListPage.getSessionTile().isDisplayed());
		} catch (Throwable e) {
			Assert.fail("Exception Detail: " + e);
		}
	}

	@Test(priority = 128302, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS,
			FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_LIST_TESTS, })
	public void gateWayNameTest() {
		try {
			Assert.assertEquals(sessionListPage.getElementVisibleTextInSessionTileStrict(FCCM3550.gatewayNameValue),
					FCCM3550.gatewayNameValue);
		} catch (Throwable e) {
			Assert.fail("Exception Detail: " + e);
		}
	}

	@Test(priority = 128303, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS,
			FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_LIST_TESTS, })
	public void sensorsStaticTextVisibleTest() {
		try {
			Assert.assertEquals(sessionListPage.getElementVisibleTextInSessionTileStrict(Config.SENSORS_STATIC_TEXT),
					Config.SENSORS_STATIC_TEXT);
		} catch (Throwable e) {
			Assert.fail("Exception Detail: " + e);
		}
	}

	@Test(priority = 128304, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS,
			FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_LIST_TESTS, })
	public void sensorCountAndTypeTest() {
		try {
			Assert.assertEquals(sessionListPage.getElementVisibleTextInSessionTileStrict(FCCM3550.sensorsCountAndType),
					FCCM3550.sensorsCountAndType);
		} catch (Throwable e) {
			Assert.fail("Exception Detail: " + e);
		}
	}

	@Test(priority = 128305, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS,
			FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_LIST_TESTS, })
	public void startTimeStaticTextVisibleTest() {
		try {
			Assert.assertEquals(sessionListPage.getElementVisibleTextInSessionTileStrict(Config.START_TIME_STATIC_TEXT),
					Config.START_TIME_STATIC_TEXT);
		} catch (Throwable e) {
			Assert.fail("Exception Detail: " + e);
		}
	}

	@Test(priority = 128306, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS,
			FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_LIST_TESTS, })
	public void sessionStartTimeTest() {
		try {
			if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)
					|| DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
				Assert.assertTrue(sessionListPage.getElementVisibleTextInSessionTile(requiredSessionStartTimestamp)
						.contains(requiredSessionStartTimestamp));
			} else if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
				Assert.assertTrue(ElementUtils.getElement(sessionListPage.getSessionTile(), null, null, null, null,
						LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_SPAN_TEXT_CONTAINS, requiredSessionStartTimestamp)
						.getText().contains(requiredSessionStartTimestamp));
			}
		} catch (Throwable e) {
			Assert.fail("Exception Detail: " + e);
		}
	}

	@Test(priority = 128307, groups = {})
	public void sessionStartUserNameTest() {
		try {
			if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
				Assert.assertEquals(
						sessionListPage.getElementVisibleTextInSessionTileStrict(FCCM3550.sessionStartUserName),
						FCCM3550.sessionStartUserName);
			} else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
				Assert.assertTrue(sessionListPage.getElementVisibleTextInSessionTile(FCCM3550.sessionStartUserName)
						.contains(FCCM3550.sessionStartUserName));
			} else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
				Assert.assertTrue(sessionListPage.getElementVisibleTextInSessionTile(requiredSessionStartTimestamp)
						.contains(FCCM3550.sessionStartUserName));
			}
		} catch (Throwable e) {
			Assert.fail("Exception Detail: " + e);
		}
	}

	@Test(priority = 128308, groups = {FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS, FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3550.COMPLETED_SESSION_LIST_TESTS, })
	public void clickOnSessionTileTest() {
		try {
			ElementUtils.getElement(sessionListPage.getSessionTile(),
					LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, requiredSessionStartTimestamp,
					LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, requiredSessionStartTimestamp,
					LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_SPAN_TEXT_CONTAINS, requiredSessionStartTimestamp)
					.click();
		} catch (Throwable e) {
			Assert.fail("Exception Detail: " + e);
		}
	}

	@AfterClass(groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS,
			FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_LIST_TESTS, })
	public void tearDown() throws Exception {
		Config.useExistingPageSource = false;
		IOSUtils.resetIOSPageSource();
	}

}
