package com.urban.linearcode;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HoverAndPrintSubmenu {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://www.urbanladder.com/");

        // Close the popup if it appears
//        try {
//            WebElement closePopup = driver.findElement(By.cssSelector("a.close-reveal-modal"));
//           closePopup.click();
//            }catch (Exception e) {
//            // Popup not present
//            	e.printStackTrace();
//            	System.out.println("error occured");
//        }

        // Hover over "Sofas & Recliners"
        
        WebElement sofasMenu = driver.findElement(By.xpath("//span[normalize-space()='Sofas & Recliners']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(sofasMenu).click().build().perform();

        // Wait and collect submenu items
        List<WebElement> submenuItems = driver.findElements(By.xpath("//ul[@class = 'inline-list left']//li[1]//ul"));

        System.out.println("Submenu items under 'Sofas & Recliners':");
        for (WebElement item : submenuItems) {
            System.out.println("- " + item.getText());
        }

//        driver.quit();
    }
}
