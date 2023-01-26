package com.brand_information_page_tests;

import org.testng.annotations.Test;

import com.base.TestBase;
import com.base.WaitFor;
import com.core.Keyword;
import com.pages.BrandPage;
import com.pages.HomePage;

public class BIP extends TestBase {

	
	@Test
	public void toVerifyBrandPageContainSameBrandBikes() {
		HomePage onHomePage = new HomePage();
		BrandPage fromBrandPage = new BrandPage();
		
		onHomePage.clickOnBrandTab();
		onHomePage.clickOnRoyalEnfield();
		fromBrandPage.checkBikeNameHas("Royal Enfield");

	}

}
