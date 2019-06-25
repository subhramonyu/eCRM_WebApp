package com.fluke.connect.app.functional.client.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.fluke.connect.app.functional.client.pages.SignUpPage;
import com.fluke.connect.app.testdata.Team;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.RandomGeneratorUtils;

public class SingUpTests 
{
	private SignUpPage signUpPage;
	
	@BeforeClass(groups = {Config.TEAM_TESTS, Config.TEAM_TESTS_WEB})
	public void initClass()
	{
		signUpPage = new SignUpPage();
	}
	
	@Test(priority = 71000, groups = {Config.TEAM_TESTS, Config.TEAM_TESTS_WEB})
	public void createAccountTest() throws Exception
	{
		Team.userName = RandomGeneratorUtils.generateRandomEmail();
		Team.password = RandomGeneratorUtils.generateRandomPassword();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			Team.androidUserName = Team.userName;
			Team.androidPassword = Team.password;
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			Team.iOSUserName = Team.userName;
			Team.iOSPassword = Team.password;
		}
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			Team.webUserName = Team.userName;
			Team.webPassword = Team.password;
		}
		signUpPage.createAccount(Team.userFirstName, Team.userLastName, Team.userName, Team.password, Team.countaryName);
	}
	
	@Test(priority = 71015, groups = {Config.TEAM_TESTS, Config.TEAM_TESTS_WEB})
	public void isAccountCreatedTest() throws Exception
	{
		Assert.assertTrue(signUpPage.isAccountCreated(Team.userName, Team.userFirstName+ " "+ Team.userLastName));
	}

}
