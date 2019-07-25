package com.eCRM.client.tests;

import javax.xml.ws.FaultAction;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eCRM.client.core.Config;
import com.eCRM.client.pages.CustomerPage;
import com.eCRM.client.pages.CustomerPage.classificationType;
import com.eCRM.client.pages.LandingPage;
import com.eCRM.client.pages.LogInPage;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class CustomerTest {
	private LandingPage landing;
	private CustomerPage customer;

	@BeforeClass(groups = { Config.REGRESSION_TEST })
	public void initClass() {
		landing = new LandingPage();
		customer = new CustomerPage();
	}
	
	
	@Stories("eCRM-Specific")
	@Features("Module - Customer Mgmt(New Customer)")
	@Severity(SeverityLevel.CRITICAL)
	@TestCaseId("EFISWCRM-1384")
	@Test(groups = { Config.REGRESSION_TEST }, priority = 1001)
	@Description("Verify new customer can be added from Home page > Ribbon Bar > New Customer hyper link")
	public void addNewCustomerInCRM() throws Exception {
		landing.clickOnNewCustomerLink();
		customer.create(classificationType.CUSTOMER);;
	}

	
	
	@Stories("eCRM-Specific")
	@Features("Module - Customer Mgmt(New Customer)")
	@Severity(SeverityLevel.CRITICAL)
	@TestCaseId("EFISWCRM-1384")
	@Test(groups = { Config.REGRESSION_TEST }, priority = 1002)
	@Description("New customer should get added")
	public void validateTheNewCustomerIsCreated() {
		Assert.assertTrue(customer.isCreated(classificationType.CUSTOMER));
	}
	
	
	
	@Stories("eCRM-Specific")
	@Features("Module - Customer Mgmt(New Customer)")
	@Severity(SeverityLevel.CRITICAL)
	@TestCaseId("EFISWCRM-1384")
	@Test(groups = { Config.REGRESSION_TEST }, priority = 1003)
	@Description("Modify the customer in eCRM.")
	public void editNewCustomerinCRM() {
		customer.edit(classificationType.CUSTOMER);
	}
	
	
	
	@Stories("eCRM-Specific")
	@Features("Module - Customer Mgmt(New Customer)")
	@Severity(SeverityLevel.CRITICAL)
	@TestCaseId("EFISWCRM-1384")
	@Test(groups = { Config.REGRESSION_TEST }, priority = 1004)
	@Description("Changes should get reflected in eCRM.")
	public void verifyTheEditedCustomerIsReflected() {
		customer.isCreated(classificationType.CUSTOMER);
	}
	
	
	
	@Stories("eCRM-Specific")
	@Features("Module - Customer Mgmt(New Customer)")
	@Severity(SeverityLevel.CRITICAL)
	@TestCaseId("EFISWCRM-1384")
	@Test(groups = { Config.REGRESSION_TEST }, priority = 1005)
	@Description("delete the customer in eCRM.")
	public void deleteCustomer() {
		customer.delete(classificationType.CUSTOMER);
	}
	
	
	

	@Stories("eCRM-Specific")
	@Features("Module - Customer Mgmt(New Customer)")
	@Severity(SeverityLevel.CRITICAL)
	@TestCaseId("EFISWCRM-1384")
	@Test(groups = { Config.REGRESSION_TEST }, priority = 1006)
	@Description("Verify deletion of customer from eCRM")
	public void verifytheCustomerIsRemoved() {
		customer.isDeleted(classificationType.CUSTOMER);
	}
	
	
	
	@Stories("eCRM-Specific")
	@Features("Module - Customer Mgmt(New Customer)")
	@Severity(SeverityLevel.CRITICAL)
	@TestCaseId("EFISWCRM-1384")
	@Test(groups = { Config.REGRESSION_TEST }, priority = 1007)
	@Description("Verify new prospect can be added from Home page > Ribbon Bar > New Customer hyper link")
	public void addNewProspectInCRM() throws Exception {
		landing.clickOnNewCustomerLink();
		customer.create(classificationType.PROSPECT);;
	}

	
	
	@Stories("eCRM-Specific")
	@Features("Module - Customer Mgmt(New Customer)")
	@Severity(SeverityLevel.CRITICAL)
	@TestCaseId("EFISWCRM-1384")
	@Test(groups = { Config.REGRESSION_TEST }, priority = 1008)
	@Description("New prospect should get added")
	public void validateTheNewProspectIsCreated() {
		Assert.assertTrue(customer.isCreated(classificationType.PROSPECT));
	}
}
