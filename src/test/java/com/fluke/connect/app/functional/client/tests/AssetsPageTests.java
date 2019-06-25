package com.fluke.connect.app.functional.client.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fluke.connect.app.functional.client.pages.AssetsPage;
import com.fluke.connect.app.functional.client.pages.MeasurementsHistoryPage;
import com.fluke.connect.app.functional.client.pages.NewAssetPage;
import com.fluke.connect.app.functional.client.pages.Switcher;
import com.fluke.connect.app.testdata.Asset;
import com.fluke.connect.app.testdata.SignIn;
import com.fluke.connect.app.testdata.SignIn.FeatureList;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DateAndTimeUtils;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.FileUtil;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.TestNGUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;

import io.appium.java_client.MobileBy;

@SuppressWarnings("unused")
public class AssetsPageTests 
{
	private AssetsPage assetsPage;
	private Switcher switcher;
	private MeasurementsHistoryPage measurementsHistoryPage;
	private Asset asset;
 	private String vibrationMeterDeviceName = "Fluke 805FC";
	
	private String timeStamp = " "+DateAndTimeUtils.getCurrentTimeStamp();
	

	@BeforeClass(alwaysRun = true, groups = {Config.IOS_FULL_TESTS, Config.TEST_ASSET, Config.IOS_SMOKE_TESTS,Config.FC_805_TESTS, Config.ANDROID_ASSET_SMOKE_EXT_TESTS,Config.ANDROID_UAT_TESTS,"assets",Config.ASSET_UAT_TEST,
			Config.ASSET_ANDROID_UAT,Config.IOS_ASSET_SMOKE_EXT_TESTS,
			Config.ANDROID_SMOKE_EXTENDED_TESTS,Config.WEB_SMOKE_ASSET_EXTENDED})
	public void initClass() throws Exception
	{
		
		if(!DriverManager.isSmokeSuite()) {
			DriverManager.getSignIn().signIn(SignIn.getUID(FeatureList.ASSETS), SignIn.getPWD(FeatureList.ASSETS));
	        DriverManager.getSignIn().handleAfterSignInAlertsOtherUser();
		}
		else
		{
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
				DriverManager.getSignIn().signIn(SignIn.getUID(FeatureList.SMOKE_WEB), SignIn.getPWD(FeatureList.SMOKE_WEB));
				DriverManager.getSignIn().handleAfterSignInAlerts();
		        DriverManager.setSmokeSuiteFlag(true);
			}
			
		}
		assetsPage = new AssetsPage();
		switcher = new Switcher();
		switcher.switchToAssetsPage();
		measurementsHistoryPage = new MeasurementsHistoryPage();
		asset=new Asset();
		
		
	}
	
	//smoke test starts
	
