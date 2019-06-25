package com.fluke.connect.app.functional.client.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fluke.connect.app.functional.client.pages.AlarmPage;
import com.fluke.connect.app.functional.client.pages.AlarmPage.AlarmPageObjectList;
import com.fluke.connect.app.functional.client.pages.SessionDetailPage.SessionDetailPageObjectList;
import com.fluke.connect.app.functional.client.pages.SessionSetup3560;
import com.fluke.connect.app.testdata.FCCM3560;
import com.fluke.connect.app.testdata.FCCM.AlarmType;
import com.fluke.connect.app.testdata.FCCM.FCCMProductName;
import com.fluke.connect.app.utils.Config.ScrollDiection;

public class SessionSetupTests3560 
{
	private SessionSetup3560 sessionSetup3560;
	private AlarmPage alarmPage;
	
	@BeforeClass(alwaysRun = true, groups = {FCCM3560.SESSION_SETUP_TESTS,  FCCM3560.SESSION_CONFIG_TESTS})
	public void initClass() throws Exception
	{
		sessionSetup3560 = new SessionSetup3560();
		sessionSetup3560.selectFCCMProduct(FCCMProductName.VIBRATION_SENSOR, ScrollDiection.DOWN);
		alarmPage = new AlarmPage();
	}
	
	@Parameters({"gatewayName", "networkName"})
	@Test(alwaysRun = true, priority = 136001, groups = {FCCM3560.SESSION_SETUP_TESTS,  FCCM3560.SESSION_CONFIG_TESTS})
	public void gatewayProvisionTest(@Optional("no value") String gatewayName, @Optional("no value") String networkName) throws Exception
	{
		if(gatewayName.equals("no value"))
			Assert.assertTrue(sessionSetup3560.isGatewayProvisioned(FCCM3560.gatewayNameValue, FCCM3560.networkName, ScrollDiection.DOWN));
		else
			Assert.assertTrue(sessionSetup3560.isGatewayProvisioned(gatewayName, networkName, ScrollDiection.DOWN));
	}
	
	@Parameters({"sensorName"})
	@Test(priority = 136002, groups = {FCCM3560.SESSION_SETUP_TESTS, FCCM3560.SESSION_CONFIG_TESTS}, dependsOnMethods = {"gatewayProvisionTest"})
	public void sensorProvisionTest(@Optional("no value") String sensorName) throws Exception
	{
		if(sensorName.equals("no value"))
				Assert.assertTrue(sessionSetup3560.isSensorProvisioned(FCCM3560.sensorNameList, ScrollDiection.DOWN));
			else
			{
				String[] sensorList = sensorName.split(",");
				Assert.assertTrue(sessionSetup3560.isSensorProvisioned(sensorList, ScrollDiection.DOWN));
			}
	}
	
	@Test(priority = 136003, groups = {FCCM3560.SESSION_SETUP_TESTS,  FCCM3560.SESSION_CONFIG_TESTS}, dependsOnMethods = {"sensorProvisionTest"})
	public void assignAssetTest() throws Exception
	{
		Assert.assertTrue(sessionSetup3560.isAssetAssigned(FCCM3560.assetGroupName, FCCM3560.assetName, FCCM3560.testPointName, 0));
	}
	
	@Test(priority = 136004, groups = {FCCM3560.SESSION_SETUP_TESTS,  FCCM3560.SESSION_CONFIG_TESTS}, dependsOnMethods = {"sensorProvisionTest"})
	public void selectMeasurementUnitTest() throws Exception
	{
		sessionSetup3560.selectMeasurementUnit(FCCM3560.vibrationUnit1InValue, FCCM3560.tempratureUnit);
	}
	
	@Test(priority = 136005, groups = {FCCM3560.SESSION_SETUP_TESTS,  FCCM3560.SESSION_CONFIG_TESTS}, dependsOnMethods = {"sensorProvisionTest"})
	public void selectAlarmTypeTest() throws Exception
	{
		sessionSetup3560.selectAlarmType(AlarmType.CUSTOM_VIBRATION_ALARM);
	}
	
