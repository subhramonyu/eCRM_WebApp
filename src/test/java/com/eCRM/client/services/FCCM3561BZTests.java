package com.eCRM.client.services;

import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.eCRM.client.testdata.FCCM3560;
import com.eCRM.client.utils.CommonUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.time.Instant;
import java.util.List;

public class FCCM3561BZTests 
{
	private String startDate;
 	private String endDate;
 	private String beaconID;
 	private String BZID;
 	private String projectID;
 	private String tempValue;
 	private Response response;
 	List<Float> velocityList;
 	
 	@Parameters({"baseURI", "beaconID", "BZID", "projectID", "tempValue"})
 	@BeforeClass(groups = {"z", FCCM3560.BZ_TESTS})
 	public void init(String baseURI, String beaconID, String BZID, String projectID, String tempValue) {
 		RestAssured.baseURI = baseURI;
 		RestAssured.basePath = "/portal/papis/v1";
 		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
 		this.beaconID = beaconID;
 		this.BZID = BZID;
 		this.projectID = projectID;
 		this.tempValue = tempValue;
 	}
 	
 	/*
 	 * 1H = 60  -- 1m
 	 * 8H = 480 -- 1m
 	 * 1W = 168 -- 1H
 	 * 3W = 504 -- 1H
 	 * ALL = 82 -- 1d
 	 */
 	
 	@Test(priority = 200001,  groups = {FCCM3560.BZ_TESTS})
 	public void velocityValueTestXAxis() {
 		response = null;
 		startDate = null;
 		endDate = null;
 		startDate = Instant.now().minusSeconds(3600).toString();
 		endDate = Instant.now().toString();
 		response = given().
 							param("beaconId", beaconID).
 							param("format", "json").
 							param("interval", "1m").
 							param("startDate", startDate).
 							param("endDate", endDate).
 							header("BZID", BZID).
 							header("content-Type", "application/json").
 					when().	
 							get("/history/metric/aggregate/"+projectID).
 					then().
 							extract().response();
 		velocityList = response.path("xvrmsAvg");
 		boolean flag = false;
 		int counter = 0;
 		for(Float value: velocityList) {
 			if(value > 0.0) {
 				flag = true;
 				counter++;
 			}	
 		}
 		CommonUtils.print("Velocity xAxis data points Counter in 1H tab: "+counter);
 		Assert.assertTrue(flag && counter >= 15 && counter <= 55);
 	}
 	
 	@Test(priority = 200002,  groups = {FCCM3560.BZ_TESTS})
 	public void velocityValueTestYAxis() {
 		if(!velocityList.isEmpty())
 			velocityList.clear();
 		velocityList = response.path("yvrmsAvg");
 		boolean flag = false;
 		int counter = 0;
 		for(Float value: velocityList) {
 			if(value > 0.0) {
 				flag = true;
 				counter++;
 			}	
 		}
 		CommonUtils.print("Velocity yAxis data points Counter in 1H tab: "+counter);
 		Assert.assertTrue(flag && counter >= 15 && counter <= 50);
 	}
 	
 	@Test(priority = 200003,  groups = {FCCM3560.BZ_TESTS})
 	public void velocityValueTestZAxis() {
 		if(!velocityList.isEmpty())
 			velocityList.clear();
 		velocityList = response.path("zvrmsAvg");
 		boolean flag = false;
 		int counter = 0;
 		for(Float value: velocityList) {
 			if(value > 0.0) {
 				flag = true;
 				counter++;
 			}	
 		}
 		CommonUtils.print("Velocity zAxis data points Counter in 1H tab: "+counter);
 		Assert.assertTrue(flag && counter >= 15 && counter <= 55);
 	}
 	
 	@Test(priority = 200004,  groups = {FCCM3560.BZ_TESTS})
 	public void accelrationValueTestXAxis() {
 		if(!velocityList.isEmpty())
 			velocityList.clear();
 		velocityList = response.path("xhsRmsAvg");
 		boolean flag = false;
 		int counter = 0;
 		for(Float value: velocityList) {
 			if(value > 0.0) {
 				flag = true;
 				counter++;
 			}	
 		}
 		CommonUtils.print("Accelration xAxis data points Counter in 1H tab: "+counter);
 		Assert.assertTrue(flag && counter >= 15 && counter <= 55);
 	}
 	
 	@Test(priority = 200005,  groups = {FCCM3560.BZ_TESTS})
 	public void accelrationValueTestYAxis() {
 		if(!velocityList.isEmpty())
 			velocityList.clear();
 		velocityList = response.path("yhsRmsAvg");
 		boolean flag = false;
 		int counter = 0;
 		for(Float value: velocityList) {
 			if(value > 0.0) {
 				flag = true;
 				counter++;
 			}	
 		}
 		CommonUtils.print("Accelration yAxis data points Counter in 1H tab: "+counter);
 		Assert.assertTrue(flag && counter >= 15 && counter <= 55);
 	}
 	
