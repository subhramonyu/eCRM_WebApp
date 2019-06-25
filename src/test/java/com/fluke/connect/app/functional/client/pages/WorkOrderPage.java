package com.fluke.connect.app.functional.client.pages;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.fluke.connect.app.testdata.FCM.DataType;
import com.fluke.connect.app.testdata.FCM.MeasurementType;
import com.fluke.connect.app.testdata.FCM.ShareFormat;
import com.fluke.connect.app.utils.AndroidUtils;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DateAndTimeUtils;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.GestureUtils.ObjectName;
import com.fluke.connect.app.utils.Gestures;
import com.fluke.connect.app.utils.IOSUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.ScrollDiection;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class WorkOrderPage {
	@AndroidFindBy(id = "com.fluke.deviceApp:id/search_text")
	@iOSFindBy(accessibility = "Search")
	@FindBy(how = How.CSS, using = "#woListFilterTypeSearch")
	private WebElement workOrderSearchField;

	@AndroidFindBy(id = "com.fluke.deviceApp:id/title")
	@iOSFindBy(accessibility = "Work Order Title")
	private WebElement workOrderTitle;

	@iOSXCUITFindBy(iOSNsPredicate = "name CONTAINS 'is assigned to you'")
	@FindBy(how = How.CSS, using = "div[title='1']")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"is assigned to you\")")
	private WebElement firstWorkOrderIdentifier;

	@AndroidFindBy(id = "com.fluke.deviceApp:id/back_left")
	@iOSFindBy(accessibility = "backBarButton")
	@FindBy(how = How.CSS, using = "a[data-event='click:navigate-back']")
	private WebElement backBarButton;

	@AndroidFindBy(id = "com.fluke.deviceApp:id/clear")
	@iOSFindBy(accessibility = "Clear text")
	private WebElement clearTextInSearchField;

	@AndroidFindBy(id = "com.fluke.deviceApp:id/work_order_title")
	private WebElement androidWorkOrderTitle;

	@iOSFindBy(accessibility = "Filter")
	@FindBy(how = How.CSS, using = "#woListFilterTypeSearch")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/search_text")
	private WebElement filterButton;

	// work orders page --> ... button
	@iOSFindBy(accessibility = "more btn")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/history_menu_button")
	@FindBy(how = How.CSS, using = "div[class='sidbar-header-float show_more_options']")
	private WebElement moreButton;

	// work orders page --> ... button --> Add Work Order
	@iOSFindBy(accessibility = "Add Work Order")
	@AndroidFindBy(id = "android:id/title")
	@FindBy(how = How.CSS, using = "#add_new_work_order")
	private WebElement addWorkOrderButton;

	// work orders page --> ... button --> Cancel
	@iOSFindBy(accessibility = "Cancel")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/back_left")
	private WebElement cancelButton;

	// Add Work Order --> Title
	@iOSFindBy(accessibility = "Work Order Title")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/title")
	@FindBy(how = How.CSS, using = "#workOrderTitle")
	private WebElement workOrderTitleTextField;

	// Add Work Order --> Description
	@iOSFindBy(accessibility = "Work Order Description")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/longDescription")
	@FindBy(how = How.CSS, using = "#workOrderDescription")
	private WebElement workOrderDescriptionTextField;

	// Add Work Order --> Schedule WO --> Check box
	@iOSFindBy(accessibility = "checkbox off")
	private WebElement checkBoxButton;

	// Add Work Order --> Schedule WO --> Check box --> Back button
	@iOSFindBy(accessibility = "Back")
	private WebElement backButton;

	// Add / Edit Work Order --> priority cell
	@AndroidFindBy(id = "com.fluke.deviceApp:id/priorityLayout")
	@iOSFindBy(accessibility = "PriortyCell")
	@FindBy(how = How.CSS, using = "#workOrderPriorityOptions")
	private WebElement priorityCell;

	// priority and work type cell for Web
	@FindBy(how = How.CSS, using = ".custom-context-menu-down-pointer-container")
	private List<WebElement> priorityWorkTypeCellForWeb;

	// Add / Edit Work Order --> priority / work type cell --> back button
	@iOSXCUITFindBy(accessibility = "arrow back")
	private WebElement arrowBackButton;

	// Add / Edit Work Order --> priority cell --> High priority button
	@AndroidFindBy(uiAutomator = "new UiSelector().textStartsWith(\"High\")")
	@iOSFindBy(accessibility = "High")
	private WebElement highPriorityButton;

	// priority cell for web
	@FindBy(how = How.CSS, using = "li.work-order-priority-list-item")
	private List<WebElement> priorityCellForWeb;

	// work type cell for web
	@FindBy(how = How.CSS, using = "li.work-order-type-list-item")
	private List<WebElement> workTypeCellForWeb;

	// Add / Edit Work Order --> priority cell --> Standard priority button
	@AndroidFindBy(uiAutomator = "new UiSelector().textStartsWith(\"Standard\")")
	@iOSFindBy(accessibility = "Standard")
	private WebElement standardPriorityButton;

	// Add / Edit Work Order --> priority cell --> Low priority button
	@AndroidFindBy(uiAutomator = "new UiSelector().textStartsWith(\"Low\")")
	@iOSFindBy(accessibility = "Low")
	private WebElement lowPriorityButton;

	// Add / Edit Work Order --> Work Order type cell
	@iOSFindBy(accessibility = "Work type")
	@FindBy(how = How.CSS, using = "#workOrderTypeOptions")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/worktypelayout")
	private WebElement workTypeCell;

	// Add / Edit Work Order --> Work Order type cell --> Unplanned
	@iOSFindBy(accessibility = "Unplanned")
	@AndroidFindBy(uiAutomator = "new UiSelector().textStartsWith(\"Unplanned\")")
	private WebElement unplannedButton;

	// Add / Edit Work Order --> Work Order type cell --> Unassigned
	@iOSFindBy(accessibility = "Unassigned")
	@AndroidFindBy(uiAutomator = "new UiSelector().textStartsWith(\"Unassigned\")")
	private WebElement unassignedButton;

	// Add / Edit Work Order --> Work Order type cell --> Planned
	@iOSFindBy(accessibility = "Planned")
	@AndroidFindBy(uiAutomator = "new UiSelector().textStartsWith(\"Planned\")")
	private WebElement plannedButton;

	// Add / Edit Work Order --> Save button
	@HowToUseLocators(iOSAutomation = ALL_POSSIBLE, androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(id = "com.fluke.deviceApp:id/save_button")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/save_btn")
	@iOSFindBy(accessibility = "Save")
	// @iOSFindBy(accessibility = "SAVE")
	@FindBy(how = How.CSS, using = "a[data-event='click:work-order-add-submit']")
	private WebElement saveButton;

	// Add / Edit Work Order --> SCHEDULED WORK cell
	@iOSFindBy(accessibility = "SCHEDULED WORK")
	private WebElement scheduledWorkCell;

	// Add / Edit Work Order --> SCHEDULED WORK cell --> Schedule Work Order
	// button
	@iOSFindBy(xpath = "//XCUIElementTypeOther[@name='SCHEDULED WORK']/following::XCUIElementTypeOther")
	private WebElement scheduledWorkOrderButton;

	// Add / Edit Work Order --> SCHEDULED WORK cell --> Done
	@HowToUseLocators(iOSAutomation = ALL_POSSIBLE)
	@iOSFindBy(accessibility = "DONE")
	private WebElement doneButton;

	// Done button when adding manual measurement on iOs
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeButton' AND name=='Done'")
	private List<WebElement> doneList;

	// Add / Edit Work Order --> Status
	@iOSXCUITFindBy(accessibility = "ChangeStatusCell")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/status_layout")
	private WebElement changeStatusCell;

	// Add / Edit Work Order --> Status --> Open
	@iOSFindBy(accessibility = "Open")
	@FindBy(how = How.CSS, using = "#open")
	@AndroidFindBy(uiAutomator = "new UiSelector().textStartsWith(\"Open\")")
	private WebElement openStatusButton;

	// Add / Edit Work Order --> Status --> In-Progress
	@iOSFindBy(accessibility = "In-Progress")
	@FindBy(how = How.CSS, using = "#inprogress")
	@AndroidFindBy(uiAutomator = "new UiSelector().textStartsWith(\"In-progress\")")
	private WebElement inProgressStatusButton;

	// Add / Edit Work Order --> Status --> Completed
	@iOSFindBy(accessibility = "Completed")
	@FindBy(how = How.CSS, using = "#completed")
	@AndroidFindBy(uiAutomator = "new UiSelector().textStartsWith(\"Completed\")")
	private WebElement completedStatusButton;

	// Add / Edit Work Order --> Status --> Closed
	@iOSFindBy(accessibility = "Closed")
	@FindBy(how = How.CSS, using = "#closed")
	@AndroidFindBy(uiAutomator = "new UiSelector().textStartsWith(\"Closed\")")
	private WebElement closedStatusButton;

	// Add / Edit Work Order --> Status --> Text Note
	@iOSFindBy(accessibility = "Text Note")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/text_note")
	private WebElement textNoteTextArea;

	// Add / Edit Work Order --> Status --> Voice Note
	@iOSFindBy(accessibility = "Microphone")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/voice_note")
	private WebElement voiceNoteMicrophoneButton;

	// Add / Edit Work Order --> Status --> Voice Note --> Start / stop
	// recording button
	@iOSFindBy(accessibility = "Start or Stop Recording")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/record_btn")
	private WebElement startStopRecordingButton;

	// Edit Work Order --> START WORK ORDER
	@HowToUseLocators(iOSAutomation = ALL_POSSIBLE)
	@iOSFindBy(accessibility = "START WORK ORDER")
	@iOSFindBy(accessibility = "startWorkOrder")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/start_work_order")
	@FindBy(how = How.CSS, using = "[data-event='click:add-assets-testpoints']")
	private WebElement startWorkOrderButton;

	// Edit Work Order --> START WORK ORDER --> CAPTURE MEASUREMENTS
	@iOSFindBy(accessibility = "CAPTURE MEASUREMENTS")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/capture_measurements")
	private WebElement captureMeasurementsButton;

	// Edit Work Order --> START WORK ORDER --> Manual Measurements
	@iOSFindBy(accessibility = "asset icon")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/measurements_manual")
	private WebElement manualMeasurementsButton;

	// Edit Work Order --> Assignee
	@iOSFindBy(accessibility = "options gray")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/schedule_options")
	private WebElement assigneeOptionsButton;

	// Edit Work Order --> Assignee --> Edit
	@iOSFindBy(accessibility = "Edit")
	private WebElement assigneeOptionsEditButton;

	// Add / Edit Work Order --> Priority
	@iOSFindBy(accessibility = "Priority")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/priorityLayout")
	private List<WebElement> priorityTextField;

	// Add / Edit Work Order --> Work Type
	@iOSFindBy(accessibility = "Work Type")
	private List<WebElement> workTypeTextField;

	// Add / Edit Work Order --> Status
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Status']/following-sibling::XCUIElementTypeStaticText")
	private WebElement statusTextField;

	// Add / Edit Work Order --> View Activity Stream & Notes
	@HowToUseLocators(iOSAutomation = ALL_POSSIBLE)
	@iOSFindBy(accessibility = "View Activity Stream & Notes")
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Status']/following-sibling::XCUIElementTypeStaticText")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/activty_stream")
	private WebElement viewActivityStreamNotesButton;

	// Add / Edit Work Order --> View Activity Stream & Notes --> text note list
	// 1st text note
	@iOSFindBy(xpath = "//XCUIElementTypeTextView")
	private WebElement textNoteListFirstTextView;

	// Add / Edit Work Order --> View Activity Stream & Notes --> text note list
	// 1st text note --> text view
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='TEXT NOTE']/following::XCUIElementTypeTextView")
	private WebElement textNoteTextView;

	// ... to duplicate or delete work order after opening the wo
	@AndroidFindBy(id = "com.fluke.deviceApp:id/menu_icon")
	@iOSFindBy(accessibility = "more btn")
	@FindBy(how = How.CSS, using = "div.c3")
	private WebElement menuToDelOrDuplicateWo;

	// to duplicate or delete workorder after opening work order in web
	@FindBy(how = How.CSS, using = "div.sidbar-header-float.show_more_options")
	private List<WebElement> menuToDelOrDuplicateWoInWeb;

	// Edit Work Order --> ... --> Duplicate Work Order
	@iOSFindBy(accessibility = "Duplicate Work Order")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Duplicate Work Order\")")
	@FindBy(how = How.CSS, using = "li[data-event='click:duplicate-wo']")
	private WebElement duplicateWorkOrderButton;

	// Edit Work Order --> ... --> Delete Work Order
	@iOSFindBy(accessibility = "Delete Work Order")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Delete Work Order\")")
	@FindBy(how = How.CSS, using = "li[data-event='click:delete-wo']")
	private WebElement deleteWorkOrderButton;

	// Edit Work Order --> ... --> Delete Work Order --> Delete

	@HowToUseLocators(iOSAutomation = ALL_POSSIBLE)
	@iOSFindBy(accessibility = "Delete")
	// @iOSFindBy(xpath = "(//XCUIElementTypeButton[@name='Add'])[2]")
	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Delete'")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/dialog_ok")
	@FindBy(how = How.CSS, using = "#workOrderDeleteConfirmation")
	private WebElement deleteWorkOrderAlertDeleteButton;

	// add confirmation in iOS
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeButton' AND name =='Add'")
	private List<WebElement> addConfirmation;

	// delete confirmation in iOS
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeButton' AND name =='Delete'")
	private List<WebElement> deleteConfirmation;

	// Work Order page --> All Work Orders tab
	@WithTimeout(time = 30, chronoUnit = ChronoUnit.SECONDS)
	@iOSFindBy(accessibility = "ALL WORK ORDERS")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/allWorkOrderT")
	// @FindBy(how=How.CSS,using="div#workOrdersTabs div.down-pointer")
	private WebElement allWorkOrdersTabButton;

	// Work Order page --> My Work Orders tab
	@iOSFindBy(accessibility = "MY WORK ORDERS")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/myWorkOrderT")
	private WebElement myWorkOrdersTabButton;

	// Work Order page --> Work Orders static text
	@iOSFindBy(accessibility = "WORK ORDERS")
	private WebElement workOrdersStaticText;

	// add work order
	@AndroidFindBy(id = "com.fluke.deviceApp:id/add_work_order")
	@FindBy(how = How.CSS, using = "[data-event='click:schedule-work-order']")
	@iOSFindBy(accessibility = "startWorkOrder")
	private WebElement scheduleWorkOrderButton;

	// estimated target work date picker
	@FindBy(how = How.CSS, using = "label[for='targetDate'] .date-picker-date-icon")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/estimated_date_icon")
	@iOSFindBy(accessibility = "EstimatedWorkTimeBtn")
	private WebElement estimateDatePicker;

	// OK button in date picker
	@AndroidFindBy(id = "android:id/button1")
	private List<WebElement> okButton;

	@iOSFindBy(accessibility = "Select")
	private WebElement selectDatePicker;

	// Estimated Hours text
	@FindBy(how = How.CSS, using = "#workOrderEstimatedHours")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/estimatedhours")
	@iOSFindBy(xpath = "(//XCUIElementTypeTextField[@name='Estimated Hours'])[1]")
	private WebElement workOrderEstimatedHours;

	// scheduled Date Picker
	@FindBy(how = How.CSS, using = "[label[for='scheduledDate'] .date-picker-date-icon]")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/date_icon")
	@iOSFindBy(accessibility = "calendar")
	private WebElement scheduledDatePicker;

	// Work order assignee select check box for mobile and text field for web
	@FindBy(how = How.CSS, using = "#workOrderAssigneeOptions")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/check_assignee")
	@iOSFindBy(accessibility = "checkbox off")
	private WebElement workOrderAssigneeOptions;

	// Add assignee button
	@FindBy(how = How.CSS, using = "[data-event='click:confirm-schedule-change']")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/save_button")
	private WebElement assigneeButton;

	// Schedule wo ... icon in android and button in web
	@FindBy(how = How.CSS, using = "[data-event='click:schedule-work-order']")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/schedule_options")
	private WebElement scheduleWorkOrder;

	// add assignee button in search for web
	@FindBy(how = How.CSS, using = "[data-event='click:add-assignee']")
	private WebElement addAssigneeBtn;

	// overview tab to verify the work order status
	@FindBy(how = How.CSS, using = "a[href='/work-orders/overview'].common-header-link")
	private WebElement workOrderOverview;

	// overview tab to verify the work order status
	@FindBy(how = How.CSS, using = "a[href='/work-orders/list'].common-header-link")
	private WebElement workOrderList;

	// List of work order on overview page in web
	@FindBy(how = How.CSS, using = "div.wo-ovl-data")
	private List<WebElement> listWorkOrdersOverview;

	// text note area
	@FindBy(how = How.CSS, using = "textarea#add-note")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/new_session_note")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeCell'")
	private WebElement addNotes;

	@FindBy(how = How.CSS, using = "[data-event='click:wo-add-notes']")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Add Notes\")")
	@iOSFindBy(accessibility = "Add Notes")
	private WebElement addNotesButton;

	// check notification
	@FindBy(how = How.CSS, using = "span#user_notification.account_notification")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/notification_count")
	@iOSFindBy(accessibility = "AlarmBadgeCount")
	private WebElement userNotification;

	// Saved Link
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Saved Data')]")
	private WebElement savedDataLink;

	// Add data after adding test point
	@FindBy(how = How.CSS, using = "#add-data-btn")
	private WebElement addDataButtonInSavedData;

	// Wo prior arrow in saved data for web
	@FindBy(how = How.CSS, using = ".wo-prio-arrow")
	private List<WebElement> workOrderPriorArrow;

	// Select measurement from overlay in saved data and measurement in mobile
	@FindBy(how = How.CSS, using = "#userMeasurementsList .measurement-detail ")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/measurement_frame_multi")
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='added date']")
	private List<WebElement> selectMeasurementInWorkOrder;

	// Confirm measurement selection in saved data
	@FindBy(how = How.CSS, using = "a[data-event='click:confirm-add-measurements']")
	private WebElement addMeasurementInSavedData;

	// Ok button on overlay after measurement selection in saved data for web
	// only
	@FindBy(how = How.CSS, using = "#ok_btn")
	private List<WebElement> selectMeasurementOverlayOk;

	// Email and remove measurement options drop down in saved data
	@FindBy(how = How.CSS, using = "div.meas-down-pointer")
	private List<WebElement> woSavedDataItemOptionDropdown;

	// Email measurement options in saved data
	@FindBy(how = How.CSS, using = "a.wo-emailAddr")
	private List<WebElement> woEmailAddress;

	// Remove measurement options in saved data
	@FindBy(how = How.CSS, using = "span.remove-meas-workorder")
	private List<WebElement> removeMeasurementWorkorder;

	// select measurement for sharing wo
	@AndroidFindBy(id = "com.fluke.deviceApp:id/measurement_list")
	@iOSFindBy(accessibility = "added date")
	private List<WebElement> measurementList;

	// next button after measurement selection in share functionality of mobile
	@AndroidFindBy(id = "new UiSelector().textContains(\"NEXT\")")
	@iOSFindBy(accessibility = "Next")
	private WebElement shareMeasurementNextButton;

	// sort on priority basis
	@FindBy(how = How.CSS, using = "div[data-sort-criterion='priority']")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Priority\")")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' AND value=='Priority'")
	private WebElement sortOnPriority;

	// sort on Completion date
	@FindBy(how = How.CSS, using = "div[data-sort-criterion='completiondate']")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Completion Date\")")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' AND value=='Completion Date'")
	private WebElement sortOnCompletionDate;

	// sort on Start date
	@FindBy(how = How.CSS, using = "div[data-sort-criterion='startdate']")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Start Date\")")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' AND value=='Start Date'")
	private WebElement sortOnStartDate;

	// sort on schedule date
	@FindBy(how = How.CSS, using = "div[data-sort-criterion='scheduleddate']")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Scheduled Date\")")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' AND value=='Scheduled Date'")
	private WebElement sortOnScheduleDate;

	// equipment name
	@FindBy(how = How.CSS, using = "div[data-event='click:sort-equipment-cards']")
	private WebElement equipmentNameOnAssetPage;

	// share measurement by selecting assets
	@AndroidFindBy(id = "com.fluke.deviceApp:id/share_check_box")
	@iOSFindBy(xpath = "(//XCUIElementTypeButton[@name='checkbox off'])")
	private List<WebElement> shareCheckBox;

	// filter saved data
	@FindBy(how = How.CSS, using = ".filter-icon")
	private WebElement filterIcon;

	// view saved data filter
	@FindBy(how = How.CSS, using = "li.select-box")
	private WebElement selectBox;

	// filter option in saved data
	@FindBy(how = How.CSS, using = "[data-event='click:filter-measurements']")
	private List<WebElement> filterMeasurements;

	// view asset type
	@FindBy(how = How.CSS, using = "li[data-event='click:change-view']")
	private List<WebElement> changeView;

	// Add test points in saved data for Web(only)
	@FindBy(how = How.CSS, using = ".wo-options-assets-more")
	private WebElement addTestPoint;

	// Edit testpoint in saved data for Web(only)
	@FindBy(how = How.CSS, using = "li[data-event='click:edit-testpoints']")
	private WebElement editTestPoint;

	// selecting test points
	@FindBy(how = How.CSS, using = ".select-title")
	private WebElement selectTestPoint;

	// confirm test point selection in web
	@FindBy(how = How.CSS, using = "[data-event='click:confirm-select-testpoints']")
	private WebElement confirmTestPointSelection;

	// action bar on add measurement for work order mobile and
	@AndroidFindBy(id = "com.fluke.deviceApp:id/action_bar_item_menu_icon")
	@FindBy(how = How.CSS, using = "a#dialog_ok")
	@iOSFindBy(accessibility = "options white")
	private WebElement actionBar;

	// ... dots on user notification // for web no notification
	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(id = "com.fluke.deviceApp:id/action_bar_item_menu_icon")
	@iOSFindBy(xpath = "(//XCUIElementTypeButton[@name='more btn'])")
	private List<WebElement> moreBtn;

	// share measurement in edit mode
	@iOSFindBy(accessibility = "Share")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Share\")")
	private WebElement shareMeasurementInEditWorkOrder;

	// home screen open button
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Open\")")
	@iOSFindBy(accessibility = "Open")
	private WebElement openStatusHomeScreen;

	// home screen in progress button
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"In-progress\")")
	@iOSFindBy(accessibility = "In-Progress")
	private WebElement inProgressStatusHomeScreen;

	// home screen completed button
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Completed\")")
	@iOSFindBy(accessibility = "Completed")
	private WebElement completedStatusHomeScreen;

	// sort and filter icon in mobile
	@AndroidFindBy(id = "com.fluke.deviceApp:id/sortB")
	@FindBy(how = How.CSS, using = "div.wo-list-avail-options div.down-pointer")
	@iOSFindBy(accessibility = "Filter")
	private WebElement sortIcon;

	// back button on sort order
	@HowToUseLocators(androidAutomation = ALL_POSSIBLE, iOSAutomation = ALL_POSSIBLE)
	@iOSFindBy(accessibility = "back white")
	@iOSFindBy(accessibility = "arrow back")
	@iOSFindBy(accessibility = "Home")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/action_bar_item_left")
	@FindBy(how = How.CSS, using = "div[data-sort-criterion='wonumber']")
	private WebElement sortBackButton;

	@iOSFindBy(accessibility = "Delete Measurements")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Delete Measurements\")")
	private WebElement deleteMeasurementInEditWorkOrder;

	@iOSFindBy(accessibility = "Add Measurements")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Add Measurements\")")
	private WebElement addMeasurementInEditWorkOrder;

	// select asset in web
	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@FindBy(how = How.CSS, using = "input.equicheckbox")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/measurement_frame_multi")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeCell' AND name CONTAINS ','")
	private List<WebElement> selectAsset;

	// + icon in web to create asset and add to wo
	@HowToUseLocators(iOSAutomation = ALL_POSSIBLE)
	@FindBy(how = How.CSS, using = "a[data-event='click:assign-asset-to-workorder']")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/action_bar_item_menu_text")
	@iOSFindBy(accessibility = "Add")
	@iOSFindBy(accessibility = "Next")
	@iOSFindBy(accessibility = "Delete")
	private WebElement addAsset;

	// Keyboard done button in iOS at create work order screen
	@iOSFindBy(accessibility = "Keyboard-Done")
	private WebElement KeyboardDone;

	// Keyboard search button in iOS at search workoreder screen
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeButton' AND name='Search'")
	private WebElement searchKey;

	// Add work order from overview screen
	@FindBy(how = How.CSS, using = "[data-event='click:add-work-order']")
	private WebElement addWorkorderOverviewScreen;

	// Mark as read for notification
	@iOSFindBy(accessibility = "Mark As Read")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Mark as read\")")
	@FindBy(how = How.CSS, using = "a[data-event='click:close-done']")
	private WebElement markAsRead;

	@iOSFindBy(accessibility = "Mark As UnRead")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Mark as read\")")
	private WebElement markAsUnRead;

	// Add asset + mark in web
	@FindBy(how = How.CSS, using = "div.asset-header-option-styles.add-asset-header")
	private WebElement addAssetPage;

	// Add Asset name
	@FindBy(how = How.CSS, using = "#equipmentName")
	private WebElement equipmentNameTextField;

	// Asset picker icon
	@FindBy(how = How.CSS, using = "div.equipment-type-picker-options")
	private WebElement equipementPicker;

	// Asset picker icon
	@FindBy(how = How.CSS, using = "li[data-event='click:change-type']")
	private List<WebElement> equipementPickerList;

	@FindBy(how = How.CSS, using = "a[data-event='click:add-equipment-done']")
	private WebElement addEquipmentDone;

	@AndroidFindBy(id = "com.fluke.deviceApp:id/back_button")
	private WebElement backButtonMesurementDetail;

	@FindBy(how = How.CSS, using = ".confirm-cancel-options-image.save")
	private WebElement saveButtonUpdate;
	
	@FindBy(how=How.CSS,using =".search-bar-container")
	private WebElement searchType;

	// Assign workorder in measurement
	@AndroidFindBy(id = "com.fluke.deviceApp:id/wo_name")
	@iOSFindBy(accessibility = "(//XCUIElementTypeStaticText[@name='Description'])[1]")
	@iOSXCUITFindBy(iOSNsPredicate = "[type=='XCUIElementTypeCell' AND name CONTAINS ',']")
	@FindBy(how = How.CSS, using = "#measWorkOrderDetail label#locked")
	private List<WebElement> assignWorkOrderInMeasurement;

	// Assign workorder
	@AndroidFindBy(id = "com.fluke.deviceApp:id/work_orders_row")
	@iOSFindBy(accessibility = "Work Order")
	@FindBy(how = How.CSS, using = "div.work-orders-list-column.work-order-status-color.work-order-status-color-column.open")
	private WebElement assignWorkOrder;

	// WorkOrder Number
	@AndroidFindBy(id = "com.fluke.deviceApp:id/wo_num")
	@iOSFindBy(accessibility = "Estimated Completion Date – Today")
	@FindBy(how = How.CSS, using = "a[data-action='assign']")
	private WebElement workOrderNumber;

	// Add notes on assign workorder for measurement
	@AndroidFindBy(id = "com.fluke.deviceApp:id/add_text_note")
	@iOSFindBy(accessibility = "textNote")
	private WebElement addNotesInMeasurementWorkOrder;

	// Close coach mark
	@AndroidFindBy(id = "com.fluke.deviceApp:id/close")
	private WebElement closeCoachMark;

	@AndroidFindBy(id = "com.fluke.deviceApp:id/workOderInfo")
	private WebElement workOderInfo;

	@AndroidFindBy(id = "com.fluke.deviceApp:id/priority_title")
	@FindBy(how = How.CSS, using = ".filter-status-option-list-container .view-all-option input")
	@iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Priority'])[2]")
	private WebElement priorityFilter;

	@AndroidFindBy(id = "com.fluke.deviceApp:id/status_title")
	@FindBy(how = How.CSS, using = ".filter-type-option-list-container .view-all-option input")
	@iOSFindBy(accessibility = "Status")
	private WebElement statusFilter;

	@AndroidFindBy(id = "com.fluke.deviceApp:id/worktype_title")
	@iOSFindBy(accessibility = "Type")
	private WebElement workTypeFilter;

	@AndroidFindBy(id = "com.fluke.deviceApp:id/filter_check_box")
	@FindBy(how = How.CSS, using = "span.status-option-text")
	private List<WebElement> filterCheckBox;

	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' AND name=='Open'")
	private WebElement filterOpenStatusCheckbox;

	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' AND name=='High'")
	private WebElement filterHighPriorityCheckbox;

	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' AND name=='Unplanned'")
	private WebElement filterUnplannedTypeCheckbox;

	@iOSFindBy(accessibility = "Clear text")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/clear")
	@FindBy(how = How.CSS, using = "img.search-bar-icon")
	private WebElement clearText;

	// @AndroidFindBy(id="com.fluke.deviceApp:id/filter_check_box")
	// private List<WebElement> filterCheckBox;

	// @AndroidFindBy(id="com.fluke.deviceApp:id/filter_check_box")
	@FindBy(how = How.CSS, using = "span.type-option-text")
	// @iOSFindBy(className="checkbox off']")
	private List<WebElement> filterCheckBoxStatus;

	@FindBy(how = How.CSS, using = "div[title='Asset created for WorkOrder Automation']")
	private WebElement assetNameForWorkOrderAutomation;

	@FindBy(how = How.CSS, using = "span.select-title")
	private WebElement testPointSelectionCheckBox;

	@FindBy(how = How.CSS, using = "div.wo-assets-container")
	private WebElement addDataToRequiredAsset;

	@FindBy(how = How.CSS, using = "ul.meas-attributes")
	private WebElement selectAssetInAddData;

	@FindBy(how = How.CSS, using = "a#deleteWorkOrderButton")
	private WebElement deleteWorkOrderButtonFinal;

	@FindBy(how = How.CSS, using = "div[title='wo_automation@yopmail.com']")
	private List<WebElement> woAssignee;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Edit\")")
	@iOSFindBy(accessibility = "Edit")
	private WebElement editScheduleWo;

	// List of workorder created
	@iOSFindBy(accessibility = "Estimated Completion Date – Today")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/priority_icon")
	@FindBy(how = How.CSS, using = "div.work-order-title-display")
	private List<WebElement> listOfWorkOrders;

	// delete notification
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Delete\")")
	@iOSFindBy(accessibility = "Delete")
	private WebElement deleteNotification;

	// notification list
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeCell'")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/item")
	private List<WebElement> notificationList;

	// tick sign when user updates n web edit mode
	@FindBy(how = How.CSS, using = "div.confirm-cancel-options img.confirm-cancel-options-image.save")
	private List<WebElement> updationOkWeb;

	// explicite click on asset name to pass the test cases
	@FindBy(how = How.CSS, using = "[data-sort-criterion='equipmentName']")
	private WebElement equipmentNameSort;

	// Work ordeer title
	@iOSFindBy(accessibility = "Title")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/home_text")
	private WebElement workOrderHomeText;

	// Filter pointer in web
	@FindBy(how = How.CSS, using = "div.options-box-pointer-container")//
	private WebElement filterPointer;

	@FindBy(how = How.CSS, using = "input[data-type='priority']")
	private List<WebElement> priorityFilterInWeb;

	@FindBy(how = How.CSS, using = "input[data-type='status']")
	private List<WebElement> statusFilterInWeb;

	// elements on home screen
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText'")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/count")
	private List<WebElement> elementsOnHomeScreen;

	// pointer in asset to delete/move
	@FindBy(how = How.CSS, using = "div.equipment-item-option-dropdown .down-pointer")
	private WebElement downPointerInAsset;

	// delete asset
	@FindBy(how = How.CSS, using = "li[data-event='click:delete-asset']")
	private WebElement deleteAsset;

	// asset delete confirmation
	@FindBy(how = How.CSS, using = "[data-event='change:confirm-delete-text-change']")
	private WebElement confirmAssetDeletion;

	@FindBy(how = How.CSS, using = "a#deleteEquipmentAssetButton")
	private WebElement deleteEquipmentAssetButton;

	// List of assets
	@FindBy(how = How.CSS, using = "div.equipment-card")
	private List<WebElement> listOfAssets;

	@FindBy(how = How.CSS, using = "span.wo-prio-count")
	private List<WebElement> openWoCount;

	@FindBy(how = How.CSS, using = "span.fluke-icon.fluke-icon-angle-down.wo-prio-down-arrow")
	private List<WebElement> expandArrowOnOverviewWo;

	@FindBy(how = How.CSS, using = "div.no-work-orders-message")
	private List<WebElement> noWoMessage;

	@FindBy(how = How.CSS, using = "li[data-value='add-component']")
	private WebElement addComponentAsset;

	@FindBy(how = How.CSS, using = "input#addComponentAssetName")
	private WebElement addComponentAssetName;

	@FindBy(how = How.CSS, using = "a#equipment-modal-bottom-button")
	private WebElement addComponentAssetNameDone;

	@FindBy(how = How.CSS, using = "input[name='test_point']")
	private WebElement testPointName;

	@FindBy(how = How.CSS, using = "[data-event='click:confirm-select-testpoints']")
	private WebElement testPointNameDone;

	// equipment name
	@FindBy(how = How.CSS, using = "div.equipment-card")
	private WebElement assetName;

	@FindBy(how = How.CSS, using = "a.common-header-link  ")
	private List<WebElement> assetHeaders;

	@FindBy(how = How.CSS, using = "div.context-menu-down-pointer.down-pointer")
	private WebElement addComponentPointer;

	private CaptureMeasurementsPage captureMeasurementsPage;
	private Gestures gesture;
	private MeasurementDetailPage measurementDetailPage;
	private GestureUtils gestureUtils;
	private Switcher switcher;

	public WorkOrderPage() {
		CommonUtils.initElements(this, 10);
		gesture = new Gestures();
		captureMeasurementsPage = new CaptureMeasurementsPage();
		measurementDetailPage = new MeasurementDetailPage();
		gestureUtils = new GestureUtils();
		switcher = new Switcher();
	}

	public void addWorkOrderWithMeasurements(String workOrderTitle, String workOrderDescription) throws Exception {
		addWorkOrder(workOrderTitle, workOrderDescription);
		gesture.iOSScrollDown(workOrderDescription);
		openWorkOrder(workOrderDescription);
		gesture.iOSScrollDown("Actual Hours");
		startWorkOrderButton.click();
		manualMeasurementsButton.click();
		captureMeasurementsPage.clickOnManualMeasureButton();
		captureMeasurementsPage.saveManualMeasurement("9", "V AC");
		measurementDetailPage.captureMeasurementsDetails(Config.WORKORDERS_PROPERTIES_FILE_PATH,
				"Work Order Manual Entry", MeasurementType.SCALAR, 0);
		arrowBackButton.click();
		cancelButton.click();
	}

	public void addWorkOrderWithDefaultPriorityAndType(String workOrderTitle, String workOrderDescription)
			throws Exception {
		moreButton.click();
		addWorkOrderButton.click();
		ElementUtils.sendKeys(workOrderTitleTextField, workOrderTitle);
		ElementUtils.sendKeys(workOrderDescriptionTextField, workOrderDescription);
		gesture.iOSCordinateScroll(0, 300, 0, 0);
		scheduledWorkOrderButton.click();
		checkBoxButton.click();
		doneButton.click();
		saveButton.click();
	}

	public void setWorkOrderPriority(String workOrderPriority) throws Exception {
		priorityCell.click();
		if (workOrderPriority.equals("high") || workOrderPriority.equals("High")) {
			highPriorityButton.click();
		} else if (workOrderPriority.equals("standard") || workOrderPriority.equals("Standard")) {
			standardPriorityButton.click();
		} else if (workOrderPriority.equals("low") || workOrderPriority.equals("Low")) {
			lowPriorityButton.click();
		}
		saveButton.click();
	}

	public void setWorkOrderType(String workOrderType) throws Exception {
		workTypeCell.click();
		if (workOrderType.equals("unplanned") || workOrderType.equals("Unplanned")) {
			unplannedButton.click();
		} else if (workOrderType.equals("unassigned") || workOrderType.equals("Unassigned")) {
			unassignedButton.click();
		} else if (workOrderType.equals("planned") || workOrderType.equals("Planned")) {
			plannedButton.click();
		}
		saveButton.click();
	}

	public void addWorkOrder(String workOrderTitle, String workOrderDescription) throws Exception {
		moreButton.click();
		addWorkOrderButton.click();
		ElementUtils.sendKeys(workOrderTitleTextField, workOrderTitle);
		ElementUtils.sendKeys(workOrderDescriptionTextField, workOrderDescription);
		saveButton.click();
	}

	public void assignAssignee(String userName) throws Exception {
		gesture.iOSScrollDown("SCHEDULED WORK");
		assigneeOptionsButton.click();
		assigneeOptionsEditButton.click();
		CommonUtils.ifDisplayedThenClick(userName);
		doneButton.click();
	}

	public void changeWorkOrderStatusAndAddOptionalTexNote(String statusValue, boolean textNoteFlag, String textNote)
			throws Exception {
		changeStatusCell.click();
		if (statusValue.equals("open") || statusValue.equals("Open")) {
			openStatusButton.click();
		} else if (statusValue.equals("in-progress") || statusValue.equals("In-Progress")) {
			inProgressStatusButton.click();
		} else if (statusValue.equals("completed") || statusValue.equals("Completed")) {
			completedStatusButton.click();
		} else if (statusValue.equals("closed") || statusValue.equals("Closed")) {
			closedStatusButton.click();
		}
		if (textNoteFlag) {
			ElementUtils.sendKeys(textNoteTextArea, textNote);
		}
		saveButton.click();
	}

	public void addVoiceNoteToWorkOrder(int voiceNoteDuration) throws Exception {
		changeStatusCell.click();
		voiceNoteMicrophoneButton.click();
		startStopRecordingButton.click();
		CommonUtils.wait(voiceNoteDuration);
		startStopRecordingButton.click();
		saveButton.click();
	}

	public boolean isWorkOrderStatusChanged(String expectedStatus, String workOrderDescription) throws Exception {
		if (DriverManager.getDriver().getPageSource().contains(expectedStatus)) {
			openWorkOrder(workOrderDescription);
			backBarButton.click();
			return true;
		} else {
			openWorkOrder(workOrderDescription);
			backBarButton.click();
			return false;
		}
	}

	public boolean isWorkOrderPriortyChanged(String expectedPriority) {
		return DriverManager.getDriver().getPageSource().contains(expectedPriority);
	}

	public boolean isWorkOrderTypeChanged(String expectedWorkType) {
		return DriverManager.getDriver().getPageSource().contains(expectedWorkType);
	}

	public boolean isTextNoteAddedToWorkOrder(String expectedTextNote) throws Exception {
		viewActivityStreamNotesButton.click();
		textNoteListFirstTextView.click();
		return textNoteTextView.getText().equals(expectedTextNote);
	}

	public boolean isVoiceNoteAdded(String voiceNoteDuration) throws Exception // voiceNoteDuration
																				// =
																				// mm:ss
	{
		viewActivityStreamNotesButton.click();
		return DriverManager.getDriver().findElement(MobileBy.AccessibilityId(voiceNoteDuration)).isDisplayed();
	}

	public void deleteWorkOrder(String workOrderDescription) throws Exception {
		switcher.switchToWorkOrdersPage();
		CommonUtils.wait(10);
		while (listOfWorkOrders.size() > 0) {

			if ((DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
					|| (DriverManager.getDriverName().equals(Config.IOS_DRIVER))) {
				allWorkOrdersTabButton.click();
			}
			for (int i = 0; i < listOfWorkOrders.size(); i++) {
				IOSUtils.isPageLoaded(30, "Refreshing data...");
				listOfWorkOrders.get(i).click();
				menuToDelOrDuplicateWo.click();
				deleteWorkOrderButton.click();
				deleteWorkOrderAlertDeleteButton.click();
				if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
					CommonUtils.wait(10);
				}

				if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
					deleteWorkOrderAlertDeleteButton.sendKeys("delete");
					deleteWorkOrderButtonFinal.click();
				}

			}
		}
	}

	public void deleteFirstWorkOrder() throws Exception {
		openWorkOrder();
		moreButton.click();
		deleteWorkOrderButton.click();
		deleteWorkOrderAlertDeleteButton.click();
	}

	public boolean isWorkOrderDeleted(String workOrderDescription) {
		ElementUtils.isDisplayed(6, filterButton);
		if (DriverManager.getDriver().getPageSource().contains(workOrderDescription))
			return true;
		else
			return false;

	}

	public void measurementDuplicateWorkOrder(String workOrderIdentifier) throws Exception {
		openWorkOrder(workOrderIdentifier);
		menuToDelOrDuplicateWo.click();
		duplicateWorkOrderButton.click();
		saveButton.click();

	}

	public void measurementDuplicateFirstWorkOrder(String workOrderDescription) throws Exception {
		if ((DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				|| (DriverManager.getDriverName().equals(Config.IOS_DRIVER))) {
			myWorkOrdersTabButton.click();
		}

		openWorkOrder(workOrderDescription);
		if ((DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)))
			{
			menuToDelOrDuplicateWo.click();
			}
		else {
			GestureUtils.moveAndClickElement(menuToDelOrDuplicateWo);
			}
		duplicateWorkOrderButton.click();
		saveButton.click();
		CommonUtils.wait(1,1,3);
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			backBarButton.click();
		}

	}

	public boolean isWorkOrderDuplicated(String workOrderDescription) throws Exception {
		CommonUtils.wait(1,1,3);
		if ((DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				|| (DriverManager.getDriverName().equals(Config.IOS_DRIVER))) {
			allWorkOrdersTabButton.click();
			if ((DriverManager.getDriver().findElements(MobileBy.AccessibilityId(workOrderDescription)).size() > 0)) {
				return true;
			} else
				return false;

		} else if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {

			if (DriverManager.getDriver().findElements(By.cssSelector("div.work-order-title-display")).size() > 0) {
				return true;
			} else
				return false;
		}
		return false;
	}

	public boolean isFirstWorkOrderDuplicated(String workOrderDescription) throws Exception {
		if ((DriverManager.getDriver().getPageSource().contains("This is duplicate work order"))) {
			return true;
		} else
			return false;
	}

	public void searchWorkOrder(String searchText) throws Exception {
		CommonUtils.wait(2);
		workOrderSearchField.click();
		workOrderSearchField.sendKeys(searchText);
		clearText.click();
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			searchKey.click();
		}

	}

	public void openWorkOrder(String workOrderDescription) throws Exception {
		IOSUtils.isPageLoaded(20, "Data...");
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, workOrderDescription,
				LocatorStrategy.IOS_LOCATOR_STRATEGY_XPATH,
				"//XCUIElementTypeStaticText[@name='" + workOrderDescription + "']/parent::XCUIElementTypeCell",
				LocatorStrategy.WEB_LOCATOR_STRATEGY_XPATH_TEXT_CONTAINS, workOrderDescription).click();

	}

	public void openWorkOrder() throws Exception {
		CommonUtils.wait(3);
		ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_CLASS_NAME, "XCUIElementTypeCell",
				null, null).click();
	}

	public String getWorkOrderTitle() {
		return workOrderTitle.getText();
	}

	public String getFirstWorkOrderIdentifier() {
		return firstWorkOrderIdentifier.getText();
	}

	public void clickOnBackBarButton() {
		backBarButton.click();
	}

	public void clickclearTextInSearchField() {
		clearTextInSearchField.click();
	}

	public boolean isWorkOrderVisible() {
		return androidWorkOrderTitle.isDisplayed();
	}

	public void clickOnFilterButton() {
		filterButton.click();
	}

	public void clickOnCancelButton() {
		cancelButton.click();
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}

	private void setPriorityInAddWorkOrder() throws Exception {
		if ((DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				|| (DriverManager.getDriverName().equals(Config.IOS_DRIVER))) {
			priorityCell.click();
			highPriorityButton.click();
		}

		else {
			priorityCell.click();
			// priorityWorkTypeCellForWeb.get(0));
			priorityCellForWeb.get(0).click();
			;
		}

		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			saveButton.click();
		}
	}

	private void setWorktypeInAddWorkOrder() throws Exception {

		if ((DriverManager.getDriverName().equals(Config.IOS_DRIVER)
				|| DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)))

		{
			workTypeCell.click();
			unassignedButton.click();
		}

		else if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			gestureUtils.scroll(500, 1);
			workTypeCell.click();
			// priorityWorkTypeCellForWeb.get(1));
			workTypeCellForWeb.get(0).click();
		}

		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			saveButton.click();
		}
	}

	public void scheduleWorkOrder() throws Exception {

		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			scheduledDatePicker.click();
			okButton.get(0).click();
			workOrderAssigneeOptions.click();
			assigneeButton.click();
		} else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			scheduledDatePicker.click();
			selectDatePicker.click();
			ElementUtils.safeClick(workOrderAssigneeOptions);
			doneButton.click();
		} else if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			ElementUtils.sendKeys(workOrderAssigneeOptions,
					DriverManager.getUserName() + " " + "(" + DriverManager.getUserName() + ")");
			addAssigneeBtn.click();
			CommonUtils.wait(5);
			assigneeButton.click();
			CommonUtils.wait(5);
		}
	}

	public void verifyOpenWorkOrderInWeb() throws Exception {
		verifyWorkOrderOverview(openStatusButton);
	}

	public void verifyInProgressWorkOrderInWeb() throws Exception {
		verifyWorkOrderOverview(inProgressStatusButton);

	}

	public void verifyCompletedWorkOrderInWeb() throws Exception {
		verifyWorkOrderOverview(completedStatusButton);
	}

	public void verifyClosedWorkOrderInWeb() throws Exception {
		verifyWorkOrderOverview(closedStatusButton);
	}

	private void addTextNote(String textNote) throws Exception {
		addNotes.click();
		ElementUtils.sendKeys(addNotes, textNote);
		addNotesButton.click();

	}

	public void verifyWorkOrderOverview(WebElement statusElement) throws Exception {

		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			CommonUtils.wait(5);
			String textNote = "Added text note " + "in " + DriverManager.getDriverName() + " at "
					+ DateAndTimeUtils.getCurrentTimeStamp();
			workOrderOverview.click();
			statusElement.click();
			if (listWorkOrdersOverview.size() > 0) {
				listWorkOrdersOverview.get(0).click();
				addTextNote(textNote);
			}
			backBarButton.click();
		}
	}

	public void verifyUserNotification(String workOrderDescription) throws Exception {

		switcher.switchToHomePage();
		CommonUtils.wait(5);
		userNotification.click();
		moreBtn.get(1).click();
		markAsRead.click();
		sortBackButton.click();
		switcher.switchToWorkOrdersPage();
	}

	public boolean isNotificationDisplayed(String workOrderDescription) throws Exception {
		switcher.switchToHomePage();
		userNotification.click();
		if (DriverManager.getDriver().getPageSource().contains(getFirstWorkOrderIdentifier())) {
			sortBackButton.click();
			switcher.switchToWorkOrdersPage();
			return true;
		} else
			sortBackButton.click();
		switcher.switchToWorkOrdersPage();
		return false;
	}

	public void verifySavedData(String workOrderDescription) throws Exception {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			switcher.switchToWorkOrdersPage();
			addCreatedAssetsToWorkOrderSavedData(workOrderDescription);
			openWorkOrder(workOrderDescription);
			savedDataLink.click();
			addDataButtonInSavedData.click();
			workOrderPriorArrow.get(0).click();
			CommonUtils.wait(5);
			if (selectMeasurementInWorkOrder.size() > 0) {
				for (int i = 0; i < selectMeasurementInWorkOrder.size(); i++) {
					selectMeasurementInWorkOrder.get(i).click();
					for (; i < selectMeasurementOverlayOk.size();) {
						selectMeasurementOverlayOk.get(i).click();
					}
					CommonUtils.wait(3);
				}
			}
			addMeasurementInSavedData.click();
			CommonUtils.wait(3);
			savedDataLink.click();
		}
	}

	public void addDataToSavedData(String workOrderDescription) throws Exception {
		openWorkOrder(workOrderDescription);
		gestureUtils.webScroll(startWorkOrderButton);
		addCreatedAssetsToWorkOrderSavedData(workOrderDescription);
		addTestPoint.click();
		editTestPoint.click();
		selectTestPoint.click();
		confirmTestPointSelection.click();
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, workOrderDescription,
				LocatorStrategy.IOS_LOCATOR_STRATEGY_XPATH,
				"//XCUIElementTypeStaticText[@name='" + workOrderDescription + "']/parent::XCUIElementTypeCell", null,
				null).click();
	}

	public void addCreatedAssetsToWorkOrderSavedData(String workOrderDescription) throws Exception {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			openWorkOrder(workOrderDescription);
			gestureUtils.webScroll(ScrollDiection.DOWN, 4);
			startWorkOrderButton.click();
			actionBar.click();
			CommonUtils.wait(5);
			equipmentNameOnAssetPage.click();
			selectAsset.get(0).click();
			addAsset.click();
			backBarButton.click();
		}

	}

	public void updateWorkOrder(String workOrderDescription) throws Exception {
		switcher.switchToWorkOrdersPage();
		openWorkOrder(workOrderDescription);
		// CommonUtils.wait(3);
		workOrderDescriptionTextField.clear();
		ElementUtils.sendKeys(workOrderDescriptionTextField, " Work order has been updated in  "
				+ DriverManager.getDriverName() + " at " + DateAndTimeUtils.getCurrentTimeStamp());
		if ((DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))) {
			backBarButton.click();
		} else if ((DriverManager.getDriverName().equals(Config.IOS_DRIVER))) {
			saveButton.click();
		} else if ((DriverManager.getDriverName().equals(Config.WEB_DRIVER))) {
			updationOkWeb.get(1).click();
		}
	}

	public boolean isWorkOrderUpdated(String workOrderDescription) throws Exception {
		openWorkOrder(workOrderDescription);
		if (workOrderDescription.contains("updated")) {
			backBarButton.click();
			return true;
		} else {
			backBarButton.click();
			return false;
		}

	}

	public void verifyOpenWorkOrderOnHomeScreen(String workOrderDescription) throws Exception {
		if ((DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				|| (DriverManager.getDriverName().equals(Config.IOS_DRIVER))) {
			switcher.switchToHomePage();
			openStatusHomeScreen.click();
			allWorkOrdersTabButton.click();
			CommonUtils.wait(5);

		}

	}

	public void verifyInProgressWorkOrderOnHomeScreen(String workOrderDescription) throws Exception {
		if ((DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				|| (DriverManager.getDriverName().equals(Config.IOS_DRIVER))) {
			switcher.switchToHomePage();
			inProgressStatusHomeScreen.click();

		}
	}

	public void verifyCompletedWorkOrderOnHomeScreen(String workOrderDescription) throws Exception {
		if ((DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				|| (DriverManager.getDriverName().equals(Config.IOS_DRIVER))) {
			switcher.switchToHomePage();
			completedStatusHomeScreen.click();

		}

	}

	public void verifySavedDataEmailFunction(String workOrderDescription) throws Exception {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			verifySavedData(workOrderDescription);
			woSavedDataItemOptionDropdown.get(0).click();
			woEmailAddress.get(0).click();
		}
	}

	public void verifySavedDataRemoveFunction(String workOrderDescription) throws Exception {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			verifySavedData(workOrderDescription);
			woSavedDataItemOptionDropdown.get(0).click();
			removeMeasurementWorkorder.get(0).click();
		}
	}

	public void shareMeasurementInWorkOrder(String workOrderDescription) throws Exception {
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			measurementMenuWhenMeasurementIsPresent(workOrderDescription);
			shareMeasurementInEditWorkOrder.click();
			selectAsset.get(0).click();
			addAsset.click();
			measurementDetailPage.shareMeasurement("qa.samsungs6@gmail.com", DataType.MEASUREMENT_DATA,
					ShareFormat.TEXT, true);
			sortBackButton.click();
			backBarButton.click();
		}
		/*
		 * commenting the test case as the test case is running on simulator
		 * else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
		 * MeasurementMenuWhenMeasurementIsPresent(workOrderDescription);
		 * 
		 * shareMeasurementInEditWorkOrder); ElementUtils.getElement(null, null,
		 * LocatorStrategy.IOS_LOCATOR_STRATEGY_PREDICATE_STRING,
		 * "type=='XCUIElementTypeStaticText' AND name =='Description'", null,
		 * null).click(); addAsset);
		 * measurementDetailPage.shareMeasurement("qa.samsungs6@gmail.com",
		 * DataType.MEASUREMENT_DATA, ShareFormat.TEXT,true); sortBackButton);
		 * backBarButton); }
		 */
	}

	public void measurementOperationsOnWorkOrder(String operationsOnWorkOrder) throws Exception {
		switch (operationsOnWorkOrder) {
		case "Share": {
			if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
				shareMeasurementInEditWorkOrder.click();
				selectAsset.get(0).click();
				addAsset.click();
				measurementDetailPage.shareMeasurement("qa.samsungs6@gmail.com", DataType.MEASUREMENT_DATA,
						ShareFormat.TEXT, true);
				sortBackButton.click();
				backBarButton.click();
			}
		}
			break;
		case "Add": {
			addMeasurementInEditWorkOrder.click();
			CommonUtils.wait(2);
			selectAsset.get(0).click();
			CommonUtils.wait(2);

			if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
				CommonUtils.wait(5);

				addAsset.click();

				addConfirmation.get(1).click();
				CommonUtils.wait(5);
				sortBackButton.click();
				backBarButton.click();
			} else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
				addAsset.click();
				deleteWorkOrderAlertDeleteButton.click();
				sortBackButton.click();
				backBarButton.click();
			}

		}
			break;
		case "Delete": {
			deleteMeasurementInEditWorkOrder.click();
			selectAsset.get(0).click();
			addAsset.click();

			if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
				CommonUtils.wait(4);
				deleteConfirmation.get(1).click();
				CommonUtils.wait(4);
				ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_PREDICATE_STRING,
						"type=='XCUIElementTypeButton' AND name CONTAINS 'Work Order'", null, null).click();
				cancelButton.click();
			}
			if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
				CommonUtils.wait(4);
				deleteWorkOrderAlertDeleteButton.click();
				CommonUtils.wait(4);
				sortBackButton.click();
				backBarButton.click();

			}
		}
			break;
		case "View": {
			selectAsset.get(0).click();
			selectAsset.get(0).click();
			if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
				ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_PREDICATE_STRING,
						"type=='XCUIElementTypeButton' AND name CONTAINS 'Work Order'", null, null).click();
				sortBackButton.click();
				backBarButton.click();
			}
			if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
				backButtonMesurementDetail.click();
				sortBackButton.click();
				backBarButton.click();
			}
			break;
		}
		}

	}

	public void measurementMenuWhenMeasurementIsPresent(String workOrderDescription) throws Exception {
		openWorkOrder(workOrderDescription);
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			gestureUtils.mScroll("Actual Hours", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS,
					LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
		else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			gestureUtils.mobileScroll(-1000, 3);
		}
		startWorkOrderButton.click();
		actionBar.click();
	}

	public void addManualMeasurement(String workOrderDescription) throws Exception {
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)
				|| DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			openWorkOrder(workOrderDescription);
			if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				gestureUtils.mScroll("Actual Hours", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS,
						LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
			else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
				gestureUtils.mobileScroll(-1000, 3);
			}
			startWorkOrderButton.click();
			manualMeasurementsButton.click();
			captureMeasurementsPage.saveManualMeasurement("9", "V AC");
		}
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			doneList.get(0).click();
		}
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)
				|| DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			sortBackButton.click();
			cancelButton.click();
		}

	}

	public void shareManualMeasurementToWo(String workOrderDescription) throws Exception {
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)
				|| DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			{
				actionBar.click();
				shareMeasurementInEditWorkOrder.click();
				selectAsset.get(0).click();
				addAsset.click();
				measurementDetailPage.shareMeasurement("qa.samsungs6@gmail.com", DataType.MEASUREMENT_DATA,
						ShareFormat.TEXT, true);
				sortBackButton.click();
				backBarButton.click();
			}
		}
	}

	public void addMeasurementToWorkOrder(String workOrderDescription) throws Exception {
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)
				|| DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			measurementMenuWhenMeasurementIsPresent(workOrderDescription);
			addMeasurementInEditWorkOrder.click();
		}
		selectAsset.get(0).click();
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)
				|| DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			addAsset.click();
			deleteWorkOrderAlertDeleteButton.click();

			if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)
					|| DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
				sortBackButton.click();
				backBarButton.click();
			}
		}
	}

	public void viewMeasurementDetail(String workOrderDescription) throws Exception {
		addMeasurementToWorkOrder(workOrderDescription);
		measurementList.get(0).click();
		backButtonMesurementDetail.click();
		sortBackButton.click();
		backBarButton.click();

	}

	public void deleteMeasurementFromWorkOrder(String workOrderDescription) throws Exception {
		{
			if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)
					|| DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
				measurementMenuWhenMeasurementIsPresent(workOrderDescription);
				deleteMeasurementInEditWorkOrder.click();
				if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
					ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_PREDICATE_STRING,
							"type == 'XCUIElementTypeCell' AND name CONTAINS ','", null, null).click();

				} else {
					selectAsset.get(0).click();
				}
				addAsset.click();
				deleteWorkOrderAlertDeleteButton.click();

				if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
					ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_PREDICATE_STRING,
							"type=='XCUIElementTypeButton' AND name CONTAINS 'Work Order'", null, null).click();
					cancelButton.click();
				}
				if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
					sortBackButton.click();
					backBarButton.click();
				}
			}
		}
	}

	public void filterSavedData(String workOrderDescription) throws Exception {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			addCreatedAssetsToWorkOrderSavedData(workOrderDescription);
			savedDataLink.click();
			filterIcon.click();
			for (int i = 0; i < filterMeasurements.size(); i++) {
				filterMeasurements.get(i).click();
			}
		}
	}

	public void viewSavedData(String workOrderDescription) throws Exception {
		addCreatedAssetsToWorkOrderSavedData(workOrderDescription);
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			savedDataLink.click();
			selectBox.click();
			for (int i = 0; i < changeView.size(); i++) {
				changeView.get(i).click();
			}
		}
	}

	public void sortWorkOrder() throws Exception {
		if ((DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				|| (DriverManager.getDriverName().equals(Config.IOS_DRIVER))) {
			// allWorkOrdersTabButton);
			sortIcon.click();
		}
		sortOnScheduleDate.click();
		sortOnStartDate.click();
		sortOnCompletionDate.click();
		sortOnPriority.click();
		sortBackButton.click();
	}

	public void viewActivityStreamAndNotes(String workOrderDescription) throws Exception {
		if ((DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				|| (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))) {
			openWorkOrder(workOrderDescription);
			viewActivityStreamNotesButton.click();
			menuToDelOrDuplicateWo.click();
			addNotesButton.click();
			addNotes.click();
			addNotes.sendKeys("Notes added in " + DriverManager.getDriverName() + " at "
					+ DateAndTimeUtils.getCurrentTimeStamp());
		}

		if (DriverManager.getDriverName().equals((Config.IOS_DRIVER))) {
			KeyboardDone.click();
			// saveWorkOrderByCordinate();
			saveButton.click();
			backBarButton.click();
			cancelButton.click();
		} else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			addAsset.click();
			backBarButton.click();
			backBarButton.click();

		}

	}

	public void createWorkOrderFromOverviewPage(String workOrderTitle, String measurementsWorkOrderDescription)
			throws Exception {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			CommonUtils.wait(3);
			workOrderOverview.click();
			CommonUtils.wait(2);
			addWorkorderOverviewScreen.click();
			ElementUtils.sendKeys(workOrderTitleTextField, workOrderTitle);
			ElementUtils.sendKeys(workOrderDescriptionTextField, measurementsWorkOrderDescription);
			saveButton.click();
			CommonUtils.wait(4);
		}
	}

	public void createAssetInWorkOrder(String workOrderDescription) throws Exception {
		if ((DriverManager.getDriverName().equals(Config.WEB_DRIVER))) {
			switcher.switchToWorkOrdersPage();
			openWorkOrder(workOrderDescription);
			startWorkOrderButton.click();
			CommonUtils.wait(8);
			actionBar.click();
			CommonUtils.wait(5);
			addAssetPage.click();
			equipmentNameTextField.sendKeys("Asset created at" + DateAndTimeUtils.getCurrentTimeStamp());
			GestureUtils.moveAndClickElement(equipementPicker);
			equipementPickerList.get(0).click();
			addEquipmentDone.click();
			CommonUtils.wait(4);
		}
	}

	public void addWorkOrderToMeasurement() throws Exception {
		switcher.switchToMeasurementsPage();
		CommonUtils.wait(4);
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			ElementUtils.getElement(null, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_PREDICATE_STRING,
					"type == 'XCUIElementTypeCell' AND name CONTAINS ','", null, null).click();
		} else {
			assignWorkOrderInMeasurement.get(0).click();
		}
		CommonUtils.wait(2);
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			closeCoachMark.click();
		}
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			actionBar.click();
		}
		CommonUtils.wait(2);
		addNotesInMeasurementWorkOrder.click();
		addNotesInMeasurementWorkOrder.sendKeys("Added work order to measurement at "
				+ DateAndTimeUtils.getCurrentTimeStamp() + " in " + DriverManager.getDriverName());
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			AndroidUtils.pressDoneButtonOnNativeKeyBoard("SM-G920I", "AlphaNumeric");
		}
		CommonUtils.wait(4);
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			KeyboardDone.click();
		}
		CommonUtils.wait(4);
		assignWorkOrder.click();
		workOrderNumber.click();
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			backButtonMesurementDetail.click();
		} else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			saveButton.click();
		}
		switcher.switchToWorkOrdersPage();
	}

	public void filterWorkOrderByPriority() throws Exception {

		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			CommonUtils.wait(2);
			GestureUtils.moveAndClickElement(filterPointer);
			for (int i = 0; i < priorityFilterInWeb.size(); i++) {
				priorityFilterInWeb.get(i).click();
			}
			GestureUtils.moveAndClickElement(priorityFilter);
			searchType.click();
		} else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			sortIcon.click();
			priorityFilter.click();
			for (int i = 1; i < filterCheckBox.size(); i++) {
				filterCheckBox.get(i).click();
			}
		} else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			sortIcon.click();
			priorityFilter.click();
			filterHighPriorityCheckbox.click();
		}
		sortBackButton.click();
		sortBackButton.click();
	}

	public void filterWorkOrderByStatus() throws Exception {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			GestureUtils.moveAndClickElement(filterPointer);
			for (int i = 0; i < statusFilterInWeb.size(); i++) {
				statusFilterInWeb.get(i).click();
			}
			GestureUtils.moveAndClickElement(statusFilter);
			GestureUtils.moveAndClickElement(searchType);
		} else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			sortIcon.click();
			statusFilter.click();
			for (int i = 1; i < filterCheckBox.size(); i++) {
				filterCheckBox.get(i).click();
			}
		} else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			sortIcon.click();
			statusFilter.click();
			filterOpenStatusCheckbox.click();
		}
		sortBackButton.click();
		sortBackButton.click();
	}

	public void filterWorkOrderByWorkType() throws Exception {
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			sortIcon.click();
			workTypeFilter.click();
			for (int i = 1; i < filterCheckBox.size(); i++) {
				filterCheckBox.get(i).click();
			}
		} else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			sortIcon.click();
			workTypeFilter.click();
			filterUnplannedTypeCheckbox.click();
		}
		sortBackButton.click();
		sortBackButton.click();
	}

	public void addWorkOrderWithAssignAssignee(String workOrderDescription) throws Exception {
		openWorkOrder(workOrderDescription);
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			gestureUtils.mScroll("Estimated Hours", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS,
					LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
			estimateDatePicker.click();
			okButton.get(0).click();
			ElementUtils.sendKeys(workOrderEstimatedHours, "10");
			backBarButton.click();
		} else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			gestureUtils.mScroll("Estimated Completion Date", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS,
					LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
			estimateDatePicker.click();
			selectDatePicker.click();
			ElementUtils.sendKeys(workOrderEstimatedHours, "10");
			KeyboardDone.click();
			saveButton.click();
			// saveWorkOrderByCordinate();
		} else if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			gesture.webBrowserScrollDown(800);
			CommonUtils.wait(10);
			ElementUtils.sendKeys(workOrderEstimatedHours, "10");
			CommonUtils.wait(10);
			updationOkWeb.get(2).click();
			CommonUtils.wait(10);
			gesture.webBrowserScrollUp(800);
			backBarButton.click();

		}

	}

	public void addWorkOrderAll(String workOrderTitle, String workOrderDescription) throws Exception {
		if ((DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				|| (DriverManager.getDriverName().equals(Config.IOS_DRIVER))) {
			moreButton.click();
		}

		addWorkOrderButton.click();
		ElementUtils.sendKeys(workOrderTitleTextField, workOrderTitle);
		ElementUtils.sendKeys(workOrderDescriptionTextField, workOrderDescription);
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			KeyboardDone.click();
			saveWorkOrderByCordinate();
			// saveButton);
		}

		else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			AndroidUtils.back();
			saveButton.click();
		} else if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			saveButton.click();
		}

	}

	public void addWorkOrderWithSetWorkType(String workOrderDescription) throws Exception {
		openWorkOrder(workOrderDescription);
		setWorktypeInAddWorkOrder();
		if ((DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				|| (DriverManager.getDriverName().equals(Config.WEB_DRIVER))) {
			backBarButton.click();
		} else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			saveButton.click();
			// saveWorkOrderByCordinate();
		}
	}

	public void addWorkOrderWithSetPriority(String workOrderDescription) throws Exception {
		openWorkOrder(workOrderDescription);
		setPriorityInAddWorkOrder();
		if ((DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				|| (DriverManager.getDriverName().equals(Config.WEB_DRIVER))) {
			backBarButton.click();
		} else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			saveButton.click();
			// saveWorkOrderByCordinate();
		}

	}

	public void addWorkOrderAndScheduleWo(String workOrderDescription) throws Exception {
		openWorkOrder(workOrderDescription);
		if ((DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				|| (DriverManager.getDriverName().equals(Config.IOS_DRIVER))) {
			gestureUtils.mScroll("Assignee", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS,
					LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);

			assigneeOptionsButton.click();
			editScheduleWo.click();
		} else if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			gestureUtils.scroll(1000, 1);
			scheduleWorkOrderButton.click();
		}
		scheduleWorkOrder();
		if ((DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				|| (DriverManager.getDriverName().equals(Config.WEB_DRIVER))) {
			backBarButton.click();
		} else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			saveButton.click();
			// saveWorkOrderByCordinate();
		}
	}

	public boolean isManualMeasurementAdded(String workOrderDescription) throws Exception {
		if ((DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				|| (DriverManager.getDriverName().equals(Config.IOS_DRIVER))) {
			openWorkOrder(workOrderDescription);
			if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				gestureUtils.mScroll("Actual Hours", LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS,
						LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
			else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
				gestureUtils.mobileScroll(-1000, 3);
			}
			startWorkOrderButton.click();
			if (selectAsset.size() > 0) {
				sortBackButton.click();
				backBarButton.click();
				return true;
			} else {
				sortBackButton.click();
				backBarButton.click();
				return false;
			}
		}

		return true;

	}

	public void deleteNotification() throws Exception {
		switcher.switchToHomePage();
		userNotification.click();
		actionBar.click();
		deleteNotification.click();
		CommonUtils.wait(5);
		notificationList.get(0).click();
		;
		deleteNotification.click();
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			deleteWorkOrderAlertDeleteButton.click();
		} else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			deleteConfirmation.get(1).click();
			;
		}
		sortBackButton.click();
		switcher.switchToWorkOrdersPage();

	}

	public boolean isAllWorkOrderDeleted(String workOrderDescription) {
		if (listOfWorkOrders.size() == 0)
			return true;
		else
			return false;
	}

	public boolean isAssignedWorkOrder() throws Exception {

		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			CommonUtils.wait(5);
			switcher.switchToHomePage();
			CommonUtils.wait(5);
			Float openWo = Parse(elementsOnHomeScreen.get(1));
			Float inprogressWo = Parse(elementsOnHomeScreen.get(3));
			Float closedWo = Parse(elementsOnHomeScreen.get(5));
			Float allMyWo = openWo + inprogressWo + closedWo;
			switcher.switchToWorkOrdersPage();
			myWorkOrdersTabButton.click();
			int listOfWo = listOfWorkOrders.size();
			if (allMyWo == listOfWo) {
				return true;
			} else {
				return false;
			}
		} else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			CommonUtils.wait(5);
			switcher.switchToHomePage();
			CommonUtils.wait(5);
			Float openWo = Parse(elementsOnHomeScreen.get(0));
			Float inprogressWo = Parse(elementsOnHomeScreen.get(1));
			Float closedWo = Parse(elementsOnHomeScreen.get(2));
			Float allMyWo = openWo + inprogressWo + closedWo;
			switcher.switchToWorkOrdersPage();
			myWorkOrdersTabButton.click();
			int listOfWo = listOfWorkOrders.size();
			if (allMyWo == listOfWo) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	static Float Parse(WebElement element) {
		return Float.parseFloat(element.getText());
	}

	static Float ParseList(List<WebElement> element1) {
		return null;
	}

	public void deleteAssetInWorkOrder(String workOrderDescription) throws Exception {
		switcher.switchToAssetsPage();
		downPointerInAsset.click();
		;
		deleteAsset.click();
		;
		confirmAssetDeletion.click();
		;
		CommonUtils.wait(3);
		confirmAssetDeletion.sendKeys("delete");
		deleteEquipmentAssetButton.click();
		;

	}

	public boolean isDeleteAssetInWorkOrder(String measurementsWorkOrderDescription) {
		if (listOfAssets.size()== 0) {
			return true;
		}
		return false;

	}

	public boolean isWorkOrderCount(int woStatus) {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			workOrderList.click();
			CommonUtils.wait(2);
			workOrderOverview.click();
			CommonUtils.wait(2);
			Float woCount = null;
			woCount = Parse(openWoCount.get(woStatus));
			if (expandArrowOnOverviewWo.get(woStatus).isDisplayed()) {
				expandArrowOnOverviewWo.get(woStatus).click();
				CommonUtils.wait(1,1,2);
			}
			if (woCount > 0) {
				int listOfWo = listWorkOrdersOverview.size();
				if (woCount == listOfWo) {
					return true;
				} else {
					return false;
				}
			} else if (woCount == 0) {
				if (noWoMessage.get(0).isDisplayed())
					return true;
				else
					return false;
			}

		}
		return false;
	}

	public void createTestPointInAsset() throws Exception {
		switcher.switchToAssetsPage();
		CommonUtils.wait(1,1,4);
		assetName.click();
		assetHeaders.get(0).click();
		addComponentPointer.click();
		addComponentAsset.click();
		addComponentAssetName.sendKeys("Asset TestPoint");
		addComponentAssetNameDone.click();

	}

	public void addCreatedTestPointToWorkOrderSavedData(String measurementsWorkOrderDescription) throws Exception {
		switcher.switchToWorkOrdersPage();
		openWorkOrder(measurementsWorkOrderDescription);
		gestureUtils.scroll(1500, 1);
		startWorkOrderButton.click();
		CommonUtils.wait(5);
		actionBar.click();
		CommonUtils.wait(8);
		assetName.click();
		CommonUtils.wait(4);
		testPointName.click();
		CommonUtils.wait(4);
		testPointNameDone.click();
		CommonUtils.wait(3);
		addAsset.click();
		CommonUtils.wait(3);
	}

	public void saveWorkOrderMain() {
		saveButton.click();
	}

	public void saveWorkOrderByCordinate() {
		int[] tapCordinates = GestureUtils.getTapCordinates(GestureUtils.ObjectName.WORKORDER_SAVE_BUTTON);
		gestureUtils.clickOnCordinates(tapCordinates[0], tapCordinates[1]);
	}

	public boolean isSetWorkTypeTest(String workOrderDescription) throws Exception {
		openWorkOrder(workOrderDescription);
		if (workTypeCell.getText().equalsIgnoreCase("unassigned")) {
			backBarButton.click();
			return true;

		} else {
			backBarButton.click();
			return false;
		}
	}

	public boolean isSetPriorityTest(String workOrderDescription) throws Exception {
		openWorkOrder(workOrderDescription);
		if (priorityCell.getText().equalsIgnoreCase("high")) {
			backBarButton.click();
			return true;
		} else {
			backBarButton.click();
			return false;
		}
	}

	public boolean isScheduleWoTest(String workOrderDescription) throws Exception {
		openWorkOrder(workOrderDescription);
		if (workOrderAssigneeOptions.getText().equalsIgnoreCase("wo_automation@yopmail.com")) {
			backBarButton.click();
			return true;
		} else {
			backBarButton.click();
			return false;
		}

	}

	public void clickOnThreeDot() {
		moreButton.click();
	}

	public void addWorkOrderButton() {
		addWorkOrderButton.click();

	}

	public void iOSKeyboardDone() {
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			KeyboardDone.click();
	}

	public void enterWorkOrderDetails(String workOrderTitle, String workOrderDescription) {
		ElementUtils.sendKeys(workOrderTitleTextField, workOrderTitle);
		ElementUtils.sendKeys(workOrderDescriptionTextField, workOrderDescription);
		iOSKeyboardDone();
	}

	public void clickOnPriorityCell() {
		priorityCell.click();

	}

	public void selectHighPriority() {
		highPriorityButton.click();

	}

	public void clickOnWorkTypeCell() {
		workTypeCell.click();
	}

	public void selectUnassigned() {
		unassignedButton.click();
	}

	public void enterDate() {
		estimateDatePicker.click();
		selectDatePicker.click();
	}

	public void enterEstimatedHours() {
		ElementUtils.sendKeys(workOrderEstimatedHours, "10");
	}

	public void scrollToText(String textToScrollUpto) {
		gestureUtils.mScroll(textToScrollUpto, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS,
				LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
	}

	public void clickOnThreeDotScheduleWO() {
		assigneeOptionsButton.click();
	}

	public void clickOnEditScheduleButton() {
		editScheduleWo.click();
	}

	public void selectScheduleDate() {
		scheduledDatePicker.click();
		selectDatePicker.click();
	}

	public void checkAssignee() {
		ElementUtils.safeClick(workOrderAssigneeOptions);
	}

	public void clickOnDoneSchedule() {
		doneButton.click();
	}

}
