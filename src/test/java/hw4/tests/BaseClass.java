package hw4.tests;

import hw4.data.TestData;
import hw4.pages.HomePage;
import hw4.pages.LoginPage;
import hw4.projectUtils.BeforeClass;
import hw4.steps.DifferentElementsPageSteps;
import hw4.steps.HomePageSteps;
import hw4.steps.LoggedInHomePageSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
    protected WebDriver webDriver;
    protected String originalHandle;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected DifferentElementsPageSteps differentElementsPageSteps;

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
        HomePageSteps.checkHomePageWithCorrectTitle(homePage, TestData.TITLE);
    }
    public void loginMethod(){
        loginPage = HomePageSteps.login(homePage);
    }
    public void assertUsername(){
        LoggedInHomePageSteps.usernameAssert(loginPage, TestData.USERTEXT);
    }

}