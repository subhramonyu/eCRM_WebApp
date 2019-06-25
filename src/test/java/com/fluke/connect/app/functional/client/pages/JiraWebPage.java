package com.fluke.connect.app.functional.client.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;

public class JiraWebPage 
{
	@FindBy( how = How.CSS, using = ".login-link")
	private WebElement loginLink;
	
	@FindBy( how = How.CSS, using = "#username")
	private WebElement userNameTextField;
	
	@FindBy( how = How.CSS, using = "#login-submit")
	private WebElement continueButton;
	
	@FindBy( how = How.CSS, using = "#password")
	private WebElement passwordTextField;
	
	@FindBy( how = How.CSS, using = "a[title = 'QMetry']")
	private WebElement qmetryLink;
	
	@FindBy( how = How.CSS, using = "a[title = 'Create Test Run']")
	private WebElement createTestRunLink;
	
	@FindBy( how = How.CSS, using = "#create_link")
	private WebElement createLink;
	
	@FindBy( how = How.CSS, using = "#project-field")
	private WebElement projectNameTextField;
	
	@FindBy( how = How.CSS, using = "#issuetype-field")
	private WebElement issueTypeNameTextField;
	
	@FindBy( how = How.CSS, using = "#create-issue-submit")
	private WebElement createButton;
	
	@FindBy( how = How.CSS, using = "#issue-create-submit")
	private WebElement nextButton;
	
	@FindBy( how = How.CSS, using = "#summary")
	private WebElement summaryTextField;
	
	@FindBy( how = How.CSS, using = "#customfield_10700-6")
	private WebElement automatedYesRadioButton;
	
	@FindBy( how = How.CSS, using = "#customfield_15500-4")
	private WebElement deploymentiOSCheckBox;
	
	@FindBy( how = How.CSS, using = "a[title='Clone Test Run']")
	private WebElement cloneTestRunButton;
	
	@FindBy( how = How.CSS, using = "iframe[id *= 'com.infostretch.QmetryTestManager__test-run-panel__']")
	private WebElement addFrame;
	
	@FindBy( how = How.CSS, using = "button[aria-controls='dropdown2-add-items']")
	private WebElement addButton;
	
	@FindBy( how = How.CSS, using = "a[data-type='testCase']")
	private WebElement testCaseButton;
	
	@FindBy( how = How.CSS, using = "iframe[id *= 'com.infostretch.QmetryTestManager__test-case-add-dialog__']")
	private WebElement addTestCasesDialogFrame;
	
	@FindBy( how = How.CSS, using = ".brksummary")
	private WebElement defaultTestCases;
	
	@FindBy( how = How.CSS, using = ".advanced")
	private WebElement advancedQueryLink;
	
	@FindBy( how = How.CSS, using = ".advanced-search")
	private WebElement advancedSearchTextField;
	
	@FindBy( how = How.CSS, using = ".checkAcross")
	private WebElement checkAllIsues;
	
	@FindBy( how = How.CSS, using = "#test_authoring")
	private WebElement submitButton;
	
	@FindBy( how = How.CSS, using = "#showTestRun")
	private WebElement executeButton;
	
	@FindBy( how = How.CSS, using = "iframe[id *= 'com.infostretch.QmetryTestManager__qmetry-execute-test-run__']")
	private WebElement testRunFrame;
	
	@FindBy( how = How.CSS, using = ".bulkActions")
	private WebElement bulkActionsButton;
	
	@FindBy( how = How.CSS, using = ".bulkExecutionbtn")
	private WebElement bulkExecutionButton;
	
	@FindBy( how = How.CSS, using = ".tcCheckAcross")
	private WebElement selectAllIsues;
	
	@FindBy( how = How.CSS, using = ".executionResult")
	private WebElement executionResult;
	
	@FindBy( how = How.CSS, using = "iframe[id *= 'com.infostretch.QmetryTestManager__bulkUpdate-data-execution-dialog__']")
	private WebElement bulkUpdateFrame;
	
	@FindBy( how = How.CSS, using = "#bulk_update")
	private WebElement bulkUpdateButton;
	
	@FindBy( how = How.CSS, using = "span[data-id='1307']")
	private WebElement testStatusButton;
	
	@FindBy( how = How.XPATH, using = "//td[contains(text(), 'There are no Test Cases/Scenarios or Stories added yet')]")
	private WebElement noTestCaseStatusText;
	
