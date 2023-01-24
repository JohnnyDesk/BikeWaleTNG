package com.product_information_page_tests;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
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
			Keyword.clickOn(itr.next());
			Keyword.driver.navigate().refresh();
			Keyword.clickOn(Locator.selectVariant);
			Keyword.clickOn(itr.next());
		}
		Thread.sleep(3000);
	}
	
	@Test
	public void check() throws InterruptedException {
		RemoteWebDriver driver = new EdgeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.pollingEvery(Duration.ofSeconds(2));
		
		driver.manage().window().maximize();

		driver.get("https://www.bikewale.com");
		driver.findElement(By.cssSelector("input#newBikeList")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#newBikeList")).sendKeys("Yamaha FZ S FI");
		Thread.sleep(3000);
		Keyword.hitKey("Enter");
		Thread.sleep(3000);
		
		
		List<WebElement> variants = driver.findElements(By.cssSelector("div#ddlNewVersionList>ul>li"));
		
		Iterator<WebElement> itr = variants.iterator();
		
		while(itr.hasNext()) {
			
			driver.findElement(By.cssSelector("p#defversion")).click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.stalenessOf(itr.next()));
			itr.next().click();
			Thread.sleep(3000);
		}
		
	}

}
