package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features", glue = "stepDefinitions", dryRun = false, monochrome = true)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
