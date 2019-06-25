package com.fluke.connect.app.functional.client.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fluke.connect.app.functional.client.pages.AssetAnalysisPage;
import com.fluke.connect.app.functional.client.pages.AssetsPage;
import com.fluke.connect.app.functional.client.pages.FC1555CaptureMeasurementPage;
import com.fluke.connect.app.functional.client.pages.FC1664Page;
import com.fluke.connect.app.functional.client.pages.MeasurementDetailPage;
import com.fluke.connect.app.functional.client.pages.MeasurementsHistoryPage;
import com.fluke.connect.app.functional.client.pages.ServiceHatchPage;
import com.fluke.connect.app.functional.client.pages.Switcher;
import com.fluke.connect.app.testdata.Asset;
import com.fluke.connect.app.testdata.SignIn;
import com.fluke.connect.app.testdata.SignIn.FeatureList;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.GestureUtils;

public class FC1664Tests 
{
	
	private FC1664Page fc1664CaptureMeasurementPage;
	private Switcher switcher;
	private ServiceHatchPage serviceHatchPage;
	private MeasurementDetailPage measurementDetailPage;
	private GestureUtils gestureUtils;
	private AssetAnalysisPage assetsAnalysisPage;
	private AssetsPage assetsPage;
	private Asset asset;
	private MeasurementsHistoryPage measurementsHistoryPage;

