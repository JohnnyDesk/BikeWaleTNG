package com.teststeps;

import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Browse {

	public static RemoteWebDriver driver = null;

	@BeforeMethod
	public void launchBrowser() {
		System.out.println("before method has been called");
		driver = new ChromeDriver();
		driver.get("https://www.bikewale.com");
	}

	@AfterMethod
	private void closeBrowser() {
		System.out.println("after method has been called");
		driver.quit();
	}

//	1st Test Case
	@Test
	public void m2() {

//		Click on Brand Tab
		driver.findElement(By.xpath("//h3[text()='Brand']"));
//		Click on Brand BMW
		driver.findElement(By.xpath("//span[text()='BMW']")).click();
//		Get List of bike names
		List<WebElement> bikeNames = driver.findElements(By.xpath("//h3[@class=\"bikeTitle margin-bottom10\"]"));
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

}
