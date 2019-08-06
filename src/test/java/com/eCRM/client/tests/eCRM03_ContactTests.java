package com.eCRM.client.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eCRM.client.core.CommonUtils;
import com.eCRM.client.core.Config;
import com.eCRM.client.pages.ContactPage;
import com.eCRM.client.pages.LandingPage;
import com.eCRM.client.pages.LogInPage;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class eCRM03_ContactTests {
	private LandingPage landing;
	private ContactPage contact;
	private String valueHolder;

	@BeforeClass(groups = { Config.REGRESSION_TEST })
	public void initClass() {
		landing = new LandingPage();
		contact = new ContactPage();
		valueHolder = null;
	}

	@Stories("eCRM-Specific")
	@Features("Module - Customer Mgmt(New Contact)")
	@Severity(SeverityLevel.CRITICAL)
	@TestCaseId("EFISWCRM-1383")
	@Test(priority = 2001, groups = { Config.REGRESSION_TEST })
	@Description("Add new contact for the customer in the eCRM")
	public void addNewContactTest() throws Exception {

		
		CommonUtils.wait(2);// ensure to load the page
		landing.clickOnContactLink();

		valueHolder = contact.createNewContacts();
	}

	@Stories("eCRM-Specific")
	@Features("Module - Customer Mgmt(New Contact)")
	@Severity(SeverityLevel.CRITICAL)
	@TestCaseId("EFISWCRM-1383")
	@Test(priority = 2002, groups = { Config.REGRESSION_TEST },dependsOnMethods = "addNewContactTest")
	@Description("Contact should get created in eCRM")
	public void verifyNewContactCreated() {
		Assert.assertTrue(contact.isContactCreated());
	}

	@Stories("eCRM-Specific")
	@Features("Module - Customer Mgmt(New Contact)")
	@Severity(SeverityLevel.CRITICAL)
	@TestCaseId("EFISWCRM-1383")
	@Test(priority = 2003, groups = { Config.REGRESSION_TEST },dependsOnMethods = "addNewContactTest")
	@Description("Contact should get added to Customer ")
	public void validateNewContactAddedToCustomer() {
		Assert.assertTrue(contact.isContactVisibleToCustomer(valueHolder));
	}

	@Stories("eCRM-Specific")
	@Features("Module - Customer Mgmt(New Contact)")
	@Severity(SeverityLevel.CRITICAL)
	@TestCaseId("EFISWCRM-1383")
	@Test(priority = 2004, groups = { Config.REGRESSION_TEST },dependsOnMethods = "addNewContactTest")
	@Description("Add multiple contacts to Customer")
	public void addMultipleContact() {
		CommonUtils.wait(2);// ensure to load the page
		landing.clickOnContactLink();
		contact.addAnotherContact(valueHolder);
	}
	
	
	@Stories("eCRM-Specific")
	@Features("Module - Customer Mgmt(New Contact)")
	@Severity(SeverityLevel.CRITICAL)
	@TestCaseId("EFISWCRM-1383")
	@Test(priority = 2005, groups = { Config.REGRESSION_TEST },dependsOnMethods = "addMultipleContact")
	@Description("verify multiple contacts Created in eCRM")
	public void verifyMultipleContactCreated() {
		contact.isMultipleContactCreated(valueHolder);
	}
	
	
	@Stories("eCRM-Specific")
	@Features("Module - Customer Mgmt(New Contact)")
	@Severity(SeverityLevel.CRITICAL)
	@TestCaseId("EFISWCRM-1383")
	@Test(priority = 2006, groups = { Config.REGRESSION_TEST },dependsOnMethods = "verifyMultipleContactCreated")
	@Description("verify multiple contacts Added to Customer")
	public void verifyMultipleContactAddedToCustomer() {
		contact.isMultipleContactAddedToCustomer(valueHolder);
	}
	
	@Stories("eCRM-Specific")
	@Features("Module - Customer Mgmt(New Contact)")
	@Severity(SeverityLevel.CRITICAL)
	@TestCaseId("EFISWCRM-1383")
	@Test(priority = 2007, groups = { Config.REGRESSION_TEST },dependsOnMethods = "verifyMultipleContactCreated")
	@Description("edit contact in eCRM")
	public void editContact() {
		contact.editContact();
	}
	
	@Stories("eCRM-Specific")
	@Features("Module - Customer Mgmt(New Contact)")
	@Severity(SeverityLevel.CRITICAL)
	@TestCaseId("EFISWCRM-1383")
	@Test(priority = 2008, groups = { Config.REGRESSION_TEST },dependsOnMethods = "editContact")
	@Description("verify contact is Edited")
	public void verifyContactIsEdited() {
		Assert.assertTrue(contact.isContactEdited());
	}
	
	@Stories("eCRM-Specific")
	@Features("Module - Customer Mgmt(New Contact)")
	@Severity(SeverityLevel.CRITICAL)
	@TestCaseId("EFISWCRM-1383")
	@Test(priority = 2009, groups = { Config.REGRESSION_TEST },dependsOnMethods="verifyContactIsEdited")
	@Description("verify contact is Edited")
	public void verifyeditedContactisAddedToCustomer() {
		Assert.assertTrue(contact.isEditedContactAdded(valueHolder));
	}
	
	
	

}
