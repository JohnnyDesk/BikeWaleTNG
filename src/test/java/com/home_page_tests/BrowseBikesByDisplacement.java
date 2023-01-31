package com.home_page_tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.HomePage;
import com.pages.ProductSummaryPage;

public class BrowseBikesByDisplacement extends TestBase{
	
	@Test
	public void toVerifyIfCorrectEngineSizeBikesAreShown() {
		HomePage onHomePage = new HomePage();
		ProductSummaryPage fromPSP = new ProductSummaryPage();
		
		onHomePage.clickOnDisplacementTab();
		onHomePage.clickOn250cc_500cc();
		fromPSP.clickOnLoadMoreBtn();
		Assert.assertTrue(fromPSP.checkEngineSizeIsWithin(250, 500)); 
		
	}

}