	@FindBy( how = How.CSS, using = ".bulkCheckBox ")
	private WebElement bulkUpdateCheckBox;
	
	private Select select;
	
	public JiraWebPage()
	{
		CommonUtils.initElements(this);
	}
	
	public void login(String userName, String password) throws Exception
	{
		ElementUtils.isDisplayed(120, 1, loginLink);
		ElementUtils.reliableClick(10, 1, loginLink, userNameTextField, 6);
		ElementUtils.sendKeys(10, 1, userNameTextField, userName);
		ElementUtils.clickIfDisplayedAndEnabled(30, 1, continueButton);
		ElementUtils.sendKeys(60, 1, passwordTextField, password);
		ElementUtils.clickIfDisplayedAndEnabled(30, 1, continueButton);
	}
	
	public void createTestRun(String projectName, String issueType, String issueName) throws Exception
	{
		ElementUtils.isDisplayed(120, 1, projectNameTextField);
		ElementUtils.reliableSendKeys(10, 1, projectNameTextField, projectName, 6);
		ElementUtils.reliableSendKeys(10, 1, issueTypeNameTextField, issueType, 6);
		ElementUtils.clickIfDisplayedAndEnabled(30, 1, nextButton);
		ElementUtils.sendKeys(120, 1, summaryTextField, issueName);
		ElementUtils.clickIfDisplayedAndEnabled(30, 1, automatedYesRadioButton);
		ElementUtils.clickIfDisplayedAndEnabled(30, 1, deploymentiOSCheckBox);
		ElementUtils.clickIfDisplayedAndEnabled(30, 1, nextButton);
	}
	
	public void addTestCasesToTestRun(String queryToSelectIssues) throws Exception
	{
		ElementUtils.isDisplayed(120, 1, addFrame);
		DriverManager.getDriver().switchTo().frame(addFrame);
		ElementUtils.isDisplayed(30, 2, noTestCaseStatusText);
		ElementUtils.clickIfDisplayedAndEnabled(30, 1, addButton);
		ElementUtils.clickIfDisplayedAndEnabled(30, 1, testCaseButton);
		DriverManager.getDriver().switchTo().defaultContent();
		ElementUtils.isDisplayed(120, 1, addTestCasesDialogFrame);
		DriverManager.getDriver().switchTo().frame(addTestCasesDialogFrame);
		ElementUtils.isDisplayed(30, 1, defaultTestCases);
		ElementUtils.clickIfDisplayedAndEnabled(30, 1, advancedQueryLink);
		advancedSearchTextField.sendKeys(queryToSelectIssues, Keys.ENTER);
		advancedSearchTextField.sendKeys(Keys.ENTER);
		ElementUtils.clickIfDisplayedAndEnabled(30, 1, checkAllIsues);
		ElementUtils.clickIfDisplayedAndEnabled(30, 1, submitButton);
	}
	
	public void executeTestCases() throws Exception
	{
		DriverManager.getDriver().switchTo().defaultContent();
		ElementUtils.isDisplayed(120, 1, addFrame);
		DriverManager.getDriver().switchTo().frame(addFrame);
		ElementUtils.clickIfDisplayedAndEnabled(30, 1, executeButton);
		DriverManager.getDriver().switchTo().defaultContent();
		ElementUtils.isDisplayed(120, 1, testRunFrame);
		DriverManager.getDriver().switchTo().frame(testRunFrame);
		ElementUtils.isDisplayed(30, 2, testStatusButton);
		ElementUtils.clickIfDisplayedAndEnabled(30, 1, bulkActionsButton);
		ElementUtils.clickIfDisplayedAndEnabled(30, 1, bulkExecutionButton);
		ElementUtils.clickIfDisplayedAndEnabled(30, 1, selectAllIsues);
		select = new Select(executionResult);
		select.selectByVisibleText("Pass");
		DriverManager.getDriver().switchTo().defaultContent();
		ElementUtils.isDisplayed(120, 1, bulkUpdateFrame);
		DriverManager.getDriver().switchTo().frame(bulkUpdateFrame);
		ElementUtils.isDisplayed(30, 1, bulkUpdateCheckBox);
		ElementUtils.clickIfDisplayedAndEnabled(30, 3, bulkUpdateButton);
	}
	
}
