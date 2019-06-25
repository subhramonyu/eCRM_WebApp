package com.fluke.connect.app.testdata;

import org.testng.annotations.DataProvider;

public class FCCM3560 
{
	// **** FCCM3560 session configuration ****
		/*
		 * ******  Priority Range (136001 to 143000) ****** 
		 *  
		 *   Session end: 1 - 100 
		 *   Session setup: 300 to 800
		 *   Session List: 1000 to 1500
		 *   Session Detail Page: 1700 to 3800  { 1- 100(session Detail), 100 for each tab in graph }
		 *   Session Delete: 3950 To 4000
		 *   Developer test: 4000 to 4900
		 *   Performance / Security: 5000 to 7000
		 *   
		 *   ********* nocturne == FCCM3560  **********
		 * 
		 * The 'sessionStartTimestamp' variable hold the value which is base for identifying the desired session.
		 * 
		 * Value assignment to sessionStartTimestamp can be automatic or manual. 
		 * Automatic --> session set up followed by identifying the desired session
		 * Manual --> directly identifying the desired session
		 * In case of manual specification time stamp format should be as of (20-Oct-2017):-
		 * 
		 * iOS time stamp format --> "mm/dd/yyyy, hh:mm:ss"  --> sample --> "10/17/2017, 17:57:10", "01/06/2018 08:56:28" (17th, 16th Oct)
		 * android time stamp format --> "m/d/yy hh:mm:ss |" -->  sample --> "10/17/17 17:57:10 |", "1/6/18 08:56:28 |" (17th, 16th Oct)
		 * web time stamp format --> "mm/dd/yyyy h:mm:ss $"  --> sample --> "10/17/2017, 17:57:10 $", "01/06/2018 8:56:28 $" (17th, 16th Oct)
		 * 
		 * Variables XXXSessionStartTimestampXXX holds the time stamp for a particular deployment and for a particular geography.
		 *
		 * iOS -- Below Vibration, Out Of Alarm Temperature
		 * Android -- Out-of-Range Vibration Alarm, Below Temperature Alarm
		 * Web -- Above Vibration Alarm, Within Vibration Alarm, Above Temperature Alarm, Within Temperature Alarm
		 * 
		 */
	
	//active session
	public static String sessionStartTimestamp = "nocturneSessionStartTimestamp"; //common variable for both platforms
	public static String sessionStartTimestampValue = "04/12/2017 20:21:28 |";
	public static String iOSSessionStartTimestamp = "nocturneiOSSessionStartTimestamp"; //platform specific variables
	public static String androidSessionStartTimestamp = "nocturneAndroidSessionStartTimestamp";
	public static String activeIOSSessionStartTimestamp = "12/20/2017, 16:16:34";
	public static String activeAnsroidSessionStartTimestamp = "12/20/17 16:16:34 |";
	
	//completed session
	public static String completedSessionStartTimestamp = "nocturneCompletedSessionStartTimestamp";  //common variable for both platforms
	public static String completedSessionGivenStartTimestamp = "04/12/2017 20:21:28 |";
	public static String iOSCompletedSessionStartTimestamp = "nocturneiOSCompletedSessionStartTimestamp";
	public static String androidCompletedSessionStartTimestamp = "nocturneAndroidCompletedSessionStartTimestamp";
	
	//placeholder for time-stamp for all platforms
	public static String requiredSessionStartTimestamp;
	
	//gateway and sensor
	public static String[] sessionStatus = {"MONITORING IN PROGRESS", "SENSOR CONNECTION LOST", "GATEWAY CONNECTION LOST"};
	public static String gatewayName = "nocturneGatewayName";    //common variable if same gateway is being used while session setup
	public static String iOSGatewayName = "nocturneiOSGatewayName";   //platform specific gateway name
	public static String iOSCompletedSessionGatewayName = "nocturneiOSCompletedSessionGatewayName";
	public static String iOSGatewayNameValue = "Fluke 3502 Gateway (4BEC6)";
	public static String androidGatewayName = "nocturneAndroidGatewayName";
	public static String androidCompletedSessionGatewayName = "nocturneAndroidCompletedSessionGatewayName";
	public static String androidGatewayNameValue = "Fluke 3502 Gateway (4BEC6)";
	public static String[] androidSensorNameList = {"Fluke 3560 (xCEFC)"};
	public static String[] iOSSensorNameList = {"Fluke 3560 (xCEFC)"};
	public static String iOSSensorsCountAndType = String.valueOf(iOSSensorNameList.length)+" Vibration";
	public static String androidSensorsCountAndType = String.valueOf(androidSensorNameList.length)+" Vibration";
	
