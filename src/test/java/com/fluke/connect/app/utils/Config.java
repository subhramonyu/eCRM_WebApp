package com.fluke.connect.app.utils;

import java.util.HashMap;
import java.util.Map;

import com.fluke.connect.app.testdata.FCM;


public class Config 
{
	// **** Priority range guidelines ****
		/*
		 * For each feature priority range lies b/w "X to X + 6999" ( where X is a positive integer), which is further segregated into:-
		 * 
		 * QA Functional + Interopreability - 1 to 2000
		 * Web Services - 2001 to 3000
		 * Developer Tests - 3001 to 5000
		 * Performance Tests - 5001 to 6000
		 * Security Tests - 6001 to 7000 (if applicable)
		 * 
		 * Smoke Tests --> 301 to 800
		 * UAT Tests   --> 801 to 1300
		 * Full Tests  --> 1301 to 1800
		 * 
		 * 
		 * It's possible a UAT test lies in range of 1 to 1000 iff smoke test as it's being used in UAT test suite.
		 * 
		 * There should be a gap of range 1 to 4000 b/w two features in order to accommodate exceptions from below list
		 * 
		 *     ****************************     Priority range list:-    *************************************
		 * 
	     *     * Feature Name *					 * Gap Range *				* Feature Range *
		 *       
		 * 1)  Capture Measurements:-    		Gap: 1 to 4000, 				Feature: 4001 to 11000
		 * 2)  Settings Page:-           		Gap: 11001 to 15000, 		Feature: 15001 to 22000
		 * 3)  Assets Page:- 					Gap: 22001 to 26000, 		Feature: 26001 to 33000
		 * 4)  Work Order Page:- 				Gap: 33001 to 37000, 		Feature: 37001 to 44000
		 * 5)  Reports Page:- 					Gap: 44001 to 48000, 		Feature: 48001 to 55000
		 * 6)  Exports Page:- 					Gap: 55001 to 59000, 		Feature: 59001 to 66000
		 * 7)  Team Page:-				 		Gap: 66001 to 70000, 		Feature: 70001 to 77000
		 * 8)  Resource Center:- 				Gap: 77001 to 81000, 		Feature: 81001 to 88000
		 * 9)  Measurement History Page:- 		Gap: 88001 to 92000, 		Feature: 92001 to 99000
		 * 10) VATG:- 							Gap: 99001 to 103000, 		Feature: 103001 to 110000
		 * 11) 3540:- 							Gap: 110001 to 114000, 		Feature: 114001 to 121000
		 * 12) 3550:- 							Gap: 121001 to 125000, 		Feature: 125001 to 1320000
		 * 13) 3560:- 							Gap: 132001 to 136000, 		Feature: 136001 to 143000
		 * 14) Delete Tests:- 					Gap: 143001 to 147000,		Feature: 147001 to 154000
		 * 15) Create Account:-					Gap: 154001 to 158000,		Feature: 158001 to 165000
		 * 16) Eevee								Gap: 165001 to 169000,		Feature: 169001 to 176000
		 * 17) 174X Blondel 						Gap: 176001 to 180000,      Feature: 180001 to 187000 
		 * 18) Localization 						Gap: 187001 to 191000,      Feature: 191001 to 195000
		 *  
		 *  Any new / other features will be amended further in the above list.
		 *  
		 *  Enviornment Name: 
		 *  Dev   --> https://connect.dev.connect.fluke.com/
		 *  PreProduction  --> https://preprod.connect.fluke.com/
		 *  Production  --> https://connect.fluke.com/
		 *  Betas
		 */
	
