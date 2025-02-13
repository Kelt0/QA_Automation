package hw4.pages;

import hw4.data.TestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement logBut;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }
    public HomePage openHomePage(){
        webDriver.get(TestData.URL);
        return this;
    }
    public LoginPage logIn(){
        userIcon.click();
        name.sendKeys(TestData.USERNAME);
        password.sendKeys(TestData.PASSWORD);
        logBut.click();
        return new LoginPage(webDriver);
    }
}