	//user and asset details
	public static String sessionStartUserName = "3561prod1";  //"ntt@yopmail.com";    
	public static String assetGroupNameOld = "Test Asset Group";
	public static String assetNameOld = "Test Asset";
	public static String testPointNameOld = "Test Asset";
	public static String assetGroupName = "3561"; // used during session setup and session verification
	public static String assetName = "Motor";
	public static String testPointName = "Motor";
	
	//public static String assetNameActiveSession = "Distribution Panel > L3 New";
	//public static String testPointNameActiveSession = "Distribution Panel > L3 New";
	
	public static String machineCategoryName = "Spindle – Machine Finishing";
	public static String[] sensorNameList = {"342A5"};
	public static String gatewayNameValue = "Fluke 3502 Gateway (C2AE5)";
	public static String networkName = "FC-Net";
	
	//session setup vibration unit
	public static String aboveVibrationUnit = "g";
	public static String belowVibrationUnit = "in/s";
	public static String withinVibrationUnit = "mm/s";
	public static String outofVibrationUnit = "mm/s";
	
	public static String aboveTempratureUnit = "C";
	public static String belowTempratureUnit = "F";
	public static String tempratureUnit = "F";
	public static String graphFarenhietUnit="°F";
	public static String graphCelsiusUnit="°C";
	
	public static String aboveVibrationThresholdValue = "0.001";
	public static String belowVibrationThresholdValue = "19.999";
	public static String withinVibrationLowerThresholdValue = "0.001";
	public static String withinVibrationUpperThresholdValue = "19.999";
	public static String outofVibrationLowerThresholdValue = "0.001";
	public static String outofVibrationUpperThresholdValue = "0.002";
	
	public static String aboveTempratureThresholdValue = "10";
	public static String belowTempratureThresholdValue = "200";
	
	//vibration unit, network template, machine learning message
	public static String vibrationUnit = "Acceleration - g";
	public static String vibrationUnitWeb = "Overall Vibration -in/s";
	public static String vibrationUnitMobile = "Overall Vibration - in/s";
	public static String vibrationUnitInValue = "g";
	public static String vibrationUnit1InValue = "in/s";
	public static String vibrationUnit2InValue = "mm/s";
	public static String vibrationUnitMmsWeb="Overall Vibration-  mm/s";
	
	public static String tempratureUnitPrefix = "Temperature -";
	public static String tempratureUnitCelsiusAndroid = "Temperature - ℃";
	public static String tempratureUnitFarenightAndroid = "Temperature - ℉";
	public static String tempratureUnitFarenightiOS = "Temperature - °F";
	public static String tempratureUnitCelsiusiOS = "Temperature - °C";
	public static String measurementValueTempratureUnitFarenightAndroid = "℉"; 
	public static String measurementValueTempratureUnitCelseiusAndroid = "℃";
	public static String measurementValueTempratureUnitFarenightiOS = "°F";
	public static String measurementValueTempratureUnitCelseiusiOS = "°C";
	public static String tempratureUnitFarenightWeb = "Temperature -°F";
	public static String tempratureUnitCelsiusWeb = "Temperature -°C";
	
	public final static String MACHINE_LEARNING_MESSAGE = "MACHINE LEARNING IN PROGRESS ALARMS DISABLED";
	
	// **** 3560 test suite name constants ****
	final public static String SESSION_SETUP_TESTS = "3560_session_setup_tests";
	final public static String SESSION_END_TESTS = "3560_session_end_tests";
	final public static String SESSION_DELETE_TESTS = "3560_session_delete_tests";
	final public static String SESSION_CONFIG_TESTS = "3560_session_config_tests";
	final public static String SESSION_LIST_TESTS = "3560_session_list_tests";
	final public static String SESSION_DETAIL_PAGE_TESTS = "3560_session_detail_page_tests";
	final public static String COMPLETED_SESSION_LIST_TESTS = "3560_completed_session_list_tests";
	final public static String COMPLETED_SESSION_DETAIL_PAGE_TESTS = "3560_completed_session_detail_page_tests";
	final public static String SESSION_VERIFICATION_TESTS = "3560_session_tests"; //for android and iOS
	final public static String SESSION_VERIFICATION_WEB_TESTS = "3560_session_tests_web";
	final public static String COMPLETED_SESSION_VERIFICATION_TESTS = "3560_completed_session_tests"; //for android and iOS
	final public static String COMPLETED_SESSION_VERIFICATION_WEB_TESTS = "3560_completed_session_tests_web";
	
	final public static String PROD_TESTS = "prod_tests_3560";
	final public static String PROD_WEB_TESTS = "prod_web_tests_3560";
	final public static String UAT_TESTS = "uat_tests_3560";
	final public static String UAT_WEB_TESTS = "uat_web_tests_3560";
	
