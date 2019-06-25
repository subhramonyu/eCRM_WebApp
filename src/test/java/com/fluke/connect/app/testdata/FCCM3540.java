package com.fluke.connect.app.testdata;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.DataProvider;

import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;

public class FCCM3540 
{
	// **** 3540 test suite name constants ****
	final public static String SESSION_SETUP_TESTS = "3540_session_setup_tests";
	final public static String SESSION_END_TESTS = "3540_session_end_tests";
	final public static String SESSION_DELETE_TESTS = "3540_session_delete_tests";
	final public static String SESSION_CONFIG_TESTS = "3540_session_config_tests";
	final public static String SESSION_LIST_TESTS = "3540_session_list_tests";
	final public static String SESSION_DETAIL_PAGE_TESTS = "3540_session_detail_page_tests";
	final public static String COMPLETED_SESSION_LIST_TESTS = "3540_completed_session_list_tests";
	final public static String COMPLETED_SESSION_DETAIL_PAGE_TESTS = "3540_completed_session_detail_page_tests";
	final public static String SESSION_VERIFICATION_TESTS = "3540_session_tests"; //for android and iOS
	final public static String SESSION_VERIFICATION_WEB_TESTS = "3540_session_tests_web";
	final public static String COMPLETED_SESSION_VERIFICATION_TESTS = "3540_completed_session_tests"; //for android and iOS
	final public static String COMPLETED_SESSION_VERIFICATION_WEB_TESTS = "3540_completed_session_tests_web";
	final public static String EVENT_LOGGING_TESTS = "3540_EventLogging_tests";
	final public static String UAT_3540 = "3540_UAT_tests";
	
	//active session
	public static String sessionStartTimestamp = "powerQualitySessionStartTimestamp"; //common variable for both platforms
	public static String sessionStartTimestampValue = "04/12/2017 20:21:28 |";
	public static String iOSSessionStartTimestamp = "powerQualityiOSSessionStartTimestamp"; //platform specific variables
	public static String androidSessionStartTimestamp = "powerQualityAndroidSessionStartTimestamp";
	public static String activeIOSSessionStartTimestamp = "12/20/2017, 16:16:34";
	public static String activeAnsroidSessionStartTimestamp = "06/28/18 18:05:08 |";
	//public static String activeAnsroidSessionStartTimestamp = "06/28/18 18:05:08 |";

	//completed session
	public static String completedSessionStartTimestamp = "powerQualityCompletedSessionStartTimestamp";  //common variable for both platforms
	public static String completedSessionGivenStartTimestamp = "04/12/2017 20:21:28 |";
	public static String iOSCompletedSessionStartTimestamp = "powerQualityiOSCompletedSessionStartTimestamp";
	public static String androidCompletedSessionStartTimestamp = "powerQualityAndroidCompletedSessionStartTimestamp";

	//placeholder for time-stamp for all platforms
	public static String requiredSessionStartTimestamp;

	//gateway and sensor
	public static String[] sessionStatus = {"MONITORING IN PROGRESS", "CONNECTION LOST"};
	public static String gatewayNameValue = "Fluke3540FC";
	public static String monitoringData = "MONITORING DATA";
	
	//user and asset details
	//public static String sessionStartUserName = "Team Admin";
	public static String sessionStartUserName = DriverManager.getUserName();
	public static String assetGroupName = "Ungrouped Assets"; // used during session setup and session verification
	public static String assetName = "Motor";
	public static String testPointName = "Motor";
	
	private static String[] mTabList;
	private static String[] mStudyTypeList;
	private static String[] mUnitList;
	private static String[] mUnitPhaseList;
	public static String mStudyType;
	private static int numberOfRows = 0, 
					  numberOfColumns = 0, 
					  rowPointer = 0, 
					  colPointer = 0;
	private static String mUnitSplitCharacter = " \\(";
	private static String mPhaseStripCharacterFromStart = "\\(";
	private static String mPhaseStripCharacterFromBack = "\\)";
	
	public enum StudyType 
	{
		ES3Phase, ES3PhaseV, ES3PhaseA, ES3PhaseP, ES3PhaseT,
		ES1Phase, ES1PhaseV, ES1PhaseA, ES1PhaseP, ES1PhaseT,
		ESSplitPhase, ESSplitPhaseV, ESSplitPhaseA, ESSplitPhaseP, ESSplitPhaseT,
		ES3PhaseWyeIt, ES3PhaseWyeItV, ES3PhaseWyeItA, ES3PhaseWyeItP, ES3PhaseWyeItT,
		ES3PhaseWyeBal, ES3PhaseWyeBalV, ES3PhaseWyeBalA, ES3PhaseWyeBalP, ES3PhaseWyeBalT,
		ES3PhaseDelta, ES3PhaseDeltaV, ES3PhaseDeltaA, ES3PhaseDeltaP, ES3PhaseDeltaT,
		ES3PhaseDeltaBal, ES3PhaseDeltaBalV, ES3PhaseDeltaBalA, ES3PhaseDeltaBalP, ES3PhaseDeltaBalT,
		ES3Phase2Element, ES3Phase2ElementV, ES3Phase2ElementA, ES3Phase2ElementP, ES3Phase2ElementT,
		ES3PhaseDeltaOL, ES3PhaseDeltaOLV, ES3PhaseDeltaOLA, ES3PhaseDeltaOLP, ES3PhaseDeltaOLT,
		ES3PhaseHighLegDelta, ES3PhaseHighLegDeltaV, ES3PhaseHighLegDeltaA, ES3PhaseHighLegDeltaP, ES3PhaseHighLegDeltaT,
		
		LS1Phase, LS1PhaseV, LS1PhaseP, LS1PhaseT,
		LS3Phase,
		
		ACTIVE_POWER, CURRENT, FREQUENCY, POWER_FACTOR, THDA, THDV, THCA, VOLTAGE, APPARENT_POWER, NON_ACTIVE_POWER,
		NONE
	}
	
