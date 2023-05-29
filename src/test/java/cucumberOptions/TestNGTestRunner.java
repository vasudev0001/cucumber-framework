package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/OrderProduct.feature", glue = "stepDefinitions", dryRun = false, monochrome = true)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

	
}
