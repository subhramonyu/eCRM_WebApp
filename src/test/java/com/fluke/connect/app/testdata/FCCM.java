package com.fluke.connect.app.testdata;

public class FCCM 
{
	public final static String GRAPH_1H_TAB = "1H";
	public final static String GRAPH_8H_TAB = "8H";
	public final static String GRAPH_12H_TAB = "12H";
	public final static String GRAPH_1D_TAB = "1D";
	public final static String GRAPH_1W_TAB = "1W";
	public final static String GRAPH_3W_TAB = "3W";
	public final static String GRAPH_1M_TAB = "1M";
	public final static String GRAPH_ALL_TAB = "ALL";
	
	public enum AlarmType
	{
		ABOVE, BELOW, WITHIN, OUTOF,
		ABOVE_VOLTAGE, BELOW_VOLTAGE, WITHIN_VOLTAGE, OUTOF_VOLTAGE, 
		CURRENT, 
		ABOVE_TEMPERATURE, BELOW_TEMPERATURE, WITHIN_TEMPERATURE, OUTOF_TEMPERATURE,
		ABOVE_VIBRATION, BELOW_VIBRATION, WITHIN_VIBRATION, OUTOF_VIBRATION,
		CUSTOM_VIBRATION_ALARM, FOVS
		
	}
	
	public enum MeasurementUnit
	{
		FAHRENHEIT, CELSIUS   
	}
	
	public enum FCCMProductName
	{
	    TI_SENSOR("Thermal Imaging"),
	    VIBRATION_SENSOR("Vibration");
	 
	    private String productName;
	 
	    FCCMProductName(String productNamee) {
	        this.productName = productNamee;
	    }
	 
	    public String getProductName() {
	        return productName;
	    }
	}
	
	public enum AlarmText
	{
		WEB_SESSION_FOVS_TYPE("[data-fovsstatus-test-id]"),//"(".alarm-status-color"),
		WEB_SESSION_FOVS("Vibration Level Change Alarm"),
		WEB_SESSION_FOVS_MACHINE_CATEGORY("Spindle – Machine Finishing"),
		
		WEB_SESSION_ACTIVITY_ABOVE_TEMPRATURE("Above Temperature Alarm"),
		WEB_SESSION_ACTIVITY_BELOW_TEMPRATURE("Below Temperature Alarm"),
		WEB_SESSION_ACTIVITY_WITHIN_TEMPRATURE("Within Range Temperature Alarm"),
		WEB_SESSION_ACTIVITY_OUTOF_TEMPRATURE("Out of Range Temperature Alarm"),
		
		WEB_SESSION_ACTIVITY_ABOVE_VIBRATION("Above Vibration Alarm"),
		WEB_SESSION_ACTIVITY_BELOW_VIBRATION("Below Vibration Alarm"),
		WEB_SESSION_ACTIVITY_WITHIN_VIBRATION("Within Range Vibration Alarm"),
		WEB_SESSION_ACTIVITY_OUTOF_VIBRATION("Out of Range Vibration Alarm"),
		
		WEB_ABOVE_TEMPRATURE("TEMPERATURE  >"),
		WEB_BELOW_TEMPRATURE("TEMPERATURE  <"),
		WEB_WITHIN_TEMPRATURE("TEMPERATURE "),
		WEB_OUTOF_TEMPRATURE("TEMPERATURE  "),
		
		WEB_ABOVE_VIBRATION("VIBRATION  >"),
		WEB_BELOW_VIBRATION("VIBRATION  <"),
		WEB_WITHIN_VIBRATION("VIBRATION "),
		WEB_OUTOF_VIBRATION("VIBRATION "),
		
		IOS_SESSION_UNACCEPTABLE(" UNACCEPTABLE "),
		IOS_SESSION_UNSATISFACTORY(" UNSATISFACTORY "),
		ANDROID_SESSION_UNACCEPTABLE("UNACCEPTABLE"),
		ANDROID_SESSION_UNSATISFACTORY("UNSATISFACTORY"),
		
		IOS_SESSION_ABOVE("Above Temperature Alarm"),
		IOS_SESSION_BELOW("Below Temperature Alarm"),
		IOS_SESSION_WITHIN("Within-Range Temperature Alarm"),
		IOS_SESSION_OUT("Out-of-Range Temperature Alarm"),
		
		IOS_SESSION_ACTIVITY_ASSET_GROUP("3561"),
		IOS_SESSION_ACTIVITY_ASSET("Motor"),
		IOS_SESSION_ACTIVITY_TEST_POINT("Motor"),
		