	public static Map<StudyType, String[]> androidGraphViewMap = new HashMap<StudyType, String[]>();
    static 
    {
    		androidGraphViewMap.put(StudyType.ES3Phase, new String[] {"V, A, Hz", "Active Power", "Power Overview", "THD/THC"});
    		androidGraphViewMap.put(StudyType.ES1Phase, new String[] {"V, A, Hz", "Active Power", "Power Overview", "THD/THC"});
    		androidGraphViewMap.put(StudyType.ESSplitPhase, new String[] {"V, A, Hz", "Active Power", "Power Overview", "THD/THC"});
    		androidGraphViewMap.put(StudyType.ES3PhaseWyeIt, new String[] {"V, A, Hz", "Active Power", "Power Overview", "THD/THC"});
    		androidGraphViewMap.put(StudyType.ES3PhaseWyeBal, new String[] {"V, A, Hz", "Active Power", "Power Overview", "THD/THC"});
    		androidGraphViewMap.put(StudyType.ES3PhaseDelta, new String[] {"V, A, Hz", "Active Power", "Power Overview", "THD/THC"});
    		androidGraphViewMap.put(StudyType.ES3PhaseDeltaBal, new String[] {"V, A, Hz", "Active Power", "Power Overview", "THD/THC"});
    		androidGraphViewMap.put(StudyType.ES3Phase2Element, new String[] {"V, A, Hz", "Active Power", "Power Overview", "THD/THC"});
    		androidGraphViewMap.put(StudyType.ES3PhaseDeltaOL, new String[] {"V, A, Hz", "Active Power", "Power Overview", "THD/THC"});
    		androidGraphViewMap.put(StudyType.ES3PhaseHighLegDelta, new String[] {"V, A, Hz", "Active Power", "Power Overview", "THD/THC"});
    		
    		androidGraphViewMap.put(StudyType.LS1Phase, new String[] {"V, A, Hz", "Power Overview", "THD/THC"});
    }
    
    public static Map<StudyType, String[]> iOSGraphViewMap = new HashMap<StudyType, String[]>();
    static 
    {
    		iOSGraphViewMap.put(StudyType.ES3Phase, new String[] {"V, A, Hz", "Active Power", "THD/THC", "Power Overview"});
    		iOSGraphViewMap.put(StudyType.ES1Phase, new String[] {"V, A, Hz", "Active Power", "THD/THC", "Power Overview"});
    		iOSGraphViewMap.put(StudyType.ESSplitPhase, new String[] {"V, A, Hz", "Active Power", "THD/THC", "Power Overview"});
    		iOSGraphViewMap.put(StudyType.ES3PhaseWyeIt, new String[] {"V, A, Hz", "Active Power", "THD/THC", "Power Overview"});
    		iOSGraphViewMap.put(StudyType.ES3PhaseWyeBal, new String[] {"V, A, Hz", "Active Power", "THD/THC", "Power Overview"});
    		iOSGraphViewMap.put(StudyType.ES3PhaseDelta, new String[] {"V, A, Hz", "Active Power", "THD/THC", "Power Overview"});
    		iOSGraphViewMap.put(StudyType.ES3PhaseDeltaBal, new String[] {"V, A, Hz", "Active Power", "THD/THC", "Power Overview"});
    		iOSGraphViewMap.put(StudyType.ES3Phase2Element, new String[] {"V, A, Hz", "Active Power", "THD/THC", "Power Overview"});
    		iOSGraphViewMap.put(StudyType.ES3PhaseDeltaOL, new String[] {"V, A, Hz", "Active Power", "THD/THC", "Power Overview"});
    		iOSGraphViewMap.put(StudyType.ES3PhaseHighLegDelta, new String[] {"V, A, Hz", "Active Power", "THD/THC", "Power Overview"});
    
    		iOSGraphViewMap.put(StudyType.LS1Phase, new String[] {"V, A, Hz", "THD/THC", "Power Overview"});
    }
    
    public static Map<StudyType, String[]> webGraphViewMap = new HashMap<StudyType, String[]>();
    static 
    {
    		webGraphViewMap.put(StudyType.ES3Phase, new String[] {"V,A,Hz", "Active Power", "Power Overview", "THD/THC"});
    		webGraphViewMap.put(StudyType.ES1Phase, new String[] {"V,A,Hz", "Active Power", "Power Overview", "THD/THC"});
    		webGraphViewMap.put(StudyType.ESSplitPhase, new String[] {"V,A,Hz", "Active Power", "Power Overview", "THD/THC"});
    		webGraphViewMap.put(StudyType.ES3PhaseWyeIt, new String[] {"V,A,Hz", "Active Power", "Power Overview", "THD/THC"});
    		webGraphViewMap.put(StudyType.ES3PhaseWyeBal, new String[] {"V,A,Hz", "Active Power", "Power Overview", "THD/THC"});
    		webGraphViewMap.put(StudyType.ES3PhaseDelta, new String[] {"V,A,Hz", "Active Power", "Power Overview", "THD/THC"});
    		webGraphViewMap.put(StudyType.ES3PhaseDeltaBal, new String[] {"V,A,Hz", "Active Power", "Power Overview", "THD/THC"});
    		webGraphViewMap.put(StudyType.ES3Phase2Element, new String[] {"V,A,Hz", "Active Power", "Power Overview", "THD/THC"});
    		webGraphViewMap.put(StudyType.ES3PhaseDeltaOL, new String[] {"V,A,Hz", "Active Power", "Power Overview", "THD/THC"});
    		webGraphViewMap.put(StudyType.ES3PhaseHighLegDelta, new String[] {"V,A,Hz", "Active Power", "Power Overview", "THD/THC"});
    
    		webGraphViewMap.put(StudyType.LS1Phase, new String[] {"V,A,Hz", "Power Overview", "THD/THC"});
    }
    
