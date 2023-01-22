package com.core;

import java.awt.Robot;
import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.Locator;
import com.exceptions.InvalidBrowserNameException;

public class Keyword {

	public static RemoteWebDriver driver = null;

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
	 * Keyword to launch a specific URL
	 * 
	 * @param url
	 * @author Sandesh
	 */
	public static void launchUrl(String url) {
		driver.get(url);
	}

	/**
	 * This keyword splits Locators from Locator Interface
	 * 
	 * @author Sandesh
	 */
	public static void clickOn(String locator) {
		getElement(locator).click();
	}

	/**
	 * This Keyword is used to Enter text in a particular text field
	 * 
	 * @param locator
	 * @param text
	 * @author Sandesh
	 */
	public static void enterText(String locator, String text) {
		getElement(locator).sendKeys(text);
	}

	/**
	 * This Keyword returns a WebElement by providing a locator from Locator
	 * interface
	 * 
	 * @param locator
	 * @return
	 * @author Sandesh
	 */
	public static WebElement getElement(String locator) {
		String locatorType = locator.split("##")[0].toLowerCase();
		String locatorValue = locator.split("##")[1];

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
	 * This Keyword Returns a List of WebElements by providing a locator from
	 * Locator interface
	 * 
	 * @param locator
	 * @return
	 */
	public static List<WebElement> getElements(String locator) {
		String locatorType = locator.split("##")[0].toLowerCase();
		String locatorValue = locator.split("##")[1];

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
	 * This Keyword returns false if element is not found on page
	 * @param locator
	 * @return
	 * @author Sandesh
	 */
	public static boolean isElementPresent(String locator) {
		List<WebElement> temp = getElements(locator);
		return temp.isEmpty();
	}

	public static void hitKey(){
		Robot robo = null;
		try {
			robo = new Robot();
		} catch (AWTException e) {
		}

		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
	}
	
	/**
	 * 
	 * @param locator
	 */
	public static void waitFor(String locator) {
		String locatorType = locator.split("##")[0].toLowerCase();
		String locatorValue = locator.split("##")[1];
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locatorValue)));
	}
}
