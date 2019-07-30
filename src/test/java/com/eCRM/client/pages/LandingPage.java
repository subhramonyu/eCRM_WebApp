package com.eCRM.client.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.eCRM.client.config.UserProfile;
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

	@FindBy(how = How.CSS, using = "input#txtQuickSearch")
	private WebElement quickSearch;

	@FindBy(how = How.CSS, using = "input#btnQuickSearch")
	private WebElement quickSearchBtn;

	@FindBy(how = How.CSS, using = "a#aCompany")
	private WebElement newCustomerLink;

	@FindBy(how = How.CSS, using = "a#aContact")
	private WebElement newContactLink;

	public LandingPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
		Log.setLogger("LandingPage");

	}

	@Step("Clicking on the new Customer hyper link")
	public void clickOnNewCustomerLink() {
		switchToDefaultContent();
		switchToHeaderFrame();
		click(newCustomerLink);
	}

	@Step("Clicking on the new Contact hyper link")
	public void clickOnContactLink() {
		switchToDefaultContent();
		switchToHeaderFrame();
		click(newContactLink);
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

	@Step("Search : {0}")
	public void search(String atext) {
		switchToDefaultContent();
		switchToHeaderFrame();
		click(quickSearch);
		quickSearch.clear();
		sendKeys(quickSearch, atext);
		click(quickSearchBtn);
	}

}
