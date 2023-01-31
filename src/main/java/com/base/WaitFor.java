package com.base;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	 * 
	 * @param cssvalue
	 */
	public static void elementToBeInteractable(String cssvalue) {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssvalue)));
	}
	
	/**
	 * 
	 * @param element
	 */
	public static void elementToBePresent(WebElement element) {
		wait.until(ExpectedConditions.presenceOfElementLocated((By)element));
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
	

}
