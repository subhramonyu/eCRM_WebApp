package com.eCRM.client.utils;

import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;

import com.eCRM.client.utils.Config.LocatorStrategy;
import com.eCRM.client.utils.Config.ScrollDiection;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import java.time.Duration;

@SuppressWarnings("rawtypes")
public class GestureUtils {
	private JavascriptExecutor javaScriptExecutor;
	private HashMap<String, Object> gestureObject;
	private TouchAction touchAction;
	private static Actions actions;
	private boolean androidScrollFlag;
	private int androidScrollCounter;
	private String androidPageSourceBeforeScroll;
	private String androidPageSourceAfterScroll;
	public static boolean isAndroidScrollableElementFound;
	private boolean iOSScrollFlag;
	public static boolean isiOSScrollableElementFound;
	public static boolean iosPageSourceFlag = true;
	public static String iOSPageSource;
	private int startX, startY, endX, endY;
	private int mAndroidScrollSteps;
	private int mScrollX, mScrollY;

	public GestureUtils() {
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)
				|| DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			touchAction = new TouchAction((PerformsTouchActions) DriverManager.getDriver());
		else if (DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			actions = new Actions(DriverManager.getDriver());
		javaScriptExecutor = (JavascriptExecutor) DriverManager.getDriver();
		gestureObject = new HashMap<String, Object>();
		mScrollX = 0;
		mScrollY = 0;
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

	public void clickOnCordinates(int xCordinate, int yCordinate) {
		touchAction.tap(PointOption.point(xCordinate, yCordinate)).perform();
	}

	public void clickOnCordinates(WebElement element, int xOffset, int yOffset) {
		Point elementLocation = getElementLocation(element);
		touchAction.tap(PointOption.point(elementLocation.getX() + xOffset, elementLocation.getY() + yOffset))
				.perform();
	}

	public void clickOnElement(WebElement element) {
		touchAction.tap(new TapOptions().withElement(ElementOption.element(element))).perform();
	}

	public void longPressElement(WebElement element, Duration duration) {
		touchAction.longPress(new LongPressOptions().withElement(ElementOption.element(element)).withDuration(duration))
				.release().perform();
	}

	public void swipeByCordinates(int x1, int y1, int x2, int y2) {
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			touchAction.press(PointOption.point(x1, y1)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
					.moveTo(PointOption.point(x2, y2)).release().perform();
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			touchAction.press(PointOption.point(x1 * 2, y1 * 2))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
					.moveTo(PointOption.point(x2 * 2, y2 * 2)).release().perform();
	}

	public void swipeByCordinates(WebElement element, int x1, int y1, int x2, int y2) {
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			touchAction.press(ElementOption.element(element, x1, y1))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
					.moveTo(ElementOption.element(element, x2, y2)).release().perform();
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			touchAction.press(ElementOption.element(element, x1 * 2, y1 * 2))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
					.moveTo(ElementOption.element(element, x2 * 2, y2 * 2)).release().perform();
	}

	/*
	 * Use this method in order to perform scroll up and scroll down. For scroll
	 * down scroll steps should be negative and for scroll up steps should be
	 * positive. This method scroll then check objectName == objectValue, it repeats
	 * again and again until it reaches the object.
	 */

	public boolean scroll(String iOSObjectName, String iOSObjectValue, String androidObjectName,
			String androidObjectValue, int iOSScrollSteps, int androidScrollSteps, LocatorStrategy webLocatorStrategy,
			String webAttributeValue) {
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			if (iOSObjectValue != null) {
				if (iOSScrollSteps < 0)
					IOSUtils.getScrollSteps(ScrollDiection.DOWN);
				else
					IOSUtils.getScrollSteps(ScrollDiection.UP);
				return iOSScroll(iOSObjectName, iOSObjectValue, iOSScrollSteps);
			}
		} else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			if (androidObjectValue != null) {
				if (iOSScrollSteps < 0)
					AndroidUtils.getScrollSteps(ScrollDiection.DOWN);
				else
					AndroidUtils.getScrollSteps(ScrollDiection.UP);
				return androidScroll(androidObjectValue, androidScrollSteps);
			}
		} else if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			if (webAttributeValue != null)
				return webScroll(
						ElementUtils.getElement(null, null, null, null, webLocatorStrategy, webAttributeValue));
		}
		return false;
	}

	public boolean scroll(String iOSLocatorStragey, String attributeValue, LocatorStrategy webLocatorStrtegy,
			String webAttributeValue, ScrollDiection scrollDirection) {
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			if (attributeValue != null)
				return iOSScroll(iOSLocatorStragey, attributeValue, IOSUtils.getScrollSteps(scrollDirection));
		} else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			if (attributeValue != null)
				return androidScroll(attributeValue, AndroidUtils.getScrollSteps(scrollDirection));
		} else if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			if (webAttributeValue != null)
				return webScroll(ElementUtils.getElement(null, null, null, null, webLocatorStrtegy, webAttributeValue));
		}
		return false;
	}

	public void scroll(ScrollDiection scrollDirection, WebElement element) {
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			iOSScroll(getScrollSteps(scrollDirection), element);
		else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			androidScroll(getScrollSteps(scrollDirection));
	}

	public void scroll(int scrollSteps, int scrollCount) {
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)
				|| (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)))
			mobileScroll(scrollSteps, scrollCount);
		else if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			for (int i = 0; i < scrollCount; i++) {
				((JavascriptExecutor) DriverManager.getDriver()).executeScript("window.scrollBy(0," + scrollSteps + ")",
						"");
			}
		}
	}

	public boolean mobileScroll(String attributeValue, String iOSLocatorStragey, ScrollDiection scrollDirection) {
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			if (attributeValue != null) {
				return iOSScroll(iOSLocatorStragey, attributeValue, IOSUtils.getScrollSteps(scrollDirection));
			}
		} else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			if (attributeValue != null) {
				return androidScroll(attributeValue, AndroidUtils.getScrollSteps(scrollDirection));
			}
		}
		return false;
	}

	public boolean scroll(String attributeValue, String iOSLocatorStragey, int androidScrollSteps, int iOSScrollSteps) {
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			if (attributeValue != null) {
				return iOSScroll(iOSLocatorStragey, attributeValue, iOSScrollSteps);
			}
		} else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			if (attributeValue != null) {
				return androidScroll(attributeValue, androidScrollSteps);
			}
		} else if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			if (attributeValue != null) {
				return webScroll(ElementUtils.getElement(null, null, null, null,
						LocatorStrategy.WEB_LOCATOR_STRATEGY_CSS, attributeValue));
			}
		}
		return false;
	}

	public boolean iOSScroll(String elementAttributeName, String elementAttributeValue, int scrollSteps) {
		try {
			List<MobileElement> scrollToDesiredElement = DriverManager.getDriver().findElements(
					MobileBy.iOSNsPredicateString("" + elementAttributeName + " == \"" + elementAttributeValue + "\""));
			int appWidth = 10;
			for (MobileElement scrollToElement : scrollToDesiredElement) {
				if (scrollToElement.isDisplayed())
					return true;
			}
			if (Config.useExistingPageSource)
				iOSScrollFlag = Config.iOSPageSource.contains(elementAttributeValue);
			else
				iOSScrollFlag = DriverManager.getDriver().getPageSource().contains(elementAttributeValue);
			if (iOSScrollFlag) {
				if (Config.appWidthCenterFlag)
					appWidth = VisualUtils.getAppWidth() / 2;
				int appHeight = VisualUtils.getAppHeight();
				if (scrollSteps < 0)
					appHeight -= 200;
				else {
					appHeight = 0;
					appHeight += 100;
				}
				while (iOSScrollFlag) {
					touchAction.press(PointOption.point(appWidth, appHeight))
							.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
							.moveTo(PointOption.point(appWidth, appHeight + scrollSteps)).release().perform();
					for (MobileElement scrollToElement : scrollToDesiredElement) {
						if (scrollToElement.isDisplayed())
							return true;
					}
				}
			} else {
				return false;
			}
		} catch (Throwable e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public void setAndroidScrollFlag(String scrollToElement) {
		try {
			if (DriverManager.getDriver().getPageSource().contains(scrollToElement)) {
				if (ElementUtils.isDisplayed(2, 1, scrollToElement, LocatorStrategy.NONE, null)) {
					androidScrollFlag = false;
					isAndroidScrollableElementFound = true;
				}
			} else {
				androidScrollFlag = true;
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void iOSScroll(int scrollSteps, WebElement element) {
		try {
			iOSScrollFlag = true;
			while (iOSScrollFlag) {
				int appWidth = 10;
				int appHeight = VisualUtils.getAppHeight();
				if (scrollSteps < 0) {
					appHeight -= 300;
				} else {
					appHeight = 0;
					appHeight += 300;
				}
				touchAction.press(PointOption.point(appWidth, appHeight))
						.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
						.moveTo(PointOption.point(appWidth, appHeight + scrollSteps)).release().perform();
				if (element == null) {
					iOSScrollFlag = true;
				} else if (element.isDisplayed()) {
					iOSScrollFlag = false;
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void androidScroll(int scrollSteps) {
		try {
			androidScrollFlag = true;
			while (androidScrollFlag) {
				int appWidth = 10;
				int appHeight = VisualUtils.getAppHeight();
				if (scrollSteps < 0) {
					appHeight -= 300;
				} else {
					appHeight = 0;
					appHeight += 300;
				}
				androidPageSourceBeforeScroll = DriverManager.getDriver().getPageSource();

				touchAction.press(PointOption.point(appWidth, appHeight))
						.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
						.moveTo(PointOption.point(appWidth, appHeight + scrollSteps)).release().perform();
				androidPageSourceAfterScroll = DriverManager.getDriver().getPageSource();
				if (isReachedToBottom()) {
					androidScrollFlag = false;
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void mobileScroll(int scrollSteps, int scrollCount) {
		try {
			for (int i = 0; i < scrollCount; i++) {
				int appWidth = 10;
				int appHeight = VisualUtils.getAppHeight();
				if (scrollSteps < 0)
					appHeight -= 300;
				else {
					appHeight = 0;
					appHeight += 300;
				}
				touchAction.press(PointOption.point(appWidth, appHeight))
						.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
						.moveTo(PointOption.point(appWidth, appHeight + scrollSteps)).release().perform();
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void iOSScrollDown() {
		try {
			gestureObject.clear();
			gestureObject.put("direction", "down");
			javaScriptExecutor.executeScript("mobile: scroll", gestureObject);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public boolean iOSScrollDown(WebElement element) {
		try {
			System.out.println("Is Element Displayed:" + ElementUtils.isDisplayed(element));
			if (ElementUtils.isDisplayed(element)) {
				return false;
			} else {
				HashMap<String, String> scrollObject = new HashMap<String, String>();

				scrollObject.put("direction", "down");

				// System.out.println("Element Displayed:"+ElementUtils.isDisplayed(element));
				javaScriptExecutor.executeScript("mobile: scroll", scrollObject);

				return true;
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return false;
	}

	// ********************************** This method used to perform Actions On Web
	// Application **************************//

	public static void moveToElement(WebElement element) {
		actions.moveToElement(element).build().perform();
	}

	public static void moveAndClickElement(WebElement element) {
		actions.moveToElement(element).click().build().perform();
	}

	// ******************************************* New Gesture Methods
	// ******************************************

	public int getScrollSteps(ScrollDiection scrollDirection) {
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			return AndroidUtils.getScrollSteps(scrollDirection);
		else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			return IOSUtils.getScrollSteps(scrollDirection);
		return 0;
	}

	// *************************************** SCROLL METHODS
	// *************************************************

	/*
	 * for iOS "visibleText" should be same as name attribute of the object for
	 * Android "visibleText" should be in lie with textContains attribute of object
	 */

	public boolean mScroll(String visibleText, LocatorStrategy iOSLocatorStrategy,
			LocatorStrategy androidLocatorStrategy, ScrollDiection scrollDirection) {
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER) && iOSLocatorStrategy != null)
			return iOSScroll(iOSLocatorStrategy, visibleText, IOSUtils.getScrollSteps(scrollDirection));
		else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) && androidLocatorStrategy != null)
			return androidScroll(visibleText, androidLocatorStrategy, getScrollSteps(scrollDirection));
		return false;
	}

	public boolean mScroll(String androidVisibleText, String iOSVisibleText, LocatorStrategy iOSLocatorStrategy,
			LocatorStrategy androidLocatorStrategy, ScrollDiection scrollDirection) {
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER) && iOSLocatorStrategy != null)
			return iOSScroll(iOSLocatorStrategy, iOSVisibleText, IOSUtils.getScrollSteps(scrollDirection));
		else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) && androidLocatorStrategy != null)
			return androidScroll(androidVisibleText, androidLocatorStrategy, getScrollSteps(scrollDirection));
		return false;
	}

	public void mScroll(int androidScrollSteps, int iOSScrollSteps, int scrollCount) {
		try {
			for (int i = 0; i < scrollCount; i++) {
				int appWidth = VisualUtils.getAppWidth() / 2;
				int appHeight = VisualUtils.getAppHeight();
				if (androidScrollSteps < 0 || iOSScrollSteps < 0)
					appHeight -= 300;
				else {
					appHeight = 0;
					appHeight += 300;
				}
				if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
					touchAction.press(PointOption.point(appWidth, appHeight))
							.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
							.moveTo(PointOption.point(appWidth, appHeight + androidScrollSteps)).release().perform();
				else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
					touchAction.press(PointOption.point(appWidth, appHeight))
							.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
							.moveTo(PointOption.point(appWidth, appHeight + iOSScrollSteps)).release().perform();
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public boolean mobileScroll(String visibleText, ScrollDiection scrollDirection) {
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			return iOSScroll(null, visibleText, null, scrollDirection);
		else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			return androidScroll(visibleText, null, getScrollSteps(scrollDirection));
		return false;
	}

	public boolean mobileScroll(String iOSAttributeValue, String androidAttributeValue,
			LocatorStrategy androidLocatorStrategy, ScrollDiection scrollDirection, boolean isPredicateString) {
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			if (isPredicateString)
				return iOSScroll(null, null, iOSAttributeValue, scrollDirection);
			else
				return iOSScroll(null, iOSAttributeValue, null, scrollDirection);
		} else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			return androidScroll(androidAttributeValue, androidLocatorStrategy, getScrollSteps(scrollDirection));
		return false;
	}

	public boolean mobileScroll(WebElement iOSParentElement, String iOSName, String iOSPredicateString,
			String androidAttributeValue, LocatorStrategy androidLocatorStrategy, ScrollDiection scrollDirection) {
		if (DriverManager.getDriverName().equals(Config.IOS_DRIVER))
			return iOSScroll(iOSParentElement, iOSName, iOSPredicateString, scrollDirection);
		else if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
			return androidScroll(androidAttributeValue, androidLocatorStrategy, getScrollSteps(scrollDirection));
		return false;
	}

	public boolean iOSScroll(WebElement parentElement, String name, String predicateString,
			ScrollDiection scrollDirection) {
		try {
			gestureObject.clear();
			if (parentElement != null)
				gestureObject.put("element", ((RemoteWebElement) parentElement).getId());
			switch (scrollDirection) {
			case UP:
				gestureObject.put("direction", "up");
				break;
			case DOWN:
				gestureObject.put("direction", "down");
				break;
			case LEFT:
				gestureObject.put("direction", "left");
				break;
			case RIGHT:
				gestureObject.put("direction", "right");
				break;
			default:
				gestureObject.put("direction", "down");
			}
			if (name != null)
				gestureObject.put("name", name);
			else if (predicateString != null)
				gestureObject.put("predicateString", predicateString);
			javaScriptExecutor.executeScript("mobile:scroll", gestureObject);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean iOSScroll(LocatorStrategy locatorStrategy, String elementAttributeValue, int scrollSteps) {
		try {
			if (ElementUtils.isDisplayed(2, null, null, locatorStrategy, elementAttributeValue, null, null))
				return true;
			if (Config.useExistingPageSource)
				iOSScrollFlag = Config.iOSPageSource.contains(elementAttributeValue);
			else
				iOSScrollFlag = DriverManager.getDriver().getPageSource().contains(elementAttributeValue);
			if (iOSScrollFlag) {
				int appWidth = 10;
				if (Config.appWidthCenterFlag)
					appWidth = VisualUtils.getAppWidth() / 2;
				int appHeight = VisualUtils.getAppHeight();
				if (scrollSteps < 0)
					appHeight -= 200;
				else {
					appHeight = 0;
					appHeight += 100;
				}
				while (iOSScrollFlag) {
					touchAction.press(PointOption.point(appWidth, appHeight))
							.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
							.moveTo(PointOption.point(appWidth, appHeight + scrollSteps)).release().perform();
					if (ElementUtils.isDisplayed(2, null, null, locatorStrategy, elementAttributeValue, null, null))
						return true;
				}
			} else
				return false;
		} catch (Throwable e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public boolean androidScroll(String scrollToElement, int androidScrollSteps) {
		try {
			setAndroidScrollFlag(scrollToElement);
			while (androidScrollFlag) {
				if (androidScrollSteps < 0)
					getScrollPoint(ScrollDiection.DOWN);
				else
					getScrollPoint(ScrollDiection.UP);
				androidPageSourceBeforeScroll = DriverManager.getDriver().getPageSource();
				touchAction.press(PointOption.point(mScrollX, mScrollY))
						.waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
						.moveTo(PointOption.point(mScrollX, mScrollY + androidScrollSteps)).release().perform();
				androidPageSourceAfterScroll = DriverManager.getDriver().getPageSource();
				setAndroidScrollFlag(scrollToElement);
				if (androidScrollFlag) {
					if (isReachedToBottom()) {
						androidScrollFlag = false;
						isAndroidScrollableElementFound = false;
					}
				}
			}
			return isAndroidScrollableElementFound;
		} catch (Throwable e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean androidScroll(String attributeValue, LocatorStrategy androidLocatorStrategy,
			int androidScrollSteps) {
		try {
			mAndroidScrollSteps = androidScrollSteps;
			setAndroidScrollFlag(attributeValue, androidLocatorStrategy);
			while (androidScrollFlag) {
				if (androidScrollSteps < 0)
					getScrollPoint(ScrollDiection.DOWN);
				else
					getScrollPoint(ScrollDiection.UP);
				androidPageSourceBeforeScroll = DriverManager.getDriver().getPageSource();
				touchAction.press(PointOption.point(mScrollX, mScrollY))
						.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
						.moveTo(PointOption.point(mScrollX, mScrollY + mAndroidScrollSteps)).release().perform();
				androidPageSourceAfterScroll = DriverManager.getDriver().getPageSource();
				setAndroidScrollFlag(attributeValue, androidLocatorStrategy);
				if (androidScrollFlag) {
					if (isReachedToBottom()) {
						androidScrollFlag = false;
						isAndroidScrollableElementFound = false;
					}
				}
			}
			return isAndroidScrollableElementFound;
		} catch (Throwable e) {
			e.printStackTrace();
			return false;
		}
	}

	public void getScrollPoint(ScrollDiection direction) {
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			mScrollX = AndroidUtils.scrollX;
			if (direction == ScrollDiection.DOWN)
				mScrollY = AndroidUtils.scrollYDown;
			else
				mScrollY = AndroidUtils.scrollYUp;

		}
	}

	public void setScrollPoint(int androidX, int androidYDown, int androidYUp, int iOSX, int iOSYDown, int iOSYUp) {
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			AndroidUtils.scrollX = androidX;
			AndroidUtils.scrollYDown = androidYDown;
			AndroidUtils.scrollYUp = androidYUp;
		}
	}

	public void resetScrollPoint() {
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			AndroidUtils.scrollX = VisualUtils.getAppWidth() / 2;
			AndroidUtils.scrollYDown = VisualUtils.getAppHeight() / 2 + VisualUtils.getAppHeight() / 4;
			AndroidUtils.scrollYUp = VisualUtils.getAppHeight() / 2 - VisualUtils.getAppHeight() / 4;
		}
	}

	public void setAndroidScrollFlag(String attributeValue, LocatorStrategy androidLocatorStrategy) {
		try {
			if (androidLocatorStrategy == null)
				androidLocatorStrategy = LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS;
			if (DriverManager.getDriver().getPageSource().contains(attributeValue)) {
				if (ElementUtils.isDisplayed(2, 1, attributeValue, androidLocatorStrategy, null, null, null)) {
					androidScrollFlag = false;
					isAndroidScrollableElementFound = true;
				} else {
					androidScrollFlag = true;
					if (mAndroidScrollSteps < 0)
						mAndroidScrollSteps = getScrollSteps(ScrollDiection.FLEXIBLE_DOWN);
					else
						mAndroidScrollSteps = getScrollSteps(ScrollDiection.FLEXIBLE_UP);
				}
			} else {
				androidScrollFlag = true;
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	// specific to Android scroll, bottom can be top end or down end
	public boolean isReachedToBottom() {
		try {
			if (androidPageSourceBeforeScroll.equals(androidPageSourceAfterScroll))
				androidScrollCounter++;
			else
				androidScrollCounter = 0;
			if (Config.isDynamicPage) {
				androidScrollCounter++;
				if (androidScrollCounter == 3 || androidScrollCounter == Config.maxScrollCounterForDynamicPage)
					return true;
				else
					return false;
			} else if (Config.isScrollCountFixed) {
				Config.maxFixedScrollCounter++;
				if (Config.maxFixedScrollCounter >= Config.maxFixedScrollCount)
					return true;
				else
					return false;
			} else {
				if (androidScrollCounter >= 3)
					return true;
				else
					return false;
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean webScroll(WebElement element) {
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

	public boolean webScroll(LocatorStrategy locatorStrategy, String attributeValue, ScrollDiection scrollDirection,
			int scrollCount) {
		if (ElementUtils.isDisplayed(ElementUtils.getElement(null, null, null, null, locatorStrategy, attributeValue)))
			return true;
		for (int i = 0; i < scrollCount; i++) {
			if (scrollDirection == ScrollDiection.DOWN) {
				((JavascriptExecutor) DriverManager.getDriver())
						.executeScript("window.scrollTo(0, document.body.scrollHeight);");
				CommonUtils.wait(2);
				if (ElementUtils
						.isDisplayed(ElementUtils.getElement(null, null, null, null, locatorStrategy, attributeValue)))
					return true;
			} else if (scrollDirection == ScrollDiection.UP) {
				((JavascriptExecutor) DriverManager.getDriver())
						.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
				CommonUtils.wait(2);
				if (ElementUtils
						.isDisplayed(ElementUtils.getElement(null, null, null, null, locatorStrategy, attributeValue)))
					return true;
			}
		}
		return false;
	}

	public boolean webSafeScroll(LocatorStrategy locatorStrategy, String attributeValue, ScrollDiection scrollDirection,
			int scrollCount) {
		for (int i = 0; i < scrollCount; i++) {
			if (scrollDirection == ScrollDiection.DOWN) {
				((JavascriptExecutor) DriverManager.getDriver())
						.executeScript("window.scrollTo(0, document.body.scrollHeight);");
				CommonUtils.wait(1);
			} else if (scrollDirection == ScrollDiection.UP) {
				((JavascriptExecutor) DriverManager.getDriver())
						.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
				CommonUtils.wait(1);
			}
		}
		return ElementUtils
				.isDisplayed(ElementUtils.getElement(null, null, null, null, locatorStrategy, attributeValue));
	}

	public void webScroll(ScrollDiection scrollDirection, int scrollCount) {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			for (int i = 0; i < scrollCount; i++) {
				if (scrollDirection == ScrollDiection.DOWN) {
					((JavascriptExecutor) DriverManager.getDriver())
							.executeScript("window.scrollTo(0, document.body.scrollHeight);");
					CommonUtils.wait(2);
				} else if (scrollDirection == ScrollDiection.UP) {
					((JavascriptExecutor) DriverManager.getDriver())
							.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
					CommonUtils.wait(2);
				}
			}
		}

	}

	public void webScroll(int scrollCount, int xScrollSteps, int yScrollSteps) {
		if (DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
			for (int i = 0; i < scrollCount; i++) {
				((JavascriptExecutor) DriverManager.getDriver())
						.executeScript("window.scrollBy(arguments[1], arguments[1]);", xScrollSteps, yScrollSteps);
				CommonUtils.wait(2);
			}
		}

	}

	public void webPopupScroll(WebElement parentElement, WebElement childElement, ScrollDiection scrollDirection,
			int scrollCount) {
		for (int i = 0; i < scrollCount; i++) {
			if (scrollDirection == ScrollDiection.DOWN) {
				((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollTop = arguments[1];",
						parentElement, 100);
				if (ElementUtils.isDisplayed(childElement))
					break;
			} else if (scrollDirection == ScrollDiection.UP) {
				((JavascriptExecutor) DriverManager.getDriver())
						.executeScript("arguments[0].scrollBottom = arguments[1];", parentElement, 100);
				if (ElementUtils.isDisplayed(childElement))
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

	public void scrollIOSPickerWheel(WebElement element, ScrollDiection scrollDirection) {
		gestureObject.clear();
		switch (scrollDirection) {
		case NEXT:
			gestureObject.put("order", "next");
			break;
		case PREVIOUS:
			gestureObject.put("order", "previous");
			break;
		default:
			gestureObject.put("order", "next");
		}
		gestureObject.put("offset", 0.12);
		gestureObject.put("element", ((RemoteWebElement) element).getId());
		javaScriptExecutor.executeScript("mobile: selectPickerWheelValue", gestureObject);
	}

	// *************************************** END OF SCROLL METHODS
	// *************************************************

	// *************************************** SWIPE METHODS
	// *************************************************

	public void swipe(ScrollDiection scrollDirection, WebElement element, int offsetValue) {
		if (DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)) {
			resetSwipeCordinates();
			setSwipeCordinates(scrollDirection, element, offsetValue);
			swipeByCordinates(startX, startY, endX, endY);
		} else if (DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
			iOSSwipe(scrollDirection, element);
		}
	}

	// works only for android for iOS use iOSSwipe
	public void setSwipeCordinates(ScrollDiection scrollDirection, WebElement element, int offsetValue) {
		switch (scrollDirection) {
		case RIGHT:
			startX = element.getLocation().x + offsetValue;
			startY = element.getLocation().y + element.getSize().height / 2;
			endX = element.getSize().width - offsetValue;
			endY = element.getLocation().y + element.getSize().height / 2;
			break;
		case LEFT:
			startX = element.getSize().width - offsetValue;
			startY = element.getLocation().y + element.getSize().height / 2;
			endX = element.getLocation().x + offsetValue;
			endY = element.getLocation().y + element.getSize().height / 2;
			break;
		default:
			startX = 0;
			startY = 0;
			endX = 0;
			endY = 0;
			break;
		}
	}

	public void iOSSwipe(ScrollDiection direction, Object element) {
		gestureObject.clear();
		CommonUtils.wait(3);
		switch (direction) {
		case RIGHT:
			gestureObject.put("direction", "right");
			break;
		case LEFT:
			gestureObject.put("direction", "left");
			break;
		case UP:
			gestureObject.put("direction", "up");
			break;
		case DOWN:
			gestureObject.put("direction", "down");
			break;
		default:
			gestureObject.put("direction", "right");
		}
		if (element != null)
			gestureObject.put("element", ((RemoteWebElement) element).getId());
		javaScriptExecutor.executeScript("mobile: swipe", gestureObject);
	}

	public void resetSwipeCordinates() {
		startX = 0;
		startY = 0;
		endX = 0;
		endY = 0;
	}

	public void slideIOSSlider(WebElement sliderElement, String value) {
		sliderElement.sendKeys(value);
	}

	// *************************************** END OF SWIPE METHODS
	// *************************************************

	public JavascriptExecutor getJavaScriptExecutor() {
		return javaScriptExecutor;
	}

	public Actions getActionsWebObject() {
		return actions;
	}

	public enum ObjectName {
		DOWNLOAD_LOG, DISCONNECT_DEVICE, DOWNLOAD, ASSET_PROMPT, WORK_ORDER_PROMPT, TEXT_NOTE_PROMPT, SHARE_PROMPT, TEXT_NOTE_ENTER_BUTTON, WORKORDER_SAVE_BUTTON, VIEW_SESSION_SETUP_VIBRATION_UNIT, VIEW_SESSION_SETUP_TEMPERATURE_UNIT,
	}

	public static int[] getTapCordinates(ObjectName objectName) {
		switch (DriverManager.getDeviceName()) {
		case "iPhone 6s":
		case "iPhone":
			return GestureUtils.getiPhone6SCordinates(objectName);
		case "SM-N9208":
			return GestureUtils.getNote5Cordinates(objectName);
		case "SM-G920I":
			return GestureUtils.getS7Cordinates(objectName);
		case "ANE-AL00":
			return GestureUtils.getHuwaeiP20Cordinates(objectName);
		case "iPhone 6":
			return GestureUtils.getiPhone6Cordinates(objectName);
		default:
			return null;
		}
	}

	public static int[] getiPhone6Cordinates(ObjectName objectName) {
		switch (objectName) {
		case DOWNLOAD_LOG:
			return new int[] { 287, 128 };
		case DOWNLOAD:
			return new int[] { 33, 437 };
		case DISCONNECT_DEVICE:
			return new int[] { 326, 128 };
		case VIEW_SESSION_SETUP_VIBRATION_UNIT:
			return new int[] { 170, 240 };
		case VIEW_SESSION_SETUP_TEMPERATURE_UNIT:
			return new int[] { 170, 310 };
		default:
			return null;
		}
	}

	public static int[] getiPhone6SCordinates(ObjectName objectName) {
		switch (objectName) {
		case DOWNLOAD_LOG:
			return new int[] { 301, 140 };
		case WORKORDER_SAVE_BUTTON:
			return new int[] { 325, 40 };
		case VIEW_SESSION_SETUP_VIBRATION_UNIT:
			return new int[] { 170, 240 };
		case VIEW_SESSION_SETUP_TEMPERATURE_UNIT:
			return new int[] { 170, 310 };
		default:
			return null;
		}
	}

	public static int[] getNote5Cordinates(ObjectName objectName) {
		switch (objectName) {
		case DOWNLOAD_LOG:
			return new int[] { 870, 450 };
		case DISCONNECT_DEVICE:
			return new int[] { 964, 450 };
		case VIEW_SESSION_SETUP_VIBRATION_UNIT:
			return new int[] { 450, 800 };
		case VIEW_SESSION_SETUP_TEMPERATURE_UNIT:
			return new int[] { 450, 1000 };
		default:
			return null;
		}
	}

	public static int[] getHuwaeiP20Cordinates(ObjectName objectName) {
		switch (objectName) {
		case DOWNLOAD_LOG:
			return new int[] { 840, 530 };
		case DISCONNECT_DEVICE:
			return new int[] { 940, 530 };
		case VIEW_SESSION_SETUP_VIBRATION_UNIT:
			return new int[] { 450, 800 };
		case VIEW_SESSION_SETUP_TEMPERATURE_UNIT:
			return new int[] { 450, 1000 };
		default:
			return null;
		}
	}

	public static int[] getS7Cordinates(ObjectName objectName) {
		switch (objectName) {
		case DOWNLOAD_LOG:
			return new int[] { 1160, 604 };
		case DISCONNECT_DEVICE:
			return new int[] { 1280, 604 };
		case VIEW_SESSION_SETUP_VIBRATION_UNIT:
			return new int[] { 450, 800 };
		case VIEW_SESSION_SETUP_TEMPERATURE_UNIT:
			return new int[] { 450, 1000 };
		default:
			return null;
		}
	}

}
