/**
 * This class comprises of tests around an active session and its details like gateway name, sensor count, asset / test point
 * hierarchy, session creator, and start time stamp details.
 */

package com.fluke.connect.app.functional.client.tests;

import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.fluke.connect.app.functional.client.pages.SessionDetailPage3550;
import com.fluke.connect.app.functional.client.pages.SessionListPage;
import com.fluke.connect.app.functional.client.pages.SessionDetailPage.SessionDetailPageObjectList;
import com.fluke.connect.app.functional.client.pages.SessionDetailPage3550.SessionDetailPage3550ObjectList;
import com.fluke.connect.app.testdata.FCCM;
import com.fluke.connect.app.testdata.FCCM3550;
import com.fluke.connect.app.testdata.FCCM.AlarmDataValues;
import com.fluke.connect.app.testdata.FCCM.AlarmType;
import com.fluke.connect.app.testdata.SignIn.FeatureList;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DateAndTimeUtils;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.IOSUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.ScrollDiection;

public class ActiveSessionDetailPageTests3550 
{
	private SessionDetailPage3550 sessionDetailPage3550;
	private int iterationValue;
	private GestureUtils gestureUtils;
	private String valueUnit;
	private String sessionDetailPageSource;
	private int[] mAlarmCountSensorLevel;
	private SessionListPage sessionListPage;
	private WebElement mAlarmObject;
	private StringBuilder mValueHolder;
	private List<WebElement> mElementList;
	private String mTextNote;
	
