package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

public class CucumberRunner {

    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src/test/resources/features",
            glue = "stepdefinitions",
            plugin = {"pretty", "html:target/cucumber-reports.html"}
    )
    public class TestRunner {
    }
}
