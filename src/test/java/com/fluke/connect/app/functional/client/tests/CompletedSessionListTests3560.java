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


public class CompletedSessionListTests3560 
{
	private GestureUtils gestureUtils;
	private SessionListPage sessionListPage;
	private Switcher switcher;
	private ServiceHatchPage serviceHatchPage;
	private MeasurementsHistoryPage measurementHistoryPage;
	private String gatewayName;
	
	@Parameters({"completedSessionStartTime3560", "completedSessionGatewayName3560", "toggleFeature3560"})
	@BeforeClass(groups = {
				 FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS, 
				FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,  FCCM3560.COMPLETED_SESSION_LIST_TESTS})
	public void initClass(@Optional("no value") String completedSessionStartTime3560, @Optional("no value") String completedSessionGatewayName, @Optional("true") Boolean toggleFeature) throws Exception, ParseException
	{
		if(!DriverManager.isSmokeSuite()) {
			DriverManager.getSignIn().signIn(SignIn.getUID(FeatureList.FCCM3560), SignIn.getPWD(FeatureList.FCCM3560));
	        DriverManager.getSignIn().handleAfterSignInAlertsOtherUser();
		}
		switcher = new Switcher();
		sessionListPage = new SessionListPage();
		gestureUtils = new GestureUtils();
		measurementHistoryPage = new MeasurementsHistoryPage();
		serviceHatchPage = new ServiceHatchPage();
		gatewayName = completedSessionGatewayName;
		CommonUtils.wait(5);
		if(toggleFeature)
			serviceHatchPage.toggleFeature(null, null, "input[data-feature='Bluvision Preprod']", true, null, true);
		switcher.switchToSession(Switcher.COMPLETED_SESSION);
		SyncUtils.isSynced(measurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.COMPLETED_SESSIONS), switcher.getElement(Switcher.BACK_BUTTON), FCCM3560.testPointNameOld, 10, 6);
		FCCM3560.sessionStartTimestampValue = FCCMUtils.getSessionStartTime(completedSessionStartTime3560, Config.getPropertiesFilePath(PropertiesFileType.FCCM_PROPERTIES), FCCM3560.androidCompletedSessionStartTimestamp, FCCM3560.iOSCompletedSessionStartTimestamp);
		FCCM3560.gatewayNameValue = FCCMUtils.getGatewayName(gatewayName, Config.getPropertiesFilePath(PropertiesFileType.FCCM_PROPERTIES), FCCM3560.androidCompletedSessionGatewayName, FCCM3560.iOSCompletedSessionGatewayName);
		FCCM3560.requiredSessionStartTimestamp = FCCMUtils.getRequiredSessionStartTimestamp(FCCM3560.sessionStartTimestampValue, Config.ANDROID_DATE_SEPRATOR, Config.IOS_DATE_SEPRATOR, null);
		CommonUtils.wait(2);
		if(!IOSUtils.isPageLoaded(LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_BEGINSWITH, "Loading...", 60))
			throw new Exception();
		ElementUtils.isDisplayed(5, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, "Sensors", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, "Sensors", LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".sessionGatewaySensorsTitle"); // to ensure active monitoring session page is loaded properly
		IOSUtils.setIOSPageSource();
		gestureUtils.mScroll(FCCM3560.requiredSessionStartTimestamp, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		sessionListPage.initSessionCellElement(FCCM3560.requiredSessionStartTimestamp); 
	}
	
	@Test(priority = 139301, groups = {})
	public void sessionTileVisibleTest()
	{
		try 
		{
			Assert.assertTrue(sessionListPage.getSessionTile().isDisplayed());
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 139302, groups = {})
	public void sessionTileStatusTest()
	{
		try 
		{
				Assert.assertEquals(sessionListPage.getElementVisibleTextInSessionTileStrict(FCCM3560.sessionStatus[0]), FCCM3560.sessionStatus[0]);
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 139303, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,  FCCM3560.COMPLETED_SESSION_LIST_TESTS})
	public void gateWayNameTest()
	{
		try 
		{
			if(gatewayName.equals("no value"))
				Assert.assertEquals(sessionListPage.getElementVisibleTextInSessionTileStrict(FCCM3560.gatewayNameValue), FCCM3560.gatewayNameValue);
			else
				Assert.assertEquals(sessionListPage.getElementVisibleTextInSessionTileStrict(gatewayName), gatewayName);
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 139304, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,  FCCM3560.COMPLETED_SESSION_LIST_TESTS})
	public void sensorsStaticTextVisibleTest()
	{
		try 
		{
			Assert.assertEquals(sessionListPage.getElementVisibleTextInSessionTileStrict(Config.SENSORS_STATIC_TEXT), Config.SENSORS_STATIC_TEXT);
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 139305, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,  FCCM3560.COMPLETED_SESSION_LIST_TESTS})
	public void sensorCountAndTypeTest()
	{
		try 
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertTrue(sessionListPage.getElementVisibleTextInSessionTileStrict(FCCM3560.androidSensorsCountAndType).contains(FCCM3560.androidSensorsCountAndType));
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) ||DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				Assert.assertTrue(sessionListPage.getElementVisibleTextInSessionTileStrict(FCCM3560.iOSSensorsCountAndType).contains(FCCM3560.iOSSensorsCountAndType));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 139306, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,  FCCM3560.COMPLETED_SESSION_LIST_TESTS})
	public void startTimeStaticTextVisibleTest()
	{
		try 
		{
			Assert.assertEquals(sessionListPage.getElementVisibleTextInSessionTileStrict(Config.START_TIME_STATIC_TEXT), Config.START_TIME_STATIC_TEXT);
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 139307, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,  FCCM3560.COMPLETED_SESSION_LIST_TESTS})
	public void sessionStartTimeTest()
	{
		try 
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertTrue(sessionListPage.getElementVisibleTextInSessionTileStrict(FCCM3560.requiredSessionStartTimestamp).contains(FCCM3560.requiredSessionStartTimestamp)) ;
			}
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertTrue(sessionListPage.getElementVisibleTextInSessionTile(FCCM3560.requiredSessionStartTimestamp).contains(FCCM3560.requiredSessionStartTimestamp));
			}
			else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				Assert.assertTrue(ElementUtils.getElement(sessionListPage.getSessionTile(), null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_SPAN_TEXT_CONTAINS, FCCM3560.requiredSessionStartTimestamp).getText().contains(FCCM3560.requiredSessionStartTimestamp)) ;
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Parameters({"sessionStartUserName"})
	@Test(priority = 139308, groups = {})
	public void sessionStartUserNameTest(@Optional("no value") String userName)
	{
		try 
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
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 139309, groups = {"35", FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,  FCCM3560.COMPLETED_SESSION_LIST_TESTS})
	public void clickOnSessionTileTest()
	{
		try 
		{
			ElementUtils.getElement(sessionListPage.getSessionTile(), LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, FCCM3560.requiredSessionStartTimestamp, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, FCCM3560.requiredSessionStartTimestamp, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_SPAN_TEXT_CONTAINS, FCCM3560.requiredSessionStartTimestamp).click();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@AfterClass(groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,  FCCM3560.COMPLETED_SESSION_LIST_TESTS})
	public void tearDown()
	{
		Config.useExistingPageSource = false;
		IOSUtils.resetIOSPageSource();
	}
}

