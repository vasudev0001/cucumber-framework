package utils;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericUtils {
	private WebDriver driver;

	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement waitTillElementVisisble(By locator, int timeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void switchedToWindow_withURL(String URL) {
		Set<String> windows = driver.getWindowHandles();
		for (String id : windows) {
			try {
				driver.switchTo().window(id);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
				// "https://rahulshettyacademy.com/seleniumPractise/#/offers"
				boolean b = wait.until(ExpectedConditions.urlMatches(URL));
				if (b == true) {
					System.out.println("switched to the targected window.");
					break;
				}

			} catch (Exception e) {
			}
		}
	}

	public void clickOnButton(By btnLocator) {
		driver.findElement(btnLocator).click();
	}
	public String getElementText(By elementLocator) {
		return driver.findElement(elementLocator).getText();
	}
	
	public void sendTextToField(By locatotr, String valueToBeEntered) {
		driver.findElement(locatotr).sendKeys(valueToBeEntered);
	}
	
	public void selectDropdownValue(By dropdown_loc, String selectValue) {
		Select dd = new Select(driver.findElement(dropdown_loc));
		dd.selectByVisibleText(selectValue);
	}
}
