package com.fluke.connect.app.functional.client.pages;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.fluke.connect.app.utils.AndroidUtils;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverFactory;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.ScrollDiection;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.KeyEventFlag;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
//import com.fluke.blondel.Fccm174x_APIMethods;
//import com.fluke.blondel.*;

public class FCCM174XSessionConfigurationPage {

	private Switcher switcher;
	//private SignInPage signInPage;
	//private HomePage homePage;
	//private ServiceHatchPage serviceHatchPage;
	private GestureUtils gestureUtils;
	private FCCM174XSessionConfigObjectRepo fCCM174XSessionConfigObjectRepo;
	private String testFailureState;
	private boolean testFailureFlag = false;
	//private int max_Bit_Length = 50;
	//private int radix = 32;
	
	public FCCM174XSessionConfigurationPage()
	{
		CommonUtils.initElements(this, 15);
		switcher = new Switcher();
		gestureUtils = new GestureUtils();
		fCCM174XSessionConfigObjectRepo = new FCCM174XSessionConfigObjectRepo();
	}
	
	public Boolean tc01_Blondel_checkPowerQualityLoggerOption(String flukeWIFI) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnSetupLoggingOrMonitoringLink();
		fCCM174XSessionConfigObjectRepo.clickOnThreePhasePowerMonitorLink();
		Boolean PQLoggerCheck = fCCM174XSessionConfigObjectRepo.verifyPowerQualityLoggerOption();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		switcher.switchToHomePage();
		//fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
		//fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		//fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		
		return PQLoggerCheck;
	}
	
	public Boolean tc02_Blondel_ConnectingToBlondel(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnSetupLoggingOrMonitoringLink();
		fCCM174XSessionConfigObjectRepo.clickOnThreePhasePowerMonitorLink();
		fCCM174XSessionConfigObjectRepo.clickOnpowerQualityLogger();
		fCCM174XSessionConfigObjectRepo.clickOpenPhoneSettingsButton();
		fCCM174XSessionConfigObjectRepo.selectToolWifi(pqTool, ssid174X);
		Boolean monitorAuthStatus = fCCM174XSessionConfigObjectRepo.getMonitorAuthenticationText();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			switcher.switchToHomePage();
			fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
		    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
			fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			switcher.switchToHomePage();
			fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		}
		
		return monitorAuthStatus;
	}
	
	public Boolean tc03_Blondel_verifyLoggerAuthenticationPage(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnSetupLoggingOrMonitoringLink();
		fCCM174XSessionConfigObjectRepo.clickOnThreePhasePowerMonitorLink();
		fCCM174XSessionConfigObjectRepo.clickOnpowerQualityLogger();
		fCCM174XSessionConfigObjectRepo.clickOpenPhoneSettingsButton();
		fCCM174XSessionConfigObjectRepo.selectToolWifi(pqTool, ssid174X);
		fCCM174XSessionConfigObjectRepo.enterUserNameAndPasswordInLoginAuthentication();
		//fCCM174XSessionConfigObjectRepo.waitTillLoginAuthenticationIsVisible();
		//Verifying Monitor name in Monitor Authentication page
		//Assert.assertEquals(getMonitorNameInMonitorAuthenticationPageLabel(), "Monitor Name : "+pqTool+"<"+ssid174X+">");
		//CommonUtils.wait(1);
		
		//Verifying Serial Number in Monitor Authentication page
		//Assert.assertEquals(getSerialNumberInMonitorAuthenticationPageLabel(), "Serial Number : "+ssid174X);
		//CommonUtils.wait(1);
		
		
		//Verifying Firmware version in Monitor Authentication page
		
		//**********Need to add API validation to this assertion************//
		//Assert.assertEquals(getFirmwareVersionInMonitorAuthenticationPageLabel(), "Firmware Version : 1.1.1-224-g91b519c");
		//CommonUtils.wait(1);
		
		
		//fCCM174XSessionConfigObjectRepo.enterUserNameInMonitorAuthenticationPageText("admin");
		//fCCM174XSessionConfigObjectRepo.enterPasswordInMonitorAuthenticationPageText("admin");
		
		//fCCM174XSessionConfigObjectRepo.checkRememberUserInMonitorAuthenticationPageCheckbox();
		//UnfCCM174XSessionConfigObjectRepo.checkRememberUserInMonitorAuthenticationPageCheckbox();
		
		//fCCM174XSessionConfigObjectRepo.clickOnContinueInMonitorAuthenticationPageText();
		//CommonUtils.wait(5);
		Boolean isVisibleSessionSetup = fCCM174XSessionConfigObjectRepo.isVisibleSessionSetupText();
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		return isVisibleSessionSetup;
	}
	
	public Boolean tc04_Blondel_verifyLoggerAuthenticationWithSavedCredentials(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnSetupLoggingOrMonitoringLink();
		fCCM174XSessionConfigObjectRepo.clickOnThreePhasePowerMonitorLink();
		fCCM174XSessionConfigObjectRepo.clickOnpowerQualityLogger();
		fCCM174XSessionConfigObjectRepo.clickOpenPhoneSettingsButton();
		fCCM174XSessionConfigObjectRepo.selectToolWifi(pqTool, ssid174X);
		//fCCM174XSessionConfigObjectRepo.waitTillLoginAuthenticationIsVisible();
		//fCCM174XSessionConfigObjectRepo.enterUserNameInMonitorAuthenticationPageText("admin");
		//fCCM174XSessionConfigObjectRepo.enterPasswordInMonitorAuthenticationPageText("admin");
		fCCM174XSessionConfigObjectRepo.checkRememberUserInMonitorAuthenticationPageCheckbox();
		fCCM174XSessionConfigObjectRepo.clickOnContinueInMonitorAuthenticationPageText();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isVisibleSessionSetupText();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.clickOnSetupLoggingOrMonitoringLink();
		fCCM174XSessionConfigObjectRepo.clickOnThreePhasePowerMonitorLink();
		fCCM174XSessionConfigObjectRepo.clickOnpowerQualityLogger();
		
		//Verify Username is persisting
		Assert.assertTrue(fCCM174XSessionConfigObjectRepo.verifyUserNameInMonitorAuthenticationPageText());
		
		//verifyPasswordInMonitorAuthenticationPageText
		Assert.assertTrue(fCCM174XSessionConfigObjectRepo.verifyPasswordInMonitorAuthenticationPageText());
		
		//Verify Remember Username and Password checkbox is checked
		Boolean rememberUsrPass = fCCM174XSessionConfigObjectRepo.checkStatusOfRememberUserInMonitorAuthenticationPageCheckbox();
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		
		return rememberUsrPass;
	}
	
	public Boolean tc05_Blondel_verifyLoggerAuthenticationWithWrongCredentials(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnSetupLoggingOrMonitoringLink();
		fCCM174XSessionConfigObjectRepo.clickOnThreePhasePowerMonitorLink();
		fCCM174XSessionConfigObjectRepo.clickOnpowerQualityLogger();
		fCCM174XSessionConfigObjectRepo.clickOpenPhoneSettingsButton();
		fCCM174XSessionConfigObjectRepo.selectToolWifi(pqTool, ssid174X);
		fCCM174XSessionConfigObjectRepo.waitTillLoginAuthenticationIsVisible();
		fCCM174XSessionConfigObjectRepo.enterUserNameInMonitorAuthenticationPageText("admin");
		fCCM174XSessionConfigObjectRepo.enterPasswordInMonitorAuthenticationPageText("admin1");
		fCCM174XSessionConfigObjectRepo.clickOnContinueInMonitorAuthenticationPageText();
		CommonUtils.wait(5);
		Boolean loginAuthenticationText = fCCM174XSessionConfigObjectRepo.verifyLoginAuthenticationIsVisible();
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		
		return loginAuthenticationText;
		
	}
		
	public Boolean tc06_Blondel_verifySessionSetupPage(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		fCCM174XSessionConfigObjectRepo.clickOnSetupLoggingOrMonitoringLink();
		fCCM174XSessionConfigObjectRepo.clickOnThreePhasePowerMonitorLink();
		fCCM174XSessionConfigObjectRepo.clickOnpowerQualityLogger();
		fCCM174XSessionConfigObjectRepo.clickOpenPhoneSettingsButton();
		fCCM174XSessionConfigObjectRepo.selectToolWifi(pqTool, ssid174X);
		fCCM174XSessionConfigObjectRepo.waitTillLoginAuthenticationIsVisible();
		
		fCCM174XSessionConfigObjectRepo.enterUserNameInMonitorAuthenticationPageText("admin");
		fCCM174XSessionConfigObjectRepo.enterPasswordInMonitorAuthenticationPageText("admin");
		fCCM174XSessionConfigObjectRepo.clickOnContinueInMonitorAuthenticationPageText();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isVisibleSessionSetupText();
		
		//Verifying Logger name in Session Setup page
		try
		{
			Assert.assertEquals(fCCM174XSessionConfigObjectRepo.getLoggerNameInSessionSetupPageLabel(), "Logger Name: "+pqTool+"<"+ssid174X+">");
			CommonUtils.wait(1);
		}
		catch (Throwable e)
		{
			Assert.fail("Logger name is not shown properly, it is showing as: "+pqTool+"<"+ssid174X+">");
			testFailureFlag = true;
		}
		
		//Verifying RTC is displayed
		try
		{
			Assert.assertEquals(fCCM174XSessionConfigObjectRepo.isDisplayedRTC(), "true");
			CommonUtils.wait(1);
		}
		catch (Throwable e)
		{
			Assert.fail("Issue in displaying RTC");
			testFailureFlag = true;
		}
		
		
		//Verifying Recording state is displayed
		try
		{
			Assert.assertEquals(fCCM174XSessionConfigObjectRepo.isDisplayedRecordingState(), "true");
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Issue in displaying Recording status");
			testFailureFlag = true;
		}
		
		
		//Verifying is wifi strength displayed
		try
		{
			Assert.assertEquals(fCCM174XSessionConfigObjectRepo.isDisplayedWifiStrength(), "true");
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Issue in displaying wifi strength");
			testFailureFlag = true;
		}
		
		
		//Verifying is memory displayed
		try
		{
			Assert.assertEquals(fCCM174XSessionConfigObjectRepo.isDisplayedMemory(), "true");
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Issue in displaying memory");
			testFailureFlag = true;
		}
		
		
		//Verifying is battery displayed
		try
		{
			Assert.assertEquals(fCCM174XSessionConfigObjectRepo.isDisplayedBattery(), "true");
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Issue in displaying battery");
			testFailureFlag = true;
		}
		
		
		//Verifying is Configure the logger displayed
		try
		{
			Assert.assertEquals(fCCM174XSessionConfigObjectRepo.isDisplayedConfigureTheLoggerInSessionSetupPageText(), "true");
			CommonUtils.wait(1);
		}
		catch (Throwable e)
		{
			Assert.fail("Issue in displaying Configure the logger link");
			testFailureFlag = true;
		}
		
		
		//Verifying is installAndVerifyTheLogger displayed
		try
		{
			Assert.assertEquals(fCCM174XSessionConfigObjectRepo.isDisplayedInstallAndVerifyTheLoggerInSessionSetupPageText(), "true");
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Issue in displaying Install And Verify The Logger link");
			testFailureFlag = true;
		}
		
		gestureUtils.mobileScroll("Connect to Internet or begin Logging Session", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		//Verifying is setupContinuousMonitoringOrLocalLogging displayed
		try
		{
			Assert.assertEquals(fCCM174XSessionConfigObjectRepo.isDisplayedSetupContinuousMonitoringOrLocalLoggingInSessionSetupPageText(), "true");
			CommonUtils.wait(1);
		}
		catch (Throwable e)
		{
			Assert.fail("Issue in Setup Continuous Monitoring Or LocalLogging link");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		
		return true;
		
	}
		
	public Boolean tc07_Blondel_verifyConfigOverview(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
		fCCM174XSessionConfigObjectRepo.clickOnSetupLoggingOrMonitoringLink();
		fCCM174XSessionConfigObjectRepo.clickOnThreePhasePowerMonitorLink();
		fCCM174XSessionConfigObjectRepo.clickOnpowerQualityLogger();
		fCCM174XSessionConfigObjectRepo.clickOpenPhoneSettingsButton();
		fCCM174XSessionConfigObjectRepo.selectToolWifi(pqTool, ssid174X);
		fCCM174XSessionConfigObjectRepo.waitTillLoginAuthenticationIsVisible();
		
		fCCM174XSessionConfigObjectRepo.enterUserNameInMonitorAuthenticationPageText("admin");
		fCCM174XSessionConfigObjectRepo.enterPasswordInMonitorAuthenticationPageText("admin");
		fCCM174XSessionConfigObjectRepo.clickOnContinueInMonitorAuthenticationPageText();
		CommonUtils.wait(5);
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
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.UP);
		}	
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOn_ViewMore_Link();
		//clickOn_ViewMore_Link();
		
		//Verifing entered new config name
		try
		{
			Assert.assertEquals(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, randomConfigName, LocatorStrategy.NONE, null).getText(), randomConfigName);
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered config name is not displayed, Config name: "+randomConfigName);
			testFailureFlag = true;
		}
				
		//Verifying entered standard (none)
		try
		{
			Assert.assertEquals(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "None", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, "None", LocatorStrategy.NONE, null).getText(), "None");
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered standard(none) is not displayed, Standard: None");
			testFailureFlag = true;
		}
		
		//Verifying entered study type (Load Study)
		try
		{
			Assert.assertEquals(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Load Study", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, "Load Study", LocatorStrategy.NONE, null).getText(), "Load Study");
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered study type is not displayed, Study type: Load Study");
			testFailureFlag = true;
		}
		
		//Verifying entered Topology (wyeIT_topology)
		try
		{
			String abc = ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, "Wye It", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, "Wye It", LocatorStrategy.NONE, null).getText();
			Assert.assertEquals(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, "Wye It", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, "Wye It", LocatorStrategy.NONE, null).getText(), "Wye It");
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered Topology is not displayed, Topology: Wye It");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		CommonUtils.wait(1);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, randomConfigName, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Delete", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, "Delete", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(1);
		
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		return true;
		
		
		
	}
	
	public Boolean tc08_Blondel_verifySavedConfig(String pqTool, String ssid174X, String flukeWIFI) throws Exception

	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
		fCCM174XSessionConfigObjectRepo.clickOnSetupLoggingOrMonitoringLink();
		fCCM174XSessionConfigObjectRepo.clickOnThreePhasePowerMonitorLink();
		fCCM174XSessionConfigObjectRepo.clickOnpowerQualityLogger();
		fCCM174XSessionConfigObjectRepo.clickOpenPhoneSettingsButton();
		fCCM174XSessionConfigObjectRepo.selectToolWifi(pqTool, ssid174X);
		fCCM174XSessionConfigObjectRepo.waitTillLoginAuthenticationIsVisible();
		
		fCCM174XSessionConfigObjectRepo.enterUserNameInMonitorAuthenticationPageText("admin");
		fCCM174XSessionConfigObjectRepo.enterPasswordInMonitorAuthenticationPageText("admin");
		fCCM174XSessionConfigObjectRepo.clickOnContinueInMonitorAuthenticationPageText();
		CommonUtils.wait(5);
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
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOn_ViewMore_Link();
		
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			DriverManager.getDriver().findElement(MobileBy.xpath("//android.widget.TextView[contains(@text, '"+randomConfigName+"')]/preceding-sibling::android.widget.RadioButton")).click();
			CommonUtils.wait(1);
		}
		
		fCCM174XSessionConfigObjectRepo.clickOn_SendConfiguration_Button();
		CommonUtils.wait(2);
		Boolean configName = fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		CommonUtils.wait(1);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, randomConfigName, LocatorStrategy.NONE, null).click();
		//ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Delete", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, "Delete", LocatorStrategy.NONE, null).click();
		//ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Delete", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(1);
		
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		
		return configName;
		
	}
		
	public Boolean tc09_Blondel_verifySavedConfigMenuOptions(String pqTool, String ssid174X, String flukeWIFI) throws Exception

	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
		fCCM174XSessionConfigObjectRepo.clickOnSetupLoggingOrMonitoringLink();
		fCCM174XSessionConfigObjectRepo.clickOnThreePhasePowerMonitorLink();
		fCCM174XSessionConfigObjectRepo.clickOnpowerQualityLogger();
		fCCM174XSessionConfigObjectRepo.clickOpenPhoneSettingsButton();
		fCCM174XSessionConfigObjectRepo.selectToolWifi(pqTool, ssid174X);
		fCCM174XSessionConfigObjectRepo.waitTillLoginAuthenticationIsVisible();
		
		fCCM174XSessionConfigObjectRepo.enterUserNameInMonitorAuthenticationPageText("admin");
		fCCM174XSessionConfigObjectRepo.enterPasswordInMonitorAuthenticationPageText("admin");
		fCCM174XSessionConfigObjectRepo.clickOnContinueInMonitorAuthenticationPageText();
		CommonUtils.wait(5);
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
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		}
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOn_ViewMore_Link();
		
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			DriverManager.getDriver().findElement(MobileBy.xpath("//android.widget.TextView[contains(@text, '"+randomConfigName+"')]/preceding-sibling::android.widget.RadioButton")).click();
			//relativeLayoutOfSavedConfiguration.get(0).click();
			CommonUtils.wait(1);
		}
		
		fCCM174XSessionConfigObjectRepo.clickOn_SendConfiguration_Button();
		CommonUtils.wait(2);
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		}
		
		Boolean configName = fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		CommonUtils.wait(1);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, randomConfigName, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		
		//Verifying Edit link in Saved session page
		try
		{
			Assert.assertEquals(fCCM174XSessionConfigObjectRepo.isEditLinkDisplayedInSavedSessionPage(), "true");
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered study type is not displayed, Study type: Load Study");
			testFailureFlag = true;
		}
		
		//Verifying SaveAs link in Saved session page
		try
		{
			Assert.assertEquals(fCCM174XSessionConfigObjectRepo.isSaveAsLinkDisplayedInSavedSessionPage(), "true");
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered study type is not displayed, Study type: Load Study");
			testFailureFlag = true;
		}
		
		//Verifying Delete link in Saved session page
		try
		{
			Assert.assertEquals(fCCM174XSessionConfigObjectRepo.isDeleteLinkDisplayedInSavedSessionPage(), "true");
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered study type is not displayed, Study type: Load Study");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			throw new Exception();  //if any validation fails exception will triggered
		}
		//fCCM174XSessionConfigObjectRepo.clickOnEditLinkInSavedSessionScreen();
		//CommonUtils.wait(1);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Delete", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, "Delete", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		
		return configName;
		
	}
	
	public Boolean tc10_Blondel_verifyEditSavedConfig(String pqTool, String ssid174X, String flukeWIFI) throws Exception

	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		}	
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOn_ViewMore_Link();
		
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, randomConfigName, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		
		//Validations starts after edit Config
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			gestureUtils.mobileScroll("Config Name and Desc", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			gestureUtils.mobileScroll("Configuration Name & Description", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Config Name and Desc", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, "Configuration Name & Description", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_XPATH, "//XCUIElementTypeTextField", LocatorStrategy.NONE, null).clear();
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_XPATH, "//android.widget.EditText", LocatorStrategy.IOS_LOCATOR_STRATEGY_XPATH, "//XCUIElementTypeTextField", LocatorStrategy.NONE, null).sendKeys(randomConfigName+"_abcd");
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
		}
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		CommonUtils.wait(1);
		
		
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName+"_abcd", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName+"_abcd", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, randomConfigName+"_abcd", LocatorStrategy.NONE, null).click();
		
		//Verifing entered new config name
		try
		{
			Assert.assertEquals(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName+"_abcd", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, randomConfigName+"_abcd", LocatorStrategy.NONE, null).getText(), randomConfigName+"_abcd");
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered config name is not displayed, Config name: "+randomConfigName+"_abcd");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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

	public Boolean tc11_Blondel_verifySaveAsInSavedConfig(String pqTool, String ssid174X, String flukeWIFI) throws Exception

	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		}	
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, randomConfigName, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_SaveAs_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.enter_Text_In_SaveAs_EditBox(randomConfigName+"_saveAs");
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.isSavedConfigScreenVisible();
		}
		
		//Scroll till config name
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		//Verifing entered config name
		try
		{
			Assert.assertEquals(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, randomConfigName, LocatorStrategy.NONE, null).getText(), randomConfigName);
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered config name is not displayed, Expected Config name: "+randomConfigName);
			testFailureFlag = true;
		}
		
		
		// Scroll till new Config name given as part of Save As
		gestureUtils.mobileScroll(randomConfigName+"_saveAs", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		//Verifing entered config name (entered from SaveAs option)
		try
		{
			Assert.assertEquals(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName+"_saveAs", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, randomConfigName+"_saveAs", LocatorStrategy.NONE, null).getText(), randomConfigName+"_saveAs");
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered config name is not displayed, Expected Config name: "+randomConfigName+"_saveAs");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//deleting both Saved sessions
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, randomConfigName, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName+"_saveAs", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName+"_saveAs", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, randomConfigName+"_saveAs", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc12_Blondel_verifyEditConfigNameAndDescriptionForEnergyStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception

	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		}	
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOn_ViewMore_Link();
		
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, randomConfigName, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		
		//Validations starts after edit Config
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			gestureUtils.mobileScroll("Config Name and Desc", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			gestureUtils.mobileScroll("Configuration Name & Description", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Config Name and Desc", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, "Configuration Name & Description", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, randomConfigName, LocatorStrategy.NONE, null).clear();
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_XPATH, "//android.widget.EditText", LocatorStrategy.IOS_LOCATOR_STRATEGY_XPATH, "//XCUIElementTypeTextField", LocatorStrategy.NONE, null).sendKeys(randomConfigName+"_abcd");
		fCCM174XSessionConfigObjectRepo.enter_Text_In_DescriptionBox("abcd");
		
		
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOnBackButton();
			CommonUtils.wait(2);
		}
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
		}
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		CommonUtils.wait(1);
	
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		}
		
		gestureUtils.mobileScroll(randomConfigName+"_abcd", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName+"_abcd", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, randomConfigName+"_abcd", LocatorStrategy.NONE, null).click();
	
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		
		//Validations starts after edit Config
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			gestureUtils.mobileScroll("Config Name and Desc", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			gestureUtils.mobileScroll("Configuration Name & Description", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Config Name and Desc", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, "Configuration Name & Description", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validation check edited config name
		try
		{
			Assert.assertEquals(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_XPATH, "//android.widget.EditText", LocatorStrategy.IOS_LOCATOR_STRATEGY_XPATH, "//XCUIElementTypeTextField", LocatorStrategy.NONE, null).getText(), randomConfigName+"_abcd");
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered config name is not displayed, Expected Config name: "+randomConfigName+"_abcd");
			testFailureFlag = true;
		}
		
		//Validation check edited config description
		
		try
		{
			Assert.assertEquals(fCCM174XSessionConfigObjectRepo.get_Text_FromDescriptionBox(), "abcd");
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered config name description is not displayed properly, Expected Config name: abcd");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		}
		
		gestureUtils.mobileScroll(randomConfigName+"_abcd", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName+"_abcd", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, randomConfigName+"_abcd", LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
		
	public Boolean tc13_Blondel_verifyEditStudyTypeTopologyPhaseColour(String pqTool, String ssid174X, String flukeWIFI) throws Exception

	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		
		//Validations starts after edit Config
		gestureUtils.mobileScroll("Study Type,Topology and Phase Colors", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Study Type,Topology and Phase Colors", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.changeStudyTypeFromEditDropdown("Load Study");
		fCCM174XSessionConfigObjectRepo.changeTopologyFromEditDropdown("High Leg Delta");
		fCCM174XSessionConfigObjectRepo.changePhaseColourFromEditDropdown("Europe");
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		gestureUtils.mobileScroll("Nominal Voltage and Frequency", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		CommonUtils.wait(1);
		
		//Validating updated Study type, Topology and Phase colour
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Load Study"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Load Study");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("High Leg Delta"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: High Leg Delta");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Study Type,Topology and Phase Colors", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Europe"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Europe");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	
	
	
	
	public Boolean tc14_Blondel_verifyNominalVoltageAndFrequency(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		//String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, randomConfigName, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		//Validations starts after edit Config
		//gestureUtils.mobileScroll("Ranges and Scaling", Config.IOS_LOCATOR_STRATEGY_ID, ScrollDiection.DOWN);
		gestureUtils.mScroll("Ranges and Scaling","Ranges and Scaling", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Nominal Voltage and Frequency", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Nominal Voltage and Frequency", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.clickOnNominalVoltage_Dropdown();
		String iOS_NominalVoltage = null;
		String iOS_NominalFrequency = null;
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Custom Value", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Custom Value", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
			fCCM174XSessionConfigObjectRepo.enterCustomNominalVoltage("500");
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
		    iOS_NominalVoltage = fCCM174XSessionConfigObjectRepo.getNominalVoltage();
			
		}
			
		fCCM174XSessionConfigObjectRepo.clickOnNominalFrequency_Dropdown();
		
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "60 Hz", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
			iOS_NominalFrequency = fCCM174XSessionConfigObjectRepo.getNominalFrequency();
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		//validation
		//gestureUtils.mobileScroll("Ranges and Scaling", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		gestureUtils.mScroll("Ranges and Scaling","Ranges and Scaling", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		//gestureUtils.mScroll(null, "Ranges and Scaling", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.NONE, ScrollDiection.DOWN);
		//gestureUtils.scroll(ScrollDiection.DOWN, "");
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("500.0V, 60Hz"));
				CommonUtils.wait(1);
			}
			else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(iOS_NominalVoltage+" "+iOS_NominalFrequency));
				CommonUtils.wait(1);
			}
			
		}
		catch(Throwable e)
		{
			Assert.fail("Nominal voltage and frequency not set or not displayed properly");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Nominal Voltage and Frequency", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Nominal Voltage and Frequency", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("500.0"));
				CommonUtils.wait(1);
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(iOS_NominalVoltage));
				CommonUtils.wait(1);
			}
			
		}
		catch(Throwable e)
		{
			Assert.fail("Nominal voltage is not showing correctly or not set correctly");
			testFailureFlag = true;
		}
		
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("60 Hz"));
				CommonUtils.wait(1);
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(iOS_NominalFrequency));
				CommonUtils.wait(1);
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Nominal frequency is not showing correctly or not set correctly");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		/*
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		}
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, randomConfigName, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		*/
		
		return true;
	}
	
	public Boolean tc15_Blondel_verifyRangesAndScaling(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
	{
		/*
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		*/
		
		//Validations starts after edit Config
		//gestureUtils.mobileScroll("Ranges and Scaling", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		gestureUtils.mScroll("Ranges and Scaling","Ranges and Scaling", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Ranges and Scaling", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, "Ranges and Scaling", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.enterVoltageRatio("20");
		fCCM174XSessionConfigObjectRepo.enterCurrentRatio("30");
		fCCM174XSessionConfigObjectRepo.enterAmpNeutralRatio("10");
		
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
		}
		else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		}
		
		gestureUtils.mScroll("Ranges and Scaling","Ranges and Scaling", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Ranges and Scaling", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, "Ranges and Scaling", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validation
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validateVoltageRatio("20.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 20.0V");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validateCurrentRatio("30.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 30.0V");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validateAmpNeutralRatio("10.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 10.0V");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		/*
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		*/
		
		return true;
	}
	
	public Boolean tc16_Blondel_verifyMainSignalingVoltage(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		/*
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		*/
		
		
		//Validation starts after edit
		gestureUtils.mScroll("Mains Signalling Voltages","Mains Signaling Voltages", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Mains Signalling Voltages", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, "Mains Signaling Voltages", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		
		fCCM174XSessionConfigObjectRepo.enter_Freq1_ForMainSignalingVoltage("100");
		fCCM174XSessionConfigObjectRepo.enter_Freq2_ForMainSignalingVoltage("200");
		
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
		}
		else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOnBackButton();
			CommonUtils.wait(2);
		}
		
		//validation
		gestureUtils.mScroll("Harmonics Measurements Mode","Harmonics Measurement Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		
		//gestureUtils.mobileScroll("Harmonics Measurements Mode", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		try
		{
			if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("100.0Hz,200.0Hz"));
				CommonUtils.wait(1);
			}
			
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 100.0Hz,200.0Hz");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Mains Signalling Voltages", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, "Mains Signaling Voltages", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_Freq1_ForMainSigVoltage("100.0"));
				CommonUtils.wait(1);
			}
			else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_Freq1_ForMainSigVoltage("100"));
				CommonUtils.wait(1);
			}
			
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 100.0");
			testFailureFlag = true;
		}
		
		try
		{
			if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_Freq2_ForMainSigVoltage("200.0"));
				CommonUtils.wait(1);
			}
			else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_Freq2_ForMainSigVoltage("200"));
				CommonUtils.wait(1);
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 200.0");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		/*
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		*/
		
		return true;
	}
	
	public Boolean tc17_Blondel_verifyHarmonicMeasurementMode(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		/*
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		*/
		
		//Validation starts after edit
		gestureUtils.mScroll("Harmonics Measurements Mode","Harmonics Measurement Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Harmonics Measurement Mode", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validating Components radio button
		fCCM174XSessionConfigObjectRepo.clickOn_Components_RadioButton();
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
		}
		else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOnBackButton();
			CommonUtils.wait(2);
		}
		
		//gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		gestureUtils.mScroll("Flicker - Lamp Model","Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Components"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Components");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Harmonics Measurement Mode", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_Components_isSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Components radio button is not selected");
			testFailureFlag = true;
		}
		
		
		//Validating Grouped radio button
		fCCM174XSessionConfigObjectRepo.clickOn_Grouped_RadioButton();
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
		}
		else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOnBackButton();
			CommonUtils.wait(2);
		}
		
		gestureUtils.mScroll("Flicker - Lamp Model","Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Grouped"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Grouped");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Harmonics Measurement Mode", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_Grouped_isSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Grouped radio button is not selected");
			testFailureFlag = true;
		}
		
		
		//Validating SubGrouped radio button
		fCCM174XSessionConfigObjectRepo.clickOn_SubGrouped_RadioButton();
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
		}
		else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOnBackButton();
			CommonUtils.wait(2);
		}
		
		gestureUtils.mScroll("Flicker - Lamp Model","Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		
		try
		{
			if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Sub Grouped"));
				CommonUtils.wait(1);
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Subgrouped"));
				CommonUtils.wait(1);
			}
			
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Sub Grouped");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Harmonics Measurement Mode", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_SubGrouped_isSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("SubGrouped radio button is not selected");
			testFailureFlag = true;
		}
		
		
		//Validating IncludeInterHarmonics checkbox
		fCCM174XSessionConfigObjectRepo.check_IncludeInterHarmonics_checkbox();
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
		}
		else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOnBackButton();
			CommonUtils.wait(2);
		}
		
		gestureUtils.mScroll("Flicker - Lamp Model","Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Harmonics Measurement Mode", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_IncludeInterHarmonics_isCheckBoxSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Include Inter Harmonics checkbox is not selected");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		/*
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		*/
		
		return true;
	}

	public Boolean tc18_Blondel_verifyFlickerLampModel(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		/*
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, randomConfigName, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		*/
		
		//Validation starts after edit
		String iOS_FlickerLampModel = null;
		gestureUtils.mScroll("Flicker - Lamp Model","Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Flicker - Lamp Model", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.choose_FlickerLampModelVoltage("100 V");
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
		}
		else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOnBackButton();
			CommonUtils.wait(1);
		}
	    
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			gestureUtils.mScroll("Flicker - Lamp Model","Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Flicker - Lamp Model", LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
			iOS_FlickerLampModel= fCCM174XSessionConfigObjectRepo.getSelectedFlickerLampModelValueForiOS();

			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
		}
		
		
		
		gestureUtils.mScroll("Events: Triggers and Limits","Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		
		//Validation
		try
		{
			if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("100V"));
				CommonUtils.wait(1);
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchForValue("Flicker - Lamp Model",iOS_FlickerLampModel));
				CommonUtils.wait(1);
			}
			
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 100V");
			testFailureFlag = true;
		}
		
		gestureUtils.mScroll("Flicker - Lamp Model","Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Flicker - Lamp Model", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("100 V"));
				CommonUtils.wait(1);
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchUsingName(iOS_FlickerLampModel));
				CommonUtils.wait(1);
			}
			
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 100 V");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		/*
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		
		*/
		
		return true;
	}
		
	public Boolean tc19_Blondel_verifyEditEventTriggerAndLimitsForDipEvent(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		/*
		String randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
		
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
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mScroll(randomConfigName,randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		//gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, randomConfigName, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		*/
		
		//Validation starts after edit
		gestureUtils.mScroll("Events: Triggers and Limits","Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.clickOnDipSledingReferenceCheckbox();
		fCCM174XSessionConfigObjectRepo.clickAndEditDipLimitEditBox("80");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mScroll("Events: Triggers and Limits","Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mScroll("Swell","Swell", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkDipAndSwellCheckboxes());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Dip and Swell checkboxes are not checked, Expected : Both should be checked");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditDipLimitEditBoxValue("80.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 80.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to dip edit box value to 90.0
		fCCM174XSessionConfigObjectRepo.uncheckDipSledingReferenceCheckbox();
		fCCM174XSessionConfigObjectRepo.clickAndEditDipLimitEditBox("90");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();

		
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		/*
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		CommonUtils.wait(3);
		
		*/
		return true;
	}
	
	
	public Boolean tc20_Blondel_verifyEditEventTriggerAndLimitsForSwellEvent(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		/*
		String randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
		
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
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mScroll(randomConfigName,randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		//gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, randomConfigName, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		*/
		
		//Validation starts after edit
		gestureUtils.mScroll("Events: Triggers and Limits","Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnSwellSledingReferenceCheckbox();
		fCCM174XSessionConfigObjectRepo.clickAndEditSwellLimitEditBox("100");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		//Validation
		gestureUtils.mScroll("Events: Triggers and Limits","Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mScroll("Interruption","Interruptions", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkDipAndSwellCheckboxes());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Dip and Swell checkboxes are not checked, Expected : Both should be checked");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditSwellLimitEditBoxValue("100.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 100.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to swell edit box value to 110
		fCCM174XSessionConfigObjectRepo.uncheckSwellSledingReferenceCheckbox();
		fCCM174XSessionConfigObjectRepo.clickAndEditSwellLimitEditBox("110");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		CommonUtils.wait(2);
		
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		/*
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		CommonUtils.wait(3);
		*/
		return true;
	}
	
	
	public Boolean tc21_Blondel_verifyEditEventTriggerAndLimitsForInterruptionEvent(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		/*
		String randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
		
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
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mScroll(randomConfigName,randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, randomConfigName, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		*/
		
		//Validation starts after edit
		gestureUtils.mScroll("Events: Triggers and Limits","Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mScroll("Rapid Voltage Changes","Rapid Voltage Changes", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		
		fCCM174XSessionConfigObjectRepo.clickAndEditInterruptionLimitEditBox("10");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mScroll("Events: Triggers and Limits","Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mScroll("Rapid Voltage Changes","Rapid Voltage Changes", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditInterruptionLimitEditBoxValue("10.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 10.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to default values
		gestureUtils.mScroll("Set to Defaults","SET TO DEFAULTS", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Set to Defaults", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "SET TO DEFAULTS", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(3);
	
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		/*
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		CommonUtils.wait(3);
		*/
		return true;
	}
	
	
	public Boolean tc22_Blondel_verifyEditEventTriggerAndLimitsForRapidVoltageChangesEvent(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		/*
		String randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
		
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
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mScroll(randomConfigName,randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, randomConfigName, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		*/
		
		
		//Validation starts after edit
		gestureUtils.mScroll("Events: Triggers and Limits","Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mScroll("Mains Signalling Voltages","Mains Signalling", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		
		fCCM174XSessionConfigObjectRepo.clickAndEditRapidVoltageChangesLimitEditBox("10");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mScroll("Events: Triggers and Limits","Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mScroll("Mains Signalling Voltages","Mains Signalling", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkRapidVoltageChangesCheckboxes());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Rapid Voltage Changes trigger ON checkbox is not checked, Expected : check box should be checked");
			testFailureFlag = true;
		}
		
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditRapidVoltageChangesLimitEditBoxValue("10.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 10.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to default values
		
		gestureUtils.mScroll("Set to Defaults","SET TO DEFAULTS", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Set to Defaults", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "SET TO DEFAULTS", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(3);
	
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		/*
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		CommonUtils.wait(3);
		*/
		return true;
	}
	
	
	
	public Boolean tc23_Blondel_verifyEditEventTriggerAndLimitsForMainsSignallingEvent(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		/*
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		*/
		
		//Validation starts after edit
		gestureUtils.mScroll("Events: Triggers and Limits","Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mScroll("Waveform Deviation","Waveform Deviation", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		
		fCCM174XSessionConfigObjectRepo.clickAndEditMainsSignallingVoltagesLimitsEditBox("20");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mScroll("Events: Triggers and Limits","Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mScroll("Waveform Deviation","Waveform Deviation", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
			
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkMainsSignallingVoltagesCheckboxes());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Mains Signalling Voltages trigger ON checkbox is not checked, Expected : check box should be checked");
			testFailureFlag = true;
		}
		
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditMainsSignallingVoltagesLimitEditBoxValue("20.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 20.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to default values
		
		gestureUtils.mScroll("Set to Defaults","SET TO DEFAULTS", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Set to Defaults", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "SET TO DEFAULTS", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(3);
	
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		/*
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		CommonUtils.wait(3);
		*/
		return true;
	}
	
	
	public Boolean tc24_Blondel_verifyEditEventTriggerAndLimitsForWaveformDeviationEvent(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		/*
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		*/
		
		//Validation starts after edit
		gestureUtils.mScroll("Events: Triggers and Limits","Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mScroll("Inrush Current","Inrush Current", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
				
		fCCM174XSessionConfigObjectRepo.clickAndEditWaveformDeviationLimitsEditBox("20");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mScroll("Events: Triggers and Limits","Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mScroll("Inrush Current","Inrush Current", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
			
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkWaveformDeviationCheckbox());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Waveform Deviation trigger ON checkbox is not checked, Expected : check box should be checked");
			testFailureFlag = true;
		}
		
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditWaveformDeviationLimitEditBoxValue("20.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 20.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to default values
		gestureUtils.mScroll("Set to Defaults","SET TO DEFAULTS", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Set to Defaults", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "SET TO DEFAULTS", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(3);
	
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		/*
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		CommonUtils.wait(3);
		*/
		return true;
	}
	
	
	
	public Boolean tc25_Blondel_verifyEditEventTriggerAndLimitsForInrushCurrentEvent(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		/*
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		*/
		
		//Validation starts after edit
		gestureUtils.mScroll("Events: Triggers and Limits","Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mScroll("Set to Defaults","SET TO DEFAULTS", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		
		fCCM174XSessionConfigObjectRepo.clickAndEditInrushCurrentLimitsEditBox("100");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mScroll("Events: Triggers and Limits","Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mScroll("Set to Defaults","SET TO DEFAULTS", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkInrushCurrentCheckbox());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Inrush Current trigger ON checkbox is not checked, Expected : check box should be checked");
			testFailureFlag = true;
		}
		
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditInrushCurrentLimitEditBoxValue("100.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 100.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to default values
		
		gestureUtils.mScroll("Set to Defaults","SET TO DEFAULTS", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Set to Defaults", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "SET TO DEFAULTS", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(3);
	
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		/*
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		CommonUtils.wait(3);
		*/
		return true;
	}
	
	
	public Boolean tc26_Blondel_verifyEditingIntervals(String pqTool, String ssid174X, String flukeWIFI, String randomConfigName) throws Exception
	{
		/*
		String randomConfigName = fCCM174XSessionConfigObjectRepo.getRandomText()+"_Test";
		
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
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mScroll(randomConfigName,randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, randomConfigName, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		*/
		
		//Validation starts after edit
		gestureUtils.mScroll("Intervals","Intervals (Trend, Demand)", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Intervals", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Intervals (Trend, Demand)", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.clickOn_TrendIntervalDropdown();
		String trendInterval_3rdItem =fCCM174XSessionConfigObjectRepo.clickOn_TrendInterval_listItem();
		fCCM174XSessionConfigObjectRepo.clickOn_DemandIntervalDropdown();
		String demandInterval_3rdItem = fCCM174XSessionConfigObjectRepo.clickOn_DemandInterval_listItem();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		gestureUtils.mScroll("AUX Probes","AUX Probes", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
				
		//Trend :1 minutes, Demand :15 minutes
		String selectedIntervals = "Trend :"+trendInterval_3rdItem+", Demand :"+demandInterval_3rdItem;
		
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(selectedIntervals));
				CommonUtils.wait(1);
			}
			
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Actual text:"+selectedIntervals);
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Intervals", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Intervals (Trend, Demand)", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(trendInterval_3rdItem));
				CommonUtils.wait(1);
			}
			else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchForValue(trendInterval_3rdItem));
				CommonUtils.wait(1);
			}
			
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Actual text:"+trendInterval_3rdItem);
			testFailureFlag = true;
		}
		
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(demandInterval_3rdItem));
				CommonUtils.wait(1);
			}
			else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchForValue(demandInterval_3rdItem));
				CommonUtils.wait(1);
			}
			
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Actual text:"+demandInterval_3rdItem);
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		}
		
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	
	
	
	
	
	
	//Energy study- During config creation
	
	public Boolean tc27_Blondel_verifyConfigNameAndDescriptionForEnergyStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		}	
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		//Validations starts after edit Config
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			gestureUtils.mobileScroll("Config Name and Desc", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			gestureUtils.mobileScroll("Configuration Name & Description", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Config Name and Desc", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, "Configuration Name & Description", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, randomConfigName, LocatorStrategy.NONE, null).clear();
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_XPATH, "//android.widget.EditText", LocatorStrategy.IOS_LOCATOR_STRATEGY_XPATH, "//XCUIElementTypeTextField", LocatorStrategy.NONE, null).sendKeys(randomConfigName+"_abcd");
		fCCM174XSessionConfigObjectRepo.enter_Text_In_DescriptionBox("abcd");
		
		
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOnBackButton();
			CommonUtils.wait(2);
		}
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
		}
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		CommonUtils.wait(1);
	
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		}
		
		else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			gestureUtils.mobileScroll("Previous Configurations", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Previous Configurations", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
		}
		
		
		gestureUtils.mobileScroll(randomConfigName+"_abcd", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName+"_abcd", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, randomConfigName+"_abcd", LocatorStrategy.NONE, null).click();
	
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		
		//Validations starts after edit Config
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			gestureUtils.mobileScroll("Config Name and Desc", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			gestureUtils.mobileScroll("Configuration Name & Description", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Config Name and Desc", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, "Configuration Name & Description", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validation check edited config name
		try
		{
			Assert.assertEquals(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_XPATH, "//android.widget.EditText", LocatorStrategy.IOS_LOCATOR_STRATEGY_XPATH, "//XCUIElementTypeTextField", LocatorStrategy.NONE, null).getText(), randomConfigName+"_abcd");
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered config name is not displayed, Expected Config name: "+randomConfigName+"_abcd");
			testFailureFlag = true;
		}
		
		//Validation check edited config description
		
		try
		{
			Assert.assertEquals(fCCM174XSessionConfigObjectRepo.get_Text_FromDescriptionBox(), "abcd");
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered config name description is not displayed properly, Expected Config name: abcd");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		}
		
		//gestureUtils.mobileScroll("Previous Configurations", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		//ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Previous Configurations", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		//CommonUtils.wait(1);
		gestureUtils.mobileScroll(randomConfigName+"_abcd", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName+"_abcd", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, randomConfigName+"_abcd", LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	//Dont run TC-28 issue in iOS same as TC-13
	public Boolean tc28_Blondel_verifyTopologyAndPhaseColorForEnergyStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		}	
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		

		//Validations starts after edit Config
		gestureUtils.mobileScroll("Study Type,Topology and Phase Colors", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Study Type,Topology and Phase Colors", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.changeStudyTypeFromEditDropdown("Load Study");
		fCCM174XSessionConfigObjectRepo.changeTopologyFromEditDropdown("High Leg Delta");
		fCCM174XSessionConfigObjectRepo.changePhaseColourFromEditDropdown("Europe");
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		gestureUtils.mobileScroll("Nominal Voltage and Frequency", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		CommonUtils.wait(1);
		
		//Validating updated Study type, Topology and Phase colour
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Load Study"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Load Study");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("High Leg Delta"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: High Leg Delta");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Study Type,Topology and Phase Colors", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Europe"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Europe");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		}
		
		//gestureUtils.mobileScroll("Previous Configurations", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		//ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Previous Configurations", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		//CommonUtils.wait(1);
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, randomConfigName, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
		
	public Boolean tc29_Blondel_verifyNominalVoltageAndFrequencyForEnergyStudy(String pqTool, String ssid174X, String flukeWIFI,String randomConfigName) throws Exception
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
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		}	
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		

		
		//Validations starts after edit Config
		//gestureUtils.mobileScroll("Ranges and Scaling", Config.IOS_LOCATOR_STRATEGY_ID, ScrollDiection.DOWN);
		gestureUtils.mScroll("Ranges and Scaling","Ranges and Scaling", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Nominal Voltage and Frequency", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Nominal Voltage and Frequency", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.clickOnNominalVoltage_Dropdown();
		String iOS_NominalVoltage = null;
		String iOS_NominalFrequency = null;
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Custom Value", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Custom Value", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
			fCCM174XSessionConfigObjectRepo.enterCustomNominalVoltage("500");
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
		    iOS_NominalVoltage = fCCM174XSessionConfigObjectRepo.getNominalVoltage();
			
		}
			
		fCCM174XSessionConfigObjectRepo.clickOnNominalFrequency_Dropdown();
		
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "60 Hz", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
			iOS_NominalFrequency = fCCM174XSessionConfigObjectRepo.getNominalFrequency();
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		//validation
		//gestureUtils.mobileScroll("Ranges and Scaling", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		gestureUtils.mScroll("Ranges and Scaling","Ranges and Scaling", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		//gestureUtils.mScroll(null, "Ranges and Scaling", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.NONE, ScrollDiection.DOWN);
		//gestureUtils.scroll(ScrollDiection.DOWN, "");
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("500.0V, 60Hz"));
				CommonUtils.wait(1);
			}
			else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(iOS_NominalVoltage+" "+iOS_NominalFrequency));
				CommonUtils.wait(1);
			}
			
		}
		catch(Throwable e)
		{
			Assert.fail("Nominal voltage and frequency not set or not displayed properly");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Nominal Voltage and Frequency", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Nominal Voltage and Frequency", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("500.0"));
				CommonUtils.wait(1);
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(iOS_NominalVoltage));
				CommonUtils.wait(1);
			}
			
		}
		catch(Throwable e)
		{
			Assert.fail("Nominal voltage is not showing correctly or not set correctly");
			testFailureFlag = true;
		}
		
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("60 Hz"));
				CommonUtils.wait(1);
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(iOS_NominalFrequency));
				CommonUtils.wait(1);
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Nominal frequency is not showing correctly or not set correctly");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		/*
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		}
		
		//gestureUtils.mobileScroll("Previous Configurations", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		//ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Previous Configurations", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		//CommonUtils.wait(1);
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, randomConfigName, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		*/
		return true;
	}
	
	public Boolean tc30_Blondel_verifyRangesAndScalingForEnergyStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		/*
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		*/
		
		
		//Validations starts after edit Config
		//gestureUtils.mobileScroll("Ranges and Scaling", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		gestureUtils.mScroll("Ranges and Scaling","Ranges and Scaling", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Ranges and Scaling", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, "Ranges and Scaling", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.enterVoltageRatio("20");
		fCCM174XSessionConfigObjectRepo.enterCurrentRatio("30");
		fCCM174XSessionConfigObjectRepo.enterAmpNeutralRatio("10");
		
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
		}
		else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		}
		
		gestureUtils.mScroll("Ranges and Scaling","Ranges and Scaling", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Ranges and Scaling", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, "Ranges and Scaling", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validation
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validateVoltageRatio("20.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 20.0V");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validateCurrentRatio("30.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 30.0V");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validateAmpNeutralRatio("10.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 10.0V");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		
		
		
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		/*
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		*/
		return true;
		
	}
	
	public Boolean tc31_Blondel_verifyMainSignalingVoltageForEnergyStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		/*
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		*/
		
		
		//Validation starts after edit
		gestureUtils.mScroll("Mains Signalling Voltages","Mains Signaling Voltages", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Mains Signalling Voltages", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, "Mains Signaling Voltages", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		
		fCCM174XSessionConfigObjectRepo.enter_Freq1_ForMainSignalingVoltage("100");
		fCCM174XSessionConfigObjectRepo.enter_Freq2_ForMainSignalingVoltage("200");
		
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
		}
		else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOnBackButton();
			CommonUtils.wait(2);
		}
		
		//validation
		gestureUtils.mScroll("Harmonics Measurements Mode","Harmonics Measurement Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		
		//gestureUtils.mobileScroll("Harmonics Measurements Mode", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		try
		{
			if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("100.0Hz,200.0Hz"));
				CommonUtils.wait(1);
			}
			
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 100.0Hz,200.0Hz");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Mains Signalling Voltages", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, "Mains Signaling Voltages", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_Freq1_ForMainSigVoltage("100.0"));
				CommonUtils.wait(1);
			}
			else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_Freq1_ForMainSigVoltage("100"));
				CommonUtils.wait(1);
			}
			
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 100.0");
			testFailureFlag = true;
		}
		
		try
		{
			if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_Freq2_ForMainSigVoltage("200.0"));
				CommonUtils.wait(1);
			}
			else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_Freq2_ForMainSigVoltage("200"));
				CommonUtils.wait(1);
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 200.0");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		/*
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		*/
		
		return true;
	}
	
	public Boolean tc32_Blondel_verifyHamonicMeasurementModeForEnergyStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		/*
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		*/
		
		//Validation starts after edit
		gestureUtils.mScroll("Harmonics Measurements Mode","Harmonics Measurement Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Harmonics Measurement Mode", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validating Components radio button
		fCCM174XSessionConfigObjectRepo.clickOn_Components_RadioButton();
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
		}
		else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOnBackButton();
			CommonUtils.wait(2);
		}
		
		//gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		gestureUtils.mScroll("Flicker - Lamp Model","Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Components"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Components");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Harmonics Measurement Mode", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_Components_isSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Components radio button is not selected");
			testFailureFlag = true;
		}
		
		
		//Validating Grouped radio button
		fCCM174XSessionConfigObjectRepo.clickOn_Grouped_RadioButton();
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
		}
		else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOnBackButton();
			CommonUtils.wait(2);
		}
		
		gestureUtils.mScroll("Flicker - Lamp Model","Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Grouped"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Grouped");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Harmonics Measurement Mode", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_Grouped_isSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Grouped radio button is not selected");
			testFailureFlag = true;
		}
		
		
		//Validating SubGrouped radio button
		fCCM174XSessionConfigObjectRepo.clickOn_SubGrouped_RadioButton();
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
		}
		else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOnBackButton();
			CommonUtils.wait(2);
		}
		
		gestureUtils.mScroll("Flicker - Lamp Model","Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		
		try
		{
			if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Sub Grouped"));
				CommonUtils.wait(1);
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Subgrouped"));
				CommonUtils.wait(1);
			}
			
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Sub Grouped");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Harmonics Measurement Mode", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_SubGrouped_isSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("SubGrouped radio button is not selected");
			testFailureFlag = true;
		}
		
		
		//Validating IncludeInterHarmonics checkbox
		fCCM174XSessionConfigObjectRepo.check_IncludeInterHarmonics_checkbox();
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
		}
		else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOnBackButton();
			CommonUtils.wait(2);
		}
		
		gestureUtils.mScroll("Flicker - Lamp Model","Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Harmonics Measurement Mode", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_IncludeInterHarmonics_isCheckBoxSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Include Inter Harmonics checkbox is not selected");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		/*
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		*/
		return true;
	}
	
	public Boolean tc33_Blondel_verifyFlickerLampModelForEnergyStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		/*
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
	
		*/
		
		//Validation starts after edit
		String iOS_FlickerLampModel = null;
		gestureUtils.mScroll("Flicker - Lamp Model","Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Flicker - Lamp Model", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.choose_FlickerLampModelVoltage("100 V");
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
		}
		else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOnBackButton();
			CommonUtils.wait(1);
		}
	    
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			gestureUtils.mScroll("Flicker - Lamp Model","Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Flicker - Lamp Model", LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
			iOS_FlickerLampModel= fCCM174XSessionConfigObjectRepo.getSelectedFlickerLampModelValueForiOS();

			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
		}
		
		
		
		gestureUtils.mScroll("Events: Triggers and Limits","Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		
		//Validation
		try
		{
			if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("100V"));
				CommonUtils.wait(1);
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchForValue("Flicker - Lamp Model",iOS_FlickerLampModel));
				CommonUtils.wait(1);
			}
			
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 100V");
			testFailureFlag = true;
		}
		
		gestureUtils.mScroll("Flicker - Lamp Model","Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Flicker - Lamp Model", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("100 V"));
				CommonUtils.wait(1);
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchUsingName(iOS_FlickerLampModel));
				CommonUtils.wait(1);
			}
			
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 100 V");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		/*
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		*/
		return true;
		
	}

	
	
	
	public Boolean tc34_Blondel_verifyEventTriggerAndLimitsForDipEvent(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		/*
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		*/
		
		
		//Validation starts after edit
		gestureUtils.mScroll("Events: Triggers and Limits","Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.clickOnDipSledingReferenceCheckbox();
		fCCM174XSessionConfigObjectRepo.clickAndEditDipLimitEditBox("80");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mScroll("Events: Triggers and Limits","Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mScroll("Swell","Swell", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkDipAndSwellCheckboxes());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Dip and Swell checkboxes are not checked, Expected : Both should be checked");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditDipLimitEditBoxValue("80.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 80.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to dip edit box value to 90.0
		fCCM174XSessionConfigObjectRepo.uncheckDipSledingReferenceCheckbox();
		fCCM174XSessionConfigObjectRepo.clickAndEditDipLimitEditBox("90");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		/*
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		*/
		return true;
	}

	public Boolean tc35_Blondel_verifyEventTriggerAndLimitsForSwellEvent(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		/*
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		*/
		
		//Validation starts after edit
		gestureUtils.mScroll("Events: Triggers and Limits","Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnSwellSledingReferenceCheckbox();
		fCCM174XSessionConfigObjectRepo.clickAndEditSwellLimitEditBox("100");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		//Validation
		gestureUtils.mScroll("Events: Triggers and Limits","Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mScroll("Interruption","Interruptions", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkDipAndSwellCheckboxes());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Dip and Swell checkboxes are not checked, Expected : Both should be checked");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditSwellLimitEditBoxValue("100.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 100.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to swell edit box value to 110
		fCCM174XSessionConfigObjectRepo.uncheckSwellSledingReferenceCheckbox();
		fCCM174XSessionConfigObjectRepo.clickAndEditSwellLimitEditBox("110");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		/*
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		*/
		return true;
	}

	public Boolean tc36_Blondel_verifyEventTriggerAndLimitsForInterruptionEvent(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		/*
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		*/
		
		//Validation starts after edit
		gestureUtils.mScroll("Events: Triggers and Limits","Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mScroll("Rapid Voltage Changes","Rapid Voltage Changes", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		
		fCCM174XSessionConfigObjectRepo.clickAndEditInterruptionLimitEditBox("10");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mScroll("Events: Triggers and Limits","Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mScroll("Rapid Voltage Changes","Rapid Voltage Changes", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditInterruptionLimitEditBoxValue("10.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 10.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to default values
		gestureUtils.mScroll("Set to Defaults","SET TO DEFAULTS", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Set to Defaults", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "SET TO DEFAULTS", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(3);
	
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		/*
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		*/
		
		return true;
	}

	public Boolean tc37_Blondel_verifyEventTriggerAndLimitsForRapidVoltageChangesEvent(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		/*
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		*/
		
		//Validation starts after edit
		gestureUtils.mScroll("Events: Triggers and Limits","Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mScroll("Mains Signalling Voltages","Mains Signalling", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		
		fCCM174XSessionConfigObjectRepo.clickAndEditRapidVoltageChangesLimitEditBox("10");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mScroll("Events: Triggers and Limits","Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mScroll("Mains Signalling Voltages","Mains Signalling", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkRapidVoltageChangesCheckboxes());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Rapid Voltage Changes trigger ON checkbox is not checked, Expected : check box should be checked");
			testFailureFlag = true;
		}
		
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditRapidVoltageChangesLimitEditBoxValue("10.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 10.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to default values
		
		gestureUtils.mScroll("Set to Defaults","SET TO DEFAULTS", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Set to Defaults", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "SET TO DEFAULTS", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(3);
	
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		/*
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		*/
		return true;
	}

	public Boolean tc38_Blondel_verifyEventTriggerAndLimitsForMainsSignallingEvent(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		/*
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		*/
		
		//Validation starts after edit
		gestureUtils.mScroll("Events: Triggers and Limits","Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mScroll("Waveform Deviation","Waveform Deviation", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		
		fCCM174XSessionConfigObjectRepo.clickAndEditMainsSignallingVoltagesLimitsEditBox("20");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mScroll("Events: Triggers and Limits","Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mScroll("Waveform Deviation","Waveform Deviation", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
			
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkMainsSignallingVoltagesCheckboxes());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Mains Signalling Voltages trigger ON checkbox is not checked, Expected : check box should be checked");
			testFailureFlag = true;
		}
		
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditMainsSignallingVoltagesLimitEditBoxValue("20.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 20.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to default values
		
		gestureUtils.mScroll("Set to Defaults","SET TO DEFAULTS", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Set to Defaults", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "SET TO DEFAULTS", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(3);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		/*
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		*/
		return true;
	}

	public Boolean tc39_Blondel_verifyEventTriggerAndLimitsForWaveformDeviationEvent(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		/*
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		*/
		
		//Validation starts after edit
		gestureUtils.mScroll("Events: Triggers and Limits","Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mScroll("Inrush Current","Inrush Current", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
				
		fCCM174XSessionConfigObjectRepo.clickAndEditWaveformDeviationLimitsEditBox("20");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mScroll("Events: Triggers and Limits","Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mScroll("Inrush Current","Inrush Current", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
			
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkWaveformDeviationCheckbox());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Waveform Deviation trigger ON checkbox is not checked, Expected : check box should be checked");
			testFailureFlag = true;
		}
		
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditWaveformDeviationLimitEditBoxValue("20.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 20.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to default values
		gestureUtils.mScroll("Set to Defaults","SET TO DEFAULTS", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Set to Defaults", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "SET TO DEFAULTS", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(3);
	
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		/*
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		*/
		return true;
	}

	public Boolean tc40_Blondel_verifyEventTriggerAndLimitsForInrushCurrentEvent(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		/*
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		*/
		
		
		//Validation starts after edit
		gestureUtils.mScroll("Events: Triggers and Limits","Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mScroll("Set to Defaults","SET TO DEFAULTS", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		
		fCCM174XSessionConfigObjectRepo.clickAndEditInrushCurrentLimitsEditBox("100");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mScroll("Events: Triggers and Limits","Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mScroll("Set to Defaults","SET TO DEFAULTS", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkInrushCurrentCheckbox());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Inrush Current trigger ON checkbox is not checked, Expected : check box should be checked");
			testFailureFlag = true;
		}
		
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditInrushCurrentLimitEditBoxValue("100.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 100.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to default values
		
		gestureUtils.mScroll("Set to Defaults","SET TO DEFAULTS", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Set to Defaults", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "SET TO DEFAULTS", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(3);
	
	
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		/*
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		*/
		return true;
	}

	
	
	
	
	
	public Boolean tc41_Blondel_verifyIntervalsForEnergyStudy(String pqTool, String ssid174X, String flukeWIFI, String randomConfigName) throws Exception
	{
		/*
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		*/
		//Validation starts after edit
		gestureUtils.mScroll("Intervals","Intervals (Trend, Demand)", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Intervals", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Intervals (Trend, Demand)", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.clickOn_TrendIntervalDropdown();
		String trendInterval_3rdItem =fCCM174XSessionConfigObjectRepo.clickOn_TrendInterval_listItem();
		fCCM174XSessionConfigObjectRepo.clickOn_DemandIntervalDropdown();
		String demandInterval_3rdItem = fCCM174XSessionConfigObjectRepo.clickOn_DemandInterval_listItem();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		gestureUtils.mScroll("AUX Probes","AUX Probes", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
				
		//Trend :1 minutes, Demand :15 minutes
		String selectedIntervals = "Trend :"+trendInterval_3rdItem+", Demand :"+demandInterval_3rdItem;
		
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(selectedIntervals));
				CommonUtils.wait(1);
			}
			
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Actual text:"+selectedIntervals);
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Intervals", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Intervals (Trend, Demand)", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(trendInterval_3rdItem));
				CommonUtils.wait(1);
			}
			else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchForValue(trendInterval_3rdItem));
				CommonUtils.wait(1);
			}
			
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Actual text:"+trendInterval_3rdItem);
			testFailureFlag = true;
		}
		
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(demandInterval_3rdItem));
				CommonUtils.wait(1);
			}
			else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchForValue(demandInterval_3rdItem));
				CommonUtils.wait(1);
			}
			
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Actual text:"+demandInterval_3rdItem);
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		}
		
		//gestureUtils.mobileScroll("Previous Configurations", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		//ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Previous Configurations", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		//CommonUtils.wait(1);
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, randomConfigName, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	
	//Load study- During config creation
	
	public Boolean tc42_Blondel_verifyConfigNameAndDescriptionForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		}	
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		
		//Validations starts after edit Config
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			gestureUtils.mobileScroll("Config Name and Desc", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			gestureUtils.mobileScroll("Configuration Name & Description", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Config Name and Desc", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, "Configuration Name & Description", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, randomConfigName, LocatorStrategy.NONE, null).clear();
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_XPATH, "//android.widget.EditText", LocatorStrategy.IOS_LOCATOR_STRATEGY_XPATH, "//XCUIElementTypeTextField", LocatorStrategy.NONE, null).sendKeys(randomConfigName+"_abcd");
		fCCM174XSessionConfigObjectRepo.enter_Text_In_DescriptionBox("abcd");
		
		
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOnBackButton();
			CommonUtils.wait(2);
		}
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
		}
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_Done_with_Configuration_Button();
		CommonUtils.wait(1);
	
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		}
		
		else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			gestureUtils.mobileScroll("Previous Configurations", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Previous Configurations", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
		}
		
		
		gestureUtils.mobileScroll(randomConfigName+"_abcd", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName+"_abcd", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, randomConfigName+"_abcd", LocatorStrategy.NONE, null).click();
	
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		
		//Validations starts after edit Config
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			gestureUtils.mobileScroll("Config Name and Desc", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			gestureUtils.mobileScroll("Configuration Name & Description", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Config Name and Desc", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, "Configuration Name & Description", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validation check edited config name
		try
		{
			Assert.assertEquals(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_XPATH, "//android.widget.EditText", LocatorStrategy.IOS_LOCATOR_STRATEGY_XPATH, "//XCUIElementTypeTextField", LocatorStrategy.NONE, null).getText(), randomConfigName+"_abcd");
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered config name is not displayed, Expected Config name: "+randomConfigName+"_abcd");
			testFailureFlag = true;
		}
		
		//Validation check edited config description
		
		try
		{
			Assert.assertEquals(fCCM174XSessionConfigObjectRepo.get_Text_FromDescriptionBox(), "abcd");
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered config name description is not displayed properly, Expected Config name: abcd");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		}
		
		//gestureUtils.mobileScroll("Previous Configurations", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		//ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Previous Configurations", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		//CommonUtils.wait(1);
		gestureUtils.mobileScroll(randomConfigName+"_abcd", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName+"_abcd", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, randomConfigName+"_abcd", LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc43_Blondel_verifyStandardForLoadStudy(String pqTool, String ssid174X, String flukeWIFI, String randomConfigName) throws Exception
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
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		}	
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		/*
		//fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		//CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		}
		*/
		
		/*
		//gestureUtils.mobileScroll("Previous Configurations", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		//ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Previous Configurations", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		//CommonUtils.wait(1);
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, randomConfigName, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		*/
		return true;
	}
	
	//Dont run , TC-44 same as TC-28 and TC-13
	public Boolean tc44_Blondel_verifyTopologyAndPhaseColorForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		
		/*
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		*/
		
		gestureUtils.mobileScroll("Nominal Voltage and Frequency", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Study Type, Topology and Phase Colors", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.changeStudyTypeFromEditDropdown("Energy Study");
		fCCM174XSessionConfigObjectRepo.changeTopologyFromEditDropdown("High Leg Delta");
		fCCM174XSessionConfigObjectRepo.changePhaseColourFromEditDropdown("Europe");
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		gestureUtils.mobileScroll("Nominal Voltage and Frequency", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		CommonUtils.wait(1);
		
		//Validating updated Study type, Topology and Phase colour
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Energy Study"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Energy Study");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("High Leg Delta"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: High Leg Delta");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Study Type, Topology and Phase Colors", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Europe"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Europe");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		/*
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		*/
		
		return true;
	}
	
	public Boolean tc45_Blondel_verifyNominalVoltageAndFrequencyForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		/*
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		*/
		
		//Validations starts after edit Config
		//gestureUtils.mobileScroll("Ranges and Scaling", Config.IOS_LOCATOR_STRATEGY_ID, ScrollDiection.DOWN);
		gestureUtils.mScroll("Ranges and Scaling","Ranges and Scaling", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Nominal Voltage and Frequency", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Nominal Voltage and Frequency", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.clickOnNominalVoltage_Dropdown();
		String iOS_NominalVoltage = null;
		String iOS_NominalFrequency = null;
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			gestureUtils.mScroll("Custom Value", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Custom Value", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
			fCCM174XSessionConfigObjectRepo.enterCustomNominalVoltage("500");
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
		    iOS_NominalVoltage = fCCM174XSessionConfigObjectRepo.getNominalVoltage();
			
		}
			
		fCCM174XSessionConfigObjectRepo.clickOnNominalFrequency_Dropdown();
		
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "60 Hz", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
			iOS_NominalFrequency = fCCM174XSessionConfigObjectRepo.getNominalFrequency();
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		//validation
		//gestureUtils.mobileScroll("Ranges and Scaling", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		gestureUtils.mScroll("Ranges and Scaling","Ranges and Scaling", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		//gestureUtils.mScroll(null, "Ranges and Scaling", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.NONE, ScrollDiection.DOWN);
		//gestureUtils.scroll(ScrollDiection.DOWN, "");
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("500.0V, 60Hz"));
				CommonUtils.wait(1);
			}
			else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(iOS_NominalVoltage+" "+iOS_NominalFrequency));
				CommonUtils.wait(1);
			}
			
		}
		catch(Throwable e)
		{
			Assert.fail("Nominal voltage and frequency not set or not displayed properly");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Nominal Voltage and Frequency", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Nominal Voltage and Frequency", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("500.0"));
				CommonUtils.wait(1);
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(iOS_NominalVoltage));
				CommonUtils.wait(1);
			}
			
		}
		catch(Throwable e)
		{
			Assert.fail("Nominal voltage is not showing correctly or not set correctly");
			testFailureFlag = true;
		}
		
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("60 Hz"));
				CommonUtils.wait(1);
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(iOS_NominalFrequency));
				CommonUtils.wait(1);
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Nominal frequency is not showing correctly or not set correctly");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		/*
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		*/
		return true;
	}

	public Boolean tc46_Blondel_verifyRangesAndScalingForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		/*
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		*/
		
		//Validations starts after edit Config
		//gestureUtils.mobileScroll("Ranges and Scaling", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		gestureUtils.mScroll("Ranges and Scaling","Ranges and Scaling", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Ranges and Scaling", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, "Ranges and Scaling", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Checking voltage section is not present because of Load study
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchTextNOTPresent("Voltage"));
			CommonUtils.wait(1);
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchTextNOTPresent("voltage"));
		}
		catch(Throwable e)
		{
			Assert.fail("Voltage section is present, Expected is Voltage should not be present for Load study");
			testFailureFlag = true;
		}
		
		fCCM174XSessionConfigObjectRepo.enterCurrentRatioForLoad("30");
		fCCM174XSessionConfigObjectRepo.enterAmpNeutralRatioForLoad("10");
		
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
		}
		else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		}
		
		gestureUtils.mScroll("Ranges and Scaling","Ranges and Scaling", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Ranges and Scaling", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, "Ranges and Scaling", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validation
		
		try
		{
			if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validateCurrentRatio("30.0"));
				CommonUtils.wait(1);
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validateVoltageRatio("30.0"));
				CommonUtils.wait(1);
			}
			
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 30.0V");
			testFailureFlag = true;
		}
		
		try
		{
			if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validateAmpNeutralRatio("10.0"));
				CommonUtils.wait(1);
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validateCurrentRatio("10.0"));
				CommonUtils.wait(1);
			}
			
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 10.0V");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		/*
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		*/
		return true;
	}
	
	public Boolean tc47_Blondel_verifyMainSignalingVoltagesForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		/*
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
	*/
		//Validation starts after edit
		gestureUtils.mScroll("Mains Signalling Voltages","Mains Signaling Voltages", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Mains Signalling Voltages", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, "Mains Signaling Voltages", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Harmonics Measurements Mode"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Mains Signalling Voltages section is clickable, Expected is in Load study Mains Signalling Voltages section should be disabled");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
	
		/*
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		*/
		return true;
	}
	
	public Boolean tc48_Blondel_verifyHarmonicsMeasurementModeForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		/*
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		*/
		
		//Validation starts after edit
		gestureUtils.mScroll("Harmonics Measurements Mode","Harmonics Measurement Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Harmonics Measurement Mode", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validating Components radio button
		fCCM174XSessionConfigObjectRepo.clickOn_Components_RadioButton();
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
		}
		else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOnBackButton();
			CommonUtils.wait(2);
		}
		
		//gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		gestureUtils.mScroll("Flicker - Lamp Model","Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Components"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Components");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Harmonics Measurement Mode", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_Components_isSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Components radio button is not selected");
			testFailureFlag = true;
		}
		
		
		//Validating Grouped radio button
		fCCM174XSessionConfigObjectRepo.clickOn_Grouped_RadioButton();
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
		}
		else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOnBackButton();
			CommonUtils.wait(2);
		}
		
		gestureUtils.mScroll("Flicker - Lamp Model","Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Grouped"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Grouped");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Harmonics Measurement Mode", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_Grouped_isSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Grouped radio button is not selected");
			testFailureFlag = true;
		}
		
		
		//Validating SubGrouped radio button
		fCCM174XSessionConfigObjectRepo.clickOn_SubGrouped_RadioButton();
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
		}
		else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOnBackButton();
			CommonUtils.wait(2);
		}
		
		gestureUtils.mScroll("Flicker - Lamp Model","Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		
		try
		{
			if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Sub Grouped"));
				CommonUtils.wait(1);
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Subgrouped"));
				CommonUtils.wait(1);
			}
			
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Sub Grouped");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Harmonics Measurement Mode", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_SubGrouped_isSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("SubGrouped radio button is not selected");
			testFailureFlag = true;
		}
		
		
		//Validating IncludeInterHarmonics checkbox
		fCCM174XSessionConfigObjectRepo.check_IncludeInterHarmonics_checkbox();
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
		}
		else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOnBackButton();
			CommonUtils.wait(2);
		}
		
		gestureUtils.mScroll("Flicker - Lamp Model","Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Harmonics Measurement Mode", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_IncludeInterHarmonics_isCheckBoxSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Include Inter Harmonics checkbox is not selected");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		/*
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		*/
		return true;
	}

	public Boolean tc49_Blondel_verifyFlickerLampModelForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		/*
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
	
		*/
		
		//Validation starts after edit
		String iOS_FlickerLampModel = null;
		gestureUtils.mScroll("Flicker - Lamp Model","Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Flicker - Lamp Model", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Flicker - Lamp Model"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Flicker Lamp Model section is clickable, Expected is in Load study Flicker Lamp Model section should be disabled");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
	
		/*
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		*/
		
		return true;
	}
	
	public Boolean tc50_Blondel_verifyEventTriggersAndLimitsForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		/*
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
	
		*/
		
		//Validation starts after edit
		gestureUtils.mScroll("Events: Triggers and Limits","Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Events: Triggers and Limits"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Events: Triggers and Limits section is clickable, Expected is in Load study Events: Triggers and Limits section should be disabled");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
	
		/*
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		*/
		return true;
	}
	
	public Boolean tc51_Blondel_verifyIntervalsForLoadStudy(String pqTool, String ssid174X, String flukeWIFI, String randomConfigName) throws Exception
	{
		/*
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		*/
		
		gestureUtils.mScroll("Intervals","Intervals (Trend, Demand)", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Intervals", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Intervals (Trend, Demand)", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.clickOn_TrendIntervalDropdown();
		String trendInterval_3rdItem =fCCM174XSessionConfigObjectRepo.clickOn_TrendInterval_listItem();
		//fCCM174XSessionConfigObjectRepo.clickOn_DemandIntervalDropdown();
		//String demandInterval_3rdItem = fCCM174XSessionConfigObjectRepo.clickOn_DemandInterval_listItem();
		//fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		gestureUtils.mScroll("AUX Probes","AUX Probes", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Intervals", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "Intervals (Trend, Demand)", LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(trendInterval_3rdItem));
				CommonUtils.wait(1);
			}
			else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchForValue(trendInterval_3rdItem));
				CommonUtils.wait(1);
			}
			
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Actual text:"+trendInterval_3rdItem);
			testFailureFlag = true;
		}
		
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		}
		
		
		
		//gestureUtils.mobileScroll("Previous Configurations", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		//ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Previous Configurations", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		//CommonUtils.wait(1);
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, randomConfigName, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc52_Blondel_verifyEditConfigNameAndDescriptionForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception

	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOn_ViewMore_Link();
		
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		
		//Validations starts after edit Config
		gestureUtils.mobileScroll("Config Name and Desc", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Config Name and Desc", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).clear();
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "title", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).sendKeys(randomConfigName+"_abcd");
		fCCM174XSessionConfigObjectRepo.enter_Text_In_DescriptionBox("abcd");
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Config Name and Desc", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validation check edited config name
		try
		{
			Assert.assertEquals(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "title", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).getText(), randomConfigName+"_abcd");
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered config name is not displayed, Expected Config name: "+randomConfigName+"_abcd");
			testFailureFlag = true;
		}
		
		//Validation check edited config description
		
		try
		{
			Assert.assertEquals(fCCM174XSessionConfigObjectRepo.get_Text_FromDescriptionBox(), "abcd");
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered config name description is not displayed properly, Expected Config name: abcd");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName+"_abcd", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName+"_abcd", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
		
	public Boolean tc53_Blondel_verifyEditStudyTypeForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception

	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOn_ViewMore_Link();
		
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		//validation
		gestureUtils.mobileScroll("Study Type, Topology and Phase Colors", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("None"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: None");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Standard", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Study Type, Topology and Phase Colors"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Standard tab is clickable, expected is Standard tab should not be clickable");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
		
	public Boolean tc54_Blondel_verifyEditStudyTypeTopologyPhaseColorForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception

	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOn_ViewMore_Link();
		
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		//Validation
		gestureUtils.mobileScroll("Nominal Voltage and Frequency", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Study Type, Topology and Phase Colors", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.changeStudyTypeFromEditDropdown("Energy Study");
		fCCM174XSessionConfigObjectRepo.changeTopologyFromEditDropdown("High Leg Delta");
		fCCM174XSessionConfigObjectRepo.changePhaseColourFromEditDropdown("Europe");
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		gestureUtils.mobileScroll("Nominal Voltage and Frequency", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		CommonUtils.wait(1);
		
		//Validating updated Study type, Topology and Phase colour
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Energy Study"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Energy Study");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("High Leg Delta"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: High Leg Delta");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Study Type, Topology and Phase Colors", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Europe"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Europe");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
			
	public Boolean tc55_Blondel_verifyEditNominalVoltageAndFrequencyForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception

	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOn_ViewMore_Link();
		
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		
		//Validations starts after edit Config
		gestureUtils.mobileScroll("Nominal Voltage and Frequency", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Nominal Voltage and Frequency", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.clickOnNominalVoltage_Dropdown();
		Config.appWidthCenterFlag = true;
		gestureUtils.mScroll("Custom Value", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Custom Value", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.enterCustomNominalVoltage("500");
			
		fCCM174XSessionConfigObjectRepo.clickOnNominalFrequency_Dropdown();
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "60 Hz", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		
		//Validation
		gestureUtils.mobileScroll("Ranges and Scaling", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("500.0V, 60Hz"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 500.0V, 60Hz");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Nominal Voltage and Frequency", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("500.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 500.0V");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("60 Hz"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 60 Hz");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
		
	public Boolean tc56_Blondel_verifyEditRangesAndScalingForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception

	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOn_ViewMore_Link();
		
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		//Validations starts after edit Config
		gestureUtils.mobileScroll("Ranges and Scaling", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Ranges and Scaling", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Checking voltage section is not present because of Load study
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchTextNOTPresent("Voltage"));
			CommonUtils.wait(1);
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchTextNOTPresent("voltage"));
		}
		catch(Throwable e)
		{
			Assert.fail("Voltage section is present, Expected is Voltage should not be present for Load study");
			testFailureFlag = true;
		}
		
		fCCM174XSessionConfigObjectRepo.enterCurrentRatio("30");
		fCCM174XSessionConfigObjectRepo.enterAmpNeutralRatio("10");
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		gestureUtils.mobileScroll("Ranges and Scaling", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Ranges and Scaling", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validation
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validateCurrentRatio("30.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 30.0V");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validateAmpNeutralRatio("10.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 10.0V");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc57_Blondel_verifyEditMainSignallingVoltageForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception

	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOn_ViewMore_Link();
		
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Harmonics Measurements Mode", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Mains Signalling Voltages", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Harmonics Measurements Mode"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Mains Signalling Voltages section is clickable, Expected is in Load study Mains Signalling Voltages section should be disabled");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
	
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
		
	public Boolean tc58_Blondel_verifyEditHarmonicsMeasurementModeForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception

	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOn_ViewMore_Link();
		
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Harmonics Measurements Mode", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validating Components radio button
		fCCM174XSessionConfigObjectRepo.clickOn_Components_RadioButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Components"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Components");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_Components_isSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Components radio button is not selected");
			testFailureFlag = true;
		}
		
		
		//Validating Grouped radio button
		fCCM174XSessionConfigObjectRepo.clickOn_Grouped_RadioButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Grouped"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Grouped");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_Grouped_isSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Grouped radio button is not selected");
			testFailureFlag = true;
		}
		
		
		//Validating SubGrouped radio button
		fCCM174XSessionConfigObjectRepo.clickOn_SubGrouped_RadioButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Sub Grouped"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Sub Grouped");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_SubGrouped_isSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("SubGrouped radio button is not selected");
			testFailureFlag = true;
		}
		
		
		//Validating IncludeInterHarmonics checkbox
		fCCM174XSessionConfigObjectRepo.check_IncludeInterHarmonics_checkbox();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_IncludeInterHarmonics_isCheckBoxSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Include Inter Harmonics checkbox is not selected");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc59_Blondel_verifyEditFlickerLampModelForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception

	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOn_ViewMore_Link();
		
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Events: Triggers and Limits"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Flicker Lamp Model section is clickable, Expected is in Load study Flicker Lamp Model section should be disabled");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
	
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc60_Blondel_verifyEditEventsTriggersAndLimitsForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception

	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOn_ViewMore_Link();
		
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Intervals", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Intervals"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Events: Triggers and Limits section is clickable, Expected is in Load study Events: Triggers and Limits section should be disabled");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
	
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc61_Blondel_verifyEditIntervalsForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception

	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOn_ViewMore_Link();
		
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Intervals", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Intervals", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_TrendIntervalDropdown();
		String trendInterval_3rdItem =fCCM174XSessionConfigObjectRepo.clickOn_TrendInterval_listItem();
		fCCM174XSessionConfigObjectRepo.clickOn_DemandIntervalDropdown();
		String demandInterval_1stItem = fCCM174XSessionConfigObjectRepo.clickOn_DemandIntervalLoadStudy_listItem();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll("AUX Probes", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		//Trend :1 minutes, Demand :15 minutes
		String selectedIntervals = "Trend :"+trendInterval_3rdItem+", Demand :"+demandInterval_1stItem;
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(selectedIntervals));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Actual text:"+selectedIntervals);
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Intervals", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(trendInterval_3rdItem));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Actual text:"+trendInterval_3rdItem);
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(demandInterval_1stItem));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Actual text:"+demandInterval_1stItem);
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	


	
	//EN50160 Standard: Energy study tests
	public Boolean tc62_Blondel_verifyEditConfigNameAndDescriptionForEN50160(String pqTool, String ssid174X, String flukeWIFI) throws Exception

	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		fCCM174XSessionConfigObjectRepo.clickOn_EN50160_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOn_ViewMore_Link();
		
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		
		//Validations starts after edit Config
		gestureUtils.mobileScroll("Config Name and Desc", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Config Name and Desc", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).clear();
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "title", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).sendKeys(randomConfigName+"_abcd");
		fCCM174XSessionConfigObjectRepo.enter_Text_In_DescriptionBox("abcd");
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Config Name and Desc", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validation check edited config name
		try
		{
			Assert.assertEquals(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "title", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).getText(), randomConfigName+"_abcd");
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered config name is not displayed, Expected Config name: "+randomConfigName+"_abcd");
			testFailureFlag = true;
		}
		
		//Validation check edited config description
		
		try
		{
			Assert.assertEquals(fCCM174XSessionConfigObjectRepo.get_Text_FromDescriptionBox(), "abcd");
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered config name description is not displayed properly, Expected Config name: abcd");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName+"_abcd", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName+"_abcd", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
		
	public Boolean tc63_Blondel_verifyEditStudyTypeTopologyPhaseColourForEN50160(String pqTool, String ssid174X, String flukeWIFI) throws Exception

	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		fCCM174XSessionConfigObjectRepo.clickOn_EN50160_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		
		//Validations starts after edit Config
		gestureUtils.mobileScroll("Study Type, Topology and Phase Colors", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Study Type, Topology and Phase Colors", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.changeStudyTypeFromEditDropdown("Load Study");
		fCCM174XSessionConfigObjectRepo.changeTopologyFromEditDropdown("High Leg Delta");
		fCCM174XSessionConfigObjectRepo.changePhaseColourFromEditDropdown("Europe");
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		gestureUtils.mobileScroll("Nominal Voltage and Frequency", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		CommonUtils.wait(1);
		
		//Validating updated Study type, Topology and Phase colour
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Load Study"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Load Study");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("High Leg Delta"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: High Leg Delta");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Study Type, Topology and Phase Colors", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Europe"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Europe");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc64_Blondel_verifyNominalVoltageAndFrequencyForEN50160(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		fCCM174XSessionConfigObjectRepo.clickOn_EN50160_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		Config.appWidthCenterFlag = true;
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		//Validations starts after edit Config
		gestureUtils.mobileScroll("Nominal Voltage and Frequency", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Nominal Voltage and Frequency", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.clickOnNominalVoltage_Dropdown();
		Config.appWidthCenterFlag = true;
		gestureUtils.mScroll("Custom Value", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Custom Value", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.enterCustomNominalVoltage("500");
			
		fCCM174XSessionConfigObjectRepo.clickOnNominalFrequency_Dropdown();
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "60 Hz", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		//validation
		gestureUtils.mobileScroll("Ranges and Scaling", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("500.0V, 60Hz"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 500.0V, 60Hz");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Nominal Voltage and Frequency", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("500.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 500.0V");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("60 Hz"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 60 Hz");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc65_Blondel_verifyRangesAndScalingForEN50160(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		fCCM174XSessionConfigObjectRepo.clickOn_EN50160_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		Config.appWidthCenterFlag = true;
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		//Validations starts after edit Config
		gestureUtils.mobileScroll("Ranges and Scaling", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Ranges and Scaling", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.enterVoltageRatio("20");
		fCCM174XSessionConfigObjectRepo.enterCurrentRatio("30");
		fCCM174XSessionConfigObjectRepo.enterAmpNeutralRatio("10");
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		gestureUtils.mobileScroll("Ranges and Scaling", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Ranges and Scaling", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validation
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validateVoltageRatio("20.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 20.0V");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validateCurrentRatio("30.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 30.0V");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validateAmpNeutralRatio("10.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 10.0V");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc66_Blondel_verifyMainSignalingVoltageForEN50160(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		fCCM174XSessionConfigObjectRepo.clickOn_EN50160_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		Config.appWidthCenterFlag = true;
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Mains Signalling Voltages", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Mains Signalling Voltages", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.enter_Freq1_ForMainSignalingVoltage("100");
		fCCM174XSessionConfigObjectRepo.enter_Freq2_ForMainSignalingVoltage("200");
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		//validation
		gestureUtils.mobileScroll("Harmonics Measurements Mode", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("100.0Hz,200.0Hz"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 100.0Hz,200.0Hz");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Mains Signalling Voltages", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_Freq1_ForMainSigVoltage("100.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 100.0");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_Freq2_ForMainSigVoltage("200.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 200.0");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc67_Blondel_verifyHarmonicMeasurementModeForEN50160(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		fCCM174XSessionConfigObjectRepo.clickOn_EN50160_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		Config.appWidthCenterFlag = true;
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Harmonics Measurements Mode", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validating Components radio button
		fCCM174XSessionConfigObjectRepo.clickOn_Components_RadioButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Components"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Components");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_Components_isSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Components radio button is not selected");
			testFailureFlag = true;
		}
		
		
		//Validating Grouped radio button
		fCCM174XSessionConfigObjectRepo.clickOn_Grouped_RadioButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Grouped"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Grouped");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_Grouped_isSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Grouped radio button is not selected");
			testFailureFlag = true;
		}
		
		
		//Validating SubGrouped radio button
		fCCM174XSessionConfigObjectRepo.clickOn_SubGrouped_RadioButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Sub Grouped"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Sub Grouped");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_SubGrouped_isSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("SubGrouped radio button is not selected");
			testFailureFlag = true;
		}
		
		
		//Validating IncludeInterHarmonics checkbox
		fCCM174XSessionConfigObjectRepo.check_IncludeInterHarmonics_checkbox();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_IncludeInterHarmonics_isCheckBoxSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Include Inter Harmonics checkbox is not selected");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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

	public Boolean tc68_Blondel_verifyFlickerLampModelForEN50160(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		fCCM174XSessionConfigObjectRepo.clickOn_EN50160_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		Config.appWidthCenterFlag = true;
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.choose_FlickerLampModelVoltage("100 V");
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
	
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		//Validation
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("100V"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 100V");
			testFailureFlag = true;
		}
		
		gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("100 V"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 100 V");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
		
	public Boolean tc69_Blondel_verifyEditEventTriggerAndLimitsForDipEventForEN50160(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		fCCM174XSessionConfigObjectRepo.clickOn_EN50160_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		Config.appWidthCenterFlag = true;
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnDipSledingReferenceCheckbox();
		fCCM174XSessionConfigObjectRepo.clickAndEditDipLimitEditBox("80");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll("Swell", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkDipAndSwellCheckboxes());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Dip and Swell checkboxes are not checked, Expected : Both should be checked");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditDipLimitEditBoxValue("80.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 80.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to dip edit box value to 90.0
		fCCM174XSessionConfigObjectRepo.uncheckDipSledingReferenceCheckbox();
		fCCM174XSessionConfigObjectRepo.clickAndEditDipLimitEditBox("90");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();

		
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		CommonUtils.wait(3);
		return true;
	}
	
	
	public Boolean tc70_Blondel_verifyEditEventTriggerAndLimitsForSwellEventForEN50160(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		fCCM174XSessionConfigObjectRepo.clickOn_EN50160_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		Config.appWidthCenterFlag = true;
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnSwellSledingReferenceCheckbox();
		fCCM174XSessionConfigObjectRepo.clickAndEditSwellLimitEditBox("100");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll("Interruption", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkDipAndSwellCheckboxes());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Dip and Swell checkboxes are not checked, Expected : Both should be checked");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditSwellLimitEditBoxValue("100.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 100.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to swell edit box value to 110
		fCCM174XSessionConfigObjectRepo.uncheckSwellSledingReferenceCheckbox();
		fCCM174XSessionConfigObjectRepo.clickAndEditSwellLimitEditBox("110");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();

		
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		CommonUtils.wait(3);
		return true;
	}
	
	
	public Boolean tc71_Blondel_verifyEditEventTriggerAndLimitsForInterruptionEventForEN50160(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		fCCM174XSessionConfigObjectRepo.clickOn_EN50160_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		Config.appWidthCenterFlag = true;
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mobileScroll("Rapid Voltage Changes", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		fCCM174XSessionConfigObjectRepo.clickAndEditInterruptionLimitEditBox("10");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll("Rapid Voltage Changes", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
	
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditInterruptionLimitEditBoxValue("10.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 10.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to default values
		
		gestureUtils.mobileScroll("Set to Defaults", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Set to Defaults", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
	
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		CommonUtils.wait(3);
		return true;
	}
	
	
	public Boolean tc72_Blondel_verifyEditEventTriggerAndLimitsForRapidVoltageChangesEventForEN50160(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		fCCM174XSessionConfigObjectRepo.clickOn_EN50160_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		Config.appWidthCenterFlag = true;
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mobileScroll("Mains Signalling Voltages", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		fCCM174XSessionConfigObjectRepo.clickAndEditRapidVoltageChangesLimitEditBox("10");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll("Mains Signalling Voltages", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
	
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkRapidVoltageChangesCheckboxes());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Rapid Voltage Changes trigger ON checkbox is not checked, Expected : check box should be checked");
			testFailureFlag = true;
		}
		
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditRapidVoltageChangesLimitEditBoxValue("10.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 10.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to default values
		
		gestureUtils.mobileScroll("Set to Defaults", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Set to Defaults", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
	
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		CommonUtils.wait(3);
		return true;
	}
	
	
	
	public Boolean tc73_Blondel_verifyEditEventTriggerAndLimitsForMainsSignallingEventForEN50160(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		fCCM174XSessionConfigObjectRepo.clickOn_EN50160_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		Config.appWidthCenterFlag = true;
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mobileScroll("Waveform Deviation", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		fCCM174XSessionConfigObjectRepo.clickAndEditMainsSignallingVoltagesLimitsEditBox("20");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll("Waveform Deviation", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
	
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkMainsSignallingVoltagesCheckboxes());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Mains Signalling Voltages trigger ON checkbox is not checked, Expected : check box should be checked");
			testFailureFlag = true;
		}
		
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditMainsSignallingVoltagesLimitEditBoxValue("20.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 20.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to default values
		
		gestureUtils.mobileScroll("Set to Defaults", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Set to Defaults", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
	
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		CommonUtils.wait(3);
		return true;
	}
	
	
	public Boolean tc74_Blondel_verifyEditEventTriggerAndLimitsForWaveformDeviationEventForEN50160(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		fCCM174XSessionConfigObjectRepo.clickOn_EN50160_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		Config.appWidthCenterFlag = true;
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mobileScroll("Inrush Current", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		fCCM174XSessionConfigObjectRepo.clickAndEditWaveformDeviationLimitsEditBox("20");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll("Inrush Current", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
	
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkWaveformDeviationCheckbox());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Waveform Deviation trigger ON checkbox is not checked, Expected : check box should be checked");
			testFailureFlag = true;
		}
		
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditWaveformDeviationLimitEditBoxValue("20.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 20.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to default values
		
		gestureUtils.mobileScroll("Set to Defaults", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Set to Defaults", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
	
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		CommonUtils.wait(3);
		return true;
	}
	
	
	
	public Boolean tc75_Blondel_verifyEditEventTriggerAndLimitsForInrushCurrentEventForEN50160(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		fCCM174XSessionConfigObjectRepo.clickOn_EN50160_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		Config.appWidthCenterFlag = true;
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mobileScroll("Set to Defaults", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		fCCM174XSessionConfigObjectRepo.clickAndEditInrushCurrentLimitsEditBox("100");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll("Set to Defaults", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
	
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkInrushCurrentCheckbox());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Inrush Current trigger ON checkbox is not checked, Expected : check box should be checked");
			testFailureFlag = true;
		}
		
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditInrushCurrentLimitEditBoxValue("100.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 100.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to default values
		
		gestureUtils.mobileScroll("Set to Defaults", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Set to Defaults", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
	
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		CommonUtils.wait(3);
		return true;
	}
	
	
	public Boolean tc76_Blondel_verifyEditingIntervalsForEN50160(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		fCCM174XSessionConfigObjectRepo.clickOn_EN50160_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		Config.appWidthCenterFlag = true;
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Intervals", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Intervals", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_TrendIntervalDropdown();
		String trendInterval_3rdItem =fCCM174XSessionConfigObjectRepo.clickOn_TrendInterval_listItem();
		fCCM174XSessionConfigObjectRepo.clickOn_DemandIntervalDropdown();
		String demandInterval_3rdItem = fCCM174XSessionConfigObjectRepo.clickOn_DemandInterval_listItem();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll("AUX Probes", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		//Trend :1 minutes, Demand :15 minutes
		String selectedIntervals = "Trend :"+trendInterval_3rdItem+", Demand :"+demandInterval_3rdItem;
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(selectedIntervals));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Actual text:"+selectedIntervals);
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Intervals", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(trendInterval_3rdItem));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Actual text:"+trendInterval_3rdItem);
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(demandInterval_3rdItem));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Actual text:"+demandInterval_3rdItem);
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	
	//Energy study- During config creation
	
	public Boolean tc77_Blondel_verifyConfigNameAndDescriptionForEnergyStudyForEN50160(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		fCCM174XSessionConfigObjectRepo.clickOn_EN50160_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		Config.appWidthCenterFlag = true;
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		
		gestureUtils.mobileScroll("Config Name and Desc", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Config Name and Desc", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		fCCM174XSessionConfigObjectRepo.enter_Text_In_DescriptionBox("abcd");
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Config Name and Desc", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validation config name
		try
		{
			Assert.assertEquals(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "title", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).getText(), randomConfigName);
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered config name is not displayed, Expected Config name: "+randomConfigName);
			testFailureFlag = true;
		}
		
		//Validation check edited config description
		
		try
		{
			Assert.assertEquals(fCCM174XSessionConfigObjectRepo.get_Text_FromDescriptionBox(), "abcd");
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered config name description is not displayed properly, Expected Config name: abcd");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc78_Blondel_verifyTopologyAndPhaseColorForEnergyStudyForEN50160(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		fCCM174XSessionConfigObjectRepo.clickOn_EN50160_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		Config.appWidthCenterFlag = true;
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		gestureUtils.mobileScroll("Nominal Voltage and Frequency", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Study Type, Topology and Phase Colors", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.changeStudyTypeFromEditDropdown("Energy Study");
		fCCM174XSessionConfigObjectRepo.changeTopologyFromEditDropdown("High Leg Delta");
		fCCM174XSessionConfigObjectRepo.changePhaseColourFromEditDropdown("Europe");
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		gestureUtils.mobileScroll("Nominal Voltage and Frequency", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		CommonUtils.wait(1);
		
		//Validating updated Study type, Topology and Phase colour
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Energy Study"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Energy Study");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("High Leg Delta"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: High Leg Delta");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Study Type, Topology and Phase Colors", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Europe"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Europe");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
		
	public Boolean tc79_Blondel_verifyNominalVoltageAndFrequencyForEnergyStudyForEN50160(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		fCCM174XSessionConfigObjectRepo.clickOn_EN50160_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		Config.appWidthCenterFlag = true;
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		//Validations starts after edit Config
		gestureUtils.mobileScroll("Nominal Voltage and Frequency", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Nominal Voltage and Frequency", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.clickOnNominalVoltage_Dropdown();
		Config.appWidthCenterFlag = true;
		gestureUtils.mScroll("Custom Value", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Custom Value", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.enterCustomNominalVoltage("500");
			
		fCCM174XSessionConfigObjectRepo.clickOnNominalFrequency_Dropdown();
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "60 Hz", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		//validation
		gestureUtils.mobileScroll("Ranges and Scaling", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("500.0V, 60Hz"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 500.0V, 60Hz");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Nominal Voltage and Frequency", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("500.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 500.0V");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("60 Hz"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 60 Hz");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc80_Blondel_verifyRangesAndScalingForEnergyStudyForEN50160(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		fCCM174XSessionConfigObjectRepo.clickOn_EN50160_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		Config.appWidthCenterFlag = true;
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		//Validations starts after edit Config
		gestureUtils.mobileScroll("Ranges and Scaling", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Ranges and Scaling", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.enterVoltageRatio("20");
		fCCM174XSessionConfigObjectRepo.enterCurrentRatio("30");
		fCCM174XSessionConfigObjectRepo.enterAmpNeutralRatio("10");
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		gestureUtils.mobileScroll("Ranges and Scaling", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Ranges and Scaling", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validation
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validateVoltageRatio("20.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 20.0V");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validateCurrentRatio("30.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 30.0V");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validateAmpNeutralRatio("10.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 10.0V");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc81_Blondel_verifyMainSignalingVoltageForEnergyStudyForEN50160(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		fCCM174XSessionConfigObjectRepo.clickOn_EN50160_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		Config.appWidthCenterFlag = true;
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Mains Signalling Voltages", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Mains Signalling Voltages", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.enter_Freq1_ForMainSignalingVoltage("100");
		fCCM174XSessionConfigObjectRepo.enter_Freq2_ForMainSignalingVoltage("200");
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		//validation
		gestureUtils.mobileScroll("Harmonics Measurements Mode", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("100.0Hz,200.0Hz"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 100.0Hz,200.0Hz");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Mains Signalling Voltages", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_Freq1_ForMainSigVoltage("100.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 100.0");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_Freq2_ForMainSigVoltage("200.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 200.0");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc82_Blondel_verifyHamonicMeasurementModeForEnergyStudyForEN50160(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		fCCM174XSessionConfigObjectRepo.clickOn_EN50160_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		Config.appWidthCenterFlag = true;
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Harmonics Measurements Mode", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validating Components radio button
		fCCM174XSessionConfigObjectRepo.clickOn_Components_RadioButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Sub Grouped"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Sub Grouped (EN50160)");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
	
		
		//Validating Grouped radio button
		fCCM174XSessionConfigObjectRepo.clickOn_Grouped_RadioButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Sub Grouped"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Sub Grouped(EN50160)");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
	
		//Validating SubGrouped radio button
		fCCM174XSessionConfigObjectRepo.clickOn_SubGrouped_RadioButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Sub Grouped"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Sub Grouped");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_SubGrouped_isSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("SubGrouped radio button is not selected");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc83_Blondel_verifyFlickerLampModelForEnergyStudyForEN50160(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		fCCM174XSessionConfigObjectRepo.clickOn_EN50160_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		Config.appWidthCenterFlag = true;
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
	
		//Validation starts after edit
		gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.choose_FlickerLampModelVoltage("100 V");
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
	
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		//Validation
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("100V"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 100V");
			testFailureFlag = true;
		}
		
		gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("100 V"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 100 V");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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

	
	
	
	
	
	public Boolean tc84_Blondel_verifyEventTriggerAndLimitsForDipEventForEN50160(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		fCCM174XSessionConfigObjectRepo.clickOn_EN50160_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		Config.appWidthCenterFlag = true;
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnDipSledingReferenceCheckbox();
		fCCM174XSessionConfigObjectRepo.clickAndEditDipLimitEditBox("80");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll("Swell", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkDipAndSwellCheckboxes());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Dip and Swell checkboxes are not checked, Expected : Both should be checked");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditDipLimitEditBoxValue("80.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 80.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to dip edit box value to 90.0
		fCCM174XSessionConfigObjectRepo.uncheckDipSledingReferenceCheckbox();
		fCCM174XSessionConfigObjectRepo.clickAndEditDipLimitEditBox("90");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
	
		
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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

	public Boolean tc85_Blondel_verifyEventTriggerAndLimitsForSwellEventForEN50160(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		fCCM174XSessionConfigObjectRepo.clickOn_EN50160_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		Config.appWidthCenterFlag = true;
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnSwellSledingReferenceCheckbox();
		fCCM174XSessionConfigObjectRepo.clickAndEditSwellLimitEditBox("100");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll("Interruption", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkDipAndSwellCheckboxes());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Dip and Swell checkboxes are not checked, Expected : Both should be checked");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditSwellLimitEditBoxValue("100.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 100.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to swell edit box value to 110
		fCCM174XSessionConfigObjectRepo.uncheckSwellSledingReferenceCheckbox();
		fCCM174XSessionConfigObjectRepo.clickAndEditSwellLimitEditBox("110");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
	
		
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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

	public Boolean tc86_Blondel_verifyEventTriggerAndLimitsForInterruptionEventForEN50160(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		fCCM174XSessionConfigObjectRepo.clickOn_EN50160_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		Config.appWidthCenterFlag = true;
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mobileScroll("Rapid Voltage Changes", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		fCCM174XSessionConfigObjectRepo.clickAndEditInterruptionLimitEditBox("10");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll("Rapid Voltage Changes", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
	
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditInterruptionLimitEditBoxValue("10.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 10.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to default values
		
		gestureUtils.mobileScroll("Set to Defaults", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Set to Defaults", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
	
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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

	public Boolean tc87_Blondel_verifyEventTriggerAndLimitsForRapidVoltageChangesEventForEN50160(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		fCCM174XSessionConfigObjectRepo.clickOn_EN50160_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		Config.appWidthCenterFlag = true;
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mobileScroll("Mains Signalling Voltages", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		fCCM174XSessionConfigObjectRepo.clickAndEditRapidVoltageChangesLimitEditBox("10");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll("Mains Signalling Voltages", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
	
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkRapidVoltageChangesCheckboxes());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Rapid Voltage Changes trigger ON checkbox is not checked, Expected : check box should be checked");
			testFailureFlag = true;
		}
		
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditRapidVoltageChangesLimitEditBoxValue("10.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 10.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to default values
		
		gestureUtils.mobileScroll("Set to Defaults", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Set to Defaults", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
	
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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

	public Boolean tc88_Blondel_verifyEventTriggerAndLimitsForMainsSignallingEventForEN50160(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		fCCM174XSessionConfigObjectRepo.clickOn_EN50160_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		Config.appWidthCenterFlag = true;
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mobileScroll("Waveform Deviation", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		fCCM174XSessionConfigObjectRepo.clickAndEditMainsSignallingVoltagesLimitsEditBox("20");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll("Waveform Deviation", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
	
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkMainsSignallingVoltagesCheckboxes());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Mains Signalling Voltages trigger ON checkbox is not checked, Expected : check box should be checked");
			testFailureFlag = true;
		}
		
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditMainsSignallingVoltagesLimitEditBoxValue("20.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 20.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to default values
		
		gestureUtils.mobileScroll("Set to Defaults", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Set to Defaults", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
	
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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

	public Boolean tc89_Blondel_verifyEventTriggerAndLimitsForWaveformDeviationEventForEN50160(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		fCCM174XSessionConfigObjectRepo.clickOn_EN50160_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		Config.appWidthCenterFlag = true;
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mobileScroll("Inrush Current", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		fCCM174XSessionConfigObjectRepo.clickAndEditWaveformDeviationLimitsEditBox("20");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll("Inrush Current", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
	
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkWaveformDeviationCheckbox());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Waveform Deviation trigger ON checkbox is not checked, Expected : check box should be checked");
			testFailureFlag = true;
		}
		
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditWaveformDeviationLimitEditBoxValue("20.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 20.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to default values
		
		gestureUtils.mobileScroll("Set to Defaults", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Set to Defaults", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
	
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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

	public Boolean tc90_Blondel_verifyEventTriggerAndLimitsForInrushCurrentEventForEN50160(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		fCCM174XSessionConfigObjectRepo.clickOn_EN50160_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		Config.appWidthCenterFlag = true;
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mobileScroll("Set to Defaults", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		fCCM174XSessionConfigObjectRepo.clickAndEditInrushCurrentLimitsEditBox("100");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll("Set to Defaults", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
	
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkInrushCurrentCheckbox());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Inrush Current trigger ON checkbox is not checked, Expected : check box should be checked");
			testFailureFlag = true;
		}
		
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditInrushCurrentLimitEditBoxValue("100.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 100.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to default values
		
		gestureUtils.mobileScroll("Set to Defaults", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Set to Defaults", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
	
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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

	
	
	
	
	
	public Boolean tc91_Blondel_verifyIntervalsForEnergyStudyForEN50160(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		fCCM174XSessionConfigObjectRepo.clickOn_EN50160_StandardType();
		fCCM174XSessionConfigObjectRepo.clickOn_StudyType_dropdown();
		fCCM174XSessionConfigObjectRepo.clickOn_ENERGYSTUDY_StudyType();
		fCCM174XSessionConfigObjectRepo.clickOn_Topology_dropdown();
		Config.appWidthCenterFlag = true;
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Intervals", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Intervals", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_TrendIntervalDropdown();
		String trendInterval_3rdItem =fCCM174XSessionConfigObjectRepo.clickOn_TrendInterval_listItem();
		fCCM174XSessionConfigObjectRepo.clickOn_DemandIntervalDropdown();
		String demandInterval_3rdItem = fCCM174XSessionConfigObjectRepo.clickOn_DemandInterval_listItem();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll("AUX Probes", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		
		String selectedIntervals = "Trend :"+trendInterval_3rdItem+", Demand :"+demandInterval_3rdItem;
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(selectedIntervals));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Actual text:"+selectedIntervals);
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Intervals", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(trendInterval_3rdItem));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Actual text:"+trendInterval_3rdItem);
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(demandInterval_3rdItem));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Actual text:"+demandInterval_3rdItem);
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
//leave one test case 1698	

	
	//IEEE519 standard
	
	
	public Boolean tc93_Blondel_verifyEditConfigNameAndDescriptionForEnergyStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception

	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOn_ViewMore_Link();
		
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		
		//Validations starts after edit Config
		gestureUtils.mobileScroll("Config Name and Desc", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Config Name and Desc", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).clear();
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "title", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).sendKeys(randomConfigName+"_abcd");
		fCCM174XSessionConfigObjectRepo.enter_Text_In_DescriptionBox("abcd");
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Config Name and Desc", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validation check edited config name
		try
		{
			Assert.assertEquals(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "title", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).getText(), randomConfigName+"_abcd");
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered config name is not displayed, Expected Config name: "+randomConfigName+"_abcd");
			testFailureFlag = true;
		}
		
		//Validation check edited config description
		
		try
		{
			Assert.assertEquals(fCCM174XSessionConfigObjectRepo.get_Text_FromDescriptionBox(), "abcd");
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered config name description is not displayed properly, Expected Config name: abcd");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName+"_abcd", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName+"_abcd", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
		
	public Boolean tc94_Blondel_verifyEditStudyTypeTopologyPhaseColour(String pqTool, String ssid174X, String flukeWIFI) throws Exception

	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		
		//Validations starts after edit Config
		gestureUtils.mobileScroll("Study Type, Topology and Phase Colors", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Study Type, Topology and Phase Colors", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.changeStudyTypeFromEditDropdown("Load Study");
		fCCM174XSessionConfigObjectRepo.changeTopologyFromEditDropdown("High Leg Delta");
		fCCM174XSessionConfigObjectRepo.changePhaseColourFromEditDropdown("Europe");
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		gestureUtils.mobileScroll("Nominal Voltage and Frequency", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		CommonUtils.wait(1);
		
		//Validating updated Study type, Topology and Phase colour
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Load Study"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Load Study");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("High Leg Delta"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: High Leg Delta");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Study Type, Topology and Phase Colors", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Europe"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Europe");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc95_Blondel_verifyNominalVoltageAndFrequency(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		//Validations starts after edit Config
		gestureUtils.mobileScroll("Nominal Voltage and Frequency", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Nominal Voltage and Frequency", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.clickOnNominalVoltage_Dropdown();
		Config.appWidthCenterFlag = true;
		gestureUtils.mScroll("Custom Value", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Custom Value", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.enterCustomNominalVoltage("500");
			
		fCCM174XSessionConfigObjectRepo.clickOnNominalFrequency_Dropdown();
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "60 Hz", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		//validation
		gestureUtils.mobileScroll("Ranges and Scaling", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("500.0V, 60Hz"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 500.0V, 60Hz");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Nominal Voltage and Frequency", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("500.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 500.0V");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("60 Hz"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 60 Hz");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc96_Blondel_verifyRangesAndScaling(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		//Validations starts after edit Config
		gestureUtils.mobileScroll("Ranges and Scaling", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Ranges and Scaling", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.enterVoltageRatio("20");
		fCCM174XSessionConfigObjectRepo.enterCurrentRatio("30");
		fCCM174XSessionConfigObjectRepo.enterAmpNeutralRatio("10");
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		gestureUtils.mobileScroll("Ranges and Scaling", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Ranges and Scaling", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validation
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validateVoltageRatio("20.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 20.0V");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validateCurrentRatio("30.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 30.0V");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validateAmpNeutralRatio("10.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 10.0V");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc97_Blondel_verifyMainSignalingVoltage(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Mains Signalling Voltages", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Mains Signalling Voltages", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.enter_Freq1_ForMainSignalingVoltage("100");
		fCCM174XSessionConfigObjectRepo.enter_Freq2_ForMainSignalingVoltage("200");
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		//validation
		gestureUtils.mobileScroll("Harmonics Measurements Mode", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("100.0Hz,200.0Hz"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 100.0Hz,200.0Hz");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Mains Signalling Voltages", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_Freq1_ForMainSigVoltage("100.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 100.0");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_Freq2_ForMainSigVoltage("200.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 200.0");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc98_Blondel_verifyHarmonicMeasurementMode(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Harmonics Measurements Mode", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validating Components radio button
		fCCM174XSessionConfigObjectRepo.clickOn_Components_RadioButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Components"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Components");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_Components_isSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Components radio button is not selected");
			testFailureFlag = true;
		}
		
		
		//Validating Grouped radio button
		fCCM174XSessionConfigObjectRepo.clickOn_Grouped_RadioButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Grouped"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Grouped");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_Grouped_isSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Grouped radio button is not selected");
			testFailureFlag = true;
		}
		
		
		//Validating SubGrouped radio button
		fCCM174XSessionConfigObjectRepo.clickOn_SubGrouped_RadioButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Sub Grouped"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Sub Grouped");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_SubGrouped_isSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("SubGrouped radio button is not selected");
			testFailureFlag = true;
		}
		
		
		//Validating IncludeInterHarmonics checkbox
		fCCM174XSessionConfigObjectRepo.check_IncludeInterHarmonics_checkbox();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_IncludeInterHarmonics_isCheckBoxSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Include Inter Harmonics checkbox is not selected");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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

	public Boolean tc99_Blondel_verifyFlickerLampModel(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.choose_FlickerLampModelVoltage("100 V");
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
	
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		//Validation
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("100V"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 100V");
			testFailureFlag = true;
		}
		
		gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("100 V"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 100 V");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
		
	public Boolean tc100_Blondel_verifyEditEventTriggerAndLimitsForDipEvent(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnDipSledingReferenceCheckbox();
		fCCM174XSessionConfigObjectRepo.clickAndEditDipLimitEditBox("80");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll("Swell", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkDipAndSwellCheckboxes());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Dip and Swell checkboxes are not checked, Expected : Both should be checked");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditDipLimitEditBoxValue("80.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 80.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to dip edit box value to 90.0
		fCCM174XSessionConfigObjectRepo.uncheckDipSledingReferenceCheckbox();
		fCCM174XSessionConfigObjectRepo.clickAndEditDipLimitEditBox("90");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();

		
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		CommonUtils.wait(3);
		return true;
	}
	
	
	public Boolean tc101_Blondel_verifyEditEventTriggerAndLimitsForSwellEvent(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnSwellSledingReferenceCheckbox();
		fCCM174XSessionConfigObjectRepo.clickAndEditSwellLimitEditBox("100");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll("Interruption", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkDipAndSwellCheckboxes());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Dip and Swell checkboxes are not checked, Expected : Both should be checked");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditSwellLimitEditBoxValue("100.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 100.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to swell edit box value to 110
		fCCM174XSessionConfigObjectRepo.uncheckSwellSledingReferenceCheckbox();
		fCCM174XSessionConfigObjectRepo.clickAndEditSwellLimitEditBox("110");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();

		
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		CommonUtils.wait(3);
		return true;
	}
	
	
	public Boolean tc102_Blondel_verifyEditEventTriggerAndLimitsForInterruptionEvent(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mobileScroll("Rapid Voltage Changes", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		fCCM174XSessionConfigObjectRepo.clickAndEditInterruptionLimitEditBox("10");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll("Rapid Voltage Changes", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
	
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditInterruptionLimitEditBoxValue("10.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 10.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to default values
		
		gestureUtils.mobileScroll("Set to Defaults", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Set to Defaults", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
	
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		CommonUtils.wait(3);
		return true;
	}
	
	
	public Boolean tc103_Blondel_verifyEditEventTriggerAndLimitsForRapidVoltageChangesEvent(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mobileScroll("Mains Signalling Voltages", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		fCCM174XSessionConfigObjectRepo.clickAndEditRapidVoltageChangesLimitEditBox("10");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll("Mains Signalling Voltages", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
	
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkRapidVoltageChangesCheckboxes());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Rapid Voltage Changes trigger ON checkbox is not checked, Expected : check box should be checked");
			testFailureFlag = true;
		}
		
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditRapidVoltageChangesLimitEditBoxValue("10.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 10.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to default values
		
		gestureUtils.mobileScroll("Set to Defaults", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Set to Defaults", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
	
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		CommonUtils.wait(3);
		return true;
	}
		
	
	public Boolean tc104_Blondel_verifyEditEventTriggerAndLimitsForMainsSignallingEvent(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mobileScroll("Waveform Deviation", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		fCCM174XSessionConfigObjectRepo.clickAndEditMainsSignallingVoltagesLimitsEditBox("20");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll("Waveform Deviation", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
	
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkMainsSignallingVoltagesCheckboxes());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Mains Signalling Voltages trigger ON checkbox is not checked, Expected : check box should be checked");
			testFailureFlag = true;
		}
		
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditMainsSignallingVoltagesLimitEditBoxValue("20.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 20.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to default values
		
		gestureUtils.mobileScroll("Set to Defaults", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Set to Defaults", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
	
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		CommonUtils.wait(3);
		return true;
	}
	
	
	public Boolean tc105_Blondel_verifyEditEventTriggerAndLimitsForWaveformDeviationEvent(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mobileScroll("Inrush Current", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		fCCM174XSessionConfigObjectRepo.clickAndEditWaveformDeviationLimitsEditBox("20");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll("Inrush Current", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
	
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkWaveformDeviationCheckbox());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Waveform Deviation trigger ON checkbox is not checked, Expected : check box should be checked");
			testFailureFlag = true;
		}
		
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditWaveformDeviationLimitEditBoxValue("20.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 20.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to default values
		
		gestureUtils.mobileScroll("Set to Defaults", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Set to Defaults", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
	
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		CommonUtils.wait(3);
		return true;
	}
	
	
	
	public Boolean tc106_Blondel_verifyEditEventTriggerAndLimitsForInrushCurrentEvent(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mobileScroll("Set to Defaults", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		fCCM174XSessionConfigObjectRepo.clickAndEditInrushCurrentLimitsEditBox("100");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll("Set to Defaults", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
	
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkInrushCurrentCheckbox());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Inrush Current trigger ON checkbox is not checked, Expected : check box should be checked");
			testFailureFlag = true;
		}
		
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditInrushCurrentLimitEditBoxValue("100.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 100.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to default values
		
		gestureUtils.mobileScroll("Set to Defaults", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Set to Defaults", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
	
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
		
		switcher.switchToHomePage();
		fCCM174XSessionConfigObjectRepo.openWifiSettingsPage();
	    fCCM174XSessionConfigObjectRepo.selectingParticularWifi(flukeWIFI);
		fCCM174XSessionConfigObjectRepo.navigateBackToFCAppAfterWifiChange();
		switcher.switchToHomePage();
		CommonUtils.wait(3);
		return true;
	}
	
	
	public Boolean tc107_Blondel_verifyEditingIntervals(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Intervals", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Intervals", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_TrendIntervalDropdown();
		String trendInterval_3rdItem =fCCM174XSessionConfigObjectRepo.clickOn_TrendInterval_listItem();
		fCCM174XSessionConfigObjectRepo.clickOn_DemandIntervalDropdown();
		String demandInterval_3rdItem = fCCM174XSessionConfigObjectRepo.clickOn_DemandInterval_listItem();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll("AUX Probes", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		//Trend :1 minutes, Demand :15 minutes
		String selectedIntervals = "Trend :"+trendInterval_3rdItem+", Demand :"+demandInterval_3rdItem;
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(selectedIntervals));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Actual text:"+selectedIntervals);
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Intervals", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(trendInterval_3rdItem));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Actual text:"+trendInterval_3rdItem);
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(demandInterval_3rdItem));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Actual text:"+demandInterval_3rdItem);
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	
	//Energy study- During config creation
	
	public Boolean tc108_Blondel_verifyConfigNameAndDescriptionForEnergyStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		
		gestureUtils.mobileScroll("Config Name and Desc", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Config Name and Desc", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		fCCM174XSessionConfigObjectRepo.enter_Text_In_DescriptionBox("abcd");
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Config Name and Desc", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validation config name
		try
		{
			Assert.assertEquals(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "title", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).getText(), randomConfigName);
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered config name is not displayed, Expected Config name: "+randomConfigName);
			testFailureFlag = true;
		}
		
		//Validation check edited config description
		
		try
		{
			Assert.assertEquals(fCCM174XSessionConfigObjectRepo.get_Text_FromDescriptionBox(), "abcd");
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered config name description is not displayed properly, Expected Config name: abcd");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc109_Blondel_verifyTopologyAndPhaseColorForEnergyStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		gestureUtils.mobileScroll("Nominal Voltage and Frequency", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Study Type, Topology and Phase Colors", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.changeStudyTypeFromEditDropdown("Load Study");
		fCCM174XSessionConfigObjectRepo.changeTopologyFromEditDropdown("High Leg Delta");
		fCCM174XSessionConfigObjectRepo.changePhaseColourFromEditDropdown("Europe");
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		gestureUtils.mobileScroll("Nominal Voltage and Frequency", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		CommonUtils.wait(1);
		
		//Validating updated Study type, Topology and Phase colour
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Load Study"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Load Study");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("High Leg Delta"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: High Leg Delta");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Study Type, Topology and Phase Colors", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Europe"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Europe");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
		
	public Boolean tc110_Blondel_verifyNominalVoltageAndFrequencyForEnergyStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		//Validations starts after edit Config
		gestureUtils.mobileScroll("Nominal Voltage and Frequency", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Nominal Voltage and Frequency", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.clickOnNominalVoltage_Dropdown();
		Config.appWidthCenterFlag = true;
		gestureUtils.mScroll("Custom Value", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Custom Value", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.enterCustomNominalVoltage("500");
			
		fCCM174XSessionConfigObjectRepo.clickOnNominalFrequency_Dropdown();
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "60 Hz", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		//validation
		gestureUtils.mobileScroll("Ranges and Scaling", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("500.0V, 60Hz"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 500.0V, 60Hz");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Nominal Voltage and Frequency", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("500.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 500.0V");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("60 Hz"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 60 Hz");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc111_Blondel_verifyRangesAndScalingForEnergyStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		//Validations starts after edit Config
		gestureUtils.mobileScroll("Ranges and Scaling", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Ranges and Scaling", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.enterVoltageRatio("20");
		fCCM174XSessionConfigObjectRepo.enterCurrentRatio("30");
		fCCM174XSessionConfigObjectRepo.enterAmpNeutralRatio("10");
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		gestureUtils.mobileScroll("Ranges and Scaling", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Ranges and Scaling", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validation
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validateVoltageRatio("20.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 20.0V");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validateCurrentRatio("30.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 30.0V");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validateAmpNeutralRatio("10.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 10.0V");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc112_Blondel_verifyMainSignalingVoltageForEnergyStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Mains Signalling Voltages", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Mains Signalling Voltages", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.enter_Freq1_ForMainSignalingVoltage("100");
		fCCM174XSessionConfigObjectRepo.enter_Freq2_ForMainSignalingVoltage("200");
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		//validation
		gestureUtils.mobileScroll("Harmonics Measurements Mode", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("100.0Hz,200.0Hz"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 100.0Hz,200.0Hz");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Mains Signalling Voltages", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_Freq1_ForMainSigVoltage("100.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 100.0");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_Freq2_ForMainSigVoltage("200.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 200.0");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc113_Blondel_verifyHamonicMeasurementModeForEnergyStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Harmonics Measurements Mode", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validating Components radio button
		fCCM174XSessionConfigObjectRepo.clickOn_Components_RadioButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Components"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Components");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_Components_isSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Components radio button is not selected");
			testFailureFlag = true;
		}
		
		
		//Validating Grouped radio button
		fCCM174XSessionConfigObjectRepo.clickOn_Grouped_RadioButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Grouped"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Grouped");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_Grouped_isSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Grouped radio button is not selected");
			testFailureFlag = true;
		}
		
		
		//Validating SubGrouped radio button
		fCCM174XSessionConfigObjectRepo.clickOn_SubGrouped_RadioButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Sub Grouped"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Sub Grouped");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_SubGrouped_isSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("SubGrouped radio button is not selected");
			testFailureFlag = true;
		}
		
		
		//Validating IncludeInterHarmonics checkbox
		fCCM174XSessionConfigObjectRepo.check_IncludeInterHarmonics_checkbox();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_IncludeInterHarmonics_isCheckBoxSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Include Inter Harmonics checkbox is not selected");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc114_Blondel_verifyFlickerLampModelForEnergyStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
	
		//Validation starts after edit
		gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.choose_FlickerLampModelVoltage("100 V");
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
	
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		//Validation
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("100V"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 100V");
			testFailureFlag = true;
		}
		
		gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("100 V"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 100 V");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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

	
	public Boolean tc115_Blondel_verifyEventTriggerAndLimitsForDipEvent(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnDipSledingReferenceCheckbox();
		fCCM174XSessionConfigObjectRepo.clickAndEditDipLimitEditBox("80");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll("Swell", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkDipAndSwellCheckboxes());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Dip and Swell checkboxes are not checked, Expected : Both should be checked");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditDipLimitEditBoxValue("80.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 80.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to dip edit box value to 90.0
		fCCM174XSessionConfigObjectRepo.uncheckDipSledingReferenceCheckbox();
		fCCM174XSessionConfigObjectRepo.clickAndEditDipLimitEditBox("90");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
	
		
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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

	public Boolean tc116_Blondel_verifyEventTriggerAndLimitsForSwellEvent(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnSwellSledingReferenceCheckbox();
		fCCM174XSessionConfigObjectRepo.clickAndEditSwellLimitEditBox("100");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll("Interruption", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkDipAndSwellCheckboxes());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Dip and Swell checkboxes are not checked, Expected : Both should be checked");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditSwellLimitEditBoxValue("100.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 100.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to swell edit box value to 110
		fCCM174XSessionConfigObjectRepo.uncheckSwellSledingReferenceCheckbox();
		fCCM174XSessionConfigObjectRepo.clickAndEditSwellLimitEditBox("110");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
	
		
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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

	public Boolean tc117_Blondel_verifyEventTriggerAndLimitsForInterruptionEvent(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mobileScroll("Rapid Voltage Changes", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		fCCM174XSessionConfigObjectRepo.clickAndEditInterruptionLimitEditBox("10");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll("Rapid Voltage Changes", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
	
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditInterruptionLimitEditBoxValue("10.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 10.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to default values
		
		gestureUtils.mobileScroll("Set to Defaults", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Set to Defaults", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
	
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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

	public Boolean tc118_Blondel_verifyEventTriggerAndLimitsForRapidVoltageChangesEvent(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mobileScroll("Mains Signalling Voltages", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		fCCM174XSessionConfigObjectRepo.clickAndEditRapidVoltageChangesLimitEditBox("10");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll("Mains Signalling Voltages", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
	
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkRapidVoltageChangesCheckboxes());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Rapid Voltage Changes trigger ON checkbox is not checked, Expected : check box should be checked");
			testFailureFlag = true;
		}
		
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditRapidVoltageChangesLimitEditBoxValue("10.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 10.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to default values
		
		gestureUtils.mobileScroll("Set to Defaults", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Set to Defaults", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
	
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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

	public Boolean tc119_Blondel_verifyEventTriggerAndLimitsForMainsSignallingEvent(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mobileScroll("Waveform Deviation", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		fCCM174XSessionConfigObjectRepo.clickAndEditMainsSignallingVoltagesLimitsEditBox("20");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll("Waveform Deviation", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
	
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkMainsSignallingVoltagesCheckboxes());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Mains Signalling Voltages trigger ON checkbox is not checked, Expected : check box should be checked");
			testFailureFlag = true;
		}
		
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditMainsSignallingVoltagesLimitEditBoxValue("20.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 20.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to default values
		
		gestureUtils.mobileScroll("Set to Defaults", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Set to Defaults", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
	
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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

	public Boolean tc120_Blondel_verifyEventTriggerAndLimitsForWaveformDeviationEvent(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mobileScroll("Inrush Current", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		fCCM174XSessionConfigObjectRepo.clickAndEditWaveformDeviationLimitsEditBox("20");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll("Inrush Current", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
	
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkWaveformDeviationCheckbox());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Waveform Deviation trigger ON checkbox is not checked, Expected : check box should be checked");
			testFailureFlag = true;
		}
		
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditWaveformDeviationLimitEditBoxValue("20.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 20.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to default values
		
		gestureUtils.mobileScroll("Set to Defaults", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Set to Defaults", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
	
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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

	public Boolean tc121_Blondel_verifyEventTriggerAndLimitsForInrushCurrentEvent(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mobileScroll("Set to Defaults", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		fCCM174XSessionConfigObjectRepo.clickAndEditInrushCurrentLimitsEditBox("100");
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnAndroidDoneButton_OnAndroidNumericPad();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		//Validation
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll("Set to Defaults", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
	
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.checkInrushCurrentCheckbox());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Inrush Current trigger ON checkbox is not checked, Expected : check box should be checked");
			testFailureFlag = true;
		}
		
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.getEditInrushCurrentLimitEditBoxValue("100.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected : 100.0");
			testFailureFlag = true;
		}
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		//revert back to default values
		
		gestureUtils.mobileScroll("Set to Defaults", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Set to Defaults", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
	
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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

	
	
	
	
	
	public Boolean tc122_Blondel_verifyIntervalsForEnergyStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Intervals", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Intervals", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_TrendIntervalDropdown();
		String trendInterval_3rdItem =fCCM174XSessionConfigObjectRepo.clickOn_TrendInterval_listItem();
		fCCM174XSessionConfigObjectRepo.clickOn_DemandIntervalDropdown();
		String demandInterval_3rdItem = fCCM174XSessionConfigObjectRepo.clickOn_DemandInterval_listItem();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll("AUX Probes", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		
		String selectedIntervals = "Trend :"+trendInterval_3rdItem+", Demand :"+demandInterval_3rdItem;
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(selectedIntervals));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Actual text:"+selectedIntervals);
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Intervals", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(trendInterval_3rdItem));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Actual text:"+trendInterval_3rdItem);
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(demandInterval_3rdItem));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Actual text:"+demandInterval_3rdItem);
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	
	//Load study- During config creation
	
	public Boolean tc123_Blondel_verifyConfigNameAndDescriptionForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		
		gestureUtils.mobileScroll("Config Name and Desc", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Config Name and Desc", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		fCCM174XSessionConfigObjectRepo.enter_Text_In_DescriptionBox("abcd");
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Config Name and Desc", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validation config name
		try
		{
			Assert.assertEquals(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "title", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).getText(), randomConfigName);
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered config name is not displayed, Expected Config name: "+randomConfigName);
			testFailureFlag = true;
		}
		
		//Validation check edited config description
		
		try
		{
			Assert.assertEquals(fCCM174XSessionConfigObjectRepo.get_Text_FromDescriptionBox(), "abcd");
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered config name description is not displayed properly, Expected Config name: abcd");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc124_Blondel_verifyStandardForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		gestureUtils.mobileScroll("Study Type, Topology and Phase Colors", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("None"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: None");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Standard", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Study Type, Topology and Phase Colors"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Standard tab is clickable, expected is Standard tab should not be clickable");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc125_Blondel_verifyTopologyAndPhaseColorForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		gestureUtils.mobileScroll("Nominal Voltage and Frequency", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Study Type, Topology and Phase Colors", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.changeStudyTypeFromEditDropdown("Energy Study");
		fCCM174XSessionConfigObjectRepo.changeTopologyFromEditDropdown("High Leg Delta");
		fCCM174XSessionConfigObjectRepo.changePhaseColourFromEditDropdown("Europe");
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		gestureUtils.mobileScroll("Nominal Voltage and Frequency", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		CommonUtils.wait(1);
		
		//Validating updated Study type, Topology and Phase colour
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Energy Study"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Energy Study");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("High Leg Delta"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: High Leg Delta");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Study Type, Topology and Phase Colors", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Europe"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Europe");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc126_Blondel_verifyNominalVoltageAndFrequencyForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		
		//Validations starts after edit Config
		gestureUtils.mobileScroll("Nominal Voltage and Frequency", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Nominal Voltage and Frequency", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.clickOnNominalVoltage_Dropdown();
		Config.appWidthCenterFlag = true;
		gestureUtils.mScroll("Custom Value", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Custom Value", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.enterCustomNominalVoltage("500");
			
		fCCM174XSessionConfigObjectRepo.clickOnNominalFrequency_Dropdown();
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "60 Hz", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		//validation
		gestureUtils.mobileScroll("Ranges and Scaling", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("500.0V, 60Hz"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 500.0V, 60Hz");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Nominal Voltage and Frequency", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("500.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 500.0V");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("60 Hz"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 60 Hz");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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

	public Boolean tc127_Blondel_verifyRangesAndScalingForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		
		//Validations starts after edit Config
		gestureUtils.mobileScroll("Ranges and Scaling", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Ranges and Scaling", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Checking voltage section is not present because of Load study
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchTextNOTPresent("Voltage"));
			CommonUtils.wait(1);
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchTextNOTPresent("voltage"));
		}
		catch(Throwable e)
		{
			Assert.fail("Voltage section is present, Expected is Voltage should not be present for Load study");
			testFailureFlag = true;
		}
		
		fCCM174XSessionConfigObjectRepo.enterCurrentRatio("30");
		fCCM174XSessionConfigObjectRepo.enterAmpNeutralRatio("10");
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		gestureUtils.mobileScroll("Ranges and Scaling", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Ranges and Scaling", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validation
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validateCurrentRatio("30.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 30.0V");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validateAmpNeutralRatio("10.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 10.0V");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc128_Blondel_verifyMainSignalingVoltagesForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
	
		//Validation starts after edit
		gestureUtils.mobileScroll("Harmonics Measurements Mode", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Mains Signalling Voltages", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Harmonics Measurements Mode"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Mains Signalling Voltages section is clickable, Expected is in Load study Mains Signalling Voltages section should be disabled");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
	
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc129_Blondel_verifyHarmonicsMeasurementModeForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Harmonics Measurements Mode", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validating Components radio button
		fCCM174XSessionConfigObjectRepo.clickOn_Components_RadioButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Components"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Components");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_Components_isSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Components radio button is not selected");
			testFailureFlag = true;
		}
		
		
		//Validating Grouped radio button
		fCCM174XSessionConfigObjectRepo.clickOn_Grouped_RadioButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Grouped"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Grouped");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_Grouped_isSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Grouped radio button is not selected");
			testFailureFlag = true;
		}
		
		
		//Validating SubGrouped radio button
		fCCM174XSessionConfigObjectRepo.clickOn_SubGrouped_RadioButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Sub Grouped"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Sub Grouped");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_SubGrouped_isSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("SubGrouped radio button is not selected");
			testFailureFlag = true;
		}
		
		
		//Validating IncludeInterHarmonics checkbox
		fCCM174XSessionConfigObjectRepo.check_IncludeInterHarmonics_checkbox();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_IncludeInterHarmonics_isCheckBoxSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Include Inter Harmonics checkbox is not selected");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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

	public Boolean tc130_Blondel_verifyFlickerLampModelForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
	
		//Validation starts after edit
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Events: Triggers and Limits"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Flicker Lamp Model section is clickable, Expected is in Load study Flicker Lamp Model section should be disabled");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
	
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc131_Blondel_verifyEventTriggersAndLimitsForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
	
		//Validation starts after edit
		gestureUtils.mobileScroll("Intervals", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Intervals"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Events: Triggers and Limits section is clickable, Expected is in Load study Events: Triggers and Limits section should be disabled");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
	
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc132_Blondel_verifyIntervalsForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Intervals", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Intervals", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_TrendIntervalDropdown();
		String trendInterval_3rdItem =fCCM174XSessionConfigObjectRepo.clickOn_TrendInterval_listItem();
		fCCM174XSessionConfigObjectRepo.clickOn_DemandIntervalDropdown();
		String demandInterval_1stItem = fCCM174XSessionConfigObjectRepo.clickOn_DemandIntervalLoadStudy_listItem();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll("AUX Probes", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		//Trend :1 minutes, Demand :15 minutes
		String selectedIntervals = "Trend :"+trendInterval_3rdItem+", Demand :"+demandInterval_1stItem;
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(selectedIntervals));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Actual text:"+selectedIntervals);
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Intervals", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(trendInterval_3rdItem));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Actual text:"+trendInterval_3rdItem);
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(demandInterval_1stItem));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Actual text:"+demandInterval_1stItem);
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc133_Blondel_verifyEditConfigNameAndDescriptionForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception

	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOn_ViewMore_Link();
		
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		
		//Validations starts after edit Config
		gestureUtils.mobileScroll("Config Name and Desc", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Config Name and Desc", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).clear();
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "title", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).sendKeys(randomConfigName+"_abcd");
		fCCM174XSessionConfigObjectRepo.enter_Text_In_DescriptionBox("abcd");
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Config Name and Desc", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validation check edited config name
		try
		{
			Assert.assertEquals(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "title", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).getText(), randomConfigName+"_abcd");
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered config name is not displayed, Expected Config name: "+randomConfigName+"_abcd");
			testFailureFlag = true;
		}
		
		//Validation check edited config description
		
		try
		{
			Assert.assertEquals(fCCM174XSessionConfigObjectRepo.get_Text_FromDescriptionBox(), "abcd");
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered config name description is not displayed properly, Expected Config name: abcd");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName+"_abcd", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName+"_abcd", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
		
	public Boolean tc134_Blondel_verifyEditStudyTypeForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception

	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOn_ViewMore_Link();
		
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		//validation
		gestureUtils.mobileScroll("Study Type, Topology and Phase Colors", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("None"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: None");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Standard", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Study Type, Topology and Phase Colors"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Standard tab is clickable, expected is Standard tab should not be clickable");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
		
	public Boolean tc135_Blondel_verifyEditStudyTypeTopologyPhaseColorForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception

	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOn_ViewMore_Link();
		
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		//Validation
		gestureUtils.mobileScroll("Nominal Voltage and Frequency", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Study Type, Topology and Phase Colors", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.changeStudyTypeFromEditDropdown("Energy Study");
		fCCM174XSessionConfigObjectRepo.changeTopologyFromEditDropdown("High Leg Delta");
		fCCM174XSessionConfigObjectRepo.changePhaseColourFromEditDropdown("Europe");
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		gestureUtils.mobileScroll("Nominal Voltage and Frequency", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		CommonUtils.wait(1);
		
		//Validating updated Study type, Topology and Phase colour
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Energy Study"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Energy Study");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("High Leg Delta"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: High Leg Delta");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Study Type, Topology and Phase Colors", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Europe"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Europe");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
			
	public Boolean tc136_Blondel_verifyEditNominalVoltageAndFrequencyForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception

	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOn_ViewMore_Link();
		
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		
		//Validations starts after edit Config
		gestureUtils.mobileScroll("Nominal Voltage and Frequency", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Nominal Voltage and Frequency", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		fCCM174XSessionConfigObjectRepo.clickOnNominalVoltage_Dropdown();
		Config.appWidthCenterFlag = true;
		gestureUtils.mScroll("Custom Value", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.UP);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Custom Value", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.enterCustomNominalVoltage("500");
			
		fCCM174XSessionConfigObjectRepo.clickOnNominalFrequency_Dropdown();
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "60 Hz", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		
		//Validation
		gestureUtils.mobileScroll("Ranges and Scaling", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("500.0V, 60Hz"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 500.0V, 60Hz");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Nominal Voltage and Frequency", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("500.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 500.0V");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("60 Hz"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 60 Hz");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
		
	public Boolean tc137_Blondel_verifyEditRangesAndScalingForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception

	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOn_ViewMore_Link();
		
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		//Validations starts after edit Config
		gestureUtils.mobileScroll("Ranges and Scaling", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Ranges and Scaling", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Checking voltage section is not present because of Load study
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchTextNOTPresent("Voltage"));
			CommonUtils.wait(1);
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchTextNOTPresent("voltage"));
		}
		catch(Throwable e)
		{
			Assert.fail("Voltage section is present, Expected is Voltage should not be present for Load study");
			testFailureFlag = true;
		}
		
		fCCM174XSessionConfigObjectRepo.enterCurrentRatio("30");
		fCCM174XSessionConfigObjectRepo.enterAmpNeutralRatio("10");
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		gestureUtils.mobileScroll("Ranges and Scaling", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Ranges and Scaling", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validation
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validateCurrentRatio("30.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 30.0V");
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validateAmpNeutralRatio("10.0"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: 10.0V");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc138_Blondel_verifyEditMainSignallingVoltageForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception

	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOn_ViewMore_Link();
		
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Harmonics Measurements Mode", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Mains Signalling Voltages", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Harmonics Measurements Mode"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Mains Signalling Voltages section is clickable, Expected is in Load study Mains Signalling Voltages section should be disabled");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
	
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
		
	public Boolean tc139_Blondel_verifyEditHarmonicsMeasurementModeForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception

	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOn_ViewMore_Link();
		
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Harmonics Measurements Mode", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		//Validating Components radio button
		fCCM174XSessionConfigObjectRepo.clickOn_Components_RadioButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Components"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Components");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_Components_isSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Components radio button is not selected");
			testFailureFlag = true;
		}
		
		
		//Validating Grouped radio button
		fCCM174XSessionConfigObjectRepo.clickOn_Grouped_RadioButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Grouped"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Grouped");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_Grouped_isSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Grouped radio button is not selected");
			testFailureFlag = true;
		}
		
		
		//Validating SubGrouped radio button
		fCCM174XSessionConfigObjectRepo.clickOn_SubGrouped_RadioButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Sub Grouped"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Expected Config name: Sub Grouped");
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_SubGrouped_isSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("SubGrouped radio button is not selected");
			testFailureFlag = true;
		}
		
		
		//Validating IncludeInterHarmonics checkbox
		fCCM174XSessionConfigObjectRepo.check_IncludeInterHarmonics_checkbox();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll("Flicker - Lamp Model", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Harmonics Measurements Mode", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.validate_IncludeInterHarmonics_isCheckBoxSelected());
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Include Inter Harmonics checkbox is not selected");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc140_Blondel_verifyEditFlickerLampModelForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception

	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOn_ViewMore_Link();
		
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Events: Triggers and Limits", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Flicker - Lamp Model", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Events: Triggers and Limits"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Flicker Lamp Model section is clickable, Expected is in Load study Flicker Lamp Model section should be disabled");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
	
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc141_Blondel_verifyEditEventsTriggersAndLimitsForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception

	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOn_ViewMore_Link();
		
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Intervals", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Events: Triggers and Limits", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains("Intervals"));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Events: Triggers and Limits section is clickable, Expected is in Load study Events: Triggers and Limits section should be disabled");
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
	
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	
	public Boolean tc142_Blondel_verifyEditIntervalsForLoadStudy(String pqTool, String ssid174X, String flukeWIFI) throws Exception

	{
		String randomConfigName = "Test_"+fCCM174XSessionConfigObjectRepo.getRandomText();
		
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
		gestureUtils.mobileScroll("Wye It", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		fCCM174XSessionConfigObjectRepo.clickOn_WyeIT_topology();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOn_GenerateConfiguration_Button();
		CommonUtils.wait(5);
		fCCM174XSessionConfigObjectRepo.isConfigNameVisibleInNewConfigDetailsScreen(randomConfigName);
		fCCM174XSessionConfigObjectRepo.clickOn_ViewMore_Link();
		
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		
		fCCM174XSessionConfigObjectRepo.clickOn_SavedConfigurarion_link();
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_Link_ForSavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Edit_ConfigurationButton_InPopup();
		fCCM174XSessionConfigObjectRepo.isNewConfigurationScreenVisible();
		
		
		//Validation starts after edit
		gestureUtils.mobileScroll("Intervals", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Intervals", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_TrendIntervalDropdown();
		String trendInterval_3rdItem =fCCM174XSessionConfigObjectRepo.clickOn_TrendInterval_listItem();
		fCCM174XSessionConfigObjectRepo.clickOn_DemandIntervalDropdown();
		String demandInterval_1stItem = fCCM174XSessionConfigObjectRepo.clickOn_DemandIntervalLoadStudy_listItem();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll("AUX Probes", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		
		//Trend :1 minutes, Demand :15 minutes
		String selectedIntervals = "Trend :"+trendInterval_3rdItem+", Demand :"+demandInterval_1stItem;
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(selectedIntervals));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Actual text:"+selectedIntervals);
			testFailureFlag = true;
		}
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Intervals", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(trendInterval_3rdItem));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Actual text:"+trendInterval_3rdItem);
			testFailureFlag = true;
		}
		
		try
		{
			Assert.assertTrue(fCCM174XSessionConfigObjectRepo.searchWithTextContains(demandInterval_1stItem));
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			Assert.fail("Entered element is not displayed properly, Actual text:"+demandInterval_1stItem);
			testFailureFlag = true;
		}
		
		if(testFailureFlag)
		{
			testFailureFlag = false;
			fCCM174XSessionConfigObjectRepo.goBackTillHomeScreen();
			throw new Exception();  //if any validation fails exception will triggered
		}
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		CommonUtils.wait(2);
		
		gestureUtils.mobileScroll("Saved Configuration", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Saved Configuration", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		
		gestureUtils.mobileScroll(randomConfigName, Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_3dot_ActionBarMenu_Link();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_Link_for_SavedSession();
		CommonUtils.wait(1);
		fCCM174XSessionConfigObjectRepo.clickOn_Delete_ConfigurationButton_InPopup();
		CommonUtils.wait(2);
		
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
		fCCM174XSessionConfigObjectRepo.clickOnBackButton();
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
	

}
