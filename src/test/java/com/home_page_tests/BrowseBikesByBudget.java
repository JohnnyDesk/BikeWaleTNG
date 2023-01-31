package com.home_page_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.core.Keyword;
import com.pages.HomePage;
import com.pages.ProductSummaryPage;

public class BrowseBikesByBudget extends TestBase{

	
	@Test
	public void toVerifyIfBikesAreUnderTwoLakh() {
		HomePage onHomePage = new HomePage();
		ProductSummaryPage fromPSP = new ProductSummaryPage();
		
		onHomePage.clickOnBudgetTab();
		onHomePage.clickOnUnder2Lakh();
		fromPSP.clickOnLoadMoreBtn();
		Assert.assertTrue(fromPSP.checkBikePricesAreUnder(200000),"All Bikes are within given amount");

	}
	
	@Test
	public void toVerifyIfBikesAreAboveTwoLakh() {
		HomePage onHomePage = new HomePage();
		ProductSummaryPage fromPSP = new ProductSummaryPage();
		
		onHomePage.clickOnBudgetTab();
		onHomePage.clickOnAbove2Lakh();
		fromPSP.clickOnLoadMoreBtn();
		Assert.assertTrue(fromPSP.checkBikePricesAreAbove(200000),"All Bikes are within given amount");

	}

}
