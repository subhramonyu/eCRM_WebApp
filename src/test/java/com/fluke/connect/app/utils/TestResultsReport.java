

package com.fluke.connect.app.utils;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.MediaEntityBuilder;

public class TestResultsReport implements ITestListener
{
	StringBuilder screenshotLocation = new StringBuilder();
	
	public synchronized void onStart(ITestContext context) 
	{ 	}

	public synchronized void onFinish(ITestContext context) 
	{
		//DriverManager.getExtentReport().flush();
	}
	
	public synchronized void onTestStart(ITestResult result) 
	{
		//DriverManager.setExtentTest(DriverManager.getExtentReport().createTest(result.getMethod().getMethodName()).assignCategory(result.getTestClass().getRealClass().getSimpleName()));
	}

	public synchronized void onTestSuccess(ITestResult result) 
	{
		try 
		{
			//DriverManager.getExtentTest().pass("Test passed");
		} 
		catch (Exception e) 
		{
			//e.printStackTrace();
		}
	}

	public synchronized void onTestFailure(ITestResult result) 
	{
		try 
		{
			/*screenshotLocation.setLength(0);
			screenshotLocation.append(Config.FAILED_TESTS_SCREENSHOT_LOCATION+result.getMethod().getMethodName()+"_"+DateAndTimeUtils.getCurrentTimeStamp()+".png");
			VisualUtils.saveScreenshot(screenshotLocation.toString()); */
			//DriverManager.getExtentTest().fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotLocation.toString()).build());
		} 
		catch (Exception e) 
		{
			//e.printStackTrace();
		}
	}

	public synchronized void onTestSkipped(ITestResult result) 
	{
		//DriverManager.getExtentTest().skip(result.getThrowable());
	}

	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
	}

}



