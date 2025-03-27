package hw5.hooks;

import hw5.contexts.TestContexts;
import hw5.projectUtils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {
    @Before
    public void setUp() {
        TestContexts.getInstance().setDriver(DriverManager.createWD());
    }

    @After
    public void tearDown() {
        TestContexts.getInstance().getDriver().quit();
    }
}