//	################################################################################################# 
//	##Modified and Created Test case Start here        
	//@author -- Akhilesh 
	

	//$$$$$$$$$$$$$$$$$$$$$$$$ Asset Group,Asset,TestPoint Creation, deletion  Start Here///

	@Test(alwaysRun = true, priority = 26301, groups = {Config.IOS_SMOKE_TESTS,  Config.ANDROID_ASSET_SMOKE_EXT_TESTS,Config.ANDROID_UAT_TESTS,Config.TEST_ASSET,Config.ASSET_UAT_TEST,Config.IOS_ASSET_SMOKE_EXT_TESTS,
			Config.ASSET_ANDROID_UAT,Config.WEB_SMOKE_ASSET_EXTENDED, Config.ANDROID_SMOKE_EXTENDED_TESTS,Config.ASSET_UAT_TEST})//Config.TEST_ASSET,
	public void addBasicAssetGroupTest()
	{
		try
		{
			CommonUtils.wait(10,2,1);
			assetsPage.addAssetGroup(Asset.ASSETCONFIG.ASSET_GROUP_A.getAssetConfig());
			CommonUtils.wait(2);
			Assert.assertTrue(assetsPage.isAssetGroupCreated(Asset.ASSETCONFIG.ASSET_GROUP_A.getAssetConfig()));
		}
		catch(Throwable e)
		{
			Assert.fail(e.toString());
		}
	}
	
	@Test(alwaysRun = true, priority = 26302, groups = {})//
	public void verfiyEditBasicAssetGroupTest()
	{
		try
		{
			assetsPage.clickOnAssetGroupName(Asset.ASSETCONFIG.ASSET_GROUP_A.getAssetConfig());
			assetsPage.editGroup(Asset.ASSETCONFIG.ASSET_GROUP_EDIT.getAssetConfig(),Asset.ASSETCONFIG.ASSET_GROUP_A.getAssetConfig());
			assetsPage.clickOnBackButton();
			CommonUtils.wait(1);
			Assert.assertTrue(assetsPage.isAssetGroupCreated(Asset.ASSETCONFIG.ASSET_GROUP_EDIT.getAssetConfig()));
		}
		catch(Throwable e)
		{
			Assert.fail(e.toString());
		}
	}
		

	@Test(alwaysRun = true, priority = 26303, groups = {Config.IOS_SMOKE_TESTS, Config.ANDROID_ASSET_SMOKE_EXT_TESTS,
			Config.TEST_ASSET,"assets",Config.IOS_ASSET_SMOKE_EXT_TESTS,Config.ASSET_UAT_TEST,Config.ASSET_ANDROID_UAT, Config.ANDROID_SMOKE_EXTENDED_TESTS, Config.WEB_SMOKE_ASSET_EXTENDED})//,C//Config.TEST_ASSET ,Config.ASSET_UAT_TEST

	public void verifyAddAsset() throws Exception
	{
		try
		{	
			assetsPage.clickOnAssetGroupName(Asset.ASSETCONFIG.ASSET_GROUP_A.getAssetConfig());
			assetsPage.addAsset(Asset.ASSETCONFIG.ASSET_NAME.getAssetConfig(), Asset.ASSETCONFIG.ASSET_TYPE.getAssetConfig(), asset.statusFilter().get(0));	
			Assert.assertTrue(assetsPage.isAssetCreated(Asset.ASSETCONFIG.ASSET_NAME.getAssetConfig()));
			assetsPage.clickOnBackButton();
		}
		catch(Throwable e)
		{
			assetsPage.clickOnBackButton();
			e.printStackTrace();
			Assert.fail(e.toString());
		}
	}

	@Test(alwaysRun = true, priority = 26304, groups = { Config.IOS_SMOKE_TESTS, Config.TEST_ASSET,"assets1",Config.IOS_ASSET_SMOKE_EXT_TESTS, Config.ANDROID_ASSET_SMOKE_EXT_TESTS,
			Config.WEB_SMOKE_ASSET_EXTENDED,Config.ANDROID_SMOKE_EXTENDED_TESTS,Config.ASSET_ANDROID_UAT,Config.ASSET_UAT_TEST})//,Config.TEST_ASSET ,Config.ANDROID_SMOKE_EXTENDED_TESTS,

	public void verifyEditAsset() throws Exception
	{
		try
		{
			switcher.switchToAssetsPage();
			assetsPage.clickOnAssetGroupName(Asset.ASSETCONFIG.ASSET_GROUP_A.getAssetConfig());			
			assetsPage.clickOnAssetName(Asset.ASSETCONFIG.ASSET_NAME.getAssetConfig());
			assetsPage.editAsset(Asset.ASSETCONFIG.ASSET_NAME_EDIT.getAssetConfig());
			CommonUtils.wait(3,1,5);
			if(DriverManager.getDriverName().equals("iOS")||DriverManager.getDriverName().equals("Android"))
			{
				assetsPage.clickOnBackButton();
				assetsPage.clickOnBackButton();
				assetsPage.clickOnAssetGroupName(Asset.ASSETCONFIG.ASSET_GROUP_A.getAssetConfig());
				assetsPage.clickOnBackButton();
				assetsPage.clickOnAssetGroupName(Asset.ASSETCONFIG.ASSET_GROUP_A.getAssetConfig());
				assetsPage.clickOnBackButton();
				assetsPage.clickOnAssetGroupName(Asset.ASSETCONFIG.ASSET_GROUP_A.getAssetConfig());
				//Assert.assertTrue(assetsPage.isAssetCreated(Asset.ASSETCONFIG.ASSET_NAME_EDIT.getAssetConfig()));
				assetsPage.clickOnBackButton();
			}
			else if(DriverManager.getDriverName().equals("Web"))
			{
				Assert.assertTrue(assetsPage.isAssetCreated(Asset.ASSETCONFIG.ASSET_NAME_EDIT.getAssetConfig()));
				assetsPage.clickOnBackButton();
			}
		}
		catch(Throwable e)
		{
			assetsPage.clickOnBackButton();
			Assert.fail(e.toString());	
		}
	}

	@Test(alwaysRun=true,priority = 26305,groups = {Config.IOS_SMOKE_TESTS,Config.TEST_ASSET,"assets1",Config.IOS_ASSET_SMOKE_EXT_TESTS, Config.ANDROID_ASSET_SMOKE_EXT_TESTS,
			 Config.ANDROID_SMOKE_EXTENDED_TESTS ,Config.WEB_SMOKE_ASSET_EXTENDED,Config.ASSET_UAT_TEST,Config.ASSET_ANDROID_UAT})//, Config.TEST_ASSET

	public void verifyAddTestComponent() throws Exception
	{
		try
		{
			switcher.switchToAssetsPage();
			assetsPage.clickOnAssetGroupName(Asset.ASSETCONFIG.ASSET_GROUP_A.getAssetConfig());
			assetsPage.createTestComponent(Asset.ASSETCONFIG.ASSET_NAME_EDIT.getAssetConfig().toString(),Asset.ASSETCONFIG.TEST_POINT_A.getAssetConfig());
			CommonUtils.wait(1,1,4);
			Assert.assertTrue(assetsPage.isTestComponentCreated(Asset.ASSETCONFIG.TEST_POINT_A.getAssetConfig()));	
		}
		catch(Throwable e)
		{
			assetsPage.clickOnBackButton();
			assetsPage.clickOnBackButton();
			Assert.fail(e.toString());
		}
	}

	@Test(alwaysRun=true,priority = 26306,groups = {Config.IOS_SMOKE_TESTS,Config.TEST_ASSET,"assets1",Config.IOS_ASSET_SMOKE_EXT_TESTS, Config.ANDROID_ASSET_SMOKE_EXT_TESTS,
			Config.ANDROID_SMOKE_EXTENDED_TESTS,Config.WEB_SMOKE_ASSET_EXTENDED,Config.ASSET_UAT_TEST,Config.ASSET_ANDROID_UAT})//, Config.TEST_ASSET

	public void verifyEditTestComponent() throws Exception
	{
		try
		{
			assetsPage.editComponent(Asset.ASSETCONFIG.ASSET_NAME_EDIT.getAssetConfig().toString(),Asset.ASSETCONFIG.TEST_POINT_EDIT.getAssetConfig(),Asset.ASSETCONFIG.TEST_POINT_A.getAssetConfig());
			Assert.assertTrue(assetsPage.isTestComponentCreated(Asset.ASSETCONFIG.TEST_POINT_EDIT.getAssetConfig()));	
			
		}
		catch(Throwable e)
		{
			Assert.fail(e.toString());
		}
	}

	@Test(alwaysRun=true,priority = 26307,groups = {Config.IOS_SMOKE_TESTS,Config.TEST_ASSET,"assets1",Config.IOS_ASSET_SMOKE_EXT_TESTS,  Config.ANDROID_ASSET_SMOKE_EXT_TESTS,
			Config.ANDROID_SMOKE_EXTENDED_TESTS,Config.WEB_SMOKE_ASSET_EXTENDED,Config.ASSET_UAT_TEST,Config.ASSET_ANDROID_UAT})//, Config.TEST_ASSET

	public void verifydeleteTestComponent() throws Exception
	{
		try
		{
			assetsPage.deleteComponent(Asset.ASSETCONFIG.TEST_POINT_EDIT.getAssetConfig());
			CommonUtils.wait(1,1,4);
			Assert.assertTrue(assetsPage.isAssetOrAssetGroupDeleated(Asset.ASSETCONFIG.TEST_POINT_EDIT.getAssetConfig()));	
			assetsPage.clickOnBackButton();
			assetsPage.clickOnBackButton();
		}
		catch(Throwable e)
		{
			assetsPage.clickOnBackButton();
			assetsPage.clickOnBackButton();
			e.printStackTrace();
			Assert.fail(e.toString());
		}
	}

	@Test(alwaysRun = true, priority = 26308, groups = {Config.IOS_SMOKE_TESTS,Config.IOS_FULL_TESTS,"assets1",Config.IOS_ASSET_SMOKE_EXT_TESTS, Config.ANDROID_ASSET_SMOKE_EXT_TESTS,Config.ASSET_ANDROID_UAT
			, Config.ANDROID_SMOKE_EXTENDED_TESTS, Config.WEB_SMOKE_ASSET_EXTENDED,Config.ASSET_UAT_TEST,Config.ASSET_ANDROID_UAT})//, Config.TEST_ASSET
	public void VerifyDeleteAsset() throws Exception

	{
		try
		{
			assetsPage.clickOnAssetGroupName(Asset.ASSETCONFIG.ASSET_GROUP_A.getAssetConfig());			
			CommonUtils.wait(1,2,2);
			assetsPage.deleteAsset(Asset.ASSETCONFIG.ASSET_NAME_EDIT.getAssetConfig().toString());
			CommonUtils.wait(1,2,2);
			Assert.assertTrue(assetsPage.isAssetOrAssetGroupDeleated(Asset.ASSETCONFIG.ASSET_NAME_EDIT.getAssetConfig()));	
			assetsPage.clickOnBackButton();

		}
		catch(Throwable e)
		{
			assetsPage.clickOnBackButton();
			e.printStackTrace();
			Assert.fail(e.toString());
		}
	}


 @Test(alwaysRun = true, priority = 26309, groups = {Config.IOS_SMOKE_TESTS, Config.ANDROID_UAT_TESTS,Config.TEST_ASSET,"assets1",Config.IOS_ASSET_SMOKE_EXT_TESTS, Config.ANDROID_ASSET_SMOKE_EXT_TESTS,
		  Config.ANDROID_SMOKE_EXTENDED_TESTS,Config.WEB_SMOKE_ASSET_EXTENDED,Config.ASSET_UAT_TEST,Config.ASSET_ANDROID_UAT})//Config.TEST_ASSET	

	public void deletBasicAssetGroupTest() throws Exception
	{
		try
		{
			switcher.switchToAssetsPage();
			assetsPage.clickOnAssetGroupName(Asset.ASSETCONFIG.ASSET_GROUP_A.getAssetConfig());
			assetsPage.deleteAssetGroup(Asset.ASSETCONFIG.ASSET_GROUP_A.getAssetConfig());
			CommonUtils.wait(2,2,2);
			Assert.assertTrue(assetsPage.isAssetOrAssetGroupDeleated(Asset.ASSETCONFIG.ASSET_GROUP_A.getAssetConfig()));	
		}
		catch(Throwable e)
		{
			assetsPage.clickOnBackButton();
			Assert.fail(e.toString());
		}
	}	
	
	//smoke test ends
	

	//$$$$$$$$$$$$$$$$$$$$$$$$ Asset Group,Asset,TestPoint Creation, deletion  End Here///

	
	
	//!!!!!!!!!!!!!!!!!!!!!!!!!! Asset Status Test cases start Here///
	



