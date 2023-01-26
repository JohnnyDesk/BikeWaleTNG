package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Locator;
import com.base.TestBase;
import com.base.WaitFor;
import com.core.Keyword;

public class HomePage extends TestBase {
	
	public HomePage(){
		PageFactory.initElements(Keyword.driver, this);
	}

	/*** =================ELEMENTS======================== ***/

	@FindBy(css = "input#newBikeList")
	public static WebElement searchBox_HomePage;

	@FindBy(css = "div.login-box")
	public static WebElement loginBtn;

	@FindBy(css = "li[data-testing-id='global-search-result-list']")
	public static WebElement suggestionList;

	@FindBy(css = "li#bw-brands")
	public static WebElement brandTab;

	@FindBy(css = "img[alt='Royal Enfield bikes']")
	public static WebElement ROYALENFIELD;

	/*** =================METHODS======================== ***/

	public void clickOnSearchBox_HomePage() {
		Keyword.clickOn(searchBox_HomePage);
	}

	public void searchBike(String bikeName) {
		searchBox_HomePage.sendKeys(bikeName);
	}

	public void clickOnLoginBtn() {
		loginBtn.click();
	}

	public void waitForSuggestionList() {
		WaitFor.elementToBePresent(Locator.suggestionList);
	}

	public void clickOnBrandTab() {
		brandTab.click();
	}

	public void clickOnRoyalEnfield() {
		ROYALENFIELD.click();
	}

	public By searchBox_HomePage1 = By.cssSelector("input#newBikeList");

	public void searchBike1(String bikeName) {
		Keyword.driver.findElement(searchBox_HomePage1).sendKeys(bikeName);
	}

}
