package com.eCRM.client.core;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.time.Duration;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.apache.tools.ant.taskdefs.condition.And;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.internal.annotations.TestAnnotation;

import com.eCRM.client.core.Config.ScrollDiection;
import com.eCRM.client.pages.SignInPage;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.TapOptions;

@SuppressWarnings({"unused"})
public class CommonUtils 
{
	private static Process process;
	private static int reliableRetryClickCount = 0;
	private static boolean reliableRetryClickFlag = true;
	private static Robot robot;
	private static Wait<WebDriver> fluentWait;
	private static WebElement fluentWaitElement;
	private JavascriptExecutor javaScriptExecutor;
	private HashMap<String, Object> gestureObject;
	private static Actions actions;
	private int startX, startY, endX, endY;
	
	
	public CommonUtils() {
		actions = new Actions(DriverManager.getDriver());
		javaScriptExecutor = (JavascriptExecutor) DriverManager.getDriver();
		gestureObject = new HashMap<String, Object>();
	}
	
	
	
	
	

	// ************************* Actions methods **********************************

	
	public static void moveToElement(WebElement element) {
		actions.moveToElement(element).build().perform();
	}

	public static void moveAndClickElement(WebElement element) {
		actions.moveToElement(element).click().build().perform();
	}
	
	
	
	
	
	//*********************** Scroll methods **************************************

	public void scroll(int scrollSteps, int scrollCount) 
	{
		for (int i = 0; i < scrollCount; i++) {
			((JavascriptExecutor) DriverManager.getDriver()).executeScript("window.scrollBy(0," + scrollSteps + ")",
					"");
		}
	}
		
	
	public boolean scrollToElement(WebElement element) {
		try {
			((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView();", element);
			if (element.isDisplayed())
				return true;
			else
				return false;
		} catch (Throwable e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean scrollToElement(WebElement element, ScrollDiection scrollDirection,
			int scrollCount) {
		if (ElementUtils.isDisplayed(10,1,element))
			return true;
		for (int i = 0; i < scrollCount; i++) {
			if (scrollDirection == ScrollDiection.DOWN) {
				((JavascriptExecutor) DriverManager.getDriver())
						.executeScript("window.scrollTo(0, document.body.scrollHeight);");
				CommonUtils.wait(2);
				if (ElementUtils
						.isDisplayed(10, 1, element))
					return true;
			} else if (scrollDirection == ScrollDiection.UP) {
				((JavascriptExecutor) DriverManager.getDriver())
						.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
				CommonUtils.wait(2);
				if (ElementUtils
						.isDisplayed(10,1,element))
					return true;
			}
		}
		return false;
	}

	
	public void popupScroll(WebElement parentElement, WebElement childElement, ScrollDiection scrollDirection,
			int scrollCount) {
		for (int i = 0; i < scrollCount; i++) {
			if (scrollDirection == ScrollDiection.DOWN) {
				((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollTop = arguments[1];",
						parentElement, 100);
				if (ElementUtils.isDisplayed(10, 1, childElement))
					break;
			} else if (scrollDirection == ScrollDiection.UP) {
				((JavascriptExecutor) DriverManager.getDriver())
						.executeScript("arguments[0].scrollBottom = arguments[1];", parentElement, 100);
				if (ElementUtils.isDisplayed(10,1,childElement))
					break;
			}
		}
		CommonUtils.wait(2);
	}

	public void webPopupScroll(WebElement parentElement, int scrollSteps, int scrollCount) {
		if (scrollSteps <= 0)
			((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollTop = arguments[1];",
					parentElement, Math.abs(scrollSteps));
		else if (scrollSteps > 0)
			((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollBottom = arguments[1];",
					parentElement, Math.abs(scrollSteps));
		CommonUtils.wait(2);
	}

	
	
	//************************  Miscellaneous methods *****************************  
	
	
	
		public static void executeCommandOnTerminal(String command)
		{
			try
			{
				process = Runtime.getRuntime().exec(command);
			}
			catch(Exception e){ }
		}
		
		public static void wait(int seconds)
		{
			try 
			{
				Thread.sleep(1000 * seconds);
			}
			catch(Exception e){ }
		}
		
		
		public static String[] split(String mainString, String... sepeartor)
		{
			String getString= Arrays.toString(sepeartor);
			return mainString.split(getString);
		}
		
		public int getScreenWidth() {
			return DriverManager.getDriver().manage().window().getSize().getWidth();
		}

		public int getScreenHeight() {
			return DriverManager.getDriver().manage().window().getSize().getHeight();
		}

		public Point getElementLocation(WebElement element) {
			return element.getLocation();
		}

		public Dimension getElementDimension(WebElement element) {
			return element.getSize();
		}

	
}
	

