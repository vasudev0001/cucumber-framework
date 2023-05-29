package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public WebDriver driver;
	public GreenKartHomePageObjects HomePageObject_greenKart;
	public TopDealsPageObjects pageObjects_topDeals;
	public CheckOutPage checkoutPage;
	public CountryPageObject countryPageObjects;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public GreenKartHomePageObjects instantiateGreenKartHomePageObjects() {
		HomePageObject_greenKart = new GreenKartHomePageObjects(driver);
		return HomePageObject_greenKart;
	}

	public TopDealsPageObjects instantiateTopDealsPage() {
		pageObjects_topDeals = new TopDealsPageObjects(driver);
		return pageObjects_topDeals;
	}

	public CheckOutPage instantiateCheckOutPage() {
		CheckOutPage checkOutPage = new CheckOutPage(driver);
		return checkOutPage;
	}

	public CountryPageObject instantiateCountryPageObject() {
		countryPageObjects = new CountryPageObject(driver);
		return countryPageObjects;
	}

}
