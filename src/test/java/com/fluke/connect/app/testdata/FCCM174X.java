package com.fluke.connect.app.testdata;

import java.util.HashMap;
import java.util.Map;

public class FCCM174X {
	// **** Blondel 174x test suite name constants ****
	final public static String SESSION_CONFIG_TESTS = "174X_Session_Config_tests";
	final public static String FCCM174X_API_TESTS = "174X_Api_tests";
	final public static String FCCM174X_INSTALL_COMM_SESSIONS_TESTS = "174X_Install_Comm_Sessions_tests";
	final public static String FCCM174X_LIVESESSION_TESTS = "174X_LiveSession_tests";
	
	
	
	public static Map<String, Integer> getPickerLoopCountTestStandardType = new HashMap<String, Integer>();
	static
	{
		FCCM174X.getPickerLoopCountTestStandardType.put("None", 0);
		FCCM174X.getPickerLoopCountTestStandardType.put("EN50160", 1);
	}
	
	public static Map<String, Integer> getPickerLoopCountTestStudyType = new HashMap<String, Integer>();
	static
	{
		FCCM174X.getPickerLoopCountTestStudyType.put("Energy Study", 0);
		FCCM174X.getPickerLoopCountTestStudyType.put("Load Study", 1);
	}
	
	public static Map<String, Integer> getPickerLoopCountTestTopology = new HashMap<String, Integer>();
	static
	{
		FCCM174X.getPickerLoopCountTestTopology.put("Single Phase", 0);
		FCCM174X.getPickerLoopCountTestTopology.put("Wye", 1);
		FCCM174X.getPickerLoopCountTestTopology.put("Delta", 2);
		FCCM174X.getPickerLoopCountTestTopology.put("Split Single Phase", 3);
		FCCM174X.getPickerLoopCountTestTopology.put("Single Phase It", 4);
		FCCM174X.getPickerLoopCountTestTopology.put("Wye It", 5);
		FCCM174X.getPickerLoopCountTestTopology.put("High Leg Delta", 6);
		FCCM174X.getPickerLoopCountTestTopology.put("Open Delta", 7);
		FCCM174X.getPickerLoopCountTestTopology.put("Two Element", 8);
		FCCM174X.getPickerLoopCountTestTopology.put("Wye Balanced", 9);
		FCCM174X.getPickerLoopCountTestTopology.put("Delta Balanced", 10);

	}
}
