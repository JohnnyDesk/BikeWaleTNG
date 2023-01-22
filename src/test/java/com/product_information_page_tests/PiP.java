package com.product_information_page_tests;

import org.testng.annotations.Test;

import com.base.Locator;
import com.base.TestBase;
import com.core.Keyword;

public class PiP extends TestBase {

	@Test
	public void toVerifyPriceChangesIfVariantIsChanged() throws InterruptedException {
		Keyword.clickOn(Locator.searchBox_HomePage);
		Keyword.enterText(Locator.searchBox_HomePage, "Yamaha FZ S FI");
		Keyword.waitFor(Locator.suggestionList);
		Keyword.hitKey();
	}

}
