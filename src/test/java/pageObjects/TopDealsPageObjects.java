package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.GenericUtils;
import utils.TextContextSetup;

public class TopDealsPageObjects extends GenericUtils {
	public WebDriver driver;
	public TextContextSetup textContextSetup;

	public TopDealsPageObjects(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	private By topDealsLink = By.xpath("//a[@class='cart-header-navlink' and text()='Top Deals']");
	private By searchField_topdeals = By.xpath("//input[@id='search-field']");
	private By searchedProduct_topDealsPage = By.xpath("//table[@class='table table-bordered']//tbody/tr/td[1]");
	private String URL = "https://rahulshettyacademy.com/seleniumPractise/#/offers";

	public void clickONTopDealsLink() {
		clickOnButton(topDealsLink);
	}

	public void sendTextToTopDealsSearchField(String Searchtext) {
		sendTextToField(searchField_topdeals, Searchtext);
	}

	public String getSearchedProductName() {
		return getElementText(searchedProduct_topDealsPage);
	}

	public void switchedToWindow() {
		switchedToWindow_withURL(URL);
	}

}
