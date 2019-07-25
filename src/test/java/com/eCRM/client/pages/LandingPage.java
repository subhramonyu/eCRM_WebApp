package com.eCRM.client.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.eCRM.client.core.CommonUtils;
import com.eCRM.client.core.DriverManager;
import com.eCRM.client.core.Log;

import ru.yandex.qatools.allure.annotations.Step;

public class LandingPage extends CommonUtils {

	@FindBy(how = How.CSS, using = "frame[name =header]")
	private WebElement headerFrame;

	@FindBy(how = How.CSS, using = "frame[name=master]")
	private WebElement bodyFrame;

	@FindBy(how = How.CSS, using = "frame[name=menu]")
	private WebElement sideMenuFrame;

	@FindBy(how = How.CSS, using = "a#aCompany")
	private WebElement newCustomerLink;
	
	

	public LandingPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
		Log.setLogger("LandingPage");
	}

	@Step("Clicking on the new cutomer hyper link")
	public void clickOnNewCustomerLink() {
		switchToDefaultContent();
		switchToHeaderFrame();
		click(newCustomerLink);
	}
	
	@Step("Switch to Header frame")
	public void switchToHeaderFrame() {
		switchToFrame(headerFrame);
	}
	
	@Step("Switch to BodyFrame")
	public void switchToBodyFrame() {
		switchToFrame(bodyFrame);
	}
	
	@Step("Switch to side menu frame")
	public void switchToSideMenuFrame() {
		switchToFrame(sideMenuFrame);
	}
}
