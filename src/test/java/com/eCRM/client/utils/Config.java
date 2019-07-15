package com.eCRM.client.utils;

import java.util.HashMap;
import java.util.Map;


public class Config 
{
	

	// **** driver name constants **** 
	
	final public static String WEB_DRIVER = "Web";
	
	// **** browser name constants **** 
	final public static String CHROME = "Chrome";
	final public static String FIREFOX = "Firefox";
	final public static String SAFARI = "Safari";
	
	// **** environment name constants *****

	final public static String PREPRODUCTION = "PreProduction";
	
	
	// ****  Test  suit Type name constants *****
	
	final public static String REGRESSION_TEST="uat_test";
	
	
	
	
	
	

	
	// properties file path
	public final static String FCCM_PROPERTIES_FILE_PATH = CommonUtils.getUserHomeDirectoryPath()+"/UAF/properties/fccm.properties";
	public final static String FCCM_PROPERTIES_FILE_PATH_PROD = CommonUtils.getUserHomeDirectoryPath()+"/UAF/properties/fccm_prod.properties";
	public final static String FCCM_PROPERTIES_FILE_PATH_DEV = CommonUtils.getUserHomeDirectoryPath()+"/UAF/properties/fccm_dev.properties";
	
	public final static String EXISTING_FCCM_PROPERTIES_FILE_PATH = CommonUtils.getUserHomeDirectoryPath()+"/UAF/properties/fccm_existing.properties";
	public final static String EXISTING_FCCM_PROPERTIES_FILE_PATH_PROD = CommonUtils.getUserHomeDirectoryPath()+"/UAF/properties/fccm_prod_existing.properties";
	public final static String EXISTING_FCCM_PROPERTIES_FILE_PATH_DEV = CommonUtils.getUserHomeDirectoryPath()+"/UAF/properties/fccm_dev_existing.properties";
	
	
	
	
	
	public enum LocatorStrategy
	{

		WEB_LOCATOR_STRATEGY_ID, WEB_LOCATOR_STRATEGY_CSS, WEB_LOCATOR_STRATEGY_CSS_INPUT_DATA_FEATURE,
		WEB_LOCATOR_STRATEGY_XPATH, WEB_LOCATOR_STRATEGY_XPATH_TEXT, WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS, WEB_LOCATOR_STRATEGY_XPATH_SPAN_TEXT_CONTAINS,
		WEB_LOCATOR_STRATEGY_XPATH_TEXT_CONTAINS,
		
		NONE 
	}
	
	// **** element locator strategies constants ****
	public final static String WEB_LOCATOR_STRATEGY_ID = "id";
	public final static String WEB_LOCATOR_STRATEGY_CSS = "css";
	public final static String WEB_LOCATOR_STRATEGY_XPATH = "xpath";
	public final static String WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS = "xpath_div_text_contains";
	public final static String WEB_LOCATOR_STRATEGY_XPATH_SPAN_TEXT_CONTAINS = "xpath_span_text_contains";

    
    // **** seprators in session start time stamp **** 
 	final public static String WEB_DATE_FORMAT = "MM/dd/yyyy";
 	final public static String WEB_TIME_FORMAT = "H:mm";
 	
 	
	
    //   **** Reports Test Configuration *****
	final public static String reportsExpectedPDFFilePath = "./Files/reports/report.pdf";
	final public static String reportsExpectedImageDirectoryPath = "./Files/reports/images/expected/";
	final public static String reportsActualImageDirectoryPath = "./Files/reports/images/actual/";
	final public static String reportsDeviatedImageDirectoryPath = "./Files/reports/images/deviation/";
	final public static String reportsVisualComparisonImageDirectoryPath = "./Files/reports/visual_comparison/";
	
	// ***** Properties File Path *****
	public final static String PROPERTIES_FILE_PATH = "./properties/output.properties";
	public final static String ASSETS_PROPERTIES_FILE_PATH = "./properties/assets.properties";
	public final static String WORKORDERS_PROPERTIES_FILE_PATH = "./properties/workorders.properties";
	public static String FAILED_TESTS_SCREENSHOT_LOCATION = "./screenshots/failed_tests/mobile/";
	public static String PASSED_TEST_SCREENSHOT_LOCATION = "./screenshots/passed_tests/mobile/";

	// ****** Measurements Type ******
	public final static String SCALAR_MEASUREMENT = "Scalar";
	public final static String NON_SCALAR_MEASUREMENT = "NonScalar";
	public final static String GROUP_MEASUREMENT = "Group";
	public final static String RECORDED_MEASUREMENT = "Recorded";


	// **** Evvee configuration ****
	final public static String COACH_MARK_TEXT="Go ahead and add this measurement to an asset. You can then track the health of your asset over time.";
	final public static String EEVEEE_TOOL_NAME ="FLUKE 1550B";
	public static String[] eeveeCapturedMeasurementTimeStampInAndroid ={"3/8/18 20:48:04",""};
	public static String dateFormat = "Android";
	
	
	//** Wifi tools *****
	public final static String WIFI_TOOL_TESTS = "wifi_tool_tests";
	
