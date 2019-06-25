package com.fluke.connect.app.functional.client.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fluke.connect.app.functional.client.pages.FCCM174XApiCheckPage;
import com.fluke.connect.app.functional.client.pages.FCCM174XSessionConfigObjectRepo;
import com.fluke.connect.app.functional.client.pages.FCCM174XSessionConfigurationPage;
import com.fluke.connect.app.functional.client.pages.SettingsPage;
import com.fluke.connect.app.functional.client.pages.Switcher;
import com.fluke.connect.app.testdata.FCCM174X;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.GestureUtils;

public class FCCM174XApiCheckTests {
	private Switcher switcher;
	private FCCM174XSessionConfigurationPage FCCM174XSessionConfiguration;
	private FCCM174XSessionConfigObjectRepo fCCM174XSessionConfigObjectRepo;
	private FCCM174XApiCheckPage fCCM174XApiCheck;
	private GestureUtils gestureUtils;
	private SettingsPage settingsPage;
	@BeforeClass(alwaysRun = true, groups = {FCCM174X.FCCM174X_API_TESTS})
	public void initClass() throws Exception
	{
		FCCM174XSessionConfiguration = new FCCM174XSessionConfigurationPage();
		fCCM174XApiCheck = new FCCM174XApiCheckPage();
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
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	@Test(alwaysRun = true, priority = 185001, groups = {FCCM174X.FCCM174X_API_TESTS})
	public void verifySessionConfigAPIs(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(fCCM174XApiCheck.tc_Api01_Blondel_checkPowerQualityLoggerOption(pqTool, ssid174X, flukeWIFI));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}

}
