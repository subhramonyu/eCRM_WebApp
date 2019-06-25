package com.fluke.connect.app.functional.client.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fluke.connect.app.functional.client.pages.HomePage;
import com.fluke.connect.app.functional.client.pages.WorkOrderPage;
import com.fluke.connect.app.functional.client.pages.WorkOrderSortAndFilterPage;
import com.fluke.connect.app.utils.CommonUtils;

@SuppressWarnings("unused")
public class WorkOrderSortAndFilterTest 
{
	private HomePage homePage;
	private WorkOrderPage workOrderPage;
	private WorkOrderSortAndFilterPage workOrderSortAndFilterPage;
	private boolean testFailureFlag = false;
	
	@BeforeClass(groups = {})
	public void initClass()
	{
		homePage = new HomePage();
		workOrderPage = new WorkOrderPage();
		workOrderSortAndFilterPage = new WorkOrderSortAndFilterPage();
	}
/*	
	@Test(priority = 2, groups = {})
	public void saveScreenshotTest()
	{
		homePage.clickOnMyWorkOrderButton();
		workOrderPage.clickOnFilterButton();
		try 
		{
			testFailureFlag = false;
			if(AppiumFactory.mobileDriverName.equals("iOS"))
			{
				workOrderSortAndFilterPage.saveScreenshot("./VisualTests/Actual/iOS/WorkOrders/Sort And Filter.jpg");
				//CommonUtils.wait(10);
				Assert.assertTrue(VisualComparison.compareImages("./VisualTests/Expected/iOS/WorkOrders/Sort & Filter (Work Order List).jpg", "./VisualTests/Actual/iOS/WorkOrders/Sort And Filter.jpg", "./VisualTests/Deviation/iOS/WorkOrders/Sort And Filter.jpg"));
			}
		}
		catch(Exception e)
		{
			testFailureFlag = true;
			Assert.fail("Exception Detail: "+e);
		}
	}
*/
}
