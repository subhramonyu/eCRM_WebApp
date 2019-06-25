package com.fluke.connect.app.functional.client.pages;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.fluke.connect.app.functional.client.pages.FC1555CaptureMeasurementPage.CaptureEeveeMeasurementsPageObject;
import com.fluke.connect.app.testdata.FCCM174X;
import com.fluke.connect.app.testdata.FCM1555;
import com.fluke.connect.app.utils.AndroidUtils;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DeviceUtils;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.Config.LocatorStrategy;
import com.fluke.connect.app.utils.Config.ScrollDiection;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class FCCM174XSessionConfigObjectRepo 

{

	private Switcher switcher;
	private SignInPage signInPage;
	private HomePage homePage;
	private DeviceUtils phoneSettingsPage;
	//private FCCM174XSessionConfigObjectRepo fCCM174XSessionConfigObjectRepo;
	private ServiceHatchPage serviceHatchPage;
	private GestureUtils gestureUtils;
	private String testFailureState;
	private boolean testFailureFlag = false;
	private int max_Bit_Length = 50;
	private int radix = 32;
	
	
	
	@AndroidFindBy(id = "blondel_toggle")
	public WebElement blondelServiceHatchButton;
	
	
	@AndroidFindBy(id = "setup_logging_monitoring_text")
	@iOSFindBy(accessibility="Set Up Logging Or Monitoring")
	public WebElement setupLoggingOrMonitoringLink;
	
	@AndroidFindBy(id = "three_phase_image")
	@iOSFindBy(accessibility="Power & Energy Monitors/Loggers")
	private WebElement threePhasePowerMonitorLink;
	
	@AndroidFindBy(uiAutomator="new UiSelector().textContains(\"Power Quality Logger\")")
	@iOSFindBy(accessibility="Power Quality Logger")
	private WebElement powerQualityLoggerText;
	
	//@AndroidFindBy(id = "action_bar_item_left")
	@AndroidFindBy(className = "android.widget.ImageButton")
	@iOSFindBy(accessibility="Back")
	private WebElement BackButtonOnApp;
	
	@AndroidFindBy(id = "action_bar_item_left")
	private WebElement normalbackButton;
	
	@AndroidFindBy(id = "open_settings")
	//@iOSFindBy(accessibility="CONTINUE")
	private WebElement openPhoneSettings;
	
	@AndroidFindBy(id = "action_bar_title")
	@iOSFindBy(xpath="//XCUIElementTypeNavigationBar[@name=\"Monitor Authentication\"]")
	private WebElement monitorAuthenticationText;
	
	@AndroidFindBy(uiAutomator="new UiSelector().textContains(\"Monitor Name :\")")
	private WebElement monitorNameInMonitorAuthenticationPageLabel;
	
	@AndroidFindBy(uiAutomator="new UiSelector().textContains(\"Serial Number :\")")
	private WebElement serialNumberInMonitorAuthenticationPageLabel;
	
	@AndroidFindBy(uiAutomator="new UiSelector().textContains(\"Firmware Version :\")")
	private WebElement firmwareVersionInMonitorAuthenticationPageLabel;
	
	@AndroidFindBy(id = "enter_logger_name")
	@iOSFindBy(xpath="//XCUIElementTypeTextField")
	private WebElement userNameInMonitorAuthenticationPageText;
	
	@AndroidFindBy(id = "enter_logger_pwd")
	@iOSFindBy(xpath="//XCUIElementTypeSecureTextField")
	private WebElement passwordInMonitorAuthenticationPageText;
	
	@iOSFindBy(accessibility="Return")
	private WebElement returnKeypadButton;
	
	@AndroidFindBy(uiAutomator="new UiSelector().textContains(\"Remember User Name & Password\")")
	private WebElement rememberUserInMonitorAuthenticationPageCheckbox;
	
	@AndroidFindBy(id = "generate_config2")
	@iOSFindBy(accessibility="CONTINUE")
	private WebElement continueInMonitorAuthenticationPageText;
	
	@AndroidFindBy(id = "action_bar_title")
	@iOSFindBy(xpath="//XCUIElementTypeNavigationBar[@name=\"Session Setup\"]")
	private WebElement sessionSetupText;
	
	@AndroidFindBy(id = "settings")
	@iOSFindBy(accessibility="gear")
	private WebElement instrumentSettingsLink;
	
	@AndroidFindBy(uiAutomator="new UiSelector().textContains(\"Logger Name: \")")
	private WebElement loggerNameInSessionSetupPageLabel;
	
	@AndroidFindBy(id = "date_synchronization")
	private WebElement RTCText;
	
	@AndroidFindBy(id = "recording_state")
	private WebElement recordingStateImageView;
	
	@AndroidFindBy(id = "wifi_strength")
	private WebElement wifi_strengthImageView;
	
	@AndroidFindBy(id = "memory")
	private WebElement memoryImageView;
	
	@AndroidFindBy(id = "battery")
	private WebElement batteryImageView;
	
	@AndroidFindBy(id = "textConfigure")
	@iOSFindBy(accessibility="Configure the Logger")
	private WebElement configureTheLoggerInSessionSetupPageText;
	
	@AndroidFindBy(id = "textInstall")
	@iOSFindBy(accessibility="Install and Verify the Logger")
	private WebElement installAndVerifyTheLoggerInSessionSetupPageText;

	@AndroidFindBy(uiAutomator="new UiSelector().textContains(\"Send Configuration\")")
	@iOSFindBy(accessibility="Send Configuration")
	private WebElement sendConfigurationButton;
	
	//textMonitoring
	@AndroidFindBy(id = "textMonitoring")
	private WebElement setupContinuousMonitoringOrLocalLoggingInSessionSetupPageText;
	
	//Monitor Authentication
	@AndroidFindBy(uiAutomator="new UiSelector().textContains(\"Logger Authentication\")")
	@iOSFindBy(xpath="//XCUIElementTypeNavigationBar[@name=\"Monitor Authentication\"]")
	private WebElement monitorAuthenticationTitle;
	
	@AndroidFindBy(uiAutomator="new UiSelector().textContains(\"New Configuration\")")
	@iOSFindBy(accessibility="New Configuration")
	private WebElement newConfigurationLink;
	
	@AndroidFindBy(id = "action_bar_title")
	@iOSFindBy(xpath="//XCUIElementTypeNavigationBar[@name=\"New Configuration\"]")
	private WebElement newConfigurationScreenText;
	
	@AndroidFindBy(id = "enter_config_name")
	@iOSFindBy(xpath="//XCUIElementTypeTextField[@value=\"Enter configuration name\"]")
	private WebElement enterConfigurationNameText;
	
	@AndroidFindBy(className = "android.widget.EditText")
	@iOSFindBy(xpath="//XCUIElementTypeTextView")
	private List<WebElement> configDescriptionText;
	
	@AndroidFindBy(id = "standard_drop_down")
	@iOSXCUITFindBy(iOSNsPredicate ="name == \"None\" OR name == \"EN50160\" OR name == \"IEEE519\"")
	private WebElement standardTypeDropdown;
	
	@iOSFindBy(xpath="//XCUIElementTypePickerWheel")
	private WebElement PQ_iOS_174X_PickerWheel;
	
	////XCUIElementTypeStaticText[@name="Topology"]/following-sibling::XCUIElementTypeButton
	
	@iOSFindBy(accessibility="Done")
	private WebElement doneOnPickerWheel;
	
	@AndroidFindBy(uiAutomator="new UiSelector().textContains(\"None\")")
	private WebElement none_StandardType;
	
	@AndroidFindBy(uiAutomator="new UiSelector().textContains(\"EN50160\")")
	private WebElement eN50160_StandardType;
	
	@AndroidFindBy(id = "study_type_drop_down")
	@iOSXCUITFindBy(iOSNsPredicate ="name == \"Energy Study\" OR name == \"Load Study\"")
	private WebElement studyTypeDropdown;
	
	@AndroidFindBy(uiAutomator="new UiSelector().textContains(\"Load Study\")")
	private WebElement loadStudy_StudyType;
	
	@AndroidFindBy(uiAutomator="new UiSelector().textContains(\"Energy Study\")")
	private WebElement energyStudy_StudyType;
	
	@AndroidFindBy(id = "topology_drop_down")
	@iOSXCUITFindBy(iOSNsPredicate ="name == \"Single Phase\" OR name == \"Wye\" OR name == \"Delta\" OR name == \"Split Single Phase\" OR name == \"Single Phase It\" OR name == \"Wye It\" OR name == \"High Leg Delta\" OR name == \"Open Delta\" OR name == \"Two Element\" OR name == \"Wye Balanced\" OR name == \"Delta Balanced\"")
	private WebElement topology_Dropdown;
	
	@AndroidFindBy(uiAutomator="new UiSelector().textContains(\"Wye It\")")
	private WebElement wyeIT_topology;
	
	@AndroidFindBy(uiAutomator="new UiSelector().textContains(\"Single Phase\")")
	private WebElement singlePhase_topology;
	
	@AndroidFindBy(uiAutomator="new UiSelector().textContains(\"Wye\")")
	private WebElement wye_topology;
	
	@AndroidFindBy(uiAutomator="new UiSelector().textContains(\"Split Single Phase\")")
	private WebElement splitSinglePhase_topology;
	
	@AndroidFindBy(uiAutomator="new UiSelector().textContains(\"Single Phase It\")")
	private WebElement singlePhaseIt_topology;
	
	@AndroidFindBy(uiAutomator="new UiSelector().textContains(\"Wye It\")")
	private WebElement wyeIt_topology;
	
	@AndroidFindBy(uiAutomator="new UiSelector().textContains(\"High Leg Delta\")")
	private WebElement highLegDelta_topology;
	
	@AndroidFindBy(uiAutomator="new UiSelector().textContains(\"Open Delta\")")
	private WebElement openDelta_topology;
	
	@AndroidFindBy(uiAutomator="new UiSelector().textContains(\"Two Element\")")
	private WebElement twoElement_topology;
	
	@AndroidFindBy(uiAutomator="new UiSelector().textContains(\"Wye Balanced\")")
	private WebElement wyeBalanced_topology;

	@AndroidFindBy(uiAutomator="new UiSelector().textContains(\"Delta Balanced\")")
	private WebElement deltaBalanced_topology;
	
	@AndroidFindBy(uiAutomator="new UiSelector().textContains(\"Delta\")")
	private WebElement delta_topology;
	
	@AndroidFindBy(id = "generate_config")
	@iOSFindBy(accessibility="Generate and Send Configuration")
	private WebElement generateConfigurationButton;

	@AndroidFindBy(uiAutomator="new UiSelector().textContains(\"Previous Configurations\")")
	@iOSFindBy(accessibility="Previous Configurations")
	private WebElement savedConfigurarionLink;

	@AndroidFindBy(id = "search")
	private WebElement searchTextBox;
	
	
	@AndroidFindBy(id = "viewMore")
	@iOSFindBy(accessibility="VIEW MORE")
	private WebElement viewMoreLink;
	
	//@AndroidFindBy(id = "ImageDescription")
	@AndroidFindBy(xpath ="//android.widget.ImageView[@content-desc=\"ImageDescription\"]")
	@iOSFindBy(accessibility="options white")
	private WebElement actionBarMenuLink;

	@AndroidFindBy(id = "dialog_ok")
	@iOSFindBy(accessibility="Delete")
	private WebElement deleteConfigButtonInPopUp;
	
	@AndroidFindBy(id = "dialog_ok")
	@iOSFindBy(accessibility="CONTINUE")
	private WebElement editConfigButtonInPopUp;
	
	@AndroidFindBy(id = "dialog_ok")
	@iOSFindBy(accessibility="SAVE")
	private WebElement saveButton;
	
	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	private WebElement allowButton;

	@AndroidFindBy(xpath = "//android.widget.RelativeLayout/child::android.widget.TextView[contains(@text,'Edit')]")
	@iOSFindBy(accessibility="Edit")
	private WebElement editLinkForSavedSession;

	@AndroidFindBy(xpath = "//android.widget.RelativeLayout/child::android.widget.TextView[contains(@text,'Save As')]")
	@iOSFindBy(accessibility="Save As")
	private WebElement saveAsLinkForSavedSession;
	
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout/child::android.widget.TextView[contains(@text,'Delete')]")
	@iOSFindBy(accessibility="Delete")
	private WebElement deleteLinkForSavedSession;
	
	@AndroidFindBy(id = "rename_group_ed")
	@iOSFindBy(xpath = "//XCUIElementTypeTextField")
	private WebElement saveAsEditBox_InPopup;
	
	@AndroidFindBy(id = "generate_config3")
	@iOSFindBy(accessibility="Done with Configuration")
	private WebElement doneWithConfigurationButton;
	
	@AndroidFindBy(id = "done_config")
	private WebElement doneConfigurationButton;
	
	@AndroidFindBy(xpath = "//android.widget.Spinner")
	private List <WebElement> studyTypeTopologyAndPhaseColour_Dropdowns;
	
	@AndroidFindBy(xpath = "//android.widget.Spinner")
	private List <WebElement> nominalVoltageAndFrequency_Dropdown;
	
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Nominal Voltage\"]")
	private WebElement nominalVoltage_iOSDropdown;
	
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Nominal Frequency\"]")
	private WebElement nominalFrequency_iOSDropdown;
	
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText")
	private List <WebElement> nominalVoltageFrequencyValue;
	
	
	@AndroidFindBy(className = "android.widget.EditText")
	private WebElement customNominalVoltage_EditBox;
	
	//Ranges and Scaling
	@AndroidFindBy(id = "value_voltage")
	private WebElement voltageRatio_EditBox;
	
	@AndroidFindBy(id = "current_ampratio")
	private WebElement currentRatio_EditBox;
	
	@AndroidFindBy(id = "amp_neutral_ratio")
	private WebElement ampNeutralRatio_EditBox;
	
	@iOSFindBy(xpath = "//XCUIElementTypeTextField")
	private List<WebElement> voltageCurrentAmpNeutralRatio_EditBox;
	
	//Main Signaling voltages
	@AndroidFindBy(xpath = "//android.widget.EditText")
	@iOSFindBy(xpath = "//XCUIElementTypeTextField")
	private List <WebElement> mainSignalingVoltage_Freq1_Freq2_EditBox;
	
	//Harmonics Measurement Mode
	@AndroidFindBy(xpath = "//android.widget.RadioButton")
	@iOSFindBy(xpath ="//XCUIElementTypeButton")
	private List <WebElement> harmonicsMeasurementMode_RadioButton;
	
	@AndroidFindBy(id = "checkBox")
	private WebElement includeInterHarmonics_Checkbox;
	
	//Flicker-Lamp model
	@AndroidFindBy(xpath = "//android.widget.Spinner")
	@iOSFindBy(xpath ="//XCUIElementTypeButton")
	private List<WebElement> flickerLampModelVoltage_Drodpdown;
	
	@iOSFindBy(xpath ="//XCUIElementTypeButton")
	private List<WebElement> eventsAndTriggersCheckboxes;
	
	
	@AndroidFindBy(xpath = "//android.widget.TextView [@text='Dip']/following-sibling::android.widget.CheckBox")
	private WebElement dipSlidingReference_Checkbox;
	
	@AndroidFindBy(xpath = "//android.widget.TextView [@text='Swell']/following-sibling::android.widget.CheckBox")
	private WebElement swellSlidingReference_Checkbox;
	
	@AndroidFindBy(xpath = "//android.widget.TextView [@text='Dip']/following-sibling::android.widget.EditText")
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Dip']/following-sibling::XCUIElementTypeTextField")
	private WebElement dipLimit_editbox;
	
	@AndroidFindBy(xpath = "//android.widget.TextView [@text='Swell']/following-sibling::android.widget.EditText")
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Swell']/following-sibling::XCUIElementTypeTextField")
	private WebElement swellLimit_editbox;
	
	@AndroidFindBy(xpath = "//android.widget.TextView [@text='Interruption']/following-sibling::android.widget.EditText")
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Interruptions']/following-sibling::XCUIElementTypeTextField")
	private WebElement interruptionLimit_editbox;
	
	@AndroidFindBy(xpath = "//android.widget.TextView [@text='Rapid Voltage Changes']/following-sibling::android.widget.EditText")
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Rapid Voltage Changes']/following-sibling::XCUIElementTypeTextField")
	private WebElement rapidVoltageChangesLimit_editbox;
	
	@AndroidFindBy(xpath = "//android.widget.TextView [@text='Mains Signalling Voltages']/following-sibling::android.widget.EditText")
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Mains Signalling']/following-sibling::XCUIElementTypeTextField")
	private WebElement mainsSignllingVoltagesLimit_editbox;
	
	@AndroidFindBy(xpath = "//android.widget.TextView [@text='Inrush Current']/following-sibling::android.widget.EditText")
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Inrush Current']/following-sibling::XCUIElementTypeTextField")
	private WebElement inrushCurrentLimit_editbox;
	
	@AndroidFindBy(xpath = "//android.widget.TextView [@text='Waveform Deviation']/following-sibling::android.widget.EditText")
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Waveform Deviation']/following-sibling::XCUIElementTypeTextField")
	private WebElement waveformDeviationLimit_editbox;
	
	@AndroidFindBy(xpath = "//android.widget.TextView [@text='Rapid Voltage Changes']/following-sibling::android.widget.CheckBox")
	private WebElement rapidVoltageChangesTriggerON_Checkbox;
	
	@AndroidFindBy(xpath = "//android.widget.TextView [@text='Mains Signalling Voltages']/following-sibling::android.widget.CheckBox")
	private WebElement mainsSignallingVoltagesTriggerON_Checkbox;
	
	@AndroidFindBy(xpath = "//android.widget.TextView [@text='Waveform Deviation']/following-sibling::android.widget.CheckBox")
	private WebElement waveformDeviationTriggerON_Checkbox;
	
	@AndroidFindBy(xpath = "//android.widget.TextView [@text='Inrush Current']/following-sibling::android.widget.CheckBox")
	private WebElement inrushCurrentTriggerON_Checkbox;
	
	public FCCM174XSessionConfigObjectRepo()
	{
		CommonUtils.initElements(this, 15);
		gestureUtils = new GestureUtils();
		phoneSettingsPage = new DeviceUtils();
		
	}
	
	//Intervals(Trend,Demand)
	@AndroidFindBy(xpath = "//android.widget.Spinner")
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText")
	private List <WebElement> trendInterval_DemandInterval_Drodpdown;
	
	@AndroidFindBy(xpath = "//android.widget.ListView/child::android.widget.CheckedTextView")
	private List <WebElement> trendInterval_list;
	
	public void turnOnBlondelToggle()
	{
		CommonUtils.wait(1);
		gestureUtils.mobileScroll("Blondel", Config.IOS_LOCATOR_STRATEGY_NAME, ScrollDiection.DOWN);
		String blondelToggleONOFFButtonStatus = blondelServiceHatchButton.getText();
		if(blondelToggleONOFFButtonStatus.equals("OFF"))
		{
			blondelServiceHatchButton.click();
			CommonUtils.wait(1);
		}
		clickOnBackButton();
		
	}
	
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
	
	public void clickOnAllowButton()
	{
		allowButton.click();
	}
	
	public void clickOnSetupLoggingOrMonitoringLink()
	{
		setupLoggingOrMonitoringLink.click();
	}
	
	public void clickOnThreePhasePowerMonitorLink()
	{
		threePhasePowerMonitorLink.click();
	}
	
	public void clickOnBackButton()
	{
		try
		{
			BackButtonOnApp.click();
		}
		catch(Exception e)
		{
			normalbackButton.click();
		}
		
		CommonUtils.wait(1);
	}
	
	public Boolean verifyPowerQualityLoggerOption()
	{
		String pqLoggerText = powerQualityLoggerText.getText();
		
		if (pqLoggerText.equals("Power Quality Logger"))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public void clickOpenPhoneSettingsButton()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			openPhoneSettings.click();
		}
		
	}
	
	public void clickOnpowerQualityLogger()
	{
		powerQualityLoggerText.click();
	}
	
	public Boolean getMonitorAuthenticationText()
	{
		String monitorAuth =  monitorAuthenticationText.getText();
		if (monitorAuth.equals("Monitor Authentication"))
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, "CANCEL", LocatorStrategy.NONE, null).click();
				CommonUtils.wait(1);
			}
			
			return true;
		}
		else
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			{
				ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME, "CANCEL", LocatorStrategy.NONE, null).click();
				CommonUtils.wait(1);
			}
			return false;
		}
	}
	
	public String getMonitorNameInMonitorAuthenticationPageLabel()
	{
		return monitorNameInMonitorAuthenticationPageLabel.getText();
	}
	
	public String getSerialNumberInMonitorAuthenticationPageLabel()
	{
		return serialNumberInMonitorAuthenticationPageLabel.getText();
	}
	
	public String getFirmwareVersionInMonitorAuthenticationPageLabel()
	{
		return firmwareVersionInMonitorAuthenticationPageLabel.getText();
	}
	
	public void enterUserNameInMonitorAuthenticationPageText(String username)
	{
		userNameInMonitorAuthenticationPageText.sendKeys(username);
	}
	
	public void enterPasswordInMonitorAuthenticationPageText(String password)
	{
		passwordInMonitorAuthenticationPageText.sendKeys(password);
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			returnKeypadButton.click();
		}
	}
	
	public String getLoggerNameInSessionSetupPageLabel()
	{
		return loggerNameInSessionSetupPageLabel.getText();
	}
	
	public boolean verifyUserNameInMonitorAuthenticationPageText()
	{
		String usrName = userNameInMonitorAuthenticationPageText.getText();
		if (usrName.equals("admin"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean verifyPasswordInMonitorAuthenticationPageText()
	{
		String pass = passwordInMonitorAuthenticationPageText.getText();
		if (pass != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Boolean checkRememberUserInMonitorAuthenticationPageCheckbox()
	{
		String abc = rememberUserInMonitorAuthenticationPageCheckbox.getAttribute("checked");
		if (rememberUserInMonitorAuthenticationPageCheckbox.getAttribute("checked").equals("false"))
		{
			rememberUserInMonitorAuthenticationPageCheckbox.click();
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Boolean UncheckRememberUserInMonitorAuthenticationPageCheckbox()
	{
		String abc = rememberUserInMonitorAuthenticationPageCheckbox.getAttribute("checked");
		if (rememberUserInMonitorAuthenticationPageCheckbox.getAttribute("checked").equals("true"))
		{
			rememberUserInMonitorAuthenticationPageCheckbox.click();
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Boolean checkStatusOfRememberUserInMonitorAuthenticationPageCheckbox()
	{
		String abc = rememberUserInMonitorAuthenticationPageCheckbox.getAttribute("checked");
		if (rememberUserInMonitorAuthenticationPageCheckbox.getAttribute("checked").equals("false"))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public void clickOnContinueInMonitorAuthenticationPageText()
	{
		continueInMonitorAuthenticationPageText.click();
	}
	
	public Boolean isDisplayedRTC()
	{
		if (RTCText.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Boolean isDisplayedRecordingState()
	{
		if (recordingStateImageView.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Boolean isDisplayedWifiStrength()
	{
		if (wifi_strengthImageView.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Boolean isDisplayedMemory()
	{
		if (memoryImageView.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Boolean isDisplayedBattery()
	{
		if (batteryImageView.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Boolean isDisplayedConfigureTheLoggerInSessionSetupPageText()
	{
		if (configureTheLoggerInSessionSetupPageText.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	//installAndVerifyTheLoggerInSessionSetupPageText
	public Boolean isDisplayedInstallAndVerifyTheLoggerInSessionSetupPageText()
	{
		if (installAndVerifyTheLoggerInSessionSetupPageText.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	//setupContinuousMonitoringOrLocalLoggingInSessionSetupPageText
	public Boolean isDisplayedSetupContinuousMonitoringOrLocalLoggingInSessionSetupPageText()
	{
		if (setupContinuousMonitoringOrLocalLoggingInSessionSetupPageText.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public void clickOnConfigureTheLoggerInSessionSetupPageText()
	{
		configureTheLoggerInSessionSetupPageText.click();
	}
	
	public void clickOnInstallAndVerifyTheLoggerText()
	{
		installAndVerifyTheLoggerInSessionSetupPageText.click();
	}
	
	public void openWifiSettingsPage()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			AndroidUtils.getAndroidDriver().startActivity(new Activity("com.android.settings", ".wifi.WifiSettings"));
			CommonUtils.wait(1);
		}

	}
	
	public Boolean isVisibleSessionSetupText()
	{
		//CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(120, 10, sessionSetupText);
		ElementUtils.isDisplayed(120, 3, sessionSetupText);
		if(sessionSetupText.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void clickOnInstrumentSettings()
	{
		instrumentSettingsLink.click();
		CommonUtils.wait(2);
	}
	
	public Boolean isNewConfigurationScreenVisible()
	{
		ElementUtils.isDisplayed(120, 3, newConfigurationScreenText);
		if(newConfigurationScreenText.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public Boolean isSavedConfigScreenVisible()
	{
		ElementUtils.isDisplayed(120, 3, newConfigurationScreenText);
		if(newConfigurationScreenText.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void enter_Text_In_DescriptionBox(String configDescription)
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			configDescriptionText.get(1).clear();
			configDescriptionText.get(1).sendKeys(configDescription);
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			configDescriptionText.get(0).clear();
			configDescriptionText.get(0).sendKeys(configDescription);
		}
		
		
	}
	
	public String get_Text_FromDescriptionBox()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			return configDescriptionText.get(1).getText();
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			return configDescriptionText.get(0).getText();
		}
		else
		{
			return null;
		}
	}
	
	public void clickOnNewConfigurationLink()
	{
		newConfigurationLink.click();
	}
	
	
	public Boolean isConfigNameVisibleInNewConfigDetailsScreen(String randomConfigName)
	{
		ElementUtils.isDisplayed(120, 3, ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, randomConfigName, LocatorStrategy.NONE, null));
		if(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, randomConfigName, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, randomConfigName, LocatorStrategy.NONE, null).isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void enterConfigurationNameInTextBox(String randomConfigName)
	{
		enterConfigurationNameText.sendKeys(randomConfigName);
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			returnKeypadButton.click();
		}
	}
	
	
	public void clickOnStandardTypeDropdown()
	{
		standardTypeDropdown.click();
	}
	
	public void clickOn_NONE_StandardType()
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			for(int i = 0;i < FCCM174X.getPickerLoopCountTestStandardType.get("None"); i++)
			{
				gestureUtils.scrollIOSPickerWheel(PQ_iOS_174X_PickerWheel, ScrollDiection.NEXT);
			}
			
			doneOnPickerWheel.click();
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			none_StandardType.click();
		}
		
	}
	
	public void clickOn_EN50160_StandardType()
	{
		eN50160_StandardType.click();
	}
	
	public void clickOn_StudyType_dropdown()
	{
		studyTypeDropdown.click();
	}
	
	public void clickOn_LOADSTUDY_StudyType()
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			for(int i = 0;i < FCCM174X.getPickerLoopCountTestStudyType.get("Load Study"); i++)
			{
				gestureUtils.scrollIOSPickerWheel(PQ_iOS_174X_PickerWheel, ScrollDiection.NEXT);
			}
			
			doneOnPickerWheel.click();
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			loadStudy_StudyType.click();
		}
	}
	
	public void clickOn_ENERGYSTUDY_StudyType()
	{
		
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			for(int i = 0;i < FCCM174X.getPickerLoopCountTestStudyType.get("Energy Study"); i++)
			{
				gestureUtils.scrollIOSPickerWheel(PQ_iOS_174X_PickerWheel, ScrollDiection.NEXT);
			}
			
			doneOnPickerWheel.click();
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			energyStudy_StudyType.click();
		}
	}
	
	public void clickOn_Topology_dropdown()
	{
		topology_Dropdown.click();
	}
	
	public void clickOn_WyeIT_topology()
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			for(int i = 0;i < FCCM174X.getPickerLoopCountTestTopology.get("Wye It"); i++)
			{
				gestureUtils.scrollIOSPickerWheel(PQ_iOS_174X_PickerWheel, ScrollDiection.NEXT);
			}
			
			doneOnPickerWheel.click();
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			wyeIT_topology.click();
		}
		
	}
	
	public void clickOn_SinglePhase_topology()
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			for(int i = 0;i < FCCM174X.getPickerLoopCountTestTopology.get("Single Phase"); i++)
			{
				gestureUtils.scrollIOSPickerWheel(PQ_iOS_174X_PickerWheel, ScrollDiection.NEXT);
			}
			
			doneOnPickerWheel.click();
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			singlePhase_topology.click();
		}
		
	}
	
	public void clickOn_Wye_topology()
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			for(int i = 0;i < FCCM174X.getPickerLoopCountTestTopology.get("Wye"); i++)
			{
				gestureUtils.scrollIOSPickerWheel(PQ_iOS_174X_PickerWheel, ScrollDiection.NEXT);
			}
			
			doneOnPickerWheel.click();
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			wye_topology.click();
		}
		
	}
	
	
	public void clickOn_Delta_topology()
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			for(int i = 0;i < FCCM174X.getPickerLoopCountTestTopology.get("Delta"); i++)
			{
				gestureUtils.scrollIOSPickerWheel(PQ_iOS_174X_PickerWheel, ScrollDiection.NEXT);
			}
			
			doneOnPickerWheel.click();
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			delta_topology.click();
		}
		
	}
	
	
	public void clickOn_SplitSinglePhase_topology()
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			for(int i = 0;i < FCCM174X.getPickerLoopCountTestTopology.get("Split Single Phase"); i++)
			{
				gestureUtils.scrollIOSPickerWheel(PQ_iOS_174X_PickerWheel, ScrollDiection.NEXT);
			}
			
			doneOnPickerWheel.click();
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			splitSinglePhase_topology.click();
		}
		
	}
	
	
	public void clickOn_SinglePhaseIt_topology()
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			for(int i = 0;i < FCCM174X.getPickerLoopCountTestTopology.get("Single Phase It"); i++)
			{
				gestureUtils.scrollIOSPickerWheel(PQ_iOS_174X_PickerWheel, ScrollDiection.NEXT);
			}
			
			doneOnPickerWheel.click();
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			singlePhaseIt_topology.click();
		}
		
	}
	
	public void clickOn_WyeIt_topology()
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			for(int i = 0;i < FCCM174X.getPickerLoopCountTestTopology.get("Wye It"); i++)
			{
				gestureUtils.scrollIOSPickerWheel(PQ_iOS_174X_PickerWheel, ScrollDiection.NEXT);
			}
			
			doneOnPickerWheel.click();
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			wyeIt_topology.click();
		}
		
	}
	
	
	public void clickOn_HighLegDelta_topology()
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			for(int i = 0;i < FCCM174X.getPickerLoopCountTestTopology.get("High Leg Delta"); i++)
			{
				gestureUtils.scrollIOSPickerWheel(PQ_iOS_174X_PickerWheel, ScrollDiection.NEXT);
			}
			
			doneOnPickerWheel.click();
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			highLegDelta_topology.click();
		}
		
	}
	
	public void clickOn_OpenDelta_topology()
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			for(int i = 0;i < FCCM174X.getPickerLoopCountTestTopology.get("Open Delta"); i++)
			{
				gestureUtils.scrollIOSPickerWheel(PQ_iOS_174X_PickerWheel, ScrollDiection.NEXT);
			}
			
			doneOnPickerWheel.click();
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			openDelta_topology.click();
		}
		
	}
	
	public void clickOn_TwoElement_topology()
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			for(int i = 0;i < FCCM174X.getPickerLoopCountTestTopology.get("Two Element"); i++)
			{
				gestureUtils.scrollIOSPickerWheel(PQ_iOS_174X_PickerWheel, ScrollDiection.NEXT);
			}
			
			doneOnPickerWheel.click();
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			twoElement_topology.click();
		}
		
	}
	
	public void clickOn_WyeBalanced_topology()
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			for(int i = 0;i < FCCM174X.getPickerLoopCountTestTopology.get("Wye Balanced"); i++)
			{
				gestureUtils.scrollIOSPickerWheel(PQ_iOS_174X_PickerWheel, ScrollDiection.NEXT);
			}
			
			doneOnPickerWheel.click();
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			wyeBalanced_topology.click();
		}
		
	}
	
	
	public void clickOn_DeltaBalanced_topology()
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			for(int i = 0;i < FCCM174X.getPickerLoopCountTestTopology.get("Delta Balanced"); i++)
			{
				gestureUtils.scrollIOSPickerWheel(PQ_iOS_174X_PickerWheel, ScrollDiection.NEXT);
			}
			
			doneOnPickerWheel.click();
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			deltaBalanced_topology.click();
		}
		
	}
	
	
	
	public void clickOn_GenerateConfiguration_Button()
	{
		generateConfigurationButton.click();
	}
	
	
	public void clickOn_ViewMore_Link()
	{
		viewMoreLink.click();
	}
	
	public void clickOn_SavedConfigurarion_link()
	{
		savedConfigurarionLink.click();
	}
	
	public void clickOn_3dot_ActionBarMenu_Link()
	{
		CommonUtils.wait(2);
		actionBarMenuLink.click();
		
	}
	
	
	public void clickOn_Delete_ConfigurationButton_InPopup()
	{
		deleteConfigButtonInPopUp.click();
	}
	
	
	public void clickOn_SendConfiguration_Button()
	{
		sendConfigurationButton.click();
	}
	
	
	public void clickOn_Edit_Link_ForSavedSession()
	{
		editLinkForSavedSession.click();
	}
	
	public void clickOn_SaveAs_Link_ForSavedSession()
	{
		saveAsLinkForSavedSession.click();
	}
	
	public void clickOn_Edit_ConfigurationButton_InPopup()
	{
		editConfigButtonInPopUp.click();
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			CommonUtils.wait(3);
		}
	}
	
	public void enter_Text_In_SaveAs_EditBox(String savedSessionName_SaveAs)
	{
		saveAsEditBox_InPopup.clear();
		CommonUtils.wait(1);
		saveAsEditBox_InPopup.sendKeys(savedSessionName_SaveAs);
		saveButton.click();
		CommonUtils.wait(1);
	}
	
	public void clickOn_Done_with_Configuration_Button()
	{
		doneWithConfigurationButton.click();
	}
	
	public void clickOn_DoneButton()
	{
		doneConfigurationButton.click();
	}
	
	public void clickOn_Delete_Link_for_SavedSession()
	{
		deleteLinkForSavedSession.click();
	}
	
	public void changeStudyTypeFromEditDropdown(String studyType)
	{
		studyTypeTopologyAndPhaseColour_Dropdowns.get(0).click();
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, studyType, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
	}
	
	public void changeTopologyFromEditDropdown(String topology)
	{
		studyTypeTopologyAndPhaseColour_Dropdowns.get(1).click();
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, topology, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
	}
	
	
	public void changePhaseColourFromEditDropdown(String phaseColour)
	{
		studyTypeTopologyAndPhaseColour_Dropdowns.get(2).click();
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, phaseColour, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
	}
	
	public String isEditLinkDisplayedInSavedSessionPage()
	{
		if(editLinkForSavedSession.isDisplayed())
		{
			return "true";
		}
		else
		{
			return "false";
		}
	}
	
	public String isSaveAsLinkDisplayedInSavedSessionPage()
	{
		if(saveAsLinkForSavedSession.isDisplayed())
		{
			return "true";
		}
		else
		{
			return "false";
		}
	}
	
	public String isDeleteLinkDisplayedInSavedSessionPage()
	{
		if(deleteLinkForSavedSession.isDisplayed())
		{
			return "true";
		}
		else
		{
			return "false";
		}
	}
	
	public void clickOnEditLinkInSavedSessionScreen()
	{
		editLinkForSavedSession.click();
	}
	
	public void clickOnNominalVoltage_Dropdown()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			nominalVoltageAndFrequency_Dropdown.get(0).click();
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			nominalVoltage_iOSDropdown.click();
		}
		
	}
	
	public String getNominalVoltage()
	{
		return nominalVoltageFrequencyValue.get(2).getText();
	}
	
	public String getNominalFrequency()
	{
		return nominalVoltageFrequencyValue.get(4).getText();
	}
	
	public void clickOnNominalFrequency_Dropdown()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			nominalVoltageAndFrequency_Dropdown.get(1).click();	
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			nominalFrequency_iOSDropdown.click();
		}
	}
	
	public void enterCustomNominalVoltage(String customValue)
	{
		customNominalVoltage_EditBox.sendKeys(customValue);
	}
	
	public void enterVoltageRatio(String vtgRatio)
	{
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			voltageRatio_EditBox.clear();
			voltageRatio_EditBox.sendKeys(vtgRatio);
			CommonUtils.wait(1);
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			voltageCurrentAmpNeutralRatio_EditBox.get(0).clear();
			voltageCurrentAmpNeutralRatio_EditBox.get(0).sendKeys(vtgRatio);
			CommonUtils.wait(1);
		}
		
	}
	
	public void enterCurrentRatio(String currentRatio)
	{
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			currentRatio_EditBox.clear();
			currentRatio_EditBox.sendKeys(currentRatio);
			CommonUtils.wait(1);
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			voltageCurrentAmpNeutralRatio_EditBox.get(1).clear();
			voltageCurrentAmpNeutralRatio_EditBox.get(1).sendKeys(currentRatio);
			CommonUtils.wait(1);
		}
		
	}
	
	public void enterCurrentRatioForLoad(String currentRatio)
	{
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			currentRatio_EditBox.clear();
			currentRatio_EditBox.sendKeys(currentRatio);
			CommonUtils.wait(1);
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			voltageCurrentAmpNeutralRatio_EditBox.get(0).clear();
			voltageCurrentAmpNeutralRatio_EditBox.get(0).sendKeys(currentRatio);
			CommonUtils.wait(1);
		}
		
	}
	
	public void enterAmpNeutralRatio(String ampNeutralRatio)
	{
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			ampNeutralRatio_EditBox.clear();
			ampNeutralRatio_EditBox.sendKeys(ampNeutralRatio);
			CommonUtils.wait(1);
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			voltageCurrentAmpNeutralRatio_EditBox.get(2).clear();
			voltageCurrentAmpNeutralRatio_EditBox.get(2).sendKeys(ampNeutralRatio);
			CommonUtils.wait(1);
		}
	}
	
	public void enterAmpNeutralRatioForLoad(String currentRatio)
	{
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			ampNeutralRatio_EditBox.clear();
			ampNeutralRatio_EditBox.sendKeys(currentRatio);
			CommonUtils.wait(1);
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			voltageCurrentAmpNeutralRatio_EditBox.get(1).clear();
			voltageCurrentAmpNeutralRatio_EditBox.get(1).sendKeys(currentRatio);
			CommonUtils.wait(1);
		}
		
	}
	
	
	public Boolean validateVoltageRatio(String value)
	{
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			if (voltageRatio_EditBox.getText().equals(value))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			if (voltageCurrentAmpNeutralRatio_EditBox.get(0).getText().contains(value))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		
	}
	
	public Boolean validateCurrentRatio(String value)
	{
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			if (currentRatio_EditBox.getText().equals(value))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			if (voltageCurrentAmpNeutralRatio_EditBox.get(1).getText().contains(value))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	public Boolean validateAmpNeutralRatio(String value)
	{
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			if (ampNeutralRatio_EditBox.getText().equals(value))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			if (voltageCurrentAmpNeutralRatio_EditBox.get(2).getText().contains(value))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		
	}
	
	public void enter_Freq1_ForMainSignalingVoltage(String value)
	{
		mainSignalingVoltage_Freq1_Freq2_EditBox.get(0).clear();
		mainSignalingVoltage_Freq1_Freq2_EditBox.get(0).sendKeys(value);
	}
	
	public void enter_Freq2_ForMainSignalingVoltage(String value)
	{
		mainSignalingVoltage_Freq1_Freq2_EditBox.get(1).clear();
		mainSignalingVoltage_Freq1_Freq2_EditBox.get(1).sendKeys(value);
	}
	
	public Boolean validate_Freq1_ForMainSigVoltage(String value)
	{
		if (mainSignalingVoltage_Freq1_Freq2_EditBox.get(0).getText().equals(value))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Boolean validate_Freq2_ForMainSigVoltage(String value)
	{
		if (mainSignalingVoltage_Freq1_Freq2_EditBox.get(1).getText().equals(value))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void clickOn_Components_RadioButton()
	{
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			harmonicsMeasurementMode_RadioButton.get(0).click();
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			harmonicsMeasurementMode_RadioButton.get(2).click();
		}
	}
	
	public void clickOn_Grouped_RadioButton()
	{
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			harmonicsMeasurementMode_RadioButton.get(1).click();
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			harmonicsMeasurementMode_RadioButton.get(3).click();
		}
	}
	
	public void clickOn_SubGrouped_RadioButton()
	{
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			harmonicsMeasurementMode_RadioButton.get(2).click();
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			harmonicsMeasurementMode_RadioButton.get(4).click();
		}
		
	}
	
	public void check_IncludeInterHarmonics_checkbox()
	{
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			if (includeInterHarmonics_Checkbox.getAttribute("checked").equals("false"))
			{
				includeInterHarmonics_Checkbox.click();
			}
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			try
			{
				if(harmonicsMeasurementMode_RadioButton.get(5).getAttribute("value").equals("1"))
				{
					
				}
				else
				{
					harmonicsMeasurementMode_RadioButton.get(5).click();
				}
			}
			catch(Exception e)
			{
				harmonicsMeasurementMode_RadioButton.get(5).click();
			}
			
		}
		
	}
	
	public Boolean validate_Components_isSelected()
	{
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			if(harmonicsMeasurementMode_RadioButton.get(0).getAttribute("checked").equals("true"))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			try
			{
				if(harmonicsMeasurementMode_RadioButton.get(2).getAttribute("value").equals("1"))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			catch(Exception e)
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		
	}
	
	public Boolean validate_Grouped_isSelected()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			if(harmonicsMeasurementMode_RadioButton.get(1).getAttribute("checked").equals("true"))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			
		{
			try
			{
				if(harmonicsMeasurementMode_RadioButton.get(3).getAttribute("value").equals("1"))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			catch(Exception e)
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		
	}
	
	
	public Boolean validate_SubGrouped_isSelected()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			if(harmonicsMeasurementMode_RadioButton.get(2).getAttribute("checked").equals("true"))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			try
			{
				if(harmonicsMeasurementMode_RadioButton.get(4).getAttribute("value").equals("1"))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			catch(Exception e)
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		
	}
	
	public Boolean validate_IncludeInterHarmonics_isCheckBoxSelected()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			if (includeInterHarmonics_Checkbox.getAttribute("checked").equals("true"))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			try
			{
				if(harmonicsMeasurementMode_RadioButton.get(5).getAttribute("value").equals("1"))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			catch(Exception e)
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		
	}
	
	public void choose_FlickerLampModelVoltage(String value)
	{
		
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			flickerLampModelVoltage_Drodpdown.get(0).click();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, value, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			flickerLampModelVoltage_Drodpdown.get(2).click();
			//Clicking on done button in droddown
			flickerLampModelVoltage_Drodpdown.get(3).click();
		}
		
	}
	
	public String getSelectedFlickerLampModelValueForiOS()
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			return flickerLampModelVoltage_Drodpdown.get(2).getText();
		}
		else
		{
			return null;
		}
		
	}
	
	public void clickOnDipSledingReferenceCheckbox()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			//unchecking if already checked
			if (dipSlidingReference_Checkbox.getAttribute("checked").equals("true"))
			{
				dipSlidingReference_Checkbox.click();
				CommonUtils.wait(3);
			}
			CommonUtils.wait(3);
			dipSlidingReference_Checkbox.click();
			CommonUtils.wait(3);
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		try
		{
			//unchecking if already checked
			if (eventsAndTriggersCheckboxes.get(1).getAttribute("value").equals("1"))
			{
				eventsAndTriggersCheckboxes.get(1).click();
				CommonUtils.wait(3);
			}
			CommonUtils.wait(3);
			eventsAndTriggersCheckboxes.get(1).click();
			CommonUtils.wait(3);
			
		}catch(Exception e)
		{
			eventsAndTriggersCheckboxes.get(1).click();
			CommonUtils.wait(3);
		}
		
		
	}
	
	public void clickOnSwellSledingReferenceCheckbox()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			//unchecking if already checked
			if (swellSlidingReference_Checkbox.getAttribute("checked").equals("true"))
			{
				swellSlidingReference_Checkbox.click();
				CommonUtils.wait(3);
			}
			CommonUtils.wait(3);
			swellSlidingReference_Checkbox.click();
			CommonUtils.wait(3);
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			try
			{
				//unchecking if already checked
				if (eventsAndTriggersCheckboxes.get(2).getAttribute("value").equals("1"))
				{
					eventsAndTriggersCheckboxes.get(2).click();
					CommonUtils.wait(3);
				}
				CommonUtils.wait(3);
				eventsAndTriggersCheckboxes.get(2).click();
				CommonUtils.wait(3);
				
			}catch(Exception e)
			{
				eventsAndTriggersCheckboxes.get(2).click();
				CommonUtils.wait(3);
			}
		
	}
	
	public void uncheckDipSledingReferenceCheckbox()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			//unchecking if already checked
			if (dipSlidingReference_Checkbox.getAttribute("checked").equals("true"))
			{
				dipSlidingReference_Checkbox.click();
				CommonUtils.wait(3);
			}
			CommonUtils.wait(3);
			
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			try
			{
				//unchecking if already checked
				if (eventsAndTriggersCheckboxes.get(1).getAttribute("value").equals("1"))
				{
					eventsAndTriggersCheckboxes.get(1).click();
					CommonUtils.wait(3);
				}
				CommonUtils.wait(3);
			}catch(Exception e)
			{
				
			}	
		}
	}
	
	public void uncheckSwellSledingReferenceCheckbox()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			//unchecking if already checked
			if (swellSlidingReference_Checkbox.getAttribute("checked").equals("true"))
			{
				swellSlidingReference_Checkbox.click();
				CommonUtils.wait(3);
			}
			CommonUtils.wait(3);
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			try
			{
				//unchecking if already checked
				if (eventsAndTriggersCheckboxes.get(2).getAttribute("value").equals("1"))
				{
					eventsAndTriggersCheckboxes.get(2).click();
					CommonUtils.wait(3);
				}
				CommonUtils.wait(3);
			}catch(Exception e)
			{
				
			}	
		}
		
	}
	
	
	public Boolean checkDipAndSwellCheckboxes()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			if (dipSlidingReference_Checkbox.getAttribute("checked").equals("true") && swellSlidingReference_Checkbox.getAttribute("checked").equals("true"))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			try
			{
				if (eventsAndTriggersCheckboxes.get(1).getAttribute("value").equals("1") && eventsAndTriggersCheckboxes.get(2).getAttribute("value").equals("1"))
				{
					return true;
				}
				else
				{
					return false;
				}
			}catch(Exception e)
			{
				return false;
			}
			
		}
		return true;
	}
	
	
	public Boolean checkRapidVoltageChangesCheckboxes()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			if (rapidVoltageChangesTriggerON_Checkbox.getAttribute("checked").equals("true"))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			try
			{
				if (eventsAndTriggersCheckboxes.get(3).getAttribute("value").equals("1") && eventsAndTriggersCheckboxes.get(2).getAttribute("value").equals("1"))
				{
					return true;
				}
				else
				{
					return false;
				}
			}catch(Exception e)
			{
				return true;
			}
		}
		return true;
	}
	
	
	public Boolean checkMainsSignallingVoltagesCheckboxes()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			if (mainsSignallingVoltagesTriggerON_Checkbox.getAttribute("checked").equals("true"))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			try
			{
				if (eventsAndTriggersCheckboxes.get(4).getAttribute("value").equals("1") && eventsAndTriggersCheckboxes.get(2).getAttribute("value").equals("1"))
				{
					return true;
				}
				else
				{
					return false;
				}
			}catch(Exception e)
			{
				return true;
			}
		}
		return true;
	}
	
	public Boolean checkWaveformDeviationCheckbox()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			if (waveformDeviationTriggerON_Checkbox.getAttribute("checked").equals("true"))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			try
			{
				if (eventsAndTriggersCheckboxes.get(5).getAttribute("value").equals("1") && eventsAndTriggersCheckboxes.get(2).getAttribute("value").equals("1"))
				{
					return true;
				}
				else
				{
					return false;
				}
			}catch(Exception e)
			{
				return true;
			}
		}
		return true;
	}
	
	public Boolean checkInrushCurrentCheckbox()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			if (inrushCurrentTriggerON_Checkbox.getAttribute("checked").equals("true"))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			try
			{
				if (eventsAndTriggersCheckboxes.get(6).getAttribute("value").equals("1") && eventsAndTriggersCheckboxes.get(2).getAttribute("value").equals("1"))
				{
					return true;
				}
				else
				{
					return false;
				}
			}catch(Exception e)
			{
				return true;
			}
		}
		return true;
	}
	
	public void clickAndEditDipLimitEditBox(String value)
	{
		dipLimit_editbox.click();
		CommonUtils.wait(1);
		dipLimit_editbox.clear();
		dipLimit_editbox.sendKeys(value);
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
		}
		CommonUtils.wait(1);
	}
	
	public void clickAndEditSwellLimitEditBox(String value)
	{
		swellLimit_editbox.click();
		CommonUtils.wait(1);
		swellLimit_editbox.clear();
		swellLimit_editbox.sendKeys(value);
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
		}
		CommonUtils.wait(1);
	}
	
	public void clickAndEditInterruptionLimitEditBox(String value)
	{
		interruptionLimit_editbox.click();
		CommonUtils.wait(1);
		interruptionLimit_editbox.clear();
		interruptionLimit_editbox.sendKeys(value);
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
		}
		CommonUtils.wait(1);
	}
	
	public void clickAndEditRapidVoltageChangesLimitEditBox(String value)
	{
		rapidVoltageChangesLimit_editbox.click();
		CommonUtils.wait(1);
		rapidVoltageChangesLimit_editbox.clear();
		rapidVoltageChangesLimit_editbox.sendKeys(value);
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
		}
		CommonUtils.wait(1);
	}
	
	public void clickAndEditMainsSignallingVoltagesLimitsEditBox(String value)
	{
		mainsSignllingVoltagesLimit_editbox.click();
		CommonUtils.wait(1);
		mainsSignllingVoltagesLimit_editbox.clear();
		mainsSignllingVoltagesLimit_editbox.sendKeys(value);
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
		}
		CommonUtils.wait(1);
	}
	
	public void clickAndEditWaveformDeviationLimitsEditBox(String value)
	{
		waveformDeviationLimit_editbox.click();
		CommonUtils.wait(1);
		waveformDeviationLimit_editbox.clear();
		waveformDeviationLimit_editbox.sendKeys(value);
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
		}
		CommonUtils.wait(1);
	}
	
	public void clickAndEditInrushCurrentLimitsEditBox(String value)
	{
		inrushCurrentLimit_editbox.click();
		CommonUtils.wait(1);
		inrushCurrentLimit_editbox.clear();
		inrushCurrentLimit_editbox.sendKeys(value);
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			ElementUtils.getElement(LocatorStrategy.NONE, null, LocatorStrategy.IOS_LOCATOR_STRATEGY_ID, "Done", LocatorStrategy.NONE, null).click();
		}
		CommonUtils.wait(1);
	}
	
	public Boolean getEditDipLimitEditBoxValue(String value)
	{
		if (dipLimit_editbox.getText().equals(value))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public Boolean getEditSwellLimitEditBoxValue(String value)
	{
		if (swellLimit_editbox.getText().equals(value))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public Boolean getEditInterruptionLimitEditBoxValue(String value)
	{
		if (interruptionLimit_editbox.getText().equals(value))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public Boolean getEditRapidVoltageChangesLimitEditBoxValue(String value)
	{
		if (rapidVoltageChangesLimit_editbox.getText().equals(value))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public Boolean getEditMainsSignallingVoltagesLimitEditBoxValue(String value)
	{
		if (mainsSignllingVoltagesLimit_editbox.getText().equals(value))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	
	public Boolean getEditWaveformDeviationLimitEditBoxValue(String value)
	{
		if (waveformDeviationLimit_editbox.getText().equals(value))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	
	public Boolean getEditInrushCurrentLimitEditBoxValue(String value)
	{
		if (inrushCurrentLimit_editbox.getText().equals(value))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	
	public void clickOn_TrendIntervalDropdown()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			trendInterval_DemandInterval_Drodpdown.get(0).click();
			CommonUtils.wait(1);
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			trendInterval_DemandInterval_Drodpdown.get(1).click();
			CommonUtils.wait(1);
		}
		
	}
	
	public String clickOn_TrendInterval_listItem()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			String trendInterval_3rdItem =trendInterval_list.get(3).getText();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, trendInterval_3rdItem, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
			return trendInterval_3rdItem;
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			for(int i = 0;i < 2; i++)
			{
				gestureUtils.scrollIOSPickerWheel(PQ_iOS_174X_PickerWheel, ScrollDiection.NEXT);
			}
			
			doneOnPickerWheel.click();
			return trendInterval_DemandInterval_Drodpdown.get(1).getText();
		}
		else
		{
			return null;
		}
		
		
	}
	
	public void clickOn_DemandIntervalDropdown()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			trendInterval_DemandInterval_Drodpdown.get(1).click();
			CommonUtils.wait(1);
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			trendInterval_DemandInterval_Drodpdown.get(3).click();
			CommonUtils.wait(1);
		}
		
	}
	
	public String clickOn_DemandInterval_listItem()
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			String DemandInterval_3rdItem =trendInterval_list.get(3).getText();
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, DemandInterval_3rdItem, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
			CommonUtils.wait(1);
			return DemandInterval_3rdItem;
		}
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			for(int i = 0;i < 2; i++)
			{
				gestureUtils.scrollIOSPickerWheel(PQ_iOS_174X_PickerWheel, ScrollDiection.NEXT);
			}
			
			doneOnPickerWheel.click();
			return trendInterval_DemandInterval_Drodpdown.get(3).getText();
		}
		else
		{
			return null;
		}
		
		
	}
	
	public String clickOn_DemandIntervalLoadStudy_listItem()
	{
		String DemandInterval_1stItem =trendInterval_list.get(0).getText();
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, DemandInterval_1stItem, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		CommonUtils.wait(1);
		return DemandInterval_1stItem;
		
	}
	
	public void selectingParticularWifi(String flukeWIFI)
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			WebElement wifiONOFFButton=ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.android.settings:id/switch_widget", LocatorStrategy.NONE,null,LocatorStrategy.NONE,null);
			if (wifiONOFFButton.getText().equals("OFF"))
			{
				wifiONOFFButton.click();
				CommonUtils.wait(1);
			}
			
			WebElement wiFiName = ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, flukeWIFI, LocatorStrategy.NONE,null,LocatorStrategy.NONE,null);
			wiFiName.click();
			CommonUtils.wait(10);
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, flukeWIFI, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
			if (ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Network speed", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).isDisplayed())
			{
				ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "CANCEL", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
				CommonUtils.wait(1);
			}
		}

		
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			try
			{
				String wifiName =flukeWIFI;
				phoneSettingsPage.openWiFiPageAndTrunOnWiFiIfOff();
				phoneSettingsPage.connectToNetwork(wifiName, "fluketools");
				CommonUtils.wait(5);
				/*
				if(!phoneSettingsPage.isConnectedToNetwork(wifiName))
				{
					phoneSettingsPage.connectToNetwork(wifiName, "fluketools");
				}
				else
				{
					phoneSettingsPage.clickBackButtonToSettingsPage();
				}
				*/
				phoneSettingsPage.clickBackButtonToSettingsPage();
				
				phoneSettingsPage.launchFCApp();
			}
			catch(Exception e)
			{
				Assert.fail("Not able to find tool wifi or did not click on Tool wifi,  Exception Detail: "+e);
			}
			
		}
	}
	
	public void navigateBackToFCAppAfterWifiChange() throws Exception
	{
		/*AndroidUtils.getAndroidDriver().launchApp();
		serviceHatchPage = new ServiceHatchPage();
		signInPage = new SignInPage();
		switcher = new Switcher();
		homePage = new HomePage();
		signInPage.handleBeforeSignInAlerts();
		serviceHatchPage.changeEnvironment("PreProduction");
		signInPage.signIn();
		signInPage.handleAfterSignInAlerts();
		CommonUtils.wait(1);
		if(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Upgrade Fluke Connect", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).isDisplayed())
		{
			ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "NOT NOW", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
		}*/
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			AndroidUtils.back();
			CommonUtils.wait(1);
		}
		
		//homePage.isNotificationIconIsDisplayed();
		
	}
	
	public void selectToolWifi(String pqTool, String ssid174X) throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{	
			WebElement wifiONOFFButton=ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.android.settings:id/switch_widget", LocatorStrategy.NONE,null,LocatorStrategy.NONE,null);
			if (wifiONOFFButton.getText().equals("OFF"))
			{
				wifiONOFFButton.click();
				CommonUtils.wait(5);
			}
			
			String wifiName =pqTool+"<"+ssid174X+">";
			CommonUtils.wait(2);
			try
			{
				if(DriverManager.getDriverName().equals("Android"))
				{
					ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, wifiName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
					CommonUtils.wait(10);
					ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, wifiName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
					if (ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Network speed", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).isDisplayed())
					{
						ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "CANCEL", LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, null, LocatorStrategy.NONE, null).click();
						CommonUtils.wait(1);
					}
					AndroidUtils.back();
				}
			}
			catch(Exception e)
			{
				Assert.fail("Not able to find tool wifi or did not click on Tool wifi,  Exception Detail: "+e);
			}
		}
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			try
			{
				String wifiName =pqTool+"<"+ssid174X+">";
				phoneSettingsPage.openWiFiPageAndTrunOnWiFiIfOff();
				//phoneSettingsPage.connectToNetwork(wifiName, "fluketools");
				//CommonUtils.wait(5);  //wait for networks to appear
				Config.isDynamicPage = true;
				gestureUtils.mScroll(wifiName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, ScrollDiection.DOWN);
				ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, wifiName, LocatorStrategy.IOS_LOCATOR_STRATEGY_VALUE, wifiName, LocatorStrategy.NONE, null).click();
				CommonUtils.wait(5);
				/*
				if(!phoneSettingsPage.isConnectedToNetwork(wifiName))
				{
					phoneSettingsPage.connectToNetwork(wifiName, "fluketools");
				}
				else
				{
					phoneSettingsPage.clickBackButtonToSettingsPage();
				}
				*/
				phoneSettingsPage.clickBackButtonToSettingsPage();
				
				phoneSettingsPage.launchFCApp();
				clickOnSetupLoggingOrMonitoringLink();
				clickOnThreePhasePowerMonitorLink();
				clickOnpowerQualityLogger();
			}
			catch(Exception e)
			{
				phoneSettingsPage.clickBackButtonToSettingsPage();
				
				phoneSettingsPage.launchFCApp();
				clickOnSetupLoggingOrMonitoringLink();
				clickOnThreePhasePowerMonitorLink();
				clickOnpowerQualityLogger();
			}
			
		}
		
	}
	
	public Boolean waitTillLoginAuthenticationIsVisible()
	{
		if (ElementUtils.isDisplayed(20, 3, monitorAuthenticationTitle))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void enterUserNameAndPasswordInLoginAuthentication()
	{
		if (waitTillLoginAuthenticationIsVisible())
		{
			enterUserNameInMonitorAuthenticationPageText("admin");
			enterPasswordInMonitorAuthenticationPageText("admin");
			clickOnContinueInMonitorAuthenticationPageText();
			CommonUtils.wait(5);
		}
		
		
	}
	
	public Boolean verifyLoginAuthenticationIsVisible()
	{
		if (ElementUtils.isDisplayed(120, 3, monitorAuthenticationTitle))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public String getRandomText() {
        // cryptographically strong random number generator
        SecureRandom random = new SecureRandom();
 
        // randomly generated BigInteger
        BigInteger bigInteger = new BigInteger(max_Bit_Length, random);
 
        // String representation of this BigInteger in the given radix.
        String randomText = bigInteger.toString(radix);
         
        return randomText;
    }
	
	public void goBackTillHomeScreen()
	{
		
		while(isWebElementDisplayed(setupLoggingOrMonitoringLink) == false)
		{
			clickOnBackButton();
		}
		
	}
	
	public Boolean isWebElementDisplayed(WebElement element)
	{
		try
		{
			return element.isDisplayed();
		}
		catch(Throwable e)
		{
			return false;
		}
	}
	
	
	public Boolean searchWithTextContains(String elementText)
	{
		try
		{
			CommonUtils.wait(2);
			if(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, elementText, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, elementText, LocatorStrategy.NONE, null).isDisplayed())
			{
				return true;
			}
			else
			{
				return false; 
			}
		}
		catch(Exception e)
		{
			return true;
		}
		
	}
	
	public Boolean searchUsingName(String elementText)
	{
		CommonUtils.wait(2);
		if(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, elementText, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, elementText, LocatorStrategy.NONE, null).isDisplayed())
		{
			return true;
		}
		else
		{
			return false; 
		}
	}
	
	public Boolean searchForValue(String configChar,String elementText)
	{
		CommonUtils.wait(2);
		String abc ="(//XCUIElementTypeStaticText[@name=\""+configChar+"\""+"]/following-sibling::XCUIElementTypeStaticText)";
		String elementValue =ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, elementText, LocatorStrategy.IOS_LOCATOR_STRATEGY_XPATH, abc, LocatorStrategy.NONE, null).getText();
		if(elementValue.equals(elementText))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public Boolean searchForValue(String elementText)
	{
		CommonUtils.wait(2);
		String abc ="(//XCUIElementTypeStaticText[@name=\""+elementText+"\""+"])";
		String elementValue =ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, elementText, LocatorStrategy.IOS_LOCATOR_STRATEGY_XPATH, abc, LocatorStrategy.NONE, null).getText();
		if(elementValue.equals(elementText))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public Boolean searchTextNOTPresent(String elementText)
	{
		CommonUtils.wait(2);
		try
		{
			if(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, elementText, LocatorStrategy.IOS_LOCATOR_STRATEGY_NAME_CONTAINS, elementText, LocatorStrategy.NONE, null).isDisplayed())
			{
				return false;
			}
			else
			{
				return true; 
			}
		}
		catch(Exception e)
		{
			return true;
		}
		
	}
	
	public void clickOnAndroidDoneButton_OnAndroidNumericPad()
    {
         if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
            {
            // WebElement  element = ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_ID, "com.fluke.deviceApp:id/fake_action_bar", null, null, null , null);
             int x= DriverManager.getDriver().manage().window().getSize().getWidth();
             int y= DriverManager.getDriver().manage().window().getSize().getHeight();
             int samsungS6X=600;
             int samsungNote5=470;
             if(DriverManager.getDeviceName().equals("SM-N9208"))
                     gestureUtils.clickOnCordinates(x-150, y-samsungNote5);
             else if(DriverManager.getDeviceName().equals("SM-G920I"))
                  gestureUtils.clickOnCordinates(x-150, y-samsungS6X);
            }
    }
	
	
}
