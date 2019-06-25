package com.fluke.connect.app.functional.client.pages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.openqa.selenium.WebElement;

import com.fluke.connect.app.functional.client.tests.ActiveSessionDetailPageTests3540;
import com.fluke.connect.app.testdata.FCCM3540;
import com.fluke.connect.app.testdata.FCCM3560;
import com.fluke.connect.app.utils.AndroidUtils;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.FCCMUtils;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;


public class EventLogging3540Page {
	
	private GestureUtils gestureUtils;
	//gestureUtils
	private Switcher switcher;
	private SessionListPage sessionListPage;
	private ActiveSessionDetailPageTests3540 sessionDetailPageTests3540;
	private SessionDetailPage3540 sessionDetailPage3540;
	private String pageSource;
	private CompletedSessionPage completedSessionPage;
	
	//@FindBy(how = How.ID, using = "com.fluke.deviceApp:id/download_logging_sessions")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/download_logging_sessions")
	@iOSFindBy(accessibility="select Download Screen")
	private WebElement downloadLogginSessionButton;
	
	@AndroidFindBy(id = "three_phase_image")
	@iOSFindBy(accessibility="3-Phase Power Monitor")
	private WebElement threePhasePowerMonitorLink;
	
	
	@AndroidFindBy(id = "next")
	@iOSFindBy(accessibility="CONTINUE")
	private WebElement continueButton;
	
	@AndroidFindBy(id = "download_button")
	@iOSFindBy(accessibility="DOWNLOAD")
	private WebElement downloadButton;
	
	@AndroidFindBy(id = "delete_memory_selection")
	@iOSFindBy(accessibility="checkbox on")
	private WebElement deleteMemorySelectionCheckbox;
	
	@AndroidFindBy(id = "action_bar_item_menu_text")
	@iOSFindBy(accessibility="START")
	private WebElement startDownloadButton;
	
	@AndroidFindBy(id = "dialog_ok")
	@iOSFindBy(accessibility="OK")
	private WebElement downloadCompleteOKButton;
	
	@AndroidFindBy(id = "action_bar_item_left")
	@iOSFindBy(accessibility="BACK")
	private WebElement BackButtonOnApp;
	
	@AndroidFindBy(id = "action_bar_item_menu_icon")
	@iOSFindBy(accessibility = "options white")
	private WebElement optionsButton;
	
	@AndroidFindBy(id = "android:id/title")
	@iOSFindBy(accessibility = "Delete")
	private WebElement deleteButton;
	
	@AndroidFindBy(id = "action_bar_item_menu_text")
	private WebElement deleteSessionButton;
	
	
	public EventLogging3540Page()
	{
		CommonUtils.initElements(this, 15);
		switcher = new Switcher();
		gestureUtils = new GestureUtils();
		sessionListPage = new SessionListPage();
		sessionDetailPageTests3540 = new ActiveSessionDetailPageTests3540();
		completedSessionPage = new CompletedSessionPage();
	}
	
	public void clickOnDownloadLoggingSessions()
	{
		downloadLogginSessionButton.click();
	}

	public void clickOnthreePhasePowerMonitorLink()
	{
		threePhasePowerMonitorLink.click();
	}
	
	public void clickContinueButton()
	{
		continueButton.click();
	}
	
	public void clickOpenPhoneSettingsButton()
	{
		continueButton.click();
	}
	
	public void clickOnDownloadButton()
	{
		downloadButton.click();
	}
	
	public void select3540ToolWifi(String ssid3540) throws InterruptedException, IOException
	{
		String wifiName3540 ="FLUKE3540FC<"+ssid3540+">";
		Thread.sleep(2000);
		
		if(DriverManager.getDriverName().equals("Android"))
		{
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, wifiName3540, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, "3540 IOS ID", LocatorStrategy.NONE, null).click();
			Thread.sleep(5000);
			AndroidUtils.back();
		}
		
