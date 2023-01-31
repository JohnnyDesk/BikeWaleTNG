package com.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.core.Keyword;

public class TestBase extends Keyword{
	
	@BeforeMethod
	public void setup() {
		Keyword.launchBrowser("Edge");
		Keyword.maximizeBrowser();
		Keyword.launchUrl("https://www.bikewale.com");
		
	}
	
	@AfterMethod
	public void tearDown() {
		Keyword.quitBrowser();
	}

}
