package com.eCRM.client.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.eCRM.client.core.CommonUtils;
import com.eCRM.client.core.DriverFactory;
import com.eCRM.client.core.DriverManager;
import com.eCRM.client.core.Log;

import ru.yandex.qatools.allure.annotations.Step;

public class LogInPage extends CommonUtils {

	@FindBy(how = How.CSS, using = "input#txtUsername")
	private WebElement loginId;

	@FindBy(how = How.CSS, using = "input#txtPassword")
	private WebElement password;

	@FindBy(how = How.CSS, using = "input#Submit1")
	private WebElement loginButton;

	private WebDriver driver;

	public LogInPage(WebDriver driver) {
		//PageFactory.initElements(DriverManager.getDriver(), this);
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		Log.setLogger("LogInPage");
	}

	@Step("Login to the Application")
	public void login() {
		System.out.println(DriverManager.getDriver());
		//loginId.clear();
		//password.clear();
		sendKeys(loginId, DriverManager.getUserName());
		sendKeys(password, DriverManager.getPassword());
		loginButton.click();

	}

}
