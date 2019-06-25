package com.fluke.connect.app.functional.client.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.fluke.connect.app.testdata.Graph.SessionTileDetail;
import com.fluke.connect.app.testdata.Graph.SessionType;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.GestureUtils;

public class Graph3560Page {
	
	
	
	@FindBy(how=How.CSS,using="[data-detailgatewayname-test-id]")
	private WebElement gatewayName;
	
	@FindBy(how=How.CSS,using="[data-detailstarttime-test-id]")
	private WebElement startDetailSesisonTime;
	
	@FindBy(how=How.CSS,using="[data-detailstartuser-test-id]")
	private WebElement startDetailSessionUser;
	
	@FindBy(how=How.CSS,using="[data-detailendtime-test-id]")
	private WebElement endDetailSessisonTime;
	
	@FindBy(how=How.CSS,using="[data-detailenduser-test-id]")
	private WebElement endDetailSessionUser;
	
	@FindBy(how=How.CSS,using="[data-assetdetailgroup-test-id]")
	private WebElement assetDetailGroupName;
	
	@FindBy(how=How.CSS,using="[data-assetdetail-test-id]")
	private WebElement assetDetailName;
	
	@FindBy(how=How.CSS,using="[data-notification-test-id] img")
	private List<WebElement> notificationCount;
	
	@FindBy(how=How.CSS,using="[name='monitoring-status']")
	private static WebElement monitoringStatus;
	
	@FindBy(how=How.CSS,using="[data-notification-test-id]")
	private List<WebElement> notificationCountTest;
	
	@FindBy(how=How.CSS,using="[alt='menu-logo']")
	private WebElement addEditAlarmOption;
	
	@FindBy(how=How.CSS,using="[data-addalarmbutton-test-id]")
	private WebElement addAlarmButton;
	
	@FindBy(how=How.CSS,using="[data-alarmscount-test-id]")
	private WebElement alarmCountSessionTile;
	
	@FindBy(how=How.CSS,using="[data-alertscount-test-id]")
	private WebElement alertCountSessionTile;
	// ############ Edit Session Setup ################/////s
	
	@FindBy(how=How.CSS,using="[data-viewsessionactivity-test-id]")
	private WebElement sessionActivityOption;
	
	@FindBy(how=How.CSS,using="[data-editsession-test-id]")
	private WebElement editSessionOption;
	
	@FindBy(how=How.CSS,using="[name='edit-session-setup']")
	private WebElement editSessionSetupPopup;	
	
	@FindBy(how=How.CSS,using="[name='Vibration']")
	private WebElement vibrationUnitDorpDown;
	
	@FindBy(how=How.CSS,using="[name='Temperature']")
	private WebElement temperatureUnitDorpDown;
	
	@FindBy(how=How.XPATH,using="//button[text()='SAVE']")
	private WebElement saveButton;
	
	@FindBy(how=How.XPATH,using="//button[text()='CANCEL']")
	private WebElement cancelButton;
	
	@FindBy(how=How.CSS,using="[text-anchor=\"end\"]>tspan")
	private WebElement leftGraphVibrationUnit;
	
	@FindBy(how=How.CSS,using="[text-anchor=\"start\"]>tspan")
	private WebElement rightGraphVibrationUnit;
	
	// ############ Edit Session Setup  End Here ################/////
	
	
	//############# View Session Export ##################//
	
	@FindBy(how=How.CSS,using="[data-sessionactivity-test-id]")
	private WebElement viewSessionActivity;
	
	@FindBy(how=How.CSS,using="[value='1.5 Min (90s)']")
	private WebElement chooseFrequency;
	
	//############# View Session Activity End here  ##################//
	
	// ############ Graph tile start here ################/////s
	@FindBy(how=How.CSS,using="[data-max-test-id] [data-vibrationval-test-id]")
	private List<WebElement> maxVibrationVal; 
	
	@FindBy(how=How.CSS,using="[data-max-test-id] [data-tempratureval-test-id]")
	private List<WebElement> maxTempratureVal;
	
	@FindBy(how=How.CSS,using="[data-max-test-id] [data-date-test-id]")
	private List<WebElement> maxDate;
	
