package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GreenKartHomePageObjects {
	public WebDriver driver;

	public GreenKartHomePageObjects(WebDriver driver) {
		this.driver = driver;
	}

	By HomePageSearchField = By.xpath("//input[@class='search-keyword']");
	By clickOnSearchButton = By.xpath("//div[@class='search']//button[@class='search-button']");
	By getProductText = By.xpath("//div[@class='product']/h4");

	public void sendTestToSearchField(String valueToBeEntered) {
		driver.findElement(HomePageSearchField).sendKeys(valueToBeEntered);
	}

	public void ClickOnSearchButton_HomePage() {
		driver.findElement(clickOnSearchButton).click();
	}

	public String getHomePageSearchedProductName() {
		return driver.findElement(getProductText).getText();
	}
}
