package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckOutPage;
import pageObjects.CountryPageObject;
import pageObjects.GreenKartHomePageObjects;
import utils.TextContextSetup;

public class OrderPage {
	TextContextSetup textContextSetup;
	GreenKartHomePageObjects homePage_obj;
	CheckOutPage checkOutPage;
	CountryPageObject countryPage_ObjectRef;

	public OrderPage(TextContextSetup textContextSetup) {
		this.textContextSetup = textContextSetup;
		homePage_obj = textContextSetup.pageObjectManager.instantiateGreenKartHomePageObjects();
		checkOutPage = textContextSetup.pageObjectManager.instantiateCheckOutPage();
		countryPage_ObjectRef = textContextSetup.pageObjectManager.instantiateCountryPageObject();
	}

	@Given("search for a product in greenKart home page")
	public void search_for_a_product_in_green_kart_home_page() {
		homePage_obj.sendTestToSearchField("tom");
	}

	@When("if product found then increase the quantity and add to cart")
	public void if_product_found_then_increase_the_quantity_and_add_to_cart() {
		String searchedProduct = homePage_obj.getHomePageSearchedProductName();
		System.out.println("Searched product: " + searchedProduct);
		homePage_obj.wait_Untill_Product_Visible_On_HomePage(2);
		homePage_obj.increaseProductCount(5);
		homePage_obj.clickOnCartButton();

	}

	@When("Open cart and check added product is correct")
	public void open_cart_and_check_added_product_is_correct() {
		homePage_obj.clickOnCart();
		homePage_obj.clickOnCheckOutButton_CartPage();
		checkOutPage.wait_Untill_ProductTable_Displayed_On_CheckoutPage(2);
		int colIndex = checkOutPage.getTableHeaderIndexWithName("Product Name");
		int colIndex1 = checkOutPage.getTableHeaderIndexWithName("Quantiry");
		int rowIndex = checkOutPage.getRowData("Tomato", colIndex);
		String nameOfProduct = checkOutPage.getTableValue(rowIndex, colIndex);
		String SelectedQuantity = checkOutPage.getTableValue(rowIndex, colIndex1);
		System.out.println("Name of the Product: " + nameOfProduct);
		System.out.println("Selected quantity: " + SelectedQuantity);

	}

	@Then("place the order and verify the error message")
	public void place_the_order_and_verify_the_error_message() {
		checkOutPage.clickOnPlaceOrderButton();
		countryPage_ObjectRef.wait_Until_Country_Label_Tobe_Displayed(2);
		checkOutPage.selectDropdownOption("India");
		checkOutPage.clickOnCheckOutCheckBox();
		checkOutPage.clickOnProceedBtn();
		String OrderSuccessMsg = checkOutPage.getOrderSuccessMessage().split("You'll")[0];
		System.out.println("Order Success Message: " + OrderSuccessMsg);

	}
}
