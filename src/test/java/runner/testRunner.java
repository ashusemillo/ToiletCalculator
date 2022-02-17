package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = "gluecode",
        features = "src/test/java/resources/features/CalculatorPage/",
        tags = "@execute"
        )
public class testRunner extends AbstractTestNGCucumberTests {
}
