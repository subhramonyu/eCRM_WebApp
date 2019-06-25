package com.fluke.connect.app.functional.client.pages;


import java.util.ArrayList;
import java.util.Collections;
import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.fluke.connect.app.testdata.Asset;
import com.fluke.connect.app.utils.AndroidUtils;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.Gestures;
import com.fluke.connect.app.utils.IOSUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.ScrollDiection;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AssetsPage 
{
	//asset group page --> ellipsis button
	//@AndroidFindBy(id="com.fluke.deviceApp:id/asset_group_options")
	//forWeb three dot
	@FindBy(how=How.CSS,using="#dots-class")
	@AndroidFindBy(id="com.fluke.deviceApp:id/action_bar_item_menu_icon")
	@iOSFindBy(accessibility = "AssetGroups Option Button")
	private WebElement assetGroupsPageOptionButton;
	
	@iOSFindBy(accessibility = "AssetGroups Option Button")
	private List<WebElement> assetListGroupsPageOptionButton;
	
	//asset list page --> three dot button
	@iOSXCUITFindBy(accessibility="options white")
	private WebElement assetListPageOptionsButton;
	
	//asset details page --> three dot button
	//infoPage --> For Web
	@HowToUseLocators(iOSXCUITAutomation = ALL_POSSIBLE)
	@FindBy(how=How.XPATH,using="//a[contains(text(),\"Info\")]")
	@AndroidFindBy(id="com.fluke.deviceApp:id/action_bar_item_menu_icon")
	//@AndroidFindBy(id="com.fluke.deviceApp:id/action_bar_right_menu_layout")
	@iOSFindBy(accessibility="menuOption")
	private WebElement assetDetailsPageOptionsButton;
	
	//asset group page --> ellipsis button --> add asset button
	@iOSFindBy(accessibility = "Add Asset")
	private WebElement addAssetButton;
	
	//asset group page --> ellipsis button --> add asset group button
	@FindBy(how=How.CSS,using=".add-container-group-plus")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Add Asset Group']")
	@iOSFindBy(accessibility = "Add Asset Group")
	private WebElement addAssetGroupButton;
	
	//asset group page --> ellipsis button --> cancel button
	@AndroidFindBy(id="com.fluke.deviceApp:id/clear")
	@iOSFindBy(accessibility = "Cancel")
	private WebElement cancelButton;
	
	@FindBy(how=How.CSS,using="[data-action=\"save\"]")
	@AndroidFindBy(id="com.fluke.deviceApp:id/dialog_ok")
	@iOSFindBy(accessibility = "Save")
	private WebElement saveButton;
	
	@iOSFindBy(accessibility = "SAVE")
	private WebElement secondSaveButton;

	@WithTimeout(time = 20, chronoUnit = ChronoUnit.SECONDS)
	@iOSFindBy(accessibility="backBarButton")
	@AndroidFindBy(id="com.fluke.deviceApp:id/action_bar_item_left")
	@FindBy(how=How.CSS,using="[data-page=\"equipment\"]")
	private WebElement backButton;
	
	@FindBy(how=How.CSS,using="[data-attr=\"delete-group\"]")
	@iOSFindBy(accessibility="Delete Group")
	private WebElement deleteAssetGroupButton;
	
	@AndroidFindBy(uiAutomator="Delete Asset")
	@iOSFindBy(accessibility="Delete Asset")
	private WebElement deleteAssetButton;
	
	@FindBy(how=How.CSS,using="[data-event=\"click:confirm-delete-component-asset\"]")
	@iOSFindBy(accessibility="Delete")
	@AndroidFindBy(id="com.fluke.deviceApp:id/dialog_ok")
	private WebElement confirmationAlertDeleteButton;
	
	@iOSFindBy(accessibility="Edit Info")
	private WebElement editAssetInfoButton;
	
	//Status tab in edit asset page
	@iOSFindBy(accessibility="STATUS")
	private WebElement editAssetStatusButton;
	
	//Asset status field --
	@iOSFindBy(accessibility="Severity")
	private WebElement editAssetStatusTypeButton;
	
	//Asset group -- asset -- analysis tab
	@iOSFindBy(accessibility="Analysis")
	private WebElement analysisButton;
	
	//Asset group -- asset -- analysis tab -- Thermal Images static text
	@iOSFindBy(accessibility="Thermal Images")
	private WebElement thermalImagesStaticText;
	
	//Asset group -- asset -- analysis tab -- View Saved Data static text
	@iOSFindBy(accessibility="View Saved Data")
	private WebElement viewSavedDataStaticText;
	
	//Asset group -- asset -- analysis tab -- View Saved Data static text -- measurements device name
	@iOSFindBy(accessibility="device name")
	private List<WebElement> deviceNamesInMeasurementsList;
	
	@iOSFindBy(accessibility="addDataButton")
	private WebElement addDataButton;
	
	@WithTimeout(time = 20, chronoUnit = ChronoUnit.SECONDS)
	@iOSFindBy(accessibility="newMeasurementButton")
	private WebElement addExistingMeasurementButton; 
	
	@iOSFindBy(accessibility="Create New Measurement")
	private WebElement createNewMeasurementButton; 
	
	@iOSFindBy(accessibility="Add")
	private WebElement addMeasurementButton; 
	
	@iOSFindBy(accessibility="Overall Vibration - in/s")
	private WebElement vibrationInchesPerSecondStaticText; 
	
	@iOSFindBy(accessibility="Overall Vibration - mm/s")
	private WebElement vibrationMillimetersPerSecondStaticText; 
	
	@iOSFindBy(accessibility="Temperature - °C")
	private WebElement temperatureCelciusStaticText; 
	
	@iOSFindBy(accessibility="Temperature - °F")
	private WebElement temperatureFarenheitStaticText; 
	
	@HowToUseLocators(iOSAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
	@iOSFindBy(accessibility="Temperature - °F")
	@iOSFindBy(accessibility="Temperature - °C")
	private WebElement temperatureStaticText; 
	
	@iOSFindBy(accessibility="Not enough data available for analysis")
	private WebElement notEnoughDataAvailableText;
	
	@iOSFindBy(accessibility="Edit")
	private WebElement editButton;
	
	@iOSFindBy(accessibility="Delete")
	private WebElement deleteButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Add\"])[2]")
	private WebElement alertAddButton;
	
	@iOSXCUITFindBy(accessibility = "Next")
	private WebElement nextButtonInNewAssetPage;
	
	@AndroidFindBy(id = "select_asset")
	private List<WebElement> testPointRadioButtonList;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/rename_group_ed")
	@FindBy(how=How.CSS,using="#container-name-input")
	@iOSFindBy(accessibility="Enter Asset Group Name")
	private WebElement enterGroup;
	
	
	@iOSFindBy(accessibility="AssetList")
	private List<MobileElement> assetList;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),\"Info\")]")
	@AndroidFindBy(id="com.fluke.deviceApp:id/componets_testpoints")
	@iOSFindBy(accessibility="InfoComponents")
	private WebElement testComponent;
	
	@FindBy(how=How.CSS,using="[data-value=\"add-component\"]")
	@AndroidFindBy(id="com.fluke.deviceApp:id/add_component")
	@iOSFindBy(accessibility="AddComponent")
	private WebElement addComponentButton;
	
	@FindBy(how=How.CSS,using="input[id=addComponentAssetName]")
	@AndroidFindBy(id="com.fluke.deviceApp:id/add_component_name")
	@iOSFindBy(accessibility="Component name")
	private WebElement componentTextField;
	
	@FindBy(how=How.CSS,using="[data-event=\"click:confirm-save-component-asset\"]")
	@AndroidFindBy(id="com.fluke.deviceApp:id/action_bar_item_menu_text")
	@iOSFindBy(accessibility="Save")
	private WebElement saveComponent;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/image_menu")
	@iOSFindBy(accessibility="ComponentMenu0")
	private WebElement  componentEditButton;
	
	@FindBy(how=How.CSS,using="[data-value=\"delete-component\"]")
	@AndroidFindBy(uiAutomator="Delete Test Point")
	@iOSFindBy(accessibility="Delete subcomponent")
	private WebElement deleteCompButton;
	
	@FindBy(how=How.XPATH,using="//div/a[contains(text(),\"Status\")]")
	@AndroidFindBy(id="com.fluke.deviceApp:id/status_tab_text")
	@iOSFindBy(accessibility="STATUS")
	private WebElement status;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/filter_image")
	@iOSFindBy(accessibility="Filter")
	private WebElement filter;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/action_bar_item_left")
	@iOSFindBy(accessibility="Back")
	private WebElement statusBackButton;
	
	@FindBy(how=How.CSS,using="[data-event='click:edit-equipment-basic-info']")
	@iOSFindBy(accessibility="Edit Info")
	private WebElement editInfo;
	
	@FindBy(how=How.CSS,using="input[id=\"equipmentName\"]")
	@AndroidFindBy(id="com.fluke.deviceApp:id/asset_name_text")
	@iOSFindBy(accessibility = "Asset name")
	private WebElement assetNameTextField;
	
	@FindBy(how=How.CSS,using="[data-event=\"click:save-edit-equipment-basic-info\"]")
	@AndroidFindBy(id="com.fluke.deviceApp:id/action_bar_item_menu_text")
	@iOSXCUITFindBy(iOSNsPredicate = "label == 'SAVE' OR label == 'Save'")
	private WebElement saveEditAsset;
	
	@iOSFindBy(accessibility="Rename Group")
	private WebElement renameGroupButton;
	
	@FindBy(how=How.CSS,using="[data-value=\"edit-component-name\"]")
	@AndroidFindBy(uiAutomator="Edit Test Point")
	@iOSFindBy(accessibility="Edit subcomponent")
	private WebElement editComponent;
	
	@iOSFindBy(accessibility="delete")
	private WebElement deleteKeyBoard;
	
	@FindBy(how=How.CSS,using=".equipment-list-filter-new")
	@AndroidFindBy(id="com.fluke.deviceApp:id/sortB")
	@iOSXCUITFindBy( iOSNsPredicate = "name = 'Filter Button' AND visible = true")
	private WebElement filterButton;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/icon_add_asset")
	private WebElement addAssetIcon;

	@iOSFindBy(accessibility="Filter Button")
	private List<WebElement> iOSFilterButton;
	
	@iOSFindBy(accessibility="Status")
	private WebElement statusFilterOption;
	
	@iOSFindBy(accessibility="Asset Type")
	private WebElement assetTypeOption;
	
	
	@iOSFindBy(accessibility="Asset Name")
	private WebElement assetNameOptions;
	
	@FindBy(how=How.CSS,using="[data-sort-criterion='lastModified']")
	@iOSFindBy(accessibility="Last Status Update")
	private WebElement lastStatusUpdate;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/action_bar_item_left")
	@iOSFindBy(accessibility="back white")
	private WebElement sortFilterBackButton;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/asset_search_text")
	private WebElement searchedAsset;
	
	@iOSFindBy(accessibility="Search")
	private List<WebElement> searchedAssetIniOS;
	
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/asset_name")
	private List<MobileElement> assetListAndoroid;
	
	@FindBy(how=How.CSS,using=".equipment-card")
	private List<WebElement> assetWebList;
	
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/filter_type")
	private List<WebElement> filterTypeList;
	
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/radio_btn")
	private List<WebElement> sortTypeList;
	
	@FindBy(how=How.CSS,using=".status-option-text")
	@AndroidFindBy(id="com.fluke.deviceApp:id/filter_option_text")
	private List<WebElement> fliterStatusText;
	
	@FindBy(how=How.CSS,using="[data-event=\"click:filter-equipment-list\"]")
	@AndroidFindBy(id="com.fluke.deviceApp:id/filter_check_box")
	private List<WebElement> fliterStatusCheckBox;
	
	@FindBy(how=How.CSS,using="#assetHierarchyDisplay .down-pointer")
	private  WebElement downPointerWebOfAssetHierarchy;
	
	@FindBy(how=How.CSS,using="input[id=equipmentAssetDeleteConfirmation]")
	private WebElement deleteTextArea;
	
	@FindBy(how=How.CSS,using="#deleteEquipmentAssetButton")
	private WebElement deleteWebAssetButton;
	
	@FindBy(how=How.CSS,using=".down-pointer")
	private WebElement assetDownPointer;
	
	@FindBy(how=How.CSS,using="[data-event=\"click:delete-asset\"]")
	private WebElement deleteOptionInWeb;
	
	@FindBy(how=How.CSS,using="[data-action=\"delete\"]")
	private WebElement deleteWebAssetGroup;
	
	@FindBy(how=How.CSS,using=".equipment-status-picker-options")
	private WebElement webStatusOptions;
	
	@FindBy(how=How.CSS,using=".equipment-card-name-column .equipment-card-name")
	private List<WebElement> getWebAssetNameList;
	
	@FindBy(how=How.CSS,using=".equipment-card-last-stat-change")
	private List<WebElement> getLastStatusChnage;
	
	@iOSFindBy(accessibility="Clear text")
	private WebElement clearText;
	
	@AndroidFindBy(id = "action_bar_item_menu_icon")
	private WebElement optionMenuAtAssetTestPointPage;
	
	@AndroidFindBy(id = "android:id/title")
	@iOSFindBy(accessibility="CLEAR")
	private WebElement clearAssignment;
	
	@AndroidFindBy(id = "com.fluke.deviceApp:id/dialog_ok")
	@iOSFindBy(xpath="//XCUIElementTypeButton[@name=\"Clear Asset Assignment\"]")
	private WebElement okButtonOnAssetClearingPopUp;
	
	@AndroidFindBy(id = "image_menu")
	@iOSXCUITFindBy(iOSNsPredicate = "name = 'options gray'")
	private WebElement testPointOptionsButton;
	
	@FindBy(how = How.CSS, using = "#dialog_ok")
	private WebElement assignAssetDialogOk;
	
	@FindBy(how = How.CSS, using = "#asset-selection-assign-button")
	private WebElement assignAssetButton;
	
	@FindBy(how = How.CSS, using = ".equipment-card-current-sort-column")
	private WebElement assetListSortArrow;
	
	private NewAssetPage newAssetPage;
	private Gestures gesture;
	private GestureUtils gestureUtils;
	private Asset assets;
	public List<String> actualListParameter=new ArrayList<String>();
	public List<String> expectedListParameter=new ArrayList<String>();
	
	public AssetsPage()
	{
		CommonUtils.initElements(this, 10);
		newAssetPage = new NewAssetPage();
		gesture = new Gestures();
		gestureUtils=new GestureUtils();
		assets=new Asset();
	}
	
	public void clickOnAssetGroupName(String assetGroupName) throws Exception
	{
		CommonUtils.wait(2, 2, 3);
		ElementUtils.click(5, ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,assetGroupName,LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,assetGroupName,LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS,assetGroupName));	
		CommonUtils.wait(2,2,5);
	} 
	
	public enum AssetPageObjects {
		ASSIGN_ASSET_DIALOG_OK
	}
	
	public WebElement getAssetPageWebElement(AssetPageObjects objectName) {
		switch(objectName)
		{
		case ASSIGN_ASSET_DIALOG_OK:
			return assignAssetDialogOk;
		}
		return null;
	}
	
	public void clickOnAssetName(String assetName) throws Exception 
	{
		
		CommonUtils.wait(2, 5, 3);
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
	  	{	
			DriverManager.getDriver().findElements(MobileBy.AccessibilityId(assetName)).get(1).click();
		}
		else if(DriverManager.getDriverName().equals("Android")||DriverManager.getDriverName().equals("Web"))
		{
			gestureUtils.mScroll(assetName, null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);	
			ElementUtils.safeClick(20, ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,assetName,LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,assetName,LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS,assetName));
		}	
	}
	
	public void selectAssetTestPoint(String testPointName, int index)
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.safeClick(10, null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, testPointName, null, null);
			CommonUtils.wait(2);
		}
		else if(DriverManager.getDriverName().equals("Android"))
		{
			CommonUtils.ifElementIsDisplayedThenTap(testPointRadioButtonList.get(index));
		}
	}
	
	public void assignAsset(String assetGroupName, String assetName, String testPointName, int androidTestPointIndex) throws Exception 
	{
		clickOnAssetGroupName(assetGroupName);
		clickOnAssetName(assetName);
		selectAssetTestPoint(testPointName, androidTestPointIndex);
	}
	
	public void assignAssetCM(String assetGroupName, String assetName, String testPointName, int androidTestPointIndex) throws Exception 
	{
		clickOnAssetGroupNameCM(assetGroupName);
		clickOnAssetNameCM(assetName);
		selectAssetTestPointCM(testPointName, androidTestPointIndex);
	}
	
	public void clickOnAssetGroupNameCM(String assetGroupName) throws Exception
	{
		IOSUtils.isPageLoaded(30, "Loading...");
		ElementUtils.isEnabledReliableClick(1, assetGroupName, filterButton, 9);
	}
	
	public void clickOnAssetNameCM(String assetName) throws Exception 
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			ElementUtils.isEnabledReliableClick(1, assetName, testPointOptionsButton, 10);
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			gestureUtils.mScroll(assetName, null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);	
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,assetName,LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,assetName, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS,assetName).click();
		}
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			ElementUtils.click(5, assetListSortArrow);
			ElementUtils.click(5, assetListSortArrow);
			CommonUtils.wait(1);
			gestureUtils.getJavaScriptExecutor().executeScript("arguments[0].click();", ElementUtils.getElements(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT, assetName).get(1));
		}
	}
	
	public void selectAssetTestPointCM(String testPointName, int index)
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, testPointName, null, null).click();
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			testPointRadioButtonList.get(index).click();
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			assignAssetButton.click();
	}
	
	public void clickOnBackButton() throws Exception
	{
		if(DriverManager.getDriverName().equals("iOS")||DriverManager.getDriverName().equals("Android"))
			ElementUtils.clickIfDisplayedAndEnabled(backButton);
		else
			GestureUtils.moveAndClickElement(backButton);
	}
	
	public void addAssetGroup(String assetGroupName) throws Exception
	{
		
		if(DriverManager.getDriverName().equals("iOS"))
		{
			CommonUtils.reliableClick(assetGroupsPageOptionButton, addAssetGroupButton, 3);
			CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(15, 1, addAssetGroupButton);
		 	//((MobileElement) DriverManager.getDriver().findElement(MobileBy.iOSNsPredicateString("value MATCHES 'Enter Asset Group Name' AND type MATCHES 'XCUIElementTypeTextField'"))).setValue(assetGroupName);
			enterGroup.sendKeys(assetGroupName);

		}
		else if(DriverManager.getDriverName().equals("Android"))
		{
			CommonUtils.wait(2);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/more_icon", null, null, null, null).click();
			CommonUtils.getElementByUsingVisibleText("Add Asset Group").click();
			CommonUtils.wait(2);
			DriverManager.getDriver().findElement(By.id("com.fluke.deviceApp:id/rename_group_ed")).sendKeys(assetGroupName);
		}
		
		else if(DriverManager.getDriverName().equals("Web"))
		{
			addAssetGroupButton.click();
			enterGroup.sendKeys(assetGroupName);
		}
		saveButton.click();
		CommonUtils.wait(2,2,6);
	}
	
	public boolean isAssetGroupCreated(String assetGroupName)
	{
		
		if(DriverManager.getDriverName().equals("iOS"))
		{
			return DriverManager.getDriver().findElement(MobileBy.AccessibilityId(assetGroupName)).isDisplayed();
		}
		else if(DriverManager.getDriverName().equals("Android") ||DriverManager.getDriverName().equals("Web"))
	
		{
			return ElementUtils.isDisplayed(20, 2, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, assetGroupName, null,null,LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS,assetGroupName);
		}
		else
		{
			return false;
		}
		
		
	}
	
	public void clickOnAddAssetButton() throws Exception
	{
		CommonUtils.wait(2);
		for(WebElement element: ElementUtils.getElements(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"com.fluke.deviceApp:id/icon_add_asset",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"AddAsset Button",LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,"[data-event=\"click:navigate\"] [title=\"Add\"]"))
			element.click();
	}
	
	public void addAsset(String assetName, String assetType, String assetStatus) throws Exception
	{
		clickOnAddAssetButton();
		newAssetPage.newAsset(assetName, assetType, assetStatus);
	}
	
	
	//############################ Added By Akhilesh ######################################################
	
	public void clickOnComponentSection()
	{
		testComponent.click();
	}
	
	public void clickOnAddComponentButton()
	{
		if(DriverManager.getDriverName().equals("Web"))
		{
			downPointerWebOfAssetHierarchy.click();
		}
		addComponentButton.click();
	}
	
	public void enterComponentName(String compName)
	{
		componentTextField.clear();
		componentTextField.sendKeys(compName);
	}
	
	public void clickOnSaveComponentButton()
	{
		saveComponent.click();
	}
	
	public void clickOnEditComponentButton(String assetName)
	{
		if(DriverManager.getDriverName().equals("Android")||DriverManager.getDriverName().equals("iOS"))
		{
			componentEditButton.click();
		}
		else
		{
			CommonUtils.wait(2);
			//ElementUtils.clickObject(DriverManager.getDriver().findElement(By.cssSelector("[title='"+assetName+"']~.bubble-menu-wrpr .down-pointer")));
			DriverManager.getDriver().findElement(By.cssSelector("[title='"+assetName+"']~.bubble-menu-wrpr .down-pointer")).click();;
		}	
	}
	
	public void clickDeleteCompButton()
	{
		deleteCompButton.click();
	}
	
	public void deleteOnPopup()
	{
		confirmationAlertDeleteButton.click();
	}
	
	public void clickOnAssetEditInfoButon()
	{
		if(DriverManager.getDriverName().equals("Android"))
		{
			ElementUtils.getElement("Edit Asset Info", null, null).click();
		}
		else if(DriverManager.getDriverName().equals("iOS")||DriverManager.getDriverName().equals("Web"))
		{
			editInfo.click();
		}
		
	}
	
	public void editGroup(String editGroupName,String mainGroupName)
	{
		assetGroupsPageOptionButton.click();
		//renameGroupButton.click();
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, "Rename Group",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"Rename Group",null,null).click();
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"com.fluke.deviceApp:id/rename_group_ed", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE,mainGroupName, null, null).clear();;
		
		enterGroup.sendKeys(editGroupName);
		saveButton.click();	
	}
	
	public void editAsset(String editAssetname)
	{
		CommonUtils.wait(2);
		assetDetailsPageOptionsButton.click();
		clickOnAssetEditInfoButon();
		assetNameTextField.clear();
		assetNameTextField.sendKeys(editAssetname);
		saveEditAsset.click();
		CommonUtils.wait(3);
	}
	
	public void createTestComponent(String assetName,String compName) throws Exception
	{
		clickOnAssetName(assetName);
		clickOnComponentSection();
		clickOnAddComponentButton();
		enterComponentName(compName);
		clickOnSaveComponentButton();	
	}
	
	public void editComponent(String assetName,String editComponentName,String assetComponent) throws Exception
	{
		
		clickOnEditComponentButton(assetComponent);
		if(DriverManager.getDriverName().equals("Android"))
		{
			ElementUtils.getElement("Edit Test Point", null, null).click();
		}
		else if(DriverManager.getDriverName().equals("iOS")||DriverManager.getDriverName().equals("Web"))
		{
			editComponent.click();
		}
		
		enterComponentName(editComponentName);
		clickOnSaveComponentButton();	
	}
	
	public void deleteComponent(String assetName)
	{
		clickOnEditComponentButton(assetName);
		
		if(DriverManager.getDriverName().equals("Android"))
		{
			ElementUtils.getElement("Delete Test Point", null, null).click();
		}
		else if(DriverManager.getDriverName().equals("iOS")||DriverManager.getDriverName().equals("Web"))
		{
			deleteCompButton.click();
		}
		
		if(DriverManager.getDriverName().equals("Web"))
		{
			deleteTextArea.sendKeys("delete");
		}
		confirmationAlertDeleteButton.click();
	}
	
	public boolean isTestComponentCreated(String assetOrTestPoint)
	{
		CommonUtils.wait(2);
		return ElementUtils.isDisplayed(10,2,LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,assetOrTestPoint,LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS,assetOrTestPoint,LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_SPAN_TEXT_CONTAINS,assetOrTestPoint);	
	}
	
	public void clickOnStatusTab()
	{
		status.click();
	}
	
	
	public void clickOnSeverity()
	{
		if(DriverManager.getDriverName().equals("Android")||DriverManager.getDriverName().equals("iOS"))
		{
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/set_status_layout", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME,"Severity" , null, null).click();;
		}
		else if(DriverManager.getDriverName().equals("Web"))
		{
			CommonUtils.wait(2);
			GestureUtils.moveToElement(webStatusOptions);
			CommonUtils.wait(1);
		}
	}
	
	public void selectStatus(String statusName,int statusCount )
	{	
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,statusName,LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,statusName,LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "[data-event=\"click:change-status\"] [data-severity='"+assets.assetSeverityFilterWeb().get(statusCount)+"']").click();	
	}
	
	public void selectStatusFromFilterInAndorid(int statusCount,String statusName)
	{
		if(fliterStatusText.get(statusCount+1).getText().equals(statusName))
		{
			fliterStatusCheckBox.get(statusCount+1).click();
		}	
		
		
	}
	
	public String getStatusNameAfterChange()
	{
		CommonUtils.wait(2);
		return ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/current_status_text", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME,"Severity" , LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,".equipment-status-current").getText();
	}
	
	public void clickOnSaveButton()
	{
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/action_bar_item_menu_text", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Save", LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "[data-event=\"click:confirm-status-change\"]").click();
	}
	
	
	public void clickOnFilter()
	{
		filter.click();
	}
	
	public void clickOnBackStatusButton()
	{
		if(DriverManager.getDriverName().equals("iOS")||DriverManager.getDriverName().equals("Android"))
		statusBackButton.click();
	}
	
	
	public boolean getStatusHistory(String statusIcon)
	{
		return ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, statusIcon, null, null).isEnabled();
	}

	
	public void clearData(String str)
	{
		
		for(int stringLength=0;stringLength<str.length();stringLength++)
		{
			deleteKeyBoard.click();
		}
		
	}	
	
	public void clickOnAssetFilter()
	{
		if(DriverManager.getDriverName().equals("iOS"))
			iOSFilterButton.get(1).click();
		else if(DriverManager.getDriverName().equals("Android")||DriverManager.getDriverName().equals("Web"))
			  filterButton.click();	
	}
	
	public void clickOnStatusfilterOption()
	{		
		if(DriverManager.getDriverName().equals("Android"))
		{
			filterTypeList.get(0).click();
		}
		else if(DriverManager.getDriverName().equals("iOS"))
		{
			statusFilterOption.click();
		}
	}
	
	public void clickOnSortFilterBackButton()
	{
		if(DriverManager.getDriverName().equals("Android")||DriverManager.getDriverName().equals("iOS"))
		{
			sortFilterBackButton.click();
		}
	}
	
	public void selectStatusCheck(String  statusname,int statusCount) throws Exception
	{
		clickOnAssetFilter();
		clickOnStatusfilterOption();
		CommonUtils.wait(3);
		if(DriverManager.getDriverName().equals("Android"))
		{
			selectStatusFromFilterInAndorid(statusCount,statusname);
			CommonUtils.wait(3);
			clickOnBackStatusButton();
			clickOnSortFilterBackButton();
		}
		else if(DriverManager.getDriverName().equals("iOS"))
		{
			selectStatus(statusname,statusCount);
			CommonUtils.wait(3);
			clickOnBackStatusButton();
			clickOnSortFilterBackButton();
		}
		else if(DriverManager.getDriverName().equals("Web"))
		{
			ElementUtils.getElement(null,null,null,null,LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,"[data-model-name='"+statusname+"']").click();
		}

		
	}
	
	public void clickOnAssetTypeOption()
	{
		if(DriverManager.getDriverName().equals("Android"))
		{
			filterTypeList.get(1).click();
		}
		else if(DriverManager.getDriverName().equals("iOS"))
		{
			assetTypeOption.click();
		}
	}
	
	public void selectAssetType(String assetType)
	{
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,assetType,LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,assetType,null,null).click();
	}
	
	
	public void selectAssetTypeCheck(String assetTypeName,int assetTypeCount) throws Exception
	{
		clickOnAssetFilter();
		clickOnAssetTypeOption();
		CommonUtils.wait(3);
		
		if(DriverManager.getDriverName().equals("Android"))
		{
			selectStatusFromFilterInAndorid(assetTypeCount,assetTypeName);
			CommonUtils.wait(3);
			clickOnBackStatusButton();
			clickOnSortFilterBackButton();
		}
		else if(DriverManager.getDriverName().equals("iOS"))
		{
			selectAssetType(assetTypeName);;
			CommonUtils.wait(3);
			clickOnBackStatusButton();
			clickOnSortFilterBackButton();
		}
		else if(DriverManager.getDriverName().equals("Web"))
		{
			ElementUtils.getElement(null,null,null,null,LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,"[data-model-name='"+assetTypeName+"']").click();;
		}
		
		
	}
	
	/*public boolean assetTypeDisplayed(String assetType)
	{
		List<MobileElement> assetListView =  DriverManager.getDriver().findElements(MobileBy.AccessibilityId("Asset Group List View"));
		MobileElement assetListTable = assetListView.get(1);
		return assetListTable.findElementByXPath(using)
	}*/
	
	
	
	public List<MobileElement> getAssetCell()
	{
		if(DriverManager.getDriverName().equals("Android"))
		{
			return assetListAndoroid;
		}
		else if(DriverManager.getDriverName().equals("iOS"))
		{
			return assetList.get(1).findElements(MobileBy.xpath("XCUIElementTypeCell"));
		}
		return null;		
	}
	
	public int getAssetList()
	{
		int assetCell=0;
		if(DriverManager.getDriverName().equals("iOS"))
		{
			System.out.println(getAssetCell().size());
			assetCell=getAssetCell().size()-1;
		}
		else if(DriverManager.getDriverName().equals("Android"))
		{
			assetCell=getAssetCell().size();
			System.out.println(assetCell);
		}
		else if(DriverManager.getDriverName().equals("Web"))
		{
			CommonUtils.wait(3);
			assetCell=assetWebList.size();
		}
		
		return assetCell;
	}
	
	public void selectAssetNameFilter()
	{
		CommonUtils.wait(2);
		if(DriverManager.getDriverName().equals("Android"))
		{
			ElementUtils.getElement("Asset Name", null, null).click();
		}
		else if(DriverManager.getDriverName().equals("iOS"))
		{
			assetNameOptions.click();
		}	
	}
	
	public void selectLastUpdateDate()

	{
		if(DriverManager.getDriverName().equals("Android"))
		{
			ElementUtils.getElement("Last Status Update", null, null).click();
		}
		else if(DriverManager.getDriverName().equals("iOS")||DriverManager.getDriverName().equals("Web"))
		{
			lastStatusUpdate.click();
		}
		
	}
	public boolean getAssetNameFromList()
	{ 
		if(DriverManager.getDriverName().equals("iOS"))
		{
			
			for(int assetSortList=0;assetSortList<assets.sortedAsset.length-6;assetSortList++)
			{
				gestureUtils.iOSScrollDown(DriverManager.getDriver().findElements(By.xpath("//XCUIElementTypeStaticText[@name='"+assets.sortedAsset[assetSortList]+"']")).get(1));
				actualListParameter.add(DriverManager.getDriver().findElements(By.xpath("//XCUIElementTypeStaticText[@name='"+assets.sortedAsset[assetSortList]+"']")).get(1).getText());
			
			}
		}
		else if(DriverManager.getDriverName().equals("Android"))
		{
			for(int assetSortList=0;assetSortList<assets.sortedAsset.length;assetSortList++)
			{
				int assetListCount=0;
				CommonUtils.wait(2);
				gestureUtils.scroll(null,null,null,assets.sortedAsset[assetSortList],0,-200,null,null);
				if(getAssetCell().size()<=assetSortList)
				{
					 assetListCount=getAssetCell().size()-1;
					 actualListParameter.add(getAssetCell().get(assetListCount).getText());
				}
				else
				{
					actualListParameter.add(getAssetCell().get(assetSortList).getText());
				}	
			}
		}
		else if(DriverManager.getDriverName().equals("Web"))
		{
			for(int assetListCount=0;assetListCount<getAssetList();assetListCount++)
			{
				CommonUtils.wait(1);
				actualListParameter.add(getWebAssetNameList.get(assetListCount).getText());
			}
		}
		expectedListParameter.addAll(actualListParameter);		
		Collections.sort(actualListParameter);
		/* Collections.sort(actualListParameter, new Comparator<String>() {
		        public int compare(String first, String second) {
		            return extractInt(first) - extractInt(second);
		        }
		        int extractInt(String s) {
		            String num = s.replaceAll("\\D", "");
		            // return 0 if no digits found
		            return num.isEmpty() ? 0 : Integer.parseInt(num);
		        }
		    });*/
		 
		if(expectedListParameter.equals(actualListParameter))
		{
			return true;
		}
			return false;	
	} 
		
	
	public String  getLastModifiedDateOfAssets(int assetListCount)
	{
		return getLastStatusChnage.get(assetListCount).getText();
	}
	
	
	public String  searchedAsset(String assetName,int aseetCellNumber)
	{
		CommonUtils.wait(1,1,2);
		enterAssetNameInSaerch(assetName);
		if(DriverManager.getDriverName().equals("iOS"))
		{
			return DriverManager.getDriver().findElement(MobileBy.iOSNsPredicateString("name =='"+assetName+"'")).getText();
			
		//return assetList.get(0).findElementsByXPath("XCUIElementTypeCell").get(aseetCellNumber).findElementsByXPath("XCUIElementTypeStaticText").get(3).getText();
		
		}
		else if(DriverManager.getDriverName().equals("Android"))
		{
			CommonUtils.wait(3);
			//AndroidUtils.back();
			return assetListAndoroid.get(0).getText();
		}
		return null;
	}
	
	public void clickOnCancelButton()
	{
		cancelButton.click();
	}
	
	public void enterAssetNameInSaerch(String searchedAssetName)
	{
		if(DriverManager.getDriverName().equals("iOS"))
		{
			searchedAssetIniOS.get(1).clear();
			searchedAssetIniOS.get(1).sendKeys(searchedAssetName);
		}
		else if(DriverManager.getDriverName().equals("Android"))
		{
			searchedAsset.clear();
			searchedAsset.sendKeys(searchedAssetName);
		}
		
	}
	
