package com.fluke.connect.app.functional.client.pages;

import java.time.temporal.ChronoUnit;
import org.openqa.selenium.WebElement;

import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Gestures;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSFindBy;


public class Thermography3550CompletedSessionPage {
	
	@WithTimeout(time = 20, chronoUnit = ChronoUnit.SECONDS)
	@iOSFindBy(accessibility="backBarButton")
	@AndroidFindBy(id="com.fluke.deviceApp:id/action_bar_item_left")
	public static WebElement backButton;
	
	@AndroidFindBy(id = "com.fluke.deviceApp:id/value_live")
	private WebElement liveValue;
	
	@AndroidFindBy(id = "com.fluke.deviceApp:id/value_max")
	private WebElement maxValue;
	
	@AndroidFindBy(id = "com.fluke.deviceApp:id/value_min")
	private WebElement minValue;
	
private Gestures gesture;
	
	public Thermography3550CompletedSessionPage()
	{
		CommonUtils.initElements(this);
		gesture = new Gestures();
	}
	
	public boolean Thermography_1HTab() 
	{
		gesture.scroll(null, null, null, "1M",-45, -60, null, null);
		CommonUtils.getElementByUsingVisibleText("1H").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		return staleDataCheck();
	}
	
	public boolean Thermography_1DTab() 
	{
		gesture.scroll(null, null, null, "1M",-45, -60, null, null);
		CommonUtils.getElementByUsingVisibleText("1D").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		return staleDataCheck();
	}
	
	public boolean Thermography_1WTab() 
	{
		gesture.scroll(null, null, null, "1M",-45, -60, null, null);
		CommonUtils.getElementByUsingVisibleText("1W").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		return staleDataCheck();
	}
	
	public boolean Thermography_1MTab() 
	{
		gesture.scroll(null, null, null, "1M",-45, -60, null, null);
		CommonUtils.getElementByUsingVisibleText("1M").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		return staleDataCheck();
	}
	
	public boolean Thermography_AllTab() 
	{
		gesture.scroll(null, null, null, "1M",-45, -60, null, null);
		CommonUtils.getElementByUsingVisibleText("All").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		return staleDataCheck();
	}
	
	
	public boolean staleDataCheck()
	{
		boolean returnFlag = false;
		
			if(liveValue.getText().equals("----") || maxValue.getText().equals("----") || minValue.getText().equals("----"))
			{
				returnFlag = false;
			}
			else
			{
				returnFlag = true;
			}
		

		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,1000, null, null);
		CommonUtils.wait(1);
		return returnFlag;	
	}

}
