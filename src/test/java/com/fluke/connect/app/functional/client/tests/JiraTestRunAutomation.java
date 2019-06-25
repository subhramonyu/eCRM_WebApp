package com.fluke.connect.app.functional.client.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fluke.connect.app.functional.client.pages.JiraWebPage;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;

public class JiraTestRunAutomation 
{
	private JiraWebPage jiraWebPage;
	
	@BeforeClass(alwaysRun = true, groups = {Config.JIRA_TEST_RUN_AUTOMATION})
	public void setup()
	{
		try
		{
			jiraWebPage = new JiraWebPage();
			jiraWebPage.login(DriverManager.getUserName(), DriverManager.getPassword());
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(alwaysRun = true, groups = {Config.JIRA_TEST_RUN_AUTOMATION})
	public void createTestRun()
	{
		try
		{
			jiraWebPage.createTestRun("3560 FC Condition Monitoring (VIBNOC) (FCCM3560)", "Test Run", "Tests test");
			jiraWebPage.addTestCasesToTestRun("project = FCCM3560 AND issuetype = \"Test Case\" AND labels in (\"195\", \"1290\")");
			jiraWebPage.executeTestCases();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		
	}

}
