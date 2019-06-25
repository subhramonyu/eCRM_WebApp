package com.fluke.connect.app.functional.client.tests;

import java.text.ParseException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.apache.commons.validator.routines.FloatValidator;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.fluke.connect.app.functional.client.pages.MeasurementDetailPage;
import com.fluke.connect.app.functional.client.pages.MeasurementsHistoryPage;
import com.fluke.connect.app.functional.client.pages.Switcher;
import com.fluke.connect.app.functional.client.pages.MeasurementDetailPage.MeasturementAttributes;
import com.fluke.connect.app.functional.client.pages.MeasurementDetailPage.MeasurementDetailPageObjects;
import com.fluke.connect.app.functional.client.pages.MeasurementsHistoryPage.MeasurementHistoryPageObjects;
import com.fluke.connect.app.testdata.FCM;
import com.fluke.connect.app.testdata.SignIn;
import com.fluke.connect.app.testdata.FCM.DeviceList;
import com.fluke.connect.app.testdata.FCM.SearchSortFilterAttributes;
import com.fluke.connect.app.testdata.SignIn.FeatureList;
import com.fluke.connect.app.testdata.Team;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DateAndTimeUtils;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.FileUtil;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.IOSUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.PropertiesFileType;
import com.fluke.connect.app.utils.Config.ScrollDiection;

@SuppressWarnings("unused")
public class MeasurementsHistoryPageTests 
{
	private MeasurementsHistoryPage mMeasurementHistoryPage;
	private Switcher mSwitcher;
	private MeasurementDetailPage mMeasurementDetailPage;
	private WebElement mMeasurementCell;
	private WebElement mWebTIMeasurementCell;
	private WebElement mWebCNXMeasurementCell;
	private List<WebElement> mWebAssignedAssetWorkOrderList;
	private WebElement mWebAssignedAssetLabel;
	private WebElement mWebAssignedWorkOrderLabel;
	private StringBuilder mMeasurementUnit;
	private StringBuilder mMeasurementValue;
	private StringBuilder mCurrentMeasurementDate;
	private StringBuilder mNextMeasurementDate; 
	private StringBuilder mMeasurementLabel; 
	private GestureUtils mGestureUtils;
	private List<WebElement> mMeasurementCaptureDate;
	private List<String> mMeasurementCaptureDateASC;
	private List<String> mMeasurementCaptureDateDESC;
	
	
	@BeforeClass(groups = {Config.IOS_FULL_TESTS, Config.IOS_SMOKE_TESTS, Config.FC_805_TESTS,
						Config.EEVEE_MEASUREMENT_ANDROID_TESTS, Config.EEVEE_MEASUREMENT_IOS_TESTS,
						Config.TI_FCM_ANDROID, Config.TI_FCM_WEB, Config.TI_FCM_IOS, Config.TEAM_TESTS,
						Config.CNX, Config.CNX_IOS, Config.CNX_WEB, Config.CNX_ANDROID,"musetest", Config.TEAM_TESTS_WEB})
	public void initClass() throws Exception
	{
		if(!DriverManager.isSmokeSuite()) {
			DriverManager.getSignIn().signIn(SignIn.getUID(FeatureList.FCM_CNX), SignIn.getPWD(FeatureList.FCM_CNX));
	        DriverManager.getSignIn().handleAfterSignInAlertsOtherUser();
		}
		mMeasurementHistoryPage = new MeasurementsHistoryPage();
		mSwitcher = new Switcher();
		mSwitcher.switchToMeasurementsPage();
		mMeasurementDetailPage = new MeasurementDetailPage();
		mMeasurementCell = null;
		mWebTIMeasurementCell = null;
		mWebCNXMeasurementCell = null;
		mWebAssignedAssetLabel = null;
		mWebAssignedWorkOrderLabel = null;
		mWebAssignedAssetWorkOrderList = null;
		mMeasurementUnit = new StringBuilder();
		mMeasurementValue = new StringBuilder();
		mCurrentMeasurementDate = new StringBuilder();
		mNextMeasurementDate = new StringBuilder();
		mMeasurementLabel = new StringBuilder();
		mGestureUtils = new GestureUtils();
		CommonUtils.wait(5, 15, 1); //wait for page load
		IOSUtils.isPageLoadedWithSetSource(15, "Data...");
	}
	