		else if (DriverManager.getDriverName().equals("iOS"))
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
	            System.out.println("Done2");
	            runtime.exec("sudo ifconfig en4 down");
	            Thread.sleep(30000);
	        Thread.sleep(5000);
	        runtime.exec("sudo ifconfig en0 up");
	        Thread.sleep(5000);
	        System.out.println("Done3");
	        runtime.exec("networksetup -setairportnetwork en0 "+wifiName3540+" fluketools");
	        Thread.sleep(30000);
	        runtime.exec("sudo ifconfig en4 up");
	        System.out.println("Done4");
	        Thread.sleep(5000);
	        runtime.exec("sudo ifconfig en0 down");
	        System.out.println("Done");
		}
		
		
	}
	
	
	public void clickStartDownloadButton()
	{
		deleteMemorySelectionCheckbox.click();
		startDownloadButton.click();
	}
	
	public void clickOKonDownloadCompletePopup()
	{
		CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(120, 10, downloadCompleteOKButton);
	}
	
	public void clickOnBackButtonOnStoredSessions() throws InterruptedException
	{
		Thread.sleep(1000);
		BackButtonOnApp.click();
	}
	
	public void clickOnOKonDisconnectFromTool()
	{
		downloadCompleteOKButton.click();
	}
	
	public void clickOnBackButtonOnDownloadSession()
	{
		BackButtonOnApp.click();
	}
	
	public void navigateToCompletedSessionList() throws Exception
	{
		switcher.switchToMeasurementsPage();
		switcher.switchToSession(Switcher.COMPLETED_SESSION);
	}
	
	public Boolean checkStaleDataInSession() throws Exception
	{
		if (pageSource.contains("--"))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public void clickOnDownloadedEventLoggingSession(String sessionStartTime) throws Exception
	{
		FCCM3540.sessionStartTimestampValue = FCCMUtils.getSessionStartTime(sessionStartTime, Config.FCCM_PROPERTIES_FILE_PATH, FCCM3540.androidSessionStartTimestamp, FCCM3540.iOSSessionStartTimestamp);
		FCCM3540.requiredSessionStartTimestamp = FCCMUtils.getRequiredSessionStartTimestamp(FCCM3540.sessionStartTimestampValue, Config.ANDROID_DATE_SEPRATOR, Config.IOS_DATE_SEPRATOR, null);
		sessionListPage.initSessionCellElement(FCCM3540.requiredSessionStartTimestamp);
		ElementUtils.getElement(sessionListPage.getSessionTile(), LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, FCCM3540.requiredSessionStartTimestamp, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, FCCM3540.requiredSessionStartTimestamp, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_SPAN_TEXT_CONTAINS, FCCM3540.requiredSessionStartTimestamp).click();
	}
	
	public void clickOnDownloadedEventLoggingSessionAndDeleteIt(String sessionStartTime) throws Exception
	{
		FCCM3540.requiredSessionStartTimestamp = FCCMUtils.getRequiredSessionStartTimestamp(sessionStartTime, Config.ANDROID_DATE_SEPRATOR, Config.IOS_DATE_SEPRATOR, null);
		CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(30, 1, optionsButton);
		CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(30, 1, deleteButton);
		sessionListPage.initSessionCellElement(FCCM3540.requiredSessionStartTimestamp);
		ElementUtils.getElement(sessionListPage.getSessionTile(), LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, FCCM3540.requiredSessionStartTimestamp, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, FCCM3540.requiredSessionStartTimestamp, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_SPAN_TEXT_CONTAINS, FCCM3540.requiredSessionStartTimestamp).click();
		deleteSessionButton.click();
		downloadCompleteOKButton.click();
		Thread.sleep(10000);
	}
	
	
	public Boolean downloadLoggingSession(Boolean isActiveSession, String sessionStartTime, String ssid3540) throws Exception
	{
		//gesture.mobileScrollDown();
		Thread.sleep(1000);
		clickOnDownloadLoggingSessions();
		clickOnthreePhasePowerMonitorLink();	
		if(DriverManager.getDriverName().equals("Android"))
		{
			clickContinueButton();
			clickOpenPhoneSettingsButton();
			select3540ToolWifi(ssid3540);
		}
		else if (DriverManager.getDriverName().equals("iOS"))
		{
			select3540ToolWifi(ssid3540);
			clickContinueButton();
		}
		
		clickOnDownloadButton();
		clickStartDownloadButton();
		clickOKonDownloadCompletePopup();
		clickOnBackButtonOnStoredSessions();
		clickOnOKonDisconnectFromTool();
		clickOnBackButtonOnDownloadSession();
		clickOnBackButtonOnDownloadSession();
		Thread.sleep(1000);
		clickOnBackButtonOnDownloadSession();
		Thread.sleep(10000);
		navigateToCompletedSessionList();
		Thread.sleep(60000);
		clickOnDownloadedEventLoggingSession(sessionStartTime);
		pageSource = null;
		pageSource = DriverManager.getDriver().getPageSource();
		Boolean checkStaleData = checkStaleDataInSession();
		clickOnBackButtonOnDownloadSession();
		Thread.sleep(1000);
		clickOnBackButtonOnDownloadSession();
		Thread.sleep(10000);
		switcher.switchToMeasurementsPage();
		switcher.switchToHomePage();
		return checkStaleData;
	}
	
	
	public Boolean deleteDownloadedSession(Boolean isActiveSession, String sessionStartTime, String ssid3540) throws Exception
	{
		switcher.switchToMeasurementsPage();
		switcher.switchToHomePage();
		navigateToCompletedSessionList();		
		clickOnDownloadedEventLoggingSessionAndDeleteIt(sessionStartTime);		
		clickOnBackButtonOnDownloadSession();
		switcher.switchToMeasurementsPage();
		Thread.sleep(5000);
		switcher.switchToHomePage();
		clickOnDownloadLoggingSessions();
		clickOnthreePhasePowerMonitorLink();
		clickContinueButton();
		clickOpenPhoneSettingsButton();
		select3540ToolWifi(ssid3540);
		Boolean downloadButtonCheck = downloadButton.isDisplayed();
		clickOnBackButtonOnDownloadSession();
		Thread.sleep(1000);
		clickOnOKonDisconnectFromTool();
		clickOnBackButtonOnDownloadSession();
		clickOnBackButtonOnDownloadSession();
		Thread.sleep(1000);
		clickOnBackButtonOnDownloadSession();
		return downloadButtonCheck;
	}
}
