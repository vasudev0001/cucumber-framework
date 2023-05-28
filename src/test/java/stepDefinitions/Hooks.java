package stepDefinitions;

import io.cucumber.java.After;
import utils.TextContextSetup;

public class Hooks {
	private TextContextSetup textContextSetup;
//	private WebDriver driver;

	public Hooks(TextContextSetup textContextSetup) {
		this.textContextSetup = textContextSetup;
		// driver=textContextSetup.testBase.getDriverInstance();
	}

	@After
	public void teardown() {
		textContextSetup.testBase.getDriverInstance().quit();
	}
}
