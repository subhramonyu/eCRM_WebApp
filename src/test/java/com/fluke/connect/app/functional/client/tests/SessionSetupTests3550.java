package com.fluke.connect.app.functional.client.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fluke.connect.app.functional.client.pages.SessionSetupPage3550;
import com.fluke.connect.app.testdata.FCCM3550;
import com.fluke.connect.app.testdata.FCCM.AlarmType;
import com.fluke.connect.app.testdata.FCCM.FCCMProductName;
import com.fluke.connect.app.testdata.FCCM.MeasurementUnit;
import com.fluke.connect.app.utils.Config.ScrollDiection;

public class SessionSetupTests3550 
{
	private SessionSetupPage3550 sessionSetupPage3550;
	
	@BeforeClass(groups = {FCCM3550.SESSION_SETUP_TESTS})
	public void init()
	{
		sessionSetupPage3550 = new SessionSetupPage3550();
	}
	
	@Test(priority = 125001, groups = {FCCM3550.SESSION_SETUP_TESTS})
	public void selectProductTest() 
	{
		try
		{
			sessionSetupPage3550.configureAsset(FCCM3550.assetGroupName, FCCM3550.assetName, FCCM3550.testPointName, "Normal");
			sessionSetupPage3550.selectFCCMProduct(FCCMProductName.TI_SENSOR, ScrollDiection.DOWN);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	@Parameters({"sensorID"})
	@Test(priority = 125002, groups = {FCCM3550.SESSION_SETUP_TESTS})
	public void sensorSelectionTest(@Optional("no value") String sensorID) 
	{
		try
		{
			if(sensorID.equals("no value"))
				sessionSetupPage3550.selectSensor3550(FCCM3550.sensorID, true, false);
			else
				sessionSetupPage3550.selectSensor3550(sensorID, true, false);
		}
		catch(Throwable e)
		{
			Assert.fail();
		}
	}
	
	@Parameters({"networkName", "networkPassword"})
	@Test(priority = 125003, groups = {FCCM3550.SESSION_SETUP_TESTS})
	public void connectToFCCloudTest(@Optional("no value") String networkName, @Optional("null") String networkPassword) throws Exception 
	{
		if(networkName.equals("no value"))
			sessionSetupPage3550.selectNetwork3550(FCCM3550.networkName, FCCM3550.password);
		else
			sessionSetupPage3550.selectNetwork3550(networkName, networkPassword);
	}
	
	@Test(priority = 125004, groups = {FCCM3550.SESSION_SETUP_TESTS})
	public void configureThermalImagingSensorsTest() throws Exception 
	{
		sessionSetupPage3550.configureThermalImagingSensors(FCCM3550.FIVE_MIN, MeasurementUnit.FAHRENHEIT, false);
	}
	
	@Test(priority = 125005, groups = {FCCM3550.SESSION_SETUP_TESTS})
	public void assignAssetTest() 
	{
		try
		{
			sessionSetupPage3550.assignAsset3550(FCCM3550.assetGroupName, FCCM3550.assetName, FCCM3550.testPointName, 0);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority = 125006, groups = {FCCM3550.SESSION_SETUP_TESTS})
	public void addAboveAlarmTest() 
	{
		sessionSetupPage3550.addAlarm(AlarmType.ABOVE_TEMPERATURE	, "F", 67, 0, ScrollDiection.NEXT);
	}
	
	@Test(priority = 125007, groups = {FCCM3550.SESSION_SETUP_TESTS})
	public void addBelowAlarmTest() 
	{
		sessionSetupPage3550.addAlarm(AlarmType.BELOW_TEMPERATURE	, "F", 0, 120, ScrollDiection.NEXT);
	}
	
	@Test(priority = 125008, groups = {FCCM3550.SESSION_SETUP_TESTS})
	public void addWithinAlarmTest() 
	{
		sessionSetupPage3550.addAlarm(AlarmType.WITHIN_TEMPERATURE, "F", 120, 67, ScrollDiection.NEXT);
	}
	
	@Test(priority = 125009, groups = {FCCM3550.SESSION_SETUP_TESTS})
	public void addOutOfAlarmTest() 
	{
		sessionSetupPage3550.addAlarm(AlarmType.OUTOF_TEMPERATURE	, "F", 300, 200, ScrollDiection.NEXT);
	}
	
	@Test(priority = 125010, groups = {FCCM3550.SESSION_SETUP_TESTS})
	public void startRemoteMonitoringTest() 
	{
		try
		{
			sessionSetupPage3550.startRemoteMonitoring3550();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}

}
