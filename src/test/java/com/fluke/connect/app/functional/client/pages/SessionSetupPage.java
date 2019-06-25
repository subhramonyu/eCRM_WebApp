package com.fluke.connect.app.functional.client.pages;

import org.openqa.selenium.WebElement;

import com.fluke.connect.app.testdata.FCCM.FCCMProductName;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.ScrollDiection;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SessionSetupPage
{
	@AndroidFindBy(id = "assign_asset")
	@iOSXCUITFindBy(iOSNsPredicate = "name == 'ASSIGN ASSET OR TEST POINT'")
	private WebElement assignAssetOrTestPointButton;
	
	@AndroidFindBy(id = "save_continue_btn")
	@iOSXCUITFindBy(iOSNsPredicate = "name CONTAINS 'CONTINUE'")
	private WebElement saveAndContinueButton;
	
	@AndroidFindBy(id = "action_bar_title_center")
	@iOSXCUITFindBy(accessibility="Title")
	private WebElement configureSensorsStaticText;
	
	@AndroidFindBy(id = "continue_button")
	@iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH 'CONTINUE'")
	private WebElement continueButton;
	
	@AndroidFindBy(id = "button_3")
	@iOSXCUITFindBy(accessibility = "Cancel")
	private WebElement licenseErrorCancelButton; 
	
		
	private AssetsPage assetPage;
	private GestureUtils gestureUtils;
	private HomePage homePage;

	public SessionSetupPage()
	{
		CommonUtils.initElements(this, 1);
		assetPage = new AssetsPage();
		gestureUtils = new GestureUtils();
		homePage = new HomePage();
	}

	public void selectFCCMProduct(FCCMProductName productName, ScrollDiection scrollDirection) 
	{
		homePage.clickOnSetupLoggingAndMonitoring();
		switch(productName)
		{
		case VIBRATION_SENSOR:
			ElementUtils.getElement(FCCMProductName.VIBRATION_SENSOR.getProductName(), null, null).click();  //handleLicenseError(FCCMProductName.VIBRATION_SENSOR.getProductName());
			break;
		case TI_SENSOR:
			gestureUtils.mScroll(FCCMProductName.TI_SENSOR.getProductName(), LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, scrollDirection);
			ElementUtils.getElement(FCCMProductName.VIBRATION_SENSOR.getProductName(), null, null).click();  //handleLicenseError(FCCMProductName.VIBRATION_SENSOR.getProductName());
			//handleLicenseError(FCCMProductName.TI_SENSOR.getProductName());
			break;
		}
	}
	
	public void handleLicenseError(String productName)
	{
		for(int i = 0; i < 5; i++)
		{
			ElementUtils.getElement(productName, null, null).click();
			if(ElementUtils.isDisplayed(2, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "button_3", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Cancel", null, null))
			{
				licenseErrorCancelButton.click();
				CommonUtils.wait(5);
			}
			else
				break; 
		}		
	}
	
	public boolean isAssetAssigned(String assetGroupName, String assetName, String testPointName, int androidTestPointIndex) throws Exception
	{
		assignAsset(assetGroupName, assetName, testPointName, androidTestPointIndex);
		return ElementUtils.isDisplayed(10, configureSensorsStaticText);
	}
	
	public void assignAsset(String assetGroupName, String assetName, String testPointName, int androidTestPointIndex) throws Exception
	{
		ElementUtils.click(10, assignAssetOrTestPointButton);
		ElementUtils.click(10, continueButton);
		assetPage.assignAssetCM(assetGroupName, assetName, testPointName, androidTestPointIndex);
		saveAndContinueButton.click();
	}
	
}