 	@Test(priority = 200006,  groups = {FCCM3560.BZ_TESTS})
 	public void accelrationValueTestZAxis() {
 		if(!velocityList.isEmpty())
 			velocityList.clear();
 		velocityList = response.path("zhsRmsAvg");
 		boolean flag = false;
 		int counter = 0;
 		for(Float value: velocityList) {
 			if(value > 0.0) {
 				flag = true;
 				counter++;
 			}	
 		}
 		CommonUtils.print("Accelration zAxis data points Counter in 1H tab: "+counter);
 		Assert.assertTrue(flag && counter >= 15 && counter <= 55);
 	}
 	
 	@Test(priority = 200007,  groups = {"z", FCCM3560.BZ_TESTS})
 	public void tempratureValueTest() {
 		if(!velocityList.isEmpty())
 			velocityList.clear();
 		velocityList = response.path("tempAvg");
 		boolean flag = false;
 		int counter = 0;
 		for(Float value: velocityList) {
 			if(value > Double.parseDouble(tempValue)) {
 				flag = true;
 				counter++;
 			}	
 		}
 		CommonUtils.print("Temperature data points Counter: "+counter);
 		Assert.assertTrue(flag && counter >= 15);
 	}
 	
 	@Test(priority = 200010,  groups = {FCCM3560.BZ_TESTS})
 	public void velocityValueTestXAxis8HTab() {
 		response = null;
 		startDate = null;
 		endDate = null;
 		startDate = Instant.now().minusSeconds(28800).toString();
 		endDate = Instant.now().toString();
 		response = given().
 							param("beaconId", beaconID).
 							param("format", "json").
 							param("interval", "1m").
 							param("startDate", startDate).
 							param("endDate", endDate).
 							header("BZID", BZID).
 							header("content-Type", "application/json").
 					when().	
 							get("/history/metric/aggregate/"+projectID).
 					then().
 							extract().response();
 		velocityList = response.path("xvrmsAvg");
 		boolean flag = false;
 		int counter = 0;
 		for(Float value: velocityList)
 		{
 			if(value > 0.0)
 			{
 				flag = true;
 				counter++;
 			}	
 		}
 		CommonUtils.print("Velocity xAxis data points Counter in 8H tab: "+counter);
 		Assert.assertTrue(flag && counter >= 150 && counter <= 475);
 	}
 	
 	@Test(priority = 200011,  groups = {FCCM3560.BZ_TESTS})
 	public void velocityValueTestYAxis8HTab()
 	{
 		if(!velocityList.isEmpty())
 			velocityList.clear();
 		velocityList = response.path("yvrmsAvg");
 		boolean flag = false;
 		int counter = 0;
 		for(Float value: velocityList)
 		{
 			if(value > 0.0)
 			{
 				flag = true;
 				counter++;
 			}	
 		}
 		CommonUtils.print("Velocity yAxis data points Counter in 8H tab: "+counter);
 		Assert.assertTrue(flag && counter >= 150 && counter <= 475);
 	}
 	
 	@Test(priority = 200012,  groups = {FCCM3560.BZ_TESTS})
 	public void velocityValueTestZAxis8HTab()
 	{
 		if(!velocityList.isEmpty())
 			velocityList.clear();
 		velocityList = response.path("zvrmsAvg");
 		boolean flag = false;
 		int counter = 0;
 		for(Float value: velocityList)
 		{
 			if(value > 0.0)
 			{
 				flag = true;
 				counter++;
 			}	
 		}
 		CommonUtils.print("Velocity zAxis data points Counter in 8H tab: "+counter);
 		Assert.assertTrue(flag && counter >= 150 && counter <= 475);
 	}
 	
 	@Test(priority = 200013,  groups = {FCCM3560.BZ_TESTS})
 	public void accelrationValueTestXAxis8HTab()
 	{
 		if(!velocityList.isEmpty())
 			velocityList.clear();
 		velocityList = response.path("xhsRmsAvg");
 		boolean flag = false;
 		int counter = 0;
 		for(Float value: velocityList)
 		{
 			if(value > 0.0)
 			{
 				flag = true;
 				counter++;
 			}	
 		}
 		CommonUtils.print("Accelration xAxis data points Counter in 8H tab: "+counter);
 		Assert.assertTrue(flag && counter >= 150 && counter <= 475);
 	}
 	
 	@Test(priority = 200014,  groups = {FCCM3560.BZ_TESTS})
 	public void accelrationValueTestYAxis8HTab()
 	{
 		if(!velocityList.isEmpty())
 			velocityList.clear();
 		velocityList = response.path("yhsRmsAvg");
 		boolean flag = false;
 		int counter = 0;
 		for(Float value: velocityList)
 		{
 			if(value > 0.0)
 			{
 				flag = true;
 				counter++;
 			}	
 		}
 		CommonUtils.print("Accelration yAxis data points Counter in 8H tab: "+counter);
 		Assert.assertTrue(flag && counter >= 150 && counter <= 475);
 	}
 	
