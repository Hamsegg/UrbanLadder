package com.urban.pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	public static WebDriver driver;
	public WebDriverWait wait;
	
	public BasePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public static void popupHandle() {
		try {
			driver.findElement(By.xpath("//a[@class='close-reveal-modal hide-mobile']")).click();
		} catch (Exception ignored) {
			System.out.println("SignUp popup handled failed");
		}
	}
}