	/*
	 *    ********************************* Maven Parameterized Test Run Command ***********************************
	 *    
	 *    Android: mvn surefire-report:report site -DgenerateReports=false  -Dsurefire.suiteXmlFiles=src/test/resources/android_feature.xml -Dtestname="Android Feature Name Tests" -Ddevice_name=SM-G920I -Dudid=1215fc6d0a652104 -Dplatform_version=7.2 -Dapp_install_flag=true -Dapp_location=/ele/android/elekra.apk -Denvironment_name=PreProduction -Duser_name=ntt@yopmail.com -Dpassword=ntt@yopmail.com -Dgroups="android_smoke_tests"
	 *    iOS Simulator: mvn surefire-report:report site -DgenerateReports=false  -Dsurefire.suiteXmlFiles=src/test/resources/ios_sim_feature.xml -Dtestname="iOS Simulator Feature Name Tests" -Ddevice_name=iPhone7 -Dplatform_version=10.1 -Dapp_install_flag=true -Dapp_location=/ele/ios/elekra.app -Denvironment_name=PreProduction -Duser_name=ntt@yopmail.com -Dpassword=ntt@yopmail.com -Dis_real_device=false -Dgroups="ios_smoke_tests"
	 *    iOS Device: mvn surefire-report:report site -DgenerateReports=false  -Dsurefire.suiteXmlFiles=src/test/resources/ios_sim_feature.xml -Dtestname="iOS Feature Name Tests" -Ddevice_name=iPhone6s -Dplatform_version=11.2 -Dapp_install_flag=true -Dapp_location=/ele/ios/elekra.app -Denvironment_name=PreProduction -Duser_name=ntt@yopmail.com -Dpassword=ntt@yopmail.com -Dis_real_device=true -Dudid=2796895a3cdfc088ad3b88cbd9e9b6e7ca45912e -Dgroups="3560_session_tests"
	 *    Web: mvn surefire-report:report site -DgenerateReports=false  -Dsurefire.suiteXmlFiles=src/test/resources/web_feature.xml -Dtestname="Web Feature Name Tests" -Dbrowser_name=Chrome -Durl=https://connect.fluke.com -Duser_name=ntt@yopmail.com -Dpassword=ntt@yopmail.com -Dgroups="web_smoke_tests" 
	 *     
	 */

	// **** driver name constants **** 
	final public static String IOS_DRIVER = "iOS";
	final public static String ANDROID_DRIVER = "Android";
	final public static String WEB_DRIVER = "Web";
	
	// **** browser name constants **** 
	final public static String CHROME = "Chrome";
	final public static String FIREFOX = "Firefox";
	final public static String SAFARI = "Safari";
	
	// **** environment name constants *****
	final public static String PRODUCTION = "Production";
	final public static String PREPRODUCTION = "PreProduction";
	final public static String DEVELOPMENT = "Dev";
	final public static String BETA = "Beta";
	
	// **** smoke, uat and full suite name constants
	final public static String ANDROID_UAT_TESTS = "android_uat_tests";
	final public static String ANDROID_FULL_TESTS = "android_full_tests";
	final public static String IOS_SMOKE_TESTS = "ios_smoke_tests";
	final public static String IOS_SMOKE_EXTENDED_TESTS = "ios_smoke_extende_tests";
	final public static String IOS_UAT_TESTS = "ios_uat_tests";
	final public static String IOS_FULL_TESTS = "ios_full_tests";
	final public static String WEB_SMOKE_TESTS = "web_smoke_tests";
	final public static String WEB_SMOKE_CM_TESTS = "web_smoke_cm_tests";
	final public static String WEB_SMOKE_EXTENDED_TESTS = "web_smoke_extended_tests";
	final public static String WEB_UAT_TESTS = "web_uat_tests";
	final public static String WEB_FULL_TESTS = "web_full_tests";
	final public static String UAT_TEST="uat_test";
	final public static String ASSET_UAT_TEST="asset_uat";
	final public static String REPORT_UAT_TEST="report_uat";
	
	
	// **** feature wise test suite name constants (non-condition monitoring)
	final public static String CAPTURE_MEASUREMENT_TESTS = "capture_measurement_tests";
	final public static String ASSET_NEW_TESTS = "asset_tests";
	final public static String TEST_ASSET="analysis";
	final public static String WORK_ORDER_TESTS = "work_order_tests";
	final public static String WORK_ORDER_WEB_TESTS = "work_order_web_tests";
	final public static String REPORT_TESTS = "report_tests";
	final public static String REPORT_TESTS_WEB = "report_tests_web";
	final public static String MEASUREMENT_HISTORY_TESTS = "measurement_history_tests";
	final public static String TEAM_TESTS = "team_tests";
	final public static String TEAM_TESTS_WEB = "team_tests_web";
	final public static String RESOURCE_CENTER_TESTS = "resource_center_tests";
	final public static String SETTINGS_TESTS = "settings_tests";
	final public static String WORK_ORDER_805_TESTS = "work_order_805_tests";
	final public static String FC_805_TESTS = "805_tests";
	final public static String CAPTURE_MEASUREMENT_RELIABILTY_TESTS = "capture_measurement_reliability_tests";
	final public static String EEVEE_MEASUREMENT_ANDROID_TESTS = "eevee_android_tests";
	final public static String EEVEE_MEASUREMENT_IOS_TESTS = "eevee_ios_tests";
	final public static String TI_FCM = "ti_tests";
	final public static String TI_FCM_CAPTURE_ANDROID = "ti_capture_android_tests";
	final public static String TI_FCM_CAPTURE_IOS = "ti_capture_ios_tests";
	final public static String TI_FCM_ANDROID = "ti_tests_android";
	final public static String TI_FCM_IOS = "ti_tests_ios";
	final public static String TI_FCM_WEB = "ti_tests_web";
	final public static String CNX = "cnx_tests";
	final public static String CNX_CAPTURE_ANDROID = "cnx_capture_android_tests";
	final public static String CNX_CAPTURE_IOS = "cnx_capture_ios_tests";
	final public static String CNX_CAPTURE_ANDROID_1 = "cnx_capture_android_tests_1";
	final public static String CNX_CAPTURE_IOS_1 = "cnx_capture_ios_tests_1";
	final public static String CNX_ANDROID = "cnx_tests_android";
	final public static String CNX_IOS = "cnx_tests_ios";
	final public static String CNX_WEB = "cnx_tests_web";
	final public static String SIGNIN = "signin";
	final public static String FC1555 = "fc1555";
	final public static String FC1664 = "fc1664";
	final public static String FC1555_ANALYSIS = "fc1555_analysis";
	final public static String FC1555_WEB = "fc1555_web";
	final public static String FC1555_UAT = "fc1555_uat";
	final public static String ASSET_ANDROID_UAT = "android_asset_uat";
	final public static String VOC_WO = "voc_wo";
	final public static String WORK_ORDER_IOS_TESTS = "work_order_ios_tests";
	final public static String LOCALIZATION_TESTS = "localization_tests";
	final public static String ANDROID_BUG_AUTOMATION = "android_Bug_Automation";
	final public static String TEMP = "temp";


