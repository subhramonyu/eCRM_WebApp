package com.fluke.connect.app.functional.client.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fluke.connect.app.functional.client.pages.SettingsPage;
import com.fluke.connect.app.utils.Config;

public class SettingsPageTests 
{
	private SettingsPage settingsPage;
	
	@BeforeClass(alwaysRun = true, groups = {Config.IOS_SMOKE_TESTS, Config.IOS_UAT_TESTS, Config.IOS_FULL_TESTS, Config.ANDROID_SMOKE_EXTENDED_TESTS})
	public void initClass()
	{
		settingsPage = new SettingsPage();
	}
	
	@Test(alwaysRun = true, priority = 15301, groups={Config.IOS_SMOKE_TESTS, Config.IOS_UAT_TESTS, Config.IOS_FULL_TESTS ,Config.ANDROID_SMOKE_TESTS,
			Config.ANDROID_SMOKE_EXTENDED_TESTS})
	public void endUserLicenseAgreementTest()
	{
		try
		{
			//settingsPage.readEndUserLicenseAgreement();
		}
		catch(Exception e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 15302, groups={Config.IOS_SMOKE_TESTS, Config.IOS_UAT_TESTS, Config.IOS_FULL_TESTS ,Config.ANDROID_SMOKE_TESTS, 
			Config.ANDROID_SMOKE_EXTENDED_TESTS})
	public void privacyPolicyTest()
	{
		try
		{
			//settingsPage.readprivacyPolicy();
		}
		catch(Exception e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@AfterClass(alwaysRun = true, groups = {Config.IOS_FULL_TESTS, Config.IOS_SMOKE_TESTS})
	public void classTearDown() throws Exception
	{
	    
	}
}