    public static Map<Enum<?>, String[]> androidStudyTypeMap = new HashMap<Enum<?>, String[]>();
    static 
    {
    	//Energy study 3-phase
		androidStudyTypeMap.put(StudyType.ES3PhaseV, new String[] {"Voltage (AB, BC, CA)", "Current (A, B, C)", "Frequency"});
		androidStudyTypeMap.put(StudyType.ES3PhaseA, new String[] {"Active Power (Total)", "Power Factor (Total)"});
		androidStudyTypeMap.put(StudyType.ES3PhaseP, new String[] {"Total (kW, kVA, kvar)", "kW (Total)", "kVA (Total)", "kvar (Total)"});
		androidStudyTypeMap.put(StudyType.ES3PhaseT, new String[] {"THD - V (AB, BC, CA)", "THD - A (A, B, C)", "THC - A (A, B, C)"});
		
		//Energy study Single phase
		androidStudyTypeMap.put(StudyType.ES1PhaseV, new String[] {"Voltage (A)", "Current (A)", "Frequency"});
		androidStudyTypeMap.put(StudyType.ES1PhaseA, new String[] {"Active Power (A)", "Power Factor (A)"});
		androidStudyTypeMap.put(StudyType.ES1PhaseP, new String[] {"Phase A (kW, kVA, kvar)", "kW (A)", "kVA (A)", "kvar (A)"});
		androidStudyTypeMap.put(StudyType.ES1PhaseT, new String[] {"THD - V (A)", "THD - A (A)", "THC - A (A)"});
		
		//Energy study Split Phase
		androidStudyTypeMap.put(StudyType.ESSplitPhaseV, new String[] {"Voltage (A, B, AB)", "Current (A, B)", "Frequency"});
		androidStudyTypeMap.put(StudyType.ESSplitPhaseA, new String[] {"Active Power (A, B, Total)", "Power Factor (A, B, Total)"});
		androidStudyTypeMap.put(StudyType.ESSplitPhaseP, new String[] {"Phase A (kW, kVA, kvar)", "Phase B (kW, kVA, kvar)", "Total (kW, kVA, kvar)", "kW (A, B, Total)", "kVA (A, B, Total)", "kvar (A, B, Total)"});
		androidStudyTypeMap.put(StudyType.ESSplitPhaseT, new String[] {"THD - V (A, B)", "THD - A (A, B)", "THC - A (A, B)"});
		
		//Energy study 3-phase WYE IT
		androidStudyTypeMap.put(StudyType.ES3PhaseWyeItV, new String[] {"Voltage (AB, BC, CA)", "Current (A, B, C)", "Frequency"});
		androidStudyTypeMap.put(StudyType.ES3PhaseWyeItA, new String[] {"Active Power (Total)", "Power Factor (Total)"});
		androidStudyTypeMap.put(StudyType.ES3PhaseWyeItP, new String[] {"Total (kW, kVA, kvar)", "kW (Total)", "kVA (Total)", "kvar (Total)"});
		androidStudyTypeMap.put(StudyType.ES3PhaseWyeItT, new String[] {"THD - V (AB, BC, CA)", "THD - A (A, B, C)", "THC - A (A, B, C)"});
		
		//Energy study 3-Phase WYE Balanced
		androidStudyTypeMap.put(StudyType.ES3PhaseWyeBalV, new String[] {"Voltage (A)", "Current (A)", "Frequency"});
		androidStudyTypeMap.put(StudyType.ES3PhaseWyeBalA, new String[] {"Active Power (A, Total)", "Power Factor (A, Total)"});
		androidStudyTypeMap.put(StudyType.ES3PhaseWyeBalP, new String[] {"Phase A (kW, kVA, kvar)", "Total (kW, kVA, kvar)", "kW (A, Total)", "kVA (A, Total)","kvar (A, Total)"});
		androidStudyTypeMap.put(StudyType.ES3PhaseWyeBalT, new String[] {"THD - V (A)", "THD - A (A)", "THC - A (A)"});
		
		//Energy study 3-phase Delta
		androidStudyTypeMap.put(StudyType.ES3PhaseDeltaV, new String[] {"Voltage (AB, BC, CA)", "Current (A, B, C)", "Frequency"});
		androidStudyTypeMap.put(StudyType.ES3PhaseDeltaA, new String[] {"Active Power (Total)", "Power Factor (Total)"});
		androidStudyTypeMap.put(StudyType.ES3PhaseDeltaP, new String[] {"Total (kW, kVA, kvar)", "kW (Total)", "kVA (Total)", "kvar (Total)"});
		androidStudyTypeMap.put(StudyType.ES3PhaseDeltaT, new String[] {"THD - V (AB, BC, CA)", "THD - A (A, B, C)", "THC - A (A, B, C)"});
		
		//Energy study 3-phase Delta Balanced
		androidStudyTypeMap.put(StudyType.ES3PhaseDeltaBalV, new String[] {"Voltage (AB)", "Current (A)", "Frequency"});
		androidStudyTypeMap.put(StudyType.ES3PhaseDeltaBalA, new String[] {"Active Power (A, Total)", "Power Factor (A, Total)"});
		androidStudyTypeMap.put(StudyType.ES3PhaseDeltaBalP, new String[] {"Total (kW, kVA, kvar)", "kW (Total)", "kVA (Total)", "kvar (Total)"});
		androidStudyTypeMap.put(StudyType.ES3PhaseDeltaBalT, new String[] {"THD - V (AB)","THD - A (A)", "THC - A (A)"});
		
		//Energy study 3 phase 2 element data
		androidStudyTypeMap.put(StudyType.ES3Phase2ElementV, new String[] {"Voltage (AB, BC, CA)", "Current (A, B, C)", "Frequency"});
		androidStudyTypeMap.put(StudyType.ES3Phase2ElementA, new String[] {"Active Power (Total)", "Power Factor (Total)"});
		androidStudyTypeMap.put(StudyType.ES3Phase2ElementP, new String[] {"Total (kW, kVA, kvar)", "kW (Total)", "kVA (Total)", "kvar (Total)"});
		androidStudyTypeMap.put(StudyType.ES3Phase2ElementT, new String[] {"THD - V (AB, BC, CA)", "THD - A (A, B, C)", "THC - A (A, B, C)"});
		
		//Energy study 3 phase delta OL
		androidStudyTypeMap.put(StudyType.ES3PhaseDeltaOLV, new String[] {"Voltage (AB, BC, CA)", "Current (A, B, C)", "Frequency"});
		androidStudyTypeMap.put(StudyType.ES3PhaseDeltaOLA, new String[] {"Active Power (Total)", "Power Factor (Total)"});
		androidStudyTypeMap.put(StudyType.ES3PhaseDeltaOLP, new String[] {"Total (kW, kVA, kvar)", "kW (Total)", "kVA (Total)", "kvar (Total)"});
		androidStudyTypeMap.put(StudyType.ES3PhaseDeltaOLT, new String[] {"THD - V (AB, BC, CA)", "THD - A (A, B, C)", "THC - A (A, B, C)"});
		
		//Energy study 3 phase High Leg Delta
		androidStudyTypeMap.put(StudyType.ES3PhaseHighLegDeltaV, new String[] {"Voltage (AB, BC, CA)", "Current (A, B, C)", "Frequency"});
		androidStudyTypeMap.put(StudyType.ES3PhaseHighLegDeltaA, new String[] {"Active Power (Total)", "Power Factor (Total)"});
		androidStudyTypeMap.put(StudyType.ES3PhaseHighLegDeltaP, new String[] {"Total (kW, kVA, kvar)", "kW (Total)", "kVA (Total)", "kvar (Total)"});
		androidStudyTypeMap.put(StudyType.ES3PhaseHighLegDeltaT, new String[] {"THD - V (AB, BC, CA)", "THD - A (A, B, C)", "THC - A (A, B, C)"});
   
		//Load study Single phase
		androidStudyTypeMap.put(StudyType.LS1PhaseV, new String[] {"Current (A)", "Frequency"});
		androidStudyTypeMap.put(StudyType.LS1PhaseP, new String[] {"Phase A (kVA)", "kVA (A)"});
		androidStudyTypeMap.put(StudyType.LS1PhaseT, new String[] {"THD - A (A)", "THC - A (A)"});
    
    }
    
