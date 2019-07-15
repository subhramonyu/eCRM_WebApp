package com.eCRM.client.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.TestResult;
import org.testng.internal.annotations.TestAnnotation;

public class TestListener implements ITestListener
{
	TestResult testResult;
	TestAnnotation testAnnotation;
	
	
	public TestListener()
	{
		testResult = new TestResult();
		testAnnotation = new TestAnnotation();
	}

	public void onTestStart(ITestResult result)
	{	}

	public void onTestSuccess(ITestResult result) 
	{ 	}

	public void onTestFailure(ITestResult result) 
	{ 
		VisualUtils.saveScreenshot(Config.FAILED_TESTS_SCREENSHOT_LOCATION+
	    result.getMethod().getMethodName()+"_"+DateAndTimeUtils.getCurrentTimeStamp()+".png");
	}

	public void onTestSkipped(ITestResult result)
	{  }

	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{   }

	public void onStart(ITestContext context) 
	{   }
	
	public void onFinish(ITestContext context) 
	{   }
}
