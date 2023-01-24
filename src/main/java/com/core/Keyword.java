package com.core;

import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.Locator;
import com.base.WaitFor;
import com.exceptions.InvalidBrowserNameException;
import com.exceptions.InvalidKeyName;

public class Keyword {

	public static RemoteWebDriver driver = null;

	/**
	 * Used to store Locator type after splitting from locator using locatorSplit
	 */
	protected static String locatorType;

	/**
	 * Used to store Locator value after splitting from locator using locatorSplit
	 */
	protected static String locatorValue;

	/**
	 * This keyword helps launch a browser instance. You can choose to launch any
	 * one of the following Browsers
	 * <ol>
	 * <li>Microsoft Edge
	 * <li>Google Chrome
	 * <li>Mozilla Firefox
	 * <li>Safari
	 * </ol>
	 * 
	 * @param browserName
	 * @author Sandesh
	 */
	public static void launchBrowser(String browserName) {
		browserName = browserName.toLowerCase();

		if (browserName.equals("edge") || browserName.contains("microsoft")) {
			driver = new EdgeDriver();
		} else if (browserName.equals("chrome") || browserName.contains("google")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox") || browserName.contains("mozilla")) {
			driver = new FirefoxDriver();
		} else if (browserName.equals("safari")) {
			driver = new SafariDriver();
		} else {
			throw new InvalidBrowserNameException(browserName);
		}
	}

	/**
	 * Keyword to quit browser
	 * 
	 * @author Sandesh
	 */
	public static void quitBrowser() {
		driver.quit();
	}

	/**
	 * Maximize Browser Window
	 * 
	 * @author Sandesh
	 */
	public static void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	/**
	 * Keyword to launch Web-Application/Website
	 * 
	 * @param url
	 * @author Sandesh
	 */
	public static void launchUrl(String url) {
		driver.get(url);
	}

	/**
	 * Used for clicking on WebElements
	 * 
	 * @param locator of WebElement from Locator Interface
	 * 
	 * @author Sandesh
	 */
	public static void clickOn(String locator) {
		getElement(locator).click();
	}
	
	/**
	 * Used for clicking on WebElements
	 * @param WebElement
	 * @author Sandesh
	 */
	public static void clickOn(WebElement element) {
		element.click();
	}

	
	/**
	 * Used to Enter text in a particular text field
	 * 
	 * @param locator of WebElement from Locator Interface
	 * @param text
	 * @author Sandesh
	 */
	public static void enterText(String locator, String text) {
		getElement(locator).sendKeys(text);
	}

	/**
	 * Used to split locator values from Locator Interface
	 */
	protected static void splitLocator(String locator) {
		locatorType = locator.split("##")[0].toLowerCase();
		locatorValue = locator.split("##")[1];
	}

	/**
	 * Returns a WebElement by providing a locator from Locator interface
	 * 
	 * @param locator
	 * @return A WebElement
	 * @author Sandesh
	 */
	public static WebElement getElement(String locator) {

		splitLocator(locator);

		if (locatorType.equals("css")) {
			return driver.findElement(By.cssSelector(locatorValue));
		} else if (locatorType.equals("xpath")) {
			return driver.findElement(By.xpath(locatorValue));
		} else if (locatorType.equals("classname")) {
			return driver.findElement(By.className(locatorValue));
		} else if (locatorType.equals("name")) {
			return driver.findElement(By.name(locatorValue));
		} else if (locatorType.equals("tagname")) {
			return driver.findElement(By.tagName(locatorValue));
		} else if (locatorType.equals("id")) {
			return driver.findElement(By.id(locatorValue));
		} else if (locatorType.equals("linktext")) {
			return driver.findElement(By.linkText(locatorValue));
		} else if (locatorType.equals("partiallinktext")) {
			return driver.findElement(By.partialLinkText(locatorValue));
		}
		return null;
	}

	/**
	 * Returns a List of WebElements by providing a locator from Locator interface
	 * 
	 * @param locator
	 * @return List of WebElements
	 */
	public static List<WebElement> getElements(String locator) {

		splitLocator(locator);

		if (locatorType.equals("css")) {
			return driver.findElements(By.cssSelector(locatorValue));
		} else if (locatorType.equals("xpath")) {
			return driver.findElements(By.xpath(locatorValue));
		} else if (locatorType.equals("classname")) {
			return driver.findElements(By.className(locatorValue));
		} else if (locatorType.equals("name")) {
			return driver.findElements(By.name(locatorValue));
		} else if (locatorType.equals("tagname")) {
			return driver.findElements(By.tagName(locatorValue));
		} else if (locatorType.equals("id")) {
			return driver.findElements(By.id(locatorValue));
		} else if (locatorType.equals("linktext")) {
			return driver.findElements(By.linkText(locatorValue));
		} else if (locatorType.equals("partiallinktext")) {
			return driver.findElements(By.partialLinkText(locatorValue));
		}
		return null;
	}
	
	/**
	 * Returns a By instance of matching locator type
	 * 
	 * @param locator
	 * @return A By instance of matching locator Type
	 * @author Sandesh
	 */
	protected static By getBy(String locator) {
		splitLocator(locator);

		By by = null;

		if (locatorType.equals("css")) {
			by = By.cssSelector(locatorValue);
		} else if (locatorType.equals("xpath")) {
			by = By.xpath(locatorValue);
		} else if (locatorType.equals("id")) {
			by = By.id(locatorValue);
		} else if (locatorType.equals("name")) {
			by = By.name(locatorValue);
		} else if (locatorType.equals("tagname")) {
			by = By.tagName(locatorValue);
		} else if (locatorType.equals("classname")) {
			by = By.className(locatorValue);
		} else if (locatorType.equals("linktext")) {
			by = By.linkText(locatorValue);
		} else if (locatorType.equals("partiallinktext")) {
			by = By.partialLinkText(locatorValue);
		}

		return by;
	}

	/**
	 * Returns false if element is not found in dom
	 * 
	 * @param locator
	 * @return
	 * @author Sandesh
	 */
	public static boolean isElementPresent(String locator) {
		List<WebElement> temp = getElements(locator);
		return temp.isEmpty();
	}

	/**
	 * Used to Immitate pressing a keyboard key, You can choose to press any
	 * one of the following keys
	 * <ol>
	 * <li> Enter
	 * <li> Tab
	 * </ol>
	 * @author Sandesh
	 */
	public static void hitKey(String keyname) {
		Robot robo = null;
		try {
			robo = new Robot();
		} catch (AWTException e) {
		}

		if (keyname.equalsIgnoreCase("enter")) {
			robo.keyPress(KeyEvent.VK_ENTER);
			robo.keyRelease(KeyEvent.VK_ENTER);
		}else if (keyname.equals("tab")) {
			robo.keyPress(KeyEvent.VK_TAB);
			robo.keyRelease(KeyEvent.VK_TAB);
		}else {
			throw new InvalidKeyName();
		}
	}

}
