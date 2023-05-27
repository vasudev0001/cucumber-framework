package utils;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TextContextSetup {
	public WebDriver driver;
	public String homePageProduct;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;

	static int a = 1;

	public TextContextSetup() {
		System.out.println("value of a: " + a);
		testBase = new TestBase();
		pageObjectManager = new PageObjectManager(testBase.getDriverInstance());
		genericUtils = new GenericUtils(testBase.getDriverInstance());
		a++;
	}
}
