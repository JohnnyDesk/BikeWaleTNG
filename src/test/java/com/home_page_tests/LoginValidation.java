package com.home_page_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.base.Locator;
import com.base.TestBase;
import com.core.Keyword;
import com.util.GetLocator;

public class LoginValidation extends TestBase {

	@Test(description = "TC_LP_001", priority = 1)
	public void toVerifyLoginIsSuccessfulWithValidCredentials() {

		Keyword.clickOn(Locator.loginBtn);
		Keyword.enterText(Locator.enterEmailBox, "skalambe1998@gmail.com");
		Keyword.enterText(Locator.enterPasswordBox, "Skalambe@1998");
		Keyword.clickOn(Locator.signInBtn);
		Assert.assertTrue(Keyword.isElementPresent(Locator.loginBtn));
	}
	
	@Test(description = "TC_LP_002", priority = 2)
	public void toVerifyLoginIsNotSuccessfulWithInvalidCredentials() {

		Keyword.clickOn(Locator.loginBtn);
		Keyword.enterText(Locator.enterEmailBox, "skalambe1998@gmail.com");
		Keyword.enterText(Locator.enterPasswordBox, "Skalambe@");
		Keyword.clickOn(Locator.signInBtn);
		Assert.assertFalse(Keyword.isElementPresent(Locator.loginBtn));
		
	}
	
	
	
	

}