	//** 125B (prism tool) tests
	public final static String WIFI_TOOL_125B_TESTS = "wifi_tool_125B_tests";
	
	//** 173X (Aron tool) tests
	public final static String WIFI_TOOL_173X_TESTS = "wifi_tool_173X_tests";
		
	public enum ScrollDiection
	{
		RIGHT, LEFT, UP, DOWN, NEXT, PREVIOUS, FLEXIBLE_UP, FLEXIBLE_DOWN
	}
	
	public final static int defaultScrollDownSteps = -75;
	public final static int defaultScrollUpSteps = 100;
	
	public static boolean appWidthCenterFlag = true;
	public static boolean useExistingPageSource = false;
	public static String iOSPageSource = null;
	public static boolean isDynamicPage = false;
	public static int maxScrollCounterForDynamicPage = 5;
	
	public static boolean isScrollCountFixed = false;
	public static int maxFixedScrollCount = 5;
	public static int maxFixedScrollCounter = 0;
	
	public static Map<String, String[]> eeveeeCaptureAndroidMeasurementDetails = new HashMap<String, String[]>();
    static 
    {
    	eeveeeCaptureAndroidMeasurementDetails.put("3/8/18 20:48:04", new String[] {"36","Test duration", "00:00:14","> 535","GΩ","535","V DC","< 1.00","nA DC","Unassigned",
    			"Test Conditions","Voltage","500 V AC","Ramp","Off","Time limit","00:01:00","Test Ended","By User","Calculated Results",
    			"Capacitance","0.00 µF","PI","Not available","DAR","Not available"});
    }
    
public static String[] eeveeCapturedMeasurementTimeStampInIos ={"03/08/18 20:48:04",""};
    
public static Map<String, String[]> eeveeeCaptureIosMeasurementDetails = new HashMap<String, String[]>();
    static 
    {
    	eeveeeCaptureIosMeasurementDetails.put("03/08/18 20:48:04", new String[] {"36","Test duration", "0:00:14","> 535 GΩ","535 V DC","< 1.00 nA DC","Unassigned","TEST CONDITIONS",
    			"Voltage","500 V AC","Ramp","Off","Time Limit","0:01:00","Test Ended","By User","CALCULATED RESULTS","Capacitance","PI","DAR","0.00 µF","Not Available","Not Available"});
    }
    
    public static final String SHARE_EMAIL_ADDRESS = "flukeidcat@gmail.com";

	
    public enum PropertiesFileType
	{
		MEASUREMENTS_PROPERTIES, ASSET_PROPERTIES, FCCM_PROPERTIES
	}
	
	public static String getPropertiesFilePath(PropertiesFileType propertyFileType)
	{/*
		switch(propertyFileType)
		{
		case MEASUREMENTS_PROPERTIES:
			if (DriverManager.getEnvironmentName().equals(Config.PRODUCTION)) {
				if (DriverManager.getUseExistingDataFlag())
					return FCM.EXISTING_MEASUREMENTS_PROPERTIES_FILE_PATH_PROD;
				else
					return FCM.MEASUREMENTS_PROPERTIES_FILE_PATH_PROD;
			} else if (DriverManager.getEnvironmentName().equals(Config.PREPRODUCTION)) {
				if (DriverManager.getUseExistingDataFlag())
					return FCM.EXISTING_MEASUREMENTS_PROPERTIES_FILE_PATH;
				else
					return FCM.MEASUREMENTS_PROPERTIES_FILE_PATH;
			} else if (DriverManager.getEnvironmentName().equals(Config.DEVELOPMENT)) {
				if (DriverManager.getUseExistingDataFlag())
					return FCM.EXISTING_MEASUREMENTS_PROPERTIES_FILE_PATH_DEV;
				else
					return FCM.MEASUREMENTS_PROPERTIES_FILE_PATH_DEV;
			}
		case FCCM_PROPERTIES:
			if (DriverManager.getEnvironmentName().equals(Config.PRODUCTION)) {
				if (DriverManager.getUseExistingDataFlag())
					return EXISTING_FCCM_PROPERTIES_FILE_PATH_PROD;
				else
					return FCCM_PROPERTIES_FILE_PATH_PROD;

			} else if (DriverManager.getEnvironmentName().equals(Config.PREPRODUCTION)) {
				if (DriverManager.getUseExistingDataFlag())
					return EXISTING_FCCM_PROPERTIES_FILE_PATH;
				else
					return FCCM_PROPERTIES_FILE_PATH;
			} else if (DriverManager.getEnvironmentName().equals(Config.DEVELOPMENT)) {
				if (DriverManager.getUseExistingDataFlag())
					return EXISTING_FCCM_PROPERTIES_FILE_PATH_DEV;
				else
					return FCCM_PROPERTIES_FILE_PATH_DEV;
			}
			default:
				return null;
		}
	*/
		return null;}
	
	
}
