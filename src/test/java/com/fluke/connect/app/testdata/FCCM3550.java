package com.fluke.connect.app.testdata;

public class FCCM3550 
{
	// **** 3550 test suite name constants ****
	final public static String SESSION_SETUP_TESTS = "3550_session_setup_tests";
	final public static String SESSION_END_TESTS = "3550_session_end_tests";
	final public static String SESSION_DELETE_TESTS = "3550_session_delete_tests";
	final public static String SESSION_CONFIG_TESTS = "3550_session_config_tests";
	final public static String SESSION_LIST_TESTS = "3550_session_list_tests";
	final public static String SESSION_DETAIL_PAGE_TESTS = "3550_session_detail_page_tests";
	final public static String COMPLETED_SESSION_LIST_TESTS = "3550_completed_session_list_tests";
	final public static String COMPLETED_SESSION_DETAIL_PAGE_TESTS = "3550_completed_session_detail_page_tests";
	final public static String SESSION_VERIFICATION_TESTS = "3550_session_tests"; //for android and iOS
	final public static String SESSION_VERIFICATION_WEB_TESTS = "3550_session_tests_web";
	final public static String COMPLETED_SESSION_VERIFICATION_TESTS = "3550_completed_session_tests"; //for android and iOS
	final public static String COMPLETED_SESSION_VERIFICATION_WEB_TESTS = "3550_completed_session_tests_web";
	
	final public static String PROD_TESTS = "prod_tests_3550";
	final public static String PROD_WEB_TESTS = "prod_web_tests_3550";
	final public static String UAT_TESTS = "uat_tests_3550";
	final public static String UAT_WEB_TESTS = "uat_web_tests_3550";

	
	//active session
	public static String sessionStartTimestamp = "nightcrawlerSessionStartTimestamp"; //common variable for both platforms
	public static String sessionStartTimestampValue = "04/12/2017 20:21:28 |";
	public static String iOSSessionStartTimestamp = "nightcrawleriOSSessionStartTimestamp"; //platform specific variables
	public static String androidSessionStartTimestamp = "nightcrawlerAndroidSessionStartTimestamp";
	public static String activeIOSSessionStartTimestamp = "12/20/2017, 16:16:34";
	public static String activeAnsroidSessionStartTimestamp = "12/20/17 16:16:34 |";

	//completed session
	public static String completedSessionStartTimestamp = "nightcrawlerCompletedSessionStartTimestamp";  //common variable for both platforms
	public static String completedSessionGivenStartTimestamp = "04/12/2017 20:21:28 |";
	public static String iOSCompletedSessionStartTimestamp = "nightcrawleriOSCompletedSessionStartTimestamp";
	public static String androidCompletedSessionStartTimestamp = "nightcrawlerAndroidCompletedSessionStartTimestamp";

	//placeholder for time-stamp for all platforms
	public static String requiredSessionStartTimestamp;

	//gateway and sensor
	public static String[] sessionStatus = {"MONITORING IN PROGRESS", "SENSOR CONNECTION LOST", "GATEWAY CONNECTION LOST"};
	public static String gatewayNameValue = "Fluke 3550 FC";
	public static String sensorsCountAndType = "1 TI";
	public static String sensorID = "17020070";
	
	//user and asset details
	public static String sessionStartUserName = "Team Admin";     
	public static String assetGroupName = "3550"; // used during session setup and session verification
	public static String assetName = "Motor";
	public static String testPointName = "Motor";
	
	//unit 
	public static String tempratureUnitFahrenheitAndroid = "℉";
	public static String tempratureUnitFahrenheit = "F";
	
	public static String mobileMaxLabel = "max";
	public static String mobileMinLabel = "min";
	public static String webMaxLabel = "Max";
	public static String webMinLabel = "Min";
	
	//network name and password
	public static String networkName = "FC-Net";
	public static String password = "wgS3jNC#6D";
	
	//sampling rate
	public final static String ONE_MIN  = "1";
	public final static String FIVE_MIN  = "5";
	public final static String TEN_MIN  = "10";
	public final static String THIRTY_MIN  = "30";
	public final static String SIXTY_MIN  = "60";
	public final static String TWELE_HOUR  = "12";
	public final static String TWENTY_FOUR_HOUR  = "24";
	
	public final static String SAMPLING_RATE  = "SAMPLING_RATE";
	
	public enum AlarmText3550
	{
		WEB_NOTIFICATION_ABOVE("//span[starts-with(text(), 'TEMPERATURE  >')]"),
		WEB_NOTIFICATION_BELOW("//span[starts-with(text(), 'TEMPERATURE  <') and (not(contains(text(), 'or')))]"),
		WEB_NOTIFICATION_WITHIN("//span[starts-with(text(), 'TEMPERATURE') and contains(text(), '-')]"),
		WEB_NOTIFICATION_OUT("//span[starts-with(text(), 'TEMPERATURE') and contains(text(), 'or')]"),
		WEB_SESSION_ABOVE("Above Temperature Alarm"),
		WEB_SESSION_BELOW("Below Temperature Alarm"),
		WEB_SESSION_WITHIN("Within Range Temperature Alarm"),
		WEB_SESSION_OUT("Out of Range Temperature Alarm"),
		IOS_SESSION_ABOVE("Above Temperature Alarm"),
		IOS_SESSION_BELOW("Below Temperature Alarm"),
		IOS_SESSION_WITHIN("Within-Range Temperature Alarm"),
		IOS_SESSION_OUT("Out-of-Range Temperature Alarm"),
		ANDROID_SESSION_ABOVE("Above Temperature Alarm"),
		ANDROID_SESSION_BELOW("Below Temperature Alarm"),
		ANDROID_SESSION_WITHIN("Within-Range Temperature Alarm"),
		ANDROID_SESSION_OUT("Out-of-Range Temperature Alarm");
	 
	    private String alarmText;
	 
	    AlarmText3550(String alarmText) {
	        this.alarmText = alarmText;
	    }
	 
	    public String getText() {
	        return alarmText;
	    }
	}
	
	public enum AlarmNotificationObject3550
	{
		WEB_SESSION_ABOVE("//*[. = 'Above Temperature Alarm']/ancestor::div[@class = 'user-notifications']"),
		WEB_SESSION_BELOW("//*[. = 'Below Temperature Alarm']/ancestor::div[@class = 'user-notifications']"),
		WEB_SESSION_WITHIN("//*[. = 'Within Range Temperature Alarm']/ancestor::div[@class = 'user-notifications']"),
		WEB_SESSION_OUT("//*[. = 'Out of Range Temperature Alarm']/ancestor::div[@class = 'user-notifications']");
	 
	    private String alarmText;
	 
	    AlarmNotificationObject3550(String alarmText) {
	        this.alarmText = alarmText;
	    }
	 
	    public String getObject() {
	        return alarmText;
	    }
	}
	
	public enum DataValues
	{
		WEB_TEMP_UNIT_CEL("°C"),
		WEB_TEMP_UNIT_FAR("°F"),
		
		WEB_TEMP_VALUE_UNIT_CEL("°C"),
		WEB_TEMP_VALUE_UNIT_FAR("°F"),
		
		
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
