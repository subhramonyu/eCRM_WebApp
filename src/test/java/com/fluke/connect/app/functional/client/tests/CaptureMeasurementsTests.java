package com.fluke.connect.app.functional.client.tests;

import org.apache.commons.validator.routines.FloatValidator;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.fluke.connect.app.functional.client.pages.CaptureMeasurementsPage;
import com.fluke.connect.app.functional.client.pages.FC1555CaptureMeasurementPage;
import com.fluke.connect.app.functional.client.pages.MeasurementDetailPage;
import com.fluke.connect.app.functional.client.pages.ServiceHatchPage;
import com.fluke.connect.app.functional.client.pages.Switcher;
import com.fluke.connect.app.functional.client.pages.CaptureMeasurementsPage.CaptureMeasurementsPageObject;
import com.fluke.connect.app.functional.client.pages.MeasurementDetailPage.MeasurementDetailPageObjects;
import com.fluke.connect.app.testdata.FCM;
import com.fluke.connect.app.testdata.SignIn;
import com.fluke.connect.app.testdata.SignIn.FeatureList;
import com.fluke.connect.app.testdata.FCM.MeasurementType;
import com.fluke.connect.app.utils.AndroidUtils;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DeviceUtils;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.PropertiesFileType;
import com.fluke.connect.app.utils.DeviceUtils.DeviceUtilsObjects;


public class CaptureMeasurementsTests 
{
	private CaptureMeasurementsPage captureMeasurementsPage;
	private FC1555CaptureMeasurementPage fc1555CaptureMeasurementPage;
	private Switcher switcher;
	private ServiceHatchPage serviceHatchPage;
	private MeasurementDetailPage measurementDetailPage;
	private GestureUtils gestureUtils;
	private WebElement element;
	private DeviceUtils deviceUtils;
	private StringBuilder measurementValue;
	private StringBuilder measurementUnit;
	private StringBuilder measurementLabel;

