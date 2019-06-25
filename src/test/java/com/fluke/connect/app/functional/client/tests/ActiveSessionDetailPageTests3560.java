package com.fluke.connect.app.functional.client.tests;

import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.fluke.connect.app.functional.client.pages.HomePage;
import com.fluke.connect.app.functional.client.pages.NotificationsPage;
import com.fluke.connect.app.functional.client.pages.SessionDetailPage;
import com.fluke.connect.app.functional.client.pages.SessionDetailPage3560;
import com.fluke.connect.app.functional.client.pages.SessionListPage;
import com.fluke.connect.app.functional.client.pages.SessionDetailPage.SessionDetailPageObjectList;
import com.fluke.connect.app.functional.client.pages.SessionDetailPage3560.SessionDetailPage3560ObjectList;
import com.fluke.connect.app.testdata.FCCM;
import com.fluke.connect.app.testdata.FCCM.AlarmDataValues;
import com.fluke.connect.app.testdata.FCCM.AlarmType;
import com.fluke.connect.app.testdata.FCCM3560;
import com.fluke.connect.app.testdata.SignIn.FeatureList;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.GestureUtils.ObjectName;
import com.fluke.connect.app.utils.IOSUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.ScrollDiection;
import com.fluke.connect.app.utils.DateAndTimeUtils;

public class ActiveSessionDetailPageTests3560 
{
	private SessionDetailPage3560 sessionDetailPage3560;
	private int iterationValue;
	private List<String> vibrationList;
	private List<String> tempratureList;
	private List<String> dateList;
	private List<String> timeList;
	private GestureUtils gestureUtils;
	private String sessionDetailPageSource;
	private NotificationsPage notificationsPage;
	private boolean isActiveSession;
	private WebElement mAlarmObject;
	private StringBuilder mValueHolder;
	private String gatewayName;
	private int[] mAlarmCountSensorLevel;
	private List<WebElement> mElementList;
	private String mTextNote;
	private SessionListPage sessionListPage;
	private int[] vibrationTapCordinates = new int[2];
	private int[] temperatureTapCordinates = new int[2];
	private HomePage homepage;
	private SessionDetailPage sessionDetailPage;
    
