package hw5.projectUtils;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class WebDriverSingleton {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private WebDriverSingleton() {
    }

    public static WebDriver getDriver() {
        String browserName = System.getProperty("browser") == null ? "chrome" : System.getProperty("browser");
        if (Objects.isNull(driver.get())) {
            driver.set(WebDriverFactory.createWebDriver(browserName));
        }
        return driver.get();
    }

    public static void closeDriver() {
        driver.get().quit();
        driver.remove();
    }
}