		SESSION_ACTIVITY_ASSET_GROUP("3561"),
		SESSION_ACTIVITY_ASSET("Motor"),
		SESSION_ACTIVITY_TEST_POINT("Motor"),
		
		ANDROID_SESSION_ABOVE_TEMP("Above Temperature Alarm"),
		ANDROID_SESSION_BELOW_TEMP("Below Temperature Alarm"),
		ANDROID_SESSION_WITHIN_TEMP("Within-Range Temperature Alarm"),
		ANDROID_SESSION_OUTOF_TEMP("Out-of-Range Temperature Alarm"),
		
		ANDROID_SESSION_ABOVE_VIB("Above Vibration Alarm"),
		ANDROID_SESSION_BELOW_VIB("Below Vibration Alarm"),
		ANDROID_SESSION_WITHIN_VIB("Within-Range Vibration Alarm"),
		ANDROID_SESSION_OUTOF_VIB("Out-of-Range Vibration Alarm");
	 
	    private String alarmText;
	 
	    AlarmText(String alarmText) {
	        this.alarmText = alarmText;
	    }
	 
	    public String getText() {
	        return alarmText;
	    }
	}
	
	public enum AlarmObject  
	{
		WEB_NOTIFICATION_UNACCEPTABLE("//span[. = 'UNACCEPTABLE']"),
		WEB_NOTIFICATION_UNSATISFACTORY("//span[. = 'UNSATISFACTORY']"),
		WEB_SESSION_UNACCEPTABLE("//*[. = 'UNACCEPTABLE']/ancestor::div[@class = 'user-notifications']"),
		WEB_SESSION_UNSATISFACTORY("//*[. = 'UNSATISFACTORY']/ancestor::div[@class = 'user-notifications']"),
		WEB_SESSION_FOVS("//*[. = 'Vibration Level Change Alarm']/ancestor::div[@class = 'user-notifications']"),
		WEB_SESSION_TRIGGERED_VALUE(".alarm-triggered-value"),
		WEB_SESSION_TRIGGERED_UNIT(".units-style"),
		
		WEB_SESSION_ALARM_TIMESTAMP(".alarm-edit-info"),
		WEB_SESSION_ASSET_GROUP(".alarm-asset-container-tree"),
		WEB_SESSION_ASSET(".alarm-asset-device-title"),
		WEB_SESSION_THRESHOLD(".sidebar-range-value"),
		WEB_SESSION_THRESHOLD_HIGH("[data-highrangevalue-test-id]"),
		WEB_SESSION_THRESHOLD_LOW("[data-lowrangevalue-test-id]"),
		WEB_SESSION_UNIT("[data-rangeunit-test-id]"),
		
		WEB_NOTIFICATION_VALUE(".menuItemReading"),
		WEB_NOTIFICATION_TIMESTAMP(".menuItemTime"),
		
		WEB_NOTIFICATION_ABOVE_TEMPRATURE("//span[starts-with(text(), 'TEMPERATURE  >')]/ancestor::div[@class = 'menuItemContainer']"),
		WEB_NOTIFICATION_ABOVE_VIBRATION("//span[starts-with(text(), 'VIBRATION  >')]/ancestor::div[@class = 'menuItemContainer']"),
		WEB_NOTIFICATION_BELOW_VIBRATION("//span[starts-with(text(), 'VIBRATION  <') and (not(contains(text(), 'or')))]/ancestor::div[@class = 'menuItemContainer']"),
		WEB_NOTIFICATION_BELOW_TEMPRATURE("//span[starts-with(text(), 'TEMPERATURE  <') and (not(contains(text(), 'or')))]/ancestor::div[@class = 'menuItemContainer']"),
		WEB_NOTIFICATION_WITHIN_TEMPRATURE("//span[starts-with(text(), 'TEMPERATURE') and contains(text(), '-')]/ancestor::div[@class = 'menuItemContainer']"),
		WEB_NOTIFICATION_WITHIN_VIBRATION("//span[starts-with(text(), 'VIBRATION') and contains(text(), '-')]/ancestor::div[@class = 'menuItemContainer']"),
		WEB_NOTIFICATION_OUTOF_VIBRATION("//span[starts-with(text(), 'VIBRATION') and contains(text(), 'or')]/ancestor::div[@class = 'menuItemContainer']"),
		WEB_NOTIFICATION_OUTOF_TEMPRATURE("//span[starts-with(text(), 'TEMPERATURE') and contains(text(), 'or')]/ancestor::div[@class = 'menuItemContainer']"),
		