 	@Test(priority = 200015,  groups = {FCCM3560.BZ_TESTS})
 	public void accelrationValueTestZAxis8HTab()
 	{
 		if(!velocityList.isEmpty())
 			velocityList.clear();
 		velocityList = response.path("zhsRmsAvg");
 		boolean flag = false;
 		int counter = 0;
 		for(Float value: velocityList)
 		{
 			if(value > 0.0)
 			{
 				flag = true;
 				counter++;
 			}	
 		}
 		CommonUtils.print("Accelration zAxis data points Counter in 8H tab: "+counter);
 		Assert.assertTrue(flag && counter >= 150 && counter <= 475);
 	}
 	
 	@Test(priority = 200020,  groups = {"z", FCCM3560.BZ_TESTS})
 	public void velocityValueTestXAxis1WTab()
 	{
 		response = null;
 		startDate = null;
 		endDate = null;
 		startDate = Instant.now().minusSeconds(604800).toString();
 		endDate = Instant.now().toString();
 		response = given().
 							param("beaconId", beaconID).
 							param("format", "json").
 							param("interval", "1H").
 							param("startDate", startDate).
 							param("endDate", endDate).
 							header("BZID", BZID).
 							header("content-Type", "application/json").
 					when().	
 							get("/history/metric/aggregate/"+projectID).
 					then().
 							extract().response();
 		velocityList = response.path("xvrmsAvg");
 		boolean flag = false;
 		int counter = 0;
 		for(Float value: velocityList)
 		{
 			if(value > 0.0)
 			{
 				flag = true;
 				counter++;
 			}	
 		}
 		CommonUtils.print("Velocity xAxis data points Counter in 1W tab: "+counter);
 		Assert.assertTrue(flag && counter >= 10);
 	}
 	
 	@Test(priority = 200021,  groups = {FCCM3560.BZ_TESTS})
 	public void velocityValueTestYAxis1WTab()
 	{
 		if(!velocityList.isEmpty())
 			velocityList.clear();
 		velocityList = response.path("yvrmsAvg");
 		boolean flag = false;
 		int counter = 0;
 		for(Float value: velocityList)
 		{
 			if(value > 0.0)
 			{
 				flag = true;
 				counter++;
 			}	
 		}
 		CommonUtils.print("Velocity yAxis data points Counter in 1W tab: "+counter);
 		Assert.assertTrue(flag && counter >= 10 && counter <= 160);
 	}
 	
 	@Test(priority = 200022,  groups = {FCCM3560.BZ_TESTS})
 	public void velocityValueTestZAxis1WTab()
 	{
 		if(!velocityList.isEmpty())
 			velocityList.clear();
 		velocityList = response.path("zvrmsAvg");
 		boolean flag = false;
 		int counter = 0;
 		for(Float value: velocityList)
 		{
 			if(value > 0.0)
 			{
 				flag = true;
 				counter++;
 			}	
 		}
 		CommonUtils.print("Velocity zAxis data points Counter in 1W tab: "+counter);
 		Assert.assertTrue(flag && counter >= 10);
 	}
 	
 	@Test(priority = 200023,  groups = {FCCM3560.BZ_TESTS})
 	public void accelrationValueTestXAxis1WTab()
 	{
 		if(!velocityList.isEmpty())
 			velocityList.clear();
 		velocityList = response.path("xhsRmsAvg");
 		boolean flag = false;
 		int counter = 0;
 		for(Float value: velocityList)
 		{
 			if(value > 0.0)
 			{
 				flag = true;
 				counter++;
 			}	
 		}
 		CommonUtils.print("Accelration xAxis data points Counter in 1W tab: "+counter);
 		Assert.assertTrue(flag && counter >= 10);
 	}
 	
 	@Test(priority = 200024,  groups = {FCCM3560.BZ_TESTS})
 	public void accelrationValueTestYAxis1WTab()
 	{
 		if(!velocityList.isEmpty())
 			velocityList.clear();
 		velocityList = response.path("yhsRmsAvg");
 		boolean flag = false;
 		int counter = 0;
 		for(Float value: velocityList)
 		{
 			if(value > 0.0)
 			{
 				flag = true;
 				counter++;
 			}	
 		}
 		CommonUtils.print("Accelration yAxis data points Counter in 1W tab: "+counter);
 		Assert.assertTrue(flag && counter >= 10);
 	}
 	
