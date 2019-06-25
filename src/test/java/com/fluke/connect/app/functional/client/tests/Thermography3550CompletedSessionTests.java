package com.fluke.connect.app.functional.client.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fluke.connect.app.functional.client.pages.CompletedSessionPage;
import com.fluke.connect.app.functional.client.pages.MeasurementsHistoryPage;
import com.fluke.connect.app.functional.client.pages.Switcher;
import com.fluke.connect.app.functional.client.pages.Thermography3550CompletedSessionPage;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.Gestures;

public class Thermography3550CompletedSessionTests {
	
	private CompletedSessionPage completedSessionPage;
	private Switcher switcherPage;
	private Gestures gesture;
	private Thermography3550CompletedSessionPage thermography3550CompletedSessionPage;
	private MeasurementsHistoryPage measurementsHistoryPage;

	
	@BeforeClass(alwaysRun = true, groups = {Config.ANDROID_FULL_TESTS, Config.ANDROID_UAT_TESTS,Config.ANDROID_SMOKE_TESTS})
	public void initClass()
	{
		completedSessionPage = new CompletedSessionPage();
		switcherPage = new Switcher();
		gesture = new Gestures();
		thermography3550CompletedSessionPage =new Thermography3550CompletedSessionPage();
		measurementsHistoryPage = new MeasurementsHistoryPage();
	}
	
	@AfterClass(alwaysRun = true, groups = {Config.ANDROID_FULL_TESTS, Config.ANDROID_UAT_TESTS,Config.ANDROID_SMOKE_TESTS})
	public void afterClass()
	{
		Thermography3550CompletedSessionPage.backButton.click();
		CommonUtils.wait(2);
		Thermography3550CompletedSessionPage.backButton.click();
		CommonUtils.wait(2);
	}
	

	@Test (priority = 125001, groups = { Config.ANDROID_UAT_TESTS})
	public void check3550CompletedSession()
	{
		//This test case will check the particular session tile is present or not in completed session list
		try
		{
			switcherPage.switchToMeasurementsPage();
			measurementsHistoryPage.clickOnViewCompletedSessionsLink();
			completedSessionPage.clickOnBackButton();
			switcherPage.switchToMeasurementsPage();
			measurementsHistoryPage.clickOnViewCompletedSessionsLink();
			CommonUtils.wait(2);
			if (DriverManager.getEnvironmentName().equals("PreProduction"))
			{
				gesture.scroll("value", Config.Android_PreProd_TM3550_sessionTime, null, Config.Android_PreProd_TM3550_sessionTime, -300,-45, null, null);
				completedSessionPage.initSessionCellElement(Config.Android_PreProd_TM3550_sessionTime);
				completedSessionPage.getElementInSessionTileStrict(Config.Android_PreProd_TM3550_sessionTime).click();
				Assert.assertEquals(completedSessionPage.getElementVisibleTextInSessionDetailPageStrict(Config.Android_PreProd_TM3550_sessionTime), Config.Android_PreProd_TM3550_sessionTime);
			}
			
			else if(DriverManager.getEnvironmentName().equals("Devolpment"))
			{
				gesture.scroll("value", Config.Android_Dev_TM3550_sessionTime, null, Config.Android_Dev_TM3550_sessionTime, -300,-45, null, null);
				completedSessionPage.initSessionCellElement(Config.Android_Dev_TM3550_sessionTime);
				completedSessionPage.getElementInSessionTileStrict(Config.Android_Dev_TM3550_sessionTime).click();
				Assert.assertEquals(completedSessionPage.getElementVisibleTextInSessionDetailPageStrict(Config.Android_Dev_TM3550_sessionTime), Config.Android_Dev_TM3550_sessionTime);
			}
			
			
			}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	
	@Test (priority = 125002, groups = {Config.ANDROID_FULL_TESTS}) //Config.ANDROID_SMOKE_TESTS
	public void thermography1HourGraphTabCheck()
	{
		//This test case will check the if stale data present in voltage 1h graph tab
		try
		{

			gesture.scroll(null,null, null,"1M",-45,-60, null, null);
			Assert.assertTrue(thermography3550CompletedSessionPage.Thermography_1HTab(),"Measurement is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	
	@Test (priority = 125003, groups = {Config.ANDROID_FULL_TESTS})
	public void thermography1DGraphTabCheck()
	{
		//This test case will check the if stale data present in voltage 1h graph tab
		try
		{

			gesture.scroll(null,null, null,"1M",-45,-60, null, null);
			Assert.assertTrue(thermography3550CompletedSessionPage.Thermography_1DTab(),"Measurement is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 125004, groups = {Config.ANDROID_FULL_TESTS})
	public void thermography1WGraphTabCheck()
	{
		//This test case will check the if stale data present in voltage 1h graph tab
		try
		{

			gesture.scroll(null,null, null,"1M",-45,-60, null, null);
			Assert.assertTrue(thermography3550CompletedSessionPage.Thermography_1WTab(),"Measurement is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	
	@Test (priority = 125005, groups = {Config.ANDROID_FULL_TESTS})
	public void thermography1MGraphTabCheck()
	{
		//This test case will check the if stale data present in voltage 1h graph tab
		try
		{

			gesture.scroll(null,null, null,"1M",-45,-60, null, null);
			Assert.assertTrue(thermography3550CompletedSessionPage.Thermography_1MTab(),"Measurement is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 125006, groups = {Config.ANDROID_FULL_TESTS})
	public void thermographyAllGraphTabCheck()
	{
		//This test case will check the if stale data present in voltage 1h graph tab
		try
		{

			gesture.scroll(null,null, null,"1M",-45,-60, null, null);
			Assert.assertTrue(thermography3550CompletedSessionPage.Thermography_AllTab(),"Measurement is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 125007, groups = {Config.ANDROID_FULL_TESTS})
	public void viewMoreCheck()
	{
		//This test case will check the if stale data present in voltage 1h graph tab
		try
		{

			gesture.scroll(null,null, null,"1M",-45,-60, null, null);
			Assert.assertTrue(thermography3550CompletedSessionPage.Thermography_AllTab(),"Measurement is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	
	

}
