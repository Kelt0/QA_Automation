package hw2;

import hw2.data.TestData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BaseClass {
    protected WebDriver webDriver;
    protected String originalHandle;

    @BeforeMethod
    public void beforeConditions() {
        //1.Open test site by URL
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        //2.Assert browser title
        Assert.assertEquals(webDriver.getTitle(), TestData.TITLE);
        //3.Perform login
        webDriver.findElement(By.id("user-icon")).click();
        webDriver.findElement(By.id("name")).sendKeys(TestData.USERNAME);
        webDriver.findElement(By.id("password")).sendKeys(TestData.PASSWORD);
        webDriver.findElement(By.id("login-button")).click();
        //4. Assert Username is loggined
        String actualText = webDriver.findElement(By.id("user-name")).getText();
        Assert.assertEquals(actualText, TestData.USERTEXT);
    }

}