package com.fluke.connect.app.functional.client.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fluke.connect.app.functional.client.pages.Graph3560Page;
import com.fluke.connect.app.functional.client.pages.Switcher;
import com.fluke.connect.app.testdata.FCCM3560;
import com.fluke.connect.app.testdata.Graph;
import com.fluke.connect.app.testdata.SignIn;
import com.fluke.connect.app.testdata.Graph.SessionTileDetail;
import com.fluke.connect.app.testdata.Graph.SessionType;
import com.fluke.connect.app.testdata.SignIn.FeatureList;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.GestureUtils;



public class Graph3560Test {
	
	
	private Graph3560Page graph3560Page;
	public String sessionID;
	public Map<Enum<?>, String>sesionTileCheck=new HashMap<Enum<?>,String>();
	
	private Switcher switcher;
	public List<String> getMetaData=new ArrayList<String>();
	
	public  List<String> sessionTileValue=new  ArrayList<String>();
	
	@BeforeClass(alwaysRun=true,groups = {Graph.GRAPHDEV})
	@Parameters({"sessionID"})
	public void initClass(String sessionID) throws Exception
	{
		graph3560Page=new Graph3560Page();
		switcher=new Switcher();
		if(!DriverManager.isSmokeSuite()) {
				DriverManager.getSignIn().signIn(SignIn.getUID(FeatureList.FCCM3560), SignIn.getPWD(FeatureList.FCCM3560));
				DriverManager.getSignIn().handleAfterSignInAlertsOtherUser();
			    CommonUtils.wait(4);	
			
		}
		else
		{
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
				DriverManager.getSignIn().signIn(SignIn.getUID(FeatureList.SMOKE_WEB), SignIn.getPWD(FeatureList.SMOKE_WEB));
				DriverManager.getSignIn().handleAfterSignInAlerts();
		        DriverManager.setSmokeSuiteFlag(true);
			}
			
		}
		switcher.switchToSession(Switcher.ACTIVE_SESSION);
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			graph3560Page.clickOnSessionType(SessionType.VIBRATION,"Active Session");	
		CommonUtils.wait(5);
		this.sessionID=sessionID;
		
		sessionTileValue=graph3560Page.sesionTileValue(sessionID);
		
		System.out.println(sessionTileValue);
		
