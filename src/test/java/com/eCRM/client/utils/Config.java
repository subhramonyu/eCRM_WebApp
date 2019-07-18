package com.eCRM.client.utils;

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
	
	
	
	
	
	

	
	//  file path
	public final static String DRIVER_PATH = CommonUtils.getUserCurrentDirectoryPath()+"/driver";
	public final static String DEFAULT_DOWNLOAD_PATH = CommonUtils.getUserCurrentDirectoryPath()+"/Downloads";
	
	
	
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
 	
	
	
		
	public enum ScrollDiection
	{
		RIGHT, LEFT, UP, DOWN, NEXT, PREVIOUS, FLEXIBLE_UP, FLEXIBLE_DOWN
	}
	

	
    public enum PropertiesFileType
	{
		MEASUREMENTS_PROPERTIES, ASSET_PROPERTIES, FCCM_PROPERTIES
	}
	
	public static String getPropertiesFilePath(PropertiesFileType propertyFileType)
	{
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
	
		return null;}
	
	
}
