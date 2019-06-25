package com.fluke.connect.app.functional.client.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fluke.connect.app.functional.client.pages.Switcher;
import com.fluke.connect.app.functional.client.pages.WorkOrderPage;
import com.fluke.connect.app.testdata.SignIn;
import com.fluke.connect.app.testdata.SignIn.FeatureList;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DateAndTimeUtils;
import com.fluke.connect.app.utils.DriverFactory;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.IOSUtils;
import com.fluke.connect.app.utils.TestNGUtils;

public class WorkOrderPageTests {
	private WorkOrderPage workOrderPage;
	private Switcher switcher;
	public String measurementsWorkOrderDescription = "Work Order Description";

	@BeforeClass(groups = { Config.WORK_ORDER_UAT, Config.WORK_ORDER_TESTS, Config.IOS_FULL_TESTS,
			Config.IOS_SMOKE_TESTS, Config.ANDROID_SMOKE_TESTS, Config.ANDROID_UAT_TESTS, Config.IOS_WO_SMOKE_EXT_TESTS,
			Config.WO_WEB_SMOKE_EXT_TESTS, Config.WORK_ORDER_WEB_TESTS, Config.IOS_SMOKE_TESTS,
			Config.ANDROID_WO_SMOKE_EXT_TESTS, Config.ANDROID_UAT_TESTS, Config.ANDROID_SMOKE_EXTENDED_TESTS,
			Config.WORK_ORDER_IOS_TESTS })

	public void initClass() throws Exception {
		if (!DriverManager.isSmokeSuite()) {
			DriverManager.getSignIn().signIn(SignIn.getUID(FeatureList.WORKORDERS),
					SignIn.getPWD(FeatureList.WORKORDERS));
			DriverManager.getSignIn().handleAfterSignInAlertsOtherUser();
		}
		workOrderPage = new WorkOrderPage();
		// CommonUtils.wait(05);
		switcher = new Switcher();
		
		switcher.switchToWorkOrdersPage();
		measurementsWorkOrderDescription = "Created in " + DriverManager.getDriverName() + " at "
				+ DateAndTimeUtils.getCurrentTimeStamp();
	}

	/******** This test case creates a work order without any detail ********/

