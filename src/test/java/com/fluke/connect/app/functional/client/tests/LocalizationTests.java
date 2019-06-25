package com.fluke.connect.app.functional.client.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fluke.connect.app.functional.client.pages.LocalizationPage;
import com.fluke.connect.app.testdata.SignIn;
import com.fluke.connect.app.testdata.SignIn.FeatureList;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.DeviceUtils;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;

public class LocalizationTests {
	
	DeviceUtils mDeviceUtils;
	LocalizationPage mLocalizationPage;
	private String[] languageNameList;
	private String[] languageFileNameList;
	
	@Parameters({"languageName", "languageFileName"})
	@BeforeClass(groups = {Config.LOCALIZATION_TESTS})
	public void initClass(@Optional("no value") String languageName, @Optional("no value") String languageFileName) throws Exception 
	{
		if(!DriverManager.isSmokeSuite()) {
		DriverManager.getSignIn().signIn(SignIn.getUID(FeatureList.LOCALIZATION), SignIn.getPWD(FeatureList.LOCALIZATION));
        DriverManager.getSignIn().handleAfterSignInAlertsOtherUser();
		}
		mDeviceUtils = new DeviceUtils();
		mLocalizationPage = new LocalizationPage();
		languageNameList = languageName.split(",");
		languageFileNameList = languageFileName.split(",");
		
	}

	@Test(alwaysRun = true, priority = 191001, groups = {Config.LOCALIZATION_TESTS})
	public void assetTitleSideMenuTest() throws Exception {
		mLocalizationPage.changeLanguage(languageNameList[0], languageFileNameList[0]);
		ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, "Schalter", null, null).click();
		Assert.assertNotNull(ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, mLocalizationPage.getLocalizedString("Equipments"), null, null));
	}
	
	@Test(alwaysRun = true, priority = 191002, groups = {Config.LOCALIZATION_TESTS})
	public void workOrderTitleSideMenuTest() throws Exception {
		Assert.assertNotNull(ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, mLocalizationPage.getLocalizedString("Work Orders"), null, null));
	}
	
	@Test(alwaysRun = true, priority = 191003, groups = {Config.LOCALIZATION_TESTS})
	public void teamTitleSideMenuTest() throws Exception {
		Assert.assertNotNull(ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, mLocalizationPage.getLocalizedString("Team"), null, null));
		ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, mLocalizationPage.getLocalizedString("Team"), null, null).click();
		CommonUtils.wait(2);
	}
	
	@Test(alwaysRun = true, priority = 191004, groups = {Config.LOCALIZATION_TESTS})
	public void changeLanguageTest() throws Exception {
		mLocalizationPage.changeLanguage(languageNameList[1], languageFileNameList[1]);
	}
		


}