	// **** 3540 test suite name constants 
	final public static String FCCM_3540_TESTS = "3540_tests";
	
	// **** 3550 test suite name constants 
	final public static String FCCM_3550_TESTS = "3550_tests";
	final public static String FCCM_3550_SESSION_VERIFICATION_TESTS = "3550_session_tests"; //for android and iOS
	final public static String FCCM_3550_SESSION_VERIFICATION_WEB_TESTS = "3550_session_tests_web";
	final public static String FCCM_3550_SESSION_CONFIG_TESTS = "3550_session_config_tests";
	
	final public static String TEMP_TAG = "temp_tag";
	final public static String JENKINS_TO_QMETRY_MAPPING = "jenkins_to_qmetry_mapping";
	final public static String JIRA_TEST_RUN_AUTOMATION = "jira_test_run_automation";
	
	// **** measurement history attributes ****
    public static String[] measurementHistoryAssetList = {"Ungrouped Assets", "Distribution Panel", "L3"};  //asset group name --> asset name --> test point name
    
    // **** shared attributes ****
    public static String measurementWorkOrderToBeAssignedTitle = "Automation tests work order";
	public static String measurementAssignedWorkOrderNumber = "00002";
	public static String measurementReAssignedWorkOrderNumber = "00001";
	public static String measurementReAssignedWorkOrder = "Sample Work Order - Insulation Testing for Motor A (00001)";
	public static String measurementTextNoteText = "note";
	public static int measurementRecordingDuration = 5;

	// Condition Monitoring solution name list
	public static String[] conditionMonitoringSolutionNameList = {"Gateway & Sensors", "3-Phase Power Monitor", "Vibration Sensors", "Thermal Imaging Sensors"};
	
	// properties file path
	public final static String FCCM_PROPERTIES_FILE_PATH = CommonUtils.getUserHomeDirectoryPath()+"/UAF/properties/fccm.properties";
	public final static String FCCM_PROPERTIES_FILE_PATH_PROD = CommonUtils.getUserHomeDirectoryPath()+"/UAF/properties/fccm_prod.properties";
	public final static String FCCM_PROPERTIES_FILE_PATH_DEV = CommonUtils.getUserHomeDirectoryPath()+"/UAF/properties/fccm_dev.properties";
	
	public final static String EXISTING_FCCM_PROPERTIES_FILE_PATH = CommonUtils.getUserHomeDirectoryPath()+"/UAF/properties/fccm_existing.properties";
	public final static String EXISTING_FCCM_PROPERTIES_FILE_PATH_PROD = CommonUtils.getUserHomeDirectoryPath()+"/UAF/properties/fccm_prod_existing.properties";
	public final static String EXISTING_FCCM_PROPERTIES_FILE_PATH_DEV = CommonUtils.getUserHomeDirectoryPath()+"/UAF/properties/fccm_dev_existing.properties";
	
	
	// **** 3540 test suite name constants ****
	
