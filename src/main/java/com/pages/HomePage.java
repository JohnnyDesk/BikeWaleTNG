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

	@FindBy(css = "li[data-tabs='discoverBrand']")
	public static WebElement brandTab;
	
	@FindBy(css = "li[data-tabs='discoverBudget']")
	public static WebElement budgetTab;
	
	@FindBy(css = "li[data-tabs='discoverMileage']")
	public static WebElement displacementTab;
	
	@FindBy(css = "a[title='Best bikes under 2 lakh']")
	public static WebElement under2LakhOption;
	
	@FindBy(css = "a[title='Best bikes above 2 lakh']")
	public static WebElement above2LakhOption;
	
	@FindBy(css = "a[title='Best 500cc bikes']")
	public static WebElement _250cc_500ccOption;
	
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
	
	public void clickOnBudgetTab() {
		budgetTab.click();
	}
	
	public void clickOnDisplacementTab() {
		displacementTab.click();
	}
	
	public void clickOn250cc_500cc(){
		_250cc_500ccOption.click();
	}
	
	public void clickOnUnder2Lakh() {
		under2LakhOption.click();
	}
	
	public void clickOnAbove2Lakh() {
		above2LakhOption.click();
	}

	public void clickOnRoyalEnfield() {
		ROYALENFIELD.click();
	}

	public By searchBox_HomePage1 = By.cssSelector("input#newBikeList");

	public void searchBike1(String bikeName) {
		Keyword.driver.findElement(searchBox_HomePage1).sendKeys(bikeName);
	}

}
