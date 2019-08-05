package com.eCRM.client.core;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.eCRM.client.core.Config.LocatorStrategy;
import com.eCRM.client.core.Config.ScrollDiection;
import com.google.common.base.Function;

import ru.yandex.qatools.allure.annotations.Step;

@SuppressWarnings({ "unused" })
public class CommonUtils {
	private static Process process;
	private static int reliableRetryClickCount = 0;
	private static boolean reliableRetryClickFlag = true;
	private static Robot robot;
	private static Wait<WebDriver> fluentWait;
	private static WebElement element;
	private static JavascriptExecutor javaScriptExecutor;
	private static Actions actions;
	private int startX, startY, endX, endY;

	public CommonUtils() {
		actions = new Actions(DriverManager.getDriver());
		javaScriptExecutor = (JavascriptExecutor) DriverManager.getDriver();
	}

	// ***************** Actions and Events methods *******************

	@Step("Moving to Element : {0}")
	public static void moveToElement(WebElement element) {
		actions.moveToElement(element).build().perform();
	}

	@Step("Moving and Clicking on Element : {0}")
	public static void moveAndClickElement(WebElement element) {
		actions.moveToElement(element).click().build().perform();
	}

	// *********************** Scroll methods **************************************

	@Step("Scrolling by Steps : {0}")
	public void scroll(int scrollSteps, int scrollCount) {
		for (int i = 0; i < scrollCount; i++) {
			javaScriptExecutor.executeScript("window.scrollBy(0," + scrollSteps + ")", "");
		}
	}

	@Step("Scrolling to the Element : {0}")
	public boolean scrollToElement(WebElement element) {
		try {
			javaScriptExecutor.executeScript("arguments[0].scrollIntoView();", element);
			if (element.isDisplayed())
				return true;
			else
				return false;
		} catch (Throwable e) {
			e.printStackTrace();
			return false;
		}
	}

	@Step("Scrolling to the Element :{0}  in the direction : {1}")
	public boolean scrollToElement(WebElement element, ScrollDiection scrollDirection, int scrollCount) {
		if (isDisplayed(10, 1, element))
			return true;
		for (int i = 0; i < scrollCount; i++) {
			if (scrollDirection == ScrollDiection.DOWN) {
				javaScriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
				CommonUtils.wait(2);
				if (isDisplayed(10, 1, element))
					return true;
			} else if (scrollDirection == ScrollDiection.UP) {
				javaScriptExecutor.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
				CommonUtils.wait(2);
				if (isDisplayed(10, 1, element))
					return true;
			}
		}
		return false;
	}

	@Step("Pop up scrolling : {0}")
	public void popupScroll(WebElement parentElement, WebElement childElement, ScrollDiection scrollDirection,
			int scrollCount) {
		for (int i = 0; i < scrollCount; i++) {
			if (scrollDirection == ScrollDiection.DOWN) {
				javaScriptExecutor.executeScript("arguments[0].scrollTop = arguments[1];", parentElement, 100);
				if (isDisplayed(10, 1, childElement))
					break;
			} else if (scrollDirection == ScrollDiection.UP) {
				javaScriptExecutor.executeScript("arguments[0].scrollBottom = arguments[1];", parentElement, 100);
				if (isDisplayed(10, 1, childElement))
					break;
			}
		}
		CommonUtils.wait(2);
	}

	@Step("Pop up scrolling to element : {0}")
	public void webPopupScroll(WebElement parentElement, int scrollSteps, int scrollCount) {
		if (scrollSteps <= 0)
			javaScriptExecutor.executeScript("arguments[0].scrollTop = arguments[1];", parentElement,
					Math.abs(scrollSteps));
		else if (scrollSteps > 0)
			javaScriptExecutor.executeScript("arguments[0].scrollBottom = arguments[1];", parentElement,
					Math.abs(scrollSteps));
		CommonUtils.wait(2);
	}

	// **************************** Find ELEMENT METHODS ******************

