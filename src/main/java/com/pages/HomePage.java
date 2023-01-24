package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.core.Keyword;

public class HomePage {

	public HomePage() {
		PageFactory.initElements(Keyword.driver, this);
	}

	/*** ========================================== ***/

	@FindBy(css = "input#newBikeList")
	public WebElement searchBox_HomePage;

	@FindBy(css = "css##div.login-box")
	public WebElement loginBtn;

	/*** ========================================== ***/

	public void clickOnSearchBox_HomePage() {
		Keyword.clickOn(searchBox_HomePage);
	}

	public void searchBike(String bikeName) {
//		Keyword.clickOn(searchBox_HomePage);
//		Keyword.enterText("searchBox_HomePage", bikeName);
		searchBox_HomePage.sendKeys(bikeName);

	}

	public void clickOnLoginBtn() {
		loginBtn.click();
	}

}