	final public static String BZ_TESTS = "bz_tests";

	final public static String DEV_TESTS = "dev_tests";
	
	// BUG_AUTOMATION
	final public static String ANDROID_BUGS = "3561_android_bugs";
	final public static String IOS_BUGS = "3561_ios_bugs";
	final public static String WEB_BUGS = "3561_web_bugs";
	public static String gatewayNameInActiveSession = "Fluke 3502 Gateway (A7D8F)";
	public static String gateway = "Fluke 3502 Gateway (27674)";
	public static String gatewayNameInCompletedSession = "Fluke 3502 Gateway (560D0)";
	public static String gatewayNameForProvisioning = "Fluke 3502 Gateway (2AD10)";
	public static String gatewayAlreadyProvisoned ="Fluke 3502 Gateway (2E1F9)";
	public static String[] sensorName = {"53A35"};
	public static String[] sensorNameForProvisioning = {"4902B"};
	public static String[] sensorNameInAddSensor = {"CCD2D"};
	public static String assetGroupName1 = "Test"; // used during session setup and session verification
	public static String assetName1 = "4902B";
	public static String testPointName1 = "Motor";
	//

	@DataProvider(name = "alarmNotificationTestData")
	public Object[][] alarmNotificationTestData()
	{
		return new Object[][] 
	    {
			new Object[] {"Vibration Sensor"},
			new Object[] {"Vibration Level Change Alarm"},
			new Object[] {"A change in vibration signature may be indicative of a change in health state or a change in operating state while remaining unhealthy"},
		};
	}
	
	@DataProvider(name = "switchToOtherTabTestDataProd")
	public Object[][] switchToOtherTabTestDataProd()
	{
		return new Object[][] 
	    {
			new Object[] {"1H"},
			new Object[] {"8H"},
			new Object[] {"1W"},
			new Object[] {"3W"},
			new Object[] {"1W"},
			new Object[] {"8H"},
			new Object[] {"1H"},
		};
	}
	
	@DataProvider(name = "switchToOtherTabTestData")
	public Object[][] switchToOtherTabTestData()
	{
		return new Object[][] 
	    {
			new Object[] {"1H"},
			new Object[] {"8H"},
			new Object[] {"1W"},
			new Object[] {"3W"},
			new Object[] {"ALL"},
			new Object[] {"3W"},
			new Object[] {"1W"},
			new Object[] {"8H"},
			new Object[] {"1H"},
		};
	}
	
	public enum DataValues {
		WEB_GRAPH_UNIT_ACC("Acceleration -g"),
		WEB_GRAPH_UNIT_INS("Overall Vibration -in/s"),
		WEB_GRAPH_UNIT_MMS("Overall Vibration -mm/s"),
		
		WEB_GRAPH_UNIT_CEL("Temperature -°C"),
		WEB_GRAPH_UNIT_FAR("Temperature -°F"),
		
		WEB_VALUE_UNIT_ACC("g"),
		WEB_VALUE_UNIT_INS("in/s"),
		WEB_VALUE_UNIT_MMS("mm/s"),
		
		WEB_VALUE_UNIT_CEL("°C"),
		WEB_VALUE_UNIT_FAR("°F"),
		
		IOS_GRAPH_UNIT_ACC("Acceleration - g"), 
		ANDROID_GRAPH_UNIT_ACC("Acceleration - g"), 
		MOBILE_GRAPH_UNIT_INS("Overall Vibration - in/s"),
		MOBILE_GRAPH_UNIT_MMS("Overall Vibration - mm/s"),
		
		IOS_GRAPH_UNIT_CEL("Temperature - °C"),
		IOS_GRAPH_UNIT_FAR("Temperature - °F"),
		
		ANDROID_GRAPH_UNIT_CEL("Temperature - ℃"),
		ANDROID_GRAPH_UNIT_FAR("Temperature - ℉"),
		
		MOBILE_VALUE_UNIT_ACC("g"),
		MOBILE_VALUE_UNIT_INS("in/s"),
		MOBILE_VALUE_UNIT_MMS("mm/s"),
		
		IOS_VALUE_UNIT_CEL("C"),
		IOS_VALUE_UNIT_FAR("F"),
		
		ANDROID_VALUE_UNIT_CEL("℃"),
		ANDROID_VALUE_UNIT_FAR("℉"),
		
		
		;
	 
	    private String dataValue;
	 
	    DataValues(String dataValue) {
	        this.dataValue = dataValue;
	    }
	 
	    public String getValue() {
	        return dataValue;
	    }
	}
	

}
