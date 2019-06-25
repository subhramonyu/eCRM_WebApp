package com.fluke.connect.app.functional.client.tests;

import java.text.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fluke.connect.app.functional.client.pages.CompletedSessionPage;
import com.fluke.connect.app.functional.client.pages.MeasurementsHistoryPage;
import com.fluke.connect.app.functional.client.pages.SessionDetailPage;
import com.fluke.connect.app.functional.client.pages.SessionListPage;
import com.fluke.connect.app.functional.client.pages.Switcher;
import com.fluke.connect.app.functional.client.pages.MeasurementsHistoryPage.MeasurementHistoryPageObjects;
import com.fluke.connect.app.testdata.FCCM3550;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.FCCMUtils;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.SyncUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.ScrollDiection;

public class SessionEndTests3550 
{
	private GestureUtils gestureUtils;
	private SessionListPage sessionListPage;
	private Switcher switcher;
	private SessionDetailPage sessionDetailPage;
	private MeasurementsHistoryPage measurementHistoryPage;
	private CompletedSessionPage completedSessionPage;
	
	@BeforeClass(alwaysRun = true, groups = {FCCM3550.SESSION_END_TESTS})
	public void initClass() throws Exception, ParseException
	{
		switcher = new Switcher();
		sessionListPage = new SessionListPage();
		gestureUtils = new GestureUtils();
		measurementHistoryPage = new MeasurementsHistoryPage();
		completedSessionPage = new CompletedSessionPage();
		sessionDetailPage = new SessionDetailPage();
		switcher.switchToSession(Switcher.ACTIVE_SESSION);
		CommonUtils.wait(3, 10, 3);
		SyncUtils.isSynced(measurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.ACTIVE_SESSIONS), switcher.getElement(Switcher.BACK_BUTTON), "Unknown", 10, 6);
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			FCCM3550.sessionStartTimestampValue = FCCMUtils.getSessionVariableValue(Config.FCCM_PROPERTIES_FILE_PATH, FCCM3550.androidSessionStartTimestamp, FCCM3550.iOSSessionStartTimestamp);
			FCCM3550.requiredSessionStartTimestamp = FCCMUtils.getRequiredSessionStartTimestamp(FCCM3550.sessionStartTimestampValue, Config.ANDROID_DATE_SEPRATOR, Config.IOS_DATE_SEPRATOR, null);
			gestureUtils.mScroll(FCCM3550.requiredSessionStartTimestamp, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
			//tap on session tile
			sessionListPage.initSessionCellElement(FCCM3550.requiredSessionStartTimestamp);
			ElementUtils.getElement(sessionListPage.getSessionTile(), LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, FCCM3550.requiredSessionStartTimestamp, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, FCCM3550.requiredSessionStartTimestamp, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_SPAN_TEXT_CONTAINS, FCCM3550.requiredSessionStartTimestamp).click();
			//just to double-ensure session detail page loaded properly
			CommonUtils.wait(5); 
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			sessionDetailPage.openFirstSession();
		ElementUtils.isDisplayed(10, 1, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, "Sensors", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, "Sensors", LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".sessionGatewaySensorsTitle"); 
	}
	
	@Test(priority = 130701, groups = {FCCM3550.SESSION_END_TESTS})
	public void sessionEndTest() throws Exception
	{
			try 
			{
				if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				{
					Assert.assertFalse(sessionDetailPage.isSessionEnded(FCCM3550.requiredSessionStartTimestamp));
					sessionDetailPage.reset3550Timestamp();
					sessionDetailPage.clickOnBackButton();
				}
				else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				{
					sessionDetailPage.endSession();
					sessionDetailPage.reset3550Timestamp();
					ElementUtils.click(10, null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Back", null, null);
				}
				switcher.switchToHomePage();
			}
			catch(Throwable e)
			{
				sessionDetailPage.clickOnBackButton();
				switcher.switchToHomePage();
				Assert.fail("Failed to delete session, exception details are "+e);
			}
	}
	
	@Test(priority = 130702, groups = {})
	public void sessionDeleteTest() throws Exception
	{
			try 
			{
		        //completedSessionPage.clickOnBackButton();
				if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				{
				switcher.switchToSession(Switcher.COMPLETED_SESSION);	
				Assert.assertFalse(completedSessionPage.areSessionsDeleted(FCCM3550.requiredSessionStartTimestamp));
			        completedSessionPage.clickOnBackButton();
			        switcher.switchToHomePage();
				}
				else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				{
					completedSessionPage.deleteFirstSession();
					completedSessionPage.clickOnBackButton();
			        switcher.switchToHomePage();
				}
				FCCMUtils.setSessionVariableValue(Config.FCCM_PROPERTIES_FILE_PATH, FCCM3550.androidCompletedSessionStartTimestamp, FCCM3550.iOSCompletedSessionStartTimestamp, "null");
		        
			}
			catch(Throwable e)
			{
				Assert.fail("Failed to delete session, exception details are "+e);
				completedSessionPage.clickOnBackButton();
		        switcher.switchToHomePage();
			}
	}
	
}