	@FindBy(how=How.CSS,using="[data-max-test-id] [data-time-test-id]")
	private List<WebElement> maxTime;
	
	
	@FindBy(how=How.CSS,using="[data-min-test-id] [data-vibrationval-test-id]")
	private List<WebElement> minVibrationVal; 
	
	@FindBy(how=How.CSS,using="[data-min-test-id] [data-tempratureval-test-id]")
	private List<WebElement> minTempratureVal;
	
	@FindBy(how=How.CSS,using="[data-min-test-id] [data-date-test-id]")
	private List<WebElement> minDate;
	
	@FindBy(how=How.CSS,using="[data-min-test-id] [data-time-test-id]")
	private List<WebElement> minTime;
	
	
	@FindBy(how=How.CSS,using="[data-currentval-test-id] [data-vibrationval-test-id]")
	private List<WebElement> currentVibrationVal; 
	
	@FindBy(how=How.CSS,using="[data-currentval-test-id] [data-tempratureval-test-id]")
	private List<WebElement>currentTempratureVal;
	
	@FindBy(how=How.CSS,using="[data-currentval-test-id] [data-date-test-id]")
	private List<WebElement> currentDate;
	
	@FindBy(how=How.CSS,using="[data-currentval-test-id] [data-time-test-id]")
	private List<WebElement> currentTime;
	
	
	@FindBy(how=How.CSS,using="[data-alarmtype-test-id]")
	public  WebElement alarmTypeCheck;
	
	
	
	//// Sign IN Page /////////
	
	@FindBy(how=How.CSS,using="[name=\"username\"]")
	private WebElement userName;
	
	@FindBy(how=How.CSS,using="[name=\"password\"]")
	private WebElement password;
	
	@FindBy(how=How.CSS,using=".btn-primary")
	private WebElement loginButton;
	
	///***** Meta Data ids ******///
	
	
	
	@FindBy(how=How.CSS,using="[data-xaxis-test-id]")
	private WebElement xAxisLabel;
	
	@FindBy(how=How.CSS,using="[data-yaxis-test-id]")
	private WebElement yAxisLabel;
	
	@FindBy(how=How.CSS,using="[data-zaxis-test-id]")
	private WebElement zAxisLabel;
	
	@FindBy(how=How.CSS,using="[data-max-test-id] div")
	private WebElement maxLabel;
	
	@FindBy(how=How.CSS,using="[data-min-test-id] div")
	private WebElement minLabel;
	
	
	
	
	@FindBy(how=How.CSS,using="[data-vibrationval-test-id]")
	private List<WebElement> vibrationVal;
	
	@FindBy(how=How.CSS,using="[data-tempratureval-test-id]")
	private List<WebElement> tempratureVal;
	
	@FindBy(how=How.CSS,using="[data-date-test-id]")
	private List<WebElement> dateVal;
	
	@FindBy(how=How.CSS,using="[data-time-test-id]")
	private List<WebElement> timeVal;
	
	
	//// Graph check /////////
	
	@FindBy(how=How.CSS,using=".highcharts-series-group")
	private WebElement  graphZoom;
	
	
	/// Session Filter ////////
	
	@FindBy(how=How.CSS,using="[data-model='/powermonitor']")
	private WebElement powerMonitorSession;
	
	@FindBy(how=How.CSS,using="[data-model='/vibration']")
	private WebElement vibrationSession;
	
	@FindBy(how=How.CSS,using="[data-model='/thermalimage']")
	private WebElement thermalSession;
	
	@FindBy(how=How.CSS,using="[data-model='/vatg']")
	private WebElement vatgSession;
	
	@FindBy(how=How.CSS,using="[href='/saved-session']~ .sessionTypes [data-model='/powermonitor']")
	private WebElement savedPowerMonitorSession;
	
	@FindBy(how=How.CSS,using="[href='/saved-session']~ .sessionTypes [data-model='/vibration']")
	private WebElement savedVibrationSession;
	
	@FindBy(how=How.CSS,using="[href='/saved-session']~ .sessionTypes [data-model='/thermalimage']")
	private WebElement savedThermalSession;
	