	@Test(priority = 147301, groups = {Config.IOS_FULL_TESTS, Config.IOS_SMOKE_TESTS})
	public void onExistingAccountSampleDataTest()
	{
		try 
		{
			if(mMeasurementHistoryPage.getMeasurementsCount() < 0)
			{
				throw new Exception("Sample Data Missing Error");
			}
		}
		catch(Exception e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 92302, groups = {})
	public void deleteWorkOrderMeasurementTest()
	{
		try 
		{
			mMeasurementHistoryPage.deleteSingleMeasurement("Work Order Manual Entry", Config.WORKORDERS_PROPERTIES_FILE_PATH);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 92303, groups = {Config.IOS_FULL_TESTS, })
	public void isHudsonMeasurementsValueSavedCorrectlyTest()
	{
		try 
		{
			mMeasurementHistoryPage.reliableClickOnMeasurementName(FCM.captureMeasurementSimulatedDeviceNameList.get("V3002"), Config.getPropertiesFilePath(PropertiesFileType.MEASUREMENTS_PROPERTIES));
			Assert.assertTrue(mMeasurementHistoryPage.isNonScalarMeasurementValuesCorrect(FCM.captureMeasurementSimulatedDeviceNameList.get("Hudson")));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 92304, groups = {Config.IOS_FULL_TESTS, })
	public void isHudsonMeasurementsUnitsSavedCorrectlyTest()
	{
		try 
		{
			Assert.assertTrue(mMeasurementHistoryPage.isNonScalarMeasurementUnitsCorrect(FCM.captureMeasurementSimulatedDeviceNameList.get("Hudson")));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 92305, groups = {Config.IOS_FULL_TESTS, })
	public void assignAssetToHudsonTest()
	{
		try 
		{
			mMeasurementDetailPage.assignAsset(Config.measurementHistoryAssetList[0], Config.measurementHistoryAssetList[1], Config.measurementHistoryAssetList[2]);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 92306, groups = {Config.IOS_FULL_TESTS, })
	public void isAssetAssignedToHudsonTest()
	{
		try 
		{
			Assert.assertTrue(mMeasurementDetailPage.isAssetAssigned(Config.measurementHistoryAssetList[2]));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 92307, groups = {Config.IOS_FULL_TESTS, })
	public void assignedWorkOrderToHudsonTest()
	{
		try 
		{
			mMeasurementDetailPage.assignWorkOrder(Config.measurementWorkOrderToBeAssignedTitle);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 92308, groups = {Config.IOS_FULL_TESTS, })
	public void isWorkOrderAssignedToHudsonTest()
	{
		try 
		{
			Assert.assertTrue(mMeasurementDetailPage.isWorkOrderAssigned(Config.measurementAssignedWorkOrderNumber));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 92309, groups = {Config.IOS_FULL_TESTS, })
	public void addTextNoteToHudsonTest()
	{
		try 
		{
			mMeasurementDetailPage.addTextNote(Config.measurementTextNoteText);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 92310, groups = {Config.IOS_FULL_TESTS, })
	public void istextNoteAdedToHudsonTest()
	{
		try 
		{
			Assert.assertTrue(mMeasurementDetailPage.isTextNoteAdded(Config.measurementTextNoteText));
			mMeasurementHistoryPage.clickOnDoneButton();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
			mMeasurementHistoryPage.clickOnDoneButton();
		}
	}

	@Test(alwaysRun = true, priority = 147302, groups = {Config.IOS_FULL_TESTS, Config.IOS_SMOKE_TESTS})
	public void deleteMultipleMeasurementsTest()
	{
		try 
		{
			mMeasurementHistoryPage.deleteMultipleMeasurements(3);
			CommonUtils.wait(30);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	//******************************* TI FCM Test Suite starts Here *****************************
	
	public void setScrollDirection(String currentDeviceName, String nextDeviceName, int currentDateMeasurementIndex,int nextDateMeasurementIndex) throws ParseException
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			mCurrentMeasurementDate.delete(0, mCurrentMeasurementDate.length());
			mNextMeasurementDate.delete(0, mNextMeasurementDate.length());
			if(currentDateMeasurementIndex < 0)
				mCurrentMeasurementDate.append(FileUtil.readProperty(Config.getPropertiesFilePath(PropertiesFileType.MEASUREMENTS_PROPERTIES), currentDeviceName + mMeasurementDetailPage.getMeasurementDetailPageObject(MeasurementDetailPageObjects.DATE_SUFFIX)));
			else
				mCurrentMeasurementDate.append(FileUtil.readProperty(Config.getPropertiesFilePath(PropertiesFileType.MEASUREMENTS_PROPERTIES), currentDeviceName + mMeasurementDetailPage.getMeasurementDetailPageObject(MeasurementDetailPageObjects.DATE_SUFFIX) + " " +String.valueOf(currentDateMeasurementIndex)));
			if(nextDateMeasurementIndex < 0)
				mNextMeasurementDate.append(FileUtil.readProperty(Config.getPropertiesFilePath(PropertiesFileType.MEASUREMENTS_PROPERTIES), nextDeviceName + mMeasurementDetailPage.getMeasurementDetailPageObject(MeasurementDetailPageObjects.DATE_SUFFIX)));
			else
				mNextMeasurementDate.append(FileUtil.readProperty(Config.getPropertiesFilePath(PropertiesFileType.MEASUREMENTS_PROPERTIES), nextDeviceName + mMeasurementDetailPage.getMeasurementDetailPageObject(MeasurementDetailPageObjects.DATE_SUFFIX) + " " +String.valueOf(nextDateMeasurementIndex)));
			if(DateAndTimeUtils.isAfter(getDateFormat(), mCurrentMeasurementDate.toString(), mNextMeasurementDate.toString()))
				mMeasurementHistoryPage.setScrollDirection(ScrollDiection.DOWN);
			else
			{
				if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
					mMeasurementHistoryPage.setScrollDirection(ScrollDiection.UP);
				else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				{
					mGestureUtils.mScroll(1000, 1000, 3);
					mGestureUtils.mScroll("Date", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.UP);	
					mMeasurementHistoryPage.setScrollDirection(ScrollDiection.DOWN);
				}
			}
		}
	}
	
	public String getDateFormat()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			return FCM.getDateFormat(Config.ANDROID_DRIVER);
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			return FCM.getDateFormat(Config.IOS_DRIVER);
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			return FCM.getDateFormat(Config.WEB_DRIVER);
		return null;
	}
	
	public void deviceNameTestLogic(String deviceName, MeasurementDetailPageObjects deploymentName) throws ParseException
	{
		mMeasurementCell = null;
		mWebTIMeasurementCell = null;
		mMeasurementCell = mMeasurementHistoryPage.getMeasurementCell(true, Config.getPropertiesFilePath(PropertiesFileType.MEASUREMENTS_PROPERTIES), deviceName, null, null, -1, deploymentName, false);
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			mWebTIMeasurementCell = ElementUtils.getElement(mMeasurementCell, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".measDetailImg");
		Assert.assertTrue(ElementUtils.getElement(mMeasurementCell, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, MeasturementAttributes.ANDROID_DEVICE_NAME.getAttributeValue(), LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, MeasturementAttributes.IOS_DEVICE_NAME.getAttributeValue(), LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, MeasturementAttributes.WEB_DEVICE_NAME.getAttributeValue()).getText().equals(FileUtil.readProperty(Config.getPropertiesFilePath(PropertiesFileType.MEASUREMENTS_PROPERTIES), deviceName)));
	}
	
	public void deviceNameTestLogic(String deviceName, int measurementIndex, MeasurementDetailPageObjects deploymentName) throws ParseException
	{
		mMeasurementCell = null;
		mWebTIMeasurementCell = null;
		mMeasurementCell = mMeasurementHistoryPage.getMeasurementCell(true, Config.getPropertiesFilePath(PropertiesFileType.MEASUREMENTS_PROPERTIES), deviceName, null, null, measurementIndex, deploymentName, false);
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			mWebTIMeasurementCell = ElementUtils.getElement(mMeasurementCell, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, ".measDetailImg");
		Assert.assertTrue(ElementUtils.getElement(mMeasurementCell, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, MeasturementAttributes.ANDROID_DEVICE_NAME.getAttributeValue(), LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, MeasturementAttributes.IOS_DEVICE_NAME.getAttributeValue(), LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, MeasturementAttributes.WEB_DEVICE_NAME.getAttributeValue()).getText().equals(FileUtil.readProperty(Config.getPropertiesFilePath(PropertiesFileType.MEASUREMENTS_PROPERTIES), deviceName + " " +String.valueOf(measurementIndex))));
	}
	
	public void measurementDetailPageDeviceNameTestLogic(String deviceName)
	{
		Assert.assertTrue(mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MEASUREMENT_DEVICE_NAME).getText().equals(deviceName));
	}
	
	public void measurementValueTestLogic()
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertTrue(FloatValidator.getInstance().isInRange(Float.parseFloat(ElementUtils.getElement(mMeasurementCell, null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, MeasturementAttributes.IOS_VALUE_LABEL.getAttributeValue(), LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, MeasturementAttributes.WEB_VALUE.getAttributeValue()).getText()), 15.0, 45.0));
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			mMeasurementValue.delete(0, mMeasurementValue.length());
			mMeasurementValue.append(ElementUtils.getElement(mMeasurementCell, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, MeasturementAttributes.WEB_VALUE.getAttributeValue()).getText());
			Assert.assertTrue(FloatValidator.getInstance().isInRange(Float.parseFloat(mMeasurementValue.substring(0, mMeasurementValue.indexOf(" "))), 5.0, 145.0));
		}
	}
	
	public void measurementDetailPageMeasurementValueTest()
	{
		mMeasurementValue.delete(0, mMeasurementValue.length());
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertTrue(FloatValidator.getInstance().isInRange(Float.parseFloat(mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MEASUREMENT_VALUE).getText()), 15.0, 100.0));
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			mMeasurementValue.append(mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MEASUREMENT_VALUE).getText());
			Assert.assertTrue(FloatValidator.getInstance().isInRange(Float.parseFloat(mMeasurementValue.substring(0, mMeasurementValue.indexOf(" "))), 15.0, 140.0));
		}
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			mMeasurementValue.append(mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MEASUREMENT_VALUE).getText());
			Assert.assertTrue(FloatValidator.getInstance().isInRange(Float.parseFloat(mMeasurementValue.substring(0, mMeasurementValue.indexOf(" "))), 5.0, 145.0));
		}
	}

	public void measurementUnitTestLogic()
	{
		mMeasurementUnit.delete(0, mMeasurementUnit.length());
		mMeasurementUnit.append(ElementUtils.getElement(mMeasurementCell, null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, MeasturementAttributes.IOS_UNIT_LABEL.getAttributeValue(), LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, MeasturementAttributes.WEB_VALUE_UNIT.getAttributeValue()).getText());
		Assert.assertTrue(mMeasurementUnit.toString().contains("C") || mMeasurementUnit.toString().contains("F"));
	}
	
