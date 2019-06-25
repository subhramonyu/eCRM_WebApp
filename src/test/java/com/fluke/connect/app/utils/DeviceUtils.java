package com.fluke.connect.app.utils;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.ScrollDiection;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class DeviceUtils 
{
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Wi-Fi\")")
	@iOSXCUITFindBy(accessibility="Wi-Fi")
	private WebElement wifiButtonSettingsPage;   //For Android Connection Button
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Wi-Fi\")")
	private WebElement wifiButtonAndroid;
	
	@AndroidFindBy(className = "android.widget.Switch")
	@iOSXCUITFindBy(iOSNsPredicate = "name = 'Wi-Fi' AND type == 'XCUIElementTypeSwitch'")
	private WebElement wifiSwitchButton;
	
	@AndroidFindBy(id = "com.android.settings:id/btn_wifi_connect1")
	@iOSXCUITFindBy(accessibility="Join")
	private WebElement joinButton;
	
	@iOSXCUITFindBy(accessibility="Forget This Network")
	private WebElement forgetThisNetworkButton;
	
	@iOSXCUITFindBy(accessibility="Settings")
	private WebElement backButtonToSettingsPage;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Connect To Wi-Fi Networks\")")
    @iOSXCUITFindBy(accessibility = "More Info")
    private WebElement wifiStatus;
	
	@AndroidFindBy(id = "com.android.settings:id/password")
	@iOSXCUITFindBy(accessibility="Password")
	private WebElement passwordTextField;
	
	@iOSXCUITFindBy(accessibility="Settings")
    private WebElement iPhoneSettingsAppIcon;
	
	@AndroidFindBy(id = "android:id/button2")
    private WebElement cancelButton;
	
	private Map<String, Object> objectParameters = new HashMap<>();
	private JavascriptExecutor javascriptExecutor;

	private GestureUtils gestureUtils;
	final public static String IOS_SETTINGS_APP_BUNDLE_ID = "com.apple.Preferences";
	final public static String ANDROID_SETTINGS_PACKAGE = "com.android.settings";
	final public static String ANDROID_SETTINGS_ACTIVITY = "com.android.settings.HWSettings";
	
	
	public DeviceUtils()
	{
		CommonUtils.initElements(this, 5);
		gestureUtils = new GestureUtils();
		javascriptExecutor = (JavascriptExecutor) DriverManager.getDriver();
	}
	
	public enum DeviceUtilsObjects
	{
		iPHONE_SETTINGS_APP_ICON, ANDROID_SETTINGS_PACKAGE, ANDROID_SETTINGS_ACTIVITY, WI_FI_BUTTONS_SETTINGS_PAGE, 
		IOS_SETTINGS_BUNDLE_ID, CANCEL_BUTTON
	}
	
	public WebElement getDeviceUtilsWebElement(DeviceUtilsObjects objectName)
	{
		switch(objectName)
		{
		case iPHONE_SETTINGS_APP_ICON:
			return iPhoneSettingsAppIcon;
		case WI_FI_BUTTONS_SETTINGS_PAGE:
			return wifiButtonSettingsPage;
		case CANCEL_BUTTON:
			return cancelButton;
		default:
				return null;
		}
	}
	
	public String getDeviceUtilsAttributes(DeviceUtilsObjects objectName)
	{
		switch(objectName)
		{
		case ANDROID_SETTINGS_PACKAGE:
			return ANDROID_SETTINGS_PACKAGE;
		case ANDROID_SETTINGS_ACTIVITY:
			return ANDROID_SETTINGS_ACTIVITY;
		case IOS_SETTINGS_BUNDLE_ID:
			return IOS_SETTINGS_APP_BUNDLE_ID;
		default:
				return null;
		}
	}
	
	public void openWiFiPageAndTrunOnWiFiIfOff() throws Exception
	{
		IOSUtils.getIOSDriver().runAppInBackground(Duration.ofSeconds(-1));
        ElementUtils.clickIfDisplayedAndEnabled(iPhoneSettingsAppIcon);
        ElementUtils.clickIfDisplayedAndEnabled(wifiButtonSettingsPage);
        if(isWiFiOff())
        {
            turnWiFi(true);
        }
    
	}
	
	 public void launchFCApp() throws Exception
	 {
	        IOSUtils.getIOSDriver().launchApp();
	 }
	
	public boolean isConnectedToNetwork(String networkName) throws Exception
	{
		CommonUtils.ifDisplayedThenClick(networkName);
		if(forgetThisNetworkButton.isDisplayed())
		{
			ElementUtils.clickIfDisplayedAndEnabled(wifiButtonSettingsPage);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void clickBackButtonToSettingsPage() throws Exception
	{
		ElementUtils.clickIfDisplayedAndEnabled(backButtonToSettingsPage);
	}
	
	//********************************************* Below are New Improved Methods **************************************
	
	public boolean connectToNetwork(String networkName, String password) throws Exception
	{
		CommonUtils.wait(5);  //wait for networks to appear
		Config.isDynamicPage = true;
		gestureUtils.mScroll(networkName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
		ElementUtils.click(10, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, networkName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, networkName, null, null);
		clickAdditionalConnectButton(DriverManager.getDeviceName());
		try
		{
			if(ElementUtils.isDisplayed(1, passwordTextField))
			{
				ElementUtils.sendKeys(passwordTextField, password);
				joinButton.click();
				CommonUtils.wait(2);
				if(ElementUtils.isDisplayed(10, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, "Wi-Fi", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "More Info", null, null))
					return true;
				else
					return false;
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			throw new Exception();
		}
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			AndroidUtils.back();
		return true;
	}
	
	public void toggleWiFi(boolean flag, String elementAttributeValue, boolean resetSesstingsPage) throws Exception
	{
		launchOtherApp(IOS_SETTINGS_APP_BUNDLE_ID, AndroidUtils.getPackageName(DriverManager.getDeviceName()), AndroidUtils.getActivityName(DriverManager.getDeviceName()));
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
		    CommonUtils.wait(1);
			IOSUtils.terminateApp(IOS_SETTINGS_APP_BUNDLE_ID);
		    launchOtherApp(IOS_SETTINGS_APP_BUNDLE_ID, null, null);
		}
		turnWiFi(flag);
	}
	
	public void launchOtherApp(String iOSOtherAppBundleID, String androidAppPackage, String androidAppActivity) throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			objectParameters.clear();
			objectParameters.put("bundleId", iOSOtherAppBundleID);
		    javascriptExecutor.executeScript("mobile: launchApp", objectParameters);
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			AndroidUtils.launchOtherApp(androidAppPackage, androidAppActivity);
		}
	}
	
	public void toogleFCAPP(boolean flag, String toggleDurationInSeconds)
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			if(flag)
				 IOSUtils.getIOSDriver().launchApp();
			else
				IOSUtils.getIOSDriver().runAppInBackground(Duration.ofSeconds(Integer.parseInt(toggleDurationInSeconds)));
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			if(flag)
				 AndroidUtils.getAndroidDriver().launchApp();
			else
				AndroidUtils.getAndroidDriver().runAppInBackground(Duration.ofSeconds(Integer.parseInt(toggleDurationInSeconds)));
		}
	}
	
	public void turnWiFi(boolean flag) throws Exception
	{
		getWiFiObject(DriverManager.getDeviceName()).click();
		if(flag)
		{
			if(isWiFiOff())
				wifiSwitch();
		}
		else
		{
			if(isWiFiOff())
				return;
			else
				wifiSwitch();
		}
	}
	
	public void wifiSwitch() throws Exception
	{
		wifiSwitchButton.click();
	}

	public boolean isWiFiOff() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			CommonUtils.wait(2);
			if(wifiSwitchButton.getText().equals("1"))
				return false;
			else
				return true;
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			ElementUtils.click(1, wifiButtonAndroid);
			if(DriverManager.getDriver().getPageSource().contains("improve location accuracy"))
				return true;
			else
				return false;
		}
		return false;
	}
	
	public void launchAndroidWiFiPage() throws Exception
	{
		getWiFiObject(DriverManager.getDeviceName()).click();
		wifiButtonAndroid.click();
	}
	
	public WebElement getWiFiObject(String deviceName)
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			switch(deviceName)
			{
			case "ANE-AL00":
				return ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Wireless & networks", null, null, null, null);
			case "SM-G920I":
				return ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Connections", null, null, null, null);
			default:
				return wifiButtonSettingsPage;
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			return wifiButtonSettingsPage;
		return wifiButtonSettingsPage;
	}
	
	public void clickAdditionalConnectButton(String deviceName)
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			switch(deviceName)
			{
			case "ANE-AL00":
				ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "CONNECT", null, null, null, null).click();
			default:
				return;
			}
		}
	}
	
	@Deprecated
	public void launchOtherApp(WebElement iOSOtherAppIcon, String iOSOtherAppBundleID, String androidAppPackage, String androidAppActivity, String elementAttributeValue) throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			toogleFCAPP(false, "-1");
			ElementUtils.click(1, iOSOtherAppIcon);
			if(iOSOtherAppBundleID != null)
			{
				ElementUtils.isDisplayed(5, null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, elementAttributeValue, null, null);
				IOSUtils.terminateApp(IOS_SETTINGS_APP_BUNDLE_ID);
				ElementUtils.click(1, iOSOtherAppIcon);
			}
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			AndroidUtils.launchOtherApp(androidAppPackage, androidAppActivity);
		}
	}

}
