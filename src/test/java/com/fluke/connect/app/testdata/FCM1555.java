
package com.fluke.connect.app.testdata;
import org.testng.annotations.DataProvider;
import java.util.HashMap;
import java.util.Map;


public class FCM1555 
{
	public  static String[] testVoltageTestData = {"250", "250", "250", "250", "250", "250"};

	public static String[] testTypeTestData = {"Time Limited", "RAMP", "DAR (1m : 30s)", "DAR (1m : 30s)", "DAR CN (1m : 15s)", "DAR (1m : 30s)"};

	public static String[] timeLimitTestData = {"1", "1", "2", "2", "2", "2"};

	/*
		{

		 "500", "1000", "2500", "5000"};
		 , "RAMP", "DAR (1m : 30s)", "DAR CN (1m : 15s)", "PI (10m : 1m)"};
		 , "1", "2", "2", "11" };
			{250, RAMP, 1},
			{500, DAR, 3}, 
			{1000, RAMP, 4}
		}
	 */
	
	@DataProvider(name = "eeveeTestData")
	public Object[][] mobileDataProvider()
	{
		String[][] eeveeTestDataProvider = new String[testVoltageTestData.length][testVoltageTestData.length - 3];
		for(int i = 0; i < eeveeTestDataProvider.length; i++)
		{
			for(int j = 0; j < i + 1; j++) 
			{
				eeveeTestDataProvider[i][j] = testVoltageTestData[i];
				j++;

				eeveeTestDataProvider[i][j] = testTypeTestData[i];
				j++;

				eeveeTestDataProvider[i][j] = timeLimitTestData[i];

				break;
			}

		}
		return eeveeTestDataProvider;
	}
	
	public static Map<String, Integer> getPickerLoopCountTestVoltage = new HashMap<String, Integer>();
	static
	{
		FCM1555.getPickerLoopCountTestVoltage.put("250", 1);
		FCM1555.getPickerLoopCountTestVoltage.put("250", 1);
		FCM1555.getPickerLoopCountTestVoltage.put("250", 1);
		FCM1555.getPickerLoopCountTestVoltage.put("250", 1);
		FCM1555.getPickerLoopCountTestVoltage.put("250", 1);
		FCM1555.getPickerLoopCountTestVoltage.put("250", 1);
	}
	public static Map<String, Integer> getPickerLoopCountTestType = new HashMap<String, Integer>();
	static
	{
		FCM1555.getPickerLoopCountTestType.put("Time Limited", 0);
		FCM1555.getPickerLoopCountTestType.put("RAMP", 1);
		FCM1555.getPickerLoopCountTestType.put("DAR (1m : 30s)", 2);
		FCM1555.getPickerLoopCountTestType.put("DAR (1m : 30s)", 2);
		FCM1555.getPickerLoopCountTestType.put("DAR CN (1m : 15s)", 4);
		FCM1555.getPickerLoopCountTestType.put("DAR (1m : 30s)", 2);
	}
	public static Map<String, Integer> getPickerLoopCountTestDuration = new HashMap<String, Integer>();
	static
	{
		FCM1555.getPickerLoopCountTestDuration.put("1", 1);
		FCM1555.getPickerLoopCountTestDuration.put("1", 1);
		FCM1555.getPickerLoopCountTestDuration.put("2", 1);
		FCM1555.getPickerLoopCountTestDuration.put("2", 1);
		FCM1555.getPickerLoopCountTestDuration.put("2", 1);
		FCM1555.getPickerLoopCountTestDuration.put("2", 1);
	}
	//FCM1555.getPickerLoopCountTestType.put("Time Limited", 0);
	//Integer.parseInt()
	//Integer.parseInt(FCM1555.getPickerLoopCountTestType.get(type))

	public enum MESSAGES

	{
		REMOTE_CONTROL_CONFIRMATION("Are you sure you want to start Remote Control?"), 
		TEST_SUCCESSFULLY_STARTED_CONFIRMATION("Test has been started successfully."), 
		TEST_SUCCESSFULLY_COMPLETED("Test completed Successfully"),
		TEST_SUCCESSFULLY_COMPLETED_iOS("Test completed successfully."),
		DOYOU_WANT_TO_SAVE("Do you want to save the test result?"), 
		STOP_REMOTE_CONTROL_CONFIRMATION("Are you sure you want to stop Remote Control?");

		String getMessageStr;

		public String  getMessage()
		{
			return getMessageStr;
		}

		MESSAGES(String getMessageStr)
		{
			this.getMessageStr=getMessageStr;
		}

	}


	public enum TEST_RESULTS
	{
		TEST_RESULT_HEADER(""),
		TEST_DURATION(""),
		PRIMARY_VALUE (""),
		SECONDARY_VALUE(""),
		TERTIARY_VALUE("");
		String getMeasData;
		public String  getMeasurementData()
		{
			return getMeasData;
		}

