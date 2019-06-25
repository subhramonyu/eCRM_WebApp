package com.fluke.connect.app.functional.client.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fluke.connect.app.functional.client.pages.FCCM3540ActiveMonitoringSessionPage;

import io.restassured.RestAssured;

public class FCCM3540ActiveMonitoringSessionsTests 
{
	private FCCM3540ActiveMonitoringSessionPage activeMonitoringSessionPage;
	
	@BeforeClass(groups= {"y"})
	public void init()
	{
		RestAssured.baseURI = "https://streaming.preprod.connect.fluke.com";
		activeMonitoringSessionPage = new FCCM3540ActiveMonitoringSessionPage();
	}
	
	@Test(groups= {"y"})
	public void createSession()
	{
		//activeMonitoringSessionPage.startRemoteMonitoringSessionThroughWebServices();
		//activeMonitoringSessionPage.addDataToActiveSessionThroughWebServices();
		activeMonitoringSessionPage.endActiveSessionThroughWebServices();
	}


}
