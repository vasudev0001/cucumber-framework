package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.GenericUtils;

public class CountryPageObject extends GenericUtils {
	WebDriver driver;

	public CountryPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	private By country_label_loc = By.xpath("//div[@class='wrapperTwo']/label");
	
	public void wait_Until_Country_Label_Tobe_Displayed(int timeInSeconds) {
		waitTillElementVisisble(country_label_loc, timeInSeconds);
	}

}
