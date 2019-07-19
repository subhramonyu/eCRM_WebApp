package com.eCRM.client.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eCRM.client.core.Config;
import com.eCRM.client.pages.HomePage;

@SuppressWarnings("unused")
public class HomePageTests 
{
	private HomePage homePage;
	
	
	@BeforeClass(groups = {Config.REGRESSION_TEST})
	public void initClass()
	{
		homePage = new HomePage();
	
	}
	
	@Test
	public void test()
	{
		
		
	}
	
	
	

}
