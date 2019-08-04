package com.eCRM.client.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eCRM.client.core.Config;
import com.eCRM.client.pages.LogInPage;

import ru.yandex.qatools.allure.annotations.Description;

public class LogInTests {
	private LogInPage login;

	@BeforeClass(groups = {})
	public void initClass() {
		//login = new LogInPage();
	}

	
	@Test(groups= {})
	@Description("Login to the Application using existing UserId and Password")
	public void loginTest() throws Exception {
			login.login();
	}

	
}
