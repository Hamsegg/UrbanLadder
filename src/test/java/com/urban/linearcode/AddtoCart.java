/*Go To home page
Search "chair" in search box
Fetch first item and get item name
Add item to cart
Verify name with item in cart
Verify FinalPrice and print it.
*/

package com.urban.linearcode;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddtoCart{
	static WebDriver driver;

	public static void popupHandle() {
		try {
			driver.findElement(By.xpath("//a[@class='close-reveal-modal hide-mobile']")).click();
		} catch (Exception ignored) {
			System.out.println("SignUp popup handled failed");
		}
	}

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.urbanladder.com/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// Search "Chair" and click search Btn
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("chair");
		driver.findElement(By.xpath("//span[@class='search-icon icofont-search']")).click();
		WebElement chairItem = driver
				.findElement(By.xpath("//span[normalize-space()='Willow Accent Chair in Multi Coloured Colour']"));
		wait.until(ExpectedConditions.visibilityOf(chairItem));
		String ChairName = chairItem.getText();

		String currwindow = driver.getWindowHandle();

		// click on 1st item
		driver.findElement(By.xpath("//img[@title='Chair Furniture Willow Accent Chair in Multi Coloured Colour']"))
				.click();

//		try {
//			driver.findElement(By.xpath("//a[@class='close-reveal-modal hide-mobile']")).click();
//		} catch (Exception ignored) {
//			System.out.println("SignUp popup handled");
//		}
		popupHandle();
		

		Set<String> allWindows = driver.getWindowHandles();

		for (String windowHandle : allWindows) {
			if (!windowHandle.equalsIgnoreCase(currwindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		
		popupHandle();

		// click add to cart btn
		driver.findElement(By.xpath("//button[@id='add-to-cart-button']")).click();
		String itemNameinCart = driver
				.findElement(By.xpath("//a[normalize-space()='Willow Accent Chair in Multi Coloured Colour']"))
				.getText();

		if (ChairName.equalsIgnoreCase(itemNameinCart)) {
			System.out.println("Item verified");
		}
		
		//PriceVerification

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		WebElement itemPrice = driver.findElement(By.xpath("//div[@class='order-amt upfront-payment']"));
		if(itemPrice.isDisplayed()) {
			System.out.println("itemPrice : "+itemPrice.getText());
		}
		
			
		}

}
