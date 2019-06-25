package com.fluke.connect.app.functional.client.pages;

import java.time.temporal.ChronoUnit;
import org.openqa.selenium.WebElement;

import com.fluke.connect.app.utils.AndroidUtils;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.ScrollDiection;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.Gestures;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SettingsPage 
{
	@AndroidFindBy(id ="com.fluke.deviceApp:id/end_user_license_agreement")
	@iOSFindBy(accessibility="End User License Agreement")
	private WebElement endUserLicenseAgreementButton;
	
	@AndroidFindBy(id ="com.fluke.deviceApp:id/privacy_policy")
	@iOSFindBy(accessibility="Privacy Policy")
	private WebElement privacyPolicyButton;
	
	@iOSFindBy(accessibility="Done")
	private WebElement doneButton;
	
	@WithTimeout(time=2, chronoUnit = ChronoUnit.SECONDS)
	@iOSFindBy(accessibility="Done")
	private WebElement reliableDoneButton;
	
	@iOSFindBy(accessibility="hatch")
	private WebElement hatchButton;
	
	@AndroidFindBy(id = "settings_build_version_text")
	@iOSXCUITFindBy(iOSNsPredicate = "name CONTAINS 'Server'")
	private WebElement buildVersionText;
	
	@AndroidFindBy(className = "android.widget.EditText")
	@iOSFindBy(accessibility="UnlockField")
	private WebElement serviceHatchUnlockTextField;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/sync_now")
	private WebElement syncNowButton;
	
	@iOSFindBy(xpath = "//XCUIElementTypeWebView")
	private WebElement endUserLicenseWebViewElement;
	
	@iOSFindBy(xpath = "//XCUIElementTypeWebView")
	private WebElement privacyPolicyWebViewElement;
	
	@AndroidFindBy(id="android:id/button1")
	private WebElement androidServiceHatchOkButton;
	
	private Switcher switcher;
	private Gestures gesture;
	private GestureUtils mGestureUtils;
	
	public SettingsPage()
	{
		CommonUtils.initElements(this);
		switcher = new Switcher();
		gesture = new Gestures();
		mGestureUtils = new GestureUtils();
	}
	
	public void readEndUserLicenseAgreement() throws Exception
	{
		if(DriverManager.getDriverName().equals("iOS"))
		{
			CommonUtils.reliableClick(endUserLicenseAgreementButton, reliableDoneButton, 30);
			CommonUtils.wait(5);
			doneButton.click();
		}
		if(DriverManager.getDriverName().equals("Android"))
		{		
			switcher.switchToSettingsPage();
			gesture.mobileScrollDown();
			mGestureUtils.mScroll("POLICY", null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
			endUserLicenseAgreementButton.click();
			CommonUtils.wait(5);
			AndroidUtils.back();		
		}
	}
	
	public void readprivacyPolicy() throws Exception
	{
		if(DriverManager.getDriverName().equals("iOS"))
		{
			CommonUtils.reliableClick(privacyPolicyButton, reliableDoneButton, 30);
			CommonUtils.wait(5);
			doneButton.click();
		}
		if(DriverManager.getDriverName().equals("Android"))
		{		
			privacyPolicyButton.click();
			CommonUtils.wait(5);
			AndroidUtils.back();		
		}
	}
	
	public void openServiceHatch() throws Exception
	{
		switcher.switchToSettingsPage();
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.reliableClick(3, 1, buildVersionText, reliableDoneButton, 20);
			if(SignInPage.iOSServiceHatchPasswordFlag)
			{
				ElementUtils.sendKeys(serviceHatchUnlockTextField, "3585");
				SignInPage.iOSServiceHatchPasswordFlag = false;
			}
		}
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			gesture.mobileScrollDown();
			for(int i=0;i<10;i++)
			{
				ElementUtils.clickIfDisplayedAndEnabled(buildVersionText);
			}
			ElementUtils.sendKeys(serviceHatchUnlockTextField, "3585");
			ElementUtils.clickIfDisplayedAndEnabled(androidServiceHatchOkButton);
		}
	}
	
	public void clickSyncNowButton()
	{
		ElementUtils.safeClick(syncNowButton);
		CommonUtils.wait(5);
		ElementUtils.safeClick(syncNowButton);
	}
}
