package com.fluke.connect.app.functional.client.pages;

import org.openqa.selenium.WebElement;

import com.fluke.connect.app.utils.CommonUtils;

import io.appium.java_client.pagefactory.iOSFindBy;

public class ResouceCenterPage 
{
	@iOSFindBy(accessibility="Resource Center List")
	
	
	private WebElement resourceCenterVisualElement;
	
	public ResouceCenterPage()
	{
		CommonUtils.initElements(this);
	}
	
	public WebElement getResourceCenterVisualElement()
	{
		return resourceCenterVisualElement;
	}
	
	
	

}
