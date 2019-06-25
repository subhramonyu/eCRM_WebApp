package com.fluke.connect.app.utils;

import org.testng.ITestResult;

@SuppressWarnings("unused")
public class TestNGUtils 
{
	private static int testMethodPriority;

	public static void setTestMethodPriority(int priority)
	{
		TestNGUtils.testMethodPriority = priority;
	}

	public static String getTestMethodName(ITestResult result)
	{
		return result.getMethod().getMethodName();
	}

	public static int getTestMethodPriority()
	{
		return testMethodPriority;
	}

	public static int getTestExecutionPriority(int priority)
	{
		return priority;
	}
}
