package com.product_information_page_tests;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.base.Locator;
import com.base.TestBase;
import com.base.WaitFor;
import com.core.Keyword;

public class PiP extends TestBase {
	
	@Test
	public void toVerifyPriceChangesIfVariantIsChanged() throws InterruptedException {
		Keyword.clickOn(Locator.searchBox_HomePage);
		Keyword.enterText(Locator.searchBox_HomePage, "Yamaha FZ S FI");
		WaitFor.elementToBePresent(Locator.suggestionList);
		Keyword.hitKey("Enter");
		Keyword.clickOn(Locator.selectVariant);
		List<WebElement> variants = Keyword.getElements(Locator.changeVariant);
		Iterator<WebElement> itr = variants.iterator();
		while(itr.hasNext()) {
//			click on WebElement
//			need a method which clicks on a element by providing it a WebElement
			Keyword.clickOn(itr.next());
		}
		Thread.sleep(3000);
	}
	
	@Test
	public void check() throws InterruptedException {
		RemoteWebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		WebElement ele = driver.findElement(By.xpath(""));

		driver.get("https://www.bikewale.com");
		driver.findElement(By.cssSelector("input#newBikeList")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#newBikeList")).sendKeys("Yamaha FZ S FI");
		Thread.sleep(3000);
		Keyword.hitKey("Enter");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("p#defversion")).click();
		Thread.sleep(3000);
		List<WebElement> variants = driver.findElements(By.cssSelector("div#ddlNewVersionList>ul>li"));
		
		Iterator<WebElement> itr = variants.iterator();
		
		while(itr.hasNext()) {
			itr.next().click();
		}
		
	}
	
	@Test
	public void toVerifyClickOnSpecificPriceBracketCorrectPriceBikesAreShown() throws InterruptedException {
		RemoteWebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("li[data-tabs=\"discoverBudget\"]")).click();    //Under Browse Bikes by Section, Click on Budget Tab
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[title=\"Best bikes under 2 lakh\"]")).click(); //click on under 2 lakhs
		Thread.sleep(2000);
		
		
			
	}

	
	
	
	
	
	
	

}
