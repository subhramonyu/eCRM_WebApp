package com.fluke.connect.app.functional.client.pages;

import org.openqa.selenium.WebElement;

import com.fluke.connect.app.utils.CommonUtils;

import io.appium.java_client.pagefactory.iOSFindBy;

public class ThermalImageAnalysisPage 
{
	//assets -- asset group -- asset -- analysis tab -- thermal images -- chart element
	@iOSFindBy(accessibility = "HIG Chart")
	private WebElement chartElement;
	
	private AssetsPage assetPage;
	
	public ThermalImageAnalysisPage()
	{
		CommonUtils.initElements(this);
		assetPage = new AssetsPage();
	}
	
	public boolean isChartDisplayed() throws Exception
	{
		assetPage.clickOnAssetAnalysisThermalImages("3540eventlogging", "frequency");
		return chartElement.isDisplayed();
	}
	
}