    public static Map<Enum<?>, String[]> iOSStudyTypeMap = new HashMap<Enum<?>, String[]>();
    static 
    {
    	//Energy study 3-phase
		iOSStudyTypeMap.put(StudyType.ES3PhaseV, new String[] {"Volts (AB, BC, CA)", "Amps (A, B, C)", "Frequency (Hz)"});
		iOSStudyTypeMap.put(StudyType.ES3PhaseP, new String[] {"kW (Total)", "kVA (Total)", "kvar (Total)", "Total (kW, kVA, kvar)"});
		iOSStudyTypeMap.put(StudyType.ES3PhaseT, new String[] {"THD - V (AB, BC, CA)", "THD - A (A, B, C)", "THC - A (A, B, C)"});
		iOSStudyTypeMap.put(StudyType.ES3PhaseA, new String[] {"Active Power (Total)", "Power Factor (Total)"});
		
		//Energy study Split Phase
		iOSStudyTypeMap.put(StudyType.ESSplitPhaseV, new String[] {"Volts (A, B, AB)", "Amps (A, B)", "Frequency (Hz)"});
		iOSStudyTypeMap.put(StudyType.ESSplitPhaseA, new String[] {"Active Power (A, B, Total)", "Power Factor (A, B, Total)"});
		iOSStudyTypeMap.put(StudyType.ESSplitPhaseP, new String[] {"kW (A, B, Total)","kVA (A, B, Total)", "kvar (A, B, Total)", "A (kW, kVA, kvar)", "B (kW, kVA, kvar)", "Total (kW, kVA, kvar)"});
		iOSStudyTypeMap.put(StudyType.ESSplitPhaseT, new String[] {"THD - V (A, B)", "THD - A (A, B)", "THC - A (A, B)"});
    
		//Energy study 3-phase Wye IT
		iOSStudyTypeMap.put(StudyType.ES3PhaseWyeItV, new String[] {"Volts (AB, BC, CA)", "Amps (A, B, C)", "Frequency (Hz)"});
		iOSStudyTypeMap.put(StudyType.ES3PhaseWyeItP, new String[] {"kW (Total)", "kVA (Total)", "kvar (Total)", "Total (kW, kVA, kvar)"});
		iOSStudyTypeMap.put(StudyType.ES3PhaseWyeItT, new String[] {"THD - V (AB, BC, CA)", "THD - A (A, B, C)", "THC - A (A, B, C)"});
		iOSStudyTypeMap.put(StudyType.ES3PhaseWyeItA, new String[] {"Active Power (Total)", "Power Factor (Total)"});
		
		//Energy study 3-Phase WYE Balanced
		iOSStudyTypeMap.put(StudyType.ES3PhaseWyeBalV, new String[] {"Volts (A)", "Amps (A)", "Frequency (Hz)"});
		iOSStudyTypeMap.put(StudyType.ES3PhaseWyeBalA, new String[] {"Active Power (A, Total)", "Power Factor (A, Total)"});
		iOSStudyTypeMap.put(StudyType.ES3PhaseWyeBalP, new String[] {"kW (A, Total)", "kVA (A, Total)", "kvar (A, Total)", "A (kW, kVA, kvar)","Total (kW, kVA, kvar)"});
		iOSStudyTypeMap.put(StudyType.ES3PhaseWyeBalT, new String[] {"THD - V (A)", "THD - A (A)", "THC - A (A)"});
				
		//Energy study 3-phase Delta
		iOSStudyTypeMap.put(StudyType.ES3PhaseDeltaV, new String[] {"Volts (AB, BC, CA)", "Amps (A, B, C)", "Frequency (Hz)"});
		iOSStudyTypeMap.put(StudyType.ES3PhaseDeltaP, new String[] {"kW (Total)", "kVA (Total)", "kvar (Total)", "Total (kW, kVA, kvar)"});
		iOSStudyTypeMap.put(StudyType.ES3PhaseDeltaT, new String[] {"THD - V (AB, BC, CA)", "THD - A (A, B, C)", "THC - A (A, B, C)"});
		iOSStudyTypeMap.put(StudyType.ES3PhaseDeltaA, new String[] {"Active Power (Total)", "Power Factor (Total)"});
		
		//Energy study 3-phase Delta Balanced
		iOSStudyTypeMap.put(StudyType.ES3PhaseDeltaBalV, new String[] {"Volts (AB)", "Amps (A)", "Frequency (Hz)"});
		iOSStudyTypeMap.put(StudyType.ES3PhaseDeltaBalA, new String[] {"Active Power (A, Total)", "Power Factor (A, Total)"});
		iOSStudyTypeMap.put(StudyType.ES3PhaseDeltaBalP, new String[] {"kW (Total)", "kVA (Total)", "kvar (Total)", "Total (kW, kVA, kvar)"});
		iOSStudyTypeMap.put(StudyType.ES3PhaseDeltaBalT, new String[] {"THD - V (AB)", "THD - A (A)", "THC - A (A)"});
		
		//Energy study 3 phase 2 element data
		iOSStudyTypeMap.put(StudyType.ES3Phase2ElementV, new String[] {"Volts (AB, BC, CA)", "Amps (A, B, C)", "Frequency (Hz)"});
		iOSStudyTypeMap.put(StudyType.ES3Phase2ElementA, new String[] {"Active Power (Total)", "Power Factor (Total)"});
		iOSStudyTypeMap.put(StudyType.ES3Phase2ElementP, new String[] {"kW (Total)", "kVA (Total)", "kvar (Total)", "Total (kW, kVA, kvar)"});
		iOSStudyTypeMap.put(StudyType.ES3Phase2ElementT, new String[] {"THD - V (AB, BC, CA)", "THD - A (A, B, C)", "THC - A (A, B, C)"});
		
		//Energy study 3 phase Delta OL
		iOSStudyTypeMap.put(StudyType.ES3PhaseDeltaOLV, new String[] {"Volts (AB, BC, CA)", "Amps (A, B, C)", "Frequency (Hz)"});
		iOSStudyTypeMap.put(StudyType.ES3PhaseDeltaOLA, new String[] {"Active Power (Total)", "Power Factor (Total)"});
		iOSStudyTypeMap.put(StudyType.ES3PhaseDeltaOLP, new String[] {"kW (Total)", "kVA (Total)", "kvar (Total)", "Total (kW, kVA, kvar)"});
		iOSStudyTypeMap.put(StudyType.ES3PhaseDeltaOLT, new String[] {"THD - V (AB, BC, CA)", "THD - A (A, B, C)", "THC - A (A, B, C)"});
		
		//Energy study 3 phase High leg delta
		iOSStudyTypeMap.put(StudyType.ES3PhaseHighLegDeltaV, new String[] {"Volts (AB, BC, CA)", "Amps (A, B, C)", "Frequency (Hz)"});
		iOSStudyTypeMap.put(StudyType.ES3PhaseHighLegDeltaA, new String[] {"Active Power (Total)", "Power Factor (Total)"});
		iOSStudyTypeMap.put(StudyType.ES3PhaseHighLegDeltaP, new String[] {"kW (Total)", "kVA (Total)", "kvar (Total)", "Total (kW, kVA, kvar)"});
		iOSStudyTypeMap.put(StudyType.ES3PhaseHighLegDeltaT, new String[] {"THD - V (AB, BC, CA)", "THD - A (A, B, C)", "THC - A (A, B, C)"});
    
		//Load study Single phase
		iOSStudyTypeMap.put(StudyType.LS1PhaseV, new String[] {"Amps (A)", "Frequency (Hz)"});
		iOSStudyTypeMap.put(StudyType.LS1PhaseP, new String[] {"kVA (A)"});
		iOSStudyTypeMap.put(StudyType.LS1PhaseT, new String[] {"THD - A (A)", "THC - A (A)"});
		
    }
    
