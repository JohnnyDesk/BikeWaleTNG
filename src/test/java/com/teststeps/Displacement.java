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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Displacement {


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
	@Test(description = "TC_BF_005")
	public void displacementUnder250cc_500cc() {
    	//click on Displacement Tab
    	driver.findElement(By.cssSelector("li[data-tabs=\"discoverMileage\"]")).click();
    	//click on 250cc-500cc	
    	driver.findElement(By.cssSelector("a[title=\"Best 500cc bikes\"]")).click();
    	//Click on Load more
    	driver.executeScript("window.scrollBy(0,1200)");
		driver.findElement(By.cssSelector("a#loadMoreBikes")).click();
		
//		Get specs
		List<WebElement> specs = driver.findElements(By.cssSelector("div.text-xt-light-grey+div.text-xt-light-grey"));

//		Iterate
		Iterator<WebElement> itr = specs.iterator();

		int count = 0;
		while (itr.hasNext()) {
			
			String engineSize = itr.next().getText().split(",")[0].split(" ")[0];
			double i = Double.parseDouble(engineSize);
			
			if (i>= 250 && i<=500) {
				count++;
				System.out.println(count + "\t"+ i);
			} else {
				System.err.println("invalid entry" + "\t" + engineSize);
			}
		}

	}
}