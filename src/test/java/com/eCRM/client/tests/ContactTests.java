package com.eCRM.client.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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

public class ContactTests {
	private LandingPage landing;
	private ContactPage contact;
	private String valueHolder;

	@BeforeClass(groups = { Config.REGRESSION_TEST })
	public void initClass() {
		landing = new LandingPage();
		contact = new ContactPage();
	}

	@Test(groups = { Config.REGRESSION_TEST },priority =2001)
	@Stories("eCRM-Specific")
	@Features("Module - Customer Mgmt(New Contact)")
	@Severity(SeverityLevel.CRITICAL)
	@TestCaseId("EFISWCRM-1383")
	@Description("Add new contact for the customer in the eCRM")
	public void addNewContactTest() throws Exception {
		landing.clickOnContactLink();
		contact.createNewContacts();
		//return valueHolder;
	}

	@Test(groups = { Config.REGRESSION_TEST },priority = 2002)
	@Stories("eCRM-Specific")
	@Features("Module - Customer Mgmt(New Contact)")
	@Severity(SeverityLevel.CRITICAL)
	@TestCaseId("EFISWCRM-1383")
	public void validateNewContactAdded() {
		contact.isContactAdded();
	}

}
