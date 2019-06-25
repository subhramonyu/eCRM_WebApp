package com.fluke.connect.app.functional.client.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fluke.connect.app.functional.client.pages.AccountDetailsPage;
import com.fluke.connect.app.functional.client.pages.CreateAccountPage;
import com.fluke.connect.app.functional.client.pages.MeasurementsHistoryPage;
import com.fluke.connect.app.functional.client.pages.SignInPage;
import com.fluke.connect.app.functional.client.pages.Switcher;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.RandomGeneratorUtils;

public class CreateAccountPageTests 
{
	private SignInPage signInPage;
	private CreateAccountPage createAccountPage;
	private Switcher switcher;
	private AccountDetailsPage accountDetailsPage;
	private MeasurementsHistoryPage measurementHistoryPage;
	
	@BeforeClass(groups = {Config.IOS_SMOKE_TESTS})
	public void initClass()
	{
		switcher = new Switcher();
		signInPage = new SignInPage();
		createAccountPage = new CreateAccountPage();
		accountDetailsPage = new AccountDetailsPage();
		measurementHistoryPage = new MeasurementsHistoryPage();
		//switcher.signOut();
	}
	
	@Test(alwaysRun = true, priority = 158301, groups = {})
	public void createAccountTest()
	{
		try 
		{
			signInPage.clickCreateAccountButton();
			createAccountPage.createAccount("New", "User", "Fluke", "Tester", "123456", RandomGeneratorUtils.generateRandomEmail(), "123456","123456");
			switcher = new Switcher();
			switcher.switchToUserDetailsPage();
			Assert.assertEquals(accountDetailsPage.getUserName(),"New User");
		}
		catch(Exception e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 158302, groups = {})
	public void onNewAccountSampleDataTest()
	{
		try 
		{
			switcher.switchToMeasurementsPage();
			if(measurementHistoryPage.getMeasurementsCount() < 0)
			{
				throw new Exception("Sample Data Missing Error");
			}
		}
		catch(Exception e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
}
