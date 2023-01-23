package com.base;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.core.Keyword;

public class WaitFor extends Keyword {

	static WebDriverWait wait = null;
	

	static {
		wait = new WebDriverWait(Keyword.driver, Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofSeconds(2));
	}

	/**
	 * Waits for an Element to be Present in DOM (Document Object Model)
	 * 
	 * @param locator
	 * @author Sandesh
	 */
	public static void elementToBePresent(String locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(getBy(locator)));
	}

	/**
	 * Waits for an Element to be no longer attached to the DOM
	 * @param locator of the element to wait for
	 * @author Sandesh
	 */
	public static void stalenessOfElement(String locator) {
		wait.until(ExpectedConditions.stalenessOf(Keyword.getElement(locator)));
	}
	
	/**
	 * Waits for an Element to be Clickable
	 * @param locator
	 * @author Sandesh
	 */
	public static void elementToBeClickable(String locator) {
		wait.until(ExpectedConditions.elementToBeClickable(getBy(locator)));	
	}

	/**
	 * Wait for checking if an element is either invisible or not present on the DOM.
	 * @param locator
	 */
	public static void elementToBeVisible(String locator) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(getBy(locator)));
	}
	/**
	 * Returns a By instance of matching locator type
	 * 
	 * @param locator
	 * @return A By instance of matching locator Type
	 * @author Sandesh
	 */
	private static By getBy(String locator) {
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

}
