package com.fluke.connect.app.testdata;

import java.util.HashMap;
import java.util.Map;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;


public class FCM {
	
	public static boolean assetOnBoardFlag = true;
	public static boolean workOrderOnBoardFlag = true;
	public static boolean textNoteOnBoardFlag = true;
	public static boolean shareOnBoardFlag = true;
	public static boolean onBoardFlagBeforeSignIn = true;
	public static boolean onBoardFlagAfterSignIn = false;
	
	public static Map<String, String> captureMeasurementSimulatedDeviceNameList = new HashMap<String, String>();
	static 
    {
    	FCM.captureMeasurementSimulatedDeviceNameList.put("Beaker", "Fluke 1587 FC");
    	FCM.captureMeasurementSimulatedDeviceNameList.put("Beaker Real Device", "1587FC");
    	FCM.captureMeasurementSimulatedDeviceNameList.put("Hudson", "Hudson 1664 FC Volts");
    	FCM.captureMeasurementSimulatedDeviceNameList.put("Hudson Real Device", "1664FC");
    	FCM.captureMeasurementSimulatedDeviceNameList.put("V3000", "CNX3000");
    	FCM.captureMeasurementSimulatedDeviceNameList.put("Record Measurement", "Tulasi");
    	FCM.captureMeasurementSimulatedDeviceNameList.put("T3000", "CNX t3000");
    	FCM.captureMeasurementSimulatedDeviceNameList.put("Manual Measurement", "Measurement Manual Entry");
    	FCM.captureMeasurementSimulatedDeviceNameList.put("Vibration Meter", "Fluke 805FC");
    	FCM.captureMeasurementSimulatedDeviceNameList.put("V30002", "CNX3000");
    }
	
	// **** iOS Simulated Device List ****
	public static String[] iOSSimulatedDeviceList = {"Jeff's CNX3000", "Dave's CNX3000", "Carolyn's CNX3000", "Luke's CNX3000",
			                                         "Dan's CNX3000", "Barbara's CNX3000", "James' CNX3000", "Tulasi's CNX3000",
			                                         "Karen's CNX3000", "Dmitry's CNX t3000", "Whitney's CNX t3000"};
	
	// **** capture measurement attributes ****
	public static String[] captureMeasurementAssetList = {"Ungrouped Assets", "Motor", "Motor"};  //asset group name --> asset name --> test point name
	public static String[] captureMeasurementGroupMeasurementSimulatedDeviceNameList = {"CNX3000", "CNX t3000"};

	public final static String MEASUREMENTS_PROPERTIES_FILE_PATH = CommonUtils.getUserHomeDirectoryPath() + "/UAF/properties/measurements.properties";
	public final static String MEASUREMENTS_PROPERTIES_FILE_PATH_PROD = CommonUtils.getUserHomeDirectoryPath() + "/UAF/properties/measurements_prod.properties";
	public final static String MEASUREMENTS_PROPERTIES_FILE_PATH_DEV = CommonUtils.getUserHomeDirectoryPath() + "/UAF/properties/measurements_dev.properties";
	
	public final static String EXISTING_MEASUREMENTS_PROPERTIES_FILE_PATH = CommonUtils.getUserHomeDirectoryPath() + "/UAF/properties/measurements_existing.properties";
	public final static String EXISTING_MEASUREMENTS_PROPERTIES_FILE_PATH_PROD = CommonUtils.getUserHomeDirectoryPath() + "/UAF/properties/measurements_prod_existing.properties";
	public final static String EXISTING_MEASUREMENTS_PROPERTIES_FILE_PATH_DEV = CommonUtils.getUserHomeDirectoryPath() + "/UAF/properties/measurements_dev_existing.properties";

	
	public enum DeviceList
	{
		V3000("V300"),
		V3000_MEASUREMENT_UNIT("C"),  //mV 
		
		A3002("A3002"),
		A3002_MEASUREMENT_UNIT("DC"),  //A 
		
		T3000("T3000"),
		T3000_MEASUREMENT_UNIT("C"),
		
		A3000("A3000"),
		A3000_MEASUREMENT_UNIT("AC"), //A 
		
		FC369("369FC"),
		FC369_MEASUREMENT_UNIT("AC"), //mA 
		
		TI400WIFI("400"),
		TI("Thermal Imager"),
		ANDROID_TI_400("Thermal Imager 400"),
		TI_400("TI 400"),
		TI_400_DOWNLOAD("TI 400 Download"),
		TI_400_PASSWORD("password"),
		FC376("376FC"),
		FC376_MEASUREMENT_UNIT("AC"),  //V
		
		TI_450("TI 450"),
		TI_450_DOWNLOAD("TI 450 Download"),
		TI450WIFI("450"),
		ANDROID_TI_450("Thermal Imager 450"),
		
		TI_S65_DOWNLOAD("TI S65 Download"),
		TI_S65_WIFI("65"),
		ANDROID_TI_S65("Thermal Imager 65"),
		
		TI_S75_DOWNLOAD("TI S75 Download"),
		TI_S75_WIFI("75"),
		ANDROID_TI_S75("Thermal Imager 75"),
		
