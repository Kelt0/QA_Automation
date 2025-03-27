package hw5.contexts;

import org.openqa.selenium.WebDriver;

public class TestContexts {
    private static TestContexts instance;
    private WebDriver driver;

    public static TestContexts getInstance() {
        if (instance == null) {
            instance = new TestContexts();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
