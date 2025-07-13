package com.urban.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='search']")
	WebElement searchField;
	
	@FindBy(xpath = "//span[@class='search-icon icofont-search']")
	WebElement searchIcon;

	public void searchField(String query) {
		searchField.sendKeys(query);
	}

	public void clickSearchIcon() {
		searchIcon.click();
	}
}