		/*sesionTileCheck.put(SessionTileDetail.ASSETGROUP, graph3560Page.sesionTileValue(sessionID).get(0));
		sesionTileCheck.put(SessionTileDetail.ASSET, graph3560Page.sesionTileValue(sessionID).get(1));
		sesionTileCheck.put(SessionTileDetail.STARTUSER, graph3560Page.sesionTileValue(sessionID).get(2));
		sesionTileCheck.put(SessionTileDetail.STARTTIME, graph3560Page.sesionTileValue(sessionID).get(3));
		//sesionTileCheck.put(SessionTileDetail.ENDTIME, graph3560Page.sesionTileValue(sessionID).get(4));
		//sesionTileCheck.put(SessionTileDetail.ENDUSER, graph3560Page.sesionTileValue(sessionID).get(5));
		sesionTileCheck.put(SessionTileDetail.GATEWAYNAME, graph3560Page.sesionTileValue(sessionID).get(6));
		sesionTileCheck.put(SessionTileDetail.ALARM, graph3560Page.sesionTileValue(sessionID).get(7));
		sesionTileCheck.put(SessionTileDetail.SENSORNAME, graph3560Page.sesionTileValue(sessionID).get(8));
		//sesionTileCheck.put(SessionTileDetail.MONITORINGSTATUS, graph3560Page.sesionTileValue(sessionID).get(9));*/
		
	}
	
	@Test(priority=1,groups= {Graph.GRAPHDEV})
	public void verifySessionStartTime()
	{
		try 
		{
			Assert.assertTrue(Graph3560Page.getSessionTileElement(SessionTileDetail.STARTTIME,sessionID).isDisplayed());
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority=2,groups= {Graph.GRAPHDEV})
	public void verifySessionEndTime()
	{
		try 
		{
			Assert.assertTrue(Graph3560Page.getSessionTileElement(SessionTileDetail.ENDTIME,sessionID).isDisplayed());
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
		
	}
	
	@Test(priority=3,groups= {Graph.GRAPHDEV})
	public void verifyGatewayNameOnSessionTile()
	{
		try 
		{
			Assert.assertTrue(Graph3560Page.getSessionTileElement(SessionTileDetail.GATEWAYNAME,sessionID).isDisplayed());
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
		
	}
	
	@Test(priority=4,groups= {Graph.GRAPHDEV})
	public void verifySessionStartUserSessionTile()
	{
		try 
		{
			Assert.assertTrue(Graph3560Page.getSessionTileElement(SessionTileDetail.STARTUSER,sessionID).isDisplayed());
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
		
	}

	@Test(priority=5,groups= {Graph.GRAPHDEV})
	public void verifySessionEndUserSessionTile()
	{
		try 
		{
			Assert.assertTrue(Graph3560Page.getSessionTileElement(SessionTileDetail.ENDUSER,sessionID).isDisplayed());
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
		
	}

	
	@Test(priority=6,groups= {Graph.GRAPHDEV})
	public void verifyAssetGroupSessionTile()
	{
		try 
		{
			Assert.assertTrue(Graph3560Page.getSessionTileElement(SessionTileDetail.ASSETGROUP,sessionID).isDisplayed());
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
		
	}
	
	@Test(priority=7,groups= {Graph.GRAPHDEV})
	public void verifyAssetSessionTile()
	{
		try 
		{
			Assert.assertTrue(Graph3560Page.getSessionTileElement(SessionTileDetail.ASSET,sessionID).isDisplayed());
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
		
	}
	
	
	@Test(priority=8,groups= {Graph.GRAPHDEV})
	public void verifyAlarmSessionTile()
	{
		try 
		{
			Assert.assertTrue(Graph3560Page.getSessionTileElement(SessionTileDetail.ALARM,sessionID).isDisplayed());
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
		
	}
	
	
	
	@Test(priority=9,groups= {Graph.GRAPHDEV})
	public void verifyAlertSessionTile()
	{
		try 
		{
			Assert.assertTrue(Graph3560Page.getSessionTileElement(SessionTileDetail.ALERT,sessionID).isDisplayed());
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
		
	}
	
	

	@Test(priority=10,groups= {Graph.GRAPHDEV})
	public void verifySensorNameSessionTile()
	{
		try 
		{
			Assert.assertTrue(Graph3560Page.getSessionTileElement(SessionTileDetail.SENSORNAME,sessionID).isDisplayed());
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
		
	}
	
	
	@Test(priority=11,groups= {Graph.GRAPHDEV})
	public void verifyNavigationOnDetailPage()
	{
		try 
		{
			graph3560Page.clickOnSessionTile(sessionID);
			Assert.assertTrue(Graph3560Page.getSessionTileElement(SessionTileDetail.MONITORINGSTATUS,sessionID).isDisplayed());
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
		
	}	
	
	@Test(priority=12,groups= {Graph.GRAPHDEV})
	public void validateSessionStartTimeOnDetailPage()
	{
		try 
		{
			Assert.assertTrue(sessionTileValue.contains((graph3560Page.getSessionDetails(SessionTileDetail.STARTTIME).getText())));

			
			//Assert.assertTrue(graph3560Page.getSessionDetails(SessionTileDetail.STARTTIME).getText().equals(sesionTileCheck.get(SessionTileDetail.STARTTIME)));
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority=13,groups= {Graph.GRAPHDEV})
	public void validateSessionStartUserOnDetailPage()
	{
		try 
		{
			Assert.assertTrue(sessionTileValue.contains((graph3560Page.getSessionDetails(SessionTileDetail.STARTUSER).getText())));

			//Assert.assertTrue(graph3560Page.getSessionDetails(SessionTileDetail.STARTUSER).getText().equals(sesionTileCheck.get(SessionTileDetail.STARTUSER)));
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
	@Test(priority=14,groups= {})
	public void validateSessionEndTimeOnDetailPage()
	{
		try 
		{
			Assert.assertTrue(sessionTileValue.contains((graph3560Page.getSessionDetails(SessionTileDetail.ENDTIME).getText())));

			//Assert.assertTrue(graph3560Page.getSessionDetails(SessionTileDetail.ENDTIME).getText().equals(sesionTileCheck.get(SessionTileDetail.ENDTIME)));
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority=15,groups= {})
	public void validateSessionEndUserOnDetailPage()
	{
		try 
		{
			Assert.assertTrue(sessionTileValue.contains((graph3560Page.getSessionDetails(SessionTileDetail.ENDUSER).getText())));

			//Assert.assertTrue(graph3560Page.getSessionDetails(SessionTileDetail.ENDUSER).getText().equals(sesionTileCheck.get(SessionTileDetail.ENDUSER)));
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority=16,groups= {Graph.GRAPHDEV})
	public void validateAssetGroupOnDetailPage()
	{
		try 
		{
			Assert.assertTrue(sessionTileValue.contains((graph3560Page.getSessionDetails(SessionTileDetail.ASSETGROUP).getText())));

			//Assert.assertTrue(graph3560Page.getSessionDetails(SessionTileDetail.ASSETGROUP).getText().equals(sesionTileCheck.get(SessionTileDetail.ASSETGROUP)));
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority=17,groups= {Graph.GRAPHDEV})
	public void validateAssetOnDetailPage()
	{
		try 
		{
			Assert.assertTrue(sessionTileValue.contains((graph3560Page.getSessionDetails(SessionTileDetail.ASSET).getText())));

			//Assert.assertTrue(graph3560Page.getSessionDetails(SessionTileDetail.ASSET).getText().equals(sesionTileCheck.get(SessionTileDetail.ASSET)));
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
	@Test(priority=18,groups= {Graph.GRAPHDEV})
	public void validateGatewayNameONDetailPage()
	{
		try 
		{
			Assert.assertTrue(sessionTileValue.contains((graph3560Page.getSessionDetails(SessionTileDetail.GATEWAYNAME).getText())));

			//Assert.assertTrue(graph3560Page.getSessionDetails(SessionTileDetail.GATEWAYNAME).getText().equals(sesionTileCheck.get(SessionTileDetail.GATEWAYNAME)));
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
	//****************** Edit Session Setup Test Cases Start Here  *********************//
	
	@Test(priority=19,groups= {Graph.GRAPHDEV})
	public void validateEditSessionSetupPopup()
	{
		try 
		{
			graph3560Page.navigateToSessionSetup();
			Assert.assertTrue(graph3560Page.getSessionDetails(SessionTileDetail.EDITSESSION).isDisplayed());
			//gestureUtils.getActionsWebObject().sendKeys(Keys.ESCAPE).build().perform();
			graph3560Page.clickOnCancelButton();
			
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
	@Test(priority=20,groups= {Graph.GRAPHDEV})
	public void validateSessionSetupWithAccelerationFahrehniet()
	{
		try 
		{
			//graph3560Page.navigateToSessionSetup();
			graph3560Page.editSessionSetup(FCCM3560.aboveVibrationUnit,FCCM3560.graphFarenhietUnit);
			CommonUtils.wait(3);
			Assert.assertTrue(graph3560Page.getSessionDetails(SessionTileDetail.LEFTGRAPHUNIT).getText().equals(FCCM3560.vibrationUnit)&& graph3560Page.getSessionDetails(SessionTileDetail.RIGHTGRAPHUNIT).getText().equals(FCCM3560.tempratureUnitFarenightWeb));
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority=21,groups= {Graph.GRAPHDEV})
	public void validateSessionSetupWithAccelerationCelsius()
	{
		try 
		{
			//graph3560Page.navigateToSessionSetup();
			graph3560Page.editSessionSetup(FCCM3560.aboveVibrationUnit,FCCM3560.graphCelsiusUnit);
			CommonUtils.wait(3);
			Assert.assertTrue(graph3560Page.getSessionDetails(SessionTileDetail.LEFTGRAPHUNIT).getText().equals(FCCM3560.vibrationUnit)&& graph3560Page.getSessionDetails(SessionTileDetail.RIGHTGRAPHUNIT).getText().equals(FCCM3560.tempratureUnitCelsiusWeb));
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority=22,groups= {Graph.GRAPHDEV})
	public void validateSessionSetupWithInsFahrehniet()
	{
		try 
		{
			//graph3560Page.navigateToSessionSetup();
			graph3560Page.editSessionSetup(FCCM3560.belowVibrationUnit,FCCM3560.graphFarenhietUnit);
			CommonUtils.wait(3);
			Assert.assertTrue(graph3560Page.getSessionDetails(SessionTileDetail.LEFTGRAPHUNIT).getText().equals(FCCM3560.vibrationUnitWeb)&& graph3560Page.getSessionDetails(SessionTileDetail.RIGHTGRAPHUNIT).getText().equals(FCCM3560.tempratureUnitFarenightWeb));
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
	@Test(priority=23,groups= {Graph.GRAPHDEV})
	public void validateSessionSetupWithInsCelsius()
	{
		try 
		{
			//graph3560Page.navigateToSessionSetup();
			graph3560Page.editSessionSetup(FCCM3560.belowVibrationUnit,FCCM3560.graphCelsiusUnit);
			CommonUtils.wait(3);
			Assert.assertTrue(graph3560Page.getSessionDetails(SessionTileDetail.LEFTGRAPHUNIT).getText().equals(FCCM3560.vibrationUnitWeb)&& graph3560Page.getSessionDetails(SessionTileDetail.RIGHTGRAPHUNIT).getText().equals(FCCM3560.tempratureUnitCelsiusWeb));
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority=24,groups= {Graph.GRAPHDEV})
	public void validateSessionSetupWithMmsFahrehniet()
	{
		try 
		{
			//graph3560Page.navigateToSessionSetup();
			graph3560Page.editSessionSetup(FCCM3560.withinVibrationUnit,FCCM3560.graphFarenhietUnit);
			CommonUtils.wait(3);
			Assert.assertTrue(graph3560Page.getSessionDetails(SessionTileDetail.LEFTGRAPHUNIT).getText().equals(FCCM3560.vibrationUnitMmsWeb)&& graph3560Page.getSessionDetails(SessionTileDetail.RIGHTGRAPHUNIT).getText().equals(FCCM3560.tempratureUnitFarenightWeb));
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
	@Test(priority=25,groups= {Graph.GRAPHDEV})
	public void validateSessionSetupWithMmsCelsius()
	{
		try 
		{
			//graph3560Page.navigateToSessionSetup();
			graph3560Page.editSessionSetup(FCCM3560.withinVibrationUnit,FCCM3560.graphCelsiusUnit);
			CommonUtils.wait(3);
			Assert.assertTrue(graph3560Page.getSessionDetails(SessionTileDetail.LEFTGRAPHUNIT).getText().equals(FCCM3560.vibrationUnitMmsWeb)&& graph3560Page.getSessionDetails(SessionTileDetail.RIGHTGRAPHUNIT).getText().equals(FCCM3560.tempratureUnitCelsiusWeb));
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
//****************** Edit Session Setup Test Cases End Here  *********************//


	
	
	
	
//****************** Meta data Test cases start here ****************//
	
	@Test(priority=26,groups= {Graph.GRAPHDEV})
	public void validateXAxisLabelInMetaData()
	{
		try 
		{
			Assert.assertTrue(graph3560Page.getSessionDetails(SessionTileDetail.XAXISLABEL).getText().equals("X Axis"));
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	

	@Test(priority=27,groups= {Graph.GRAPHDEV})
	public void validateYAxisLabelInMetaData()
	{
		try 
		{
			Assert.assertTrue(graph3560Page.getSessionDetails(SessionTileDetail.YAXISLABEL).getText().equals("Y Axis"));
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	

	@Test(priority=28,groups= {Graph.GRAPHDEV})
	public void validateZAxisLabelInMetaData()
	{
		try 
		{
			Assert.assertTrue(graph3560Page.getSessionDetails(SessionTileDetail.ZAXISLABEL).getText().equals("Z Axis"));
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority=28,groups= {Graph.GRAPHDEV})
	public void validateMinLabelInMetaData()
	{
		try 
		{
			Assert.assertTrue(graph3560Page.getSessionDetails(SessionTileDetail.MINLABEL).getText().equals("MIN "));
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority=28,groups= {Graph.GRAPHDEV})
	public void validateMaxLabelInMetaData()
	{
		try 
		{
			Assert.assertTrue(graph3560Page.getSessionDetails(SessionTileDetail.MAXLABEL).getText().equals("MAX"));
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
	@Test(priority=29,groups= {Graph.GRAPHDEV})
	public void validateVibrationValueInMetaData()
	{
		try 
		{
			
			getMetaData.clear();
			getMetaData=graph3560Page.getVibrationValue();
			for(String vibrationVal:getMetaData)
			{
				vibrationVal = vibrationVal.substring(0, vibrationVal.indexOf(' '));
				Assert.assertTrue(CommonUtils.getDoubleValue(vibrationVal) >= 0.000 && CommonUtils.getDoubleValue(vibrationVal) < 3.001);
			}
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority=30,groups= {Graph.GRAPHDEV})
	public void validateVibrationUnitInMetaData()
	{
		try 
		{
			for(String vibrationVal:getMetaData)
			{
				Assert.assertTrue(vibrationVal.contains(FCCM3560.vibrationUnitInValue) || vibrationVal.contains(FCCM3560.vibrationUnit1InValue));
			}
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority=31,groups= {Graph.GRAPHDEV})
	public void validateTempratureValueInMetaData()
	{
		try 
		{
			
			getMetaData.clear();
			getMetaData=graph3560Page.getTempratureValue();
			for(String tempratureVal:getMetaData)
			{
				tempratureVal = tempratureVal.substring(0, tempratureVal.indexOf(' '));
				Assert.assertTrue(CommonUtils.getDoubleValue(tempratureVal) >= 0.0 && CommonUtils.getDoubleValue(tempratureVal) < 110.0);
			}
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
	@Test(priority=31,groups= {Graph.GRAPHDEV})
	public void validateTempratureUnitInMetaData()
	{
		try 
		{
			
			getMetaData.clear();
			getMetaData=graph3560Page.getTempratureValue();
			for(String tempratureVal:getMetaData)
			{
				Assert.assertTrue(tempratureVal.contains("°C") || tempratureVal.contains("℃") || tempratureVal.contains(FCCM3560.measurementValueTempratureUnitCelseiusAndroid) || tempratureVal.contains(FCCM3560.measurementValueTempratureUnitFarenightAndroid) || tempratureVal.contains(FCCM3560.measurementValueTempratureUnitCelseiusiOS) || tempratureVal.contains(FCCM3560.measurementValueTempratureUnitFarenightiOS));

				//Assert.assertTrue(CommonUtils.getDoubleValue(tempratureVal) >= 0.0 && CommonUtils.getDoubleValue(tempratureVal) < 110.0);
			}
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	

	@Test(priority=32,groups= {Graph.GRAPHDEV})
	public void validateDateValueInMetaData()
	{
		try 
		{
			
			getMetaData.clear();
			getMetaData=graph3560Page.getDateValue();
			for(String dateVal:getMetaData)
			{
				Assert.assertTrue(dateVal.contains("/"));
			}
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority=33,groups= {Graph.GRAPHDEV})
	public void validateTimeValueInMetaData()
	{
		try 
		{
			
			getMetaData.clear();
			getMetaData=graph3560Page.getDateValue();
			for(String timeVal:getMetaData)
			{
				Assert.assertTrue(timeVal.contains(":"));
			}
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
	@Test(priority=34,groups= {Graph.GRAPHDEV})
	public void validateZoomGraph()
	{
		try 
		{
			
			
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
	
}
