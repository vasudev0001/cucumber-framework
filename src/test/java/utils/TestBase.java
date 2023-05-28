package utils;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	private WebDriver driver;
	Properties prop;

	public WebDriver getDriverInstance() {

		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\global.properties");
			prop.load(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (driver == null) {
			if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe");
				driver = new ChromeDriver();
			}

			driver.manage().window().maximize();
			driver.get(prop.getProperty("URL"));
		}
		return driver;
	}
}