		ANDROID_TI_DOWNLOAD_START("0"),
		IOS_TI_DOWNLOAD_START("3"),
		TI_CAPTURE("TI_CAPTURE"),

		Fc279FC("279FC-Muse"),
		FC279FC_MEASUREMENT_UNIT("VDC"),
		FC279IR("279FC-Muse"),
		FC279IR_MEASUREMENT_UNIT("IR Camera"),//points to camera
		
		
		
		WEB_ASSET_HIERARCHY("Ungrouped Assets > Motor"),
		WEB_WORK_ORDER_NUMBER("00002)");
		
		private String attributeValue;

	    DeviceList(String attributeValue) 
	    {
	        this.attributeValue = attributeValue;
	    }

	    public String getAttributeValue() 
	    {
	        return attributeValue;
	    }
	}
	
	public enum MeasurementType 
	{
		SCALAR, NON_SCALAR, GROUP, RECORDED, TI, TI_DOWNLOAD,
	}
	
	public enum ShareFormat
	{
		TEXT, CSV, PDF, XLS, IS2, GRAPH;
	}
	
	public enum DataType
	{
		MEASUREMENT_DATA, RECORDED_DATA, THERMAL_IMAGES, TEXT_VOICE_NOTES, CAMERA_IMAGES;
	}
	
	public static boolean MEASUREMENT_DATE_LENGTH_FULL = false;
	
	public static void setDateLength(boolean lengthFlag)
	{
		if(lengthFlag)
			MEASUREMENT_DATE_LENGTH_FULL = true;
		else
			MEASUREMENT_DATE_LENGTH_FULL = false;
	}
	
	public static String getDateFormat(String driverName)
	{
		if(MEASUREMENT_DATE_LENGTH_FULL)
		{
			if(driverName.equals(Config.ANDROID_DRIVER))
				return "MM/d/yy HH:mm:ss";
			else if(driverName.equals(Config.IOS_DRIVER))
				return "MM/dd/yy HH:mm:ss";
			else if(driverName.equals(Config.WEB_DRIVER))
				return "MM/dd/yyyy H:mm:ss";
		}
		else
		{
			if(driverName.equals(Config.ANDROID_DRIVER))
				return "MM/d/yy h:mm";
			else if(driverName.equals(Config.IOS_DRIVER))
				return "MM/dd/yy HH:mm";
			else if(driverName.equals(Config.WEB_DRIVER))
				return "MM/dd/yyyy H:mm";
		}
		return null;
	}
	
	public enum SearchSortFilterAttributes {
		SORT_BY_ASSET("Asset"),
		SORT_BY_WORK_ORDER("Work Order"),
		SORT_BY_DATE("Date"),
		FILTER_MEASUREMENTS("Measurements Only"),
		FILTER_THERMAL_IMAGES("Thermal Images Only"),
		FILTER_3_PHASE("3-Phase Monitor Measurements"),
		SORT_BY_ASSET_VALUE("Distribution Panel"),
		SORT_BY_WORK_ORDER_VALUE_HEADER("Unassigned"),
		SORT_BY_WORK_ORDER_VALUE("Assign Work Order"),
		FILTER_MEASUREMENTS_VALUE("3000 FC"),
		FILTER_THERMAL_IMAGES_VALUE("Thermal Imager"),
		FILTER_3_PHASE_VALUE("3-Phase Monitor"),
		FILTER_UNASSIGNED_ASSET("Assign to Asset"),
		SORT_BY_DATE_ASC_VALUE("06/30/2018 17:07:58"),
		IOS_SEARCH_ID("Asset, Distribution Panel"),
		IOS_REASSIGNED_ASSET("Asset, Motor"),
		IOS_REASSIGNED_WORKORDER("00001"),
		SEARCH_TEXT("Distribution Panel");
		
		private String attributeValue;

	    SearchSortFilterAttributes(String attributeValue) 
	    {
	        this.attributeValue = attributeValue;
	    }

	    public String getAttributeValue() 
	    {
	        return attributeValue;
	    }
	}
	
	public enum CoachMarkTitleAndMessage

	{
		ADD_ASSET_COACHMARK_TITLE("Add Asset"),
		ADD_ASSET_COACHMARK_MESSAGE("Add an asset to track the health of your asset over a period of time"),
		ADD_NOTE_COACHMARK_TITLE("Add Note"), 
		ADD_NOTE_COACHMARK_MESSAGE("Add additional information so you can reference it later."), 
		SHARE_COACHMARK_TITLE("Share"),
		SHARE_COACHMARK_MESSAGE("Share the measurement with others"),
		YOU_ARE_ONTRACK_TITLE("You are on track!"),
		YOU_ARE_ONTRACK_DESCRIPTION("Continue to save and document measurements over time to track the health of your Asset");

		String getTitleAndMessageStr;

		public String  getMessageAndMessage()
		{
			return getTitleAndMessageStr;
		}

		CoachMarkTitleAndMessage(String getMessageStr)
		{
			this.getTitleAndMessageStr=getMessageStr;
		}

	}
}
