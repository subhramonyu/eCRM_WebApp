package com.eCRM.client.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eCRM.client.testdata.UserCredentials;
import com.eCRM.client.testpages.SignUpPage;
import com.eCRM.client.utils.Config;
import com.eCRM.client.utils.DriverManager;
import com.eCRM.client.utils.RandomGeneratorUtils;

public class SingUpTests {
	private SignUpPage signUpPage;

	@BeforeClass(groups = { Config.TEAM_TESTS, Config.TEAM_TESTS_WEB })
	public void initClass() {
		signUpPage = new SignUpPage();
	}

	@Test(priority = 0001, groups = { Config.TEAM_TESTS, Config.TEAM_TESTS_WEB })
	public void createAccountTest() throws Exception {

		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			UserCredentials.userName = RandomGeneratorUtils.generateRandomEmail();
			UserCredentials.password = RandomGeneratorUtils.generateRandomPassword();
		}
		signUpPage.createAccount(UserCredentials.userFirstName, UserCredentials.userLastName, UserCredentials.userName,
				UserCredentials.password, UserCredentials.countaryName);
	}

	@Test(priority = 71015, groups = { Config.TEAM_TESTS, Config.TEAM_TESTS_WEB })
	public void isAccountCreatedTest() throws Exception {
		Assert.assertTrue(signUpPage.isAccountCreated(UserCredentials.userName,
				UserCredentials.userFirstName + " " + UserCredentials.userLastName));
	}

}
