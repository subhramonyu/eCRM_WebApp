package com.eCRM.client.core;

import org.openqa.selenium.WebDriver;

import com.eCRM.client.pages.LogInPage;

public class DriverManager {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private static ThreadLocal<String> browserName = new ThreadLocal<String>();
	private static ThreadLocal<String> environmentName = new ThreadLocal<String>();
	private static ThreadLocal<String> userName = new ThreadLocal<String>();
	private static ThreadLocal<String> password = new ThreadLocal<String>();
	private static ThreadLocal<LogInPage> signIn = new ThreadLocal<LogInPage>();
	private static ThreadLocal<Log> log = new ThreadLocal<Log>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(WebDriver driverObject) {
		driver.set(driverObject);
	}

	public static LogInPage getSignIn() {
		return signIn.get();
	}

	public static void setSignIn(LogInPage signInObject) {
		signIn.set(signInObject);
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
