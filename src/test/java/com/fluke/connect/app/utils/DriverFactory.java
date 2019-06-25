package com.fluke.connect.app.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.fluke.connect.app.functional.client.pages.HomePage;
import com.fluke.connect.app.functional.client.pages.ServiceHatchPage;
import com.fluke.connect.app.functional.client.pages.SignInPage;
import com.fluke.connect.app.functional.client.pages.Switcher;
import com.fluke.connect.app.others.SpeedTest;
import com.fluke.connect.app.functional.client.pages.SignInPage.SigninPageObjects;
import com.fluke.connect.app.testdata.FCCM174X;
import com.fluke.connect.app.testdata.FCCM3540;
import com.fluke.connect.app.testdata.FCCM3550;
import com.fluke.connect.app.testdata.FCCM3560;
import com.fluke.connect.app.testdata.FCM1555.GRAPH;
import com.fluke.connect.app.testdata.Graph;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

@SuppressWarnings("unused")
public class DriverFactory 
{
	public WebDriver driver;
	private DesiredCapabilities capabilities;
	private AppiumDriverLocalService service;
	private SignInPage signInPage;
	private ServiceHatchPage serviceHatchPage;
	private Switcher switcher;
	private HomePage homePage;
	private ChromeOptions chromeOptions = new ChromeOptions();
	private ExtentReports extentReport;
	private GestureUtils gestureUtils;
	
	@BeforeTest(groups = {Config.IOS_SMOKE_TESTS, Config.ANDROID_SMOKE_TESTS, Config.WEB_SMOKE_TESTS,
			Config.IOS_UAT_TESTS, Config.ANDROID_UAT_TESTS, Config.WEB_UAT_TESTS, 
			Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX, Config.CNX_ANDROID, 
			Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX_IOS, Config.CNX_WEB,
			Config.TI_FCM, Config.SIGNIN, Config.TI_FCM_ANDROID, Config.TI_FCM_WEB,Config.TI_FCM_IOS, 
			Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS,
			Config.TEST_ASSET, Config.ASSET_UAT_TEST, 
			Config.WORK_ORDER_TESTS, Config.WORK_ORDER_UAT, Config.WORK_ORDER_805_TESTS, 
			Config.SETTINGS_TESTS, 
			Config.TEAM_TESTS_WEB, Config.TEAM_TESTS,
			FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS, FCCM3540.EVENT_LOGGING_TESTS,
			FCCM3540.UAT_3540, FCCM3540.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_VERIFICATION_TESTS, FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS, 
			FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_SETUP_TESTS, FCCM3550.SESSION_END_TESTS, FCCM3550.SESSION_DELETE_TESTS,
			FCCM3550.COMPLETED_SESSION_LIST_TESTS, FCCM3550.SESSION_LIST_TESTS,
			FCCM3560.SESSION_CONFIG_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS, FCCM3560.SESSION_LIST_TESTS,
			FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_TESTS, FCCM3560.DEV_TESTS, FCCM3560.SESSION_SETUP_TESTS,
			FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS,
		    Config.EEVEE_MEASUREMENT_ANDROID_TESTS, Config.EEVEE_MEASUREMENT_IOS_TESTS, 
			FCCM174X.SESSION_CONFIG_TESTS,FCCM174X.FCCM174X_API_TESTS, FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS,FCCM174X.FCCM174X_LIVESESSION_TESTS,
			Config.WIFI_TOOL_TESTS, Config.WIFI_TOOL_125B_TESTS, Config.WIFI_TOOL_173X_TESTS,
			Config.REPORT_TESTS, Config.REPORT_TESTS_WEB, Config.REPORT_UAT_TEST, Config.FC1555 , Config.FC1555_UAT, 
			Config.IOS_WO_SMOKE_EXT_TESTS, Config.IOS_ASSET_SMOKE_EXT_TESTS, Config.IOS_3540_SMOKE_EXT_TESTS, Config.WO_WEB_SMOKE_EXT_TESTS,
			Config.FC1555_WEB,Config.IOS_REPORT_SMOKE_EXT_TESTS,  Config.ANDROID_FC1555_EXT_SMOKE_TESTS, 
			Config.IOS_3560_SMOKE_EXT_TESTS,Config.IOS_1555_SMOKE_EXT_TESTS,	Config.ANDROID_REPORT_EXT_SMOKE_TESTS, 
			Config.ANDROID_WO_SMOKE_EXT_TESTS, Config.ANDROID_ASSET_SMOKE_EXT_TESTS, Config.WORK_ORDER_WEB_TESTS, 
			Config.WEB_SMOKE_ASSET_EXTENDED, Config.ANDROID_SMOKE_EXTENDED_TESTS,Config.FC1555_ANALYSIS,Config.ASSET_ANDROID_UAT,
			Config.WEB_SMOKE_CM_TESTS, Config.WORK_ORDER_IOS_TESTS, Config.VOC_WO, Config.LOCALIZATION_TESTS, Config.TEMP, Config.ANDROID_BUG_AUTOMATION,
			SpeedTest.SPEED_TEST,Graph.GRAPHDEV

	}) 
	        		
	        

