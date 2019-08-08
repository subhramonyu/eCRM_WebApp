package com.eCRM.client.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.eCRM.client.core.CommonUtils;
import com.eCRM.client.core.DriverManager;
import com.eCRM.client.core.Log;

import ru.yandex.qatools.allure.annotations.Step;

public class LogInPage extends CommonUtils {

	@FindBy(how = How.CSS, using = "input#txtUsername")
	private WebElement loginId_field;

	@FindBy(how = How.CSS, using = "input#txtPassword")
	private WebElement password_field;

	@FindBy(how = How.CSS, using = "input#Submit1")
	private WebElement loginButton;


	public LogInPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
		//this.driver = driver; 
		//PageFactory.initElements(driver, this);
		Log.setLogger("LogInPage");
	}

	@Step("Login to the Application with userid:{0} and password :{1}")
	public void login(String userId,String Password) {
		loginId_field.clear();
		password_field.clear();
		sendKeys(loginId_field,userId );
		sendKeys(password_field,Password);
		loginButton.click();

	}

}
