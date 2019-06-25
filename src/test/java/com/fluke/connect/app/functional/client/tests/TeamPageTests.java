package com.fluke.connect.app.functional.client.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.fluke.connect.app.functional.client.pages.Switcher;
import com.fluke.connect.app.functional.client.pages.TeamPage;
import com.fluke.connect.app.functional.client.pages.MeasurementDetailPage;
import com.fluke.connect.app.functional.client.pages.MeasurementDetailPage.MeasurementDetailPageObjects;
import com.fluke.connect.app.functional.client.pages.MeasurementsHistoryPage;
import com.fluke.connect.app.functional.client.pages.MeasurementsHistoryPage.MeasurementHistoryPageObjects;
import com.fluke.connect.app.functional.client.pages.TeamPage.TeamPageObjectList;
import com.fluke.connect.app.testdata.FCM;
import com.fluke.connect.app.testdata.Team;
import com.fluke.connect.app.testdata.FCM.SearchSortFilterAttributes;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DateAndTimeUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.ScrollDiection;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.IOSUtils;

public class TeamPageTests 
{
	private TeamPage teamPage;
	private Switcher switcher;
	private MeasurementsHistoryPage mMeasurementHistoryPage;
	private GestureUtils mGestureUtils;
	private StringBuilder mCurrentMeasurementDate;
	private StringBuilder mNextMeasurementDate; 
	private MeasurementDetailPage mMeasurementDetailPage;
	
	@BeforeClass(alwaysRun = true, groups = {Config.IOS_FULL_TESTS, Config.IOS_SMOKE_TESTS, Config.ANDROID_SMOKE_TESTS, 
			Config.ANDROID_UAT_TESTS,Config.ANDROID_FULL_TESTS, Config.ANDROID_SMOKE_EXTENDED_TESTS, Config.TEAM_TESTS_WEB})
	public void initClass()  throws Exception
	{
		teamPage = new TeamPage();
		switcher = new Switcher();
		switcher.switchToTeamPage();
		mMeasurementHistoryPage = new MeasurementsHistoryPage();
		mGestureUtils = new GestureUtils();
		mCurrentMeasurementDate = new StringBuilder();
		mNextMeasurementDate = new StringBuilder();
		mMeasurementDetailPage = new MeasurementDetailPage();
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			ElementUtils.safeClick(5, 1, teamPage.getElement(TeamPageObjectList.OK_BUTTON));
	}
	
