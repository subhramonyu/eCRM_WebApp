package com.fluke.connect.app.functional.client.pages;
/*package com.connect.fluke.app.pages;

import java.time.temporal.ChronoUnit;
import org.openqa.selenium.WebElement;

import com.connect.fluke.app.testdata.FCCM.FCCMProductName;
import com.connect.fluke.app.utils.AndroidUtils;
import com.connect.fluke.app.utils.CommonUtils;
import com.connect.fluke.app.utils.Config;
import com.connect.fluke.app.utils.Config.LocatorStrategy;
import com.connect.fluke.app.utils.Config.ScrollDiection;
import com.connect.fluke.app.utils.DriverManager;
import com.connect.fluke.app.utils.ElementUtils;
import com.connect.fluke.app.utils.FileUtil;
import com.connect.fluke.app.utils.GestureUtils;
import com.connect.fluke.app.utils.IOSUtils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SessionSetup 
{
	@iOSXCUITFindBy(accessibility="Gateway & Sensors")
	private WebElement gatewayAndSensorsButton;
	
	@iOSXCUITFindBy(accessibility="CONTINUE WITH SENSORS")
	private WebElement continueWithSensorButton;
	
	@AndroidFindBy(id = "assign_asset")
	@iOSXCUITFindBy(iOSNsPredicate = "name == 'ASSIGN ASSET OR TEST POINT'")
	private WebElement assignAssetOrTestPointButton;
	
	@HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
	@AndroidFindBy(id = "save_continue_btn")
	@iOSXCUITFindBy(iOSNsPredicate = "name CONTAINS 'CONTINUE'")
	@iOSXCUITFindBy(accessibility = "SAVE & CONTINUE")
	private WebElement saveAndContinueButton;
	
	@iOSXCUITFindBy(accessibility="SKIP")
	private WebElement skipOrSaveAndContinueButton;
	
	@iOSXCUITFindBy(accessibility="CONNECT GATEWAY TO FLUKE CONNECT CLOUD")
	private WebElement connectGatewayToFlukeCloudButton;
	
	@WithTimeout(time=10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility="Password Required")
	private WebElement passwordRequiredStaticText;
	
	@AndroidFindBy(id = "start_remote_monitoring")
	@iOSXCUITFindBy(accessibility="START MONITORING")
	private WebElement startMonitoringButton;
	
	@iOSXCUITFindBy(accessibility="Almost Done")
	private WebElement almostDoneStaticText;
	
	@iOSXCUITFindBy(accessibility="Join")
	private WebElement joinButton;
	
	@iOSXCUITFindBy(accessibility="Vibration Sensors")
	private WebElement vibrationSensorButton;
	
	@iOSXCUITFindBy(accessibility = "CONNECT TO FLUKE CONNECT CLOUD ￼")
	private WebElement connectToFlukeConnectCloudButton;
	
	@AndroidFindBy(id = "saved_network")
	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'SAVED NETWORKS'")
	private WebElement savedNetworksStaticText;
	
	@HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
	@AndroidFindBy(id = "continue_button")
	@iOSXCUITFindBy(accessibility = "CONTINUE ￼")
	@iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH 'CONTINUE'")
	private WebElement continueButton;
	
	@AndroidFindBy(id = "start_setup_button")
	@iOSXCUITFindBy(accessibility = "START SESSION SETUP ￼")
	private WebElement startSessionSetupButton;
	
	@AndroidFindBy(id = "started_time_and_name")
	@iOSXCUITFindBy(accessibility = "sessionStartTime")
	private WebElement sessionStartTimeStaticText;
	
	@AndroidFindBy(id = "goto_home_screen_button")
	@iOSXCUITFindBy(accessibility = "Home")
	private WebElement goToHomeScreenButton;
	
	@AndroidFindBy(id = "gateway_name")
	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Gateway Name'")
	private WebElement gatewayNameStaticText;
	
	@AndroidFindBy(id = "button_3")
	@iOSXCUITFindBy(accessibility = "Cancel")
	private WebElement licenseErrorCancelButton; 
	
	private AssetsPage assetPage;
	private GestureUtils gestureUtils;
	private HomePage homePage;
	
	public SessionSetup()
	{
		CommonUtils.initElements(this);
		assetPage = new AssetsPage();
		gestureUtils = new GestureUtils();
		homePage = new HomePage();
	}
	
	public boolean isGatewayConnectedToCloud()
	{
		if(startMonitoringButton.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void connectGatewayToCloud(String networkName, String password) throws Exception
	{
		gestureUtils.scroll(networkName, Config.IOS_LOCATOR_STRATEGY_VALUE, AndroidUtils.getScrollSteps(ScrollDiection.DOWN), IOSUtils.getScrollSteps(ScrollDiection.DOWN));
		ElementUtils.clickIfDisplayedAndEnabled(networkName, null, null);
		if(passwordRequiredStaticText.isDisplayed())
		{
			passwordRequiredStaticText.sendKeys(password);
			ElementUtils.clickIfDisplayedAndEnabled(joinButton);
		}
	}
	
	public void selectFCCMProduct(FCCMProductName productName, ScrollDiection scrollDirection) 
	{
		homePage.clickOnSetupLoggingAndMonitoring();
		switch(productName)
		{
		case VIBRATION_SENSOR:
			handleLicenseError(FCCMProductName.VIBRATION_SENSOR.getProductName());
			break;
		case TI_SENSOR:
			gestureUtils.mScroll(FCCMProductName.TI_SENSOR.getProductName(), LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, scrollDirection);
			handleLicenseError(FCCMProductName.TI_SENSOR.getProductName());
			break;
		}
	}
	
	public void handleLicenseError(String productName)
	{
		for(int i = 0; i < 5; i++)
		{
			ElementUtils.getElement(productName, null, null).click();
			if(ElementUtils.isDisplayed(2, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "button_3", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Cancel", null, null))
			{
				licenseErrorCancelButton.click();
				CommonUtils.wait(5);
			}
			else
				break;
		}		
	}
	
	public void startVATGSession(String assetGroupName, String assetName, String testPointName, String networkName, String password) throws Exception
	{
		ElementUtils.clickIfDisplayedAndEnabled(startSessionSetupButton);
		ElementUtils.clickIfDisplayedAndEnabled(continueWithSensorButton);
		ElementUtils.clickIfDisplayedAndEnabled(assignAssetOrTestPointButton);
		assetPage.assignAsset(assetGroupName, assetName, testPointName, 0);
		ElementUtils.clickIfDisplayedAndEnabled(saveAndContinueButton);
		ElementUtils.clickIfDisplayedAndEnabled(skipOrSaveAndContinueButton);
		ElementUtils.clickIfDisplayedAndEnabled(saveAndContinueButton);
		ElementUtils.clickIfDisplayedAndEnabled(connectGatewayToFlukeCloudButton);
		connectGatewayToCloud(networkName, password);
		if(!isGatewayConnectedToCloud())
		{
			connectGatewayToCloud(networkName, password);
		}
		ElementUtils.clickIfDisplayedAndEnabled(startMonitoringButton);
	}
	
	public void selectTool(String toolName) throws Exception
	{
		gestureUtils.scroll(toolName, Config.IOS_LOCATOR_STRATEGY_VALUE, AndroidUtils.getScrollSteps(ScrollDiection.DOWN), IOSUtils.getScrollSteps(ScrollDiection.DOWN));
		ElementUtils.clickIfDisplayedAndEnabled(toolName, null, null);
	}
	
	public void selectNetwork(String iOSObjectName, String networkName, int iOSScrollSteps, int androidScrollSteps) throws Exception
	{
		if(!ElementUtils.isDisplayed(180, 1, networkName, null, null))
		{
			gestureUtils.scroll(iOSObjectName, networkName, null, networkName, iOSScrollSteps, androidScrollSteps, null, null);
		}
		ElementUtils.clickIfDisplayedAndEnabled(networkName, null, null);
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) && DriverManager.getEnvironmentName().equals(Config.PRODUCTION))
		{
			ElementUtils.clickIfDisplayedAndEnabled(connectToFlukeConnectCloudButton);
		}	
	}
	
	public boolean isAssetAssigned(String iOSObjectName, String iOSObjectValue, String androidObjectValue, int iOSScrollSteps, int androidScrollSteps, String[] assetGroupNameList, String[] assetNameList, String[] testPointNameList, int androidTestPointIndex) throws Exception
	{
		assignAsset(iOSObjectName, iOSObjectValue, androidObjectValue, iOSScrollSteps, androidScrollSteps, assetGroupNameList, assetNameList, testPointNameList, androidTestPointIndex);
		return ElementUtils.isDisplayed(60, 1, startMonitoringButton);
	}
	
	public void assignAsset(String iOSObjectName, String iOSObjectValue, String androidObjectValue, int iOSScrollSteps, int androidScrollSteps, String[] assetGroupNameList, String[] assetNameList, String[] testPointNameList, int androidTestPointIndex) throws Exception
	{
		for(int i = 0; i < assetNameList.length; i++)
		{
			ElementUtils.clickIfDisplayedAndEnabled(assignAssetOrTestPointButton);
			ElementUtils.clickIfDisplayedAndEnabled(60, 1, continueButton);
			ElementUtils.clickIfDisplayedAndEnabled(60, 1, continueButton);
			assetPage.assignAsset(assetGroupNameList[i], assetNameList[i], testPointNameList[i], androidTestPointIndex);
			ElementUtils.clickIfDisplayedAndEnabled(saveAndContinueButton);
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				ElementUtils.clickIfDisplayedAndEnabled(60, 1, saveAndContinueButton);
				ElementUtils.clickIfDisplayedAndEnabled(continueButton);
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				ElementUtils.clickIfDisplayedAndEnabled(60, 1, continueButton);
				ElementUtils.clickIfDisplayedAndEnabled(saveAndContinueButton);
			}
			if(assetNameList.length > 1)
			{
				gestureUtils.scroll(iOSObjectName, iOSObjectValue, null, androidObjectValue, iOSScrollSteps, androidScrollSteps, null, null);
			}
		}
		ElementUtils.clickIfDisplayedAndEnabled(60, 1, saveAndContinueButton);
	}
	
	public boolean isMonitoringStarted(String propertyFilePath, String... propertyName) throws Exception
	{
		startMonitoring();
		boolean flag = ElementUtils.isDisplayed(60, 1, sessionStartTimeStaticText);
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			FileUtil.writeProperty(propertyFilePath, propertyName[0], getSessionStartTime());
			FileUtil.writeProperty(propertyFilePath, propertyName[2], "null");
			FileUtil.writeProperty(propertyFilePath, propertyName[1], gatewayNameStaticText.getText());
			FileUtil.writeProperty(propertyFilePath, propertyName[3], "null");
		}
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			FileUtil.writeProperty(propertyFilePath, propertyName[2], getSessionStartTime());
			FileUtil.writeProperty(propertyFilePath, propertyName[0], "null");
			FileUtil.writeProperty(propertyFilePath, propertyName[3], gatewayNameStaticText.getText());
			FileUtil.writeProperty(propertyFilePath, propertyName[1], "null");
		}
		ElementUtils.clickIfDisplayedAndEnabled(goToHomeScreenButton);
		CommonUtils.wait(30);
		return flag;
	}
	
	public void startMonitoring() throws Exception
	{
		ElementUtils.clickIfDisplayedAndEnabled(startMonitoringButton);
	}
	
	public String getSessionStartTime()
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			return sessionStartTimeStaticText.getText();
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			return sessionStartTimeStaticText.getText().substring(0, sessionStartTimeStaticText.getText().indexOf(" |")+2);
		}
		return null;
	}

}

*/
