package com.eCRM.client.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eCRM.client.core.Config;
import com.eCRM.client.pages.CustomerPage;
import com.eCRM.client.pages.CustomerPage.classificationType;
import com.eCRM.client.pages.HomePage;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.model.SeverityLevel;




@Stories("eCRM-Core")
@Features("Module - Customer Mgmt(New Customer)")

public class eCRM02_CustomerTests {
	private HomePage landing;
	private CustomerPage customer;

	@BeforeClass(groups = { Config.REGRESSION_TEST })
	public void initClass() {
		landing = new HomePage();
		customer = new CustomerPage();
	}
	
	
	
	@TestCaseId("EFISWCRM-1384")
	@Severity(SeverityLevel.CRITICAL)
	@Test(groups = { Config.REGRESSION_TEST }, priority = 1001)
	@Description("Verify new customer can be added from Home page > Ribbon Bar > New Customer hyper link")
	public void addNewCustomerInCRM() throws Exception {
		landing.clickOnNewCustomerLink();
		customer.create(classificationType.CUSTOMER);;
	}

	
	
	
	@Severity(SeverityLevel.CRITICAL)
	@TestCaseId("EFISWCRM-1384")
	@Test(groups = { Config.REGRESSION_TEST }, priority = 1002,dependsOnMethods = "addNewCustomerInCRM")
	@Description("New customer should get added")
	public void validateTheNewCustomerIsCreated() {
		Assert.assertTrue(customer.isCreated(classificationType.CUSTOMER));
	}
	
	
	
	
	@Severity(SeverityLevel.CRITICAL)
	@TestCaseId("EFISWCRM-1384")
	@Test(groups = { Config.REGRESSION_TEST }, priority = 1003,dependsOnMethods = "validateTheNewCustomerIsCreated")
	@Description("Modify the customer in eCRM.")
	public void editNewCustomerinCRM() {
		customer.edit(classificationType.CUSTOMER);
	}
	
	

	
	@Severity(SeverityLevel.CRITICAL)
	@TestCaseId("EFISWCRM-1384")
	@Test(groups = { Config.REGRESSION_TEST }, priority = 1004)
	@Description("Changes should get reflected in eCRM.")
	public void verifyTheEditedCustomerIsReflected() {
		customer.isCreated(classificationType.CUSTOMER);
	}
	
	
	
	
	@Severity(SeverityLevel.CRITICAL)
	@TestCaseId("EFISWCRM-1384")
	@Test(groups = { Config.REGRESSION_TEST }, priority = 1005,dependsOnMethods="verifyTheEditedCustomerIsReflected")
	@Description("delete the customer in eCRM.")
	public void deleteCustomer() {
		customer.delete(classificationType.CUSTOMER);
	}
	
	
	

	@Severity(SeverityLevel.CRITICAL)
	@TestCaseId("EFISWCRM-1384")
	@Test(groups = { Config.REGRESSION_TEST }, priority = 1006)
	@Description("Verify deletion of customer from eCRM")
	public void verifytheCustomerIsRemoved() {
		customer.isDeleted(classificationType.CUSTOMER);
	}
	
	
	
	
	@Severity(SeverityLevel.CRITICAL)
	@TestCaseId("EFISWCRM-1384")
	@Test(groups = { Config.REGRESSION_TEST }, priority = 1007)
	@Description("Verify new prospect can be added from Home page > Ribbon Bar > New Customer hyper link")
	public void addNewProspectInCRM() throws Exception {
		landing.clickOnNewCustomerLink();
		customer.create(classificationType.PROSPECT);;
	}

	
	
	
	@Severity(SeverityLevel.CRITICAL)
	@TestCaseId("EFISWCRM-1384")
	@Test(groups = { Config.REGRESSION_TEST }, priority = 1008)
	@Description("New prospect should get added")
	public void validateTheNewProspectIsCreated() {
		Assert.assertTrue(customer.isCreated(classificationType.PROSPECT));
	}
}