		TEST_RESULTS(String getMeasData)
		{
			this.getMeasData=getMeasData;
		}
	}


	public enum COMPENSATION_DATA
	{
		COMPENSATION_HEADER(""),
		COMPENSATION_RESISTANCE(""),
		COMPENSATION_TEMPRATURE(""),
		COMPENSATION_HUMIDITY("");

		String getCompensationData;
		public String  getCompensationData()
		{
			return getCompensationData;
		}

		COMPENSATION_DATA(String getCompensationData)
		{
			this.getCompensationData=getCompensationData;
		}
	}

	public enum TEST_CONDITIONS
	{
		TEST_CONDITIONS(""),
		VOLTAGE(""),
		RAMP(""),
		TIME_LIMIT(""),
		TEST_ENDED("");


		String getCondtionsData;
		public String  getTestCondtionData()
		{
			return getCondtionsData;
		}

		TEST_CONDITIONS(String getCondtionsData)
		{
			this.getCondtionsData=getCondtionsData;
		}
	}

	public  enum CALCUTLATED_RESULTS
	{
		CALCULATED_RESULTS(""),
		CAPACITANCE(""),
		PI(""),
		DAR("");


		String getCalculatedData;
		public String  getCalculatedData()
		{
			return getCalculatedData;
		}

		CALCUTLATED_RESULTS(String getCalculatedData)
		{
			this.getCalculatedData=getCalculatedData;
		}
	}

	public enum GRAPH
	{
		GRAPH(""),
		PRIMARY_AXIS_UNIT("");

		String getGraph;
		public String  getGraph()
		{
			return getGraph();
		}

		GRAPH(String getGraph)
		{
			this.getGraph=getGraph();
		}
	}

	public enum CNX_LOGGING_TEXTS

	{
		LOGGING_TEXT("Logging"), 
		INTERVAL_TEXT("Interval"), 
		DURATION_TEXT("Duration"),
		LOGGING_SETUP_TEXT("Logging Setup"),
		SET_INTERVAL_TEXT("Set interval to:"),
		MANUALLY_STOP_LOGGING_TEXT("Manually stop logging"),
		AUTOMATICALLY_STOP_LOGGING_TEXT("Automatically stop logging in:");

		String getStaticTextStr;

		public String  getMessage()
		{
			return getStaticTextStr;
		}

		CNX_LOGGING_TEXTS(String getStaticTextStr)
		{
			this.getStaticTextStr=getStaticTextStr;
		}
	}

	public static String[] expectedDeviceInfoStaticText = {"Device Info", "TOOL SPECIFIC SETTINGS"};
	public static String expectedDeviceNameStaticText = "Device Name";
	public static String expectedDeviceDescriptionStaticText = "Device Description";
	
	
	public static String expectedDeviceDescriptionFor1587FCStaticText = "Fluke Mfg Co. FLUKE 1587FC";
	public static String[] expectedConnectionStaticText = {"Connection: 1" , ""};
	public static String[] expectedDeviceDescriptionForV3000CStaticText = {"Fluke Mfg Co. FLUKE V3000FC", ""};


	public static String LOGGING_TEXT="Logging";
	public static String INTERVAL_TEXT="Interval";
	public static String DURATION_TEXT="Duration";
	public static String LOGGING_SETUP_TEXT="Logging Setup";
	public static String SET_INTERVAL_TEXT="Set interval to:";
	public static String MANUALLY_STOP_LOGGING_TEXT="Manually stop logging";
	public static String AUTOMATICALLY_STOP_LOGGING_TEXT="Automatically stop logging in:";
	
	//****Work order ****

	public static String[] measurementAssignedWorkOrderTile = {"sanity397", "1"};
	public static String[] measurementAssignedWorkOrderNumber = {"sanity397 (1)", "1"};
	
	public static String [] downloadCompletedHeaderStaticText= {"Download Completed", "" };
	public static String [] downloadCompletedSuccessfullyStaticText= {"Measurements Downloaded Successfully.", ""};

	// public static String [] getMeasurementUnits={"mV AC"};
	
	//   *****Device Info FC 1555 Android *****
	public static String[] expectedDeviceDescriptionFor1555FCStaticText = {"Fluke Mfg Co.  FLUKE 1550B", "FLUKE 1550B"};
	public static String expectedConnectionFor1555FCStaticText = "Connection: 1";
	
	//  *****Device Info FC 1555 iOS*****
	public static String expectedSerialNumberFor1555FCStaticText = "Serial Number";
	public static String expectedSoftwareVersionFor1555FCStaticText = "Software Version";
	public static String expectedFirwmwareVersionFor1555FCStaticText = "Firmware Version";
	
	public static String EveeAssetAnalsysisGroup="AssetAnalysisEveeAutomation";
	public static String EveeAsset="EveeAsset";
	
	
}

