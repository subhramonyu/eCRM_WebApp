/**
 * This class comprises of tests around an active session and its details like gateway name, sensor count, asset / test point
 * hierarchy, session creator, and start time stamp details.
 */

package com.fluke.connect.app.functional.client.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fluke.connect.app.functional.client.pages.AlarmPage;
import com.fluke.connect.app.functional.client.pages.NotificationsPage;
import com.fluke.connect.app.functional.client.pages.SessionDetailPage3550;
import com.fluke.connect.app.functional.client.pages.AlarmPage.AlarmPageObjectList;
import com.fluke.connect.app.functional.client.pages.SessionDetailPage.SessionDetailPageObjectList;
import com.fluke.connect.app.functional.client.pages.SessionDetailPage3550.SessionDetailPage3550ObjectList;
import com.fluke.connect.app.testdata.FCCM;
import com.fluke.connect.app.testdata.FCCM3550;
import com.fluke.connect.app.testdata.FCCM.AlarmType;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.IOSUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.ScrollDiection;

public class CompletedSessionDetailPageTests3550 
{
	private SessionDetailPage3550 sessionDetailPage3550;
	private GestureUtils gestureUtils;
	private String valueUnit;
	private int alarmCount = 0;
	private AlarmPage alarmPage;
	private NotificationsPage notificationsPage;
	private String sessionDetailPageSource;
	
