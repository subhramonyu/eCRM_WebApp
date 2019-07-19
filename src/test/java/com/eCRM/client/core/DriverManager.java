package com.eCRM.client.core;

import org.openqa.selenium.WebDriver;

import com.eCRM.client.pages.SignInPage;

public class DriverManager {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private static ThreadLocal<String> browserName = new ThreadLocal<String>();
	private static ThreadLocal<String> environmentName = new ThreadLocal<String>();
	private static ThreadLocal<String> userName = new ThreadLocal<String>();
	private static ThreadLocal<String> password = new ThreadLocal<String>();
	private static ThreadLocal<SignInPage> signIn = new ThreadLocal<SignInPage>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(WebDriver driverObject) {
		driver.set(driverObject);
	}

	public static SignInPage getSignIn() {
		return signIn.get();
	}

	public static void setSignIn(SignInPage signInObject) {
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

	
	

	
}