@Test(alwaysRun = true, priority = 26310, groups = {Config.IOS_FULL_TESTS,Config.TEST_ASSET,Config.ASSET_UAT_TEST,Config.ASSET_ANDROID_UAT})//Config.TEST_ASSET , Config.ANDROID_ASSET_SMOKE_EXT_TESTS

	public void verifyAssetStatusAfterChanged() throws Exception 
	{	
		try
		{
			assetsPage.clickOnAssetGroupName(Asset.ASSETCONFIG.ASSET_GROUP_B.getAssetConfig());
			assetsPage.clickOnAssetName(Asset.ASSETCONFIG.ASSET_NAME_B.getAssetConfig());
			assetsPage.clickOnStatusTab();
			CommonUtils.wait(2,2,2);
			for(int statusCount=0;statusCount<asset.statusFilter().size();statusCount++)
			{
				CommonUtils.wait(2);
				assetsPage.clickOnSeverity();
				assetsPage.selectStatus(asset.statusFilter().get(statusCount),statusCount);
				assetsPage.clickOnSaveButton();
				CommonUtils.wait(1,2,5);
				Assert.assertTrue(asset.statusFilter().get(statusCount).equalsIgnoreCase(assetsPage.getStatusNameAfterChange()));	
			}
			assetsPage.clickOnBackButton();
			assetsPage.clickOnBackButton();
		}
		catch(Throwable e)
		{
			assetsPage.clickOnBackButton();
			assetsPage.clickOnBackButton();
			Assert.fail(e.toString());
		}
	}
	