//############################## Ended BY Akhilesh  #########################################################	
	
	public void addAssetWithAboveTempratureAlarm(String assetName, String assetType, String componentName, String aboveTempratureValue, String assetStatus) throws Exception
	{
		clickOnAddAssetButton();
		newAssetPage.newAssetWithAboveTempratureAlarm(assetName, assetType, componentName, aboveTempratureValue, assetStatus);
	}
	
	public boolean isAssetCreated(String assetName)
	{
	 	if(DriverManager.getDriverName().equals("iOS"))
		{
			//return DriverManager.getDriver().findElements(MobileBy.iOSNsPredicateString("name =='"+assetName+"'")).get(1).isDisplayed();
	 		CommonUtils.wait(2);
	 		return DriverManager.getDriver().findElements(By.xpath("//XCUIElementTypeStaticText[@name='"+assetName+"']")).get(1).isDisplayed();	//DriverManager.getDriver().findElements(MobileBy.AccessibilityId(assetName)).get(1).isDisplayed();
		}
		else if(DriverManager.getDriverName().equals("Android")||DriverManager.getDriverName().equals("Web"))
		{
			return ElementUtils.isDisplayed(20,2,LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,assetName,null,null,LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS,assetName);
		}
		else
		{
			return false;
		}
	}
	
	public void deleteAssetGroup(String assetGroupName)
	{
		CommonUtils.wait(1,1,3);
		
		try
		{
			if(DriverManager.getDriverName().equals("iOS"))
			{
				try
				{
					assetListGroupsPageOptionButton.get(1).click();
				}
				catch(Exception e)
				{
					assetListGroupsPageOptionButton.get(0).click();
				}
				
				deleteAssetGroupButton.click();
				confirmationAlertDeleteButton.click();
				confirmationAlertDeleteButton.click();
			}
			else if(DriverManager.getDriverName().equals("Android"))
			{
				assetGroupsPageOptionButton.click();
				CommonUtils.getElementByUsingVisibleText("Delete Group").click();
				confirmationAlertDeleteButton.click();
				confirmationAlertDeleteButton.click();
			}
			else if(DriverManager.getDriverName().equals("Web"))
			{

				GestureUtils.moveToElement(ElementUtils.getElement(null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS, assetGroupName));
				assetGroupsPageOptionButton.click();
				deleteAssetGroupButton.click();
				deleteWebAssetGroup.click();
				CommonUtils.wait(2);
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			CommonUtils.ifElementIsDisplayedThenTap(cancelButton);
			CommonUtils.ifElementIsDisplayedThenTap(backButton);
		}
	}
	
	public void deleteAsset(String assetName) throws Exception
	{
		if(DriverManager.getDriverName().equals("Android")||DriverManager.getDriverName().equals("iOS"))
		{
			clickOnAssetName(assetName);
			assetDetailsPageOptionsButton.click();
		//	deleteAssetButton.click();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, "Delete Asset", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Delete Asset", null, null).click();
			confirmationAlertDeleteButton.click();
			confirmationAlertDeleteButton.click();
		}
		else
		{
			GestureUtils.moveAndClickElement(assetDownPointer);
			deleteOptionInWeb.click();
			deleteTextArea.sendKeys("delete");
			deleteWebAssetButton.click();
		}
		
	}
	
	public boolean isAssetOrAssetGroupDeleated(String assetOrGroup)
	{
		CommonUtils.wait(5);
		return ElementUtils.isNotDisplayed(60,3,LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,assetOrGroup,LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,assetOrGroup,LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT,assetOrGroup);
		//return ElementUtils.isNotDisplayed(30,3,LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_ONLY_TEXT,assetOrGroup)
	}

	public void changeAssetType(String assetName, String assetType)
	{
		try
		{
			clickOnAssetName(assetName);
			assetDetailsPageOptionsButton.click();
			editAssetInfoButton.click();
			newAssetPage.selectAssetType(assetType);
			ElementUtils.clickIfDisplayedAndEnabled(30, 1, secondSaveButton);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	public void changeAssetStatus(String assetStatus)
	{
		editAssetStatusButton.click();
		editAssetStatusTypeButton.click();
		newAssetPage.selectAssetStatus(assetStatus);
		backButton.click();
	}
	
	public boolean isAssetTypeChanged(String assetName, String assetType) throws Exception
	{
		clickOnAssetName(assetName);
		return ElementUtils.isDisplayed(60, 1, ElementUtils.getElement(null, null,LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, assetType, null, null));
	}
	
	public boolean isAssetStatusChanged(String assetStatus)
	{
		editAssetStatusButton.click();
		return editAssetStatusTypeButton.getText().equals(assetStatus);
	}
	
	public void clickOnAssetAnalysisThermalImages(String assetGroupName, String assetName) throws Exception
	{
		clickOnAssetGroupName(assetGroupName);
		clickOnAssetName(assetName);
		ElementUtils.clickIfDisplayedAndEnabled(analysisButton);
		gesture.iOSScrollDown("Thermal Images");
		ElementUtils.clickIfDisplayedAndEnabled(thermalImagesStaticText);
	}
	
	public boolean isDataSaved()
	{
		viewSavedDataStaticText.click();
		if(deviceNamesInMeasurementsList.size()<0)
		{
			return false;
		}
		return true;
	}
	
	public void navigateToAnalysisTab(String assetGroupName, String assetName) throws Exception
	{
		clickOnAssetGroupName(assetGroupName);
		clickOnAssetName(assetName);
		ElementUtils.clickIfDisplayedAndEnabled(analysisButton);
	}
	
	public void selectMeasurementsFor805() throws Exception
	{
		CommonUtils.reliableClick(addDataButton, addExistingMeasurementButton, 3);
		ElementUtils.clickIfDisplayedAndEnabled(addExistingMeasurementButton);
	}
	
	public WebElement getInchesStaticTextObject()
	{
		return vibrationInchesPerSecondStaticText;
		
	}
	
	public WebElement getMillimetersStaticTextObject()
	{
		return vibrationMillimetersPerSecondStaticText;
		
	}
	
	public WebElement getCelciusStaticTextObject()
	{
		return temperatureCelciusStaticText;	
	}
	
	public WebElement getFarhenheitStaticTextObject()
	{
		return temperatureFarenheitStaticText;	
	}
	
	public WebElement getTemperatureStaticText()
	{
		return temperatureStaticText;	
	}
	
	public void editMeasurementFor805() throws Exception
	{
		ElementUtils.clickIfDisplayedAndEnabled(viewSavedDataStaticText);
		ElementUtils.clickIfDisplayedAndEnabled(editButton);
	}
	
	public void deleteMeasurementFor805() throws Exception
	{
		ElementUtils.clickIfDisplayedAndEnabled(deleteButton);
	}
	
	public void assetDetailsPageOptionsButton() throws Exception
	{
		ElementUtils.clickIfDisplayedAndEnabled(assetDetailsPageOptionsButton);
	}
	
	public void clickOn805AlertAddButton()
	{
		try
		{
			//alertAddButton.click();;
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	//*****Added by Rakesh*****
	
	public void navigationToAssetTestPoint(String assetGroupName, String assetName) throws Exception
	{
		
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,assetGroupName,LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME,assetGroupName,null,null).click();
		CommonUtils.wait(2);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,assetName,LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME,assetName,null,null).click();
		//clickOnAssetGroupName(assetGroupName);
		//clickOnAssetName(assetName);
	}
	
	public void clickClearAssignment()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			ElementUtils.safeClick(optionMenuAtAssetTestPointPage);
		}
			ElementUtils.safeClick(clearAssignment);
			ElementUtils.safeClick(okButtonOnAssetClearingPopUp);
		
		
	}

	
	
}
