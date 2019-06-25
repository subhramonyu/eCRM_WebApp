package com.fluke.connect.app.functional.client.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fluke.connect.app.functional.client.pages.FCCM174XSessionConfigObjectRepo;
import com.fluke.connect.app.functional.client.pages.FCCM174XSessionConfigurationPage;
import com.fluke.connect.app.functional.client.pages.SettingsPage;
import com.fluke.connect.app.functional.client.pages.Switcher;
import com.fluke.connect.app.testdata.FCCM174X;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.Config.ScrollDiection;

public class FCCM174XSessionConfigurationTests {
	private Switcher switcher;
	private FCCM174XSessionConfigurationPage FCCM174XSessionConfiguration;
	private FCCM174XSessionConfigObjectRepo fCCM174XSessionConfigObjectRepo;
	private GestureUtils gestureUtils;
	private SettingsPage settingsPage;
	public String randomConfigName =null;
	
	@BeforeClass(alwaysRun = true, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	public void initClass() throws Exception
	{
		FCCM174XSessionConfiguration = new FCCM174XSessionConfigurationPage();
		switcher = new Switcher();
		gestureUtils = new GestureUtils();
		switcher.switchToSettingsPage();
		fCCM174XSessionConfigObjectRepo = new FCCM174XSessionConfigObjectRepo();
		settingsPage = new SettingsPage();
		//gestureUtils.mobileScroll("PRIVACY POLICY", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			try {
				settingsPage.openServiceHatch();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fCCM174XSessionConfigObjectRepo.turnOnBlondelToggle();
		}
		
		switcher.switchToHomePage();
	}

