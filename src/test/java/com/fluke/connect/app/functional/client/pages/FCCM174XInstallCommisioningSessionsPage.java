package com.fluke.connect.app.functional.client.pages;

import org.testng.Assert;

import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.GestureUtils;

import io.appium.java_client.TouchAction;

import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.ScrollDiection;

public class FCCM174XInstallCommisioningSessionsPage {
	private Switcher switcher;
	private GestureUtils gestureUtils;
	private FCCM174XSessionConfigObjectRepo fCCM174XSessionConfigObjectRepo;
	private String testFailureState;
	private boolean testFailureFlag = false;
	
	public FCCM174XInstallCommisioningSessionsPage()
	{
		CommonUtils.initElements(this, 15);
		switcher = new Switcher();
		gestureUtils = new GestureUtils();
		fCCM174XSessionConfigObjectRepo = new FCCM174XSessionConfigObjectRepo();
	}
	
	public Boolean tc01_Blondel_verifyInstallAndVerifyTab(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnSetupLoggingOrMonitoringLink();
		fCCM174XSessionConfigObjectRepo.clickOnThreePhasePowerMonitorLink();
		fCCM174XSessionConfigObjectRepo.clickOnpowerQualityLogger();
		fCCM174XSessionConfigObjectRepo.clickOpenPhoneSettingsButton();
		fCCM174XSessionConfigObjectRepo.selectToolWifi(pqTool, ssid174X);
		fCCM174XSessionConfigObjectRepo.enterUserNameAndPasswordInLoginAuthentication();
		fCCM174XSessionConfigObjectRepo.isVisibleSessionSetupText();
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		Config.appWidthCenterFlag = true;
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		}	
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		CommonUtils.wait(1);
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		//Clicking on Install and Verify link.
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		
		