	//Preprod account constants
	public final static String Android_PreProd_PQ3540_EneryStudy_3PhaseWye_sessionTime ="2/15/18 11:56:14 | android_fullsuite@yopmail.com android_fullsuite@yopmail.com";
	public final static String Android_Dev_PQ3540_EneryStudy_3PhaseWye_sessionTime ="2/5/18 14:44:30 | Android Dev Dev";
	
	// **** 3550 test suite name constants ****
	
	//Preprod account constants
	public final static String Android_PreProd_TM3550_sessionTime ="2/14/18 18:24:38 | android_fullsuite@yopmail.com android_fullsuite@yopmail.com";
	public final static String Android_Dev_TM3550_sessionTime ="2/7/18 22:10:43 | Android Dev Dev";
	
	//Uat suite feature wise
	public final static String WORK_ORDER_UAT="work_order_uat";
	
	//Extended smoke
	public final static String IOS_WO_SMOKE_EXT_TESTS = "ios_wo_smoke_extended_tests";
	public final static String IOS_ASSET_SMOKE_EXT_TESTS = "ios_asset_smoke_extended_tests";
	public final static String IOS_3540_SMOKE_EXT_TESTS = "ios_3540_smoke_extended_tests";
	public final static String IOS_REPORT_SMOKE_EXT_TESTS = "ios_report_smoke_tests";
	public final static String IOS_3560_SMOKE_EXT_TESTS = "ios_3560_smoke_extended_tests";
	public final static String IOS_3550_SMOKE_EXT_TESTS = "ios_3550_smoke_extended_tests";
	public final static String IOS_1555_SMOKE_EXT_TESTS = "ios_1555_smoke_tests";
	public final static String WO_WEB_SMOKE_EXT_TESTS = "wo_web_smoke_ext_tests";
	
// Android Extended Smoke Test
	final public static String ANDROID_SMOKE_TESTS = "android_smoke_tests";
	final public static String ANDROID_SMOKE_EXTENDED_TESTS = "android_smoke_extended_tests";
	final public static String ANDROID_FC1555_EXT_SMOKE_TESTS = "fc1555_ext_smoke_tests";
	final public static String ANDROID_REPORT_EXT_SMOKE_TESTS = "report_ext_smoke_tests";
	public final static String ANDROID_WO_SMOKE_EXT_TESTS = "wo_smoke_extended_tests";
	public final static String ANDROID_ASSET_SMOKE_EXT_TESTS = "asset_smoke_extended_tests";

	// Web Extended Smoke Test
	
	final public static String WEB_SMOKE_ASSET_EXTENDED="web_smoke_ext_assets";
	final public static String WEB_SMOKE_ASSET_EXTENDED_REMOVE="web_smoke_ext_assets1";
	
	
	//Automation 3560
	final public static String Android_Bug_Automation="android_Bug_Automation";

	
	public enum LocatorStrategy
	{

		ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ANDROID_LOCATOR_STRATEGY_TEXT, ANDROID_LOCATOR_STRATEGY_ID,ANDROID_LOCATOR_STRATEGY_XPATH_WITH_TEXT_VIEW,
		ANDROID_LOCATOR_STRATEGY_XPATH, ANDROID_LOCATOR_STRATEGY_TEXT_STARTS_WITH,
		
		IOS_LOCATOR_STRATEGY_ID, IOS_LOCATOR_STRATEGY_VALUE, IOS_LOCATOR_STRATEGY_NAME, IOS_LOCATOR_STRATEGY_NAME_CONTAINS,


		IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, IOS_LOCATOR_STRATEGY_LABEL, IOS_LOCATOR_STRATEGY_XPATH_NAME_ANCESTOR_CELL,
		IOS_LOCATOR_STRATEGY_VALUE_ENDS_WITH,

		IOS_LOCATOR_STRATEGY_XPATH_STARTS_WITH_ANCESTOR_CELL,IOS_LOCATOR_STRATEGY_XPATH_NAME_CELL,
		IOS_LOCATOR_STRATEGY_PREDICATE_STRING, IOS_LOCATOR_STRATEGY_XPATH, IOS_LOCATOR_STRATEGY_CLASS_NAME, IOS_LOCATOR_STRATEGY_NAME_BEGINSWITH,
		IOS_LOCATOR_STRATEGY_NAME_ENDSWITH,

		
		WEB_LOCATOR_STRATEGY_ID, WEB_LOCATOR_STRATEGY_CSS, WEB_LOCATOR_STRATEGY_CSS_INPUT_DATA_FEATURE,
		WEB_LOCATOR_STRATEGY_XPATH, WEB_LOCATOR_STRATEGY_XPATH_TEXT, WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS, WEB_LOCATOR_STRATEGY_XPATH_SPAN_TEXT_CONTAINS,
		WEB_LOCATOR_STRATEGY_XPATH_TEXT_CONTAINS,
		
