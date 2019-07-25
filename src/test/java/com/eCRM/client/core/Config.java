package com.eCRM.client.core;

import java.util.HashMap;
import java.util.Map;


public class Config 
{
	

	
	// **** driver  name constants **** 
	final public static String CHROME_DRIVER = "Chrome";
	final public static String FIREFOX_DRIVER = "Firefox";
	final public static String IE_DRIVER = "InternetExploler";
	final public static String SAFARI_DRIVER = "Safari";
	
	// **** environment name constants *****

	final public static String PREPRODUCTION = "PreProduction";
	
	
	// ****  Test  suit Type name constants *****
	
	final public static String REGRESSION_TEST="regression_test";
	
	// *********** User Details ********************
	public enum UserDetails
	{
		FULLNAME,FIRST_NAME,LAST_NAME,ADDRESS,CITY,POSTCODE;
	}
	
	
	// ****** Time out Constant **********
	final public static int TIMEOUT_IN_SECONDS = 15;
	final public static int POLLING_TIME_IN_SECONDS = 1;
	

	
	// *********** file path **************
	public final static String DRIVER_PATH = CommonUtils.getUserCurrentDirectoryPath()+"/drivers";
	public final static String DEFAULT_DOWNLOAD_PATH = CommonUtils.getUserCurrentDirectoryPath()+"/Downloads";
	public final static String Env_Property = CommonUtils.getUserCurrentDirectoryPath()+"/PropertiesFiles/Environment.properties";
	
	
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
 	
	
	
	// ****** scroll direction *********	
	public enum ScrollDiection
	{
		RIGHT, LEFT, UP, DOWN, NEXT
	}
	

	
    public enum PropertiesFileType
	{
		MEASUREMENTS_PROPERTIES, ASSET_PROPERTIES, FCCM_PROPERTIES
	}
	
	
	
	
}
