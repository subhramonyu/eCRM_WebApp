package com.fluke.connect.app.functional.client.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fluke.connect.app.functional.client.pages.EventLogging3540Page;
import com.fluke.connect.app.functional.client.pages.Switcher;
import com.fluke.connect.app.testdata.FCCM3540;

public class EventLogging3540test {
	
	private Switcher switcher;
	private EventLogging3540Page EventLogging3540;
	
	@BeforeClass(alwaysRun = true, groups = {FCCM3540.EVENT_LOGGING_TESTS})
	public void initClass() throws Exception
	{
		EventLogging3540 = new EventLogging3540Page();
		switcher = new Switcher();
		switcher.switchToHomePage();
	
	}

	@Parameters({"isActiveSession", "sessionStartTime", "ssid3540"})
	@Test(alwaysRun = true, priority = 116001, groups = {FCCM3540.EVENT_LOGGING_TESTS})
	public void downloadEventLoggingSessionTest(@Optional("true") Boolean isActiveSession, @Optional("null") String sessionStartTime, @Optional("null") String ssid3540)
	{
		try 
		{
			Assert.assertTrue(EventLogging3540.downloadLoggingSession(isActiveSession, sessionStartTime, ssid3540));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
	@Parameters({"isActiveSession", "sessionStartTime", "ssid3540"})
	@Test(alwaysRun = true, priority = 116002, groups = {FCCM3540.EVENT_LOGGING_TESTS})
	public void deleteDownloadedSessionTest(@Optional("true") Boolean isActiveSession, @Optional("null") String sessionStartTime, @Optional("null") String ssid3540)
	{
		try 
		{
			
			Assert.assertTrue(EventLogging3540.deleteDownloadedSession(isActiveSession, sessionStartTime, ssid3540));
		}
		catch(Throwable e)
		{
			Assert.fail("Exception Detail: "+e);
		}
	}
	
}
