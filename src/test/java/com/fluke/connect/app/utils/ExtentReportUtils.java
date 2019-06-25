package com.fluke.connect.app.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportUtils 
{   
    private ExtentReports extentReport;
	
	public ExtentReports getInstance(String fileName, boolean appendTestResults) 
    {
    		if (extentReport != null)
		extentReport = createInstance(fileName, appendTestResults);
		return extentReport;
    }
    
    public ExtentReports createInstance(String fileName, boolean appendTestResults) 
    {
    	 	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(fileName); 
        htmlReporter.setAppendExisting(appendTestResults);
        extentReport = new ExtentReports();
        extentReport.attachReporter(htmlReporter); 
        return extentReport;
    }
    
    public static void assignCategory(String categoryName)
    {
    		DriverManager.getExtentTest().assignCategory(categoryName);
    }
    
    public static void testStepDetails(String testStepDetails)
    {
    		DriverManager.getExtentTest().log(Status.INFO, testStepDetails);
    }

}
