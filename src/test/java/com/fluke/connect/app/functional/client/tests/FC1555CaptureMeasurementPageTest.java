package com.fluke.connect.app.functional.client.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.fluke.connect.app.functional.client.pages.AssetAnalysisPage;
import com.fluke.connect.app.functional.client.pages.AssetsPage;
import com.fluke.connect.app.functional.client.pages.FC1555CaptureMeasurementPage;
import com.fluke.connect.app.functional.client.pages.MeasurementDetailPage;
import com.fluke.connect.app.functional.client.pages.MeasurementsHistoryPage;
import com.fluke.connect.app.functional.client.pages.ServiceHatchPage;
import com.fluke.connect.app.functional.client.pages.Switcher;
import com.fluke.connect.app.functional.client.pages.FC1555CaptureMeasurementPage.CaptureEeveeMeasurementsPageObject;
import com.fluke.connect.app.testdata.Asset;
import com.fluke.connect.app.testdata.FCM1555;
import com.fluke.connect.app.testdata.SignIn;
import com.fluke.connect.app.testdata.FCM.DataType;
import com.fluke.connect.app.testdata.FCM.ShareFormat;
import com.fluke.connect.app.testdata.SignIn.FeatureList;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.ScrollDiection;

public class FC1555CaptureMeasurementPageTest 
{
	private FC1555CaptureMeasurementPage fc1555CaptureMeasurementPage;
	private Switcher switcher;
	private ServiceHatchPage serviceHatchPage;
	private MeasurementDetailPage measurementDetailPage;
	private GestureUtils gestureUtils;
	private AssetAnalysisPage assetsAnalysisPage;
	private AssetsPage assetsPage;
	private Asset asset;
	private MeasurementsHistoryPage measurementsHistoryPage;

	@BeforeClass(alwaysRun = true, groups = {Config.FC1555 ,Config.FC1555_ANALYSIS, Config.FC1555_UAT, Config.ANDROID_FC1555_EXT_SMOKE_TESTS, Config.ANDROID_SMOKE_EXTENDED_TESTS})

