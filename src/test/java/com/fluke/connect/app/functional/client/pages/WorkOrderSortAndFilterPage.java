package com.fluke.connect.app.functional.client.pages;

import org.openqa.selenium.WebElement;

import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.VisualUtils;

import io.appium.java_client.pagefactory.iOSFindBy;

public class WorkOrderSortAndFilterPage 
{
	@iOSFindBy(accessibility = "Status")
	private WebElement filterStatusButton;
	
	public WorkOrderSortAndFilterPage()
	{
		CommonUtils.initElements(this);
	}
	
	public void clickOnFilterStatusButton()
	{
		filterStatusButton.click();
	}
	
	public void saveScreenshot(String locationWithName)
	{
		VisualUtils.saveScreenshot(locationWithName);
	}

}
