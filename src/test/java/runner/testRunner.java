package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * runner class to execute test classes
 */
@CucumberOptions(
        glue = "gluecode",
        features = "src/test/java/resources/features/CalculatorPage/",
        plugin = { "pretty", "html:target/reports/cucumber-reports.html" },
        monochrome = true,
        tags = "@execute"
        )
public class testRunner extends AbstractTestNGCucumberTests {
}