	@Test(alwaysRun = true, priority = 70301, groups = {Config.IOS_FULL_TESTS, Config.IOS_SMOKE_TESTS, 
			Config.ANDROID_SMOKE_TESTS, Config.ANDROID_UAT_TESTS,Config.ANDROID_FULL_TESTS, Config.ANDROID_SMOKE_EXTENDED_TESTS})
	public void addTeamMembersTest()
	{
		try 
		{
			teamPage.clickOnInviteButton();
			teamPage.addContacts(Team.newUserInviteeID);
			teamPage.clickOnSendButton();
		}
		catch(Exception e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 70302, groups = {Config.IOS_FULL_TESTS, Config.IOS_SMOKE_TESTS, Config.ANDROID_SMOKE_TESTS, Config.ANDROID_UAT_TESTS,Config.ANDROID_FULL_TESTS,
			Config.ANDROID_SMOKE_EXTENDED_TESTS})
	public void removeTeamMembersTest()
	{
		try 
		{
			teamPage.removeInvitees(1);
		}
		catch(Exception e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 71200, groups = {Config.TEAM_TESTS})   //priority range in lies with SignUpPage Tests
	public void newUserLicenseTest()
	{
		
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			teamPage.getElement(TeamPageObjectList.SUBSCRIPTION_EXPIRATION_OK_BUTTON).click();
			Assert.assertTrue(teamPage.getElement(TeamPageObjectList.LICENSE_INFO).getText().contains(Team.newUserLicense));
		}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			IOSUtils.isPageLoaded(15, "Data...");
			ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, Team.userLastName, null, null).click();
			IOSUtils.isPageLoaded(15, "Data...");
			Assert.assertTrue(ElementUtils.isDisplayed(5, ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, Team.newUserLicense, null, null)));
			ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, "Back", null, null).click();
		}
	}
	
	@Test(priority = 71201, groups = {Config.TEAM_TESTS, Config.TEAM_TESTS_WEB})   //priority range in lies with SignUpPahe Tests
	public void inviteNewMemberTest() throws Exception
	{
		teamPage.inviteMember(Team.newUserInviteeID);
	}
	
	@Test(priority = 71202, groups = {Config.TEAM_TESTS, Config.TEAM_TESTS_WEB})   //priority range in lies with SignUpPahe Tests
	public void revokeNewMemberTest() throws Exception
	{
		teamPage.removeInvitees(1);
	}
	
	@Test(priority = 71225, groups = {Config.TEAM_TESTS})
	public void sortByAssetTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER)) 
			switcher.switchToMeasurementsPage();
		mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.SORT_AND_FILTER_BUTTON).click();
		mMeasurementHistoryPage.sortAndFilter(MeasurementHistoryPageObjects.SORT_BY_ASSET);
		CommonUtils.wait(0, 2, 0);
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			Assert.assertTrue(mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.SORT_MODE).getText().equals(SearchSortFilterAttributes.SORT_BY_ASSET.getAttributeValue()) && mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.SORT_VALUE).getText().equals(SearchSortFilterAttributes.SORT_BY_ASSET_VALUE.getAttributeValue()) && mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.TEST_POINT).getText().equals(SearchSortFilterAttributes.SORT_BY_ASSET_VALUE.getAttributeValue()));
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertTrue(mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.SORT_MODE).getText().contains(SearchSortFilterAttributes.SORT_BY_ASSET.getAttributeValue()) && ElementUtils.isDisplayed(5, ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, SearchSortFilterAttributes.SORT_BY_ASSET_VALUE.getAttributeValue(), null, null)));
	}
	
	@Test(priority = 71226, groups = {Config.TEAM_TESTS})
	public void sortByWorkOrderTest() throws Exception
	{
		mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.SORT_AND_FILTER_BUTTON).click();
		mMeasurementHistoryPage.sortAndFilter(MeasurementHistoryPageObjects.SORT_BY_WORK_ORDER);
		CommonUtils.wait(0, 2, 0);
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			Assert.assertTrue(mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.SORT_MODE).getText().equals(SearchSortFilterAttributes.SORT_BY_WORK_ORDER.getAttributeValue()) && mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.SORT_VALUE).getText().equals(SearchSortFilterAttributes.SORT_BY_WORK_ORDER_VALUE_HEADER.getAttributeValue()) && mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.WORK_ORDER).getText().equals(SearchSortFilterAttributes.SORT_BY_WORK_ORDER_VALUE.getAttributeValue()));
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertTrue(mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.SORT_MODE).getText().contains(SearchSortFilterAttributes.SORT_BY_WORK_ORDER.getAttributeValue()));
	}
	
	@Test(priority = 71227, groups = {Config.TEAM_TESTS, Config.TEAM_TESTS_WEB})
	public void sortByDateTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.SORT_AND_FILTER_BUTTON).click();
			mMeasurementHistoryPage.sortAndFilter(MeasurementHistoryPageObjects.SORT_BY_DATE);
			CommonUtils.wait(0, 2, 0);
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				Assert.assertTrue(mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.SORT_MODE).getText().equals(SearchSortFilterAttributes.SORT_BY_DATE.getAttributeValue()) && mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.SORT_VALUE).getText().equals(DateAndTimeUtils.getCurrentTimeStamp("M/d/yy")) && mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.MEASUREMENT_DATE).getText().contains(DateAndTimeUtils.getCurrentTimeStamp("M/d/yy")));
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				Assert.assertTrue(mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.SORT_MODE).getText().contains(SearchSortFilterAttributes.SORT_BY_DATE.getAttributeValue()) && mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.MEASUREMENT_DATE).getText().contains(DateAndTimeUtils.getCurrentTimeStamp("MM/dd/yy")));
		}
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			switcher.switchToMeasurementsPage();
			GestureUtils.moveAndClickElement(mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.SORT_AND_FILTER_BUTTON));
			mMeasurementHistoryPage.sortAndFilter(MeasurementHistoryPageObjects.SORT_BY_DATE_ASC);
			CommonUtils.wait(10);
			mCurrentMeasurementDate.delete(0, mCurrentMeasurementDate.length());
			mCurrentMeasurementDate.append(mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.MEASUREMENT_DATE).getText());
			GestureUtils.moveAndClickElement(mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.SORT_AND_FILTER_BUTTON));
			mMeasurementHistoryPage.sortAndFilter(MeasurementHistoryPageObjects.SORT_BY_DATE);
			CommonUtils.wait(10);
			mNextMeasurementDate.delete(0, mNextMeasurementDate.length());
			mNextMeasurementDate.append(mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.MEASUREMENT_DATE));
			Assert.assertFalse(mCurrentMeasurementDate.toString().equals(mNextMeasurementDate.toString()) && mCurrentMeasurementDate.toString().equals(FCM.SearchSortFilterAttributes.SORT_BY_DATE_ASC_VALUE.getAttributeValue()) && mNextMeasurementDate.toString().contains(DateAndTimeUtils.getCurrentTimeStamp("dd/MM/yyyy")));
		}
	}
	
	@Test(priority = 71228, groups = {Config.TEAM_TESTS, Config.TEAM_TESTS_WEB})
	public void filterByMeasurementTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mGestureUtils.getActionsWebObject().moveToElement(mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.ASSET_CELL)).build().perform();
			GestureUtils.moveAndClickElement(mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.FILTER_BUTTON));
			mMeasurementHistoryPage.sortAndFilter(MeasurementHistoryPageObjects.FILTER_MEASUREMENTS);
			CommonUtils.wait(10);
			Assert.assertTrue(mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.DEVICE_NAME).getText().equals(SearchSortFilterAttributes.FILTER_MEASUREMENTS_VALUE.getAttributeValue()));
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.SORT_AND_FILTER_BUTTON).click();
			mMeasurementHistoryPage.sortAndFilter(MeasurementHistoryPageObjects.FILTER_MEASUREMENTS);
			CommonUtils.wait(0, 2, 0);
			Assert.assertTrue(mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.FILTER_MODE).getText().equals(SearchSortFilterAttributes.FILTER_MEASUREMENTS.getAttributeValue()) && mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.DEVICE_NAME).getText().equals(SearchSortFilterAttributes.FILTER_MEASUREMENTS_VALUE.getAttributeValue()));
		}
	}
	
	@Test(priority = 71229, groups = {Config.TEAM_TESTS, Config.TEAM_TESTS_WEB})
	public void filterByThermalImagesTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mGestureUtils.getActionsWebObject().moveToElement(mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.ASSET_CELL)).build().perform();
			GestureUtils.moveAndClickElement(mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.FILTER_BUTTON));
			mMeasurementHistoryPage.sortAndFilter(MeasurementHistoryPageObjects.FILTER_THERMAL_IMAGES);
			CommonUtils.wait(10);
			mGestureUtils.getActionsWebObject().moveToElement(mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.ASSET_CELL)).build().perform();
			GestureUtils.moveAndClickElement(mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.FILTER_BUTTON));	
			mMeasurementHistoryPage.sortAndFilter(MeasurementHistoryPageObjects.FILTER_MEASUREMENTS);
			Assert.assertTrue(mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.DEVICE_NAME).getText().equals(SearchSortFilterAttributes.FILTER_THERMAL_IMAGES_VALUE.getAttributeValue()));
			CommonUtils.wait(10);
			mGestureUtils.getActionsWebObject().moveToElement(mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.MEASUREMENT_DATE)).build().perform();
			GestureUtils.moveAndClickElement(mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.FILTER_BUTTON));
			mMeasurementHistoryPage.sortAndFilter(MeasurementHistoryPageObjects.FILTER_ALL);
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.SORT_AND_FILTER_BUTTON).click();
			mMeasurementHistoryPage.sortAndFilter(MeasurementHistoryPageObjects.FILTER_THERMAL_IMAGES);
			CommonUtils.wait(0, 2, 0);
			Assert.assertTrue(mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.FILTER_MODE).getText().equals(SearchSortFilterAttributes.FILTER_THERMAL_IMAGES.getAttributeValue()) && mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.DEVICE_NAME).getText().equals(SearchSortFilterAttributes.FILTER_THERMAL_IMAGES_VALUE.getAttributeValue()));
		}
	}
	
	@Test(priority = 71230, groups = {Config.TEAM_TESTS}) 
	public void filterBy3PhaseTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			mGestureUtils.getActionsWebObject().moveToElement(mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.ASSET_CELL)).build().perform();
			GestureUtils.moveAndClickElement(mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.FILTER_BUTTON));
			mMeasurementHistoryPage.sortAndFilter(MeasurementHistoryPageObjects.FILTER_3_PHASE);
			mGestureUtils.getActionsWebObject().moveToElement(mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.ASSET_CELL)).build().perform();
			GestureUtils.moveAndClickElement(mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.FILTER_BUTTON));
			mMeasurementHistoryPage.sortAndFilter(MeasurementHistoryPageObjects.FILTER_THERMAL_IMAGES);
			Assert.assertTrue(mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.TEST_POINT).getText().equals(SearchSortFilterAttributes.FILTER_UNASSIGNED_ASSET.getAttributeValue()));
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.SORT_AND_FILTER_BUTTON).click();
			mMeasurementHistoryPage.sortAndFilter(MeasurementHistoryPageObjects.FILTER_3_PHASE);
			CommonUtils.wait(0, 2, 0);
			Assert.assertTrue(mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.FILTER_MODE).getText().contains(SearchSortFilterAttributes.FILTER_3_PHASE.getAttributeValue()) && mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.DEVICE_NAME).getText().equalsIgnoreCase(SearchSortFilterAttributes.FILTER_3_PHASE_VALUE.getAttributeValue()));
		}
	}
	
	@Test(priority = 71231, groups = {Config.TEAM_TESTS})
	public void searchMeasurementsTest() throws Exception
	{
		mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.SORT_AND_FILTER_BUTTON).click();
		mMeasurementHistoryPage.sortAndFilter(MeasurementHistoryPageObjects.FILTER_ALL);
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			ElementUtils.sendKeys(mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.SEARCH_TEXT_FIELD), SearchSortFilterAttributes.SEARCH_TEXT.getAttributeValue());
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			switcher.switchToAssetsPage();
			CommonUtils.wait(1);
			switcher.switchToMeasurementsPage();
			CommonUtils.wait(5);
			ElementUtils.sendKeys(mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.SEARCH_TEXT_FIELD), SearchSortFilterAttributes.SEARCH_TEXT.getAttributeValue());
			mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.KEYBOARD_SEARCH_BUTTON).click();
			mGestureUtils.scroll(-250, 1);
			Assert.assertTrue(ElementUtils.isEnabled(5, ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, SearchSortFilterAttributes.IOS_SEARCH_ID.getAttributeValue(), null, null)));
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			Assert.assertTrue(mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.TEST_POINT).getText().equals(SearchSortFilterAttributes.SEARCH_TEXT.getAttributeValue()));
	}
	
	@Test(priority = 71232, groups = {Config.TEAM_TESTS, Config.TEAM_TESTS_WEB})
	public void reassignAssetTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.TEST_POINT).click();
			ElementUtils.safeClick(5, mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.ANDROID_ASSET_POPUP_CLOSE_BUTTON));
		}
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.TEST_POINT).click();
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.FIRST_MEASUREMENT).click();
			CommonUtils.wait(0, 2, 0);
			mCurrentMeasurementDate.delete(0, mCurrentMeasurementDate.length());
			mCurrentMeasurementDate.append(mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.MEASUREMENT_CAPTURE_DATE).getText());
		}
		mMeasurementDetailPage.assignAssetCM(FCM.captureMeasurementAssetList[0], FCM.captureMeasurementAssetList[1], FCM.captureMeasurementAssetList[2]);
		Assert.assertTrue(mMeasurementDetailPage.isAssetAssigned(FCM.captureMeasurementAssetList[2]));
	}
	
	@Test(priority = 71233, groups = {Config.TEAM_TESTS, Config.TEAM_TESTS_WEB})
	public void reassignWorkOrderTest() throws Exception
	{
		mMeasurementDetailPage.assignWorkOrder(Config.measurementReAssignedWorkOrderNumber);
		Assert.assertTrue(mMeasurementDetailPage.isWorkOrderAssigned(Config.measurementReAssignedWorkOrderNumber));
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.BACK_BUTTON).click();
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.MEASUREMENT_SAVE_BUTTON).click();
	}
	
	@Test(priority = 71234, groups = {Config.TEAM_TESTS})
	public void isAssetReassignedTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			CommonUtils.wait(2);
			mGestureUtils.mobileScroll(250, 1);
			mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.SEARCH_TEXT_FIELD).clear();
			mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.KEYBOARD_SEARCH_BUTTON).click();
			mGestureUtils.mScroll(mCurrentMeasurementDate.toString(), LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, null, ScrollDiection.DOWN);
			mGestureUtils.mobileScroll(-250, 2);
			Assert.assertTrue(ElementUtils.isEnabled(5, ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, SearchSortFilterAttributes.IOS_REASSIGNED_ASSET.getAttributeValue(), null, null)));
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			Assert.assertTrue(mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.TEST_POINT).getText().equals(FCM.captureMeasurementAssetList[2]));
	}
	
	@Test(priority = 71235, groups = {Config.TEAM_TESTS})
	public void isWorkOrderReassignedTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			Assert.assertTrue(mMeasurementHistoryPage.getMeasurementHistoryPageObject(MeasurementHistoryPageObjects.WORK_ORDER).getText().contains(Config.measurementReAssignedWorkOrder));
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertTrue(ElementUtils.isEnabled(5, ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, SearchSortFilterAttributes.IOS_REASSIGNED_WORKORDER.getAttributeValue(), null, null)));
	}
	
	@Test(priority = 71236, groups = {Config.TEAM_TESTS_WEB})
	public void loadMeasurementsTest() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			DriverManager.getDriver().navigate().refresh();
			CommonUtils.wait(10);
			mGestureUtils.webScroll(ScrollDiection.DOWN, 8);
			Assert.assertTrue(mMeasurementHistoryPage.getMeasurementHistoryPageWebElements(MeasurementHistoryPageObjects.MEASUREMENT_DATE_LIST).size() == 14);
		}
	}
	
	@AfterClass(groups = {Config.IOS_SMOKE_TESTS, Config.ANDROID_SMOKE_TESTS, 
			Config.ANDROID_UAT_TESTS, Config.ANDROID_SMOKE_EXTENDED_TESTS, Config.TEAM_TESTS, Config.TEAM_TESTS_WEB})
	public void tearDown() throws Exception
	{
		if(!DriverManager.isSmokeSuite()) { 
			DriverManager.closeApp();
			DriverManager.launchApp();
			DriverManager.getSignIn().handleOnBoardPrompt();
			DriverManager.getSwitcher().signOut();
		}
	}
		
}