    public static Map<Enum<?>, String[]> webStudyTypeMap = new HashMap<Enum<?>, String[]>();
    static 
    {
    	//Energy study 3-phase
    	webStudyTypeMap.put(StudyType.ES3PhaseV, new String[] {"Voltage (AB, BC, CA)", "Current (A, B, C)", "Frequency (Hz)"});
    	webStudyTypeMap.put(StudyType.ES3PhaseA, new String[] {"Active Power (Total)", "Power Factor (Total)"});
    	webStudyTypeMap.put(StudyType.ES3PhaseP, new String[] {"Active Power (Total)", "Apparent Power (Total)", "Non-Active Power (Total)"});
    	webStudyTypeMap.put(StudyType.ES3PhaseT, new String[] {"THD-V (AB, BC, CA)", "THD-A (A, B, C)", "THC-A (A, B, C)"});

    	//Energy study Split Phase
    	webStudyTypeMap.put(StudyType.ESSplitPhaseV, new String[] {"Voltage (A, B, AB)", "Current (A, B)", "Frequency (Hz)"});
    	webStudyTypeMap.put(StudyType.ESSplitPhaseA, new String[] {"Active Power (A, B, Total)", "Power Factor (A, B, Total)"});
    	webStudyTypeMap.put(StudyType.ESSplitPhaseP, new String[] {"Active Power (A, B, Total)", "Apparent Power (A, B, Total)", "Non-Active Power (A, B, Total)"});
    	webStudyTypeMap.put(StudyType.ESSplitPhaseT, new String[] {"THD-V (A, B)", "THD-A (A, B)", "THC-A (A, B)"});

    	//Energy study 3-phase Wye IT
    	webStudyTypeMap.put(StudyType.ES3PhaseWyeItV, new String[] {"Voltage (AB, BC, CA)", "Current (A, B, C)", "Frequency (Hz)"});
    	webStudyTypeMap.put(StudyType.ES3PhaseWyeItA, new String[] {"Active Power (Total)", "Power Factor (Total)"});
    	webStudyTypeMap.put(StudyType.ES3PhaseWyeItP, new String[] {"Active Power (Total)", "Apparent Power (Total)", "Non-Active Power (Total)"});
    	webStudyTypeMap.put(StudyType.ES3PhaseWyeItT, new String[] {"THD-V (AB, BC, CA)", "THD-A (A, B, C)", "THC-A (A, B, C)"});

    	//Energy study 3-phase WYE Balanced
    	webStudyTypeMap.put(StudyType.ES3PhaseWyeBalV, new String[] {"Voltage (A)", "Current (A)", "Frequency (Hz)"});
    	webStudyTypeMap.put(StudyType.ES3PhaseWyeBalA, new String[] {"Active Power (A, Total)", "Power Factor (A, Total)"});
    	webStudyTypeMap.put(StudyType.ES3PhaseWyeBalP, new String[] {"Active Power (A, Total)", "Apparent Power (A, Total)", "Non-Active Power (A, Total)"});
    	webStudyTypeMap.put(StudyType.ES3PhaseWyeBalT, new String[] {"THD-V (A)", "THD-A (A)", "THC-A (A)"});

    	//Energy study 3-phase Delta
    	webStudyTypeMap.put(StudyType.ES3PhaseDeltaV, new String[] {"Voltage (AB, BC, CA)", "Current (A, B, C)", "Frequency (Hz)"});
    	webStudyTypeMap.put(StudyType.ES3PhaseDeltaA, new String[] {"Active Power (Total)", "Power Factor (Total)"});
    	webStudyTypeMap.put(StudyType.ES3PhaseDeltaP, new String[] {"Active Power (Total)", "Apparent Power (Total)", "Non-Active Power (Total)"});
    	webStudyTypeMap.put(StudyType.ES3PhaseDeltaT, new String[] {"THD-V (AB, BC, CA)", "THD-A (A, B, C)", "THC-A (A, B, C)"});

    	// more failures 
    	//Energy study 3-phase Delta
    	webStudyTypeMap.put(StudyType.ES3PhaseDeltaBalV, new String[] {"Voltage (AB)", "Current (A)", "Frequency (Hz)"});
    	webStudyTypeMap.put(StudyType.ES3PhaseDeltaBalA, new String[] {"Active Power (Total)", "Power Factor (Total)"});
    	webStudyTypeMap.put(StudyType.ES3PhaseDeltaBalP, new String[] {"Active Power (Total)", "Apparent Power (Total)", "Non-Active Power (Total)"});
    	webStudyTypeMap.put(StudyType.ES3PhaseDeltaBalT, new String[] {"THD-V (AB)", "THD-A (A)", "THC-A (A)"});

    	//Energy study 3 phase 2 element data
    	webStudyTypeMap.put(StudyType.ES3Phase2ElementV, new String[] {"Voltage (AB, BC, CA)", "Current (A, B, C)", "Frequency (Hz)"});
    	webStudyTypeMap.put(StudyType.ES3Phase2ElementA, new String[] {"Active Power (Total)", "Power Factor (Total)"});
    	webStudyTypeMap.put(StudyType.ES3Phase2ElementP, new String[] {"Active Power (Total)", "Apparent Power (Total)", "Non-Active Power (Total)"});
    	webStudyTypeMap.put(StudyType.ES3Phase2ElementT, new String[] {"THD-V (AB, BC, CA)", "THD-A (A, B, C)", "THC-A (A, B, C)"});

    	//Energy study 3 phase Delta OL
    	webStudyTypeMap.put(StudyType.ES3PhaseDeltaOLV, new String[] {"Voltage (AB, BC, CA)", "Current (A, B, C)", "Frequency (Hz)"});
    	webStudyTypeMap.put(StudyType.ES3PhaseDeltaOLA, new String[] {"Active Power (Total)", "Power Factor (Total)"});
    	webStudyTypeMap.put(StudyType.ES3PhaseDeltaOLP, new String[] {"Active Power (Total)", "Apparent Power (Total)", "Non-Active Power (Total)"});
    	webStudyTypeMap.put(StudyType.ES3PhaseDeltaOLT, new String[] {"THD-V (AB, BC, CA)", "THD-A (A, B, C)", "THC-A (A, B, C)"});

    	//Energy study 3 phase High leg delta
    	webStudyTypeMap.put(StudyType.ES3PhaseHighLegDeltaV, new String[] {"Voltage (AB, BC, CA)", "Current (A, B, C)", "Frequency (Hz)"});
    	webStudyTypeMap.put(StudyType.ES3PhaseHighLegDeltaA, new String[] {"Active Power (Total)", "Power Factor (Total)"});
    	webStudyTypeMap.put(StudyType.ES3PhaseHighLegDeltaP, new String[] {"Active Power (Total)", "Apparent Power (Total)", "Non-Active Power (Total)"});
    	webStudyTypeMap.put(StudyType.ES3PhaseHighLegDeltaT, new String[] {"THD-V (AB, BC, CA)", "THD-A (A, B, C)", "THC-A (A, B, C)"});

    	//Load study Single phase
    	webStudyTypeMap.put(StudyType.LS1PhaseV, new String[] {"Current (A)", "Frequency (Hz)"});
    	webStudyTypeMap.put(StudyType.LS1PhaseP, new String[] {"Apparent Power (A)"});
    	webStudyTypeMap.put(StudyType.LS1PhaseT, new String[] {"THD-A (A)", "THC-A (A)"});
    }
    
