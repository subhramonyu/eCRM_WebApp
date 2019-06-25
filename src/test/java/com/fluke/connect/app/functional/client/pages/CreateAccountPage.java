package com.fluke.connect.app.functional.client.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.fluke.connect.app.utils.AndroidUtils;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.Gestures;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

@SuppressWarnings("unused")
public class CreateAccountPage 
{
	@AndroidFindBy(id="com.fluke.deviceApp:id/first_name")
	@iOSFindBy(accessibility="Full Name") 
	private WebElement firstNameTextField;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/last_name")
	@iOSFindBy(accessibility="Last Name") 
	private WebElement lastNameTextField;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/company_name")
	@iOSFindBy(accessibility="Company") 
	private WebElement companyTextField;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/user_role")
	@iOSFindBy(accessibility="Job Role")  
	private WebElement jobRoleButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Tester']")
	@iOSFindBy(accessibility="Tester") 
	private WebElement jobRoleValue;
	
	@iOSFindBy(accessibility="Back")  
	private WebElement backButton;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/phone_number")
	@iOSFindBy(accessibility="Phone Number") 
	private WebElement phoneTextField;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/email")
	@iOSFindBy(accessibility="Email") 
	private WebElement emailTextField;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/password")
	@iOSFindBy(accessibility="Password") 
	private WebElement passwordTextField;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/confirm_password")
	@iOSFindBy(accessibility="Confirm Password") 
	private WebElement confirmPasswordTextField;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/country")
	@iOSFindBy(accessibility="Country") 
	private WebElement countryButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Australia']")
	@iOSFindBy(accessibility="Australia") 
	private WebElement countryValue;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/zipcode")
	@iOSFindBy(accessibility="Postal Code") 
	private WebElement postalCodeTextField;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/create_account_button")
	@iOSFindBy(accessibility="Create Account") 
	private WebElement createAccountButton;
	
	private String userName;
	private CommonUtils commonUtils;
	public Switcher switcher;
	//private HandleAlerts handleAlerts;
	private Gestures gesture;

	
	public CreateAccountPage() 
	{
		CommonUtils.initElements(this, 10);
		commonUtils = new CommonUtils();
		switcher = new Switcher();
	//	handleAlerts = new HandleAlerts();
		gesture = new Gestures();
	}
	
	
	
	public void createAccount(String firstName, String lastName, String company, String role, String phone, String email, 
			String password, String postalCode)
	{
		ElementUtils.sendKeys(firstNameTextField, firstName);
		if(DriverManager.getDriverName().equals("Android"))
		{
			AndroidUtils.back();
		}
		lastNameTextField.sendKeys(lastName);
		userName = firstName +" "+lastName;
		emailTextField.sendKeys(email);
		passwordTextField.sendKeys(password);
		countryButton.click();
		countryValue.click();
		if(DriverManager.getDriverName().equals("iOS"))
		{
			backButton.click();
		}
		if(DriverManager.getDriverName().equals("iOS"))
		{
			gesture.iOSCordinateScroll(0,300,0,50);
		}
		if(DriverManager.getDriverName().equals("Android"))
		{
			gesture.androidScrollToTextValue("\"Create Account\"");
		}
		
		createAccountButton.click();
		/*
		 *  
	    if(AppiumFactory.mobileDriverName.equals("iOS"))
		{
			handleAlerts.iOSAcceptNotificationAlerts();
			handleAlerts.iOSDeclineAppUpgradeAlert();
			//handleAlerts.iOSAcceptDataUploadFailure();
			handleAlerts.iOSAcceptTutotrialsAlert();
		}
		* 
		*/
	}
}
