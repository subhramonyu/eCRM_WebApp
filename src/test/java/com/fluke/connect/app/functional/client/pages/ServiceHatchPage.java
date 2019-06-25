package com.fluke.connect.app.functional.client.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.fluke.connect.app.functional.client.pages.SignInPage.SigninPageObjects;
import com.fluke.connect.app.utils.AndroidUtils;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.ScrollDiection;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ServiceHatchPage 
{
	@AndroidFindBy(id = "app_environment")
	@iOSXCUITFindBy(iOSNsPredicate = "value == 'Production' OR value == 'Dev' OR value == 'PreProduction'")
    public WebElement changeEnvironmentButton;
	
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Production']")
	@iOSFindBy(accessibility="Production")
    public WebElement productionEnvironment;
	
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Preprod']")
	@iOSFindBy(accessibility="PreProduction")
    public WebElement preProductionEnvironment;
	
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Development']")
	@iOSFindBy(accessibility="Beta")
    public WebElement devolpmentEnvironment;
	
	@FindBy(how = How.CSS, using = "#service-hatch-done")
	@AndroidFindBy(id = "set_environment_button")
	@iOSFindBy(accessibility="Done")
    public WebElement doneButton;
	
	@iOSFindBy(accessibility = "SIMULATED DEVICES")
	private WebElement simulatedDevicesButton;
	
	@iOSFindBy(accessibility = "SIMULATED THERMAL IMAGER DEVICE")
	private WebElement simulatedThermalImagerDeviceButton;
	
	@iOSFindBy(accessibility = "YES")
	private WebElement yesButton;
	
	@iOSFindBy(accessibility = "NO")
	private WebElement noButton;
	
	@AndroidFindBy(id = "action_bar_item_left")
	@iOSFindBy(accessibility="Back")
	private WebElement backButton;
	
	@AndroidFindBy(id = "com.fluke.deviceApp:id/workorderoverview_toggle")
	@iOSFindBy(accessibility="WORK ORDER OVERVIEW ENABLED")
	private WebElement workOrderOverviewEnabledButton;
	
	@iOSFindBy(accessibility = "UnlockField")
	private WebElement serviceHatchUnlockTextField;
	
	@HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
	@iOSXCUITFindBy(accessibility = "Current User")
	@iOSXCUITFindBy(accessibility = "CURRENT USER")
	private WebElement currentUserText;
	
	@iOSFindBy(accessibility = "805 MULTI AXES GRAPH ENABLED")
	private WebElement fc805ServiceHatchButton;
	
	@iOSXCUITFindBy(accessibility = "NOCTURNE BETA ONE ENABLED")
	private WebElement nocturneBetaOneServiceHatchButton;
	
	@iOSXCUITFindBy(iOSNsPredicate = "name LIKE 'NOCTURNE RELEASE ONE ENABLED'")
	private WebElement nocturneReleaseOneServiceHatchButton;
	
	@AndroidFindBy(id = "nocturne")
	private WebElement nocturneToggleButton;
	
	@iOSXCUITFindBy(accessibility = "ASSET REPORTS ENABLED")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/asset_report_toggle")
	private WebElement assetReportToggleButton;
	
	@AndroidFindBy(id = "force_upgrade")
	private WebElement forceUpgradeButton;
	
	@FindBy(how = How.CSS, using = ".col-lg-6")
	private WebElement topHeaderElement;
	
	private SignInPage signInPage;
	private GestureUtils gestureUtils;
	private SettingsPage settingsPage;
	private Actions actions;
	final public static String FORCE_UPGRADE = "force_upgrade";
	final public static String ASSET_REPORT = "asset_report";
	final public static String SIMULATED_DEVICES_BUTTON = "simulated_devices";
	private String iOSPageSource = null;
	
	public ServiceHatchPage()
	{
		CommonUtils.initElements(this, 3);
		signInPage = new SignInPage();
		gestureUtils = new GestureUtils();
		settingsPage = new SettingsPage();
		actions = new Actions(DriverManager.getDriver());
	}
	
	public WebElement getElement(String elementName)
	{
		switch(elementName)
		{
		case "force_upgrade":
			return forceUpgradeButton;
		case "asset_report":
			return assetReportToggleButton;
		case "simulated_devices":
			return simulatedDevicesButton;
		}
		return null;
	}
	
	public void changeEnvironment(String environmentName) throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				if(!signInPage.isEnvironmentChangeRequired(environmentName))
					return;
			}
			else if(DriverManager.getHandleUpgradeAlertFlag() && DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				ElementUtils.safeClick(signInPage.getSignInPageObject(SigninPageObjects.DECLINE_UPGRADE_ALERT));
			signInPage.openServiceHatch();
			changeEnvironmentButton.click();
			if(environmentName.equals(Config.PRODUCTION))
				ElementUtils.click(1, productionEnvironment);
			else if(environmentName.equals(Config.PREPRODUCTION))
				ElementUtils.click(1, preProductionEnvironment);
			else if(environmentName.equals(Config.DEVELOPMENT) || environmentName.equals(Config.BETA))
				ElementUtils.click(1, devolpmentEnvironment);
			ElementUtils.click(3, doneButton);
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				for(int i=0;i<3;i++)
				{
					ElementUtils.safeClick(DriverManager.getSignIn().getSignInPageObject(SigninPageObjects.ON_BOARD_NEXT_BUTTON));
				}
			}
		}
	}
	
	public boolean toggleFlag(String androidFeatureName, String iOSFeatureName)
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) && androidFeatureName != null)
			return true;
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) && iOSFeatureName != null)
			return true;
		else
			return false;
	}
	
	public void toggleFeature(String iOSFeatureName, String androidFeatureName, boolean toggleFlag, WebElement toggleButton, boolean isSignedIn) throws Exception
	{
		if(toggleFlag(androidFeatureName, iOSFeatureName))
		{
			if(isSignedIn)
				settingsPage.openServiceHatch();
			else
			{
				signInPage.openServiceHatch();
				if(DriverManager.getHandleUpgradeAlertFlag() && DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) && androidFeatureName.contains("Force Upgrade"))
					ElementUtils.safeClick(signInPage.getSignInPageObject(SigninPageObjects.DECLINE_UPGRADE_ALERT));
			}
			toggleFeature(iOSFeatureName, androidFeatureName, toggleFlag, toggleButton);
		}
	}
	
	public void toggleFeature(String iOSFeatureName, String androidFeatureName, boolean toggleFlag, WebElement toggleButton) throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			Config.appWidthCenterFlag = true;
			Config.useExistingPageSource = true;
			Config.iOSPageSource = null;
			if(iOSPageSource == null)
			{
				CommonUtils.wait(2);
				iOSPageSource = DriverManager.getDriver().getPageSource();
			}
				
			Config.iOSPageSource = iOSPageSource;
			gestureUtils.mScroll(iOSFeatureName, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, null, ScrollDiection.DOWN);
			ElementUtils.clickIfDisplayedAndEnabled(toggleButton);
			if(toggleFlag)
				ElementUtils.clickIfDisplayedAndEnabled(yesButton);
			else
				ElementUtils.clickIfDisplayedAndEnabled(noButton);
			ElementUtils.clickIfDisplayedAndEnabled(doneButton);
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			gestureUtils.scroll(null, null, null, androidFeatureName, 0, AndroidUtils.getScrollSteps(ScrollDiection.DOWN), null, null);
			if(GestureUtils.isAndroidScrollableElementFound)
			{
				if(toggleFlag)
				{
					if(toggleButton.getText().equals("OFF"))
						ElementUtils.clickIfDisplayedAndEnabled(toggleButton);
				}
				else
				{
					if(toggleButton.getText().equals("ON"))
						ElementUtils.clickIfDisplayedAndEnabled(toggleButton);
				}
				ElementUtils.clickIfDisplayedAndEnabled(backButton);
				if(DriverManager.getHandleUpgradeAlertFlag() && DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) && androidFeatureName.contains("Force Upgrade"))
					ElementUtils.safeClick(signInPage.getSignInPageObject(SigninPageObjects.DECLINE_UPGRADE_ALERT));
			}
			else
				CommonUtils.throwElementNotFoundException(androidFeatureName);
		}
	}
	
	public void toggleFeature(String iOSFeatureName, String androidFeatureName, String webFeatureName, boolean toggleFlag, WebElement toggleButton, boolean isSignedIn) throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			toggleFeature(iOSFeatureName, androidFeatureName, toggleFlag, toggleButton);
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			WebElement flukeLogo = DriverManager.getDriver().findElement(By.cssSelector(".header-logo-new")); 
			for(int i = 0; i < 3; i++)
			{
				flukeLogo.click();
			}
			actions.sendKeys("a").sendKeys("b").sendKeys(Keys.SPACE).sendKeys(Keys.ENTER).perform();
			ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, webFeatureName).click();
			doneButton.click();
		}
	}
	
	public void iOSToggleSimulatedDevices(boolean flag) throws Exception
	{
		ElementUtils.clickIfDisplayedAndEnabled(simulatedDevicesButton);
		if(flag)
			ElementUtils.clickIfDisplayedAndEnabled(yesButton);
		else
			ElementUtils.clickIfDisplayedAndEnabled(noButton);
	}
	
	public void toggleAssetReport(boolean flag) throws Exception
	{
		toggleFeature("ASSET REPORTS ENABLED", "Assset Report", flag, assetReportToggleButton, true);
	}
	
	public void clickOnDoneButton() throws Exception
	{
		ElementUtils.clickIfDisplayedAndEnabled(doneButton);
	}
}
