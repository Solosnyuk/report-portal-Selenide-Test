package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepdefs", //пакет нахождения java шагов
        plugin = {"pretty"}
)

public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
