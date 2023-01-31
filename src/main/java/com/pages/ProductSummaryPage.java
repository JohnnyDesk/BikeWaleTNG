package com.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.base.WaitFor;
import com.core.Keyword;

public class ProductSummaryPage extends TestBase {

	public ProductSummaryPage() {
		PageFactory.initElements(Keyword.driver, this);
	}

	/*** =================ELEMENTS======================== ***/

	@FindBy(css = "h3.bikeTitle")
	public static List<WebElement> bikeNames;

	@FindBy(css = "span.bwsprite+span.font18")
	public static List<WebElement> bikePrices;
	
	@FindBy(css = "div.text-xt-light-grey:nth-child(3)")
	public static List<WebElement> bikeSpecs;
	
	@FindBy(css = "div.load-more-btn-container span[style='display: none;']:nth-child(1)")
	public static List<WebElement> loadMoreButtonElement;

	@FindBy(css = "a#loadMoreBikes")
	public static WebElement loadMoreBtn;

	/*** =================METHODS======================== ***/

	public List<String> getAllBikeNames() {

		List<String> listOfBikeNames = new ArrayList<>();

		Iterator<WebElement> itr = bikeNames.iterator();

		while (itr.hasNext()) {
			listOfBikeNames.add(itr.next().getText());
		}

		for (String s : listOfBikeNames) {
			System.out.println(s);
		}

		return listOfBikeNames;
	}
	
	public boolean checkAllBikeNamesHave(String brandName) {
		List<WebElement> listOfBikeNames = bikeNames;

		Iterator<WebElement> itr = listOfBikeNames.iterator();

		boolean b = true;

		while (itr.hasNext()) {
			String bikeName = itr.next().getText();
			if (bikeName.contains(brandName)) {

			} else {
				b = false;
				System.out.println(bikeName + " does not contain the given Brand Name " + brandName);
			}
		}
		return b;
	}


	public List<String> getAllBikePrices() {
		List<String> listOfPrices = new ArrayList<>();

		Iterator<WebElement> itr = bikePrices.iterator();
		while (itr.hasNext()) {
			String price = itr.next().getText();
			listOfPrices.add(price);
		}

		return listOfPrices;
	}

	/**
	 * returns true if bike price is equal or less than a given amount
	 * @param amount
	 * @return
	 */
	public boolean checkBikePricesAreUnder(int amount) {

		boolean b = true;

		for (String charPrice : getAllBikePrices()) {
			int digitPrice = Integer.parseInt(charPrice.replace(",", ""));
			if (digitPrice <= amount) {
			}else {
				b = false;
				System.out.println("Bike has price more than " + amount);
			}
		}

		return b;
	}
	
	/**
	 * returns true if bike price is equal or more than a given amount
	 * @param amount
	 * @return
	 */
	public boolean checkBikePricesAreAbove(int amount) {

		boolean b = true;

		for (String charPrice : getAllBikePrices()) {
			int digitPrice = Integer.parseInt(charPrice.replace(",", ""));
			if (digitPrice >=  amount) {
			}else {
				b = false;
				System.out.println("Bike has price less than " + amount);
			}
		}

		return b;
	}

	public void clickOnLoadMoreBtn() {
		
		int listsize = loadMoreButtonElement.size();

		while (listsize != 1) {
			Keyword.scrollWindowBy(0, 1000);
			loadMoreBtn.click();
			listsize = Keyword.getElementsList("div.load-more-btn-container span[style='display: none;']:nth-child(1)").size();
		}

	}
	
	public boolean checkEngineSizeIsWithin(int minSize, int maxSize) {
		
		List<WebElement> genBikeSpecs = bikeSpecs;
		
		Iterator<WebElement> itr = genBikeSpecs.iterator();
		
		boolean b = true;
		
		while(itr.hasNext()) {
			String bs = itr.next().getText();
			Double cc = Double.parseDouble(bs.split(" ")[0].replace("cc", ""));
			if(cc >= minSize && cc <= maxSize) {
			}else {
				b = false;
			}
		}
		
		return b;
	}
	
	public int getNumberOfBikesDisplayed() {
		int number = 0;
		
		Iterator<WebElement> itr = bikeNames.iterator();
		while(itr.hasNext()) {
			itr.next();
			number++;
		}
		
		return number;
	}
}