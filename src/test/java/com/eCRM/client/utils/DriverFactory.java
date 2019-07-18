package com.eCRM.client.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.eCRM.client.testpages.SignInPage;
import com.google.j2objc.annotations.ReflectionSupport.Level;

import net.jsourcerer.webdriver.jserrorcollector.JavaScriptError;

@SuppressWarnings("unused")
public class DriverFactory {
	public WebDriver driver;
	private DesiredCapabilities capabilities;
	private SignInPage signInPage;
	private ChromeOptions chromeOptions = new ChromeOptions();
	private GestureUtils gestureUtils;

	@BeforeTest(groups = { Config.REGRESSION_TEST })

	@Parameters({ "browserName", "environmentName", "userName", "password", "isSignInRequired" })
	public void setUp(@Optional("null") String browserName, @Optional("null") String environmentName,
			@Optional("null") String userName, @Optional("null") String password,
			@Optional("true") Boolean isSignInRequired) throws Exception {

		try {
			if (browserName.equals("ChromeHeadless")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedrivercanary");
				chromeOptions.setBinary("/Applications/Google Chrome Canary.app/Contents/MacOS/Google Chrome Canary");
				chromeOptions.addArguments("--headless");
				chromeOptions.addArguments("--disable-gpu");
				chromeOptions.addArguments("window-size=2560x1600");
				driver = new ChromeDriver(chromeOptions);
				DriverManager.setDriver(driver);
				DriverManager.setBrowserName("ChromeHeadless");
			}
			
			else if (browserName.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver", Config.DRIVER_PATH+"/chromedriver.exe");
				
				// loggingprefs = new LoggingPreferences();
				//loggingprefs.enable("browser", Level.NATIVE_ONLY);
				//capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);

				ChromeOptions chromeOptions = new ChromeOptions();
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("download.default_directory", Config.DEFAULT_DOWNLOAD_PATH);
				prefs.put("download.prompt_for_download", false);
				chromeOptions.setExperimentalOption("prefs", prefs);
				chromeOptions.addArguments("--disable-pdf-material-ui");
				chromeOptions.addArguments("--disable-out-of-process-pdf");
				chromeOptions.addArguments("--start-maximized");
				capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

				driver = new ChromeDriver(capabilities);
				driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
				DriverManager.setDriver(driver);
				DriverManager.setBrowserName(Config.CHROME_DRIVER);
				
			} else if (browserName.equals("Firefox")) {
			
			
				System.setProperty("webdriver.gecko.driver", Config.DRIVER_PATH+"/geckodriver.exe");
				FirefoxProfile firefoxProfile = new FirefoxProfile();
				firefoxProfile.setPreference("browser.download.folderList", 2);
				firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
				firefoxProfile.setPreference("browser.download.dir", Config.DEFAULT_DOWNLOAD_PATH);
				firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/xls");
				firefoxProfile.setPreference("pdfjs.disabled", true);
				firefoxProfile.setPreference("plugin.scan.Acrobat", "99.0");
				firefoxProfile.setPreference("plugin.scan.plid.all", false);
				firefoxProfile.setPreference("plugin.disable_full_page_plugin_for_types", "application/pdf");

				JavaScriptError.addExtension(firefoxProfile);
				FirefoxOptions options = new FirefoxOptions();
				options.setProfile(firefoxProfile);
				driver = new FirefoxDriver(options);
				driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
				DriverManager.setDriver(driver);
				DriverManager.setBrowserName(Config.FIREFOX_DRIVER);
			}
			driver.get(url);
			DriverManager.setBrowserName(browserName);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			DriverManager.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			DriverManager.setEnvironmentName(environmentName);
			DriverManager.setUserName(userName);
			DriverManager.setPassword(password);
			signInPage = new SignInPage();
			gestureUtils = new GestureUtils();
			DriverManager.setSignIn(signInPage);
		} catch (

		Throwable e) {
			e.printStackTrace();
			throw new Exception("Unable to signin");
		}
	}

	@AfterTest(groups = { Config.REGRESSION_TEST })

	@Parameters({ "driverName" })
	public void tearDown(String driverName) {
		try {
			CommonUtils.wait(2);
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