	@BeforeClass(groups = {FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS, FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS})
	public void initClass()
	{
		sessionDetailPage3550 = new SessionDetailPage3550();
		gestureUtils = new GestureUtils();
		alarmPage = new AlarmPage();
		notificationsPage = new NotificationsPage();
		CommonUtils.wait(15, 15, 3);
		ElementUtils.isDisplayed(60, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, "Sensors", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, "Sensors", LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".assetNameTextSession"); //to ensure active monitoring session page is loaded properly
		Config.appWidthCenterFlag = false;
		Config.useExistingPageSource = true;
		sessionDetailPageSource = DriverManager.getDriver().getPageSource();
		Config.iOSPageSource = sessionDetailPageSource;
	}
	
	
	@Test(priority = 128501, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void gateWayNameTest()
	{
		Assert.assertEquals(sessionDetailPage3550.getElementVisibleTextInSessionTileStrict(FCCM3550.gatewayNameValue), FCCM3550.gatewayNameValue);
		
	}
	
	@Test(priority = 128502, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void sensorsStaticTextVisibleTest()
	{
		Assert.assertEquals(sessionDetailPage3550.getElementVisibleTextInSessionTileStrict(Config.SENSORS_STATIC_TEXT), Config.SENSORS_STATIC_TEXT);
	}
	
	@Test(priority = 128503, groups = { FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void sensorCountAndTypeTest()
	{
		try 
		{
			Assert.assertEquals(sessionDetailPage3550.getElementVisibleTextInSessionTileStrict(FCCM3550.sensorsCountAndType), FCCM3550.sensorsCountAndType);
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 128504, groups = {FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void startTimeStaticTextVisibleTest()
	{
		try 
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertEquals(sessionDetailPage3550.getElementVisibleTextInSessionTileStrict(Config.START_TIME_STATIC_TEXT), Config.START_TIME_STATIC_TEXT);
			}
			else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "#new_design1").getText().contains(Config.START_STATIC_TEXT));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 128505, groups = {})
	public void sessionStartTimeTest()
	{
		try 
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertTrue(sessionDetailPage3550.getElementVisibleTextInSessionTile(FCCM3550.requiredSessionStartTimestamp).contains(FCCM3550.requiredSessionStartTimestamp));
			}
			else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "#new_design1").getText().startsWith(FCCM3550.requiredSessionStartTimestamp));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	} 
	
	@Test(priority = 128506, groups = {})
	public void sessionStartUserNameTest()
	{
		try 
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertTrue(sessionDetailPage3550.getElementVisibleTextInSessionTile(FCCM3550.sessionStartUserName).contains(FCCM3550.sessionStartUserName));
			}
			/*else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertTrue(
						sessionDetailPage3550.getElementVisibleTextInSessionTile(FCCM3550.requiredSessionStartTimestamp)
								.contains(FCCM3550.sessionStartUserName));
						}*/
			else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "#new_design1").getText().contains(FCCM3550.sessionStartUserName));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Incorrect session start user name, Exception Detail: "+e);
		}
	} 
	
	@Test(priority = 128507, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void assetCountTextVisibleTest()
	{
		try 
		{
			Assert.assertTrue(sessionDetailPage3550.getElementInSessionTileStrict(Config.ASSET_STATIC_TEXT+" (1)").isDisplayed());
		}
		catch(Throwable e)
		{
			Assert.fail("Incorrect asset cout, Exception Detail: "+e);
		}
	}
	

	@Test(priority = 128508, groups = {  FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})//FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
	public void assetGroupNameTest()
	{
		try 
			{
				if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				{
					Assert.assertEquals(sessionDetailPage3550.getElementVisibleTextInSessionTileStrict(FCCM3550.assetGroupName), FCCM3550.assetGroupName);
				}
				else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				{
					Assert.assertEquals(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".crumbTrailAssetGroupInfo").getText(), FCCM3550.assetGroupName);
				}
			}
			catch(Throwable e)
			{
				Assert.fail("Incorrect asset group name, Exception Detail: "+e);
			}
	}
	
	@Test(priority = 128509, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void assetNameTest()
	{
		try 
			{

				if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				{
					Assert.assertEquals(sessionDetailPage3550.getElementVisibleTextInSessionTileStrict(FCCM3550.assetName), FCCM3550.assetName);
				}
				else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				{
					Assert.assertEquals(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".crumbTrailAssetName").getText(), FCCM3550.assetName);
				}				
			}
			catch(Throwable e)
			{
				Assert.fail("Incorrect asset name, Exception Detail: "+e);
			}
	}
	
	@Test(priority = 128510, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void testPointNameTest()
	{
		try 
			{
				if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				{
					Assert.assertEquals(sessionDetailPage3550.getElementVisibleTextInSessionTileStrict(FCCM3550.testPointName), FCCM3550.testPointName);
				}
				else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				{
					Assert.assertEquals(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".assetNameTextSession").getText(), FCCM3550.testPointName);
				}					
			}
			catch(Throwable e)
			{
				Assert.fail("Incorrect test point details, Exception Detail: "+e);
			}
	} 
	
	@Test(priority = 128515, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS})
	public void alarmIconTest()
	{
		try
		{
			List<WebElement> alarmIcons = sessionDetailPage3550.getSessionDetailPageObjects(SessionDetailPageObjectList.ALARM_ICONS);
			for(WebElement alarmIcon:alarmIcons)
			{
				Assert.assertTrue(alarmIcon.isDisplayed());
			}
		}
		catch(Throwable e) 
		{
			Assert.fail("Min value time is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 128516, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS})
	public void alertIconTest()
	{
		try
		{
			List<WebElement> alertIcons = sessionDetailPage3550.getSessionDetailPageObjects(SessionDetailPageObjectList.ALERT_ICONS);
			for(WebElement alertIcon:alertIcons)
			{
				if(alertIcon.isDisplayed())
					break;
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Min value time is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 128517, groups = {})
	public void belowThresholdAlarmSessionNotificationTest() throws Exception
	{
		try
		{
			sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.MORE_OPTIONS_BUTTON).click();
			sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.VIEW_SESSION_ACTIVITY).click();
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT, FCCM3550.AlarmText3550.WEB_SESSION_BELOW.getText()).isDisplayed());
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				CommonUtils.wait(2);
				Config.appWidthCenterFlag = true;
				if(!IOSUtils.isPageLoaded(LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_BEGINSWITH, "Loading...", 60))
					throw new Exception();
				IOSUtils.setIOSPageSource();
				Assert.assertTrue(notificationsPage.isNotificationDisplayed(FCCM3550.AlarmText3550.IOS_SESSION_BELOW.getText(), FCCM3550.AlarmText3550.IOS_SESSION_ABOVE.getText(), FCCM3550.AlarmText3550.IOS_SESSION_WITHIN.getText(), FCCM3550.AlarmText3550.IOS_SESSION_OUT.getText()));
				sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
				IOSUtils.resetIOSPageSource();
				Config.iOSPageSource = sessionDetailPageSource;
			}
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Config.appWidthCenterFlag = true;
				Assert.assertTrue(notificationsPage.isNotificationDisplayed(FCCM3550.AlarmText3550.IOS_SESSION_BELOW.getText()));
				sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
			}
		}
		catch(Throwable e)
		{
			sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Config.iOSPageSource = "";
				Config.iOSPageSource = sessionDetailPageSource;
			}
			Assert.fail("Exception details are: "+e);
		}
	}
	
	@Test(priority = 128518, groups = {}, dependsOnMethods = {"belowThresholdAlarmSessionNotificationTest"})
	public void aboveThresholdAlarmSessionNotificationTest() throws Exception
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT, FCCM3550.AlarmText3550.WEB_SESSION_ABOVE.getText()).isDisplayed());
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.MORE_OPTIONS_BUTTON).click();
				sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.VIEW_SESSION_ACTIVITY).click();
				Assert.assertTrue(notificationsPage.isNotificationDisplayed(FCCM3550.AlarmText3550.IOS_SESSION_ABOVE.getText()));
				sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
			}
		}
		catch(Throwable e)
		{
			sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
			Assert.fail("Min value time is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 128519, groups = {}, dependsOnMethods = {"belowThresholdAlarmSessionNotificationTest"})
	public void withinThresholdAlarmSessionNotificationTest() throws Exception
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT, FCCM3550.AlarmText3550.WEB_SESSION_WITHIN.getText()).isDisplayed());
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.MORE_OPTIONS_BUTTON).click();
				sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.VIEW_SESSION_ACTIVITY).click();
				Assert.assertTrue(notificationsPage.isNotificationDisplayed(FCCM3550.AlarmText3550.IOS_SESSION_WITHIN.getText()));
				sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
			}
		}
		catch(Throwable e)
		{
			sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
			Assert.fail("Min value time is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 128520, groups = {}, dependsOnMethods = {"belowThresholdAlarmSessionNotificationTest"})
	public void outOfThresholdAlarmSessionNotificationTest() throws Exception
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT, FCCM3550.AlarmText3550.WEB_SESSION_OUT.getText()).isDisplayed());
				sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_DONE_BUTTON).click();
			}
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.MORE_OPTIONS_BUTTON).click();
				sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.VIEW_SESSION_ACTIVITY).click();
				Assert.assertTrue(notificationsPage.isNotificationDisplayed(FCCM3550.AlarmText3550.IOS_SESSION_OUT.getText()));
				sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
				Config.appWidthCenterFlag = false;
			}
		}
		catch(Throwable e)
		{
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_DONE_BUTTON).click();
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Config.appWidthCenterFlag = false;
				sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
			}
			Assert.fail();
		}
	}
	
	@Test(priority = 128521, groups = {})
	public void mainImageMobileTest()
	{
		try
		{
			gestureUtils.mScroll(-100, -100, 4);
			Assert.assertTrue(ElementUtils.isDisplayed(10, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "vl_image", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, "options white", LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "div[id='ti-download-image0'][style='display: block;']"));
		}
		catch(Throwable e)
		{
			Assert.fail("Min value time is not correct, exception details are: "+e);
		}
	}

	@Test(priority = 128580, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void tempratureUnitTest()
	{
		try
		{
			gestureUtils.mScroll("Show", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
			System.out.println(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.TEMPRATURE_UNIT).getText());
			System.out.println(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.TEMPRATURE_UNIT).getText().contains(FCCM3550.tempratureUnitFahrenheitAndroid));
			Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.TEMPRATURE_UNIT).getText().contains(FCCM3550.tempratureUnitFahrenheit) || sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.TEMPRATURE_UNIT).getText().contains(FCCM3550.tempratureUnitFahrenheitAndroid));
		}
		catch(Throwable e)
		{
			Assert.fail();
		}
	} 
	
	@Test(priority = 128581, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void graphDisplayedTest()
	{
		try
		{
				if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				{
					Assert.assertTrue(sessionDetailPage3550.isGraphDisplayed(Config.IOS_LOCATOR_STRATEGY_NAME, FCCM.GRAPH_1H_TAB, -300, -60, 10, -70));
				}
				else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				{
					Assert.assertTrue(sessionDetailPage3550.isGraphDisplayed(null));
				}	
		}
		catch(Throwable e)
		{
			Assert.fail("No graph object for sensor, exception details are: "+e);
		}
	}
	
	
	
	@Test(priority = 128582, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void maxLabelIn1HTabTest()
	{
		try
		{
			gestureUtils.mScroll("Show", FCCM3550.mobileMaxLabel, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertTrue(sessionDetailPage3550.getElementInSessionTileStrict(FCCM3550.mobileMaxLabel).isDisplayed());
			}
			else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".maxPosition .sessionValueTitle").getText().equals(FCCM3550.webMaxLabel));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("MAX label is not displayed, exception details are: "+e);
		}
	}
	
	@Test(priority = 128583, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void minLabelIn1HTabTest()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertTrue(sessionDetailPage3550.getElementInSessionTileStrict(FCCM3550.mobileMaxLabel).isDisplayed());
			}
			else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".minPosition .sessionValueTitle").getText().equals(FCCM3550.webMinLabel));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("MIN label is not displayed, exception details are: "+e);
		}
	}
	
	@Test(priority = 128584, groups = {})
	public void livePollingTest()
	{
			try 
			{
				sessionDetailPage3550.scrollToGraphTab("1H", ScrollDiection.UP);
				//Assert.assertTrue(sessionDetailPage3560.isLivePollingHappening("./graph/bp", "./graph/ap", "./graph/dp", ".png", iterationValue, 5, 60, Config.IOS_LOCATOR_STRATEGY_NAME, FCCM3560.vibrationUnit, -300, -45, 10, -150, -45));
			}
		    catch(Throwable e)
			{
				Assert.fail("No live polling is happening on sensor, exception details are: "+e);
			} 
	}
	
	@Test(priority = 128801, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void liveValueTest()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE).getText().contains("--"));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value is coming as stale, exception details are: "+e);
		}
	}
	
	@Test(priority = 128802, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void liveValueUnitTest()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE_UNIT).getText();
				System.out.println(valueUnit);
				System.out.println(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid));
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value unit is incorrect, exception details are: "+e);
		}
	}
	
	@Test(priority = 128803, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void maxValueTest()
	{
		try
		{
			Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE).getText().contains("--"));
		}
		catch(Throwable e)
		{
			Assert.fail("Max value is coming as stale, exception details are: "+e);
		}
	}
	
	@Test(priority = 128804, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void maxValueUnitTest()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE).getText();
				
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE_UNIT).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value unit is incorrect, exception details are: "+e);
		}
	}
	
	@Test(priority = 128805, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void maxValueTimeTest()
	{
		try
		{
			Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE_TIME).getText().contains(":"));
		}
		catch(Throwable e)
		{
			Assert.fail("Max value unit is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 128806, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void minValueTest()
	{
		try
		{
			Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE).getText().contains("--"));
		}
		catch(Throwable e)
		{
			Assert.fail("Min value is coming as stale, exception details are: "+e);
		}
	}
	
	@Test(priority = 128807, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void minValueUnitTest()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE_UNIT).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value unit is incorrect, exception details are: "+e);
		}
	}
	
	@Test(priority = 128808, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void minValueTimeTest()
	{
		try
		{
			Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE_TIME).getText().contains(":"));
		}
		catch(Throwable e)
		{
			Assert.fail("Min value time is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 128809, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS})
	public void mainImageTest()
	{
		try
		{
			Assert.assertTrue(ElementUtils.isDisplayed(10, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "div[id='ti-download-image0'][style='display: block;']"));
		}
		catch(Throwable e)
		{
			Assert.fail("Min value time is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 128810, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS})
	public void sliderImageTest()
	{
		try
		{
			Assert.assertTrue(ElementUtils.isDisplayed(10, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "img[data-event='click:changeimages']"));
		}
		catch(Throwable e)
		{
			Assert.fail("Min value time is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 128900, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void switchTo1DTabTest()
	{
		try
		{
			sessionDetailPage3550.switchToOtherTab("1D", ScrollDiection.UP);
			gestureUtils.mScroll("Show", FCCM3550.mobileMaxLabel, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		}
		catch(Throwable e)
		{
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor exception details are: "+e);
		}
	}
	
	@Test(priority = 128901, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void liveValueTest1DTab()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE).getText().contains("--"));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value is coming as stale, exception details are: "+e);
		}
	}
	
	@Test(priority = 128902, groups = {FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void liveValueUnitTest1DTab()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE_UNIT).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value unit is incorrect, exception details are: "+e);
		}
	}
	
	@Test(priority = 128903, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void maxValueTest1DTab()
	{
		try
		{
			Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE).getText().contains("--"));
		}
		catch(Throwable e)
		{
			Assert.fail("Max value is coming as stale, exception details are: "+e);
		}
	}
	
	@Test(priority = 128904, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void maxValueUnitTest1DTab()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE_UNIT).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value unit is incorrect, exception details are: "+e);
		}
	}
	
	@Test(priority = 128905, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void maxValueTimeTest1DTab()
	{
		try
		{
			Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE_TIME).getText().contains(":"));
		}
		catch(Throwable e)
		{
			Assert.fail("Max value unit is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 128906, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void minValueTest1DTab()
	{
		try
		{
			Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE).getText().contains("--"));
		}
		catch(Throwable e)
		{
			Assert.fail("Min value is coming as stale, exception details are: "+e);
		}
	}
	
	@Test(priority = 128907, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void minValueUnitTest1DTab()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE_UNIT).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value unit is incorrect, exception details are: "+e);
		}
	}
	
	@Test(priority = 128908, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void minValueTimeTest1DTab()
	{
		try
		{
			Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE_TIME).getText().contains(":"));
		}
		catch(Throwable e)
		{
			Assert.fail("Min value time is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 128909, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS})
	public void mainImage1DTest()
	{
		try
		{
			Assert.assertTrue(ElementUtils.isDisplayed(10, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "div[id='ti-download-image0'][style='display: block;']"));
		}
		catch(Throwable e)
		{
			Assert.fail("Min value time is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 128910, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS})
	public void sliderImage1DTest()
	{
		try
		{
			Assert.assertTrue(ElementUtils.isDisplayed(10, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "img[data-event='click:changeimages']"));
		}
		catch(Throwable e)
		{
			Assert.fail("Min value time is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 129000, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void switchTo1WTabTest()
	{
		try
		{
			sessionDetailPage3550.switchToOtherTab("1W", ScrollDiection.UP);
			gestureUtils.mScroll("Show", FCCM3550.mobileMaxLabel, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		}
		catch(Throwable e)
		{
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor exception details are: "+e);
		}
	}
	
	@Test(priority = 129001, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void liveValueTest1WTab()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE).getText().contains("--"));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value is coming as stale, exception details are: "+e);
		}
	}
	
	@Test(priority = 129002, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void liveValueUnitTest1WTab()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE_UNIT).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value unit is incorrect, exception details are: "+e);
		}
	}
	
	@Test(priority = 129003, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void maxValueTest1WTab()
	{
		try
		{
			Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE).getText().contains("--"));
		}
		catch(Throwable e)
		{
			Assert.fail("Max value is coming as stale, exception details are: "+e);
		}
	}
	
	@Test(priority = 129004, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void maxValueUnitTest1WTab()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE_UNIT).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value unit is incorrect, exception details are: "+e);
		}
	}
	
	@Test(priority = 129005, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void maxValueTimeTest1WTab()
	{
		try
		{
			Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE_TIME).getText().contains(":"));
		}
		catch(Throwable e)
		{
			Assert.fail("Max value unit is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 129006, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void minValueTest1WTab()
	{
		try
		{
			Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE).getText().contains("--"));
		}
		catch(Throwable e)
		{
			Assert.fail("Min value is coming as stale, exception details are: "+e);
		}
	}
	
	@Test(priority = 129007, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void minValueUnitTest1WTab()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE_UNIT).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value unit is incorrect, exception details are: "+e);
		}
	}
	
	@Test(priority = 129008, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void minValueTimeTest1WTab()
	{
		try
		{
			Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE_TIME).getText().contains(":"));
		}
		catch(Throwable e)
		{
			Assert.fail("Min value time is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 129009, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS})
	public void mainImage1WTest()
	{
		try
		{
			Assert.assertTrue(ElementUtils.isDisplayed(10, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "div[id='ti-download-image0'][style='display: block;']"));
		}
		catch(Throwable e)
		{
			Assert.fail("Min value time is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 129010, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS})
	public void sliderImage1WTest()
	{
		try
		{
			Assert.assertTrue(ElementUtils.isDisplayed(10, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "img[data-event='click:changeimages']"));
		}
		catch(Throwable e)
		{
			Assert.fail("Min value time is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 129100, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void switchTo1MTabTest()
	{
		try
		{
			sessionDetailPage3550.switchToOtherTab("1M", ScrollDiection.UP);
			gestureUtils.mScroll("Show", FCCM3550.mobileMaxLabel, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		}
		catch(Throwable e)
		{
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor exception details are: "+e);
		}
	}
	
	@Test(priority = 129101, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void liveValueTest1MTab()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE).getText().contains("--"));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value is coming as stale, exception details are: "+e);
		}
	}
	
	@Test(priority = 129102, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void liveValueUnitTest1MTab()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE_UNIT).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value unit is incorrect, exception details are: "+e);
		}
	}
	
	@Test(priority = 129103, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void maxValueTest1MTab()
	{
		try
		{
			Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE).getText().contains("--"));
		}
		catch(Throwable e)
		{
			Assert.fail("Max value is coming as stale, exception details are: "+e);
		}
	}
	
	@Test(priority = 129104, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void maxValueUnitTest1MTab()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE_UNIT).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value unit is incorrect, exception details are: "+e);
		}
	}
	
	@Test(priority = 129105, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void maxValueTimeTest1MTab()
	{
		try
		{
			Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE_TIME).getText().contains(":"));
		}
		catch(Throwable e)
		{
			Assert.fail("Max value unit is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 129106, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void minValueTest1MTab()
	{
		try
		{
			Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE).getText().contains("--"));
		}
		catch(Throwable e)
		{
			Assert.fail("Min value is coming as stale, exception details are: "+e);
		}
	}
	
	@Test(priority = 129107, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void minValueUnitTest1MTab()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE_UNIT).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value unit is incorrect, exception details are: "+e);
		}
	}
	
	@Test(priority = 129108, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void minValueTimeTest1MTab()
	{
		try
		{
			Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE_TIME).getText().contains(":"));
		}
		catch(Throwable e)
		{
			Assert.fail("Min value time is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 129109, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS})
	public void mainImage1MTest()
	{
		try
		{
			//Assert.assertTrue(ElementUtils.isDisplayed(10, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "div[id='ti-download-image0'][style='display: block;']"));
		}
		catch(Throwable e)
		{
			Assert.fail("Min value time is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 129110, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS})
	public void sliderImage1MTest()
	{
		try
		{
			Assert.assertTrue(ElementUtils.isDisplayed(10, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "img[data-event='click:changeimages']"));
		}
		catch(Throwable e)
		{
			Assert.fail("Min value time is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 129200, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void switchToALLTabTest()
	{
		try
		{
			sessionDetailPage3550.switchToOtherTab("ALL3550", ScrollDiection.UP);
			gestureUtils.mScroll("Show", FCCM3550.mobileMaxLabel, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		}
		catch(Throwable e)
		{
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor exception details are: "+e);
		}
	}
	
	@Test(priority = 129201, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void liveValueTestALLTab()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE).getText().contains("--"));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value is coming as stale, exception details are: "+e);
		}
	}
	
	@Test(priority = 129202, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void liveValueUnitTestALLTab()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE_UNIT).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value unit is incorrect, exception details are: "+e);
		}
	}
	
	@Test(priority = 129203, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void maxValueTestALLTab()
	{
		try
		{
			Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE).getText().contains("--"));
		}
		catch(Throwable e)
		{
			Assert.fail("Max value is coming as stale, exception details are: "+e);
		}
	}
	
	@Test(priority = 129204, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void maxValueUnitTestALLTab()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE_UNIT).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value unit is incorrect, exception details are: "+e);
		}
	}
	
	@Test(priority = 129205, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void maxValueTimeTestALLTab()
	{
		try
		{
			Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE_TIME).getText().contains(":"));
		}
		catch(Throwable e)
		{
			Assert.fail("Max value unit is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 129206, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void minValueTestALLTab()
	{
		try
		{
			Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE).getText().contains("--"));
		}
		catch(Throwable e)
		{
			Assert.fail("Min value is coming as stale, exception details are: "+e);
		}
	}
	
	@Test(priority = 129207, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void minValueUnitTestALLTab()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE_UNIT).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value unit is incorrect, exception details are: "+e);
		}
	}
	
	@Test(priority = 129208, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void minValueTimeTestALLTab()
	{
		try
		{
			Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE_TIME).getText().contains(":"));
		}
		catch(Throwable e)
		{
			Assert.fail("Min value time is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 129209, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS})
	public void mainImageAllTest()
	{
		try
		{
			Assert.assertTrue(ElementUtils.isDisplayed(10, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "div[id='ti-download-image0'][style='display: block;']"));
		}
		catch(Throwable e)
		{
			Assert.fail("Min value time is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 129210, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS})
	public void sliderImageAllTest()
	{
		try
		{
			Assert.assertTrue(ElementUtils.isDisplayed(10, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "img[data-event='click:changeimages']"));
		}
		catch(Throwable e)
		{
			Assert.fail("Min value time is not correct, exception details are: "+e);
		}
	}
	
	
	@Test(priority = 129211, groups = {})
	public void addAlarmTest()
	{
		try
		{
			alarmCount = 0;
			alarmPage.getAlarmPageObject(AlarmPageObjectList.ADD_EDIT_ALARM_MENU).click();
			alarmPage.getAlarmPageObject(AlarmPageObjectList.ADD_EDIT_ALARM_BUTTON).click();
			CommonUtils.wait(1);
			alarmCount = alarmPage.getElementsAlarmPage(AlarmPageObjectList.ALARM_COUNT).size();
			alarmPage.getAlarmPageObject(AlarmPageObjectList.ADD_ALARM).click();
		//	alarmPage.addAlarm(AlarmType.WITHIN_TEMPERATURE, "F", 995, 555, ScrollDiection.NEXT, 1);
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				alarmPage.getAlarmPageObject(AlarmPageObjectList.ADD_EDIT_ALARM_MENU).click();
				alarmPage.getAlarmPageObject(AlarmPageObjectList.ADD_EDIT_ALARM_BUTTON).click();
			}
			Assert.assertEquals(alarmPage.getElementsAlarmPage(AlarmPageObjectList.ALARM_COUNT).size(),  alarmCount + 1);
		}
		catch(Throwable e)
		{
			Assert.fail("Alarm is not added: "+e);
		}
	}
	
	@Test(priority = 129212, groups = {})
	public void editAlarmTest()
	{
		try
		{
			//alarmPage.editAlarm(AlarmType.WITHIN, "C", "900", 500, ScrollDiection.NEXT);
		}
		catch(Throwable e)
		{
			Assert.fail("Alarm is not edited: "+e);
		}
	}
	
	@Test(priority = 129213, groups = {})
	public void deleteAlarmTest()
	{
		try
		{
			alarmCount = 0;
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				alarmPage.getAlarmPageObject(AlarmPageObjectList.ADD_EDIT_ALARM_MENU).click();
				alarmPage.getAlarmPageObject(AlarmPageObjectList.ADD_EDIT_ALARM_BUTTON).click();
			}
			alarmCount = alarmPage.getElementsAlarmPage(AlarmPageObjectList.ALARM_COUNT).size();
			//alarmPage.deleteAlarm(AlarmType.WITHIN);
			/*if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				alarmPage.getElementAlarmPage(AlarmPageObjectList.ADD_EDIT_ALARM_MENU).click();
				alarmPage.getElementAlarmPage(AlarmPageObjectList.ADD_EDIT_ALARM_BUTTON).click();
			}
			Assert.assertEquals(alarmPage.getElementsAlarmPage(AlarmPageObjectList.ALARM_COUNT).size(),  alarmCount - 1);		*/
			
		}
		catch(Throwable e)
		{
			Assert.fail("Alarm is not deleted: "+e);
		}
	}
	
	@Test(priority = 129250, groups = {})
	public void belowThresholdAlarmNotificationTest()
	{
		try
		{
			gestureUtils.webScroll(ScrollDiection.UP, 1);
			sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.SENSOR_ALARM_COUNT).click();
			Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, FCCM3550.AlarmText3550.WEB_NOTIFICATION_BELOW.getText()).isDisplayed());
		}
		catch(Throwable e)
		{
			Assert.fail("Min value time is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 129251, groups = {})
	public void aboveThresholdAlarmNotificationTest()
	{
		try
		{
			Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, FCCM3550.AlarmText3550.WEB_NOTIFICATION_ABOVE.getText()).isDisplayed());
		}
		catch(Throwable e)
		{
			Assert.fail("Min value time is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 129252, groups = {})
	public void withinThresholdAlarmNotificationTest()
	{
		try
		{
			Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, FCCM3550.AlarmText3550.WEB_NOTIFICATION_WITHIN.getText()).isDisplayed());
		}
		catch(Throwable e)
		{
			Assert.fail("Min value time is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 129253, groups = {})
	public void outOfThresholdAlarmNotificationTest()
	{
		try
		{
			Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, FCCM3550.AlarmText3550.WEB_NOTIFICATION_OUT.getText()).isDisplayed());
		}
		catch(Throwable e)
		{
			Assert.fail("Min value time is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 129254, groups = {FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS})
	public void belowThresholdAlarmSessionNotificationTestWeb() throws Exception
	{
		try
		{
			gestureUtils.webScroll(ScrollDiection.UP, 3);
			sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.MORE_OPTIONS_BUTTON).click();
			sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.VIEW_SESSION_ACTIVITY).click();
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT, FCCM3550.AlarmText3550.WEB_SESSION_BELOW.getText()).isDisplayed());
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				CommonUtils.wait(2, 5, 1);
				Config.appWidthCenterFlag = true;
				if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				{
					Config.iOSPageSource = "";
					Config.iOSPageSource = DriverManager.getDriver().getPageSource();
					Config.useExistingPageSource = true;
				}
				Assert.assertTrue(notificationsPage.isNotificationDisplayed(FCCM3550.AlarmText3550.IOS_SESSION_BELOW.getText()));
				sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
			}
		}
		catch(Throwable e)
		{
			sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
			Assert.fail("Exception details are: "+e);
		}
	}
	
	@Test(priority = 129255, groups = {FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS})
	public void aboveThresholdAlarmSessionNotificationTestWeb() throws Exception
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT, FCCM3550.AlarmText3550.WEB_SESSION_ABOVE.getText()).isDisplayed());
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.MORE_OPTIONS_BUTTON).click();
				sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.VIEW_SESSION_ACTIVITY).click();
				CommonUtils.wait(2, 5, 1);
				Assert.assertTrue(notificationsPage.isNotificationDisplayed(FCCM3550.AlarmText3550.IOS_SESSION_ABOVE.getText()));
				sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
			}
		}
		catch(Throwable e)
		{
			sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
			Assert.fail("Min value time is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 129256, groups = { FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS})
	public void withinThresholdAlarmSessionNotificationTestWeb() throws Exception
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
				Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT, FCCM3550.AlarmText3550.WEB_SESSION_WITHIN.getText()).isDisplayed());
				sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_DONE_BUTTON).click(); 
				DriverManager.getGestureUtils().webScroll(ScrollDiection.UP, 2);
				sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.BACK_BUTTON).click(); 
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.MORE_OPTIONS_BUTTON).click();
				sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.VIEW_SESSION_ACTIVITY).click();
				CommonUtils.wait(2, 5, 1);
				Assert.assertTrue(notificationsPage.isNotificationDisplayed(FCCM3550.AlarmText3550.IOS_SESSION_WITHIN.getText()));
				sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
			}
		}
		catch(Throwable e)
		{
			sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_DONE_BUTTON).click(); 
			DriverManager.getGestureUtils().webScroll(ScrollDiection.UP, 2);
			sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
			Assert.fail("Min value time is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 129257, groups = {})
	public void outOfThresholdAlarmSessionNotificationTestWeb() throws Exception
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT, FCCM3550.AlarmText3550.WEB_SESSION_OUT.getText()).isDisplayed());
				sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_DONE_BUTTON).click();
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.MORE_OPTIONS_BUTTON).click();
				sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.VIEW_SESSION_ACTIVITY).click();
				CommonUtils.wait(2, 5, 1);
				Assert.assertTrue(notificationsPage.isNotificationDisplayed(FCCM3550.AlarmText3550.IOS_SESSION_OUT.getText()));
				sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
				if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				{
					Config.iOSPageSource = "";
					Config.iOSPageSource = sessionDetailPageSource;
				}
				Config.appWidthCenterFlag = false;
			}
		}
		catch(Throwable e)
		{
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_DONE_BUTTON).click();
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				{
					Config.iOSPageSource = "";
					Config.iOSPageSource = sessionDetailPageSource;
				}
				Config.appWidthCenterFlag = false;
				sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
			}
			Assert.fail("Min value time is not correct, exception details are: "+e);
		}
	}
	
	
	@Test(priority = 129300, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void clickOnViewMoreTest()
	{
		try
		{
			gestureUtils.mScroll("View More", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.UP);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "View More", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, "View More", null, null).click();
		}
		catch(Throwable e)
		{
			Assert.fail("MAX label is not displayed, exception details are: "+e);
		}
	}
	
	@Test(priority = 129301, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void maxLabelInViewMore1HTabTest()
	{
		try
		{
			CommonUtils.wait(3, 5, 0);
			IOSUtils.resetIOSPageSource();
			IOSUtils.setIOSPageSource();
			gestureUtils.mScroll("Show", FCCM3550.mobileMaxLabel, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				Assert.assertTrue(sessionDetailPage3550.getElementInSessionTileStrict(FCCM3550.mobileMaxLabel).isDisplayed());
		}
		catch(Throwable e)
		{
			Assert.fail("MAX label is not displayed, exception details are: "+e);
		}
	}
	
	@Test(priority = 129302, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void minLabelInViewMore1HTabTest()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertTrue(sessionDetailPage3550.getElementInSessionTileStrict(FCCM3550.mobileMaxLabel).isDisplayed());
			}
		}
		catch(Throwable e)
		{
			Assert.fail("MIN label is not displayed, exception details are: "+e);
		}
	}
	
	@Test(priority = 129303, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void liveValueTestInViewMore1HTab()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE).getText().contains("--"));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value is coming as stale, exception details are: "+e);
		}
	}
	
	@Test(priority = 129304, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void liveValueUnitTestInViewMore()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE_UNIT).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value unit is incorrect, exception details are: "+e);
		}
	}
	
	@Test(priority = 129305, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void maxValueTestInViewMore1HTab()
	{
		try
		{
			Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE).getText().contains("--"));
		}
		catch(Throwable e)
		{
			Assert.fail("Max value is coming as stale, exception details are: "+e);
		}
	}
	
	@Test(priority = 129306, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void maxValueUnitTestInViewMore1HTab()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE_UNIT).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value unit is incorrect, exception details are: "+e);
		}
	}
	
	@Test(priority = 129307, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void maxValueTimeTestInViewMore1Htab()
	{
		try
		{
			Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE_TIME).getText().contains(":"));
		}
		catch(Throwable e)
		{
			Assert.fail("Max value unit is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 129308, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void minValueTestInViewMore1HTab()
	{
		try
		{
			Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE).getText().contains("--"));
		}
		catch(Throwable e)
		{
			Assert.fail("Min value is coming as stale, exception details are: "+e);
		}
	}
	
	@Test(priority = 129309, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void minValueUnitTestInViewMore1Htab()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE_UNIT).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value unit is incorrect, exception details are: "+e);
		}
	}
	
	@Test(priority = 129310, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void minValueTimeTestInViewMore1Htab()
	{
		try
		{
			Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE_TIME).getText().contains(":"));
		}
		catch(Throwable e)
		{
			Assert.fail("Min value time is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 129350, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void switchTo1DTabTestInViewMore()
	{
		try
		{
			sessionDetailPage3550.switchToOtherTab("1D", ScrollDiection.UP);
			gestureUtils.mScroll("Show", FCCM3550.mobileMaxLabel, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		}
		catch(Throwable e)
		{
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor exception details are: "+e);
		}
	}
	
	@Test(priority = 129351, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void liveValueTestInViewMore1DTab()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE).getText().contains("--"));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value is coming as stale, exception details are: "+e);
		}
	}
	
	@Test(priority = 129352, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void liveValueUnitTest1DTabInViewMore()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE_UNIT).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value unit is incorrect, exception details are: "+e);
		}
	}
	
	@Test(priority = 129353, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void maxValueTest1DTabInViewMore()
	{
		try
		{
			Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE).getText().contains("--"));
		}
		catch(Throwable e)
		{
			Assert.fail("Max value is coming as stale, exception details are: "+e);
		}
	}
	
	@Test(priority = 129354, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void maxValueUnitTest1DTabInViewMore()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE_UNIT).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value unit is incorrect, exception details are: "+e);
		}
	}
	
	@Test(priority = 129355, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void maxValueTimeTest1DTabInViewMore()
	{
		try
		{
			Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE_TIME).getText().contains(":"));
		}
		catch(Throwable e)
		{
			Assert.fail("Max value unit is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 129356, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void minValueTest1DTabInViewMore()
	{
		try
		{
			Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE).getText().contains("--"));
		}
		catch(Throwable e)
		{
			Assert.fail("Min value is coming as stale, exception details are: "+e);
		}
	}
	
	@Test(priority = 129357, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void minValueUnitTest1DTabInViewMore()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE_UNIT).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value unit is incorrect, exception details are: "+e);
		}
	}
	
	@Test(priority = 129358, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void minValueTimeTest1DTabInViewMore()
	{
		try
		{
			Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE_TIME).getText().contains(":"));
		}
		catch(Throwable e)
		{
			Assert.fail("Min value time is not correct, exception details are: "+e);
		}
	}
	
	
	
	@Test(priority = 129400, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void switchTo1WTabTestInViewMore()
	{
		try
		{
			sessionDetailPage3550.switchToOtherTab("1W", ScrollDiection.UP);
			gestureUtils.mScroll("Show", FCCM3550.mobileMaxLabel, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		}
		catch(Throwable e)
		{
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor exception details are: "+e);
		}
	}
	
	@Test(priority = 129401, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void liveValueTest1WTabInViewMore()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE).getText().contains("--"));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value is coming as stale, exception details are: "+e);
		}
	}
	
	@Test(priority = 129402, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void liveValueUnitTest1WTabInViewMore()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE_UNIT).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value unit is incorrect, exception details are: "+e);
		}
	}
	
	@Test(priority = 129403, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void maxValueTest1WTabInViewMore()
	{
		try
		{
			Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE).getText().contains("--"));
		}
		catch(Throwable e)
		{
			Assert.fail("Max value is coming as stale, exception details are: "+e);
		}
	}
	
	@Test(priority = 129404, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void maxValueUnitTest1WTabInViewMore()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE_UNIT).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value unit is incorrect, exception details are: "+e);
		}
	}
	
	@Test(priority = 129405, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void maxValueTimeTest1WTabInViewMore()
	{
		try
		{
			Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE_TIME).getText().contains(":"));
		}
		catch(Throwable e)
		{
			Assert.fail("Max value unit is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 129406, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void minValueTest1WTabInViewMore()
	{
		try
		{
			Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE).getText().contains("--"));
		}
		catch(Throwable e)
		{
			Assert.fail("Min value is coming as stale, exception details are: "+e);
		}
	}
	
	@Test(priority = 129407, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void minValueUnitTest1WTabInViewMore()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE_UNIT).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value unit is incorrect, exception details are: "+e);
		}
	}
	
	@Test(priority = 129408, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void minValueTimeTest1WTabInViewMore()
	{
		try
		{
			Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE_TIME).getText().contains(":"));
		}
		catch(Throwable e)
		{
			Assert.fail("Min value time is not correct, exception details are: "+e);
		}
	}
	

	
	@Test(priority = 129450, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void switchTo1MTabTestInViewMore()
	{
		try
		{
			sessionDetailPage3550.switchToOtherTab("1M", ScrollDiection.UP);
			gestureUtils.mScroll("Show", FCCM3550.mobileMaxLabel, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		}
		catch(Throwable e)
		{
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor exception details are: "+e);
		}
	}
	
	@Test(priority = 129451, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void liveValueTest1MTabInViewMore()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE).getText().contains("--"));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value is coming as stale, exception details are: "+e);
		}
	}
	
	@Test(priority = 129452, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void liveValueUnitTest1MTabInViewMore()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE_UNIT).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value unit is incorrect, exception details are: "+e);
		}
	}
	
	@Test(priority = 129453, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void maxValueTest1MTabInViewMore()
	{
		try
		{
			Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE).getText().contains("--"));
		}
		catch(Throwable e)
		{
			Assert.fail("Max value is coming as stale, exception details are: "+e);
		}
	}
	
	@Test(priority = 129454, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void maxValueUnitTest1MTabInViewMore()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE_UNIT).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value unit is incorrect, exception details are: "+e);
		}
	}
	
	@Test(priority = 129455, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void maxValueTimeTest1MTabInViewMore()
	{
		try
		{
			Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE_TIME).getText().contains(":"));
		}
		catch(Throwable e)
		{
			Assert.fail("Max value unit is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 129456, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void minValueTest1MTabInViewMore()
	{
		try
		{
			Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE).getText().contains("--"));
		}
		catch(Throwable e)
		{
			Assert.fail("Min value is coming as stale, exception details are: "+e);
		}
	}
	
	@Test(priority = 129457, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void minValueUnitTest1MTabInViewMore()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE_UNIT).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value unit is incorrect, exception details are: "+e);
		}
	}
	
	@Test(priority = 129458, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void minValueTimeTest1MTabInViewMore()
	{
		try
		{
			Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE_TIME).getText().contains(":"));
		}
		catch(Throwable e)
		{
			Assert.fail("Min value time is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 129475, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void switchToALLTabTestInViewMore()
	{
		try
		{
			sessionDetailPage3550.switchToOtherTab("ALL3550", ScrollDiection.UP);
			gestureUtils.mScroll("Show", FCCM3550.mobileMaxLabel, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		}
		catch(Throwable e)
		{
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor exception details are: "+e);
		}
	}
	
	@Test(priority = 129476, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void liveValueTestALLTabInViewMore()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE).getText().contains("--"));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value is coming as stale, exception details are: "+e);
		}
	}
	
	@Test(priority = 129477, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void liveValueUnitTestALLTabInViewMore()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE_UNIT).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value unit is incorrect, exception details are: "+e);
		}
	}
	
	@Test(priority = 129478, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void maxValueTestALLTabInViewMore()
	{
		try
		{
			Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE).getText().contains("--"));
		}
		catch(Throwable e)
		{
			Assert.fail("Max value is coming as stale, exception details are: "+e);
		}
	}
	
	@Test(priority = 129479, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void maxValueUnitTestALLTabInViewMore()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE_UNIT).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value unit is incorrect, exception details are: "+e);
		}
	}
	
	@Test(priority = 129480, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void maxValueTimeTestALLTabInViewMore()
	{
		try
		{
			Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE_TIME).getText().contains(":"));
		}
		catch(Throwable e)
		{
			Assert.fail("Max value unit is not correct, exception details are: "+e);
		}
	}
	
	@Test(priority = 129481, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void minValueTestALLTabInViewMore()
	{
		try
		{
			Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE).getText().contains("--"));
		}
		catch(Throwable e)
		{
			Assert.fail("Min value is coming as stale, exception details are: "+e);
		}
	}
	
	@Test(priority = 129482, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void minValueUnitTestALLTabInViewMore()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE_UNIT).getText();
				Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Live value unit is incorrect, exception details are: "+e);
		}
	}
	
	@Test(priority = 129483, groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS,  FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void minValueTimeTestALLTabInViewMore()
	{
		try
		{
			Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE_TIME).getText().contains(":"));
		}
		catch(Throwable e)
		{
			Assert.fail("Min value time is not correct, exception details are: "+e);
		}
	}
 
	@AfterClass(groups = {FCCM3550.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS, FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS})
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



