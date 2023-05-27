package stepDefinitions;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.Then;
import pageObjects.TopDealsPageObjects;
import utils.TextContextSetup;

public class TopDealsPage {

	TextContextSetup textContextSetup;
	String dealsPAge_product;
	TopDealsPageObjects topDealPage;

	public TopDealsPage(TextContextSetup textContextSetup) {
		this.textContextSetup = textContextSetup;
		topDealPage = textContextSetup.pageObjectManager.instantiateTopDealsPage();
	}

	@Then("user search for a product on the top deals page")
	public String user_search_for_a_product_on_the_top_deals_page() throws InterruptedException {

		// topDealPage = textContextSetup.pageObjectManager.instantiateTopDealsPage();
		topDealPage.clickONTopDealsLink();
		textContextSetup.genericUtils.switchedToWindow_withURL();
		topDealPage.sendTextToTopDealsSearchField("tom");
		String dealsPAge_product = topDealPage.getSearchedProductName();
		System.out.println("product found in top deals page: " + dealsPAge_product);
		return dealsPAge_product;
	}

	@Then("check whether the home page search product matched with the top deals searched product")
	public void check_whether_the_home_page_search_product_matched_with_the_top_deals_searched_product()
			throws InterruptedException {
		assertEquals(textContextSetup.homePageProduct, dealsPAge_product, "both are differernt products");
		System.out.println("Both searched products are same. It displays correct product.");
		textContextSetup.genericUtils.closeBrowser();
		textContextSetup.genericUtils.closeAllWindows();
	}

}
