package com.urban.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Login extends BasePage {

	@FindBy(xpath = "//span[@class='header-icon-link user-profile-icon']//*[name()='svg']")
	WebElement profileIcon;
	@FindBy(xpath = "//a[@id='header-icon-login']")
	WebElement loginLink;
	@FindBy(xpath = "//div[@id='password-credentials']//input[@id='spree_user_email']")
	WebElement emailField;
	@FindBy(xpath = "//div[@class='password-wrap']//input[@id='spree_user_password']")
	WebElement passwordField;
	@FindBy(xpath = "//input[@id='ul_site_login']")
	WebElement loginButton;
	@FindBy(xpath = "//div[@class='flash ulmessage error  ']")
	WebElement invalidLoginMessage;

	public Login(WebDriver driver) {
		super(driver);
	}

	public void login(String email, String password) {
		Actions actions = new Actions(driver);
		actions.moveToElement(profileIcon).moveToElement(loginLink).click().build().perform();

		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		loginButton.click();
	}

	public boolean isLoginFailed(String expectedUrl) {
		if (driver.getCurrentUrl().equalsIgnoreCase(expectedUrl)) {
			wait.until(ExpectedConditions.visibilityOf(invalidLoginMessage));
			return invalidLoginMessage.isDisplayed();
		}
		return false;
	}
}
