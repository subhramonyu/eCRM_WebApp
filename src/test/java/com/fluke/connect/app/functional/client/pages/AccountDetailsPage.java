package com.fluke.connect.app.functional.client.pages;

import org.openqa.selenium.WebElement;

import com.fluke.connect.app.utils.CommonUtils;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class AccountDetailsPage 
{
	@AndroidFindBy(id="com.fluke.deviceApp:id/user_name_text")
	@iOSFindBy(xpath="//XCUIElementTypeTextField[contains(@value,'.com')]/preceding-sibling::XCUIElementTypeTextField")
	private WebElement userName;
	
	public AccountDetailsPage()
	{
		CommonUtils.initElements(this);
	}
	
	public String getUserName()
	{
		return userName.getText();
	}
	
}
