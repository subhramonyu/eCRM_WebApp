package com.fluke.connect.app.functional.client.pages;

import java.time.temporal.ChronoUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.Gestures;
import com.fluke.connect.app.utils.VisualUtils;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomePage 
{
	@AndroidFindBy(id = "capture_measurements")
	@iOSFindBy(accessibility="Capture Measurements")
	private WebElement captureMeasurementsButton;
	
	@AndroidFindBy(id = "setup_logging_monitoring_text")
	@iOSXCUITFindBy(accessibility="Set Up Logging Or Monitoring")
	private WebElement setUpLoggingOrMonitoringButton;
	
	@iOSFindBy(accessibility="MyWorkOrderCell")
	private WebElement myWorkOrderButton;
	
	@iOSFindBy(accessibility="Home")
	private WebElement homeStaticText;
	
	@HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
	@FindBy(how = How.CSS, using = "a[href='/remote-monitoring']")
	@AndroidFindBy(id = "view_active_sessions")
	@iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH 'View Active Monitoring Sessions'")
	@iOSXCUITFindBy(iOSNsPredicate = "name CONTAINS 'Active'")
	private WebElement viewActiveMonitoringSessionsButton;
	
	@FindBy(how = How.CSS, using = "#user_notification")
	@AndroidFindBy(id = "notification_count")
	@iOSXCUITFindBy(accessibility = "AlarmBadgeCount")
	private WebElement notificationButton;
	
	@AndroidFindBy(id = "gateway_sensors_layout")
	@iOSXCUITFindBy(accessibility = "Gateway & Sensors")
	private WebElement vatgButton;
	
	@AndroidFindBy(id = "three_phase_power_monitor_layout")
	@iOSXCUITFindBy(accessibility = "3-Phase Power Monitor")
	private WebElement threePhasePowerMonitiorButton;
	
	@AndroidFindBy(id = "fc3560_select_layout")
	@iOSXCUITFindBy(accessibility = "Vibration Sensors")
	private WebElement vibrationSensorsButton;
	
	@AndroidFindBy(id = "fc_tools_layout")
	@iOSXCUITFindBy(accessibility = "Thermal Imaging Sensors")
	private WebElement thermalImagingSensorsButton;
	
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Start Time\")")
	@iOSXCUITFindBy(accessibility = "Start Time")
	private WebElement startTimeText;
	
	private Gestures gesture;
	private boolean notificationIconCheckFlag = true;
	private boolean isNotificationIconDisplayed;
	
	public HomePage()
	{
		CommonUtils.initElements(this);
		gesture = new Gestures();
	}
	
	public void clickCaptureMeasurementsButton()
	{
		captureMeasurementsButton.click();
	}
	
	public void clickOnMyWorkOrderButton()
	{
		myWorkOrderButton.click();
	}
	
	public void saveScreenshot(String locationWithName)
	{
		VisualUtils.saveScreenshot(locationWithName);
	}
	
	public boolean isSignInSuccessful()
	{
		return CommonUtils.isElementDisplayedWithinFluentWait(60, 1, homeStaticText);
	}
	
	public void captureMyWorkOrderCellScreenshot(String locationWithName)
	{
		VisualUtils.saveElementScreenshot(captureMeasurementsButton, locationWithName);
	}
	
	public void clickOnViewActiveMonitoringSessionButton() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			if(viewActiveMonitoringSessionsButton.isDisplayed() && viewActiveMonitoringSessionsButton.isEnabled())
			{
				CommonUtils.reliableClick(viewActiveMonitoringSessionsButton, startTimeText, 5);
			}
			else if(viewActiveMonitoringSessionsButton.isDisplayed() && !viewActiveMonitoringSessionsButton.isEnabled())
			{
				if(CommonUtils.isElementEnabledWithinFluentWait(15, 1, viewActiveMonitoringSessionsButton))
				{
					CommonUtils.reliableClick(viewActiveMonitoringSessionsButton, startTimeText, 5);
				}
			}
			else if(!viewActiveMonitoringSessionsButton.isDisplayed() && viewActiveMonitoringSessionsButton.isEnabled())
			{
				if(gesture.mobileScrollFlexible("name", "BEGINSWITH", "View Active Monitoring Sessions", "View Active Monitoring Sessions", -300, -45))
				{
					CommonUtils.reliableClick(viewActiveMonitoringSessionsButton, startTimeText, 5);
				}
			}	
			else
			{
				if(gesture.mobileScrollFlexible("name", "BEGINSWITH", "View Active Monitoring Sessions", "View Active Monitoring Sessions", -300, -45))
				{
					if(CommonUtils.isElementEnabledWithinFluentWait(15, 1, viewActiveMonitoringSessionsButton))
					{
						CommonUtils.reliableClick(viewActiveMonitoringSessionsButton, startTimeText, 5);
					}
				}
			}
		}
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			CommonUtils.ifElementDisplayedWithinFluentWaitThenClick(60, 1, viewActiveMonitoringSessionsButton);
		}
	}
	
	public boolean isNotificationIconIsDisplayed()
	{
		if(notificationIconCheckFlag)
		{
			notificationIconCheckFlag = false;
			isNotificationIconDisplayed = ElementUtils.isDisplayed(120, 1, notificationButton);
			return isNotificationIconDisplayed;
		}
		else
		{
			return isNotificationIconDisplayed;
		}
		
	}
	
	public void clickOnSetupLoggingAndMonitoring() 
	{
		setUpLoggingOrMonitoringButton.click();
	}
	
	public void selectConditionMonitoringTool(String iOSObjectName, String toolName, int iOSScrollSteps, int androidScrollSteps) throws Exception
	{
		ElementUtils.clickIfDisplayedAndEnabled(setUpLoggingOrMonitoringButton);
		switch(toolName)
		{
		case "vatg":
			CommonUtils.ifElementIsDisplayedThenTap(vatgButton);
			break;
		case "3540":
			CommonUtils.ifElementIsDisplayedThenTap(threePhasePowerMonitiorButton);
			break;
		case "nocturne":
			CommonUtils.ifElementIsDisplayedThenTap(vibrationSensorsButton);
			break;
		case "nightcrawler":
			CommonUtils.ifElementIsDisplayedThenTap(thermalImagingSensorsButton);
			break;
		}
	}
	
	public void tapOnNotificationIcon() 
	{
		try 
		{
			ElementUtils.clickIfDisplayedAndEnabled(notificationButton);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
}
