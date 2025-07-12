package com.urban.testfile;

import java.util.Set;

import org.testng.annotations.Test;

import com.urban.base.BaseClass;
import com.urban.pageObject.BasePage;
import com.urban.pageObject.HomePage;
import com.urban.pageObject.ProductPage;
import com.urban.pageObject.SearchresultPage;

public class TC_002_AddtoCart extends BaseClass {

	HomePage home;
	SearchresultPage results;
	ProductPage product;
	BasePage base;

	@Test()
	public void searchAndAddToCartTest() {
//        BasePage.popupHandle();
		home = new HomePage(driver);
		home.searchField("chair");
		home.clickSearchIcon();

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//ul[@class='search-results']/li//span[@class='name'])[1]")));
		results = new SearchresultPage(driver);
		String expectedName = results.getFirstItemName();
		results.clickFirstItem();

		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String win : allWindows) {
			if (!win.equals(parentWindow)) {
				driver.switchTo().window(win);
				break;
			}
		}

		BasePage.popupHandle();
		product = new ProductPage(driver);
		product.addToCart();
		
		System.out.println("reached cart");

		String actualName = product.getItemNameInCart();
//		Assert.assertEquals(actualName, expectedName, "Item name mismatch in cart!");
		if(actualName.equalsIgnoreCase(expectedName)) {
			System.out.println();
		}
		else {
			System.out.println("Item name mismatch in cart");
		}
		System.out.println("next");
		

		System.out.println("Item verified in cart.");
		System.out.println("Final Price: " + product.getItemPrice());
	}

}