		WEB_SESSION_ABOVE_TEMPRATURE("//*[. = 'Above Temperature Alarm']/ancestor::div[@class = 'user-notifications']"),
		WEB_SESSION_ABOVE_VIBRATION("//*[. = 'Above Vibration Alarm']/ancestor::div[@class = 'user-notifications']"),
		WEB_SESSION_BELOW_TEMPRATURE("//*[. = 'Below Temperature Alarm']/ancestor::div[@class = 'user-notifications']"),
		WEB_SESSION_BELOW_VIBRATION("//*[. = 'Below Vibration Alarm']/ancestor::div[@class = 'user-notifications']"),
		WEB_SESSION_WITHIN_TEMPRATURE("//*[. = 'Within Range Temperature Alarm']/ancestor::div[@class = 'user-notifications']"),
		WEB_SESSION_WITHIN_VIBRATION("//*[. = 'Within Range Vibration Alarm']/ancestor::div[@class = 'user-notifications']"),
		WEB_SESSION_OUTOF_TEMPRATURE("//*[. = 'Out of Range Temperature Alarm']/ancestor::div[@class = 'user-notifications']"),
		WEB_SESSION_OUTOF_VIBRATION("//*[. = 'Out of Range Vibration Alarm']/ancestor::div[@class = 'user-notifications']"),
		
		
		// Graph SDK Value for Alarm  START HERE ******************************************//
		
		WEB_SESSION_FOVS_GRAPH("//*[. = 'Vibration Level Change Alarm']/ancestor::div[@name = 'alarm-notification-wrapper']"),//("//*[. = 'Vibration Level Change Alarm']/ancestor::div[@class = 'user-notifications']"),
		WEB_SESSION_TRIGGERED_VALUE_GRAPH("[data-alarmval-test-id]"),//(".alarm-triggered-value"),
		WEB_SESSION_TRIGGERED_UNIT_GRAPH("[data-alarmunit-test-id]"),
		
		
		WEB_SESSION_ALARM_TIMESTAMP_GRAPH("[name=\"alarm-edit-info\"]"),//(".alarm-edit-info"),
		WEB_SESSION_ASSET_GROUP_GRAPH("[data-assetgroup-test-id]"),//(".alarm-asset-container-tree"),
		WEB_SESSION_ASSET_GRAPH("[data-asset-test-id]"),//(".alarm-asset-device-title"),
		WEB_SESSION_THRESHOLD_GRAPH("[data-rangevalue-test-id]"),//(".sidebar-range-value"),
		WEB_SESSION_THRESHOLD_HIGH_GRAPH("[data-highrangevalue-test-id]"),
		WEB_SESSION_THRESHOLD_LOW_GRAPH("[data-lowrangevalue-test-id]"),
		WEB_SESSION_UNIT_GRAPH("[data-rangeunit-test-id]"),
		
		
		
		
		WEB_SESSION_ABOVE_TEMPRATURE_GRAPH("//*[. = 'Above Temperature Alarm']/ancestor::div[@name = 'alarm-notification-wrapper']"),  //("//*[. = 'Above Temperature Alarm']/ancestor::div[@class = 'user-notifications']"),
		WEB_SESSION_ABOVE_VIBRATION_GRAPH("//*[. = 'Above Vibration Alarm']/ancestor::div[@name = 'alarm-notification-wrapper']"),//("//*[. = 'Above Vibration Alarm']/ancestor::div[@class = 'user-notifications']"),
		WEB_SESSION_BELOW_TEMPRATURE_GRAPH("//*[. = 'Below Temperature Alarm']/ancestor::div[@name = 'alarm-notification-wrapper']"),//("//*[. = 'Below Temperature Alarm']/ancestor::div[@class = 'user-notifications']"),
		WEB_SESSION_BELOW_VIBRATION_GRAPH("//*[. = 'Below Vibration Alarm']/ancestor::div[@name = 'alarm-notification-wrapper']"),//("//*[. = 'Below Vibration Alarm']/ancestor::div[@class = 'user-notifications']"),
		WEB_SESSION_WITHIN_TEMPRATURE_GRAPH("//*[. = 'Within Range Temperature Alarm']/ancestor::div[@name = 'alarm-notification-wrapper']"),//("//*[. = 'Within Range Temperature Alarm']/ancestor::div[@class = 'user-notifications']"),
		WEB_SESSION_WITHIN_VIBRATION_GRAPH("//*[. = 'Within Range Vibration Alarm']/ancestor::div[@name = 'alarm-notification-wrapper']"),//("//*[. = 'Within Range Vibration Alarm']/ancestor::div[@class = 'user-notifications']"),
		WEB_SESSION_OUTOF_TEMPRATURE_GRAPH("//*[. = 'Out of Range Temperature Alarm']/ancestor::div[@name = 'alarm-notification-wrapper']"),//("//*[. = 'Out of Range Temperature Alarm']/ancestor::div[@class = 'user-notifications']"),
		WEB_SESSION_OUTOF_VIBRATION_GRAPH("//*[. = 'Out of Range Vibration Alarm']/ancestor::div[@name = 'alarm-notification-wrapper']"),//("//*[. = 'Out of Range Vibration Alarm']/ancestor::div[@class = 'user-notifications']"),
		
		
		//****************** END HERE ****************************//
		
