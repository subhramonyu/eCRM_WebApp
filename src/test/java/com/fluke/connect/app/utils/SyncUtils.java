package com.fluke.connect.app.utils;

import org.openqa.selenium.WebElement;

public class SyncUtils 
{
	public static boolean isSynced(WebElement elementToBeClicked, WebElement backButton, String stringToBeSearched, int waitTime, int retryCount) throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			boolean retryFlag = true;
			int retryCounter = 0;
			while(retryFlag)
			{
				CommonUtils.wait(waitTime);
				if(DriverManager.getDriver().getPageSource().contains(stringToBeSearched))
					return true;
				else
				{
					backButton.click();
					CommonUtils.wait(waitTime);
					elementToBeClicked.click();
					retryCounter++;
				}
				if(retryCounter == retryCount)
					retryFlag = false;
			}
		}
		return false;
	}
	
}
