package hw3.tests;

import hw2.data.TestData;
import hw3.pages.HomePage;
import hw3.pages.LoginPage;
import hw3.projectUtils.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseClass {
    protected WebDriver webDriver;
    protected String originalHandle;
    protected HomePage homePage;
    protected LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        //1. open test site
        initialazer();
        //2. assert title
        assertTitle();
        //3. login
        loginMethod();
        //4. assert username
        assertUsername();
    }

    public void initialazer(){
        webDriver = BeforeClass.createWD();
        originalHandle = webDriver.getWindowHandle();
        homePage = new HomePage(webDriver);
        homePage.openHomePage();
    }

    public void assertTitle(){
        Assert.assertEquals(homePage.getTitle(), TestData.TITLE);
    }
    public void loginMethod(){
        loginPage = homePage.logIn();
    }
    public void assertUsername(){
    Assert.assertEquals(loginPage.getUserName().getText(), TestData.USERTEXT);
    }

}