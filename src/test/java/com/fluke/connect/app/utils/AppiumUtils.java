package com.fluke.connect.app.utils;

public class AppiumUtils 
{

	public static void startAppiumServer()
	{
		CommonUtils.wait(4);
		CommonUtils.executeCommandOnTerminal("appium");
		CommonUtils.wait(4);
	}

	public static void stopAppiumServer()
	{
		CommonUtils.wait(4);
		CommonUtils.executeCommandOnTerminal("pkill -2 simctl");
		CommonUtils.wait(4);
	}

}
