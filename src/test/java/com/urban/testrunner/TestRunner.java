package com.urban.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
//		".//Features/TC_02_CalculatorWorkflow.feature",".//Features/TC_04_ContactUsPage.feature",".//Features/TC_05_HealthInsurance.feature",
//		".//Features/TC_06_PolicyBazaarPartners.feature",".//Features/TC_03_CarInsurance.feature",".//Features/TC_08_TermInsurance.feature",".//Features/TC_07_SignIn.feature
		features = { ".//src//test//resources//feature/TC_01_AddToCart.feature"},

		glue = { "com.urban.stepDefinitions", "com.urban.hooks" }, 
		plugin = { "pretty", "html:test-output/cucumber-reports.html",
				"json:test-output/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" }, 
		monochrome = true
//			dryRun = false,
//			monochrome = true,
//			publish = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
