package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

    @RunWith(Cucumber.class)
    @CucumberOptions(
		features = "C:\\Users\\ankit\\eclipse-workspace\\FirstCucumberE2E\\src\\test\\java\\Features"
		,glue={"StepDefinations"}
		)

public class TestRuner {



}