	@Step("Getting the webElement : {1}")
	public static WebElement getElement(LocatorStrategy webLocatorStrategy, String webAttributeValue) {
		WebElement returnElement = null;

		try {

			switch (webLocatorStrategy) {
			case WEB_LOCATOR_STRATEGY_ID:
				returnElement = DriverManager.getDriver().findElement(By.id(webAttributeValue));
				break;
			case WEB_LOCATOR_STRATEGY_XPATH:
				returnElement = DriverManager.getDriver().findElement(By.xpath(webAttributeValue));
				break;
			case WEB_LOCATOR_STRATEGY_XPATH_TEXT:
				returnElement = DriverManager.getDriver().findElement(By.xpath("//*[. = '" + webAttributeValue + "']"));
				break;
			case WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS:
				returnElement = DriverManager.getDriver()
						.findElement(By.xpath("//*[contains(text(), '" + webAttributeValue + "')]"));
				break;
			case WEB_LOCATOR_STRATEGY_XPATH_SPAN_TEXT_CONTAINS:
				returnElement = DriverManager.getDriver()
						.findElement(By.xpath("//span[contains(text(), '" + webAttributeValue + "')]"));
				break;
			case WEB_LOCATOR_STRATEGY_CSS:
				returnElement = DriverManager.getDriver().findElement(By.cssSelector(webAttributeValue));
				break;
			case WEB_LOCATOR_STRATEGY_XPATH_TEXT_CONTAINS:
				returnElement = DriverManager.getDriver()
						.findElement(By.xpath("//*[contains(text(), '" + webAttributeValue + "')]"));
				break;
			default:
			}
			return returnElement;

		} catch (Throwable e) {
			return null;
		}
	}

	@Step("Getting the list of webElements")
	public static List<WebElement> getElements(WebElement parentElement, LocatorStrategy webLocatorStrategy,
			String webAttributeValue) {
		try {
			List<WebElement> returnElement = null;

			switch (webLocatorStrategy) {
			case WEB_LOCATOR_STRATEGY_ID:
				returnElement = parentElement.findElements(By.id(webAttributeValue));
				break;
			case WEB_LOCATOR_STRATEGY_XPATH:
				returnElement = parentElement.findElements(By.xpath(webAttributeValue));
				break;
			case WEB_LOCATOR_STRATEGY_XPATH_TEXT:
				returnElement = parentElement.findElements(By.xpath("//*[. = '" + webAttributeValue + "']"));
				break;
			case WEB_LOCATOR_STRATEGY_XPATH_DIV_TEXT_CONTAINS:
				returnElement = parentElement
						.findElements(By.xpath("//div[contains(text(), '" + webAttributeValue + "')]"));
				break;
			case WEB_LOCATOR_STRATEGY_XPATH_SPAN_TEXT_CONTAINS:
				returnElement = parentElement
						.findElements(By.xpath("//span[contains(text(), '" + webAttributeValue + "')]"));
				break;
			case WEB_LOCATOR_STRATEGY_CSS:
				returnElement = parentElement.findElements(By.cssSelector(webAttributeValue));
				break;
			case WEB_LOCATOR_STRATEGY_CSS_INPUT_DATA_FEATURE:
				returnElement = parentElement
						.findElements(By.cssSelector("input[data-feature = '" + webAttributeValue + "']"));
				break;
			default:
			}
			return returnElement;

		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}

	}

	// **************** IS DISPLAYED / ENABLED METHODS *************************

