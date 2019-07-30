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
		click(saveBtn);
		return customerName;

	}

	@Step("Select Customer")
	public String selectCustomer() {
		click(customerNameDropdown);
		wait(4);// TO load the Drop down
		WebElement ele = customerNameList.get(RandomGeneratorUtils.getRandomNumber(customerNameList.size()));
		click(ele);
		return ele.getText();
	}

	@Step("")
	public boolean isContactAdded() {
		boolean bValue = false;
		landing.search(user.getFirstName());
		switchToDefaultContent();
		landing.switchToBodyFrame();
		Assert.assertNotNull(
				DriverManager.getDriver().findElement(By.cssSelector("a[title=" + user.getFirstName() + "]")));
		click(DriverManager.getDriver().findElement(By.cssSelector("a[title=" + user.getFirstName() + "]")));
		return true;

	}

}
