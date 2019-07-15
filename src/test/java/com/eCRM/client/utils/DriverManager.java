package com.eCRM.client.utils;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.eCRM.client.testpages.SignInPage;
import com.eCRM.client.testpages.Switcher;

public class DriverManager {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private static ThreadLocal<String> driverName = new ThreadLocal<String>();
	private static ThreadLocal<String> browserName = new ThreadLocal<String>();
	private static ThreadLocal<String> environmentName = new ThreadLocal<String>();
	private static ThreadLocal<String> userName = new ThreadLocal<String>();
	private static ThreadLocal<String> password = new ThreadLocal<String>();
	private static ThreadLocal<String> deviceName = new ThreadLocal<String>();
	private static ThreadLocal<Boolean> deviceType = new ThreadLocal<Boolean>();
	private static ThreadLocal<Boolean> appInstallFlag = new ThreadLocal<Boolean>();
	private static ThreadLocal<Boolean> handleUpgradeAlertFlag = new ThreadLocal<Boolean>();
	private static ThreadLocal<Boolean> isSmokeSuiteFlag = new ThreadLocal<Boolean>();
	private static ThreadLocal<ExtentReports> extentReports = new ThreadLocal<ExtentReports>();
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	private static ThreadLocal<Boolean> useExistingDataFlag = new ThreadLocal<Boolean>();
	private static ThreadLocal<SignInPage> signIn = new ThreadLocal<SignInPage>();
	private static ThreadLocal<Switcher> switcher = new ThreadLocal<Switcher>();
	private static ThreadLocal<GestureUtils> gestureUtils = new ThreadLocal<GestureUtils>();
	private static ThreadLocal<String> featureName = new ThreadLocal<String>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(WebDriver driverObject) {
		driver.set(driverObject);
	}

	public static SignInPage getSignIn() {
		return signIn.get();
	}

	public static void setSignIn(SignInPage signInObject) {
		signIn.set(signInObject);
	}

	public static Switcher getSwitcher() {
		return switcher.get();
	}

	public static void setSwitcher(Switcher switcherObject) {
		switcher.set(switcherObject);
	}

	public static GestureUtils getGestureUtils() {
		return gestureUtils.get();
	}

	public static void setGestureUtils(GestureUtils gestureUtilsObject) {
		gestureUtils.set(gestureUtilsObject);
	}

	public static String getDriverName() {
		return driverName.get();
	}

	public static void setDriverName(String name) {
		driverName.set(name);
	}

	public static String getBrowserName() {
		return browserName.get();
	}

	public static void setBrowserName(String name) {
		browserName.set(name);
	}

	public static String getEnvironmentName() {
		return environmentName.get();
	}

	public static void setEnvironmentName(String name) {
		environmentName.set(name);
	}

	public static String getUserName() {
		return userName.get();
	}

	public static void setUserName(String name) {
		userName.set(name);
	}

	public static String getPassword() {
		return password.get();
	}

	public static void setPassword(String passwordValue) {
		password.set(passwordValue);
	}

	public static String getDeviceName() {
		return deviceName.get();
	}

	public static void setDeviceName(String name) {
		deviceName.set(name);
	}

	public static Boolean isRealDevice() {
		return deviceType.get();
	}

	public static void setDeviceType(Boolean value) {
		deviceType.set(value);
	}

	public static Boolean getAppInstallFlag() {
		return appInstallFlag.get();
	}

	public static void setAppInstallFlag(Boolean value) {
		appInstallFlag.set(value);
	}

	public static Boolean getUseExistingDataFlag() {
		return useExistingDataFlag.get();
	}

	public static void setUseExistingDataFlag(Boolean value) {
		useExistingDataFlag.set(value);
	}

	public static Boolean getHandleUpgradeAlertFlag() {
		return handleUpgradeAlertFlag.get();
	}

	public static void setHandleUpgradeAlertFlag(Boolean value) {
		handleUpgradeAlertFlag.set(value);
	}

	public static Boolean isSmokeSuite() {
		return isSmokeSuiteFlag.get();
	}

	public static void setSmokeSuiteFlag(Boolean value) {
		isSmokeSuiteFlag.set(value);
	}

	public static ExtentReports getExtentReport() {
		return extentReports.get();
	}

	public static void setExtentReport(ExtentReports extentReport) {
		extentReports.set(extentReport);
	}

	public static ExtentTest getExtentTest() {
		return extentTest.get();
	}

	public static void setExtentTest(ExtentTest testInstance) {
		extentTest.set(testInstance);
	}

	public static void closeApp() {
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			IOSUtils.getIOSDriver().closeApp();
		else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			AndroidUtils.getAndroidDriver().closeApp();
	}

	public static void launchApp() {
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			IOSUtils.getIOSDriver().launchApp();
		else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			AndroidUtils.getAndroidDriver().launchApp();
	}
	
	public static String getFeatureName() {
		return featureName.get();
	}

	public static void setFeatureName(String name) {
		featureName.set(name);
	}

}
