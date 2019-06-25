package com.fluke.connect.app.functional.client.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fluke.connect.app.functional.client.pages.AssetImportPage;
import com.fluke.connect.app.functional.client.pages.AssetsPage;
import com.fluke.connect.app.functional.client.pages.Switcher;
import com.fluke.connect.app.testdata.Asset;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.GestureUtils;

 public class AssetImportTest 
 {
	
	private Asset assets;
	private Switcher switcher;
	private AssetsPage assetPage;
	private AssetImportPage  assetImport;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFRow Row;
	private static XSSFSheet ExcelWSheet;
	private GestureUtils gestureUtils;
	
	@BeforeClass(alwaysRun = true, groups = {})
	public void initClass() throws Exception
	{
		assets = new Asset();
		switcher = new Switcher();
		switcher.switchToAssetsPage();
		assetImport=new AssetImportPage();
		gestureUtils=new GestureUtils();
		assetPage=new AssetsPage();
	}
	
	@Test(alwaysRun = true, priority = 28001, groups = {})//Config.TEST_ASSET,
	public void importAsset()
	{
		try
		{
			assetImport.addImportAssetgroup();
			CommonUtils.wait(4);
			try
			{
				if(DriverManager.getDriverName().equals("Web"))
				{
					InputStream fileToRead= new FileInputStream(assets.importFilePath);
					ExcelWBook=new XSSFWorkbook(fileToRead);
					ExcelWSheet=ExcelWBook.getSheetAt(1);
					int rowCount=ExcelWSheet.getLastRowNum() - ExcelWSheet.getFirstRowNum();
					
					for(int row=0;row<rowCount-1;row++)
					{
						Row=ExcelWSheet.getRow(row+1);
						CommonUtils.wait(2);
						gestureUtils.webScroll(assetImport.assetName.get(row));
						Assert.assertTrue(ElementUtils.isDisplayed(assetImport.assetName.get(row)));			
						if(Row.getCell(7).getStringCellValue().equals(""))
						{
							break;
						}	
					 }
					assetPage.deleteAssetGroup(Asset.ASSETCONFIG.ASSET_IMPORT_GROUP.getAssetConfig());
				}
			}
			catch (FileNotFoundException  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
			}
			 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
			} 
		}
		catch(Throwable e)
		{
			Assert.fail(e.toString());
		}
	}
	
	/*else if(DriverManager.getDriverName().equals("Android"))
	{
		//gestureUtils.scroll("name",assetName,null,assetName,-50,-50,LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,".equipment-card-name-column .equipment-card-name");	
 	}*/
	
	
	/*** This require more then one cell to read  and has to take Two dimension array ***/
	/*for(int cell=0;cell<Row.getLastCellNum();cell++)
	{
		System.out.println(Row.getCell(cell).getStringCellValue());
	}*/
}