    public enum Attributes
	{
    		WEB_ES3_VOLTAGE("Voltage"),
    		WEB_ES3_VOLTAGE_PHASE("AB, BC, CA"), 
    		WEB_ES3_CURRENT("Current"),
    		WEB_ES3_CURRENT_PHASE("A, B, C"),
    		WEB_ES3_FREQUENCY("Frequency"),
    		WEB_ES3_ACTIVE_POWER("Active Power"),
    		WEB_ES3_ACTIVE_POWER_PHASE("Total"),
    		WEB_ES3_POWER_FACTOR("Power Factor"),
    		WEB_ES3_POWER_FACTOR_PHASE("Total"),
    		WEB_ES3_APPARENT_POWER("Apparent Power"),
    		WEB_ES3_APPARENT_POWER_PHASE("Total"),
    		WEB_ES3_NON_ACTIVE_POWER("Non-Active Power"),
    		WEB_ES3_NON_ACTIVE_POWER_PHASE("Total"),
    		WEB_ES3_THDV("THD-V"),
    		WEB_ES3_THDV_PHASE("AB, BC, CA"),
    		WEB_ES3_THDA("THD-A"),
    		WEB_ES3_THDA_PHASE("A, B, C"),
    		WEB_ES3_THCA("THC-A"),
    		WEB_ES3_THCA_PHASE("A, B, C");
	 
	    private String attributeValue;
	 
	    Attributes(String attributeValue) {
	        this.attributeValue = attributeValue;
	    }
	 
	    public String getAttributeValue() {
	        return attributeValue;
	    }
	}
   
    public static String[] getTabList()
    {
    		return new String[] {"1H", "1D", "1W", "1M", "All", "1M", "1W", "1D", "1H"}; 
    }
    
    public static String[] getMobileTabList()
    {
    		return new String[] {"1H", "1D", "1W", "1M", "All"};
    		//return new String[] {"1H"};
    }
    