		IOS_SESSION_ABOVE_VIBRATION("//XCUIElementTypeStaticText[@name='Above Vibration Alarm']/ancestor::XCUIElementTypeCell"),
		IOS_SESSION_BELOW_VIBRATION("//XCUIElementTypeStaticText[@name='Below Vibration Alarm']/ancestor::XCUIElementTypeCell"),
		IOS_SESSION_WITHIN_VIBRATION("//XCUIElementTypeStaticText[@name='Within-Range Vibration Alarm']/ancestor::XCUIElementTypeCell"),
		IOS_SESSION_OUTOF_VIBRATION("//XCUIElementTypeStaticText[@name='Out-of-Range Vibration Alarm']/ancestor::XCUIElementTypeCell"),
		
		IOS_SESSION_ABOVE_TEMPERATURE("//XCUIElementTypeStaticText[@name='Above Temperature Alarm']/ancestor::XCUIElementTypeCell"),
		IOS_SESSION_BELOW_TEMPERATURE("//XCUIElementTypeStaticText[@name='Below Temperature Alarm']/ancestor::XCUIElementTypeCell"),
		IOS_SESSION_WITHIN_TEMPERATURE("//XCUIElementTypeStaticText[@name='Within-Range Temperature Alarm']/ancestor::XCUIElementTypeCell"),
		IOS_SESSION_OUTOF_TEMPERATURE("//XCUIElementTypeStaticText[@name='Out-of-Range Temperature Alarm']/ancestor::XCUIElementTypeCell"),
	 
		ANDROID_SESSION_ABOVE_VIBRATION("//android.widget.TextView[contains(@text, 'Above Vibration Alarm')]/parent::android.widget.RelativeLayout/parent::android.widget.LinearLayout"),
		ANDROID_SESSION_BELOW_VIBRATION("//android.widget.TextView[contains(@text, 'Below Vibration Alarm')]/parent::android.widget.RelativeLayout/parent::android.widget.LinearLayout"),
		ANDROID_SESSION_WITHIN_VIBRATION("//android.widget.TextView[contains(@text, 'Within-Range Vibration Alarm')]/parent::android.widget.RelativeLayout/parent::android.widget.LinearLayout"),
		ANDROID_SESSION_OUTOF_VIBRATION("//android.widget.TextView[contains(@text, 'Out-of-Range Vibration Alarm')]/parent::android.widget.RelativeLayout/parent::android.widget.LinearLayout"),
		
		ANDROID_SESSION_ABOVE_TEMPERATURE("//android.widget.TextView[contains(@text, 'Above Temperature Alarm')]/parent::android.widget.RelativeLayout/parent::android.widget.LinearLayout"),
		ANDROID_SESSION_BELOW_TEMPERATURE("//android.widget.TextView[contains(@text, 'Below Temperature Alarm')]/parent::android.widget.RelativeLayout/parent::android.widget.LinearLayout"),
		ANDROID_SESSION_WITHIN_TEMPERATURE("//android.widget.TextView[contains(@text, 'Within-Range Temperature Alarm')]/parent::android.widget.RelativeLayout/parent::android.widget.LinearLayout"),
		ANDROID_SESSION_OUTOF_TEMPERATURE("//android.widget.TextView[contains(@text, 'Out-of-Range Temperature Alarm')]/parent::android.widget.RelativeLayout/parent::android.widget.LinearLayout");
	 
		
		private String alarmText;
	 
	    AlarmObject(String alarmText) {
	        this.alarmText = alarmText;
	    }
	 
	    public String getObject() {
	        return alarmText;
	    }
	}
	
	public enum AlarmDataValues
	{
		//3560
		
		FCCM3560_VIB_UNIT_ACC("g"),
		FCCM3560_VIB_UNIT_INS("in/s"),
		FCCM3560_VIB_UNIT_MMS("mm/s"),
		
		FCCM3560_TEMP_UNIT_CEL("C"),
		FCCM3560_TEMP_UNIT_FAR("F"),
		
		FCCM3560_ASSET_GROUP_NAME("3561"),
		FCCM3560_ASSET_NAME("Motor"),
		FCCM3560_TEST_POINT_NAME("Motor"),
		
