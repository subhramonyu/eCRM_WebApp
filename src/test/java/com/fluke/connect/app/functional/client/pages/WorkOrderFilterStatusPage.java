package com.fluke.connect.app.functional.client.pages;

import org.openqa.selenium.WebElement;

import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.VisualUtils;

import io.appium.java_client.pagefactory.iOSFindBy;

public class WorkOrderFilterStatusPage 
{
	@iOSFindBy(accessibility="backBarButton")
	private WebElement backButton;
	
	public WorkOrderFilterStatusPage()
	{
		CommonUtils.initElements(this);
	}
	
	public void clickBackButton()
	{
		backButton.click();
	}
	
	public void saveScreenshot(String locationWithName)
	{
		VisualUtils.saveScreenshot(locationWithName);
	}

}
