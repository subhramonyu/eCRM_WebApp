package com.eCRM.client.core;

import com.eCRM.client.core.Config.ScrollDiection;

public class WebUtils 
{
	private static int scrollDownSteps = DriverManager.getDriver().manage().window().getSize().height;
	private static int scrollUpSteps = - DriverManager.getDriver().manage().window().getSize().height;
	
	public static int getScrollSteps(ScrollDiection scrollDirection)
	{
		if(scrollDirection == ScrollDiection.DOWN)
			return scrollDownSteps;
		else if(scrollDirection == ScrollDiection.UP)
			return scrollUpSteps;
		return 0;
	}

}
