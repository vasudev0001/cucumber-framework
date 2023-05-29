package utils;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;
import pageObjects.TopDealsPageObjects;

public class TextContextSetup {
	public WebDriver driver;
	public String homePageProduct;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	public TopDealsPageObjects topDealPage;

	public TextContextSetup() {

		testBase = new TestBase();
		pageObjectManager = new PageObjectManager(testBase.getDriverInstance());
		//genericUtils = new GenericUtils(testBase.getDriverInstance());

	}
}
