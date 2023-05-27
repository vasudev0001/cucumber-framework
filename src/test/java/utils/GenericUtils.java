package utils;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericUtils {
	public WebDriver driver;

	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement waitTillElementVisisble(By locator, int timeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void switchedToWindow_withURL() {
		Set<String> windows = driver.getWindowHandles();
		for (String id : windows) {
			try {
				driver.switchTo().window(id);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
				boolean b = wait.until(
						ExpectedConditions.urlMatches("https://rahulshettyacademy.com/seleniumPractise/#/offers"));
				if (b == true) {
					System.out.println("switched to the targected window.");
					break;
				}

			} catch (Exception e) {
			}
		}
	}

	public void closeBrowser() {
		driver.close();
	}
	
	public void closeAllWindows() {
		driver.quit();
	}
}
