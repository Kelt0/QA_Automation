package hw5;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/hw5.features/ex1.feature"},
        glue = {"hw5.steps"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class RunAcceptanceTests extends AbstractTestNGCucumberTests {}