	@FindBy(how=How.CSS,using="[href='/saved-session']~ .sessionTypes [data-model='/vatg']")
	private WebElement savedVATGSession;

	
	public Graph3560Page()
	{
		CommonUtils.initElements(this, 5);	
		
	}

	
	public WebElement getSessionDetails(SessionTileDetail sessionTile)
	{
		switch(sessionTile)
		{
		case ASSETGROUP:
			return assetDetailGroupName;
		case ASSET:
			return assetDetailName;
		case STARTUSER:
			return startDetailSessionUser;
		case STARTTIME:
			return startDetailSesisonTime;
		case ENDTIME:
			return endDetailSessisonTime;
		case ENDUSER:
			return endDetailSessionUser;
		case GATEWAYNAME:
			return gatewayName;
		case ALARM:
			return notificationCount.get(0);
		case ALERT:
			return notificationCount.get(1);
		case ACTIVITYOPTION:
			return sessionActivityOption;
		case EDITSESSION:
			return editSessionSetupPopup;
		case LEFTGRAPHUNIT:
			return leftGraphVibrationUnit;
		case RIGHTGRAPHUNIT:
		 	return rightGraphVibrationUnit;
		case XAXISLABEL:
			return xAxisLabel;
		case YAXISLABEL:
			return yAxisLabel;
		case ZAXISLABEL:
			return zAxisLabel;
		case MAXLABEL:
			return maxLabel;
		case MINLABEL:
			return minLabel;
			
		default:
			return null;
		}
		
	}
	
	
	public static  WebElement getSessionTileElement(SessionTileDetail sessionTile,String sessionId)
	{
		switch(sessionTile)
		{
		case ASSETGROUP:
			return ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,"[sessionid='"+sessionId+"'] [data-assetgroup-test-id]");//assetGroupName;
		case ASSET:
			return ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS,"[sessionid='"+sessionId+"'] [data-asset-test-id]");//assetGroupName;
		case STARTUSER:
			return ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "[sessionid='"+sessionId+"'] [data-startuser-test-id]");
		case STARTTIME:
			return ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "[sessionid='"+sessionId+"'] [data-starttime-test-id]");
		case ENDTIME:
			return ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "[sessionid='"+sessionId+"'] [data-endtime-test-id]");
		case ENDUSER:
			return ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "[sessionid='"+sessionId+"'] [data-enduser-test-id]");
		case GATEWAYNAME:
			return ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "[sessionid='"+sessionId+"'] [data-gatewayname-test-id]");
		case ALARM:
			return ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "[sessionid='"+sessionId+"'] [data-alarmscount-test-id]");
		case ALERT:
			return ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "[sessionid='"+sessionId+"'] [data-alertscount-test-id]");
		case SENSORNAME:
			return ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "[sessionid='"+sessionId+"'] [data-sensorname-test-id]");
		case MONITORINGSTATUS:
			return monitoringStatus;	
		default:
			return null;
		}
		
	}
	
	public List<String> sesionTileValue(String  sessionId)
	{
		List<String> value=new ArrayList<String>();
		value.add(getSessionTileElement(SessionTileDetail.ASSETGROUP, sessionId).getText());
		value.add(getSessionTileElement(SessionTileDetail.ASSET, sessionId).getText());
		value.add(getSessionTileElement(SessionTileDetail.STARTUSER, sessionId).getText());
		value.add(getSessionTileElement(SessionTileDetail.STARTTIME, sessionId).getText());
		//value.add(getSessionTileElement(SessionTileDetail.ENDTIME, sessionId).getText());
		//value.add(getSessionTileElement(SessionTileDetail.ENDUSER, sessionId).getText());
		value.add(getSessionTileElement(SessionTileDetail.GATEWAYNAME, sessionId).getText());
		value.add(getSessionTileElement(SessionTileDetail.ALARM, sessionId).getText());
		value.add(getSessionTileElement(SessionTileDetail.ALERT, sessionId).getText());
		value.add(getSessionTileElement(SessionTileDetail.SENSORNAME, sessionId).getText());
		//value.add(getSessionTileElement(SessionTileDetail.MONITORINGSTATUS, sessionId).getText());
		return (value);
		
	}
	
	
	public void clickOnSessionTile(String sessionId)
	{
		ElementUtils.getElement(null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "[sessionid='"+sessionId+"']").click();
	}
	
	public void getAlarmAndAlertCount(String sessionId)
	{
		
	}
	
	public int getAssetRowCountOnSessionTile(String sessionId)
	{
		return ElementUtils.getElements(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "[sessionid='"+sessionId+"'] [name='assets-row']").size();
	}
	
	public int getAssetCountonSessionTile(String sessionId)
	{
		String getAssetCountString= ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, "[sessionid='"+sessionId+"'] [name='asset-details']  div>span").getText();
		String[]getAssetCount=getAssetCountString.split("[(,)]");
		return Integer.parseInt(getAssetCount[0]);	
	}
	
	
	public void  clickOnAddEditAlarm() {	
		GestureUtils.moveToElement(addEditAlarmOption);
	}
	
	
	public void navigateToSessionSetup()
	{
		GestureUtils.moveAndClickElement(sessionActivityOption);
		editSessionOption.click();
	}
	
	public void navigateToViewSessionActivity()
	{
		GestureUtils.moveAndClickElement(sessionActivityOption);
		viewSessionActivity.click();
		
	}
	
	public void editSessionSetup(String virbrationUnit,String temperatureUnit)
	{
		CommonUtils.wait(2);
		navigateToSessionSetup();
		vibrationUnitDorpDown.click();
		ElementUtils.getElement("[value='"+virbrationUnit+"']", null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS).click();
		temperatureUnitDorpDown.click();
		ElementUtils.getElement("[value='"+temperatureUnit+"']", null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS).click();
		saveButton.click();	
	}
	
	public void signIn()
	{
		userName.sendKeys("preprodqa2@yopmail.com");
		password.sendKeys("preprodqa2@yopmail.com");
		loginButton.click();
	}
	
	public void clickOnCancelButton()
	{
		cancelButton.click();
	}
	
	
	public List<String> getVibrationValue()

	{
		ArrayList<String> lst=new ArrayList<String>();
		lst.clear();
		for(WebElement ele:vibrationVal)
		{
			lst.add(ele.getText());
		}
		return lst;
	}
	
	
	public List<String> getTempratureValue()

	{
		ArrayList<String> lst=new ArrayList<String>();
		lst.clear();
		for(WebElement ele:vibrationVal)
		{
			lst.add(ele.getText());
		}
		return lst;
	}
	
	public List<String> getDateValue()

	{
		ArrayList<String> lst=new ArrayList<String>();
		lst.clear();
		for(WebElement ele:dateVal)
		{
			lst.add(ele.getText());
		}
		return lst;
	}
	
	public List<String> getTimeValue()

	{
		ArrayList<String> lst=new ArrayList<String>();
		lst.clear();
		for(WebElement ele:timeVal)
		{
			lst.add(ele.getText());
		}
		return lst;
	}
	
	public void zoomGraph()
	{
		
	}
	
	
	public void clickOnSessionType(SessionType sessionType,String sessionValue )
	{
		
		
		switch(sessionType)
		{
		  case POWER:
			  if(sessionValue.equals("SavedSession"))
			  {
				  savedPowerMonitorSession.click();
			  }
			  else
			  {
				  powerMonitorSession.click();
			  }
			 
			  break;
		  case THERMAL:
			 
			  if(sessionValue.equals("SavedSession"))
			  {
				  savedThermalSession.click();
			  }
			  else
			  {
				  thermalSession.click();
			  }
			  break;
		  case VATG:
			  
			  if(sessionValue.equals("SavedSession"))
			  {
				  savedVATGSession.click();
			  }
			  else
			  {
				  vatgSession.click();
			  }
			  break;
		  case VIBRATION: 
			  if(sessionValue.equals("SavedSession"))
			  {
				  savedVibrationSession.click();
			  }
			  else
			  {
				  vibrationSession.click();
			  }
			  break;
		  default:
			   break; 
		}
	}
}
