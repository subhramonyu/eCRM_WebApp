package com.fluke.connect.app.functional.client.pages;

import java.time.temporal.ChronoUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SessionDetailPage3550 extends SessionDetailPage
{
	@FindBy(how = How.CSS, using = ".sessionMaxValue")
	@AndroidFindBy(id = "value_max") 
	@iOSXCUITFindBy(accessibility = "Max Value")
	private WebElement maxValue;
	
	@AndroidFindBy(id = "unit_max") 
	private WebElement maxValueUnit;
	
	@FindBy(how = How.CSS, using = ".sessionMinValue")
	@AndroidFindBy(id = "value_min") 
	@iOSXCUITFindBy(accessibility = "Min Value")
	private WebElement minValue;
	
	@AndroidFindBy(id = "unit_min") 
	private WebElement minValueUnit;
	
	@FindBy(how = How.CSS, using = ".sessionMaxValueTime")
	@AndroidFindBy(id = "max_time") 
	@iOSXCUITFindBy(accessibility = "Max Value Time Stamp")
	private WebElement maxValueTime;
	
	@FindBy(how = How.CSS, using = ".sessionMinValueTime")
	@AndroidFindBy(id = "min_time") 
	@iOSXCUITFindBy(accessibility = "Min Value Time Stamp")
	private WebElement minValueTime;
	
	@FindBy(how = How.CSS, using = ".sessionMaxParamValue")
	@AndroidFindBy(id = "value_live") 
	private WebElement liveValue;
	
	@AndroidFindBy(id = "unit_live") 
	private WebElement liveValueUnit;
	
	@HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
	@FindBy(how = How.CSS, using = ".graphFilterValueUnit")
	@AndroidFindBy(id = "test_point_unit")
	@iOSXCUITFindBy(accessibility = "°C")
	@iOSXCUITFindBy(accessibility = "°F")
	private WebElement tempratureUnitText;
	
	@WithTimeout(time = 2, chronoUnit = ChronoUnit.SECONDS)
	@FindBy(how = How.CSS, using = ".image-not-available1")  //.image-not-available2
	private WebElement mainImage;
	
	@WithTimeout(time = 2, chronoUnit = ChronoUnit.SECONDS)
	@FindBy(how = How.CSS, using = ".image-not-available2")
	private WebElement sliderImage;
	
	@FindBy(how = How.CSS, using = ".remoteMonitoringTotalAlarmCount")
	private WebElement sessionAlarmIcon;
	
	@FindBy(how = How.CSS, using = ".sessionGraphTotalAlarmCount")
	private WebElement sensorAlarmIcon;
		
	private boolean graphDisplayedFlag;
	
	public SessionDetailPage3550()
	{
		CommonUtils.initElements(this, 5);
	}
	
	public enum SessionDetailPage3550ObjectList
	{
		TEMPRATURE_UNIT, MAX_VALUE, MIN_VALUE, MAX_VALUE_TIME, MIN_VALUE_TIME, LIVE_VALUE, LIVE_VALUE_UNIT,
		MAX_VALUE_UNIT, MIN_VALUE_UNIT, MAIN_IMAGE, SLIDER_IMAGE, FCCM3550_SESSION_ALARM_ICON, FCCM3550_SENSOR_ALARM_ICON, 
	}
	
	public WebElement getSessionDetailPage3550Object(SessionDetailPage3550ObjectList objectName)
	{
		switch(objectName)
		{
		case TEMPRATURE_UNIT:
			return tempratureUnitText;
		case LIVE_VALUE:
			return liveValue;
		case LIVE_VALUE_UNIT:
			return liveValueUnit;
		case MAX_VALUE:
			return maxValue;
		case MAX_VALUE_UNIT:
			return maxValueUnit;
		case MIN_VALUE:
			return minValue;
		case MIN_VALUE_UNIT:
			return minValueUnit;
		case MAX_VALUE_TIME:
			return maxValueTime;
		case MIN_VALUE_TIME:
			return minValueTime;
		case MAIN_IMAGE:
			return mainImage;
		case SLIDER_IMAGE:
			return sliderImage;
		case FCCM3550_SESSION_ALARM_ICON:
			return sessionAlarmIcon;
		case FCCM3550_SENSOR_ALARM_ICON:
			return sensorAlarmIcon;
		default:
				return null;
		}
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
	
}