	@Step("Is element is Displayed : {2}")
	public static boolean isDisplayed(int timeoutInSeconds, int pollingTimeInSeconds, WebElement aNelement) {
		try {
			fluentWait = new FluentWait<WebDriver>(DriverManager.getDriver())
					.pollingEvery(Duration.ofSeconds(pollingTimeInSeconds))
					.withTimeout(Duration.ofSeconds(timeoutInSeconds))
					.ignoring(NoSuchElementException.class, Error.class);
			element = aNelement;
			return fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					return element.isDisplayed();
				}
			});
		} catch (Throwable e) {
			e.printStackTrace();
			return false;
		}
	}

	@Step("Is Displayed element is enabled : {0}")
	public static boolean isDisplayedAndEnabled(int timeoutInSeconds, int pollingTimeInSeconds, WebElement aNelement) {
		try {
			if (timeoutInSeconds == 0)
				timeoutInSeconds = Config.TIMEOUT_IN_SECONDS;
			if (pollingTimeInSeconds == 0)
				pollingTimeInSeconds = Config.POLLING_TIME_IN_SECONDS;
			fluentWait = new FluentWait<WebDriver>(DriverManager.getDriver())
					.pollingEvery(Duration.ofSeconds(pollingTimeInSeconds))
					.withTimeout(Duration.ofSeconds(timeoutInSeconds))
					.ignoring(NoSuchElementException.class, Error.class);
			element = aNelement;
			return fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					return (element.isDisplayed() && element.isEnabled());
				}
			});
		} catch (Throwable e) {
			e.printStackTrace();
			return false;
		}
	}

	// ****************** CLICK METHODS ****************************

	@Step("Clicking on the WebElement : {0}")
	public static void click(WebElement element) {
		try {
			if (isDisplayed(Config.TIMEOUT_IN_SECONDS, Config.POLLING_TIME_IN_SECONDS, element))
				element.click();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Step("Clicking on the WebElement : {2}")
	public static void click(int timeoutInSeconds, int pollingTimeInSeconds, WebElement elementToBeClicked,
			WebElement elementToBeVisibleAfterClick, int retryCount) throws Exception {
		try {
			boolean retryFlag = true;
			int retryCounter = 0;
			boolean clickFlag = false;
			while (retryFlag) {
				if (isDisplayedAndEnabled(timeoutInSeconds, pollingTimeInSeconds, elementToBeClicked)) {
					elementToBeClicked.click();
					clickFlag = true;
				}
				if (clickFlag && isDisplayed(10, 1, elementToBeVisibleAfterClick)) {
					retryFlag = false;
				} else if (retryCounter == retryCount) {
					retryFlag = false;
				} else {
					retryCounter++;
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	@Step("Clicking on the WebElement : {0}")
	public static void jsclick(WebElement element) {
		try {
			javaScriptExecutor.executeScript("arguments[0].click();", element);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	@Step("Selecting from the drop down by index :{1}")
	public void selectFromDropdown(WebElement element, int indexToBeSelected) {
		Select aSelect = new Select(element);
		aSelect.selectByIndex(indexToBeSelected);
	}

	public static void clickEnterKey() {
		try {
			robot = new Robot();
			CommonUtils.wait(1);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			CommonUtils.wait(1);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	// ************** SEND KEYS METHODS **************************

	@Step("Sending Text : {1} to element : {0}")
	public static void sendKeys(WebElement element, String textToBeTyped) {
		try {
			element.sendKeys(textToBeTyped);

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Step("Sending Text : {3} to element : {2}")
	public static void sendKeys(int timeoutInSeconds, int pollingTimeInSeconds, WebElement element,
			String textToBeTyped, int retryCount) {
		try {
			boolean retryFlag = true;
			boolean setTextFlag = false;
			int retryCounter = 0;
			while (retryFlag) {
				if (isDisplayed(timeoutInSeconds, pollingTimeInSeconds, element)) {

					{
						element.clear();
						element.sendKeys(textToBeTyped);
						setTextFlag = true;
					}
				}
				if (setTextFlag) {
					if (element.getAttribute("value").contains(textToBeTyped)) {
						retryFlag = false;
					} else {
						retryCounter++;
					}
				}
				if (retryCounter == retryCount) {
					retryFlag = false;
				} else {
					retryCounter++;
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	// ************************ Miscellaneous methods *****************************

	@Step("Executing Command : {0} ")
	public static void executeCommand(String command) {
		try {
			process = Runtime.getRuntime().exec(command);
		} catch (Exception e) {
		}
	}

	@Step("Waiting for : {0} seconds")
	public static void wait(int seconds) {
		try {
			Thread.sleep(1000 * seconds);
		} catch (Exception e) {
		}
	}

	@Step("Spliting the string : {0} with separator : {1}")
	public static String[] split(String mainString, String... sepeartor) {
		String getString = Arrays.toString(sepeartor);
		return mainString.split(getString);
	}

	@Step("Get the screen width")
	public int getScreenWidth() {
		return DriverManager.getDriver().manage().window().getSize().getWidth();
	}

	@Step("Get the Screen height")
	public int getScreenHeight() {
		return DriverManager.getDriver().manage().window().getSize().getHeight();
	}

	@Step("Get the Element location : {0}")
	public Point getElementLocation(WebElement element) {
		return element.getLocation();
	}

	@Step("Get the Element Dimension : {0}")
	public Dimension getElementDimension(WebElement element) {
		return element.getSize();
	}

	@Step("Getting the User home directory path")
	public static String getUserHomeDirectoryPath() {
		return System.getProperty("user.home");
	}

	@Step("Getting the  User Current directory path")
	public static String getUserCurrentDirectoryPath() {
		return System.getProperty("user.dir");
	}

	@Step("switching to Frame : {0}")
	public void switchToFrame(WebElement element) {
		DriverManager.getDriver().switchTo().frame(element);
	}

	@Step("switching to default Content")
	public void switchToDefaultContent() {
		DriverManager.getDriver().switchTo().defaultContent();
	}

	@Step("get the current Frame")
	public Object getCurrentFrame() {
		return javaScriptExecutor.executeScript("return self.name");
	}
	
	@Step("execute JavaScript")
	public  static Object jsExeCute(String script) {
		return javaScriptExecutor.executeScript(script);
	}

}
