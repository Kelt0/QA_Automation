package hw4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {
    protected WebDriver webDriver;

    public AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    public String getTitle(){
        return webDriver.getTitle();
    }
    public WebDriver getWebDriver(){
        return webDriver;
    }
    public void setWebDriver(WebDriver webDriver){
        this.webDriver=webDriver;
    }
}