	@Parameters({ "platformName", "platformVersion", "app", "bundleID", "appPackage", "appActivity", "deviceName",
			"driverName", "environmentName", "userName", "password", "isRealDevice", "isSignInRequired", "deviceUdid",
			"xcodeOrgId", "xcodeSigningId", "isFeature", "isCodeRunningOnEverettMachine", "browserName", "url",
			"appInstallFlag", "isFCApp", "handleUpgradeAlert", "testResultsReportName", "appendTestResults", 
			"noResetFlag", "wdaLocalPort", "systemPort", "useExistingData", "isChangeEnvironmentRequired", "isSmokeSuite"})
	public void setUp(@Optional("null") String platformName, @Optional("null") String platformVersion,
			@Optional("null") String app, @Optional("null") String bundleId, @Optional("null") String appPackage,
			@Optional("null") String appActivity, @Optional("null") String deviceName,
			@Optional("null") String driverName, @Optional("null") String environmentName,
			@Optional("null") String userName, @Optional("null") String password,
			@Optional("false") Boolean isRealDevice, @Optional("true") Boolean isSignInRequired,
			@Optional("null") String deviceUdid, @Optional("null") String xcodeOrgId,
			@Optional("null") String xcodeSigningId, @Optional("false") Boolean isFeature,
			@Optional("false") Boolean isCodeRunningOnEverettMachine, @Optional("null") String browserName,
			@Optional("null") String url, @Optional("false") Boolean appInstallFlag, @Optional("true") Boolean isFCApp,
			@Optional("true") Boolean handleUpgradeAlert, @Optional("no value") String testResultsReportName,
			@Optional("false") Boolean appendTestResults, @Optional("false") Boolean noResetFlag, 
			@Optional("no value") String wdaLocalPort, @Optional("no value") String systemPort, @Optional("false") Boolean useExistingData,
			@Optional("true") Boolean isChangeEnvironmentRequired, @Optional("false") Boolean isSmokeSuite) throws Exception 
		{
		try 
		{
			if(testResultsReportName.equals("no value")) 
				testResultsReportName = "Test Results.html";
			extentReport = new ExtentReportUtils().createInstance(testResultsReportName, appendTestResults);
	        DriverManager.setExtentReport(extentReport);
	        DriverManager.getExtentReport().setSystemInfo("Platform Name", driverName);
	        Map<String, String> env = new HashMap<>(System.getenv());
	        env.put("PATH", "/usr/local/bin:" + env.get("PATH"));
	        if(driverName.equals(Config.ANDROID_DRIVER) || driverName.equals(Config.IOS_DRIVER)) 
	        {
	       	service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().withIPAddress("127.0.0.1").withEnvironment(env).usingAnyFreePort());
	       	service.start();
	        	capabilities = new DesiredCapabilities();
	        	capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
	        	capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
	        	capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
	        	capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "30000");
	        	capabilities.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, true);
	        	if(appInstallFlag) 
	        		capabilities.setCapability("app", app);
	        	if(driverName.equals(Config.ANDROID_DRIVER)) 
	        	{
	        		capabilities.setCapability("automationName", "uiautomator2");
	        		capabilities.setCapability("appPackage", appPackage);
	        		capabilities.setCapability("appActivity", appActivity);
	          		capabilities.setCapability("skipUnlock", true);
	        		if(noResetFlag)
	        			capabilities.setCapability("noReset", true);
	        		capabilities.setCapability(MobileCapabilityType.UDID, deviceUdid);
	        		capabilities.setCapability("systemPort", systemPort);
	        		driver = new AndroidDriver<MobileElement>(service.getUrl(), capabilities);
	        		DriverManager.setDriver(driver);
	        		DriverManager.setDriverName(driverName);
	        	}  
	        	else if(driverName.equals(Config.IOS_DRIVER)) 
	        	{
	        		capabilities.setCapability("bundleId", bundleId);
	        		capabilities.setCapability("automationName", "XCUITest");
	        		capabilities.setCapability("wdaLocalPort", wdaLocalPort);
	        		capabilities.setCapability("useNewWDA", true);
	        		if(isRealDevice) 
	        		{
	        			capabilities.setCapability("udid", deviceUdid);
	        			capabilities.setCapability("xcodeOrgId", xcodeOrgId);
	        			capabilities.setCapability("xcodeSigningId", xcodeSigningId);
	        		}
	        		driver = new IOSDriver<MobileElement>(service.getUrl(), capabilities);
	        		DriverManager.setDriver(driver);
	        		DriverManager.setDriverName(driverName);
	        	}
	        	DriverManager.getExtentReport().setSystemInfo("Platform Version", platformVersion);
	        	DriverManager.getExtentReport().setSystemInfo("Device Name", deviceName);
	        } 
	        else if(driverName.equals(Config.WEB_DRIVER)) 
	        {
	        	if(browserName.equals("ChromeHeadless")) 
	        	{
	        		System.setProperty("webdriver.chrome.driver", "./drivers/chromedrivercanary");
	        		chromeOptions.setBinary("/Applications/Google Chrome Canary.app/Contents/MacOS/Google Chrome Canary");
	        		chromeOptions.addArguments("--headless");
	        		chromeOptions.addArguments("--disable-gpu");
	        		chromeOptions.addArguments("window-size=2560x1600");
	        		driver = new ChromeDriver(chromeOptions);
	        		DriverManager.setDriver(driver);
	        		DriverManager.setDriverName(driverName);
	        	} 
	        	else if(browserName.equals("Chrome")) 
	        	{
	        		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
	        		driver = new ChromeDriver();
	        		DriverManager.setDriver(driver);
	        		DriverManager.setDriverName(driverName);
	        		//driver.manage().window().setPosition(new Point(0, 0));
	        		//driver.manage().window().setSize(new Dimension(VisualUtils.getScreenDimensionObject().width, VisualUtils.getScreenDimensionObject().height));
	        		driver.manage().window().setSize(new Dimension(1260, 2000));
	        	} 
	        	else if(browserName.equals("Firefox")) 
	        	{
	        		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");
	        		driver = new FirefoxDriver();
	        		DriverManager.setDriver(driver);
	        		DriverManager.setDriverName(driverName);
	        	}
	        	driver.get(url);
	        	DriverManager.getExtentReport().setSystemInfo("Browser Name", browserName);
	        	DriverManager.setBrowserName(browserName);
	        }
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        DriverManager.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	        DriverManager.setEnvironmentName(environmentName);
	        DriverManager.setUserName(userName);
	        DriverManager.setPassword(password);
	        DriverManager.setDeviceName(deviceName);
	        DriverManager.setDeviceType(isRealDevice);
	        DriverManager.setAppInstallFlag(appInstallFlag);
	        DriverManager.setUseExistingDataFlag(useExistingData);
	        DriverManager.setHandleUpgradeAlertFlag(handleUpgradeAlert);
	        DriverManager.setSmokeSuiteFlag(isSmokeSuite);
	        signInPage = new SignInPage();
	        serviceHatchPage = new ServiceHatchPage();
	        switcher = new Switcher();
	        homePage = new HomePage();
	        gestureUtils = new GestureUtils();
	        DriverManager.setSignIn(signInPage);
	        DriverManager.setSwitcher(switcher);
	        DriverManager.setGestureUtils(gestureUtils);
	        if(isChangeEnvironmentRequired) {
	        	signInPage.handleBeforeSignInAlerts();
	        	if(handleUpgradeAlert && driverName.equals(Config.ANDROID_DRIVER)) 
	        		serviceHatchPage.toggleFeature(null, "Force Upgrade", false, serviceHatchPage.getElement(ServiceHatchPage.FORCE_UPGRADE), false);
	        	serviceHatchPage.changeEnvironment(environmentName);
	        }
	        	
		}
		catch(Throwable e) 
		{
			e.printStackTrace();
			throw new Exception("Unable to signin");
		}
	}
	
	@AfterTest(groups = {Config.IOS_SMOKE_TESTS, Config.ANDROID_SMOKE_TESTS, Config.WEB_SMOKE_TESTS,
			Config.IOS_UAT_TESTS, Config.ANDROID_UAT_TESTS, Config.WEB_UAT_TESTS, 
			Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX, Config.CNX_ANDROID, 
			Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX_IOS, Config.CNX_WEB,
			Config.TI_FCM, Config.SIGNIN, Config.TI_FCM_ANDROID, Config.TI_FCM_WEB,Config.TI_FCM_IOS, 
			Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS,
			Config.TEST_ASSET, Config.ASSET_UAT_TEST, 
			Config.WORK_ORDER_TESTS, Config.WORK_ORDER_UAT, Config.WORK_ORDER_805_TESTS, 
			Config.SETTINGS_TESTS, 
			Config.TEAM_TESTS_WEB, Config.TEAM_TESTS,
			FCCM3540.SESSION_VERIFICATION_TESTS, FCCM3540.SESSION_VERIFICATION_WEB_TESTS, FCCM3540.EVENT_LOGGING_TESTS,
			FCCM3540.UAT_3540, FCCM3540.COMPLETED_SESSION_VERIFICATION_WEB_TESTS,
			FCCM3550.SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_VERIFICATION_TESTS, FCCM3550.COMPLETED_SESSION_VERIFICATION_TESTS, 
			FCCM3550.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3550.SESSION_SETUP_TESTS, FCCM3550.SESSION_END_TESTS, FCCM3550.SESSION_DELETE_TESTS,
			FCCM3550.COMPLETED_SESSION_LIST_TESTS, FCCM3550.SESSION_LIST_TESTS,
			FCCM3560.SESSION_CONFIG_TESTS, FCCM3560.COMPLETED_SESSION_VERIFICATION_TESTS, FCCM3560.SESSION_LIST_TESTS,
			FCCM3560.SESSION_VERIFICATION_WEB_TESTS, FCCM3560.SESSION_VERIFICATION_TESTS, FCCM3560.DEV_TESTS, FCCM3560.SESSION_SETUP_TESTS,
			FCCM3560.COMPLETED_SESSION_VERIFICATION_WEB_TESTS, FCCM3560.PROD_TESTS, FCCM3560.PROD_WEB_TESTS, FCCM3560.UAT_TESTS, FCCM3560.UAT_WEB_TESTS,
		    Config.EEVEE_MEASUREMENT_ANDROID_TESTS, Config.EEVEE_MEASUREMENT_IOS_TESTS, 
			FCCM174X.SESSION_CONFIG_TESTS,FCCM174X.FCCM174X_API_TESTS, FCCM174X.FCCM174X_INSTALL_COMM_SESSIONS_TESTS,FCCM174X.FCCM174X_LIVESESSION_TESTS,
			Config.WIFI_TOOL_TESTS, Config.WIFI_TOOL_125B_TESTS, Config.WIFI_TOOL_173X_TESTS,
			Config.REPORT_TESTS, Config.REPORT_TESTS_WEB, Config.REPORT_UAT_TEST, Config.FC1555 , Config.FC1555_UAT, 
			Config.IOS_WO_SMOKE_EXT_TESTS, Config.IOS_ASSET_SMOKE_EXT_TESTS, Config.IOS_3540_SMOKE_EXT_TESTS, Config.WO_WEB_SMOKE_EXT_TESTS,
			Config.FC1555_WEB,Config.IOS_REPORT_SMOKE_EXT_TESTS,  Config.ANDROID_FC1555_EXT_SMOKE_TESTS, 
			Config.IOS_3560_SMOKE_EXT_TESTS,Config.IOS_1555_SMOKE_EXT_TESTS,	Config.ANDROID_REPORT_EXT_SMOKE_TESTS, 
			Config.ANDROID_WO_SMOKE_EXT_TESTS, Config.ANDROID_ASSET_SMOKE_EXT_TESTS, Config.WORK_ORDER_WEB_TESTS, 
			Config.WEB_SMOKE_ASSET_EXTENDED, Config.ANDROID_SMOKE_EXTENDED_TESTS,Config.FC1555_ANALYSIS,Config.ASSET_ANDROID_UAT,
			Config.WEB_SMOKE_CM_TESTS, Config.WORK_ORDER_IOS_TESTS,Config.VOC_WO, Config.LOCALIZATION_TESTS, Config.ANDROID_BUG_AUTOMATION,Graph.GRAPHDEV
	}) 


	@Parameters({"driverName"})
	public void tearDown(String driverName) {
		try {

			if (driverName.equals(Config.ANDROID_DRIVER)|| driverName.equals(Config.IOS_DRIVER)) 
			{
				SignInPage.iOSServiceHatchPasswordFlag = true;
			  	CommonUtils.wait(2);
		  		driver.quit();
				service.stop();
			} 
			else 
			{
				CommonUtils.wait(2);
				 driver.quit();
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
