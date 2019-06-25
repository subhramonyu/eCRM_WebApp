package com.fluke.connect.app.functional.client.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.fluke.connect.app.testdata.FCCM3540.StudyType;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.ScrollDiection;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SessionDetailPage3540 extends SessionDetailPage
{
	private SessionDetailPage sessionDetailPage3540;
	
	@AndroidFindBy(id = "study_type_spinner_layout")
	@iOSXCUITFindBy(accessibility = "Graph View")
	private WebElement studyTypeSpinner;

	@AndroidFindBy(id = "unit_type_spinner_layout")
	@iOSXCUITFindBy(iOSNsPredicate = "name ENDSWITH 'Option'")
	private WebElement unitTypeSpinner;

	@FindBy(how = How.CSS, using = ".channel-AB")
	private List<WebElement> phaseABList;

	@FindBy(how = How.CSS, using = ".channel-BC")
	private List<WebElement> phaseBCList;

	@FindBy(how = How.CSS, using = ".channel-CA")
	private List<WebElement> phaseCAList;

	@FindBy(how = How.CSS, using = ".channel-total-green")
	private List<WebElement> phaseTotalList;

	@FindBy(how = How.CSS, using = ".border-title-bottom-black")
	private List<WebElement> unitList;

	@FindBy(how = How.CSS, using = ".border-title-bottom-green")
	private List<WebElement> unitListFrequency;

	@FindBy(how = How.CSS, using = "input[id ^= radiobtns_VOLTAGE] + div > div .power-range-value")
	private List<WebElement> voltageValueList;
	
	@FindBy(how = How.CSS, using = "input[id ^= radiobtns_VOLTAGE]")
	private List<WebElement> voltageRadioButtonList;
	
	@FindBy(how = How.CSS, using = "input[id ^= radiobtns_VOLTAGE] + div > div .current-graph-unit-style")
	@iOSXCUITFindBy(iOSNsPredicate = "name = 'V' AND visible = true")
	private List<WebElement> voltageUnitList;

	@FindBy(how = How.CSS, using = "input[id ^= radiobtns_CURRENT] + div > div .power-range-value")
	private List<WebElement> currentValueList;
	
	@FindBy(how = How.CSS, using = "input[id ^= radiobtns_CURRENT]")
	private List<WebElement> currentRadioButtonList;
	
	@FindBy(how = How.CSS, using = "input[id ^= radiobtns_CURRENT] + div > div .current-graph-unit-style")
	@iOSXCUITFindBy(iOSNsPredicate = "name = 'A' AND visible = true")
	private List<WebElement> currentUnitList;

	@FindBy(how = How.CSS, using = "input[id ^= radiobtns_FREQUENCY] + div > div .power-range-value")
	private List<WebElement> frequencyValueList;
	
	@FindAll({	@FindBy(how = How.CSS, using = "input[id ^= radiobtns1_ACTIVE_POWER] + div > div .power-range-value"),
				@FindBy(how = How.CSS, using = "input[id ^= radiobtns2_ACTIVE_POWER] + div > div .power-range-value")
			})
	private List<WebElement> activePowerValueList;
	
	@FindBy(how = How.CSS, using = ".graphFilterValueUnit")
	private WebElement activePowerUnit;
	
	@FindBy(how = How.CSS, using = "input[id ^= radiobtns1_POWER_FACTOR] + div > div .power-range-value")
	private List<WebElement> powerFactorValueList;
	
	@FindBy(how = How.CSS, using = "input[id ^= radiobtns2_APPARENT_POWER] + div > div .power-range-value")
	private List<WebElement> apparentPowerValueList;
	
	@FindBy(how = How.CSS, using = "input[id ^= radiobtns2_NON_ACTIVE_POWER] + div > div .power-range-value")
	private List<WebElement> nonActivePowerValueList;
	
	@FindBy(how = How.CSS, using = "input[id ^= radiobtns3_THD_VOLTAGE] + div > div .power-range-value")
	private List<WebElement> thdVValueList;
	
	@FindBy(how = How.CSS, using = "input[id ^= radiobtns3_THD_CURRENT] + div > div .power-range-value")
	private List<WebElement> thdAValueList;
	
	@FindBy(how = How.CSS, using = "input[id ^= radiobtns3_HARMONIC] + div > div .power-range-value")
	private List<WebElement> thcAValueList;

	@FindBy(how = How.CSS, using = "input[id ^= radiobtns_FREQUENCY]")
	private List<WebElement> frequencyRadioButtonList;
	
	@FindAll({	@FindBy(how = How.CSS, using = "input[id ^= radiobtns1_ACTIVE_POWER]"),
				@FindBy(how = How.CSS, using = "input[id ^= radiobtns2_ACTIVE_POWER]")
	})
	private List<WebElement> activePowerRadioButtonList;
	
	@FindBy(how = How.CSS, using = "input[id ^= radiobtns2_ACTIVE_POWER]")
    private List<WebElement> powerOverviewActivePowerRadioButtonList;

	@FindBy(how = How.CSS, using = "input[id ^= radiobtns1_POWER_FACTOR]")
	private List<WebElement> powerFactorRadioButtonList;
	
	@FindBy(how = How.CSS, using = "input[id ^= radiobtns2_APPARENT_POWER]")
	private List<WebElement> apparentPowerRadioButtonList;
	
	@FindBy(how = How.CSS, using = "input[id ^= radiobtns2_NON_ACTIVE_POWER]")
	private List<WebElement> nonActivePowerRadioButtonList;
	
	@FindBy(how = How.CSS, using = "input[id ^= radiobtns3_THD_VOLTAGE]")
	private List<WebElement> thdVRadioButtonList;
	
	@FindBy(how = How.CSS, using = "input[id ^= radiobtns3_THD_CURRENT]")
	private List<WebElement> thdARadioButtonList;
	
	@FindBy(how = How.CSS, using = "input[id ^= radiobtns3_HARMONIC]")
	private List<WebElement> thcARadioButtonList;
	
	@FindBy(how = How.CSS, using = ".graphFilterValueUnit")
	private WebElement graphUnit;

	@FindBy(how = How.CSS, using = "input[id ^= radiobtns_FREQUENCY] + div > div .current-graph-unit-style")
	@iOSXCUITFindBy(iOSNsPredicate = "name = 'Hz' AND visible = true")
	private List<WebElement> frequencyUnitList;
	
	@FindBy(how = How.CSS, using = "input[id ^= radiobtns1_ACTIVE_POWER] + div > div .current-graph-unit-style")
	@iOSXCUITFindBy(iOSNsPredicate = "name = 'kW' AND visible = true")
    private List<WebElement> activePowerUnitList;
	
	@FindBy(how = How.CSS, using = "input[id ^= radiobtns2_ACTIVE_POWER] + div > div .current-graph-unit-style")
	@iOSXCUITFindBy(iOSNsPredicate = "name = 'kW' AND visible = true")
    private List<WebElement> activePowerOverviewUnitList;

	@FindBy(how = How.CSS, using = "input[id ^= radiobtns1_POWER_FACTOR] + div > div .current-graph-unit-style")
	private List<WebElement> powerFactorUnitList;
	
	@FindBy(how = How.CSS, using = "input[id ^= radiobtns2_APPARENT_POWER] + div > div .current-graph-unit-style")
	@iOSXCUITFindBy(iOSNsPredicate = "name = 'kVA' AND visible = true")
	private List<WebElement> apparentPowerUnitList;
	
	@FindBy(how = How.CSS, using = "input[id ^= radiobtns2_NON_ACTIVE_POWER] + div > div .current-graph-unit-style")
	@iOSXCUITFindBy(iOSNsPredicate = "name = 'kvar' AND visible = true")
	private List<WebElement> nonActivePowerUnitList;
	
	@FindBy(how = How.CSS, using = "input[id ^= radiobtns3_THD_VOLTAGE] + div > div .current-graph-unit-style")
	@iOSXCUITFindBy(iOSNsPredicate = "name = '%' AND visible = true")
	private List<WebElement> thdVUnitList;
	
	@FindBy(how = How.CSS, using = "input[id ^= radiobtns3_THD_CURRENT] + div > div .current-graph-unit-style")
	@iOSXCUITFindBy(iOSNsPredicate = "name = '%' AND visible = true")
	private List<WebElement> thdAUnitList;
	
	@FindBy(how = How.CSS, using = "input[id ^= radiobtns3_HARMONIC] + div > div .current-graph-unit-style")
	@iOSXCUITFindBy(iOSNsPredicate = "name = 'A' AND visible = true")
	private List<WebElement> thcAUnitList;
	
	@iOSXCUITFindBy(accessibility = "voltage")
	private WebElement studyTypeVoltage;
	
	@iOSXCUITFindBy(accessibility = "thd - v")
	private WebElement studyTypeTHDV;
	
	@iOSXCUITFindBy(accessibility = "thd - a")
	private WebElement studyTypeTHDA;
	
	@iOSXCUITFindBy(accessibility = "power factor")
	private WebElement studyTypePowerFactor;
	
	@iOSXCUITFindBy(accessibility = "frequency")
	private WebElement studyTypeFrequency;
	
	@iOSXCUITFindBy(accessibility = "current")
	private WebElement studyTypeCurrent;
	
	@iOSXCUITFindBy(accessibility = "active power")
	private WebElement studyTypeActivePower;
	
	@FindBy(how = How.CSS, using = ".power-menu-indicator")
	private WebElement addAlarmWebLink;
	
	@FindBy(how = How.CSS, using = ".common-button")
	private WebElement addAlarmButtonForWeb;
	
	@FindBy(how = How.CSS, using = "div[conf-type=above]")
	private WebElement aboveVoltageAlarmSection;
	
	@FindBy(how = How.XPATH, using = "//div[@id=\"add_alarm_conf\"]/div[@class=\"buttons\"]/a[@data-action = \"cancel\"]")
	private WebElement cancelAlarmButton;
	
	@FindBy(how = How.CSS, using = "#above_range")
	private WebElement upperRangeEditBox;
	
	@FindBy(how = How.CSS, using = "#above_range_unit")
	private WebElement aboveRangeDropDown;
	
	@FindBy(how = How.CSS, using = ".alarm-unit-list-item")
	private List<WebElement> alarmUnitList;
	
	@FindBy(how = How.CSS, using = "#alarmConfNext")
	private WebElement nextButtonOnAddAlarm;
	
	@FindBy(how = How.XPATH, using = "//input[@name=\"notify_self_toggle\"]")
	private WebElement notifyMeCheckBox;
	
	@FindBy(how = How.CSS, using = "#btnSaveAlarm")
	private WebElement saveButtonOnAddAlarm;
	
	@FindBy(how = How.CSS, using = "#AllFilter")
	private WebElement allTabOnGraph;
	
	@FindBy(how = How.XPATH, using = "//span[@id=\"1HFilter\"]")
	private WebElement oneHourTabOnGraph;
	
	@FindBy(how = How.XPATH, using = "//div[@class=\"sessionDetailsAlarmsInfo\"]//div[@class=\"alarmsIcon\"]")
	private WebElement alarmIconAboveGraph;
	
	@FindBy(how = How.CSS, using = ".menuItemTitle")
	private WebElement firstItemInAlarmList;
	
	@FindBy(how = How.CSS, using = ".c3")
	private WebElement first3DotItemInAddEditAlarmList;
	
	@FindBy(how = How.XPATH, using = "//li[@data-value=\"edit-alarm\"]")
	private WebElement editAlarmLink;
	
	@FindBy(how = How.XPATH, using = "//li[@data-value=\"delete-alarm\"]")
	private WebElement deleteAlarmLink;
	
	@FindBy(how = How.CSS, using = "#deleteAlarmButton")
	private WebElement deleteButton;
	
	@iOSXCUITFindBy(iOSNsPredicate = "name == 'Cancel'")
	private WebElement cancelButton;
	
	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name ENDSWITH ')'")
	private List<WebElement> iOSStudyTpeList;
	private boolean graphDisplayedFlag;

	private int contentValidationCounter = 0;
	
	private boolean contentValidationFlag = false;

	public SessionDetailPage3540()
	{
		CommonUtils.initElements(this, 15);
		sessionDetailPage3540 = new SessionDetailPage();
	}

	public enum SessionDetailPage3540ObjectList
	{
		STUDY_TYPE_SPINNER, UNIT_TYPE_SPINNER, CANCEL_BUTTON,
		WEB_VOLTAGE_VALUE_LIST, VOLTAGE_VALUE_UNIT, WEB_VOLTAGE_RADIO_BUTTON_LIST,
		WEB_CURRENT_VALUE_LIST, CURRENT_VALUE_UNIT, WEB_CURRENT_RADIO_BUTTON_LIST,
		WEB_FREQUENCY_VALUE_LIST, FREQUENCY_VALUE_UNIT, WEB_FREQUENCY_RADIO_BUTTON_LIST,
		WEB_ACTIVE_POWER_VALUE_LIST, ACTIVE_POWER_VALUE_UNIT, WEB_ACTIVE_POWER_RADIO_BUTTON_LIST,
		WEB_POWER_FACTOR_VALUE_LIST, POWER_FACTOR_VALUE_UNIT, WEB_POWER_FACTOR_RADIO_BUTTON_LIST,
		WEB_APPARENT_POWER_VALUE_LIST, APPARENT_POWER_VALUE_UNIT, WEB_APPARENT_POWER_RADIO_BUTTON_LIST,
		WEB_NON_ACTIVE_POWER_VALUE_LIST, NON_ACTIVE_POWER_VALUE_UNIT, WEB_NON_ACTIVE_POWER_RADIO_BUTTON_LIST,
		WEB_THDV_VALUE_LIST, THDV_VALUE_UNIT, WEB_THDV_RADIO_BUTTON_LIST,
		WEB_THDA_VALUE_LIST, THDA_VALUE_UNIT, WEB_THDA_RADIO_BUTTON_LIST,
		WEB_THCA_VALUE_LIST, THCA_VALUE_UNIT, WEB_THCA_RADIO_BUTTON_LIST,
		IOS_STUDY_TYPE_LIST
	}

	public WebElement getSessionDetailPage3540Object(SessionDetailPage3540ObjectList objectName)
	{
		switch(objectName)
		{
		case STUDY_TYPE_SPINNER:
			return studyTypeSpinner;
		case UNIT_TYPE_SPINNER:
			return unitTypeSpinner;
		case CANCEL_BUTTON:
			return cancelButton;
		default:
			return null;
		}
	}
	
	public List<WebElement> getSessionDetailPage3540Objects(SessionDetailPage3540ObjectList objectName)
	{
		switch(objectName)
		{
		case WEB_VOLTAGE_VALUE_LIST:
			return voltageValueList;
		case WEB_VOLTAGE_RADIO_BUTTON_LIST:
			return voltageRadioButtonList;
		case VOLTAGE_VALUE_UNIT:
			return voltageUnitList;
		case WEB_CURRENT_VALUE_LIST:
			return currentValueList;
		case WEB_CURRENT_RADIO_BUTTON_LIST:
			return currentRadioButtonList;
		case CURRENT_VALUE_UNIT:
			return currentUnitList;
		case WEB_FREQUENCY_VALUE_LIST:
			return frequencyValueList;
		case WEB_FREQUENCY_RADIO_BUTTON_LIST:
			return frequencyRadioButtonList;
		case FREQUENCY_VALUE_UNIT:
			return frequencyUnitList;
		case WEB_ACTIVE_POWER_VALUE_LIST:
			return activePowerValueList;
		case WEB_ACTIVE_POWER_RADIO_BUTTON_LIST:
			return activePowerRadioButtonList;
		case ACTIVE_POWER_VALUE_UNIT:
			return activePowerUnitList;
		case WEB_POWER_FACTOR_VALUE_LIST:
			return powerFactorValueList;
		case WEB_POWER_FACTOR_RADIO_BUTTON_LIST:
			return powerFactorRadioButtonList;
		case POWER_FACTOR_VALUE_UNIT:
			return powerFactorUnitList;
		case WEB_APPARENT_POWER_VALUE_LIST:
			return apparentPowerValueList;
		case WEB_APPARENT_POWER_RADIO_BUTTON_LIST:
			return apparentPowerRadioButtonList;
		case APPARENT_POWER_VALUE_UNIT:
			return apparentPowerUnitList;
		case WEB_NON_ACTIVE_POWER_VALUE_LIST:
			return nonActivePowerValueList;
		case WEB_NON_ACTIVE_POWER_RADIO_BUTTON_LIST:
			return nonActivePowerRadioButtonList;
		case NON_ACTIVE_POWER_VALUE_UNIT:
			return nonActivePowerUnitList;
		case WEB_THDV_VALUE_LIST:
			return thdVValueList;
		case WEB_THDV_RADIO_BUTTON_LIST:
			return thdVRadioButtonList;
		case THDV_VALUE_UNIT:
			return thdVUnitList;
		case WEB_THDA_VALUE_LIST:
			return thdAValueList;
		case WEB_THDA_RADIO_BUTTON_LIST:
			return thdARadioButtonList;
		case THDA_VALUE_UNIT:
			return thdAUnitList;
		case WEB_THCA_VALUE_LIST:
			return thcAValueList;
		case WEB_THCA_RADIO_BUTTON_LIST:
			return thcARadioButtonList;
		case THCA_VALUE_UNIT:
			return thcAUnitList;
		case IOS_STUDY_TYPE_LIST:
			return iOSStudyTpeList;
		default:
			return null;
		}
	}

	public String getUnit(String phaseValue)
	{
		switch(phaseValue)
		{
		case "Voltage":
			return "V";
		case "Volts":
			return "V";
		case "Current":
			return "A";
		case "Amps":
			return "A";
		case "Frequency":
			return "Hz";
		case "Active Power":
			return "kW";
		case "Power Factor":
			return "";
		case "Apparent Power":
			return "kVA";
		case "Non-Active Power":
			return "kvar";
		case "THD - V":
		case "THD-V":
			return "%";
		case "THD - A":
		case "THD-A":
			return "%";
		case "THC - A":
		case "THC-A":
			return "A";
		case "kW":
			return "kW";
		case "kVA":
			return "kVA";
		case "kvar":
			return "kvar";
		case "Total":
			return "kW";
		default:
			return "";
		}
	}
	
	public String getUnit(StudyType phaseValue)
	{
		switch(phaseValue)
		{
		case VOLTAGE:
			return "V";
		case CURRENT:
			return "A";
		case FREQUENCY:
			return "Hz";
		case ACTIVE_POWER:
			return "kW";
		case POWER_FACTOR:
			return "Total";
		case APPARENT_POWER:
			return "kVA";
		case NON_ACTIVE_POWER:
			return "kvar";
		case THDV:
			return "%";
		case THDA:
			return "%";
		case THCA:
			return "A";
		default:
			return "";
		}
	}

	 public String getPhase(String studyType, StudyType unit)
	    {
	    		if(studyType.equals("ES3Phase") && unit == StudyType.VOLTAGE)
	    			return "AB, BC, CA";
	    		else if(studyType.equals("ES3Phase") && unit == StudyType.CURRENT)
	    			return "A, B, C";
	    		else if(studyType.equals("ES3Phase") && unit == StudyType.ACTIVE_POWER)
	    			return "Total,";
	    		else if(studyType.equals("ES3Phase") && unit == StudyType.POWER_FACTOR)
	    			return "Total,";
	    		else if(studyType.equals("ES3Phase") && unit == StudyType.APPARENT_POWER)
	    			return "Total,";
	    		else if(studyType.equals("ES3Phase") && unit == StudyType.NON_ACTIVE_POWER)
	    			return "Total,";
	    		else if(studyType.equals("ES3Phase") && unit == StudyType.THDV)
	    			return "AB, BC, CA";
	    		else if(studyType.equals("ES3Phase") && unit == StudyType.THDA)
	    			return "A, B, C";
	    		else if(studyType.equals("ES3Phase") && unit == StudyType.THCA)
	    			return "A, B, C";
	    		else 
	    		return "";
	    }
	 
	 public String getUnitHeader(String studyType, StudyType unit)
	    {
	    		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
	    			if(studyType.equals("ES3Phase") && (unit == StudyType.VOLTAGE || unit == StudyType.CURRENT))
		    			return "Voltage, Current, Frequency";
		    		else if(studyType.equals("ES3Phase") && (unit == StudyType.ACTIVE_POWER || unit == StudyType.POWER_FACTOR))
		    			return "Active Power, Power Factor";
		    		else if(studyType.equals("ES3Phase") && (unit == StudyType.APPARENT_POWER || unit == StudyType.NON_ACTIVE_POWER))
		    			return "Active Power, Apparent Power, Non-Active Power";
		    		else if(studyType.equals("ES3Phase") && (unit == StudyType.THDV || unit == StudyType.THDA || unit == StudyType.THCA))
		    			return "THD-V, THD-A, THC-A";
	    		}
	    		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
	    			if(studyType.equals("ES3Phase") && (unit == StudyType.VOLTAGE || unit == StudyType.CURRENT))
		    			return "Voltage, Current";
		    		else if(studyType.equals("ES3Phase") && (unit == StudyType.ACTIVE_POWER || unit == StudyType.POWER_FACTOR))
		    			return "Active Power, Power Factor";
		    		else if(studyType.equals("ES3Phase") && (unit == StudyType.APPARENT_POWER || unit == StudyType.NON_ACTIVE_POWER))
		    			return "kW, kVA, kvar";
		    		else if(studyType.equals("ES3Phase") && (unit == StudyType.THDV || unit == StudyType.THDA || unit == StudyType.THCA))
		    			return "V - THD, A - THD, A - THC";
	    		}
	    		return "";
	    }

	public boolean isGraphDisplayed(String objectName, String scrollString, int iOSScrollSteps, int androidScrollDownSteps, int scrollCount, int flexibleScrollSteps)
	{
		graphDisplayedFlag = false;
		graphDisplayedFlag = getGraphObject().isDisplayed();
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			graphDisplayedFlag = webGraphLines.isDisplayed();
		}
		return graphDisplayedFlag;
	}

	public boolean isGraphDisplayed()
	{
		graphDisplayedFlag = false;
		graphDisplayedFlag = getGraphObject().isDisplayed();
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			graphDisplayedFlag = webGraphLines.isDisplayed();
		return graphDisplayedFlag;
	}

	public boolean isPhaseDisplayed(String expectedPhaseValue)
	{
		contentValidationCounter = 0;
		switch(expectedPhaseValue)
		{
		case "A":
		case "AB":
			for(WebElement phaseAB:phaseABList)
			{
				if(phaseAB.isDisplayed() && phaseAB.getText().equals(expectedPhaseValue))
					contentValidationCounter++;
			}
			if(contentValidationCounter == 1)
				return true;
			else
				return false;
		case "B":
		case "BC":
			for(WebElement phaseBC:phaseBCList)
			{
				if(phaseBC.isDisplayed() && phaseBC.getText().equals(expectedPhaseValue))
					contentValidationCounter++;
			}
			if(contentValidationCounter == 1)
				return true;
			else
				return false;
		case "C":
		case "CA":
			for(WebElement phaseCA:phaseCAList)
			{
				if(phaseCA.isDisplayed() && phaseCA.getText().equals(expectedPhaseValue))
					contentValidationCounter++;
			}
			if(contentValidationCounter == 1)
				return true;
			else
				return false;
		case "Total":
			for(WebElement phaseTotal:phaseTotalList)
			{
				if(phaseTotal.isDisplayed() && phaseTotal.getText().equals(expectedPhaseValue))
					contentValidationCounter++;
			}
			if(contentValidationCounter == 1)
				return true;
			else
				return false;
		case "Hz":
			return ElementUtils.isDisplayed(null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT, expectedPhaseValue);
		}
		return false;
	}

	public boolean isUnitDisplayed(String expectedUnitValue)
	{
		contentValidationCounter = 0;
		switch(expectedUnitValue)
		{
		case "Voltage":
		case "Current":
		//case "Active Power":
		case "Power Factor":
		case "THD-V":
		case "THD-A":
		case "THC-A":	
			for(WebElement unit:unitList)
			{
				if(unit.isDisplayed() && unit.getText().equals(expectedUnitValue))
					contentValidationCounter++;
			}
			if(contentValidationCounter == 1)
				return true;
			else
				return false;
		case "Frequency":	
			for(WebElement unit:unitListFrequency)
			{
				if(unit.isDisplayed() && unit.getText().equals(expectedUnitValue))
					contentValidationCounter++;
			}
			if(contentValidationCounter == 1)
				return true;
			else
				return false;
		case "Active Power":
			CommonUtils.wait(5);
			if(activePowerUnit.getText().contains("kW"))
			{
				return true;
			}
			else
			{
				return false;
			}
			
		case "Apparent Power":
			CommonUtils.wait(5);
			if(activePowerUnit.getText().contains("kVA"))
			{
				return true;
			}
			else
			{
				return false;
			}
		case "Non-Active Power":
			CommonUtils.wait(5);
			if(activePowerUnit.getText().contains("kvar"))
			{
				return true;
			}
			else
			{
				return false;
			}
		
		}
		return false;
	}

	public boolean isMeasurementValueNotStale(String unitValue)
	{
		contentValidationCounter = 0;
		switch(unitValue)
		{
		case "Voltage":
			for(WebElement measurementValue:voltageValueList)
			{
				if(measurementValue.getText().contains("--"))
					contentValidationCounter++;
			}
			if(contentValidationCounter > 0)
				return false;
			else
				return true;
		case "Current":
			for(WebElement measurementValue:currentValueList)
			{
				if(measurementValue.getText().contains("--"))
					contentValidationCounter++;
			}
			if(contentValidationCounter > 0)
				return false;
			else
				return true;
		case "Frequency":	
			for(WebElement measurementValue:frequencyValueList)
			{
				if(measurementValue.getText().contains("--"))
					contentValidationCounter++;
			}
			if(contentValidationCounter > 0)
				return false;
			else
				return true;
		case "Active Power":
			for(WebElement measurementValue:activePowerValueList)
			{
				if(measurementValue.getText().contains("--"))
					contentValidationCounter++;
			}
			if(contentValidationCounter > 0)
				return false;
			else
				return true;
		case "Power Factor":
			for(WebElement measurementValue:powerFactorValueList)
			{
				if(measurementValue.getText().contains("--"))
					contentValidationCounter++;
			}
			if(contentValidationCounter > 0)
				return false;
			else
				return true;
		case "Apparent Power":
			for(WebElement measurementValue:apparentPowerValueList)
			{
				if(measurementValue.getText().contains("--"))
					contentValidationCounter++;
			}
			if(contentValidationCounter > 0)
				return false;
			else
				return true;
		case "Non-Active Power":
			for(WebElement measurementValue:nonActivePowerValueList)
			{
				if(measurementValue.getText().contains("--"))
					contentValidationCounter++;
			}
			if(contentValidationCounter > 0)
				return false;
			else
				return true;
		case "THD-V":
			for(WebElement measurementValue:thdVValueList)
			{
				if(measurementValue.getText().contains("--"))
					contentValidationCounter++;
			}
			if(contentValidationCounter > 0)
				return false;
			else
				return true;
		case "THD-A":
			for(WebElement measurementValue:thdAValueList)
			{
				if(measurementValue.getText().contains("--"))
					contentValidationCounter++;
			}
			if(contentValidationCounter > 0)
				return false;
			else
				return true;
		case "THC-A":	
			for(WebElement measurementValue:thcAValueList)
			{
				if(measurementValue.getText().contains("--"))
					contentValidationCounter++;
			}
			if(contentValidationCounter > 0)
				return false;
			else
				return true;
	}
		return false;

}
	
	public boolean isUnitOnGraphAccurate(String unitValue, String phaseValue, String tab)  //Sample parameter value --> Voltage -- AB, BC, CA 
	{
		contentValidationFlag = false;
		String[] phaseValueList = phaseValue.split(", ");
		switch(unitValue)
		{
		case "Voltage":
			for(int i = 0; i < voltageRadioButtonList.size(); i++)
			{
				voltageRadioButtonList.get(i).click();
				CommonUtils.wait(10);
				try {
					sessionDetailPage3540.switchToOtherTab(tab, ScrollDiection.UP);
				} catch (Exception e) {
					e.printStackTrace();
				}
				contentValidationFlag = graphUnit.getText().equals(getUnit(unitValue)+" "+phaseValueList[i]);				
			}
			return contentValidationFlag;
		case "Current":
			for(int i = 0; i < currentRadioButtonList.size(); i++)
			{
				currentRadioButtonList.get(i).click();
				CommonUtils.wait(10);
				try {
					sessionDetailPage3540.switchToOtherTab(tab, ScrollDiection.UP);
				} catch (Exception e) {
					e.printStackTrace();
				}
				contentValidationFlag = graphUnit.getText().equals(getUnit(unitValue)+" "+phaseValueList[i]);
			}
			return contentValidationFlag;
		case "Frequency":	
			for(int i = 0; i < frequencyRadioButtonList.size(); i++)
			{
				frequencyRadioButtonList.get(i).click();
				CommonUtils.wait(10);
				try {
					sessionDetailPage3540.switchToOtherTab(tab, ScrollDiection.UP);
				} catch (Exception e) {
					e.printStackTrace();
				}
				contentValidationFlag = graphUnit.getText().equals(getUnit(unitValue));
			}
			return contentValidationFlag;
		case "Active Power":
			try
			{
				ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_ID, "radiobtns1_ACTIVE_POWER_Tot").click();
				CommonUtils.wait(0, 0, 3);
			
			}catch(Throwable e)
			{
				
			}
			
			try
			{
				ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_ID, "radiobtns2_ACTIVE_POWER_Tot").click();
				CommonUtils.wait(0, 0, 3);
				
			}catch(Throwable e)
			{
				
			}
			//for(int i = 0; i < activePowerRadioButtonList.size(); i++)
			//{
				//activePowerRadioButtonList.get(i).click();
				CommonUtils.wait(10);
				try {
					sessionDetailPage3540.switchToOtherTab(tab, ScrollDiection.UP);
				} catch (Exception e) {
					//e.printStackTrace();
				}
				//contentValidationFlag = graphUnit.getText().equals(getUnit(unitValue)+" "+phaseValueList[i]);
				CommonUtils.wait(5);
				contentValidationFlag = graphUnit.getText().contains("kW");
			//}
			    return contentValidationFlag;
		case "Power Factor":
			for(int i = 0; i < powerFactorRadioButtonList.size(); i++)
			{
				powerFactorRadioButtonList.get(i).click();
				CommonUtils.wait(10);
				try {
					sessionDetailPage3540.switchToOtherTab(tab, ScrollDiection.UP);
				} catch (Exception e) {
					e.printStackTrace();
				}
				contentValidationFlag = graphUnit.getText().equals(phaseValueList[i]);
			}
			return contentValidationFlag;
		case "Apparent Power":
			try
			{
				ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_ID, "radiobtns2_APPARENT_POWER_Tot").click();
				CommonUtils.wait(0, 0, 3);
			
			}catch(Throwable e)
			{
				
			}
			CommonUtils.wait(10);
			try {
				sessionDetailPage3540.switchToOtherTab(tab, ScrollDiection.UP);
			} catch (Exception e) {
				e.printStackTrace();
			}
			contentValidationFlag = graphUnit.getText().contains("kVA");
		
		   return contentValidationFlag;
		case "Non-Active Power":
			try
			{
				ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_ID, "radiobtns2_NON_ACTIVE_POWER_Tot").click();
				CommonUtils.wait(0, 0, 3);
			
			}catch(Throwable e)
			{
				
			}
			CommonUtils.wait(10);
			try {
				sessionDetailPage3540.switchToOtherTab(tab, ScrollDiection.UP);
			} catch (Exception e) {
				e.printStackTrace();
			}
			contentValidationFlag = graphUnit.getText().contains("kvar");
			
			return contentValidationFlag;
		case "THD-V":
			for(int i = 0; i < thdVRadioButtonList.size(); i++)
			{
				thdVRadioButtonList.get(i).click();
				CommonUtils.wait(10);
				try {
					sessionDetailPage3540.switchToOtherTab(tab, ScrollDiection.UP);
				} catch (Exception e) {
					e.printStackTrace();
				}
				contentValidationFlag = graphUnit.getText().equals(getUnit(unitValue)+" "+phaseValueList[i]);
			}
			return contentValidationFlag;
		case "THD-A":
			for(int i = 0; i < thdARadioButtonList.size(); i++)
			{
				thdARadioButtonList.get(i).click();
				CommonUtils.wait(10);
				try {
					sessionDetailPage3540.switchToOtherTab(tab, ScrollDiection.UP);
				} catch (Exception e) {
					e.printStackTrace();
				}
				contentValidationFlag = graphUnit.getText().equals(getUnit(unitValue)+" "+phaseValueList[i]);
			}
			return contentValidationFlag;
		case "THC-A":	
			for(int i = 0; i < thcARadioButtonList.size(); i++)
			{
				thcARadioButtonList.get(i).click();
				CommonUtils.wait(10);
				try {
					sessionDetailPage3540.switchToOtherTab(tab, ScrollDiection.UP);
				} catch (Exception e) {
					e.printStackTrace();
				}
				contentValidationFlag = graphUnit.getText().equals(getUnit(unitValue)+" "+phaseValueList[i]);
			}
			return contentValidationFlag;
	}
		return false;

}

	public boolean isMeasurementUnitAccurate(String unitValue) 
	{
		contentValidationFlag = false;
		switch(unitValue)
		{
		case "Voltage":
			for(WebElement measurementUnit: voltageUnitList)
			{
				contentValidationFlag = measurementUnit.getText().equals(getUnit(unitValue));
			}
			return contentValidationFlag;
		case "Current":
			for(WebElement measurementUnit: currentUnitList)
			{
				contentValidationFlag = measurementUnit.getText().equals(getUnit(unitValue));
			}
			return contentValidationFlag;
		case "Frequency":	
			for(WebElement measurementUnit: frequencyUnitList)
			{
				contentValidationFlag = measurementUnit.getText().equals(getUnit(unitValue));
			}
			return contentValidationFlag;
		case "Active Power":
			for(WebElement measurementUnit: activePowerUnitList)
			{
				contentValidationFlag = measurementUnit.getText().equals(getUnit(unitValue));
			}
			return contentValidationFlag;
		case "Power Factor":
			for(WebElement measurementUnit: powerFactorUnitList)
			{
				contentValidationFlag = measurementUnit.getText().equals(getUnit(unitValue));
			}
			return contentValidationFlag;
		case "Apparent Power":
			for(WebElement measurementUnit: apparentPowerUnitList)
			{
				contentValidationFlag = measurementUnit.getText().equals(getUnit(unitValue));
			}
			return contentValidationFlag;
		case "Non-Active Power":
			for(WebElement measurementUnit: nonActivePowerUnitList)
			{
				contentValidationFlag = measurementUnit.getText().equals(getUnit(unitValue));
			}
			return contentValidationFlag;
		case "THD-V":
			for(WebElement measurementUnit: thdVUnitList)
			{
				contentValidationFlag = measurementUnit.getText().equals(getUnit(unitValue));
			}
			return contentValidationFlag;
		case "THD-A":
			for(WebElement measurementUnit: thdAUnitList)
			{
				contentValidationFlag = measurementUnit.getText().equals(getUnit(unitValue));
			}
			return contentValidationFlag;
		case "THC-A":	
			for(WebElement measurementUnit: thcAUnitList)
			{
				contentValidationFlag = measurementUnit.getText().equals(getUnit(unitValue));
			}
			return contentValidationFlag;
	}
		return false;
	}
	
	public void addAlarmStudyType(StudyType studyType)
	{
		switch (studyType) 
		{
		case ACTIVE_POWER:
			studyTypeActivePower.click();
			break;
		case CURRENT:
			studyTypeCurrent.click();
			break;
		case FREQUENCY:
			studyTypeFrequency.click();
			break;
		case POWER_FACTOR:
			studyTypePowerFactor.click();
			break;
		case THDA:
			studyTypeTHDA.click();
			break;
		case THDV:
			studyTypeTHDV.click();
			break;
		case VOLTAGE:
			studyTypeVoltage.click();
			break;
		default:
			break;
		}
	}
	
	public Boolean addAboveVoltageAlarmForWeb(String value)
	{
		addAlarmWebLink.click();
		CommonUtils.wait(1);
		addAlarmButtonForWeb.click();
		CommonUtils.wait(1);
		aboveVoltageAlarmSection.click();
		CommonUtils.wait(1);
		upperRangeEditBox.sendKeys(value);
		CommonUtils.wait(1);
		aboveRangeDropDown.click();
		CommonUtils.wait(1);
		//Select VAC unit
		alarmUnitList.get(1).click();
		CommonUtils.wait(1);
		nextButtonOnAddAlarm.click();
		CommonUtils.wait(1);
		notifyMeCheckBox.click();
		CommonUtils.wait(1);
		saveButtonOnAddAlarm.click();
		CommonUtils.wait(10);
		
		allTabOnGraph.click();
		CommonUtils.wait(3);
		
		//oneHourTabOnGraph.click();
		//CommonUtils.wait(3);
		
		alarmIconAboveGraph.click();
		CommonUtils.wait(1);
		
		String alarmValue = firstItemInAlarmList.getText();
		if (alarmValue.contains(" V"))
		{
			firstItemInAlarmList.click();
			return true;			
		}
		else
		{
			firstItemInAlarmList.click();
			return false;
		}
		
		//cancelAlarmButton.click();
		//CommonUtils.wait(1);
		
	}
	
	public Boolean editVoltageAlarmForWeb(String value)
	{
		addAlarmWebLink.click();
		CommonUtils.wait(1);
		
		first3DotItemInAddEditAlarmList.click();
		CommonUtils.wait(1);
		
		editAlarmLink.click();
		CommonUtils.wait(1);
		upperRangeEditBox.clear();
		CommonUtils.wait(1);
		upperRangeEditBox.sendKeys(value);
		CommonUtils.wait(1);
		aboveRangeDropDown.click();
		CommonUtils.wait(1);
		//Select VAC unit
		alarmUnitList.get(1).click();
		CommonUtils.wait(1);
		nextButtonOnAddAlarm.click();
		CommonUtils.wait(1);
		notifyMeCheckBox.click();
		CommonUtils.wait(1);
		saveButtonOnAddAlarm.click();
		CommonUtils.wait(10);
		
		allTabOnGraph.click();
		CommonUtils.wait(3);
		
		//oneHourTabOnGraph.click();
		//CommonUtils.wait(3);
		
		alarmIconAboveGraph.click();
		CommonUtils.wait(1);
		
		String alarmValue = firstItemInAlarmList.getText();
		if (alarmValue.contains(" V"))
		{
			firstItemInAlarmList.click();
			return true;			
		}
		else
		{
			firstItemInAlarmList.click();
			return false;
		}
		
		
	}
	
	
	public Boolean deleteVoltageAlarmForWeb()
	{
		addAlarmWebLink.click();
		CommonUtils.wait(1);
		
		first3DotItemInAddEditAlarmList.click();
		CommonUtils.wait(1);
		
		deleteAlarmLink.click();
		CommonUtils.wait(1);
		
		deleteButton.click();
		CommonUtils.wait(1);
		return true;
		
	}

}
