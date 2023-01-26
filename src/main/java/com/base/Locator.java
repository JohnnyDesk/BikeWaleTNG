package com.base;

/**
 * This interface contains Locators of the whole Project
 * Locators can be of any type
 * Format to save Locators
 * locatortype##locatorvalue
 * xpath##//div[@id = 2]
 * css##div#2
 * @author Sandesh
 *
 */
public interface Locator {
	
	String loginBtn = "css##div.login-box";
	String enterEmailBox = "xpath##//input[@id='txtLoginid']";
	String enterPasswordBox = "css##input#txtPasswd";
	String signInBtn = "css##button#btnLogin";
	String searchBox_HomePage = "css##input#newBikeList";
	String searchBtn_HomePage = "css##input#btnSearch";
	String suggestionList = "css##li[data-testing-id='global-search-result-list']";
	String selectVariant = "css##p#defversion";
	String changeVariant = "css##div#ddlNewVersionList>ul>li";
	
}