	public void measurementDetailPageMeasurementUniTest()
	{
		mMeasurementUnit.delete(0, mMeasurementUnit.length());
		mMeasurementUnit.append(mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MEASUREMENT_UNIT).getText());
		Assert.assertTrue(mMeasurementUnit.toString().contains("C") || mMeasurementUnit.toString().contains("F"));
	}
	
	public void maxTempValueTestLogic()
	{
		mMeasurementValue.delete(0, mMeasurementValue.length());  
		mMeasurementValue.append(ElementUtils.getElement(mMeasurementCell, null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, MeasturementAttributes.IOS_MAX_MIN_VALUE.getAttributeValue(), LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, MeasturementAttributes.WEB_MAX_VALUE.getAttributeValue()).getText());
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertTrue(FloatValidator.getInstance().isInRange(Float.parseFloat(mMeasurementValue.substring(mMeasurementValue.indexOf(":") + 2, mMeasurementValue.lastIndexOf("M") - 4)), 15.0, 100.0));
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(FloatValidator.getInstance().isInRange(Float.parseFloat(mMeasurementValue.toString()), 15.0, 100.0));
	}
	
	public void measurementDetailPageMaxTempValueTestLogic()
	{
		mMeasurementValue.delete(0, mMeasurementValue.length());  
		mMeasurementValue.append(mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MAX_TEMP).getText());
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertTrue(FloatValidator.getInstance().isInRange(Float.parseFloat(mMeasurementValue.substring(mMeasurementValue.indexOf(":") + 2, mMeasurementValue.lastIndexOf("M") - 4)), 15.0, 100.0));
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			Assert.assertTrue(FloatValidator.getInstance().isInRange(Float.parseFloat(mMeasurementValue.substring(mMeasurementValue.indexOf(":") + 2, mMeasurementValue.lastIndexOf(" "))), 15.0, 100.0));
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(FloatValidator.getInstance().isInRange(Float.parseFloat(mMeasurementValue.toString()), 15.0, 100.0));
	}
	
	public void maxTempUnitTestLogic()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertTrue(mMeasurementValue.toString().contains("C") || mMeasurementValue.toString().contains("F"));
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			mMeasurementUnit.delete(0, mMeasurementUnit.length());
			mMeasurementUnit.append(mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.WEB_MAX_UNIT).getText());
			Assert.assertTrue(mMeasurementUnit.toString().contains("C") || mMeasurementUnit.toString().contains("F"));
		}
	}
	
	public void minTempUnitTestLogic()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertTrue(mMeasurementValue.toString().contains("C") || mMeasurementValue.toString().contains("F"));
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			mMeasurementUnit.delete(0, mMeasurementUnit.length());
			mMeasurementUnit.append(mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.WEB_MIN_UNIT).getText());
			Assert.assertTrue(mMeasurementUnit.toString().contains("C") || mMeasurementUnit.toString().contains("F"));
		}
	}
	
	public void maxMinLabelTestLogic()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertTrue(mMeasurementValue.toString().contains("Max") || mMeasurementValue.toString().contains("Min"));
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			mMeasurementLabel.delete(0, mMeasurementLabel.length());
			mMeasurementLabel.append(mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.WEB_MAX_MIN_LABEL).getText());
			Assert.assertTrue(mMeasurementLabel.toString().contains("Max") || mMeasurementLabel.toString().contains("Min"));
		}
	}
	
	public void minTempValueTestLogic()
	{
		mMeasurementValue.delete(0, mMeasurementValue.length());  
		mMeasurementValue.append(ElementUtils.getElement(mMeasurementCell, null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, MeasturementAttributes.IOS_MAX_MIN_VALUE.getAttributeValue(), LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, MeasturementAttributes.WEB_MIN_VALUE.getAttributeValue()).getText());
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertTrue(FloatValidator.getInstance().isInRange(Float.parseFloat(mMeasurementValue.substring(mMeasurementValue.lastIndexOf(":") + 2, mMeasurementValue.lastIndexOf(" "))), 15.0, 100.0));
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(FloatValidator.getInstance().isInRange(Float.parseFloat(mMeasurementValue.toString()), 15.0, 100.0));
	}
	
	public void measurementDetailPageMinTempValueTestLogic()
	{
		mMeasurementValue.delete(0, mMeasurementValue.length());  
		mMeasurementValue.append(mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MIN_TEMP).getText());
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			Assert.assertTrue(FloatValidator.getInstance().isInRange(Float.parseFloat(mMeasurementValue.substring(mMeasurementValue.lastIndexOf(":") + 2, mMeasurementValue.lastIndexOf(" "))), 15.0, 100.0));
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			Assert.assertTrue(FloatValidator.getInstance().isInRange(Float.parseFloat(mMeasurementValue.substring(mMeasurementValue.indexOf(": ") + 2, mMeasurementValue.lastIndexOf(" "))), 15.0, 100.0));
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			Assert.assertTrue(FloatValidator.getInstance().isInRange(Float.parseFloat(mMeasurementValue.toString()), 15.0, 100.0));
	}
	
	//************************************************* TI Tests *********************************************************************************************

	@Test(priority = 98000, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI450MeasurementDeviceNameTest()
	{
		try 
		{
			deviceNameTestLogic(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.TI_450.getAttributeValue(), null);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98001, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI450MeasurementValueTest()
	{
		try 
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				measurementValueTestLogic();
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				mMeasurementCell.click();
				ElementUtils.click(3, mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.ANDROID_ASSET_POPUP_CLOSE_BUTTON));
				ElementUtils.isDisplayed(3, mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MAX_TEMP));
				measurementDetailPageMeasurementValueTest();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98002, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI450MeasurementUnitTest()
	{
		try 
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				measurementUnitTestLogic();
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				measurementDetailPageMeasurementUniTest();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98003, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI450MaxTempValueTest()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				maxTempValueTestLogic();
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				measurementDetailPageMaxTempValueTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98004, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI450MaxTempUnitTest()
	{
		try
		{
			maxTempUnitTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98005, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI450MaxTempLabelTest()
	{
		try
		{
			maxMinLabelTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98006, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI450MinTempValueTest()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				minTempValueTestLogic();
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				measurementDetailPageMinTempValueTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98007, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI450MinTempUnitTest()
	{
		try
		{
			maxTempUnitTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98008, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI450MinTempLabelTest() throws ParseException
	{
		try
		{
			maxMinLabelTestLogic();
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.BACK_BUTTON).click();
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.TI_450.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.TI_400.getAttributeValue(), -1, -1);
		}
		catch(Throwable e)
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.BACK_BUTTON).click();
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.TI_450.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.TI_400.getAttributeValue(), -1, -1);
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98050, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI400MeasurementDeviceNameTest()
	{
		try 
		{
			deviceNameTestLogic(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.TI_400.getAttributeValue(), null);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98051, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI400MeasurementValueTest()
	{
		try 
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				measurementValueTestLogic();
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				mMeasurementCell.click();
				ElementUtils.isDisplayed(3, mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MAX_TEMP));
				measurementDetailPageMeasurementValueTest();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98052, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI400MeasurementUnitTest()
	{
		try 
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				measurementUnitTestLogic();
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				measurementDetailPageMeasurementUniTest();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98053, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI400MaxTempValueTest()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				maxTempValueTestLogic();
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				measurementDetailPageMaxTempValueTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98054, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI400MaxTempUnitTest()
	{
		try
		{
			maxTempUnitTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98055, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI400MaxTempLabelTest()
	{
		try
		{
			maxMinLabelTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98056, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI400MinTempValueTest()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				minTempValueTestLogic();
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				measurementDetailPageMinTempValueTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98057, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI400MinTempUnitTest()
	{
		try
		{
			minTempUnitTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98058, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI400MinTempLabelTest() throws ParseException
	{
		try
		{
			maxMinLabelTestLogic();
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.BACK_BUTTON).click();
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.TI_400.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.TI_450.getAttributeValue(), -1, -1);
		}
		catch(Throwable e)
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.BACK_BUTTON).click();
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.TI_400.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.TI_450.getAttributeValue(), -1, -1);
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98100, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TI450MeasurementDeviceNameSyncTest()
	{
		try 
		{
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				if(!DriverManager.isSmokeSuite()) {
					DriverManager.getSignIn().signIn(SignIn.getUID(FeatureList.FCM_TI), SignIn.getPWD(FeatureList.FCM_TI));
			        DriverManager.getSignIn().handleAfterSignInAlertsOtherUser();
				}
				CommonUtils.wait(5);
				mGestureUtils.webScroll(ScrollDiection.DOWN, 7);
				deviceNameTestLogic(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.WEB_SYNC_IOS_DEPLOYMENT) + FCM.DeviceList.TI_450.getAttributeValue(), MeasurementDetailPageObjects.WEB_SYNC_IOS_DEPLOYMENT);
			}
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				deviceNameTestLogic(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.TI_450.getAttributeValue(), MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98101, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TI450MeasurementValueSyncTest()
	{
		try 
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				measurementValueTestLogic();
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				mMeasurementCell.click();
				ElementUtils.isDisplayed(3, mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MAX_TEMP));
				measurementDetailPageMeasurementValueTest();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98102, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TI450MeasurementUnitSyncTest()
	{
		try 
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				measurementUnitTestLogic();
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				measurementDetailPageMeasurementUniTest();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98103, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TI450MaxTempValueSyncTest()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				maxTempValueTestLogic();
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				measurementDetailPageMaxTempValueTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98104, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TI450MaxTempUnitSyncTest()
	{
		try
		{
			maxTempUnitTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98105, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TI450MaxTempLabelSyncTest()
	{
		try
		{
			maxMinLabelTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98106, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TI450MinTempValueSyncTest()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				minTempValueTestLogic();
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				measurementDetailPageMinTempValueTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98107, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TI450MinTempUnitSyncTest()
	{
		try
		{
			minTempUnitTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98108, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TI450MinTempLabelSyncTest() throws ParseException
	{
		try
		{
			maxMinLabelTestLogic();
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.BACK_BUTTON).click();
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.TI_450.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.TI_400.getAttributeValue(), -1, -1);			
		}
		catch(Throwable e)
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.BACK_BUTTON).click();
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.TI_450.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.TI_400.getAttributeValue(), -1, -1);			
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98150, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI400MeasurementDeviceNameSyncTest()
	{
		try 
		{
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				deviceNameTestLogic(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.WEB_SYNC_ANDROID_DEPLOYMENT) + FCM.DeviceList.TI_400.getAttributeValue(), MeasurementDetailPageObjects.WEB_SYNC_ANDROID_DEPLOYMENT);
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				deviceNameTestLogic(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.TI_400.getAttributeValue(), MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98151, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TI400MeasurementValueSyncTest()
	{
		try 
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				measurementValueTestLogic();
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				mMeasurementCell.click();
				ElementUtils.isDisplayed(3, mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MAX_TEMP));
				measurementDetailPageMeasurementValueTest();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98152, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TI400MeasurementUnitSyncTest()
	{
		try 
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				measurementUnitTestLogic();
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				measurementDetailPageMeasurementUniTest();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98153, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TI400MaxTempValueSyncTest()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				maxTempValueTestLogic();
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				measurementDetailPageMaxTempValueTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98154, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TI400MaxTempUnitSyncTest()
	{
		try
		{
			maxTempUnitTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98155, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TI400MaxTempLabelSyncTest()
	{
		try
		{
			maxMinLabelTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98156, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TI400MinTempValueSyncTest()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				minTempValueTestLogic();
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				measurementDetailPageMinTempValueTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98157, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TI400MinTempUnitSyncTest()
	{
		try
		{
			minTempUnitTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98158, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TI400MinTempLabelSyncTest() throws ParseException
	{
		try
		{
			maxMinLabelTestLogic();
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.BACK_BUTTON).click();
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.TI_400.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.TI_450_DOWNLOAD.getAttributeValue(), -1, mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + 1);
		}
		catch(Throwable e)
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.BACK_BUTTON).click();
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.TI_400.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.TI_450_DOWNLOAD.getAttributeValue(), -1, mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + 1);
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98200, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TI450DownloadedMeasurmentDeviceNameSyncTest()
	{
		try 
		{
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				deviceNameTestLogic(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.WEB_SYNC_IOS_DEPLOYMENT) + FCM.DeviceList.TI_450_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.WEB_SYNC_IOS_DEPLOYMENT) + 1, MeasurementDetailPageObjects.WEB_SYNC_IOS_DEPLOYMENT);
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				deviceNameTestLogic(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.TI_450_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + 1, MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98201, groups = {Config.TI_FCM, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TI450DownloadedMeasurementValueSyncTest()
	{
		try 
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				mMeasurementCell.click();
				ElementUtils.isDisplayed(3, mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MAX_TEMP));
				measurementDetailPageMeasurementValueTest();
			}
			else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				mWebTIMeasurementCell.click();
				ElementUtils.isDisplayed(3, mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MAX_TEMP));
				measurementDetailPageMeasurementValueTest();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98202, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TI450DownloadedMeasurementUnitSyncTest()
	{
		try 
		{
			measurementDetailPageMeasurementUniTest();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98203, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TI450DownloadedMaxTempValueSyncTest()
	{
		try
		{
			measurementDetailPageMaxTempValueTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98204, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TI450DownloadedMaxTempUnitSyncTest()
	{
		try
		{
			maxTempUnitTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98205, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TI450DownloadedMaxTempLabelSyncTest()
	{
		try
		{
			maxMinLabelTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98206, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TI450DownloadedMinTempValueSyncTest()
	{
		try
		{
			measurementDetailPageMinTempValueTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98207, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TI450DownloadedMinTempUnitSyncTest()
	{
		try
		{
			minTempUnitTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98208, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TI450DownloadedMinTempLabelSyncTest() throws ParseException
	{
		try
		{
			maxMinLabelTestLogic();
			mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.BACK_BUTTON).click();
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.TI_450_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.TI_450_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + 1, mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + 1);
		}
		catch(Throwable e)
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)  || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.BACK_BUTTON).click();
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.TI_450_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.TI_450_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + 1, mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + 1);
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98250, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI450DownloadedMeasurmentDeviceNameTest()
	{
		try 
		{
			deviceNameTestLogic(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.TI_450_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + 1, null);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98251, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI450DownloadedMeasurementValueTest()
	{
		try 
		{
			mMeasurementCell.click();
			ElementUtils.isDisplayed(3, mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MAX_TEMP));
			measurementDetailPageMeasurementValueTest();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98252, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI450DownloadedMeasurementUnitTest()
	{
		try 
		{
			measurementDetailPageMeasurementUniTest();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98253, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI450DownloadedMaxTempValueTest()
	{
		try
		{
			measurementDetailPageMaxTempValueTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98254, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI450DownloadedMaxTempUnitTest()
	{
		try
		{
			maxTempUnitTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98255, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI450DownloadedMaxTempLabelTest()
	{
		try
		{
			maxMinLabelTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98256, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI450DownloadedMinTempValueTest()
	{
		try
		{
			measurementDetailPageMinTempValueTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98257, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI450DownloadedMinTempUnitTest()
	{
		try
		{
			minTempUnitTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98258, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI450DownloadedMinTempLabelTest() throws ParseException
	{
		try
		{
			maxMinLabelTestLogic();
			mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.BACK_BUTTON).click();
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.TI_450_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.TI_400_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + 1, mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT));
		}
		catch(Throwable e)
		{
			mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.BACK_BUTTON).click();
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.TI_450_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.TI_400_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + 1, mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT));
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98300, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TI400DownloadedMeasurmentDeviceNameSyncTest()
	{
		try 
		{
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				deviceNameTestLogic(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.WEB_SYNC_IOS_DEPLOYMENT) + FCM.DeviceList.TI_400_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.WEB_SYNC_IOS_DEPLOYMENT), MeasurementDetailPageObjects.WEB_SYNC_IOS_DEPLOYMENT);
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				deviceNameTestLogic(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.TI_400_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT), MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98301, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TI400DownloadedMeasurementValueSyncTest()
	{
		try 
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				mMeasurementCell.click();
				ElementUtils.isDisplayed(3, mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MAX_TEMP));
				measurementDetailPageMeasurementValueTest();
			}
			else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				//mWebTIMeasurementCell.click();
				ElementUtils.isDisplayed(1, mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MAX_TEMP));
				measurementDetailPageMeasurementValueTest();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98302, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TI400DownloadedMeasurementUnitSyncTest()
	{
		try 
		{
			measurementDetailPageMeasurementUniTest();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98303, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TI400DownloadedMaxTempValueSyncTest()
	{
		try
		{
			measurementDetailPageMaxTempValueTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98304, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TI400DownloadedMaxTempUnitSyncTest()
	{
		try
		{
			maxTempUnitTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98305, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TI400DownloadedMaxTempLabelSyncTest()
	{
		try
		{
			maxMinLabelTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98306, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TI400DownloadedMinTempValueSyncTest()
	{
		try
		{
			measurementDetailPageMinTempValueTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98307, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TI400DownloadedMinTempUnitSyncTest()
	{
		try
		{
			minTempUnitTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98308, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TI400DownloadedMinTempLabelSyncTest() throws ParseException
	{
		try
		{
			maxMinLabelTestLogic();
			ElementUtils.safeClick(mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.BACK_BUTTON));
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.TI_400_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.TI_400_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT), mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT));
		}
		catch(Throwable e)
		{
			mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.BACK_BUTTON).click();
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.TI_400_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.TI_400_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT), mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT));
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98350, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI400DownloadedMeasurmentDeviceNameTest()
	{
		try 
		{
			deviceNameTestLogic(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.TI_400_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT), null);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98351, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI400DownloadedMeasurementValueTest()
	{
		try 
		{
			mMeasurementCell.click();
			ElementUtils.isDisplayed(3, mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MAX_TEMP));
			measurementDetailPageMeasurementValueTest();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98352, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI400DownloadedMeasurementUnitTest()
	{
		try 
		{
			measurementDetailPageMeasurementUniTest();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98353, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI400DownloadedMaxTempValueTest()
	{
		try
		{
			measurementDetailPageMaxTempValueTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98354, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI400DownloadedMaxTempUnitTest()
	{
		try
		{
			maxTempUnitTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98355, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI400DownloadedMaxTempLabelTest()
	{
		try
		{
			maxMinLabelTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98356, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI400DownloadedMinTempValueTest()
	{
		try
		{
			measurementDetailPageMinTempValueTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98357, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI400DownloadedMinTempUnitTest()
	{
		try
		{
			minTempUnitTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98358, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TI400DownloadedMinTempLabelTest() throws ParseException
	{
		try
		{
			maxMinLabelTestLogic();
			mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.BACK_BUTTON).click();
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.TI_400_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.TI_S75_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT), mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + 1);
		}
		catch(Throwable e)
		{
			mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.BACK_BUTTON).click();
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.TI_400_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.TI_S75_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT), mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + 1);
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98400, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TIS75DownloadedMeasurmentDeviceNameSyncTest()
	{
		try 
		{
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				deviceNameTestLogic(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.WEB_SYNC_IOS_DEPLOYMENT) + FCM.DeviceList.TI_S75_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.WEB_SYNC_IOS_DEPLOYMENT) + 1, MeasurementDetailPageObjects.WEB_SYNC_IOS_DEPLOYMENT);
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				deviceNameTestLogic(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.TI_S75_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + 1, MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98401, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TIS75DownloadedMeasurementValueSyncTest()
	{
		try 
		{
			//mMeasurementCell.click();
			ElementUtils.isDisplayed(3, mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MAX_TEMP));
			measurementDetailPageMeasurementValueTest();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98402, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TIS75DownloadedMeasurementUnitSyncTest()
	{
		try 
		{
			measurementDetailPageMeasurementUniTest();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98403, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TIS75DownloadedMaxTempValueSyncTest()
	{
		try
		{
			measurementDetailPageMaxTempValueTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98404, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TIS75DownloadedMaxTempUnitSyncTest()
	{
		try
		{
			maxTempUnitTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98405, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TIS75DownloadedMaxTempLabelSyncTest()
	{
		try
		{
			maxMinLabelTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98406, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TIS75DownloadedMinTempValueSyncTest()
	{
		try
		{
			measurementDetailPageMinTempValueTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98407, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TIS75DownloadedMinTempUnitSyncTest()
	{
		try
		{
			minTempUnitTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98408, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TIS75DownloadedMinTempLabelSyncTest() throws ParseException
	{
		try
		{
			maxMinLabelTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98409, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void assignAssetToTIS75DownloadedMeasurementSyncTest()
	{
		try
		{
			mMeasurementDetailPage.assignAsset(FCM.captureMeasurementAssetList[0], FCM.captureMeasurementAssetList[1], FCM.captureMeasurementAssetList[2]);
			Assert.assertTrue(mMeasurementDetailPage.isAssetAssigned(FCM.captureMeasurementAssetList[2]));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98410, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void assignWorkOrderToTIS75MeasurementSyncTest()
	{
		try
		{
			mMeasurementDetailPage.assignWorkOrder(Config.measurementAssignedWorkOrderNumber);
			Assert.assertTrue(mMeasurementDetailPage.isWorkOrderAssigned(Config.measurementAssignedWorkOrderNumber));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98411, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void addTextNoteToTIS75MeasurementSyncTest()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				mMeasurementDetailPage.addTextNote(Config.measurementTextNoteText);
				Assert.assertTrue(mMeasurementDetailPage.isTextNoteAdded(Config.measurementTextNoteText));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98412, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void shareTIS75MeasurementSyncTest() throws ParseException
	{
		try
		{
			mMeasurementDetailPage.shareMeasurement(Config.SHARE_EMAIL_ADDRESS, FCM.DataType.THERMAL_IMAGES, FCM.ShareFormat.PDF, false);
			CommonUtils.wait(2);
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.BACK_BUTTON).click();
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.MEASUREMENT_SAVE_BUTTON).click();
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.TI_S75_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.TI_S75_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + 1, mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + 1);
		}
		catch(Throwable e)
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.BACK_BUTTON).click();
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.MEASUREMENT_SAVE_BUTTON).click();
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.TI_S75_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.TI_S75_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + 1, mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + 1);
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98450, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TIS75DownloadedMeasurmentDeviceNameTest()
	{
		try 
		{
			deviceNameTestLogic(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.TI_S75_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + 1, null);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98451, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TIS75DownloadedMeasurementValueTest()
	{
		try 
		{
			mMeasurementCell.click();
			ElementUtils.isDisplayed(3, mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MAX_TEMP));
			measurementDetailPageMeasurementValueTest();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98452, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TIS75DownloadedMeasurementUnitTest()
	{
		try 
		{
			measurementDetailPageMeasurementUniTest();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98453, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TIS75DownloadedMaxTempValueTest()
	{
		try
		{
			measurementDetailPageMaxTempValueTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98454, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TIS75DownloadedMaxTempUnitTest()
	{
		try
		{
			maxTempUnitTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98455, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TIS75DownloadedMaxTempLabelTest()
	{
		try
		{
			maxMinLabelTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98456, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TIS75DownloadedMinTempValueTest()
	{
		try
		{
			measurementDetailPageMinTempValueTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98457, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TIS75DownloadedMinTempUnitTest()
	{
		try
		{
			minTempUnitTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98458, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TIS75DownloadedMinTempLabelTest() throws ParseException
	{
		try
		{
			maxMinLabelTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98459, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void assignAssetToTIS75DownloadedMeasurementTest()
	{
		try
		{
			mMeasurementDetailPage.assignAsset(FCM.captureMeasurementAssetList[0], FCM.captureMeasurementAssetList[1], FCM.captureMeasurementAssetList[2]);
			Assert.assertTrue(mMeasurementDetailPage.isAssetAssigned(FCM.captureMeasurementAssetList[2]));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98460, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void assignWorkOrderToTIS75MeasurementTest()
	{
		try
		{
			mMeasurementDetailPage.assignWorkOrder(Config.measurementAssignedWorkOrderNumber);
			Assert.assertTrue(mMeasurementDetailPage.isWorkOrderAssigned(Config.measurementAssignedWorkOrderNumber));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98461, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void addTextNoteToTIS75MeasurementTest()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				mMeasurementDetailPage.addTextNote(Config.measurementTextNoteText);
				Assert.assertTrue(mMeasurementDetailPage.isTextNoteAdded(Config.measurementTextNoteText));
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98462, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void shareTIS75MeasurementTest() throws ParseException
	{
		try
		{
			mMeasurementDetailPage.shareMeasurement(Config.SHARE_EMAIL_ADDRESS, FCM.DataType.THERMAL_IMAGES, FCM.ShareFormat.PDF, false);
			CommonUtils.wait(2);
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.BACK_BUTTON).click();
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.MEASUREMENT_SAVE_BUTTON).click();
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.TI_S75_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.TI_S65_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + 1, mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT));
		}
		catch(Throwable e)
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.BACK_BUTTON).click();
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.MEASUREMENT_SAVE_BUTTON).click();
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.TI_S75_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.TI_S65_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT), mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT));
			Assert.fail("Exception Detail: "+e);
		}
	}
		
	@Test(priority = 98500, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TIS65DownloadedMeasurmentDeviceNameSyncTest()
	{
		try 
		{
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				deviceNameTestLogic(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.WEB_SYNC_IOS_DEPLOYMENT) + FCM.DeviceList.TI_S65_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.WEB_SYNC_IOS_DEPLOYMENT), MeasurementDetailPageObjects.WEB_SYNC_IOS_DEPLOYMENT);
				//deviceNameTestLogic(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.WEB_SYNC_ANDROID_DEPLOYMENT) + FCM.DeviceList.TI_S65_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.WEB_SYNC_ANDROID_DEPLOYMENT), MeasurementDetailPageObjects.WEB_SYNC_ANDROID_DEPLOYMENT);
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				deviceNameTestLogic(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.TI_S65_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT), MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98501, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TIS65DownloadedMeasurementValueSyncTest()
	{
		try 
		{
			//mMeasurementCell.click();
			ElementUtils.isDisplayed(3, mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MAX_TEMP));
			measurementDetailPageMeasurementValueTest();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98502, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TIS65DownloadedMeasurementUnitSyncTest()
	{
		try 
		{
			measurementDetailPageMeasurementUniTest();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98503, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TIS65DownloadedMaxTempValueSyncTest()
	{
		try
		{
			measurementDetailPageMaxTempValueTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98504, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TIS65DownloadedMaxTempUnitSyncTest()
	{
		try
		{
			maxTempUnitTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98505, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TIS65DownloadedMaxTempLabelSyncTest()
	{
		try
		{
			maxMinLabelTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98506, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TIS65DownloadedMinTempValueSyncTest()
	{
		try
		{
			measurementDetailPageMinTempValueTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98507, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TIS65DownloadedMinTempUnitSyncTest()
	{
		try
		{
			minTempUnitTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98508, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_WEB, Config.TI_FCM_ANDROID})
	public void TIS65DownloadedMinTempLabelSyncTest() throws ParseException
	{
		try
		{
			maxMinLabelTestLogic();
			ElementUtils.safeClick(mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.BACK_BUTTON));
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.TI_S65_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.TI_S65_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT), mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT));
		}
		catch(Throwable e)
		{
			mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.BACK_BUTTON).click();
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.TI_S65_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.TI_S65_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT), mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT));
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98550, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TIS65DownloadedMeasurmentDeviceNameTest()
	{
		try 
		{
			deviceNameTestLogic(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.TI_S65_DOWNLOAD.getAttributeValue(), mMeasurementDetailPage.getMeasurementIndices(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT), null);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98551, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TIS65DownloadedMeasurementValueTest()
	{
		try 
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				measurementValueTestLogic();
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			{
				mMeasurementCell.click();
				ElementUtils.isDisplayed(3, mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.TI_MAX_TEMP));
				measurementDetailPageMeasurementValueTest();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98552, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TIS65DownloadedMeasurementUnitTest()
	{
		try 
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				measurementUnitTestLogic();
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				measurementDetailPageMeasurementUniTest();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98553, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TIS65DownloadedMaxTempValueTest()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				maxTempValueTestLogic();
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				measurementDetailPageMaxTempValueTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98554, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TIS65DownloadedMaxTempUnitTest()
	{
		try
		{
			maxTempUnitTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98555, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TIS65DownloadedMaxTempLabelTest()
	{
		try
		{
			maxMinLabelTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98556, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TIS65DownloadedMinTempValueTest()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				minTempValueTestLogic();
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				measurementDetailPageMinTempValueTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98557, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TIS65DownloadedMinTempUnitTest()
	{
		try
		{
			minTempUnitTestLogic();
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98558, groups = {Config.TI_FCM, Config.TI_FCM_IOS, Config.TI_FCM_ANDROID})
	public void TIS65DownloadedMinTempLabelTest() throws ParseException
	{
		try
		{
			maxMinLabelTestLogic();
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.BACK_BUTTON).click();
		}
		catch(Throwable e)
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.BACK_BUTTON).click();
		Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 98950, groups = {Config.TI_FCM, Config.TI_FCM_WEB})
	public void deleteTIMeasurements() throws ParseException
	{
		try
		{			
			//mMeasurementHistoryPage.deleteMultipleMeasurementsWeb();
		}
		catch(Throwable e)
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				mMeasurementDetailPage.getMeasurementDetailPageWebElement(MeasurementDetailPageObjects.BACK_BUTTON).click();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	// **************************************** TI FCM Test Suite ends here *********************************************************************************

	// **************************************** CNX Test Suite Starts Here *****************************************
	
	public void cnxDeviceNameTestLogic(String deviceName, MeasurementDetailPageObjects deploymentName) throws ParseException
	{
		mMeasurementCell = null;
		mMeasurementCell = mMeasurementHistoryPage.getMeasurementCell(true, Config.getPropertiesFilePath(PropertiesFileType.MEASUREMENTS_PROPERTIES), deviceName, null, null, -1, deploymentName, false);
		Assert.assertTrue(ElementUtils.getElement(mMeasurementCell, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, MeasturementAttributes.ANDROID_DEVICE_NAME.getAttributeValue(), LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, MeasturementAttributes.IOS_DEVICE_NAME.getAttributeValue(), LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, MeasturementAttributes.WEB_DEVICE_NAME.getAttributeValue()).getText().equals(FileUtil.readProperty(Config.getPropertiesFilePath(PropertiesFileType.MEASUREMENTS_PROPERTIES), deviceName)));
	}
	
	public void cnxMeasurementValueTestLogic()
	{
		Assert.assertTrue(FloatValidator.getInstance().isInRange(Float.parseFloat(ElementUtils.getElement(mMeasurementCell, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, MeasturementAttributes.ANDROID_VALUE_LABEL.getAttributeValue(), LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, MeasturementAttributes.IOS_CNX_VALUE_LABEL.getAttributeValue(), LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, MeasturementAttributes.WEB_CNX_VALUE.getAttributeValue()).getText()), -10.0, 100.0));	
	}
	
	public void cnxMeasurementUnitTestLogic(String expectedMeasurementUnit)
	{
		mMeasurementUnit.delete(0, mMeasurementUnit.length());
		mMeasurementUnit.append(ElementUtils.getElement(mMeasurementCell, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, MeasturementAttributes.ANDROID_UNIT_LABEL.getAttributeValue(), LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, MeasturementAttributes.IOS_CNX_UNIT_LABEL.getAttributeValue(), LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, MeasturementAttributes.WEB_CNX_UNIT.getAttributeValue()).getText());
		Assert.assertTrue(mMeasurementUnit.toString().contains(expectedMeasurementUnit));
	}
	
	public void cnxTempratureMeasurementUnitTestLogic(String expectedMeasurementUnit)
	{
		mMeasurementUnit.delete(0, mMeasurementUnit.length());
		mMeasurementUnit.append(ElementUtils.getElement(mMeasurementCell, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, MeasturementAttributes.ANDROID_UNIT_LABEL.getAttributeValue(), LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, MeasturementAttributes.IOS_CNX_UNIT_LABEL.getAttributeValue(), LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, MeasturementAttributes.WEB_CNX_UNIT.getAttributeValue()).getText());
		Assert.assertTrue(mMeasurementUnit.toString().contains(expectedMeasurementUnit));
	}
	
	public void cnxAssignedAssetTestLogic()
	{
		if(mWebAssignedAssetWorkOrderList != null)
			mWebAssignedAssetWorkOrderList.clear();
		mWebAssignedAssetWorkOrderList = ElementUtils.getElements(mMeasurementCell, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, MeasturementAttributes.WEB_ASSET_LABEL.getAttributeValue());
		Assert.assertTrue(mWebAssignedAssetWorkOrderList.get(0).getText().equals(FCM.DeviceList.WEB_ASSET_HIERARCHY.getAttributeValue()));
	}
	
	public void cnxAssignedWorkOrderTestLogic()
	{
		if(mWebAssignedAssetWorkOrderList != null)
			mWebAssignedAssetWorkOrderList.clear();
		mWebAssignedAssetWorkOrderList = ElementUtils.getElements(mMeasurementCell, null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, MeasturementAttributes.WEB_WORK_ORDER_LABEL.getAttributeValue());
		Assert.assertTrue(mWebAssignedAssetWorkOrderList.get(1).getText().contains(FCM.DeviceList.WEB_WORK_ORDER_NUMBER.getAttributeValue()));
	}
	
	/*
	 * Priority Range Segregated in 2 parts
	 * For Sync tests 97499 -- 97000 (backward)
	 * For Deployment Specific Tests 97999 - 97500
	 * For each device a range of 30 is allocated, for instance V300X range is 97950 - 980 (deployment tests), 97470 - 499 (sync tests)
	 * For new test we need to move upward in the priorty range
	 */
	
	@Test(priority = 97000, groups = {Config.CNX, Config.CNX_IOS, Config.CNX_WEB, Config.CNX_ANDROID})
	public void fc369MeasurementDeviceNameSyncTest()
	{
		try 
		{
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				mGestureUtils.webScroll(ScrollDiection.DOWN, 7);
				cnxDeviceNameTestLogic(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.WEB_SYNC_IOS_DEPLOYMENT) + FCM.DeviceList.FC369.getAttributeValue(), MeasurementDetailPageObjects.WEB_SYNC_IOS_DEPLOYMENT);
			}
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				cnxDeviceNameTestLogic(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.FC369.getAttributeValue(), MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97001, groups = {Config.CNX, Config.CNX_IOS, Config.CNX_WEB, Config.CNX_ANDROID})
	public void fc369MeasurementValueSyncTest()
	{
		try 
		{
			cnxMeasurementValueTestLogic();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97002, groups = {Config.CNX, Config.CNX_IOS, Config.CNX_WEB, Config.CNX_ANDROID})
	public void fc369MeasurementUnitSyncTest() throws ParseException
	{
		try 
		{
			cnxMeasurementUnitTestLogic(DeviceList.FC369_MEASUREMENT_UNIT.getAttributeValue());
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.FC369.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.A3000.getAttributeValue(), -1, -1);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.FC369.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.A3000.getAttributeValue(), -1, -1);
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97003, groups = {Config.CNX_WEB})
	public void fc369AssignedAssetSyncTest()
	{
		cnxAssignedAssetTestLogic();
	}
	
	@Test(priority = 97004, groups = {Config.CNX_WEB})
	public void fc369AssignedWorkOrderSyncTest()
	{
		cnxAssignedWorkOrderTestLogic();
	}
	
	@Test(priority = 97380, groups = {Config.CNX, Config.CNX_IOS, Config.CNX_WEB, Config.CNX_ANDROID})
	public void a3000MeasurementDeviceNameSyncTest()
	{
		try 
		{
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				cnxDeviceNameTestLogic(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.WEB_SYNC_IOS_DEPLOYMENT) + FCM.DeviceList.A3000.getAttributeValue(), MeasurementDetailPageObjects.WEB_SYNC_IOS_DEPLOYMENT);
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				cnxDeviceNameTestLogic(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.A3000.getAttributeValue(), MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97381, groups = {Config.CNX, Config.CNX_IOS, Config.CNX_WEB, Config.CNX_ANDROID})
	public void a3000MeasurementValueSyncTest()
	{
		try 
		{
			cnxMeasurementValueTestLogic();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97382, groups = {Config.CNX, Config.CNX_IOS, Config.CNX_WEB, Config.CNX_ANDROID})
	public void a3000MeasurementUnitSyncTest() throws ParseException
	{
		try 
		{
			cnxMeasurementUnitTestLogic(DeviceList.A3000_MEASUREMENT_UNIT.getAttributeValue());
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.A3000.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.T3000.getAttributeValue(), -1, -1);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.A3000.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.T3000.getAttributeValue(), -1, -1);
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97383, groups = {Config.CNX_WEB})
	public void a3000AssignedAssetSyncTest()
	{
		try 
		{
			cnxAssignedAssetTestLogic();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97384, groups = {Config.CNX_WEB})
	public void a3000AssignedWorkOrderSyncTest()
	{
		try 
		{
			cnxAssignedWorkOrderTestLogic();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97410, groups = {Config.CNX, Config.CNX_IOS, Config.CNX_WEB, Config.CNX_ANDROID})
	public void t3000MeasurementDeviceNameSyncTest()
	{
		try 
		{
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				cnxDeviceNameTestLogic(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.WEB_SYNC_ANDROID_DEPLOYMENT) + FCM.DeviceList.T3000.getAttributeValue(), MeasurementDetailPageObjects.WEB_SYNC_ANDROID_DEPLOYMENT);
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				cnxDeviceNameTestLogic(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.T3000.getAttributeValue(), MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97411, groups = {Config.CNX, Config.CNX_IOS, Config.CNX_WEB, Config.CNX_ANDROID})
	public void t3000MeasurementValueSyncTest()
	{
		try 
		{
			cnxMeasurementValueTestLogic();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97412, groups = {Config.CNX, Config.CNX_IOS, Config.CNX_WEB, Config.CNX_ANDROID})
	public void t3000MeasurementUnitSyncTest() throws ParseException
	{
		try 
		{
			cnxTempratureMeasurementUnitTestLogic(DeviceList.T3000_MEASUREMENT_UNIT.getAttributeValue());
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.T3000.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.A3002.getAttributeValue(), -1, -1);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.T3000.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.A3002.getAttributeValue(), -1, -1);
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97413, groups = {Config.CNX_WEB})
	public void t3000AssignedAssetSyncTest()
	{
		try 
		{
			cnxAssignedAssetTestLogic();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97414, groups = {Config.CNX_WEB})
	public void t3000AssignedWorkOrderSyncTest()
	{
		try 
		{
			cnxAssignedWorkOrderTestLogic();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97440, groups = {Config.CNX, Config.CNX_IOS, Config.CNX_WEB, Config.CNX_ANDROID})
	public void a3002MeasurementDeviceNameSyncTest()
	{
		try 
		{
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				cnxDeviceNameTestLogic(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.WEB_SYNC_IOS_DEPLOYMENT) + FCM.DeviceList.A3002.getAttributeValue(), MeasurementDetailPageObjects.WEB_SYNC_IOS_DEPLOYMENT);
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				cnxDeviceNameTestLogic(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.A3002.getAttributeValue(), MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97441, groups = {Config.CNX, Config.CNX_IOS, Config.CNX_WEB, Config.CNX_ANDROID})
	public void a3002MeasurementValueSyncTest()
	{
		try 
		{
			cnxMeasurementValueTestLogic();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97442, groups = {Config.CNX, Config.CNX_IOS, Config.CNX_WEB, Config.CNX_ANDROID})
	public void a3002MeasurementUnitSyncTest() throws ParseException
	{
		try 
		{
			cnxMeasurementUnitTestLogic(DeviceList.A3002_MEASUREMENT_UNIT.getAttributeValue());
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.A3002.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.V3000.getAttributeValue(), -1, -1);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.A3002.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.V3000.getAttributeValue(), -1, -1);
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97443, groups = {Config.CNX_WEB})
	public void a3002AssignedAssetSyncTest()
	{
		try 
		{
			cnxAssignedAssetTestLogic();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97444, groups = {Config.CNX_WEB})
	public void a3002AssignedWorkOrderSyncTest()
	{
		try 
		{
			cnxAssignedWorkOrderTestLogic();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97470, groups = {Config.CNX, Config.CNX_IOS, Config.CNX_WEB, Config.CNX_ANDROID})
	public void v3001MeasurementDeviceNameSyncTest()
	{
		try 
		{
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				cnxDeviceNameTestLogic(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.WEB_SYNC_ANDROID_DEPLOYMENT) + FCM.DeviceList.V3000.getAttributeValue(), MeasurementDetailPageObjects.WEB_SYNC_ANDROID_DEPLOYMENT);
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				cnxDeviceNameTestLogic(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.V3000.getAttributeValue(), MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97471, groups = {Config.CNX, Config.CNX_IOS, Config.CNX_WEB, Config.CNX_ANDROID})
	public void v3001MeasurementValueSyncTest()
	{
		try 
		{
			cnxMeasurementValueTestLogic();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97472, groups = {Config.CNX, Config.CNX_IOS, Config.CNX_WEB, Config.CNX_ANDROID})
	public void v3001MeasurementUnitSyncTest() throws ParseException
	{
		try 
		{
			cnxMeasurementUnitTestLogic(DeviceList.V3000_MEASUREMENT_UNIT.getAttributeValue());
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.V3000.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.FC369.getAttributeValue(), -1, -1);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.MOBILE_SYNC_DEPLOYMENT) + FCM.DeviceList.V3000.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.FC369.getAttributeValue(), -1, -1);
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97473, groups = {Config.CNX_WEB})
	public void v3001AssignedAssetSyncTest()
	{
		try 
		{
			cnxAssignedAssetTestLogic();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97474, groups = {})
	public void v3001AssignedWorkOrderSyncTest()
	{
		try 
		{
			cnxAssignedWorkOrderTestLogic();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97500, groups = {Config.CNX, Config.CNX_IOS, Config.CNX_ANDROID})
	public void fc369MeasurementDeviceNameTest()
	{
		try 
		{
			cnxDeviceNameTestLogic(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.FC369.getAttributeValue(), null);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97501, groups = {Config.CNX, Config.CNX_IOS, Config.CNX_ANDROID})
	public void fc369MeasurementValueTest()
	{
		try 
		{
			cnxMeasurementValueTestLogic();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97502, groups = {Config.CNX, Config.CNX_IOS, Config.CNX_ANDROID})
	public void fc369MeasurementUnitTest() throws ParseException
	{
		try 
		{
			cnxMeasurementUnitTestLogic(DeviceList.FC369_MEASUREMENT_UNIT.getAttributeValue());
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.FC369.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.A3000.getAttributeValue(), -1, -1);
		}
		catch(Exception e)
		{
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.FC369.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.A3000.getAttributeValue(), -1, -1);
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97860, groups = {Config.CNX, Config.CNX_IOS, Config.CNX_ANDROID})
	public void a3000MeasurementDeviceNameTest()
	{
		try 
		{
			cnxDeviceNameTestLogic(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.A3000.getAttributeValue(), null);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97861, groups = {Config.CNX, Config.CNX_IOS, Config.CNX_ANDROID})
	public void a3000MeasurementValueTest()
	{
		try 
		{
			cnxMeasurementValueTestLogic();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97862, groups = {Config.CNX, Config.CNX_IOS, Config.CNX_ANDROID})
	public void a3000MeasurementUnitTest() throws ParseException
	{
		try 
		{
			cnxMeasurementUnitTestLogic(DeviceList.A3000_MEASUREMENT_UNIT.getAttributeValue());
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.A3000.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.T3000.getAttributeValue(), -1, -1);
		}
		catch(Exception e)
		{
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.A3000.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.A3000.getAttributeValue(), -1, -1);
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97890, groups = {Config.CNX, Config.CNX_IOS, Config.CNX_ANDROID})
	public void t3000MeasurementDeviceNameTest()
	{
		try 
		{
			cnxDeviceNameTestLogic(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.T3000.getAttributeValue(), null);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97891, groups = {Config.CNX, Config.CNX_IOS, Config.CNX_ANDROID})
	public void t3000MeasurementValueTest()
	{
		try 
		{
			cnxMeasurementValueTestLogic();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97892, groups = {Config.CNX, Config.CNX_IOS, Config.CNX_ANDROID})
	public void t3000MeasurementUnitTest() throws ParseException
	{
		try 
		{
			cnxTempratureMeasurementUnitTestLogic(DeviceList.T3000_MEASUREMENT_UNIT.getAttributeValue());
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.T3000.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.A3002.getAttributeValue(), -1, -1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.T3000.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.A3002.getAttributeValue(), -1, -1);
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97920, groups = {Config.CNX, Config.CNX_IOS, Config.CNX_ANDROID})
	public void a3002MeasurementDeviceNameTest()
	{
		try 
		{
			cnxDeviceNameTestLogic(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.A3002.getAttributeValue(), null);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97921, groups = {Config.CNX, Config.CNX_IOS, Config.CNX_ANDROID})
	public void a3002MeasurementValueTest()
	{
		try 
		{
			cnxMeasurementValueTestLogic();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97922, groups = {Config.CNX, Config.CNX_IOS, Config.CNX_ANDROID})
	public void a3002MeasurementUnitTest() throws ParseException
	{
		try 
		{
			cnxMeasurementUnitTestLogic(DeviceList.A3002_MEASUREMENT_UNIT.getAttributeValue());
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.A3002.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.V3000.getAttributeValue(), -1, -1);
		}
		catch(Exception e)
		{
			setScrollDirection(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.A3002.getAttributeValue(), mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.V3000.getAttributeValue(), -1, -1);
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97950, groups = {})
	public void v3001MeasurementDeviceNameTest()
	{
		try 
		{
			cnxDeviceNameTestLogic(mMeasurementDetailPage.getDevicePrefix(MeasurementDetailPageObjects.CURRENT_DEPLOYMENT) + FCM.DeviceList.V3000.getAttributeValue(), null);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97951, groups = {})
	public void v3001MeasurementValueTest()
	{
		try 
		{
			cnxMeasurementValueTestLogic();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97952, groups = {})
	public void v3001MeasurementUnitTest()
	{
		try 
		{
			cnxMeasurementUnitTestLogic(DeviceList.V3000_MEASUREMENT_UNIT.getAttributeValue());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(priority = 97980, groups = {Config.CNX, Config.CNX_WEB})
	public void deleteCNXMeasurements() throws Exception
	{
		//mMeasurementHistoryPage.deleteMultipleMeasurementsWeb();
		if(!DriverManager.isSmokeSuite()) { 
			DriverManager.closeApp();
			DriverManager.launchApp();
			DriverManager.getSwitcher().signOut();
		}
	}
	
	//************************************* Sort And Filter Tests ***************************************************
	
	
	
	
	///////////////////////////bug automation////////////////////////////////////////////////////////////////
	

	@Test(priority = 97980, groups = {"musetest"})
	public void museCentrePointTest() throws Exception
	{
		CommonUtils.wait(10);
		mMeasurementHistoryPage.museCentrePointMeasurement();
	}	
	

	@Test(priority = 97980, groups = {})
	public void museGroupedCentrePointTest() throws Exception
	{
		CommonUtils.wait(10);
		mMeasurementHistoryPage.museGroupedCentrePointMeasurement();
	}	
	// **************************************** CNX Test Suite Ends Here *****************************************

	@AfterClass(groups = {Config.IOS_FULL_TESTS, Config.IOS_SMOKE_TESTS, Config.FC_805_TESTS,
			Config.EEVEE_MEASUREMENT_ANDROID_TESTS, Config.EEVEE_MEASUREMENT_IOS_TESTS,
			Config.TI_FCM_ANDROID, Config.TI_FCM_WEB, Config.TI_FCM_IOS, Config.TEAM_TESTS,
			Config.CNX, Config.CNX_IOS, Config.CNX_WEB, Config.CNX_ANDROID,"musetest", Config.TEAM_TESTS_WEB})
	public void tearDown() throws Exception
	{
		IOSUtils.resetIOSPageSource();
		if(!DriverManager.isSmokeSuite()) { 
			DriverManager.closeApp();
			DriverManager.launchApp();
			DriverManager.getSignIn().handleOnBoardPrompt();
			DriverManager.getSwitcher().signOut();
		}
	}
}