/*	@Test(alwaysRun = true, priority = 26311, groups = {Config.IOS_FULL_TESTS})//Config.TEST_ASSET
	public void verifyAssetHistoryForExtreme()
	{
		try
		{
			assetsPage.clickOnFilter();
			assetsPage.selectStatus(asset.statusFilter().get(0));
			assetsPage.clickOnBackStatusButton();
			CommonUtils.wait(2);
			Assert.assertTrue(assetsPage.getStatusHistory(asset.assetSeverityFilter().get(0)));
			
			assetsPage.clickOnFilter();
			assetsPage.selectStatus(asset.statusFilter().get(0));
			assetsPage.clickOnBackStatusButton();
		}
		catch(Throwable e)
		{
			assetsPage.clickOnBackStatusButton();
			Assert.fail(e.toString());
		}
	}	
	
	@Test(alwaysRun = true, priority = 26312, groups = {Config.IOS_FULL_TESTS})//Config.TEST_ASSET
	public void verifyAssetHistoryForModerate()
	{
		try
		{
			assetsPage.clickOnFilter();
			assetsPage.selectStatus(asset.statusFilter().get(1));
			assetsPage.clickOnBackStatusButton();
			CommonUtils.wait(2);
			Assert.assertTrue(assetsPage.getStatusHistory("moderate_icon"));
			assetsPage.clickOnFilter();
			assetsPage.selectStatus(asset.statusFilter().get(1));
			assetsPage.clickOnBackStatusButton();
		}
		catch(Throwable e)
		{
			assetsPage.clickOnBackStatusButton();
			Assert.fail(e.toString());
		}
	}
		
	@Test(alwaysRun = true, priority = 26313, groups = {Config.IOS_FULL_TESTS})//Config.TEST_ASSET
	public void verifyAssetHistoryForNormal()
	{
		try
		{
			assetsPage.clickOnFilter();
			assetsPage.selectStatus(asset.statusFilter().get(2));
			assetsPage.clickOnBackStatusButton();
			CommonUtils.wait(2);
			Assert.assertTrue(assetsPage.getStatusHistory("normal_icon"));
			assetsPage.clickOnFilter();
			assetsPage.selectStatus(asset.statusFilter().get(2));
			assetsPage.clickOnBackStatusButton();
		}
		catch(Throwable e)
		{
			assetsPage.clickOnBackStatusButton();
			Assert.fail(e.toString());
		}
	}
	
	@Test(alwaysRun = true, priority = 26314, groups = {Config.IOS_FULL_TESTS,})//Config.TEST_ASSET
	public void verifyAssetHistoryForSerious()
	{
		try
		{
			assetsPage.clickOnFilter();
			assetsPage.selectStatus(asset.statusFilter().get(3));
			assetsPage.clickOnBackStatusButton();
			CommonUtils.wait(2);
			Assert.assertTrue(assetsPage.getStatusHistory("serious_icon"));
			assetsPage.clickOnFilter();
			assetsPage.selectStatus(asset.statusFilter().get(3));
			assetsPage.clickOnBackStatusButton();
		}
		catch(Throwable e)
		{
			assetsPage.clickOnBackStatusButton();
			Assert.fail(e.toString());
		}
	}
	
	@Test(alwaysRun = true, priority = 26315, groups = {Config.IOS_FULL_TESTS, })//Config.TEST_ASSET
	public void verifyAssetHistoryForUnassigned() throws Exception
	{
		try
		{
			assetsPage.clickOnFilter();
			assetsPage.selectStatus(asset.statusFilter().get(4));
			assetsPage.clickOnBackStatusButton();
			CommonUtils.wait(2);
			Assert.assertTrue(assetsPage.getStatusHistory("unassigned_icon"));
			assetsPage.clickOnFilter();		
			assetsPage.selectStatus(asset.statusFilter().get(4));
			assetsPage.clickOnBackStatusButton();
			assetsPage.clickOnBackButton();
			assetsPage.clickOnBackButton();
		}
		catch(Throwable e)
		{
			//assetsPage.clickOnBackStatusButton();
			assetsPage.clickOnBackButton();
			assetsPage.clickOnBackButton();
			Assert.fail(e.toString());
		}
	}*/
	
	//!!!!!!!!!!!!!!!!!!!!!!!!!! Asset Status Test cases start Here///
		
	//#$#$#$#$#$#$#$#$#$ SORT AND FILTER Test case Start Here #$#$#$#$##$##$$#$#$##$#$$#$
	


	@Test(alwaysRun = true, priority = 26316, groups = {Config.IOS_FULL_TESTS,Config.TEST_ASSET,Config.IOS_ASSET_SMOKE_EXT_TESTS})	//,Config.TEST_ASSET,Config.ANDROID_SMOKE_TESTS, Config.ANDROID_ASSET_SMOKE_EXT_TESTS,

	public void verfiyStatusFilter() throws Exception
	{
		try
		{
			assetsPage.clickOnAssetGroupName(Asset.ASSETCONFIG.ASSET_GROUP_SORT.getAssetConfig());			
	   		CommonUtils.wait(1,1,2);
			for(int statusCount=0;statusCount<asset.statusFilter().size();statusCount++)
			{
				assetsPage.selectStatusCheck(asset.statusFilter().get(statusCount),statusCount);
				for(int assetListCount=0;assetListCount<assetsPage.getAssetList();assetListCount++)
				{
					CommonUtils.wait(2,2,3); 
					if(DriverManager.getDriverName().equals("iOS"))
					{
						Assert.assertTrue(ElementUtils.getElement(assetsPage.getAssetCell().get(assetListCount+1), null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME,asset.assetSeverityFilter().get(statusCount), null, null).isDisplayed());	
					}
					else if(DriverManager.getDriverName().equals("Android"))
					{
						Assert.assertTrue(assetsPage.getAssetCell().get(assetListCount).isDisplayed());
					}
					else if(DriverManager.getDriverName().equals("Web"))
					{
						Assert.assertTrue(ElementUtils.isDisplayed(20, 2, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "[data-severity='"+asset.assetSeverityFilterWeb().get(statusCount)+"']"));   
					}
				}
				assetsPage.selectStatusCheck(asset.statusFilter().get(statusCount),statusCount);
			}	
			assetsPage.clickOnBackButton();	
		}
		
		catch(Throwable e)
		{
			try
			{
				assetsPage.clickOnBackStatusButton();
				assetsPage.clickOnSortFilterBackButton();
			}	
			catch(Throwable err)
			
			{
				assetsPage.clickOnBackButton();
				Assert.fail(err.toString());
			}
			Assert.fail(e.toString());
		}	
		
	}

	@Test(alwaysRun = true, priority = 26317, groups = {Config.IOS_FULL_TESTS,Config.IOS_ASSET_SMOKE_EXT_TESTS,Config.ASSET_UAT_TEST,Config.ASSET_ANDROID_UAT})	//Config.TEST_ASSET , Config.ANDROID_SMOKE_TESTS
	public void assetTypeFilter() throws Exception
	{
		try
		{
			switcher.switchToAssetsPage();
			assetsPage.clickOnAssetGroupName(Asset.ASSETCONFIG.ASSET_GROUP_SORT.getAssetConfig());	

		for(int typeCount=0;typeCount<asset.assetTypeFilter().size();typeCount++)
			{
				assetsPage.selectAssetTypeCheck(asset.assetTypeFilter().get(typeCount),typeCount);	
				for(int assetListCount=0;assetListCount<assetsPage.getAssetList();assetListCount++)
				{
				    if(DriverManager.getDriverName().equals("iOS"))
					{
						CommonUtils.wait(2);
				    	Assert.assertTrue(DriverManager.getDriver().findElement(MobileBy.iOSNsPredicateString("name == '"+asset.assetTypeFilter().get(typeCount)+"'")).isDisplayed());
					}
					else if(DriverManager.getDriverName().equals("Android")||DriverManager.getDriverName().equals("Web"))
					{	
						Assert.assertTrue(ElementUtils.isDisplayed(30,3,LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS,asset.assetTypeFilter().get(typeCount),null,null,LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".equipment-card-type-column [title='"+asset.assetTypeFilter().get(typeCount)+"']"));
					}
				}
				assetsPage.selectAssetTypeCheck(asset.assetTypeFilter().get(typeCount),typeCount);
			}
			assetsPage.clickOnBackButton();
		}
		
		catch(Throwable e)
		{
			try
			{
				assetsPage.clickOnBackStatusButton();
				assetsPage.clickOnSortFilterBackButton();
			}	
			catch(Throwable err)
			
			{
				assetsPage.clickOnBackButton();
				assetsPage.clickOnBackButton();
				Assert.fail(err.toString());
			}
			Assert.fail(e.toString());
			
		}	
		
	}
	
	@Test(alwaysRun = true, priority = 26318, groups = {Config.IOS_FULL_TESTS,Config.IOS_ASSET_SMOKE_EXT_TESTS,
			Config.TEST_ASSET,Config.ASSET_ANDROID_UAT,Config.ASSET_UAT_TEST,})	//Config.TEST_ASSET , Config.ANDROID_SMOKE_TESTS
	public void sortByAssetName() throws Exception
	{
		try
		{
			switcher.switchToAssetsPage();
			assetsPage.clickOnAssetGroupName(Asset.ASSETCONFIG.ASSET_GROUP_SORT.getAssetConfig());	
			assetsPage.clickOnAssetFilter();
		 	assetsPage.selectAssetNameFilter(); 
		    assetsPage.clickOnSortFilterBackButton();
			Assert.assertTrue(assetsPage.getAssetNameFromList());	   
	  		assetsPage.clickOnBackButton();
		}
		
		catch(Throwable e)
		{
			assetsPage.clickOnBackButton();
			Assert.fail(e.toString());
		}	
		
	}
	
	
	@Test(alwaysRun = true, priority = 26319, groups = {Config.IOS_FULL_TESTS,Config.ASSET_UAT_TEST,Config.TEST_ASSET,Config.ASSET_ANDROID_UAT})	 //,Config.ASSET_SMOKE_EXT_TESTS
	public void sortByLastUpdateDate() throws Exception
	{
		try
		{
			if(DriverManager.getDriverName().equals("Web"))
			{
				switcher.switchToAssetsPage();
				assetsPage.clickOnAssetGroupName(Asset.ASSETCONFIG.ASSET_GROUP_SORT.getAssetConfig());
				assetsPage.selectLastUpdateDate();
				assetsPage.clickOnSortFilterBackButton();
				for(int assetListCount=0;assetListCount<assetsPage.getAssetList()-1;assetListCount++)
				{
					Assert.assertTrue(DateAndTimeUtils.compareDateDscedningOrder(assetsPage.getLastModifiedDateOfAssets(assetListCount),assetsPage.getLastModifiedDateOfAssets(assetListCount+1),"MM/dd/yyyy hh:mm:ss"));
				}
			}	
		}
		
		catch(Throwable e)
		{
			assetsPage.clickOnBackStatusButton();
			assetsPage.clickOnSortFilterBackButton();
			Assert.fail(e.toString());
		}
		
	}
	
	@Test(alwaysRun = true, priority = 26320, groups = {Config.IOS_FULL_TESTS,Config.ASSET_UAT_TEST,Config.TEST_ASSET,Config.ASSET_ANDROID_UAT})	//Config.TEST_ASSET , Config.ANDROID_SMOKE_TESTS
	public void searchAsset() throws Exception
	{
		try
		{
			if(DriverManager.getDriverName().equals("iOS")||DriverManager.getDriverName().equals("Android"))
			{
				switcher.switchToAssetsPage() ;
				assetsPage.clickOnAssetGroupName(Asset.ASSETCONFIG.ASSET_GROUP_SORT.getAssetConfig());
				Assert.assertEquals(assetsPage.searchedAsset("OneApp",0), "OneApp");  
				assetsPage.clickOnCancelButton();
				assetsPage.clickOnBackButton();
			}
		}
		
		catch(Throwable e)
		{
			assetsPage.clickOnCancelButton();
			assetsPage.clickOnBackButton();
			Assert.fail(e.toString());
		}	
		
	}
}
	//#$#$#$#$#$#$#$#$#$ SORT AND FILTER Test case End Here #$#$#$#$##$##$$#$#$##$#$$#$

	