 	@Test(priority = 200025,  groups = {FCCM3560.BZ_TESTS})
 	public void accelrationValueTestZAxis1WTab()
 	{
 		if(!velocityList.isEmpty())
 			velocityList.clear();
 		velocityList = response.path("zhsRmsAvg");
 		boolean flag = false;
 		int counter = 0;
 		for(Float value: velocityList)
 		{
 			if(value > 0.0)
 			{
 				flag = true;
 				counter++;
 			}	
 		}
 		CommonUtils.print("Accelration zAxis data points Counter in 1W tab: "+counter);
 		Assert.assertTrue(flag && counter >= 10 && counter <= 160);
 	}
 	
 	@Test(priority = 200050,  groups = {"z", FCCM3560.BZ_TESTS})
 	public void velocityValueTestXAxisAllTab()
 	{
 		response = null;
 		startDate = null;
 		endDate = null;
 		startDate = Instant.now().minusSeconds(1814400).toString();
 		endDate = Instant.now().toString();
 		response = given().
 							param("beaconId", beaconID).
 							param("format", "json").
 							param("interval", "1d").
 							param("startDate", startDate).
 							param("endDate", endDate).
 							header("BZID", BZID).
 							header("content-Type", "application/json").
 					when().	
 							get("/history/metric/aggregate/"+projectID).
 					then().
 							extract().response();
 		velocityList = response.path("xvrmsPeak");
 		boolean flag = false;
 		int counter = 0;
 		for(Float value: velocityList)
 		{
 			if(value > 0.0) {
 				flag = true;
 				counter++;
 			}	
 		}
 		CommonUtils.print("Velocity xAxis data points Counter in ALL tab: "+counter);
 		Assert.assertTrue(flag && counter >= 10);
 	}
 	
 	@Test(priority = 200051,  groups = {FCCM3560.BZ_TESTS})
 	public void velocityValueTestYAxisAllTab()
 	{
 		if(!velocityList.isEmpty())
 			velocityList.clear();
 		velocityList = response.path("yvrmsPeak");
 		boolean flag = false;
 		int counter = 0;
 		for(Float value: velocityList)
 		{
 			if(value > 0.0)
 			{
 				flag = true;
 				counter++;
 			}	
 		}
 		CommonUtils.print("Velocity yAxis data points Counter in ALL tab: "+counter);
 		Assert.assertTrue(flag && counter >= 10);
 	}
 	
 	@Test(priority = 200052,  groups = {FCCM3560.BZ_TESTS})
 	public void velocityValueTestZAxisAllTab()
 	{
 		if(!velocityList.isEmpty())
 			velocityList.clear();
 		velocityList = response.path("zvrmsPeak");
 		boolean flag = false;
 		int counter = 0;
 		for(Float value: velocityList)
 		{
 			if(value > 0.0)
 			{
 				flag = true;
 				counter++;
 			}	
 		}
 		CommonUtils.print("Velocity zAxis data points Counter in ALL tab: "+counter);
 		Assert.assertTrue(flag && counter >= 10);
 	}
 	
 	@Test(priority = 200053,  groups = {FCCM3560.BZ_TESTS})
 	public void accelrationValueTestXAxisAllTab()
 	{
 		if(!velocityList.isEmpty())
 			velocityList.clear();
 		velocityList = response.path("xhsRmsPeak");
 		boolean flag = false;
 		int counter = 0;
 		for(Float value: velocityList)
 		{
 			if(value > 0.0)
 			{
 				flag = true;
 				counter++;
 			}	
 		}
 		CommonUtils.print("Accelration xAxis data points Counter in ALL tab: "+counter);
 		Assert.assertTrue(flag && counter >= 10);
 	}
 	
 	@Test(priority = 200054,  groups = {FCCM3560.BZ_TESTS})
 	public void accelrationValueTestYAxisAllTab()
 	{
 		if(!velocityList.isEmpty())
 			velocityList.clear();
 		velocityList = response.path("yhsRmsPeak");
 		boolean flag = false;
 		int counter = 0;
 		for(Float value: velocityList)
 		{
 			if(value > 0.0)
 			{
 				flag = true;
 				counter++;
 			}	
 		}
 		CommonUtils.print("Accelration yAxis data points Counter in ALL tab: "+counter);
 		Assert.assertTrue(flag && counter >= 10);
 	}
 	
 	@Test(priority = 200055,  groups = {FCCM3560.BZ_TESTS})
 	public void accelrationValueTestZAxisAllTab()
 	{
 		if(!velocityList.isEmpty())
 			velocityList.clear();
 		velocityList = response.path("zhsRmsPeak");
 		boolean flag = false;
 		int counter = 0;
 		for(Float value: velocityList)
 		{
 			if(value > 0.0)
 			{
 				flag = true;
 				counter++;
 			}	
 		}
 		CommonUtils.print("Accelration zAxis data points Counter in ALL tab: "+counter);
 		Assert.assertTrue(flag && counter >= 10);
 	}

}
