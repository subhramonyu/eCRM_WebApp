package com.eCRM.client.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.eCRM.client.pages.LogInPage;

public class DriverManager {
	private static ThreadLocal<EventFiringWebDriver> driver = new ThreadLocal<EventFiringWebDriver>();
	private static ThreadLocal<String> browserName = new ThreadLocal<String>();
	private static ThreadLocal<String> environmentName = new ThreadLocal<String>();
	private static ThreadLocal<String> userName = new ThreadLocal<String>();
	private static ThreadLocal<String> password = new ThreadLocal<String>();
	private static ThreadLocal<Log> log = new ThreadLocal<Log>();

	public static EventFiringWebDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(EventFiringWebDriver webdriver) {
		driver.set(webdriver);
	}


	public static String getBrowserName() {
		return browserName.get();
	}

	public static void setBrowserName(String name) {
		browserName.set(name);
	}

	public static String getEnvironmentName() {
		return environmentName.get();
	}

	public static void setEnvironmentName(String name) {
		environmentName.set(name);
	}

	public static String getUserName() {
		return userName.get();
	}

	public static void setUserName(String name) {
		userName.set(name);
	}

	public static String getPassword() {
		return password.get();
	}

	public static void setPassword(String passwordValue) {
		password.set(passwordValue);
	}

	public static ThreadLocal<Log> getLog() {
		return log;
	}

	public static void setLog(Log logObject) {
		log.set(logObject);
	}




	
}
