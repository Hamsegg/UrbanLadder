package com.urban.Stepdefination;

import com.urban.base.BaseClass;
import com.urban.pageObject.BasePage;
import com.urban.pageObject.HomePage;
import com.urban.pageObject.ProductPage;
import com.urban.pageObject.SearchresultPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCart {
	
	HomePage home;
	SearchresultPage results;
	ProductPage product;
	BasePage base;
	String expectedName;
	
	@Given("the user is on the home page")
	public void the_user_is_on_the_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	    home = new HomePage(BaseClass.driver);
	}

	@When("the user searches for {string}")
	public void the_user_searches_for(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    home.searchField(string);
	    home.clickSearchIcon();
	}

	@When("clicks the first item and switches to new window")
	public void clicks_the_first_item_and_switches_to_new_window() {
	    // Write code here that turns the phrase above into concrete actions
	    results = new SearchresultPage(BaseClass.driver);
	    expectedName = results.getFirstItemName();
		results.clickFirstItem();
		results.switchWindow();
	}

	@When("adds the item to cart")
	public void adds_the_item_to_cart() {
	    // Write code here that turns the phrase above into concrete actions
		BasePage.popupHandle();
		product = new ProductPage(BaseClass.driver);
		product.addToCart();
	}

	@Then("the item name in cart should match the search result")
	public void the_item_name_in_cart_should_match_the_search_result() {
	    // Write code here that turns the phrase above into concrete actions
		String actualName = product.getItemNameInCart();
		if(actualName.equalsIgnoreCase(expectedName)) {
			System.out.println("Valid Item");
		}
		else {
			System.out.println("Item name mismatch in cart");
		}
	}

	@Then("print the item price")
	public void print_the_item_price() {
	    // Write code here that turns the phrase above into concrete actions
		BaseClass.getLogger().info("Item verified in cart");
		System.out.println("Final Price: " + product.getItemPrice());
	    
	}

}
