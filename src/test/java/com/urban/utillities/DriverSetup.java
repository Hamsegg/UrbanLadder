package com.urban.utillities;

import java.time.Duration;

/**
 * Utility class for initializing and quitting WebDriver instances.
 * Supports launching Chrome and Edge browsers.
 * Captures screenshots before closing the browser.
 */


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import com.test.utilities.ScreenShot;

public class DriverSetup {
	
    private static WebDriver driver;
//    public Properties p = new Properties();

    // Launches WebDriver based on specified browser name
    public static WebDriver initializeBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            System.out.println("Chrome Browser Launched");
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            System.out.println("Edge Browser Launched");
        } else {
            System.out.println("Invalid browser specified in config.properties. Defaulting to Chrome.");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://urbanladder.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		return driver;
    }
    
    public static WebDriver getDriver() {
    	return driver;
    }
    // Quits WebDriver session and captures screenshot before closing
    public static void quitDriver(WebDriver driver) {
        if (driver != null) {
            ScreenShot.captureScreenshot(driver, "Before_Browser_Close"); // Capture screenshot before closing
            driver.quit();
            System.out.println("Browser Closed");
            driver = null;
        }
    }
	
}