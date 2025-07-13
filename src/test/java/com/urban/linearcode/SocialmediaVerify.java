package com.urban.linearcode;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SocialmediaVerify {
    public static void main(String[] args) {
        // Set path to ChromeDriver

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Open Urban Ladder website
        driver.get("https://www.urbanladder.com");

        // Scroll to bottom using JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        // Social media domains to check
        String[] platforms = {"pinterest.com", "linkedin.com", "youtube.com"};

        // Get all anchor tags
        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (String platform : platforms) {
            boolean found = false;
            for (WebElement link : links) {
                String href = link.getAttribute("href");
                if (href != null && href.contains(platform)) {
                    found = true;
                    System.out.println(platform + " URL found: " + href);
                    if (href.contains("urbanladder")) {
                        System.out.println("✅ URL contains 'UrbanLadder'");
                    } else {
                        System.out.println("❌ URL does NOT contain 'UrbanLadder'");
                    }
                    break;
                }
            }
            if (!found) {
                System.out.println("⚠️ " + platform + " link not found.");
            }
        }

        driver.quit();
    }
}