    public static String[] getWebTabList()
    {
    		//return new String[] {"1H", "1D", "ALL"};
    		return new String[] {"1H","ALL"};
    }
    
    public static String[] getGraphViewList(String studyType)
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			return FCCM3540.androidGraphViewMap.get(StudyType.valueOf(studyType));
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			return FCCM3540.iOSGraphViewMap.get(StudyType.valueOf(studyType));
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			return FCCM3540.webGraphViewMap.get(StudyType.valueOf(studyType));
		return null;
	}
    
    public static String[] getStudyTypeList(String unitType)
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			 return FCCM3540.androidStudyTypeMap.get(StudyType.valueOf(unitType));
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			return FCCM3540.iOSStudyTypeMap.get(StudyType.valueOf(unitType));
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			return FCCM3540.webStudyTypeMap.get(StudyType.valueOf(unitType));
		return null;
	} 
	
	public static String[] getStudyTypeMapKey(String studyType)
	{
		switch(studyType)
		{
		case "ES3Phase":
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				return new String[] {"ES3PhaseV", "ES3PhaseA", "ES3PhaseP", "ES3PhaseT"};
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				return new String[] {"ES3PhaseV", "ES3PhaseA", "ES3PhaseT", "ES3PhaseP"};
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				return new String[] {"ES3PhaseV", "ES3PhaseA", "ES3PhaseP", "ES3PhaseT"};
		case "ES1Phase":
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				return new String[] {"ES1PhaseV", "ES1PhaseA", "ES1PhaseP", "ES1PhaseT"};
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				return new String[] {"ES1PhaseV", "ES1PhaseA", "ES1PhaseT", "ES1PhaseP"};
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				return new String[] {"ES1PhaseV", "ES1PhaseA", "ES1PhaseP", "ES1PhaseT"};
		case "ESSplitPhase":
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				return new String[] {"ESSplitPhaseV", "ESSplitPhaseA", "ESSplitPhaseP", "ESSplitPhaseT"};
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				return new String[] {"ESSplitPhaseV", "ESSplitPhaseA", "ESSplitPhaseT", "ESSplitPhaseP"};
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				return new String[] {"ESSplitPhaseV", "ESSplitPhaseA", "ESSplitPhaseP", "ESSplitPhaseT"};
		case "ES3PhaseWyeIt":
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				return new String[] {"ES3PhaseWyeItV", "ES3PhaseWyeItA", "ES3PhaseWyeItP", "ES3PhaseWyeItT"};
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				return new String[] {"ES3PhaseWyeItV", "ES3PhaseWyeItA", "ES3PhaseWyeItT", "ES3PhaseWyeItP"};
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				return new String[] {"ES3PhaseWyeItV", "ES3PhaseWyeItA", "ES3PhaseWyeItP", "ES3PhaseWyeItT"};			
		case "ES3PhaseWyeBal":
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				return new String[] {"ES3PhaseWyeBalV", "ES3PhaseWyeBalA", "ES3PhaseWyeBalP", "ES3PhaseWyeBalT"};
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				return new String[] {"ES3PhaseWyeBalV", "ES3PhaseWyeBalA", "ES3PhaseWyeBalT", "ES3PhaseWyeBalP"};
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				return new String[] {"ES3PhaseWyeBalV", "ES3PhaseWyeBalA", "ES3PhaseWyeBalP", "ES3PhaseWyeBalT"};			
		case "ES3PhaseDelta":
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				return new String[] {"ES3PhaseDeltaV", "ES3PhaseDeltaA", "ES3PhaseDeltaP", "ES3PhaseDeltaT"};
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				return new String[] {"ES3PhaseDeltaV", "ES3PhaseDeltaA", "ES3PhaseDeltaT", "ES3PhaseDeltaP"};
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				return new String[] {"ES3PhaseDeltaV", "ES3PhaseDeltaA", "ES3PhaseDeltaP", "ES3PhaseDeltaT"};			
		case "ES3PhaseDeltaBal":
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				return new String[] {"ES3PhaseDeltaBalV", "ES3PhaseDeltaBalA", "ES3PhaseDeltaBalP", "ES3PhaseDeltaBalT"};
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				return new String[] {"ES3PhaseDeltaBalV", "ES3PhaseDeltaBalA", "ES3PhaseDeltaBalT", "ES3PhaseDeltaBalP"};
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				return new String[] {"ES3PhaseDeltaBalV", "ES3PhaseDeltaBalA", "ES3PhaseDeltaBalP", "ES3PhaseDeltaBalT"};			
		case "ES3Phase2Element":
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				return new String[] {"ES3Phase2ElementV", "ES3Phase2ElementA", "ES3Phase2ElementP", "ES3Phase2ElementT"};
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				return new String[] {"ES3Phase2ElementV", "ES3Phase2ElementA", "ES3Phase2ElementT", "ES3Phase2ElementP"};
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				return new String[] {"ES3Phase2ElementV", "ES3Phase2ElementA", "ES3Phase2ElementP", "ES3Phase2ElementT"};			
		case "ES3PhaseDeltaOL":
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				return new String[] {"ES3PhaseDeltaOLV", "ES3PhaseDeltaOLA", "ES3PhaseDeltaOLP", "ES3PhaseDeltaOLT"};
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				return new String[] {"ES3PhaseDeltaOLV", "ES3PhaseDeltaOLA", "ES3PhaseDeltaOLT", "ES3PhaseDeltaOLP"};
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				return new String[] {"ES3PhaseDeltaOLV", "ES3PhaseDeltaOLA", "ES3PhaseDeltaOLP", "ES3PhaseDeltaOLT"};			
		case "ES3PhaseHighLegDelta":
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				return new String[] {"ES3PhaseHighLegDeltaV", "ES3PhaseHighLegDeltaA", "ES3PhaseHighLegDeltaP", "ES3PhaseHighLegDeltaT"};
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				return new String[] {"ES3PhaseHighLegDeltaV", "ES3PhaseHighLegDeltaA", "ES3PhaseHighLegDeltaT", "ES3PhaseHighLegDeltaP"};
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				return new String[] {"ES3PhaseHighLegDeltaV", "ES3PhaseHighLegDeltaA", "ES3PhaseHighLegDeltaP", "ES3PhaseHighLegDeltaT"};			
			//LS1Phase
		case "LS1Phase":
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				return new String[] {"LS1PhaseV", "LS1PhaseP", "LS1PhaseT"};
			else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				return new String[] {"LS1PhaseV", "LS1PhaseT", "LS1PhaseP"};
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				return new String[] {"LS1PhaseV", "LS1PhaseP", "LS1PhaseT"};			
		}
		return null;
	}
	
	public static String getMeasurementValueUnit(String studyTypeMapValue)  {
		switch(studyTypeMapValue) {
		case "Voltage (AB, BC, CA)":
			return "V";
		case "Current (A, B, C)":
			return "A";
		case "Frequency (Hz)":
			return "Hz";
		default:
			return "";
		}
    }
	
	public static String[] getPhaseList(String studyTypeMapValue)  {
		switch(studyTypeMapValue) {
		case "Voltage (AB, BC, CA)":
			return new String[] {"AB", "BC", "CA"};
		case "Current (A, B, C)":
			return new String[] {"A", "B", "C"};
		default:
			return new String[] {""};
		}
    }
	
	 @DataProvider(name = "mobileTestData")
		public Object[][] getMobileTestData()
		{
			return mobileDataProvider();
		}
	    
	    public Object[][] mobileDataProvider()
	    {
	    		mStudyTypeList = getGraphViewList(mStudyType);
	    		mUnitList = getStudyTypeMapKey(mStudyType);
	    		mTabList = FCCM3540.getMobileTabList();
	    		numberOfRows = getMobileDatProviderRowsCount();
	    		numberOfColumns = getMobileDatProviderColsCount();
	    		String[][] mobileTestDataProvider = new String[numberOfRows][numberOfColumns];
	    		for(int i = 0; i < mTabList.length; i++)
	    		{
	    			for(int j = 0; j < mStudyTypeList.length; j++)    
	    			{
	    				mUnitPhaseList = null;
	    				mUnitPhaseList = getStudyTypeList(mUnitList[j]);    
	    				for(String unitPhaseValue:mUnitPhaseList)								
	    				{
	    					mobileTestDataProvider[rowPointer][colPointer] = mTabList[i];
	    					colPointer++;
	    					mobileTestDataProvider[rowPointer][colPointer] = mStudyTypeList[j];
	    					colPointer++;
	    					mobileTestDataProvider[rowPointer][colPointer] = unitPhaseValue;
	    					colPointer++;
	    					mobileTestDataProvider[rowPointer][colPointer] = getUnit(unitPhaseValue);
	    					colPointer++;
	    					mobileTestDataProvider[rowPointer][colPointer] = getPhase(unitPhaseValue);
	    					colPointer = 0;
	    					rowPointer++;
	    				}
	    			}
	    		}
	    		return mobileTestDataProvider;
	    }
	    
	    @DataProvider(name = "webTestData")
		public Object[][] getWebTestData()
		{
			return webDataProvider();
		}
	    
	    public Object[][] webDataProvider()  //Sample output for ES3Phase --> R1 --> 1H, 'V,A,Hz', Voltage, AB, BC, CA --> R2 --> 1H, 'V,A,Hz', Current, A, B, C
	    {
	    		mStudyTypeList = getGraphViewList(mStudyType);
	    		mUnitList = getStudyTypeMapKey(mStudyType);
	    		mTabList = FCCM3540.getWebTabList();
	    		numberOfRows = getWebDatProviderRowsCount();
	    		numberOfColumns = getWebDatProviderColsCount();
	    		String[][] webDataProvider = new String[numberOfRows][numberOfColumns];
	    		
	    				for(int i = 0; i < mStudyTypeList.length; i++)
	    				{
	    					String[] unitPhaseList = getStudyTypeList(mUnitList[i]);
	    					for(int j = 0; j < mTabList.length; j++)     
	    					{
	    						for(int k = 0; k < unitPhaseList.length; k++)
	    						{
	    	    						String unitPhaseValue = unitPhaseList[k];
	    	    						webDataProvider[rowPointer][colPointer] = mStudyTypeList[i];
	    	    						colPointer++;
	    	    						webDataProvider[rowPointer][colPointer] = mTabList[j];
	    	    						colPointer++;
	    	    						webDataProvider[rowPointer][colPointer] = getUnit(unitPhaseValue);
	    	    						colPointer++;
	    	    						webDataProvider[rowPointer][colPointer] = getPhase(unitPhaseValue);
	    	    						colPointer = 0;
	    	    						rowPointer++;
	    						}
	    					}
	    				}
	    		return webDataProvider;
	    }
	    
	    
		private int getMobileDatProviderRowsCount()
	    {
	    		int rowsCount = 0;
	    		for(String unitList:mUnitList)
	    		{
	    			rowsCount += getStudyTypeList(unitList).length * FCCM3540.getMobileTabList().length;
	    		}
	    		return rowsCount;
	    }
	    
	    private int getMobileDatProviderColsCount()
	    {
	    		return 5;
	    }
	    
	    private int getWebDatProviderRowsCount()
	    {
	    		int rowsCount = 0;
	    		for(String unitList:mUnitList)
	    		{
	    			rowsCount += getStudyTypeList(unitList).length;
	    		}
	    		return rowsCount * FCCM3540.getWebTabList().length;
	    }
	    
	    private int getWebDatProviderColsCount()
	    {
	    		return 4;
	    }
	    
	    private String getUnit(String unitPhaseValue) //returns Voltage
	    {
	    		if(unitPhaseValue.split(mUnitSplitCharacter).length > 0)
	    		 	return unitPhaseValue.split(mUnitSplitCharacter)[0];
	    		else
	    			return unitPhaseValue;
	    }
	    
	    private String getPhase(String unitPhaseValue)   //returns value AB, BC, CA
	    {
	    	if(unitPhaseValue.split(" ").length > 1)
			{
			 	String phaseString = StringUtils.strip(unitPhaseValue.split(mUnitSplitCharacter)[unitPhaseValue.split(mUnitSplitCharacter).length-1], mPhaseStripCharacterFromStart);
			 	return StringUtils.strip(phaseString, mPhaseStripCharacterFromBack);
			}
			else
				return unitPhaseValue;
	    }
	    
	    
}
