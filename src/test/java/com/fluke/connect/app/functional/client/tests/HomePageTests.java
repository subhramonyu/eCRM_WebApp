package com.fluke.connect.app.functional.client.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fluke.connect.app.functional.client.pages.HomePage;
import com.fluke.connect.app.testdata.FCCM3560;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;

import junit.framework.Assert;

@SuppressWarnings("unused")
public class HomePageTests 
{
	private HomePage homePage;
	private boolean testFailureFlag = false;
	private GestureUtils mGestureUtils;
	
	@BeforeClass(groups = {FCCM3560.DEV_TESTS})
	public void initClass()
	{
		homePage = new HomePage();
		mGestureUtils = new GestureUtils();
	}
	
	@Test
	public void captureMeasurementTest()
	{
		homePage.clickCaptureMeasurementsButton();
		
	}
	
	@Test(priority = 139001, groups = {FCCM3560.DEV_TESTS})
	public void testFC3560NotificationTile() 
	{
 		homePage.tapOnNotificationIcon();
 		//Scenerio 1
		Assert.assertTrue(mGestureUtils.scroll(null, null, null, "UNSATISFACTORY", 0, -100, null, null));
		//Scenerio 2
		Assert.assertTrue(ElementUtils.isDisplayed(1, 1, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, "UNSATISFACTORY", null, null, null, null));
		//Scenerio 3
		Assert.assertTrue(ElementUtils.isDisplayed(1, 1, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, "Vibration Sensor", null, null, null, null));
		//Scenerio 4 and 5 will verify Machine learning alarms notification tile
		//Scenerio 4
		Assert.assertTrue(mGestureUtils.scroll(null, null, null, "Vibration Level Change Alarm", 0, -50, null, null));
		//Scenerio 5
		Assert.assertTrue(ElementUtils.isDisplayed(1, 1, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, "A change in vibration signature may be indicative of a change in health state or a change in operating state while remaining unhealthy", null, null, null, null));
	}
/*	
 * 
	@Test(priority = 1, groups = {"visual_actual_tests"})
	public void workOrdersHomesaveVisualTest()
	{
		try 
		{
			testFailureFlag = false;
			if(AppiumFactory.mobileDriverName.equals("iOS"))
			{
				homePage.saveScreenshot("./VisualTests/Actual/iOS/WorkOrders/Home.jpg");
				//CommonUtils.wait(10);
				Assert.assertTrue(VisualComparison.compareImages("./VisualTests/Expected/iOS/WorkOrders/Home C.jpg", "./VisualTests/Actual/iOS/WorkOrders/Home.jpg", "./VisualTests/Deviation/iOS/WorkOrders/Home.jpg"));
			}
			
		}
		catch(Exception e)
		{
			testFailureFlag = true;
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	*/
	
	@Test(alwaysRun = true, priority = 99, groups = {"adhoc_ctests"})
	public void captureMyWorkOrderCellScreenshot()
	{
		//homePage.captureMyWorkOrderCellScreenshot("./VisualTests/Actual/iOS/WorkOrders/a.jpg");
		//VisualComparison.compareImages("./VisualTests/Expected/iOS/WorkOrders/e.jpg", "./VisualTests/Actual/iOS/WorkOrders/a.jpg", "./VisualTests/Deviation/iOS/WorkOrders/d.jpg");
	}
	
	

}
