package com.brand_information_page_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.HomePage;
import com.pages.ProductSummaryPage;

public class BIP extends TestBase {

	@Test
	public void toVerifyBrandPageContainSameBrandBikes() {
		HomePage onHomePage = new HomePage();
		ProductSummaryPage fromPSP = new ProductSummaryPage();

		onHomePage.clickOnBrandTab();
		onHomePage.clickOnRoyalEnfield();
		Assert.assertTrue(fromPSP.checkAllBikeNamesHave("Royal Enfield"));
	}
	
	

}
