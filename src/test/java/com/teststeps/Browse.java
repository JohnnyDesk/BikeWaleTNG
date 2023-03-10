package com.teststeps;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Browse {

	public RemoteWebDriver driver = null;
	private final static Logger LOG = Logger.getLogger(Browse.class);

	@BeforeMethod
	public void launchBrowser() {
		LOG.info("browser has been launched successfully");
		driver = new EdgeDriver();
		driver.get("https://www.bikewale.com");
	}

	@AfterMethod
	private void closeBrowser() {
		LOG.info("browser has been closed successfully");
		driver.quit();
	}

	@Test(description = "TC_BF_002")
	public void toVerifyIfCorrectBrandBikesAreDisplayed() {

//		Click on Brand Tab
		driver.findElement(By.cssSelector("li[data-tabs='discoverBrand']")).click();
//		Click on View More Brands
		driver.findElement(By.cssSelector("span.btn-label")).click();
//		Click on Brand BMW
		driver.findElement(By.cssSelector("img[alt='BMW']")).click();
//		Get List of bike names
		List<WebElement> bikeNames = driver.findElements(By.cssSelector("h3.bikeTitle"));
//		Iterate List
		Iterator<WebElement> itr = bikeNames.iterator();
//		Set to true, if all bikes are BMW brand
		boolean b = true;
//		Print List
		while (itr.hasNext()) {
			String bikeName = itr.next().getText();
			if (bikeName.contains("BMW")) {
				System.out.println(bikeName);
			} else {
				b = false;
			}
			Assert.assertEquals(b, true);
		}

	}

	@Test(description = "TC_BF_003")
	public void bikesUnder2Lakh() {

//		Click on Budget Tab
		driver.findElement(By.cssSelector("li[data-tabs='discoverBudget']")).click();
//		Click on Under 2 Lakh
		driver.findElement(By.cssSelector("a[title='Best bikes under 2 lakh']")).click();
//		Click on Load more
		for (int i = 1; i <= 5; i++) {

//			Fluent Wait created
			FluentWait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20))
					.pollingEvery(Duration.ofMillis(1500));

//			WebElement
			WebElement loadmore = driver.findElement(By.cssSelector("a#loadMoreBikes"));

//			Fluent wait used on element
			wait.until(ExpectedConditions.elementToBeClickable(loadmore));
			driver.executeScript("window.scrollBy(0,600)");
			loadmore.click();

		}

//		Sleep
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

//		Get Prices
		List<WebElement> prices = driver.findElements(By.cssSelector("span.inr-lg+span.font18"));

//		Iterate
		Iterator<WebElement> itr = prices.iterator();

		int count = 0;
		boolean b = true;

		while (itr.hasNext()) {

			String price = itr.next().getText();
			String formatprice = price.replace(",", "");
			int i = Integer.parseInt(formatprice);
			count++;
			if (i < 200000) {
				System.out.println(count + "\t" + i);
			} else {
				b = false;
			}
		}

		if (b == false)
			System.out.println("Entry No. " + count + " has price more than 2 lakh");

	}

	@Test(description = "TC_BF_004")
	public void bikesAbove2Lakh() throws InterruptedException {

		driver.findElement(By.cssSelector("li[data-tabs='discoverBudget']")).click();
		driver.findElement(By.cssSelector("a[title='Best bikes above 2 lakh']")).click();

		WebElement loadmoreBtn = driver.findElement(By.cssSelector("a#loadMoreBikes"));

		while (loadmoreBtn.isDisplayed()) {
			FluentWait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20))
					.pollingEvery(Duration.ofMillis(1500));

//			WebElement
			loadmoreBtn = driver.findElement(By.cssSelector("a#loadMoreBikes"));

//			Fluent wait used on element
			wait.until(ExpectedConditions.elementToBeClickable(loadmoreBtn));
			loadmoreBtn.click();
			driver.executeScript("window.scrollBy(0,600)");
		}

		Thread.sleep(3000);

		List<WebElement> prices = driver.findElements(By.cssSelector("span.inr-lg+span.font18"));

		Iterator<WebElement> itr = prices.iterator();

		int count = 0;
		boolean b = true;

		while (itr.hasNext()) {

			String price = itr.next().getText();
			String formatprice = price.replace(",", "");
			int i = Integer.parseInt(formatprice);
			count++;
			if (i > 200000) {
				System.out.println(count + "\t" + i);
			} else {
				b = false;
			}
		}

		if (b == false)
			System.out.println("Entry No. " + count + " has price less than 2 lakh");

	}

}