	public void initClass() throws Exception
	{

		if(!DriverManager.isSmokeSuite()) {
			DriverManager.getSignIn().signIn(SignIn.getUID(FeatureList.FC1555), SignIn.getPWD(FeatureList.FC1555));
	        DriverManager.getSignIn().handleAfterSignInAlertsOtherUser();
		}
		
		fc1555CaptureMeasurementPage = new FC1555CaptureMeasurementPage();
		switcher = new Switcher();
		serviceHatchPage = new ServiceHatchPage();
		measurementDetailPage = new MeasurementDetailPage();
		gestureUtils = new GestureUtils();

		assetsPage= new AssetsPage();
		assetsAnalysisPage=new AssetAnalysisPage();
		asset=new Asset();
		measurementsHistoryPage= new MeasurementsHistoryPage();
		gestureUtils = new GestureUtils();
	}

	
	@Test(alwaysRun = true, priority = 169001, groups = {Config.FC1555, Config.FC1555_UAT})
	public void fc1555ConnectionTest() throws Exception
	{
		try
		{
			switcher.switchToCaptureMeasurementsHomePage();
			fc1555CaptureMeasurementPage.connectToRealDeviceAndroidPopUpHandle();
			fc1555CaptureMeasurementPage.connectToRealDevice("IR 3000 FC");
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}


	@Test(alwaysRun = true, priority = 169002, groups = {Config.FC1555, Config.FC1555_UAT})
	public void fc1555NavigationToInfoScreenTest() throws Exception
	{
		try
		{
			fc1555CaptureMeasurementPage.eeveeOptionMenu("Info");
		}
		catch(Exception e)
		
		{
			fc1555CaptureMeasurementPage.eeveeOptionMenu("Info");
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 169003, groups = {Config.FC1555, Config.FC1555_UAT})
	public void fc1555DeviceInfoStaticTextTest() throws Exception
	{
		try
		{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertEquals(fc1555CaptureMeasurementPage.getDeviceinfoStaticText(), FCM1555.expectedDeviceInfoStaticText[0]);	
			}
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertEquals(fc1555CaptureMeasurementPage.getDeviceinfoStaticText(), FCM1555.expectedDeviceInfoStaticText[1]);	
			}
		}
		catch(Exception e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 169004, groups = {Config.FC1555, Config.FC1555_UAT})
	public void fc1555DeviceNameStaticTextTest() throws Exception
	{
		try
		{
			Assert.assertEquals(fc1555CaptureMeasurementPage.getDeviceNameStaticText(), FCM1555.expectedDeviceNameStaticText);
		}
		catch(Exception e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 169005, groups = {Config.FC1555, Config.FC1555_UAT})
	public void fc1555DeviceDescriptionStaticTextTest() throws Exception
	{
		try
		{
			Assert.assertEquals(fc1555CaptureMeasurementPage.getDeviceDescriptionStaticText(), FCM1555.expectedDeviceDescriptionStaticText);
		}
		catch(Exception e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 169008, groups = {Config.FC1555, Config.FC1555_UAT})
	public void fc1555DeviceManufacturingDetailsStaticTextTest() throws Exception
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertEquals(fc1555CaptureMeasurementPage.getLoggingDeviceDescriptionStaticText(), FCM1555.expectedDeviceDescriptionFor1555FCStaticText[0]);
			}
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertEquals(fc1555CaptureMeasurementPage.getLoggingDeviceDescriptionStaticText(), FCM1555.expectedDeviceDescriptionFor1555FCStaticText[1]);
			}	
		}
		catch(Exception e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 169012, groups = {Config.FC1555})
	public void fc1555DeviceConnectionStaticTextTest() throws Exception
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertEquals(fc1555CaptureMeasurementPage.getLoggingDeviceConnectionStaticText(), FCM1555.expectedConnectionFor1555FCStaticText);
			}
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertEquals(fc1555CaptureMeasurementPage.getSerialNumberStaticTextInInfoPage(), FCM1555.expectedSerialNumberFor1555FCStaticText);
			}
		}
		catch(Exception e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 169014, groups = {Config.FC1555})
	public void fc1555DeviceSoftwareVersionStaticTextTest() throws Exception
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertEquals(fc1555CaptureMeasurementPage.getSoftwareVersionStaticTextInInfoPage(), FCM1555.expectedSoftwareVersionFor1555FCStaticText);
			}
		}
		catch(Exception e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 169017, groups = {Config.FC1555})
	public void fc1555DeviceFirmwareVersionStaticTextTest() throws Exception
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertEquals(fc1555CaptureMeasurementPage.getFirmwareVersionStaticTextInInfoPage(), FCM1555.expectedFirwmwareVersionFor1555FCStaticText);
			}
		}
		catch(Exception e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 169018, groups = {Config.FC1555, Config.FC1555_UAT})
	public void fc1555EditDeviceNameTest() throws Exception
	{
		try
		{
			fc1555CaptureMeasurementPage.deviceNameEditText("IR 3000 FC");
			fc1555CaptureMeasurementPage.clickOnDoneButtonInDeviceInfoPage();
		}
		catch(Exception e)
		{
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "back_button", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Cancel", null, null);
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 169019, groups = {Config.FC1555})
	public void fc1555DeviceNameInCaptureScreenTest() throws Exception
	{
		try
		{
			String deviceName=fc1555CaptureMeasurementPage.getConnectedFC1555DeviceNameInCapturePage();
			CommonUtils.wait(5);
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertEquals(deviceName, "1550C  #1");
			}
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				CommonUtils.wait(3);
	//			Assert.assertEquals(deviceName, "1555");
			}	
		}
		catch(Exception e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 169020, groups = {Config.FC1555, Config.FC1555_UAT})
	public void fc1555DownloadMeasurements() throws Exception
	{
		try
		{
			fc1555CaptureMeasurementPage.eeveeOptionMenu("Download");
			ElementUtils.isDisplayed(60, 1, ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/dialog_ok", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", null, null));
		}
		catch(Throwable e)
		{
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/dialog_ok", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, null, null, null).click();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/action_bar_item_close", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, null, null, null).click();
			fc1555CaptureMeasurementPage.eeveeOptionMenu("Download");
			ElementUtils.isDisplayed(60, 1, ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/dialog_ok", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, null, null, null));
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/dialog_ok", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, null, null, null).click();
			switcher.switchToCaptureMeasurementsHomePage();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 169021, groups = {Config.FC1555, Config.FC1555_UAT})
	public void fc1555DownloadMessageHeaderVerification() throws Exception
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
			Assert.assertEquals(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/dialog_title", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, null, null, null).getText(), FCM1555.downloadCompletedHeaderStaticText[0]);
			}
		}
		catch(Throwable e)
		{
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/dialog_ok", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, null, null, null).click();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/back_button", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, null, null, null).click();
			switcher.switchToCaptureMeasurementsHomePage();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 169025, groups = {Config.FC1555})
	public void fc1555DownloadSucessMessageVerification() throws Exception
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertEquals(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/dialog_message_main", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, null, null, null).getText(), FCM1555.downloadCompletedSuccessfullyStaticText[0]);
			}
		}
		catch(Throwable e)
		{
			switcher.switchToCaptureMeasurementsHomePage();
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 169026, groups = {Config.FC1555, Config.FC1555_UAT})
	public void fc1555NavigationToIntermediateMeasurementsPageAfterDownloads() throws Exception
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				ElementUtils.isDisplayed(60, 1, ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/dialog_ok", null, null, null, null));
				ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/dialog_ok", null, null, null, null).click();
				//ElementUtils.isDisplayed(60, 1, ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/menu_share", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "done", null, null));
			}
			
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				CommonUtils.wait(5);
				String getDate=fc1555CaptureMeasurementPage.getEeveeMeasurementDate();
				ElementUtils.getElement(null,null,LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,getDate,null,null).click();
			}
		}
		catch(Throwable e)
		{
			switcher.switchToCaptureMeasurementsHomePage();
			Assert.fail("Exception Detail: "+e);
		}
	}
	

	@Test(alwaysRun = true, priority = 169027, groups = {Config.FC1555})
	public void fc1555AddTextNotesDuringDownloadTest()
	{
		try
		{
			CommonUtils.wait(5);
			fc1555CaptureMeasurementPage.coachMarkClosure();
			measurementDetailPage.addTextNote("textNote");
			//measurementDetailPage.isTextNoteAdded("textNote");
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 169029, groups = {Config.FC1555, Config.FC1555_UAT})
	public void fc1555ShareMeasurementInCSVFormatTest() throws Exception
	{
		try
		{
			fc1555CaptureMeasurementPage.coachMarkClosure();
			CommonUtils.wait(1);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/menu_share", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Share", null, null).click();
			CommonUtils.wait(2);
			measurementDetailPage.shareMeasurement("fluketestnote5@gmail.com", DataType.MEASUREMENT_DATA, ShareFormat.CSV, false);
			CommonUtils.wait(2);
			//ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "back_button", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Back", null, null).click();
		}
		catch(Throwable e)
		{
			fc1555CaptureMeasurementPage.clickBackButton();
			//fc1555CaptureMeasurementPage.doneAndDisconnectDevice(1);
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 169030, groups = {Config.FC1555, Config.FC1555_UAT})
	public void fc1555ShareMeasurementInXLSFormatTest() throws Exception
	{
		try
		{
			CommonUtils.wait(5);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/menu_share", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Share", null, null).click();
			CommonUtils.wait(2);
			measurementDetailPage.shareMeasurement("fluketestnote5@gmail.com", DataType.MEASUREMENT_DATA, ShareFormat.XLS, false);
			CommonUtils.wait(1);
		}
		catch(Throwable e)
		{
			fc1555CaptureMeasurementPage.clickBackButton();
			//fc1555CaptureMeasurementPage.doneAndDisconnectDevice(1);
			Assert.fail("Exception Detail: "+e);
		}
	}
	

	@Test(alwaysRun = true, priority = 169031, groups = {Config.FC1555, Config.FC1555_UAT})
	public void fc1555AssetAssignmentAfterDownloads() throws Exception
	{
		try
		{
			
			fc1555CaptureMeasurementPage.coachMarkClosure();
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				CommonUtils.wait(15);
				measurementsHistoryPage.assignAssetInIntermediateMeasurementPageAfterDownload("eevee automation", "eevee test", "eevee test");
				CommonUtils.wait(5);
			}
			
			
		}
		catch(Throwable e)
		{
			switcher.switchToCaptureMeasurementsHomePage();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 169032, groups = {Config.FC1555, Config.FC1555_UAT})
	public void fc1555IsAssetAssignedAfterDownloads() throws Exception
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				CommonUtils.wait(5);
				measurementDetailPage.isAssetAssigned("eevee test");
			}
		}
		catch(Throwable e)
		{
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"back_button",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"Back",null,null).click();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"action_bar_item_left",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"backBarButton",null,null).click();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"action_bar_item_left",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"backBarButton",null,null).click();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"action_bar_item_left",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"backBarButton",null,null).click();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"back_button",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"Back",null,null).click();
			switcher.switchToCaptureMeasurementsHomePage();
			Assert.fail("Exception Detail: "+e);
		}
	}
	

	@Test(alwaysRun = true, priority = 169033, groups = {Config.FC1555, Config.FC1555_UAT})
	public void fc1555ClearAssetAssignmentDuringDownload() throws Exception
	{
		try
		{
			fc1555CaptureMeasurementPage.coachMarkClosure();
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				CommonUtils.wait(3);
				fc1555CaptureMeasurementPage.clickOnAssignAssetCell();
				CommonUtils.wait(3);
				assetsPage.navigationToAssetTestPoint("eevee automation", "eevee test");
				CommonUtils.wait(1);
				assetsPage.clickClearAssignment();
				CommonUtils.wait(2);
			}
			
			//measurementsHistoryPage.clickOnDoneButton();
		}
		catch(Throwable e)
		{
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"back_button",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"Back",null,null).click();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"action_bar_item_left",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"backBarButton",null,null).click();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"action_bar_item_left",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"backBarButton",null,null).click();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"action_bar_item_left",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"backBarButton",null,null).click();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"back_button",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"Back",null,null).click();
			//fc1555CaptureMeasurementPage.doneAndDisconnectDevice(1);
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 169034, groups = {Config.FC1555, Config.FC1555_UAT})
	public void fc1555DeviceMeasWOAssignDuringDownloadTest() throws Exception
	{
		try
		{
			//CommonUtils.wait(5);
			fc1555CaptureMeasurementPage.coachMarkClosure();
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				CommonUtils.wait(15);
				measurementDetailPage.assignWorkOrder(FCM1555.measurementAssignedWorkOrderTile[0]);
			}
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				CommonUtils.wait(2);
				//measurementDetailPage.assignWorkOrder(FCM1555.measurementAssignedWorkOrderTile[1]);
				ElementUtils.getElement(null,null,LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"Work Order",null,null).click();
				ElementUtils.getElement(null,null,LocatorStrategy.IOS_LOCATOR_STRATEGY_XPATH,"//XCUIElementTypeStaticText[@name=\"1\"]",null,null).click();
			}
		}
		catch(Throwable e)
		{	
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"com.fluke.deviceApp:id/action_cancel",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"Cancel",null,null).click();
			ElementUtils.getElement(null,null,LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"Back",null,null).click();
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 169037, groups = {Config.FC1555, Config.FC1555_UAT})
	public void isWorkOrderAssignedTo1555FCDuringDownloadTest()
	{
		try
		{
			CommonUtils.wait(4);
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertTrue(measurementDetailPage.isWorkOrderAssigned(FCM1555.measurementAssignedWorkOrderNumber[0]));
			}
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertEquals(ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Assigned Work Order Label", null, null).getText(), FCM1555.measurementAssignedWorkOrderNumber[1]);
			}
		//	if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		//	{
		//		ElementUtils.getElement(null,null,LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"Save",null,null).click();
		//	}
		//	else
		//	{
		//		fc1555CaptureMeasurementPage.clickBackORDoneButton();
		//	}
		}
		catch(Throwable e)
		{
			//ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"action_cancel",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"Cancel",null,null).click();
			//ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"Cancel",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"Back",null,null).click();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 169039, groups = {Config.FC1555})
	public void fc1555MeasurementDetailsDuringDownloadTest() throws Throwable
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				//gestureUtils.androidScroll(75);
			}
			CommonUtils.wait(5);
			String getDate=fc1555CaptureMeasurementPage.getEeveeMeasurementDate();
			
			String [] getTestResultData=
				{		fc1555CaptureMeasurementPage.testResultData(FCM1555.TEST_RESULTS.TEST_RESULT_HEADER),
						fc1555CaptureMeasurementPage.testResultData(FCM1555.TEST_RESULTS.TEST_DURATION),
						fc1555CaptureMeasurementPage.testResultData(FCM1555.TEST_RESULTS.PRIMARY_VALUE),
						fc1555CaptureMeasurementPage.testResultData(FCM1555.TEST_RESULTS.SECONDARY_VALUE),
						fc1555CaptureMeasurementPage.testResultData(FCM1555.TEST_RESULTS.TERTIARY_VALUE)};
			/*	gestureUtils.swipe(ScrollDiection.LEFT, ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/viewpager", LocatorStrategy.IOS_LOCATOR_STRATEGY_CLASS_NAME, "XCUIElementTypeCell", LocatorStrategy.NONE, null), 150);
			CommonUtils.wait(2);
			String [] getCompensationData=
				{ fc1555CaptureMeasurementPage.compensationData(FCM1555.COMPENSATION_DATA.COMPENSATION_HEADER),
						fc1555CaptureMeasurementPage.compensationData(FCM1555.COMPENSATION_DATA.COMPENSATION_RESISTANCE),
						fc1555CaptureMeasurementPage.compensationData(FCM1555.COMPENSATION_DATA.COMPENSATION_TEMPRATURE),
						fc1555CaptureMeasurementPage.compensationData(FCM1555.COMPENSATION_DATA.COMPENSATION_HUMIDITY)};

			gestureUtils.swipe(ScrollDiection.LEFT, ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/viewpager", LocatorStrategy.IOS_LOCATOR_STRATEGY_CLASS_NAME, "XCUIElementTypeCell", LocatorStrategy.NONE, null), 150);
			CommonUtils.wait(2);
			String [] getTestConditionData=
				{ fc1555CaptureMeasurementPage.getTestConditionData(FCM1555.TEST_CONDITIONS.TEST_CONDITIONS),
						fc1555CaptureMeasurementPage.getTestConditionData(FCM1555.TEST_CONDITIONS.VOLTAGE),
						fc1555CaptureMeasurementPage.getTestConditionData(FCM1555.TEST_CONDITIONS.RAMP),
						fc1555CaptureMeasurementPage.getTestConditionData(FCM1555.TEST_CONDITIONS.TIME_LIMIT),
						fc1555CaptureMeasurementPage.getTestConditionData(FCM1555.TEST_CONDITIONS.TEST_ENDED)};

			gestureUtils.swipe(ScrollDiection.LEFT, ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/viewpager", LocatorStrategy.IOS_LOCATOR_STRATEGY_CLASS_NAME, "XCUIElementTypeCell", LocatorStrategy.NONE, null), 150);
			CommonUtils.wait(2);
			String [] getCalculatedResultData=
				{ fc1555CaptureMeasurementPage.calculatedResultData(FCM1555.CALCUTLATED_RESULTS.CALCULATED_RESULTS),
						fc1555CaptureMeasurementPage.calculatedResultData(FCM1555.CALCUTLATED_RESULTS.CAPACITANCE),
						fc1555CaptureMeasurementPage.calculatedResultData(FCM1555.CALCUTLATED_RESULTS.PI),
						fc1555CaptureMeasurementPage.calculatedResultData(FCM1555.CALCUTLATED_RESULTS.DAR)};

			gestureUtils.swipe(ScrollDiection.LEFT, ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/viewpager", LocatorStrategy.IOS_LOCATOR_STRATEGY_CLASS_NAME, "XCUIElementTypeCell", LocatorStrategy.NONE, null), 150);
			CommonUtils.wait(2);
			fc1555CaptureMeasurementPage.checkForGraphAvailability();
			CommonUtils.wait(2);
			*/
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				fc1555CaptureMeasurementPage.clickBackORDoneButton();
			}
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Save", null, null).click();
				fc1555CaptureMeasurementPage.clickBackORDoneButton();	
				CommonUtils.wait(3);
				ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Device info", null, null).click();
				CommonUtils.wait(1);
				ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Disconnect", null, null).click();
			}
			fc1555CaptureMeasurementPage.clickOnBack();
			
			switcher.switchToMeasurementsPage();

			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,getDate,LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,getDate,null,null).click();
			CommonUtils.wait(5);
			Assert.assertEquals(fc1555CaptureMeasurementPage.testResultData(FCM1555.TEST_RESULTS.TEST_RESULT_HEADER), getTestResultData[0]);
			Assert.assertEquals(fc1555CaptureMeasurementPage.testResultData(FCM1555.TEST_RESULTS.TEST_DURATION), getTestResultData[1]);
			Assert.assertEquals(fc1555CaptureMeasurementPage.testResultData(FCM1555.TEST_RESULTS.PRIMARY_VALUE), getTestResultData[2]);
			Assert.assertEquals(fc1555CaptureMeasurementPage.testResultData(FCM1555.TEST_RESULTS.SECONDARY_VALUE), getTestResultData[3]);
			Assert.assertEquals(fc1555CaptureMeasurementPage.testResultData(FCM1555.TEST_RESULTS.TERTIARY_VALUE), getTestResultData[4]);
			/*
			gestureUtils.swipe(ScrollDiection.LEFT, ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/viewpager", LocatorStrategy.IOS_LOCATOR_STRATEGY_CLASS_NAME, "XCUIElementTypeCell", LocatorStrategy.NONE, null), 150);
			CommonUtils.wait(5);
			Assert.assertEquals(fc1555CaptureMeasurementPage.compensationData(FCM1555.COMPENSATION_DATA.COMPENSATION_HEADER), getCompensationData[0]);
			Assert.assertEquals(fc1555CaptureMeasurementPage.compensationData(FCM1555.COMPENSATION_DATA.COMPENSATION_RESISTANCE), getCompensationData[1]);
			Assert.assertEquals(fc1555CaptureMeasurementPage.compensationData(FCM1555.COMPENSATION_DATA.COMPENSATION_TEMPRATURE), getCompensationData[2]);
			Assert.assertEquals(fc1555CaptureMeasurementPage.compensationData(FCM1555.COMPENSATION_DATA.COMPENSATION_HUMIDITY), getCompensationData[3]);

			gestureUtils.swipe(ScrollDiection.LEFT, ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/viewpager", LocatorStrategy.IOS_LOCATOR_STRATEGY_CLASS_NAME, "XCUIElementTypeCell", LocatorStrategy.NONE, null), 150);
			CommonUtils.wait(5);
			Assert.assertEquals(fc1555CaptureMeasurementPage.getTestConditionData(FCM1555.TEST_CONDITIONS.TEST_CONDITIONS), getTestConditionData[0]);
			Assert.assertEquals(fc1555CaptureMeasurementPage.getTestConditionData(FCM1555.TEST_CONDITIONS.VOLTAGE), getTestConditionData[1]);
			Assert.assertEquals(fc1555CaptureMeasurementPage.getTestConditionData(FCM1555.TEST_CONDITIONS.RAMP), getTestConditionData[2]);
			Assert.assertEquals(fc1555CaptureMeasurementPage.getTestConditionData(FCM1555.TEST_CONDITIONS.TIME_LIMIT), getTestConditionData[3]);
			Assert.assertEquals(fc1555CaptureMeasurementPage.getTestConditionData(FCM1555.TEST_CONDITIONS.TEST_ENDED), getTestConditionData[4]);

			gestureUtils.swipe(ScrollDiection.LEFT, ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/viewpager", LocatorStrategy.IOS_LOCATOR_STRATEGY_CLASS_NAME, "XCUIElementTypeCell", LocatorStrategy.NONE, null), 150);
			CommonUtils.wait(5);
			Assert.assertEquals(fc1555CaptureMeasurementPage.calculatedResultData(FCM1555.CALCUTLATED_RESULTS.CALCULATED_RESULTS), getCalculatedResultData[0]);
			Assert.assertEquals(fc1555CaptureMeasurementPage.calculatedResultData(FCM1555.CALCUTLATED_RESULTS.CAPACITANCE), getCalculatedResultData[1]);
			Assert.assertEquals(fc1555CaptureMeasurementPage.calculatedResultData(FCM1555.CALCUTLATED_RESULTS.PI), getCalculatedResultData[2]);
			Assert.assertEquals(fc1555CaptureMeasurementPage.calculatedResultData(FCM1555.CALCUTLATED_RESULTS.DAR), getCalculatedResultData[3]);

			gestureUtils.swipe(ScrollDiection.LEFT, ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/viewpager", LocatorStrategy.IOS_LOCATOR_STRATEGY_CLASS_NAME, "XCUIElementTypeCell", LocatorStrategy.NONE, null), 150);
			CommonUtils.wait(5);
			fc1555CaptureMeasurementPage.checkForGraphAvailability();
			*/
		}
		catch(Throwable e)
		{	
			ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Cancel", null, null).click();
			ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Stop Download", null, null).click();
			fc1555CaptureMeasurementPage.clickBackORDoneButton();	
			fc1555CaptureMeasurementPage.clickOnBack();
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 169041, groups = {Config.FC1555, Config.FC1555_UAT})
	public void fc1555deleteMeasurementTest()
	{
		try
		{
			//CommonUtils.wait(5);
			//fc1555CaptureMeasurementPage.coachMarkClosure();
			measurementDetailPage.deleteMeasurement();
		}
		catch(Throwable e)
		{
		//	ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"android:id/button2",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"Cancel",null,null).click();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"back_button",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"Cancel",null,null).click();
			Assert.fail("Exception Detail: "+e);
		}
	}


	@Test(alwaysRun = true, priority = 169043, groups = {Config.FC1555}) //, Config.FC1555_UAT
	public void fc1555GetRemoteControlConfirmationMessagesVerification() throws Exception
	{
		try
		{
			switcher.switchToCaptureMeasurementsHomePage();
			fc1555CaptureMeasurementPage.connectToRealDevice("IR 3000 FC");
			fc1555CaptureMeasurementPage.eeveeOptionMenu("Start Remote Control");
			Assert.assertEquals(fc1555CaptureMeasurementPage.getRemoteControlMessage(FCM1555.MESSAGES.REMOTE_CONTROL_CONFIRMATION), FCM1555.MESSAGES.REMOTE_CONTROL_CONFIRMATION.getMessage());
			fc1555CaptureMeasurementPage.eeveeRemoteControlConfirmation();
		}
		catch(Throwable e)
		{
			//fc1555CaptureMeasurementPage.doneAndDisconnectDevice(1);
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 169045, groups = {Config.FC1555}) //, Config.FC1555_UAT
	public void fc1555SuccesfulTestRunMessagesVerification() throws Exception
	{
		try
		{
			CommonUtils.wait(5);
			fc1555CaptureMeasurementPage.eeveeRemoteControlStartTestRun();
			CommonUtils.wait(10);
			fc1555CaptureMeasurementPage.eeveeRemoteControlStopTestRun();
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				Assert.assertEquals(fc1555CaptureMeasurementPage.getRemoteControlMessage(FCM1555.MESSAGES.TEST_SUCCESSFULLY_COMPLETED), FCM1555.MESSAGES.TEST_SUCCESSFULLY_COMPLETED.getMessage());
			}
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertEquals(fc1555CaptureMeasurementPage.getRemoteControlMessage(FCM1555.MESSAGES.TEST_SUCCESSFULLY_COMPLETED), FCM1555.MESSAGES.TEST_SUCCESSFULLY_COMPLETED_iOS.getMessage());
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 169047, groups = {Config.FC1555}) //, Config.FC1555_UAT
	public void fc1555DoYouWantToSaveMessageVerification() throws Exception
	{
		try
		{
			Assert.assertEquals(fc1555CaptureMeasurementPage.getRemoteControlMessage(FCM1555.MESSAGES.DOYOU_WANT_TO_SAVE), FCM1555.MESSAGES.DOYOU_WANT_TO_SAVE.getMessage());
			fc1555CaptureMeasurementPage.clickOncancelButtonAfterTestCompletion();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 169049, groups = {Config.FC1555}) //, Config.FC1555_UAT
	public void fc1555StopRemoteControlMessageTest() throws Exception
	{
		try
		{
			CommonUtils.wait(3);
			fc1555CaptureMeasurementPage.eeveeOptionMenu("Stop Remote Control");
			Assert.assertEquals(fc1555CaptureMeasurementPage.getRemoteControlMessage(FCM1555.MESSAGES.STOP_REMOTE_CONTROL_CONFIRMATION), FCM1555.MESSAGES.STOP_REMOTE_CONTROL_CONFIRMATION.getMessage());
			CommonUtils.wait(1);
			fc1555CaptureMeasurementPage.stopRemoteControl();
			CommonUtils.wait(1);

		}
		catch(Throwable e)
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				fc1555CaptureMeasurementPage.clickOnOkbuttonIncaseOfErrorFetchingSettings();
				CommonUtils.wait(2);
				fc1555CaptureMeasurementPage.clickOnOkbuttonIncaseOfErrorFetchingSettings();
			}
			
			switcher.switchToCaptureMeasurementsHomePage();
			Assert.fail("Exception Detail: "+e);
		}
	}


	@Test(alwaysRun = true, priority = 169051, groups = {Config.FC1555}) //, Config.FC1555_UAT
	public void fc1555StopRemoteControlTest() throws Exception
	{
		try
		{
			fc1555CaptureMeasurementPage.eeveeOptionMenu("Start Remote Control");
			fc1555CaptureMeasurementPage.eeveeRemoteControlConfirmation();
			fc1555CaptureMeasurementPage.clickOnGraphIconInRemoteControl();
			fc1555CaptureMeasurementPage.eeveeOptionMenu("Stop Remote Control");
			CommonUtils.wait(2);
			fc1555CaptureMeasurementPage.stopRemoteControl();
		}
		catch(Throwable e)
		{
			switcher.switchToCaptureMeasurementsHomePage();
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 169053, groups = {Config.FC1555}) //Config.FC1555
	public void fc1555CancelOptionTest() throws Exception
	{
		try
		{
			CommonUtils.wait(5);
			fc1555CaptureMeasurementPage.eeveeOptionMenu("Cancel");
			//fc1555CaptureMeasurementPage.eeveeOptionMenu("Disconnect");
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				fc1555CaptureMeasurementPage.clickOnBack();
			}
		}
		catch(Throwable e)
		{
			switcher.switchToMeasurementsPage();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 169054, groups = {Config.FC1555_WEB}) //Config.FC1555
	public void navigationToEeveeMeasDetailsPageInWebTest() throws Exception
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
			CommonUtils.wait(3);
			fc1555CaptureMeasurementPage.navigationToMeasurementDetailsPage();
			}
		}	
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 169055, groups = {}) //, Config.FC1555_UAT ,Config.FC1555
	public void eeveeCompResistanceValueWithGreaterThanOrLessThanAndTempValueZeroTest() throws Exception
	{
		try
		{
			switcher.switchToMeasurementsPage();
			String getDate=fc1555CaptureMeasurementPage.getEeveeMeasurementDate();
			//CommonUtils.wait(5);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, getDate, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, getDate, null, null).click();
			fc1555CaptureMeasurementPage.coachMarkClosure();
			String primaryValue=fc1555CaptureMeasurementPage.testResultData(FCM1555.TEST_RESULTS.PRIMARY_VALUE);
			CommonUtils.wait(5);
			gestureUtils.swipe(ScrollDiection.LEFT, ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/viewpager", LocatorStrategy.IOS_LOCATOR_STRATEGY_CLASS_NAME, "XCUIElementTypeCell", LocatorStrategy.NONE, null), 150);
			CommonUtils.wait(5);
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				CommonUtils.wait(5);
				Assert.assertEquals(fc1555CaptureMeasurementPage.compensatedresistance(CommonUtils.split(primaryValue, " ")[0],"00"), fc1555CaptureMeasurementPage.getCompensationresistance());
			}
			else
			{
				Assert.assertEquals(fc1555CaptureMeasurementPage.compensatedresistance(CommonUtils.split(primaryValue, " ")[0],"00"), fc1555CaptureMeasurementPage.getCompensationresistance());
			}
			CommonUtils.wait(10);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "back_button", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Save", null, null).click();
		}
		catch(Throwable e)
		{
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "back_button", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Back", null, null).click();
			ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Cancel", null, null).click();
			switcher.switchToMeasurementsPage();
			
			//fc1555CaptureMeasurementPage.doneAndDisconnectDevice(1);
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 169057, groups = {}) //, Config.FC1555_UAT,Config.FC1555
	public void eeveeCompResistanceValueWithGreaterThanOrLessThanTest() throws Exception
	{
		try
		{
			switcher.switchToMeasurementsPage();

			String getDate=fc1555CaptureMeasurementPage.getEeveeMeasurementDate();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,getDate,LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,getDate,null,null).click();
			String primaryValue=fc1555CaptureMeasurementPage.testResultData(FCM1555.TEST_RESULTS.PRIMARY_VALUE);
			gestureUtils.swipe(ScrollDiection.LEFT, ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/viewpager", LocatorStrategy.IOS_LOCATOR_STRATEGY_XPATH, "//XCUIElementTypeStaticText[@name=\"added date\"]/following-sibling::XCUIElementTypeOther", null, null), 150);
			CommonUtils.wait(5);
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				CommonUtils.wait(5);
				Assert.assertEquals(fc1555CaptureMeasurementPage.compensatedresistance(CommonUtils.split(primaryValue, " ")[0],"10"), fc1555CaptureMeasurementPage.getCompensationresistance());
			}
			else
			{
				Assert.assertEquals(fc1555CaptureMeasurementPage.compensatedresistance(CommonUtils.split(primaryValue, " ")[0],"10"), fc1555CaptureMeasurementPage.getCompensationresistance());
			}
			CommonUtils.wait(5);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "back_button", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Save", null, null).click();
		}
		catch(Throwable e)
		{
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "back_button", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Back", null, null).click();
			ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Cancel", null, null).click();
			switcher.switchToMeasurementsPage();
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 169059, groups = {}) //, Config.FC1555_UAT ,Config.FC1555
	public void eeveeCompResistanceValueWithoutGreaterThanOrLessThanAndTempValueZeroTest() throws Exception
	{
		try
		{
			switcher.switchToMeasurementsPage();
			String getDate=fc1555CaptureMeasurementPage.getEeveeMeasurementDate();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,getDate,LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,getDate,null,null).click();
			//fc1555CaptureMeasurementPage.coachMarkClosure();
			String primaryValue=fc1555CaptureMeasurementPage.testResultData(FCM1555.TEST_RESULTS.PRIMARY_VALUE);

			System.out.println("primary : "+primaryValue);
			gestureUtils.swipe(ScrollDiection.LEFT, ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/viewpager", LocatorStrategy.IOS_LOCATOR_STRATEGY_CLASS_NAME, "XCUIElementTypeCell", LocatorStrategy.NONE, null), 150);
			CommonUtils.wait(5);
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				CommonUtils.wait(5);
				Assert.assertEquals(fc1555CaptureMeasurementPage.compensatedresistance(CommonUtils.split(primaryValue, " ")[0],"00"), fc1555CaptureMeasurementPage.getCompensationresistance());
			}
			else
			{
				Assert.assertEquals(fc1555CaptureMeasurementPage.compensatedresistance(CommonUtils.split(primaryValue, " ")[0],"00"), fc1555CaptureMeasurementPage.getCompensationresistance());
			}
			CommonUtils.wait(5);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "back_button", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Save", null, null).click();
		}
		catch(Throwable e)
		{
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "back_button", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Back", null, null).click();
			ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Cancel", null, null).click();
			switcher.switchToMeasurementsPage();
			//fc1555CaptureMeasurementPage.doneAndDisconnectDevice(1);
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 169061, groups = {}) //, Config.FC1555_UAT ,Config.FC1555
	public void eeveeCompResistanceValueWithoutGreaterThanOrLessThanAndTempValueNonZeroTest() throws Exception
	{
		try
		{
			switcher.switchToMeasurementsPage();
			String getDate=fc1555CaptureMeasurementPage.getEeveeMeasurementDate();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,getDate,LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,getDate,null,null).click();
			String primaryValue=fc1555CaptureMeasurementPage.testResultData(FCM1555.TEST_RESULTS.PRIMARY_VALUE);

			gestureUtils.swipe(ScrollDiection.LEFT, ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/viewpager", LocatorStrategy.IOS_LOCATOR_STRATEGY_CLASS_NAME, "XCUIElementTypeCell", LocatorStrategy.NONE, null), 150);
			CommonUtils.wait(5);
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				CommonUtils.wait(5);
				Assert.assertEquals(fc1555CaptureMeasurementPage.compensatedresistance(CommonUtils.split(primaryValue, " ")[0],"13"), fc1555CaptureMeasurementPage.getCompensationresistance());
			}
			else
			{
				Assert.assertEquals(fc1555CaptureMeasurementPage.compensatedresistance(CommonUtils.split(primaryValue, " ")[0],"13"), fc1555CaptureMeasurementPage.getCompensationresistance());
			}
			CommonUtils.wait(5);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "back_button", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Save", null, null).click();
		}
		catch(Throwable e)
		{
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "back_button", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Back", null, null).click();
			ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Cancel", null, null).click();
			switcher.switchToMeasurementsPage();
			//fc1555CaptureMeasurementPage.doneAndDisconnectDevice(1);
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 169063, groups = {Config.FC1555, Config.ANDROID_FC1555_EXT_SMOKE_TESTS, Config.ANDROID_SMOKE_EXTENDED_TESTS})
	public void fc1555AssetAssignment() throws Exception
	{
		try
		{
			switcher.switchToMeasurementsPage();
			String getDate=fc1555CaptureMeasurementPage.getEeveeMeasurementDate();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,getDate,LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,getDate,null,null).click();
			fc1555CaptureMeasurementPage.coachMarkClosure();
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				CommonUtils.wait(10);
				measurementsHistoryPage.assignAsset("eevee automation", "eevee test", "eevee test");
				measurementDetailPage.youAreOnTrackCoarchMarkInDetailsPage();
				CommonUtils.wait(5);
			}
			else
			{
				CommonUtils.wait(5);
				fc1555CaptureMeasurementPage.clickOnAssignAssetCell();
				CommonUtils.wait(5);
				ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, "eevee automation", null, null).click();
				ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_XPATH, "(//XCUIElementTypeStaticText[@name=\"eevee test\"])[3]", null, null).click();
				ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "eevee test", null, null).click();
				ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Save", null, null).click();
			}
			CommonUtils.wait(2);
		}
		catch(Throwable e)
		{
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"back_button",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"Back",null,null).click();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"action_bar_item_left",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"backBarButton",null,null).click();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"action_bar_item_left",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"backBarButton",null,null).click();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"action_bar_item_left",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"backBarButton",null,null).click();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"back_button",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"Back",null,null).click();
			//fc1555CaptureMeasurementPage.doneAndDisconnectDevice(1);
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 169064, groups = {Config.FC1555, Config.ANDROID_FC1555_EXT_SMOKE_TESTS,Config.ANDROID_SMOKE_EXTENDED_TESTS})
	public void fc1555ClearAssetAssignment() throws Exception
	{
		try
		{
			switcher.switchToMeasurementsPage();
			String getDate=fc1555CaptureMeasurementPage.getEeveeMeasurementDate();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,getDate,LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,getDate,null,null).click();
			//fc1555CaptureMeasurementPage.coachMarkClosure();
			CommonUtils.wait(2);
			fc1555CaptureMeasurementPage.clickOnAssignAssetCell();
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				CommonUtils.wait(2);
				assetsPage.navigationToAssetTestPoint("eevee automation", "eevee test");
				CommonUtils.wait(2);

			}
			else
			{
				ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, "eevee automation", null, null).click();
				CommonUtils.wait(2);
				ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_XPATH, "(//XCUIElementTypeStaticText[@name=\"eevee test\"])[3]", null, null).click();
			}
			CommonUtils.wait(1);
			assetsPage.clickClearAssignment();
			CommonUtils.wait(1);
			measurementsHistoryPage.clickOnDoneButton();
		}
		catch(Throwable e)
		{
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"back_button",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"Back",null,null).click();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"action_bar_item_left",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"backBarButton",null,null).click();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"action_bar_item_left",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"backBarButton",null,null).click();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"action_bar_item_left",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"backBarButton",null,null).click();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"back_button",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"Back",null,null).click();
			//fc1555CaptureMeasurementPage.doneAndDisconnectDevice(1);
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 169067, groups = {Config.FC1555, Config.ANDROID_FC1555_EXT_SMOKE_TESTS}) //Config.ANDROID_SMOKE_EXTENDED_TESTS
	public void fc1555DeviceMeasWOAssignTest() throws Exception
	{
		try
		{
			switcher.switchToMeasurementsPage();
		/*	if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				gestureUtils.androidScroll(100);
			}*/
			String getDate=fc1555CaptureMeasurementPage.getEeveeMeasurementDate();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,getDate,LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS,getDate,null,null).click();
			//CommonUtils.wait(5);
			//fc1555CaptureMeasurementPage.coachMarkClosure();
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				CommonUtils.wait(10);
				measurementDetailPage.assignWorkOrder(FCM1555.measurementAssignedWorkOrderTile[0]);
			}
			else
			{
				CommonUtils.wait(2);
				measurementDetailPage.assignWorkOrder(FCM1555.measurementAssignedWorkOrderTile[1]);
				//ElementUtils.getElement(null,null,LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"Work Order",null,null).click();
				CommonUtils.wait(2);
			//	ElementUtils.getElement(null,null,LocatorStrategy.IOS_LOCATOR_STRATEGY_XPATH,"(//XCUIElementTypeStaticText[@name=\"1\"])[2]",null,null).click();
				
			}
		}
		catch(Throwable e)
		{	
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"com.fluke.deviceApp:id/action_cancel",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"Cancel",null,null).click();
			fc1555CaptureMeasurementPage.clickBackORDoneButton();
			ElementUtils.getElement(null,null,LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"Back",null,null).click();
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 169069, groups = {Config.ANDROID_FC1555_EXT_SMOKE_TESTS, Config.FC1555, Config.ANDROID_SMOKE_EXTENDED_TESTS})
	public void fc1555ShareMeasurementDetailsInCSVFormatTest() throws Exception
	{
		try
		{
			switcher.switchToMeasurementsPage();
			String getDate=fc1555CaptureMeasurementPage.getEeveeMeasurementDate();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,getDate,LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS,getDate,null,null).click();
			//fc1555CaptureMeasurementPage.coachMarkClosure();
			CommonUtils.wait(1);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/menu_share", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Share", null, null).click();
			CommonUtils.wait(2);
			measurementDetailPage.shareMeasurement("fluketestnote5@gmail.com", DataType.MEASUREMENT_DATA, ShareFormat.CSV, false);
			CommonUtils.wait(2);
			//ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "back_button", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Back", null, null).click();
		}
		catch(Throwable e)
		{
			fc1555CaptureMeasurementPage.clickBackButton();
			//fc1555CaptureMeasurementPage.doneAndDisconnectDevice(1);
			Assert.fail("Exception Detail: "+e);
		}
	}
	

	

	@Test(alwaysRun = true, priority = 169071, groups = {Config.ANDROID_FC1555_EXT_SMOKE_TESTS, Config.FC1555, Config.ANDROID_SMOKE_EXTENDED_TESTS})
	public void fc1555ShareMeasurementDetailsInXLSFormatTest() throws Exception
	{
		try
		{
			CommonUtils.wait(1);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/menu_share", LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Share", null, null).click();
			CommonUtils.wait(2);
			measurementDetailPage.shareMeasurement("fluketestnote5@gmail.com", DataType.MEASUREMENT_DATA, ShareFormat.XLS, false);
			CommonUtils.wait(1);
			fc1555CaptureMeasurementPage.clickBackORDoneButton();
		}
		catch(Throwable e)
		{
			fc1555CaptureMeasurementPage.clickBackButton();
			//fc1555CaptureMeasurementPage.doneAndDisconnectDevice(1);
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 169073, groups = {Config.FC1555, Config.ANDROID_FC1555_EXT_SMOKE_TESTS}) //Config.ANDROID_SMOKE_EXTENDED_TESTS
	public void isWorkOrderAssignedTo1555FCTest()
	{
		try
		{
			CommonUtils.wait(1);
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				//gestureUtils.androidScroll(50);
				Assert.assertTrue(measurementDetailPage.isWorkOrderAssigned(FCM1555.measurementAssignedWorkOrderNumber[0]));
			}
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				Assert.assertEquals(ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Assigned Work Order Label", null, null).getText(), FCM1555.measurementAssignedWorkOrderNumber[1]);
			}
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				ElementUtils.getElement(null,null,LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"Save",null,null).click();
			}
			else
			{
				fc1555CaptureMeasurementPage.clickBackORDoneButton();
			}

		}
		catch(Throwable e)
		{
			//ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"action_cancel",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"Cancel",null,null).click();
			//ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"Cancel",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"Back",null,null).click();
			fc1555CaptureMeasurementPage.clickBackButton();
			fc1555CaptureMeasurementPage.clickBackORDoneButton();
			switcher.switchToCaptureMeasurementsHomePage();
			fc1555CaptureMeasurementPage.connectToRealDevice("IR 3000 FC");
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 169075, groups = {Config.FC1555})
	public void fc1555ConnectionForRemoteControlTest()
	{
		try
		{
			switcher.switchToCaptureMeasurementsHomePage();
			CommonUtils.wait(5);
			//fc1555CaptureMeasurementPage.connectToRealDeviceAndroidPopUpHandle();
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				fc1555CaptureMeasurementPage.connectToRealDevice("IR 3000 FC");
			}

		}
		catch(Throwable e)
		{
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"action_cancel",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"Cancel",null,null).click();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"Cancel",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"Back",null,null).click();
			fc1555CaptureMeasurementPage.clickBackButton();
			fc1555CaptureMeasurementPage.clickBackORDoneButton();
			switcher.switchToCaptureMeasurementsHomePage();
			fc1555CaptureMeasurementPage.connectToRealDevice("IR 3000 FC");
			Assert.fail("Exception Detail: "+e);
		}
	}


	@Test(alwaysRun = true, dataProvider = "eeveeTestData", dataProviderClass = FCM1555.class, priority = 169077, groups = {Config.FC1555})
	public void fc1555RemoteControlDataDrivenTest(String voltage, String type, String time) throws Throwable
	{
		//switcher.switchToCaptureMeasurementsHomePage();
		//fc1555CaptureMeasurementPage.connectToRealDeviceAndroidPopUpHandle();
		//fc1555CaptureMeasurementPage.connectToRealDevice("IR 3000 FC");
		fc1555CaptureMeasurementPage.eeveeOptionMenu("Start Remote Control");
		fc1555CaptureMeasurementPage.eeveeRemoteControlConfirmation();
		fc1555CaptureMeasurementPage.clickOnGraphIconInRemoteControl();
		CommonUtils.wait(2);
		fc1555CaptureMeasurementPage.eeveeTestFunctionSetting();
		try
		{
			CommonUtils.wait(5);
			fc1555CaptureMeasurementPage.getCaptureEeveeMeasurementsPageObject(CaptureEeveeMeasurementsPageObject.TEST_VOLTAGE_DROPDOWN_BUTTON).click();
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, voltage, LocatorStrategy.NONE, null, LocatorStrategy.NONE, null).click();
			}
			else
			{
				for(int i = 0;i < FCM1555.getPickerLoopCountTestVoltage.get(voltage); i++)
				{
					gestureUtils.scrollIOSPickerWheel(fc1555CaptureMeasurementPage.getCaptureEeveeMeasurementsPageObject(CaptureEeveeMeasurementsPageObject.IOS_PICKER_WHEEL), ScrollDiection.NEXT);
				}
				ElementUtils.safeClick("Done", null, null);
			}
			CommonUtils.wait(5);
			fc1555CaptureMeasurementPage.getCaptureEeveeMeasurementsPageObject(CaptureEeveeMeasurementsPageObject.TEST_TYPE_DROPDOWN_BUTTON).click();
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, type, LocatorStrategy.NONE, null, LocatorStrategy.NONE, null).click();
			}
			else
			{
				for(int i=0; i< FCM1555.getPickerLoopCountTestType.get(type); i++)
				{
					gestureUtils.scrollIOSPickerWheel(fc1555CaptureMeasurementPage.getCaptureEeveeMeasurementsPageObject(CaptureEeveeMeasurementsPageObject.IOS_PICKER_WHEEL), ScrollDiection.NEXT);
				}
				ElementUtils.safeClick("Done", null, null);
			}
			CommonUtils.wait(5);
			fc1555CaptureMeasurementPage.getCaptureEeveeMeasurementsPageObject(CaptureEeveeMeasurementsPageObject.TIME_LIMIT_DROPDOWN_BUTTON).click();
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, time, LocatorStrategy.NONE, null, LocatorStrategy.NONE, null).click();
			}
			else
			{
				for(int i=0; i< FCM1555.getPickerLoopCountTestDuration.get(time); i++)
				{
					gestureUtils.scrollIOSPickerWheel(fc1555CaptureMeasurementPage.getCaptureEeveeMeasurementsPageObject(CaptureEeveeMeasurementsPageObject.IOS_PICKER_WHEEL), ScrollDiection.NEXT);
				}
				ElementUtils.safeClick("Done", null, null);
			}
			CommonUtils.wait(10);
			try 
			{
				if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				{
					fc1555CaptureMeasurementPage.clickOnOkbuttonIncaseOfErrorFetchingSettings();
				}
			}
			catch(Throwable e) 
			{
				System.out.println("Element not Present");
			}
			
			fc1555CaptureMeasurementPage.clickOnDoneButtonAfterFunctionSetting();
			
			try 
			{
				if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				{
					fc1555CaptureMeasurementPage.clickOnOkbuttonIncaseOfErrorFetchingSettings();
				}
			}
			catch(Throwable e) 
			{
				System.out.println("Element not Present");
			}

			fc1555CaptureMeasurementPage.eeveeRemoteControlStartTestRun();

			CommonUtils.wait(Integer.parseInt(time) * 60 + 5);
		/*	if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				fc1555CaptureMeasurementPage.eeveeRemoteControlStopTestRun();
			} */

			fc1555CaptureMeasurementPage.eeveeRemoteControlTestCompletion();

			fc1555CaptureMeasurementPage.coachMarkClosure();
			CommonUtils.wait(5);
			String getDate=fc1555CaptureMeasurementPage.getEeveeMeasurementDate();

			String [] getTestResultData=
				{fc1555CaptureMeasurementPage.testResultData(FCM1555.TEST_RESULTS.TEST_RESULT_HEADER),
						fc1555CaptureMeasurementPage.testResultData(FCM1555.TEST_RESULTS.TEST_DURATION),
						fc1555CaptureMeasurementPage.testResultData(FCM1555.TEST_RESULTS.PRIMARY_VALUE),
						fc1555CaptureMeasurementPage.testResultData(FCM1555.TEST_RESULTS.SECONDARY_VALUE),
						fc1555CaptureMeasurementPage.testResultData(FCM1555.TEST_RESULTS.TERTIARY_VALUE)};
