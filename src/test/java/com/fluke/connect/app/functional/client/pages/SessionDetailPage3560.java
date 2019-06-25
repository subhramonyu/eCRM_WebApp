package com.fluke.connect.app.functional.client.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SessionDetailPage3560 extends SessionDetailPage
{
	@FindBy(how = How.CSS, using = ".max")
	@AndroidFindBy(id = "max_header")
	private WebElement maxStaticText;
	
	@FindBy(how = How.CSS, using = ".min")
	@AndroidFindBy(id = "min_header")
	private WebElement minStaticText;
	
	@FindBy(how = How.CSS, using = ".x-axis")
	@AndroidFindBy(id = "x_axis_text")
	private WebElement xAxisStaticText;
	
	@FindBy(how = How.CSS, using = ".y-axis")
	@AndroidFindBy(id = "y_axis_text")
	private WebElement yAxisStaticText;
	
	@FindBy(how = How.CSS, using = ".z-axis")
	@AndroidFindBy(id = "z_axis_text")
	private WebElement zAxisStaticText;
	
	//list for max min live value  
	@FindBy(how = How.CSS, using = ".axes_values")
	@AndroidFindBy(id = "axis_data") 
	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value CONTAINS '.'")
	private List<WebElement> maxMinLiveValueList;
	
	@FindBy(how = How.CSS, using = ".axes_time")
	@AndroidFindBy(id = "axis_data_time") 
	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value CONTAINS ':'")
	private List<WebElement> maxMinLiveTimeValueListOld;
	
	@FindBy(how = How.CSS, using = ".axes_values")
	@AndroidFindBy(id = "axis_data") 
	@iOSXCUITFindBy(iOSNsPredicate = "name ENDSWITH 'Value'")
	private List<WebElement> vibrationValueList;
	
	@FindBy(how = How.CSS, using = ".axes_temp")
	@AndroidFindBy(id = "tv_temp") 
	@iOSXCUITFindBy(iOSNsPredicate = "name ENDSWITH 'Temp'")
	private List<WebElement> tempratureValueList;
	
	@FindBy(how = How.CSS, using = ".axes_date")
	@AndroidFindBy(id = "tv_date") 
	@iOSXCUITFindBy(iOSNsPredicate = "name ENDSWITH 'Date'")
	private List<WebElement> dateValueList;
	
	@FindBy(how = How.CSS, using = "div[id $= 'time']")
	@AndroidFindBy(id = "axis_data_time") 
	@iOSXCUITFindBy(iOSNsPredicate = "name ENDSWITH 'Time'")
	private List<WebElement> timeValueList;
	
	@FindBy(how = How.CSS, using = ".machine-learning-in-progress")
	@AndroidFindBy(id = "machine_learning_status_text")  
	@iOSXCUITFindBy(accessibility = "MACHINE LEARNING IN PROGRESS ALARMS DISABLED")
	private WebElement machineLearningStatusText;
	
	@FindBy(how = How.CSS, using = ".alarmsIcon")
	@AndroidFindBy(id = "btn_show_notification")
	@iOSXCUITFindBy(accessibility = "Show Alarms")
	private WebElement showAlarmsButton;
	
	@FindBy(how = How.CSS, using = "#scalarunit_A")
	@iOSXCUITFindBy(iOSNsPredicate = "name CONTAINS 'Overall Vibration' OR name CONTAINS 'Acceleration - g'")
	@AndroidFindBy(id = "vibration_unit")
	private WebElement vibrationUnitText;
	
	@FindBy(how = How.CSS, using = ".scalarunit_T")
	@AndroidFindBy(id = "test_point_unit")
	@iOSXCUITFindBy(iOSNsPredicate = "name CONTAINS 'Temperature'")
	private WebElement tempratureUnitText;
	
	@FindBy(how = How.CSS, using = ".menuItemTitle")
	private WebElement alarmNotificationTitle;
	
	@FindBy(how = How.CSS, using = ".menuItemReading")
	private WebElement alarmNotificationValue;
	
	@FindBy(how = How.CSS, using = ".menuItemTime")
	private WebElement alarmNotificationTime;
	
	@FindBy(how = How.CSS, using = ".units-style")
	private List<WebElement> sessionActivityUnit;
	
	@FindBy(how = How.CSS, using = ".alarm-triggered-value")
	private WebElement sessionActivityAlarmTriggeredValue;
	
	@FindBy(how = How.CSS, using = ".alarm-asset-container-tree")
	private WebElement sessionActivityAssetGroup;
	
	@FindBy(how = How.CSS, using = ".alarm-asset-device-title")
	private WebElement sessionActivityTestPoint;
	
	@FindBy(how = How.CSS, using = "#editSessionSetupDoneButton")
	private WebElement editSessionSetupSaveButton;
	
	@FindBy(how = How.CSS, using = "#select_vibration_unit")
	private WebElement selectVibrationUnitDropdown;
	
	@FindBy(how = How.CSS, using = "#select_temperature_unit")
	private WebElement selectTempratureUnitDropdown;
	
	@FindBy(how = How.CSS, using = "option[value='g']")
	private WebElement selectVibrationUnitACC;
	
	@FindBy(how = How.CSS, using = "option[value='in/s']")
	private WebElement selectVibrationUnitINS;
	
	@FindBy(how = How.CSS, using = "option[value='mm/s']")
	private WebElement selectVibrationUnitMMS;
	
	@FindBy(how = How.CSS, using = "option[value='°F']")
	private WebElement selectTempratureUnitFAR;
	
	@FindBy(how = How.CSS, using = "option[value='°C']")
	private WebElement selectTempratureUnitCEL;
	
	@AndroidFindBy(id = "action_bar_item_menu_icon")
	public WebElement sessionDetailsMenuIcon;
	
	@AndroidFindBy(xpath ="android.widget.LinearLayout[1]\n")
	public WebElement clickOnEdit;
	
	@AndroidFindBy(id="installation_detail")
	public WebElement installationDeatils;
	
	@AndroidFindBy(xpath="android.widget.RelativeLayout[1]/android.widget.TextView[2]")
	public WebElement epoxyins;
	
	@AndroidFindBy(id="connection_strength_value")
	public WebElement connectionStrength;
	
	@AndroidFindBy(id="sensor_status_value")
	public WebElement sensor_Status;
	
	
	@AndroidFindBy(id="signal_strength")
	public WebElement sensor_Gateway_Connection_Strength_Indication;

	
	@AndroidFindBy(id="gateway_list_header")
	public  WebElement gateway_Tab;
	
	@AndroidFindBy(id="delete_btn")
	public WebElement delete_Extra_Gateway_Button;
	
	@AndroidFindBy(id="android.webkit.WebView/android.view.View[1]")
	public WebElement   epoxy_Instruction_Text;

	
	@FindBy(how=How.CLASS_NAME,using="sessionGatewaycontainer")
	public  WebElement  clickActiveSession;
	
	private List<String> maxMinLiveValueTextList;
	private List<String> maxMinLiveValueTimeTextList;
	private List<String> vibrationValueTextList;
	private List<String> tempratureValueTextList;
	private List<String> dateValueTextList;
	private List<String> timeValueTextList;
	private boolean graphDisplayedFlag;
	
	public SessionDetailPage3560()
	{
		CommonUtils.initElements(this, 5);
		maxMinLiveValueTextList = new ArrayList<String>();
		maxMinLiveValueTimeTextList = new ArrayList<String>();
		vibrationValueTextList = new ArrayList<String>();
		tempratureValueTextList = new ArrayList<String>();
 		dateValueTextList = new ArrayList<String>();
		timeValueTextList = new ArrayList<String>();
	}
	
	public enum SessionDetailPage3560ObjectList
	{
		VIBRATION_UNIT, TEMPRATURE_UNIT, ALARM_NOTIFICATION_TITLE, ALARM_NOTIFICATION_VALUE, 
		ALARM_NOTIFICATION_TIME, SESSION_ACTIVITY_UNIT, SESSION_ACTIVITY_ALARM_TRIGGERED_VALUE, 
		SESSION_ACTIVITY_ASSET_GROUP, SESSION_ACTIVITY_TEST_POINT,
		VIB_UNIT_ACC, VIB_UNIT_INS, VIB_UNIT_MMS, TEMP_UNIT_CEL, TEMP_UNIT_FAR, CHANGE_UNIT_DONE_BUTTON,
		SHOW_ALARMS
	}
	
	public WebElement getSessionDetailPage3560Object(SessionDetailPage3560ObjectList objectName)
	{
		switch(objectName)
		{
		case VIBRATION_UNIT:
			return vibrationUnitText;
		case TEMPRATURE_UNIT:
			return tempratureUnitText;
		case CHANGE_UNIT_DONE_BUTTON:
			return editSessionSetupSaveButton;
		case SHOW_ALARMS:
			return showAlarmsButton;
		default:
				return null;
		}
	}
	
	public String getMachineLearningText()
	{
		return machineLearningStatusText.getText();
	}
	
	public boolean isGraphDisplayed(String scrollString)
	{
		graphDisplayedFlag = false;
		graphDisplayedFlag = getGraphObject().isDisplayed();
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			graphDisplayedFlag = webGraphLines.isDisplayed();
		}
		return graphDisplayedFlag;
	}
	
	public List<String> getVibrationList()
	{
		vibrationValueList.clear();
		vibrationValueTextList.clear();
		for(WebElement element: vibrationValueList)
		{
			vibrationValueTextList.add(element.getText());
		}
		return vibrationValueTextList;
	}
	
	public List<String> getTempratureList()
	{
		tempratureValueList.clear();
		tempratureValueTextList.clear();
		for(WebElement element: tempratureValueList)
		{
			tempratureValueTextList.add(element.getText());
		}
		return tempratureValueTextList;
	}
	
	public List<String> getDateList()
	{
		dateValueList.clear();
		dateValueTextList.clear();
		for(WebElement element: dateValueList)
		{
			dateValueTextList.add(element.getText());
		}
		return dateValueTextList;
	}
	
	public List<String> getTimeList()
	{
		timeValueList.clear();
		timeValueTextList.clear();
		for(WebElement element: timeValueList)
		{
			timeValueTextList.add(element.getText());
		}
		timeValueTextList.remove(0);
		timeValueTextList.remove(0);
		return timeValueTextList;
	}
	
	public void changeUnit(SessionDetailPage3560ObjectList objectName)
	{
		
		switch(objectName)
		{
		case VIB_UNIT_ACC:
			selectVibrationUnitDropdown.click();
			selectVibrationUnitACC.click();
			break;
		case VIB_UNIT_INS:
			selectVibrationUnitDropdown.click();
			selectVibrationUnitINS.click();
			break;
		case VIB_UNIT_MMS:
			selectVibrationUnitDropdown.click();
			selectVibrationUnitMMS.click();
			break;
		case TEMP_UNIT_FAR:
			selectTempratureUnitDropdown.click();
			selectTempratureUnitFAR.click();
			break;
		case TEMP_UNIT_CEL:
			selectTempratureUnitDropdown.click();
			selectTempratureUnitCEL.click();
			break;
		default:
			break;
		}
	}
	
	@Deprecated
	public List<String> getMaxMinLiveValueList()
	{
		maxMinLiveValueList.clear();
		maxMinLiveValueTextList.clear();
		for(WebElement element: maxMinLiveValueList)
		{
			maxMinLiveValueTextList.add(element.getText());
		}
		return maxMinLiveValueTextList;
	}
	
	@Deprecated
	public List<String> getMaxMinLiveValueTimeList()
	{
		maxMinLiveTimeValueListOld.clear();
		maxMinLiveValueTimeTextList.clear();
		for(WebElement element: maxMinLiveTimeValueListOld)
		{
			maxMinLiveValueTimeTextList.add(element.getText());
		}
		return maxMinLiveValueTimeTextList;
	}
	
	public WebElement clickOnEditSessionSetup() {
		return clickOnEdit;
	}
	
    public  WebElement epoxyInstructions() {
		return epoxyins;
	}	
	public void ConnectionStatus(String status) {
		switch (status) {
		case "Excellent":
			break;
         case "Good":
        	 break;
         case "Poor":
        	 break;
         case "Unavailable":
        	 break;	 
		}
	}
	public void Sensor_status(String stat) {
		
		switch(stat){
			case "Active":
				break;
			case "Configuring":
				break;
			case "Initializing":	
				break;
			case "Failed":
				break;
			
		}
	}
	
	public WebElement clickOnActiveSession() {
		return clickActiveSession;
	}
	

}
