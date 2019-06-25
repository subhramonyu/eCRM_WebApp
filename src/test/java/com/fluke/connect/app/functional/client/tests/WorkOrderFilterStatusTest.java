package com.fluke.connect.app.functional.client.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fluke.connect.app.functional.client.pages.WorkOrderFilterStatusPage;
import com.fluke.connect.app.functional.client.pages.WorkOrderSortAndFilterPage;
import com.fluke.connect.app.utils.CommonUtils;


@SuppressWarnings("unused")
public class WorkOrderFilterStatusTest 
{
	private WorkOrderSortAndFilterPage workOrderSortAndFilterPage;
	private WorkOrderFilterStatusPage workOrderFilterStatusPage;
	private boolean testFailureFlag = false;
	
	@BeforeClass(groups = {})
	public void initClass()
	{
		workOrderSortAndFilterPage = new WorkOrderSortAndFilterPage();
		workOrderFilterStatusPage = new WorkOrderFilterStatusPage();
	}
	
/*	@Test(priority = 3, groups = {})
	public void saveScreenshotTest()
	{
		workOrderSortAndFilterPage.clickOnFilterStatusButton();
		try 
		{
			testFailureFlag = false;
			if(AppiumFactory.mobileDriverName.equals("iOS"))
			{
				workOrderFilterStatusPage.saveScreenshot("./VisualTests/Actual/iOS/WorkOrders/Filter Status.jpg");
				//CommonUtils.wait(10);
				Assert.assertTrue(VisualComparison.compareImages("./VisualTests/Expected/iOS/WorkOrders/Filter Status.jpg", "./VisualTests/Actual/iOS/WorkOrders/Filter Status.jpg", "./VisualTests/Deviation/iOS/WorkOrders/Filter Status.jpg"));
			}
		}
		catch(Exception e)
		{
			testFailureFlag = true;
			Assert.fail("Exception Detail: "+e);
		}
		if(AppiumFactory.mobileDriverName.equals("iOS"))
		{
			
		}
	}
	*/
	@AfterClass(groups = {})
	public void tearDown()
	{
		workOrderFilterStatusPage.clickBackButton();
		workOrderFilterStatusPage.clickBackButton();
	}

}
