/**
 * This class comprises of tests around an active session and its details like gateway name, sensor count, asset / test point
 * hierarchy, session creator, and start time stamp details.
 */

package com.fluke.connect.app.functional.client.tests;

import java.text.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.fluke.connect.app.functional.client.pages.MeasurementsHistoryPage;
import com.fluke.connect.app.functional.client.pages.ServiceHatchPage;
import com.fluke.connect.app.functional.client.pages.SessionListPage;
import com.fluke.connect.app.functional.client.pages.Switcher;
import com.fluke.connect.app.functional.client.pages.MeasurementsHistoryPage.MeasurementHistoryPageObjects;
import com.fluke.connect.app.testdata.FCCM3560;
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


public class ActiveSessionListTests3560 
{
	private GestureUtils gestureUtils;
	private SessionListPage sessionListPage;
	private Switcher switcher;
	private ServiceHatchPage serviceHatchPage;
	private MeasurementsHistoryPage measurementHistoryPage;
	private String gatewayName;
	
	@Parameters({"activeSessionStartTime3560", "activeSessionGatewayName3560", "toggleFeature3560"})
	@BeforeClass(groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, 
				FCCM3560.SESSION_VERIFICATION_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS,  
				 FCCM3560.SESSION_LIST_TESTS})
	public void initClass(@Optional("no value") String activeSessionStartTime3560, @Optional("no value") String activeSessionGatewayName, @Optional("true") Boolean toggleFeature) throws Exception, ParseException
	{
		if(!DriverManager.isSmokeSuite()) {
		DriverManager.getSignIn().signIn(SignIn.getUID(FeatureList.FCCM3560_VIB), SignIn.getPWD(FeatureList.FCCM3560_VIB));
        DriverManager.getSignIn().handleAfterSignInAlertsOtherUser();
		}
		switcher = new Switcher();
		sessionListPage = new SessionListPage();
		gestureUtils = new GestureUtils();
		measurementHistoryPage = new MeasurementsHistoryPage();
		serviceHatchPage = new ServiceHatchPage();
		gatewayName = activeSessionGatewayName;
		CommonUtils.wait(5);
		if(toggleFeature)
			serviceHatchPage.toggleFeature(null, null, "input[data-feature='Bluvision Preprod']", true, null, true);
		switcher.switchToSession(Switcher.ACTIVE_SESSION);
		SyncUtils.isSynced(measurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.ACTIVE_SESSIONS), switcher.getElement(Switcher.BACK_BUTTON), FCCM3560.assetGroupName, 10, 6);
		FCCM3560.sessionStartTimestampValue = FCCMUtils.getSessionStartTime(activeSessionStartTime3560, Config.getPropertiesFilePath(PropertiesFileType.FCCM_PROPERTIES), FCCM3560.androidSessionStartTimestamp, FCCM3560.iOSSessionStartTimestamp);
		FCCM3560.gatewayNameValue = FCCMUtils.getGatewayName(gatewayName, Config.getPropertiesFilePath(PropertiesFileType.FCCM_PROPERTIES), FCCM3560.androidGatewayName, FCCM3560.iOSGatewayName);
		FCCM3560.requiredSessionStartTimestamp = FCCMUtils.getRequiredSessionStartTimestamp(FCCM3560.sessionStartTimestampValue, Config.ANDROID_DATE_SEPRATOR, Config.IOS_DATE_SEPRATOR, null);
		CommonUtils.wait(2);
		if(!IOSUtils.isPageLoaded(LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_BEGINSWITH, "Loading...", 60))
			throw new Exception();
		ElementUtils.isDisplayed(5, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, "Sensors", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, "Sensors", LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".sessionGatewaySensorsTitle"); // to ensure active monitoring session page is loaded properly
		IOSUtils.setIOSPageSource();
		gestureUtils.mScroll(FCCM3560.requiredSessionStartTimestamp, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		sessionListPage.initSessionCellElement(FCCM3560.requiredSessionStartTimestamp); 
	}
	
	@Test(priority = 136501, groups = {})
	public void sessionTileVisibleTest()
	{
		Assert.assertTrue(sessionListPage.getSessionTile().isDisplayed());
	}
	
	@Test(priority = 136502, groups = {})
	public void sessionTileStatusTest()
	{
		Assert.assertEquals(sessionListPage.getElementVisibleTextInSessionTileStrict(FCCM3560.sessionStatus[0]), FCCM3560.sessionStatus[0]);
	}
	@Test(priority = 136503, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS,   FCCM3560.SESSION_LIST_TESTS, })
	public void  gatewayNameTest()
	{
		if(gatewayName.equals("no value"))
				Assert.assertEquals(sessionListPage.getElementVisibleTextInSessionTileStrict(FCCM3560.gatewayNameValue), FCCM3560.gatewayNameValue);
			else
				Assert.assertEquals(sessionListPage.getElementVisibleTextInSessionTileStrict(gatewayName), gatewayName);
	}
	
	@Test(priority = 136504, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS,   FCCM3560.SESSION_LIST_TESTS, })
	public void sensorsStaticTextVisibleTest()
	{
		Assert.assertEquals(sessionListPage.getElementVisibleTextInSessionTileStrict(Config.SENSORS_STATIC_TEXT), Config.SENSORS_STATIC_TEXT);
	}
	
	@Test(priority = 136505, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS,   FCCM3560.SESSION_LIST_TESTS, })
	public void sensorCountAndTypeTest()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			Assert.assertTrue(sessionListPage.getElementVisibleTextInSessionTileStrict(FCCM3560.androidSensorsCountAndType).contains(FCCM3560.androidSensorsCountAndType));
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) ||DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(sessionListPage.getElementVisibleTextInSessionTileStrict(FCCM3560.iOSSensorsCountAndType).contains(FCCM3560.iOSSensorsCountAndType));
	}
	
	@Test(priority = 136506, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS,   FCCM3560.SESSION_LIST_TESTS, })
	public void startTimeStaticTextVisibleTest()
	{
		Assert.assertEquals(sessionListPage.getElementVisibleTextInSessionTileStrict(Config.START_TIME_STATIC_TEXT), Config.START_TIME_STATIC_TEXT);
	}
	
	@Test(priority = 136507, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS,   FCCM3560.SESSION_LIST_TESTS, })
	public void sessionStartTimeTest()
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertTrue(sessionListPage.getElementVisibleTextInSessionTileStrict(FCCM3560.requiredSessionStartTimestamp).contains(FCCM3560.requiredSessionStartTimestamp)) ;
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			Assert.assertTrue(sessionListPage.getElementVisibleTextInSessionTile(FCCM3560.requiredSessionStartTimestamp).contains(FCCM3560.requiredSessionStartTimestamp));
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(ElementUtils.getElement(sessionListPage.getSessionTile(), null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_SPAN_TEXT_CONTAINS, FCCM3560.requiredSessionStartTimestamp).getText().contains(FCCM3560.requiredSessionStartTimestamp)) ;
	}
	
	@Parameters({"sessionStartUserName"})
	@Test(priority = 136508, groups = {})
	public void sessionStartUserNameTest(@Optional("no value") String userName)
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			if(userName.equals("no value"))
				Assert.assertEquals(sessionListPage.getElementVisibleTextInSessionTile(FCCM3560.sessionStartUserName), FCCM3560.sessionStartUserName);
			else
				Assert.assertEquals(sessionListPage.getElementVisibleTextInSessionTile(userName), userName);
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			if(userName.equals("no value"))
				Assert.assertTrue(sessionListPage.getElementVisibleTextInSessionTile(FCCM3560.requiredSessionStartTimestamp).contains(FCCM3560.sessionStartUserName));
			else
				Assert.assertTrue(sessionListPage.getElementVisibleTextInSessionTile(FCCM3560.requiredSessionStartTimestamp).contains(userName));
		}
	}
	
	@Test(priority = 136509, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS,   FCCM3560.SESSION_LIST_TESTS, })
	public void clickOnSessionTileTest()
	{
		ElementUtils.getElement(sessionListPage.getSessionTile(), LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, FCCM3560.requiredSessionStartTimestamp, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, FCCM3560.requiredSessionStartTimestamp, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_SPAN_TEXT_CONTAINS, FCCM3560.requiredSessionStartTimestamp).click();
	}
	
	@AfterClass(groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS,   FCCM3560.SESSION_LIST_TESTS, })
	public void tearDown()
	{
		Config.useExistingPageSource = false;
		IOSUtils.resetIOSPageSource();
	}
}

