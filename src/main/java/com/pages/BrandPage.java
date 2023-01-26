package com.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.core.Keyword;

public class BrandPage extends TestBase {

	public BrandPage() {
		PageFactory.initElements(Keyword.driver, this);
	}

	/*** =================ELEMENTS======================== ***/

	@FindBy(css = "h3.bikeTitle")
	public static WebElement bikeName;

	@FindBy(css = "h3.bikeTitle")
	public static List<WebElement> bikeNames;

	/*** =================METHODS======================== ***/

	public boolean checkBikeNameHas(String brandName) {
		List<WebElement> listOfBikeNames = bikeNames;

		Iterator<WebElement> itr = listOfBikeNames.iterator();
		boolean b = true;
		while (itr.hasNext()) {
			String bikeName = itr.next().getText();
			if (bikeName.contains(brandName)) {
				System.out.println(b + " " + bikeName + " correct name");
			} else {
				System.out.println(bikeName + "in--correct name");
			}
		}
		return b;
	}

}