	@BeforeClass(alwaysRun = true, groups = {Config.FC1664})
     public void initClass() throws Exception
	{

		if(!DriverManager.isSmokeSuite()) {
			DriverManager.getSignIn().signIn(SignIn.getUID(FeatureList.FC1664), SignIn.getPWD(FeatureList.FC1664));
	        DriverManager.getSignIn().handleAfterSignInAlertsOtherUser();
		}
		
		fc1664CaptureMeasurementPage = new FC1664Page();
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
	
	@Test(alwaysRun = true, priority = 169001, groups = {"fc1665"})
	public void verifyFC1664VoltageTest() throws Exception
	{
		try
		{
			//switcher.switchToCaptureMeasurementsHomePage();
			fc1664CaptureMeasurementPage.clickMeasurement("Voltage");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	
	@Test(alwaysRun = true, priority = 169001, groups = {Config.FC1664})
	public void verifyFC1664VoltageTestInDownloadedMeasurements() throws Exception
	{
		try
		{
			//switcher.switchToCaptureMeasurementsHomePage();
			fc1664CaptureMeasurementPage.clickMeasurement("Downloaded");
			fc1664CaptureMeasurementPage.verify1664fcMeasurementsConfigurationInListPage("Voltage");
			fc1664CaptureMeasurementPage.verify1664fcMeasurementParametersInListPage("Voltage");
			fc1664CaptureMeasurementPage.verify1664FCReadings("Voltage");
			fc1664CaptureMeasurementPage.backtoMeasurementsPage();
			CommonUtils.wait(15);
			
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			fc1664CaptureMeasurementPage.backtoMeasurementsPage();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 169001, groups = {Config.FC1664})
	public void verifyFC1664InsulationTestInDownloadedMeasurements() throws Exception
	{
		try
		{
			//switcher.switchToCaptureMeasurementsHomePage();
			fc1664CaptureMeasurementPage.clickMeasurement("Downloaded");
			fc1664CaptureMeasurementPage.verify1664fcMeasurementsConfigurationInListPage("Insulation");
			fc1664CaptureMeasurementPage.verify1664fcMeasurementParametersInListPage("Insulation");
			fc1664CaptureMeasurementPage.verify1664FCReadings("Insulation");
			fc1664CaptureMeasurementPage.backtoMeasurementsPage();
			CommonUtils.wait(15);
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 169001, groups = {Config.FC1664})
	public void verifyFC1664ContinuityTestInDownloadedMeasurements() throws Exception
	{
		try
		{
			//switcher.switchToCaptureMeasurementsHomePage();
			fc1664CaptureMeasurementPage.clickMeasurement("Downloaded");
			fc1664CaptureMeasurementPage.verify1664fcMeasurementsConfigurationInListPage("Continuity");
			fc1664CaptureMeasurementPage.verify1664fcMeasurementParametersInListPage("Continuity");
			fc1664CaptureMeasurementPage.verify1664FCReadings("Continuity");
			fc1664CaptureMeasurementPage.backtoMeasurementsPage();
			CommonUtils.wait(15);
			
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			fc1664CaptureMeasurementPage.backtoMeasurementsPage();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 169001, groups = {Config.FC1664})
	public void verifyFC1664NoTripLoopTestInDownloadedMeasurements() throws Exception
	{
		try
		{
			//switcher.switchToCaptureMeasurementsHomePage();
			fc1664CaptureMeasurementPage.clickMeasurement("Downloaded");
			fc1664CaptureMeasurementPage.verify1664fcMeasurementsConfigurationInListPage("No Trip Loop Test");
			fc1664CaptureMeasurementPage.verify1664fcMeasurementParametersInListPage("No Trip Loop Test");
			fc1664CaptureMeasurementPage.verify1664FCReadings("No Trip Loop Test");
			fc1664CaptureMeasurementPage.backtoMeasurementsPage();
			CommonUtils.wait(15);
			
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			fc1664CaptureMeasurementPage.backtoMeasurementsPage();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 169001, groups = {Config.FC1664})
	public void verifyFC1664HighCurrentLoopTestInDownloadedMeasurements() throws Exception
	{
		try
		{
			//switcher.switchToCaptureMeasurementsHomePage();
			fc1664CaptureMeasurementPage.clickMeasurement("Downloaded");
			fc1664CaptureMeasurementPage.verify1664fcMeasurementsConfigurationInListPage("High-Current Loop Test");
			fc1664CaptureMeasurementPage.verify1664fcMeasurementParametersInListPage("High-Current Loop Test");
			fc1664CaptureMeasurementPage.verify1664FCReadings("High-Current Loop Test");
			fc1664CaptureMeasurementPage.backtoMeasurementsPage();
			CommonUtils.wait(15);
			
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			fc1664CaptureMeasurementPage.backtoMeasurementsPage();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 169001, groups = {Config.FC1664})
	public void verifyFC1664RCDTrippingTimeTestInDownloadedMeasurements() throws Exception
	{
		try
		{
			//switcher.switchToCaptureMeasurementsHomePage();
			fc1664CaptureMeasurementPage.clickMeasurement("Downloaded");
			fc1664CaptureMeasurementPage.verify1664fcMeasurementsConfigurationInListPage("RCD Tripping Time Test");
			fc1664CaptureMeasurementPage.verify1664fcMeasurementParametersInListPage("RCD Tripping Time Test");
			fc1664CaptureMeasurementPage.verify1664FCReadings("RCD Tripping Time Test");
			fc1664CaptureMeasurementPage.backtoMeasurementsPage();
			CommonUtils.wait(15);
			
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			fc1664CaptureMeasurementPage.backtoMeasurementsPage();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 169001, groups = {Config.FC1664})
	public void verifyFC1664RCDTrippingCurrentTestInDownloadedMeasurements() throws Exception
	{
		try
		{
			//switcher.switchToCaptureMeasurementsHomePage();
			fc1664CaptureMeasurementPage.clickMeasurement("Downloaded");
			fc1664CaptureMeasurementPage.verify1664fcMeasurementsConfigurationInListPage("RCD Tripping Current Test");
			fc1664CaptureMeasurementPage.verify1664fcMeasurementParametersInListPage("RCD Tripping Current Test");
			fc1664CaptureMeasurementPage.verify1664FCReadings("RCD Tripping Current Test");
			fc1664CaptureMeasurementPage.backtoMeasurementsPage();
			CommonUtils.wait(15);
			
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			fc1664CaptureMeasurementPage.backtoMeasurementsPage();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 169001, groups = {Config.FC1664})
	public void verifyFC1664EarthGroundTestInDownloadedMeasurements() throws Exception
	{
		try
		{
			//switcher.switchToCaptureMeasurementsHomePage();
			fc1664CaptureMeasurementPage.clickMeasurement("Downloaded");
			//fc1664CaptureMeasurementPage.verify1664fcMeasurementsConfigurationInListPage("RCD Tripping Current Test");
			fc1664CaptureMeasurementPage.verify1664fcMeasurementParametersInListPage("Earth Ground Test");
			fc1664CaptureMeasurementPage.verify1664FCReadings("Earth Ground Test");
			fc1664CaptureMeasurementPage.backtoMeasurementsPage();
			CommonUtils.wait(15);
			
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			fc1664CaptureMeasurementPage.backtoMeasurementsPage();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 169001, groups = {Config.FC1664})
	public void verifyFC1664PhaseSequenceTestInDownloadedMeasurements() throws Exception
	{
		try
		{
			//switcher.switchToCaptureMeasurementsHomePage();
			fc1664CaptureMeasurementPage.clickMeasurement("Downloaded");
			//fc1664CaptureMeasurementPage.verify1664fcMeasurementsConfigurationInListPage("RCD Tripping Current Test");
			fc1664CaptureMeasurementPage.verify1664fcMeasurementParametersInListPage("Phase Sequence Test");
			fc1664CaptureMeasurementPage.verify1664FCReadings("Phase Sequence Test");
			fc1664CaptureMeasurementPage.backtoMeasurementsPage();
			CommonUtils.wait(15);
			
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			fc1664CaptureMeasurementPage.backtoMeasurementsPage();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	
	@Test(alwaysRun = true, priority = 169001, groups = {Config.FC1664})
	public void verifyFC1664VoltageMeasurement() throws Exception
	{
		try
		{
			//switcher.switchToCaptureMeasurementsHomePage();
			fc1664CaptureMeasurementPage.clickMeasurement("Voltage");
			fc1664CaptureMeasurementPage.verify1664fcMeasurementsConfigurationInListPage("Voltage");
			fc1664CaptureMeasurementPage.verify1664fcMeasurementParametersInListPage("Voltage");
			fc1664CaptureMeasurementPage.verify1664FCReadings("Voltage");
			fc1664CaptureMeasurementPage.backtoMeasurementsPage();
			CommonUtils.wait(15);
			
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			fc1664CaptureMeasurementPage.backtoMeasurementsPage();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 169001, groups = {Config.FC1664})
	public void verifyFC1664InsulationMeasurement() throws Exception
	{
		try
		{
			//switcher.switchToCaptureMeasurementsHomePage();
			fc1664CaptureMeasurementPage.clickMeasurement("Insulation");
			fc1664CaptureMeasurementPage.verify1664fcMeasurementsConfigurationInListPage("Insulation");
			fc1664CaptureMeasurementPage.verify1664fcMeasurementParametersInListPage("Insulation");
			fc1664CaptureMeasurementPage.verify1664FCReadings("Insulation");
			fc1664CaptureMeasurementPage.backtoMeasurementsPage();
			CommonUtils.wait(15);
			
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			fc1664CaptureMeasurementPage.backtoMeasurementsPage();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 169001, groups = {Config.FC1664})
	public void verifyFC1664ContinuityMeasurement() throws Exception
	{
		try
		{
			//switcher.switchToCaptureMeasurementsHomePage();
			fc1664CaptureMeasurementPage.clickMeasurement("Continuity");
			fc1664CaptureMeasurementPage.verify1664fcMeasurementsConfigurationInListPage("Continuity");
			fc1664CaptureMeasurementPage.verify1664fcMeasurementParametersInListPage("Continuity");
			fc1664CaptureMeasurementPage.verify1664FCReadings("Continuity");
			fc1664CaptureMeasurementPage.backtoMeasurementsPage();
			CommonUtils.wait(15);
			
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			fc1664CaptureMeasurementPage.backtoMeasurementsPage();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	
	@Test(alwaysRun = true, priority = 169001, groups = {Config.FC1664})
	public void verifyFC1664NoTripLoopMeasurement() throws Exception
	{
		try
		{
			//switcher.switchToCaptureMeasurementsHomePage();
			fc1664CaptureMeasurementPage.clickMeasurement("No Trip Loop Test");
			fc1664CaptureMeasurementPage.verify1664fcMeasurementsConfigurationInListPage("No Trip Loop Test");
			fc1664CaptureMeasurementPage.verify1664fcMeasurementParametersInListPage("No Trip Loop Test");
			fc1664CaptureMeasurementPage.verify1664FCReadings("No Trip Loop Test");
			fc1664CaptureMeasurementPage.backtoMeasurementsPage();
			CommonUtils.wait(15);
			
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			fc1664CaptureMeasurementPage.backtoMeasurementsPage();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	
	@Test(alwaysRun = true, priority = 169001, groups = {Config.FC1664})
	public void verifyFC1664HighCurrentLoopTestMeasurement() throws Exception
	{
		try
		{
			//switcher.switchToCaptureMeasurementsHomePage();
			fc1664CaptureMeasurementPage.clickMeasurement("High-Current Loop Test");
			fc1664CaptureMeasurementPage.verify1664fcMeasurementsConfigurationInListPage("High-Current Loop Test");
			fc1664CaptureMeasurementPage.verify1664fcMeasurementParametersInListPage("High-Current Loop Test");
			fc1664CaptureMeasurementPage.verify1664FCReadings("High-Current Loop Test");
			fc1664CaptureMeasurementPage.backtoMeasurementsPage();
			CommonUtils.wait(15);
			
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			fc1664CaptureMeasurementPage.backtoMeasurementsPage();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 169001, groups = {Config.FC1664})
	public void verifyFC1664RCDTrippingTimeTestMeasurement() throws Exception
	{
		try
		{
			//switcher.switchToCaptureMeasurementsHomePage();
			fc1664CaptureMeasurementPage.clickMeasurement("RCD Tripping Time Test");
			fc1664CaptureMeasurementPage.verify1664fcMeasurementsConfigurationInListPage("RCD Tripping Time Test");
			fc1664CaptureMeasurementPage.verify1664fcMeasurementParametersInListPage("RCD Tripping Time Test");
			fc1664CaptureMeasurementPage.verify1664FCReadings("RCD Tripping Time Test");
			fc1664CaptureMeasurementPage.backtoMeasurementsPage();
			CommonUtils.wait(15);
			
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			fc1664CaptureMeasurementPage.backtoMeasurementsPage();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 169001, groups = {Config.FC1664})
	public void verifyFC1664RCDTrippingCurrentTestMeasurement() throws Exception
	{
		try
		{
			//switcher.switchToCaptureMeasurementsHomePage();
			fc1664CaptureMeasurementPage.clickMeasurement("RCD Tripping Current Test");
			fc1664CaptureMeasurementPage.verify1664fcMeasurementsConfigurationInListPage("RCD Tripping Current Test");
			fc1664CaptureMeasurementPage.verify1664fcMeasurementParametersInListPage("RCD Tripping Current Test");
			fc1664CaptureMeasurementPage.verify1664FCReadings("RCD Tripping Current Test");
			fc1664CaptureMeasurementPage.backtoMeasurementsPage();
			CommonUtils.wait(15);
			
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			fc1664CaptureMeasurementPage.backtoMeasurementsPage();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 169001, groups = {Config.FC1664})
	public void verifyFC1664EarthGroundTestMeasurement() throws Exception
	{
		try
		{
			//switcher.switchToCaptureMeasurementsHomePage();
			fc1664CaptureMeasurementPage.clickMeasurement("Earth Ground Test");
			//fc1664CaptureMeasurementPage.verify1664fcMeasurementsConfigurationInListPage("RCD Tripping Current Test");
			fc1664CaptureMeasurementPage.verify1664fcMeasurementParametersInListPage("Earth Ground Test");
			fc1664CaptureMeasurementPage.verify1664FCReadings("Earth Ground Test");
			fc1664CaptureMeasurementPage.backtoMeasurementsPage();
			CommonUtils.wait(15);
			
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			fc1664CaptureMeasurementPage.backtoMeasurementsPage();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test(alwaysRun = true, priority = 169001, groups = {Config.FC1664})
	public void verifyFC1664PhaseSequenceTestMeasurement() throws Exception
	{
		try
		{
			//switcher.switchToCaptureMeasurementsHomePage();
			fc1664CaptureMeasurementPage.clickMeasurement("Earth Ground Test");
			//fc1664CaptureMeasurementPage.verify1664fcMeasurementsConfigurationInListPage("RCD Tripping Current Test");
			fc1664CaptureMeasurementPage.verify1664fcMeasurementParametersInListPage("Earth Ground Test");
			fc1664CaptureMeasurementPage.verify1664FCReadings("Earth Ground Test");
			fc1664CaptureMeasurementPage.backtoMeasurementsPage();
			CommonUtils.wait(15);
			
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			fc1664CaptureMeasurementPage.backtoMeasurementsPage();
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	

}
