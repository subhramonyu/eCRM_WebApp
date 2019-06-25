package com.fluke.connect.app.functional.client.pages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.ScrollDiection;

import io.appium.java_client.MobileBy;

public class FCCM174XApiCheckPage {
	private Switcher switcher;
	private GestureUtils gestureUtils;
	private FCCM174XSessionConfigObjectRepo fCCM174XSessionConfigObjectRepo;
	//private Fccm174x_APIMethods fCCM174x_APIMethods;
	private String testFailureState;
	private boolean testFailureFlag = false;
	
	public FCCM174XApiCheckPage()
	{
		CommonUtils.initElements(this, 15);
		switcher = new Switcher();
		gestureUtils = new GestureUtils();
		fCCM174XSessionConfigObjectRepo = new FCCM174XSessionConfigObjectRepo();
		//fCCM174x_APIMethods = new Fccm174x_APIMethods();
	}
	
	public void connectTo174XToolWifiOnMac(String pqTool,String ssid174X) throws IOException
	{
		String PQ174XTool = pqTool+"<"+ssid174X+">";
		Runtime runtime = Runtime.getRuntime();
		String[] cmd = {"/bin/bash","-c","echo \"ABcd1234\"| sudo -S ls"};
	    Process pb = Runtime.getRuntime().exec(cmd);

	    String line;
	    BufferedReader input = new BufferedReader(new InputStreamReader(pb.getInputStream()));
	    while ((line = input.readLine()) != null) {
	        System.out.println(line);
	    }
	    input.close();
		runtime.exec("sudo ifconfig en4 down");
        runtime.exec("sudo ifconfig en4 down");
        //Thread.sleep(30000);
        //Thread.sleep(5000);
        runtime.exec("sudo ifconfig en0 up");
        //Thread.sleep(5000);
        System.out.println("Done3");
        runtime.exec("networksetup -setairportnetwork en0 "+PQ174XTool+" fluketools");
        CommonUtils.wait(5);
        System.out.println("Blondel Connected");
        runtime.exec("sudo ifconfig en4 up");
        System.out.println("Done4");
        CommonUtils.wait(5);
	}
	
	public void connectToFlukeWifi(String flukeWIFI) throws IOException
	{
		Runtime runtime = Runtime.getRuntime();
		String[] cmd = {"/bin/bash","-c","echo \"ABcd1234\"| sudo -S ls"};
	    Process pb = Runtime.getRuntime().exec(cmd);

	    String line;
	    BufferedReader input = new BufferedReader(new InputStreamReader(pb.getInputStream()));
	    while ((line = input.readLine()) != null) {
	        System.out.println(line);
	    }
	    input.close();
		runtime.exec("sudo ifconfig en4 down");
        runtime.exec("sudo ifconfig en4 down");
        //Thread.sleep(30000);
        //Thread.sleep(5000);
        runtime.exec("sudo ifconfig en0 up");
        //Thread.sleep(5000);
        System.out.println("Done3");
        runtime.exec("networksetup -setairportnetwork en0 "+flukeWIFI+" wgS3jNC!6D");
        CommonUtils.wait(5);
        System.out.println("Blondel Connected");
        runtime.exec("sudo ifconfig en4 up");
        System.out.println("Done4");
        CommonUtils.wait(5);
	}
	
	public Boolean tc_Api01_Blondel_checkPowerQualityLoggerOption(String pqTool, String ssid174X, String flukeWIFI) throws Exception
	{
		//connectTo174XToolWifiOnMac(pqTool,ssid174X);
       
        //CommonUtils.wait(5);
		//connectToFlukeWifi(flukeWIFI);
		
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
		
		//
		connectTo174XToolWifiOnMac(pqTool,ssid174X);
		CommonUtils.wait(5);
		//String standardNameFromTool = fCCM174x_APIMethods.getStandardFromTemplate();
		//String studyTypeFromTool = fCCM174x_APIMethods.getStudyTypeFromTemplate();
		//String topologyFromTool = fCCM174x_APIMethods.getTopologyFromTemplate();
		connectToFlukeWifi(flukeWIFI);
		CommonUtils.wait(5);
		
		//Deleting Starts here
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

}
