package com.fluke.connect.app.functional.client.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fluke.connect.app.functional.client.pages.AssetsPage;
import com.fluke.connect.app.functional.client.pages.Switcher;
import com.fluke.connect.app.functional.client.pages.ThermalImageAnalysisPage;

public class ThermalImageAnalysisTests 
{
	private Switcher switcher;
	private ThermalImageAnalysisPage thermalImageAnalysisPage;
	private AssetsPage assetPage;
	
	@BeforeClass(groups = {})
	public void initClass() throws Exception
	{
		switcher = new Switcher();
		thermalImageAnalysisPage = new ThermalImageAnalysisPage();
		switcher.switchToAssetsPage();
		assetPage = new AssetsPage();
	}
	
	@Test(groups = {})
	public void isChartDisplayedTest() throws Exception
	{
		try
		{
			Assert.assertTrue(thermalImageAnalysisPage.isChartDisplayed());
			assetPage.clickOnBackButton();
		}
		catch(AssertionError e)
		{
			assetPage.clickOnBackButton();
			Assert.fail();
		}
	}
	
	@Test(groups = {})
	public void savedDataTest() throws Exception
	{
		try
		{
			Assert.assertTrue(assetPage.isDataSaved());
			assetPage.clickOnBackButton();
			assetPage.clickOnBackButton();
			assetPage.clickOnBackButton();
		}
		catch(AssertionError e)
		{
			assetPage.clickOnBackButton();
			assetPage.clickOnBackButton();
			assetPage.clickOnBackButton();
			Assert.fail();
		}
	}

}