	@Parameters({"activeSessionGatewayName3560"})
	@BeforeClass(groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,"android_Bug_Automation"})
	public void initClass(@Optional("no value") String gatewayName) throws Exception
	{	
		sessionDetailPage = new SessionDetailPage();
		homepage = new HomePage();
		sessionDetailPage3560 = new SessionDetailPage3560();
		gestureUtils = new GestureUtils();
		notificationsPage = new NotificationsPage();
		mValueHolder = new StringBuilder();
		mAlarmCountSensorLevel = new int[2];
		this.isActiveSession = true;
		this.gatewayName = gatewayName;
		sessionListPage = new SessionListPage();
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) 
			ElementUtils.isDisplayed(5, sessionDetailPage3560.getWebGraphLinesObject());
		Config.appWidthCenterFlag = false;
		CommonUtils.wait(15, 15, 3);
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			sessionDetailPageSource = DriverManager.getDriver().getPageSource();
	}
	
	@Test(priority = 136601, groups = {FCCM3560.SESSION_VERIFICATION_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void deleteResetAlarmTest()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			sessionDetailPage3560.deleteAllAlarms(6);
			CommonUtils.wait(3);
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			IOSUtils.resetIOSPageSource();
			sessionDetailPage3560.navigateToSessionOptions(SessionDetailPageObjectList.ADD_EDIT_ALARM);
			if(gestureUtils.mScroll("Below Vibration Alarm", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN)) 
				sessionDetailPage3560.deleteAlarm(AlarmType.BELOW, "Below Vibration Alarm");
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
			gestureUtils.mScroll("Alarm", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.ADD_EDIT_ALARM_BUTTON).click();
			CommonUtils.wait(5);
			if(gestureUtils.mScroll("Out-of-Range Temperature Alarm", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN)) 
				sessionDetailPage3560.deleteAlarm(AlarmType.OUTOF, "Out-of-Range Temperature Alarm");
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
			gestureUtils.mScroll("Alarm", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.ADD_EDIT_ALARM_BUTTON).click();
			CommonUtils.wait(5);
			Assert.assertFalse(DriverManager.getDriver().getPageSource().contains("Below Vibration Alarm") && DriverManager.getDriver().getPageSource().contains("Out-of-Range Temperature Alarm"));
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			sessionDetailPage3560.navigateToSessionOptions(SessionDetailPageObjectList.ADD_EDIT_ALARM);
			if(gestureUtils.mScroll("Out-of-Range Vibration Alarm", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN)) 
				sessionDetailPage3560.deleteAlarm(AlarmType.OUTOF, "Out-of-Range Vibration Alarm");
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.ADD_EDIT_ALARM_BUTTON).click();
			if(gestureUtils.mScroll("Below Temperature Alarm", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN)) 
				sessionDetailPage3560.deleteAlarm(AlarmType.BELOW, "Below Temperature Alarm");
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.ADD_EDIT_ALARM_BUTTON).click();
			//second time delete to handle flaky behavior of delete
			if(gestureUtils.mScroll("Out-of-Range Vibration Alarm", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN)) 
				sessionDetailPage3560.deleteAlarm(AlarmType.OUTOF, "Out-of-Range Vibration Alarm");
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.ADD_EDIT_ALARM_BUTTON).click();
			if(gestureUtils.mScroll("Below Temperature Alarm", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN)) 
				sessionDetailPage3560.deleteAlarm(AlarmType.BELOW, "Below Temperature Alarm");
			Assert.assertFalse(gestureUtils.mScroll("Below Temperature Alarm", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN));
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.ADD_EDIT_ALARM_BUTTON).click();
			Assert.assertFalse(gestureUtils.mScroll("Out-of-Range Vibration Alarm", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN));
		}
	}
	
	@Test(priority = 136602, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void alarmCountTest()
	{
		List<WebElement> alarmIcons = sessionDetailPage3560.getSessionDetailPageObjects(SessionDetailPageObjectList.ALARM_ICONS);
		for(int i = 0; i < alarmIcons.size(); i++)
		{
			mAlarmCountSensorLevel[i] = Integer.parseInt(alarmIcons.get(i).getText());
		}
	}
	
	@Test(priority = 136603, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void addAboveVibrationAlarmTest()
	{
		CommonUtils.wait(2);
		sessionDetailPage3560.addAlarm(FeatureList.FCCM3560_VIB, AlarmType.ABOVE_VIBRATION, AlarmDataValues.FCCM3560_VIB_UNIT_INS.getValue(), AlarmDataValues.FCCM3560_ABOVE_VIB_THRESHOLD_VALUE.getValue(), AlarmDataValues.FCCM3560_ABOVE_VIB_THRESHOLD_VALUE.getValue(), null, 0, true, false, "");
	}
	
	@Test(priority = 136604, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void addWithinVibrationAlarmTest()
	{
		CommonUtils.wait(2);
		sessionDetailPage3560.addAlarm(FeatureList.FCCM3560_VIB, AlarmType.WITHIN_VIBRATION, AlarmDataValues.FCCM3560_VIB_UNIT_ACC.getValue(), AlarmDataValues.FCCM3560_WITHIN_VIB_UPPER_THRESHOLD_VALUE.getValue(), AlarmDataValues.FCCM3560_WITHIN_VIB_LOWER_THRESHOLD_VALUE.getValue(), null, 0, true, false, "");
	}
	
	@Test(priority = 136605, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void addAboveTempratureAlarmTest()
	{
		CommonUtils.wait(2);
		sessionDetailPage3560.addAlarm(FeatureList.FCCM3560_TEMP, AlarmType.ABOVE_TEMPERATURE, AlarmDataValues.FCCM3560_TEMP_UNIT_FAR.getValue(), AlarmDataValues.FCCM3560_ABOVE_TEMP_THRESHOLD_VALUE.getValue(), AlarmDataValues.FCCM3560_ABOVE_TEMP_THRESHOLD_VALUE.getValue(), null, 0, true, false, "");
	}
	
	@Test(priority = 136606, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void addWithinTempratureAlarmTest()
	{
		CommonUtils.wait(2);
		sessionDetailPage3560.addAlarm(FeatureList.FCCM3560_TEMP, AlarmType.WITHIN_TEMPERATURE, AlarmDataValues.FCCM3560_TEMP_UNIT_CEL.getValue(), AlarmDataValues.FCCM3560_WITHIN_TEMP_UPPER_THRESHOLD_VALUE.getValue(), AlarmDataValues.FCCM3560_WITHIN_TEMP_LOWER_THRESHOLD_VALUE.getValue(), null, 0, true, false, "");
	}
	
	@Test(priority = 136625, groups = {FCCM3560.SESSION_VERIFICATION_TESTS})
	public void addOutOfTempratureAlarmTest()
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			sessionDetailPage3560.addAlarm(FeatureList.FCCM3560_TEMP, AlarmType.OUTOF_TEMPERATURE, AlarmDataValues.FCCM3560_TEMP_UNIT_FAR.getValue(), AlarmDataValues.FCCM3560_OUTOF_TEMP_UPPER_THRESHOLD_VALUE.getValue(), AlarmDataValues.FCCM3560_OUTOF_TEMP_LOWER_THRESHOLD_VALUE.getValue(), ScrollDiection.DOWN, 1, true, false, "");
			CommonUtils.wait(1);
			Assert.assertTrue(DriverManager.getDriver().getPageSource().contains("Out-of-Range Temperature Alarm"));
		}
	}
	
	@Test(priority = 136626, groups = {FCCM3560.SESSION_VERIFICATION_TESTS})
	public void addBelowVibrationAlarmTest()
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			sessionDetailPage3560.addAlarm(FeatureList.FCCM3560_VIB, AlarmType.BELOW_VIBRATION, AlarmDataValues.FCCM3560_VIB_UNIT_INS.getValue(), AlarmDataValues.FCCM3560_BELOW_VIB_THRESHOLD_VALUE.getValue(), AlarmDataValues.FCCM3560_BELOW_VIB_THRESHOLD_VALUE.getValue(), ScrollDiection.DOWN, 0, true, false, "");
			CommonUtils.wait(2);
			Assert.assertTrue(DriverManager.getDriver().getPageSource().contains("Below Vibration Alarm"));
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
			CommonUtils.wait(2);
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
			CommonUtils.wait(2);
		}
	}
	
	@Test(priority = 136650, groups = {FCCM3560.SESSION_VERIFICATION_TESTS})
	public void addOutOfVibrationAlarmTest()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			sessionDetailPage3560.addAlarm(FeatureList.FCCM3560_VIB, AlarmType.OUTOF_VIBRATION, AlarmDataValues.FCCM3560_VIB_UNIT_MMS.getValue(), AlarmDataValues.FCCM3560_OUTOF_VIB_UPPER_THRESHOLD_VALUE.getValue(), AlarmDataValues.FCCM3560_OUTOF_VIB_LOWER_THRESHOLD_VALUE.getValue(), ScrollDiection.DOWN, 1, true, false, "");
			CommonUtils.wait(1);
			Assert.assertTrue(gestureUtils.mScroll("Out-of-Range Vibration Alarm", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN));
		}
	}
	
	
	@Test(priority = 136651, groups = {FCCM3560.SESSION_VERIFICATION_TESTS})
	public void addBelowTempratureAlarmTest()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			sessionDetailPage3560.addAlarm(FeatureList.FCCM3560_TEMP, AlarmType.BELOW_TEMPERATURE, AlarmDataValues.FCCM3560_TEMP_UNIT_FAR.getValue(), AlarmDataValues.FCCM3560_BELOW_TEMP_THRESHOLD_VALUE.getValue(), AlarmDataValues.FCCM3560_BELOW_TEMP_THRESHOLD_VALUE.getValue(), ScrollDiection.DOWN, 0, true, false, "");
			CommonUtils.wait(1);
			Assert.assertTrue(gestureUtils.mScroll("Below Temperature Alarm", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN));
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
			CommonUtils.wait(1);
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
			CommonUtils.wait(1);
		}
	}
	
	@Test(priority = 136701, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS})
	public void sessionTileStatusTest()
	{
		IOSUtils.setIOSPageSource(sessionDetailPageSource);
		if(isActiveSession)
			Assert.assertEquals(sessionDetailPage3560.getElementVisibleTextInSessionTileStrict(FCCM3560.sessionStatus[0]), FCCM3560.sessionStatus[0]);
	}
	
	@Test(priority = 136702, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void gateWayNameTest()
	{
		if(gatewayName.equals("no value"))
			Assert.assertEquals(sessionDetailPage3560.getElementVisibleTextInSessionTileStrict(FCCM3560.gatewayNameValue), FCCM3560.gatewayNameValue);
		else
			Assert.assertEquals(sessionDetailPage3560.getElementVisibleTextInSessionTileStrict(gatewayName), gatewayName);
	}
	
	@Test(priority = 136703, groups = {FCCM3560.UAT_TESTS, FCCM3560.PROD_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  
			FCCM3560.SESSION_VERIFICATION_TESTS,  })
	public void sensorsStaticTextVisibleTest()
	{
		Assert.assertEquals(sessionDetailPage3560.getElementVisibleTextInSessionTileStrict(Config.SENSORS_STATIC_TEXT), Config.SENSORS_STATIC_TEXT);
	}
	
	@Test(priority = 136704, groups = {FCCM3560.UAT_TESTS, FCCM3560.PROD_TESTS, 
			FCCM3560.SESSION_DETAIL_PAGE_TESTS, FCCM3560.SESSION_VERIFICATION_TESTS,  })
	public void sensorCountAndTypeTest()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			Assert.assertTrue(sessionDetailPage3560.getElementVisibleTextInSessionTileStrict(FCCM3560.androidSensorsCountAndType).contains(FCCM3560.androidSensorsCountAndType));
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertTrue(sessionDetailPage3560.getElementVisibleTextInSessionTileStrict(FCCM3560.iOSSensorsCountAndType).contains(FCCM3560.iOSSensorsCountAndType));
	}
	
	@Test(priority = 136705, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void startTimeStaticTextVisibleTest()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertEquals(sessionDetailPage3560.getElementVisibleTextInSessionTileStrict(Config.START_TIME_STATIC_TEXT), Config.START_TIME_STATIC_TEXT);
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "#new_design1").getText().contains(Config.START_STATIC_TEXT));
	}
	
	@Test(priority = 136706, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void sessionStartTimeTest()
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertTrue(sessionDetailPage3560.getElementVisibleTextInSessionTileStrict(FCCM3560.requiredSessionStartTimestamp).contains(FCCM3560.requiredSessionStartTimestamp));
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			Assert.assertTrue(sessionDetailPage3560.getElementVisibleTextInSessionTile(FCCM3560.requiredSessionStartTimestamp).contains(FCCM3560.requiredSessionStartTimestamp));
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "#new_design1").getText().contains(FCCM3560.requiredSessionStartTimestamp));
	}
	
	@Test(priority = 136707, groups = {})
	public void sessionStartUserNameTest()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "#new_design1").getText().contains(FCCM3560.sessionStartUserName));
	}
	
	@Test(priority = 136708, groups = {FCCM3560.UAT_TESTS, FCCM3560.PROD_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS, FCCM3560.SESSION_VERIFICATION_TESTS})
	public void assetCountTextVisibleTest()
	{
		Assert.assertTrue(sessionDetailPage3560.getElementInSessionTileStrict(Config.ASSET_STATIC_TEXT+" ("+1+")").isDisplayed());
	}
	
	@Test(priority = 136709, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void assetGroupNameTest()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertTrue(sessionDetailPage3560.getElementVisibleTextInSessionTileStrict(FCCM3560.assetGroupName).equals(FCCM3560.assetGroupName) || sessionDetailPage3560.getElementVisibleTextInSessionTileStrict(FCCM3560.assetGroupName).equals(FCCM3560.assetGroupName));
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".crumbTrailAssetGroupInfo").getText().equals(FCCM3560.assetGroupName) || ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".crumbTrailAssetGroupInfo").getText().equals(FCCM3560.assetGroupName));
	}
	
	@Test(priority = 136710, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS, FCCM3560.SESSION_VERIFICATION_TESTS})
	public void assetNameTest()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertEquals(sessionDetailPage3560.getElementVisibleTextInSessionTileStrict(FCCM3560.assetName), FCCM3560.assetName);
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertEquals(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".crumbTrailAssetName").getText(), FCCM3560.assetName);				
	}
	
	@Test(priority = 136711, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, 
			FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void testPointNameTest()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertEquals(sessionDetailPage3560.getElementVisibleTextInSessionTileStrict(FCCM3560.testPointName), FCCM3560.testPointName);
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertEquals(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".assetNameTextSession").getText(), FCCM3560.testPointName);				
	} 
	
	@Test(priority = 136713, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_TESTS})
	public void alarmIconTest()
	{
		List<WebElement> alarmIcons = sessionDetailPage3560.getSessionDetailPageObjects(SessionDetailPageObjectList.ALARM_ICONS);
		for(WebElement alarmIcon:alarmIcons)
		{
			Assert.assertTrue(alarmIcon.isDisplayed());
		}
	}
	
	@Test(priority = 136714, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_TESTS})
	public void alertIconTest()
	{
		List<WebElement> alertIcons = sessionDetailPage3560.getSessionDetailPageObjects(SessionDetailPageObjectList.ALERT_ICONS);
		for(WebElement alertIcon:alertIcons)
		{
			if(alertIcon.isDisplayed())
				break;
		}
	}
	
	@Test(priority = 136725, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS, FCCM3560.SESSION_VERIFICATION_TESTS})
	public void livePollingTest()
	{
		gestureUtils.mScroll("MAX", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		gestureUtils.webScroll(ScrollDiection.DOWN, 1);
		Assert.assertTrue(sessionDetailPage3560.isLivePollingHappening("./graph/bp", "./graph/ap", "./graph/dp", ".png", iterationValue, 5, 60, Config.IOS_LOCATOR_STRATEGY_NAME, FCCM3560.vibrationUnit));
	}
	
	@Test(priority = 136800, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS, FCCM3560.SESSION_VERIFICATION_TESTS})
	public void vibrationUnitTest()
	{
		gestureUtils.mScroll(FCCM3560.vibrationUnitMobile, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		Assert.assertTrue(sessionDetailPage3560.getSessionDetailPage3560Object(SessionDetailPage3560ObjectList.VIBRATION_UNIT).getText().equals(FCCM3560.vibrationUnitMobile) || sessionDetailPage3560.getSessionDetailPage3560Object(SessionDetailPage3560ObjectList.VIBRATION_UNIT).getText().equals(FCCM3560.vibrationUnitWeb)) ;
	} 
	
	@Test(priority = 136801, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, 
			FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void tempratureUnitTest()
	{
		Assert.assertTrue(sessionDetailPage3560.getSessionDetailPage3560Object(SessionDetailPage3560ObjectList.TEMPRATURE_UNIT).getText().equals(FCCM3560.tempratureUnitFarenightiOS) || sessionDetailPage3560.getSessionDetailPage3560Object(SessionDetailPage3560ObjectList.TEMPRATURE_UNIT).getText().equals(FCCM3560.tempratureUnitCelsiusiOS) || sessionDetailPage3560.getSessionDetailPage3560Object(SessionDetailPage3560ObjectList.TEMPRATURE_UNIT).getText().equals(FCCM3560.tempratureUnitFarenightAndroid) || sessionDetailPage3560.getSessionDetailPage3560Object(SessionDetailPage3560ObjectList.TEMPRATURE_UNIT).getText().equals(FCCM3560.tempratureUnitCelsiusAndroid) || sessionDetailPage3560.getSessionDetailPage3560Object(SessionDetailPage3560ObjectList.TEMPRATURE_UNIT).getText().equals(FCCM3560.tempratureUnitCelsiusWeb) || sessionDetailPage3560.getSessionDetailPage3560Object(SessionDetailPage3560ObjectList.TEMPRATURE_UNIT).getText().equals(FCCM3560.tempratureUnitFarenightWeb));
	} 
	
	@Test(priority = 136802, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, 
			FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void graphDisplayedTest()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			gestureUtils.mScroll(-400, -250, 1);
			Assert.assertTrue(sessionDetailPage3560.isGraphDisplayed(FCCM3560.vibrationUnitMobile));
		}
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(sessionDetailPage3560.isGraphDisplayed(null));
	}
	
	@Test(priority = 136803, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, 
			FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void maxLabelIn1HTabTest()
	{
		gestureUtils.mScroll("MAX", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		Assert.assertTrue(sessionDetailPage3560.getElementInSessionTileStrict("MAX").isDisplayed());
	}
	
	@Test(priority = 136804, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, 
			FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void minLabelIn1HTabTest()
	{
		Assert.assertTrue(sessionDetailPage3560.getElementInSessionTileStrict("MIN").isDisplayed());
	}
	
	@Test(priority = 136806, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, 
			FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void xAxisLabelIn1HTabTest()
	{
		gestureUtils.mScroll("Show Alarms", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
		Assert.assertTrue(sessionDetailPage3560.getElementInSessionTileStrict("X Axis").isDisplayed());
	}
	
	@Test(priority = 136807, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void yAxisLabelIn1HTabTest()
	{
		Assert.assertTrue(sessionDetailPage3560.getElementInSessionTileStrict("Y Axis").isDisplayed());
	}
	
	@Test(priority = 136808, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void zAxisLabelIn1HTabTest()
	{
		Assert.assertTrue(sessionDetailPage3560.getElementInSessionTileStrict("Z Axis").isDisplayed());
	}
	
	@Test(priority = 136809, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, 
			FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS})
	public void vibrationValueIn1HTabTest()
	{
		vibrationList = sessionDetailPage3560.getVibrationList();
		tempratureList = sessionDetailPage3560.getTempratureList();
		dateList = sessionDetailPage3560.getDateList();
		timeList = sessionDetailPage3560.getTimeList();
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			if(isActiveSession)
			{
				for(int i = 0; i < 2 ; i++) {
					timeList.remove(i);
				}
			}
			else
			{
				for(int i = 0; i < 4 ; i++) {
					timeList.remove(i);
				}
			}
		}
		for(String value:vibrationList) {	
			value = value.substring(0, value.indexOf(' '));
			Assert.assertTrue(CommonUtils.getDoubleValue(value) > 0.000 && CommonUtils.getDoubleValue(value) < 3.001);
		}
	}
	
	@Test(priority = 136810, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, 
			FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  
			FCCM3560.SESSION_VERIFICATION_TESTS,  
			  }, dependsOnMethods = {"vibrationValueIn1HTabTest"})
	public void vibrationUnitIn1HTabTest()
	{
		for(String value:vibrationList) 
		{	
			Assert.assertTrue(value.contains(FCCM3560.vibrationUnitInValue) || value.contains(FCCM3560.vibrationUnit1InValue));
		}
	}
	
	@Test(priority = 136811, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, 
			FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  
			FCCM3560.SESSION_VERIFICATION_TESTS,  
			  })
	public void tempratureValueIn1HTabTest()
	{
		for(String value:tempratureList) {	
			value = value.substring(0, value.indexOf(' '));
			Assert.assertTrue(CommonUtils.getDoubleValue(value) >= 0.0 && CommonUtils.getDoubleValue(value) < 110.0);
		}
	}
	
	@Test(priority = 136812, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, 
			FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  
			FCCM3560.SESSION_VERIFICATION_TESTS,  
			  }, dependsOnMethods = {"tempratureValueIn1HTabTest"})
	public void tempratureUnitIn1HTabTest()
	{
		for(String value:tempratureList)
		{	
			Assert.assertTrue(value.contains("°C") || value.contains("℃") || value.contains(FCCM3560.measurementValueTempratureUnitCelseiusAndroid) || value.contains(FCCM3560.measurementValueTempratureUnitFarenightAndroid) || value.contains(FCCM3560.measurementValueTempratureUnitCelseiusiOS) || value.contains(FCCM3560.measurementValueTempratureUnitFarenightiOS));
		}
	}
	
	@Test(priority = 136813, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void dateValueIn1HTabTest()
	{
		for(String value:dateList)
		{	
			Assert.assertTrue(value.contains("/"));
		}
	}
	
	@Test(priority = 136814, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, 
			FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  
			FCCM3560.SESSION_VERIFICATION_TESTS,  
			  })
	public void timeValueIn1HTabTest()
	{
		for(String value:timeList)
		{	
			Assert.assertTrue(value.contains(":"));
		}
	}
	
	@Test(priority = 136815, groups = {})
	public void scrollGraphRight1HTab()
	{
		gestureUtils.swipe(ScrollDiection.RIGHT, sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.GRAPH_OBJECT), 150);
	}
	
	@Test(priority = 136816, groups = {})
	public void scrollGraphLeft1HTab()
	{
		sessionDetailPage3560.scrollGraph(ScrollDiection.LEFT, 2);
	}
	
	@Test(priority = 136900, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, 
			FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  
			FCCM3560.SESSION_VERIFICATION_TESTS,  
			  })
	public void switchTo8HTabTest() throws Exception
	{
		sessionDetailPage3560.switchToOtherTab("8H", ScrollDiection.UP);
		gestureUtils.mScroll("Show Alarms", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
		vibrationList = sessionDetailPage3560.getVibrationList();
		tempratureList = sessionDetailPage3560.getTempratureList();
		dateList = sessionDetailPage3560.getDateList();
		timeList = sessionDetailPage3560.getTimeList();
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			if(isActiveSession)
			{
				for(int i = 0; i < 2 ; i++)
				{
					timeList.remove(i);
				}
			}
			else
			{
				for(int i = 0; i < 4 ; i++)
				{
					timeList.remove(i);
				}
			}
		}
	}
	
	@Test(priority = 136901, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, 
			FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  
			FCCM3560.SESSION_VERIFICATION_TESTS,  
			  })
	public void vibrationValueIn8HTabTest()
	{
		for(String value:vibrationList)
		{	
			value = value.substring(0, value.indexOf(' '));
			Assert.assertTrue(CommonUtils.getDoubleValue(value) > 0.000 && CommonUtils.getDoubleValue(value) < 3.001);
		}
	}
	
	@Test(priority = 136902, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, 
			FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  
			FCCM3560.SESSION_VERIFICATION_TESTS,  
			  }, dependsOnMethods = {"vibrationValueIn8HTabTest"})
	public void vibrationUnitIn8HTabTest()
	{
		for(String value:vibrationList)
		{	
			Assert.assertTrue(value.contains(FCCM3560.vibrationUnitInValue) || value.contains(FCCM3560.vibrationUnit1InValue));
		}
	}
	
	@Test(priority = 136903, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, 
			FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  
			FCCM3560.SESSION_VERIFICATION_TESTS,  
			  })
	public void tempratureValueIn8HTabTest()
	{
		for(String value:tempratureList)
		{	
			value = value.substring(0, value.indexOf(' '));
			Assert.assertTrue(CommonUtils.getDoubleValue(value) >= 0.0 && CommonUtils.getDoubleValue(value) < 110.0);
		}
	}
	
	@Test(priority = 136904, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, 
			FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  
			FCCM3560.SESSION_VERIFICATION_TESTS,  
			  },dependsOnMethods = {"tempratureValueIn8HTabTest"})
	public void tempratureUnitIn8HTabTest()
	{
		for(String value:tempratureList)
		{	
			Assert.assertTrue(value.contains("°C") || value.contains("℃") || value.contains(FCCM3560.measurementValueTempratureUnitCelseiusAndroid) || value.contains(FCCM3560.measurementValueTempratureUnitFarenightAndroid) || value.contains(FCCM3560.measurementValueTempratureUnitCelseiusiOS) || value.contains(FCCM3560.measurementValueTempratureUnitFarenightiOS));
		}
	}
	
	@Test(priority = 136905, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void dateValueIn8HTabTest()
	{
		for(String value:dateList)
		{	
			Assert.assertTrue(value.contains("/"));
		}
	}
	
	@Test(priority = 136906, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void timeValueIn8HTabTest()
	{
		for(String value:timeList)
		{	
			Assert.assertTrue(value.contains(":"));
		}
	}
	
	@Test(priority = 136907, groups = {})
	public void scrollGraphRight8HTab()
	{
		gestureUtils.swipe(ScrollDiection.RIGHT, sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.GRAPH_OBJECT), 150);
	}
	
	@Test(priority = 136908, groups = {})
	public void scrollGraphLeft8HTab()
	{
		gestureUtils.swipe(ScrollDiection.LEFT, sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.GRAPH_OBJECT), 150);
	}
	
	@Test(priority = 137000, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void switchTo1WTabTest() throws Exception
	{
		sessionDetailPage3560.switchToOtherTab("1W", ScrollDiection.UP);
		gestureUtils.mScroll("Show Alarms", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
		vibrationList = sessionDetailPage3560.getVibrationList();
		tempratureList = sessionDetailPage3560.getTempratureList();
		dateList = sessionDetailPage3560.getDateList();
		timeList = sessionDetailPage3560.getTimeList();
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			if(isActiveSession)
			{
				for(int i = 0; i < 2 ; i++)
				{
					timeList.remove(i);
				}
			}
			else
			{
				for(int i = 0; i < 4 ; i++)
				{
					timeList.remove(i);
				}
			}
		}
	}
	
	@Test(priority = 137001, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void vibrationValueIn1WTabTest()
	{
		for(String value:vibrationList)
		{	
			value = value.substring(0, value.indexOf(' '));
			Assert.assertTrue(CommonUtils.getDoubleValue(value) > 0.000 && CommonUtils.getDoubleValue(value) < 3.001);
		}
	}
	
	@Test(priority = 137002, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void vibrationUnitIn1WTabTest()
	{
		for(String value:vibrationList)
		{	
			Assert.assertTrue(value.contains(FCCM3560.vibrationUnitInValue) || value.contains(FCCM3560.vibrationUnit1InValue));
		}
	}
	
	@Test(priority = 137003, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void tempratureValueIn1WTabTest()
	{
		for(String value:tempratureList)
		{	
			value = value.substring(0, value.indexOf(' '));
			Assert.assertTrue(CommonUtils.getDoubleValue(value) >= 0.0 && CommonUtils.getDoubleValue(value) < 110.0);
		}
	}
	
	@Test(priority = 137004, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void tempratureUnitIn1WTabTest()
	{
		for(String value:tempratureList)
		{	
			Assert.assertTrue(value.contains("°C") || value.contains("℃") || value.contains(FCCM3560.measurementValueTempratureUnitCelseiusAndroid) || value.contains(FCCM3560.measurementValueTempratureUnitFarenightAndroid)|| value.contains(FCCM3560.measurementValueTempratureUnitCelseiusiOS) || value.contains(FCCM3560.measurementValueTempratureUnitFarenightiOS));
		}
	}
	
	@Test(priority = 137005, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void dateValueIn1WTabTest()
	{
		for(String value:dateList)
		{	
			Assert.assertTrue(value.contains("/"));
		}
	}
	
	@Test(priority = 137006, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void timeValueIn1WTabTest()
	{
		for(String value:timeList)
		{	
			Assert.assertTrue(value.contains(":"));
		}
	}
	
	@Test(priority = 137100, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void switchTo3WTabTest() throws Exception
	{
		sessionDetailPage3560.switchToOtherTab("3W", ScrollDiection.UP);
		gestureUtils.mScroll("Show Alarms", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
		vibrationList = sessionDetailPage3560.getVibrationList();
		tempratureList = sessionDetailPage3560.getTempratureList();
		dateList = sessionDetailPage3560.getDateList();
		timeList = sessionDetailPage3560.getTimeList();
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			if(isActiveSession)
			{
				for(int i = 0; i < 2 ; i++)
				{
					timeList.remove(i);
				}
			}
			else
			{
				for(int i = 0; i < 4 ; i++)
				{
					timeList.remove(i);
				}
			}
		}
	}
	
	@Test(priority = 137101, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void vibrationValueIn3WTabTest()
	{
		for(String value:vibrationList)
		{	
			value = value.substring(0, value.indexOf(' '));
			Assert.assertTrue(CommonUtils.getDoubleValue(value) > 0.000 && CommonUtils.getDoubleValue(value) < 3.001);
		}
	}
	
	@Test(priority = 137102, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void vibrationUnitIn3WTabTest()
	{
		for(String value:vibrationList)
		{	
			Assert.assertTrue(value.contains(FCCM3560.vibrationUnitInValue) || value.contains(FCCM3560.vibrationUnit1InValue));
		}
	}
	
	@Test(priority = 137103, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void tempratureValueIn3WTabTest()
	{
		for(String value:tempratureList)
		{	
			value = value.substring(0, value.indexOf(' '));
			Assert.assertTrue(CommonUtils.getDoubleValue(value) >= 0.0 && CommonUtils.getDoubleValue(value) < 110.0);
		}
	}
	
	@Test(priority = 137104, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void tempratureUnitIn3WTabTest()
	{
		for(String value:tempratureList)
		{	
			Assert.assertTrue(value.contains("°C") || value.contains("℃") || value.contains(FCCM3560.measurementValueTempratureUnitCelseiusAndroid) || value.contains(FCCM3560.measurementValueTempratureUnitFarenightAndroid)|| value.contains(FCCM3560.measurementValueTempratureUnitCelseiusiOS) || value.contains(FCCM3560.measurementValueTempratureUnitFarenightiOS));
		}
	}
	
	@Test(priority = 137105, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void dateValueIn3WTabTest()
	{
		for(String value:dateList)
		{	
			Assert.assertTrue(value.contains("/"));
		}
	}
	
	@Test(priority = 137106, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void timeValueIn3WTabTest()
	{
		for(String value:timeList)
		{	
			Assert.assertTrue(value.contains(":"));
		}
	}
	
	@Test(priority = 137200, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void switchToAllTabTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			sessionDetailPage3560.switchToOtherTab("ALL", ScrollDiection.UP);
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				sessionDetailPage3560.switchToOtherTab("All", ScrollDiection.UP);
			gestureUtils.mScroll("Show Alarms", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
			vibrationList = sessionDetailPage3560.getVibrationList();
			tempratureList = sessionDetailPage3560.getTempratureList();
			dateList = sessionDetailPage3560.getDateList();
			timeList = sessionDetailPage3560.getTimeList();
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				if(isActiveSession)
				{
					for(int i = 0; i < 2 ; i++)
					{
						timeList.remove(i);
					}
				}
				else
				{
					for(int i = 0; i < 4 ; i++)
					{
						timeList.remove(i);
					}
				}
			}
	}
	
	@Test(priority = 137201, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void vibrationValueInAllTabTest()
	{
		for(String value:vibrationList)
		{	
			value = value.substring(0, value.indexOf(' '));
			Assert.assertTrue(CommonUtils.getDoubleValue(value) > 0.000 && CommonUtils.getDoubleValue(value) < 3.001);
		}
	}
	
	@Test(priority = 137202, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, 
			FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS}, dependsOnMethods = {"vibrationValueInAllTabTest"})
	public void vibrationUnitInAllTabTest()
	{
		for(String value:vibrationList)
		{	
			Assert.assertTrue(value.contains(FCCM3560.vibrationUnitInValue) || value.contains(FCCM3560.vibrationUnit1InValue));
		}
	}
	
	@Test(priority = 137203, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void tempratureValueInAllTabTest()
	{
		for(String value:tempratureList)
		{	
			value = value.substring(0, value.indexOf(' '));
			Assert.assertTrue(CommonUtils.getDoubleValue(value) >= 0.0 && CommonUtils.getDoubleValue(value) < 110.0);
		}
	}
	
	@Test(priority = 137204, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, 
			FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  
			FCCM3560.SESSION_VERIFICATION_TESTS,  
			  }, dependsOnMethods = {"tempratureValueInAllTabTest"})
	public void tempratureUnitInAllTabTest()
	{
		for(String value:tempratureList)
		{	
			Assert.assertTrue(value.contains("°C") || value.contains("℃") || value.contains(FCCM3560.measurementValueTempratureUnitCelseiusAndroid) || value.contains(FCCM3560.measurementValueTempratureUnitFarenightAndroid)|| value.contains(FCCM3560.measurementValueTempratureUnitCelseiusiOS) || value.contains(FCCM3560.measurementValueTempratureUnitFarenightiOS));
		}
	}
	
	@Test(priority = 137205, groups = {FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void dateValueInAllTabTest()
	{
		for(String value:dateList)
		{	
			Assert.assertTrue(value.contains("/"));
		}
	}
	
	@Test(priority = 137206, groups = {FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void timeValueInAllTabTest()
	{
		for(String value:timeList)
		{	
			Assert.assertTrue(value.contains(":"));
		}
	}
	
	@Test(priority = 137300, groups = {FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void switchToAll3WTabTest() throws Exception
	{
		sessionDetailPage3560.switchToOtherTab("3W", ScrollDiection.UP);
		gestureUtils.mScroll("Show Alarms", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
		vibrationList = sessionDetailPage3560.getVibrationList();
		tempratureList = sessionDetailPage3560.getTempratureList();
		dateList = sessionDetailPage3560.getDateList();
		timeList = sessionDetailPage3560.getTimeList();
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			if(isActiveSession)
			{
				for(int i = 0; i < 2 ; i++)
				{
					timeList.remove(i);
				}
			}
			else
			{
				for(int i = 0; i < 4 ; i++)
				{
					timeList.remove(i);
				}
			}
		}
	}
	
	@Test(priority = 137301, groups = {FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void vibrationValueInAll3WTabTest()
	{
		for(String value:vibrationList)
		{	
			value = value.substring(0, value.indexOf(' '));
			Assert.assertTrue(CommonUtils.getDoubleValue(value) > 0.000 && CommonUtils.getDoubleValue(value) < 3.001);
		}
	}
	
	@Test(priority = 137302, groups = {FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void vibrationUnitInAll3WTabTest()
	{
		for(String value:vibrationList)
		{	
			Assert.assertTrue(value.contains(FCCM3560.vibrationUnitInValue) || value.contains(FCCM3560.vibrationUnit1InValue));
		}
	}
	
	@Test(priority = 137303, groups = {FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void tempratureValueInAll3WTabTest()
	{
		for(String value:tempratureList)
		{	
			value = value.substring(0, value.indexOf(' '));
			Assert.assertTrue(CommonUtils.getDoubleValue(value) >= 0.0 && CommonUtils.getDoubleValue(value) < 110.0);
		}
	}
	
	@Test(priority = 137304, groups = {FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void tempratureUnitInAll3WTabTest()
	{
		for(String value:tempratureList)
		{	
			Assert.assertTrue(value.contains("°C") || value.contains("℃") || value.contains(FCCM3560.measurementValueTempratureUnitCelseiusAndroid) || value.contains(FCCM3560.measurementValueTempratureUnitFarenightAndroid)|| value.contains(FCCM3560.measurementValueTempratureUnitCelseiusiOS) || value.contains(FCCM3560.measurementValueTempratureUnitFarenightiOS));
		}
	}
	
	@Test(priority = 137305, groups = {FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void dateValueInAll3WTabTest()
	{
		for(String value:dateList)
		{	
			Assert.assertTrue(value.contains("/"));
		}
	}
	
	@Test(priority = 137306, groups = {FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void timeValueInAll3WTabTest()
	{
		for(String value:timeList)
		{	
			Assert.assertTrue(value.contains(":"));
		}
	}
	
	@Test(priority = 137400, groups = {FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void switchTo3W1WTabTest() throws Exception
	{
		sessionDetailPage3560.switchToOtherTab("1W", ScrollDiection.UP);
		gestureUtils.mScroll("Show Alarms", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
		vibrationList = sessionDetailPage3560.getVibrationList();
		tempratureList = sessionDetailPage3560.getTempratureList();
		dateList = sessionDetailPage3560.getDateList();
		timeList = sessionDetailPage3560.getTimeList();
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			if(isActiveSession)
			{
				for(int i = 0; i < 2 ; i++)
				{
					timeList.remove(i);
				}
			}
			else
			{
				for(int i = 0; i < 4 ; i++)
				{
					timeList.remove(i);
				}
			}
		}
	}
	
	@Test(priority = 137401, groups = {FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void vibrationValueIn3W1WTabTest()
	{
		for(String value:vibrationList)
		{	
			value = value.substring(0, value.indexOf(' '));
			Assert.assertTrue(CommonUtils.getDoubleValue(value) > 0.000 && CommonUtils.getDoubleValue(value) < 3.001);
		}
	}
	
	@Test(priority = 137402, groups = {FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void vibrationUnitIn3W1WTabTest()
	{
		for(String value:vibrationList)
		{	
			Assert.assertTrue(value.contains(FCCM3560.vibrationUnitInValue) || value.contains(FCCM3560.vibrationUnit1InValue));
		}
	}
	
	@Test(priority = 137403, groups = {FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void tempratureValueIn3W1WTabTest()
	{
		for(String value:tempratureList)
		{	
			value = value.substring(0, value.indexOf(' '));
			Assert.assertTrue(CommonUtils.getDoubleValue(value) >= 0.0 && CommonUtils.getDoubleValue(value) < 110.0);
		}
	}
	
	@Test(priority = 137404, groups = {FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void tempratureUnitIn3W1WTabTest()
	{
		for(String value:tempratureList)
		{	
			Assert.assertTrue(value.contains("°C") || value.contains("℃") || value.contains(FCCM3560.measurementValueTempratureUnitCelseiusAndroid) || value.contains(FCCM3560.measurementValueTempratureUnitFarenightAndroid)|| value.contains(FCCM3560.measurementValueTempratureUnitCelseiusiOS) || value.contains(FCCM3560.measurementValueTempratureUnitFarenightiOS));
		}
	}
	
	@Test(priority = 137405, groups = {FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void dateValueIn3W1WTabTest()
	{
		for(String value:dateList)
		{	
			Assert.assertTrue(value.contains("/"));
		}
	}
	
	@Test(priority = 137406, groups = {FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void timeValueIn3W1WTabTest()
	{
		for(String value:timeList)
		{	
			Assert.assertTrue(value.contains(":"));
		}
	}
	
	@Test(priority = 137500, groups = {FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void switchTo1W8HTabTest() throws Exception
	{
		sessionDetailPage3560.switchToOtherTab("8H", ScrollDiection.UP);
		gestureUtils.mScroll("Show Alarms", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
		vibrationList = sessionDetailPage3560.getVibrationList();
		tempratureList = sessionDetailPage3560.getTempratureList();
		dateList = sessionDetailPage3560.getDateList();
		timeList = sessionDetailPage3560.getTimeList();
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			if(isActiveSession)
			{
				for(int i = 0; i < 2 ; i++)
				{
					timeList.remove(i);
				}
			}
			else
			{
				for(int i = 0; i < 4 ; i++)
				{
					timeList.remove(i);
				}
			}
		}
	}
	
	@Test(priority = 137501, groups = {FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void vibrationValueIn1W8HTabTest()
	{
		for(String value:vibrationList)
		{	
			value = value.substring(0, value.indexOf(' '));
			Assert.assertTrue(CommonUtils.getDoubleValue(value) > 0.000 && CommonUtils.getDoubleValue(value) < 3.001);
		}
	}
	
	@Test(priority = 137502, groups = {FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void vibrationUnitIn1W8HTabTest()
	{
		for(String value:vibrationList)
		{	
			Assert.assertTrue(value.contains(FCCM3560.vibrationUnitInValue) || value.contains(FCCM3560.vibrationUnit1InValue));
		}
	}
	
	@Test(priority = 137503, groups = {FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void tempratureValueIn1W8HTabTest()
	{
		for(String value:tempratureList)
		{	
			value = value.substring(0, value.indexOf(' '));
			Assert.assertTrue(CommonUtils.getDoubleValue(value) >= 0.0 && CommonUtils.getDoubleValue(value) < 110.0);
		}
	}
	
	@Test(priority = 137504, groups = {FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void tempratureUnitIn1W8HTabTest()
	{
		for(String value:tempratureList)
		{	
			Assert.assertTrue(value.contains("°C") || value.contains("℃") || value.contains(FCCM3560.measurementValueTempratureUnitCelseiusAndroid) || value.contains(FCCM3560.measurementValueTempratureUnitFarenightAndroid)|| value.contains(FCCM3560.measurementValueTempratureUnitCelseiusiOS) || value.contains(FCCM3560.measurementValueTempratureUnitFarenightiOS));
		}
	}
	
	@Test(priority = 137505, groups = {FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void dateValueIn1W8HTabTest()
	{
		for(String value:dateList)
		{	
			Assert.assertTrue(value.contains("/"));
		}
	}
	
	@Test(priority = 137506, groups = {FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void timeValueIn1W8HTabTest()
	{
		for(String value:timeList)
		{	
			Assert.assertTrue(value.contains(":"));
		}
	}
	
	@Test(priority = 137507, groups = {})
	public void scrollGraphRight1W8HTab()
	{
		sessionDetailPage3560.scrollGraph(ScrollDiection.RIGHT, 4);
	}
	
	@Test(priority = 137508, groups = {})
	public void scrollGraphLeft1W8HTab()
	{
		sessionDetailPage3560.scrollGraph(ScrollDiection.LEFT, 2);
	}
	
	@Test(priority = 137600, groups = {FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void switchTo8H1HTabTest() throws Exception
	{
		sessionDetailPage3560.switchToOtherTab("1H", ScrollDiection.UP);
		gestureUtils.mScroll("Show Alarms", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
		vibrationList = sessionDetailPage3560.getVibrationList();
		tempratureList = sessionDetailPage3560.getTempratureList();
		dateList = sessionDetailPage3560.getDateList();
		timeList = sessionDetailPage3560.getTimeList();
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			if(isActiveSession)
			{
				for(int i = 0; i < 2 ; i++)
				{
					timeList.remove(i);
				}
			}
			else
			{
				for(int i = 0; i < 4 ; i++)
				{
					timeList.remove(i);
				}
			}
		}
	}
	
	@Test(priority = 137601, groups = {FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void vibrationValueIn8H1HTabTest()
	{
		for(String value:vibrationList)
		{	
			value = value.substring(0, value.indexOf(' '));
			Assert.assertTrue(CommonUtils.getDoubleValue(value) > 0.000 && CommonUtils.getDoubleValue(value) < 3.001);
		}
	}
	
	@Test(priority = 137602, groups = {FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void vibrationUnitIn8H1HTabTest()
	{
		for(String value:vibrationList)
		{	
			Assert.assertTrue(value.contains(FCCM3560.vibrationUnitInValue) || value.contains(FCCM3560.vibrationUnit1InValue));
		}
	}
	
	@Test(priority = 137603, groups = {FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void tempratureValueIn8H1HTabTest()
	{
		for(String value:tempratureList)
		{	
			value = value.substring(0, value.indexOf(' '));
			Assert.assertTrue(CommonUtils.getDoubleValue(value) >= 0.0 && CommonUtils.getDoubleValue(value) < 110.0);
		}
	}
	
	@Test(priority = 137604, groups = {FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void tempratureUnitIn8H1HTabTest()
	{
		for(String value:tempratureList)
		{	
			Assert.assertTrue(value.contains("°C") || value.contains("℃") || value.contains(FCCM3560.measurementValueTempratureUnitCelseiusAndroid) || value.contains(FCCM3560.measurementValueTempratureUnitFarenightAndroid)|| value.contains(FCCM3560.measurementValueTempratureUnitCelseiusiOS) || value.contains(FCCM3560.measurementValueTempratureUnitFarenightiOS));
		}
	}
	
	@Test(priority = 137605, groups = {FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS,  FCCM3560.SESSION_VERIFICATION_TESTS,    })
	public void dateValueIn8H1HTabTest()
	{
		for(String value:dateList)
		{	
			Assert.assertTrue(value.contains("/"));
		}
	}
	
	@Test(priority = 137606, groups = {FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_DETAIL_PAGE_TESTS, FCCM3560.SESSION_VERIFICATION_TESTS})
	public void timeValueIn8H1HTabTest()
	{
		for(String value:timeList)
		{	
			Assert.assertTrue(value.contains(":"));
		}
	}
	
	/*
	 * iOS -- Below Vibration, Out Of Alarm Temperature
	 * Android -- Out-of-Range Vibration Alarm, Below Temperature Alarm
	 * Web -- Above Vibration Alarm, Within Vibration Alarm, Above Temperature Alarm, Within Temperature Alarm
	 */
	

	@Test(priority = 137615, groups = {FCCM3560.SESSION_VERIFICATION_TESTS})
	public void belowVibrationShowAlarmTest() {
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			sessionDetailPage3560.getSessionDetailPage3560Object(SessionDetailPage3560ObjectList.SHOW_ALARMS).click();
			CommonUtils.wait(10);
			mAlarmObject = null;
			mAlarmObject = ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_XPATH, FCCM.AlarmObject.IOS_SESSION_BELOW_VIBRATION.getObject(), null, null);
			Assert.assertNotNull(mAlarmObject);
		}
	}
	
	@Test(priority = 137616, groups = {FCCM3560.SESSION_VERIFICATION_TESTS})
	public void belowVibrationAssetGroupNameShowAlarmsTest() {
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			Assert.assertNotNull(ElementUtils.getElement(mAlarmObject, null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, FCCM.AlarmText.SESSION_ACTIVITY_ASSET_GROUP.getText(), null, null));
		}
	}

	@Test(priority = 137617, groups = {FCCM3560.SESSION_VERIFICATION_TESTS})
	public void belowVibrationAssetNameShowAlarmsTest() {
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			Assert.assertNotNull(ElementUtils.getElement(mAlarmObject, null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, FCCM.AlarmText.SESSION_ACTIVITY_ASSET.getText(), null, null));
		}
	}

	@Test(priority = 137618, groups = {FCCM3560.SESSION_VERIFICATION_TESTS})
	public void belowVibrationTestPointNameShowAlarmTest() {
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			Assert.assertNotNull(ElementUtils.getElement(mAlarmObject, null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, FCCM.AlarmText.SESSION_ACTIVITY_TEST_POINT.getText(), null, null));
		}
	}

	@Test(priority = 137619, groups = {FCCM3560.SESSION_VERIFICATION_TESTS})
	public void belowVibrationUnitShowAlarmTest() {
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			Assert.assertNotNull(ElementUtils.getElement(mAlarmObject, null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, AlarmDataValues.FCCM3560_VIB_UNIT_INS.getValue(), null, null));
		}
	}

	@Test(priority = 137620, groups = {FCCM3560.SESSION_VERIFICATION_TESTS})
	public void outOfAlarmTempratureShowAlarmsTest() {
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			CommonUtils.wait(1);
			mAlarmObject = null;
			mAlarmObject = ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_XPATH, FCCM.AlarmObject.IOS_SESSION_OUTOF_TEMPERATURE.getObject(), null, null);
			Assert.assertNotNull(mAlarmObject);
		}
	}

	@Test(priority = 137621, groups = {FCCM3560.SESSION_VERIFICATION_TESTS})
	public void outOfAlarmTempratureAssetGroupNameShowAlarmTest() {
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			Assert.assertNotNull(ElementUtils.getElement(mAlarmObject, null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, FCCM.AlarmText.SESSION_ACTIVITY_ASSET_GROUP.getText(), null, null));
		}
	}

	@Test(priority = 137622, groups = {FCCM3560.SESSION_VERIFICATION_TESTS})
	public void outOfAlarmTempratureAssetNameShowAlarmTest() {
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			Assert.assertNotNull(ElementUtils.getElement(mAlarmObject, null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, FCCM.AlarmText.SESSION_ACTIVITY_ASSET.getText(), null, null));
		}
	}

	@Test(priority = 137623, groups = {FCCM3560.SESSION_VERIFICATION_TESTS})
	public void outOfAlarmTempratureTestPointNameShowAlarmsTest() {
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			Assert.assertNotNull(ElementUtils.getElement(mAlarmObject, null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, FCCM.AlarmText.SESSION_ACTIVITY_TEST_POINT.getText(), null, null));
			ElementUtils.safeClick(sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON));
		}
	}
	
	@Test(priority = 137625, groups = {FCCM3560.SESSION_VERIFICATION_TESTS})
	public void outOfRangeVibrationShowAlarmTest() {
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			Config.isScrollCountFixed = true;
			Config.maxFixedScrollCount = 20;
			sessionDetailPage3560.getSessionDetailPage3560Object(SessionDetailPage3560ObjectList.SHOW_ALARMS).click();
			CommonUtils.wait(7);
			gestureUtils.mScroll(FCCM.AlarmText.ANDROID_SESSION_OUTOF_VIB.getText(), null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
			mAlarmObject = null;
			mAlarmObject = ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_XPATH, FCCM.AlarmObject.ANDROID_SESSION_OUTOF_VIBRATION.getObject(), null, null, null, null);
			Assert.assertNotNull(mAlarmObject);
		}
	}
	
	@Test(priority = 137626, groups = {FCCM3560.SESSION_VERIFICATION_TESTS}, dependsOnMethods = {"outOfRangeVibrationShowAlarmTest"})
	public void outOfRangeVibrationAssetGroupNameShowAlarmsTest() {
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			Assert.assertNotNull(ElementUtils.getElement(mAlarmObject, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, FCCM.AlarmText.SESSION_ACTIVITY_ASSET_GROUP.getText(), null, null, null, null));
		}
	}

	@Test(priority = 137627, groups = {FCCM3560.SESSION_VERIFICATION_TESTS}, dependsOnMethods = {"outOfRangeVibrationShowAlarmTest"})
	public void outOfRangeVibrationAssetNameShowAlarmsTest() {
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			Assert.assertNotNull(ElementUtils.getElement(mAlarmObject, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, FCCM.AlarmText.SESSION_ACTIVITY_ASSET.getText(), null, null, null, null));
		}
	}
	
	@Test(priority = 137628, groups = {FCCM3560.SESSION_VERIFICATION_TESTS}, dependsOnMethods = {"outOfRangeVibrationShowAlarmTest"})
	public void outOfRangeVibrationTestPointNameShowAlarmTest() {
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			Assert.assertNotNull(ElementUtils.getElement(mAlarmObject, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, FCCM.AlarmText.SESSION_ACTIVITY_TEST_POINT.getText(), null, null, null, null));
		}
	}

	@Test(priority = 137629, groups = {FCCM3560.SESSION_VERIFICATION_TESTS}, dependsOnMethods = {"outOfRangeVibrationShowAlarmTest"})
	public void outOfRangeVibrationUnitShowAlarmTest() {
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			Assert.assertNotNull(ElementUtils.getElement(mAlarmObject, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, AlarmDataValues.FCCM3560_VIB_UNIT_MMS.getValue(), null, null, null, null));
		}
	}
	
	@Test(priority = 137631, groups = {FCCM3560.SESSION_VERIFICATION_TESTS})
	public void belowTemperatureShowAlarmTest() {
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.BACK_BUTTON).click();
			sessionDetailPage3560.getSessionDetailPage3560Object(SessionDetailPage3560ObjectList.SHOW_ALARMS).click();
			CommonUtils.wait(5);
			gestureUtils.mScroll(FCCM.AlarmText.ANDROID_SESSION_BELOW_TEMP.getText(), null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
			mAlarmObject = null;
			mAlarmObject = ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_XPATH, FCCM.AlarmObject.ANDROID_SESSION_BELOW_TEMPERATURE.getObject(), null, null, null, null);
			Assert.assertNotNull(mAlarmObject);
		}
	}
	
	@Test(priority = 137632, groups = {FCCM3560.SESSION_VERIFICATION_TESTS}, dependsOnMethods = {"belowTemperatureShowAlarmTest"})
	public void belowTemperatureAssetGroupNameShowAlarmsTest() {
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			Assert.assertNotNull(ElementUtils.getElement(mAlarmObject, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, FCCM.AlarmText.SESSION_ACTIVITY_ASSET_GROUP.getText(), null, null, null, null));
		}
	}

	@Test(priority = 137633, groups = {FCCM3560.SESSION_VERIFICATION_TESTS}, dependsOnMethods = {"belowTemperatureShowAlarmTest"})
	public void belowTemperatureAssetNameShowAlarmsTest() {
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			Assert.assertNotNull(ElementUtils.getElement(mAlarmObject, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, FCCM.AlarmText.SESSION_ACTIVITY_ASSET.getText(), null, null, null, null));
		}
	}
	
	@Test(priority = 137634, groups = {FCCM3560.SESSION_VERIFICATION_TESTS}, dependsOnMethods = {"belowTemperatureShowAlarmTest"})
	public void belowTemperatureTestPointNameShowAlarmTest() {
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			Assert.assertNotNull(ElementUtils.getElement(mAlarmObject, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, FCCM.AlarmText.SESSION_ACTIVITY_TEST_POINT.getText(), null, null, null, null));
		}
	}

	@Test(priority = 137635, groups = { FCCM3560.SESSION_VERIFICATION_TESTS })
	public void belowTemperatureUnitShowAlarmTest() {
		try {
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
				Assert.assertNotNull(ElementUtils.getElement(mAlarmObject, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, AlarmDataValues.FCCM3560_TEMP_UNIT_FAR.getValue(), null, null, null, null));
				Config.isScrollCountFixed = false;
				Config.maxFixedScrollCount = 10;
				sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.BACK_BUTTON).click();
			}
		} catch (Throwable e) {
			Config.isScrollCountFixed = false;
			Config.maxFixedScrollCount = 10;
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.BACK_BUTTON).click();
		}
	}

	@Test(priority = 137650, groups = {})
	public void newAlarmCountTest() throws Exception
	{
		gestureUtils.webScroll(ScrollDiection.UP, 1);
		sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.BACK_BUTTON).click();
		DriverManager.getDriver().navigate().refresh();
		CommonUtils.wait(5, 5, 10);
		ElementUtils.isDisplayed(5, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, "Sensors", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, "Sensors", LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".sessionGatewaySensorsTitle"); // to ensure active monitoring session page is loaded properly
		IOSUtils.setIOSPageSource();
		gestureUtils.mScroll(FCCM3560.requiredSessionStartTimestamp, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		sessionListPage.initSessionCellElement(FCCM3560.requiredSessionStartTimestamp); 
		ElementUtils.getElement(sessionListPage.getSessionTile(), LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, FCCM3560.requiredSessionStartTimestamp, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, FCCM3560.requiredSessionStartTimestamp, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_SPAN_TEXT_CONTAINS, FCCM3560.requiredSessionStartTimestamp).click();
		CommonUtils.wait(5, 5, 15);
		sessionDetailPage3560.isGraphDisplayed(FCCM3560.DataValues.WEB_GRAPH_UNIT_INS.getValue());
		List<WebElement> alarmIcons = sessionDetailPage3560.getSessionDetailPageObjects(SessionDetailPageObjectList.ALARM_ICONS);
		for(int i = 0; i < alarmIcons.size(); i++) {
			Assert.assertTrue(Integer.parseInt(alarmIcons.get(i).getText()) >= mAlarmCountSensorLevel[i] + 4);
		}
	}
	
	@Test(priority = 137651, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void sessionAlertCountTest()
	{
		Assert.assertTrue(Integer.parseInt(sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ALERT_COUNT).getText()) >= 1);
	} 

	@Test(priority = 138301, groups = { FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void aboveVibrationTitleSessionActivityTest() throws Exception
	{
		
		mAlarmObject = null;
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			gestureUtils.webScroll(ScrollDiection.UP, 2);
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.MORE_OPTIONS_BUTTON).click();
			CommonUtils.wait(1);
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.VIEW_SESSION_ACTIVITY).click();
			CommonUtils.wait(10);
			mAlarmObject = ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, FCCM.AlarmObject.WEB_SESSION_ABOVE_VIBRATION.getObject());
			Assert.assertNotNull(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT, FCCM.AlarmText.WEB_SESSION_ACTIVITY_ABOVE_VIBRATION.getText()).isDisplayed());
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			sessionDetailPage3560.navigateToSessionOptions(SessionDetailPageObjectList.VIEW_SESSION_ACTIVITY);
			CommonUtils.wait(10);
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.DURATION_FILTER_DROPDOWN_ICON).click();
			for(int i = 0; i < 8; i++) {
				gestureUtils.scrollIOSPickerWheel(sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.DURATION_DROP_DOWN_LIST), ScrollDiection.DOWN);
			}
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.DURATION_DROP_DOWN_LIST_DONE_BUTTON).click();
			mAlarmObject = ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, FCCM.AlarmObject.WEB_SESSION_ABOVE_VIBRATION.getObject());
			Assert.assertNotNull(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT, FCCM.AlarmText.WEB_SESSION_ACTIVITY_ABOVE_VIBRATION.getText()).isDisplayed());
		}
	}
	
	@Test(priority = 138302, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void aboveVibrationThresholdSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mValueHolder.delete(0, mValueHolder.length());
			mValueHolder.append(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_THRESHOLD.getObject()).getText());
			Assert.assertTrue(mValueHolder.toString().contains(AlarmDataValues.FCCM3560_ABOVE_VIB_THRESHOLD_VALUE.getValue()) && (mValueHolder.toString().contains(AlarmDataValues.FCCM3560_VIB_UNIT_INS.getValue())) && (mValueHolder.toString().contains(">")));
		}
	}
	
	@Test(priority = 138303, groups = {})
	public void aboveVibrationTimestampSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mValueHolder.delete(0, mValueHolder.length());
			mValueHolder.append(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_ALARM_TIMESTAMP.getObject()).getText());
			Assert.assertTrue(mValueHolder.toString().contains(DateAndTimeUtils.getCurrentTimeStamp(AlarmDataValues.FCCM3560_DATE_FORMAT_WEB.getValue())));
		}
	}
	
	@Test(priority = 138304, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void aboveVibrationValueSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				Assert.assertTrue(Double.parseDouble((ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_TRIGGERED_VALUE.getObject()).getText().split(" ")[0])) > 0.0);
	}
	
	@Test(priority = 138305, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void aboveVibrationUnitSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mElementList = ElementUtils.getElements(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_TRIGGERED_UNIT.getObject());
			for(WebElement element: mElementList) {
				Assert.assertTrue(element.getText().equals(AlarmDataValues.FCCM3560_VIB_UNIT_INS.getValue()));
			}
		}
	}
	
	@Test(priority = 138306, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void aboveVibrationAssetGroupNameSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_ASSET_GROUP.getObject()).getText().equals(AlarmDataValues.FCCM3560_ASSET_GROUP_NAME_OLD.getValue()));
	}
	
	@Test(priority = 138307, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void aboveVibrationAssetNameSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				Assert.assertTrue(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_ASSET.getObject()).getText().equals(AlarmDataValues.FCCM3560_ASSET_NAME_OLD.getValue()));
	}
	
	@Test(priority = 138351, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void withinVibrationTitleSessionActivityTest() throws Exception
	{
		mAlarmObject = null;
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			mAlarmObject = ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, FCCM.AlarmObject.WEB_SESSION_WITHIN_VIBRATION.getObject());
			Assert.assertNotNull(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT, FCCM.AlarmText.WEB_SESSION_ACTIVITY_WITHIN_VIBRATION.getText()).isDisplayed());
		}
	}
	
	@Test(priority = 138352, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void withinVibrationThresholdSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mValueHolder.delete(0, mValueHolder.length());
			mValueHolder.append(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_THRESHOLD.getObject()).getText());
			Assert.assertTrue(mValueHolder.toString().contains(AlarmDataValues.FCCM3560_WITHIN_VIB_UPPER_THRESHOLD_VALUE.getValue()) && (mValueHolder.toString().contains(AlarmDataValues.FCCM3560_VIB_UNIT_ACC.getValue())) && (mValueHolder.toString().contains(AlarmDataValues.FCCM3560_WITHIN_VIB_LOWER_THRESHOLD_VALUE.getValue())) && (mValueHolder.toString().contains("-")));
		}
	}
	
	@Test(priority = 138353, groups = {})
	public void withinVibrationTimestampSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mValueHolder.delete(0, mValueHolder.length());
			mValueHolder.append(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_ALARM_TIMESTAMP.getObject()).getText());
			Assert.assertTrue(mValueHolder.toString().contains(DateAndTimeUtils.getCurrentTimeStamp(AlarmDataValues.FCCM3560_DATE_FORMAT_WEB.getValue())));
		}
	}
	
	@Test(priority = 138354, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void withinVibrationValueSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				Assert.assertTrue(Double.parseDouble((ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_TRIGGERED_VALUE.getObject()).getText().split(" ")[0])) > 0.0);
	}
	
	@Test(priority = 138355, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void withinVibrationUnitSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mElementList = ElementUtils.getElements(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_TRIGGERED_UNIT.getObject());
			for(WebElement element: mElementList) {
				Assert.assertTrue(element.getText().equals(AlarmDataValues.FCCM3560_VIB_UNIT_ACC.getValue()));
			}
		}
	}
	
	@Test(priority = 138356, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void withinVibrationAssetGroupNameSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_ASSET_GROUP.getObject()).getText().equals(AlarmDataValues.FCCM3560_ASSET_GROUP_NAME_OLD.getValue()));
	}
	
	@Test(priority = 138357, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void withinVibrationAssetNameSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				Assert.assertTrue(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_ASSET.getObject()).getText().equals(AlarmDataValues.FCCM3560_ASSET_NAME_OLD.getValue()));
	}
	
	@Test(priority = 138401, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void aboveTempratureTitleSessionActivityTest() throws Exception
	{
		mAlarmObject = null;
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			mAlarmObject = ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, FCCM.AlarmObject.WEB_SESSION_ABOVE_TEMPRATURE.getObject());
			Assert.assertNotNull(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT, FCCM.AlarmText.WEB_SESSION_ACTIVITY_ABOVE_TEMPRATURE.getText()).isDisplayed());
		}
	}
	
	@Test(priority = 138402, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void aboveTempratureThresholdSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mValueHolder.delete(0, mValueHolder.length());
			mValueHolder.append(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_THRESHOLD.getObject()).getText());
			Assert.assertTrue(mValueHolder.toString().contains(AlarmDataValues.FCCM3560_ABOVE_TEMP_THRESHOLD_VALUE.getValue()) && (mValueHolder.toString().contains(AlarmDataValues.FCCM3560_TEMP_UNIT_FAR.getValue())) && (mValueHolder.toString().contains(">")));
		}
	}
	
	@Test(priority = 138403, groups = {})
	public void aboveTempratureTimestampSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mValueHolder.delete(0, mValueHolder.length());
			mValueHolder.append(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_ALARM_TIMESTAMP.getObject()).getText());
			Assert.assertTrue(mValueHolder.toString().contains(DateAndTimeUtils.getCurrentTimeStamp(AlarmDataValues.FCCM3560_DATE_FORMAT_WEB.getValue())));
		}
	}
	
	@Test(priority = 138404, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void aboveTempratureValueSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				Assert.assertTrue(Double.parseDouble((ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_TRIGGERED_VALUE.getObject()).getText().split(" ")[0])) > 0.0);
	}
	
	@Test(priority = 138405, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void aboveTempratureUnitSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mElementList = ElementUtils.getElements(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_TRIGGERED_UNIT.getObject());
			for(WebElement element: mElementList) {
				Assert.assertTrue(element.getText().contains(AlarmDataValues.FCCM3560_TEMP_UNIT_FAR.getValue()) || element.getText().contains(AlarmDataValues.FCCM3560_TEMP_UNIT_CEL.getValue()));
			}
		}
	}
	
	@Test(priority = 138406, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void aboveTempratureAssetGroupNameSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_ASSET_GROUP.getObject()).getText().equals(AlarmDataValues.FCCM3560_ASSET_GROUP_NAME_OLD.getValue()));
	}
	
	@Test(priority = 138407, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void aboveTempratureAssetNameSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				Assert.assertTrue(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_ASSET.getObject()).getText().equals(AlarmDataValues.FCCM3560_ASSET_NAME_OLD.getValue()));
	}
	
	@Test(priority = 138451, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void withinTempratureTitleSessionActivityTest() throws Exception
	{
		mAlarmObject = null;
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			mAlarmObject = ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, FCCM.AlarmObject.WEB_SESSION_WITHIN_TEMPRATURE.getObject());
			Assert.assertNotNull(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT, FCCM.AlarmText.WEB_SESSION_ACTIVITY_WITHIN_TEMPRATURE.getText()).isDisplayed());
		}
	}
	
	@Test(priority = 138452, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void withinTempratureThresholdSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mValueHolder.delete(0, mValueHolder.length());
			mValueHolder.append(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_THRESHOLD.getObject()).getText());
			Assert.assertTrue(mValueHolder.toString().contains(AlarmDataValues.FCCM3560_WITHIN_TEMP_UPPER_THRESHOLD_VALUE.getValue()) && (mValueHolder.toString().contains(AlarmDataValues.FCCM3560_TEMP_UNIT_FAR.getValue())) && (mValueHolder.toString().contains(AlarmDataValues.FCCM3560_WITHIN_TEMP_LOWER_THRESHOLD_VALUE.getValue())) && (mValueHolder.toString().contains("-")));
		}
	}
	
	@Test(priority = 138453, groups = {})
	public void withinTempratureTimestampSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mValueHolder.delete(0, mValueHolder.length());
			mValueHolder.append(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_ALARM_TIMESTAMP.getObject()).getText());
			Assert.assertTrue(mValueHolder.toString().contains(DateAndTimeUtils.getCurrentTimeStamp(AlarmDataValues.FCCM3560_DATE_FORMAT_WEB.getValue())));
		}
	}
	
	@Test(priority = 138454, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void withinTempratureValueSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				Assert.assertTrue(Double.parseDouble((ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_TRIGGERED_VALUE.getObject()).getText().split(" ")[0])) > 0.0);
	}
	
	@Test(priority = 138455, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void withinTempratureUnitSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mElementList = ElementUtils.getElements(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_TRIGGERED_UNIT.getObject());
			for(WebElement element: mElementList) {
				Assert.assertTrue(element.getText().contains(AlarmDataValues.FCCM3560_TEMP_UNIT_FAR.getValue()) || element.getText().contains(AlarmDataValues.FCCM3560_TEMP_UNIT_CEL.getValue()));
			}
		}
	}
	
	@Test(priority = 138456, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void withinTempratureAssetGroupNameSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_ASSET_GROUP.getObject()).getText().equals(AlarmDataValues.FCCM3560_ASSET_GROUP_NAME_OLD.getValue()));
	}
	
	@Test(priority = 138457, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void withinTempratureAssetNameSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				Assert.assertTrue(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_ASSET.getObject()).getText().equals(AlarmDataValues.FCCM3560_ASSET_NAME_OLD.getValue()));
	}
	
	@Test(priority = 138465, groups = { FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void belowVibrationAlarmTest() {
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			sessionDetailPage3560.navigateToSessionOptions(SessionDetailPageObjectList.VIEW_SESSION_ACTIVITY);
			CommonUtils.wait(10);
			mAlarmObject = null;
			mAlarmObject = ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_XPATH, FCCM.AlarmObject.IOS_SESSION_BELOW_VIBRATION.getObject(), null, null);
			Assert.assertNotNull(mAlarmObject);
		}
	}
	
	@Test(priority = 138466, groups = { FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void belowVibrationAssetGroupNameSessionActivityTest() {
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			Assert.assertNotNull(ElementUtils.getElement(mAlarmObject, null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, FCCM.AlarmText.SESSION_ACTIVITY_ASSET_GROUP.getText(), null, null));
		}
	}

	@Test(priority = 138467, groups = { FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void belowVibrationAssetNameSessionActivityTest() {
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			Assert.assertNotNull(ElementUtils.getElement(mAlarmObject, null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, FCCM.AlarmText.SESSION_ACTIVITY_ASSET.getText(), null, null));
		}
	}

	@Test(priority = 138468, groups = { FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void belowVibrationTestPointNameSessionActivityTest() {
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			Assert.assertNotNull(ElementUtils.getElement(mAlarmObject, null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, FCCM.AlarmText.SESSION_ACTIVITY_TEST_POINT.getText(), null, null));
		}
	}

	@Test(priority = 138469, groups = { FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void belowVibrationUnitSessionActivityTest() {
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			Assert.assertNotNull(ElementUtils.getElement(mAlarmObject, null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, AlarmDataValues.FCCM3560_VIB_UNIT_INS.getValue(), null, null));
		}
	}

	@Test(priority = 138470, groups = { FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void outOfAlarmTempratureTest() {
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			CommonUtils.wait(1);
			mAlarmObject = null;
			mAlarmObject = ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_XPATH, FCCM.AlarmObject.IOS_SESSION_OUTOF_TEMPERATURE.getObject(), null, null);
			Assert.assertNotNull(mAlarmObject);
		}
	}

	@Test(priority = 138471, groups = { FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void outOfAlarmTempratureAssetGroupNameTest() {
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			Assert.assertNotNull(ElementUtils.getElement(mAlarmObject, null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, FCCM.AlarmText.SESSION_ACTIVITY_ASSET_GROUP.getText(), null, null));
		}
	}

	@Test(priority = 138472, groups = { FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void outOfAlarmTempratureAssetNameTest() {
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			Assert.assertNotNull(ElementUtils.getElement(mAlarmObject, null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, FCCM.AlarmText.SESSION_ACTIVITY_ASSET.getText(), null, null));
		}
	}

	@Test(priority = 138473, groups = { FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void outOfAlarmTempratureTestPointNameTest() {
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			Assert.assertNotNull(ElementUtils.getElement(mAlarmObject, null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, FCCM.AlarmText.SESSION_ACTIVITY_TEST_POINT.getText(), null, null));
		}
	}

	@Test(priority = 138500, groups = {})
	public void fovsTitleSessionActivityTest() throws Exception
	{
		mAlarmObject = null;
		sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.MORE_OPTIONS_BUTTON).click();
		CommonUtils.wait(1);
		sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.VIEW_SESSION_ACTIVITY).click();
		CommonUtils.wait(10);
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			mAlarmObject = ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, FCCM.AlarmObject.WEB_SESSION_FOVS.getObject());
			Assert.assertNotNull(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT, FCCM.AlarmText.WEB_SESSION_FOVS.getText()).isDisplayed());
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			CommonUtils.wait(1, 2, 1);
			Config.appWidthCenterFlag = true;
			IOSUtils.isPageLoaded(30, "Loading...");
			IOSUtils.setIOSPageSource();
			Assert.assertTrue(notificationsPage.isNotificationDisplayed(FCCM.AlarmText.ANDROID_SESSION_UNACCEPTABLE.getText(), FCCM.AlarmText.IOS_SESSION_UNACCEPTABLE.getText()) || notificationsPage.isNotificationDisplayed(FCCM.AlarmText.ANDROID_SESSION_UNSATISFACTORY.getText(), FCCM.AlarmText.IOS_SESSION_UNSATISFACTORY.getText()));
		}
	}
	
	@Test(priority = 138501, groups = {})
	public void fovsTypeSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mValueHolder.delete(0, mValueHolder.length());
			mValueHolder.append(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmText.WEB_SESSION_FOVS_TYPE.getText()).getText());
			Assert.assertTrue(mValueHolder.toString().equals("UNACCEPTABLE") || (mValueHolder.toString().equals("UNSATISFACTORY")));
		}
	}
	
	@Test(priority = 138502, groups = {})
	public void fovsValueSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				Assert.assertTrue(Double.parseDouble((ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_TRIGGERED_VALUE.getObject()).getText().split(" ")[0])) > 0.0);
	}
	
	@Test(priority = 138503, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS})
	public void fovsUnitSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				Assert.assertTrue(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_TRIGGERED_UNIT.getObject()).getText().equals(FCCM3560.vibrationUnit1InValue));
	}
	
	@Test(priority = 138504, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS})
	public void fovsAssetGroupNameSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_ASSET_GROUP.getObject()).getText().equals(FCCM3560.assetGroupName) || ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_ASSET_GROUP.getObject()).getText().equals(FCCM3560.assetGroupName));
	}
	
	@Test(priority = 138505, groups = {})
	public void fovsAssetNameSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				Assert.assertTrue(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_ASSET.getObject()).getText().equals(FCCM3560.assetName));
	}
	
	@Test(priority = 138506, groups = {})
	public void fovsMachineCategoryNameSessionActivityTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				Assert.assertTrue(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT, FCCM.AlarmText.WEB_SESSION_FOVS_MACHINE_CATEGORY.getText()).getText().equals(FCCM3560.machineCategoryName));
	}
	
	@Test(priority = 138510, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void markAsReadTest() throws Exception
	{
		sessionDetailPage3560.notificationMarkAsRead();
	}
	
	@Test(priority = 138511, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void isNotificationMarkedAsReadTest() throws Exception
	{
		Assert.assertTrue(sessionDetailPage3560.isNotificationRead());
	}
	
	@Test(priority = 138512, groups = { FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void addTextNoteTest() throws Exception
	{
		mTextNote = DateAndTimeUtils.getCurrentTimeStamp("MM/dd/yyyy hh:mm:ss");
		sessionDetailPage3560.addTextNote(mTextNote);
		CommonUtils.wait(3);
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
	}
	
	@Test(priority = 138525, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void aboveVibrationTitleNotificationTest() throws Exception
	{
		mAlarmObject = null;
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			gestureUtils.getActionsWebObject().sendKeys(Keys.ESCAPE).build().perform();
			CommonUtils.wait(3);
			sessionDetailPage3560.getSessionDetailPageObjects(SessionDetailPageObjectList.ALARM_ICONS).get(1).click();
			CommonUtils.wait(3);
			mAlarmObject = ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, FCCM.AlarmObject.WEB_NOTIFICATION_ABOVE_VIBRATION.getObject());
			Assert.assertTrue(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT_CONTAINS, FCCM.AlarmText.WEB_ABOVE_VIBRATION.getText()).isDisplayed());
		}
	}
	
	@Test(priority = 138526, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void aboveVibrationValueNotificationTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			mValueHolder.delete(0, mValueHolder.length());
			mValueHolder.append(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_NOTIFICATION_VALUE.getObject()).getText());
			Assert.assertTrue(mValueHolder.toString().contains(AlarmDataValues.FCCM3560_VIB_UNIT_INS.getValue()) && Double.parseDouble(mValueHolder.toString().split(" ")[0]) > 0.0);
		}
	}
	
	@Test(priority = 138527, groups = {})
	public void aboveVibrationTimestampNotificationTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			mValueHolder.delete(0, mValueHolder.length());
			mValueHolder.append(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_NOTIFICATION_TIMESTAMP.getObject()).getText());
			Assert.assertTrue(mValueHolder.toString().contains(DateAndTimeUtils.getCurrentTimeStamp("MM/dd/yyyy")));
		}
	}
	
	@Test(priority = 138535, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void withinVibrationTitleNotificationTest() throws Exception
	{
		mAlarmObject = null;
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			mAlarmObject = ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, FCCM.AlarmObject.WEB_NOTIFICATION_WITHIN_VIBRATION.getObject());
			Assert.assertTrue(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT_CONTAINS, FCCM.AlarmText.WEB_WITHIN_VIBRATION.getText()).isDisplayed());
		}
	}
	
	@Test(priority = 138536, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void withinVibrationValueNotificationTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			mValueHolder.delete(0, mValueHolder.length());
			mValueHolder.append(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_NOTIFICATION_VALUE.getObject()).getText());
			Assert.assertTrue(mValueHolder.toString().contains(AlarmDataValues.FCCM3560_VIB_UNIT_ACC.getValue()) && Double.parseDouble(mValueHolder.toString().split(" ")[0]) > 0.0);
		}
	}
	
	@Test(priority = 138537, groups = {})
	public void withinVibrationTimestampNotificationTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			mValueHolder.delete(0, mValueHolder.length());
			mValueHolder.append(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_NOTIFICATION_TIMESTAMP.getObject()).getText());
			Assert.assertTrue(mValueHolder.toString().contains(DateAndTimeUtils.getCurrentTimeStamp("MM/dd/yyyy")));
		}
	}
	
	@Test(priority = 138550, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void aboveTempratureTitleNotificationTest() throws Exception
	{
		mAlarmObject = null;
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			mAlarmObject = ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, FCCM.AlarmObject.WEB_NOTIFICATION_ABOVE_TEMPRATURE.getObject());
			Assert.assertTrue(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT_CONTAINS, FCCM.AlarmText.WEB_ABOVE_TEMPRATURE.getText()).isDisplayed());
		}
	}
	
	@Test(priority = 138551, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void aboveTempratureValueNotificationTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			mValueHolder.delete(0, mValueHolder.length());
			mValueHolder.append(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_NOTIFICATION_VALUE.getObject()).getText());
			Assert.assertTrue(mValueHolder.toString().contains(AlarmDataValues.FCCM3560_TEMP_UNIT_FAR.getValue()) && Double.parseDouble(mValueHolder.toString().split(" ")[0]) > 0.0);
		}
	}
	
	@Test(priority = 138552, groups = {})
	public void aboveTempratureTimestampNotificationTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			mValueHolder.delete(0, mValueHolder.length());
			mValueHolder.append(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_NOTIFICATION_TIMESTAMP.getObject()).getText());
			Assert.assertTrue(mValueHolder.toString().contains(DateAndTimeUtils.getCurrentTimeStamp("MM/dd/yyyy")));
		}
	}
	
	@Test(priority = 138560, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void withinTempratureTitleNotificationTest() throws Exception
	{
		mAlarmObject = null;
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			mAlarmObject = ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, FCCM.AlarmObject.WEB_NOTIFICATION_WITHIN_TEMPRATURE.getObject());
			Assert.assertTrue(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT_CONTAINS, FCCM.AlarmText.WEB_WITHIN_TEMPRATURE.getText()).isDisplayed());
		}
	}
	
	@Test(priority = 138561, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void withinTempratureValueNotificationTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			mValueHolder.delete(0, mValueHolder.length());
			mValueHolder.append(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_NOTIFICATION_VALUE.getObject()).getText());
			Assert.assertTrue(mValueHolder.toString().contains(AlarmDataValues.FCCM3560_TEMP_UNIT_CEL.getValue()) && Double.parseDouble(mValueHolder.toString().split(" ")[0]) > 0.0);
		}
	}
	
	@Test(priority = 138562, groups = {})
	public void withinTempratureTimestampNotificationTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			mValueHolder.delete(0, mValueHolder.length());
			mValueHolder.append(ElementUtils.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_NOTIFICATION_TIMESTAMP.getObject()).getText());
			Assert.assertTrue(mValueHolder.toString().contains(DateAndTimeUtils.getCurrentTimeStamp("MM/dd/yyyy")));
			sessionDetailPage3560.getSessionDetailPageObjects(SessionDetailPageObjectList.ALARM_ICONS).get(1).click();
			CommonUtils.wait(2);
		}
	}
	
	
	@Test(priority = 139201, groups = {FCCM3560.SESSION_VERIFICATION_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void deleteAlarmsTest()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			sessionDetailPage3560.deleteAllAlarms(6);
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			IOSUtils.resetIOSPageSource();
			sessionDetailPage3560.navigateToSessionOptions(SessionDetailPageObjectList.ADD_EDIT_ALARM);
			if(gestureUtils.mScroll("Below Vibration Alarm", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN)) 
				sessionDetailPage3560.deleteAlarm(AlarmType.BELOW, "Below Vibration Alarm");
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
			gestureUtils.mScroll("Alarm", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.ADD_EDIT_ALARM_BUTTON).click();
			CommonUtils.wait(5);
			if(gestureUtils.mScroll("Out-of-Range Temperature Alarm", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN)) 
				sessionDetailPage3560.deleteAlarm(AlarmType.OUTOF, "Out-of-Range Temperature Alarm");
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
			gestureUtils.mScroll("Alarm", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.ADD_EDIT_ALARM_BUTTON).click();
			CommonUtils.wait(5);
			Assert.assertFalse(DriverManager.getDriver().getPageSource().contains("Below Vibration Alarm") && DriverManager.getDriver().getPageSource().contains("Out-of-Range Temperature Alarm"));
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			sessionDetailPage3560.navigateToSessionOptions(SessionDetailPageObjectList.ADD_EDIT_ALARM);
			if(gestureUtils.mScroll("Out-of-Range Vibration Alarm", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN)) 
				sessionDetailPage3560.deleteAlarm(AlarmType.OUTOF, "Out-of-Range Vibration Alarm");
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.ADD_EDIT_ALARM_BUTTON).click();
			if(gestureUtils.mScroll("Below Temperature Alarm", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN)) 
				sessionDetailPage3560.deleteAlarm(AlarmType.BELOW, "Below Temperature Alarm");
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.ADD_EDIT_ALARM_BUTTON).click();
			//second time delete to handle flaky behavior of delete
			if(gestureUtils.mScroll("Out-of-Range Vibration Alarm", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN)) 
				sessionDetailPage3560.deleteAlarm(AlarmType.OUTOF, "Out-of-Range Vibration Alarm");
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.ADD_EDIT_ALARM_BUTTON).click();
			if(gestureUtils.mScroll("Below Temperature Alarm", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN)) 
				sessionDetailPage3560.deleteAlarm(AlarmType.BELOW, "Below Temperature Alarm");
			Assert.assertFalse(gestureUtils.mScroll("Below Temperature Alarm", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN));
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.ADD_EDIT_ALARM_BUTTON).click();
			Assert.assertFalse(gestureUtils.mScroll("Out-of-Range Vibration Alarm", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN));
		}
	}
	
	@Test(priority = 139202, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void addAboveVibrationResetAlarmTest()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			CommonUtils.wait(2);
			sessionDetailPage3560.addAlarm(FeatureList.FCCM3560_VIB, AlarmType.ABOVE_VIBRATION, AlarmDataValues.FCCM3560_VIB_UNIT_INS.getValue(), AlarmDataValues.FCCM3560_ABOVE_VIB_RESET_VALUE.getValue(), AlarmDataValues.FCCM3560_ABOVE_VIB_RESET_VALUE.getValue(), null, 0, true, false, "");
		}
	}
	
	@Test(priority = 139203, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void addWithinVibrationResetAlarmTest()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) { 
			CommonUtils.wait(2);
			sessionDetailPage3560.addAlarm(FeatureList.FCCM3560_VIB, AlarmType.WITHIN_VIBRATION, AlarmDataValues.FCCM3560_VIB_UNIT_ACC.getValue(), AlarmDataValues.FCCM3560_WITHIN_VIB_UPPER_RESET_VALUE.getValue(), AlarmDataValues.FCCM3560_WITHIN_VIB_LOWER_RESET_VALUE.getValue(), null, 0, true, false, "");
		}
	}
	
	@Test(priority = 139204, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void addAboveTempratureResetAlarmTest()
	{
		CommonUtils.wait(2);
		sessionDetailPage3560.addAlarm(FeatureList.FCCM3560_TEMP, AlarmType.ABOVE_TEMPERATURE, AlarmDataValues.FCCM3560_TEMP_UNIT_FAR.getValue(), AlarmDataValues.FCCM3560_ABOVE_TEMP_RESET_VALUE.getValue(), AlarmDataValues.FCCM3560_ABOVE_TEMP_RESET_VALUE.getValue(), null, 0, true, false, "");
	}
	
	@Test(priority = 139205, groups = {FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void addWithinTempratureResetAlarmTest()
	{
		CommonUtils.wait(2);
		sessionDetailPage3560.addAlarm(FeatureList.FCCM3560_TEMP, AlarmType.WITHIN_TEMPERATURE, AlarmDataValues.FCCM3560_TEMP_UNIT_CEL.getValue(), AlarmDataValues.FCCM3560_WITHIN_TEMP_UPPER_RESET_VALUE.getValue(), AlarmDataValues.FCCM3560_WITHIN_TEMP_LOWER_RESET_VALUE.getValue(), null, 0, true, false, "");
	}
	
	@Test(priority = 139210, groups = {FCCM3560.SESSION_VERIFICATION_TESTS})
	public void addOutOfTempratureResetAlarmTest()
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			sessionDetailPage3560.addAlarm(FeatureList.FCCM3560_TEMP, AlarmType.OUTOF_TEMPERATURE, AlarmDataValues.FCCM3560_TEMP_UNIT_FAR.getValue(), AlarmDataValues.FCCM3560_OUTOF_TEMP_UPPER_RESET_VALUE.getValue(), AlarmDataValues.FCCM3560_OUTOF_TEMP_LOWER_RESET_VALUE.getValue(), ScrollDiection.DOWN, 1, true, false, "");
			CommonUtils.wait(1);
			Assert.assertTrue(DriverManager.getDriver().getPageSource().contains("Out-of-Range Temperature Alarm"));
		}
	}
	
	@Test(priority = 139211, groups = {FCCM3560.SESSION_VERIFICATION_TESTS})
	public void addBelowVibrationResetAlarmTest()
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			sessionDetailPage3560.addAlarm(FeatureList.FCCM3560_VIB, AlarmType.BELOW_VIBRATION, AlarmDataValues.FCCM3560_VIB_UNIT_INS.getValue(), AlarmDataValues.FCCM3560_BELOW_VIB_RESET_VALUE.getValue(), AlarmDataValues.FCCM3560_BELOW_VIB_RESET_VALUE.getValue(), ScrollDiection.DOWN, 0, true, false, "");
			CommonUtils.wait(2);
			Assert.assertTrue(DriverManager.getDriver().getPageSource().contains("Below Vibration Alarm"));
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
			CommonUtils.wait(2);
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
			CommonUtils.wait(2);
		}
	}
	
	@Test(priority = 139212, groups = {FCCM3560.SESSION_VERIFICATION_TESTS})
	public void addOutOfVibrationResetAlarmTest()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			sessionDetailPage3560.addAlarm(FeatureList.FCCM3560_VIB, AlarmType.OUTOF_VIBRATION, AlarmDataValues.FCCM3560_VIB_UNIT_MMS.getValue(), AlarmDataValues.FCCM3560_OUTOF_VIB_UPPER_RESET_VALUE.getValue(), AlarmDataValues.FCCM3560_OUTOF_VIB_LOWER_RESET_VALUE.getValue(), ScrollDiection.DOWN, 1, true, false, "");
			CommonUtils.wait(1);
			Assert.assertTrue(gestureUtils.mScroll("Out-of-Range Vibration Alarm", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN));
		}
	}
	
	
	@Test(priority = 139213, groups = {FCCM3560.SESSION_VERIFICATION_TESTS})
	public void addBelowTempratureResetAlarmTest()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			sessionDetailPage3560.addAlarm(FeatureList.FCCM3560_TEMP, AlarmType.BELOW_TEMPERATURE, AlarmDataValues.FCCM3560_TEMP_UNIT_FAR.getValue(), AlarmDataValues.FCCM3560_BELOW_TEMP_RESET_VALUE.getValue(), AlarmDataValues.FCCM3560_BELOW_TEMP_RESET_VALUE.getValue(), ScrollDiection.DOWN, 0, true, false, "");
			CommonUtils.wait(1);
			Assert.assertTrue(gestureUtils.mScroll("Below Temperature Alarm", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN));
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
			CommonUtils.wait(1);
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
			CommonUtils.wait(1);
		}
	}
	
	
	@Test(priority = 139225, groups = {FCCM3560.SESSION_VERIFICATION_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void unitChangeACCTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.MORE_OPTIONS_BUTTON).click();
			CommonUtils.wait(1);
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.VIEW_SESSION_SETUP).click();
			CommonUtils.wait(2);
			sessionDetailPage3560.getSessionDetailPage3560Object(SessionDetailPage3560ObjectList.CHANGE_UNIT_DONE_BUTTON).click();
			CommonUtils.wait(10);
			sessionDetailPage3560.isGraphDisplayed("FCCM3560.DataValues.WEB_VIB_UNIT_ACC.getValue()");
			Assert.assertTrue(sessionDetailPage3560.getSessionDetailPage3560Object(SessionDetailPage3560ObjectList.VIBRATION_UNIT).getText().equals(FCCM3560.DataValues.WEB_GRAPH_UNIT_ACC.getValue()));
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			sessionDetailPage3560.navigateToSessionOptions(SessionDetailPageObjectList.VIEW_SESSION_SETUP);
			CommonUtils.wait(2);
			vibrationTapCordinates = GestureUtils.getTapCordinates(ObjectName.VIEW_SESSION_SETUP_VIBRATION_UNIT).clone();
			temperatureTapCordinates = GestureUtils.getTapCordinates(ObjectName.VIEW_SESSION_SETUP_TEMPERATURE_UNIT).clone();
			CommonUtils.wait(1);
			gestureUtils.clickOnCordinates(vibrationTapCordinates[0], vibrationTapCordinates[1]);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, FCCM3560.DataValues.MOBILE_VALUE_UNIT_ACC.getValue(), LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_ENDS_WITH, FCCM3560.DataValues.MOBILE_VALUE_UNIT_ACC.getValue(), null, null).click();			
		}
	}
	
	@Test(priority = 139226, groups = {FCCM3560.SESSION_VERIFICATION_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void unitChangeFARTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(sessionDetailPage3560.getSessionDetailPage3560Object(SessionDetailPage3560ObjectList.TEMPRATURE_UNIT).getText().equals(FCCM3560.DataValues.WEB_GRAPH_UNIT_FAR.getValue()));
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			CommonUtils.wait(3);
			gestureUtils.clickOnCordinates(temperatureTapCordinates[0], temperatureTapCordinates[1]);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, FCCM3560.DataValues.IOS_VALUE_UNIT_FAR.getValue(), LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_ENDS_WITH, FCCM3560.DataValues.IOS_VALUE_UNIT_FAR.getValue(), null, null).click();
			CommonUtils.wait(2);
			ElementUtils.safeClick(sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON));
			CommonUtils.wait(5);
			gestureUtils.mScroll("1H", LocatorStrategy.IOS_LOCATOR_STRATEGY_LABEL, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
				Assert.assertTrue(sessionDetailPage3560.getSessionDetailPage3560Object(SessionDetailPage3560ObjectList.VIBRATION_UNIT).getText().equals(FCCM3560.DataValues.IOS_GRAPH_UNIT_ACC.getValue()));
				Assert.assertTrue(sessionDetailPage3560.getSessionDetailPage3560Object(SessionDetailPage3560ObjectList.TEMPRATURE_UNIT).getText().equals(FCCM3560.DataValues.IOS_GRAPH_UNIT_FAR.getValue()));
			}
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
				Assert.assertTrue(sessionDetailPage3560.getSessionDetailPage3560Object(SessionDetailPage3560ObjectList.TEMPRATURE_UNIT).getText().equals(FCCM3560.DataValues.ANDROID_GRAPH_UNIT_FAR.getValue()));
			}
		}
	}
	
	@Test(priority = 139227, groups = {FCCM3560.SESSION_VERIFICATION_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void unitChangeACCValueTest() throws Exception
	{
		gestureUtils.mScroll("Show Alarms", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
		vibrationList.clear();
		tempratureList.clear();
		vibrationList = sessionDetailPage3560.getVibrationList();
		tempratureList = sessionDetailPage3560.getTempratureList();
		for(String value:vibrationList) {
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) 
			Assert.assertTrue(value.contains(FCCM3560.DataValues.WEB_VALUE_UNIT_ACC.getValue()));
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) 	
				Assert.assertTrue(value.contains(FCCM3560.DataValues.MOBILE_VALUE_UNIT_ACC.getValue()));
		}
		
	}
	
	@Test(priority = 139228, groups = {FCCM3560.SESSION_VERIFICATION_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void unitChangeFARValueTest() throws Exception
	{
		for(String value:tempratureList) {
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) 
			Assert.assertTrue(value.contains(FCCM3560.DataValues.WEB_VALUE_UNIT_FAR.getValue()));
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) 	
			Assert.assertTrue(value.contains(FCCM3560.DataValues.IOS_VALUE_UNIT_FAR.getValue()));
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) 	
			Assert.assertTrue(value.contains(FCCM3560.DataValues.ANDROID_VALUE_UNIT_FAR.getValue()));
		}
	}
	
	@Test(priority = 139229, groups = {FCCM3560.SESSION_VERIFICATION_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void unitChangeINSTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.MORE_OPTIONS_BUTTON).click();
			CommonUtils.wait(1);
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.VIEW_SESSION_SETUP).click();
			CommonUtils.wait(2);
			sessionDetailPage3560.changeUnit(SessionDetailPage3560ObjectList.VIB_UNIT_INS);
			sessionDetailPage3560.changeUnit(SessionDetailPage3560ObjectList.TEMP_UNIT_CEL);
			sessionDetailPage3560.getSessionDetailPage3560Object(SessionDetailPage3560ObjectList.CHANGE_UNIT_DONE_BUTTON).click();
			CommonUtils.wait(10);
			sessionDetailPage3560.isGraphDisplayed("FCCM3560.DataValues.WEB_VIB_UNIT_INS.getValue()");
			Assert.assertTrue(sessionDetailPage3560.getSessionDetailPage3560Object(SessionDetailPage3560ObjectList.VIBRATION_UNIT).getText().equals(FCCM3560.DataValues.WEB_GRAPH_UNIT_INS.getValue()));
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			sessionDetailPage3560.navigateToSessionOptions(SessionDetailPageObjectList.VIEW_SESSION_SETUP);
			CommonUtils.wait(3);
			gestureUtils.clickOnCordinates(vibrationTapCordinates[0], vibrationTapCordinates[1]);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, FCCM3560.DataValues.MOBILE_VALUE_UNIT_INS.getValue(), LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_ENDS_WITH, FCCM3560.DataValues.MOBILE_VALUE_UNIT_INS.getValue(), null, null).click();			
		}
	}
	
	@Test(priority = 139230, groups = {FCCM3560.SESSION_VERIFICATION_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void unitChangeCELTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(sessionDetailPage3560.getSessionDetailPage3560Object(SessionDetailPage3560ObjectList.TEMPRATURE_UNIT).getText().equals(FCCM3560.DataValues.WEB_GRAPH_UNIT_CEL.getValue()));
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			CommonUtils.wait(2);
			gestureUtils.clickOnCordinates(temperatureTapCordinates[0], temperatureTapCordinates[1]);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, FCCM3560.DataValues.IOS_VALUE_UNIT_CEL.getValue(), LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_ENDS_WITH, FCCM3560.DataValues.IOS_VALUE_UNIT_CEL.getValue(), null, null).click();
			CommonUtils.wait(2);
			ElementUtils.safeClick(sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON));
			CommonUtils.wait(5);
			gestureUtils.mScroll("1H", LocatorStrategy.IOS_LOCATOR_STRATEGY_LABEL, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				Assert.assertTrue(sessionDetailPage3560.getSessionDetailPage3560Object(SessionDetailPage3560ObjectList.TEMPRATURE_UNIT).getText().equals(FCCM3560.DataValues.ANDROID_GRAPH_UNIT_CEL.getValue()));
		}
	}
	
	@Test(priority = 139231, groups = {FCCM3560.SESSION_VERIFICATION_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void unitChangeINSValueTest() throws Exception
	{
		gestureUtils.mScroll("Show Alarms", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
		vibrationList.clear();
		tempratureList.clear();
		vibrationList = sessionDetailPage3560.getVibrationList();
		tempratureList = sessionDetailPage3560.getTempratureList();
		for(String value:vibrationList) {	
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) 
				Assert.assertTrue(value.contains(FCCM3560.DataValues.WEB_VALUE_UNIT_INS.getValue()));
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) 	
				Assert.assertTrue(value.contains(FCCM3560.DataValues.MOBILE_VALUE_UNIT_INS.getValue()));
		}
	}
	
	@Test(priority = 139232, groups = {FCCM3560.SESSION_VERIFICATION_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void unitChangeCELValueTest() throws Exception
	{
		for(String value:tempratureList) {
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) 
				Assert.assertTrue(value.contains(FCCM3560.DataValues.WEB_VALUE_UNIT_CEL.getValue()));
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) 	
				Assert.assertTrue(value.contains(FCCM3560.DataValues.ANDROID_VALUE_UNIT_CEL.getValue()));
		}
	}
	
	@Test(priority = 139233, groups = {FCCM3560.SESSION_VERIFICATION_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void unitChangeMMSTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.MORE_OPTIONS_BUTTON).click();
			CommonUtils.wait(1);
			sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.VIEW_SESSION_SETUP).click();
			CommonUtils.wait(2);
			sessionDetailPage3560.changeUnit(SessionDetailPage3560ObjectList.VIB_UNIT_MMS);
			sessionDetailPage3560.getSessionDetailPage3560Object(SessionDetailPage3560ObjectList.CHANGE_UNIT_DONE_BUTTON).click();
			CommonUtils.wait(10);
			sessionDetailPage3560.isGraphDisplayed("FCCM3560.DataValues.WEB_VIB_UNIT_MMS.getValue()");
			Assert.assertTrue(sessionDetailPage3560.getSessionDetailPage3560Object(SessionDetailPage3560ObjectList.VIBRATION_UNIT).getText().equals(FCCM3560.DataValues.WEB_GRAPH_UNIT_MMS.getValue()));
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			sessionDetailPage3560.navigateToSessionOptions(SessionDetailPageObjectList.VIEW_SESSION_SETUP);
			CommonUtils.wait(3);
			gestureUtils.clickOnCordinates(vibrationTapCordinates[0], vibrationTapCordinates[1]);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, FCCM3560.DataValues.MOBILE_VALUE_UNIT_MMS.getValue(), LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_ENDS_WITH, FCCM3560.DataValues.MOBILE_VALUE_UNIT_MMS.getValue(), null, null).click();			
		}
	}
	
	@Test(priority = 139234, groups = {FCCM3560.SESSION_VERIFICATION_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void unitChangeMMSFARTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(sessionDetailPage3560.getSessionDetailPage3560Object(SessionDetailPage3560ObjectList.TEMPRATURE_UNIT).getText().equals(FCCM3560.DataValues.WEB_GRAPH_UNIT_FAR.getValue()));
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			CommonUtils.wait(3);
			gestureUtils.clickOnCordinates(temperatureTapCordinates[0], temperatureTapCordinates[1]);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, FCCM3560.DataValues.IOS_VALUE_UNIT_FAR.getValue(), LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_ENDS_WITH, FCCM3560.DataValues.IOS_VALUE_UNIT_FAR.getValue(), null, null).click();
			ElementUtils.safeClick(sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON));
			CommonUtils.wait(5);
			gestureUtils.mScroll("1H", LocatorStrategy.IOS_LOCATOR_STRATEGY_LABEL, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				Assert.assertTrue(sessionDetailPage3560.getSessionDetailPage3560Object(SessionDetailPage3560ObjectList.TEMPRATURE_UNIT).getText().equals(FCCM3560.DataValues.ANDROID_GRAPH_UNIT_FAR.getValue()));
		}
	}
	
	@Test(priority = 139235, groups = {FCCM3560.SESSION_VERIFICATION_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void unitChangeMMSValueTest() throws Exception
	{
		gestureUtils.mScroll("Show Alarms", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
		vibrationList.clear();
		tempratureList.clear();
		vibrationList = sessionDetailPage3560.getVibrationList();
		tempratureList = sessionDetailPage3560.getTempratureList();
		for(String value:vibrationList)	{	
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) 
				Assert.assertTrue(value.contains(FCCM3560.DataValues.WEB_VALUE_UNIT_MMS.getValue()));
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) 	
				Assert.assertTrue(value.contains(FCCM3560.DataValues.MOBILE_VALUE_UNIT_MMS.getValue()));
		}
	}
	
	@Test(priority = 139236, groups = {FCCM3560.SESSION_VERIFICATION_TESTS, FCCM3560.UAT_WEB_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_WEB_TESTS})
	public void unitChangeMMSFARValueTest() throws Exception
	{
		for(String value:tempratureList) {
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) 
			 Assert.assertTrue(value.contains(FCCM3560.DataValues.WEB_VALUE_UNIT_FAR.getValue()));
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) 	
				Assert.assertTrue(value.contains(FCCM3560.DataValues.ANDROID_VALUE_UNIT_FAR.getValue()));
		}
	}
	
	//Automation Test cases
	//Android
	@Test( groups = {"Android_Bug_Automation"})
	public void clickOnInstallationdetails() throws Exception {
		homepage.clickOnViewActiveMonitoringSessionButton();
		sessionDetailPage.openFirstSession();
		CommonUtils.wait(4);
		GestureUtils.moveToElement(sessionDetailPage3560.sessionDetailsMenuIcon);
		sessionDetailPage3560.clickOnEditSessionSetup().click();
		gestureUtils.mScroll("Installation Details\n" , LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME,
				LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
        sessionDetailPage3560.installationDeatils.click();
        Assert.assertTrue(ElementUtils.isDisplayed(sessionDetailPage3560.epoxyins));
		
	}
	
	@Test(groups = {"android_Bug_Automation"})
	public void checkConnectionStrength() throws Exception {
		homepage.clickOnViewActiveMonitoringSessionButton();
		sessionDetailPage.openFirstSession();
		CommonUtils.wait(4);
		GestureUtils.moveToElement(sessionDetailPage3560.sessionDetailsMenuIcon);
		sessionDetailPage3560.clickOnEditSessionSetup().click();
		gestureUtils.mScroll("Installation Details\n" , LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME,
				LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
        String cs = sessionDetailPage3560.connectionStrength.getText();
        sessionDetailPage3560.ConnectionStatus(cs);
        
	}
	@Test(groups= {""})
	public void check_Sensor_Status() throws Exception {
		homepage.clickOnViewActiveMonitoringSessionButton();
		sessionDetailPage.openFirstSession();
		CommonUtils.wait(4);
		GestureUtils.moveToElement(sessionDetailPage3560.sessionDetailsMenuIcon);
		sessionDetailPage3560.clickOnEditSessionSetup().click();
		gestureUtils.mScroll("Installation Details\n" , LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME,
				LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
		String ss = sessionDetailPage3560.sensor_Status.getText();
		sessionDetailPage3560.Sensor_status(ss);
		
	}
	@Test(groups= {""})
	public void signalStrengthIndication() throws Exception {
		homepage.clickOnViewActiveMonitoringSessionButton();
		sessionDetailPage.openFirstSession();
		CommonUtils.wait(4);
		sessionDetailPage3560.clickOnEditSessionSetup().click();
		gestureUtils.mScroll("Installation Details\n" , LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME,
				LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
		Assert.assertTrue(ElementUtils.isDisplayed(sessionDetailPage3560.sensor_Gateway_Connection_Strength_Indication));

		
	}
	
	@Test(groups= {""})
	public void remove_Extra_Provision_Gateway() throws Exception {
		homepage.clickOnViewActiveMonitoringSessionButton();
		sessionDetailPage.openFirstSession();
		CommonUtils.wait(4);
		sessionDetailPage3560.clickOnEditSessionSetup().click();
		gestureUtils.mScroll("GATEWAY" , LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME,
				LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
		sessionDetailPage3560.gateway_Tab.click();
		Assert.assertTrue(ElementUtils.isDisplayed(sessionDetailPage3560.delete_Extra_Gateway_Button));
		sessionDetailPage3560.delete_Extra_Gateway_Button.click();

	}
	@Test(groups= {""})
	public void clickOnEpoxy() throws Exception {
		homepage.clickOnViewActiveMonitoringSessionButton();
		sessionDetailPage.openFirstSession();
		CommonUtils.wait(4);
		sessionDetailPage3560.clickOnEditSessionSetup().click();
		gestureUtils.mScroll("Installation Details\n" , LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME,
				LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
		 sessionDetailPage3560.installationDeatils.click();
		 sessionDetailPage3560.epoxyins.click();
		Assert.assertEquals(sessionDetailPage3560.epoxy_Instruction_Text, "Instructions for LOCTITE 330 Epoxy");
		
	}
	
	
	
    //BUG_AUTOMATION ANDROID -- FCCM3560-3216
	@Test(priority = 141101, groups = { FCCM3560.ANDROID_BUGS })
	public void displayingRSSIWhenConnectionStrengthIsUnavailable() throws Exception {
		sessionDetailPage.tapOnSessionWithGatewayConnectionLost(FCCM3560.gateway, ScrollDiection.DOWN);
		sessionDetailPage.navigateToSessionOptions(SessionDetailPageObjectList.VIEW_SESSION_SETUP);
		gestureUtils.mScroll("Installation Details", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME,
				LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
		sessionDetailPage.checkConnectionStrength();
		Assert.assertFalse(sessionDetailPage.isRSSIDisplayedWhenConnectionStrengthIsUnavailable());
 
	}

	// FCCM3560-1909
	@Test(priority = 141102, groups = { FCCM3560.ANDROID_BUGS })
	public void notDisplayingMeasurementUnit() throws Exception {
		sessionDetailPage.tapOnActiveSession(FCCM3560.gatewayNameInActiveSession, ScrollDiection.DOWN);
		sessionDetailPage.navigateToSessionOptions(SessionDetailPageObjectList.VIEW_SESSION_ACTIVITY);
		gestureUtils.mScroll("Show Alarms", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME,
				LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
		sessionDetailPage.clickOnShowAlarms();
		gestureUtils.mScroll("Above Temperature Alarm", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME,
				LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
		Assert.assertTrue(sessionDetailPage.checkIfUnitIsDisplayed(), "Unit is displayed");
	}

	// FCCM3560-3175
	@Test(priority = 141103, groups = { FCCM3560.ANDROID_BUGS })
	public void appCrashOnTappingOnInstallationDetails() throws Exception {
		sessionDetailPage.tapOnActiveSession(FCCM3560.gatewayNameInActiveSession, ScrollDiection.DOWN);
		sessionDetailPage.navigateToSessionOptions(SessionDetailPageObjectList.VIEW_SESSION_SETUP);
		gestureUtils.mScroll("Installation Details", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME,
				LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
		sessionDetailPage.clickOnInstallationDetails();

	}

	// FCCM3560-2986
	@Test(priority = 141104, groups = { FCCM3560.ANDROID_BUGS })
	public void appCrashWhenChangingUnits() throws Exception {
		sessionDetailPage.tapOnActiveSession(FCCM3560.gatewayNameInActiveSession, ScrollDiection.DOWN);
		sessionDetailPage.navigateToSessionOptions(SessionDetailPageObjectList.VIEW_SESSION_SETUP);
		sessionDetailPage.selectVibTempUnit();
		sessionDetailPage.getSessionDetailPageObject(SessionDetailPageObjectList.BACK_BUTTON);
	}
	
	// FCCM3560-1907
	@Test(priority = 141110, groups = { FCCM3560.ANDROID_BUGS })
	public void wrongErrorDisplayedWhenWiFiPasswordIsIncorrect() throws Exception {
		sessionDetailPage.tapOnActiveSession(FCCM3560.gatewayNameInActiveSession, ScrollDiection.DOWN);
		sessionDetailPage.navigateToSessionOptions(SessionDetailPageObjectList.VIEW_SESSION_SETUP);
		Assert.assertTrue(sessionDetailPage.getWiFiErrorInReconfigureWiFi());
	}
	
	//FCCM3560- 3435
	@Test(priority = 141111, groups = { FCCM3560.ANDROID_BUGS })
	public void appCrashWhenTappingOnViewEditSessionSetup() throws Exception {
		sessionDetailPage.tapOnActiveSession(FCCM3560.gatewayNameInActiveSession, ScrollDiection.DOWN);
		sessionDetailPage.navigateToSessionOptions(SessionDetailPageObjectList.VIEW_SESSION_SETUP);
		Assert.assertTrue(sessionDetailPage.verifyIfSessionSetupIdDisplayed());
	}
	
	//FCCM3560-2722
	@Test(priority = 141115, groups = { FCCM3560.ANDROID_BUGS })
	public void inconsitencyInTextInRecentAlarm() throws Exception {
		sessionDetailPage.tapOnActiveSession(FCCM3560.gatewayNameInActiveSession, ScrollDiection.DOWN);
		sessionDetailPage.navigateToSessionOptions(SessionDetailPageObjectList.VIEW_SESSION_SETUP);
		gestureUtils.mScroll("Alarm", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
		Assert.assertFalse(sessionDetailPage.checkIfVibrationUnitIsDisplayedForBelowTempAlarm());
	}
	
	
    @AfterClass(alwaysRun = true, groups = { FCCM3560.SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.SESSION_DETAIL_PAGE_TESTS, FCCM3560.SESSION_VERIFICATION_TESTS })
	public void tearDown() throws Exception {
		Config.useExistingPageSource = false;
		IOSUtils.resetIOSPageSource();
		if (!DriverManager.isSmokeSuite()) {
			DriverManager.closeApp();
			DriverManager.launchApp();
			DriverManager.getSignIn().handleOnBoardPrompt();
			DriverManager.getSwitcher().signOut();
		}
	}
}
