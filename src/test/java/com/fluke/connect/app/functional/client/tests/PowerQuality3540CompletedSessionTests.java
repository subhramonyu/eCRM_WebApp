package com.fluke.connect.app.functional.client.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fluke.connect.app.functional.client.pages.CompletedSessionPage;
import com.fluke.connect.app.functional.client.pages.MeasurementsHistoryPage;
import com.fluke.connect.app.functional.client.pages.PowerQuality3540CompletedSessionPage;
import com.fluke.connect.app.functional.client.pages.Switcher;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.Gestures;
import com.fluke.connect.app.utils.TestNGUtils;

public class PowerQuality3540CompletedSessionTests 
{
	private CompletedSessionPage completedSessionPage;
	private Switcher switcherPage;
	private Gestures gesture;
	private PowerQuality3540CompletedSessionPage powerQuality3540CompletedSessionPage;
	private MeasurementsHistoryPage measurementsHistoryPage;

	
	@BeforeClass(alwaysRun = true, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS, Config.ANDROID_UAT_TESTS}) //Config.ANDROID_SMOKE_TESTS
	public void initClass()
	{
		completedSessionPage = new CompletedSessionPage();
		switcherPage = new Switcher();
		gesture = new Gestures();
		powerQuality3540CompletedSessionPage =new PowerQuality3540CompletedSessionPage();
		measurementsHistoryPage = new MeasurementsHistoryPage();
	}
	
	@AfterClass(alwaysRun = true, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS, Config.ANDROID_UAT_TESTS}) //Config.ANDROID_SMOKE_TESTS
	public void afterClass()
	{
		PowerQuality3540CompletedSessionPage.backButton.click();
		CommonUtils.wait(2);
		PowerQuality3540CompletedSessionPage.backButton.click();
		CommonUtils.wait(2);
	}
	

	@Test (priority = 114001, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS, Config.ANDROID_UAT_TESTS})//,Config.ANDROID_SMOKE_TESTS
	public void check3540CompletedSession()
	{
		TestNGUtils.setTestMethodPriority(114001);
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
				gesture.scroll("value", Config.Android_PreProd_PQ3540_EneryStudy_3PhaseWye_sessionTime, null, Config.Android_PreProd_PQ3540_EneryStudy_3PhaseWye_sessionTime, -300,-45, null, null);
				completedSessionPage.initSessionCellElement(Config.Android_PreProd_PQ3540_EneryStudy_3PhaseWye_sessionTime);
				completedSessionPage.getElementInSessionTileStrict(Config.Android_PreProd_PQ3540_EneryStudy_3PhaseWye_sessionTime).click();
				Assert.assertEquals(completedSessionPage.getElementVisibleTextInSessionDetailPageStrict(Config.Android_PreProd_PQ3540_EneryStudy_3PhaseWye_sessionTime), Config.Android_PreProd_PQ3540_EneryStudy_3PhaseWye_sessionTime);
			}
			else if(DriverManager.getEnvironmentName().equals("Devolpment"))
			{
				gesture.scroll("value", Config.Android_Dev_PQ3540_EneryStudy_3PhaseWye_sessionTime, null, Config.Android_Dev_PQ3540_EneryStudy_3PhaseWye_sessionTime, -300,-45, null, null);
				completedSessionPage.initSessionCellElement(Config.Android_Dev_PQ3540_EneryStudy_3PhaseWye_sessionTime);
				completedSessionPage.getElementInSessionTileStrict(Config.Android_Dev_PQ3540_EneryStudy_3PhaseWye_sessionTime).click();
				Assert.assertEquals(completedSessionPage.getElementVisibleTextInSessionDetailPageStrict(Config.Android_Dev_PQ3540_EneryStudy_3PhaseWye_sessionTime), Config.Android_Dev_PQ3540_EneryStudy_3PhaseWye_sessionTime);
			}
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
		
	}
	
	@Test (priority = 114002, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS, Config.ANDROID_UAT_TESTS}) //Config.ANDROID_SMOKE_TESTS
	public void switchBetweenGraphView()
	{
		TestNGUtils.setTestMethodPriority(114002);
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null, null,"1M",-45,-60, null, null);
			powerQuality3540CompletedSessionPage.switchingBetweenGraphView();
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114003, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void switchBetweenVAHzView()
	{
		//This test case will check the switching between VAHz view
		try
		{
			gesture.scroll(null,null, null,"1M",-45,-60, null, null);
			powerQuality3540CompletedSessionPage.switchingBetweenVAHzView();
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114004, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void switchBetweenActivePowerView()
	{
		//This test case will check the switching between all Active power view
		try
		{
			gesture.scroll(null,null, null,"1M",-45,-60, null, null);
			powerQuality3540CompletedSessionPage.switchingBetweenActivePowerView();
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114005, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void switchBetweenPowerOverViewView()
	{
		//This test case will check the switching between Power Overview view
		try
		{
			gesture.scroll(null,null, null,"1M",-45,-60, null, null);
			powerQuality3540CompletedSessionPage.switchingBetweenPowerOverViewView();
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114006, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void switchBetweenTHDTHCView()
	{
		//This test case will check the switching between all the THD/THC view
		try
		{
			gesture.scroll(null,null, null,"1M",-45,-60, null, null);
			powerQuality3540CompletedSessionPage.switchingBetweenTHDTHCView();
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114007, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void voltage1HourGraphTabCheck()
	{
		//This test case will check the if stale data present in voltage 1h graph tab
		try
		{

			gesture.scroll(null,null, null,"1M",-45,-60, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.voltage1HourGraphTab(),"Measurement is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114008, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void voltage1DGraphTabCheck()
	{
		//This test case will check the if stale data present in voltage 1D graph tab
		try
		{
			gesture.scroll(null,null, null,"1M",-45,-60, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.voltage1DGraphTab(),"Measurement is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114009, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void voltage1WGraphTabCheck()
	{
		//This test case will check the if stale data present in voltage 1W graph tab
		try
		{
			gesture.scroll(null,null, null,"1M",-45,-60, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.voltage1WGraphTab(),"Measurement is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114010, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void voltage1MGraphTabCheck()
	{
		//This test case will check the if stale data present in voltage 1M graph tab
		try
		{
			gesture.scroll(null,null, null,"1M",-45,-60, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.voltage1MGraphTab(),"Measurement is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114011, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void voltageAllGraphTabCheck()
	{
		//This test case will check the if stale data present in voltage All graph tab
		try
		{
			gesture.scroll(null,null, null,"1M",-45,-60, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.voltageAllGraphTab(),"Measurement is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	

	@Test (priority = 114012, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS, Config.ANDROID_UAT_TESTS})
	public void current1HGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null, null,"1M",-45,-60, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.current1HGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	

	@Test (priority = 114013, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void current1DGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null, null,"1M",-45,-60, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.current1DGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	

	@Test (priority = 114014, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void current1WGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null, null,"1M",-45,-60, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.current1WGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	
	@Test (priority = 114015, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void current1MGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null, null,"1M",-45,-60, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.current1MGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	

	@Test (priority = 114016, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void currentAllGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null, null,"1M",-45,-60, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.currentAllGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	

	@Test (priority = 114017, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void frequency1HGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null, null,"1M",-45,-60, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.frequency1HGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}


	@Test (priority = 114018, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void frequency1DGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null, null,"1M",-45,-60, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.frequency1DGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	
	@Test (priority = 114019, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void frequency1WGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.frequency1WGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	
	@Test (priority = 114020, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void frequency1MGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.frequency1MGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114021, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void frequencyAllGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.frequencyAllGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	
	@Test (priority = 114022, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void activePower1HGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.activePower1HGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	
	@Test (priority = 114023, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void activePower1DGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.activePower1DGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114024, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void activePower1WGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.activePower1WGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114025, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void activePower1MGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.activePower1MGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}

	@Test (priority = 114026, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void activePowerAllGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.activePowerAllGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114027, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerFactor1HGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerFactor1HGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	
	@Test (priority = 114028, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerFactor1DGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerFactor1DGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	
	@Test (priority = 114029, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerFactor1WGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerFactor1WGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114030, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerFactor1MGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerFactor1MGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	
	@Test (priority = 114031, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerFactorAllGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerFactorAllGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114032, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerOverView_PhaseA_1HGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerOverView_PhaseA_1HGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	
	@Test (priority = 114033, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerOverView_PhaseA_1DGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerOverView_PhaseA_1DGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	
	@Test (priority = 114034, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerOverView_PhaseA_1WGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerOverView_PhaseA_1WGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	
	@Test (priority = 114035, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerOverView_PhaseA_1MGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerOverView_PhaseA_1MGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	
	@Test (priority = 114036, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerOverView_PhaseA_AllGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerOverView_PhaseA_AllGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	
	@Test (priority = 114037, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerOverView_PhaseB_1HGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerOverView_PhaseB_1HGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	
	@Test (priority = 114038, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerOverView_PhaseB_1DGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerOverView_PhaseB_1DGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114039, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerOverView_PhaseB_1WGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerOverView_PhaseB_1WGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114040, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerOverView_PhaseB_1MGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerOverView_PhaseB_1MGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114041, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerOverView_PhaseB_AllGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerOverView_PhaseB_AllGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114042, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerOverView_PhaseC_1HGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerOverView_PhaseC_1HGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	
	@Test (priority = 114043, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerOverView_PhaseC_1DGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerOverView_PhaseC_1DGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	
	@Test (priority = 114044, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerOverView_PhaseC_1WGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerOverView_PhaseC_1WGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114045, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerOverView_PhaseC_1MGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerOverView_PhaseC_1MGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114046, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerOverView_PhaseC_AllGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerOverView_PhaseC_AllGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114047, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerOverView_Total_1HGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerOverView_Total_1HGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114048, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerOverView_Total_1DGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerOverView_Total_1DGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114049, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerOverView_Total_1WGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerOverView_Total_1WGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114050, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerOverView_Total_1MGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerOverView_Total_1MGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114051, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerOverView_Total_AllGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerOverView_Total_AllGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114052, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerOverView_KW_1HGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerOverView_KW_1HGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114053, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerOverView_KW_1DGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerOverView_KW_1DGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114054, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerOverView_KW_1WGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerOverView_KW_1WGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	
	@Test (priority = 114055, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerOverView_KW_1MGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerOverView_KW_1MGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	
	@Test (priority = 114056, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerOverView_KW_AllGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerOverView_KW_AllGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114057, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerOverView_KVA_1HGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerOverView_KVA_1HGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	
	@Test (priority = 114058, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerOverView_KVA_1DGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerOverView_KVA_1DGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	
	@Test (priority = 114059, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerOverView_KVA_1WGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerOverView_KVA_1WGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114060, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerOverView_KVA_1MGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerOverView_KVA_1MGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114061, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerOverView_KVA_AllGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerOverView_KVA_AllGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	
	@Test (priority = 114062, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerOverView_Kvar_1HGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerOverView_Kvar_1HGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	
	@Test (priority = 114063, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerOverView_Kvar_1DGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerOverView_Kvar_1DGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114064, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerOverView_Kvar_1WGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerOverView_Kvar_1WGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114065, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerOverView_Kvar_1MGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerOverView_Kvar_1MGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Test (priority = 114066, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void powerOverView_Kvar_AllGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.powerOverView_Kvar_AllGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114067, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void tHD_THC_THDV_1HGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.tHDtHc_THDV_1HGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	
	@Test (priority = 114068, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void tHD_THC_THDV_1DGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.tHDtHc_THDV_1DGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	
	@Test (priority = 114069, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void tHD_THC_THDV_1WGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.tHDtHc_THDV_1WGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	
	@Test (priority = 114070, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void tHD_THC_THDV_1MGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.tHDtHc_THDV_1MGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114071, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void tHD_THC_THDV_AllGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.tHDtHc_THDV_AllGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	
	@Test (priority = 114072, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void tHD_THC_THDA_1HGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.tHDtHc_THDA_1HGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114073, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void tHD_THC_THDA_1DGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.tHDtHc_THDA_1DGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	
	@Test (priority = 114074, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void tHD_THC_THDA_1WGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.tHDtHc_THDA_1WGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114075, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void tHD_THC_THDA_1MGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.tHDtHc_THDA_1MGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	
	@Test (priority = 114076, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void tHD_THC_THDA_AllGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.tHDtHc_THDA_AllGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	
	@Test (priority = 114077, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void tHD_THC_THCA_1HGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.tHDtHc_THCA_1HGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114078, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void tHD_THC_THCA_1DGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.tHDtHc_THCA_1DGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	@Test (priority = 114079, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void tHD_THC_THCA_1WGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.tHDtHc_THCA_1WGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	
	@Test (priority = 114080, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void tHD_THC_THCA_1MGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.tHDtHc_THCA_1MGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
	
	@Test (priority = 114081, groups = {Config.FCCM_3540_TESTS,Config.ANDROID_FULL_TESTS})
	public void tHD_THC_THCA_AllGraphTabCheck()
	{
		//This test case will check the switching between all the graph view
		try
		{
			gesture.scroll(null,null,null,"1M",-45,-45, null, null);
			Assert.assertTrue(powerQuality3540CompletedSessionPage.tHDtHc_THCA_AllGraphTab(),"Measurement is not having Voltage (A) unit or it is having a stale data");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
		
	}
	
}
