package com.fluke.connect.app.functional.client.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fluke.connect.app.functional.client.pages.FCCM174XInstallCommisioningSessionsPage;
import com.fluke.connect.app.functional.client.pages.FCCM174XSessionConfigObjectRepo;
import com.fluke.connect.app.functional.client.pages.FCCM174XSessionConfigurationPage;
import com.fluke.connect.app.functional.client.pages.SettingsPage;
import com.fluke.connect.app.functional.client.pages.Switcher;
import com.fluke.connect.app.testdata.FCCM174X;
import com.fluke.connect.app.testdata.SignIn;
import com.fluke.connect.app.testdata.SignIn.FeatureList;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.ScrollDiection;

public class FCCM174XInstallCommisioningSessionsTests {
	private Switcher switcher;
	private FCCM174XSessionConfigurationPage FCCM174XSessionConfiguration;
	private FCCM174XSessionConfigObjectRepo fCCM174XSessionConfigObjectRepo;
	private FCCM174XInstallCommisioningSessionsPage fCCM174XInstallCommisioningSessionsPage;
	private GestureUtils gestureUtils;
	private SettingsPage settingsPage;
	public String randomConfigName =null;
	
	@BeforeClass(alwaysRun = true, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void initClass() throws Exception
	{
		if(!DriverManager.isSmokeSuite()) {
			DriverManager.getSignIn().signIn(SignIn.getUID(FeatureList.FCCM174X), SignIn.getPWD(FeatureList.FCCM174X));
	        DriverManager.getSignIn().handleAfterSignInAlertsOtherUser();
		}
		FCCM174XSessionConfiguration = new FCCM174XSessionConfigurationPage();
		switcher = new Switcher();
		gestureUtils = new GestureUtils();
		switcher.switchToSettingsPage();
		fCCM174XSessionConfigObjectRepo = new FCCM174XSessionConfigObjectRepo();
		settingsPage = new SettingsPage();
		fCCM174XInstallCommisioningSessionsPage = new FCCM174XInstallCommisioningSessionsPage();
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
	//@Test(alwaysRun = true, priority = 185101, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyInstallAndVerifyTab(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
		try
		{
			Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc01_Blondel_verifyInstallAndVerifyTab(pqTool, ssid174X, flukeWIFI,randomConfigName));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185102, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyLoggerNameInInstallAndVerify(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		String loggerName = pqTool+"<"+ssid174X+">";
		try
		{
			Boolean LoggerNameDisplay = ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, loggerName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, loggerName, LocatorStrategy.NONE, null);
			CommonUtils.wait(1);
			Assert.assertTrue(LoggerNameDisplay);
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185103, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyConfigNameInInstallAndVerify(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Boolean LoggerNameDisplay = ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, randomConfigName, LocatorStrategy.NONE, null);
			CommonUtils.wait(1);
			Assert.assertTrue(LoggerNameDisplay);
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185104, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyStudyTypeInInstallAndVerify(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Boolean LoggerNameDisplay = ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Energy Study", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Energy Study", LocatorStrategy.NONE, null);
			CommonUtils.wait(1);
			Assert.assertTrue(LoggerNameDisplay);
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185105, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyTopologyInInstallAndVerify(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Boolean LoggerNameDisplay = ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Wye", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Wye It", LocatorStrategy.NONE, null);
			CommonUtils.wait(1);
			Assert.assertTrue(LoggerNameDisplay);
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185106, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyLoadCurrentFlowInInstallAndVerify(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc_Blondel_verifyLoadCurrentFlowInInstallAndVerify(pqTool, ssid174X, flukeWIFI,randomConfigName));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185107, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyGeneratorCurrentFlowInInstallAndVerify(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc_Blondel_verifyGeneratorCurrentFlowInInstallAndVerify(pqTool, ssid174X, flukeWIFI,randomConfigName));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185108, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyVoltagePhaseMapInInstallAndVerify(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc_Blondel_verifyVoltagePhaseMapInInstallAndVerify(pqTool, ssid174X, flukeWIFI,randomConfigName));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185109, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyCurrentPhaseMapInInstallAndVerify(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc_Blondel_verifyCurrentPhaseMapInInstallAndVerify(pqTool, ssid174X, flukeWIFI,randomConfigName));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185110, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyDeleteConfigInInstallAndVerify(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc_Blondel_verifyDeleteConfigInInstallAndVerify(pqTool, ssid174X, flukeWIFI,randomConfigName));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	
	// Install and Verify for Load study
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185111, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyInstallAndVerifyTabLoadStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
		try
		{
			Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc_Blondel_verifyInstallAndVerifyTabLoadStudy(pqTool, ssid174X, flukeWIFI,randomConfigName));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185112, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyLoggerNameInInstallAndVerifyLoadStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		String loggerName = pqTool+"<"+ssid174X+">";
		try
		{
			Boolean LoggerNameDisplay = ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, loggerName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, loggerName, LocatorStrategy.NONE, null);
			CommonUtils.wait(1);
			Assert.assertTrue(LoggerNameDisplay);
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185113, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyConfigNameInInstallAndVerifyLoadStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Boolean LoggerNameDisplay = ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, randomConfigName, LocatorStrategy.NONE, null);
			CommonUtils.wait(1);
			Assert.assertTrue(LoggerNameDisplay);
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185114, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyStudyTypeInInstallAndVerifyLoadStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Boolean LoggerNameDisplay = ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Load Study", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Load Study", LocatorStrategy.NONE, null);
			CommonUtils.wait(1);
			Assert.assertTrue(LoggerNameDisplay);
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185115, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyTopologyInInstallAndVerifyLoadStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Boolean LoggerNameDisplay = ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Wye", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Wye It", LocatorStrategy.NONE, null);
			CommonUtils.wait(1);
			Assert.assertTrue(LoggerNameDisplay);
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185116, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyLoadCurrentFlowInInstallAndVerifyLoadStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc_Blondel_verifyLoadCurrentFlowInInstallAndVerify(pqTool, ssid174X, flukeWIFI,randomConfigName));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185117, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyGeneratorCurrentFlowInInstallAndVerifyLoadStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc_Blondel_verifyGeneratorCurrentFlowInInstallAndVerify(pqTool, ssid174X, flukeWIFI,randomConfigName));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185118, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyCurrentPhaseMapInInstallAndVerifyLoadStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc_Blondel_verifyCurrentPhaseMapInInstallAndVerify(pqTool, ssid174X, flukeWIFI,randomConfigName));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185119, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyDeleteConfigInInstallAndVerifyLoadStudy(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc_Blondel_verifyDeleteConfigInInstallAndVerify(pqTool, ssid174X, flukeWIFI,randomConfigName));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	
	
	
	
	//*****************************
	//Instrument settings test cases
	//******************************
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185301, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyInstrumentSettingsTab(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc_Blondel_verifyInstrumentSettingsTab(pqTool, ssid174X, flukeWIFI,randomConfigName));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185302, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyLoggerNameAndinfoLabel(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Boolean LoggernameAndInfo = ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Logger Name and Information", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Monitor_Name_Information", LocatorStrategy.NONE, null);		
			Assert.assertTrue(LoggernameAndInfo);
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185303, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyLoggerNameAndSerialName(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			String toolName = pqTool+"<"+ssid174X+">";
			Boolean LoggernameSerialNumber = ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, toolName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, toolName, LocatorStrategy.NONE, null);		
			Assert.assertTrue(LoggernameSerialNumber);
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185304, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyInternetConnectionLabel(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Boolean internetConnection = ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Internet Connection", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Internet Connection", LocatorStrategy.NONE, null);		
			Assert.assertTrue(internetConnection);
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185305, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyInternetConnectionWifi(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Boolean internetConnection = ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "WiFi", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "WiFi", LocatorStrategy.NONE, null);		
			Assert.assertTrue(internetConnection);
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185306, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyInternetConnectionEthernet(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Internet Connection", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Internet Connection", LocatorStrategy.NONE, null).click();
			Boolean internetConnectionEthernet = ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Configure WiFi/Ethernet", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Configure WiFi/Ethernet", LocatorStrategy.NONE, null);		
			fCCM174XSessionConfigObjectRepo.clickOnBackButton();
			CommonUtils.wait(2);
			Assert.assertTrue(internetConnectionEthernet);
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185307, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyPowerSupplyLabel(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Boolean powerSupply = ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Power Supply", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Power Supply", LocatorStrategy.NONE, null);		
			Assert.assertTrue(powerSupply);
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185308, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyPowerSupplyMessageString(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Boolean powerSupplyString = ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Logger is running", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Logger is running", LocatorStrategy.NONE, null);		
			Assert.assertTrue(powerSupplyString);
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185309, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyRecordingState(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			gestureUtils.mScroll("Recording State", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
			Boolean powerSupplyString = ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Recording State", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Recording State", LocatorStrategy.NONE, null);		
			Assert.assertTrue(powerSupplyString);
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185310, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyRecordingStateNoActiveSession(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			gestureUtils.mScroll("Recording State", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
			Boolean powerSupplyString = ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "No active session", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "No active sessions", LocatorStrategy.NONE, null);		
			Assert.assertTrue(powerSupplyString);
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185311, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyAuthenticationLabel(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			gestureUtils.mScroll("Memory", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
			Boolean powerSupplyString = ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Authentication", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Logger Authentication", LocatorStrategy.NONE, null);		
			Assert.assertTrue(powerSupplyString);
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185312, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyAuthenticationSignInMessage(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			gestureUtils.mScroll("Memory", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
			Boolean powerSupplyString = ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Signed in as", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Signed in as", LocatorStrategy.NONE, null);		
			Assert.assertTrue(powerSupplyString);
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185313, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyLoggerCredentialUserNamePassword(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			gestureUtils.mScroll("Memory", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Signed in as", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Signed in as", LocatorStrategy.NONE, null).click();		
			Assert.assertTrue(ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "admin", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "admin", LocatorStrategy.NONE, null));
			Assert.assertTrue(ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Change password", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Change User Name & Password", LocatorStrategy.NONE, null));
			fCCM174XSessionConfigObjectRepo.clickOnBackButton();
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185314, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyToolMemoryPercentage(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			gestureUtils.mScroll("Date", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
			Assert.assertTrue(ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Available :", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Available", LocatorStrategy.NONE, null));
			Assert.assertTrue(ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "%", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "%", LocatorStrategy.NONE, null));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185315, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyDataAndSyncOption_Date(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			gestureUtils.mScroll("Accessories", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Date", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Date", LocatorStrategy.NONE, null).click();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185316, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyDataAndSyncOption_GPS(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "GPS", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "GPS", LocatorStrategy.NONE, null));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185317, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyDataAndSyncOption_Internet(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Internet", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Internet", LocatorStrategy.NONE, null));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185318, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyDataAndSyncOption_Phone(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Phone", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Phone", LocatorStrategy.NONE, null));		
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185319, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyDataAndSyncOption_SyncTime(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "SYNC TIME", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "SYNC TIME", LocatorStrategy.NONE, null));
			fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185320, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyAccessories(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			gestureUtils.mScroll("Firmware Version", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
			Assert.assertTrue(ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Accessories", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, null, LocatorStrategy.NONE, null));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185321, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyFirmwareVersion(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			gestureUtils.mScroll("Licences", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
			Assert.assertTrue(ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Firmware Version", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, null, LocatorStrategy.NONE, null));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185322, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyLicences_AvailableLicencesText(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			gestureUtils.mScroll("Service Data", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
			Assert.assertTrue(ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Available Licences", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, null, LocatorStrategy.NONE, null));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185323, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyLicences_GostReportingCheck(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			gestureUtils.mScroll("Service Data", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Available Licences", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, null, LocatorStrategy.NONE, null).click();
			Assert.assertTrue(ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "GOST Reporting", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, null, LocatorStrategy.NONE, null));
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185324, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyLicences_IEEECheck(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "IEEE 519", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, null, LocatorStrategy.NONE, null));
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185325, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyLicences_RemoteMonitoringCheck(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Remote Monitoring", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, null, LocatorStrategy.NONE, null));
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185326, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyLicences_WifiInfraCheck(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			Assert.assertTrue(ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "WiFi-Infrastructure", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, null, LocatorStrategy.NONE, null));
			fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185327, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyServiceData(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			gestureUtils.mScroll("Factory Reset", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
			Assert.assertTrue(ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Download Service Log Data", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, null, LocatorStrategy.NONE, null));		
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185328, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyServiceData_Download(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			gestureUtils.mScroll("Factory Reset", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Download Service Log Data", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, null, LocatorStrategy.NONE, null).click();		
			Assert.assertTrue(ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "DOWNLOAD", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, null, LocatorStrategy.NONE, null));		
			fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185329, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyFactoryReset(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			gestureUtils.mScroll("Reset to Defaults", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
			Assert.assertTrue(ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Reset to Defaults", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, null, LocatorStrategy.NONE, null));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185330, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verifyFactoryReset_ResetButtonCheck(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			gestureUtils.mScroll("Reset to Defaults", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Reset to Defaults", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, null, LocatorStrategy.NONE, null).click();		
			Assert.assertTrue(ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Reset", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, null, LocatorStrategy.NONE, null));
			fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	
	//Sessions
	
	//None, Energy study, Remote Monitoring
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185501, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Energy_SinglePhase_RM(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				//Assert.assertTrue(FCCM174XSessionConfiguration.tc14_Blondel_verifyNominalVoltageAndFrequency(pqTool, ssid174X, flukeWIFI,randomConfigName));
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc01_Blondel_verify_None_Energy_SinglePhase_RM(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185502, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Energy_Wye_RM(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc02_Blondel_verify_None_Energy_Wye_RM(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185503, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Energy_DeltaPhase_RM(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc03_Blondel_verify_None_Energy_Delta_RM(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185504, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Energy_SplitSinglePhase_RM(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc04_Blondel_verify_None_Energy_SplitSinglePhase_RM(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185505, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Energy_SinglePhaseIt_RM(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc05_Blondel_verify_None_Energy_SinglePhaseIt_RM(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185506, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Energy_WyeIt_RM(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc06_Blondel_verify_None_Energy_WyeIt_RM(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185507, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Energy_HighLegDelta_RM(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc07_Blondel_verify_None_Energy_HighLegDelta_RM(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185508, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Energy_OpenDelta_RM(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc08_Blondel_verify_None_Energy_OpenDelta_RM(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185509, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Energy_TwoElement_RM(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc09_Blondel_verify_None_Energy_TwoElement_RM(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185510, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Energy_WyeBalanced_RM(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc10_Blondel_verify_None_Energy_WyeBalanced_RM(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185511, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Energy_DeltaBalanced_RM(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc11_Blondel_verify_None_Energy_DeltaBalanced_RM(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	
	
	
	
	//None, Load study, Remote monitoring
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185512, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Load_SinglePhase_RM(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				//Assert.assertTrue(FCCM174XSessionConfiguration.tc14_Blondel_verifyNominalVoltageAndFrequency(pqTool, ssid174X, flukeWIFI,randomConfigName));
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc12_Blondel_verify_None_Load_SinglePhase_RM(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185513, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Load_Wye_RM(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc13_Blondel_verify_None_Load_Wye_RM(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185514, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Load_DeltaPhase_RM(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc14_Blondel_verify_None_Load_Delta_RM(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185515, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Load_SplitSinglePhase_RM(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc15_Blondel_verify_None_Load_SplitSinglePhase_RM(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185516, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Load_SinglePhaseIt_RM(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc16_Blondel_verify_None_Load_SinglePhaseIt_RM(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185517, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Load_WyeIt_RM(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc17_Blondel_verify_None_Load_WyeIt_RM(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185518, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Load_HighLegDelta_RM(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc18_Blondel_verify_None_Load_HighLegDelta_RM(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185519, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Load_OpenDelta_RM(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc19_Blondel_verify_None_Load_OpenDelta_RM(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185520, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Load_TwoElement_RM(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc20_Blondel_verify_None_Load_TwoElement_RM(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185521, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Load_WyeBalanced_RM(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc21_Blondel_verify_None_Load_WyeBalanced_RM(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	//@Test(alwaysRun = true, priority = 185522, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Load_DeltaBalanced_RM(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc22_Blondel_verify_None_Load_DeltaBalanced_RM(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	
	
	
	//None, Energy study, Remote Monitoring
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	@Test(alwaysRun = true, priority = 185523, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Energy_SinglePhase_EL(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				//Assert.assertTrue(FCCM174XSessionConfiguration.tc14_Blondel_verifyNominalVoltageAndFrequency(pqTool, ssid174X, flukeWIFI,randomConfigName));
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc23_Blondel_verify_None_Energy_SinglePhase_EL(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	@Test(alwaysRun = true, priority = 185524, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Energy_Wye_EL(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc24_Blondel_verify_None_Energy_Wye_EL(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	@Test(alwaysRun = true, priority = 185525, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Energy_DeltaPhase_EL(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc25_Blondel_verify_None_Energy_Delta_EL(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	@Test(alwaysRun = true, priority = 185526, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Energy_SplitSinglePhase_EL(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc26_Blondel_verify_None_Energy_SplitSinglePhase_EL(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	@Test(alwaysRun = true, priority = 185527, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Energy_SinglePhaseIt_EL(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc27_Blondel_verify_None_Energy_SinglePhaseIt_EL(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	@Test(alwaysRun = true, priority = 185528, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Energy_WyeIt_EL(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc28_Blondel_verify_None_Energy_WyeIt_EL(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	@Test(alwaysRun = true, priority = 185529, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Energy_HighLegDelta_EL(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc29_Blondel_verify_None_Energy_HighLegDelta_EL(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	@Test(alwaysRun = true, priority = 185530, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Energy_OpenDelta_EL(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc30_Blondel_verify_None_Energy_OpenDelta_EL(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	@Test(alwaysRun = true, priority = 185531, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Energy_TwoElement_EL(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc31_Blondel_verify_None_Energy_TwoElement_EL(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	@Test(alwaysRun = true, priority = 185532, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Energy_WyeBalanced_EL(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc32_Blondel_verify_None_Energy_WyeBalanced_EL(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	@Test(alwaysRun = true, priority = 185533, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Energy_DeltaBalanced_EL(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc33_Blondel_verify_None_Energy_DeltaBalanced_EL(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	
	
	
	
	//None, Load study, Remote monitoring
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	@Test(alwaysRun = true, priority = 185534, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Load_SinglePhase_EL(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				//Assert.assertTrue(FCCM174XSessionConfiguration.tc14_Blondel_verifyNominalVoltageAndFrequency(pqTool, ssid174X, flukeWIFI,randomConfigName));
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc34_Blondel_verify_None_Load_SinglePhase_EL(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	@Test(alwaysRun = true, priority = 185535, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Load_Wye_EL(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc35_Blondel_verify_None_Load_Wye_EL(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	@Test(alwaysRun = true, priority = 185536, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Load_DeltaPhase_EL(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc36_Blondel_verify_None_Load_Delta_EL(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	@Test(alwaysRun = true, priority = 185537, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Load_SplitSinglePhase_EL(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc37_Blondel_verify_None_Load_SplitSinglePhase_EL(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	@Test(alwaysRun = true, priority = 185538, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Load_SinglePhaseIt_EL(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc38_Blondel_verify_None_Load_SinglePhaseIt_EL(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	@Test(alwaysRun = true, priority = 185539, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Load_WyeIt_EL(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc39_Blondel_verify_None_Load_WyeIt_EL(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	@Test(alwaysRun = true, priority = 185540, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Load_HighLegDelta_EL(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc40_Blondel_verify_None_Load_HighLegDelta_EL(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	@Test(alwaysRun = true, priority = 185541, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Load_OpenDelta_EL(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc41_Blondel_verify_None_Load_OpenDelta_EL(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	@Test(alwaysRun = true, priority = 185542, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Load_TwoElement_EL(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc42_Blondel_verify_None_Load_TwoElement_EL(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	@Test(alwaysRun = true, priority = 185543, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Load_WyeBalanced_EL(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc43_Blondel_verify_None_Load_WyeBalanced_EL(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
	@Parameters({"pqTool","ssid174X","flukeWIFI"})
	@Test(alwaysRun = true, priority = 185544, groups = {FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS})
	public void verify_None_Load_DeltaBalanced_EL(@Optional("null") String pqTool,@Optional("null") String ssid174X,@Optional("null") String flukeWIFI)
	{
		try
		{
			randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
			try
			{
				Assert.assertTrue(fCCM174XInstallCommisioningSessionsPage.tc44_Blondel_verify_None_Load_DeltaBalanced_EL(pqTool, ssid174X, flukeWIFI,randomConfigName));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		}
	}
	
	
}
