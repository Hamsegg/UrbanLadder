package com.urban.base;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.urban.utillities.DriverSetup;

public class BaseClass {

	public static WebDriver driver;
	static Logger logger;

	@BeforeClass()
	@Parameters({"browser"})
	public void setup(String browser) throws IOException {

		driver = DriverSetup.initializeBrowser(browser);
		
	}

	@AfterClass()
	public void teardown() {
		driver.quit();
	}
	
	public static Logger getLogger() {
		logger = LogManager.getLogger();
		return logger;
	}

}
