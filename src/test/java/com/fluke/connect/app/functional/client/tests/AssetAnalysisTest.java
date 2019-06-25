/*package com.fluke.connect.app.functional.client.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fluke.connect.app.functional.client.pages.AssetAnalysisPage;
import com.fluke.connect.app.functional.client.pages.AssetsPage;
import com.fluke.connect.app.functional.client.pages.Switcher;
import com.fluke.connect.app.testdata.Asset;

import com.fluke.connect.app.testdata.Asset.ALARM_TYPE;

import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.ScrollDiection;


public class AssetAnalysisTest 

{	
	
	private AssetAnalysisPage assetsAnalysisPage;
	private AssetsPage assetsPage;
	private Switcher switcher;
	private Asset asset;
	private GestureUtils gestureUtils;
	

	@BeforeClass(alwaysRun = true, groups = {Config.IOS_FULL_TESTS,"assets",Config.ASSET_ANDROID_UAT,Config.TEST_ASSET,Config.ASSET_UAT_TEST})

	public void initClass() throws Exception
	{
		assetsAnalysisPage = new AssetAnalysisPage();
		assetsPage = new AssetsPage();
		switcher = new Switcher();
		asset=new Asset();
		gestureUtils=new GestureUtils();
	  	assetsPage.addAssetGroup(Asset.ASSET_ANALYSIS.ASSET_ANALYSIS_GROUP.getAnalysisConfig());
		switcher.switchToAssetsPage();
		
	}

	@Test(alwaysRun = true, priority = 27301, groups = {Config.TEST_ASSET,Config.ASSET_ANDROID_UAT,Config.ASSET_UAT_TEST})//Config.TEST_ASSET,


	public void addedThermalImageVerficationOnAnalysisPage() throws Exception
	{
		try
		{
			assetsPage.clickOnAssetGroupName(Asset.ASSET_ANALYSIS.ASSET_ANALYSIS_GROUP.getAnalysisConfig());
			assetsPage.addAsset(Asset.ASSET_ANALYSIS.THERMAL_ASSET.getAnalysisConfig(), Asset.ASSETCONFIG.ASSET_TYPE.getAssetConfig(), asset.statusFilter().get(0));	
			assetsAnalysisPage.clickOnAssetInMobileForAssetAnalysis(Asset.ASSET_ANALYSIS.THERMAL_ASSET.getAnalysisConfig());
			assetsAnalysisPage.addDataOnAnalaysisPage();
			if(DriverManager.getDriverName().equals("iOS")||DriverManager.getDriverName().equals("Android")||DriverManager.getDriverName().equals("Web"))
			{
				assetsAnalysisPage.selectMeasurementInAndroidAndWeb(Asset.MEASUREMENT_NAME.THERMAL);
			}
			assetsAnalysisPage.clickOnAddMeasurementButton();
			assetsAnalysisPage.clickOnThermalImageSection();
			Assert.assertEquals(assetsAnalysisPage.getThumbnailSize(), 2);
			if(DriverManager.getDriverName().equals("iOS")||DriverManager.getDriverName().equals("Android"))
			{
				assetsPage.clickOnBackButton();
			}
			
		}
		catch(Throwable e)
		{
			assetsPage.clickOnBackButton();
			Assert.fail(e.toString());
		}
	}
	

	@Test(alwaysRun = true, priority = 27302, groups = {Config.TEST_ASSET,Config.ASSET_UAT_TEST,Config.ASSET_ANDROID_UAT})//Config.TEST_ASSET,
	public void addedThermalImageVerficationOnSavedPage() throws Exception
	{
		try
		{
			assetsAnalysisPage.clickOnViewSavedData();	
			if(DriverManager.getDriverName().equals("iOS"))
			{
				for(int measCount=0;measCount<asset.getThermalImageDate().size();measCount++)
				{
					//gestureUtils.scroll("value",asset.getThermalImageDate().get(measCount),null,asset.getThermalImageDate().get(measCount),-100,-100,LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,"[data-is-thermal-image=\"true\"]");	
					CommonUtils.wait(4);
					gestureUtils.mScroll(asset.getThermalImageDate().get(measCount),LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE,null,ScrollDiection.DOWN);	

					Assert.assertTrue(ElementUtils.isDisplayed(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, asset.getThermalImageDate().get(measCount), null, null));
				}				
			}
			else if(DriverManager.getDriverName().equals("Android")||DriverManager.getDriverName().equals("Web"))
			{
				for(int measCount=0;measCount<asset.getThermalImageDate().size();measCount++)
				{
					gestureUtils.scroll(null,null,null,asset.getThermalImageDate().get(measCount),0,-100,LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,"[data-is-thermal-image=\"true\"]");	
					Assert.assertTrue(ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, asset.getThermalImageDate().get(measCount), null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,"[data-is-thermal-image=\"true\"]"));
				}
			}
			assetsPage.clickOnBackButton();
			assetsPage.clickOnBackButton();
			assetsPage.clickOnBackButton();
		}
		catch(Throwable e)
		{
			assetsPage.clickOnBackButton();
			assetsPage.clickOnBackButton();
			assetsPage.clickOnBackButton();
			Assert.fail(e.toString());
		}
	}
	
	@Test(alwaysRun = true, priority = 27303, groups = {Config.TEST_ASSET,Config.ASSET_ANDROID_UAT,Config.ASSET_UAT_TEST})//Config.TEST_ASSET,

	public void addBeakerVerficationOnAnalysisPage() 
	{
		try
		{
			switcher.switchToAssetsPage();
			assetsPage.clickOnAssetGroupName(Asset.ASSET_ANALYSIS.ASSET_ANALYSIS_GROUP.getAnalysisConfig());
			assetsPage.addAsset(Asset.ASSET_ANALYSIS.BEAKER_ASSET.getAnalysisConfig(), Asset.ASSETCONFIG.ASSET_TYPE.getAssetConfig(), asset.statusFilter().get(0));	
			assetsAnalysisPage.clickOnAssetInMobileForAssetAnalysis(Asset.ASSET_ANALYSIS.BEAKER_ASSET.getAnalysisConfig());
			assetsAnalysisPage.addDataOnAnalaysisPage();
			if(DriverManager.getDriverName().equals("iOS")||DriverManager.getDriverName().equals("Android")||DriverManager.getDriverName().equals("Web"))
			{
				assetsAnalysisPage.selectMeasurementInAndroidAndWeb(Asset.MEASUREMENT_NAME.BEAKER);
			}
			assetsAnalysisPage.clickOnAddMeasurementButton();
			Assert.assertTrue(assetsAnalysisPage.verifyGraph("Beaker"));
		}
		catch(Throwable e)
		{
			assetsAnalysisPage.clickOnCancelButton();
			Assert.fail(e.toString());
		}
	}
	
	@Test(alwaysRun = true, priority = 27304, groups = {Config.TEST_ASSET,Config.ASSET_ANDROID_UAT,Config.ASSET_UAT_TEST})//Config.TEST_ASSET,
	public void addBeakerVerficationOnSavedPage() throws Exception
	{
		try
		{
			assetsAnalysisPage.clickOnViewSavedData();
			if(DriverManager.getDriverName().equals("iOS"))
			{				
				for(int measCount=0;measCount<asset.getBeakerDate().size();measCount++)
				{
					//gestureUtils.scroll("value",asset.getBeakerDate().get(measCount),null,asset.getBeakerDate().get(measCount),-100,-100,LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,"[data-is-thermal-image=\"true\"]");	
					CommonUtils.wait(2);
					gestureUtils.mScroll(asset.getBeakerDate().get(measCount),LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE,null,ScrollDiection.DOWN);	

					Assert.assertTrue(ElementUtils.isDisplayed(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, asset.getBeakerDate().get(measCount), null, null));
				}
			}
			else if(DriverManager.getDriverName().equals("Android")||DriverManager.getDriverName().equals("Web"))
			{
				for(int measCount=0;measCount<asset.getBeakerDate().size();measCount++)
				{
					gestureUtils.scroll(null,null,null,asset.getBeakerDate().get(measCount),0,-200,null,null);	
					Assert.assertTrue(ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, asset.getBeakerDate().get(measCount), null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "[data-detail-type='beaker']"));
				}
			}
			assetsPage.clickOnBackButton();
			assetsPage.clickOnBackButton();
			assetsPage.clickOnBackButton();
		}
		catch(Throwable e)
		{
			assetsPage.clickOnBackButton();
			assetsPage.clickOnBackButton();
			assetsPage.clickOnBackButton();
			Assert.fail(e.toString());
		}
	}
	
	@Test(alwaysRun = true, priority = 27305, groups = {Config.ASSET_ANDROID_UAT,Config.TEST_ASSET,Config.ASSET_UAT_TEST})//Config.TEST_ASSET,
	public void addCNXVerficationOnAnalysisPage() throws Exception
	{
		try
		{
			switcher.switchToAssetsPage();
			assetsPage.clickOnAssetGroupName(Asset.ASSET_ANALYSIS.ASSET_ANALYSIS_GROUP.getAnalysisConfig());
			assetsPage.addAsset(Asset.ASSET_ANALYSIS.CNX_ASSET.getAnalysisConfig(), Asset.ASSETCONFIG.ASSET_TYPE.getAssetConfig(), asset.statusFilter().get(0));	
			assetsAnalysisPage.clickOnAssetInMobileForAssetAnalysis(Asset.ASSET_ANALYSIS.CNX_ASSET.getAnalysisConfig());
			assetsAnalysisPage.addDataOnAnalaysisPage();
			if(DriverManager.getDriverName().equals("iOS"))
			{
					assetsAnalysisPage.selectMeasurementInAndroidAndWeb(Asset.MEASUREMENT_NAME.CNX);
			}
			else if(DriverManager.getDriverName().equals("Android")||DriverManager.getDriverName().equals("Web"))
			{
				assetsAnalysisPage.selectMeasurementInAndroidAndWeb(Asset.MEASUREMENT_NAME.CNX);
			}
			assetsAnalysisPage.clickOnAddMeasurementButton();
			Assert.assertTrue(assetsAnalysisPage.verifyGraph("CNX"));
		}
		catch(Throwable e)
		{
			assetsAnalysisPage.clickOnCancelButton();
			Assert.fail(e.toString());
		}
	}
	
	@Test(alwaysRun = true, priority = 27306, groups = {Config.ASSET_ANDROID_UAT,Config.TEST_ASSET,Config.ASSET_UAT_TEST})//Config.TEST_ASSET,
	public void addCNXVerficationOnSavedPage() throws Exception
	{
		try
		{
			assetsAnalysisPage.clickOnViewSavedData();
			if(DriverManager.getDriverName().equals("iOS"))
			{
				for(int measCount=0;measCount<asset.getCNXDate().size();measCount++)
				{
					CommonUtils.wait(2);
					gestureUtils.mScroll(asset.getCNXDate().get(measCount),LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE,null,ScrollDiection.DOWN);	
					Assert.assertTrue(ElementUtils.isDisplayed(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, asset.getCNXDate().get(measCount), null, null));
				}
			
			}
			else if(DriverManager.getDriverName().equals("Android")||DriverManager.getDriverName().equals("Web"))
			{
				for(int measCount=0;measCount<asset.getCNXDate().size();measCount++)
				{
					gestureUtils.scroll(null,null,null,asset.getCNXDate().get(measCount),0,-50,null,null);	
					Assert.assertTrue(ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, asset.getCNXDate().get(measCount), null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "[data-detail-type='scalar']"));
				}
				
			}
			assetsPage.clickOnBackButton();
			assetsPage.clickOnBackButton();
			assetsPage.clickOnBackButton();
		}
		catch(Throwable e)
		{
			assetsPage.clickOnBackButton();
			assetsPage.clickOnBackButton();
			assetsPage.clickOnBackButton();
			Assert.fail(e.toString());
		}
	}

	@Test(alwaysRun = true, priority = 27307, groups = {Config.ASSET_ANDROID_UAT,Config.TEST_ASSET,Config.ASSET_UAT_TEST})//Config.TEST_ASSET,Config.ASSET_ANDROID_UAT
	public void add805VerficationOnAnalysisPage() throws Exception
	{
		try
		{
			switcher.switchToAssetsPage();
			assetsPage.clickOnAssetGroupName(Asset.ASSET_ANALYSIS.ASSET_ANALYSIS_GROUP.getAnalysisConfig());
			assetsPage.addAsset(Asset.ASSET_ANALYSIS.ASSET_805.getAnalysisConfig(), Asset.ASSETCONFIG.ASSET_TYPE.getAssetConfig(), asset.statusFilter().get(0));	
			assetsAnalysisPage.clickOnAssetInMobileForAssetAnalysis(Asset.ASSET_ANALYSIS.ASSET_805.getAnalysisConfig());
			assetsAnalysisPage.addDataOnAnalaysisPage();
			if(DriverManager.getDriverName().equals("iOS")||DriverManager.getDriverName().equals("Android")||DriverManager.getDriverName().equals("Web"))
			{
				assetsAnalysisPage.selectMeasurementInAndroidAndWeb(Asset.MEASUREMENT_NAME.VIBRATION);
			}
			assetsAnalysisPage.clickOnAddMeasurementButton();
			Assert.assertTrue(assetsAnalysisPage.verifyGraph("805 Measurement"));
		}
		catch(Throwable e)
		{
			assetsAnalysisPage.clickOnCancelButton();
			Assert.fail(e.toString());
		}
	}
	@Test(alwaysRun = true, priority = 27308, groups = {Config.TEST_ASSET,Config.ASSET_UAT_TEST,Config.ASSET_ANDROID_UAT})//Config.TEST_ASSET,Config.ASSET_ANDROID_UAT

	public void xAxis805VerficationOnAnalysisPage() throws Exception
	{
		try
		{
			Assert.assertTrue(ElementUtils.isDisplayed(20,2,LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"com.fluke.deviceApp:id/vibration_unit",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"Acceleration - in/s (X-Axis)",LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH,"//div[@class='analysis-header']/h1[contains(text(),'gal')]"));
		}
		catch(Throwable e)
		{
			Assert.fail(e.toString());
		}
	}
	

	@Test(alwaysRun = true, priority = 27309, groups = {Config.ASSET_ANDROID_UAT,Config.TEST_ASSET,Config.ASSET_UAT_TEST})//Config.TEST_ASSET,Config.ASSET_ANDROID_UAT

	public void add805VerficationOnSavedPage() throws Exception
	{
		try
		{
			assetsAnalysisPage.clickOnViewSavedData();
			if(DriverManager.getDriverName().equals("iOS"))
			{
				for(int measCount=0;measCount<asset.getVibrationDate().size();measCount++)
				{
					CommonUtils.wait(3);
					gestureUtils.mScroll(asset.getVibrationDate().get(measCount),LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE,null,ScrollDiection.DOWN);	
					Assert.assertTrue(ElementUtils.isDisplayed(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, asset.getVibrationDate().get(measCount), null, null));
				}
			}
			else if(DriverManager.getDriverName().equals("Android")||DriverManager.getDriverName().equals("Web"))
			{
				for(int measCount=0;measCount<asset.getVibrationDate().size();measCount++)
				{
					gestureUtils.scroll(null,null,null,asset.getVibrationDate().get(measCount),0,-200,null,null);	
					Assert.assertTrue(ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, asset.getVibrationDate().get(measCount), null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".vibration-reading"));
				}
			}
			assetsPage.clickOnBackButton();
			assetsPage.clickOnBackButton();
			assetsPage.clickOnBackButton();
		}
		catch(Throwable e)
		{
			assetsPage.clickOnBackButton();
			assetsPage.clickOnBackButton();
			assetsPage.clickOnBackButton();
			Assert.fail(e.toString());
		}
	}
	
	@Test(alwaysRun = true, priority = 27310, groups = {"assets1",})//Config.TEST_ASSET,Config.TEST_ASSET
	public void addMuseVerficationOnAnalysisPage() throws Exception
	{
		try
		{
			switcher.switchToAssetsPage();
			assetsPage.clickOnAssetGroupName(Asset.ASSET_ANALYSIS.ASSET_ANALYSIS_GROUP.getAnalysisConfig());
			assetsPage.addAsset(Asset.ASSET_ANALYSIS.MUSE_ASSET.getAnalysisConfig(), Asset.ASSETCONFIG.ASSET_TYPE.getAssetConfig(), asset.statusFilter().get(0));	
			assetsAnalysisPage.clickOnAssetInMobileForAssetAnalysis(Asset.ASSET_ANALYSIS.MUSE_ASSET.getAnalysisConfig());
			assetsAnalysisPage.addDataOnAnalaysisPage();
			if(DriverManager.getDriverName().equals("iOS"))
			{
				//assetsAnalysisPage.selectFilter("ThermalImage");
				//assetsAnalysisPage.enterTheMeasurementName(Asset.ASSET_ANALYSIS.MUSE_MEASUREMENT_NAME.getAnalysisConfig());
				assetsAnalysisPage.clickOnMeasruement(Asset.ASSET_ANALYSIS.MUSE_MEASUREMENT_NAME.getAnalysisConfig(), 2);
			}
			else if(DriverManager.getDriverName().equals("Android")||DriverManager.getDriverName().equals("Web"))
			{
				assetsAnalysisPage.selectMeasurementInAndroidAndWeb(Asset.MEASUREMENT_NAME.MUSE);
			}
			assetsAnalysisPage.clickOnAddMeasurementButton();
			assetsAnalysisPage.clickOnThermalImageSection();
			Assert.assertEquals(assetsAnalysisPage.getThumbnailSize(), 2);
			Assert.assertTrue(assetsAnalysisPage.verifyGraph("Thermal Image"));
			if(DriverManager.getDriverName().equals("iOS")||DriverManager.getDriverName().equals("Android"))
			{
				assetsPage.clickOnBackButton();
			}
		}
		catch(Throwable e)
		{
			assetsPage.clickOnBackButton();
			Assert.fail(e.toString());
		}
	}
	
	@Test(alwaysRun = true, priority = 27311, groups = {})//Config.TEST_ASSET,Config.TEST_ASSET
	public void addedMuseVerficationOnSavedPage() throws Exception
	{  
	  	try
		{
			assetsAnalysisPage.clickOnViewSavedData();
			if(DriverManager.getDriverName().equals("iOS"))
			{
				Assert.assertEquals(assetsAnalysisPage.getMeasurementList(Asset.ASSET_ANALYSIS.MUSE_MEASUREMENT_NAME.getAnalysisConfig()).size(), 2);

			}
			else if(DriverManager.getDriverName().equals("Android")||DriverManager.getDriverName().equals("Web"))
			{
				for(int measCount=0;measCount<asset.getMuseDate().size();measCount++)
				{
					gestureUtils.scroll(null,null,null,asset.getMuseDate().get(measCount),0,-50,null,null);	
					Assert.assertTrue(ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, asset.getMuseDate().get(measCount), null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "#measDetailDataMuse"));
				}
			}
			assetsPage.clickOnBackButton();
			assetsPage.clickOnBackButton();
			assetsPage.clickOnBackButton();
		}
		catch(Throwable e)
		{
			assetsPage.clickOnBackButton();
			assetsPage.clickOnBackButton();
			assetsPage.clickOnBackButton();
			Assert.fail(e.toString());
		}
	}
	

	@Test(alwaysRun = true, priority = 27312, groups = {Config.TEST_ASSET,Config.ASSET_UAT_TEST})//Config.TEST_ASSET,
	public void addedThermalImageVerficationOnMeasurementPage() throws Exception
	{
		try
		{
			switcher.switchToHomePage();
			switcher.switchToMeasurementsPage();
			if(DriverManager.getDriverName().equals("iOS"))
			{
				for(int measCount=0;measCount<asset.getThermalImageDate().size();measCount++)
				{
					Assert.assertTrue(assetsAnalysisPage.getAssetNameMeasurementPage(Asset.ASSET_ANALYSIS.THERMAL_ASSET.getAnalysisConfig(),Asset.WEB_MEASUREMENT_ASSET.THERMAL_ASSET.getWebMeasurementAssetConfig(),measCount,asset.getThermalImageDate().get(measCount),assetsAnalysisPage.thermalMeasurement).isDisplayed());
					assetsAnalysisPage.measurementBackButton();
				}
			
				
			}
			else if(DriverManager.getDriverName().equals("Android")||DriverManager.getDriverName().equals("Web"))
			{
				
				for(int measCount=0;measCount<asset.getThermalImageDate().size();measCount++)
				{
					Assert.assertTrue(assetsAnalysisPage.getAssetNameMeasurementPage(Asset.ASSET_ANALYSIS.THERMAL_ASSET.getAnalysisConfig(),Asset.WEB_MEASUREMENT_ASSET.THERMAL_ASSET.getWebMeasurementAssetConfig(),measCount,asset.getThermalImageDate().get(measCount),assetsAnalysisPage.thermalMeasurement).isDisplayed());
					assetsAnalysisPage.measurementBackButton();
				}
			}
		}
		catch(Throwable e)
		{
			assetsAnalysisPage.measurementBackButton();
			Assert.fail(e.toString());
		}
	}
	

	@Test(alwaysRun = true, priority = 27313, groups = {Config.TEST_ASSET,Config.ASSET_UAT_TEST})//Config.TEST_ASSET,

	public void addedBeakerVerficationOnMeasurementPage() throws Exception
	{
		try
		{
			switcher.switchToHomePage();
			switcher.switchToMeasurementsPage();
			if(DriverManager.getDriverName().equals("iOS"))
			{
				for(int measCount=0;measCount<asset.getBeakerDate().size();measCount++)
				{
					Assert.assertTrue(assetsAnalysisPage.getAssetNameMeasurementPage(Asset.ASSET_ANALYSIS.BEAKER_ASSET.getAnalysisConfig(),Asset.WEB_MEASUREMENT_ASSET.BEAKER_ASSET.getWebMeasurementAssetConfig(),measCount,asset.getBeakerDate().get(measCount),assetsAnalysisPage.beakerMeasurement).isDisplayed());
					assetsAnalysisPage.measurementBackButton();
				}
			}
			else if(DriverManager.getDriverName().equals("Android")||DriverManager.getDriverName().equals("Web"))
			{
				for(int measCount=0;measCount<asset.getBeakerDate().size();measCount++)
				{
					Assert.assertTrue(assetsAnalysisPage.getAssetNameMeasurementPage(Asset.ASSET_ANALYSIS.BEAKER_ASSET.getAnalysisConfig(),Asset.WEB_MEASUREMENT_ASSET.BEAKER_ASSET.getWebMeasurementAssetConfig(),measCount,asset.getBeakerDate().get(measCount),assetsAnalysisPage.beakerMeasurement).isDisplayed());
					assetsAnalysisPage.measurementBackButton();
				}
			}
		
		}
		catch(Throwable e)
		{
			assetsAnalysisPage.measurementBackButton();
			Assert.fail(e.toString());
		}
	}
	
	@Test(alwaysRun = true, priority = 27314, groups = {Config.TEST_ASSET,Config.ASSET_UAT_TEST})//Config.TEST_ASSET,
	public void addedCNXVerficationOnMeasurementPage() throws Exception
	{
		try
		{
			switcher.switchToHomePage();
			switcher.switchToMeasurementsPage();
			if(DriverManager.getDriverName().equals("iOS"))
			{
				for(int measCount=0;measCount<asset.getCNXDate().size();measCount++)
				{
					Assert.assertTrue(assetsAnalysisPage.getAssetNameMeasurementPage(Asset.ASSET_ANALYSIS.CNX_ASSET.getAnalysisConfig(),Asset.WEB_MEASUREMENT_ASSET.CNX_ASSET.getWebMeasurementAssetConfig(),measCount,asset.getCNXDate().get(measCount),assetsAnalysisPage.scalerMeasurement).isDisplayed());
					assetsAnalysisPage.measurementBackButton();
				}
			}
			else if(DriverManager.getDriverName().equals("Android")||DriverManager.getDriverName().equals("Web"))
			{
				for(int measCount=0;measCount<asset.getCNXDate().size();measCount++)
				{
					Assert.assertTrue(assetsAnalysisPage.getAssetNameMeasurementPage(Asset.ASSET_ANALYSIS.CNX_ASSET.getAnalysisConfig(),Asset.WEB_MEASUREMENT_ASSET.CNX_ASSET.getWebMeasurementAssetConfig(),measCount,asset.getCNXDate().get(measCount),assetsAnalysisPage.scalerMeasurement).isDisplayed());
					assetsAnalysisPage.measurementBackButton();
				}
			}
		}
		catch(Throwable e)
		{
			assetsAnalysisPage.measurementBackButton();
			Assert.fail(e.toString());
		}
	}
	
	@Test(alwaysRun = true, priority = 27315, groups = {Config.ASSET_UAT_TEST})//Config.TEST_ASSET,
	public void added805VerficationOnMeasurementPage() throws Exception
	{
		try
		{
			switcher.switchToHomePage();
			switcher.switchToMeasurementsPage();
			if(DriverManager.getDriverName().equals("iOS"))
			{
				for(int measCount=0;measCount<asset.getVibrationDate().size();measCount++)
				{
					Assert.assertTrue(assetsAnalysisPage.getAssetNameMeasurementPage(Asset.ASSET_ANALYSIS.ASSET_805.getAnalysisConfig(),Asset.WEB_MEASUREMENT_ASSET.ASSET_805.getWebMeasurementAssetConfig(),measCount,asset.getVibrationDate().get(measCount),assetsAnalysisPage.vibrationMeas).isDisplayed());
					assetsAnalysisPage.measurementBackButton();
				}
			
			}
			else if(DriverManager.getDriverName().equals("Android")||DriverManager.getDriverName().equals("Web"))
			{
				for(int measCount=0;measCount<asset.getVibrationDate().size();measCount++)
				{
					Assert.assertTrue(assetsAnalysisPage.getAssetNameMeasurementPage(Asset.ASSET_ANALYSIS.ASSET_805.getAnalysisConfig(),Asset.WEB_MEASUREMENT_ASSET.ASSET_805.getWebMeasurementAssetConfig(),measCount,asset.getVibrationDate().get(measCount),assetsAnalysisPage.vibrationMeas).isDisplayed());
					assetsAnalysisPage.measurementBackButton();
				}
			}
		}
		catch(Throwable e)
		{
			assetsAnalysisPage.measurementBackButton();
			Assert.fail(e.toString());
		}
	}

	@Test(alwaysRun = true, priority = 27316, groups = {})//Config.TEST_ASSET,"assets1",Config.TEST_ASSET
	public void addedMuseVerficationOnMeasurementPage() throws Exception
	{
		try
		{
			switcher.switchToHomePage();
			switcher.switchToMeasurementsPage();
			assetsAnalysisPage.selectFilter("ThermalImage");
			if(DriverManager.getDriverName().equals("iOS"))
			{
				Assert.assertEquals(assetsAnalysisPage.getAssignAssetList(Asset.ASSET_ANALYSIS.MUSE_ASSET.getAnalysisConfig()).size(), 2);
			}
			else if(DriverManager.getDriverName().equals("Android")||DriverManager.getDriverName().equals("Web"))
			{
				for(int measCount=0;measCount<asset.getMuseDate().size();measCount++)
				{
					//Assert.assertTrue(ElementUtils.isDisplayed(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_XPATH_WITH_TEXT_VIEW, assetsAnalysisPage.getAssetNameOnMeasurementPage(measCount), null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, "//label[@id='locked-value' and text()='"+Asset.ASSET_ANALYSIS.MUSE_ASSET.getAnalysisConfig()+"']"));
					Assert.assertTrue(assetsAnalysisPage.getAssetNameMeasurementPage(Asset.ASSET_ANALYSIS.MUSE_ASSET.getAnalysisConfig(),Asset.WEB_MEASUREMENT_ASSET.MUSE_ASSET.getWebMeasurementAssetConfig(),measCount,asset.getMuseDate().get(measCount),assetsAnalysisPage.museMeas).isDisplayed());
					assetsAnalysisPage.measurementBackButton();
				}
			}
		}
		catch(Throwable e)
		{
			assetsAnalysisPage.measurementBackButton();
			Assert.fail(e.toString());
		}
	}
	
	
	/////////////////////////////////////////////////  Asset Analysis test case End here////////////////////////////////////////////////////////////////
	
	
	
	//####################################### Asset Alarm test case start here ###############################################//
	
	
	

	@Test(alwaysRun = true, priority = 27317, groups = {Config.TEST_ASSET,Config.ASSET_ANDROID_UAT,Config.ASSET_UAT_TEST})//Config.TEST_ASSET,
	public void addCurrentAlarm() throws Exception
	{
		try
		{
			switcher.switchToAssetsPage();
			assetsPage.clickOnAssetGroupName(Asset.ASSETCONFIG.ASSET_GROUP_ALARM.getAssetConfig());
			assetsPage.addAsset(Asset.ALARM_NAME.CURRENT_ALARM.getAlarmName(), Asset.ASSETCONFIG.ASSET_TYPE.getAssetConfig(), asset.statusFilter().get(0));
			assetsPage.clickOnAssetName(Asset.ALARM_NAME.CURRENT_ALARM.getAlarmName());
			assetsAnalysisPage.clickOnAlarmSection();
			for(int alarmCount=0;alarmCount<ALARM_TYPE.values().length;alarmCount++)
			{
			  	String  alarmTypeCreated=assetsAnalysisPage.createAlarm(ALARM_TYPE.values()[alarmCount],Asset.ALARM_NAME.CURRENT.getAlarmName(),"34","100");	
				assetsAnalysisPage.enterOtherAttributeOfAlarms(Asset.ALARM_NAME.CURRENT_ALARM.getAlarmName(),Asset.TEAM_MEMBER.ME.getTeamMember());
				gestureUtils.scroll(null,null,null,alarmTypeCreated,0,-150,null,null);	
				CommonUtils.wait(2,2,5);
				Assert.assertTrue(ElementUtils.isDisplayed(20,3,LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, alarmTypeCreated, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, alarmTypeCreated, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS, alarmTypeCreated));
			}
			assetsPage.clickOnBackButton();
			if(DriverManager.getDriverName().equals("Web"))
				assetsPage.clickOnAssetGroupName(Asset.ASSETCONFIG.ASSET_GROUP_ALARM.getAssetConfig());	
			assetsPage.deleteAsset(Asset.ALARM_NAME.CURRENT_ALARM.getAlarmName().toString());			
		}
		catch(Throwable e)  
		{
			assetsPage.clickOnBackButton();
			if(DriverManager.getDriverName().equals("Web"))
				assetsPage.clickOnAssetGroupName(Asset.ASSETCONFIG.ASSET_GROUP_ALARM.getAssetConfig());
			assetsPage.deleteAsset(Asset.ALARM_NAME.CURRENT_ALARM.getAlarmName().toString());
			Assert.fail(e.toString());
		}
	}
	
	@Test(alwaysRun = true, priority = 27318, groups = {Config.TEST_ASSET,Config.ASSET_ANDROID_UAT,Config.ASSET_UAT_TEST})//Config.TEST_ASSET,

	public void addVoltageAlarm() throws Exception
	{
		try
		{
			assetsPage.addAsset(Asset.ALARM_NAME.VOLATGE_ALARM.getAlarmName(), Asset.ASSETCONFIG.ASSET_TYPE.getAssetConfig(), asset.statusFilter().get(0));
			assetsPage.clickOnAssetName(Asset.ALARM_NAME.VOLATGE_ALARM.getAlarmName());
			assetsAnalysisPage.clickOnAlarmSection();
			for(int alarmCount=0;alarmCount<ALARM_TYPE.values().length;alarmCount++)
			{
				String  alarmTypeCreated=assetsAnalysisPage.createAlarm(ALARM_TYPE.values()[alarmCount],Asset.ALARM_NAME.VOLATGE.getAlarmName(),"34","100");	
				assetsAnalysisPage.enterOtherAttributeOfAlarms(Asset.ALARM_NAME.VOLATGE_ALARM.getAlarmName(),Asset.TEAM_MEMBER.ME.getTeamMember());
				gestureUtils.scroll(null,null,null,alarmTypeCreated,0,-250,null,null);
				CommonUtils.wait(2,2,5);
				Assert.assertTrue(ElementUtils.isDisplayed(30,2,LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, alarmTypeCreated, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, alarmTypeCreated, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS, alarmTypeCreated));
			}
			assetsPage.clickOnBackButton();
			if(DriverManager.getDriverName().equals("Web"))
				assetsPage.clickOnAssetGroupName(Asset.ASSETCONFIG.ASSET_GROUP_ALARM.getAssetConfig());
			assetsPage.deleteAsset(Asset.ALARM_NAME.VOLATGE_ALARM.getAlarmName());
			
		}
		catch(Throwable e)
		{
			assetsPage.clickOnBackButton();
			if(DriverManager.getDriverName().equals("Web"))
				assetsPage.clickOnAssetGroupName(Asset.ASSETCONFIG.ASSET_GROUP_ALARM.getAssetConfig());
			assetsPage.deleteAsset(Asset.ALARM_NAME.VOLATGE_ALARM.getAlarmName().toString());
			Assert.fail(e.toString());
		}
	}

	@Test(alwaysRun = true, priority = 27319, groups = {Config.TEST_ASSET,Config.ASSET_ANDROID_UAT,Config.ASSET_UAT_TEST})//Config.TEST_ASSET,
	public void addFrequencyAlarm() throws Exception
	{
		try
		{
			assetsPage.addAsset(Asset.ALARM_NAME.FREQUENCY_ALARM.getAlarmName(), Asset.ASSETCONFIG.ASSET_TYPE.getAssetConfig(), asset.statusFilter().get(0));
			assetsPage.clickOnAssetName(Asset.ALARM_NAME.FREQUENCY_ALARM.getAlarmName());
			assetsAnalysisPage.clickOnAlarmSection();
			for(int alarmCount=0;alarmCount<ALARM_TYPE.values().length;alarmCount++)
			{
				String  alarmTypeCreated=assetsAnalysisPage.createAlarm(ALARM_TYPE.values()[alarmCount],Asset.ALARM_NAME.FREQUENCY.getAlarmName(),"34","100");	
				assetsAnalysisPage.enterOtherAttributeOfAlarms(Asset.ALARM_NAME.FREQUENCY_ALARM.getAlarmName(),Asset.TEAM_MEMBER.ME.getTeamMember());
				gestureUtils.scroll(null,null,null,alarmTypeCreated,0,-250,null,null);
				CommonUtils.wait(2,2,5);
				Assert.assertTrue(ElementUtils.isDisplayed(30,2,LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, alarmTypeCreated, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, alarmTypeCreated, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS, alarmTypeCreated));
			}
			assetsPage.clickOnBackButton();
			if(DriverManager.getDriverName().equals("Web"))
				assetsPage.clickOnAssetGroupName(Asset.ASSETCONFIG.ASSET_GROUP_ALARM.getAssetConfig());
			assetsPage.deleteAsset(Asset.ALARM_NAME.FREQUENCY_ALARM.getAlarmName().toString());			
		}
		catch(Throwable e)
		{
			assetsPage.clickOnBackButton();
			if(DriverManager.getDriverName().equals("Web"))
				assetsPage.clickOnAssetGroupName(Asset.ASSETCONFIG.ASSET_GROUP_ALARM.getAssetConfig());
			assetsPage.deleteAsset(Asset.ALARM_NAME.FREQUENCY_ALARM.getAlarmName());
			Assert.fail(e.toString());
		}
	}
	
	@Test(alwaysRun = true, priority = 27320, groups = {Config.TEST_ASSET,Config.ASSET_UAT_TEST,Config.ASSET_ANDROID_UAT})//Config.TEST_ASSET,
	public void addPowerFactorAlarm() throws Exception
	{
		try
		{
			assetsPage.addAsset(Asset.ALARM_NAME.POEWR_FACTOR_ALARM.getAlarmName(), Asset.ASSETCONFIG.ASSET_TYPE.getAssetConfig(), asset.statusFilter().get(0));
			assetsPage.clickOnAssetName(Asset.ALARM_NAME.POEWR_FACTOR_ALARM.getAlarmName());
			assetsAnalysisPage.clickOnAlarmSection();
			CommonUtils.wait(3);
			for(int alarmCount=0;alarmCount<ALARM_TYPE.values().length;alarmCount++)
			{  
				String  alarmTypeCreated=assetsAnalysisPage.createAlarm(ALARM_TYPE.values()[alarmCount],Asset.ALARM_NAME.POEWR_FACTOR.getAlarmName(),".1","1");	
				assetsAnalysisPage.enterOtherAttributeOfAlarms(Asset.ALARM_NAME.POEWR_FACTOR_ALARM.getAlarmName(),Asset.TEAM_MEMBER.ME.getTeamMember());
				gestureUtils.scroll(null,null,null,alarmTypeCreated,0,-250,null,null); 
				CommonUtils.wait(2,2,5);
				Assert.assertTrue(ElementUtils.isDisplayed(30,2,LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, alarmTypeCreated, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, alarmTypeCreated, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS, alarmTypeCreated));
			}
			assetsPage.clickOnBackButton();
			if(DriverManager.getDriverName().equals("Web"))
				assetsPage.clickOnAssetGroupName(Asset.ASSETCONFIG.ASSET_GROUP_ALARM.getAssetConfig());
			assetsPage.deleteAsset(Asset.ALARM_NAME.POEWR_FACTOR_ALARM.getAlarmName().toString());			
		}
		catch(Throwable e)
		{
			assetsPage.clickOnBackButton();
			if(DriverManager.getDriverName().equals("Web"))
				assetsPage.clickOnAssetGroupName(Asset.ASSETCONFIG.ASSET_GROUP_ALARM.getAssetConfig());
	    	assetsPage.deleteAsset(Asset.ALARM_NAME.POEWR_FACTOR_ALARM.getAlarmName().toString());
			Assert.fail(e.toString());
		}
	}
	
	
	

	@Test(alwaysRun = true, priority = 27321, groups = {Config.TEST_ASSET,Config.ASSET_ANDROID_UAT,Config.ASSET_UAT_TEST})//Config.TEST_ASSET,

	public void addTempratureAlarm() throws Exception
	{
		try
		{
			assetsPage.addAsset(Asset.ALARM_NAME.TEMPERATURE_ALARM.getAlarmName(), Asset.ASSETCONFIG.ASSET_TYPE.getAssetConfig(), asset.statusFilter().get(0));
			assetsPage.clickOnAssetName(Asset.ALARM_NAME.TEMPERATURE_ALARM.getAlarmName());
			assetsAnalysisPage.clickOnAlarmSection();
			
			for(int alarmCount=0;alarmCount<ALARM_TYPE.values().length;alarmCount++)
			{
				String  alarmTypeCreated=assetsAnalysisPage.createAlarm(ALARM_TYPE.values()[alarmCount],Asset.ALARM_NAME.TEMPERATURE.getAlarmName(),"34","100");	
				assetsAnalysisPage.enterOtherAttributeOfAlarms(Asset.ALARM_NAME.TEMPERATURE_ALARM.getAlarmName(),Asset.TEAM_MEMBER.ME.getTeamMember());
				gestureUtils.scroll(null,null,null,alarmTypeCreated,0,-250,null,null);
				CommonUtils.wait(2,2,5);
				Assert.assertTrue(ElementUtils.isDisplayed(30,2,LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, alarmTypeCreated, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, alarmTypeCreated, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS, alarmTypeCreated));
			}
			assetsPage.clickOnBackButton();
			if(DriverManager.getDriverName().equals("Web"))
				assetsPage.clickOnAssetGroupName(Asset.ASSETCONFIG.ASSET_GROUP_ALARM.getAssetConfig());
	    	assetsPage.deleteAsset(Asset.ALARM_NAME.TEMPERATURE_ALARM.getAlarmName());

			
		}
		catch(Throwable e)
		{
			assetsPage.clickOnBackButton();
			if(DriverManager.getDriverName().equals("Web"))
				assetsPage.clickOnAssetGroupName(Asset.ASSETCONFIG.ASSET_GROUP_ALARM.getAssetConfig());
	    	assetsPage.deleteAsset(Asset.ALARM_NAME.TEMPERATURE_ALARM.getAlarmName());
			Assert.fail(e.toString());
		}
	}
	
	@Test(alwaysRun = true, priority = 27322, groups = {Config.TEST_ASSET,Config.ASSET_ANDROID_UAT,Config.ASSET_UAT_TEST})//Config.TEST_ASSET,

	public void addActivePowerAlarm() throws Exception
	{
		try
		{
			assetsPage.addAsset(Asset.ALARM_NAME.ACTIVE_POWER_ALARM.getAlarmName(), Asset.ASSETCONFIG.ASSET_TYPE.getAssetConfig(), asset.statusFilter().get(0));
			assetsPage.clickOnAssetName(Asset.ALARM_NAME.ACTIVE_POWER_ALARM.getAlarmName());
			assetsAnalysisPage.clickOnAlarmSection();	
			String  alarmTypeCreated=assetsAnalysisPage.createAlarm(ALARM_TYPE.ABOVE,Asset.ALARM_NAME.ACTIVE_POWER.getAlarmName(),"34","100");	
			assetsAnalysisPage.enterOtherAttributeOfAlarms(Asset.ALARM_NAME.ACTIVE_POWER_ALARM.getAlarmName(),Asset.TEAM_MEMBER.ME.getTeamMember());
			gestureUtils.scroll(null,null,null,alarmTypeCreated,0,-250,null,null);
			CommonUtils.wait(2,2,3);
			Assert.assertTrue(ElementUtils.isDisplayed(40,2,LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, alarmTypeCreated, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, alarmTypeCreated, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS, alarmTypeCreated));
			
			assetsPage.clickOnBackButton();
			if(DriverManager.getDriverName().equals("Web"))
				assetsPage.clickOnAssetGroupName(Asset.ASSETCONFIG.ASSET_GROUP_ALARM.getAssetConfig());
	   		assetsPage.deleteAsset(Asset.ALARM_NAME.ACTIVE_POWER_ALARM.getAlarmName());
		}
		catch(Throwable e)
		{
			assetsPage.clickOnBackButton();
			if(DriverManager.getDriverName().equals("Web"))
				assetsPage.clickOnAssetGroupName(Asset.ASSETCONFIG.ASSET_GROUP_ALARM.getAssetConfig());
	   		assetsPage.deleteAsset(Asset.ALARM_NAME.ACTIVE_POWER_ALARM.getAlarmName());
			Assert.fail(e.toString());
		}
	}
	
	
	@Test(alwaysRun = true, priority = 27323, groups = {Config.TEST_ASSET,Config.ASSET_ANDROID_UAT,Config.ASSET_UAT_TEST})//Config.TEST_ASSET,

	public void addTHDAAlarm() throws Exception
	{
		try
		{
			assetsPage.addAsset(Asset.ALARM_NAME.THD_A_ALARM.getAlarmName(), Asset.ASSETCONFIG.ASSET_TYPE.getAssetConfig(), asset.statusFilter().get(0));
			assetsPage.clickOnAssetName(Asset.ALARM_NAME.THD_A_ALARM.getAlarmName());
			assetsAnalysisPage.clickOnAlarmSection();
			
			String  alarmTypeCreated=assetsAnalysisPage.createAlarm(ALARM_TYPE.ABOVE,Asset.ALARM_NAME.THD_A.getAlarmName(),"34","100");	
			assetsAnalysisPage.enterOtherAttributeOfAlarms(Asset.ALARM_NAME.THD_A_ALARM.getAlarmName(),Asset.TEAM_MEMBER.ME.getTeamMember());
			gestureUtils.scroll(null,null,null,alarmTypeCreated,0,-250,null,null);
			CommonUtils.wait(3,3,1);
			Assert.assertTrue(ElementUtils.isDisplayed(30,2,LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, alarmTypeCreated, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, alarmTypeCreated, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS, alarmTypeCreated));
			
			assetsPage.clickOnBackButton();
			if(DriverManager.getDriverName().equals("Web"))
				assetsPage.clickOnAssetGroupName(Asset.ASSETCONFIG.ASSET_GROUP_ALARM.getAssetConfig());
	   		assetsPage.deleteAsset(Asset.ALARM_NAME.THD_A_ALARM.getAlarmName());			
		}
		catch(Throwable e)
		{
			assetsPage.clickOnBackButton();
			if(DriverManager.getDriverName().equals("Web"))
				assetsPage.clickOnAssetGroupName(Asset.ASSETCONFIG.ASSET_GROUP_ALARM.getAssetConfig());
	   		assetsPage.deleteAsset(Asset.ALARM_NAME.THD_A_ALARM.getAlarmName());
			Assert.fail(e.toString());
		}
	}
	
	@Test(alwaysRun = true, priority = 27324, groups = {Config.TEST_ASSET,Config.ASSET_ANDROID_UAT,Config.ASSET_UAT_TEST})//Config.TEST_ASSET,
	public void addTHDVAlarm() throws Exception
	{
		try
		{
		  	assetsPage.addAsset(Asset.ALARM_NAME.THD_V_ALARM.getAlarmName(), Asset.ASSETCONFIG.ASSET_TYPE.getAssetConfig(), asset.statusFilter().get(0));
			assetsPage.clickOnAssetName(Asset.ALARM_NAME.THD_V_ALARM.getAlarmName());
			assetsAnalysisPage.clickOnAlarmSection();
			
			String  alarmTypeCreated=assetsAnalysisPage.createAlarm(ALARM_TYPE.ABOVE,Asset.ALARM_NAME.THD_V.getAlarmName(),"34","100");	
			assetsAnalysisPage.enterOtherAttributeOfAlarms(Asset.ALARM_NAME.THD_V_ALARM.getAlarmName(),Asset.TEAM_MEMBER.ME.getTeamMember());
			gestureUtils.scroll(null,null,null,alarmTypeCreated,0,-50,null,null);
			CommonUtils.wait(3,3,1);
			Assert.assertTrue(ElementUtils.isDisplayed(30,2,LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, alarmTypeCreated, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, alarmTypeCreated, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS, alarmTypeCreated));
			  
			assetsPage.clickOnBackButton();
			if(DriverManager.getDriverName().equals("Web"))
				assetsPage.clickOnAssetGroupName(Asset.ASSETCONFIG.ASSET_GROUP_ALARM.getAssetConfig());
	   		assetsPage.deleteAsset(Asset.ALARM_NAME.THD_V_ALARM.getAlarmName());
	   		assetsPage.clickOnBackButton();
		}
		catch(Throwable e)
		{
			assetsPage.clickOnBackButton();
			if(DriverManager.getDriverName().equals("Web"))
				assetsPage.clickOnAssetGroupName(Asset.ASSETCONFIG.ASSET_GROUP_ALARM.getAssetConfig());
	   		assetsPage.deleteAsset(Asset.ALARM_NAME.THD_V_ALARM.getAlarmName());
	   		assetsPage.clickOnBackButton();
			Assert.fail(e.toString());
		}
	}
	//####################################### Asset Alarm test case End here ###############################################//
	
	
	@Test(alwaysRun = true, priority = 27331, groups = {Config.TEST_ASSET,Config.ASSET_ANDROID_UAT,Config.ASSET_UAT_TEST})//Config.TEST_ASSET,
	public void thermalImageMinValueVerficationOnAnalysisPage()
	{
		try
		{
			assetsPage.clickOnAssetGroupName(Asset.ASSET_ANALYSIS.ASSET_ANALYSIS_GROUP.getAnalysisConfig());
			gestureUtils.scroll(null,null,null,Asset.ASSET_ANALYSIS.THERMAL_ASSET.getAnalysisConfig(),0,-150,null,null);
			assetsPage.clickOnAssetName(Asset.ASSET_ANALYSIS.THERMAL_ASSET.getAnalysisConfig());
			CommonUtils.wait(2,2,4);
			assetsAnalysisPage.clickOnAnalysisTab();
			assetsAnalysisPage.clickOnThermalImageSection();
			assetsAnalysisPage.clickOnMinMaxRadioButton("Min");
			CommonUtils.wait(5,5,5);
			for (int thumbNailCount=0;thumbNailCount<assetsAnalysisPage.getThumbnailSize();thumbNailCount++)
			{
				Assert.assertTrue(assetsAnalysisPage.convertTempValueInInteger(assetsAnalysisPage.getThumbnailImageValue(thumbNailCount),"°C")<assetsAnalysisPage.convertTempValueInInteger(assetsAnalysisPage.getEnlargeThermalImageValue(),"°C"));
			}
		
		}
		catch(Throwable e)
		{
			Assert.fail(e.toString());
		}
	}
	
	@Test(alwaysRun = true, priority = 273032, groups = {Config.TEST_ASSET,Config.ASSET_ANDROID_UAT,Config.ASSET_UAT_TEST})//Config.TEST_ASSET,

	public void thermalImageMinGraphVerficationOnAnalysisPage()
	{
		try
		{
			Assert.assertTrue(assetsAnalysisPage.isGrpahDispalyed());
		}
		catch(Throwable e)
		{
			Assert.fail(e.toString());
		}
	}
	
	@Test(alwaysRun = true, priority = 273034, groups = {Config.TEST_ASSET,Config.ASSET_ANDROID_UAT,Config.ASSET_UAT_TEST})//Config.TEST_ASSET,

	public void thermalImageMaxValueVerficationOnAnalysisPage()
	{
		try
		{
			assetsAnalysisPage.clickOnMinMaxRadioButton("Max");
			CommonUtils.wait(5,5,5);
			for (int thumbNailCount=0;thumbNailCount<assetsAnalysisPage.getThumbnailSize();thumbNailCount++)
			{
		  		Assert.assertTrue(assetsAnalysisPage.convertTempValueInInteger(assetsAnalysisPage.getThumbnailImageValue(thumbNailCount),"°C")>assetsAnalysisPage.convertTempValueInInteger(assetsAnalysisPage.getEnlargeThermalImageValue(),"°C"));
			}
		}
		catch(Throwable e)
		{
			Assert.fail(e.toString());
		}
	}
	
	

	@Test(alwaysRun = true, priority = 273035, groups = {Config.TEST_ASSET,Config.ASSET_ANDROID_UAT,Config.ASSET_UAT_TEST})//Config.TEST_ASSET,
	public void thermalImageMaxGraphVerficationOnAnalysisPage()
	{
		try
		{
			Assert.assertTrue(assetsAnalysisPage.isGrpahDispalyed());
		}
		catch(Throwable e)
		{
			Assert.fail(e.toString());
		}
	}
	
	@Test(alwaysRun = true, priority = 273036, groups = {Config.TEST_ASSET,Config.ASSET_ANDROID_UAT,Config.ASSET_UAT_TEST})//Config.TEST_ASSET,

	public void thermalImageCenterPointValueVerficationOnAnalysisPage()
	{
		try
		{

			assetsAnalysisPage.clickOnMinMaxRadioButton("Center Point");
			CommonUtils.wait(5,5,5);
			for (int thumbNailCount=0;thumbNailCount<assetsAnalysisPage.getThumbnailSize();thumbNailCount++)
			{
				Assert.assertEquals(assetsAnalysisPage.getThumbnailImageValue(thumbNailCount),assetsAnalysisPage.getEnlargeThermalImageValue());
			}
		}
		catch(Throwable e)
		{
			Assert.fail(e.toString());
		}
	}

	@Test(alwaysRun = true, priority = 273037, groups = {Config.TEST_ASSET,Config.ASSET_ANDROID_UAT,Config.ASSET_UAT_TEST})//Config.TEST_ASSET,

	public void thermalImageCenterPointGraphVerficationOnAnalysisPage() throws Exception
	{
		try
		{
			Assert.assertTrue(assetsAnalysisPage.isGrpahDispalyed());
			assetsPage.clickOnBackButton();
			assetsPage.clickOnBackButton();
			assetsPage.deleteAssetGroup(Asset.ASSET_ANALYSIS.ASSET_ANALYSIS_GROUP.getAnalysisConfig());
			
		}
		catch(Throwable e)
		{
			assetsPage.clickOnBackButton();
			assetsPage.deleteAssetGroup(Asset.ASSET_ANALYSIS.ASSET_ANALYSIS_GROUP.getAnalysisConfig());
			Assert.fail(e.toString());
		}
	}
	
	
	@AfterClass(alwaysRun = true, groups = {
			 Config.WEB_SMOKE_ASSET_EXTENDED,Config.ASSET_ANDROID_UAT,Config.ASSET_UAT_TEST
			 })
	public void classTearDown() throws Exception 
	{
		if(!DriverManager.isSmokeSuite()) { 
			//DriverManager.closeApp();
			//DriverManager.launchApp();
			 DriverManager.getSwitcher().signOut();
		}
	}
	

	
	
}*/