		return true;
	}
	
	public Boolean tc_Blondel_verifyLoadCurrentFlowInInstallAndVerify(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		gestureUtils.mScroll("Detected Phase Mapping:", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Load", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Load", LocatorStrategy.NONE, null);
		CommonUtils.wait(1);
		return true;
	}
	
	public Boolean tc_Blondel_verifyGeneratorCurrentFlowInInstallAndVerify(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		gestureUtils.mScroll("Detected Phase Mapping:", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Generator", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Generator", LocatorStrategy.NONE, null);
		CommonUtils.wait(1);
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Load", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Load", LocatorStrategy.NONE, null);
		CommonUtils.wait(1);
		return true;
	}
	
	public Boolean tc_Blondel_verifyVoltagePhaseMapInInstallAndVerify(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		gestureUtils.mScroll("Digital Corrections:", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		Boolean voltagePhaseMap = ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Voltage:1 - A, 2 - B, 3 - C", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Voltage: 1- A, 2- B, 3- C", LocatorStrategy.NONE, null);
		CommonUtils.wait(1);
		if (voltagePhaseMap == true)
		{
			return true;
		}
		else
		{
			return false;
		}
			
	}
	
	public Boolean tc_Blondel_verifyCurrentPhaseMapInInstallAndVerify(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		gestureUtils.mScroll("Digital Corrections:", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		Boolean currentPhaseMap = ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Current:1 - A, 2 - B, 3 - C", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Current: 1- A, 2- B, 3- C", LocatorStrategy.NONE, null);
		CommonUtils.wait(1);
		if (currentPhaseMap == true)
		{
			return true;
		}
		else
		{
			return false;
		}
			
	}
	
	public Boolean tc_Blondel_verifyDeleteConfigInInstallAndVerify(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, randomConfigName, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		
		return true;
	}
	
	
	
	//Install and Verify for Load study
	public Boolean tc_Blondel_verifyInstallAndVerifyTabLoadStudy(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnSetupLoggingOrMonitoringLink();
		fCCM174XSessionConfigObjectRepo.clickOnThreePhasePowerMonitorLink();
		fCCM174XSessionConfigObjectRepo.clickOnpowerQualityLogger();
		fCCM174XSessionConfigObjectRepo.clickOpenPhoneSettingsButton();
		fCCM174XSessionConfigObjectRepo.selectToolWifi(pqTool, ssid174X);
		fCCM174XSessionConfigObjectRepo.enterUserNameAndPasswordInLoginAuthentication();
		fCCM174XSessionConfigObjectRepo.isVisibleSessionSetupText();
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_LOADSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		Config.appWidthCenterFlag = true;
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		}	
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		CommonUtils.wait(1);
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		
		//Clicking on Install and Verify link.
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		
		
		return true;
	}
	
	
	
	
	//*******************
	//Instrument Settings 
	//*******************
	public Boolean tc_Blondel_verifyInstrumentSettingsTab(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnSetupLoggingOrMonitoringLink();
		fCCM174XSessionConfigObjectRepo.clickOnThreePhasePowerMonitorLink();
		fCCM174XSessionConfigObjectRepo.clickOnpowerQualityLogger();
		fCCM174XSessionConfigObjectRepo.clickOpenPhoneSettingsButton();
		fCCM174XSessionConfigObjectRepo.selectToolWifi(pqTool, ssid174X);
		fCCM174XSessionConfigObjectRepo.enterUserNameAndPasswordInLoginAuthentication();
		fCCM174XSessionConfigObjectRepo.isVisibleSessionSetupText();
		fCCM174XSessionConfigObjectRepo.clickOnInstrumentSettings();
		
		return true;
		
	}
	
	
	
	//*******************
	//Sessions
	//*******************
	
	//None, Energy study
	
	
	public void session_validations(String loggerName, String configName, String studyType, String topology, String sessionType) throws Exception
	{
		//Checking Logger name
		try
		{
			//String loggerName = pqTool+"<"+ssid174X+">";
			Assert.assertTrue(ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, loggerName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, loggerName, LocatorStrategy.NONE, null));
		}
		catch(Throwable e)
		{
			Assert.fail("Error in Displaying Logger name");
			testFailureFlag = true;
		}
		
		//Checking Configuration name
		try
		{
			Assert.assertTrue(ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, configName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, configName, LocatorStrategy.NONE, null));
		}
		catch(Throwable e)
		{
			Assert.fail("Error in Displaying Configuration name");
			testFailureFlag = true;
		}
		
		//Checking study type
		try
		{
			Assert.assertTrue(ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, studyType, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, studyType, LocatorStrategy.NONE, null));
		}
		catch(Throwable e)
		{
			Assert.fail("Error in Displaying Study type");
			testFailureFlag = true;
		}
		
		//Checking topology
		try
		{
			Assert.assertTrue(ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, topology, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, topology, LocatorStrategy.NONE, null));
		}
		catch(Throwable e)
		{
			Assert.fail("Error in Displaying topology");
			testFailureFlag = true;
		}
		
		
		if (sessionType=="Remote Monitoring")
		{
			//Checking Remote monitoring text
			try
			{
				Assert.assertTrue(ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Stream Data to the Fluke Connect Cloud", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Stream Data to the Fluke Connect Cloud", LocatorStrategy.NONE, null));
			}
			catch(Throwable e)
			{
				Assert.fail("Error in Displaying session type (Remote monotring)");
				testFailureFlag = true;
			}
		}
		else
		{
			//Checking Local Logging 
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Save data to the logger", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Sava Data to the Logger", LocatorStrategy.NONE, null).click();
			CommonUtils.wait(2);
			try
			{
				Assert.assertTrue(ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Start Local Logging", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Start Logging Session", LocatorStrategy.NONE, null));		
			}
			catch(Throwable e)
			{
				Assert.fail("Error in Displaying session type (Event logging)");
				testFailureFlag = true;
			}
			fCCM174XSessionConfigObjectRepo.clickOnBackButton();
			
			
		}
		
		
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		
		gestureUtils.mobileScroll(configName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, configName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, configName, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
	}
	
	public Boolean tc01_Blondel_verify_None_Energy_SinglePhase_RM(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnSetupLoggingOrMonitoringLink();
		fCCM174XSessionConfigObjectRepo.clickOnThreePhasePowerMonitorLink();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOnSaveButton();
			fCCM174XSessionConfigObjectRepo.clickOnAllowButton();	
		}
		fCCM174XSessionConfigObjectRepo.clickOnpowerQualityLogger();
		fCCM174XSessionConfigObjectRepo.clickOpenPhoneSettingsButton();
		fCCM174XSessionConfigObjectRepo.selectToolWifi(pqTool, ssid174X);
		fCCM174XSessionConfigObjectRepo.enterUserNameAndPasswordInLoginAuthentication();
		fCCM174XSessionConfigObjectRepo.isVisibleSessionSetupText();
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_SinglePhase_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Energy Study","Single Phase","Remote Monitoring");	
		return true;
	}
	
	
	
	public Boolean tc02_Blondel_verify_None_Energy_Wye_RM(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_Wye_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Energy Study","Wye","Remote Monitoring");	
		return true;
	}
	
	
	public Boolean tc03_Blondel_verify_None_Energy_Delta_RM(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_Delta_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Energy Study","Delta","Remote Monitoring");	
		return true;
	}
	
	
	public Boolean tc04_Blondel_verify_None_Energy_SplitSinglePhase_RM(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_SplitSinglePhase_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Energy Study","Split Single Phase","Remote Monitoring");	
		return true;
	}
	
	
	public Boolean tc05_Blondel_verify_None_Energy_SinglePhaseIt_RM(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_SinglePhaseIt_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Energy Study","Single Phase It","Remote Monitoring");	
		return true;
	}
	
	public Boolean tc06_Blondel_verify_None_Energy_WyeIt_RM(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIt_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Energy Study","Wye It","Remote Monitoring");	
		return true;
	}
	
	
	public Boolean tc07_Blondel_verify_None_Energy_HighLegDelta_RM(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_HighLegDelta_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Energy Study","High Leg Delta","Remote Monitoring");	
		return true;
	}
	
	
	public Boolean tc08_Blondel_verify_None_Energy_OpenDelta_RM(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_OpenDelta_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Energy Study","Open Delta","Remote Monitoring");	
		return true;
	}
	
	
	public Boolean tc09_Blondel_verify_None_Energy_TwoElement_RM(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_TwoElement_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Energy Study","Two Element","Remote Monitoring");	
		return true;
	}
	
	
	public Boolean tc10_Blondel_verify_None_Energy_WyeBalanced_RM(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_WyeBalanced_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Energy Study","Wye","Remote Monitoring");	
		return true;
	}
	
	
	public Boolean tc11_Blondel_verify_None_Energy_DeltaBalanced_RM(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_DeltaBalanced_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Energy Study","Delta","Remote Monitoring");	
		return true;
	}
	
	
	
	//None, Load study
	
	public Boolean tc12_Blondel_verify_None_Load_SinglePhase_RM(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_LOADSTUDY_StudyType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_SinglePhase_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Load Study","Single Phase","Remote Monitoring");	
		return true;
	}
	
	
	
	public Boolean tc13_Blondel_verify_None_Load_Wye_RM(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_LOADSTUDY_StudyType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_Wye_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Load Study","Wye","Remote Monitoring");	
		return true;
	}
	
	
	public Boolean tc14_Blondel_verify_None_Load_Delta_RM(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_LOADSTUDY_StudyType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_Delta_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Load Study","Delta","Remote Monitoring");	
		return true;
	}
	
	
	public Boolean tc15_Blondel_verify_None_Load_SplitSinglePhase_RM(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_LOADSTUDY_StudyType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_SplitSinglePhase_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Load Study","Split Single Phase","Remote Monitoring");	
		return true;
	}
	
	
	public Boolean tc16_Blondel_verify_None_Load_SinglePhaseIt_RM(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_LOADSTUDY_StudyType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_SinglePhaseIt_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Load Study","Single Phase It","Remote Monitoring");	
		return true;
	}
	
	public Boolean tc17_Blondel_verify_None_Load_WyeIt_RM(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_LOADSTUDY_StudyType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIt_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Load Study","Wye It","Remote Monitoring");	
		return true;
	}
	
	
	public Boolean tc18_Blondel_verify_None_Load_HighLegDelta_RM(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_LOADSTUDY_StudyType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_HighLegDelta_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Load Study","High Leg Delta","Remote Monitoring");	
		return true;
	}
	
	
	public Boolean tc19_Blondel_verify_None_Load_OpenDelta_RM(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_LOADSTUDY_StudyType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_OpenDelta_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Load Study","Open Delta","Remote Monitoring");	
		return true;
	}
	
	
	public Boolean tc20_Blondel_verify_None_Load_TwoElement_RM(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_LOADSTUDY_StudyType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_TwoElement_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Load Study","Two Element","Remote Monitoring");	
		return true;
	}
	
	
	public Boolean tc21_Blondel_verify_None_Load_WyeBalanced_RM(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_LOADSTUDY_StudyType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_WyeBalanced_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Load Study","Wye","Remote Monitoring");	
		return true;
	}
	
	
	public Boolean tc22_Blondel_verify_None_Load_DeltaBalanced_RM(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_LOADSTUDY_StudyType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_DeltaBalanced_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Load Study","Delta","Remote Monitoring");	
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Boolean tc23_Blondel_verify_None_Energy_SinglePhase_EL(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnSetupLoggingOrMonitoringLink();
		fCCM174XSessionConfigObjectRepo.clickOnThreePhasePowerMonitorLink();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOnSaveButton();
			fCCM174XSessionConfigObjectRepo.clickOnAllowButton();	
		}
		fCCM174XSessionConfigObjectRepo.clickOnpowerQualityLogger();
		fCCM174XSessionConfigObjectRepo.clickOpenPhoneSettingsButton();
		fCCM174XSessionConfigObjectRepo.selectToolWifi(pqTool, ssid174X);
		fCCM174XSessionConfigObjectRepo.enterUserNameAndPasswordInLoginAuthentication();
		fCCM174XSessionConfigObjectRepo.isVisibleSessionSetupText();
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_SinglePhase_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Energy Study","Single Phase","Local Logging");	
		return true;
	}
	
	
	
	public Boolean tc24_Blondel_verify_None_Energy_Wye_EL(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_Wye_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Energy Study","Wye","Local Logging");	
		return true;
	}
	
	
	public Boolean tc25_Blondel_verify_None_Energy_Delta_EL(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_Delta_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Energy Study","Delta","Local Logging");	
		return true;
	}
	
	
	public Boolean tc26_Blondel_verify_None_Energy_SplitSinglePhase_EL(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_SplitSinglePhase_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Energy Study","Split Single Phase","Local Logging");	
		return true;
	}
	
	
	public Boolean tc27_Blondel_verify_None_Energy_SinglePhaseIt_EL(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_SinglePhaseIt_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Energy Study","Single Phase It","Local Logging");	
		return true;
	}
	
	public Boolean tc28_Blondel_verify_None_Energy_WyeIt_EL(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIt_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Energy Study","Wye It","Local Logging");	
		return true;
	}
	
	
	public Boolean tc29_Blondel_verify_None_Energy_HighLegDelta_EL(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_HighLegDelta_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Energy Study","High Leg Delta","Local Logging");	
		return true;
	}
	
	
	public Boolean tc30_Blondel_verify_None_Energy_OpenDelta_EL(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_OpenDelta_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Energy Study","Open Delta","Local Logging");	
		return true;
	}
	
	
	public Boolean tc31_Blondel_verify_None_Energy_TwoElement_EL(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_TwoElement_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Energy Study","Two Element","Local Logging");	
		return true;
	}
	
	
	public Boolean tc32_Blondel_verify_None_Energy_WyeBalanced_EL(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_WyeBalanced_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Energy Study","Wye","Local Logging");	
		return true;
	}
	
	
	public Boolean tc33_Blondel_verify_None_Energy_DeltaBalanced_EL(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_DeltaBalanced_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Energy Study","Delta","Local Logging");	
		return true;
	}
	
	
	
	//None, Load study
	
	public Boolean tc34_Blondel_verify_None_Load_SinglePhase_EL(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_LOADSTUDY_StudyType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_SinglePhase_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Load Study","Single Phase","Local Logging");	
		return true;
	}
	
	
	
	public Boolean tc35_Blondel_verify_None_Load_Wye_EL(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_LOADSTUDY_StudyType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_Wye_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Load Study","Wye","Local Logging");	
		return true;
	}
	
	
	public Boolean tc36_Blondel_verify_None_Load_Delta_EL(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_LOADSTUDY_StudyType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_Delta_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Load Study","Delta","Local Logging");	
		return true;
	}
	
	
	public Boolean tc37_Blondel_verify_None_Load_SplitSinglePhase_EL(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_LOADSTUDY_StudyType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_SplitSinglePhase_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Load Study","Split Single Phase","Local Logging");	
		return true;
	}
	
	
	public Boolean tc38_Blondel_verify_None_Load_SinglePhaseIt_EL(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_LOADSTUDY_StudyType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_SinglePhaseIt_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Load Study","Single Phase It","Local Logging");	
		return true;
	}
	
	public Boolean tc39_Blondel_verify_None_Load_WyeIt_EL(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_LOADSTUDY_StudyType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIt_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Load Study","Wye It","Local Logging");	
		return true;
	}
	
	
	public Boolean tc40_Blondel_verify_None_Load_HighLegDelta_EL(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_LOADSTUDY_StudyType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_HighLegDelta_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Load Study","High Leg Delta","Local Logging");	
		return true;
	}
	
	
	public Boolean tc41_Blondel_verify_None_Load_OpenDelta_EL(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_LOADSTUDY_StudyType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_OpenDelta_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Load Study","Open Delta","Local Logging");	
		return true;
	}
	
	
	public Boolean tc42_Blondel_verify_None_Load_TwoElement_EL(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_LOADSTUDY_StudyType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_TwoElement_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Load Study","Two Element","Local Logging");	
		return true;
	}
	
	
	public Boolean tc43_Blondel_verify_None_Load_WyeBalanced_EL(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_LOADSTUDY_StudyType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_WyeBalanced_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Load Study","Wye","Local Logging");	
		return true;
	}
	
	
	public Boolean tc44_Blondel_verify_None_Load_DeltaBalanced_EL(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnConfigureTheLoggerInSessionSetupPageText();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnNewConfigurationLink();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		fCCM174XSessionConfigObjectRepo.enterConfigurationNameInTextBox(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnStandardTypeDropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_NONE_StandardType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_LOADSTUDY_StudyType();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Single Phase", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_DeltaBalanced_topology();
		CommonUtils.wait(3);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_DoneButton();
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		}
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnInstallAndVerifyTheLoggerText();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Step 3", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Step 3", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validations
		String loggerName = pqTool+"<"+ssid174X+">";
		session_validations(loggerName,randomConfigName,"Load Study","Delta","Local Logging");	
		return true;
	}
	
}
