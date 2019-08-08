package com.eCRM.client.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eCRM.client.config.UserProfile;
import com.eCRM.client.core.Config;
import com.eCRM.client.pages.LogInPage;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.model.SeverityLevel;



@Stories("eCRM-Specific")
@Features("Module - Customer Mgmt(New Customer)")


public class eCRM01_LogInTests {
	private LogInPage login;

	
	@BeforeClass(groups = { Config.REGRESSION_TEST })
	public void initClass() {
		login = new LogInPage();
	}
	
	
	@Severity(SeverityLevel.CRITICAL)
	@TestCaseId("EFISWCRM-852")
	@Test(groups = {Config.REGRESSION_TEST }, priority = 0001, dataProvider = "RegressionCredentials", dataProviderClass = UserProfile.class)
	@Description("Login to the Application using invalid credentials ,userID{0},and password{1}")
	public void loginwithInvalidCredentialsTest(String userId, String password) throws Exception {
		login.login(userId, password);
	}
	
	
	
	@Severity(SeverityLevel.CRITICAL)
	@TestCaseId("EFISWCRM-852")
	@Test(groups = {Config.REGRESSION_TEST }, priority = 0002, dataProvider = "RegressionCredentials", dataProviderClass = UserProfile.class)
	@Description("Login to the Application using existing UserId :{0},and Password:{1}")
	public void loginwithvalidCredentialsTest(String userId, String password) throws Exception {
		login.login(userId, password);
	}
	
	
	
	

}