		FCCM3560_ASSET_GROUP_NAME_OLD("3561"),
		FCCM3560_ASSET_NAME_OLD("Motor"),
		FCCM3560_TEST_POINT_NAME_OLD("Motor"),
		
		FCCM3560_DATE_FORMAT_WEB("MM/dd/yyyy"),
		
		FCCM3560_ABOVE_VIB_THRESHOLD_VALUE("0.001"),
		FCCM3560_BELOW_VIB_THRESHOLD_VALUE("19.999"),
		FCCM3560_WITHIN_VIB_UPPER_THRESHOLD_VALUE("19.999"),
		FCCM3560_WITHIN_VIB_LOWER_THRESHOLD_VALUE("0.001"),
		FCCM3560_OUTOF_VIB_UPPER_THRESHOLD_VALUE("0.002"),
		FCCM3560_OUTOF_VIB_LOWER_THRESHOLD_VALUE("0.001"),
		
		FCCM3560_ABOVE_TEMP_THRESHOLD_VALUE("50"),   //F
		FCCM3560_BELOW_TEMP_THRESHOLD_VALUE("100"),   //F
		FCCM3560_WITHIN_TEMP_UPPER_THRESHOLD_VALUE("100"),  //C
		FCCM3560_WITHIN_TEMP_LOWER_THRESHOLD_VALUE("0"),   //C
		FCCM3560_OUTOF_TEMP_UPPER_THRESHOLD_VALUE("1"),  //F
		FCCM3560_OUTOF_TEMP_LOWER_THRESHOLD_VALUE("0"),  //F
		
		FCCM3560_ABOVE_VIB_RESET_VALUE("500"),
		FCCM3560_BELOW_VIB_RESET_VALUE("0"),
		FCCM3560_WITHIN_VIB_UPPER_RESET_VALUE("1000"),
		FCCM3560_WITHIN_VIB_LOWER_RESET_VALUE("500"),
		FCCM3560_OUTOF_VIB_UPPER_RESET_VALUE("19.999"),
		FCCM3560_OUTOF_VIB_LOWER_RESET_VALUE("0.001"),
		
		FCCM3560_ABOVE_TEMP_RESET_VALUE("500"),
		FCCM3560_BELOW_TEMP_RESET_VALUE("0"),
		FCCM3560_WITHIN_TEMP_UPPER_RESET_VALUE("1000"),
		FCCM3560_WITHIN_TEMP_LOWER_RESET_VALUE("500"),
		FCCM3560_OUTOF_TEMP_UPPER_RESET_VALUE("200"),
		FCCM3560_OUTOF_TEMP_LOWER_RESET_VALUE("0"),
		
		//3550
		
		FCCM3550_TEMP_UNIT_CEL("C"),
		FCCM3550_TEMP_UNIT_FAR("F"),
		
		FCCM3550_ABOVE_TEMP_THRESHOLD_VALUE("50"),   //F
		FCCM3550_BELOW_TEMP_THRESHOLD_VALUE("50"),   //C
		FCCM3550_WITHIN_TEMP_UPPER_THRESHOLD_VALUE("100"),  //C
		FCCM3550_WITHIN_TEMP_LOWER_THRESHOLD_VALUE("0"),   //C
		FCCM3550_OUTOF_TEMP_UPPER_THRESHOLD_VALUE("1"),  //F
		FCCM3550_OUTOF_TEMP_LOWER_THRESHOLD_VALUE("0"),  //F
		
		FCCM3550_DATE_FORMAT_WEB("MM/dd/yyyy"),
		
		FCCM3550_ASSET_GROUP_NAME("3550"),
		FCCM3550_ASSET_NAME("Motor"),
		FCCM3550_TEST_POINT_NAME("Motor"),
		
		FCCM3550_ABOVE_TEMP_RESET_VALUE("500"),
		FCCM3550_BELOW_TEMP_RESET_VALUE("0"),
		FCCM3550_WITHIN_TEMP_UPPER_RESET_VALUE("1000"),
		FCCM3550_WITHIN_TEMP_LOWER_RESET_VALUE("500"),
		FCCM3550_OUTOF_TEMP_UPPER_RESET_VALUE("200"),
		FCCM3550_OUTOF_TEMP_LOWER_RESET_VALUE("0"),
		
		;
	 
	    private String alarmDataValue;
	 
	    AlarmDataValues(String alarmDataValue) {
	        this.alarmDataValue = alarmDataValue;
	    }
	 
	    public String getValue() {
	        return alarmDataValue;
	    }
	}

}
