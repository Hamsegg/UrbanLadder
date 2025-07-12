package com.urban.linearcode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.urbanladder.com/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		WebElement btn = driver.findElement(By.xpath("//span[@class='header-icon-link user-profile-icon']//*[name()='svg']"));
		WebElement loginElement = driver.findElement(By.xpath("//a[@id='header-icon-login']"));
		WebElement email = driver.findElement(By.xpath("//div[@id='password-credentials']//input[@id='spree_user_email']"));
		WebElement password = driver.findElement(By.xpath("//div[@class='password-wrap']//input[@id='spree_user_password']"));
		WebElement submit = driver.findElement(By.xpath("//input[@id='ul_site_login']"));
		String URL = "https://www.urbanladder.com/login";

		Actions act = new Actions(driver);
		act.moveToElement(btn).moveToElement(loginElement).click().build().perform();

		email.sendKeys("tohordai@gmail.com");
		password.sendKeys("Tohodai@123");
		submit.click();

		// WebElement loginpopup = driver.findElement(By.xpath(null));

		if (driver.getCurrentUrl().equalsIgnoreCase(URL)) {
			WebElement InvalidMsg = driver.findElement(By.xpath("//div[@class='flash ulmessage error  ']"));
			wait.until(ExpectedConditions.visibilityOf(InvalidMsg));

			if (InvalidMsg.isDisplayed()) {
				System.out.println("Invalid login id pass.");
			}
		}
	}
}
