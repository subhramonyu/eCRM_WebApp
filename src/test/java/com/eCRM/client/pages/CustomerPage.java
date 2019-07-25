package com.eCRM.client.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.eCRM.client.config.UserProfile;
import com.eCRM.client.core.CommonUtils;
import com.eCRM.client.core.Config.LocatorStrategy;
import com.eCRM.client.core.Config.UserDetails;
import com.eCRM.client.core.DriverManager;
import com.eCRM.client.core.Log;
import com.eCRM.client.core.RandomGeneratorUtils;
import com.tigervnc.rdr.Exception;

import ru.yandex.qatools.allure.annotations.Step;

public class CustomerPage extends CommonUtils {

	private LandingPage landing;
	private UserProfile user;

	@FindBy(how = How.CSS, using = "input#ctl00_cphMain_txtCompanyName")
	private WebElement customerNameField;

	@FindBy(how = How.CSS, using = "input#ctl00_cphMain_txtAddress1")
	private WebElement addressField;

	@FindBy(how = How.CSS, using = "input#ctl00_cphMain_txtTown")
	private WebElement cityField;

	@FindBy(how = How.CSS, using = "input#ctl00_cphMain_txtPostCode")
	private WebElement postcodeField;

	@FindBy(how = How.CSS, using = "select#ctl00_cphMain_cbxSalesperson")
	private WebElement salesPersonDropDown;

	@FindBy(how = How.CSS, using = "ul.rtbUL>li:nth-child(3)")
	private WebElement saveBtn;

	@FindBy(how = How.CSS, using = "input#txtQuickSearch")
	private WebElement quickSearch;

	@FindBy(how = How.CSS, using = "input#btnQuickSearch")
	private WebElement quickSearchBtn;

	@FindBy(how = How.CSS, using = "a#ctl00_cphMain_CustomerList1_grdCustomers_ctl00_ctl04_lnkCompany")
	private WebElement customerName;

	@FindBy(how = How.CSS, using = "span#ctl00_cphMain_CustomerList1_grdCustomers_ctl00_ctl04_lblDesignation")
	private WebElement designation;

	@FindBy(how = How.CSS, using = "select#ctl00_cphMain_cbxClassification")
	private WebElement classificationDropDown;
	
	@FindBy(how = How.CSS, using = "img[alt='Edit Customer']")
	private WebElement editBtn;
	
	@FindBy(how = How.CSS,using = "input#ctl00_cphMain_CustomerList1_grdCustomers_ctl00_ctl04_SelectColumnSelectCheckBox")
	private WebElement customerCheckBox;
	
	@FindBy(how = How.CSS, using = "img[alt='Delete the seleted Customer']")
	private WebElement deleteBtn;
	
	@FindBy(how = How.CSS, using = "input#ctl00_cmdDelete")
	private WebElement markInactive;
	

	public CustomerPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
		landing = new LandingPage();
		user = new UserProfile();
		Log.setLogger("CustomerPage");
	}

	public enum classificationType{
		CUSTOMER,PROSPECT,COMPETITOR,SUPPLIER;
	}
	
	@Step("create a new {0} in eCRM")
	public void create(classificationType aType) {
		switchToDefaultContent();
		landing.switchToBodyFrame();
		click(customerNameField);
		
		switch (aType) {
		case CUSTOMER:
			selectFromDropdown(classificationDropDown, 1);
			break;
		case PROSPECT:
			selectFromDropdown(classificationDropDown, 2);
		default:
			break;
		}
		sendKeys(customerNameField, user.getDetails(UserDetails.FULLNAME));
		click(addressField);
		sendKeys(addressField, user.getDetails(UserDetails.ADDRESS));
		click(cityField);
		sendKeys(cityField, user.getDetails(UserDetails.CITY));
		click(postcodeField);
		sendKeys(postcodeField, user.getDetails(UserDetails.POSTCODE));
		selectFromDropdown(salesPersonDropDown, 1);
		click(saveBtn);
	}
	
	
	
	@Step("validating the {0}")
	public boolean isCreated(classificationType aType) {
		boolean bValue = false;
		switchToDefaultContent();
		landing.switchToHeaderFrame();
		click(quickSearch);
		quickSearch.clear();
		sendKeys(quickSearch, user.getFullName());
		click(quickSearchBtn);
		switchToDefaultContent();
		landing.switchToBodyFrame();
		Assert.assertNotNull(customerName);

		switch (aType) {
		case CUSTOMER:
			bValue = isCustomerNameisDisplayed() && isDesignationDisplayed("Customer");
			break;
		case PROSPECT:
			bValue = isCustomerNameisDisplayed() && isDesignationDisplayed("Prospect");
		default:
			break;
		}
		return bValue;
	}
	
	
	@Step("editing the name and postal code of a {0}")
	public void edit(classificationType aType) {
		switchToDefaultContent();
		landing.switchToHeaderFrame();
		click(quickSearch);
		quickSearch.clear();
		sendKeys(quickSearch, user.getFullName());
		click(quickSearchBtn);
		switchToDefaultContent();
		landing.switchToBodyFrame();
		click(customerName);
		click(editBtn);
		customerNameField.clear();
		sendKeys(customerNameField, user.getDetails(UserDetails.FULLNAME));
		postcodeField.clear();
		sendKeys(postcodeField, user.getDetails(UserDetails.POSTCODE));
		click(saveBtn);
			
	}
	
	@Step("Deleting the  {0}")
	public void delete(classificationType aType) {
		switchToDefaultContent();
		landing.switchToHeaderFrame();
		click(quickSearch);
		quickSearch.clear();
		sendKeys(quickSearch, user.getFullName());
		click(quickSearchBtn);
		switchToDefaultContent();
		landing.switchToBodyFrame();
		click(customerCheckBox);
		click(deleteBtn);
		DriverManager.getDriver().switchTo().frame("Standard");
		click(markInactive);
	}

	@Step("Validating the deleted  {0}")
	public boolean isDeleted(classificationType aType) {
		boolean bValue = true;
		try {
			switchToDefaultContent();
			landing.switchToHeaderFrame();
			click(quickSearch);
			quickSearch.clear();
			sendKeys(quickSearch, user.getFullName());
			click(quickSearchBtn);
			switchToDefaultContent();
			landing.switchToBodyFrame();
			getElement(LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "a#ctl00_cphMain_CustomerList1_grdCustomers_ctl00_ctl04_lnkCompany");
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			bValue = false;
			throw new Exception("Element is not present");
		}
		return bValue;
		
	}
	
	@Step("checking for the customer name is displayed")
	public boolean isCustomerNameisDisplayed() {
		if (customerName.getText().contentEquals(user.getFullName())) {
			return true;
		} else {
			return false;
		}
	}

	@Step("checking for designation is displayed")
	public boolean isDesignationDisplayed(String aType) {
		if (designation.getText().contentEquals(aType)) {
			return true;
		} else {
			return false;
		}
	}
}