	@Parameters({"machineCategoryName"})
	@Test(priority = 136006, groups = {FCCM3560.SESSION_SETUP_TESTS, FCCM3560.SESSION_CONFIG_TESTS}, dependsOnMethods = {"sensorProvisionTest"})
	public void assignMachineCategoryTest(@Optional("no value") String machineCategoryName)
	{
		try
		{
			if(machineCategoryName.equals("no value"))
				sessionSetup3560.assignMachineCategory(FCCM3560.machineCategoryName);
			else
				sessionSetup3560.assignMachineCategory(machineCategoryName);
		}
		catch(Throwable e)
		{
			Assert.fail("Unable to assign asset, exception details are: "+e);
		}
	}
	
	@Test(priority = 136007, groups = {FCCM3560.SESSION_SETUP_TESTS,  FCCM3560.SESSION_CONFIG_TESTS}, dependsOnMethods = {"sensorProvisionTest"})
	public void deleteExistingAlarmsTest() throws Exception
	{
		alarmPage.deleteAllAlarms(15);
	}
	
	@Test(priority = 136008, groups = {FCCM3560.SESSION_SETUP_TESTS,  FCCM3560.SESSION_CONFIG_TESTS}, dependsOnMethods = {"sensorProvisionTest"})
	public void addVibrationAlarmTest() throws Exception
	{
		/*
		alarmPage.getElementAlarmPage(AlarmPageObjectList.ADD_VIBRATION_ALARM).click();
		alarmPage.addAlarm(AlarmType.ABOVE_VIBRATION, FCCM3560.aboveVibrationUnit, Double.parseDouble(FCCM3560.aboveVibrationThresholdValue), Double.parseDouble(FCCM3560.aboveVibrationThresholdValue), ScrollDiection.NEXT, 0);
		alarmPage.getElementAlarmPage(AlarmPageObjectList.ADD_VIBRATION_ALARM).click();
		alarmPage.addAlarm(AlarmType.BELOW_VIBRATION, FCCM3560.belowVibrationUnit, Double.parseDouble(FCCM3560.belowVibrationThresholdValue), Double.parseDouble(FCCM3560.belowVibrationThresholdValue), ScrollDiection.NEXT, 1);
		alarmPage.getElementAlarmPage(AlarmPageObjectList.ADD_VIBRATION_ALARM).click();
		alarmPage.addAlarm(AlarmType.WITHIN_VIBRATION, FCCM3560.withinVibrationUnit, Double.parseDouble(FCCM3560.withinVibrationUpperThresholdValue), Double.parseDouble(FCCM3560.withinVibrationLowerThresholdValue), ScrollDiection.NEXT, 2);
		alarmPage.getElementAlarmPage(AlarmPageObjectList.ADD_VIBRATION_ALARM).click();
		alarmPage.addAlarm(AlarmType.OUTOF_VIBRATION, FCCM3560.outofVibrationUnit, Double.parseDouble(FCCM3560.outofVibrationUpperThresholdValue), Double.parseDouble(FCCM3560.outofVibrationLowerThresholdValue), ScrollDiection.NEXT, 2);
	*/
	}
	
	@Test(priority = 136009, groups = {FCCM3560.SESSION_SETUP_TESTS,  FCCM3560.SESSION_CONFIG_TESTS}, dependsOnMethods = {"sensorProvisionTest"})
	public void addTempratureAlarmTest() throws Exception
	{
		/*
		alarmPage.getElementAlarmPage(AlarmPageObjectList.ADD_TEMPRATURE_ALARM).click();
		alarmPage.addAlarm(AlarmType.ABOVE_TEMPERATURE, FCCM3560.aboveTempratureUnit, Double.parseDouble(FCCM3560.aboveTempratureThresholdValue), Double.parseDouble(FCCM3560.aboveTempratureThresholdValue), ScrollDiection.NEXT, 0);
		alarmPage.getElementAlarmPage(AlarmPageObjectList.ADD_TEMPRATURE_ALARM).click();
		alarmPage.addAlarm(AlarmType.BELOW_TEMPERATURE, FCCM3560.belowTempratureUnit, Double.parseDouble(FCCM3560.belowTempratureThresholdValue), Double.parseDouble(FCCM3560.belowTempratureThresholdValue), ScrollDiection.NEXT, 1);
	*/
	}
	
	@Test(priority = 136010, groups = {FCCM3560.SESSION_SETUP_TESTS, FCCM3560.SESSION_CONFIG_TESTS}, dependsOnMethods = {"assignMachineCategoryTest"})
	public void startMonitoringTest()
	{
		try
		{
			Assert.assertTrue(sessionSetup3560.isMonitoringStarted());
		}
		catch(Throwable e)
		{
			Assert.fail("Unable to start monitoring, exception details are: "+e);
		}
	}
	// BUG_AUTOMATION

