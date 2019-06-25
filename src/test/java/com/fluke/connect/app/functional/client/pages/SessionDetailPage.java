package com.fluke.connect.app.functional.client.pages;

import java.time.temporal.ChronoUnit;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.fluke.connect.app.functional.client.pages.AlarmPage.AlarmPageObjectList;
import com.fluke.connect.app.testdata.FCCM.AlarmType;
import com.fluke.connect.app.testdata.FCCM3550;
import com.fluke.connect.app.testdata.FCCM3560;
import com.fluke.connect.app.testdata.SignIn.FeatureList;
import com.fluke.connect.app.utils.AndroidUtils;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.FCCMUtils;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.IOSUtils;
import com.fluke.connect.app.utils.VisualUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.ScrollDiection;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SessionDetailPage
{
	@AndroidFindBy(id = "parent_scroll_layout")
	@iOSXCUITFindBy(accessibility = "GraphTableView")
	private WebElement parentElement;
	
	//gateway name
	@AndroidFindBy(id = "action_bar_title")
	@iOSXCUITFindBy(accessibility = "Title")
	private WebElement pageTitleText;
	
	//session status
	@AndroidFindBy(id = "monitoring_label")
	@iOSXCUITFindBy(accessibility = "MONITORING IN PROGRESS")
	private WebElement sessionStatusText;
	
	@AndroidFindBy(id = "gateway_name")
	@iOSXCUITFindBy(accessibility = "Gateway Name")
	private WebElement gatewayName;
	
	@AndroidFindBy(id = "sensor_label")
	@iOSXCUITFindBy(accessibility = "Sensors")
	private WebElement sesnsorText;
	
	@AndroidFindBy(id = "voltage_sensor_count")
	@iOSXCUITFindBy(accessibility = "Sensors Attached To Session")
	private WebElement sensorCount;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Start Time\")")
	@iOSXCUITFindBy(accessibility = "Start Time")
	private WebElement startTimeText;
	
	@FindBy(how = How.CSS, using = "div.remoteMonitoringDetails_timeData")
	@AndroidFindBy(id = "started_time_and_name")
	@iOSXCUITFindBy(accessibility = "sessionStartTime")
	private WebElement sessionStartTime;
	
	@AndroidFindBy(id = "started_time_and_name")
	@iOSXCUITFindBy(accessibility = "sessionStartUsername")
	private WebElement sessionStartUserName;
	
	@AndroidFindBy(id = "asset_count")
	@iOSXCUITFindBy(iOSNsPredicate = "value CONTAINS 'Assets ('")
	private WebElement assetCountText;
	
	//for iOS no accessibility label is available, need to find element at run time
	@AndroidFindBy(id = "container_path")
	private List<WebElement> assetGroupName;
	
	//for iOS no accessibility label is available, need to find element at run time
	@AndroidFindBy(id = "asset_name")
	private List<WebElement> assetName;
	
	@FindBy(how = How.CSS, using = ".graphFilterValueUnit")
	@iOSXCUITFindBy(accessibility = "Acceleration - g")
	@AndroidFindBy(id = "vibration_unit")
	private WebElement vibrationUnit;
	
	@AndroidFindBy(id = "date")
	private WebElement date;
	
	@FindBy(how = How.CSS, using = ".highcharts-plot-background")
	@AndroidFindBy(id = "hig_chart")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeOther[@height > 100]")
	private WebElement graphObject;
	
	@AndroidFindBy(id = "hig_chart")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeOther[@height > 100]") //XCUIElementTypeButton[@name='1H']/following-sibling::XCUIElementTypeOther
	private List<WebElement> graphList;
	
	@FindBy(how = How.CSS, using = "#timeElapse")
	private WebElement sessionElapseTimeValue;
	
	@FindBy(how = How.CSS, using = "#new_design1")
	private WebElement startTimeCell;
	
	@FindBy(how = How.CSS, using = "#new_design2")
	private WebElement endTimeCell;
	
	@FindBy(how = How.CSS, using = "#new_design3")
	private WebElement elapseTimeCell;
	
	@FindBy(how = How.CSS, using = "#new_design4")
	private WebElement workOrderCell;
	
	@FindBy(how = How.CSS, using = "#lastUpdateSession")
	private WebElement sessionLastUpdateTime;
	
	@FindBy(how = How.CSS, using = "#sessionDetailsData1")
	private WebElement sessionLastUpdateFullRow;
	
	@FindBy(how = How.CSS, using = "#rightScrollMenu")
	private WebElement graphScrollRight;
	
	@FindBy(how = How.CSS, using = "#leftScrollMenu")
	private WebElement graphScrollLeft;
	
	@WithTimeout(time = 3, chronoUnit = ChronoUnit.SECONDS)
	@FindBy(how = How.CSS, using = ".ajax-loader")
	@AndroidFindBy(id = "progress")
	@iOSXCUITFindBy(accessibility = "SVProgressHUD")
	private WebElement loadingSpinner;
	
	@FindBy(how = How.CSS, using = ".sessionDetailsMenuButton")
	@AndroidFindBy(id = "action_bar_item_menu_icon")
	@iOSXCUITFindBy(accessibility = "Options Menu")
	private WebElement moreOptionsButton; //... on top header
	
	@FindBy(how = How.CSS, using = "li[data-event='click:view-edit-session-setup']")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Session Setup\")")
	@iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'Session Setup'")
	private WebElement viewSessionSetup;
	
	@FindBy(how = How.CSS, using = "li[data-event='click:view-session-activity']")
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"View Session Activity\")")
	@iOSXCUITFindBy(accessibility = "View Session Activity")
	private WebElement viewSessionActivity;
	
	@FindBy(how = How.CSS, using = "#sessionActivityDoneButton")
	private WebElement sessionActivityDoneButton;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"End Session\")")
	@iOSXCUITFindBy(accessibility = "End Session")
	private WebElement endSessionButton;
	
	@WithTimeout(time = 3, chronoUnit = ChronoUnit.SECONDS)
	@AndroidFindBy(id = "dialog_ok")
	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'End Session'")
	private WebElement alertEndSessionButton;
	
	@WithTimeout(time = 3, chronoUnit = ChronoUnit.SECONDS)
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"My Notifications\")")
	@iOSXCUITFindBy(accessibility = "My Notifications")
	private WebElement myNotificationsStaticText;
	
	@WithTimeout(time = 2, chronoUnit = ChronoUnit.SECONDS)
	@AndroidFindBy(id = "action_bar_item_left")
	@iOSXCUITFindBy(accessibility = "Cancel")
	private WebElement myNotificationsCancelButton;
	
	@WithTimeout(time = 2, chronoUnit = ChronoUnit.SECONDS)
	@AndroidFindBy(id = "action_bar_item_left")
	@iOSXCUITFindBy(accessibility = "Back")
	private WebElement myNotificationsBackButton;

	@FindBy(how = How.CSS, using = "span[id='1HFilter']")
	@AndroidFindBy(id = "one_hour_graph")
	@iOSXCUITFindBy(accessibility = "1H")
	private WebElement graph1HTab;
	
	@FindBy(how = How.CSS, using = "span[id='8HFilter']")
	@AndroidFindBy(id = "one_day_graph")
	@iOSXCUITFindBy(accessibility = "8H")
	private WebElement graph8HTab;
	
	@FindBy(how = How.CSS, using = "span[id='12HFilter']")
	private WebElement graph12HTab;
	
	@FindBy(how = How.CSS, using = "span[id='1DFilter']")
	@AndroidFindBy(id = "one_day_graph")
	@iOSXCUITFindBy(accessibility = "1D")
	private WebElement graph1DTab;
	
	@FindBy(how = How.CSS, using = "span[id='1WFilter']")
	@AndroidFindBy(id = "one_week_graph")
	@iOSXCUITFindBy(accessibility = "1W")
	private WebElement graph1WTab;
	
	@FindBy(how = How.CSS, using = "span[id='3WFilter']")
	@AndroidFindBy(id = "one_month_graph")
	@iOSXCUITFindBy(accessibility = "3W")
	private WebElement graph3WTab;
	
	@FindBy(how = How.CSS, using = "span[id='1MFilter']")
	@AndroidFindBy(id = "one_month_graph")
	@iOSXCUITFindBy(accessibility = "1M")
	private WebElement graph1MTab;
	
	@FindAll( {
		@FindBy(how = How.CSS, using = "span[id='ALLFilter']"),
		@FindBy(how = How.CSS, using = "span[id='AllFilter']")
	} )
	@AndroidFindBy(id = "all_graph")
	@iOSXCUITFindBy(accessibility = "ALL")
	private WebElement graphAllTab;
	
	@FindBy(how = How.CSS, using = ".graph-dropdown-loader")
	@AndroidFindBy(id = "progressBarHolder")
	@iOSXCUITFindBy(iOSNsPredicate = "label == 'In progress' OR label CONTAINS 'In progress'")
	private WebElement progressBarHolder;
	
	@FindBy(how = How.CSS, using = "a[data-event = 'click:navigate-back']")
	@AndroidFindBy(id = "action_bar_item_left")
	@iOSXCUITFindBy(accessibility = "Back")
	private WebElement backButton;
	
	@FindBy(how = How.CSS, using = "path[stroke-linejoin='round']")
	public WebElement webGraphLines;
	
	@FindBy(how = How.CSS, using = "text[text-anchor='start']>tspan")
	private List<WebElement> dateTimeValueRawList; 
	
	@FindBy(how = How.CSS, using = ".sessionGraphTotalAlarmCount")
	private WebElement sensorAlarmCount;
	
	@iOSXCUITFindBy(accessibility = "Alarm Count")
	@FindBy(how = How.CSS, using = ".remoteMonitoringTotalAlarmCount")
	private WebElement sessionAlarmCount;
	
	@FindBy(how = How.CSS, using = ".sessionGraphTotalAlertCount")
	private WebElement sensorAlertCount;
	
	@iOSXCUITFindBy(accessibility = "Alert Count")
	@FindBy(how = How.CSS, using = ".remoteMonitoringTotalAlertCount")
	private WebElement sessionAlertCount;
	
	@FindBy(how = How.CSS, using = ".alarmsIcon")
	@iOSXCUITFindBy(accessibility = "Alarm Count")
	private List<WebElement> alarmIconList;
	
	@FindBy(how = How.CSS, using = ".notificationIcon")
	@iOSXCUITFindBy(accessibility = "Alert Count")
	private List<WebElement> alertIconList;
	
	@AndroidFindBy(id = "action_bar_item_left")
	@iOSXCUITFindBy(accessibility = "backBarButton")
	private WebElement sessionActivityBackButton;
	
	@FindBy(how = How.CSS, using = ".menuItemContainer")
	private List<WebElement> alarmNotificationList; 
	
	@FindBy(how = How.CSS, using = ".menuIconSprite")
	private WebElement addEditAlarmDialogBoxMenuIcon;
	
	@FindBy(how = How.CSS, using = "li[data-event='click:alarmsMenuClick']")
	@iOSXCUITFindBy(accessibility = "Alarm")
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Alarm\")")
	private WebElement addEditAlarmsButton;
	
	@FindBy(how = How.CSS, using = ".sessionAlarmsHeaderTypeBtn")
	private WebElement addAlarmButton;
	
	@FindBy(how = How.CSS, using = "li[data-attr='Vibration']")
	private WebElement addVibrationAlarmButton;
	
	@FindBy(how = How.CSS, using = "li[data-attr='TEMPERATURE']")
	private WebElement addTempratureAlarmButton;
	
	@FindBy(how = How.CSS, using = ".c3")
	private WebElement sessionActivityNotificationOptionsButton;
	
	@FindBy(how = How.CSS, using = "li[data-value='mark-as-read']")
	private WebElement markAsReadButton;
	
	@FindBy(how = How.CSS, using = ".alarm-tile-header.unread.read")
	private List<WebElement> markAsReadCell;
	
	@iOSXCUITFindBy(accessibility = "add gray")
	private WebElement addTextNote;
	
	@FindBy(how = How.CSS, using = "#sessionActivityHistoryNotes")
	@iOSXCUITFindBy(className = "XCUIElementTypeTextView")
	private WebElement textNoteTextArea;
	
	@FindBy(how = How.CSS, using = "#sessionActivityHistNotes")
	private WebElement textNote;
	
	@FindBy(how = How.CSS, using = "#sessionActivityAddButton")
	@iOSXCUITFindBy(accessibility = "Save")
	private WebElement textNoteAddButton;
	
	@FindBy(how = How.CSS, using = ".alarms_menu_dropdown")
	private WebElement alarmDropDownIcon;
	
	@iOSXCUITFindBy(accessibility = "accordion open gray")
	private WebElement durationFilterDropdownIcon;
	
	@iOSXCUITFindBy(accessibility = "filterIcon")
	private WebElement notificationTypeFilterIcon;
	
	@iOSXCUITFindBy(className = "XCUIElementTypePickerWheel")
	private WebElement durationDropDownList;
	
	@iOSXCUITFindBy(accessibility = "Done")
	private WebElement durationDropDownListDoneButton;
	
	@iOSXCUITFindBy(accessibility = "Cancel")
	private WebElement durationDropDownListCancelButton;
	
	// BUG_AUTOMATION

	@AndroidFindBy(id = "action_bar_title")
	private WebElement sensorInstallationDetails;

	@AndroidFindBy(id = "installation_detail")
	private WebElement installationDetails;

	@AndroidFindBy(id = "connection_strength_value")
	private WebElement connectionStrengthValue;

	@AndroidFindBy(id = "btn_show_notification")
	private WebElement showAlarms;

	@AndroidFindBy(id = "unit_data")
	private WebElement unit;

	@AndroidFindBy(id = "title")
	private WebElement title;

	@AndroidFindBy(id = "action_bar_item_menu_text")
	private WebElement deleteButton;

	@AndroidFindBy(id = "tv_signal_strength_dbm")
	private WebElement rssi;

	@AndroidFindBy(id = "tv_signal_strength_dbm")
	private WebElement temperatureUnitArrow;

	@FindBy(id = "container_name")
	private List<WebElement> vibUnit;

	@FindBy(id = "container_name")
	private List<WebElement> tempUnit;
	
	@AndroidFindBy(id = "tv_reconfigure_wifi")
	private WebElement reconfigureWiFi;
	
	@AndroidFindBy(id = "wifi_name")
	private WebElement wifiName;
	
	@AndroidFindBy(id = "template_edit")
	private WebElement editPassword;
	
	@AndroidFindBy(id = "wifi_password_view")
	private WebElement wifiPassword;
	
	@AndroidFindBy(id = "save_template")
	private WebElement saveButton;
	
	@AndroidFindBy(id = "dialog_title")
	private WebElement wifiErrorTitle;
	
	@AndroidFindBy(id = "alarm_data")
	private WebElement alarm;
	
	@AndroidFindBy(id = "below_alarm_value")
	private WebElement belowTempAlarm;
	
	private HomePage homePage;
	private MeasurementsHistoryPage measurementsHistory;
    //
	private GestureUtils gestureUtils;
	public int sensorCountInteger;
	private boolean graphDisplayedFlag;
	private boolean endSessionFlag = true;
	private List<String> dateList;
	private List<String> timeList;
	private int graphStartX = 0;
	private int graphStartY = 0;
	private int graphEndX = 0;
	private int graphEndY = 0;
	private AlarmPage mAlarmPage;
	private int mMarkAsReadCount;
 	
	public SessionDetailPage()
	{
		CommonUtils.initElements(this, 15);
		gestureUtils = new GestureUtils();
		mAlarmPage = new AlarmPage();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			sensorCountInteger = FCCM3560.androidSensorNameList.length;
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			sensorCountInteger = FCCM3560.iOSSensorNameList.length;
		} 
	}
	
	public enum SessionDetailPageObjectList
	{
		MORE_OPTIONS_BUTTON, VIEW_SESSION_ACTIVITY, VIEW_SESSION_SETUP, GRAPH_OBJECT,
		SENSOR_ALARM_COUNT, SESSION_ALARM_COUNT, SENSOR_ALERT_COUNT, SESSION_ALERT_COUNT, 
		SESSION_ACTIVITY_DONE_BUTTON, SESSION_ACTIVITY_BACK_BUTTON, BACK_BUTTON,
		ALARM_ICONS, ALERT_ICONS, ALARM_NOTIFICATION_LIST, ALARM_ICON, ADD_EDIT_ALARM_ICON,
		ADD_EDIT_ALARM, DURATION_FILTER_DROPDOWN_ICON, NOTIFICATION_TYPE_FILTER_ICON,
		DURATION_DROP_DOWN_LIST, DURATION_DROP_DOWN_LIST_DONE_BUTTON, DURATION_DROP_DOWN_LIST_CANCEL_BUTTON, ADD_EDIT_ALARM_BUTTON,
	}
	
	public WebElement getSessionDetailPageObject(SessionDetailPageObjectList objectName)
	{
		switch(objectName)
		{
		case MORE_OPTIONS_BUTTON:
			return moreOptionsButton;
		case VIEW_SESSION_ACTIVITY:
			return viewSessionActivity;
		case VIEW_SESSION_SETUP:
			return viewSessionSetup;
		case GRAPH_OBJECT:
			return graphObject;
		case SENSOR_ALARM_COUNT:
			return sensorAlarmCount;
		case SENSOR_ALERT_COUNT:
			return sensorAlertCount;
		case SESSION_ALARM_COUNT:
			return sessionAlarmCount;
		case SESSION_ALERT_COUNT:
			return sessionAlertCount;
		case SESSION_ACTIVITY_DONE_BUTTON:
			return sessionActivityDoneButton;
		case SESSION_ACTIVITY_BACK_BUTTON:
			return sessionActivityBackButton;
		case BACK_BUTTON:
			return backButton;
		case ALARM_ICON:
			return alarmDropDownIcon;
		case ADD_EDIT_ALARM_ICON:
			return addEditAlarmDialogBoxMenuIcon;
		case NOTIFICATION_TYPE_FILTER_ICON:
			return notificationTypeFilterIcon;
		case DURATION_FILTER_DROPDOWN_ICON:
			return durationFilterDropdownIcon;
		case DURATION_DROP_DOWN_LIST:
			return durationDropDownList;
		case DURATION_DROP_DOWN_LIST_DONE_BUTTON:
			return durationDropDownListDoneButton;
		case DURATION_DROP_DOWN_LIST_CANCEL_BUTTON:
			return durationDropDownListCancelButton;
		case ADD_EDIT_ALARM_BUTTON:
			return addEditAlarmsButton;
			default:
				return null;
		}
	}
	
	public List<WebElement> getSessionDetailPageObjects(SessionDetailPageObjectList objectName)
	{
		switch(objectName)
		{
		case ALARM_ICONS:
			return alarmIconList;
		case ALERT_ICONS:
			return alertIconList;
		case ALARM_NOTIFICATION_LIST:
			return alarmNotificationList;
			default:
				return null;
		}
	}
	
	public void makeMeasurementUnitInvisible(int androidFlexibleScrollSteps, int flexibleScrollSteps, int scrollCount)
	{
		gestureUtils.mScroll(flexibleScrollSteps, flexibleScrollSteps, scrollCount);	
	}
	
	public boolean isGraphDisplayed(String scrollString)
	{
		if(!ElementUtils.isDisplayed(2, 1, scrollString, null, null))
		{
			gestureUtils.mScroll(scrollString, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		}
		graphDisplayedFlag = false;
		graphDisplayedFlag = getGraphObject().isDisplayed();
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			graphDisplayedFlag = webGraphLines.isDisplayed();
		}
		return graphDisplayedFlag;
	}

	public void scrollToGraph(String objectName, String scrollString, int iOSScrollSteps, int androidScrollDownSteps, int scrollCount, int iOSFlexibleScrollSteps, int androidFlexibleScrollSteps)
	{
		if(!ElementUtils.isDisplayed(2, 1, ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "MAX", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, "MAX", LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS, "MAX")))
		{
			gestureUtils.scroll(Config.IOS_LOCATOR_STRATEGY_NAME, "MAX", null, "MAX", iOSFlexibleScrollSteps, androidFlexibleScrollSteps, null, null);
		}
	}
	
	public boolean isLivePollingHappening(String beforePollScreenshotLocation, String afterPollScreenshotLocation, String graphDeviationImage, String fileType, int iTerationValue, int pollingCount, int waitTimeBetweenScreenshots, String objectName, String scrollString)
	{
		boolean livePollingFlag = false;
		boolean graphImageComparisonFlag = false;
		try
		{
			int livePollingCounter = 0;
			scrollToGraph(objectName, scrollString, IOSUtils.getScrollSteps(ScrollDiection.DOWN), AndroidUtils.getScrollSteps(ScrollDiection.DOWN), 3, IOSUtils.getScrollSteps(ScrollDiection.FLEXIBLE_DOWN), AndroidUtils.getScrollSteps(ScrollDiection.FLEXIBLE_DOWN));
			ElementUtils.isDisplayed(1, graphObject);
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				ElementUtils.isDisplayed(1, webGraphLines);
			CommonUtils.wait(5);
			for(int j = 0; j < pollingCount; j++)
			{
				graphImageComparisonFlag = isGraphVarying(beforePollScreenshotLocation + " graph " + iTerationValue + " " + j + fileType, afterPollScreenshotLocation+ " graph " + iTerationValue + " " + j + fileType, graphDeviationImage+ " graph " + iTerationValue + " " + j + fileType, waitTimeBetweenScreenshots);
				if(graphImageComparisonFlag)
				{
					if(livePollingCounter == pollingCount-1)
						return false;
					else
						livePollingCounter++;
				}
				else
				{
					livePollingFlag = true;
					livePollingCounter = 0;
				}
			}
			return livePollingFlag;
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			return livePollingFlag;
		}
	}
	
	public boolean isGraphVarying(String beforePollScreenshotLocation, String afterPollScreenshotLocation, String graphDeviationImage, int waitTimeBetweenScreenshot)
	{
		try
		{
			VisualUtils.saveFCCMGraphScreenshot(graphObject, beforePollScreenshotLocation);
			CommonUtils.wait(waitTimeBetweenScreenshot);
			VisualUtils.saveFCCMGraphScreenshot(graphObject, afterPollScreenshotLocation);
			return VisualUtils.compareVisuals(beforePollScreenshotLocation , afterPollScreenshotLocation, graphDeviationImage);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return true;
		}
	}
	
	public WebElement getGraphObject()
	{
		return graphObject;
	}
	
	public WebElement getWebGraphLinesObject()
	{
		return webGraphLines;
	}
	
	public boolean isValueDisplayed(int iOSScrollSteps, int androidScrollSteps, int waitTimeForObjectToBeDisplayed, WebElement objectToBeDisplayed)
	{
		return true;
	}
	
	public String getElementVisibleTextInSessionTile(String elementAttributeValue)
	{
		return ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, elementAttributeValue, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, elementAttributeValue, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS, elementAttributeValue).getText();
	}
	
	public String getElementVisibleTextInSessionTileStrict(String elementAttributeValue)
	{
		return ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, elementAttributeValue, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, elementAttributeValue, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS, elementAttributeValue).getText();
	}
	
    public WebElement getElementInSessionTile(String elementAttributeValue)
	{
		return ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, elementAttributeValue, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, elementAttributeValue, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS, elementAttributeValue);
	}
   
	public WebElement getElementInSessionTileStrict(String elementAttributeValue)
	{
		return ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, elementAttributeValue, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, elementAttributeValue, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS, elementAttributeValue);
	}

	public void scrollUp(String objectName, String objectValue, int iOSScrollSteps, int androidScrollSteps)
	{
		gestureUtils.scroll(objectName, objectValue, null, objectValue, iOSScrollSteps, androidScrollSteps, null, null);
	}
	
	public boolean isSessionEnded(String sessionStartTime) throws Exception
	{
		endSession();
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			endSessionFlag = gestureUtils.mScroll(sessionStartTime, null, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ScrollDiection.DOWN);
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			endSessionFlag = DriverManager.getDriver().getPageSource().contains(sessionStartTime);
		}
		return endSessionFlag;
	}
	
	public void endSession() throws Exception
	{
		ElementUtils.reliableClick(10, 1, moreOptionsButton, endSessionButton, 6);
		ElementUtils.clickIfDisplayedAndEnabled(endSessionButton);
		ElementUtils.isDisplayed(60, 1, alertEndSessionButton);
		ElementUtils.clickIfDisplayedAndEnabled(alertEndSessionButton);
	}
	
	public void reset3560Timestamp()
	{
		if(DriverManager.getEnvironmentName().equals(Config.PREPRODUCTION))
		{
			FCCMUtils.setSessionVariableValue(Config.FCCM_PROPERTIES_FILE_PATH, FCCM3560.androidCompletedSessionStartTimestamp, FCCM3560.iOSCompletedSessionStartTimestamp, FCCM3560.sessionStartTimestampValue);
			FCCMUtils.setSessionVariableValue(Config.FCCM_PROPERTIES_FILE_PATH, FCCM3560.androidCompletedSessionGatewayName, FCCM3560.iOSCompletedSessionGatewayName, FCCM3560.gatewayNameValue);
			FCCMUtils.setSessionVariableValue(Config.FCCM_PROPERTIES_FILE_PATH, FCCM3560.androidSessionStartTimestamp, FCCM3560.iOSSessionStartTimestamp, "null");
			FCCMUtils.setSessionVariableValue(Config.FCCM_PROPERTIES_FILE_PATH, FCCM3560.androidGatewayName, FCCM3560.iOSGatewayName, "null");
		}
		else if(DriverManager.getEnvironmentName().equals(Config.PRODUCTION))
		{
			FCCMUtils.setSessionVariableValue(Config.FCCM_PROPERTIES_FILE_PATH_PROD, FCCM3560.androidCompletedSessionStartTimestamp, FCCM3560.iOSCompletedSessionStartTimestamp, FCCM3560.sessionStartTimestampValue);
			FCCMUtils.setSessionVariableValue(Config.FCCM_PROPERTIES_FILE_PATH_PROD, FCCM3560.androidCompletedSessionGatewayName, FCCM3560.iOSCompletedSessionGatewayName, FCCM3560.gatewayNameValue);
			FCCMUtils.setSessionVariableValue(Config.FCCM_PROPERTIES_FILE_PATH_PROD, FCCM3560.androidSessionStartTimestamp, FCCM3560.iOSSessionStartTimestamp, "null");
			FCCMUtils.setSessionVariableValue(Config.FCCM_PROPERTIES_FILE_PATH_PROD, FCCM3560.androidGatewayName, FCCM3560.iOSGatewayName, "null");
		}
		CommonUtils.wait(30);  //to ensure session ended
	}
	
	public void reset3550Timestamp()
	{
		FCCMUtils.setSessionVariableValue(Config.FCCM_PROPERTIES_FILE_PATH, FCCM3550.androidCompletedSessionStartTimestamp, FCCM3550.iOSCompletedSessionStartTimestamp, FCCM3550.sessionStartTimestampValue);
		FCCMUtils.setSessionVariableValue(Config.FCCM_PROPERTIES_FILE_PATH, FCCM3550.androidSessionStartTimestamp, FCCM3550.iOSSessionStartTimestamp, "null");
		CommonUtils.wait(30);  //to ensure session ended
	}
	
	public void clickOnBackButton() throws Exception
	{
		ElementUtils.click(2, backButton);
	}
	
	public void clickOnMyNotificationsCancelButton() throws Exception
	{
		if(ElementUtils.isDisplayed(5, 1, myNotificationsStaticText))
		{
			ElementUtils.clickIfDisplayedAndEnabled(3, 1, myNotificationsCancelButton);
		}
	}
	
	public void isPageLoaded()
	{
		CommonUtils.wait(5);
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			ElementUtils.isNotDisplayed(loadingSpinner, 10);
		CommonUtils.wait(2);
	}
	
	public void switchToOtherTab(String tabName, ScrollDiection scrollDirection) throws Exception
	{
		switch(tabName)
		{
		case"1H":
			scrollToGraphTab(tabName, scrollDirection);
			graph1HTab.click();
			CommonUtils.wait(5, 10, 10);
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				ElementUtils.isNotDisplayed(loadingSpinner, 10);		
			break;
		case"8H":
			scrollToGraphTab(tabName, scrollDirection);
			graph8HTab.click();
			CommonUtils.wait(5, 10, 10);
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				ElementUtils.isNotDisplayed(loadingSpinner, 10);	
			break;
		case"12H":
			scrollToGraphTab(tabName, scrollDirection);
			graph12HTab.click();
			CommonUtils.wait(5, 10, 10);
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				ElementUtils.isNotDisplayed(loadingSpinner, 10);	
			break;
		case"1D":
			scrollToGraphTab(tabName, scrollDirection);
			graph1DTab.click();
			CommonUtils.wait(5, 10, 10);
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				ElementUtils.isNotDisplayed(loadingSpinner, 10);	
			break;
		case"1W":
			scrollToGraphTab(tabName, scrollDirection);
			graph1WTab.click();
			CommonUtils.wait(5, 10, 10);
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				ElementUtils.isNotDisplayed(loadingSpinner, 10);	
			break;
		case"3W":
			scrollToGraphTab(tabName, scrollDirection);
			graph3WTab.click();
			CommonUtils.wait(5, 10, 10);
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				ElementUtils.isNotDisplayed(loadingSpinner, 10);	
			break;
		case"1M":
			scrollToGraphTab(tabName, scrollDirection);
			graph1MTab.click();
			CommonUtils.wait(5, 10, 10);
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				ElementUtils.isNotDisplayed(loadingSpinner, 10);	
			break;
		case"ALL":
			scrollToGraphTab(tabName, scrollDirection);
			graphAllTab.click();
			CommonUtils.wait(5, 10, 10);
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				ElementUtils.isNotDisplayed(loadingSpinner, 10);	
			break;
		case"All":
			scrollToGraphTab(tabName, scrollDirection);
			graphAllTab.click();
			CommonUtils.wait(5, 10, 10);
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				ElementUtils.isNotDisplayed(loadingSpinner, 10);	
			break;
		case"ALL3550":
			scrollToGraphTab("1H", scrollDirection);
			graphAllTab.click();
			CommonUtils.wait(5, 10, 10);
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				ElementUtils.isNotDisplayed(loadingSpinner, 10);	
			break;
		}		
	}
	
	public boolean scrollToGraphTab(String tabName, ScrollDiection scrollDirection)
	{
		return gestureUtils.mScroll(tabName, LocatorStrategy.IOS_LOCATOR_STRATEGY_LABEL, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, scrollDirection);
	}
	
	public String getSessionStartDate()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			return sessionStartTime.getText().split(" ")[0];
		}
		else
		{
			return sessionStartTime.getText().split(",")[0];
		}
	}
	
	public String getSessionStartTime()
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			return sessionStartTime.getText().split(" ")[1];
		}
		else
		{
			return sessionStartTime.getText().split(",")[1].trim();
		}
	}
	
	public List<String> getDateList()
	{
		for(int i = 0; i < 11; i+=2)
		{
			dateList.add(dateTimeValueRawList.get(i).getText());
		}
		return dateList;
	}
	
	public List<String> getTimeList()
	{
		for(int i = 1; i < 12; i+=2)
		{
			timeList.add(dateTimeValueRawList.get(i).getText());
		}
		return dateList;
	}
	
	public void scrollGraph(ScrollDiection scrollDirection)
	{
		switch(scrollDirection)
		{
		case RIGHT:
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				graphScrollRight.click();
				ElementUtils.isNotDisplayed(15, 1, progressBarHolder);
			}
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				gestureUtils.swipeByCordinates(graphStartX, graphStartY, graphEndX, graphEndY);
				ElementUtils.isNotDisplayed(15, 1, progressBarHolder);
			}
			break;
		case LEFT:
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			{
				graphScrollLeft.click();
				ElementUtils.isNotDisplayed(15, 1, progressBarHolder);
			}
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				gestureUtils.swipeByCordinates(graphStartX, graphStartY, graphEndX, graphEndY);
				ElementUtils.isNotDisplayed(15, 1, progressBarHolder);
			}
			break;
		default:
			
		}
	}
	
	public void setGraphSwipeCordinates(ScrollDiection scrollDirection)
	{
		switch(scrollDirection)
		{
		case RIGHT:
			graphStartX = getGraphObject().getLocation().x;
			graphStartY = getGraphObject().getLocation().y + getGraphObject().getSize().height / 2;
			graphEndX = getGraphObject().getLocation().x + getGraphObject().getSize().width;
			graphEndY = 0; 
			break;
		case LEFT:
			graphStartX = getGraphObject().getLocation().x + getGraphObject().getSize().width;
			graphStartY = getGraphObject().getLocation().y + getGraphObject().getSize().height / 2;
			graphEndX = -(getGraphObject().getLocation().x + getGraphObject().getSize().width);
			graphEndY = 0;
			break;
		default:
			graphStartX = 0;
			graphStartY = 0;
			graphEndX = 0;
			graphEndY = 0;
			break;
		}
	}
	
	public void resetGraphSwipeCordinates()
	{
		graphStartX = 0;
		graphStartY = 0;
		graphEndX = 0;
		graphEndY = 0;
	}
	
	public void scrollGraph(ScrollDiection scrollDirection, int scrollCount)
	{
		resetGraphSwipeCordinates();
		setGraphSwipeCordinates(scrollDirection);
		for(int i = 0; i < scrollCount; i++)
		{
			scrollGraph(scrollDirection);
		}
	}
	
	public void openFirstSession() throws Exception
	{
		ElementUtils.click(10, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, "Start Time", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, "Start Time", null, null);
	}
	
	public void addAlarm(FeatureList featureName, AlarmType alarmType, String unit, String upperRange, String lowerRange, ScrollDiection unitScrollDirection, int scrollCounter, boolean adminFlag, boolean teamMemberFlag, String teamMemberUID)
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			switch(featureName) {
			case FCCM3560_VIB:
				addEditAlarmDialogBoxMenuIcon.click();
				addEditAlarmsButton.click();
				addAlarmButton.click();
				addVibrationAlarmButton.click();
				mAlarmPage.addAlarm(alarmType, unit, upperRange, lowerRange, unitScrollDirection, scrollCounter, adminFlag, teamMemberFlag, teamMemberUID);
				break;
			case FCCM3560_TEMP:
				addEditAlarmDialogBoxMenuIcon.click();
				addEditAlarmsButton.click();
				addAlarmButton.click();
				addTempratureAlarmButton.click();
				mAlarmPage.addAlarm(alarmType, unit, upperRange, lowerRange, unitScrollDirection, scrollCounter, adminFlag, teamMemberFlag, teamMemberUID);
				break;
			case FCCM3550:
				gestureUtils.webScroll(ScrollDiection.DOWN, 1);
				addEditAlarmDialogBoxMenuIcon.click();
				addEditAlarmsButton.click();
				addAlarmButton.click();
				mAlarmPage.addAlarm(alarmType, unit, upperRange, lowerRange, unitScrollDirection, scrollCounter, adminFlag, teamMemberFlag, teamMemberUID);
				break;
			default:
				break;
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			CommonUtils.wait(1);
			switch (featureName) {
			case FCCM3560_VIB:
				mAlarmPage.getAlarmPageObject(AlarmPageObjectList.ADD_VIBRATION_ALARM).click();
				break;
			case FCCM3560_TEMP:
				mAlarmPage.getAlarmPageObject(AlarmPageObjectList.ADD_TEMPRATURE_ALARM).click();
				break;
			default:
				break;
			}
			mAlarmPage.addAlarm(alarmType, unit, upperRange, lowerRange, unitScrollDirection, scrollCounter, adminFlag, teamMemberFlag, teamMemberUID);
		}
	}
	
	public void navigateToSessionOptions(SessionDetailPageObjectList objectName) {
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) 
			moreOptionsButton.click();
		switch (objectName) {
		case VIEW_SESSION_SETUP:
			viewSessionSetup.click();
			break;
		case VIEW_SESSION_ACTIVITY:
			viewSessionActivity.click();
			break;
		case ADD_EDIT_ALARM:
			viewSessionSetup.click();
			gestureUtils.mScroll("Alarm", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
			addEditAlarmsButton.click();
			break;
		default:
			break;
		}
	}
	
	public void editAlarm(AlarmType alarmType, String unit, String upperRange, String lowerRange, ScrollDiection unitScrollDirection, int scrollCounter) {
		mAlarmPage.editAlarm(alarmType, unit, upperRange, lowerRange, unitScrollDirection, scrollCounter);
	}
	
	public void deleteAlarm(AlarmType alarmType, String alarmText)  //for web it always delete first alarm
	{
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
		addEditAlarmDialogBoxMenuIcon.click();
		addEditAlarmsButton.click();
		mAlarmPage.deleteAlarm(alarmType, alarmText);
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) 
			mAlarmPage.deleteAlarm(alarmType, alarmText);
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) 
			mAlarmPage.deleteAlarm(alarmType, alarmText);
	}
	
	public void deleteAllAlarms(int maxCount) {
		mAlarmPage.deleteAllAlarms(maxCount);
	}
	
	public void notificationMarkAsRead()
	{
		mMarkAsReadCount = markAsReadCell.size();
		ElementUtils.safeClick(sessionActivityNotificationOptionsButton);
		CommonUtils.wait(2);
		ElementUtils.safeClick(markAsReadButton);
		CommonUtils.wait(2);
	}
	
	public boolean isNotificationRead()
	{
		if(mMarkAsReadCount <= markAsReadCell.size())
			return true;
		else
			return false;
	}
	
	public void addTextNote(String textMessage)
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) 
			addTextNote.click();
		ElementUtils.sendKeys(textNoteTextArea, textMessage);
		textNoteAddButton.click();
	}
	
	public boolean isTextNoteAdded(String textMessage)
	{
		return ElementUtils.getElement(null, null, null, null, LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT_CONTAINS, textMessage).isDisplayed();
	}

	// BUG_AUTOMATION
	public void tapOnActiveSession(String gatewayName, ScrollDiection scrollDirection) throws Exception {
		homePage.clickOnViewActiveMonitoringSessionButton();
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, gatewayName,
				LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, gatewayName, null, null).click();

	}

	public void tapOnSessionWithGatewayConnectionLost(String gatewayName, ScrollDiection scrollDirection)
			throws Exception {
		homePage.clickOnViewActiveMonitoringSessionButton();
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, gatewayName,
				LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, gatewayName, null, null).click();

	}

	public void tapOnCompletedSession(String gatewayName, ScrollDiection scrollDirection) throws Exception {
		measurementsHistory.clickOnViewCompletedSessionsLink();
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, gatewayName,
				LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE_CONTAINS, gatewayName, null, null).click();

	}

	public boolean clickOnInstallationDetails() {
	 installationDetails.click();
		return ElementUtils.isDisplayed(sensorInstallationDetails);
	}

	public void checkConnectionStrength() throws Exception {
		if (connectionStrengthValue.getText().equals("Unavailable")) {
			clickOnInstallationDetails();

		}
	}

	public boolean isRSSIDisplayedWhenConnectionStrengthIsUnavailable() {
		return ElementUtils.isDisplayed(rssi);
	}

	public void clickOnShowAlarms() {
		showAlarms.click();
	}

	public boolean checkIfUnitIsDisplayed() {
		return ElementUtils.isDisplayed(unit);
	}

	public boolean deleteButtonIsDisabled() {
		measurementsHistory.clickOnViewCompletedSessionsLink();
		moreOptionsButton.click();
		title.click();
		gatewayName.click();
		sessionStartTime.click();
		return ElementUtils.isEnabled(deleteButton);
	}

	public void selectVibTempUnit() {
		vibUnit.get(2).click();
		getSessionDetailPageObject(SessionDetailPageObjectList.BACK_BUTTON);
		tempUnit.get(2).click();
	}
	public boolean getWiFiErrorInReconfigureWiFi()
	{
		reconfigureWiFi.click();
		CommonUtils.wait(20);
	    if (wifiName.getText().equals("FC-Net"))
           editPassword.click();
		wifiPassword.sendKeys("password");
		saveButton.click();
		Select list = new Select(wifiName);
		list.selectByVisibleText("FC-Net");
		String actual = wifiErrorTitle.getText();
		String expected = "3502FC Gateway unable to Connect to Fluke Cloud";
		if(actual.equals(expected))
		{
			return true;
		}
		return false;
	}
	public boolean verifyIfSessionSetupIdDisplayed()
	{
		return ElementUtils.isDisplayed(reconfigureWiFi);
	}
	public boolean checkIfVibrationUnitIsDisplayedForBelowTempAlarm()
	{
		alarm.click();
		gestureUtils.mScroll("Below Temperature Alarm", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
		String value = belowTempAlarm.getText();
		if(value.contains("g"))
		{
			return true;
		}
		return false;
	}
	

}
