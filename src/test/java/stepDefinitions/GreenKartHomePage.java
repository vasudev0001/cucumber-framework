package stepDefinitions;

import io.cucumber.java.en.Given; 
import io.cucumber.java.en.When;
import pageObjects.GreenKartHomePageObjects;
import utils.TextContextSetup;

public class GreenKartHomePage {
	TextContextSetup textContextSetup;
	GreenKartHomePageObjects homePage;

	public GreenKartHomePage(TextContextSetup textContextSetup) {
		this.textContextSetup = textContextSetup;
		homePage = textContextSetup.pageObjectManager.instantiateGreenKartHomePageObjects();
	}

	@Given("User landing into Greenkart home page")
	public void user_landing_into_greenkart_home_page() throws InterruptedException {

	}

	@When("user search for a product in the home page with short name of the product")
	public void user_search_for_a_product_in_the_home_page_with_short_name_of_ther_product() {

		homePage.sendTestToSearchField("tom");
		homePage.ClickOnSearchButton_HomePage();
		String productName = homePage.getHomePageSearchedProductName();
		String homePageProduct = productName.split("-")[0].trim();
		System.out.println("product found in the home page search: " + homePageProduct);

	}
}