		NONE 
	}
	
	// **** element locator strategies constants ****
	public final static String ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS = "textContains";
	public final static String ANDROID_LOCATOR_STRATEGY_TEXT = "text";
	public final static String ANDROID_LOCATOR_STRATEGY_ID = "id";
	public final static String IOS_LOCATOR_STRATEGY_ID = "id";
	public final static String IOS_LOCATOR_STRATEGY_VALUE = "value";
	public final static String IOS_LOCATOR_STRATEGY_NAME = "name";
	public final static String IOS_LOCATOR_STRATEGY_VALUE_CONTAINS = "valueContains";
	public static final String IOS_LOCATOR_STRATEGY_LABEL = "label";
	public static final String IOS_LOCATOR_STRATEGY_XPATH_NAME_ANCESTOR_CELL = "name";
	public static final String IOS_LOCATOR_STRATEGY_XPATH_STARTS_WITH_ANCESTOR_CELL = "name";
	public final static String WEB_LOCATOR_STRATEGY_ID = "id";
	public final static String WEB_LOCATOR_STRATEGY_CSS = "css";
	public final static String WEB_LOCATOR_STRATEGY_XPATH = "xpath";
	public final static String WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS = "xpath_div_text_contains";
	public final static String WEB_LOCATOR_STRATEGY_XPATH_SPAN_TEXT_CONTAINS = "xpath_span_text_contains";

	//****** STRESS TEST FOR FEATURE ********//
	
	final public static String WORK_ORDER_STRESS_TESTS = "work_order_stress_tests";
	
   
    // ***** QMETRY PROPERTIES FILE PATH *****
    public final static String QMETRY_PROPERTIES_FILE_PATH = "./qmetry.properties";
    
    // **** seprators in session start time stamp ****  Common Across different FCCM solutions
 	final public static String ANDROID_DATE_SEPRATOR = "|";
 	final public static String IOS_DATE_SEPRATOR = ",";

 	final public static String IOS_DATE_FORMAT = "MM/dd/yyyy"; //date format for each platform depends on its language and region, this format is for English - US, also applicable to web
 	final public static String ANDROID_DATE_FORMAT = "M/d/yy"; //date format for each platform depends on its language and region, this format is for English - US,
 	final public static String MOBILE_TIME_FORMAT = "HH:mm";  // Applicable to both iOS and Android
 	final public static String WEB_DATE_FORMAT = "MM/dd/yyyy";
 	final public static String WEB_TIME_FORMAT = "H:mm";
 	final public static String SENSORS_STATIC_TEXT = "Sensors";
 	final public static String START_TIME_STATIC_TEXT = "Start Time";   //for android and iOS apps
	final public static String START_STATIC_TEXT = "Start :";     //for web app
	final public static String ASSET_STATIC_TEXT = "Assets";   //used while session verification

 	final public static String iOSDateFormat = "MM/dd/yyyy"; //date format for each platform depends on its language and region, this format is for English - US, also applicable to web
 	final public static String iOSDateFormatForMeasurements = "MM/dd/yy";
 	final public static String androidDateFormat = "M/d/yy"; //date format for each platform depends on its language and region, this format is for English - US,
 	final public static String mobileTimeFormat = "HH:mm:ss";  // Applicable to both iOS and Android
 	final public static String webDateFormat = "MM/dd/yyyy";
 	final public static String webTimeFormat = "H:mm:ss";
 	public static String sensorsStaticText = "Sensors";
 	public static String startTimeStaticText = "Start Time";   //for android and iOS apps
	public static String startStaticText = "Start :";     //for web app
	public static String assetStatictText = "Assets";   //used while session verification
	
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
	}
	
	public static enum PhoneNameList
	{
		IPHONE("iPhone"),
		IPHONE6S("iPhone 6s"),
		NOTE5("SM-N9208"),
		S7("SM-G920I");
		
		private String attributeValue;

	    PhoneNameList(String attributeValue) 
	    {
	        this.attributeValue = attributeValue;
	    }

	    public String getAttributeValue() 
	    {
	        return attributeValue;
	    }
	}
}