	@BeforeClass(groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS, 
						FCCM3550.SESSION_VERIFICATION_TESTS, FCCM3550.UAT_TESTS, FCCM3550.UAT_WEB_TESTS})
	public void initClass()
	{
		sessionDetailPage3550 = new SessionDetailPage3550();
		gestureUtils = new GestureUtils();
		mAlarmCountSensorLevel = new int[2];
		sessionListPage = new SessionListPage();
		mValueHolder = new StringBuilder();
		CommonUtils.wait(15, 15, 5);
		ElementUtils.isDisplayed(60, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, "Sensors", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, "Sensors", LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".assetNameTextSession"); //to ensure active monitoring session page is loaded properly
		Config.appWidthCenterFlag = false;
		Config.useExistingPageSource = true;
		sessionDetailPageSource = DriverManager.getDriver().getPageSource();
		Config.iOSPageSource = sessionDetailPageSource;
	}
	
	@Test(priority = 125601, groups = {FCCM3550.UAT_WEB_TESTS, FCCM3550.PROD_WEB_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS})
	public void deleteResetAlarmTest()
	{
		sessionDetailPage3550.deleteAllAlarms(6);
		CommonUtils.wait(2);
	}
	
	@Test(priority = 125602, groups = {})
	public void alarmCountTest()
	{
		ElementUtils.isDisplayed(3, sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.ADD_EDIT_ALARM_ICON));
		CommonUtils.wait(2);
		for(int i = 0; i < 1; i++)
		{
			mAlarmCountSensorLevel[i] = Integer.parseInt(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.FCCM3550_SESSION_ALARM_ICON).getText());
			mAlarmCountSensorLevel[i + 1] = Integer.parseInt(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.FCCM3550_SENSOR_ALARM_ICON).getText());
		}
	}
	
	@Test(priority = 125603, groups = {FCCM3550.UAT_WEB_TESTS, FCCM3550.PROD_WEB_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS})
	public void addAboveTempratureAlarmTest()
	{
		CommonUtils.wait(2);
		sessionDetailPage3550.addAlarm(FeatureList.FCCM3550, AlarmType.ABOVE_TEMPERATURE, AlarmDataValues.FCCM3550_TEMP_UNIT_FAR.getValue(), AlarmDataValues.FCCM3550_ABOVE_TEMP_THRESHOLD_VALUE.getValue(), AlarmDataValues.FCCM3550_ABOVE_TEMP_THRESHOLD_VALUE.getValue(), null, 0, true, false, "");
		ElementUtils.isDisplayed(3, sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.ADD_EDIT_ALARM_ICON));
	}
	
	@Test(priority = 125604, groups = {FCCM3550.UAT_WEB_TESTS, FCCM3550.PROD_WEB_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS})
	public void addWithinTempratureAlarmTest()
	{
		CommonUtils.wait(2);
		sessionDetailPage3550.addAlarm(FeatureList.FCCM3550, AlarmType.WITHIN_TEMPERATURE, AlarmDataValues.FCCM3550_TEMP_UNIT_CEL.getValue(), AlarmDataValues.FCCM3550_WITHIN_TEMP_UPPER_THRESHOLD_VALUE.getValue(), AlarmDataValues.FCCM3550_WITHIN_TEMP_LOWER_THRESHOLD_VALUE.getValue(), null, 0, true, false, "");
		ElementUtils.isDisplayed(3, sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.ADD_EDIT_ALARM_ICON));
	}
	
	@Test(priority = 125701, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS, FCCM3550.SESSION_VERIFICATION_TESTS})
	public void sessionTileStatusTest()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			gestureUtils.webScroll(ScrollDiection.UP, 1);
		Assert.assertEquals(sessionDetailPage3550.getElementVisibleTextInSessionTileStrict(FCCM3550.sessionStatus[0]), FCCM3550.sessionStatus[0]);
	}
	
	@Test(priority = 125702, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,
						FCCM3550.SESSION_VERIFICATION_TESTS, FCCM3550.UAT_TESTS, FCCM3550.UAT_WEB_TESTS})
	public void gateWayNameTest()
	{
		Assert.assertEquals(sessionDetailPage3550.getElementVisibleTextInSessionTileStrict(FCCM3550.gatewayNameValue), FCCM3550.gatewayNameValue);
	}
	
	@Test(priority = 125703, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS, FCCM3550.SESSION_VERIFICATION_TESTS, FCCM3550.UAT_TESTS})
	public void sensorsStaticTextVisibleTest()
	{
		Assert.assertEquals(sessionDetailPage3550.getElementVisibleTextInSessionTileStrict(Config.SENSORS_STATIC_TEXT), Config.SENSORS_STATIC_TEXT);
	}
	
	@Test(priority = 125704, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS, FCCM3550.SESSION_VERIFICATION_TESTS})
	public void sensorCountAndTypeTest()
	{
		Assert.assertEquals(sessionDetailPage3550.getElementVisibleTextInSessionTileStrict(FCCM3550.sensorsCountAndType), FCCM3550.sensorsCountAndType);
	}
	
	@Test(priority = 125705, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS})
	public void startTimeStaticTextVisibleTest()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertEquals(sessionDetailPage3550.getElementVisibleTextInSessionTileStrict(Config.START_TIME_STATIC_TEXT), Config.START_TIME_STATIC_TEXT);
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "#new_design1").getText().contains(Config.START_STATIC_TEXT));
	}
	
	@Test(priority = 125706, groups = {})
	public void sessionStartTimeTest()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertTrue(sessionDetailPage3550.getElementVisibleTextInSessionTile(FCCM3550.requiredSessionStartTimestamp).contains(FCCM3550.requiredSessionStartTimestamp));
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "#new_design1").getText().startsWith(FCCM3550.requiredSessionStartTimestamp));
	} 
	
	@Test(priority = 125707, groups = {})
	public void sessionStartUserNameTest()
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertTrue(sessionDetailPage3550.getElementVisibleTextInSessionTile(FCCM3550.sessionStartUserName).contains(FCCM3550.sessionStartUserName));
			
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "#new_design1").getText().contains(FCCM3550.sessionStartUserName));
	} 
	
	@Test(priority = 125708, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS, FCCM3550.SESSION_VERIFICATION_TESTS})
	public void assetCountTextVisibleTest()
	{
		Assert.assertTrue(sessionDetailPage3550.getElementInSessionTileStrict(Config.ASSET_STATIC_TEXT+" (1)").isDisplayed());
	}
	
	@Test(priority = 125709, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS, FCCM3550.SESSION_VERIFICATION_TESTS})
	public void assetGroupNameTest()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertEquals(sessionDetailPage3550.getElementVisibleTextInSessionTileStrict(FCCM3550.assetGroupName), FCCM3550.assetGroupName);
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertEquals(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".crumbTrailAssetGroupInfo").getText(), FCCM3550.assetGroupName);
	}
	
	@Test(priority = 125710, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS})
	public void assetNameTest()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertEquals(sessionDetailPage3550.getElementVisibleTextInSessionTileStrict(FCCM3550.assetName), FCCM3550.assetName);
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertEquals(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".crumbTrailAssetName").getText(), FCCM3550.assetName);				
	}
	
	@Test(priority = 125711, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS})
	public void testPointNameTest()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertEquals(sessionDetailPage3550.getElementVisibleTextInSessionTileStrict(FCCM3550.testPointName), FCCM3550.testPointName);
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertEquals(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".assetNameTextSession").getText(), FCCM3550.testPointName);				
	} 
	
	@Test(priority = 125715, groups = {})
	public void alarmIconTest()
	{
		List<WebElement> alarmIcons = sessionDetailPage3550.getSessionDetailPageObjects(SessionDetailPageObjectList.ALARM_ICONS);
			for(WebElement alarmIcon:alarmIcons)
			{
				Assert.assertTrue(alarmIcon.isDisplayed());
			}
	}
	
	@Test(priority = 125716, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS})
	public void alertIconTest()
	{
		List<WebElement> alertIcons = sessionDetailPage3550.getSessionDetailPageObjects(SessionDetailPageObjectList.ALERT_ICONS);
			for(WebElement alertIcon:alertIcons)
			{
				if(alertIcon.isDisplayed())
					break;
			}
	}
	
	@Test(priority = 125721, groups = {})
	public void mainImageMobileTest()
	{
		gestureUtils.mScroll(-100, -100, 4);
		Assert.assertTrue(ElementUtils.isDisplayed(10, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "vl_image", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, "options white", LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "div[id='ti-download-image0'][style='display: block;']"));
	}

	@Test(priority = 125780, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void tempratureUnitTest()
	{
		gestureUtils.mScroll("Show", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
		Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.TEMPRATURE_UNIT).getText().contains(FCCM3550.tempratureUnitFahrenheit) || sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.TEMPRATURE_UNIT).getText().contains(FCCM3550.tempratureUnitFahrenheitAndroid));
	} 
	
	@Test(priority = 125781, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS})
	public void graphDisplayedTest()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertTrue(sessionDetailPage3550.isGraphDisplayed(Config.IOS_LOCATOR_STRATEGY_NAME, FCCM.GRAPH_1H_TAB, -300, -60, 10, -70));
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(sessionDetailPage3550.isGraphDisplayed(null));
	}
	
	@Test(priority = 125782, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void maxLabelIn1HTabTest()
	{
		gestureUtils.mScroll("Show", FCCM3550.mobileMaxLabel, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertTrue(sessionDetailPage3550.getElementInSessionTileStrict(FCCM3550.mobileMaxLabel).isDisplayed());
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".maxPosition .sessionValueTitle").getText().equals(FCCM3550.webMaxLabel));
	}
	
	@Test(priority = 125783, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void minLabelIn1HTabTest()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertTrue(sessionDetailPage3550.getElementInSessionTileStrict(FCCM3550.mobileMaxLabel).isDisplayed());
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".minPosition .sessionValueTitle").getText().equals(FCCM3550.webMinLabel));
	}
	
	@Test(priority = 125784, groups = {FCCM3550.UAT_WEB_TESTS, FCCM3550.PROD_WEB_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS})
	public void livePollingTest()
	{
		gestureUtils.webScroll(ScrollDiection.DOWN, 1);
		Assert.assertTrue(sessionDetailPage3550.isLivePollingHappening("./graph/bp", "./graph/ap", "./graph/dp", ".png", iterationValue, 3, 60, Config.IOS_LOCATOR_STRATEGY_NAME, FCCM3550.tempratureUnitFahrenheit));
	}
	
	@Test(priority = 125801, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void liveValueTest()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE).getText().contains("--"));
	}
	
	@Test(priority = 125802, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void liveValueUnitTest()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE).getText();
			Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE_UNIT).getText();
			Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
		}
	}
	
	@Test(priority = 125803, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void maxValueTest()
	{
		Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE).getText().contains("--"));
	}
	
	@Test(priority = 125804, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void maxValueUnitTest()
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
	
	@Test(priority = 125805, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void maxValueTimeTest()
	{
		Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE_TIME).getText().contains(":"));
	}
	
	@Test(priority = 125806, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void minValueTest()
	{
		Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE).getText().contains("--"));
	}
	
	@Test(priority = 125807, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void minValueUnitTest()
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
	
	@Test(priority = 125808, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void minValueTimeTest()
	{
		Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE_TIME).getText().contains(":"));
	}
	
	@Test(priority = 125809, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, })
	public void mainImageTest()
	{
		Assert.assertTrue(ElementUtils.isDisplayed(10, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "div[id='ti-download-image0'][style='display: block;']"));
	}
	
	@Test(priority = 125810, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, })
	public void sliderImageTest()
	{
		Assert.assertTrue(ElementUtils.isDisplayed(10, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "img[data-event='click:changeimages']"));
	}
	
	@Test(priority = 125900, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void switchTo1DTabTest() throws Exception
	{
		sessionDetailPage3550.switchToOtherTab("1D", ScrollDiection.UP);
		gestureUtils.mScroll("Show", FCCM3550.mobileMaxLabel, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
	}
	
	@Test(priority = 125901, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void liveValueTest1DTab()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE).getText().contains("--"));
	}
	
	@Test(priority = 125902, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void liveValueUnitTest1DTab()
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
	
	@Test(priority = 125903, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void maxValueTest1DTab()
	{
		Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE).getText().contains("--"));
	}
	
	@Test(priority = 125904, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void maxValueUnitTest1DTab()
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
	
	@Test(priority = 125905, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void maxValueTimeTest1DTab()
	{
		Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE_TIME).getText().contains(":"));
	}
	
	@Test(priority = 125906, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void minValueTest1DTab()
	{
		Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE).getText().contains("--"));
	}
	
	@Test(priority = 125907, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void minValueUnitTest1DTab()
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
	
	@Test(priority = 125908, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void minValueTimeTest1DTab()
	{
		Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE_TIME).getText().contains(":"));
	}
	
	@Test(priority = 125909, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, })
	public void mainImage1DTest()
	{
		Assert.assertTrue(ElementUtils.isDisplayed(10, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "div[id='ti-download-image0'][style='display: block;']"));
	}
	
	@Test(priority = 125910, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, })
	public void sliderImage1DTest()
	{
		Assert.assertTrue(ElementUtils.isDisplayed(10, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "img[data-event='click:changeimages']"));
	}
	
	@Test(priority = 126000, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void switchTo1WTabTest() throws Exception
	{
		sessionDetailPage3550.switchToOtherTab("1W", ScrollDiection.UP);
		gestureUtils.mScroll("Show", FCCM3550.mobileMaxLabel, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
	}
	
	@Test(priority = 126001, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void liveValueTest1WTab()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE).getText().contains("--"));
	}
	
	@Test(priority = 126002, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void liveValueUnitTest1WTab()
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
	
	@Test(priority = 126003, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void maxValueTest1WTab()
	{
		Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE).getText().contains("--"));
	}
	
	@Test(priority = 126004, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void maxValueUnitTest1WTab()
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
	
	@Test(priority = 126005, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void maxValueTimeTest1WTab()
	{
		Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE_TIME).getText().contains(":"));
	}
	
	@Test(priority = 126006, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void minValueTest1WTab()
	{
		Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE).getText().contains("--"));
	}
	
	@Test(priority = 126007, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void minValueUnitTest1WTab()
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
	
	@Test(priority = 126008, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void minValueTimeTest1WTab()
	{
		Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE_TIME).getText().contains(":"));
	}
	
	@Test(priority = 126009, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, })
	public void mainImage1WTest()
	{
		Assert.assertTrue(ElementUtils.isDisplayed(10, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "div[id='ti-download-image0'][style='display: block;']"));
	}
	
	@Test(priority = 126010, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, })
	public void sliderImage1WTest()
	{
		Assert.assertTrue(ElementUtils.isDisplayed(10, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "img[data-event='click:changeimages']"));
	}
	
	@Test(priority = 126100, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void switchTo1MTabTest() throws Exception
	{
		sessionDetailPage3550.switchToOtherTab("1M", ScrollDiection.UP);
		gestureUtils.mScroll("Show", FCCM3550.mobileMaxLabel, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
	}
	
	@Test(priority = 126101, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void liveValueTest1MTab()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE).getText().contains("--"));
	}
	
	@Test(priority = 126102, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void liveValueUnitTest1MTab()
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
	
	@Test(priority = 126103, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void maxValueTest1MTab()
	{
		Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE).getText().contains("--"));
	}
	
	@Test(priority = 126104, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void maxValueUnitTest1MTab()
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
	
	@Test(priority = 126105, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void maxValueTimeTest1MTab()
	{
		Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE_TIME).getText().contains(":"));
	}
	
	@Test(priority = 126106, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void minValueTest1MTab()
	{
		Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE).getText().contains("--"));
	}
	
	@Test(priority = 126107, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void minValueUnitTest1MTab()
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
	
	@Test(priority = 126108, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void minValueTimeTest1MTab()
	{
		Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE_TIME).getText().contains(":"));
	}
	
	@Test(priority = 126109, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, })
	public void mainImage1MTest()
	{
		Assert.assertTrue(ElementUtils.isDisplayed(10, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "div[id='ti-download-image0'][style='display: block;']"));
	}
	
	@Test(priority = 126110, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, })
	public void sliderImage1MTest()
	{
		Assert.assertTrue(ElementUtils.isDisplayed(10, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "img[data-event='click:changeimages']"));
	}
	
	@Test(priority = 126200, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void switchToALLTabTest() throws Exception
	{
		sessionDetailPage3550.switchToOtherTab("ALL3550", ScrollDiection.UP);
		gestureUtils.mScroll("Show", FCCM3550.mobileMaxLabel, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
	}
	
	@Test(priority = 126201, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void liveValueTestALLTab()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE).getText().contains("--"));
	}
	
	@Test(priority = 126202, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void liveValueUnitTestALLTab()
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
	
	@Test(priority = 126203, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void maxValueTestALLTab()
	{
		Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE).getText().contains("--"));
	}
	
	@Test(priority = 126204, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void maxValueUnitTestALLTab()
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
	
	@Test(priority = 126205, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void maxValueTimeTestALLTab()
	{
		Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE_TIME).getText().contains(":"));
	}
	
	@Test(priority = 126206, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void minValueTestALLTab()
	{
		Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE).getText().contains("--"));
	}
	
	@Test(priority = 126207, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void minValueUnitTestALLTab()
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
	
	@Test(priority = 126208, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS, })
	public void minValueTimeTestALLTab()
	{
		Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE_TIME).getText().contains(":"));
	}
	
	@Test(priority = 126209, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, })
	public void mainImageAllTest()
	{
		Assert.assertTrue(ElementUtils.isDisplayed(10, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "div[id='ti-download-image0'][style='display: block;']"));
	}
	
	@Test(priority = 126210, groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, })
	public void sliderImageAllTest()
	{
		Assert.assertTrue(ElementUtils.isDisplayed(10, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "img[data-event='click:changeimages']"));
	}
	
	@Test(priority = 126300, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void clickOnViewMoreTest()
	{
		gestureUtils.mScroll("View More", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.UP);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "View More", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, "View More", null, null).click();
	}
	
	@Test(priority = 126301, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void maxLabelInViewMore1HTabTest()
	{
		CommonUtils.wait(3, 5, 0);
		IOSUtils.resetIOSPageSource();
		IOSUtils.setIOSPageSource();
		gestureUtils.mScroll("Show", FCCM3550.mobileMaxLabel, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertTrue(sessionDetailPage3550.getElementInSessionTileStrict(FCCM3550.mobileMaxLabel).isDisplayed());
	}
	
	@Test(priority = 126302, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void minLabelInViewMore1HTabTest()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertTrue(sessionDetailPage3550.getElementInSessionTileStrict(FCCM3550.mobileMaxLabel).isDisplayed());
	}
	
	@Test(priority = 126303, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void liveValueTestInViewMore1HTab()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE).getText().contains("--"));
	}
	
	@Test(priority = 126304, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void liveValueUnitTestInViewMore()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE_UNIT).getText();
			Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
		}
	}
	
	@Test(priority = 126305, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void maxValueTestInViewMore1HTab()
	{
		Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE).getText().contains("--"));
	}
	
	@Test(priority = 126306, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void maxValueUnitTestInViewMore1HTab()
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
	
	@Test(priority = 126307, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void maxValueTimeTestInViewMore1Htab()
	{
		Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE_TIME).getText().contains(":"));
	}
	
	@Test(priority = 126308, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void minValueTestInViewMore1HTab()
	{
		Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE).getText().contains("--"));
	}
	
	@Test(priority = 126309, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void minValueUnitTestInViewMore1Htab()
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
	
	@Test(priority = 126310, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void minValueTimeTestInViewMore1Htab()
	{
		Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE_TIME).getText().contains(":"));
	}
	
	@Test(priority = 126350, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void switchTo1DTabTestInViewMore() throws Exception
	{
		sessionDetailPage3550.switchToOtherTab("1D", ScrollDiection.UP);
		gestureUtils.mScroll("Show", FCCM3550.mobileMaxLabel, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
	}
	
	@Test(priority = 126351, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void liveValueTestInViewMore1DTab()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE).getText().contains("--"));
	}
	
	@Test(priority = 126352, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void liveValueUnitTest1DTabInViewMore()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE_UNIT).getText();
			Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
		}
	}
	
	@Test(priority = 126353, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void maxValueTest1DTabInViewMore()
	{
		Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE).getText().contains("--"));
	}
	
	@Test(priority = 126354, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void maxValueUnitTest1DTabInViewMore()
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
	
	@Test(priority = 126355, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void maxValueTimeTest1DTabInViewMore()
	{
		Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE_TIME).getText().contains(":"));
	}
	
	@Test(priority = 126356, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void minValueTest1DTabInViewMore()
	{
		Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE).getText().contains("--"));
	}
	
	@Test(priority = 126357, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void minValueUnitTest1DTabInViewMore()
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
	
	@Test(priority = 126358, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void minValueTimeTest1DTabInViewMore()
	{
		Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE_TIME).getText().contains(":"));
	}

	@Test(priority = 126400, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void switchTo1WTabTestInViewMore() throws Exception
	{
		sessionDetailPage3550.switchToOtherTab("1W", ScrollDiection.UP);
		gestureUtils.mScroll("Show", FCCM3550.mobileMaxLabel, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
	}
	
	@Test(priority = 126401, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void liveValueTest1WTabInViewMore()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE).getText().contains("--"));
	}
	
	@Test(priority = 126402, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void liveValueUnitTest1WTabInViewMore()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE_UNIT).getText();
			Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
		}
	}
	
	@Test(priority = 126403, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void maxValueTest1WTabInViewMore()
	{
		Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE).getText().contains("--"));
	}
	
	@Test(priority = 126404, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void maxValueUnitTest1WTabInViewMore()
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
	
	@Test(priority = 126405, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void maxValueTimeTest1WTabInViewMore()
	{
		Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE_TIME).getText().contains(":"));
	}
	
	@Test(priority = 126406, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void minValueTest1WTabInViewMore()
	{
		Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE).getText().contains("--"));
	}
	
	@Test(priority = 126407, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void minValueUnitTest1WTabInViewMore()
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
	
	@Test(priority = 126408, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void minValueTimeTest1WTabInViewMore()
	{
		Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE_TIME).getText().contains(":"));
	}

	@Test(priority = 126450, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void switchTo1MTabTestInViewMore() throws Exception
	{
		sessionDetailPage3550.switchToOtherTab("1M", ScrollDiection.UP);
		gestureUtils.mScroll("Show", FCCM3550.mobileMaxLabel, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
	}
	
	@Test(priority = 126451, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void liveValueTest1MTabInViewMore()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE).getText().contains("--"));
	}
	
	@Test(priority = 126452, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void liveValueUnitTest1MTabInViewMore()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE_UNIT).getText();
			Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
		}
	}
	
	@Test(priority = 126453, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void maxValueTest1MTabInViewMore()
	{
		Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE).getText().contains("--"));
	}
	
	@Test(priority = 126454, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void maxValueUnitTest1MTabInViewMore()
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
	
	@Test(priority = 126455, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void maxValueTimeTest1MTabInViewMore()
	{
		Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE_TIME).getText().contains(":"));
	}
	
	@Test(priority = 126456, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void minValueTest1MTabInViewMore()
	{
		Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE).getText().contains("--"));
	}
	
	@Test(priority = 126457, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void minValueUnitTest1MTabInViewMore()
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
	
	@Test(priority = 126458, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void minValueTimeTest1MTabInViewMore()
	{
		Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE_TIME).getText().contains(":"));
	}
	
	@Test(priority = 126500, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void switchToALLTabTestInViewMore() throws Exception
	{
		sessionDetailPage3550.switchToOtherTab("ALL3550", ScrollDiection.UP);
		gestureUtils.mScroll("Show", FCCM3550.mobileMaxLabel, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
	}
	
	@Test(priority = 126501, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void liveValueTestALLTabInViewMore()
	{
		Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE).getText().contains("--"));
	}
	
	@Test(priority = 126502, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS})
	public void liveValueUnitTestALLTabInViewMore()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			valueUnit = sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.LIVE_VALUE_UNIT).getText();
			Assert.assertTrue(valueUnit.contains(FCCM3550.tempratureUnitFahrenheitAndroid) || valueUnit.contains(FCCM3550.tempratureUnitFahrenheit));
		}
	}
	
	@Test(priority = 126503, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void maxValueTestALLTabInViewMore()
	{
		Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE).getText().contains("--"));
	}
	
	@Test(priority = 126504, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void maxValueUnitTestALLTabInViewMore()
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
	
	@Test(priority = 126505, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void maxValueTimeTestALLTabInViewMore()
	{
		Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MAX_VALUE_TIME).getText().contains(":"));
	}
	
	@Test(priority = 126506, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void minValueTestALLTabInViewMore()
	{
		Assert.assertFalse(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE).getText().contains("--"));
	}
	
	@Test(priority = 126507, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void minValueUnitTestALLTabInViewMore()
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
	
	@Test(priority = 126508, groups = {FCCM3550.SESSION_DETAIL_PAGE_TESTS,  FCCM3550.SESSION_VERIFICATION_TESTS,   })
	public void minValueTimeTestALLTabInViewMore()
	{
		Assert.assertTrue(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.MIN_VALUE_TIME).getText().contains(":"));
	}  
	
	@Test(priority = 126701, groups = {})
	public void newAlarmCountTest() throws Exception
	{
		gestureUtils.webScroll(ScrollDiection.UP, 1);
		sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.BACK_BUTTON).click();
		DriverManager.getDriver().navigate().refresh();
		CommonUtils.wait(5, 5, 10);
		ElementUtils.isDisplayed(5, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, "Sensors", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, "Sensors", LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".sessionGatewaySensorsTitle"); // to ensure active monitoring session page is loaded properly
		IOSUtils.setIOSPageSource();
		gestureUtils.mScroll(FCCM3550.requiredSessionStartTimestamp, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		sessionListPage.initSessionCellElement(FCCM3550.requiredSessionStartTimestamp); 
		ElementUtils.getElement(sessionListPage.getSessionTile(), LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, FCCM3550.requiredSessionStartTimestamp, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, FCCM3550.requiredSessionStartTimestamp, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_SPAN_TEXT_CONTAINS, FCCM3550.requiredSessionStartTimestamp).click();
		CommonUtils.wait(5, 5, 15);
		ElementUtils.isDisplayed(3, sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.FCCM3550_SENSOR_ALARM_ICON));
		for(int i = 0; i < 1; i++)
		{
			Assert.assertTrue(Integer.parseInt(sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.FCCM3550_SESSION_ALARM_ICON).getText()) >= mAlarmCountSensorLevel[i] + 2);
		}
	}
	
	@Test(priority = 126702, groups = {FCCM3550.UAT_WEB_TESTS, FCCM3550.PROD_WEB_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS})
	public void sessionAlertCountTest()
	{
		Assert.assertTrue(Integer.parseInt(sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ALERT_COUNT).getText()) >= 1);
	} 

	@Test(priority = 126703, groups = {FCCM3550.UAT_WEB_TESTS, FCCM3550.PROD_WEB_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS})
	public void aboveTempratureTitleSessionActivityTest() throws Exception
	{
		gestureUtils.webScroll(ScrollDiection.UP, 2);
		mAlarmObject = null;
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.MORE_OPTIONS_BUTTON).click();
			CommonUtils.wait(1);
			sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.VIEW_SESSION_ACTIVITY).click();
			CommonUtils.wait(10);
			mAlarmObject = ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, FCCM.AlarmObject.WEB_SESSION_ABOVE_TEMPRATURE.getObject());
			Assert.assertNotNull(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT, FCCM.AlarmText.WEB_SESSION_ACTIVITY_ABOVE_TEMPRATURE.getText()).isDisplayed());
		}
	}
	
	@Test(priority = 126704, groups = {FCCM3550.UAT_WEB_TESTS, FCCM3550.PROD_WEB_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS})
	public void aboveTempratureThresholdSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mValueHolder.delete(0, mValueHolder.length());
			mValueHolder.append(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_THRESHOLD.getObject()).getText());
			Assert.assertTrue(mValueHolder.toString().contains(AlarmDataValues.FCCM3550_ABOVE_TEMP_THRESHOLD_VALUE.getValue()) && (mValueHolder.toString().contains(AlarmDataValues.FCCM3550_TEMP_UNIT_CEL.getValue())) && (mValueHolder.toString().contains(AlarmDataValues.FCCM3550_TEMP_UNIT_FAR.getValue())) && (mValueHolder.toString().contains(">")));
		}
	}
	
	@Test(priority = 126705, groups = {FCCM3550.UAT_WEB_TESTS, FCCM3550.PROD_WEB_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS})
	public void aboveTempratureTimestampSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mValueHolder.delete(0, mValueHolder.length());
			mValueHolder.append(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_ALARM_TIMESTAMP.getObject()).getText());
			Assert.assertTrue(mValueHolder.toString().contains(DateAndTimeUtils.getCurrentTimeStamp(AlarmDataValues.FCCM3550_DATE_FORMAT_WEB.getValue())));
		}
	}
	
	@Test(priority = 126706, groups = {FCCM3550.UAT_WEB_TESTS, FCCM3550.PROD_WEB_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS})
	public void aboveTempratureValueSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				Assert.assertTrue(Double.parseDouble((ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_TRIGGERED_VALUE.getObject()).getText().split(" ")[0])) > 0.0);
	}
	
	@Test(priority = 126707, groups = {FCCM3550.UAT_WEB_TESTS, FCCM3550.PROD_WEB_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS})
	public void aboveTempratureUnitSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mElementList = ElementUtils.getElements(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_TRIGGERED_UNIT.getObject());
			for(WebElement element: mElementList) {
				Assert.assertTrue(element.getText().contains(AlarmDataValues.FCCM3550_TEMP_UNIT_FAR.getValue()) || element.getText().contains(AlarmDataValues.FCCM3550_TEMP_UNIT_CEL.getValue()));
			}
		}
	}
	
	@Test(priority = 126708, groups = {FCCM3550.UAT_WEB_TESTS, FCCM3550.PROD_WEB_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS})
	public void aboveTempratureAssetGroupNameSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_ASSET_GROUP.getObject()).getText().equals(AlarmDataValues.FCCM3550_ASSET_GROUP_NAME.getValue()));
	}
	
	@Test(priority = 126709, groups = {FCCM3550.UAT_WEB_TESTS, FCCM3550.PROD_WEB_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS})
	public void aboveTempratureAssetNameSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				Assert.assertTrue(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_ASSET.getObject()).getText().equals(AlarmDataValues.FCCM3550_ASSET_NAME.getValue()));
	}
	
	@Test(priority = 126725, groups = {FCCM3550.UAT_WEB_TESTS, FCCM3550.PROD_WEB_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS})
	public void withinTempratureTitleSessionActivityTest() throws Exception
	{
		mAlarmObject = null;
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			mAlarmObject = ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, FCCM.AlarmObject.WEB_SESSION_WITHIN_TEMPRATURE.getObject());
			Assert.assertNotNull(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT, FCCM.AlarmText.WEB_SESSION_ACTIVITY_WITHIN_TEMPRATURE.getText()).isDisplayed());
		}
	}
	
	@Test(priority = 126726, groups = {FCCM3550.UAT_WEB_TESTS, FCCM3550.PROD_WEB_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS})
	public void withinTempratureThresholdSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mValueHolder.delete(0, mValueHolder.length());
			mValueHolder.append(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_THRESHOLD.getObject()).getText());
			Assert.assertTrue(mValueHolder.toString().contains(AlarmDataValues.FCCM3550_WITHIN_TEMP_UPPER_THRESHOLD_VALUE.getValue()) && mValueHolder.toString().contains(AlarmDataValues.FCCM3550_WITHIN_TEMP_LOWER_THRESHOLD_VALUE.getValue()) && (mValueHolder.toString().contains(AlarmDataValues.FCCM3550_TEMP_UNIT_CEL.getValue())) && (mValueHolder.toString().contains(AlarmDataValues.FCCM3550_TEMP_UNIT_FAR.getValue())) && (mValueHolder.toString().contains("-")));
		}
	}
	
	@Test(priority = 126727, groups = {FCCM3550.UAT_WEB_TESTS, FCCM3550.PROD_WEB_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS})
	public void withinTempratureTimestampSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mValueHolder.delete(0, mValueHolder.length());
			mValueHolder.append(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_ALARM_TIMESTAMP.getObject()).getText());
			Assert.assertTrue(mValueHolder.toString().contains(DateAndTimeUtils.getCurrentTimeStamp(AlarmDataValues.FCCM3550_DATE_FORMAT_WEB.getValue())));
		}
	}
	
	@Test(priority = 126728, groups = {FCCM3550.UAT_WEB_TESTS, FCCM3550.PROD_WEB_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS})
	public void withinTempratureValueSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				Assert.assertTrue(Double.parseDouble((ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_TRIGGERED_VALUE.getObject()).getText().split(" ")[0])) > 0.0);
	}
	
	@Test(priority = 126729, groups = {FCCM3550.UAT_WEB_TESTS, FCCM3550.PROD_WEB_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS})
	public void withinTempratureUnitSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mElementList = ElementUtils.getElements(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_TRIGGERED_UNIT.getObject());
			for(WebElement element: mElementList) {
				Assert.assertTrue(element.getText().contains(AlarmDataValues.FCCM3550_TEMP_UNIT_FAR.getValue()) || element.getText().contains(AlarmDataValues.FCCM3550_TEMP_UNIT_CEL.getValue()));
			}
		}
	}
	
	@Test(priority = 126730, groups = {FCCM3550.UAT_WEB_TESTS, FCCM3550.PROD_WEB_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS})
	public void withinTempratureAssetGroupNameSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_ASSET_GROUP.getObject()).getText().equals(AlarmDataValues.FCCM3550_ASSET_GROUP_NAME.getValue()));
	}
	
	@Test(priority = 126731, groups = {FCCM3550.UAT_WEB_TESTS, FCCM3550.PROD_WEB_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS})
	public void withinTempratureAssetNameSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				Assert.assertTrue(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_ASSET.getObject()).getText().equals(AlarmDataValues.FCCM3550_ASSET_NAME.getValue()));
	}
	
	@Test(priority = 126750, groups = {FCCM3550.UAT_WEB_TESTS, FCCM3550.PROD_WEB_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS})
	public void markAsReadTest() throws Exception
	{
		sessionDetailPage3550.notificationMarkAsRead();
	}
	
	@Test(priority = 126751, groups = {FCCM3550.UAT_WEB_TESTS, FCCM3550.PROD_WEB_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS})
	public void isNotificationMarkedAsReadTest() throws Exception
	{
		Assert.assertTrue(sessionDetailPage3550.isNotificationRead());
	}
	
	@Test(priority = 126752, groups = {FCCM3550.UAT_WEB_TESTS, FCCM3550.PROD_WEB_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS})
	public void addTextNoteTest() throws Exception
	{
		mTextNote = DateAndTimeUtils.getCurrentTimeStamp("MM/dd/yyyy hh:mm:ss");
		sessionDetailPage3550.addTextNote(mTextNote);
		CommonUtils.wait(3);
	}
	
	@Test(priority = 126760, groups = {FCCM3550.UAT_WEB_TESTS, FCCM3550.PROD_WEB_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS})
	public void aboveTempratureTitleNotificationTest() throws Exception
	{
		mAlarmObject = null;
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			gestureUtils.getActionsWebObject().sendKeys(Keys.ESCAPE).build().perform();
			CommonUtils.wait(3);
			sessionDetailPage3550.getSessionDetailPage3550Object(SessionDetailPage3550ObjectList.FCCM3550_SENSOR_ALARM_ICON).click();
			CommonUtils.wait(3);
			mAlarmObject = ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, FCCM.AlarmObject.WEB_NOTIFICATION_ABOVE_TEMPRATURE.getObject());
			Assert.assertTrue(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT_CONTAINS, FCCM.AlarmText.WEB_ABOVE_TEMPRATURE.getText()).isDisplayed());
		}
	}
	
	@Test(priority = 126761, groups = {FCCM3550.UAT_WEB_TESTS, FCCM3550.PROD_WEB_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS})
	public void aboveTempratureValueNotificationTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			mValueHolder.delete(0, mValueHolder.length());
			mValueHolder.append(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_NOTIFICATION_VALUE.getObject()).getText());
			Assert.assertTrue(mValueHolder.toString().contains(AlarmDataValues.FCCM3550_TEMP_UNIT_FAR.getValue()) && Double.parseDouble(mValueHolder.toString().split(" ")[0]) > 0.0);
		}
	}
	
	@Test(priority = 126762, groups = {FCCM3550.UAT_WEB_TESTS, FCCM3550.PROD_WEB_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS})
	public void aboveTempratureTimestampNotificationTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			mValueHolder.delete(0, mValueHolder.length());
			mValueHolder.append(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_NOTIFICATION_TIMESTAMP.getObject()).getText());
			Assert.assertTrue(mValueHolder.toString().contains(DateAndTimeUtils.getCurrentTimeStamp("MM/dd/yyyy")));
		}
	}
	
	@Test(priority = 126770, groups = {FCCM3550.UAT_WEB_TESTS, FCCM3550.PROD_WEB_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS})
	public void withinTempratureTitleNotificationTest() throws Exception
	{
		mAlarmObject = null;
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			mAlarmObject = ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, FCCM.AlarmObject.WEB_NOTIFICATION_WITHIN_TEMPRATURE.getObject());
			Assert.assertTrue(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT_CONTAINS, FCCM.AlarmText.WEB_WITHIN_TEMPRATURE.getText()).isDisplayed());
		}
	}
	
	@Test(priority = 126771, groups = {FCCM3550.UAT_WEB_TESTS, FCCM3550.PROD_WEB_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS})
	public void withinTempratureValueNotificationTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			mValueHolder.delete(0, mValueHolder.length());
			mValueHolder.append(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_NOTIFICATION_VALUE.getObject()).getText());
			Assert.assertTrue(mValueHolder.toString().contains(AlarmDataValues.FCCM3550_TEMP_UNIT_FAR.getValue()) && Double.parseDouble(mValueHolder.toString().split(" ")[0]) > 0.0);
		}
	}
	
	@Test(priority = 126772, groups = {FCCM3550.UAT_WEB_TESTS, FCCM3550.PROD_WEB_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS})
	public void withinTempratureTimestampNotificationTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			mValueHolder.delete(0, mValueHolder.length());
			mValueHolder.append(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_NOTIFICATION_TIMESTAMP.getObject()).getText());
			Assert.assertTrue(mValueHolder.toString().contains(DateAndTimeUtils.getCurrentTimeStamp("MM/dd/yyyy")));
		}
	}
	
	@Test(priority = 126800, groups = {FCCM3550.UAT_WEB_TESTS, FCCM3550.PROD_WEB_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS})
	public void deleteAlarmTest()
	{
		sessionDetailPage3550.deleteAllAlarms(6);
		CommonUtils.wait(2);
	}
	
	@Test(priority = 126801, groups = {FCCM3550.UAT_WEB_TESTS, FCCM3550.PROD_WEB_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS})
	public void addAboveResetTempratureAlarmTest()
	{
		CommonUtils.wait(2);
		sessionDetailPage3550.addAlarm(FeatureList.FCCM3550, AlarmType.ABOVE_TEMPERATURE, AlarmDataValues.FCCM3550_TEMP_UNIT_FAR.getValue(), AlarmDataValues.FCCM3550_ABOVE_TEMP_RESET_VALUE.getValue(), AlarmDataValues.FCCM3550_ABOVE_TEMP_RESET_VALUE.getValue(), null, 0, true, false, "");
		ElementUtils.isDisplayed(3, sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.ADD_EDIT_ALARM_ICON));
	}
	
	@Test(priority = 126802, groups = {FCCM3550.UAT_WEB_TESTS, FCCM3550.PROD_WEB_TESTS, FCCM3550.SESSION_VERIFICATION_WEB_TESTS})
	public void addWithinResetTempratureAlarmTest()
	{
		CommonUtils.wait(2);
		sessionDetailPage3550.addAlarm(FeatureList.FCCM3550, AlarmType.WITHIN_TEMPERATURE, AlarmDataValues.FCCM3550_TEMP_UNIT_CEL.getValue(), AlarmDataValues.FCCM3550_WITHIN_TEMP_UPPER_RESET_VALUE.getValue(), AlarmDataValues.FCCM3550_WITHIN_TEMP_LOWER_RESET_VALUE.getValue(), null, 0, true, false, "");
		ElementUtils.isDisplayed(3, sessionDetailPage3550.getSessionDetailPageObject(SessionDetailPageObjectList.ADD_EDIT_ALARM_ICON));
	}
	
	@AfterClass(groups = {FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_DETAIL_PAGE_TESTS, FCCM3550.SESSION_VERIFICATION_TESTS})
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