package com.fluke.connect.app.functional.client.pages;

import java.io.FileInputStream;
import java.util.List;

import org.openqa.selenium.WebElement;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.DeviceUtils;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.lyncode.xliff.XLIFF;
import com.lyncode.xliff.XLiffUtils;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LocalizationPage {
	
	@iOSXCUITFindBy(className = "XCUIElementTypeCell")
	private WebElement firstCell;
	
	@iOSXCUITFindBy(className = "XCUIElementTypeCell")
	private List<WebElement> cellList;
	
	@iOSXCUITFindBy(className = "XCUIElementTypeButton")
	private List<WebElement> buttonList;
	
	@iOSXCUITFindBy(className = "XCUIElementTypeSearchField")
	private WebElement searchField;
	
	private DeviceUtils mDeviceUtils;
	
	private XLIFF xliffUtils;
	private final String filePath = "./files/localization/";
	
	public LocalizationPage() {
		CommonUtils.initElements(this, 10);
		mDeviceUtils = new DeviceUtils();
	}
	
	public enum LocalizationPageObjects {
		FIRST_CELL, CELL_LIST, BUTTON_LIST, SEARCH_FIELD
	}
	
	public WebElement getLocalizationPageObject(LocalizationPageObjects objectName) {
		switch(objectName) {
		case FIRST_CELL:
			return firstCell;
		case SEARCH_FIELD:
			return searchField;
		default:
			return null;
		}
	}
	
	public List<WebElement> getLocalizationPageObjects(LocalizationPageObjects objectName) {
		switch(objectName) {
		case CELL_LIST:
			return cellList;
		case BUTTON_LIST:
			return buttonList;
		default:
			return null;
		}
	}
	
	public void changeLanguage(String languageName, String languageFileName) throws Exception {
		xliffUtils = null;
		mDeviceUtils.launchOtherApp(DeviceUtils.IOS_SETTINGS_APP_BUNDLE_ID, null, null);
		firstCell.click();
		ElementUtils.sendKeys(searchField, languageName.trim());
		CommonUtils.wait(1);
		firstCell.click();
		buttonList.get(2).click();
		CommonUtils.wait(3);
		buttonList.get(4).click();
		CommonUtils.wait(15);
		mDeviceUtils.toogleFCAPP(true, "0");
		DriverManager.getSignIn().handleAfterSignInAlertsOtherUser();
		xliffUtils = XLiffUtils.read(new FileInputStream(filePath+languageFileName.trim()));
	}
	
	public String getLocalizedString(String sourceValue) {
		return xliffUtils.getTarget(sourceValue);
	}

}