	//****************************************************************
	//Manual test case : FCCM-3540-1622
	//This test case will check for Power quality option in the initial pages
	//****************************************************************
	@Parameters({"flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180001, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180001, groups = {"adkhbha"})
	public void verifyBlondelOption(@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc01_Blondel_checkPowerQualityLoggerOption(flukeWIFI));
		}
		catch(Throwable e)
		{
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			Assert.fail("Exception Detail: "+e);
			
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1623
	//This TC will check for connecting Blondel tool
	//****************************************************************
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180002, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180002, groups = {"adkhbha"})
	public void connectingBlondelTool(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc02_Blondel_ConnectingToBlondel(pqTool, ssid174X, flukeWIFI));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
		
	}
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1624
	//This TC will verify the controls present in Logger Authentication page
	//****************************************************************
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180003, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180003, groups = {"adkhbha"})
	public void verifyLoggerAuthenticationPage(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc03_Blondel_verifyLoggerAuthenticationPage(pqTool, ssid174X, flukeWIFI));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
		
	}
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1625
	//This TC will verify Logger Authentication With Saved Credentials
	//****************************************************************
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180004, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180004, groups = {"adkhbha"})
	public void verifyRememberUsernamePassword(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc04_Blondel_verifyLoggerAuthenticationWithSavedCredentials(pqTool, ssid174X, flukeWIFI));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
		
	}
	
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1620
	//This TC will verify Logger Authentication With Wrong Credentials
	//****************************************************************
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180005, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180005, groups = {"adkhbha"})
	public void verifyWrongUsrnameAndPasswordForAuthentication(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc05_Blondel_verifyLoggerAuthenticationWithWrongCredentials(pqTool, ssid174X, flukeWIFI));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
		
	}
	
	
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1319
	//This TC will verify different controls present in session setup page 
	//like RTC, battery info, Recording status, Wifi strength, memory etc
	//****************************************************************
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180006, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180006, groups = {"uidhfi"})
	public void verifySessionSetupPage(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc06_Blondel_verifySessionSetupPage(pqTool, ssid174X, flukeWIFI));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
		
	}

	
	//****************************************************************
	//Manual test case : FCCM-3540-1626
	//This TC will verify ConfigOverview by entering Config name, 
	//Standard, Topology and Study type
	//****************************************************************
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180007, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180007, groups = {"ajhcjad"})
	public void verifyConfigOverview(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc07_Blondel_verifyConfigOverview(pqTool, ssid174X, flukeWIFI));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
		
	}
	
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1352
	//This TC will verify the saved config flow by entering a new config and 
	//checking it in saved configuration flow and deleting it at the end
	//****************************************************************
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180008, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180008, groups = {"sdfouhsdhuf"})
	public void verifySavedConfig(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc08_Blondel_verifySavedConfig(pqTool, ssid174X, flukeWIFI));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
		
	}
	
	
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1355
	//This TC will verify the saved config menu items like Delete, 
	//Save As and Edit
	//****************************************************************
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180009, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180009, groups = {"wkhgdiwe"})
	public void verifySavedConfigMenuOptions(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc09_Blondel_verifySavedConfigMenuOptions(pqTool, ssid174X, flukeWIFI));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
		
	}
	
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1685
	//This TC will verify Editing saved configuration
	//****************************************************************
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180010, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180010, groups = {"sfgr"})
	public void verifyEditSavedConfig(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc10_Blondel_verifyEditSavedConfig(pqTool, ssid174X, flukeWIFI));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
		
	}
	
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1686
	//This TC will verify Save As option for saved configuration
	//****************************************************************
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180011, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180011, groups = {"sfgr"})
	public void verifySaveAsInSavedConfig(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc11_Blondel_verifySaveAsInSavedConfig(pqTool, ssid174X, flukeWIFI));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
		
	}
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1366
	//This TC will verify Editing Config name and Description and check
	//Standard is not editable.
	//****************************************************************
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180012, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180012, groups = {"sfgr"})
	public void verifyEditConfigNameAndDescription(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc12_Blondel_verifyEditConfigNameAndDescriptionForEnergyStudy(pqTool, ssid174X, flukeWIFI));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
		
	}
	
	
	//Update Dec-4 : This TC is working in Android. 
					// In iOS still no changes done in script(There is one issue in iOS: In Config showing only "Topology and Phase Colors" no Study type displayed on tile.
	
	//****************************************************************
	//Manual test case : FCCM-3540-1678
	//This TC will verify Editing Study type, Topology and Phase colour
	//****************************************************************
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180013, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180013, groups = {"sfgr"})
	public void verifyEditStudyTypeTopologyPhaseColour(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc13_Blondel_verifyEditStudyTypeTopologyPhaseColour(pqTool, ssid174X, flukeWIFI));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
		
	}
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1367
	//This TC will verify Editing Nominal Voltage and Frequency
	//****************************************************************
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180014, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180014, groups = {"sfgr"})
	public void verifyNominalVoltageAndFrequency(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc14_Blondel_verifyNominalVoltageAndFrequency(pqTool, ssid174X, flukeWIFI,randomConfigName));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
		
	}
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1368
	//This TC will verify Ranges and Scaling
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180015, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180015, groups = {"sfgrdfg"})
	public void verifyRangesAndScaling(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc15_Blondel_verifyRangesAndScaling(pqTool, ssid174X, flukeWIFI,randomConfigName));

		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1683
	//This TC will verify Editing Main Signaling voltages
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180016, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180016, groups = {"sfgrdfg"})
	public void verifyMainSignalingVoltage(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc16_Blondel_verifyMainSignalingVoltage(pqTool, ssid174X, flukeWIFI));

		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1684
	//This TC will verify Editing Harmonics Measurement Mode
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180017, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180017, groups = {"sfgrdfg"})
	public void verifyHarmonicMeasurementMode(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc17_Blondel_verifyHarmonicMeasurementMode(pqTool, ssid174X, flukeWIFI));

		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1687
	//This TC will verify Editing Flicker-Lamp model
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180018, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180018, groups = {"sfgrdfg"})
	public void verifyFlickerLampModel(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc18_Blondel_verifyFlickerLampModel(pqTool, ssid174X, flukeWIFI));

		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1792
	//This TC will verify Editing Events Triggers And Limits(Dip Event)
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180019, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180019, groups = {"sfgrdfg"})
	public void verifyEditEventTriggerAndLimitsForDipEvent(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc19_Blondel_verifyEditEventTriggerAndLimitsForDipEvent(pqTool, ssid174X, flukeWIFI));

		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1793
	//This TC will verify Editing Events Triggers And Limits(Swell Event)
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180020, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180020, groups = {"sfgrdfg"})
	public void verifyEditEventTriggerAndLimitsForSwellEvent(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc20_Blondel_verifyEditEventTriggerAndLimitsForSwellEvent(pqTool, ssid174X, flukeWIFI));

		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	//****************************************************************
	//Manual test case : FCCM-3540-1794
	//This TC will verify Editing Events Triggers And Limits(Interruption Event)
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180021, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180021, groups = {"sfgrdfg"})
	public void verifyEditEventTriggerAndLimitsForInterruptionEvent(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc21_Blondel_verifyEditEventTriggerAndLimitsForInterruptionEvent(pqTool, ssid174X, flukeWIFI));

		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1795
	//This TC will verify Editing Events Triggers And Limits
	//(Rapid voltage Changes Event)
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180022, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180022, groups = {"sfgrdfg"})
	public void verifyEditEventTriggerAndLimitsForRapidVoltageChangesEvent(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc22_Blondel_verifyEditEventTriggerAndLimitsForRapidVoltageChangesEvent(pqTool, ssid174X, flukeWIFI));

		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1796
	//This TC will verify Editing Events Triggers And Limits
	//(Mains Signalling Event)
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180023, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180023, groups = {"sfgrdfg"})
	public void verifyEditEventTriggerAndLimitsForMainsSignallingEvent(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc23_Blondel_verifyEditEventTriggerAndLimitsForMainsSignallingEvent(pqTool, ssid174X, flukeWIFI));

		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM3540-1797
	//This TC will verify Editing Events Triggers And Limits
	//(Waveform deviation Event)
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180024, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180024, groups = {"sfgrdfg"})
	public void verifyEditEventTriggerAndLimitsForWaveformDeviationEvent(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc24_Blondel_verifyEditEventTriggerAndLimitsForWaveformDeviationEvent(pqTool, ssid174X, flukeWIFI));

		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM3540-1798
	//This TC will verify Editing Events Triggers And Limits
	//(Inrush current Event)
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180025, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180025, groups = {"sfgrdfg"})
	public void verifyEditEventTriggerAndLimitsForInrushCurrentEvent(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc25_Blondel_verifyEditEventTriggerAndLimitsForInrushCurrentEvent(pqTool, ssid174X, flukeWIFI));

		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM3540-1688
	//This TC will verify Editing Intervals(Trend. Demand)
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180026, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180026, groups = {"sfgrdfg"})
	public void verifyEditingIntervals(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc26_Blondel_verifyEditingIntervals(pqTool, ssid174X, flukeWIFI,randomConfigName));

		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1357
	//This TC will verify Configuration Name and Description for 
	//Energy Study
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180027, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180027, groups = {"sfgrdfg"})
	public void verifyConfigNameAndDescriptionForEnergyStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc27_Blondel_verifyConfigNameAndDescriptionForEnergyStudy(pqTool, ssid174X, flukeWIFI));

		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM3540-1358
	//This TC will verify Topology and Phase color for Energy Study
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180028, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180028, groups = {"sfgrdfg"})
	public void verifyTopologyAndPhaseColorForEnergyStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc28_Blondel_verifyTopologyAndPhaseColorForEnergyStudy(pqTool, ssid174X, flukeWIFI));

		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM3540-1360
	//This TC will verify Nominal Voltage and Frequency for Energy study 
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180029, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180029, groups = {"sfgrdfg"})
	public void verifyNominalVoltageAndFrequencyForEnergyStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		randomConfigName = "29TC_"+fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc29_Blondel_verifyNominalVoltageAndFrequencyForEnergyStudy(pqTool, ssid174X, flukeWIFI,randomConfigName));

		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM3540-1716
	//This TC will verify Ranges and scaling for Energy study 
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180030, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180030, groups = {"sfgrdfg"})
	public void verifyRangesAndScalingForEnergyStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc30_Blondel_verifyRangesAndScalingForEnergyStudy(pqTool, ssid174X, flukeWIFI));

		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM3540-1362
	//This TC will verify Main Signaling Voltage for Energy study 
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180031, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180031, groups = {"sfgrdfg"})
	public void verifyMainSignalingVoltageForEnergyStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc31_Blondel_verifyMainSignalingVoltageForEnergyStudy(pqTool, ssid174X, flukeWIFI));

		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM3540-1363
	//This TC will verify Harmonics Measurement Mode for Energy study 
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180032, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180032, groups = {"sfgrdfg"})
	public void verifyHamonicMeasurementModeForEnergyStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc32_Blondel_verifyHamonicMeasurementModeForEnergyStudy(pqTool, ssid174X, flukeWIFI));

		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM3540-1369
	//This TC will verify Flicker lamp model for Energy study 
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180033, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180033, groups = {"sfgrdfg"})
	public void verifyFlickerLampModelForEnergyStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc33_Blondel_verifyFlickerLampModelForEnergyStudy(pqTool, ssid174X, flukeWIFI));

		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	
	//****************************************************************
	//Manual test case : FCCM3540-1411
	//This TC will verify Events Triggers And Limits(Dip Event)
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180034, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180034, groups = {"sfgrdfg"})
	public void verifyEventTriggerAndLimitsForDipEvent(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc34_Blondel_verifyEventTriggerAndLimitsForDipEvent(pqTool, ssid174X, flukeWIFI));

		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM3540-1412
	//This TC will verify Events Triggers And Limits(Swell Event)
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180035, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180035, groups = {"sfgrdfg"})
	public void verifyEventTriggerAndLimitsForSwellEvent(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc35_Blondel_verifyEventTriggerAndLimitsForSwellEvent(pqTool, ssid174X, flukeWIFI));

		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	//****************************************************************
	//Manual test case : FCCM3540-1413
	//This TC will verify Events Triggers And Limits(Interruption Event)
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180036, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180036, groups = {"sfgrdfg"})
	public void verifyEventTriggerAndLimitsForInterruptionEvent(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc36_Blondel_verifyEventTriggerAndLimitsForInterruptionEvent(pqTool, ssid174X, flukeWIFI));

		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	
	//****************************************************************
	//Manual test case : FCCM3540-1414
	//This TC will verify Events Triggers And Limits
	//(Rapid voltage Changes Event)
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180037, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180037, groups = {"sfgrdfg"})
	public void verifyEventTriggerAndLimitsForRapidVoltageChangesEvent(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc37_Blondel_verifyEventTriggerAndLimitsForRapidVoltageChangesEvent(pqTool, ssid174X, flukeWIFI));

		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM3540-1415
	//This TC will verify Events Triggers And Limits
	//(Mains Signalling Event)
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180038, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180038, groups = {"sfgrdfg"})
	public void verifyEventTriggerAndLimitsForMainsSignallingEvent(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc38_Blondel_verifyEventTriggerAndLimitsForMainsSignallingEvent(pqTool, ssid174X, flukeWIFI));

		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM3540-1416
	//This TC will verify Events Triggers And Limits
	//(Waveform deviation Event)
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180039, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180039, groups = {"sfgrdfg"})
	public void verifyEventTriggerAndLimitsForWaveformDeviationEvent(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc39_Blondel_verifyEventTriggerAndLimitsForWaveformDeviationEvent(pqTool, ssid174X, flukeWIFI));

		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM3540-1417
	//This TC will verify Events Triggers And Limits
	//(Inrush current Event)
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180040, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180040, groups = {"sfgrdfg"})
	public void verifyEventTriggerAndLimitsForInrushCurrentEvent(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc40_Blondel_verifyEventTriggerAndLimitsForInrushCurrentEvent(pqTool, ssid174X, flukeWIFI));

		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}

	
	
	
	
	
	
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1373
	//This TC will verify Intervals for Energy study 
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180041, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180041, groups = {"sfgrdfg"})
	public void verifyIntervalsForEnergyStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc41_Blondel_verifyIntervalsForEnergyStudy(pqTool, ssid174X, flukeWIFI, randomConfigName));

		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1717
	//This TC will verify Configuration Name and Description for 
	//load Study
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180042, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180042, groups = {"sfgrdfg"})
	public void verifyConfigNameAndDescriptionForLoadStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc42_Blondel_verifyConfigNameAndDescriptionForLoadStudy(pqTool, ssid174X, flukeWIFI));

		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1718
	//This TC will verify Standard for Load study and it is not editable
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	@Test(alwaysRun = true, priority = 180043, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180043, groups = {"sfgrdfg"})
	public void verifyStandardForLoadStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		randomConfigName = "43TC_"+fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc43_Blondel_verifyStandardForLoadStudy(pqTool, ssid174X, flukeWIFI, randomConfigName));

		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1364
	//This TC will verify Topology and Phase color for Load study
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180044, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180044, groups = {"sfgrdfg"})
	public void verifyTopologyAndPhaseColorForLoadStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc44_Blondel_verifyTopologyAndPhaseColorForLoadStudy(pqTool, ssid174X, flukeWIFI));

		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1719
	//This TC will verify Nominal Voltage and Frequency for Load study
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	@Test(alwaysRun = true, priority = 180045, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180045, groups = {"sfgrdfg"})
	public void verifyNominalVoltageAndFrequencyForLoadStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc45_Blondel_verifyNominalVoltageAndFrequencyForLoadStudy(pqTool, ssid174X, flukeWIFI));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	//Defect : App is crashing when user stay on the Ranges and Scaling page for few seconds 
	//****************************************************************
	//Manual test case : FCCM-3540-1725
	//This TC will verify Ranges and scaling for Load study
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	@Test(alwaysRun = true, priority = 180046, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180046, groups = {"sfgrdfg"})
	public void verifyRangesAndScalingForLoadStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc46_Blondel_verifyRangesAndScalingForLoadStudy(pqTool, ssid174X, flukeWIFI));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1721
	//This TC will verify Main Signaling voltages for Load study
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	@Test(alwaysRun = true, priority = 180047, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180047, groups = {"sfgrdfg"})
	public void verifyMainSignalingVoltagesForLoadStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc47_Blondel_verifyMainSignalingVoltagesForLoadStudy(pqTool, ssid174X, flukeWIFI));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1726
	//This TC will verify Harmonics Measurement Mode for Load study
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	@Test(alwaysRun = true, priority = 180048, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180048, groups = {"sfgrdfg"})
	public void verifyHarmonicsMeasurementModeForLoadStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc48_Blondel_verifyHarmonicsMeasurementModeForLoadStudy(pqTool, ssid174X, flukeWIFI));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1722
	//This TC will verify Flicker Lamp Model for Load study
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	@Test(alwaysRun = true, priority = 180049, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180049, groups = {"sfgrdfg"})
	public void verifyFlickerLampModelForLoadStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc49_Blondel_verifyFlickerLampModelForLoadStudy(pqTool, ssid174X, flukeWIFI));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1724
	//This TC will verify Event Triggers And limits for Load study
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	@Test(alwaysRun = true, priority = 180050, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180050, groups = {"sfgrdfg"})
	public void verifyEventTriggersAndLimitsForLoadStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc50_Blondel_verifyEventTriggersAndLimitsForLoadStudy(pqTool, ssid174X, flukeWIFI));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1723
	//This TC will verify Intervals for Load study
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	@Test(alwaysRun = true, priority = 180051, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180051, groups = {"sfgrdfg"})
	public void verifyIntervalsForLoadStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc51_Blondel_verifyIntervalsForLoadStudy(pqTool, ssid174X, flukeWIFI, randomConfigName));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1742
	//This TC will verify editing Config name and description for
	//Load study
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180052, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180052, groups = {"sfgrdfg"})
	public void verifyEditConfigNameAndDescriptionForLoadStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc52_Blondel_verifyEditConfigNameAndDescriptionForLoadStudy(pqTool, ssid174X, flukeWIFI));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1894
	//This TC will verify editing Study Type for Load study
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180053, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180053, groups = {"sfgrdfg"})
	public void verifyEditStudyTypeForLoadStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc53_Blondel_verifyEditStudyTypeForLoadStudy(pqTool, ssid174X, flukeWIFI));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1743
	//This TC will verify editing Study Type, Topology and Phase Color 
	//for Load study
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180054, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180054, groups = {"sfgrdfg"})
	public void verifyEditStudyTypeTopologyPhaseColorForLoadStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc54_Blondel_verifyEditStudyTypeTopologyPhaseColorForLoadStudy(pqTool, ssid174X, flukeWIFI));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	

	//****************************************************************
	//Manual test case : FCCM-3540-1744
	//This TC will verify editing Nominal voltage and frequency 
	//for Load study
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180055, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180055, groups = {"sfgrdfg"})
	public void verifyEditNominalVoltageAndFrequencyForLoadStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc55_Blondel_verifyEditNominalVoltageAndFrequencyForLoadStudy(pqTool, ssid174X, flukeWIFI));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//Defect : App is crashing when user stay on the Ranges and Scaling page for few seconds
	//****************************************************************
	//Manual test case : FCCM-3540-1908
	//This TC will verify editing Edit Ranges and scaling 
	//for Load study
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180056, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180056, groups = {"sfgrdfg"})
	public void verifyEditRangesAndScalingForLoadStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc56_Blondel_verifyEditRangesAndScalingForLoadStudy(pqTool, ssid174X, flukeWIFI));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1745
	//This TC will verify editing Main Signalling Voltage
	//for Load study
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180057, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180057, groups = {"sfgrdfg"})
	public void verifyEditMainSignallingVoltageForLoadStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc57_Blondel_verifyEditMainSignallingVoltageForLoadStudy(pqTool, ssid174X, flukeWIFI));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1746
	//This TC will verify editing Harmonics Measurement Mode
	//for Load study
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180058, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180058, groups = {"sfgrdfg"})
	public void verifyEditHarmonicsMeasurementModeForLoadStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc58_Blondel_verifyEditHarmonicsMeasurementModeForLoadStudy(pqTool, ssid174X, flukeWIFI));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1747
	//This TC will verify editing Flicker Lamp Model
	//for Load study
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180059, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	@Test(alwaysRun = true, priority = 180059, groups = {"sfgrdfg"})
	public void verifyEditFlickerLampModelForLoadStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc59_Blondel_verifyEditFlickerLampModelForLoadStudy(pqTool, ssid174X, flukeWIFI));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1909
	//This TC will verify editing Events Triggers And Limits
	//for Load study
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180060, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180060, groups = {"sfgrdfg"})
	public void verifyEditEventsTriggersAndLimitsForLoadStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc60_Blondel_verifyEditEventsTriggersAndLimitsForLoadStudy(pqTool, ssid174X, flukeWIFI));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	
	//****************************************************************
	//Manual test case : FCCM-3540-1748
	//This TC will verify editing Intervals
	//for Load study
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180061, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180061, groups = {"sfgrdfg"})
	public void verifyEditIntervalsForLoadStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc61_Blondel_verifyEditIntervalsForLoadStudy(pqTool, ssid174X, flukeWIFI));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	//****************************************************************
	//Manual test case : FCCM-3540-1689
	//This TC will verify editing Config name and description
	//for EN50160
	//****************************************************************

	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 180062, groups = {FCCM174X.SESSION_CONFIG_TESTS})
	//@Test(alwaysRun = true, priority = 180062, groups = {"sfgrdfg"})
	public void verifyEditConfigNameAndDescriptionForEN50160(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(FCCM174XSessionConfiguration.tc62_Blondel_verifyEditConfigNameAndDescriptionForEN50160(pqTool, ssid174X, flukeWIFI));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}	
	
}