	@Test(priority = 37300, groups = { Config.IOS_FULL_TESTS, Config.IOS_SMOKE_TESTS, Config.ANDROID_WO_SMOKE_EXT_TESTS,
			Config.ANDROID_FULL_TESTS, Config.WEB_SMOKE_TESTS, Config.WEB_FULL_TESTS,
			Config.ANDROID_SMOKE_EXTENDED_TESTS })
	public void addWorkOrderWithoutMeasurementsTest() {
		try {
			workOrderPage.addWorkOrder("Measurements Work Order", measurementsWorkOrderDescription);
		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	/*
	 * This test case just creates a work order with name and description
	 */

	@Test(priority = 37301, groups = { Config.WORK_ORDER_TESTS, Config.WORK_ORDER_UAT, Config.IOS_WO_SMOKE_EXT_TESTS,
			Config.WO_WEB_SMOKE_EXT_TESTS, Config.ANDROID_WO_SMOKE_EXT_TESTS, Config.WORK_ORDER_WEB_TESTS,
			Config.ANDROID_SMOKE_EXTENDED_TESTS })

	public void addWorkOrderAllMeasurementsTest() {
		try {
			workOrderPage.addWorkOrderAll("Measurements Work Order", measurementsWorkOrderDescription);
		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	/*********
	 * This test case creates sets work type
	 *******/

	@Test(priority = 37302, groups = { Config.WORK_ORDER_TESTS, Config.WORK_ORDER_UAT, Config.IOS_WO_SMOKE_EXT_TESTS,
			Config.ANDROID_WO_SMOKE_EXT_TESTS, Config.ANDROID_SMOKE_EXTENDED_TESTS })

	public void addWorkOrderWithSetWorkTypeTest() {
		try {
			workOrderPage.addWorkOrderWithSetWorkType(measurementsWorkOrderDescription);
		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	/*********
	 * This test case creates a work order, assigns assignee, sets work
	 * type,sets priority and schedules work order
	 *******/

	@Test(alwaysRun = true, priority = 37303, groups = { Config.WORK_ORDER_TESTS, Config.WORK_ORDER_UAT,
			Config.IOS_WO_SMOKE_EXT_TESTS, Config.ANDROID_WO_SMOKE_EXT_TESTS, Config.ANDROID_SMOKE_EXTENDED_TESTS })

	public void addWorkOrderWithSetPriorityTest() {
		try {
			workOrderPage.addWorkOrderWithSetPriority(measurementsWorkOrderDescription);
		} catch (Throwable e) {
			workOrderPage.clickOnBackBarButton();
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	/*********
	 * This test case creates a work order, assigns assignee
	 *******/

	@Test(priority = 37304, groups = { Config.WORK_ORDER_TESTS, Config.WORK_ORDER_UAT, Config.IOS_WO_SMOKE_EXT_TESTS,
			Config.ANDROID_WO_SMOKE_EXT_TESTS, Config.ANDROID_SMOKE_EXTENDED_TESTS })

	public void addWorkOrderWithAssignAssigneeTest() {
		try {
			workOrderPage.addWorkOrderWithAssignAssignee(measurementsWorkOrderDescription);
		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	/*********
	 * This test case creates a work order, assigns assignee, sets work
	 * type,sets priority and schedules work order
	 *******/

	@Test(alwaysRun = true, priority = 37305, groups = { Config.WORK_ORDER_TESTS, Config.WORK_ORDER_UAT,
			Config.IOS_WO_SMOKE_EXT_TESTS, Config.ANDROID_WO_SMOKE_EXT_TESTS, Config.ANDROID_SMOKE_EXTENDED_TESTS })

	public void addWorkOrderAndScheduleWoTest() {
		try {
			workOrderPage.addWorkOrderAndScheduleWo(measurementsWorkOrderDescription);
		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	// @Test(alwaysRun = true, priority = 37306, groups = {
	// Config.WORK_ORDER_TESTS })
	public void verifyScheduleWoTest() throws Exception {
		Assert.assertTrue(workOrderPage.isScheduleWoTest(measurementsWorkOrderDescription));
	}

	/****** This test case sorts the work order ******/

	@Test(alwaysRun = true, priority = 37307, groups = { Config.WORK_ORDER_TESTS, Config.WORK_ORDER_IOS_TESTS }) // ,
	// Config.WORK_ORDER_WEB_TESTS
	public void measurementsWorkOrderSortTest() {
		try {
			workOrderPage.sortWorkOrder();
		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail(e.getMessage());

		}
	}

	/******* This test case filters the work order by Priority *******/

	@Test(alwaysRun = true, priority = 37308, groups = { Config.WORK_ORDER_TESTS, Config.WORK_ORDER_IOS_TESTS }) // Config.WORK_ORDER_WEB_TESTS,
	public void measurementsWorkOrderPriorityFilterTest() {
		try {

			workOrderPage.filterWorkOrderByPriority();

		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	// @Test(alwaysRun = true, priority = 37309, groups = {
	// Config.WORK_ORDER_TESTS })
	public void verifySetPriorityTest() throws Exception {
		Assert.assertTrue(workOrderPage.isSetPriorityTest(measurementsWorkOrderDescription));
	}

	/******* This test case filters the work order by Status *******/

	@Test(alwaysRun = true, priority = 37310, groups = { Config.WORK_ORDER_TESTS, Config.WORK_ORDER_IOS_TESTS }) // Config.WORK_ORDER_WEB_TESTS
																													// ,
	public void measurementsWorkOrderStatusFilterTest() {
		try {

			workOrderPage.filterWorkOrderByStatus();

		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	/******* This test case filters the work order by WorkType *******/

	@Test(alwaysRun = true, priority = 37311, groups = { Config.WORK_ORDER_TESTS, Config.WORK_ORDER_IOS_TESTS })
	public void measurementsWorkOrderWorkTypeFilterTest() {
		try {

			workOrderPage.filterWorkOrderByWorkType();

		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	// @Test(alwaysRun = true, priority = 37312, groups = {
	// Config.WORK_ORDER_TESTS })
	public void verifySetWorkTypeTest() throws Exception {
		Assert.assertTrue(workOrderPage.isSetWorkTypeTest(measurementsWorkOrderDescription));
	}

	/******* This test case searches the work order *******/

	@Test(alwaysRun = true, priority = 37313, groups = { Config.WORK_ORDER_TESTS, Config.WORK_ORDER_WEB_TESTS,
			Config.WORK_ORDER_IOS_TESTS })
	public void measurementsWorkOrderSearchTest() {
		try {
			workOrderPage.searchWorkOrder("Measurements Work Order");
		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	/****** This test case creates a duplicate work order ******/

	@Test(alwaysRun = true, priority = 37314, groups = { Config.WORK_ORDER_TESTS, Config.IOS_WO_SMOKE_EXT_TESTS,
			Config.ANDROID_WO_SMOKE_EXT_TESTS, Config.WORK_ORDER_WEB_TESTS, 
			Config.WORK_ORDER_IOS_TESTS}) //Config.ANDROID_SMOKE_EXTENDED_TESTS,

	public void measurementDuplicateFirstWorkOrderTest() {
		try {
			workOrderPage.measurementDuplicateFirstWorkOrder(measurementsWorkOrderDescription);
		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(alwaysRun = true, priority = 37315, groups = { Config.WORK_ORDER_TESTS, Config.IOS_WO_SMOKE_EXT_TESTS,
			Config.ANDROID_WO_SMOKE_EXT_TESTS, Config.WORK_ORDER_WEB_TESTS, Config.WORK_ORDER_IOS_TESTS }) // ,
																											// Config.ANDROID_SMOKE_EXTENDED_TESTS

	public void verifyMeasurementDuplicateFirstWorkOrderTest() {
		try {
			Assert.assertTrue(workOrderPage.isWorkOrderDuplicated(measurementsWorkOrderDescription));
		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	/****** This test case deletes first work order ******/

	@Test(alwaysRun = true, priority = 37316, groups = { Config.IOS_SMOKE_TESTS })
	public void measurementsWorkOrderDeleteTest() {
		try {
			workOrderPage.deleteFirstWorkOrder();
			Assert.assertFalse(workOrderPage.isWorkOrderDeleted(measurementsWorkOrderDescription));
		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	/*******
	 * This test case is applicable only for mobile. It verifies the open work
	 * order
	 ********/

	@Test(alwaysRun = true, priority = 37317, groups = { Config.WORK_ORDER_TESTS, Config.WORK_ORDER_IOS_TESTS })
	public void verifyOpenWorkOrderOnHomeScreenTest() {
		try {
			Assert.assertTrue(workOrderPage.isAssignedWorkOrder());
		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	/*******
	 * This test case is applicable only for mobile. It verifies the in progress
	 * work order
	 ********/

	@Test(alwaysRun = true, priority = 37318, groups = { Config.WORK_ORDER_TESTS, Config.WORK_ORDER_IOS_TESTS })
	public void verifyInProgressWorkOrderOnHomeScreenTest() {
		try {
			Assert.assertTrue(workOrderPage.isAssignedWorkOrder());

		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	/*******
	 * This test case is applicable only for mobile. It verifies the completed
	 * work order
	 ********/

	@Test(alwaysRun = true, priority = 37319, groups = { Config.WORK_ORDER_TESTS, Config.WORK_ORDER_IOS_TESTS })
	public void verifyCompletedWorkOrderOnHomeScreenTest() {
		try {
			Assert.assertTrue(workOrderPage.isAssignedWorkOrder());

		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	/*******
	 * This test case create manual measurement
	 ********/

	@Test(alwaysRun = true, priority = 37320, groups = { Config.WORK_ORDER_TESTS, Config.IOS_WO_SMOKE_EXT_TESTS,
			Config.ANDROID_WO_SMOKE_EXT_TESTS, Config.ANDROID_SMOKE_EXTENDED_TESTS, Config.WORK_ORDER_IOS_TESTS })
	public void addManualMeasurementTest() {
		try {

			if ((DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
					|| (DriverManager.getDriverName().equals(Config.IOS_DRIVER))) {
				workOrderPage.addManualMeasurement(measurementsWorkOrderDescription);
			}
		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(alwaysRun = true, priority = 37321, groups = { Config.WORK_ORDER_TESTS, Config.IOS_WO_SMOKE_EXT_TESTS,
			Config.ANDROID_WO_SMOKE_EXT_TESTS, Config.ANDROID_SMOKE_EXTENDED_TESTS, Config.WORK_ORDER_IOS_TESTS })
	public void verifyAddManualMeasurementTest() {
		try {

			if ((DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
					|| (DriverManager.getDriverName().equals(Config.IOS_DRIVER))) {
				Assert.assertTrue(workOrderPage.isManualMeasurementAdded(measurementsWorkOrderDescription));
			}
		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	/*******
	 * This test case is verifies the email functionality of work order
	 ********/

	@Test(alwaysRun = true, priority = 37322, groups = { Config.WORK_ORDER_TESTS, Config.IOS_WO_SMOKE_EXT_TESTS,
			Config.ANDROID_WO_SMOKE_EXT_TESTS, Config.ANDROID_SMOKE_EXTENDED_TESTS, Config.WORK_ORDER_IOS_TESTS })

	public void shareMeasurementInWorkOrderTest() {
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			try {
				workOrderPage.measurementMenuWhenMeasurementIsPresent(measurementsWorkOrderDescription);
				workOrderPage.measurementOperationsOnWorkOrder("Share");
			} catch (Throwable e) {
				e.printStackTrace();
				Assert.fail(e.getMessage());
			}
		}
	}

	/******* This test case adds measurement to work order ********/

	@Test(alwaysRun = true, priority = 37323, groups = { Config.WORK_ORDER_TESTS, Config.WORK_ORDER_IOS_TESTS })

	public void addMeasurementToWorkOrderTest() {
		if ((DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				|| (DriverManager.getDriverName().equals(Config.IOS_DRIVER))) {
			try {

				workOrderPage.measurementMenuWhenMeasurementIsPresent(measurementsWorkOrderDescription);
				workOrderPage.measurementOperationsOnWorkOrder("Add");
			}

			catch (Throwable e) {
				e.printStackTrace();
				Assert.fail(e.getMessage());
			}
		}
	}

	/******* This test case deletes measurement from work order ********/

	@Test(alwaysRun = true, priority = 37324, groups = { Config.WORK_ORDER_TESTS, Config.IOS_WO_SMOKE_EXT_TESTS,
			Config.ANDROID_WO_SMOKE_EXT_TESTS, Config.ANDROID_SMOKE_EXTENDED_TESTS, Config.WORK_ORDER_IOS_TESTS })

	public void deleteMeasurementFromWorkOrderTest() {
		if ((DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				|| (DriverManager.getDriverName().equals(Config.IOS_DRIVER))) {
			try {
				workOrderPage.measurementMenuWhenMeasurementIsPresent(measurementsWorkOrderDescription);
				workOrderPage.measurementOperationsOnWorkOrder("Delete");
			} catch (Throwable e) {
				e.printStackTrace();
				Assert.fail(e.getMessage());
			}
		}
	}

	/******* This test case views saved data measurement to work order ********/

	@Test(alwaysRun = true, priority = 37325, groups = { Config.WORK_ORDER_TESTS, Config.WORK_ORDER_IOS_TESTS })
	public void viewActivityStreamAndNotesTest() {
		try {
			if ((DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
					|| (DriverManager.getDriverName().equals(Config.IOS_DRIVER))) {
				workOrderPage.viewActivityStreamAndNotes(measurementsWorkOrderDescription);
			}

		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	/****** This test case adds work order to measurement ******/

	@Test(alwaysRun = true, priority = 37326, groups = { Config.WORK_ORDER_TESTS, Config.WORK_ORDER_IOS_TESTS })
	public void addWorkOrderToMeasurementTest() {
		try {
			if ((DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
					|| (DriverManager.getDriverName().equals(Config.IOS_DRIVER))) {
				workOrderPage.addWorkOrderToMeasurement();
			}
		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	/***
	 * web test cases start from here-----
	 */

	/*********
	 * This test case creates a work order, from overview page in web
	 *******/

	@Test(alwaysRun = true, priority = 37327, groups = { Config.WORK_ORDER_WEB_TESTS })
	public void createWorkOrderFromOverviewPageTest() {
		try {
			if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
				workOrderPage.createWorkOrderFromOverviewPage("Measurements Work Order Overview Page - Web ",
						measurementsWorkOrderDescription);
			}
		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	/***** This test case verifies the open work order in web ******/

	@Test(alwaysRun = true, priority = 37328, groups = { Config.WORK_ORDER_WEB_TESTS })
	public void verifyOpenWorkOrderStatusTest() {
		try {
			if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
				Assert.assertTrue(workOrderPage.isWorkOrderCount(0));
			}

		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	/****** This test case verifies the in progress work order in web ******/

	@Test(alwaysRun = true, priority = 37329, groups = { Config.WORK_ORDER_WEB_TESTS })
	public void verifyInProgressWorkOrderStatusTest() {
		try {
			if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
				Assert.assertTrue(workOrderPage.isWorkOrderCount(1));
			}
		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	/******* This test case verifies complete work order in web *******/
	@Test(alwaysRun = true, priority = 37330, groups = { Config.WORK_ORDER_WEB_TESTS })
	public void verifyCompletedWorkOrderStatusTest() {
		try {
			if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
				// workOrderPage.verifyCompletedWorkOrderInWeb();
				Assert.assertTrue(workOrderPage.isWorkOrderCount(2));
			}
		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	/******* This test case verifies closed work order in web ********/
	@Test(alwaysRun = true, priority = 37331, groups = { Config.WORK_ORDER_WEB_TESTS })
	public void verifyClosedWorkOrderStatusTest() {
		try {
			if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
				// workOrderPage.verifyClosedWorkOrderInWeb();
				Assert.assertTrue(workOrderPage.isWorkOrderCount(3));
			}
		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	/********** Add asset from web page ******/
	@Test(alwaysRun = true, priority = 37332, groups = { Config.WORK_ORDER_WEB_TESTS })

	public void createAssetInWorkOrderTest() {
		try {
			workOrderPage.createAssetInWorkOrder(measurementsWorkOrderDescription);

		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(alwaysRun = true, priority = 37333, groups = { Config.WORK_ORDER_WEB_TESTS })

	public void createTestPointInAssetTest() {
		try {
			workOrderPage.createTestPointInAsset();

		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	/********** this test case is applicable only for web ******/

	@Test(alwaysRun = true, priority = 37334, groups = { Config.WORK_ORDER_WEB_TESTS })

	public void addCreatedTestPointToWorkOrderSavedDataTest() {
		try {
			workOrderPage.addCreatedTestPointToWorkOrderSavedData(measurementsWorkOrderDescription);
		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	/********** this test case is applicable only for web ******/

	// @Test(alwaysRun = true, priority = 37335, groups = {
	// Config.WORK_ORDER_WEB_TESTS })
	public void verifySavedDataTest() {
		try {
			workOrderPage.verifySavedData(measurementsWorkOrderDescription);

		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	/******
	 * This test case verifies the user notification about the assigned work
	 * order
	 * 
	 * commenting the test case as no notification for wo-date 14th feb
	 *******/

	// @Test(alwaysRun = true, priority = 37340, groups = {
	// Config.WORK_ORDER_TESTS ,Config.WORK_ORDER_IOS_TESTS })
	public void verifyUserNotificationTest() {
		try {
			workOrderPage.verifyUserNotification(measurementsWorkOrderDescription);
			workOrderPage.isNotificationDisplayed(measurementsWorkOrderDescription);
		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	/****** This test case adds work order to measurement ******/

	// @Test(alwaysRun = true, priority = 37341, groups = {
	// Config.WORK_ORDER_TESTS ,Config.WORK_ORDER_IOS_TESTS })
	public void deleteNotificationTest() {
		try {
			workOrderPage.deleteNotification();
		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	/******* this test case updates the work order ******/

	@Test(alwaysRun = true, priority = 37342, groups = { Config.WORK_ORDER_TESTS, Config.IOS_WO_SMOKE_EXT_TESTS,
			Config.WORK_ORDER_IOS_TESTS, Config.WORK_ORDER_WEB_TESTS }) // Config.ANDROID_WO_SMOKE_EXT_TESTS,

	public void measurementsWorkOrderUpdateTest() {
		try {
			workOrderPage.updateWorkOrder(measurementsWorkOrderDescription);
			workOrderPage.isWorkOrderUpdated(measurementsWorkOrderDescription);

		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(alwaysRun = true, priority = 37343, groups = { Config.WORK_ORDER_TESTS, Config.IOS_WO_SMOKE_EXT_TESTS,
			Config.WORK_ORDER_IOS_TESTS, Config.WORK_ORDER_WEB_TESTS }) // Config.ANDROID_WO_SMOKE_EXT_TESTS,

	public void verifyMeasurementsWorkOrderUpdateTest() {
		try {
			workOrderPage.isWorkOrderUpdated(measurementsWorkOrderDescription);

		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	/*
	 * Delete created asset in web
	 * 
	 */

	@Test(alwaysRun = true, priority = 37344, groups = { Config.WORK_ORDER_WEB_TESTS })

	public void deleteAssetInWorkOrderTest() {
		try {
			workOrderPage.deleteAssetInWorkOrder(measurementsWorkOrderDescription);
		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(alwaysRun = true, priority = 37345, groups = { Config.WORK_ORDER_WEB_TESTS })

	public void verifyDeleteAssetInWorkOrderTest() {
		try {
			workOrderPage.isDeleteAssetInWorkOrder(measurementsWorkOrderDescription);

		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	/****** This test case deletes created work order *****/

	@Test(alwaysRun = true, priority = 37346, groups = { Config.WORK_ORDER_TESTS, Config.IOS_WO_SMOKE_EXT_TESTS,
			Config.WORK_ORDER_UAT, Config.WO_WEB_SMOKE_EXT_TESTS, Config.ANDROID_WO_SMOKE_EXT_TESTS,
			Config.ANDROID_SMOKE_EXTENDED_TESTS, Config.WORK_ORDER_WEB_TESTS, Config.WORK_ORDER_IOS_TESTS })

	public void measurementsDeleteWorkOrderTest() {
		try {
			workOrderPage.deleteWorkOrder(measurementsWorkOrderDescription);
		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(alwaysRun = true, priority = 37347, groups = { Config.WORK_ORDER_TESTS, Config.IOS_WO_SMOKE_EXT_TESTS,
			Config.WORK_ORDER_UAT, Config.WO_WEB_SMOKE_EXT_TESTS, Config.ANDROID_WO_SMOKE_EXT_TESTS,
			Config.ANDROID_SMOKE_EXTENDED_TESTS, Config.WORK_ORDER_WEB_TESTS, Config.WORK_ORDER_IOS_TESTS })

	public void verifyMeasurementsDeleteWorkOrderTest() {
		try {
			Assert.assertTrue(workOrderPage.isAllWorkOrderDeleted(measurementsWorkOrderDescription));

		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	/*------
	 * 
	 * previous test cases
	 */

	/******* This test case sets the priority of work order *******/

	@Test(alwaysRun = true, priority = 37307, groups = { Config.IOS_FULL_TESTS, Config.ANDROID_UAT_TESTS })
	public void workOrderPriorityChangeTest() {
		TestNGUtils.setTestMethodPriority(37302);
		try {
			if (DriverFactory.class.equals("Android")) {
				workOrderPage.openWorkOrder(measurementsWorkOrderDescription);
				workOrderPage.setWorkOrderPriority("High");
				Assert.assertTrue(workOrderPage.isWorkOrderPriortyChanged("High"));
			}
			if (DriverFactory.class.equals("Android")) {
				/*
				 * CommonUtils.isElementDisplayed(60, 1, CommonUtils.
				 * getElementByUsingVisibleText("Sample Work Order - Insulation Testing for Motor A"
				 * )); gesture.scroll(null, null, null, "Priority", 0,
				 * CommonUtils.getAndroidScrollUpSteps(DriverFactory.deviceName)
				 * , null, null); workOrderPage.setWorkOrderPriority("High");
				 */

				CommonUtils.wait(20);
				// ElementUtils.clickIfDisplayedAndEnabled(CommonUtils.getElementByUsingVisibleText("Sample
				// Work Order - Insulation Testing for Motor A"));
				// gesture.mobileScrollDown("Work Type");
				workOrderPage.setWorkOrderPriority("High");
				workOrderPage.clickOnBackBarButton();
			}
		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	/****** This test case changes the work order type *******/

	@Test(alwaysRun = true, priority = 37308, groups = { Config.IOS_FULL_TESTS })
	public void workOrderTypeChangeTest() {
		try {
			workOrderPage.setWorkOrderType("Planned");
			Assert.assertTrue(workOrderPage.isWorkOrderTypeChanged("Planned"));
		} catch (Throwable e) {

			e.printStackTrace();
			Assert.fail();
		}
	}

	/******* This test case changes the status of work order ******/

	@Test(alwaysRun = true, priority = 37309, groups = { Config.IOS_FULL_TESTS })
	public void workOrderStatusChangeTest() {
		try {
			workOrderPage.changeWorkOrderStatusAndAddOptionalTexNote("Closed", false, null);
			Assert.assertTrue(workOrderPage.isWorkOrderStatusChanged("CLOSED", measurementsWorkOrderDescription));
			workOrderPage.clickOnCancelButton();
		} catch (Throwable e) {
			workOrderPage.clickOnCancelButton();
			e.printStackTrace();
			Assert.fail();
		}
	}

	/********************* ios ***********************/
	@Test(alwaysRun = true, priority = 37301, groups = { Config.WORK_ORDER_IOS_TESTS })
	public void createWo() {
		workOrderPage.clickOnThreeDot();
		workOrderPage.addWorkOrderButton();
		workOrderPage.enterWorkOrderDetails("Measurement Work Order", measurementsWorkOrderDescription);
		workOrderPage.saveWorkOrderMain();
	}

	@Test(alwaysRun = true, priority = 37302, groups = { Config.WORK_ORDER_IOS_TESTS })
	public void changePriority() throws Exception {
		workOrderPage.openWorkOrder(measurementsWorkOrderDescription);
		IOSUtils.setIOSPageSource();
		workOrderPage.clickOnPriorityCell();
		workOrderPage.selectHighPriority();
		workOrderPage.saveWorkOrderMain();
	}

	@Test(alwaysRun = true, priority = 37303, groups = { Config.WORK_ORDER_IOS_TESTS })
	public void changeWorkType() {
		workOrderPage.clickOnWorkTypeCell();
		workOrderPage.selectUnassigned();
		workOrderPage.saveWorkOrderMain();
	}

	@Test(alwaysRun = true, priority = 37304, groups = { Config.WORK_ORDER_IOS_TESTS })
	public void changeEstimatedWork() {
		workOrderPage.scrollToText("Estimated Completion Date");
		workOrderPage.enterDate();
		workOrderPage.enterEstimatedHours();
		workOrderPage.iOSKeyboardDone();
	}

	@Test(alwaysRun = true, priority = 37305, groups = { Config.WORK_ORDER_IOS_TESTS })
	public void scheduleWorkOrder() {
		workOrderPage.scrollToText("Assignee");
		workOrderPage.clickOnThreeDotScheduleWO();
		workOrderPage.clickOnEditScheduleButton();
		// workOrderPage.selectScheduleDate();
		workOrderPage.checkAssignee();
		workOrderPage.clickOnDoneSchedule();
		workOrderPage.saveWorkOrderMain();
	}

	@AfterClass(alwaysRun = true, groups = { Config.WORK_ORDER_TESTS, Config.IOS_WO_SMOKE_EXT_TESTS,
			Config.WORK_ORDER_UAT, Config.WO_WEB_SMOKE_EXT_TESTS, Config.ANDROID_WO_SMOKE_EXT_TESTS,
			Config.WORK_ORDER_WEB_TESTS, Config.WORK_ORDER_IOS_TESTS })
	public void classTearDown() throws Exception {
		if (!DriverManager.isSmokeSuite()) {
			DriverManager.closeApp();
			DriverManager.launchApp();
			DriverManager.getSignIn().handleOnBoardPrompt();
			DriverManager.getSwitcher().signOut();
		}
	}

}
