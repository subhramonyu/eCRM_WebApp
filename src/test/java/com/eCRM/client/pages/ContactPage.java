package com.eCRM.client.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.eCRM.client.config.UserProfile;
import com.eCRM.client.core.CommonUtils;
import com.eCRM.client.core.Config.UserDetails;
import com.eCRM.client.core.DriverManager;
import com.eCRM.client.core.Log;
import com.eCRM.client.core.RandomGeneratorUtils;

import ru.yandex.qatools.allure.annotations.Step;

/**
 * @author subhramd
 */
public class ContactPage extends CommonUtils {

	private LandingPage landing;
	private UserProfile user;

	@FindBy(how = How.CSS, using = "input#ctl00_cphMain_txtForename")
	private WebElement firstNameField;

	@FindBy(how = How.CSS, using = "input#ctl00_cphMain_txtSurname")
	private WebElement lastNameField;

	@FindBy(how = How.CSS, using = "input#ctl00_cphMain_cbxCompany_Input")
	private WebElement customerNameDropdown;

	@FindBy(how = How.CSS, using = "li.rcbItem")
	private List<WebElement> customerNameList;

	@FindBy(how = How.CSS, using = "ul.rtbUL>li:nth-child(3)")
	private WebElement saveBtn;
	
	@FindBy(how = How.CSS, using = "span#ctl00_cphMain_lblCompanyCAP")
	public WebElement customerStaticText;
	
	@FindBy(how = How.XPATH, using = "//span[@class='rtbText'][text()='Edit']/parent::span")
	private WebElement editBtn;
	
	@FindBy(how = How.CSS, using = "span#ctl00_cphMain_ContactList1_header1_lblTitle")
	private WebElement contactHeader;
	
	@FindBy (how = How.CSS,using = "img[alt='Delete Contact']")
	private WebElement deleteBtn;
	
	@FindBy(how = How.CSS,using ="input#ctl00_cphMain_ContactList_grdContacts_ctl00_ctl04_SelectColumnSelectCheckBox")
	private WebElement contactCheckBox;
	
	


	public ContactPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
		Log.setLogger("ContactPage");
		landing = new LandingPage();
		user = new UserProfile();
	}

	@Step("Create new Contact in eCRM")
	public String createNewContacts() {
		String customerName = null;
		switchToDefaultContent();
		landing.switchToBodyFrame();
		firstNameField.clear();
		sendKeys(firstNameField, user.getDetails(UserDetails.FIRST_NAME));
		lastNameField.clear();
		sendKeys(lastNameField, user.getDetails(UserDetails.LAST_NAME));

		customerName = selectCustomer();
		wait(2);

		click(saveBtn);
		return customerName;
	}
	

	/**It will add another contact to the same customer
	 * @param - customer name */
	
	
	@Step("Create multiple Contact in eCRM")
	public void addAnotherContact(String CustomerName ) {
		switchToDefaultContent();
		landing.switchToBodyFrame();
		firstNameField.clear();
		sendKeys(firstNameField, user.getDetails(UserDetails.FIRST_NAME));
		lastNameField.clear();
		sendKeys(lastNameField, user.getDetails(UserDetails.LAST_NAME));
		selectCustomer(CustomerName);
		wait(3);//To prepopulate the details
		click(saveBtn);

	}
	
	/*It will select random customer from the drop down*/
	@Step("Select Customer")
	public String selectCustomer() {
		String name = null;
		click(customerNameDropdown);
		wait(5);// TO load the Drop down
		WebElement ele = customerNameList.get(RandomGeneratorUtils.getRandomNumber(customerNameList.size()));
		name = ele.getText();
		click(ele);
		clickEnterKey();
		return name;
	}
	
	@Step("Select Customer")
	public void selectCustomer(String CustomerName) {
		click(customerNameDropdown);
		wait(5);// TO load the Drop down
		sendKeys(customerNameDropdown, CustomerName);
		clickEnterKey();
		click(customerStaticText);
	}

	@Step("Verify the contact added ")
	public boolean isContactCreated() {
		boolean bValue = false;
		landing.search(user.getFirstName());
		switchToDefaultContent();
		landing.switchToBodyFrame();
		Assert.assertNotNull(
				DriverManager.getDriver().findElement(By.cssSelector("a[title='"+ user.getFirstName() +"']")));
		bValue = true;
		return bValue;

	}
	
	@Step("Verify the contact added  to {0}")
	public boolean isContactVisibleToCustomer(String CustomerName) {
		boolean bValue = false;
		Assert.assertNotNull(
				DriverManager.getDriver().findElement(By.xpath("//a[text()='"+CustomerName+"']")));
		bValue = true;
		return bValue;

	}
	
	@Step("Verify the multiple contact added to : {0} ")
	public boolean isMultipleContactCreated(String CustomerName) {
			boolean bValue = false;
			landing.search(user.getFirstName());
			switchToDefaultContent();
			landing.switchToBodyFrame();
			Assert.assertNotNull(
					DriverManager.getDriver().findElement(By.cssSelector("a[title='"+ user.getFirstName() +"']")));
			bValue = true;
			return bValue;

		}
		
		
	@Step("Verify the multiple contact added to {0}")
	public boolean isMultipleContactAddedToCustomer(String CustomerName) {
		boolean bValue = false;
		Assert.assertNotNull(DriverManager.getDriver().findElement(By.xpath("//a[text()='" + CustomerName + "']")));
		bValue = true;
		return bValue;

	}
	
	@Step("Edit contacts")
	public void editContact() {
		landing.search(user.getFirstName());
		switchToDefaultContent();
		landing.switchToBodyFrame();
		click(contactCheckBox);
		click(editBtn);
		wait(4);//to load the frames
		firstNameField.clear();
		sendKeys(firstNameField, user.getDetails(UserDetails.FIRST_NAME));
		lastNameField.clear();
		sendKeys(lastNameField, user.getDetails(UserDetails.LAST_NAME));
		click(saveBtn);
	}
	
	@Step("verify the contact is edited")
	public boolean isContactEdited() {
		boolean bValue = false;
		landing.search(user.getFirstName());
		switchToDefaultContent();
		landing.switchToBodyFrame();
		Assert.assertNotNull(
				DriverManager.getDriver().findElement(By.cssSelector("a[title=" + user.getFirstName() + "]")));
		bValue = true;
		return bValue;
		
	}
	
	@Step("Verify the edited contact added ")
	public boolean isEditedContactAdded(String CustomerName) {
		boolean bValue = false;
		Assert.assertNotNull(
				DriverManager.getDriver().findElement(By.cssSelector("a[title=" + user.getFirstName() + "]")));
		bValue = true;
		return bValue;

	}

}