/*
			gestureUtils.swipe(ScrollDiection.LEFT, ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/viewpager", LocatorStrategy.IOS_LOCATOR_STRATEGY_CLASS_NAME, "XCUIElementTypeCell", LocatorStrategy.NONE, null), 150);

			String [] getCompensationData=
				{fc1555CaptureMeasurementPage.compensationData(FCM1555.COMPENSATION_DATA.COMPENSATION_HEADER),
						fc1555CaptureMeasurementPage.compensationData(FCM1555.COMPENSATION_DATA.COMPENSATION_RESISTANCE),
						fc1555CaptureMeasurementPage.compensationData(FCM1555.COMPENSATION_DATA.COMPENSATION_TEMPRATURE),
						fc1555CaptureMeasurementPage.compensationData(FCM1555.COMPENSATION_DATA.COMPENSATION_HUMIDITY)};

			gestureUtils.swipe(ScrollDiection.LEFT, ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/viewpager", LocatorStrategy.IOS_LOCATOR_STRATEGY_CLASS_NAME, "XCUIElementTypeCell", LocatorStrategy.NONE, null), 150);

			String [] getTestConditionData=
				{fc1555CaptureMeasurementPage.getTestConditionData(FCM1555.TEST_CONDITIONS.TEST_CONDITIONS),
						fc1555CaptureMeasurementPage.getTestConditionData(FCM1555.TEST_CONDITIONS.VOLTAGE),
						fc1555CaptureMeasurementPage.getTestConditionData(FCM1555.TEST_CONDITIONS.RAMP),
						fc1555CaptureMeasurementPage.getTestConditionData(FCM1555.TEST_CONDITIONS.TIME_LIMIT),
						fc1555CaptureMeasurementPage.getTestConditionData(FCM1555.TEST_CONDITIONS.TEST_ENDED)};

			gestureUtils.swipe(ScrollDiection.LEFT, ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/viewpager", LocatorStrategy.IOS_LOCATOR_STRATEGY_CLASS_NAME, "XCUIElementTypeCell", LocatorStrategy.NONE, null), 150);

			String [] getCalculatedResultData=
				{fc1555CaptureMeasurementPage.calculatedResultData(FCM1555.CALCUTLATED_RESULTS.CALCULATED_RESULTS),
						fc1555CaptureMeasurementPage.calculatedResultData(FCM1555.CALCUTLATED_RESULTS.CAPACITANCE),
						fc1555CaptureMeasurementPage.calculatedResultData(FCM1555.CALCUTLATED_RESULTS.PI),
						fc1555CaptureMeasurementPage.calculatedResultData(FCM1555.CALCUTLATED_RESULTS.DAR)};

			gestureUtils.swipe(ScrollDiection.LEFT, ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/viewpager", LocatorStrategy.IOS_LOCATOR_STRATEGY_CLASS_NAME, "XCUIElementTypeCell", LocatorStrategy.NONE, null), 150);

			fc1555CaptureMeasurementPage.checkForGraphAvailability();
			CommonUtils.wait(5);
			
	*/		
			fc1555CaptureMeasurementPage.clickBackORDoneButton();
			//if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			//{
			//fc1555CaptureMeasurementPage.eeveeOptionMenu("Disconnect");
			//}
			fc1555CaptureMeasurementPage.clickOnBack();
			try 
			{
			switcher.switchToMeasurementsPage();

			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,getDate,LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,getDate,null,null).click();
			Assert.assertEquals(fc1555CaptureMeasurementPage.testResultData(FCM1555.TEST_RESULTS.TEST_RESULT_HEADER), getTestResultData[0]);
			Assert.assertEquals(fc1555CaptureMeasurementPage.testResultData(FCM1555.TEST_RESULTS.TEST_DURATION), getTestResultData[1]);
			Assert.assertEquals(fc1555CaptureMeasurementPage.testResultData(FCM1555.TEST_RESULTS.PRIMARY_VALUE), getTestResultData[2]);
			Assert.assertEquals(fc1555CaptureMeasurementPage.testResultData(FCM1555.TEST_RESULTS.SECONDARY_VALUE), getTestResultData[3]);
			Assert.assertEquals(fc1555CaptureMeasurementPage.testResultData(FCM1555.TEST_RESULTS.TERTIARY_VALUE), getTestResultData[4]);

