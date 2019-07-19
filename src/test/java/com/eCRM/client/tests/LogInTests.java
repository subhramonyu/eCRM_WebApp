package com.eCRM.client.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eCRM.client.config.UserCredentials;
import com.eCRM.client.core.Config;
import com.eCRM.client.core.RandomGeneratorUtils;
import com.eCRM.client.pages.LogInPage;

public class LogInTests {
	private LogInPage login;

	@BeforeClass(groups = {  Config.REGRESSION_TEST })
	public void initClass() {
		login = new LogInPage();
	}

	@Test(priority = 0001, groups = {  Config.REGRESSION_TEST })
	public void createAccountTest() throws Exception {

		
			UserCredentials.userName = RandomGeneratorUtils.generateRandomEmail();
			UserCredentials.password = RandomGeneratorUtils.generateRandomPassword();
		
			
	}

	
}
