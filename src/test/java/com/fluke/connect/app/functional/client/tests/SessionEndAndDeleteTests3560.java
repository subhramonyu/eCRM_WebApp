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
import com.fluke.connect.app.testdata.FCCM3560;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.FCCMUtils;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.SyncUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;

public class SessionEndAndDeleteTests3560 
{
	private GestureUtils gestureUtils;
	private SessionListPage sessionListPage;
	private Switcher switcher;
	private SessionDetailPage sessionDetailPage;
	private MeasurementsHistoryPage measurementHistoryPage;
	private CompletedSessionPage completedSessionPage;
	
	@BeforeClass(alwaysRun = true, groups = {FCCM3560.SESSION_END_TESTS, FCCM3560.SESSION_CONFIG_TESTS})
	public void initClass() throws Exception, ParseException
	{
		switcher = new Switcher();
		sessionListPage = new SessionListPage();
		gestureUtils = new GestureUtils();
		measurementHistoryPage = new MeasurementsHistoryPage();
		completedSessionPage = new CompletedSessionPage();
		sessionDetailPage = new SessionDetailPage();
		switcher.switchToSession(Switcher.ACTIVE_SESSION);
		SyncUtils.isSynced(measurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.ACTIVE_SESSIONS), switcher.getElement(Switcher.BACK_BUTTON), "Unknown", 10, 6);
		FCCM3560.sessionStartTimestampValue = FCCMUtils.getSessionVariableValue(Config.FCCM_PROPERTIES_FILE_PATH, FCCM3560.androidSessionStartTimestamp, FCCM3560.iOSSessionStartTimestamp);
		FCCM3560.requiredSessionStartTimestamp = FCCMUtils.getRequiredSessionStartTimestamp(FCCM3560.sessionStartTimestampValue, Config.ANDROID_DATE_SEPRATOR, Config.IOS_DATE_SEPRATOR, null);
		gestureUtils.scroll(Config.IOS_LOCATOR_STRATEGY_VALUE, FCCM3560.requiredSessionStartTimestamp, null, FCCM3560.requiredSessionStartTimestamp, -300, -45, null, null);
		//tap on session tile
		sessionListPage.initSessionCellElement(FCCM3560.requiredSessionStartTimestamp);
		ElementUtils.getElement(sessionListPage.getSessionTile(), LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, FCCM3560.requiredSessionStartTimestamp, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, FCCM3560.requiredSessionStartTimestamp, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_SPAN_TEXT_CONTAINS, FCCM3560.requiredSessionStartTimestamp).click();
		//just to double-ensure session detail page loaded properly
		CommonUtils.wait(5); 
		ElementUtils.isDisplayed(10, 1, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, "Sensors", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, "Sensors", LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".sessionGatewaySensorsTitle"); 
	}
	
	@Test(priority = 141701, groups = {FCCM3560.SESSION_END_TESTS, FCCM3560.SESSION_CONFIG_TESTS})
	public void sessionEndTest() throws Exception
	{
			try 
			{
				Assert.assertFalse(sessionDetailPage.isSessionEnded(FCCM3560.requiredSessionStartTimestamp));
				sessionDetailPage.reset3560Timestamp();
				sessionDetailPage.clickOnBackButton();
			}
			catch(Throwable e)
			{
				sessionDetailPage.clickOnBackButton();
				Assert.fail("Failed to delete session, exception details are "+e);
			}
	}
	
	@Test(priority = 141702, groups = {FCCM3560.SESSION_END_TESTS, FCCM3560.SESSION_CONFIG_TESTS})
	public void sessionDeleteTest() throws Exception
	{
			try 
			{
		        completedSessionPage.clickOnBackButton();
		        Assert.assertFalse(completedSessionPage.areSessionsDeleted("value", -300, -300, FCCM3560.requiredSessionStartTimestamp));
		        completedSessionPage.clickOnBackButton();
		        switcher.switchToHomePage();
			}
			catch(Throwable e)
			{
				Assert.fail("Failed to delete session, exception details are "+e);
				completedSessionPage.clickOnBackButton();
		        switcher.switchToHomePage();
			}
	}
	
}
