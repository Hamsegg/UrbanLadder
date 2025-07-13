package com.urban.hooks;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.urban.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	WebDriver driver;
	Properties properties;

	@Before
	public void setup() throws Exception {
		String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
	
		driver = BaseClass.initilizeBrowser(browser);
		properties = BaseClass.getProperties();

		String baseUrl = properties.getProperty("appURL");

		driver.get(baseUrl);

	}

	@After
	public void tearDown() {

		driver.quit();

	}

//	@AfterStep
//	public void addScreenshot(Scenario scenario) {
//
//		// this is for cucumber junit report
//		if (scenario.isFailed()) {
//
//			TakesScreenshot ts = (TakesScreenshot) driver;
//			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
//			scenario.attach(screenshot, "image/png", scenario.getName());
//
//		}
//
//	}

}
