package com.eCRM.client.testpages;

import java.time.temporal.ChronoUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.eCRM.client.utils.CommonUtils;
import com.eCRM.client.utils.Config;
import com.eCRM.client.utils.DriverManager;
import com.eCRM.client.utils.ElementUtils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SignInPage 
{	
	@FindBy(how = How.CSS, using = ".store-button #signIn")
	private WebElement webSignInLink;
	
	@FindBy(how = How.CSS, using = "a.header-login-btn")
	private WebElement webSignUpLink;
	
	@FindBy(how = How.CSS, using = "#signIn")
	private WebElement newSignInButton;

	@FindBy(how = How.CSS, using = "input#emailAddr")
	@AndroidFindBy(id = "login_name")
	@iOSFindBy(accessibility = "Email")
	private WebElement emailTextField;
	
	@FindBy(how=How.CSS, using="input#password")
	@AndroidFindBy(id="login_password")
	@iOSFindBy(accessibility="Password")
	private WebElement passwordTextField;
	
	@FindBy(how=How.CSS, using="a#signIn")
	@AndroidFindBy(id="login_button")
	@iOSFindBy(accessibility="Sign In")
	private WebElement signInButton;
	
	@AndroidFindBy(id="create_account_text")
	@iOSFindBy(accessibility="Create Account")
	private WebElement createAccountButton;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/logo")
	@iOSFindBy(accessibility="Fluke-Connect-logo")
	private WebElement flukeConnectLogo;
	
	@iOSXCUITFindBy(iOSNsPredicate = "name CONTAINS 'Server'")
	private WebElement iOSCurrentEnvironmentNameButton;
	
	@AndroidFindBy(xpath="//*[@resource-id='android:id/customPanel']//android.widget.EditText")
	@iOSFindBy(accessibility="UnlockField")
	private WebElement serviceHatchUnlockTextField;
	
	@AndroidFindBy(id="android:id/button1")
	private WebElement androidServiceHatchOkButton;
	
	@WithTimeout(time = 30, chronoUnit = ChronoUnit.SECONDS)
	@iOSFindBy(accessibility="Enable Notifications")
	private static WebElement enableNotificationsButton;
	
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSFindBy(accessibility="Cancel")
	private static WebElement cancelNotificationsButton;
	
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSFindBy(accessibility="Allow")
	private static WebElement allowButton;
	
	@iOSFindBy(accessibility="OK")
	private static WebElement OkButton;
	
	@WithTimeout(time = 3, chronoUnit = ChronoUnit.SECONDS)
	@AndroidFindBy(id="com.fluke.deviceApp:id/dialog_cancel")
	@iOSXCUITFindBy(accessibility="Cancel")
	private static WebElement declineUpgradeButton;
	
	@WithTimeout(time = 5, chronoUnit = ChronoUnit.SECONDS)
	@iOSFindBy(accessibility="Close Tutorial Button")
	private static WebElement closeTutotrialsButton;
	
	@WithTimeout(time = 5, chronoUnit = ChronoUnit.SECONDS)
	@iOSFindBy(accessibility="Skip all tutorials")
	private static WebElement skipAllTutotrialsButton;
	
	@WithTimeout(time = 3, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "next")
	@AndroidFindBy(id="com.fluke.deviceApp:id/actionBtn")
	private WebElement onboardNextButton;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/dialog_ok")
	private WebElement androidPermissionOkButton;
	
	@AndroidFindBy(id="com.android.packageinstaller:id/permission_allow_button")
	private WebElement androidPermissionAllowButton;
	
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@AndroidFindBy(id="tutorials_close")
	private WebElement androidTutotrialCloseButton;
	
	final public static String DECLINE_UPGRADE_ALERT = "decline_upgrade_alert";
	public static boolean iOSServiceHatchPasswordFlag = true;

	public SignInPage() 
	{
		CommonUtils.initElements(this, 40);
	}
	
	public enum SigninPageObjects
	{
		DECLINE_UPGRADE_ALERT, ON_BOARD_NEXT_BUTTON
	}
	
	public WebElement getSignInPageObject(SigninPageObjects objectName)
	{
		switch(objectName)
		{
		case DECLINE_UPGRADE_ALERT:
			return declineUpgradeButton;
		case ON_BOARD_NEXT_BUTTON:
			return onboardNextButton;
		}
		return null;
	}
	
	public void signIn() throws Exception 
	{
		ElementUtils.sendKeys(emailTextField, DriverManager.getUserName());
		ElementUtils.sendKeys(passwordTextField, DriverManager.getPassword());
		ElementUtils.clickIfDisplayedAndEnabled(signInButton);
	}
	
	public void signIn(String userName, String password) throws Exception 
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			ElementUtils.clickIfDisplayedAndEnabled(90, 1, signInButton);
		ElementUtils.sendKeys(emailTextField, userName);
		ElementUtils.sendKeys(passwordTextField, password);
		ElementUtils.clickIfDisplayedAndEnabled(signInButton);
	}

	public void clickCreateAccountButton() throws Exception 
	{
		ElementUtils.clickIfDisplayedAndEnabled(createAccountButton);
	}
	
	//specific to iOS
	public boolean isEnvironmentChangeRequired(String requiredEnvironment) 
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			if(ElementUtils.isDisplayed(30, iOSCurrentEnvironmentNameButton))
			{
				if((iOSCurrentEnvironmentNameButton.getText()).startsWith(requiredEnvironment))
					return false;
				else
					return true;
			}
			else
				return true;
		}
		else
			return true;
	}
	
	public void openServiceHatch() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			iOSCurrentEnvironmentNameButton.click();
			if(iOSServiceHatchPasswordFlag)
			{
				if(ElementUtils.isDisplayed(3, serviceHatchUnlockTextField))
					ElementUtils.sendKeys(serviceHatchUnlockTextField, "3585");
				iOSServiceHatchPasswordFlag = false;
			}
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) 
		{
			WebElement connectLogo = DriverManager.getDriver().findElement(MobileBy.id("logo"));
			for(int i=0;i<10;i++)
			{
				connectLogo.click();
			}
			ElementUtils.sendKeys(serviceHatchUnlockTextField, "3585");
			androidServiceHatchOkButton.click();
			ElementUtils.safeClick(declineUpgradeButton);
		}
	}
	
	public void handleBeforeSignInAlerts() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			handleOnBoardPrompt();
			androidPermissionOkButton.click();
			androidPermissionAllowButton.click();
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			handleOnBoardPrompt();
			if(DriverManager.getHandleUpgradeAlertFlag())
				ElementUtils.safeClick(declineUpgradeButton);
		}
	}
	
	public void handleAfterSignInAlerts() throws Exception  //new installation
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			CommonUtils.wait(5);
			handleOnBoardPrompt();
		}
			
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) && DriverManager.getAppInstallFlag())
		{
			CommonUtils.wait(5);
			ElementUtils.safeClick(enableNotificationsButton);
			ElementUtils.safeClick(allowButton);
			handleOnBoardPrompt();
			if(DriverManager.getHandleUpgradeAlertFlag())
				ElementUtils.safeClick(declineUpgradeButton);
		}
	}
	
	public void handleAfterSignInAlertsOtherUser() throws Exception //existing installation 
	{
		CommonUtils.wait(2);
		handleOnBoardPrompt();
	}
	
	public boolean handleOnBoardPrompt() {
		boolean returnFlag = false;
		if(ElementUtils.isDisplayed(2, onboardNextButton)) {
			returnFlag = true;
			for(int i=0;i<3;i++) {
				ElementUtils.safeClick(onboardNextButton);
				CommonUtils.wait(1);
			}
		}
		return returnFlag;
	}
	
	
	
}