/*			gestureUtils.swipe(ScrollDiection.LEFT, ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/viewpager", LocatorStrategy.IOS_LOCATOR_STRATEGY_CLASS_NAME, "XCUIElementTypeCell", LocatorStrategy.NONE, null), 150);

			Assert.assertEquals(fc1555CaptureMeasurementPage.compensationData(FCM1555.COMPENSATION_DATA.COMPENSATION_HEADER), getCompensationData[0]);
			Assert.assertEquals(fc1555CaptureMeasurementPage.compensationData(FCM1555.COMPENSATION_DATA.COMPENSATION_RESISTANCE), getCompensationData[1]);
			Assert.assertEquals(fc1555CaptureMeasurementPage.compensationData(FCM1555.COMPENSATION_DATA.COMPENSATION_TEMPRATURE), getCompensationData[2]);
			Assert.assertEquals(fc1555CaptureMeasurementPage.compensationData(FCM1555.COMPENSATION_DATA.COMPENSATION_HUMIDITY), getCompensationData[3]);

			gestureUtils.swipe(ScrollDiection.LEFT, ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/viewpager", LocatorStrategy.IOS_LOCATOR_STRATEGY_CLASS_NAME, "XCUIElementTypeCell", LocatorStrategy.NONE, null), 150);

			Assert.assertEquals(fc1555CaptureMeasurementPage.getTestConditionData(FCM1555.TEST_CONDITIONS.TEST_CONDITIONS), getTestConditionData[0]);
			Assert.assertEquals(fc1555CaptureMeasurementPage.getTestConditionData(FCM1555.TEST_CONDITIONS.VOLTAGE), getTestConditionData[1]);
			Assert.assertEquals(fc1555CaptureMeasurementPage.getTestConditionData(FCM1555.TEST_CONDITIONS.RAMP), getTestConditionData[2]);
			Assert.assertEquals(fc1555CaptureMeasurementPage.getTestConditionData(FCM1555.TEST_CONDITIONS.TIME_LIMIT), getTestConditionData[3]);
			Assert.assertEquals(fc1555CaptureMeasurementPage.getTestConditionData(FCM1555.TEST_CONDITIONS.TEST_ENDED), getTestConditionData[4]);

			gestureUtils.swipe(ScrollDiection.LEFT, ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/viewpager", LocatorStrategy.IOS_LOCATOR_STRATEGY_CLASS_NAME, "XCUIElementTypeCell", LocatorStrategy.NONE, null), 150);

			Assert.assertEquals(fc1555CaptureMeasurementPage.calculatedResultData(FCM1555.CALCUTLATED_RESULTS.CALCULATED_RESULTS), getCalculatedResultData[0]);
			Assert.assertEquals(fc1555CaptureMeasurementPage.calculatedResultData(FCM1555.CALCUTLATED_RESULTS.CAPACITANCE), getCalculatedResultData[1]);
			Assert.assertEquals(fc1555CaptureMeasurementPage.calculatedResultData(FCM1555.CALCUTLATED_RESULTS.PI), getCalculatedResultData[2]);
			Assert.assertEquals(fc1555CaptureMeasurementPage.calculatedResultData(FCM1555.CALCUTLATED_RESULTS.DAR), getCalculatedResultData[3]);

			gestureUtils.swipe(ScrollDiection.LEFT, ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/viewpager", LocatorStrategy.IOS_LOCATOR_STRATEGY_CLASS_NAME, "XCUIElementTypeCell", LocatorStrategy.NONE, null), 150);

			fc1555CaptureMeasurementPage.checkForGraphAvailability();
			*/
			} 
			
			catch(Throwable e)
			{	
				fc1555CaptureMeasurementPage.clickBackORDoneButton();
			}
			
			
			fc1555CaptureMeasurementPage.clickBackORDoneButton();
			fc1555CaptureMeasurementPage.clickOnBack();
			switcher.switchToCaptureMeasurementsHomePage();

			CommonUtils.wait(3);
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				fc1555CaptureMeasurementPage.connectToRealDevice("IR 3000 FC");
			}
		}

		catch(Throwable e)
		{	
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "cancel white", null, null).click();
			}
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				fc1555CaptureMeasurementPage.clickOncancelButtonAfterTestCompletion();
				fc1555CaptureMeasurementPage.eeveeOptionMenu("Stop Remote Control");
				fc1555CaptureMeasurementPage.stopRemoteControl();
			}
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
			fc1555CaptureMeasurementPage.eeveeOptionMenu("Stop Remote Control");
			fc1555CaptureMeasurementPage.stopRemoteControl();
			}
			fc1555CaptureMeasurementPage.clickOnDoneButton();

			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				fc1555CaptureMeasurementPage.clickOnBack();
			}
			switcher.switchToCaptureMeasurementsHomePage();
			fc1555CaptureMeasurementPage.connectToRealDevice("IR 3000 FC");
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 169079, groups = {Config.FC1555, Config.FC1555_UAT})
	public void fc1555Disconnect() throws Exception
	{
		try
		{
			fc1555CaptureMeasurementPage.eeveeOptionMenu("Disconnect");
		}
		catch(Throwable e)
		{
			switcher.switchToCaptureMeasurementsHomePage();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 169150, groups = {}) //Config.ANDROID_SMOKE_EXTENDED_TESTS
	public void simulatedDongleDeviceConnection() throws Exception
	{
		try
		{
			switcher.switchToCaptureMeasurementsHomePage();
			fc1555CaptureMeasurementPage.connectToRealDeviceAndroidPopUpHandle();
			fc1555CaptureMeasurementPage.connectToRealDevice("Simulation Dongle");
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 169151, groups = {})//Config.ANDROID_SMOKE_EXTENDED_TESTS
	public void simulateddongleMeasCaptureTest() throws Exception
	{
		try
		{
			fc1555CaptureMeasurementPage.captureRealDeviceMeasurement();
			fc1555CaptureMeasurementPage.coachMarkClosure();
		}
		catch(Throwable e)
		{
			fc1555CaptureMeasurementPage.clickBackORDoneButton();
			//fc1555CaptureMeasurementPage.doneAndDisconnectDevice(1);
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 169153, groups = {})//Config.ANDROID_SMOKE_EXTENDED_TESTS
	public void simulatedDeviceMeasAssetAssignment() throws Exception
	{
		try
		{
				CommonUtils.wait(15);
				measurementsHistoryPage.assignAsset("eevee automation", "eevee test", "eevee test");
				CommonUtils.wait(5);
		}
		catch(Throwable e)
		{
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"back_button",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"Back",null,null).click();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"action_bar_item_left",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"backBarButton",null,null).click();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"action_bar_item_left",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"backBarButton",null,null).click();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"action_bar_item_left",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"backBarButton",null,null).click();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID,"back_button",LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"Back",null,null).click();
			//fc1555CaptureMeasurementPage.doneAndDisconnectDevice(1);
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 169155, groups = {})//Config.ANDROID_SMOKE_EXTENDED_TESTS
	public void deleteMeasurementCreatedfromSimulatedDeviceTest() throws Exception
	{
		try
		{
				switcher.switchToMeasurementsPage();
				String getDate=fc1555CaptureMeasurementPage.getEeveeMeasurementDate();
				ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,getDate,LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS,getDate,null,null).click();
				fc1555CaptureMeasurementPage.coachMarkClosure();
				measurementDetailPage.deleteMeasurement();
		}
		catch(Throwable e)
		{
			fc1555CaptureMeasurementPage.clickOnDoneButton();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	//########  Evee Asset Analysis Test Case Started Here ############///
	
	
	@Test(alwaysRun = true, priority = 169200, groups = {Config.FC1555_ANALYSIS})
	public void  addEveeMeasurementOnAnalysisPage() throws Exception
	{
		try
		{
			switcher.switchToAssetsPage();
			assetsPage.clickOnAssetGroupName(FCM1555.EveeAssetAnalsysisGroup);
			assetsPage.addAsset(FCM1555.EveeAsset, Asset.ASSETCONFIG.ASSET_TYPE.getAssetConfig(), asset.statusFilter().get(0));	
			assetsAnalysisPage.clickOnAssetInMobileForAssetAnalysis(FCM1555.EveeAsset);
			assetsAnalysisPage.addDataOnAnalaysisPage();
			if(DriverManager.getDriverName().equals("iOS"))
			{
				assetsAnalysisPage.selectFilter("Measurements");
				assetsAnalysisPage.enterTheMeasurementName(Asset.ASSET_ANALYSIS.EVEE_MEASUREMENT.getAnalysisConfig());
				assetsAnalysisPage.clickOnMeasruement(Asset.ASSET_ANALYSIS.EVEE_MEASUREMENT.getAnalysisConfig(), 2);
			}
			else if(DriverManager.getDriverName().equals("Android")||DriverManager.getDriverName().equals("Web"))
			{
				assetsAnalysisPage.selectMeasurementInAndroidAndWeb(Asset.MEASUREMENT_NAME.EVEE);
			}
			assetsAnalysisPage.clickOnAddMeasurementButton();
			CommonUtils.wait(5);
			Assert.assertTrue(assetsAnalysisPage.verifyGraph("Evee"));
			//assetsPage.clickOnBackButton();
		//	assetsPage.clickOnAssetGroupName(FCM1555.EveeAssetAnalsysisGroup);	
			//assetsPage.deleteAsset(Asset.ALARM_NAME.CURRENT_ALARM.getAlarmName().toString());


			//fc1555CaptureMeasurementPage.eeveeOptionMenu("Disconnect");
		}
		catch(Throwable e)
		{
			assetsAnalysisPage.clickOnCancelButton();
			//assetsPage.clickOnBackButton();
			//assetsPage.clickOnAssetGroupName(Asset.ASSETCONFIG.ASSET_GROUP_ALARM.getAssetConfig());	
			//assetsPage.deleteAsset(Asset.ALARM_NAME.CURRENT_ALARM.getAlarmName().toString());
			Assert.fail(e.toString());
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 169201, groups = {Config.FC1555_ANALYSIS})
	public void  verifyEveePrimaryValue()
	{
		int carouselImageCount=fc1555CaptureMeasurementPage.getCarouselSize();
		for(int count=0;count<carouselImageCount;count++)
		{
			String unit=fc1555CaptureMeasurementPage.unitConversion(count);
			Assert.assertEquals(unit,fc1555CaptureMeasurementPage.toolTipPrimaryValue.getText());
		}
	}

	/*
	@Test(alwaysRun = true, priority = 4320, groups = {"CNX_Tool_Connections"})
	public void T3000FCRealDeviceConnectionTest() throws Exception
	{
		try
		{
			fc1555CaptureMeasurementPage.connectToRealDevice("T3000");
			fc1555CaptureMeasurementPage.saveMeasurement();
			fc1555CaptureMeasurementPage.clickOnDoneButton();
		}
		catch(Throwable e)
		{
			fc1555CaptureMeasurementPage.doneAndDisconnectDevice(1);
		}
	}

	@Test(alwaysRun = true, priority = 4327, groups = {"CNX_Tool_Connections"})
	public void A3002FCRealDeviceConnectionTest() throws Exception
	{
		try
		{
			fc1555CaptureMeasurementPage.connectToRealDevice("A3002");
			fc1555CaptureMeasurementPage.saveMeasurement();
			fc1555CaptureMeasurementPage.clickOnDoneButton();
		}

		catch(Exception e)
		{
			Assert.fail("Exception Detail: "+e);
		}

	}


	@Test(alwaysRun = true, priority = 4328, groups = {"CNX_Tool_Connections"})
	public void fc1587RealDeviceConnectionTest() throws Exception
	{
		try
		{
			switcher.switchToCaptureMeasurementsHomePage();
			fc1555CaptureMeasurementPage.connectToRealDeviceAndroidPopUpHandle();
			fc1555CaptureMeasurementPage.connectToRealDevice("1587FC");
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 4329, groups = {"CNX_Tool_Connections"})
	public void fc1587EditDeviceNameVerificationTest() throws Exception
	{
		try
		{
			fc1555CaptureMeasurementPage.infoScreenVerification();

			Assert.assertEquals(fc1555CaptureMeasurementPage.getDeviceinfoStaticText(), FCM1555.expectedDeviceInfoStaticText);

			Assert.assertEquals(fc1555CaptureMeasurementPage.getDeviceNameStaticText(), FCM1555.expectedDeviceNameStaticText);

			Assert.assertEquals(fc1555CaptureMeasurementPage.getDeviceDescriptionStaticText(), FCM1555.expectedDeviceDescriptionStaticText);

			Assert.assertEquals(fc1555CaptureMeasurementPage.getLoggingDeviceDescriptionStaticText(), FCM1555.expectedDeviceDescriptionFor1587FCStaticText);

			//Assert.assertEquals(fc1555CaptureMeasurementPage.getLoggingDeviceConnectionStaticText(), FCM1555.expectedConnectionStaticText);

			fc1555CaptureMeasurementPage.deviceNameEditText("1587FC");
			fc1555CaptureMeasurementPage.clickOnDoneButtonInDeviceInfoPage();

			String deviceName=fc1555CaptureMeasurementPage.getConnectedDeviceNameInCapturePage()[0];
			Assert.assertEquals(deviceName, "1587FC");
		}
		catch(Exception e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 4330, groups = {"CNX_Tool_Connections"})
	public void fc1587RealDeviceMeasRecordingTest() throws Exception
	{
		try
		{
			fc1555CaptureMeasurementPage.recordRealDeviceMeasurement(5);
			fc1555CaptureMeasurementPage.coachMarkClosure();
			String getCaptureDate=fc1555CaptureMeasurementPage.getMeasurementCaptureDate();
			String [] getMeasurementUnits= {fc1555CaptureMeasurementPage.getMeasurementUnitForRecordedGraph()};
			fc1555CaptureMeasurementPage.clickBackORDoneButton();
			switcher.switchToMeasurementsPage();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,getCaptureDate,null,null,null,null).click();

			Assert.assertEquals(fc1555CaptureMeasurementPage.getMeasurementUnitForRecordedGraph(), getMeasurementUnits[0]);
			fc1555CaptureMeasurementPage.clickBackORDoneButton();
			//switcher.switchToCaptureMeasurementsHomePage();
		}
		catch(Exception e)
		{
			fc1555CaptureMeasurementPage.clickBackORDoneButton();
			//fc1555CaptureMeasurementPage.doneAndDisconnectDevice(1);
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 4331, groups = {"CNX_Tool_Connections"})
	public void fc1587RealDeviceMeasCaptureTest() throws Exception
	{
		try
		{
			switcher.switchToCaptureMeasurementsHomePage();
			fc1555CaptureMeasurementPage.connectToRealDevice("1587FC");
			fc1555CaptureMeasurementPage.saveMeasurement();
			fc1555CaptureMeasurementPage.coachMarkClosure();
			String getCaptureDate=fc1555CaptureMeasurementPage.getMeasurementCaptureDate();
			String [] getMeasurementValue= {fc1555CaptureMeasurementPage.getMeasPrimaryValue()};
			String [] getMeasurementUnits= {fc1555CaptureMeasurementPage.getMeasurementUnitForScalarMeas()};
			fc1555CaptureMeasurementPage.clickBackORDoneButton();
			switcher.switchToMeasurementsPage();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,getCaptureDate,null,null,null,null).click();
			Assert.assertEquals(fc1555CaptureMeasurementPage.getMeasPrimaryValue(), getMeasurementValue[0]);
			Assert.assertEquals(fc1555CaptureMeasurementPage.getMeasurementUnitForScalarMeas(), getMeasurementUnits[0]);
			fc1555CaptureMeasurementPage.clickBackORDoneButton();
		}
		catch(Throwable e)
		{
			//fc1555CaptureMeasurementPage.doneAndDisconnectDevice(1);
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 4332, groups = {"CNX_Tool_Connections"})
	public void fc1587RealDeviceMeasAssetAssignmentTest() throws Exception
	{
		measurementsHistoryPage.assignAsset("eevee automation", "eevee test", "eevee test");
	}

	@Test(alwaysRun = true, priority = 4333, groups = {"CNX_Tool_Connections"})
	public void fc1587RealDeviceMeasAssetClearingTest() throws Exception
	{
		try
		{
			CommonUtils.wait(10);
			fc1555CaptureMeasurementPage.clickOnAssignAssetCell(); ////Need to check this method or need to write this method
			CommonUtils.wait(5);
			assetsPage.navigationToAssetTestPoint("eevee automation", "eevee test");
			assetsPage.clickClearAssignment();
			CommonUtils.wait(3);
			fc1555CaptureMeasurementPage.clickBackORDoneButton();
			Assert.assertEquals(fc1555CaptureMeasurementPage.assetNameInHistoryPage(), "Unassigned");
			switcher.switchToHomePage();
		}
		catch(Throwable e)
		{
			//fc1555CaptureMeasurementPage.doneAndDisconnectDevice(1);
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 4334, groups = {"CNX_Tool_Connections"})
	public void V3000FCACRealDeviceConnectionTest() throws Exception
	{
		try
		{
			//switcher.switchToCaptureMeasurementsHomePage();
			fc1555CaptureMeasurementPage.connectToRealDeviceAndroidPopUpHandle();
			fc1555CaptureMeasurementPage.connectToRealDevice("V3000FCAutomation");
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 4335, groups = {"CNX_Tool_Connections"})
	public void v3000FCEditDeviceNameVerificationTest() throws Exception
	{
		try
		{
			fc1555CaptureMeasurementPage.infoScreenVerification();

			Assert.assertTrue(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, FCM1555.expectedDeviceInfoStaticText[0], LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, FCM1555.expectedDeviceInfoStaticText[1], null, null).isDisplayed());
			//Assert.assertEquals(fc1555CaptureMeasurementPage.getDeviceinfoStaticText(), FCM1555.expectedDeviceInfoStaticText[0]);

			Assert.assertTrue(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, FCM1555.expectedDeviceNameStaticText, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, FCM1555.expectedDeviceNameStaticText, null, null).isDisplayed());
			//Assert.assertEquals(fc1555CaptureMeasurementPage.getDeviceNameStaticText(), FCM1555.expectedDeviceNameStaticText);

			//Assert.assertTrue(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, FCM1555.expectedDeviceDescriptionStaticText, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, FCM1555.expectedDeviceDescriptionStaticText, null, null).isDisplayed());
			//Assert.assertEquals(fc1555CaptureMeasurementPage.getDeviceDescriptionStaticText(), FCM1555.expectedDeviceDescriptionStaticText);

			Assert.assertTrue(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, FCM1555.expectedDeviceDescriptionForV3000CStaticText[0], LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, FCM1555.expectedDeviceDescriptionForV3000CStaticText[1], null, null).isDisplayed());
			//Assert.assertEquals(fc1555CaptureMeasurementPage.getLoggingDeviceDescriptionStaticText(), FCM1555.expectedDeviceDescriptionForV3000CStaticText);

			Assert.assertTrue(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, FCM1555.expectedConnectionStaticText[0], LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, FCM1555.expectedConnectionStaticText[1], null, null).isDisplayed());
			//Assert.assertEquals(fc1555CaptureMeasurementPage.getLoggingDeviceConnectionStaticText(), FCM1555.expectedConnectionStaticText);

			fc1555CaptureMeasurementPage.deviceNameEditText("V3000FCAutomation");
			fc1555CaptureMeasurementPage.clickOnDoneButtonInDeviceInfoPage();

			String deviceName = ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "V3000FCAutomation", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, "V3000FCAutomation", null, null).getText();

			Assert.assertTrue(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, deviceName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, deviceName, null, null).isDisplayed());
			//String deviceName=fc1555CaptureMeasurementPage.getConnectedDeviceNameInCapturePage()[0];
			//Assert.assertEquals(deviceName, "V3000FCAutomation");
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 4336, groups = {"CNX_Tool_Connections"})
	public void v3000FCRealDeviceMeasRecordingTest() throws Exception
	{
		try
		{
			fc1555CaptureMeasurementPage.recordRealDeviceMeasurement(5);
			fc1555CaptureMeasurementPage.coachMarkClosure();
			String getCaptureDate=fc1555CaptureMeasurementPage.getMeasurementCaptureDate();
			String [] getMeasurementUnits= {fc1555CaptureMeasurementPage.getMeasurementUnitForRecordedGraph()};
			fc1555CaptureMeasurementPage.clickBackORDoneButton();
			//fc1555CaptureMeasurementPage.clickOnBackIcon();
			ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Home", null, null).click();
			switcher.switchToMeasurementsPage();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,getCaptureDate,LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,getCaptureDate,null,null).click();

			Assert.assertEquals(fc1555CaptureMeasurementPage.getMeasurementUnitForRecordedGraph(), getMeasurementUnits[0]);
			ElementUtils.getElement(null,null,LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,"Save",null,null).click();
			fc1555CaptureMeasurementPage.clickBackORDoneButton();

			//switcher.switchToCaptureMeasurementsHomePage();
		}
		catch(Throwable e)
		{
			fc1555CaptureMeasurementPage.clickBackORDoneButton();
			//fc1555CaptureMeasurementPage.doneAndDisconnectDevice(1);
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 4337, groups = {"CNX_Tool_Connections"})
	public void v3000FCRealDeviceMeasCaptureTest() throws Exception
	{
		try
		{
			switcher.switchToCaptureMeasurementsHomePage();
			fc1555CaptureMeasurementPage.connectToRealDevice("V3000FCAutomation");
			fc1555CaptureMeasurementPage.captureRealDeviceMeasurement();
			fc1555CaptureMeasurementPage.coachMarkClosure();
			String getCaptureDate=fc1555CaptureMeasurementPage.getMeasurementCaptureDate();
			String [] getMeasurementValue= {fc1555CaptureMeasurementPage.getDeviceValue()};
			String [] getMeasurementUnits= {fc1555CaptureMeasurementPage.getMeasurementUnitForRecordedGraph()};
			fc1555CaptureMeasurementPage.clickBackORDoneButton();
			switcher.switchToMeasurementsPage();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,getCaptureDate,null,null,null,null).click();
			Assert.assertEquals(fc1555CaptureMeasurementPage.getDeviceValue(), getMeasurementValue[0]);
			Assert.assertEquals(fc1555CaptureMeasurementPage.getMeasurementUnitForRecordedGraph(), getMeasurementUnits[0]);
			fc1555CaptureMeasurementPage.clickBackORDoneButton();
		}
		catch(Throwable e)
		{
			fc1555CaptureMeasurementPage.clickBackORDoneButton();
			//fc1555CaptureMeasurementPage.doneAndDisconnectDevice(1);
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 4338, groups = {"CNX_Tool_Connections"})
	public void v3000FCRealDeviceMeasAssetAssignmentTest() throws Exception
	{
		try
		{
			measurementsHistoryPage.assignAsset("eevee automation", "eevee test", "eevee test");
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}


	@Test(alwaysRun = true, priority = 4339, groups = {"CNX_Tool_Connections"})
	public void v3000FCRealDeviceMeasAssetClearingTest() throws Exception
	{
		try
		{
			switcher.switchToMeasurementsPage();
			String getCaptureDate=fc1555CaptureMeasurementPage.getDateAtHistoryPage();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,getCaptureDate,null,null,null,null).click();
			//fc1555CaptureMeasurementPage.coachMarkClosure();
			CommonUtils.wait(10);
			fc1555CaptureMeasurementPage.clickOnAssignAssetCell(); //Need to check this method or need to write this method
			CommonUtils.wait(5);
			assetsPage.navigationToAssetTestPoint("eevee automation", "eevee test");
			assetsPage.clickClearAssignment();
			CommonUtils.wait(3);
			fc1555CaptureMeasurementPage.clickBackORDoneButton();
			Assert.assertEquals(fc1555CaptureMeasurementPage.assetNameInHistoryPage(), "Unassigned");
			switcher.switchToHomePage();
		}
		catch(Throwable e)
		{	
			switcher.switchToHomePage();
			//fc1555CaptureMeasurementPage.doneAndDisconnectDevice(1);
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 4340, groups = {"CNX_Tool_Connections"})
	public void v3000FCRealDeviceMeasWOAssignTest() throws Exception
	{
		try
		{
			switcher.switchToMeasurementsPage();
			String getCaptureDate=fc1555CaptureMeasurementPage.getDateAtHistoryPage();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,getCaptureDate,null,null,null,null).click();
			fc1555CaptureMeasurementPage.coachMarkClosure();
			measurementDetailPage.assignWorkOrder(FCM1555.measurementAssignedWorkOrderTile[0]);
		}
		catch(Throwable e)
		{	
			switcher.switchToMeasurementsPage();
			//fc1555CaptureMeasurementPage.doneAndDisconnectDevice(1);
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 4341, groups = {"CNX_Tool_Connections"})
	public void isWorkOrderAssignedToV3000FCTest()
	{
		try
		{
			Assert.assertTrue(measurementDetailPage.isWorkOrderAssigned(FCM1555.measurementAssignedWorkOrderNumber[0]));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	@Test(alwaysRun = true, priority = 4342, groups = {"CNX_Tool_Connections"})
	public void v3000FCSetLoggingAndDurationStaticTextsTest()
	{
		try
		{
			switcher.switchToCaptureMeasurementsHomePage();
			fc1555CaptureMeasurementPage.connectToRealDeviceAndroidPopUpHandle();
			fc1555CaptureMeasurementPage.connectToRealDevice("V3000FCAutomation");
			fc1555CaptureMeasurementPage.infoScreenVerification();
			System.out.println(fc1555CaptureMeasurementPage.loggingStaticText(FCM1555.CNX_LOGGING_TEXTS.LOGGING_TEXT));
			Assert.assertEquals(fc1555CaptureMeasurementPage.loggingStaticText(FCM1555.CNX_LOGGING_TEXTS.LOGGING_TEXT), FCM1555.CNX_LOGGING_TEXTS.LOGGING_TEXT.getMessage());
			Assert.assertEquals(fc1555CaptureMeasurementPage.loggingStaticText(FCM1555.CNX_LOGGING_TEXTS.INTERVAL_TEXT), FCM1555.CNX_LOGGING_TEXTS.INTERVAL_TEXT.getMessage());
			Assert.assertEquals(fc1555CaptureMeasurementPage.loggingStaticText(FCM1555.CNX_LOGGING_TEXTS.DURATION_TEXT), FCM1555.CNX_LOGGING_TEXTS.DURATION_TEXT.getMessage());
			//fc1555CaptureMeasurementPage.clickOnLoggingInterval(); // Need to check this method or need to write this method
			Assert.assertEquals(fc1555CaptureMeasurementPage.loggingStaticText(FCM1555.CNX_LOGGING_TEXTS.LOGGING_SETUP_TEXT), FCM1555.CNX_LOGGING_TEXTS.LOGGING_SETUP_TEXT.getMessage());
			Assert.assertEquals(fc1555CaptureMeasurementPage.loggingStaticText(FCM1555.CNX_LOGGING_TEXTS.SET_INTERVAL_TEXT), FCM1555.CNX_LOGGING_TEXTS.SET_INTERVAL_TEXT.getMessage());
			Assert.assertEquals(fc1555CaptureMeasurementPage.loggingStaticText(FCM1555.CNX_LOGGING_TEXTS.MANUALLY_STOP_LOGGING_TEXT), FCM1555.CNX_LOGGING_TEXTS.MANUALLY_STOP_LOGGING_TEXT.getMessage());
			Assert.assertEquals(fc1555CaptureMeasurementPage.loggingStaticText(FCM1555.CNX_LOGGING_TEXTS.AUTOMATICALLY_STOP_LOGGING_TEXT), FCM1555.CNX_LOGGING_TEXTS.AUTOMATICALLY_STOP_LOGGING_TEXT.getMessage());

			Assert.assertEquals(fc1555CaptureMeasurementPage.loggingStaticText(FCM1555.CNX_LOGGING_TEXTS.LOGGING_TEXT), FCM1555.LOGGING_TEXT);
			Assert.assertEquals(fc1555CaptureMeasurementPage.loggingStaticText(FCM1555.CNX_LOGGING_TEXTS.INTERVAL_TEXT), FCM1555.INTERVAL_TEXT);
			Assert.assertEquals(fc1555CaptureMeasurementPage.loggingStaticText(FCM1555.CNX_LOGGING_TEXTS.DURATION_TEXT), FCM1555.DURATION_TEXT);
			//fc1555CaptureMeasurementPage.clickOnLoggingInterval(); //Need to check this method or need to write this method
			Assert.assertEquals(fc1555CaptureMeasurementPage.loggingStaticText(FCM1555.CNX_LOGGING_TEXTS.LOGGING_SETUP_TEXT), FCM1555.LOGGING_SETUP_TEXT);
			Assert.assertEquals(fc1555CaptureMeasurementPage.loggingStaticText(FCM1555.CNX_LOGGING_TEXTS.SET_INTERVAL_TEXT), FCM1555.SET_INTERVAL_TEXT);
			Assert.assertEquals(fc1555CaptureMeasurementPage.loggingStaticText(FCM1555.CNX_LOGGING_TEXTS.MANUALLY_STOP_LOGGING_TEXT), FCM1555.MANUALLY_STOP_LOGGING_TEXT);
			Assert.assertEquals(fc1555CaptureMeasurementPage.loggingStaticText(FCM1555.CNX_LOGGING_TEXTS.AUTOMATICALLY_STOP_LOGGING_TEXT), FCM1555.AUTOMATICALLY_STOP_LOGGING_TEXT);
			//fc1555CaptureMeasurementPage.setIntervalAndDuration("1","1"); //Need to check this method or need to write this method
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 4343, groups = {"CNX_Tool_Connections"})
	public void v3000FCClearMemory()
	{
		try
		{
			//	fc1555CaptureMeasurementPage.setIntervalAndDuration("1","1"); //Need to check this method or need to write this method
			//fc1555CaptureMeasurementPage.clearToolMemory(); //Need to check this method or need to write this method
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 4344, groups = {"CNX_Tool_Connections"})
	public void v3000FCStartAndStopLogging()
	{
		try
		{
			fc1555CaptureMeasurementPage.startAndStopLogging("1");
		}
		catch(Exception e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 4345, groups = {"CNX_Tool_Connections"})
	public void v3000FCDownloadLogMeasurement()
	{
		try
		{
			fc1555CaptureMeasurementPage.downloadLogs();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 4346, groups = {"CNX_Tool_Connections"})
	public void v3000FCVerifyDownloadLogMeasurement()
	{
		try
		{
			fc1555CaptureMeasurementPage.coachMarkClosure();
			String getCaptureDate=fc1555CaptureMeasurementPage.getMeasurementCaptureDate();
			String [] getMeasurementUnits= {fc1555CaptureMeasurementPage.getMeasurementUnitForRecordedGraph()};
			fc1555CaptureMeasurementPage.clickBackORDoneButton();
			switcher.switchToMeasurementsPage();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,getCaptureDate,null,null,null,null).click();
			Assert.assertEquals(fc1555CaptureMeasurementPage.getMeasurementUnitForRecordedGraph(), getMeasurementUnits[0]);
			fc1555CaptureMeasurementPage.clickBackORDoneButton();
		}
		catch(Exception e)
		{
			fc1555CaptureMeasurementPage.clickBackORDoneButton();
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 4347, groups = {"CNX_Tool_Connections"})
	public void v3000FCAssetAssignmentToLogMeasTest() throws Exception
	{
		try
		{
			switcher.switchToAssetsPage();
			CommonUtils.wait(2);
			switcher.switchToMeasurementsPage();
			String getCaptureDate=fc1555CaptureMeasurementPage.getDateAtHistoryPage();
			//fc1555CaptureMeasurementPage.clickBackButton();
			switcher.switchToMeasurementsPage();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,getCaptureDate,null,null,null,null).click();
			fc1555CaptureMeasurementPage.coachMarkClosure();
			CommonUtils.wait(3);
			measurementsHistoryPage.assignAsset("eevee automation", "eevee test", "eevee test");
			CommonUtils.wait(3);
			//Assert.assertEquals(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, fc1555CaptureMeasurementPage.getAssetPath(), null, null, null, null), "eevee test");
			//Assert.assertEquals(fc1555CaptureMeasurementPage.getAssetPath(), "eevee test");
		}
		catch(Throwable e)
		{

			//fc1555CaptureMeasurementPage.doneAndDisconnectDevice(1);
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 4348, groups = {"CNX_Tool_Connections"})
	public void v3000FCAssetclearingToLogMeasTest() throws Exception
	{
		try 
		{
			switcher.switchToMeasurementsPage();
			String getCaptureDate=fc1555CaptureMeasurementPage.getDateAtHistoryPage();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,getCaptureDate,null,null,null,null).click();
			//fc1555CaptureMeasurementPage.coachMarkClosure();
			CommonUtils.wait(10);
			fc1555CaptureMeasurementPage.clickOnAssignAssetCell(); //Need to check this method or need to write this method
			CommonUtils.wait(5);
			assetsPage.navigationToAssetTestPoint("eevee automation", "eevee test");
			assetsPage.clickClearAssignment();
			CommonUtils.wait(3);
			fc1555CaptureMeasurementPage.clickBackORDoneButton();
			//Assert.assertEquals(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, fc1555CaptureMeasurementPage.getAssetPath(), null, null, null, null), "Unassigned");
			switcher.switchToHomePage();
		}
		catch (Throwable e)
		{	
			switcher.switchToHomePage();
			//fc1555CaptureMeasurementPage.doneAndDisconnectDevice(1);
			Assert.fail("Exception Detail: "+e);
		}
	}


	@Test(alwaysRun = true, priority = 4349, groups = {"CNX_Tool_Connections"})
	public void v3000FCGraphMeasWOAssignTest() throws Exception
	{
		try
		{
			switcher.switchToMeasurementsPage();
			String getCaptureDate=fc1555CaptureMeasurementPage.getDateAtHistoryPage();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,getCaptureDate,null,null,null,null).click();
			fc1555CaptureMeasurementPage.coachMarkClosure();
			measurementDetailPage.assignWorkOrder(FCM1555.measurementAssignedWorkOrderTile[0]);
		}
		catch(Throwable e)
		{	
			switcher.switchToMeasurementsPage();
			//fc1555CaptureMeasurementPage.doneAndDisconnectDevice(1);
			Assert.fail("Exception Detail: "+e);
		}
	}

	@Test(alwaysRun = true, priority = 4350, groups = {"CNX_Tool_Connections"})
	public void isWorkOrderAssignedToV3000FCLogMeaseTest()
	{
		try
		{
			Assert.assertTrue(measurementDetailPage.isWorkOrderAssigned(FCM1555.measurementAssignedWorkOrderNumber[0]));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}


	}
	/*

		@Test(alwaysRun = true, priority = 6301, groups = {Config.IOS_FULL_TESTS})
		public void connectAndCaptureBeakerMeasurementTest()
		{
			try
			{
				fc1555CaptureMeasurementPage.captureBeakerMeasurementWithTemprature(Config.captureMeasurementSimulatedDeviceNameList.get("Beaker"), false, "99", "°C");
	>>>>>>> Stashed changes
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
			}
		}
	<<<<<<< Updated upstream

		@Test(priority = 9028, groups = {Config.TI_FCM1555_CAPTURE_ANDROID, Config.TI_FCM1555_CAPTURE_IOS, Config.TI_FCM1555}, dependsOnMethods = {"connectToTI400Test"})
		public void TI400MeasurementUnitTest()
	=======

		@Test(alwaysRun = true, priority = 6302, groups = {Config.IOS_FULL_TESTS})
		public void assignAssetToBeakerMeasurementTest()
	>>>>>>> Stashed changes
		{
			try
			{
				measurementUnit.delete(0, measurementUnit.length());
				measurementUnit.append(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MEASUREMENT_UNIT).getText());
				Assert.assertTrue(measurementUnit.toString().contains("C") || measurementUnit.toString().contains("F"));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
			}
		}
	<<<<<<< Updated upstream

		@Test(priority = 9029, groups = {Config.TI_FCM1555_CAPTURE_ANDROID, Config.TI_FCM1555_CAPTURE_IOS, Config.TI_FCM1555}, dependsOnMethods = {"connectToTI400Test"})
		public void TI400MaxTempValueTest()
	=======

		@Test(alwaysRun = true, priority = 6303, groups = {Config.IOS_FULL_TESTS})
		public void assignWorkOrderToBeakerMeasurementTest()
	>>>>>>> Stashed changes
		{
			try
			{
				if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
					Assert.assertTrue(FloatValidator.getInstance().isInRange(Float.parseFloat(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MAX_TEMP).getText()), 15.0, 100.0));
				else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				{
					measurementValue.delete(0, measurementValue.length());
					measurementValue.append(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MAX_TEMP).getText());
					Assert.assertTrue(FloatValidator.getInstance().isInRange(Float.parseFloat(measurementValue.substring(measurementValue.indexOf(": ") + 2, measurementValue.lastIndexOf(" "))), 15.0, 100.0));
				}
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
			}
		}
	<<<<<<< Updated upstream

		@Test(priority = 9030, groups = {Config.TI_FCM1555_CAPTURE_ANDROID, Config.TI_FCM1555_CAPTURE_IOS, Config.TI_FCM1555}, dependsOnMethods = {"connectToTI400Test"})
		public void TI400MinTempValueTest()
	=======

		@Test(alwaysRun = true, priority = 6304, groups = {Config.IOS_FULL_TESTS})
		public void addTextNoteToBeakerMeasurementTest()
	>>>>>>> Stashed changes
		{
			try
			{
				if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
					Assert.assertTrue(FloatValidator.getInstance().isInRange(Float.parseFloat(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MIN_TEMP).getText()), 15.0, 100.0));
				else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				{
					measurementValue.delete(0, measurementValue.length());
					measurementValue.append(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MIN_TEMP).getText());
					Assert.assertTrue(FloatValidator.getInstance().isInRange(Float.parseFloat(measurementValue.substring(measurementValue.indexOf(": ") + 2, measurementValue.lastIndexOf(" "))), 15.0, 100.0));
				}
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
			}
		}
	<<<<<<< Updated upstream

		@Test(priority = 9031, groups = {Config.TI_FCM1555_CAPTURE_ANDROID, Config.TI_FCM1555_CAPTURE_IOS, Config.TI_FCM1555}, dependsOnMethods = {"connectToTI400Test"})
		public void TI400MaxTempUnitTest()
		{
			try
			{
				measurementUnit.delete(0, measurementUnit.length());
				measurementUnit.append(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MAX_TEMP).getText());
				Assert.assertTrue(measurementUnit.toString().contains("C") || measurementUnit.toString().contains("F"));

	=======

		@Test(alwaysRun = true, priority = 6305, groups = {Config.IOS_FULL_TESTS})
		public void connectAndRecordMeasurementTest() throws Exception
		{
			try
			{
				fc1555CaptureMeasurementPage.recordMeasurement(Config.captureMeasurementSimulatedDeviceNameList.get("Record Measurement"), Config.measurementRecordingDuration);

	>>>>>>> Stashed changes
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
			}
		}
	<<<<<<< Updated upstream

		@Test(priority = 9032, groups = {Config.TI_FCM1555_CAPTURE_ANDROID, Config.TI_FCM1555_CAPTURE_IOS, Config.TI_FCM1555}, dependsOnMethods = {"connectToTI400Test"})
		public void TI400MinTempUnitTest()
	=======

		@Test(alwaysRun = true, priority = 6306, groups = {Config.IOS_FULL_TESTS})
		public void assignAssetToRecordedMeasurementTest()
	>>>>>>> Stashed changes
		{
			try
			{
				measurementUnit.delete(0, measurementUnit.length());
				measurementUnit.append(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MIN_TEMP).getText());
				Assert.assertTrue(measurementUnit.toString().contains("C") || measurementUnit.toString().contains("F"));

			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
			}
		}
	<<<<<<< Updated upstream

		@Test(priority = 9033, groups = {Config.TI_FCM1555_CAPTURE_ANDROID, Config.TI_FCM1555_CAPTURE_IOS, Config.TI_FCM1555}, dependsOnMethods = {"connectToTI400Test"})
		public void TI400MaxTempLabelTest()
	=======

		@Test(alwaysRun = true, priority = 6307, groups = {Config.IOS_FULL_TESTS})
		public void assignWorkOrderToRecordMeasurementTest()
	>>>>>>> Stashed changes
		{
			try
			{
				measurementLabel.delete(0, measurementLabel.length());
				measurementLabel.append(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MAX_TEMP).getText());
				Assert.assertTrue(measurementLabel.toString().contains("Max :"));

			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
			}
		}
	<<<<<<< Updated upstream

		@Test(priority = 9034, groups = {Config.TI_FCM1555_CAPTURE_ANDROID, Config.TI_FCM1555_CAPTURE_IOS, Config.TI_FCM1555}, dependsOnMethods = {"connectToTI400Test"})
		public void TI400MinTempLabelTest()
	=======

		@Test(alwaysRun = true, priority = 6308, groups = {Config.IOS_FULL_TESTS})
		public void addTextNoteInRecordMeasurementTest()
	>>>>>>> Stashed changes
		{
			try
			{
				measurementLabel.delete(0, measurementLabel.length());
				measurementLabel.append(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MIN_TEMP).getText());
				Assert.assertTrue(measurementLabel.toString().contains("Min"));

			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
			}
		}
	<<<<<<< Updated upstream


		@Test(priority = 9035, groups = {Config.TI_FCM1555_CAPTURE_ANDROID, Config.TI_FCM1555_CAPTURE_IOS, Config.TI_FCM1555}, dependsOnMethods = {"connectToTI400Test"})
		public void shareTI400MeasurementTest()
	=======

		@Test(alwaysRun = true, priority = 6309, groups = {Config.IOS_FULL_TESTS})
		public void addVoiceNoteInRecordMeasurementTest()
		{
			try
			{
				fc1555CaptureMeasurementPage.addVoiceNote(Config.measurementRecordingDuration);
				fc1555CaptureMeasurementPage.reliableTapOnSaveButton();
				fc1555CaptureMeasurementPage.tapOnGraphButton();
				fc1555CaptureMeasurementPage.reliableTapOnDisconnectDeviceButton();
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fc1555CaptureMeasurementPage.reliableTapOnSaveButton();
				fc1555CaptureMeasurementPage.tapOnGraphButton();
				fc1555CaptureMeasurementPage.reliableTapOnDisconnectDeviceButton();
			}
		}

		@Test(alwaysRun = true, priority = 6310, groups = {Config.IOS_FULL_TESTS})
		public void connectAndCaptureV3000MeasurementTest()
	>>>>>>> Stashed changes
		{
			try
			{
				measurementDetailPage.shareMeasurement("at@yopmail.com", FCM1555.DataType.THERMAL_IMAGES, FCM1555.ShareFormat.PDF, false);
				CommonUtils.wait(3);
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
			}
		}
	<<<<<<< Updated upstream

		@Test(priority = 9036, groups = {Config.TI_FCM1555_CAPTURE_ANDROID, Config.TI_FCM1555_CAPTURE_IOS, Config.TI_FCM1555}, dependsOnMethods = {"connectToTI400Test"})
		public void saveTI400MeasurementTest()
	=======

		@Test(alwaysRun = true, priority = 6311, groups = {Config.IOS_FULL_TESTS})
		public void assignAssetToV3000MeasurementTest()
	>>>>>>> Stashed changes
		{
			try
			{
				measurementDetailPage.captureMeasurementsDetails(FCM1555.MEASUREMENTS_PROPERTIES_FILE_PATH, FCM1555.DeviceList.TI_400.getDeviceName(), MeasurementType.TI, 0);
				ElementUtils.click(1, fc1555CaptureMeasurementPage.getfc1555CaptureMeasurementPageObject(fc1555CaptureMeasurementPageObject.SAVE_BUTTON));
				ElementUtils.click(1, fc1555CaptureMeasurementPage.getfc1555CaptureMeasurementPageObject(fc1555CaptureMeasurementPageObject.BACK_BUTTON));
				ElementUtils.click(1, fc1555CaptureMeasurementPage.getfc1555CaptureMeasurementPageObject(fc1555CaptureMeasurementPageObject.DISCONNECT_DEVICE));
			}
			catch(Throwable e)
			{
				Assert.fail();
			}
		}
	<<<<<<< Updated upstream

		@Test(priority = 9037, groups = {Config.TI_FCM1555_CAPTURE_ANDROID, Config.TI_FCM1555_CAPTURE_IOS, Config.TI_FCM1555})
		public void connectToTI450Test() throws Exception
	=======

		@Test(alwaysRun = true, priority = 6312, groups = {Config.IOS_FULL_TESTS})
		public void assignWorkOrderToV3000MeasurementTest()
	>>>>>>> Stashed changes
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
					deviceUtils.launchOtherApp(deviceUtils.getDeviceUtilsWebElement(DeviceUtilsObjects.iPHONE_SETTINGS_APP_ICON), null, deviceUtils.getDeviceUtilsAttributes(DeviceUtilsObjects.ANDROID_SETTINGS_PACKAGE), deviceUtils.getDeviceUtilsAttributes(DeviceUtilsObjects.ANDROID_SETTINGS_ACTIVITY), null);
				else
					deviceUtils.toggleWiFi(true, "Settings", true);
				deviceUtils.connectToNetwork(FCM1555.DeviceList.TI450WIFI.getDeviceName(), "password");
				deviceUtils.toogleFCAPP(true, null);
				switcher.switchTofc1555CaptureMeasurementPageHome();
				if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
					fc1555CaptureMeasurementPage.connectToDevice(FCM1555.DeviceList.TI.getDeviceName());
				else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
					fc1555CaptureMeasurementPage.connectToDevice(FCM1555.DeviceList.ANDROID_TI_450.getDeviceName());
		}
	<<<<<<< Updated upstream


		@Test(priority = 9041, groups = {Config.TI_FCM1555_CAPTURE_ANDROID, Config.TI_FCM1555_CAPTURE_IOS, Config.TI_FCM1555}, dependsOnMethods = {"connectToTI450Test"})
		public void downloadImagesFromTI450Test()
	=======

		@Test(alwaysRun = true, priority = 6313, groups = {Config.IOS_FULL_TESTS})
		public void addTextNoteInV3000MeasurementTest()
		{
			try
			{
				fc1555CaptureMeasurementPage.addTextNote(Config.measurementTextNoteText);
				Assert.assertTrue(fc1555CaptureMeasurementPage.isTextNoteAdded(Config.measurementTextNoteText));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
			}
		}

		@Test(alwaysRun = true, priority = 6314, groups = {Config.IOS_FULL_TESTS})
		public void addVoiceNoteInV3000MeasurementTest()
	>>>>>>> Stashed changes
		{
			try
			{
				CommonUtils.wait(10);
				fc1555CaptureMeasurementPage.downloadTIMeasurement(2, FCM1555.DeviceList.TI_450_DOWNLOAD.getDeviceName(), true);
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
			}
		}
	<<<<<<< Updated upstream

		@Test(priority = 9042, groups = {Config.TI_FCM1555_CAPTURE_ANDROID, Config.TI_FCM1555_CAPTURE_IOS, Config.TI_FCM1555}, dependsOnMethods = {"connectToTI450Test"})
		public void captureTI450MeasurementTest()
	=======

		@Test(alwaysRun = true, priority = 6315, groups = {Config.IOS_FULL_TESTS})
		public void connectAndCaptureT3000MeasurementTest()
	>>>>>>> Stashed changes
		{
			try
			{
				fc1555CaptureMeasurementPage.captureTIMeasurement(FCM1555.DeviceList.TI.getDeviceName());
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
			}
		}
	<<<<<<< Updated upstream

		@Test(priority = 9043, groups = {Config.TI_FCM1555_CAPTURE_ANDROID, Config.TI_FCM1555_CAPTURE_IOS, Config.TI_FCM1555}, dependsOnMethods = {"connectToTI450Test"})
		public void assignAssetToTI450MeasurementTest()
	=======

		@Test(alwaysRun = true, priority = 6316, groups = {Config.IOS_FULL_TESTS})
		public void assignAssetToT3000MeasurementTest()
	>>>>>>> Stashed changes
		{
			try
			{
				measurementDetailPage.assignAsset(FCM1555.captureMeasurementAssetList[0], FCM1555.captureMeasurementAssetList[1], FCM1555.captureMeasurementAssetList[2]);
				Assert.assertTrue(measurementDetailPage.isAssetAssigned(FCM1555.captureMeasurementAssetList[2]));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
			}
		}
	<<<<<<< Updated upstream

		@Test(priority = 9044, groups = {Config.TI_FCM1555_CAPTURE_ANDROID, Config.TI_FCM1555_CAPTURE_IOS, Config.TI_FCM1555}, dependsOnMethods = {"connectToTI450Test"})
		public void assignWorkOrderToTI450MeasurementTest()
	=======

		@Test(alwaysRun = true, priority = 6317, groups = {Config.IOS_FULL_TESTS})
		public void assignWorkOrderToT3000MeasurementTest()
	>>>>>>> Stashed changes
		{
			try
			{
				measurementDetailPage.assignWorkOrder(Config.measurementAssignedWorkOrderNumber);
				Assert.assertTrue(measurementDetailPage.isWorkOrderAssigned(Config.measurementAssignedWorkOrderNumber));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
			}
		}
	<<<<<<< Updated upstream

		@Test(priority = 9045, groups = {Config.TI_FCM1555_CAPTURE_ANDROID, Config.TI_FCM1555_CAPTURE_IOS, Config.TI_FCM1555}, dependsOnMethods = {"connectToTI450Test"})
		public void addTextNoteToTI450MeasurementTest()
	=======

		@Test(alwaysRun = true, priority = 6318, groups = {Config.IOS_FULL_TESTS})
		public void addTextNoteInT3000MeasurementTest()
	>>>>>>> Stashed changes
		{
			try
			{
				if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				{
					measurementDetailPage.addTextNote(Config.measurementTextNoteText);
					Assert.assertTrue(measurementDetailPage.isTextNoteAdded(Config.measurementTextNoteText));
				}
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
			}
		}
	<<<<<<< Updated upstream

		@Test(priority = 9046, groups = {Config.TI_FCM1555_CAPTURE_ANDROID, Config.TI_FCM1555_CAPTURE_IOS, Config.TI_FCM1555}, dependsOnMethods = {"connectToTI450Test"})
		public void TI450DeviceNameTest()
	=======

		@Test(alwaysRun = true, priority = 6319, groups = {Config.IOS_FULL_TESTS})
		public void addVoiceNoteInT3000MeasurementTest()
	>>>>>>> Stashed changes
		{
			try
			{
				Assert.assertTrue(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MEASUREMENT_DEVICE_NAME).getText().equals(FCM1555.DeviceList.TI.getDeviceName()));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
			}
		}
	<<<<<<< Updated upstream

		@Test(priority = 9047, groups = {Config.TI_FCM1555_CAPTURE_ANDROID, Config.TI_FCM1555_CAPTURE_IOS, Config.TI_FCM1555}, dependsOnMethods = {"connectToTI450Test"})
		public void TI450MeasurementValueTest()
	=======

		@Test(alwaysRun = true, priority = 6320, groups = {Config.IOS_FULL_TESTS})
		public void captureVACManualMeasurementTest()
	>>>>>>> Stashed changes
		{
			try
			{
				if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
					Assert.assertTrue(FloatValidator.getInstance().isInRange(Float.parseFloat(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MEASUREMENT_VALUE).getText()), 15.0, 100.0));
				else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				{
					measurementValue.delete(0, measurementValue.length());
					measurementValue.append(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MEASUREMENT_VALUE).getText());
					Assert.assertTrue(FloatValidator.getInstance().isInRange(Float.parseFloat(measurementValue.substring(0, measurementValue.indexOf(" "))), 15.0, 100.0));
				}
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
			}
		}
	<<<<<<< Updated upstream

		@Test(priority = 9048, groups = {Config.TI_FCM1555_CAPTURE_ANDROID, Config.TI_FCM1555_CAPTURE_IOS, Config.TI_FCM1555}, dependsOnMethods = {"connectToTI450Test"})
		public void TI450MeasurementUnitTest()
	=======

		@Test(alwaysRun = true, priority = 6321, groups = {Config.IOS_FULL_TESTS})
		public void assignAssetToManualMeasurementTest()
	>>>>>>> Stashed changes
		{
			try
			{
				String measurementUnit = measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MEASUREMENT_UNIT).getText();
				Assert.assertTrue(measurementUnit.contains("C") || measurementUnit.contains("F"));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
			}
		}
	<<<<<<< Updated upstream

		@Test(priority = 9049, groups = {Config.TI_FCM1555_CAPTURE_ANDROID, Config.TI_FCM1555_CAPTURE_IOS, Config.TI_FCM1555}, dependsOnMethods = {"connectToTI450Test"})
		public void TI450MaxTempValueTest()
	=======

		@Test(alwaysRun = true, priority = 6322, groups = {Config.IOS_FULL_TESTS})
		public void assignWorkOrderToManualMeasurementTest()
	>>>>>>> Stashed changes
		{
			try
			{
				if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
					Assert.assertTrue(FloatValidator.getInstance().isInRange(Float.parseFloat(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MAX_TEMP).getText()), 15.0, 100.0));
				else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				{
					measurementValue.delete(0, measurementValue.length());
					measurementValue.append(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MAX_TEMP).getText());
					Assert.assertTrue(FloatValidator.getInstance().isInRange(Float.parseFloat(measurementValue.substring(measurementValue.indexOf(": ") + 2, measurementValue.lastIndexOf(" "))), 15.0, 100.0));
				}
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
			}
		}
	<<<<<<< Updated upstream

		@Test(priority = 9050, groups = {Config.TI_FCM1555_CAPTURE_ANDROID, Config.TI_FCM1555_CAPTURE_IOS, Config.TI_FCM1555}, dependsOnMethods = {"connectToTI450Test"})
		public void TI450MinTempValueTest()
	=======

		@Test(alwaysRun = true, priority = 6323, groups = {Config.IOS_FULL_TESTS})
		public void addTextNoteInManualMeasurementTest()
	>>>>>>> Stashed changes
		{
			try
			{
				if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
					Assert.assertTrue(FloatValidator.getInstance().isInRange(Float.parseFloat(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MIN_TEMP).getText()), 15.0, 100.0));
				else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				{
					measurementValue.delete(0, measurementValue.length());
					measurementValue.append(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MIN_TEMP).getText());
					Assert.assertTrue(FloatValidator.getInstance().isInRange(Float.parseFloat(measurementValue.substring(measurementValue.indexOf(": ") + 2, measurementValue.lastIndexOf(" "))), 15.0, 100.0));
				}
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
			}
		}
	<<<<<<< Updated upstream

		@Test(priority = 9051, groups = {Config.TI_FCM1555_CAPTURE_ANDROID, Config.TI_FCM1555_CAPTURE_IOS, Config.TI_FCM1555}, dependsOnMethods = {"connectToTI450Test"})
		public void TI450MaxTempUnitTest()
	=======

		@Test(alwaysRun = true, priority = 6324, groups = {Config.IOS_FULL_TESTS})
		public void addVoiceNoteInManualMeasurementTest()
	>>>>>>> Stashed changes
		{
			try
			{
				measurementUnit.delete(0, measurementUnit.length());
				measurementUnit.append(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MAX_TEMP).getText());
				Assert.assertTrue(measurementUnit.toString().contains("C") || measurementUnit.toString().contains("F"));

			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
			}
		}
	<<<<<<< Updated upstream

		@Test(priority = 9052, groups = {Config.TI_FCM1555_CAPTURE_ANDROID, Config.TI_FCM1555_CAPTURE_IOS, Config.TI_FCM1555}, dependsOnMethods = {"connectToTI450Test"})
		public void TI450MinTempUnitTest()
	=======

		@Test(alwaysRun = true, priority = 6325, groups = {Config.IOS_FULL_TESTS})
		public void captureGroupMeasurementWith2DevicesTest()
	>>>>>>> Stashed changes
		{
			try
			{
				measurementUnit.delete(0, measurementUnit.length());
				measurementUnit.append(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MIN_TEMP).getText());
				Assert.assertTrue(measurementUnit.toString().contains("C") || measurementUnit.toString().contains("F"));

			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
			}
		}
	<<<<<<< Updated upstream

		@Test(priority = 9053, groups = {Config.TI_FCM1555_CAPTURE_ANDROID, Config.TI_FCM1555_CAPTURE_IOS, Config.TI_FCM1555}, dependsOnMethods = {"connectToTI450Test"})
		public void TI450MaxTempLabelTest()
	=======

		@Test(alwaysRun = true, priority = 6326, groups = {Config.IOS_FULL_TESTS})
		public void assignAssetToGroupMeasurementWith2DevicesTest()
	>>>>>>> Stashed changes
		{
			try
			{
				measurementLabel.delete(0, measurementLabel.length());
				measurementLabel.append(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MAX_TEMP).getText());
				Assert.assertTrue(measurementLabel.toString().contains("Max :"));

			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
			}
		}
	<<<<<<< Updated upstream

		@Test(priority = 9054, groups = {Config.TI_FCM1555_CAPTURE_ANDROID, Config.TI_FCM1555_CAPTURE_IOS, Config.TI_FCM1555}, dependsOnMethods = {"connectToTI450Test"})
		public void TI450MinTempLabelTest()
	=======

		@Test(alwaysRun = true, priority = 6327, groups = {Config.IOS_FULL_TESTS})
		public void assignWorkOrderToGroupMeasurementWith2DevicesTest()
	>>>>>>> Stashed changes
		{
			try
			{
				measurementLabel.delete(0, measurementLabel.length());
				measurementLabel.append(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MIN_TEMP).getText());
				Assert.assertTrue(measurementLabel.toString().contains("Min"));

			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
			}
		}
	<<<<<<< Updated upstream


		@Test(priority = 9055, groups = {Config.TI_FCM1555_CAPTURE_ANDROID, Config.TI_FCM1555_CAPTURE_IOS, Config.TI_FCM1555}, dependsOnMethods = {"connectToTI450Test"})
		public void shareTI450MeasurementTest()
	=======

		@Test(alwaysRun = true, priority = 6328, groups = {Config.IOS_FULL_TESTS})
		public void addTextNoteInGroupMeasurementWith2DevicesTest()
		{
			try
			{
				fc1555CaptureMeasurementPage.addTextNote(Config.measurementTextNoteText);
				Assert.assertTrue(fc1555CaptureMeasurementPage.isTextNoteAdded(Config.measurementTextNoteText));
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
				fc1555CaptureMeasurementPage.reliableTapOnSaveButton();
				fc1555CaptureMeasurementPage.reliableDisconnectDevices(Config.captureMeasurementGroupMeasurementSimulatedDeviceNameList);
			}
		}

		@Test(alwaysRun = true, priority = 6329, groups = {Config.IOS_FULL_TESTS})
		public void addVoiceNoteInGroupMeasurementWith2DevicesTest()
	>>>>>>> Stashed changes
		{
			try
			{
				measurementDetailPage.shareMeasurement("at@yopmail.com", FCM1555.DataType.THERMAL_IMAGES, FCM1555.ShareFormat.PDF, false);
				CommonUtils.wait(3);
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
			}
		}
	<<<<<<< Updated upstream

		@Test(priority = 9056, groups = {Config.TI_FCM1555_CAPTURE_ANDROID, Config.TI_FCM1555_CAPTURE_IOS, Config.TI_FCM1555}, dependsOnMethods = {"connectToTI450Test"})
		public void saveTI450MeasurementTest()
	=======


		@Test(alwaysRun = true, priority = 6330, groups = {Config.IOS_FULL_TESTS})
		public void connectAndCaptureHudsonMeasurementTest()
	>>>>>>> Stashed changes
		{
			try
			{
				measurementDetailPage.captureMeasurementsDetails(FCM1555.MEASUREMENTS_PROPERTIES_FILE_PATH, FCM1555.DeviceList.TI_450.getDeviceName(), MeasurementType.TI, 0);
				ElementUtils.click(1, fc1555CaptureMeasurementPage.getfc1555CaptureMeasurementPageObject(fc1555CaptureMeasurementPageObject.SAVE_BUTTON));
				ElementUtils.click(1, fc1555CaptureMeasurementPage.getfc1555CaptureMeasurementPageObject(fc1555CaptureMeasurementPageObject.BACK_BUTTON));
				ElementUtils.click(1, fc1555CaptureMeasurementPage.getfc1555CaptureMeasurementPageObject(fc1555CaptureMeasurementPageObject.DISCONNECT_DEVICE));
			}
			catch(Throwable e)
			{
				if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				{
					element = ElementUtils.getElement("Connected Devices", null, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, null);
					gestureUtils.clickOnCordinates(element.getSize().width - 35, element.getLocation().y + 25);
					CommonUtils.wait(2);
					gestureUtils.clickOnCordinates(element.getSize().width - 35, element.getLocation().y + 25);
					element = null;
				}
				Assert.fail();
			}
		}
	<<<<<<< Updated upstream

		@Test(priority = 9075, groups = {Config.TI_FCM1555_CAPTURE_ANDROID, Config.TI_FCM1555_CAPTURE_IOS, Config.TI_FCM1555})
		public void connectToTIS65Test() throws Exception
	=======

		@Test(alwaysRun = true, priority = 6331, groups = {Config.IOS_FULL_TESTS})
		public void assignAssetToHudsonMeasurementTest()
	>>>>>>> Stashed changes
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
					deviceUtils.launchOtherApp(deviceUtils.getDeviceUtilsWebElement(DeviceUtilsObjects.iPHONE_SETTINGS_APP_ICON), null, deviceUtils.getDeviceUtilsAttributes(DeviceUtilsObjects.ANDROID_SETTINGS_PACKAGE), deviceUtils.getDeviceUtilsAttributes(DeviceUtilsObjects.ANDROID_SETTINGS_ACTIVITY), null);
				else
					deviceUtils.toggleWiFi(true, "Settings", true);			
				deviceUtils.connectToNetwork(FCM1555.DeviceList.TI_S65_WIFI.getDeviceName(), "password");
				deviceUtils.toogleFCAPP(true, null);
				switcher.switchTofc1555CaptureMeasurementPageHome();
				if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
					fc1555CaptureMeasurementPage.connectToDevice(FCM1555.DeviceList.TI.getDeviceName());
				else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
					fc1555CaptureMeasurementPage.connectToDevice(FCM1555.DeviceList.ANDROID_TI_S65.getDeviceName());
		}
	<<<<<<< Updated upstream

		@Test(priority = 9076, groups = {Config.TI_FCM1555_CAPTURE_ANDROID, Config.TI_FCM1555_CAPTURE_IOS, Config.TI_FCM1555}, dependsOnMethods = {"connectToTIS65Test"})
		public void downloadImagesFromTIS65Test()
	=======

		@Test(alwaysRun = true, priority = 6332, groups = {Config.IOS_FULL_TESTS})
		public void assignWorkOrderToHudsonMeasurementTest()
	>>>>>>> Stashed changes
		{
			try
			{
				CommonUtils.wait(10);
				fc1555CaptureMeasurementPage.downloadTIMeasurement(2, FCM1555.DeviceList.TI_S65_DOWNLOAD.getDeviceName(), false);
				ElementUtils.click(1, fc1555CaptureMeasurementPage.getfc1555CaptureMeasurementPageObject(fc1555CaptureMeasurementPageObject.DISCONNECT_DEVICE));
			}
			catch(Throwable e)
			{
				element = ElementUtils.getElement("Connected Devices", null, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, null);
				gestureUtils.clickOnCordinates(element.getSize().width - 35, element.getLocation().y + 25);
				CommonUtils.wait(2);
			}
		}
	<<<<<<< Updated upstream

		@Test(priority = 9077, groups = {Config.TI_FCM1555_CAPTURE_ANDROID, Config.TI_FCM1555_CAPTURE_IOS, Config.TI_FCM1555})
		public void connectToTIS75Test() throws Exception
	=======

		@Test(alwaysRun = true, priority = 6333, groups = {Config.IOS_FULL_TESTS})
		public void addTextNoteInHudsonMeasurementTest()
	>>>>>>> Stashed changes
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
					deviceUtils.launchOtherApp(deviceUtils.getDeviceUtilsWebElement(DeviceUtilsObjects.iPHONE_SETTINGS_APP_ICON), null, deviceUtils.getDeviceUtilsAttributes(DeviceUtilsObjects.ANDROID_SETTINGS_PACKAGE), deviceUtils.getDeviceUtilsAttributes(DeviceUtilsObjects.ANDROID_SETTINGS_ACTIVITY), null);
				else
					deviceUtils.toggleWiFi(true, "Settings", true);
				deviceUtils.connectToNetwork(FCM1555.DeviceList.TI_S75_WIFI.getDeviceName(), "password");
				deviceUtils.toogleFCAPP(true, null);
				switcher.switchTofc1555CaptureMeasurementPageHome();
				if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
					fc1555CaptureMeasurementPage.connectToDevice(FCM1555.DeviceList.TI.getDeviceName());
				else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
					fc1555CaptureMeasurementPage.connectToDevice(FCM1555.DeviceList.ANDROID_TI_S75.getDeviceName());
		}
	<<<<<<< Updated upstream

		@Test(priority = 9078, groups = {Config.TI_FCM1555_CAPTURE_ANDROID, Config.TI_FCM1555_CAPTURE_IOS, Config.TI_FCM1555}, dependsOnMethods = {"connectToTIS75Test"})
		public void downloadImagesFromTIS75Test() throws Exception
	=======

		// Full test suite ends here

	    // Below 2 tests wrote to execute on real devices and need to properly tag

		@Test(alwaysRun = true, priority = 35, groups = {})
		public void captureThermalImageTest()
	>>>>>>> Stashed changes
		{
			try
			{
				CommonUtils.wait(10);
				fc1555CaptureMeasurementPage.downloadTIMeasurement(2, FCM1555.DeviceList.TI_S75_DOWNLOAD.getDeviceName(), false);
				ElementUtils.click(1, fc1555CaptureMeasurementPage.getfc1555CaptureMeasurementPageObject(fc1555CaptureMeasurementPageObject.DISCONNECT_DEVICE));
			}
			catch(Throwable e)
			{
	<<<<<<< Updated upstream
				element = ElementUtils.getElement("Connected Devices", null, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, null);
				gestureUtils.clickOnCordinates(element.getSize().width - 35, element.getLocation().y + 25);
				ElementUtils.click(1, fc1555CaptureMeasurementPage.getfc1555CaptureMeasurementPageObject(fc1555CaptureMeasurementPageObject.BACK_BUTTON));

			}
		}

		@Test(priority = 9079, groups = {Config.TI_FCM1555_CAPTURE_ANDROID, Config.TI_FCM1555_CAPTURE_IOS, Config.TI_FCM1555})
		public void connectToWiFiTest()
	=======
				Assert.fail("Exception Detail: "+e);
			}
		}

		@Test(alwaysRun = true, priority = 36, groups = {})
		public void recordCameraMeasurementTest()
		{
			try
			{
				fc1555CaptureMeasurementPage.recordCameraMeasurement(5);
			}
			catch(Exception e)
			{
				Assert.fail("Exception Detail: "+e);
			}
		}

		// Capture measurements reliability tests suite starts here --> priority range begins from 8300

		@Test(alwaysRun = true, priority = 8301, groups = {Config.CAPTURE_MEASUREMENT_RELIABILTY_TESTS})
		public void captureMeasurementReliableTest()
		{
			try
			{
				for(int j = 0; j < 50000; j++)
				{
					try
					{
						for(int i=0;i<Config.iOSSimulatedDeviceList.length;i++)
						{
						   fc1555CaptureMeasurementPage.captureScalarMeasurementWithoutStoringValuesToPropertiesFile(Config.iOSSimulatedDeviceList[i]);
						   fc1555CaptureMeasurementPage.assignAsset(Config.captureMeasurementAssetList[0], Config.captureMeasurementAssetList[1], Config.captureMeasurementAssetList[2]);
						   fc1555CaptureMeasurementPage.reliableTapOnSaveAndDisconnectDeviceButton();
						}
					}
					catch(Error e)
					{
						e.printStackTrace();
					}
					FileUtil.writeToPropertyFile(CommonUtils.PROPERTIESFILEPATH, "count", String.valueOf(j));
				}
			}
			catch(Exception e)
			{
				Assert.fail("Exception Detail: "+e);
			}
		}

		@Test(alwaysRun = true, priority = 6309, groups = {Config.FC_805_TESTS})
		public void capture805MeasurementTest()
	>>>>>>> Stashed changes
		{
			try
			{
				deviceUtils.launchOtherApp(deviceUtils.getDeviceUtilsWebElement(DeviceUtilsObjects.iPHONE_SETTINGS_APP_ICON), null, deviceUtils.getDeviceUtilsAttributes(DeviceUtilsObjects.ANDROID_SETTINGS_PACKAGE), deviceUtils.getDeviceUtilsAttributes(DeviceUtilsObjects.ANDROID_SETTINGS_ACTIVITY), null);
				CommonUtils.wait(2);
				if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
					deviceUtils.getDeviceUtilsWebElement(DeviceUtilsObjects.WI_FI_BUTTONS_SETTINGS_PAGE).click();
				 deviceUtils.wifiSwitch();	
				deviceUtils.toogleFCAPP(true, null);
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
			}
		}
	<<<<<<< Updated upstream

		@AfterClass(groups = {"zzzz", Config.TI_FCM1555, Config.IOS_FULL_TESTS, Config.IOS_SMOKE_TESTS, Config.CAPTURE_MEASUREMENT_RELIABILTY_TESTS})
		public void classTearDown() throws Exception
		{
			Config.useExistingPageSource = false;
			fc1555CaptureMeasurementPage.clickBackButton();
		    if(!DriverManager.isRealDevice())
		    {
		    	serviceHatchPage.toggleFeature("SIMULATED DEVICES", null, true, serviceHatchPage.getElement(ServiceHatchPage.SIMULATED_DEVICES_BUTTON), true);
		    }
	=======

	 */

	//125B (Prism tool) tests
	/*
		@Parameters({"wiFiTool","wifiToolssid","flukeWIFI","wifiToolpassword","flukeWIFIpassword"})
		@Test(alwaysRun = true, priority = 7001, groups = {Config.WIFI_TOOL_TESTS, Config.WIFI_TOOL_125B_TESTS})
		public void capture125BMeasurementTest(@Optional("null") String wiFiTool,@Optional("null") String wifiToolssid,@Optional("null") String flukeWIFI,@Optional("null") String wifiToolPassword,@Optional("null") String flukeWIFIpassword)
		{
			try
			{
				Assert.assertTrue(fc1555CaptureMeasurementPage.capture125BMeasurementTest(wiFiTool, wifiToolssid, flukeWIFI, wifiToolPassword, flukeWIFIpassword));
			}
			catch(Exception e)
			{
				Assert.fail("Exception Detail: "+e);
			}
		}

		@Parameters({"wiFiTool","wifiToolssid","flukeWIFI","wifiToolpassword","flukeWIFIpassword"})
		@Test(alwaysRun = true, priority = 7101, groups = {Config.WIFI_TOOL_TESTS, Config.WIFI_TOOL_173X_TESTS})
		public void capture173XMeasurementTest(@Optional("null") String wiFiTool,@Optional("null") String wifiToolssid,@Optional("null") String flukeWIFI,@Optional("null") String wifiToolPassword,@Optional("null") String flukeWIFIpassword)
		{
			try
			{
				Assert.assertTrue(fc1555CaptureMeasurementPage.capture173XMeasurementTest(wiFiTool, wifiToolssid, flukeWIFI, wifiToolPassword, flukeWIFIpassword, switcher));
			}
			catch(Exception e)
			{
				Assert.fail("Exception Detail: "+e);
			}
		}

		@Parameters({"wiFiTool","wifiToolssid","flukeWIFI","wifiToolpassword","flukeWIFIpassword"})
		@Test(alwaysRun = true, priority = 7201, groups = {Config.WIFI_TOOL_TESTS, Config.WIFI_TOOL_173X_TESTS})
		public void download437MeasurementTest(@Optional("null") String wiFiTool,@Optional("null") String wifiToolssid,@Optional("null") String flukeWIFI,@Optional("null") String wifiToolPassword,@Optional("null") String flukeWIFIpassword)
		{
			try
			{
				Assert.assertTrue(fc1555CaptureMeasurementPage.download437MeasurementTest(wiFiTool, wifiToolssid, flukeWIFI, wifiToolPassword, flukeWIFIpassword, switcher));
			}
			catch(Exception e)
			{
				Assert.fail("Exception Detail: "+e);
			}
		}
	 */
	
	@AfterClass(groups = {Config.FC1555})
	public void classTearDown() throws Exception
	{
		Config.useExistingPageSource = false;
		fc1555CaptureMeasurementPage.clickBackORDoneButton();
		if(!DriverManager.isRealDevice())
		{
			serviceHatchPage.toggleFeature("SIMULATED DEVICES", null, true, serviceHatchPage.getElement(ServiceHatchPage.SIMULATED_DEVICES_BUTTON), true);
		}
		if(!DriverManager.isSmokeSuite()) {
			DriverManager.closeApp();
			DriverManager.launchApp();
		}
	}
}

