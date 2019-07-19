package com.eCRM.client.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.eCRM.client.config.UserCredentials;
import com.eCRM.client.core.AndroidUtils;
import com.eCRM.client.core.CommonUtils;
import com.eCRM.client.core.Config;
import com.eCRM.client.core.DriverManager;
import com.eCRM.client.core.ElementUtils;
import com.eCRM.client.core.GestureUtils;
import com.eCRM.client.core.IOSUtils;
import com.eCRM.client.core.VisualUtils;
import com.eCRM.client.core.Config.LocatorStrategy;
import com.eCRM.client.core.Config.ScrollDiection;
import com.eCRM.client.pages.SignInPage.SigninPageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SignUpPage 
{
	@FindBy(how = How.CSS, using = "#createAccount")
	@AndroidFindBy(id = "create_account_text")
	@iOSXCUITFindBy(accessibility = "Create Account")
	private WebElement signUpButton;
	
	@FindBy(how = How.CSS, using = "#storeRegisterFirstName")
	@AndroidFindBy(id = "first_name")
	@iOSXCUITFindBy(accessibility = "Full Name")
	private WebElement firstNameTextField;
	
	@FindBy(how = How.CSS, using = "#storeRegisterLastName")
	@AndroidFindBy(id = "last_name")
	@iOSXCUITFindBy(accessibility = "Last Name")
	private WebElement lastNameTextField;
	
	@FindBy(how = How.CSS, using = "#storeRegisterEmailAddr")
	@AndroidFindBy(id = "email")
	@iOSXCUITFindBy(accessibility = "Email")
	private WebElement emailTextField;
	
	@FindBy(how = How.CSS, using = "#storeRegisterPassword")
	@AndroidFindBy(id = "password")
	@iOSXCUITFindBy(accessibility = "Password")
	private WebElement passwordTextField;
	
	@AndroidFindBy(id = "country")
	@iOSXCUITFindBy(accessibility = "Country")
	private WebElement countryButton;
	
	@FindBy(how = How.CSS, using = "#ac")
	@AndroidFindBy(id = "create_account_button")
	@iOSXCUITFindBy(accessibility = "Create Account")
	private WebElement createAccountButton;
	
	@FindBy(how = How.CSS, using = ".resend-email-btn")
	private WebElement returnToLoginButton;
	
	@AndroidFindBy(id = "user_email_text")
	private WebElement userEmailTextField;
	
	@AndroidFindBy(id = "user_name_text")
	private WebElement userNameTextField;
	
	@FindBy(how = How.CSS, using = "#user-login-actions")
	private WebElement userIconButton;
	
	@iOSXCUITFindBy(accessibility = "backBarButton")
	private WebElement backButton;
	
	@iOSXCUITFindBy(accessibility = "Done")
	private WebElement keyboardDoneButton;
	
	private GestureUtils mGestureUtils;
	private SignInPage signInPage;
	private Switcher switcher;
	
	public SignUpPage()
	{
		CommonUtils.initElements(this, 10);
		mGestureUtils = new GestureUtils();
		signInPage = new SignInPage();
		switcher = new Switcher();
	}
	
	public void createAccount(String firstName, String lastName, String emailId, String password, String countryName) throws Exception
	{
		ElementUtils.click(10, signUpButton);
		CommonUtils.wait(1, 1, 0);
		AndroidUtils.back();
		IOSUtils.isPageLoaded(15, "Loading...");
		ElementUtils.sendKeys(firstNameTextField, firstName);
		ElementUtils.sendKeys(lastNameTextField, lastName);
		ElementUtils.sendKeys(emailTextField, emailId);
		ElementUtils.sendKeys(passwordTextField, password);
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			countryButton.click();
			mGestureUtils.setScrollPoint(VisualUtils.getAppWidth() / 2, 900, 500, 0, 0, 0);
			mGestureUtils.mScroll(countryName, LocatorStrategy.IOS_LOCATOR_STRATEGY_LABEL, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, countryName, LocatorStrategy.IOS_LOCATOR_STRATEGY_LABEL, countryName, null, null).click();
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
				backButton.click();
				keyboardDoneButton.click();
			}
				
			mGestureUtils.resetScrollPoint();
		}
		if(ElementUtils.isNotDisplayed(createAccountButton))
				AndroidUtils.back();
		createAccountButton.click();
	}
	
	public boolean isAccountCreated(String userEmailID, String userName) throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			ElementUtils.click(10, returnToLoginButton);
			signInPage.signIn(UserCredentials.webUserName, UserCredentials.webPassword);
			return ElementUtils.isDisplayed(10, userIconButton);
		}
			
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			ElementUtils.isDisplayed(4, signInPage.getSignInPageObject(SigninPageObjects.ON_BOARD_NEXT_BUTTON));
			signInPage.handleAfterSignInAlertsOtherUser();
			switcher.switchToUserDetailsPage();
			if(userEmailID.equals(userEmailTextField.getText()) && userName.equals(userNameTextField.getText()))
				return true;
			else 
				return false;
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.isDisplayed(4, signInPage.getSignInPageObject(SigninPageObjects.ON_BOARD_NEXT_BUTTON));
			signInPage.handleAfterSignInAlertsOtherUser();
			switcher.switchToUserDetailsPage();
			if(ElementUtils.isDisplayed(3, ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, userEmailID, null, null)) && ElementUtils.isDisplayed(3, ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, userName, null, null)))
				return true;
			else
				return false;
		}
		else
			return false;
	}
}
