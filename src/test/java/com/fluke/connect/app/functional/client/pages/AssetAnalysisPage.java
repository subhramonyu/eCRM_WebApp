package com.fluke.connect.app.functional.client.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.fluke.connect.app.testdata.Asset;
import com.fluke.connect.app.testdata.Asset.ALARM_NAME;
import com.fluke.connect.app.testdata.Asset.ALARM_TYPE;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.ScrollDiection;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AssetAnalysisPage  {
	
	@FindBy(how=How.XPATH,using="//div/a[contains(text(),\"Analysis\")]")
	@AndroidFindBy(id="com.fluke.deviceApp:id/analysis_tab_text")
	@iOSFindBy(accessibility="Analysis")
	private WebElement analysisTab;
	
	@FindBy(how=How.CSS,using="[data-event=\"click:add-data\"]")
	@AndroidFindBy(id="com.fluke.deviceApp:id/add_data")
	@iOSFindBy(accessibility="addDataButton")
	private WebElement addDataButtonBottom;
	
	@iOSFindBy(accessibility="radioButtonCell")
	private WebElement radiButtonSection;
	
	@iOSFindBy(accessibility="thermalImageCell")
	private WebElement thermalImageSection;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),\"Info\")]")
	private WebElement webInfotab;
	
	@iOSFindBy(accessibility="thumbnailCell")
	private WebElement thumbnailImageSection;
	
	@FindBy(how=How.CSS,using=".product-thumbnail-carousel-image")
	@AndroidFindBy(id="com.fluke.deviceApp:id/ti_image_layout")
	private List<WebElement> getAndroidWebThumbnailImageCount;
	
	@iOSFindBy(accessibility="newMeasurementButton")
	private WebElement addExistingMeasurementButton;
	
	@iOSFindBy(accessibility="Add")
	private List<WebElement> addMeasurementButton;
	
	@FindBy(how=How.CSS,using="#ti-main-image")
	@AndroidFindBy(id="com.fluke.deviceApp:id/thumbnail_image")
	@iOSFindBy(accessibility="Thermal Images")
	private WebElement thermalImageCell;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/hig_chart")
	@FindBy(how=How.CSS,using=".highcharts-line-series")
	@iOSFindBy(accessibility="HIG Chart")
	private WebElement getGraphHighChart;
	
	
	@FindBy(how=How.CSS,using=".highcharts-line-series")
	@iOSFindBy(xpath="//XCUIElementTypeTable/XCUIElementTypeCell[2]")
	private WebElement graphImage;
	
	@FindBy(how=How.CSS,using=".highcharts-line-series")
	@AndroidFindBy(id="com.fluke.deviceApp:id/hig_chart")
	@iOSFindBy(accessibility="graphCell")
	private WebElement graphThermalImageCell;
	
	@iOSFindBy(accessibility="radio button off")
	private List<WebElement> radioButtonOfMinMax;
	
	@iOSFindBy(xpath="//XCUIElementTypeButton[@name='Add']/ancestor::XCUIElementTypeAlert[@name='Add Measurements']")
	private WebElement popupAddButton;
	
	@FindBy(how=How.CSS,using="[data-event='click:cancel']")
	@iOSFindBy(accessibility="Cancel")
	private WebElement cancelButtonOnMeasurementSelection;
	
	@iOSFindBy(accessibility="Filter")
	private List<WebElement> filterButton;
	
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/filter_by_thermal_images_only")
	@iOSFindBy(accessibility="Thermal Images Only")
	private WebElement thermalImageFilter;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/filter_by_measurements_only")
	@iOSFindBy(accessibility="Measurements Only")
	private WebElement measurementOnlyFilter;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/action_bar_item_left")
	@iOSFindBy(accessibility="backBarButton")
	private WebElement backButton;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),\"Saved data\")]")
	@AndroidFindBy(id="com.fluke.deviceApp:id/view_saved_data_layout")
	@iOSFindBy(accessibility="View Saved Data")
	private WebElement viewSavedDataButton;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/alarm_list_layout")
	@iOSFindBy(accessibility="InfoAlarms")
	private WebElement alarmSection;
	
	@FindBy(how=How.CSS,using="#btnAddAlarm")
	@AndroidFindBy(id="com.fluke.deviceApp:id/add_alarm")
	@iOSFindBy(accessibility="AddAlarm")
	private WebElement addAlarmButton;
	
	@FindBy(how=How.CSS,using="[placeholder=\"Lower range\"]")
	@AndroidFindBy(id="com.fluke.deviceApp:id/lower_limit_ed")
	@iOSFindBy(accessibility="thresholdvalue2")
	private WebElement lowerLimitText;
	
	
	@FindBy(how=How.CSS,using="[placeholder=\"Upper range\"]")
	@AndroidFindBy(id="com.fluke.deviceApp:id/upper_limit_ed")
	@iOSFindBy(accessibility="thresholdvalue3")
	private WebElement highLimitText;

	
	
	@iOSFindBy(accessibility="Done")
	private WebElement keyboardDoneButton;
	
	@FindBy(how=How.CSS,using="#alarmConfNext")
	@AndroidFindBy(id="com.fluke.deviceApp:id/action_bar_item_menu_text")
	@iOSFindBy(accessibility="Next")
	private WebElement nextButton;
	
	@FindBy(how=How.CSS,using="#alarmAssetHierarchy")
	private WebElement webNextButton;
	
	
	@FindBy(how=How.CSS,using="#btnSaveAlarm")
	@AndroidFindBy(id="com.fluke.deviceApp:id/action_bar_item_menu_text")
	@iOSFindBy(accessibility="Save")
	private WebElement saveButton;
	
	@iOSFindBy(xpath="//XCUIElementTypeTextField")
	private List<WebElement> alarmUnitDropDownButton;
	
	@iOSFindBy(accessibility="Search")
	private List<WebElement> search;
	
	@iOSFindBy(xpath="//XCUIElementTypeAlert[@name='Add Measurements']")
	private WebElement assetExistingAlert;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/measurement_device")
	private WebElement deviceNameOfAndorid;
		
	@AndroidFindBy (id="com.fluke.deviceApp:id/measurement_frame")
	private List<WebElement> measurementFrameInAndroid;
	
	@FindBy(how=How.CSS,using="[data-event=\"click:confirm-add-measurements\"]")
	@AndroidFindBy(id="com.fluke.deviceApp:id/action_bar_item_menu_text")
	private WebElement androidNextButton;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/sortB")
	private WebElement measurementFilter;
	
	@FindBy(how = How.CSS, using = "#measEquipmentDetail #locked-value")
	@AndroidFindBy(id="com.fluke.deviceApp:id/test_point")
	private List<WebElement> measurementAssets;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/equipment_name")
	private List<WebElement> vibrationAssetName;
	 
	@AndroidFindBy(id="com.fluke.deviceApp:id/fc805_graphview")
	private WebElement vibrationsGraph;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/graph_units")
	private WebElement getUnitOfTheGraphs;
	
	@FindBy(how=How.CSS,using=".measurementContent")
	private List<WebElement> measList;
	
	@FindBy(how=How.CSS,using=".measurement-selection-overlay ~ .measurementHeadersHead [data-is-thermal-image=\"true\"]")///.measurement-selection-overlay ~ .measurementHeadersHead
	public List<WebElement> thermalImageWebList;
	
	@FindBy(how=How.CSS,using=".measurement-selection-overlay ~ .measurementHeadersHead [data-detail-type=\"beaker\"]")
	private  List<WebElement> beakerList;
	
	@FindBy(how=How.CSS,using=".measurement-selection-overlay ~ .measurementHeadersHead [data-detail-type=\"scalar\"]")
	private List<WebElement> scalerMeasurment;
	
	@FindBy(how=How.CSS,using=".measurement-selection-overlay ~ .measurementHeadersHead .vibration-reading-container")
	private List<WebElement> vibrationMeasurement;
	
	@FindBy(how=How.CSS,using=".measurement-selection-overlay ~ .measurementHeadersHead #measDetailDataMuse")
	private List<WebElement> museMeasurement;
	
	@FindBy(how=How.CSS,using=".measurement-selection-overlay ~ .measurementHeadersHead [data-detail-type='eevee']")
	private List<WebElement>  eeveeMeasurement;
	
	@FindBy(how=How.CSS,using="[data-is-thermal-image='true']")
	public List<WebElement> thermalMeasurement;
	
	@FindBy(how=How.CSS,using="[data-detail-type='beaker']")
	public List<WebElement> beakerMeasurement;
	
	@FindBy(how=How.CSS,using="[data-detail-type='scalar']")
	public List<WebElement> scalerMeasurement;
	
	@FindBy(how=How.CSS,using=".vibration-reading-container")
	public List<WebElement> vibrationMeas;
	
	@FindBy(how=How.CSS,using="#measDetailDataMuse")
	public List<WebElement> museMeas;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/min_radio")
	@FindBy(how=How.CSS,using="#minTemperature")
	private WebElement selectMinTemp;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/center_pt_radio")
	@FindBy(how=How.CSS,using="#centerTemperature")
	private WebElement selectCenterPointTemp;
		
	@AndroidFindBy(id="com.fluke.deviceApp:id/max_radio")
	@FindBy(how=How.CSS,using="#maxTemperature")
	private WebElement selectMaxTemp;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/center_point_temp")
	@FindBy(how=How.CSS,using =".ti-tooltip >h3")
	private List<WebElement> getThumbnailValue;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/centerPointTemp")
	@FindBy(how=How.CSS,using=".nc-temp-reading")
	private WebElement enlrageImageReading;
	
	@FindBy(how=How.CSS,using=".measurement-selection-overlay")
	private WebElement measurementOverlay;
	
	@FindBy(how=How.CSS,using=".meas-attributes")
	public  List<WebElement> measurementPopup;
	
	@iOSFindBy(accessibility="next")
	@AndroidFindBy(id="com.fluke.deviceApp:id/close")
	private WebElement closePopup;
	
	@iOSXCUITFindBy(accessibility = "Back")
	@AndroidFindBy(id="com.fluke.deviceApp:id/back_button")
	public WebElement measurementBackButton;
	

	
	
	
	private GestureUtils gestureUtils;
	private Asset assets;
	private AssetsPage assetPage;
	
	public AssetAnalysisPage()
	{
		CommonUtils.initElements(this);	
		gestureUtils=new GestureUtils();
		assets=new Asset();
		assetPage=new AssetsPage();
	}
	
	public void clickOnAnalysisTab()
	{
		CommonUtils.wait(1,1,2);
		analysisTab.click();
		CommonUtils.wait(1,1,2);
	}
	
	public void clickOnAddData()
	{
		addDataButtonBottom.click();
	}
	
	public void clickOnExistingMeasurement()
	{
		addExistingMeasurementButton.click();
	}
	
	public void addDataOnAnalaysisPage()
	{
		clickOnAnalysisTab();
		addDataButtonBottom.click();
		if(DriverManager.getDriverName().equals("iOS"))
		{
			clickOnExistingMeasurement();
		}	
	}
	public void clickOnAssetInMobileForAssetAnalysis(String assetName) throws Exception

	{
		if(DriverManager.getDriverName().equals("iOS")||DriverManager.getDriverName().equals("Android"))
		{ 
			gestureUtils.scroll("name",assetName,null,assetName,-50,-50,null,null);	

			assetPage.clickOnAssetName(assetName);
		}
	}
	public String getAssetNameOnMeasurementPage(int measCount)
	{
		
		return measurementAssets.get(measCount).getText();
	}
	
	public  List<MobileElement> getMeasurementList(String measurementName)
	{
		return DriverManager.getDriver().findElements(By.xpath("//XCUIElementTypeCell[contains(@name,'"+measurementName+"')]"));
		//return DriverManager.getDriver().findElements(MobileBy.iOSNsPredicateString("value == "))
		 
	}
	
	public WebElement getAssetNameMeasurementPage(String assetName,String webAsset,int count,String measDate,List<WebElement> element)
	{
		if(DriverManager.getDriverName().equals("Android"))
		{
			

		 	gestureUtils.scroll(null,null,null,measDate,0,-400,null,null);
			ElementUtils.getElement(measDate, null, null).click();
			if(ElementUtils.isDisplayed(4,2,closePopup))
			{
				closePopup.click();
			}	  
			gestureUtils.scroll(null,null,null,assetName,0,-200,null,null);
			return DriverManager.getDriver().findElement(By.xpath("//android.widget.TextView[contains(@text,'"+assetName+"')]"));
		}
		else if(DriverManager.getDriverName().equals("Web"))
		{
			CommonUtils.wait(2);
			gestureUtils.webScroll(ScrollDiection.DOWN,3);
			return DriverManager.getDriver().findElements(By.xpath("//label[@id='locked-value' and text()='"+webAsset+"']")).get(count);
		}
		else if(DriverManager.getDriverName().equals("iOS"))
		{
			
			gestureUtils.mScroll(measDate,LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE,null,ScrollDiection.DOWN);	
			ElementUtils.getElement(measDate, null, null).click();
			gestureUtils.mScroll(assetName,LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,null,ScrollDiection.DOWN);
			if(ElementUtils.isDisplayed(4,2,closePopup))
			{ 
				closePopup.click();
			}  
			//return DriverManager.getDriver().findElements(MobileBy.iOSNsPredicateString("value == '+assetName+'"))
			
					return	DriverManager.getDriver().findElement(MobileBy.AccessibilityId(assetName));

					//return ElementUtils.getElement(null,null,LocatorStrategy.IOS_LOCATOR_STRATEGY_LABEL,assetName,null,null);	
		}	
		else
		{
			return null;
		}
	}
	
	public List<MobileElement> getAssignAssetList(String assetName)
	{
		return DriverManager.getDriver().findElements(MobileBy.AccessibilityId(assetName));	
	}
	
	public void measurementBackButton()
	{
		if(DriverManager.getDriverName().equals("Android")||DriverManager.getDriverName().equals("iOS"))
		{
			measurementBackButton.click();
		}
  	  	
	}
	
	
	public void refreshPage()
	{
		if(DriverManager.getDriverName().equals("Web"))
			DriverManager.getDriver().navigate().refresh();  
		CommonUtils.wait(3);
	}
	public String  getvibrationAssetOnMeasurement(int measCount)
	{
		return vibrationAssetName.get(measCount).getText();
	}
	
	public void clickOnMeasruement(String measurementName,int measurementSelection)
	{
		if(DriverManager.getDriverName().equals("iOS"))
		{
			for(int measCount=0;measCount<assets.getThermalImageiOSDate().size();measCount++)
			{
				/*while(gestureUtils.iOSScrollDown(getMeasurementList(measurementName).get(measCount)))
				{
					break;
				}*/
				System.out.println("0"+assets.getThermalImageiOSDate().get(measCount));
				gestureUtils.mScroll("0"+assets.getThermalImageDate().get(measCount),LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE,null,ScrollDiection.DOWN);	

				ElementUtils.getElement("0"+assets.getThermalImageDate().get(measCount), null, null).click();
				//getMeasurementList(measurementName).get(measCount).click();
			}
		}
		else if(DriverManager.getDriverName().equals("Android"))
		{
			for(int measCount=0;measCount<assets.getThermalImageDate().size();measCount++)
			{
				gestureUtils.scroll(null,null,null,assets.getThermalImageDate().get(measCount),0,-50,null,null);	
				DriverManager.getDriver().findElement(By.xpath("//android.widget.TextView[contains(@text, '"+assets.getThermalImageDate().get(measCount)+"')]/parent::android.widget.RelativeLayout/following-sibling::android.widget.RelativeLayout")).click();
			}
		}	
	}
	
	
	public void selectMeasurementInAndroidAndWeb(Asset.MEASUREMENT_NAME measName )
	{	switch(measName)
		{
		case THERMAL:
			goToAnElementInWeb(thermalImageWebList,measurementPopup,0);
			for(int measCount=0;measCount<assets.getThermalImageDate().size();measCount++)
			{
				CommonUtils.wait(1,1,2);
				gestureUtils.scroll(null,null,null,assets.getThermalImageDate().get(measCount),-100,-580,null,null);	
				if(DriverManager.getDriverName().equals("Android"))
				{
					ElementUtils.getElement(assets.getThermalImageDate().get(measCount), null, null).click();
					//DriverManager.getDriver().findElement(By.xpath("//android.widget.TextView[contains(@text,'"+assets.getThermalImageDate().get(measCount)+"')]/parent::android.widget.LinearLayout/following-sibling::android.widget.RelativeLayout")).click();
				}
				else if(DriverManager.getDriverName().equals("Web"))
				{			
					CommonUtils.wait(3);
					GestureUtils.moveAndClickElement(thermalImageWebList.get(measCount));	
				}
				else if(DriverManager.getDriverName().equals("iOS"))
				{
					gestureUtils.mScroll(assets.getThermalImageDate().get(measCount),LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE,null,ScrollDiection.DOWN);	
					ElementUtils.getElement(assets.getThermalImageDate().get(measCount), null, null).click();
				}
			}
			break;
		case BEAKER:
			goToAnElementInWeb(beakerList,measurementPopup,0);
			for(int measCount=0;measCount<assets.getBeakerDate().size();measCount++)
			{
				if(DriverManager.getDriverName().equals("Android"))
				{
					CommonUtils.wait(2);
					gestureUtils.scroll(null,null,null,assets.getBeakerDate().get(measCount),0,-510,null,null);	
					//DriverManager.getDriver().findElement(By.xpath("//android.widget.TextView[contains(@text, '"+assets.getBeakerDate().get(measCount)+"')]/parent::android.widget.LinearLayout/following-sibling::android.widget.RelativeLayout")).click();
					ElementUtils.getElement(assets.getBeakerDate().get(measCount), null, null).click();

				}
				else if(DriverManager.getDriverName().equals("Web"))
				{
	            	CommonUtils.wait(2);
	            	GestureUtils.moveAndClickElement(beakerList.get(measCount));
				}
				else if(DriverManager.getDriverName().equals("iOS"))
				{
					gestureUtils.mScroll(assets.getBeakerDate().get(measCount),LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE,null,ScrollDiection.DOWN);	
					ElementUtils.getElement(assets.getBeakerDate().get(measCount), null, null).click();				}	
			}
			break;
		case CNX:
			goToAnElementInWeb(scalerMeasurment,measurementPopup,0);
			for(int measCount=0;measCount<assets.getCNXDate().size();measCount++)
			{
				
				if(DriverManager.getDriverName().equals("Android"))
				{
					CommonUtils.wait(2);
					gestureUtils.scroll(null,null,null,assets.getCNXDate().get(measCount),0,-820,null,null);	
				//	DriverManager.getDriver().findElement(By.xpath("//android.widget.TextView[contains(@text, '"+assets.getCNXDate().get(measCount)+"')]/parent::android.widget.LinearLayout/following-sibling::android.widget.RelativeLayout")).click();
					ElementUtils.getElement(assets.getCNXDate().get(measCount), null, null).click();

				}
				else if(DriverManager.getDriverName().equals("Web"))
				{
	            	
	            	CommonUtils.wait(2);
	            	GestureUtils.moveAndClickElement(scalerMeasurment.get(measCount));
				}
				else if(DriverManager.getDriverName().equals("iOS"))
				{
					gestureUtils.mScroll(assets.getCNXDate().get(measCount),LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE,null,ScrollDiection.DOWN);	
					ElementUtils.getElement(assets.getCNXDate().get(measCount), null, null).click();					
				}	
			}
			break;
			
		case MUSE:
			//goToAnElementInWeb(scalerMeasurment,measurementPopup,0);
			for(int measCount=0;measCount<assets.getMuseDate().size();measCount++)
			{
				if(DriverManager.getDriverName().equals("Android"))
				{
					CommonUtils.wait(2);
					gestureUtils.scroll(null,null,null,assets.getMuseDate().get(measCount),0,-400,null,null);	
					//DriverManager.getDriver().findElement(By.xpath("//android.widget.TextView[contains(@text, '"+assets.getMuseDate().get(measCount)+"')]/parent::android.widget.LinearLayout/following-sibling::android.widget.RelativeLayout")).click();
					ElementUtils.getElement(assets.getCNXDate().get(measCount), null, null).click();

				}
				else if(DriverManager.getDriverName().equals("Web"))
				{
	            	CommonUtils.wait(2);
	            	GestureUtils.moveAndClickElement(museMeasurement.get(measCount));
				}
			}
			break;
			
		case VIBRATION:
			goToAnElementInWeb(scalerMeasurment,measurementPopup,0);
			for(int measCount=0;measCount<assets.getVibrationDate().size();measCount++)
			{
				if(DriverManager.getDriverName().equals("Android"))
				{
					CommonUtils.wait(2);
					gestureUtils.scroll(null,null,null,assets.getVibrationDate().get(measCount),0,-500	,null,null);	
					//DriverManager.getDriver().findElement(By.xpath("//android.widget.TextView[contains(@text, '"+assets.getVibrationDate().get(measCount)+"')]/parent::android.widget.LinearLayout/following-sibling::android.widget.RelativeLayout")).click();
					ElementUtils.getElement(assets.getVibrationDate().get(measCount), null, null).click();
				}
				else if(DriverManager.getDriverName().equals("Web"))
				{
	            	CommonUtils.wait(2);
	            	GestureUtils.moveAndClickElement(vibrationMeasurement.get(measCount));
				}
				else if(DriverManager.getDriverName().equals("iOS"))
				{
					//ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, assets.getVibrationDate().get(measCount), null,null).click();
					gestureUtils.mScroll(assets.getVibrationDate().get(measCount),LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE,null,ScrollDiection.DOWN);	
					ElementUtils.getElement(assets.getVibrationDate().get(measCount), null, null).click();						
				}	
			}
			break;
		case EVEE:
			goToAnElementInWeb(eeveeMeasurement,measurementPopup,0);
			for(int measCount=0;measCount<assets.getEveeDate().size();measCount++)
			{
				if(DriverManager.getDriverName().equals("Web"))
				{
					CommonUtils.wait(2);
					eeveeMeasurement.get(measCount).click();
				}
			}
			break;
		default:		
		}
	}
	
	
	public void goToAnElementInWeb(List<WebElement> element,List<WebElement> element1,int count)
	{
		if(DriverManager.getDriverName().equals("Web"))
			for(int countCheck=0;countCheck<8;countCheck++)
			{
				CommonUtils.wait(2);
				GestureUtils.moveToElement(element1.get(countCheck));
				CommonUtils.wait(3);
			}
	}
	
	public void scrollToHideHElement(List<WebElement> element,int count)
	{
		if(DriverManager.getDriverName().equals("Web"))
		{
			/*while(element.isEmpty())
			{
				try
				{
					if(element.get(count).isDisplayed())
					{
						break;
					}
				}
				catch(Exception e)
				{
					gestureUtils.scroll(1000, 1);
				}
			}*/
			gestureUtils.webScroll(element.get(count));
		}
		
		
		
	}
	
	public void clickOnAddMeasurementButton()
	{
		if(DriverManager.getDriverName().equals("iOS"))
		{
			addMeasurementButton.get(0).click();
			try
			{
				if(assetExistingAlert.isDisplayed())
				{
					addMeasurementButton.get(0).click();
					addMeasurementButton.get(1).click();
				}
			}
			catch(Exception e)
			{
				
			}
		}
		else if(DriverManager.getDriverName().equals("Android")||DriverManager.getDriverName().equals("Web"))
		{
			CommonUtils.wait(3,2,5);
			androidNextButton.click();
			CommonUtils.wait(1,2,20);
		}			
		
	}
	
	public void clickOnThermalImageSection()
	{
		if(DriverManager.getDriverName().equals("iOS")||DriverManager.getDriverName().equals("Android"))
		{
			CommonUtils.wait(2);
			thermalImageCell.click();
		}	
	}
	
	public void clickOnCancelButton()
	{
		if(DriverManager.getDriverName().equals("iOS")||DriverManager.getDriverName().equals("Web"))
		{
			cancelButtonOnMeasurementSelection.click();
		}
		
	}
	
	public int getThumbnailSize()
	{
		CommonUtils.wait(10);
		if(DriverManager.getDriverName().equals("iOS"))
		{		return thumbnailImageSection.findElements(By.xpath("XCUIElementTypeTextField")).size();
		}
		else if(DriverManager.getDriverName().equals("Android")||DriverManager.getDriverName().equals("Web"))
		{
			return getAndroidWebThumbnailImageCount.size();
		}
		return 0;
	}
	
	public String getThumbnailImageValue(int thumbnailCount)
	{
		CommonUtils.wait(10,5,2);
		
		if(DriverManager.getDriverName().equals("iOS"))
		{
			thumbnailImageSection.findElements(By.xpath("XCUIElementTypeTextField")).get(thumbnailCount).click();
			return thumbnailImageSection.findElements(By.xpath("XCUIElementTypeTextField")).get(thumbnailCount).getText();
		}
		else if(DriverManager.getDriverName().equals("Web")||DriverManager.getDriverName().equals("Android"))
		{
			getAndroidWebThumbnailImageCount.get(thumbnailCount).click();
			CommonUtils.wait(0,5,5);
			return getThumbnailValue.get(thumbnailCount).getText();
		}
		else
		{
			return null;
		}
		
	}
	
	public String getEnlargeThermalImageValue()
	{
		CommonUtils.wait(10,10,10);
		if(DriverManager.getDriverName().equals("iOS"))
		{
			ElementUtils.isDisplayed(30,2,thermalImageCell.findElements(By.xpath("XCUIElementTypeTextField")).get(1));
			return thermalImageCell.findElements(By.xpath("XCUIElementTypeTextField")).get(1).getText();
			
		}
		else if(DriverManager.getDriverName().equals("Web")||DriverManager.getDriverName().equals("Android"))
		{
			return enlrageImageReading.getText();
		}
		else
		{
			return null;
		}	
	}
	
	public float convertTempValueInInteger(String mainTempratureValue,String tempratureUnit)
	{
		String[] getTempratureValue=mainTempratureValue.split(tempratureUnit);
		CommonUtils.wait(3,4,4);
		return Float.parseFloat(getTempratureValue[0]);
	}
	
	public boolean isGrpahDispalyed()
	{
		return getGraphHighChart.isDisplayed();
	}

	public String getUnitValueOnGraph()
	{
		return thermalImageSection.findElements(By.xpath("XCUIElementTypeStaticText")).get(1).getText();
	}
	
	public void clickOnMinMaxRadioButton(String minMax)
	{
		CommonUtils.wait(2,4,5);
		switch(minMax)
		{
		case "Min":		
			if(DriverManager.getDriverName().equals("Web"))
			{
			   ElementUtils.clickObject(selectMinTemp);
			}
			else if(DriverManager.getDriverName().equals("iOS"))
			{
				radioButtonOfMinMax.get(0).click();
			}
			else if(DriverManager.getDriverName().equals("Android"))
			{
				selectMinTemp.click();
			}
			break;
		case "Max":
			if(DriverManager.getDriverName().equals("Web"))
			{
				ElementUtils.clickObject(selectMaxTemp);
			}
			else if(DriverManager.getDriverName().equals("iOS"))
			{
				radioButtonOfMinMax.get(1).click();
			}
			else if(DriverManager.getDriverName().equals("Android"))
			{
				selectMaxTemp.click();
			}
			break;
		case "Center Point":
			if(DriverManager.getDriverName().equals("Web"))
			{
				ElementUtils.clickObject(selectCenterPointTemp);
			}
			else if(DriverManager.getDriverName().equals("iOS"))
			{
				radioButtonOfMinMax.get(2).click();
			}
			else if(DriverManager.getDriverName().equals("Android"))
			{
				selectCenterPointTemp.click();
			}
			break;
		default:	
		
		}
	}
	
	public void clickOnFilterButton()
	{
		if(DriverManager.getDriverName().equals("iOS"))
		{
			filterButton.get(1).click();
		}
		else if(DriverManager.getDriverName().equals("Android"))
		{
			measurementFilter.click();   
		}
		
		
	}
	
	public void selectFilter(String filterName)
	{
		if(DriverManager.getDriverName().equals("iOS")||DriverManager.getDriverName().equals("Android"))
		{
		clickOnFilterButton();
		switch(filterName)
		{
		case "ThermalImage":
			thermalImageFilter.click();
			break;
		case "Measurements":
			measurementOnlyFilter.click();
			break;
		default:		
		}
			backButton.click();	
		}
	}
	
	
	public String getGraphUnit()
	{
		return getUnitOfTheGraphs.getText();
	}
	
	public void enterTheMeasurementName(String measurementName)
	{
		search.get(0).sendKeys(measurementName);
		
		search.get(0).click();
	}
	public void clickOnViewSavedData()
	{
		CommonUtils.wait(2);
		viewSavedDataButton.click();
	}
	
	/********** Commneted Visual Comprasion *********///
	/*public void takeactualAnalysisGraph(String measurementName)
	{
		if(measurementName.equals("Thermal Image"))
		{
			if(DriverManager.getDriverName().equals("iOS"))
			{
				gestureUtils.iOSScrollDown();
				CommonUtils.wait(3);
			}
			else if(DriverManager.getDriverName().equals("Android"))
			{
				gestureUtils.mobileScroll(-100,2);
			}
			else if(DriverManager.getDriverName().equals("Web"))
			{
				GestureUtils.moveToElement(graphImage);
			}
			VisualUtils.saveElementScreenshot(graphThermalImageCell,"./FlukeConnect/VisualTests/Actual");
		}
		else if(measurementName.equals("805 Measurement"))
		{
			if(DriverManager.getDriverName().equals("iOS"))
			{
				gestureUtils.iOSScrollDown();
				CommonUtils.wait(3);
				VisualUtils.saveElementScreenshot(graphImage,"./FlukeConnect/VisualTests/Actual");
			}
			else if(DriverManager.getDriverName().equals("Android"))
			{
				gestureUtils.mobileScroll(-100,2);
				VisualUtils.saveElementScreenshot(vibrationsGraph,"./FlukeConnect/VisualTests/Actual");
			}		
			
		}
		else 
		{
			if(DriverManager.getDriverName().equals("iOS"))
			{
				CommonUtils.wait(3);
				VisualUtils.saveElementScreenshot(graphImage,"./FlukeConnect/VisualTests/Actual");	
			}
			else if(DriverManager.getDriverName().equals("Android"))
			{
				CommonUtils.wait(3);
				WebElement ele=DriverManager.getDriver().findElement(By.xpath("//android.widget.TextView[contains(@text,"+getGraphUnit()+")]/parent::android.widget.LinearLayout"));
				VisualUtils.saveElementScreenshot(ele,"./FlukeConnect/VisualTests/Actual");

			}
		}
		
	}*/
	
	public boolean verifyGraph(String measurementName)
	{
		if(measurementName.equals("Thermal Image"))
		{
			if(DriverManager.getDriverName().equals("iOS"))
			{
				gestureUtils.iOSScrollDown();
				CommonUtils.wait(3);
			}
			else if(DriverManager.getDriverName().equals("Android"))
			{
				gestureUtils.mobileScroll(-100,2);
				CommonUtils.wait(3);
			}	
			else if(DriverManager.getDriverName().equals("Web"))
			{
				GestureUtils.moveToElement(graphImage);
			}
			return graphThermalImageCell.isDisplayed();
				
		}
		else if(measurementName.equals("805 Measurement"))
		{
			if(DriverManager.getDriverName().equals("iOS"))
			{
				gestureUtils.iOSScrollDown();
				CommonUtils.wait(3);
				return graphImage.isDisplayed();
			}
			else if(DriverManager.getDriverName().equals("Android"))
			{
				gestureUtils.mobileScroll(-100,2);
				CommonUtils.wait(3);
				return vibrationsGraph.isDisplayed();
			}
			else if(DriverManager.getDriverName().equals("Web"))
			{
				return graphImage.isDisplayed();
			}
		}
		else 
		{
			if(DriverManager.getDriverName().equals("iOS")||DriverManager.getDriverName().equals("Web"))
			{
				CommonUtils.wait(3);
				return graphImage.isDisplayed();
			}
			else if(DriverManager.getDriverName().equals("Android"))
			{
				gestureUtils.mobileScroll(-100,2);
				CommonUtils.wait(3);
				WebElement graphImage=DriverManager.getDriver().findElement(By.xpath("//android.widget.TextView[contains(@text,'"+getGraphUnit()+"')]/parent::android.widget.LinearLayout"));
				return graphImage.isDisplayed();
			}
		}
		return false;
	}

	/*public boolean compareGraph(String measurementname)
	{
		expectedGraph(measurementname);
		takeactualAnalysisGraph(measurementname);
		return VisualUtils.compareVisuals("./FlukeConnect/VisualTests/Expected","./FlukeConnect/VisualTests/Actual","./FlukeConnect/VisualTests/Deviation");
	}*/
	
	public void clickOnCreationAlarmButton()
	{
		addAlarmButton.click();
	}
	
	public String clickOnSelectedAlarm(String alarmElementName)
	{	
		String  getAlarmType=ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, alarmElementName, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, alarmElementName, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, "//span[@class='alarm_type_title']/h4[text()='"+alarmElementName+"']").getText();
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, alarmElementName, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, alarmElementName, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, "//span[@class='alarm_type_title']/h4[text()='"+alarmElementName+"']").click();
		CommonUtils.wait(3,3,1);
		if(ALARM_NAME.TEMPERATURE.getAlarmName().equals(alarmElementName))
		{
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,"Temperature Alarm",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Temperature Alarm", LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, "//span[@class='alarm_type_title']/h4[text()='"+alarmElementName+"']").click();
		}
		return 	getAlarmType;
	}
	
	public void clickOnNextButton()
	{
		nextButton.click();
	}
	
	public void selectAsset(String assetName)
	{
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/check_box", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, assetName, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH, "//div[@id='alarm_asset_hierarchy']/div/div/ul/li/h3/span[contains(text(),'"+assetName+"')]").click();
	}
	
	public String  createAlarm(ALARM_TYPE alarmType, String alramElementName,String lowerValue,String upperValue)
	{	
		clickOnCreationAlarmButton();
		String alarmName=clickOnSelectedAlarm(alramElementName);
		if(DriverManager.getDriverName().equals("Android")) 
		{
			if(alarmName.equals(Asset.ALARM_NAME.THD_A.getAlarmName()))
			{
				alarmName="THD-A";
			}
			else if(alarmName.equals(Asset.ALARM_NAME.THD_V.getAlarmName()))
			{
				alarmName="THD-V";
			}
		}		
		switch(alarmType)
		{
			case ABOVE:
				ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, "Above "+alarmName+" Alarm", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Above "+alarmName+" Alarm", LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS, "Above "+alarmName+" Alarm").click();
				enterValueOfAlarm("Above",lowerValue,upperValue);
				return "Above "+alarmName+" Alarm";
				
			case BELOW:
				ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, "Below "+alarmName+" Alarm", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Below "+alarmName+" Alarm", LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS, "Below "+alarmName+" Alarm").click();
				enterValueOfAlarm("Below",lowerValue,upperValue);
				return "Below "+alarmName+" Alarm";
				
			case WITH_IN_A_RANGE:
				ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, "Within-Range "+alarmName+" Alarm", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Within-Range "+alarmName+" Alarm", LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS, "Within Range "+alarmName+" Alarm").click();
				enterValueOfAlarm("WithInrange",lowerValue,upperValue);
				if(DriverManager.getDriverName().equals("iOS")||DriverManager.getDriverName().equals("Android"))
				{
				  return "Within-Range "+alarmName+" Alarm";
				}
				else
				{
					return "Within Range "+alarmName+" Alarm";
				}
				
			case OUT_OF_RANGE:
				ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, "Out-of-Range "+alarmName+" Alarm", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Out-of-Range "+alarmName+" Alarm", LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS, "Out of Range "+alarmName+" Alarm").click();
				enterValueOfAlarm("OutOfRange",lowerValue,upperValue);
				if(DriverManager.getDriverName().equals("iOS")||DriverManager.getDriverName().equals("Android"))
				{
					return "Out-of-Range "+alarmName+" Alarm";
				}
				else
				{
					return "Out of Range "+alarmName+" Alarm";
				}				
		}
		return null;
	}
	
	
	public void enterValueOfAlarm(String alarmRange,String lowerValue,String upperValue)
	{
		CommonUtils.wait(2,2,1);
		if(DriverManager.getDriverName().equals("iOS"))
		{
			if(alarmRange.equals("Above")||alarmRange.equals("Below"))
			{
				lowerLimitText.sendKeys(lowerValue);
				keyboardDoneButton.click();
				alarmUnitDropDownButton.get(1).click();
				keyboardDoneButton.click();
			}
			else
			{
				lowerLimitText.sendKeys(lowerValue);
				keyboardDoneButton.click();
				highLimitText.sendKeys(upperValue);
				keyboardDoneButton.click();
				alarmUnitDropDownButton.get(2).click();
				keyboardDoneButton.click();
			}
		}
		else if(DriverManager.getDriverName().equals("Android")||DriverManager.getDriverName().equals("Web"))
		{
			if(alarmRange.equals("Above"))
			{
				highLimitText.sendKeys(upperValue);
			}
			else if(alarmRange.equals("Below"))
			{
				lowerLimitText.sendKeys(lowerValue);
			}
			else
			{
				highLimitText.sendKeys(upperValue);
				lowerLimitText.sendKeys(lowerValue);	
			}
		}
	}
	
	public void selectTeamMember(String teamMembers)
	{
		ElementUtils.getElement(null,null,LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, teamMembers, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "[name=\"notify_self_toggle\"]").click();
	}
	
	public void clickOnSavebutton()
	{
		saveButton.click();
	}
	
	public void enterOtherAttributeOfAlarms(String assetName,String teamMember)
	{
		clickOnNextButton();
		CommonUtils.wait(2,2,1);
		selectAsset(assetName);
		if(DriverManager.getDriverName().equals("Web"))
		{
			webNextButton.click();
		}
		else
		{
			clickOnNextButton();
		}
		
		if(DriverManager.getDriverName().equals("iOS")||DriverManager.getDriverName().equals("Web"))
		{
			selectTeamMember(teamMember);
		}
		clickOnSavebutton();
		CommonUtils.wait(1,1,3);
	}
	
	
	public void clickOnAlarmSection()
	{
		if(DriverManager.getDriverName().equals("Android")||DriverManager.getDriverName().equals("iOS"))
		{
			alarmSection.click();
		}
		
	}
	
	
/*	public boolean createAlarm(String alramElementName, String assetName,String teamMember,String lowerValue,String upperValue)
	{
		int counterUpdate=0;
		alarmSection.click();
		for(int alarmCount=0;alarmCount<ALARM_TYPE.values().length;alarmCount++)
		{
			String alarmTypeCreated= clickOnAlarmRange(ALARM_TYPE.values()[alarmCount], alramElementName,lowerValue,upperValue);
			clickOnNextButton();
			selectAsset(assetName);
			clickOnNextButton();
			selectTeamMember(teamMember);
			clickOnSavebutton();
			if(ElementUtils.isDisplayed(20,3,null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, alarmTypeCreated, null, null))	 
				{counterUpdate=0;}
			if(counterUpdate==0)
			{
				return true;
			}
			else
			{
				break;
			}
		}
		return false;
		
	}*/
	
	public List<WebElement>  getAssetCountNameOnAlarm(String assetName)
	{
		return DriverManager.getDriver().findElements(MobileBy.AccessibilityId(assetName));
	}


	
	
	
}
