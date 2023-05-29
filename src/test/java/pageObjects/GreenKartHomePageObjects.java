package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.GenericUtils;
import utils.TextContextSetup;

public class GreenKartHomePageObjects extends GenericUtils {
	public WebDriver driver;
	TextContextSetup textContextSetup;

	public GreenKartHomePageObjects(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	private By HomePageSearchField = By.xpath("//input[@class='search-keyword']");
	private By clickOnSearchButton = By.xpath("//div[@class='search']//button[@class='search-button']");
	private By getProductText = By.xpath("//div[@class='product']/h4");
	private By incrementProductNumber = By
			.xpath("//div[@class='product']/div[@class='stepper-input']/a[@class='increment']");
	private By getAddedProcuctCount = By.xpath("//div[@class='product']/div[@class='stepper-input']/input");

	private By cartButton = By.xpath("//div[@class='product-action']/button");
	private By clickOnCartBtn_loc = By.xpath("//a[@class='cart-icon']");
	private By proceedToCheckoutBtn_loc = By.xpath("//div[@class='cart-preview active']//button");
	private By searched_Product_result_loc = By.xpath("//div[@class='product']");

	public void sendTestToSearchField(String valueToBeEntered) {
		sendTextToField(HomePageSearchField, valueToBeEntered);
	}

	public void ClickOnSearchButton_HomePage() {
		clickOnButton(clickOnSearchButton);
	}

	public String getHomePageSearchedProductName() {
		return getElementText(getProductText);
	}

	private void incrementSymbol() {
		clickOnButton(incrementProductNumber);
	}

	private int getCountOfAddedProduct() {
		String count = driver.findElement(getAddedProcuctCount).getAttribute("value");
		return Integer.parseInt(count);

	}

	public void increaseProductCount(int productCount) {
		int a = getCountOfAddedProduct();
		if (a != productCount) {
			for (int i = 1; i < productCount; i++) {
				incrementSymbol();
				a = getCountOfAddedProduct();
				if (a == productCount)
					break;
			}
		}
	}

	public void clickOnCartButton() {
		clickOnButton(cartButton);
	}

	public void clickOnCart() {
		clickOnButton(clickOnCartBtn_loc);
	}

	public void clickOnCheckOutButton_CartPage() {
		clickOnButton(proceedToCheckoutBtn_loc);
	}
	
	public void wait_Untill_Product_Visible_On_HomePage(int timeInSec) {
		waitTillElementVisisble(searched_Product_result_loc, timeInSec);
		
	}

}
