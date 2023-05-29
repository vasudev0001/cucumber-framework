package stepDefinitions;

import io.cucumber.java.After;
import utils.TextContextSetup;

public class Hooks {
	private TextContextSetup textContextSetup;

	public Hooks(TextContextSetup textContextSetup) {
		this.textContextSetup = textContextSetup;
	}

	@After
	public void teardown() {
		textContextSetup.testBase.getDriverInstance().quit();
	}
}
