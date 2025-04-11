package hw4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class LoginPage extends AbstractPage {
    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(xpath = "//ul[@class = 'uui-navigation nav navbar-nav m-l8']/li")
    private List<WebElement> headBut;

    @FindBy(xpath = "//div[@class = 'benefit-icon']/span")
    private List<WebElement> images;

    @FindBy(xpath = "//span[@class = 'benefit-txt']")
    private List<WebElement> textBelImg;

    @FindBy(xpath = "//input[@class = 'btn btn-info']")
    private WebElement frameBut;

    @FindBy(tagName = "iframe")
    private WebElement iframe;

    @FindBy(xpath = "//span[text()='Home']")
    private WebElement homeLeft;

    @FindBy(xpath = "//span[text()='Contact form']")
    private WebElement contactLeft;

    @FindBy(xpath = "//span[text()='Service']")
    private WebElement serviceLeft;

    @FindBy(xpath = "//span[text()='Metals & Colors']")
    private WebElement metAndColLeft;

    @FindBy(xpath = "//span[text()='Elements packs']")
    private WebElement elPacksLeft;

    @FindBy(xpath = "//a[@class = 'dropdown-toggle']")
    private WebElement menuServ1;

    @FindBy(xpath = "//a[@href = 'different-elements.html']")
    private WebElement menuSer2;

    public List<WebElement> getTextBelImg() {
        return textBelImg;
    }

    public List<WebElement> getImages() {
        return images;
    }

    public List<WebElement> getHeadBut() {
        return headBut;
    }

    public WebElement getUserName() {
        return userName;
    } //убрали .getText() в hw4 ex1 и сделали юзернейма в веб элемент

    public WebElement getFrameBut() {
        return frameBut;
    }

    public WebElement getIframe() {
        return iframe;
    }

    public List<WebElement> leftEl(){
        List<WebElement> leftElements = new ArrayList<>();
        leftElements.add(homeLeft);
        leftElements.add(contactLeft);
        leftElements.add(serviceLeft);
        leftElements.add(metAndColLeft);
        leftElements.add(elPacksLeft);
        return leftElements;
    }

    public DifferentElementPage clickOnDifferentPageItem(){
        menuServ1.click();
        menuSer2.click();
        return new DifferentElementPage(webDriver);
    }

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }


}
