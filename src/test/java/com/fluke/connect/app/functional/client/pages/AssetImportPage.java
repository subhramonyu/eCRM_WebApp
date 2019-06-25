package com.fluke.connect.app.functional.client.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.fluke.connect.app.testdata.Asset;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class AssetImportPage 
  {
	
	@FindBy(how=How.CSS,using="[data-event=\"click:import-assets\"]")
	private WebElement importAssetButton;
	
	@FindBy(how=How.CSS,using="[for=\"importAssetFile\"]")
	private WebElement uploadButton;
	
	@FindBy(how=How.CSS, using = "input[type='file']")
	private WebElement uploadfile;
	
	@FindBy(how=How.CSS,using="[data-event=\"click:close\"]")
	private WebElement closeButton;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/asset_name")
	@FindBy(how=How.CSS,using=".equipment-card-name-column .equipment-card-name")
	public  List<WebElement> assetName;
	
	
	private AssetsPage assetsPage;
	public AssetImportPage()
	{
		CommonUtils.initElements(this);	
		assetsPage = new AssetsPage();
	}
	
	public void importAsset()
	{
		importAssetButton.click();
		uploadfile.sendKeys("/Users/automationqa/sw-uaf-test-framework/app/FlukeConnectTests/files/FC_Asset_Import_Template.xlsx");
		closeButton.click();;
		CommonUtils.wait(15);
		importAssetButton.click();
		closeButton.click();
		CommonUtils.wait(3);
	}
	
	
	public void clickOnAssetgroup()
	{
		ElementUtils.safeClick(20,null,null,null,null,LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS,Asset.ASSETCONFIG.ASSET_GROUP_LEVE1.getAssetConfig());
	}
	
	
	public void addImportAssetgroup() throws Exception
	{
		if(DriverManager.getDriverName().equals("Web"))
		{
			assetsPage.addAssetGroup(Asset.ASSETCONFIG.ASSET_IMPORT_GROUP.getAssetConfig());
			CommonUtils.wait(4);
			importAsset();
			clickOnAssetgroup();
		}
		
	/*	else
		{
			assetsPage.clickOnAssetGroupName(Asset.ASSETCONFIG.ASSET_IMPORT_GROUP.getAssetConfig());
			assetsPage.clickOnAssetGroupName(Asset.ASSETCONFIG.ASSET_GROUP_LEVE1.getAssetConfig());
		}*/
	}
	
	
}