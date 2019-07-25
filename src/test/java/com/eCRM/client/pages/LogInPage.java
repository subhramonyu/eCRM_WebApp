package com.eCRM.client.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.eCRM.client.core.CommonUtils;
import com.eCRM.client.core.DriverManager;
import com.eCRM.client.core.Log;
import com.eCRM.client.core.RandomGeneratorUtils;

import ru.yandex.qatools.allure.annotations.Step;

public class LogInPage extends CommonUtils {

	@FindBy(how = How.CSS, using = "input#txtUsername")
	private WebElement loginId;

	@FindBy(how = How.CSS, using = "input#txtPassword")
	private WebElement password;

	@FindBy(how = How.CSS, using = "input#Submit1")
	private WebElement loginButton;

	public LogInPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
		Log.setLogger("LogInPage");
	}

	@Step("Login to the Application")
	public void login() {
		loginId.clear();
		password.clear();
		sendKeys(loginId, DriverManager.getUserName());
		sendKeys(password, DriverManager.getPassword());
		loginButton.click();

	}

}
