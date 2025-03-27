package hw5.projectUtils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverManager {
    public static WebDriver createWD(){
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
        return webDriver;
    }
}
