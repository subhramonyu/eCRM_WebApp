package com.fluke.connect.app.functional.client.pages;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;
import java.time.temporal.ChronoUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Switcher 
{
	@FindBy(how = How.CSS, using = "img#header-logo-new")
	@AndroidFindBy(id="menu_button")
	@iOSFindBy(accessibility="Switcher")
	private WebElement switcherButton;
	
	@AndroidFindBy(id = "com.fluke.deviceApp:id/username")
	@iOSXCUITFindBy(iOSNsPredicate = "name CONTAINS 'User'") //This will work only for new user
	private WebElement userName;
	
	@FindBy(how = How.CSS, using = "a[data-event='click:logout']")
	@AndroidFindBy(id = "com.fluke.deviceApp:id/signout")
	@iOSXCUITFindBy(iOSNsPredicate = "name == 'sign out' OR name == 'Sign Out'")   
	private WebElement signOutButton;
	
	@WithTimeout(time=4, chronoUnit = ChronoUnit.SECONDS)
	@AndroidFindBy(id = "android:id/button1")  //   com.fluke.deviceApp:id/dialog_ok
	@iOSFindBy(accessibility="Sign out")
	private WebElement alertSignOutButton;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/capture")
	@iOSFindBy(accessibility="Capture")
	private WebElement captureButton;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/capture_measurements")
	@iOSFindBy(accessibility="Capture Measurements")
	private WebElement captureMeasurementsHomeScreenButton;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/home")
	@iOSFindBy(accessibility="Home")
	@FindBy(how=How.CSS,using="img#header-logo-new")
	private WebElement homeButton;
	
	@FindBy(how = How.CSS, using = "div[data-feature-desc='Measurements']")
	@AndroidFindBy(id="com.fluke.deviceApp:id/history")
	@iOSFindBy(accessibility="Measurements Screen")
	private WebElement measurementsButton;
	
	@FindBy(how=How.CSS,using="[data-page=\"equipment\"]")
	@AndroidFindBy(id="com.fluke.deviceApp:id/equipment")
	@iOSFindBy(accessibility="Equipments")
	private WebElement assetsButton;
	
	@HowToUseLocators(iOSAutomation = ALL_POSSIBLE)
	@iOSXCUITFindBy(iOSNsPredicate = "name == 'Work orders' OR name == 'Work Orders'")   
	@AndroidFindBy(id="com.fluke.deviceApp:id/workOrderView")
	@FindBy(how=How.CSS,using = "div[data-page='work_orders']")
	private WebElement workOrdersButton;
	
	@FindBy(how = How.CSS, using = ".store-header-tabs [data-feature-desc='Team']")
	@AndroidFindBy(id="com.fluke.deviceApp:id/team")
	@iOSFindBy(accessibility="Team")
	private WebElement teamButton;
	
	@FindBy(how = How.CSS, using = "div[data-feature-desc='Reports']")
	@AndroidFindBy(id="com.fluke.deviceApp:id/reports")
	@iOSFindBy(accessibility="Reports")
	private WebElement reportsButton;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/help")
	@iOSFindBy(accessibility="ResourceCenter")
	private WebElement resourceCenterButton;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/settings")
	@iOSFindBy(accessibility="Settings")
	private WebElement settingsButton;
	
	@WithTimeout(time = 3, chronoUnit = ChronoUnit.SECONDS)
	@AndroidFindBy(id = "com.fluke.deviceApp:id/dialog_ok")
	@iOSXCUITFindBy(iOSNsPredicate = "name LIKE 'Sign out' OR 'name LIKE 'Sign Out'")
	private WebElement forceSignOutButton;
	
	//For web app Measurements tab would serve as back button
	@FindBy(how = How.CSS, using = "div[data-feature-desc='Measurements']")
	@AndroidFindBy(id="action_bar_item_left")
	@iOSFindBy(accessibility="Back")
	private WebElement backButton;
	
	@FindBy(how = How.CSS, using = "#user-login-actions")
	private WebElement userOptions;
	
	@WithTimeout(time = 3, chronoUnit = ChronoUnit.SECONDS)
	@AndroidFindBy(id = "user_name_text")
	@iOSXCUITFindBy(accessibility = "Edit")
	private WebElement userNameTextField;
	
	public final static String BACK_BUTTON = "back_button";
	public final static String COMPLETED_SESSION = "completed_session";
	public final static String ACTIVE_SESSION = "active_session";
	private MeasurementsHistoryPage measurementsHistoryPage;
	
	public Switcher()
	{
		CommonUtils.initElements(this, 10);
		measurementsHistoryPage = new MeasurementsHistoryPage();
	}
	
	public void clickSwitcher() throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			ElementUtils.click(3, switcherButton);
	}
	
	public void switchToUserDetailsPage() throws Exception
	{
		clickSwitcher();
		ElementUtils.reliableClick(1, userName, userNameTextField, 4);
	}
	
	public void signOut() throws Exception
	{
		clickSwitcher();
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			userOptions.click();
		signOutButton.click();
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
		{
			ElementUtils.safeClick(alertSignOutButton);
			ElementUtils.safeClick(forceSignOutButton);
		}
		
	}
	
	public void switchToHomePage() throws Exception
	{
		clickSwitcher();
		homeButton.click();
	}
	
	public void switchToCaptureMeasurementsPage()
	{
		try
		{
			clickSwitcher();
			homeButton.click();
			captureMeasurementsHomeScreenButton.click();
		}
		catch(Exception e)
		{
			captureButton.click();
		}
	}
	
	public void switchToCaptureMeasurementsHomePage()
	{
		try
		{
			switchToHomePage();
			ElementUtils.clickIfDisplayedAndEnabled(captureMeasurementsHomeScreenButton);
		}
		catch(Exception e)
		{
				captureButton.click();
		}
	}
	
	public void switchToCaptureMeasurementsPageHome()
	{
		try
		{
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				ElementUtils.click(3, captureMeasurementsHomeScreenButton);
		}
		catch(Exception e)
		{
				captureButton.click();
		}
	}
	
	public void switchToMeasurementsPage() throws Exception
	{
		clickSwitcher();
		ElementUtils.click(3, measurementsButton);
	}
	
    public void switchToAssetsPage() throws Exception
	{
    	CommonUtils.wait(1,1,2);
    		clickSwitcher();
	 	assetsButton.click();
	 	CommonUtils.wait(1,1,4);
	}
    
	public void switchToWorkOrdersPage() throws Exception
	{

		if((DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)))
		{
			switcherButton.click();
			ElementUtils.clickIfDisplayedAndEnabled(workOrdersButton);	
		}
		
		/***** explicit wait added for web as work order tab loads slow ********/
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			clickSwitcher();
			ElementUtils.click(5,workOrdersButton);
		}
	}

	public void switchToTeamPage() throws Exception
	{
		clickSwitcher();
		ElementUtils.click(6, teamButton);	
	}
	
	public void switchToResourceCenterPage()
	{
		switcherButton.click();
		resourceCenterButton.click();
	}
	
	public void switchToReportsPage() throws Exception
	{
		clickSwitcher();
		ElementUtils.click(2, reportsButton);
	}
	
	public void switchToSettingsPage()
	{
		switcherButton.click();
		settingsButton.click();
	}
	
	public boolean isForceSignOutRequired()
	{
		try
		{
			return forceSignOutButton.isDisplayed();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public void clickforceSignoutButton()
	{
		forceSignOutButton.click();
	}
	
	public void clickBackButton() throws Exception
	{
		ElementUtils.clickIfDisplayedAndEnabled(backButton);
	}
	
	public WebElement getElement(String name)
	{
		switch(name)
		{
		case "back_button":
			return backButton;
		default:
			return null;
		}
	}
	
	public void switchToSession(String sessionType) throws Exception
	{
		switchToMeasurementsPage();
		if(sessionType.equals(ACTIVE_SESSION))
			measurementsHistoryPage.clickOnViewActiveMonitoringSessionsLink();
		else
			measurementsHistoryPage.clickOnViewCompletedSessionsLink();
	}
	
	public void switchToOtherTab(String currentWindowHandle)
	{
		for(Object windowHandle: DriverManager.getDriver().getWindowHandles().toArray())
		{
			if(!currentWindowHandle.equals(windowHandle.toString()))
				DriverManager.getDriver().switchTo().window(windowHandle.toString());
				
		}
	}
}
