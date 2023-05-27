package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopDealsPageObjects {
	public WebDriver driver;

	public TopDealsPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	//table[@class='table table-bordered']/thead//th//span[contains(text(),'Veg/fruit name')]
	
	By topDealsLink = By.xpath("//a[@class='cart-header-navlink' and text()='Top Deals']");
	By vegTableElement = By.xpath(
			"//table[@class='table table-bordered']/thead//th//span[contains(text(),'Veg/fruit name')]");
	By searchField_topdeals = By.xpath("//input[@id='search-field']");
	By searchedProduct_topDealsPage = By.xpath("//table[@class='table table-bordered']//tbody/tr/td[1]");

	public void sendText(String text, By locator) {
		driver.findElement(locator).sendKeys(text);
	}

	public String getTextFromElement(By locator) {
		return driver.findElement(locator).getText();
	}

//-----------
	public void clickONTopDealsLink() {
		driver.findElement(topDealsLink).click();
	}
//	public WebElement wait_Till_VegTable_HeaderVisible_TopDeals() {
//		WebElement vegTableHeader = waitTillElementVisisble(vegTableElement, 2);
//		return vegTableHeader;
//	}

	public void sendTextToTopDealsSearchField(String Searchtext) {
		sendText(Searchtext, searchField_topdeals);
	}

	public String getSearchedProductName() {
		return getTextFromElement(searchedProduct_topDealsPage);
	}

}