	// ANDROID_BUGS
	// FCCM3560-339
	
	@Test(priority = 141106, groups = {FCCM3560.ANDROID_BUGS})
	public void verifyTextInWiFiSelectionScreen() throws Exception {
		sessionSetup3560.selectGateway(FCCM3560.gatewayNameForProvisioning, ScrollDiection.DOWN);
		Assert.assertTrue(sessionSetup3560.getTextInWiFiSelectionScreen());
	}
	
	//FCCM3560-2818
	@Test(priority = 141107, groups = {FCCM3560.ANDROID_BUGS})
	public void appCrashInLastStageOfProvisioningGateway() throws Exception {
		Assert.assertTrue(sessionSetup3560.isGatewayProvisioned(FCCM3560.gatewayNameForProvisioning,FCCM3560.networkName, ScrollDiection.DOWN));
	}
	
	// FCCM3560-412
	@Test(priority = 141108, groups = { FCCM3560.ANDROID_BUGS })
	public void networkErrorBeforeGatewayList() throws Exception {
		Assert.assertFalse(sessionSetup3560.isNetworkErrorDisplayed());
	}

	// FCCM3560-222
	@Test(priority = 141109, groups = { FCCM3560.ANDROID_BUGS })
	public void verifySensorText() throws Exception {
		sessionSetup3560.selectGateway(FCCM3560.gatewayNameForProvisioning, ScrollDiection.DOWN);
		sessionSetup3560.selectNetwork(FCCM3560.networkName, ScrollDiection.DOWN);
		Assert.assertTrue(sessionSetup3560.getSensorText());
	}
	
	// FCCM3560- 414
	@Test(priority = 141112, groups = { FCCM3560.ANDROID_BUGS })
	public void networkErrorAfterSelectingGateway() throws Exception {
		sessionSetup3560.selectGateway(FCCM3560.gatewayNameForProvisioning, ScrollDiection.DOWN);
		Assert.assertFalse(sessionSetup3560.isNetworkErrorDisplayedAfterSelectingGateway());
	}
	
	// FCCM3560- 430
	@Test(priority = 141113, groups = { FCCM3560.ANDROID_BUGS })
	public void gatewayProvisionedError() throws Exception {
		sessionSetup3560.selectGateway(FCCM3560.gatewayAlreadyProvisoned, ScrollDiection.DOWN);
		Assert.assertTrue(sessionSetup3560.verifyGatewayProvisionedError());
	}
	
	// FCCM3560-1120
	@Test(priority = 141114, groups = { FCCM3560.ANDROID_BUGS })
	public void sensorProvisionedError() throws Exception {
		sessionSetup3560.selectGateway(FCCM3560.gatewayNameForProvisioning, ScrollDiection.DOWN);
		sessionSetup3560.selectNetwork(FCCM3560.networkName, ScrollDiection.DOWN);
		Assert.assertTrue(sessionSetup3560.verifySensorProvisionedError());
	}
	
	//FCCM3560-3272
	@Test(priority = 141116, groups = { FCCM3560.ANDROID_BUGS })
	public void appCrashOnTappingOnremoveSensors() throws Exception {
		sessionSetup3560.provisionGatewayAndSensor();
		Assert.assertTrue(sessionSetup3560.tapOnRemoveSensors());
	}
	
	// FCCM3560-3198
	@Test(priority = 141117, groups = { FCCM3560.ANDROID_BUGS })
	public void sensorStatusFluctuating() throws Exception {
		sessionSetup3560.provisionGatewayAndSensor();
		sessionSetup3560.tapOnInstallSensor();
		Assert.assertTrue(sessionSetup3560.checkSensorStatusInVerifyInstallationAndSensorInstallationDetailsScreen());
	}

	// FCCM3560-3189
	@Test(priority = 141118, groups = { FCCM3560.ANDROID_BUGS })
	public void appCrashOnRemovingSensorsInFixConnection() throws Exception {
		sessionSetup3560.provisionGatewayAndSensor();
		sessionSetup3560.tapOnInstallSensor();
		sessionSetup3560.clickOnInstallationDetails();
		Assert.assertTrue(sessionSetup3560.tapOnRemoveSensorsInFixConnection());
	}
	
	
	
}
