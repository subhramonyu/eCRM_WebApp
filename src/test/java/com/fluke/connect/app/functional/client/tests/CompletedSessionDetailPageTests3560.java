package com.fluke.connect.app.functional.client.tests;

import static org.testng.Assert.assertTrue;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.fluke.connect.app.functional.client.pages.NotificationsPage;
import com.fluke.connect.app.functional.client.pages.SessionDetailPage;
import com.fluke.connect.app.functional.client.pages.SessionDetailPage3560;
import com.fluke.connect.app.functional.client.pages.SessionDetailPage.SessionDetailPageObjectList;
import com.fluke.connect.app.functional.client.pages.SessionDetailPage3560.SessionDetailPage3560ObjectList;
import com.fluke.connect.app.testdata.FCCM;
import com.fluke.connect.app.testdata.FCCM3560;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.IOSUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.ScrollDiection;

@SuppressWarnings("deprecation")
public class CompletedSessionDetailPageTests3560 {
	
	// BUG_AUTOMATION
	private SessionDetailPage sessionDetailPage;

	//
	private SessionDetailPage3560 sessionDetailPage3560;
	private int iterationValue;
	private int sensorCount;
	private List<String> valueList;
	private List<String> valueTimeList;
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

	@Parameters({"completedSessionGatewayName3560"})
	@BeforeClass(groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS, FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS})
	public void initClass(@Optional("No Value") String gatewayName) throws Exception {
		//BUG_AUTOMATION
		sessionDetailPage3560 = new SessionDetailPage3560();
		//
		sessionDetailPage3560 = new SessionDetailPage3560();
		gestureUtils = new GestureUtils();
		notificationsPage = new NotificationsPage();
		mValueHolder = new StringBuilder();
		this.isActiveSession = false;
		this.gatewayName = gatewayName;
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)
				|| DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			sensorCount = FCCM3560.androidSensorNameList.length;
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			sensorCount = FCCM3560.iOSSensorNameList.length;
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) 
			ElementUtils.isDisplayed(5, sessionDetailPage3560.getWebGraphLinesObject());
		Config.appWidthCenterFlag = false;
		CommonUtils.wait(15, 15, 3);
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			Config.useExistingPageSource = true;
			sessionDetailPageSource = DriverManager.getDriver().getPageSource();
			Config.iOSPageSource = sessionDetailPageSource;
		}
	}
	

	@Test(priority = 139501, groups = {})
	public void sessionTileStatusTest() {
		try {
			if (isActiveSession)
				Assert.assertEquals(
						sessionDetailPage3560.getElementVisibleTextInSessionTileStrict(FCCM3560.sessionStatus[0]),
						FCCM3560.sessionStatus[0]);
		} catch (Throwable e) {
			Assert.fail("Exception Detail: " + e);
		}
	}

	@Test(priority = 139502, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void gateWayNameTest() {
		try {
			if(gatewayName.equals("no value"))
				Assert.assertEquals(sessionDetailPage3560.getElementVisibleTextInSessionTileStrict(FCCM3560.gatewayNameValue), FCCM3560.gatewayNameValue);
			else
				Assert.assertEquals(sessionDetailPage3560.getElementVisibleTextInSessionTileStrict(gatewayName), gatewayName);
	
		} catch (Throwable e) {
			Assert.fail("Exception Detail: " + e);
		}
	}

	@Test(priority = 139503, groups = { FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS,
			FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void sensorsStaticTextVisibleTest() {
		try {
			Assert.assertEquals(
					sessionDetailPage3560.getElementVisibleTextInSessionTileStrict(Config.SENSORS_STATIC_TEXT),
					Config.SENSORS_STATIC_TEXT);
		} catch (Throwable e) {
			Assert.fail("Exception Detail: " + e);
		}
	}

	@Test(priority = 139504, groups = { FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS,
			FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void sensorCountAndTypeTest() {
		try {
			if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
				Assert.assertTrue(sessionDetailPage3560
						.getElementVisibleTextInSessionTileStrict(FCCM3560.androidSensorsCountAndType)
						.contains(FCCM3560.androidSensorsCountAndType));
			} else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
				Assert.assertTrue(
						sessionDetailPage3560.getElementVisibleTextInSessionTileStrict(FCCM3560.iOSSensorsCountAndType)
								.contains(FCCM3560.iOSSensorsCountAndType));
			}
		} catch (Throwable e) {
			Assert.fail("Exception Detail: " + e);
		}
	}

	@Test(priority = 139505, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void startTimeStaticTextVisibleTest() {
		try {
			if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)
					|| DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				Assert.assertEquals(
						sessionDetailPage3560.getElementVisibleTextInSessionTileStrict(Config.START_TIME_STATIC_TEXT),
						Config.START_TIME_STATIC_TEXT);
			else if (DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				Assert.assertTrue(ElementUtils
						.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "#new_design1")
						.getText().contains(Config.START_STATIC_TEXT));
		} catch (Throwable e) {
			Assert.fail("Exception Detail: " + e);
		}
	}

	@Test(priority = 139506, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void sessionStartTimeTest() {
		try {
			if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				Assert.assertTrue(sessionDetailPage3560
						.getElementVisibleTextInSessionTileStrict(FCCM3560.requiredSessionStartTimestamp)
						.contains(FCCM3560.requiredSessionStartTimestamp));
			else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				Assert.assertTrue(
						sessionDetailPage3560.getElementVisibleTextInSessionTile(FCCM3560.requiredSessionStartTimestamp)
								.contains(FCCM3560.requiredSessionStartTimestamp));
			else if (DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				Assert.assertTrue(ElementUtils
						.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "#new_design1")
						.getText().contains(FCCM3560.requiredSessionStartTimestamp));
		} catch (Throwable e) {
			Assert.fail("Exception Detail: " + e);
		}
	}

	@Test(priority = 139507, groups = {})
	public void sessionStartUserNameTest() {
		try {
			if (DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				Assert.assertTrue(ElementUtils
						.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "#new_design1")
						.getText().contains(FCCM3560.sessionStartUserName));
		} catch (Throwable e) {
			Assert.fail("Exception Detail: " + e);
		}
	}

	@Test(priority = 139508, groups = { FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS,
			FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void assetCountTextVisibleTest() {
		try {
			Assert.assertTrue(sessionDetailPage3560
					.getElementInSessionTileStrict(Config.ASSET_STATIC_TEXT + " (" + 1 + ")").isDisplayed());
		} catch (Throwable e) {
			Assert.fail("Exception Detail: " + e);
		}
	}

	@Test(priority = 139509, groups = {})
	public void assetGroupNameTest() {
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertTrue(sessionDetailPage3560.getElementVisibleTextInSessionTileStrict(FCCM3560.assetGroupNameOld).equals(FCCM3560.assetGroupNameOld) || sessionDetailPage3560.getElementVisibleTextInSessionTileStrict(FCCM3560.assetGroupNameOld).equals(FCCM3560.assetGroupNameOld));
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".crumbTrailAssetGroupInfo").getText().equals(FCCM3560.assetGroupNameOld) || ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".crumbTrailAssetGroupInfo").getText().equals(FCCM3560.assetGroupNameOld));
	}

	@Test(priority = 139510, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void assetNameTest() {
		try {
			if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)
					|| DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				Assert.assertEquals(sessionDetailPage3560.getElementVisibleTextInSessionTileStrict(FCCM3560.assetNameOld),
						FCCM3560.assetNameOld);
			else if (DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				Assert.assertEquals(ElementUtils.getElement(null, null, null, null,
						LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".crumbTrailAssetName").getText(),
						FCCM3560.assetNameOld);
		} catch (Throwable e) {
			Assert.fail("Exception Detail: " + e);
		}
	}

	@Test(priority = 139511, groups = {

			FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS,
			FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void testPointNameTest() {
		try {
			if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)
					|| DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				Assert.assertEquals(
						sessionDetailPage3560.getElementVisibleTextInSessionTileStrict(FCCM3560.testPointNameOld),
						FCCM3560.testPointNameOld);
			else if (DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				Assert.assertEquals(ElementUtils.getElement(null, null, null, null,
						LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".assetNameTextSession").getText(),
						FCCM3560.testPointNameOld);
		} catch (Throwable e) {
			Assert.fail("Exception Detail: " + e);
		}
	}

	@Test(priority = 139513, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS })
	public void alarmIconTest() {
		try {
			List<WebElement> alarmIcons = sessionDetailPage3560
					.getSessionDetailPageObjects(SessionDetailPageObjectList.ALARM_ICONS);
			for (WebElement alarmIcon : alarmIcons) {
				Assert.assertTrue(alarmIcon.isDisplayed());
			}
		} catch (Throwable e) {
			Assert.fail("Min value time is not correct, exception details are: " + e);
		}
	}

	@Test(priority = 139514, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS })
	public void alertIconTest() {
		try {
			List<WebElement> alertIcons = sessionDetailPage3560
					.getSessionDetailPageObjects(SessionDetailPageObjectList.ALERT_ICONS);
			for (WebElement alertIcon : alertIcons) {
				if (alertIcon.isDisplayed())
					break;
			}
		} catch (Throwable e) {
			Assert.fail("Min value time is not correct, exception details are: " + e);
		}
	}

	@Test(priority = 139520, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS })
	public void sessionAlarmCountTest() {
		try {
			Assert.assertTrue(Integer.parseInt(sessionDetailPage3560
					.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ALARM_COUNT).getText()) >= 6);
		} catch (Throwable e) {
			Assert.fail("Incorrect vibration unit for sensor " + iterationValue + ", exception details are: " + e);
		}
	}

	@Test(priority = 139521, groups = {})
	public void sensorAlarmCountTest() {
		try {
			Assert.assertTrue(Integer.parseInt(sessionDetailPage3560
					.getSessionDetailPageObject(SessionDetailPageObjectList.SENSOR_ALARM_COUNT).getText()) >= 6);
		} catch (Throwable e) {
			Assert.fail("Incorrect vibration unit for sensor " + iterationValue + ", exception details are: " + e);
		}
	}

	@Test(priority = 139522, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS })
	public void sessionAlertCountTest() {
		try {
			Assert.assertTrue(Integer.parseInt(sessionDetailPage3560
					.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ALERT_COUNT).getText()) >= 1);
		} catch (Throwable e) {
			Assert.fail("Incorrect vibration unit for sensor " + iterationValue + ", exception details are: " + e);
		}
	}

	@Test(priority = 139530, groups = {})
	public void fovsTitleSessionActivityTest() throws Exception {
		mAlarmObject = null;
		sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.MORE_OPTIONS_BUTTON).click();
		CommonUtils.wait(1);
		sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.VIEW_SESSION_ACTIVITY).click();
		CommonUtils.wait(10);
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mAlarmObject = ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH,
					FCCM.AlarmObject.WEB_SESSION_FOVS.getObject());
			Assert.assertNotNull(ElementUtils.getElement(mAlarmObject, null, null, null, null,
					LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT, FCCM.AlarmText.WEB_SESSION_FOVS.getText())
					.isDisplayed());
		} else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)
				|| DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			CommonUtils.wait(1, 2, 1);
			Config.appWidthCenterFlag = true;
			IOSUtils.isPageLoaded(30, "Loading...");
			IOSUtils.setIOSPageSource();
			Assert.assertTrue(
					notificationsPage.isNotificationDisplayed(FCCM.AlarmText.ANDROID_SESSION_UNACCEPTABLE.getText(),
							FCCM.AlarmText.IOS_SESSION_UNACCEPTABLE.getText())
							|| notificationsPage.isNotificationDisplayed(
									FCCM.AlarmText.ANDROID_SESSION_UNSATISFACTORY.getText(),
									FCCM.AlarmText.IOS_SESSION_UNSATISFACTORY.getText()));
		}

	}

	@Test(priority = 139531, groups = {})
	public void fovsTypeSessionActivityTest() throws Exception {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mValueHolder.delete(0, mValueHolder.length());
			mValueHolder.append(ElementUtils.getElement(mAlarmObject, null, null, null, null,
					LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmText.WEB_SESSION_FOVS_TYPE.getText())
					.getText());
			Assert.assertTrue(mValueHolder.toString().equals("UNACCEPTABLE")
					|| (mValueHolder.toString().equals("UNSATISFACTORY")));
		}
	}

	@Test(priority = 139532, groups = {})
	public void fovsValueSessionActivityTest() throws Exception {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(
					Double.parseDouble((ElementUtils
							.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,
									FCCM.AlarmObject.WEB_SESSION_TRIGGERED_VALUE.getObject())
							.getText().split(" ")[0])) > 0.0);
	}

	@Test(priority = 139533, groups = {})
	public void fovsUnitSessionActivityTest() throws Exception {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(ElementUtils
					.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,
							FCCM.AlarmObject.WEB_SESSION_TRIGGERED_UNIT.getObject())
					.getText().equals(FCCM3560.vibrationUnit1InValue));
	}

	@Test(priority = 139534, groups = {})
	public void fovsAssetGroupNameSessionActivityTest() throws Exception {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(ElementUtils
					.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,
							FCCM.AlarmObject.WEB_SESSION_ASSET_GROUP.getObject())
					.getText().equals(FCCM3560.assetGroupNameOld)
					|| ElementUtils
							.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,
									FCCM.AlarmObject.WEB_SESSION_ASSET_GROUP.getObject())
							.getText().equals(FCCM3560.assetGroupNameOld));
	}

	@Test(priority = 139535, groups = {})
	public void fovsAssetNameSessionActivityTest() throws Exception {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(
					ElementUtils
							.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,
									FCCM.AlarmObject.WEB_SESSION_ASSET.getObject())
							.getText().equals(FCCM3560.assetNameOld));
	}

	@Test(priority = 139536, groups = {})
	public void fovsMachineCategoryNameSessionActivityTest() throws Exception {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(ElementUtils
					.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT,
							FCCM.AlarmText.WEB_SESSION_FOVS_MACHINE_CATEGORY.getText())
					.getText().equals(FCCM3560.machineCategoryName));
	}

	@Test(priority = 139540, groups = {})
	public void aboveVibrationTitleSessionActivityTest() throws Exception {
		mAlarmObject = null;
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mAlarmObject = ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH,
					FCCM.AlarmObject.WEB_SESSION_ABOVE_VIBRATION.getObject());
			Assert.assertNotNull(ElementUtils
					.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT,
							FCCM.AlarmText.WEB_SESSION_ACTIVITY_ABOVE_VIBRATION.getText())
					.isDisplayed());
		}
	}

	@Test(priority = 139541, groups = {})
	public void aboveVibrationThresholdSessionActivityTest() throws Exception {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mValueHolder.delete(0, mValueHolder.length());
			mValueHolder.append(ElementUtils.getElement(mAlarmObject, null, null, null, null,
					LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_THRESHOLD.getObject())
					.getText());
			Assert.assertTrue(mValueHolder.toString().contains(FCCM3560.aboveVibrationThresholdValue)
					&& (mValueHolder.toString().contains(FCCM3560.aboveVibrationUnit))
					&& (mValueHolder.toString().contains(">")));
		}
	}

	@Test(priority = 139542, groups = {  })
	public void aboveVibrationValueSessionActivityTest() throws Exception {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(
					Double.parseDouble((ElementUtils
							.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,
									FCCM.AlarmObject.WEB_SESSION_TRIGGERED_VALUE.getObject())
							.getText().split(" ")[0])) > 0.0);
	}

	@Test(priority = 139543, groups = {})
	public void aboveVibrationUnitSessionActivityTest() throws Exception {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(ElementUtils
					.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,
							FCCM.AlarmObject.WEB_SESSION_TRIGGERED_UNIT.getObject())
					.getText().equals(FCCM3560.aboveVibrationUnit));
	}

	@Test(priority = 139544, groups = {})
	public void aboveVibrationsAssetGroupNameSessionActivityTest() throws Exception {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(ElementUtils
					.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,
							FCCM.AlarmObject.WEB_SESSION_ASSET_GROUP.getObject())
					.getText().equals(FCCM3560.assetGroupNameOld)
					|| ElementUtils
							.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,
									FCCM.AlarmObject.WEB_SESSION_ASSET_GROUP.getObject())
							.getText().equals(FCCM3560.assetGroupNameOld));
	}

	@Test(priority = 139545, groups = { })
	public void aboveVibrationAssetNameSessionActivityTest() throws Exception {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(
					ElementUtils
							.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,
									FCCM.AlarmObject.WEB_SESSION_ASSET.getObject())
							.getText().equals(FCCM3560.assetNameOld));
	}

	@Test(priority = 139555, groups = { })
	public void belowVibrationTitleSessionActivityTest() throws Exception {
		mAlarmObject = null;
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mAlarmObject = ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH,
					FCCM.AlarmObject.WEB_SESSION_BELOW_VIBRATION.getObject());
			Assert.assertNotNull(ElementUtils
					.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT,
							FCCM.AlarmText.WEB_SESSION_ACTIVITY_BELOW_VIBRATION.getText())
					.isDisplayed());
		}
	}

	@Test(priority = 139556, groups = {})
	public void belowVibrationThresholdSessionActivityTest() throws Exception {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mValueHolder.delete(0, mValueHolder.length());
			mValueHolder.append(ElementUtils.getElement(mAlarmObject, null, null, null, null,
					LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_THRESHOLD.getObject())
					.getText());
			Assert.assertTrue(mValueHolder.toString().contains(FCCM3560.belowVibrationThresholdValue)
					&& (mValueHolder.toString().contains(FCCM3560.belowVibrationUnit))
					&& (mValueHolder.toString().contains("<")));
		}
	}

	@Test(priority = 139557, groups = {})
	public void belowVibrationValueSessionActivityTest() throws Exception {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(
					Double.parseDouble((ElementUtils
							.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,
									FCCM.AlarmObject.WEB_SESSION_TRIGGERED_VALUE.getObject())
							.getText().split(" ")[0])) > 0.0);
	}

	@Test(priority = 139558, groups = {})
	public void belowVibrationUnitSessionActivityTest() throws Exception {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(ElementUtils
					.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,
							FCCM.AlarmObject.WEB_SESSION_TRIGGERED_UNIT.getObject())
					.getText().equals(FCCM3560.belowVibrationUnit));
	}

	@Test(priority = 139559, groups = {})
	public void belowVibrationsAssetGroupNameSessionActivityTest() throws Exception {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(ElementUtils
					.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,
							FCCM.AlarmObject.WEB_SESSION_ASSET_GROUP.getObject())
					.getText().equals(FCCM3560.assetGroupNameOld)
					|| ElementUtils
							.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,
									FCCM.AlarmObject.WEB_SESSION_ASSET_GROUP.getObject())
							.getText().equals(FCCM3560.assetGroupNameOld));
	}

	@Test(priority = 139560, groups = {})
	public void belowVibrationAssetNameSessionActivityTest() throws Exception {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(
					ElementUtils
							.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,
									FCCM.AlarmObject.WEB_SESSION_ASSET.getObject())
							.getText().equals(FCCM3560.assetNameOld));
	}

	@Test(priority = 139570, groups = {})
	public void withinVibrationTitleSessionActivityTest() throws Exception {
		mAlarmObject = null;
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mAlarmObject = ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH,
					FCCM.AlarmObject.WEB_SESSION_WITHIN_VIBRATION.getObject());
			Assert.assertNotNull(ElementUtils
					.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT,
							FCCM.AlarmText.WEB_SESSION_ACTIVITY_WITHIN_VIBRATION.getText())
					.isDisplayed());
		}
	}

	@Test(priority = 139571, groups = {})
	public void withinVibrationThresholdSessionActivityTest() throws Exception {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mValueHolder.delete(0, mValueHolder.length());
			mValueHolder.append(ElementUtils.getElement(mAlarmObject, null, null, null, null,
					LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_THRESHOLD.getObject())
					.getText());
			Assert.assertTrue(mValueHolder.toString().contains(FCCM3560.withinVibrationUpperThresholdValue)
					&& (mValueHolder.toString().contains(FCCM3560.withinVibrationUnit))
					&& (mValueHolder.toString().contains(FCCM3560.withinVibrationLowerThresholdValue)));
		}
	}

	@Test(priority = 139572, groups = {})
	public void withinVibrationValueSessionActivityTest() throws Exception {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(
					Double.parseDouble((ElementUtils
							.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,
									FCCM.AlarmObject.WEB_SESSION_TRIGGERED_VALUE.getObject())
							.getText().split(" ")[0])) > 0.0);
	}

	@Test(priority = 139573, groups = {})
	public void withinVibrationUnitSessionActivityTest() throws Exception {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(ElementUtils
					.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,
							FCCM.AlarmObject.WEB_SESSION_TRIGGERED_UNIT.getObject())
					.getText().equals(FCCM3560.withinVibrationUnit));
	}

	@Test(priority = 139574, groups = {})
	public void withinVibrationsAssetGroupNameSessionActivityTest() throws Exception {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(ElementUtils
					.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,
							FCCM.AlarmObject.WEB_SESSION_ASSET_GROUP.getObject())
					.getText().equals(FCCM3560.assetGroupNameOld)
					
					|| ElementUtils
							.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,
									FCCM.AlarmObject.WEB_SESSION_ASSET_GROUP.getObject())
							.getText().equals(FCCM3560.assetGroupNameOld));
	}

	@Test(priority = 139575, groups = {})
	public void withinVibrationAssetNameSessionActivityTest() throws Exception {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(
					ElementUtils
							.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,
									FCCM.AlarmObject.WEB_SESSION_ASSET.getObject())
							.getText().equals(FCCM3560.assetNameOld));
	}

	@Test(priority = 139585, groups = {})
	public void outofVibrationTitleSessionActivityTest() throws Exception {
		mAlarmObject = null;
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mAlarmObject = ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH,
					FCCM.AlarmObject.WEB_SESSION_OUTOF_VIBRATION.getObject());
			Assert.assertNotNull(ElementUtils
					.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT,
							FCCM.AlarmText.WEB_SESSION_ACTIVITY_OUTOF_VIBRATION.getText())
					.isDisplayed());
		}
	}

	@Test(priority = 139586, groups = {})
	public void outofVibrationThresholdSessionActivityTest() throws Exception {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mValueHolder.delete(0, mValueHolder.length());
			mValueHolder.append(ElementUtils.getElement(mAlarmObject, null, null, null, null,
					LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, FCCM.AlarmObject.WEB_SESSION_THRESHOLD.getObject())
					.getText());
			Assert.assertTrue(mValueHolder.toString().contains(FCCM3560.outofVibrationUpperThresholdValue)
					&& (mValueHolder.toString().contains(FCCM3560.outofVibrationUnit))
					&& (mValueHolder.toString().contains(FCCM3560.outofVibrationLowerThresholdValue)));
		}
	}

	@Test(priority = 139587, groups = {})
	public void outofVibrationValueSessionActivityTest() throws Exception {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(
					Double.parseDouble((ElementUtils
							.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,
									FCCM.AlarmObject.WEB_SESSION_TRIGGERED_VALUE.getObject())
							.getText().split(" ")[0])) > 0.0);
	}

	@Test(priority = 139588, groups = {})
	public void outofVibrationUnitSessionActivityTest() throws Exception {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(ElementUtils
					.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,
							FCCM.AlarmObject.WEB_SESSION_TRIGGERED_UNIT.getObject())
					.getText().equals(FCCM3560.outofVibrationUnit));
	}

	@Test(priority = 139589, groups = {})
	public void outofVibrationsAssetGroupNameSessionActivityTest() throws Exception {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(ElementUtils
					.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,
							FCCM.AlarmObject.WEB_SESSION_ASSET_GROUP.getObject())
					.getText().equals(FCCM3560.assetGroupNameOld)
					|| ElementUtils
							.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,
									FCCM.AlarmObject.WEB_SESSION_ASSET_GROUP.getObject())
							.getText().equals(FCCM3560.assetGroupNameOld));
	}

	@Test(priority = 139590, groups = {})
	public void outofVibrationAssetNameSessionActivityTest() throws Exception {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(
					ElementUtils
							.getElement(mAlarmObject, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,
									FCCM.AlarmObject.WEB_SESSION_ASSET.getObject())
							.getText().equals(FCCM3560.assetNameOld));
	}

	@Test(priority = 139800, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void vibrationUnitTest() {
		try {
			if (DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_DONE_BUTTON).click();
			//else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			//	sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.SESSION_ACTIVITY_BACK_BUTTON).click();
			for (iterationValue = 0; iterationValue < sensorCount; iterationValue++) {
				gestureUtils.mScroll(FCCM3560.vibrationUnitMobile, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
				Assert.assertTrue(sessionDetailPage3560.getSessionDetailPage3560Object(SessionDetailPage3560ObjectList.VIBRATION_UNIT).getText().equals(FCCM3560.vibrationUnitMobile)|| sessionDetailPage3560
								.getSessionDetailPage3560Object(SessionDetailPage3560ObjectList.VIBRATION_UNIT)
								.getText().equals(FCCM3560.vibrationUnitWeb));
			}
		} catch (Throwable e) {
			Assert.fail("Incorrect vibration unit for sensor " + iterationValue + ", exception details are: " + e);
		}
	}

	@Test(priority = 139801, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void tempratureUnitTest() {
		try {
			for (iterationValue = 0; iterationValue < sensorCount; iterationValue++) {
				Assert.assertTrue(sessionDetailPage3560
						.getSessionDetailPage3560Object(SessionDetailPage3560ObjectList.TEMPRATURE_UNIT).getText()
						.equals(FCCM3560.tempratureUnitFarenightiOS)
						|| sessionDetailPage3560
								.getSessionDetailPage3560Object(SessionDetailPage3560ObjectList.TEMPRATURE_UNIT)
								.getText().equals(FCCM3560.tempratureUnitCelsiusiOS)
						|| sessionDetailPage3560
								.getSessionDetailPage3560Object(SessionDetailPage3560ObjectList.TEMPRATURE_UNIT)
								.getText().equals(FCCM3560.tempratureUnitFarenightAndroid)
						|| sessionDetailPage3560
								.getSessionDetailPage3560Object(SessionDetailPage3560ObjectList.TEMPRATURE_UNIT)
								.getText().equals(FCCM3560.tempratureUnitCelsiusAndroid)
						|| sessionDetailPage3560
								.getSessionDetailPage3560Object(SessionDetailPage3560ObjectList.TEMPRATURE_UNIT)
								.getText().equals(FCCM3560.tempratureUnitCelsiusWeb)
						|| sessionDetailPage3560
								.getSessionDetailPage3560Object(SessionDetailPage3560ObjectList.TEMPRATURE_UNIT)
								.getText().equals(FCCM3560.tempratureUnitFarenightWeb));
			}
		} catch (Throwable e) {
			Assert.fail("Incorrect vibration unit for sensor " + iterationValue + ", exception details are: " + e);
		}
	}

	@Test(priority = 139802, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void graphDisplayedTest() {
		try {
			for (iterationValue = 0; iterationValue < sensorCount; iterationValue++) {
				if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)
						|| DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
					gestureUtils.mScroll(-400, -250, 1);
					Assert.assertTrue(sessionDetailPage3560.isGraphDisplayed(FCCM3560.vibrationUnitMobile));
				} else if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
					Assert.assertTrue(sessionDetailPage3560.isGraphDisplayed(null));
				}
			}
		} catch (Throwable e) {
			Assert.fail("No graph object for sensor " + iterationValue + ", exception details are: " + e);
		}
	}

	@Test(priority = 139803, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void maxLabelIn1HTabTest() {
		try {
			gestureUtils.mScroll("MAX", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE,
					LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
			Assert.assertTrue(sessionDetailPage3560.getElementInSessionTileStrict("MAX").isDisplayed());
		} catch (Throwable e) {
			Assert.fail("MAX label is not displayed, exception details are: " + e);
		}
	}

	@Test(priority = 139804, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void minLabelIn1HTabTest() {
		try {
			Assert.assertTrue(sessionDetailPage3560.getElementInSessionTileStrict("MIN").isDisplayed());
		} catch (Throwable e) {
			Assert.fail("MIN label is not displayed, exception details are: " + e);
		}
	}

/*	@Test(priority = 139705, groups = {})
	public void livePollingTest() {
		try {
			sessionDetailPage3560.scrollToGraphTab("1H", ScrollDiection.UP);
			for (iterationValue = 0; iterationValue < sensorCount; iterationValue++) {
				Assert.assertTrue(sessionDetailPage3560.isLivePollingHappening("./graph/bp", "./graph/ap", "./graph/dp",
						".png", iterationValue, 5, 60, Config.IOS_LOCATOR_STRATEGY_NAME, FCCM3560.vibrationUnit, -300,
						-45, 10, -150, -45)); 
			}
		} catch (Throwable e) {
			Assert.fail("No live polling is happening on sensor " + iterationValue + ", exception details are: " + e);
		}
	} */

	@Test(priority = 139806, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void xAxisLabelIn1HTabTest() {
		try {
			gestureUtils.mScroll("Show Alarms", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME,
					LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
			Assert.assertTrue(sessionDetailPage3560.getElementInSessionTileStrict("X Axis").isDisplayed());
		} catch (Throwable e) {
			Assert.fail("X Axis label is not displayed, exception details are: " + e);
		}
	}

	@Test(priority = 139807, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void yAxisLabelIn1HTabTest() {
		try {
			Assert.assertTrue(sessionDetailPage3560.getElementInSessionTileStrict("Y Axis").isDisplayed());
		} catch (Throwable e) {
			Assert.fail("Y Axis label is not displayed, exception details are: " + e);
		}
	}

	@Test(priority = 139808, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void zAxisLabelIn1HTabTest() {
		try {
			Assert.assertTrue(sessionDetailPage3560.getElementInSessionTileStrict("Z Axis").isDisplayed());
		} catch (Throwable e) {
			Assert.fail("Z Axis label is not displayed, exception details are: " + e);
		}
	}

	@Test(priority = 139809, groups = {

			FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS,
			FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void vibrationValueIn1HTabTest() {
		try {
			for (iterationValue = 0; iterationValue < sensorCount; iterationValue++) {
				vibrationList = sessionDetailPage3560.getVibrationList();
				tempratureList = sessionDetailPage3560.getTempratureList();
				dateList = sessionDetailPage3560.getDateList();
				timeList = sessionDetailPage3560.getTimeList();
				if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
					if (isActiveSession) {
						for (int i = 0; i < 2; i++) {
							timeList.remove(i);
						}
					} else {
						for (int i = 0; i < 4; i++) {
							timeList.remove(i);
						}
					}
				}
			}
			for (String value : vibrationList) {
				value = value.substring(0, value.indexOf(' '));
				Assert.assertTrue(
						CommonUtils.getDoubleValue(value) > 0.000 && CommonUtils.getDoubleValue(value) < 3.001);
			}
		} catch (Throwable e) {
			Assert.fail("Vibration value is coming as stale or too high" + iterationValue + ", exception details are: "
					+ e);
		}
	}

	@Test(priority = 139810, groups = {

			FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS,
			FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS }, dependsOnMethods = { "vibrationValueIn1HTabTest" })
	public void vibrationUnitIn1HTabTest() {
		try {
			for (String value : vibrationList) {
				Assert.assertTrue(value.contains(FCCM3560.vibrationUnitInValue)
						|| value.contains(FCCM3560.vibrationUnit1InValue));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 139811, groups = {

			FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS,
			FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void tempratureValueIn1HTabTest() {
		try {
			for (String value : tempratureList) {
				value = value.substring(0, value.indexOf(' '));
				Assert.assertTrue(
						CommonUtils.getDoubleValue(value) >= 0.0 && CommonUtils.getDoubleValue(value) < 110.0);
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 139812, groups = {

			FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS,
			FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS }, dependsOnMethods = { "tempratureValueIn1HTabTest" })
	public void tempratureUnitIn1HTabTest() {
		try {
			for (String value : tempratureList) {
				Assert.assertTrue(value.contains("°C") || value.contains("℃")
						|| value.contains(FCCM3560.measurementValueTempratureUnitCelseiusAndroid)
						|| value.contains(FCCM3560.measurementValueTempratureUnitFarenightAndroid)
						|| value.contains(FCCM3560.measurementValueTempratureUnitCelseiusiOS)
						|| value.contains(FCCM3560.measurementValueTempratureUnitFarenightiOS));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 139813, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void dateValueIn1HTabTest() {
		try {
			for (String value : dateList) {
				Assert.assertTrue(value.contains("/"));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 139814, groups = {

			FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS,
			FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void timeValueIn1HTabTest() {
		try {
			for (String value : timeList) {
				Assert.assertTrue(value.contains(":"));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 139815, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void scrollGraphRight1HTab() {
		try {
			gestureUtils.swipe(ScrollDiection.RIGHT,
					sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.GRAPH_OBJECT), 150);
		} catch (Throwable e) {
			Assert.fail("Exception Detail: " + e);
		}
	}

	@Test(priority = 139816, groups = {})
	public void scrollGraphLeft1HTab() {
		try {
			sessionDetailPage3560.scrollGraph(ScrollDiection.LEFT, 2);
		} catch (Throwable e) {
			Assert.fail("Exception Detail: " + e);
		}
	}

	@Test(priority = 139900, groups = {

			FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS,
			FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void switchTo8HTabTest() {
		try {
			sessionDetailPage3560.switchToOtherTab("8H", ScrollDiection.UP);
			gestureUtils.mScroll("Show Alarms", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME,
					LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
			for (iterationValue = 0; iterationValue < sensorCount; iterationValue++) {
				vibrationList = sessionDetailPage3560.getVibrationList();
				tempratureList = sessionDetailPage3560.getTempratureList();
				dateList = sessionDetailPage3560.getDateList();
				timeList = sessionDetailPage3560.getTimeList();
				if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
					if (isActiveSession) {
						for (int i = 0; i < 2; i++) {
							timeList.remove(i);
						}
					} else {
						for (int i = 0; i < 4; i++) {
							timeList.remove(i);
						}
					}
				}
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 139901, groups = {

			FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS,
			FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void vibrationValueIn8HTabTest() {
		try {
			for (String value : vibrationList) {
				value = value.substring(0, value.indexOf(' '));
				Assert.assertTrue(
						CommonUtils.getDoubleValue(value) > 0.000 && CommonUtils.getDoubleValue(value) < 3.001);
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 139902, groups = {

			FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS,
			FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS }, dependsOnMethods = { "vibrationValueIn8HTabTest" })
	public void vibrationUnitIn8HTabTest() {
		try {
			for (String value : vibrationList) {
				Assert.assertTrue(value.contains(FCCM3560.vibrationUnitInValue)
						|| value.contains(FCCM3560.vibrationUnit1InValue));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 139903, groups = {

			FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS,
			FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void tempratureValueIn8HTabTest() {
		try {
			for (String value : tempratureList) {
				value = value.substring(0, value.indexOf(' '));
				Assert.assertTrue(
						CommonUtils.getDoubleValue(value) >= 0.0 && CommonUtils.getDoubleValue(value) < 110.0);
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 139904, groups = {

			FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS,
			FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS }, dependsOnMethods = { "tempratureValueIn8HTabTest" })
	public void tempratureUnitIn8HTabTest() {
		try {
			for (String value : tempratureList) {
				Assert.assertTrue(value.contains("°C") || value.contains("℃")
						|| value.contains(FCCM3560.measurementValueTempratureUnitCelseiusAndroid)
						|| value.contains(FCCM3560.measurementValueTempratureUnitFarenightAndroid)
						|| value.contains(FCCM3560.measurementValueTempratureUnitCelseiusiOS)
						|| value.contains(FCCM3560.measurementValueTempratureUnitFarenightiOS));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 139905, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void dateValueIn8HTabTest() {
		try {
			for (String value : dateList) {
				Assert.assertTrue(value.contains("/"));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 139906, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void timeValueIn8HTabTest() {
		try {
			for (String value : timeList) {
				Assert.assertTrue(value.contains(":"));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 139907, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void scrollGraphRight8HTab() {
		try {
			gestureUtils.swipe(ScrollDiection.RIGHT,
					sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.GRAPH_OBJECT), 150);
		} catch (Throwable e) {
			Assert.fail("Exception Detail: " + e);
		}
	}

	@Test(priority = 139908, groups = {})
	public void scrollGraphLeft8HTab() {
		try {
			gestureUtils.swipe(ScrollDiection.LEFT,
					sessionDetailPage3560.getSessionDetailPageObject(SessionDetailPageObjectList.GRAPH_OBJECT), 150);
		} catch (Throwable e) {
			Assert.fail("Exception Detail: " + e);
		}
	}

	@Test(priority = 140000, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void switchTo1WTabTest() {
		try {
			sessionDetailPage3560.switchToOtherTab("1W", ScrollDiection.UP);
			gestureUtils.mScroll("Show Alarms", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME,
					LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
			for (iterationValue = 0; iterationValue < sensorCount; iterationValue++) {
				vibrationList = sessionDetailPage3560.getVibrationList();
				tempratureList = sessionDetailPage3560.getTempratureList();
				dateList = sessionDetailPage3560.getDateList();
				timeList = sessionDetailPage3560.getTimeList();
				if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
					if (isActiveSession) {
						for (int i = 0; i < 2; i++) {
							timeList.remove(i);
						}
					} else {
						for (int i = 0; i < 4; i++) {
							timeList.remove(i);
						}
					}
				}
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140001, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void vibrationValueIn1WTabTest() {
		try {
			for (String value : vibrationList) {
				value = value.substring(0, value.indexOf(' '));
				Assert.assertTrue(
						CommonUtils.getDoubleValue(value) > 0.000 && CommonUtils.getDoubleValue(value) < 3.001);
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140002, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void vibrationUnitIn1WTabTest() {
		try {
			for (String value : vibrationList) {
				Assert.assertTrue(value.contains(FCCM3560.vibrationUnitInValue)
						|| value.contains(FCCM3560.vibrationUnit1InValue));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140003, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void tempratureValueIn1WTabTest() {
		try {
			for (String value : tempratureList) {
				value = value.substring(0, value.indexOf(' '));
				Assert.assertTrue(
						CommonUtils.getDoubleValue(value) >= 0.0 && CommonUtils.getDoubleValue(value) < 110.0);
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140004, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void tempratureUnitIn1WTabTest() {
		try {
			for (String value : tempratureList) {
				Assert.assertTrue(value.contains("°C") || value.contains("℃")
						|| value.contains(FCCM3560.measurementValueTempratureUnitCelseiusAndroid)
						|| value.contains(FCCM3560.measurementValueTempratureUnitFarenightAndroid)
						|| value.contains(FCCM3560.measurementValueTempratureUnitCelseiusiOS)
						|| value.contains(FCCM3560.measurementValueTempratureUnitFarenightiOS));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140005, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void dateValueIn1WTabTest() {
		try {
			for (String value : dateList) {
				Assert.assertTrue(value.contains("/"));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140006, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void timeValueIn1WTabTest() {
		try {
			for (String value : timeList) {
				Assert.assertTrue(value.contains(":"));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140050, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void switchTo3WTabTest() {
		try {
			sessionDetailPage3560.switchToOtherTab("3W", ScrollDiection.UP);
			gestureUtils.mScroll("Show Alarms", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME,
					LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
			for (iterationValue = 0; iterationValue < sensorCount; iterationValue++) {
				vibrationList = sessionDetailPage3560.getVibrationList();
				tempratureList = sessionDetailPage3560.getTempratureList();
				dateList = sessionDetailPage3560.getDateList();
				timeList = sessionDetailPage3560.getTimeList();
				if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
					if (isActiveSession) {
						for (int i = 0; i < 2; i++) {
							timeList.remove(i);
						}
					} else {
						for (int i = 0; i < 4; i++) {
							timeList.remove(i);
						}
					}
				}
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140051, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void vibrationValueIn3WTabTest() {
		try {
			for (String value : vibrationList) {
				value = value.substring(0, value.indexOf(' '));
				Assert.assertTrue(
						CommonUtils.getDoubleValue(value) > 0.000 && CommonUtils.getDoubleValue(value) < 3.001);
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140052, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void vibrationUnitIn3WTabTest() {
		try {
			for (String value : vibrationList) {
				Assert.assertTrue(value.contains(FCCM3560.vibrationUnitInValue)
						|| value.contains(FCCM3560.vibrationUnit1InValue));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140053, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void tempratureValueIn3WTabTest() {
		try {
			for (String value : tempratureList) {
				value = value.substring(0, value.indexOf(' '));
				Assert.assertTrue(
						CommonUtils.getDoubleValue(value) >= 0.0 && CommonUtils.getDoubleValue(value) < 110.0);
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140054, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void tempratureUnitIn3WTabTest() {
		try {
			for (String value : tempratureList) {
				Assert.assertTrue(value.contains("°C") || value.contains("℃")
						|| value.contains(FCCM3560.measurementValueTempratureUnitCelseiusAndroid)
						|| value.contains(FCCM3560.measurementValueTempratureUnitFarenightAndroid)
						|| value.contains(FCCM3560.measurementValueTempratureUnitCelseiusiOS)
						|| value.contains(FCCM3560.measurementValueTempratureUnitFarenightiOS));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140055, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void dateValueIn3WTabTest() {
		try {
			for (String value : dateList) {
				Assert.assertTrue(value.contains("/"));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140056, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void timeValueIn3WTabTest() {
		try {
			for (String value : timeList) {
				Assert.assertTrue(value.contains(":"));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140100, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void switchToAllTabTest() {
		try {
			if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)
					|| DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				sessionDetailPage3560.switchToOtherTab("ALL", ScrollDiection.UP);
			if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				sessionDetailPage3560.switchToOtherTab("All", ScrollDiection.UP);
			gestureUtils.mScroll("Show Alarms", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME,
					LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
			for (iterationValue = 0; iterationValue < sensorCount; iterationValue++) {
				vibrationList = sessionDetailPage3560.getVibrationList();
				tempratureList = sessionDetailPage3560.getTempratureList();
				dateList = sessionDetailPage3560.getDateList();
				timeList = sessionDetailPage3560.getTimeList();
				if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
					if (isActiveSession) {
						for (int i = 0; i < 2; i++) {
							timeList.remove(i);
						}
					} else {
						for (int i = 0; i < 4; i++) {
							timeList.remove(i);
						}
					}
				}
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140101, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void vibrationValueInAllTabTest() {
		try {
			for (String value : vibrationList) {
				value = value.substring(0, value.indexOf(' '));
				Assert.assertTrue(
						CommonUtils.getDoubleValue(value) > 0.000 && CommonUtils.getDoubleValue(value) < 3.001);
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140102, groups = {

			FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS,
			FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS }, dependsOnMethods = { "vibrationValueInAllTabTest" })
	public void vibrationUnitInAllTabTest() {
		try {
			for (String value : vibrationList) {
				Assert.assertTrue(value.contains(FCCM3560.vibrationUnitInValue)
						|| value.contains(FCCM3560.vibrationUnit1InValue));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140103, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void tempratureValueInAllTabTest() {
		try {
			for (String value : tempratureList) {
				value = value.substring(0, value.indexOf(' '));
				Assert.assertTrue(
						CommonUtils.getDoubleValue(value) >= 0.0 && CommonUtils.getDoubleValue(value) < 110.0);
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140104, groups = {

			FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS,
			FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS }, dependsOnMethods = { "tempratureValueInAllTabTest" })
	public void tempratureUnitInAllTabTest() {
		try {
			for (String value : tempratureList) {
				Assert.assertTrue(value.contains("°C") || value.contains("℃")
						|| value.contains(FCCM3560.measurementValueTempratureUnitCelseiusAndroid)
						|| value.contains(FCCM3560.measurementValueTempratureUnitFarenightAndroid)
						|| value.contains(FCCM3560.measurementValueTempratureUnitCelseiusiOS)
						|| value.contains(FCCM3560.measurementValueTempratureUnitFarenightiOS));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140105, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void dateValueInAllTabTest() {
		try {
			for (String value : dateList) {
				Assert.assertTrue(value.contains("/"));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140106, groups = { FCCM3560.PROD_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void timeValueInAllTabTest() {
		try {
			for (String value : timeList) {
				Assert.assertTrue(value.contains(":"));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140150, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void switchToAll3WTabTest() {
		try {
			sessionDetailPage3560.switchToOtherTab("3W", ScrollDiection.UP);
			gestureUtils.mScroll("Show Alarms", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME,
					LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
			for (iterationValue = 0; iterationValue < sensorCount; iterationValue++) {
				vibrationList = sessionDetailPage3560.getVibrationList();
				tempratureList = sessionDetailPage3560.getTempratureList();
				dateList = sessionDetailPage3560.getDateList();
				timeList = sessionDetailPage3560.getTimeList();
				if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
					if (isActiveSession) {
						for (int i = 0; i < 2; i++) {
							timeList.remove(i);
						}
					} else {
						for (int i = 0; i < 4; i++) {
							timeList.remove(i);
						}
					}
				}
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140151, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void vibrationValueInAll3WTabTest() {
		try {
			for (String value : vibrationList) {
				value = value.substring(0, value.indexOf(' '));
				Assert.assertTrue(
						CommonUtils.getDoubleValue(value) > 0.000 && CommonUtils.getDoubleValue(value) < 3.001);
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140152, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void vibrationUnitInAll3WTabTest() {
		try {
			for (String value : vibrationList) {
				Assert.assertTrue(value.contains(FCCM3560.vibrationUnitInValue)
						|| value.contains(FCCM3560.vibrationUnit1InValue));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140153, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void tempratureValueInAll3WTabTest() {
		try {
			for (String value : tempratureList) {
				value = value.substring(0, value.indexOf(' '));
				Assert.assertTrue(
						CommonUtils.getDoubleValue(value) >= 0.0 && CommonUtils.getDoubleValue(value) < 110.0);
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140154, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void tempratureUnitInAll3WTabTest() {
		try {
			for (String value : tempratureList) {
				Assert.assertTrue(value.contains("°C") || value.contains("℃")
						|| value.contains(FCCM3560.measurementValueTempratureUnitCelseiusAndroid)
						|| value.contains(FCCM3560.measurementValueTempratureUnitFarenightAndroid)
						|| value.contains(FCCM3560.measurementValueTempratureUnitCelseiusiOS)
						|| value.contains(FCCM3560.measurementValueTempratureUnitFarenightiOS));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140155, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void dateValueInAll3WTabTest() {
		try {
			for (String value : dateList) {
				Assert.assertTrue(value.contains("/"));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140156, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void timeValueInAll3WTabTest() {
		try {
			for (String value : timeList) {
				Assert.assertTrue(value.contains(":"));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140200, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void switchTo3W1WTabTest() {
		try {
			sessionDetailPage3560.switchToOtherTab("1W", ScrollDiection.UP);
			gestureUtils.mScroll("Show Alarms", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME,
					LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
			for (iterationValue = 0; iterationValue < sensorCount; iterationValue++) {
				vibrationList = sessionDetailPage3560.getVibrationList();
				tempratureList = sessionDetailPage3560.getTempratureList();
				dateList = sessionDetailPage3560.getDateList();
				timeList = sessionDetailPage3560.getTimeList();
				if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
					if (isActiveSession) {
						for (int i = 0; i < 2; i++) {
							timeList.remove(i);
						}
					} else {
						for (int i = 0; i < 4; i++) {
							timeList.remove(i);
						}
					}
				}
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140201, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void vibrationValueIn3W1WTabTest() {
		try {
			for (String value : vibrationList) {
				value = value.substring(0, value.indexOf(' '));
				Assert.assertTrue(
						CommonUtils.getDoubleValue(value) > 0.000 && CommonUtils.getDoubleValue(value) < 3.001);
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140202, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void vibrationUnitIn3W1WTabTest() {
		try {
			for (String value : vibrationList) {
				Assert.assertTrue(value.contains(FCCM3560.vibrationUnitInValue)
						|| value.contains(FCCM3560.vibrationUnit1InValue));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140203, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void tempratureValueIn3W1WTabTest() {
		try {
			for (String value : tempratureList) {
				value = value.substring(0, value.indexOf(' '));
				Assert.assertTrue(
						CommonUtils.getDoubleValue(value) >= 0.0 && CommonUtils.getDoubleValue(value) < 110.0);
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140204, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void tempratureUnitIn3W1WTabTest() {
		try {
			for (String value : tempratureList) {
				Assert.assertTrue(value.contains("°C") || value.contains("℃")
						|| value.contains(FCCM3560.measurementValueTempratureUnitCelseiusAndroid)
						|| value.contains(FCCM3560.measurementValueTempratureUnitFarenightAndroid)
						|| value.contains(FCCM3560.measurementValueTempratureUnitCelseiusiOS)
						|| value.contains(FCCM3560.measurementValueTempratureUnitFarenightiOS));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140205, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void dateValueIn3W1WTabTest() {
		try {
			for (String value : dateList) {
				Assert.assertTrue(value.contains("/"));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140206, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void timeValueIn3W1WTabTest() {
		try {
			for (String value : timeList) {
				Assert.assertTrue(value.contains(":"));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140250, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void switchTo1W8HTabTest() {
		try {
			sessionDetailPage3560.switchToOtherTab("8H", ScrollDiection.UP);
			gestureUtils.mScroll("Show Alarms", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME,
					LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
			for (iterationValue = 0; iterationValue < sensorCount; iterationValue++) {
				vibrationList = sessionDetailPage3560.getVibrationList();
				tempratureList = sessionDetailPage3560.getTempratureList();
				dateList = sessionDetailPage3560.getDateList();
				timeList = sessionDetailPage3560.getTimeList();
				if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
					if (isActiveSession) {
						for (int i = 0; i < 2; i++) {
							timeList.remove(i);
						}
					} else {
						for (int i = 0; i < 4; i++) {
							timeList.remove(i);
						}
					}
				}
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140251, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void vibrationValueIn1W8HTabTest() {
		try {
			for (String value : vibrationList) {
				value = value.substring(0, value.indexOf(' '));
				Assert.assertTrue(
						CommonUtils.getDoubleValue(value) > 0.000 && CommonUtils.getDoubleValue(value) < 3.001);
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140252, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void vibrationUnitIn1W8HTabTest() {
		try {
			for (String value : vibrationList) {
				Assert.assertTrue(value.contains(FCCM3560.vibrationUnitInValue)
						|| value.contains(FCCM3560.vibrationUnit1InValue));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140253, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void tempratureValueIn1W8HTabTest() {
		try {
			for (String value : tempratureList) {
				value = value.substring(0, value.indexOf(' '));
				Assert.assertTrue(
						CommonUtils.getDoubleValue(value) >= 0.0 && CommonUtils.getDoubleValue(value) < 110.0);
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140254, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void tempratureUnitIn1W8HTabTest() {
		try {
			for (String value : tempratureList) {
				Assert.assertTrue(value.contains("°C") || value.contains("℃")
						|| value.contains(FCCM3560.measurementValueTempratureUnitCelseiusAndroid)
						|| value.contains(FCCM3560.measurementValueTempratureUnitFarenightAndroid)
						|| value.contains(FCCM3560.measurementValueTempratureUnitCelseiusiOS)
						|| value.contains(FCCM3560.measurementValueTempratureUnitFarenightiOS));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140255, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void dateValueIn1W8HTabTest() {
		try {
			for (String value : dateList) {
				Assert.assertTrue(value.contains("/"));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140256, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void timeValueIn1W8HTabTest() {
		try {
			for (String value : timeList) {
				Assert.assertTrue(value.contains(":"));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140257, groups = {})
	public void scrollGraphRight1W8HTab() {
		try {
			sessionDetailPage3560.scrollGraph(ScrollDiection.RIGHT, 4);
		} catch (Throwable e) {
			Assert.fail("Exception Detail: " + e);
		}
	}

	@Test(priority = 140258, groups = {})
	public void scrollGraphLeft1W8HTab() {
		try {
			sessionDetailPage3560.scrollGraph(ScrollDiection.LEFT, 2);
		} catch (Throwable e) {
			Assert.fail("Exception Detail: " + e);
		}
	}

	@Test(priority = 140300, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void switchTo8H1HTabTest() {
		try {
			sessionDetailPage3560.switchToOtherTab("1H", ScrollDiection.UP);
			gestureUtils.mScroll("Show Alarms", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME,
					LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
			for (iterationValue = 0; iterationValue < sensorCount; iterationValue++) {
				vibrationList = sessionDetailPage3560.getVibrationList();
				tempratureList = sessionDetailPage3560.getTempratureList();
				dateList = sessionDetailPage3560.getDateList();
				timeList = sessionDetailPage3560.getTimeList();
				if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
					if (isActiveSession) {
						for (int i = 0; i < 2; i++) {
							timeList.remove(i);
						}
					} else {
						for (int i = 0; i < 4; i++) {
							timeList.remove(i);
						}
					}
				}
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140301, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void vibrationValueIn8H1HTabTest() {
		try {
			for (String value : vibrationList) {
				value = value.substring(0, value.indexOf(' '));
				Assert.assertTrue(
						CommonUtils.getDoubleValue(value) > 0.000 && CommonUtils.getDoubleValue(value) < 3.001);
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140302, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void vibrationUnitIn8H1HTabTest() {
		try {
			for (String value : vibrationList) {
				Assert.assertTrue(value.contains(FCCM3560.vibrationUnitInValue)
						|| value.contains(FCCM3560.vibrationUnit1InValue));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140303, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void tempratureValueIn8H1HTabTest() {
		try {
			for (String value : tempratureList) {
				value = value.substring(0, value.indexOf(' '));
				Assert.assertTrue(
						CommonUtils.getDoubleValue(value) >= 0.0 && CommonUtils.getDoubleValue(value) < 110.0);
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140304, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void tempratureUnitIn8H1HTabTest() {
		try {
			for (String value : tempratureList) {
				Assert.assertTrue(value.contains("°C") || value.contains("℃")
						|| value.contains(FCCM3560.measurementValueTempratureUnitCelseiusAndroid)
						|| value.contains(FCCM3560.measurementValueTempratureUnitFarenightAndroid)
						|| value.contains(FCCM3560.measurementValueTempratureUnitCelseiusiOS)
						|| value.contains(FCCM3560.measurementValueTempratureUnitFarenightiOS));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140305, groups = {FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void dateValueIn8H1HTabTest() {
		try {
			for (String value : dateList) {
				Assert.assertTrue(value.contains("/"));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140306, groups = { FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS })
	public void timeValueIn8H1HTabTest() {
		try {
			for (String value : timeList) {
				Assert.assertTrue(value.contains(":"));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}

	@Test(priority = 140307, groups = {})
	public void scrollGraphRight8H1HTab() {
		try {
			sessionDetailPage3560.scrollGraph(ScrollDiection.RIGHT, 4);
		} catch (Throwable e) {
			Assert.fail("Exception Detail: " + e);
		}
	}

	@Test(priority = 140308, groups = {})
	public void scrollGraphLeft8H1HTab() {
		try {
			sessionDetailPage3560.scrollGraph(ScrollDiection.LEFT, 2);
		} catch (Throwable e) {
			Assert.fail("Exception Detail: " + e);
		}
	}

	@Test(priority = 140350, dataProvider = "switchToOtherTabTestDataProd", dataProviderClass = FCCM3560.class, groups = {})
	public void measurementUnitTimeValueInDifferentTabsTestProd(String tabName) {
		try {
			if (sensorCount > 1) {
				sessionDetailPage3560.scrollUp(Config.IOS_LOCATOR_STRATEGY_NAME, "Sensors", 300, 45);
			}
			sessionDetailPage3560.switchToOtherTab(tabName, ScrollDiection.UP);
			for (iterationValue = 0; iterationValue < sensorCount; iterationValue++) {
				valueList = sessionDetailPage3560.getMaxMinLiveValueList();
				valueTimeList = sessionDetailPage3560.getMaxMinLiveValueTimeList();
			}
			for (String value : valueList) {
				value = value.substring(0, value.indexOf(' '));
				assertTrue(CommonUtils.getDoubleValue(value) > 0.000 && CommonUtils.getDoubleValue(value) < 3.001);
			}
			for (String value : valueList) {
				Assert.assertTrue(value.contains("g") || value.contains(".com"));
			}
			for (String timeValue : valueTimeList) {
				Assert.assertTrue(timeValue.contains(":"));
			}
		} catch (Throwable e) {
			Assert.fail("Live value or Unit or Time is coming as stale or too high for sensor " + iterationValue
					+ ", exception details are: " + e);
		}
	}
	
    //BUG_AUTOMATION

	// ANDROID_BUGS
	// FCCM3560-1834
	@Test(priority = 141105, groups = { FCCM3560.ANDROID_BUGS })
	public void deleteButtonIsDisabled() throws Exception {
		Assert.assertFalse(sessionDetailPage.deleteButtonIsDisabled());
	}

	@AfterClass(alwaysRun = true, groups = {FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3560.COMPLETED_SESSION_DETAIL_PAGE_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS})
	public void tearDown() throws Exception {
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