	@BeforeClass(alwaysRun = true, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM, Config.IOS_SMOKE_TESTS, 
											Config.FC_805_TESTS, Config.IOS_FULL_TESTS, Config.WEB_SMOKE_CM_TESTS,
											Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX,
											Config.CAPTURE_MEASUREMENT_RELIABILTY_TESTS, Config.ANDROID_SMOKE_TESTS,"cnx_capture_ios_tests376"})
	public void initClass() throws Exception
	{
		if(!DriverManager.isSmokeSuite()) {
			DriverManager.getSignIn().signIn(SignIn.getUID(FeatureList.FCM_CNX), SignIn.getPWD(FeatureList.FCM_CNX));
	        DriverManager.getSignIn().handleAfterSignInAlertsOtherUser();
		}
		else
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				DriverManager.getSignIn().signIn(SignIn.getUID(FeatureList.SMOKE_IOS), SignIn.getPWD(FeatureList.SMOKE_IOS));
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				DriverManager.getSignIn().signIn(SignIn.getUID(FeatureList.SMOKE_ANDROID), SignIn.getPWD(FeatureList.SMOKE_ANDROID));
			else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				DriverManager.getSignIn().signIn(SignIn.getUID(FeatureList.SMOKE_WEB), SignIn.getPWD(FeatureList.SMOKE_WEB));
			DriverManager.getSignIn().handleAfterSignInAlerts();
	        DriverManager.setSmokeSuiteFlag(true);
		}
		captureMeasurementsPage = new CaptureMeasurementsPage();
		fc1555CaptureMeasurementPage = new FC1555CaptureMeasurementPage();
		switcher = new Switcher();
		serviceHatchPage = new ServiceHatchPage();
		measurementDetailPage = new MeasurementDetailPage();
		gestureUtils = new GestureUtils();
		deviceUtils = new DeviceUtils();
		measurementValue = new StringBuilder();
		measurementUnit = new StringBuilder();
		measurementLabel = new StringBuilder();
		if(!DriverManager.isRealDevice() && DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			serviceHatchPage.toggleFeature("SIMULATED DEVICES", null, true, serviceHatchPage.getElement(ServiceHatchPage.SIMULATED_DEVICES_BUTTON), true);
			switcher.switchToCaptureMeasurementsHomePage();
			Config.useExistingPageSource = true;
			CommonUtils.wait(3);
			Config.iOSPageSource = DriverManager.getDriver().getPageSource();
		}
		else
			switcher.switchToCaptureMeasurementsPageHome();
		captureMeasurementsPage.handleAndroidMeasurementAlerts();
		Config.appWidthCenterFlag = false;
	}
	
	// *********************************************  Web Android Init Tests *********************************************
	
	@Test(alwaysRun = true, priority = 4301, groups = {Config.WEB_SMOKE_CM_TESTS})
	public void initTest()
	{
		//this test method just to init 
	}
	
	// *********************************************  IOS Smoke Tests *********************************************
	
	@Test(alwaysRun = true, priority = 4301, groups = {Config.IOS_SMOKE_TESTS})
	public void captureBeakerMeasurementTest()
	{
		try
		{
			captureMeasurementsPage.connectToSimulatedDevice(FCM.captureMeasurementSimulatedDeviceNameList.get("Beaker"));
			captureMeasurementsPage.saveBeakerMeasurement(false, "99", "°C");
			measurementDetailPage.captureMeasurementsDetails(Config.getPropertiesFilePath(PropertiesFileType.MEASUREMENTS_PROPERTIES), FCM.captureMeasurementSimulatedDeviceNameList.get("Beaker"), MeasurementType.NON_SCALAR, 0);
			captureMeasurementsPage.clickOnDoneButton();
			element = ElementUtils.getElement("Connected Devices", null, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, null);
			gestureUtils.clickOnCordinates(element.getSize().width - 35, element.getLocation().y + 25);	
			element = null;	
		}
		catch(Throwable e)
		{
			captureMeasurementsPage.doneAndDisconnectDevice(1);
		}
	}

	@Test(alwaysRun = true, priority = 4303, groups = {Config.IOS_SMOKE_TESTS})
	public void captureGroupMeasurementTest()
	{
		try
		{
			captureMeasurementsPage.saveGroupMeasurement(FCM.captureMeasurementGroupMeasurementSimulatedDeviceNameList);
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 4304, groups = {})//Config.IOS_SMOKE_TESTS
	public void assignAssetToGroupMeasurementTest()
	{
		try
		{
			measurementDetailPage.assignAsset(FCM.captureMeasurementAssetList[0], FCM.captureMeasurementAssetList[1], FCM.captureMeasurementAssetList[2]);
			Assert.assertTrue(measurementDetailPage.isAssetAssigned(FCM.captureMeasurementAssetList[2]));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 4305, groups = {Config.IOS_SMOKE_TESTS})
	public void assignWorkOrderToGroupMeasurementTest()
	{
		try
		{
			DriverManager.getSignIn().handleOnBoardPrompt();
			measurementDetailPage.assignWorkOrder(Config.measurementAssignedWorkOrderNumber);
			Assert.assertTrue(measurementDetailPage.isWorkOrderAssigned(Config.measurementAssignedWorkOrderNumber));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 4306, groups = {Config.IOS_SMOKE_TESTS})
	public void addTextNoteToGroupMeasurementTest()
	{
		try
		{
			DriverManager.getSignIn().handleOnBoardPrompt();
			measurementDetailPage.addTextNote(Config.measurementTextNoteText);
			Assert.assertTrue(measurementDetailPage.isTextNoteAdded(Config.measurementTextNoteText));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 4307, groups = {Config.IOS_SMOKE_TESTS})
	public void addVoiceNoteToGroupMeasurementTest()
	{
		try
		{
			measurementDetailPage.addVoiceNote(Config.measurementRecordingDuration);
			measurementDetailPage.captureMeasurementsDetails(Config.getPropertiesFilePath(PropertiesFileType.MEASUREMENTS_PROPERTIES), "Grouped", MeasurementType.GROUP, 0);
			captureMeasurementsPage.saveAndDisconnectDevice(FCM.captureMeasurementGroupMeasurementSimulatedDeviceNameList.length);
		}
		catch(Throwable e)
		{
			element = ElementUtils.getElement("Connected Devices", null, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, null);
			gestureUtils.clickOnCordinates(element.getSize().width - 35, element.getLocation().y + 25);
			CommonUtils.wait(2);
			gestureUtils.clickOnCordinates(element.getSize().width - 35, element.getLocation().y + 25);
			element = null;
		}
	}
	
	@Test(alwaysRun = true, priority = 4308, groups = {Config.IOS_SMOKE_TESTS})
	public void recordMeasurementTest() throws Exception
	{
		try
		{
			captureMeasurementsPage.connectToSimulatedDevice(FCM.captureMeasurementSimulatedDeviceNameList.get("Record Measurement"));
			captureMeasurementsPage.recordMeasurement(Config.measurementRecordingDuration);
			measurementDetailPage.captureMeasurementsDetails(Config.getPropertiesFilePath(PropertiesFileType.MEASUREMENTS_PROPERTIES), FCM.captureMeasurementSimulatedDeviceNameList.get("Record Measurement"), MeasurementType.RECORDED, 0);
			captureMeasurementsPage.doneAndDisconnectDevice(1);
		}
		catch(Throwable e)
		{
			element = ElementUtils.getElement("Connected Devices", null, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, null);
			gestureUtils.clickOnCordinates(element.getSize().width - 35, element.getLocation().y + 25);
			element = null;
		}
	}
	
	@Test(alwaysRun = true, priority = 4309, groups = {Config.IOS_SMOKE_TESTS})
	public void captureHudsonMeasurementTest()
	{
		try
		{
			captureMeasurementsPage.connectToSimulatedDevice(FCM.captureMeasurementSimulatedDeviceNameList.get("Hudson"));
			captureMeasurementsPage.saveMeasurement();
			measurementDetailPage.captureMeasurementsDetails(Config.getPropertiesFilePath(PropertiesFileType.MEASUREMENTS_PROPERTIES), FCM.captureMeasurementSimulatedDeviceNameList.get("Hudson"), MeasurementType.NON_SCALAR, 0);
			captureMeasurementsPage.clickOnDoneButton();
			element = ElementUtils.getElement("Connected Devices", null, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, null);
			gestureUtils.clickOnCordinates(element.getSize().width - 35, element.getLocation().y + 25);	
			element = null;	
			CommonUtils.wait(2);
			captureMeasurementsPage.clickBackButton();
		}
		catch(Throwable e)
		{
			captureMeasurementsPage.doneAndDisconnectDevice(1);
		}
	}
	
	// ******************************************  IOS SMOKE TEST ENDS ******************************************
	
	// ******************************************  Other Wi-Fi TestS **********************************************
	
	//125B (Prism tool) tests
	@Parameters({"wiFiTool","wifiToolssid","flukeWIFI","wifiToolpassword","flukeWIFIpassword"})
	@Test(alwaysRun = true, priority = 7001, groups = {Config.WIFI_TOOL_TESTS, Config.WIFI_TOOL_125B_TESTS})
	public void capture125BMeasurementTest(@Optional("null") String wiFiTool,@Optional("null") String wifiToolssid,@Optional("null") String flukeWIFI,@Optional("null") String wifiToolPassword,@Optional("null") String flukeWIFIpassword)
	{
		try
		{
			Assert.assertTrue(captureMeasurementsPage.capture125BMeasurementTest(wiFiTool, wifiToolssid, flukeWIFI, wifiToolPassword, flukeWIFIpassword));
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
			Assert.assertTrue(captureMeasurementsPage.capture173XMeasurementTest(wiFiTool, wifiToolssid, flukeWIFI, wifiToolPassword, flukeWIFIpassword, switcher));
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
			Assert.assertTrue(captureMeasurementsPage.download437MeasurementTest(wiFiTool, wifiToolssid, flukeWIFI, wifiToolPassword, flukeWIFIpassword, switcher));
		}
		catch(Exception e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	// ****************************************** Other Wi-Fi Test Ends ******************************************
	
	//**************************************** TI FCM Test Suite Starts Here ******************************
	
	@Test(priority = 8000, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS})
	public void captureManualMeasurementTest() throws Exception
	{
		captureMeasurementsPage.clickOnManualMeasureButton();
		captureMeasurementsPage.saveManualMeasurement("12", "V AC");
	}
	
	@Test(priority = 8001, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS}, dependsOnMethods = {"captureManualMeasurementTest"})
	public void assignAssetToManualMeasurementTest() throws Exception
	{
		measurementDetailPage.assignAssetCM(FCM.captureMeasurementAssetList[0], FCM.captureMeasurementAssetList[1], FCM.captureMeasurementAssetList[2]);
		Assert.assertTrue(measurementDetailPage.isAssetAssigned(FCM.captureMeasurementAssetList[2]));
	}
	
	@Test(priority = 8002, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS}, dependsOnMethods = {"captureManualMeasurementTest"})
	public void assignWorkOrderToManualMeasurementTest()
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
	
	@Test(priority = 8003, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS}, dependsOnMethods = {"captureManualMeasurementTest"})
	public void addTextNoteToManualMeasurementTest()
	{
		try
		{
			CommonUtils.wait(5, 1, 0);	
			measurementDetailPage.addTextNote(Config.measurementTextNoteText);
				Assert.assertTrue(measurementDetailPage.isTextNoteAdded(Config.measurementTextNoteText));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8004, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS}, dependsOnMethods = {"captureManualMeasurementTest"})
	public void shareManualMeasurementTest()
	{
		try
		{
			ElementUtils.click(5, measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.SHARE_BUTTON));
			measurementDetailPage.shareMeasurement(Config.SHARE_EMAIL_ADDRESS, FCM.DataType.MEASUREMENT_DATA, FCM.ShareFormat.CSV, false);
			CommonUtils.wait(0, 1, 0);
			ElementUtils.click(1, captureMeasurementsPage.getCaptureMeasurementsPageObject(CaptureMeasurementsPageObject.SAVE_BUTTON));
			ElementUtils.safeClick(1, captureMeasurementsPage.getCaptureMeasurementsPageObject(CaptureMeasurementsPageObject.GOT_IT_BUTTON));

		}
		catch(Throwable e)
		{
			CommonUtils.wait(0, 1, 0);
			captureMeasurementsPage.clickOnDoneButton();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 9019, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM})
	public void loadAsset() throws Exception
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				captureMeasurementsPage.clickBackButton();
			switcher.switchToAssetsPage();
			measurementDetailPage.loadAsset(FCM.captureMeasurementAssetList[0], FCM.captureMeasurementAssetList[1]);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority = 9020, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM})
	public void connectToTI400Test() throws Exception
	{
			deviceUtils.toggleWiFi(true, "Settings", true);
			deviceUtils.connectToNetwork(FCM.DeviceList.TI400WIFI.getAttributeValue(), FCM.DeviceList.TI_400_PASSWORD.getAttributeValue());
			deviceUtils.toogleFCAPP(true, null);
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				ElementUtils.safeClick(deviceUtils.getDeviceUtilsWebElement(DeviceUtilsObjects.CANCEL_BUTTON));
			switcher.switchToCaptureMeasurementsPageHome();
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				captureMeasurementsPage.connectToRealDevice(FCM.DeviceList.TI.getAttributeValue());
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				captureMeasurementsPage.connectToRealDevice(FCM.DeviceList.ANDROID_TI_400.getAttributeValue());
	}
	
	@Test(priority = 9021, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM}, dependsOnMethods = {"connectToTI400Test"})
	public void downloadImagesFromTI400Test()
	{
		try
		{
			CommonUtils.wait(10);
			captureMeasurementsPage.downloadTIMeasurement(2, FCM.DeviceList.TI_400_DOWNLOAD.getAttributeValue(), true);
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 9022, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM}, dependsOnMethods = {"connectToTI400Test"})
	public void captureTI400MeasurementTest()
	{
		try
		{
			captureMeasurementsPage.captureTIMeasurement(FCM.DeviceList.TI.getAttributeValue());
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 9023, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM}, dependsOnMethods = {"connectToTI400Test"})
	public void assignAssetToTI400MeasurementTest()
	{
		try
		{
			measurementDetailPage.assignAssetCM(FCM.captureMeasurementAssetList[0], FCM.captureMeasurementAssetList[1], FCM.captureMeasurementAssetList[2]);
			Assert.assertTrue(measurementDetailPage.isAssetAssigned(FCM.captureMeasurementAssetList[2]));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 9024, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM}, dependsOnMethods = {"connectToTI400Test"})
	public void assignWorkOrderToTI400MeasurementTest()
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
	
	@Test(priority = 9025, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM}, dependsOnMethods = {"connectToTI400Test"})
	public void addTextNoteToTI400MeasurementTest()
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
	
	@Test(priority = 9026, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM}, dependsOnMethods = {"connectToTI400Test"})
	public void TI400DeviceNameTest()
	{
		try
		{
			Assert.assertTrue(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MEASUREMENT_DEVICE_NAME).getText().equals(FCM.DeviceList.TI.getAttributeValue()));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 9027, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM}, dependsOnMethods = {"connectToTI400Test"})
	public void TI400MeasurementValueTest()
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
	
	@Test(priority = 9028, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM}, dependsOnMethods = {"connectToTI400Test"})
	public void TI400MeasurementUnitTest()
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
	
	@Test(priority = 9029, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM}, dependsOnMethods = {"connectToTI400Test"})
	public void TI400MaxTempValueTest()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				measurementValue.delete(0, measurementValue.length());
				measurementValue.append(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MAX_TEMP).getText());
				Assert.assertTrue(FloatValidator.getInstance().isInRange(Float.parseFloat(measurementValue.substring(measurementValue.lastIndexOf(":") + 2, measurementValue.lastIndexOf(" "))), 15.0, 100.0));
			}
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
	
	@Test(priority = 9030, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM}, dependsOnMethods = {"connectToTI400Test"})
	public void TI400MinTempValueTest()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				measurementValue.delete(0, measurementValue.length());
				measurementValue.append(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MIN_TEMP).getText());
				Assert.assertTrue(FloatValidator.getInstance().isInRange(Float.parseFloat(measurementValue.substring(measurementValue.lastIndexOf(":") + 2, measurementValue.lastIndexOf(" "))), 15.0, 100.0));
			}
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
	
	@Test(priority = 9031, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM}, dependsOnMethods = {"connectToTI400Test"})
	public void TI400MaxTempUnitTest()
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
	
	@Test(priority = 9032, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM}, dependsOnMethods = {"connectToTI400Test"})
	public void TI400MinTempUnitTest()
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
	
	@Test(priority = 9033, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM}, dependsOnMethods = {"connectToTI400Test"})
	public void TI400MaxTempLabelTest()
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
	
	@Test(priority = 9034, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM}, dependsOnMethods = {"connectToTI400Test"})
	public void TI400MinTempLabelTest()
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
	
	
	@Test(priority = 9035, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM}, dependsOnMethods = {"connectToTI400Test"})
	public void shareTI400MeasurementTest()
	{
		try
		{
			ElementUtils.click(5, measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.SHARE_BUTTON));
			measurementDetailPage.shareMeasurement(Config.SHARE_EMAIL_ADDRESS, FCM.DataType.THERMAL_IMAGES, FCM.ShareFormat.PDF, false);
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 9036, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM}, dependsOnMethods = {"connectToTI400Test"})
	public void saveTI400MeasurementTest() throws Exception
	{
		measurementDetailPage.captureMeasurementsDetails(Config.getPropertiesFilePath(PropertiesFileType.MEASUREMENTS_PROPERTIES), FCM.DeviceList.TI_400.getAttributeValue(), MeasurementType.TI, 0);
		ElementUtils.click(1, captureMeasurementsPage.getCaptureMeasurementsPageObject(CaptureMeasurementsPageObject.SAVE_BUTTON));
		ElementUtils.click(1, captureMeasurementsPage.getCaptureMeasurementsPageObject(CaptureMeasurementsPageObject.BACK_BUTTON));
		ElementUtils.click(1, captureMeasurementsPage.getCaptureMeasurementsPageObject(CaptureMeasurementsPageObject.DISCONNECT_DEVICE));
	}
	
	@Test(priority = 9037, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM})
	public void connectToTI450Test() throws Exception
	{
		deviceUtils.launchOtherApp(deviceUtils.getDeviceUtilsAttributes(DeviceUtilsObjects.IOS_SETTINGS_BUNDLE_ID), AndroidUtils.getPackageName(DriverManager.getDeviceName()), AndroidUtils.getActivityName(DriverManager.getDeviceName()));
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			deviceUtils.launchAndroidWiFiPage();
		deviceUtils.connectToNetwork(FCM.DeviceList.TI450WIFI.getAttributeValue(), "password");
		deviceUtils.toogleFCAPP(true, null);
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			ElementUtils.safeClick(deviceUtils.getDeviceUtilsWebElement(DeviceUtilsObjects.CANCEL_BUTTON));
		switcher.switchToCaptureMeasurementsPageHome();
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			captureMeasurementsPage.connectToRealDevice(FCM.DeviceList.TI.getAttributeValue());
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			captureMeasurementsPage.connectToRealDevice(FCM.DeviceList.ANDROID_TI_450.getAttributeValue());
	}
	
	@Test(priority = 9041, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM}, dependsOnMethods = {"connectToTI450Test"})
	public void downloadImagesFromTI450Test()
	{
		try
		{
			CommonUtils.wait(10);
			captureMeasurementsPage.downloadTIMeasurement(2, FCM.DeviceList.TI_450_DOWNLOAD.getAttributeValue(), true);
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 9042, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM}, dependsOnMethods = {"connectToTI450Test"})
	public void captureTI450MeasurementTest()
	{
		try
		{
			captureMeasurementsPage.captureTIMeasurement(FCM.DeviceList.TI.getAttributeValue());
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 9043, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM}, dependsOnMethods = {"connectToTI450Test"})
	public void assignAssetToTI450MeasurementTest()
	{
		try
		{
			measurementDetailPage.assignAssetCM(FCM.captureMeasurementAssetList[0], FCM.captureMeasurementAssetList[1], FCM.captureMeasurementAssetList[2]);
			Assert.assertTrue(measurementDetailPage.isAssetAssigned(FCM.captureMeasurementAssetList[2]));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 9044, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM}, dependsOnMethods = {"connectToTI450Test"})
	public void assignWorkOrderToTI450MeasurementTest()
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
	
	@Test(priority = 9045, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM}, dependsOnMethods = {"connectToTI450Test"})
	public void addTextNoteToTI450MeasurementTest()
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
	
	@Test(priority = 9046, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM}, dependsOnMethods = {"connectToTI450Test"})
	public void TI450DeviceNameTest()
	{
		try
		{
			Assert.assertTrue(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MEASUREMENT_DEVICE_NAME).getText().equals(FCM.DeviceList.TI.getAttributeValue()));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 9047, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM}, dependsOnMethods = {"connectToTI450Test"})
	public void TI450MeasurementValueTest()
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
	
	@Test(priority = 9048, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM}, dependsOnMethods = {"connectToTI450Test"})
	public void TI450MeasurementUnitTest()
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
	
	@Test(priority = 9049, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM}, dependsOnMethods = {"connectToTI450Test"})
	public void TI450MaxTempValueTest()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				measurementValue.delete(0, measurementValue.length());
				measurementValue.append(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MAX_TEMP).getText());
				Assert.assertTrue(FloatValidator.getInstance().isInRange(Float.parseFloat(measurementValue.substring(measurementValue.lastIndexOf(":") + 2, measurementValue.lastIndexOf(" "))), 15.0, 100.0));
			}
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
	
	@Test(priority = 9050, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM}, dependsOnMethods = {"connectToTI450Test"})
	public void TI450MinTempValueTest()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				measurementValue.delete(0, measurementValue.length());
				measurementValue.append(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MIN_TEMP).getText());
				Assert.assertTrue(FloatValidator.getInstance().isInRange(Float.parseFloat(measurementValue.substring(measurementValue.lastIndexOf(":") + 2, measurementValue.lastIndexOf(" "))), 15.0, 100.0));
			}
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
	
	@Test(priority = 9051, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM}, dependsOnMethods = {"connectToTI450Test"})
	public void TI450MaxTempUnitTest()
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
	
	@Test(priority = 9052, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM}, dependsOnMethods = {"connectToTI450Test"})
	public void TI450MinTempUnitTest()
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
	
	@Test(priority = 9053, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM}, dependsOnMethods = {"connectToTI450Test"})
	public void TI450MaxTempLabelTest()
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
	
	@Test(priority = 9054, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM}, dependsOnMethods = {"connectToTI450Test"})
	public void TI450MinTempLabelTest()
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
	
	@Test(priority = 9055, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM}, dependsOnMethods = {"connectToTI450Test"})
	public void shareTI450MeasurementTest()
	{
		try
		{
			ElementUtils.click(5, measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.SHARE_BUTTON));
			measurementDetailPage.shareMeasurement(Config.SHARE_EMAIL_ADDRESS, FCM.DataType.THERMAL_IMAGES, FCM.ShareFormat.PDF, false);
			CommonUtils.wait(3);
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 9056, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM}, dependsOnMethods = {"connectToTI450Test"})
	public void saveTI450MeasurementTest()
	{
		try
		{
			measurementDetailPage.captureMeasurementsDetails(Config.getPropertiesFilePath(PropertiesFileType.MEASUREMENTS_PROPERTIES), FCM.DeviceList.TI_450.getAttributeValue(), MeasurementType.TI, 0);
			ElementUtils.click(1, captureMeasurementsPage.getCaptureMeasurementsPageObject(CaptureMeasurementsPageObject.SAVE_BUTTON));
			ElementUtils.click(1, captureMeasurementsPage.getCaptureMeasurementsPageObject(CaptureMeasurementsPageObject.BACK_BUTTON));
			ElementUtils.click(1, captureMeasurementsPage.getCaptureMeasurementsPageObject(CaptureMeasurementsPageObject.DISCONNECT_DEVICE));
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
	
	@Test(priority = 9075, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM})
	public void connectToTIS65Test() throws Exception
	{
		deviceUtils.launchOtherApp(deviceUtils.getDeviceUtilsAttributes(DeviceUtilsObjects.IOS_SETTINGS_BUNDLE_ID), AndroidUtils.getPackageName(DriverManager.getDeviceName()), AndroidUtils.getActivityName(DriverManager.getDeviceName()));
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			deviceUtils.launchAndroidWiFiPage();		
		deviceUtils.connectToNetwork(FCM.DeviceList.TI_S65_WIFI.getAttributeValue(), "password");
		deviceUtils.toogleFCAPP(true, null);
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			ElementUtils.safeClick(deviceUtils.getDeviceUtilsWebElement(DeviceUtilsObjects.CANCEL_BUTTON));
		switcher.switchToCaptureMeasurementsPageHome();
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			captureMeasurementsPage.connectToRealDevice(FCM.DeviceList.TI.getAttributeValue());
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			captureMeasurementsPage.connectToRealDevice(FCM.DeviceList.ANDROID_TI_S65.getAttributeValue());
	}
	
	@Test(priority = 9076, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM}, dependsOnMethods = {"connectToTIS65Test"})
	public void downloadImagesFromTIS65Test()
	{
		try
		{
			CommonUtils.wait(10);
			captureMeasurementsPage.downloadTIMeasurement(2, FCM.DeviceList.TI_S65_DOWNLOAD.getAttributeValue(), false);
			ElementUtils.click(1, captureMeasurementsPage.getCaptureMeasurementsPageObject(CaptureMeasurementsPageObject.DISCONNECT_DEVICE));
		}
		catch(Throwable e)
		{
			element = ElementUtils.getElement("Connected Devices", null, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, null);
			gestureUtils.clickOnCordinates(element.getSize().width - 35, element.getLocation().y + 25);
			CommonUtils.wait(2);
		}
	}
	
	@Test(priority = 9077, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM})
	public void connectToTIS75Test() throws Exception
	{
		deviceUtils.launchOtherApp(deviceUtils.getDeviceUtilsAttributes(DeviceUtilsObjects.IOS_SETTINGS_BUNDLE_ID), AndroidUtils.getPackageName(DriverManager.getDeviceName()), AndroidUtils.getActivityName(DriverManager.getDeviceName()));
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			deviceUtils.launchAndroidWiFiPage();		
		deviceUtils.connectToNetwork(FCM.DeviceList.TI_S75_WIFI.getAttributeValue(), "password");
		deviceUtils.toogleFCAPP(true, null);
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			ElementUtils.safeClick(deviceUtils.getDeviceUtilsWebElement(DeviceUtilsObjects.CANCEL_BUTTON));
		switcher.switchToCaptureMeasurementsPageHome();
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			captureMeasurementsPage.connectToRealDevice(FCM.DeviceList.TI.getAttributeValue());
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			captureMeasurementsPage.connectToRealDevice(FCM.DeviceList.ANDROID_TI_S75.getAttributeValue());
	}
	
	@Test(priority = 9078, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM}, dependsOnMethods = {"connectToTIS75Test"})
	public void downloadImagesFromTIS75Test() throws Exception
	{
		try
		{
			CommonUtils.wait(10);
			captureMeasurementsPage.downloadTIMeasurement(2, FCM.DeviceList.TI_S75_DOWNLOAD.getAttributeValue(), false);
			ElementUtils.click(1, captureMeasurementsPage.getCaptureMeasurementsPageObject(CaptureMeasurementsPageObject.DISCONNECT_DEVICE));
		}
		catch(Throwable e)
		{
			element = ElementUtils.getElement("Connected Devices", null, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, null);
			gestureUtils.clickOnCordinates(element.getSize().width - 35, element.getLocation().y + 25);
			ElementUtils.click(1, captureMeasurementsPage.getCaptureMeasurementsPageObject(CaptureMeasurementsPageObject.BACK_BUTTON));
			
		}
	}
	
	@Test(priority = 9079, groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM_CAPTURE_IOS, Config.TI_FCM})
	public void connectToWiFiTest()
	{
		try
		{
			deviceUtils.launchOtherApp(deviceUtils.getDeviceUtilsAttributes(DeviceUtilsObjects.IOS_SETTINGS_BUNDLE_ID), AndroidUtils.getPackageName(DriverManager.getDeviceName()), AndroidUtils.getActivityName(DriverManager.getDeviceName()));
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				deviceUtils.launchAndroidWiFiPage();		
			deviceUtils.connectToNetwork("FC-Net", "wgS3jNC!6D");
			deviceUtils.toogleFCAPP(true, null);
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	// ******************************************  TI FCM Test Suite Ends Here *********************************
	
	
	// ******************************************  CNX Test Suite Starts Here *********************************
	
	

	//***********Manual Measurement Capturing and deletion for Android Smoke Test and Coach Mark Related test Cases for Android**************

	@Test(priority = 8001, groups = {Config.ANDROID_SMOKE_EXTENDED_TESTS})//Config.ANDROID_SMOKE_TESTS
	public void captureManualMeasurementSmokeTest() throws Exception
	{
		try 
		{	
		captureMeasurementsPage.clickOnManualMeasureButton();
		captureMeasurementsPage.saveManualMeasurement("12", "V AC");
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		measurementDetailPage.nextAndGotItButtonClick();
			//ElementUtils.safeClick(5, measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.ANDROID_ASSET_POPUP_CLOSE_BUTTON));
		captureMeasurementsPage.clickOnDoneButton();
		}
		catch(Throwable e)
		{
			captureMeasurementsPage.clickOnDoneButton();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 168005, groups = {Config.ANDROID_SMOKE_EXTENDED_TESTS}) //Config.ANDROID_SMOKE_TESTS ,168003
	public void deleteManualMeasurementSmokeTest() throws Exception
	{
		try
		{
			switcher.switchToMeasurementsPage();
			String getDate=fc1555CaptureMeasurementPage.getEeveeMeasurementDate();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,getDate,LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,getDate,null,null).click();
			fc1555CaptureMeasurementPage.coachMarkClosure();
			measurementDetailPage.deleteMeasurement();
			switcher.switchToHomePage();
			//CommonUtils.wait(15);
		}
		catch(Throwable e)
		{
			captureMeasurementsPage.clickOnDoneButton();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 168001, groups = {Config.ANDROID_SMOKE_EXTENDED_TESTS}) //Config.ANDROID_SMOKE_TESTS ,168003
	public void deleteManualMeasurementCreatedfromWorkOrderFlowSmokeTest() throws Exception
	{
		try
		{
			switcher.switchToMeasurementsPage();
			String getDate=fc1555CaptureMeasurementPage.getEeveeMeasurementDate();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,getDate,LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,getDate,null,null).click();
			fc1555CaptureMeasurementPage.coachMarkClosure();
			measurementDetailPage.deleteMeasurement();
			switcher.switchToHomePage();
			//CommonUtils.wait(15);
		}
		catch(Throwable e)
		{
			captureMeasurementsPage.clickOnDoneButton();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8002, groups = {Config.ANDROID_SMOKE_EXTENDED_TESTS})//Config.ANDROID_SMOKE_TESTS, 8002
	public void recordCameraMeasurementSmokeTest() throws Exception
	{
		try 
		{
		CommonUtils.wait(3);
		//measurementDetailPage.saveAndDocumentGotItButon();
		captureMeasurementsPage.recordCameraMeasurementForAndroidSmoke(3);
		CommonUtils.wait(3);
		measurementDetailPage.nextAndGotItButtonClick();
		captureMeasurementsPage.clickOnDoneButton();
		}
		catch(Throwable e)
		{
			captureMeasurementsPage.clickOnDoneButton();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 168003, groups = {Config.ANDROID_SMOKE_EXTENDED_TESTS})//Config.ANDROID_SMOKE_TESTS, 168001
	public void deleteRecordedCameraMeasurementSmokeTest() throws Exception
	{
		try
		{
			switcher.switchToMeasurementsPage();
			String getDate=fc1555CaptureMeasurementPage.getEeveeMeasurementDate();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,getDate,LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,getDate,null,null).click();
			//fc1555CaptureMeasurementPage.coachMarkClosure();
			measurementDetailPage.deleteMeasurement();
			switcher.switchToHomePage();
			//CommonUtils.wait(15);
		}
		catch(Throwable e)
		{
			captureMeasurementsPage.clickOnDoneButton();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8003, groups = {Config.ANDROID_SMOKE_EXTENDED_TESTS})//Config.ANDROID_SMOKE_TESTS, 8003
	public void saveCameraMeasurementSmokeTest() throws Exception
	{
		try {
		//switcher.switchToCaptureMeasurementsPageHome();
			captureMeasurementsPage.saveCameraMeasurementForAndroidSmoke();
		}
		catch(Throwable e)
		{
			captureMeasurementsPage.clickOnDoneButton();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 168002, groups = {Config.ANDROID_SMOKE_EXTENDED_TESTS})//Config.ANDROID_SMOKE_TESTS ,168002
	public void deleteSaveCameraMeasurementSmokeTest() throws Exception
	{
		try
		{
			switcher.switchToMeasurementsPage();
			String getDate=fc1555CaptureMeasurementPage.getEeveeMeasurementDate();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT,getDate,LocatorStrategy.IOS_LOCATOR_STRATEGY_ID,getDate,null,null).click();
			//fc1555CaptureMeasurementPage.coachMarkClosure();
			measurementDetailPage.deleteMeasurement();
			switcher.switchToHomePage();
			//CommonUtils.wait(15);
		}
		catch(Throwable e)
		{
			captureMeasurementsPage.clickOnDoneButton();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	//***********End of Smoke tests **************
	
	@Test(priority = 8020, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX})
	public void connectToV3000Test() throws Exception
	{
		captureMeasurementsPage.connectToRealDevice(FCM.DeviceList.V3000.getAttributeValue());
	}
	
	@Test(priority = 8021, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS,  Config.CNX}, dependsOnMethods = {"connectToV3000Test"})
	public void captureV3000MeasurementTest() throws Exception
	{
		captureMeasurementsPage.saveMeasurement();
	}
	
	@Test(priority = 8022, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS,  Config.CNX}, dependsOnMethods = {"connectToV3000Test"})
	public void assignAssetToV3000MeasurementTest()
	{
		try
		{
			measurementDetailPage.assignAssetCM(FCM.captureMeasurementAssetList[0], FCM.captureMeasurementAssetList[1], FCM.captureMeasurementAssetList[2]);
			Assert.assertTrue(measurementDetailPage.isAssetAssigned(FCM.captureMeasurementAssetList[2]));
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8023, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS,  Config.CNX}, dependsOnMethods = {"connectToV3000Test"})
	public void assignWorkOrderToV3000MeasurementTest()
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
	
	@Test(priority = 8024, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS,  Config.CNX}, dependsOnMethods = {"connectToV3000Test"})
	public void addTextNoteToV3000MeasurementTest()
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
	
	@Test(priority = 8025, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS,  Config.CNX}, dependsOnMethods = {"connectToV3000Test"})
	public void V3000DeviceNameTest()
	{
		try
		{
			Assert.assertTrue(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.CAPTURED_MEASUREMENT_DEVICE_NAME).getText().startsWith(FCM.DeviceList.V3000.getAttributeValue()));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8026, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS,  Config.CNX}, dependsOnMethods = {"connectToV3000Test"})
	public void V3000MeasurementValueTest()
	{
		try
		{
			Assert.assertTrue(FloatValidator.getInstance().isInRange(Float.parseFloat(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.CAPTURED_MEASUREMENT_VALUE).getText()), -10.0, 10.0));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8027, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS,  Config.CNX}, dependsOnMethods = {"connectToV3000Test"})
	public void V3000MeasurementUnitTest()
	{
		try
		{
			measurementUnit.delete(0, measurementUnit.length());
			measurementUnit.append(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.CAPTURED_MEASUREMENT_UNIT).getText());
			Assert.assertTrue(measurementUnit.toString().contains(FCM.DeviceList.V3000_MEASUREMENT_UNIT.getAttributeValue()));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8028, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS,  Config.CNX}, dependsOnMethods = {"connectToV3000Test"})
	public void shareV3000MeasurementTest()
	{
		try
		{
			measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.SHARE_BUTTON).click();
			measurementDetailPage.shareMeasurement(Config.SHARE_EMAIL_ADDRESS, FCM.DataType.MEASUREMENT_DATA, FCM.ShareFormat.CSV, false);
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				CommonUtils.wait(1);
				AndroidUtils.back();
			}	
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8029, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS,  Config.CNX}, dependsOnMethods = {"connectToV3000Test"})
	public void saveV3000MeasurementTest()
	{
		try
		{
			measurementDetailPage.captureMeasurementsDetails(Config.getPropertiesFilePath(PropertiesFileType.MEASUREMENTS_PROPERTIES), FCM.DeviceList.V3000.getAttributeValue(), MeasurementType.SCALAR, 0);
			ElementUtils.click(1, captureMeasurementsPage.getCaptureMeasurementsPageObject(CaptureMeasurementsPageObject.SAVE_BUTTON));
			ElementUtils.safeClick(1, captureMeasurementsPage.getCaptureMeasurementsPageObject(CaptureMeasurementsPageObject.GOT_IT_BUTTON));
		}
		catch(Throwable e)
		{
			Assert.fail();
		}
	}
	
	@Test(priority = 8030, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS,  Config.CNX}, dependsOnMethods = {"connectToV3000Test"})
	public void downloadV3000LogTest()
	{
		try
		{
			CommonUtils.wait(1);
			int[] tapCordinates = GestureUtils.getTapCordinates(GestureUtils.ObjectName.DOWNLOAD_LOG);
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				gestureUtils.clickOnCordinates(tapCordinates[0], tapCordinates[1]); 
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				gestureUtils.clickOnCordinates(tapCordinates[0], tapCordinates[1]); 
			captureMeasurementsPage.configureCNXLogging("1", "0", "1", "0");
			captureMeasurementsPage.clearCNXLog();
			captureMeasurementsPage.startCNXLogging();
			CommonUtils.wait(7);
			captureMeasurementsPage.downloadCNXLog();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8031, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS,  Config.CNX}, dependsOnMethods = {"connectToV3000Test"})
	public void shareV3000LogTest()
	{
		try
		{
			captureMeasurementsPage.shareCNXLog(Config.SHARE_EMAIL_ADDRESS);
			int[] tapCordinates = GestureUtils.getTapCordinates(GestureUtils.ObjectName.DISCONNECT_DEVICE);
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				CommonUtils.wait(1);
				gestureUtils.clickOnCordinates(tapCordinates[0], tapCordinates[1]); 
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				ElementUtils.click(1, captureMeasurementsPage.getCaptureMeasurementsPageObject(CaptureMeasurementsPageObject.DISCONNECT_DEVICE));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8050, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS,  Config.CNX})
	public void connectToA3002Test() throws Exception
	{
		captureMeasurementsPage.connectToRealDevice(FCM.DeviceList.A3002.getAttributeValue());
	}
	
	@Test(priority = 8051, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS,  Config.CNX}, dependsOnMethods = {"connectToA3002Test"})
	public void captureA3002MeasurementTest()
	{
		try
		{
			captureMeasurementsPage.saveMeasurement();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8052, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS,  Config.CNX}, dependsOnMethods = {"connectToA3002Test"})
	public void assignAssetToA3002MeasurementTest()
	{
		try
		{
			measurementDetailPage.assignAssetCM(FCM.captureMeasurementAssetList[0], FCM.captureMeasurementAssetList[1], FCM.captureMeasurementAssetList[2]);
			Assert.assertTrue(measurementDetailPage.isAssetAssigned(FCM.captureMeasurementAssetList[2]));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8053, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS,  Config.CNX}, dependsOnMethods = {"connectToA3002Test"})
	public void assignWorkOrderToA3002MeasurementTest()
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
	
	@Test(priority = 8054, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS,  Config.CNX}, dependsOnMethods = {"connectToA3002Test"})
	public void addTextNoteToA3002MeasurementTest()
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
	
	@Test(priority = 8055, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS,  Config.CNX}, dependsOnMethods = {"connectToA3002Test"})
	public void A3002DeviceNameTest()
	{
		try
		{
			Assert.assertTrue(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.CAPTURED_MEASUREMENT_DEVICE_NAME).getText().startsWith(FCM.DeviceList.A3002.getAttributeValue()));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8056, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS,  Config.CNX}, dependsOnMethods = {"connectToA3002Test"})
	public void A3002MeasurementValueTest()
	{
		try
		{
			Assert.assertTrue(FloatValidator.getInstance().isInRange(Float.parseFloat(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.CAPTURED_MEASUREMENT_VALUE).getText()), -10.0, 10.0));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8057, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS,  Config.CNX}, dependsOnMethods = {"connectToA3002Test"})
	public void A3002MeasurementUnitTest()
	{
		try
		{
			measurementUnit.delete(0, measurementUnit.length());
			measurementUnit.append(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.CAPTURED_MEASUREMENT_UNIT).getText());
			Assert.assertTrue(measurementUnit.toString().contains(FCM.DeviceList.A3002_MEASUREMENT_UNIT.getAttributeValue()));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8058, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS,  Config.CNX}, dependsOnMethods = {"connectToA3002Test"})
	public void shareA3002MeasurementTest()
	{
		try
		{
			ElementUtils.click(5, measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.SHARE_BUTTON));
			measurementDetailPage.shareMeasurement(Config.SHARE_EMAIL_ADDRESS, FCM.DataType.MEASUREMENT_DATA, FCM.ShareFormat.CSV, false);
			CommonUtils.wait(2);
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				AndroidUtils.back();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8059, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS,  Config.CNX}, dependsOnMethods = {"connectToA3002Test"})
	public void saveA3002MeasurementTest()
	{
		try
		{
			measurementDetailPage.captureMeasurementsDetails(Config.getPropertiesFilePath(PropertiesFileType.MEASUREMENTS_PROPERTIES), FCM.DeviceList.A3002.getAttributeValue(), MeasurementType.SCALAR, 0);
			ElementUtils.click(1, captureMeasurementsPage.getCaptureMeasurementsPageObject(CaptureMeasurementsPageObject.SAVE_BUTTON));
			ElementUtils.safeClick(1, captureMeasurementsPage.getCaptureMeasurementsPageObject(CaptureMeasurementsPageObject.GOT_IT_BUTTON));
		}
		catch(Throwable e)
		{
			Assert.fail();
		}
	}
	
	@Test(priority = 8060, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS,  Config.CNX}, dependsOnMethods = {"connectToA3002Test"})
	public void downloadA3002LogTest()
	{
		try
		{
			CommonUtils.wait(2);
			int[] tapCordinates = GestureUtils.getTapCordinates(GestureUtils.ObjectName.DOWNLOAD_LOG);
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				gestureUtils.clickOnCordinates(tapCordinates[0], tapCordinates[1]); 
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				gestureUtils.clickOnCordinates(tapCordinates[0], tapCordinates[1]); 
			captureMeasurementsPage.configureCNXLogging("1", "0", "1", "0");
			captureMeasurementsPage.clearCNXLog();
			captureMeasurementsPage.startCNXLogging();
			CommonUtils.wait(7);
			captureMeasurementsPage.downloadCNXLog();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8061, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS,  Config.CNX}, dependsOnMethods = {"connectToA3002Test"})
	public void shareA3002LogTest()
	{
		try
		{
			captureMeasurementsPage.shareCNXLog(Config.SHARE_EMAIL_ADDRESS);
			int[] tapCordinates = GestureUtils.getTapCordinates(GestureUtils.ObjectName.DISCONNECT_DEVICE);
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				CommonUtils.wait(2);
				gestureUtils.clickOnCordinates(tapCordinates[0], tapCordinates[1]); 
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				ElementUtils.click(1, captureMeasurementsPage.getCaptureMeasurementsPageObject(CaptureMeasurementsPageObject.DISCONNECT_DEVICE));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8100, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1,  Config.CNX})
	public void connectToT3000Test() throws Exception
	{
		captureMeasurementsPage.connectToRealDevice(FCM.DeviceList.T3000.getAttributeValue());
	}
	
	@Test(priority = 8101, groups = { Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX}, dependsOnMethods = {"connectToT3000Test"})
	public void captureT3000MeasurementTest()
	{
		try
		{
			captureMeasurementsPage.saveMeasurement();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8102, groups = { Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX}, dependsOnMethods = {"connectToT3000Test"})
	public void assignAssetToT3000MeasurementTest()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				ElementUtils.safeClick(5, measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.ANDROID_ASSET_POPUP_CLOSE_BUTTON));
			measurementDetailPage.assignAssetCM(FCM.captureMeasurementAssetList[0], FCM.captureMeasurementAssetList[1], FCM.captureMeasurementAssetList[2]);
			Assert.assertTrue(measurementDetailPage.isAssetAssigned(FCM.captureMeasurementAssetList[2]));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8103, groups = { Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX}, dependsOnMethods = {"connectToT3000Test"})
	public void assignWorkOrderToT3000MeasurementTest()
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
	
	@Test(priority = 8104, groups = { Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX}, dependsOnMethods = {"connectToT3000Test"})
	public void addTextNoteToT3000MeasurementTest()
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
	
	@Test(priority = 8105, groups = { Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX}, dependsOnMethods = {"connectToT3000Test"})
	public void T3000DeviceNameTest()
	{
		try
		{
			Assert.assertTrue(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.CAPTURED_MEASUREMENT_DEVICE_NAME).getText().startsWith(FCM.DeviceList.T3000.getAttributeValue()));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8106, groups = { Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX}, dependsOnMethods = {"connectToT3000Test"})
	public void T3000MeasurementValueTest()
	{
		try
		{
			Assert.assertTrue(FloatValidator.getInstance().isInRange(Float.parseFloat(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.CAPTURED_MEASUREMENT_VALUE).getText()), -10.0, 110.0));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8107, groups = { Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX}, dependsOnMethods = {"connectToT3000Test"})
	public void T3000MeasurementUnitTest()
	{
		try
		{
			measurementUnit.delete(0, measurementUnit.length());
			measurementUnit.append(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.CAPTURED_MEASUREMENT_UNIT).getText());
			Assert.assertTrue(measurementUnit.toString().contains(FCM.DeviceList.T3000_MEASUREMENT_UNIT.getAttributeValue()));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8108, groups = { Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX}, dependsOnMethods = {"connectToT3000Test"})
	public void shareT3000MeasurementTest()
	{
		try
		{
			ElementUtils.click(5, measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.SHARE_BUTTON));
			measurementDetailPage.shareMeasurement(Config.SHARE_EMAIL_ADDRESS, FCM.DataType.MEASUREMENT_DATA, FCM.ShareFormat.CSV, false);
			CommonUtils.wait(2);
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				AndroidUtils.back();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8109, groups = { Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX}, dependsOnMethods = {"connectToT3000Test"})
	public void saveT3000MeasurementTest()
	{
		try
		{
			measurementDetailPage.captureMeasurementsDetails(Config.getPropertiesFilePath(PropertiesFileType.MEASUREMENTS_PROPERTIES), FCM.DeviceList.T3000.getAttributeValue(), MeasurementType.SCALAR, 0);
			ElementUtils.click(1, captureMeasurementsPage.getCaptureMeasurementsPageObject(CaptureMeasurementsPageObject.SAVE_BUTTON));
			int[] tapCordinates = GestureUtils.getTapCordinates(GestureUtils.ObjectName.DISCONNECT_DEVICE);
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				CommonUtils.wait(2);
				gestureUtils.clickOnCordinates(tapCordinates[0], tapCordinates[1]); 
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				ElementUtils.click(1, captureMeasurementsPage.getCaptureMeasurementsPageObject(CaptureMeasurementsPageObject.DISCONNECT_DEVICE));
		}
		catch(Throwable e)
		{
			Assert.fail();
		}
	}
	
	
	@Test(priority = 8110, groups = {}, dependsOnMethods = {"connectToT3000Test"})
	public void downloadT3000LogTest()
	{
		try
		{
			CommonUtils.wait(2);
			int[] tapCordinates = GestureUtils.getTapCordinates(GestureUtils.ObjectName.DOWNLOAD_LOG);
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				gestureUtils.clickOnCordinates(tapCordinates[0], tapCordinates[1]); 
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				gestureUtils.clickOnCordinates(tapCordinates[0], tapCordinates[1]); 
			captureMeasurementsPage.configureCNXLogging("1", "0", "1", "0");
			captureMeasurementsPage.clearCNXLog();
			captureMeasurementsPage.startCNXLogging();
			CommonUtils.wait(7);
			captureMeasurementsPage.downloadCNXLog();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8111, groups = { }, dependsOnMethods = {"connectToT3000Test"})
	public void shareT3000LogTest()
	{
		try
		{
			captureMeasurementsPage.shareCNXLog(Config.SHARE_EMAIL_ADDRESS);
			int[] tapCordinates = GestureUtils.getTapCordinates(GestureUtils.ObjectName.DISCONNECT_DEVICE);
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				CommonUtils.wait(2);
				gestureUtils.clickOnCordinates(tapCordinates[0], tapCordinates[1]); 
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				ElementUtils.click(1, captureMeasurementsPage.getCaptureMeasurementsPageObject(CaptureMeasurementsPageObject.DISCONNECT_DEVICE));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8150, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX})
	public void connectToA3000Test() throws Exception
	{
		captureMeasurementsPage.connectToRealDevice(FCM.DeviceList.A3000.getAttributeValue());
	}
	
	@Test(priority = 8151, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX}, dependsOnMethods = {"connectToA3000Test"})
	public void captureA3000MeasurementTest()
	{
		try
		{
			captureMeasurementsPage.saveMeasurement();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8152, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX}, dependsOnMethods = {"connectToA3000Test"})
	public void assignAssetToA3000MeasurementTest()
	{
		try
		{
			measurementDetailPage.assignAssetCM(FCM.captureMeasurementAssetList[0], FCM.captureMeasurementAssetList[1], FCM.captureMeasurementAssetList[2]);
			Assert.assertTrue(measurementDetailPage.isAssetAssigned(FCM.captureMeasurementAssetList[2]));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8153, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX}, dependsOnMethods = {"connectToA3000Test"})
	public void assignWorkOrderToA3000MeasurementTest()
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
	
	@Test(priority = 8154, groups = {Config.CNX_CAPTURE_IOS, Config.CNX}, dependsOnMethods = {"connectToA3000Test"})
	public void addTextNoteToA3000MeasurementTest()
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
	
	@Test(priority = 8155, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX}, dependsOnMethods = {"connectToA3000Test"})
	public void A3000DeviceNameTest()
	{
		try
		{
			Assert.assertTrue(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.CAPTURED_MEASUREMENT_DEVICE_NAME).getText().startsWith(FCM.DeviceList.A3000.getAttributeValue()));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8156, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX}, dependsOnMethods = {"connectToA3000Test"})
	public void A3000MeasurementValueTest()
	{
		try
		{
			Assert.assertTrue(FloatValidator.getInstance().isInRange(Float.parseFloat(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.CAPTURED_MEASUREMENT_VALUE).getText()), -10.0, 10.0));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8157, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX}, dependsOnMethods = {"connectToA3000Test"})
	public void A3000MeasurementUnitTest()
	{
		try
		{
			measurementUnit.delete(0, measurementUnit.length());
			measurementUnit.append(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.CAPTURED_MEASUREMENT_UNIT).getText());
			Assert.assertTrue(measurementUnit.toString().contains(FCM.DeviceList.A3000_MEASUREMENT_UNIT.getAttributeValue()));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8158, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX}, dependsOnMethods = {"connectToA3000Test"})
	public void shareA3000MeasurementTest()
	{
		try
		{
			ElementUtils.click(5, measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.SHARE_BUTTON));
			measurementDetailPage.shareMeasurement(Config.SHARE_EMAIL_ADDRESS, FCM.DataType.MEASUREMENT_DATA, FCM.ShareFormat.CSV, false);
			CommonUtils.wait(2);
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				AndroidUtils.back();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8159, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX}, dependsOnMethods = {"connectToA3000Test"})
	public void saveA3000MeasurementTest()
	{
		try
		{
			measurementDetailPage.captureMeasurementsDetails(Config.getPropertiesFilePath(PropertiesFileType.MEASUREMENTS_PROPERTIES), FCM.DeviceList.A3000.getAttributeValue(), MeasurementType.SCALAR, 0);
			ElementUtils.click(1, captureMeasurementsPage.getCaptureMeasurementsPageObject(CaptureMeasurementsPageObject.SAVE_BUTTON));
		}
		catch(Throwable e)
		{
			Assert.fail();
		}
	}
	
	@Test(priority = 8160, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX}, dependsOnMethods = {"connectToA3000Test"})
	public void downloadA3000LogTest()
	{
		try
		{
			CommonUtils.wait(2);
			int[] tapCordinates = GestureUtils.getTapCordinates(GestureUtils.ObjectName.DOWNLOAD_LOG);
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				gestureUtils.clickOnCordinates(tapCordinates[0], tapCordinates[1]);
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				gestureUtils.clickOnCordinates(tapCordinates[0], tapCordinates[1]);
			captureMeasurementsPage.configureCNXLogging("1", "0", "1", "0");
			captureMeasurementsPage.clearCNXLog();
			captureMeasurementsPage.startCNXLogging();
			CommonUtils.wait(7);
			captureMeasurementsPage.downloadCNXLog();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8161, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX}, dependsOnMethods = {"connectToA3000Test"})
	public void shareA3000LogTest()
	{
		try
		{
			captureMeasurementsPage.shareCNXLog(Config.SHARE_EMAIL_ADDRESS);
			int[] tapCordinates = GestureUtils.getTapCordinates(GestureUtils.ObjectName.DISCONNECT_DEVICE);
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				CommonUtils.wait(2);
				gestureUtils.clickOnCordinates(tapCordinates[0], tapCordinates[1]);
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				ElementUtils.click(1, captureMeasurementsPage.getCaptureMeasurementsPageObject(CaptureMeasurementsPageObject.DISCONNECT_DEVICE));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8450, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX})
	public void connectTo369FCTest() throws Exception
	{
		captureMeasurementsPage.connectToRealDevice(FCM.DeviceList.FC369.getAttributeValue());
	}
	
	@Test(priority = 8451, groups = { Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX}, dependsOnMethods = {"connectTo369FCTest"})
	public void capture369FCMeasurementTest()
	{
		try
		{
			captureMeasurementsPage.saveMeasurement();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8452, groups = { Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX}, dependsOnMethods = {"connectTo369FCTest"})
	public void assignAssetTo369FCMeasurementTest()
	{
		try
		{	
			measurementDetailPage.assignAssetCM(FCM.captureMeasurementAssetList[0], FCM.captureMeasurementAssetList[1], FCM.captureMeasurementAssetList[2]);
			Assert.assertTrue(measurementDetailPage.isAssetAssigned(FCM.captureMeasurementAssetList[2]));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 8453, groups = { Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX}, dependsOnMethods = {"connectTo369FCTest"})
	public void assignWorkOrderTo369FCMeasurementTest()
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
	
	@Test(priority = 8454, groups = { Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX}, dependsOnMethods = {"connectTo369FCTest"})
	public void addTextNoteTo369FCMeasurementTest()
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			measurementDetailPage.addTextNote(Config.measurementTextNoteText);
			Assert.assertTrue(measurementDetailPage.isTextNoteAdded(Config.measurementTextNoteText));
		}
	}
	
	@Test(priority = 8455, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX}, dependsOnMethods = {"connectTo369FCTest"})
	public void FC369DeviceNameTest()
	{
		Assert.assertTrue(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.CAPTURED_MEASUREMENT_DEVICE_NAME).getText().equals(FCM.DeviceList.FC369.getAttributeValue()));
	}
	
	@Test(priority = 8456, groups = { Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX}, dependsOnMethods = {"connectTo369FCTest"})
	public void FC369MeasurementValueTest()
	{
		Assert.assertTrue(FloatValidator.getInstance().isInRange(Float.parseFloat(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.CAPTURED_MEASUREMENT_VALUE).getText()), -10.0, 10.0));
	}
	
	@Test(priority = 8457, groups = { Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX}, dependsOnMethods = {"connectTo369FCTest"})
	public void FC369MeasurementUnitTest()
	{
		measurementUnit.delete(0, measurementUnit.length());
		measurementUnit.append(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.CAPTURED_MEASUREMENT_UNIT).getText());
		Assert.assertTrue(measurementUnit.toString().contains(FCM.DeviceList.FC369_MEASUREMENT_UNIT.getAttributeValue()));
	}
	
	@Test(priority = 8458, groups = { Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX}, dependsOnMethods = {"connectTo369FCTest"})
	public void shareFC369MeasurementTest() throws Exception
	{
		ElementUtils.click(5, measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.SHARE_BUTTON));
		measurementDetailPage.shareMeasurement(Config.SHARE_EMAIL_ADDRESS, FCM.DataType.MEASUREMENT_DATA, FCM.ShareFormat.CSV, false);
		CommonUtils.wait(2);
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			AndroidUtils.back();
	}
	
	@Test(priority = 8459, groups = { Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX}, dependsOnMethods = {"connectTo369FCTest"})
	public void save369FCMeasurementTest() throws Exception
	{
		measurementDetailPage.captureMeasurementsDetails(Config.getPropertiesFilePath(PropertiesFileType.MEASUREMENTS_PROPERTIES), FCM.DeviceList.FC369.getAttributeValue(), MeasurementType.SCALAR, 0);
		ElementUtils.click(1, captureMeasurementsPage.getCaptureMeasurementsPageObject(CaptureMeasurementsPageObject.SAVE_BUTTON));
	}
	
	@Test(priority = 8460, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX}, dependsOnMethods = {"connectTo369FCTest"})
	public void downloadFC369LogTest()
	{
		try
		{
			CommonUtils.wait(3);
			int[] tapCordinates = GestureUtils.getTapCordinates(GestureUtils.ObjectName.DOWNLOAD_LOG);
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				gestureUtils.clickOnCordinates(tapCordinates[0], tapCordinates[1]);
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				gestureUtils.clickOnCordinates(tapCordinates[0], tapCordinates[1]); 
			captureMeasurementsPage.configureCNXLogging("1", "0", "1", "0");
			captureMeasurementsPage.clearCNXLog();
			captureMeasurementsPage.startCNXLogging();
			CommonUtils.wait(5);
			captureMeasurementsPage.downloadCNXLog();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
			
		}
	}
	
	@Test(priority = 8461, groups = {Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX}, dependsOnMethods = {"connectTo369FCTest"})
	public void shareFC369LogTest()
	{
		try
		{
			captureMeasurementsPage.shareCNXLog(Config.SHARE_EMAIL_ADDRESS);
			int[] tapCordinates = GestureUtils.getTapCordinates(GestureUtils.ObjectName.DISCONNECT_DEVICE);
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				CommonUtils.wait(2);
				gestureUtils.clickOnCordinates(tapCordinates[0], tapCordinates[1]);
			}
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				ElementUtils.click(1, captureMeasurementsPage.getCaptureMeasurementsPageObject(CaptureMeasurementsPageObject.DISCONNECT_DEVICE));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	

	// ******************************************  CNX Test Suite Ends Here *********************************

	//**********************************Bug automation*************************************************************//
	
	//FCM1587-656 
		@Test(priority = 8450, groups = {})
	public void connectTo376FCTest() throws Exception
	{ 
			captureMeasurementsPage.connectToRealDevice(FCM.DeviceList.FC376.getAttributeValue());
		}
		
		//FCM1587-656		
		@Test(priority = 8450, groups = {}, dependsOnMethods = {"connectTo376FCTest"})
		public void download376FC() throws Exception
		{ 
			CommonUtils.wait(4);
			int[] tapCordinates = GestureUtils.getTapCordinates(GestureUtils.ObjectName.DOWNLOAD_LOG);
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{    CommonUtils.wait(10);
				gestureUtils.clickOnCordinates(tapCordinates[0], tapCordinates[1]);
				CommonUtils.wait(10);
		     captureMeasurementsPage.download376FCLog();
		    
		     CommonUtils.wait(5);
		     captureMeasurementsPage .fc376Scroll();
		     int[] tapCordinates1 = GestureUtils.getTapCordinates(GestureUtils.ObjectName.DISCONNECT_DEVICE);
				gestureUtils.clickOnCordinates(tapCordinates1[0], tapCordinates1[1]);
		}
			
		}
		//FCM1587-594
		@Test(priority = 8450, groups = {})
		public void connectTo1587FC() throws Exception
		{ try
			{ 	if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			
			
			captureMeasurementsPage.connectToRealDevice(FCM.captureMeasurementSimulatedDeviceNameList.put("Beaker", "1587FC"));
		
			}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		}
			
		
		@Test(priority = 8450, groups = {})
		public void captureTo1587FC() throws Exception
		{ try
			{
			
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			
			captureMeasurementsPage.saveAndDisconnectDevice(1);
			}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		}
		
		
		
		
		
		//FCM1587-924
		
		
		@Test(priority = 8450, groups = {"connect1587",})
		public void connectAndDownloadTo1664FC() throws Exception
		
		{   // clear the data from the tool and connect 
			try {
				if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				{
			captureMeasurementsPage.connectToRealDevice(FCM.captureMeasurementSimulatedDeviceNameList.put("Hudson", "1664FC"));
			captureMeasurementsPage.download1664FC("Download");
			captureMeasurementsPage.doneAndDisconnectDevice(1);
				}
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
			}
			
			
		}
		//FCM1587-669	
		
		@Test(priority = 8450, groups = {})
		public void verifyMeasurementTo279Fc() throws Exception
		
		{  	
          try
        {
        	  if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
        	  {

			captureMeasurementsPage.connectToRealDevice(FCM.DeviceList.Fc279FC.getAttributeValue());		
		     captureMeasurementsPage.museMeasurementtest(switcher);		  
        	  }
        	  }
           catch(Throwable e)
         {
        	 e.printStackTrace();
	         Assert.fail("Exception Detail: "+e);
         }
			
		}

		//FCM1587-897
		@Test(priority = 8450, groups = {},dependsOnMethods = {"connectTo1587FC"})
		public void unitTest1587FC() throws Exception
		{ 
			try {
				if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				{
			captureMeasurementsPage.saveBeakerMeasurement(false,"0.00",null);
			ElementUtils.click(1,measurementDetailPage .getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.ANDROID_ASSET_POPUP_CLOSE_BUTTON));
			measurementUnit.delete(0, measurementUnit.length());
		     Assert.assertEquals(measurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.CAPTURED_BEAKER_MEASUREMENT_UNIT).getText(),"Hz mVAC");
	       captureMeasurementsPage.doneAndDisconnectDevice(1); 
			}
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
			}//measurementDetailPage.captureMeasurementsDetails(Config.getPropertiesFilePath(PropertiesFileType.MEASUREMENTS_PROPERTIES), "1587FC", MeasurementType.SCALAR, 0);
		}
	
		//FCM1587-548&&FCM1587-540
		
		@Test(priority = 8450, groups = {})
		public void museDownload() throws Exception
		{ 
			
			try {
				int[] tapCordinates = GestureUtils.getTapCordinates(GestureUtils.ObjectName.DOWNLOAD);
				captureMeasurementsPage.connectToRealDevice(FCM.DeviceList.FC279IR.getAttributeValue());
				CommonUtils.wait(10);
				gestureUtils.clickOnCordinates(tapCordinates[0], tapCordinates[1]);
				CommonUtils.wait(5);
				captureMeasurementsPage.museDownload(switcher);
				//switcher.switchToHomePage();
				switcher.switchToCaptureMeasurementsPage();
				int[] tapCordinates1 = GestureUtils.getTapCordinates(GestureUtils.ObjectName.DISCONNECT_DEVICE);
				gestureUtils.clickOnCordinates(tapCordinates1[0], tapCordinates1[1]);
			     //ElementUtils.click(1, captureMeasurementsPage.getCaptureMeasurementsPageObject(CaptureMeasurementsPageObject.DISCONNECT_DEVICE));
			
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
			}//measurementDetailPage.captureMeasurementsDetails(Config.getPropertiesFilePath(PropertiesFileType.MEASUREMENTS_PROPERTIES), "1587FC", MeasurementType.SCALAR, 0);
		}	
		//FCM-539
		@Test(priority = 8450, groups = {"cnx_capture_ios_tests376"})
		public void museDeleteGroupedFunction() throws Exception
		{ 
			
			try {
				int[] tapCordinates = GestureUtils.getTapCordinates(GestureUtils.ObjectName.DOWNLOAD);
				captureMeasurementsPage.connectToRealDevice(FCM.DeviceList.FC279IR.getAttributeValue());
				CommonUtils.wait(10);
				gestureUtils.clickOnCordinates(tapCordinates[0], tapCordinates[1]);
				CommonUtils.wait(5);
				captureMeasurementsPage.museOperations("Delete Download Measurement");
				CommonUtils.wait(5);
				int[] tapCordinates1 = GestureUtils.getTapCordinates(GestureUtils.ObjectName.DISCONNECT_DEVICE);
				gestureUtils.clickOnCordinates(tapCordinates1[0], tapCordinates1[1]);
				//Add the Validation for the Delete Operation Successful - Check the Number of Measurements before deletion and After Deletion and Compare.
			     //ElementUtils.click(1, captureMeasurementsPage.getCaptureMeasurementsPageObject(CaptureMeasurementsPageObject.DISCONNECT_DEVICE));
			
			}
			catch(Throwable e)
			{
				Assert.fail("Exception Detail: "+e);
			}//measurementDetailPage.captureMeasurementsDetails(Config.getPropertiesFilePath(PropertiesFileType.MEASUREMENTS_PROPERTIES), "1587FC", MeasurementType.SCALAR, 0);
		}		
		
	//***********************************************************************************//
	
	
	@AfterClass(groups = {Config.TI_FCM_CAPTURE_ANDROID, Config.TI_FCM, Config.IOS_SMOKE_TESTS, 
			Config.FC_805_TESTS, Config.IOS_FULL_TESTS, Config.WEB_SMOKE_CM_TESTS,
			Config.CNX_CAPTURE_ANDROID, Config.CNX_CAPTURE_IOS, Config.CNX_CAPTURE_ANDROID_1, Config.CNX_CAPTURE_IOS_1, Config.CNX,
			Config.CAPTURE_MEASUREMENT_RELIABILTY_TESTS, Config.ANDROID_SMOKE_TESTS,"cnx_capture_ios_tests376"})
	public void classTearDown() throws Exception
	{
		Config.useExistingPageSource = false;
		//captureMeasurementsPage.clickBackButton();
	    if(!DriverManager.isSmokeSuite()) { 
			DriverManager.closeApp();
			DriverManager.launchApp();
			DriverManager.getSignIn().handleOnBoardPrompt();
			switcher.signOut();
		}
	    else
    			serviceHatchPage.toggleFeature("SIMULATED DEVICES", null, false, serviceHatchPage.getElement(ServiceHatchPage.SIMULATED_DEVICES_BUTTON), true);
	}
}
