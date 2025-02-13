package hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DifferentElementsPage extends AbstractPage{

    @FindBy(xpath = "//input[@type = 'checkbox']")
    private List<WebElement> checkBoxes;

    @FindBy(xpath = "//input[@type='radio']")
    private List<WebElement> radioBoxes;

    @FindBy(xpath = "//select[@class='uui-form-element']")
    private WebElement colorBut1;

    @FindBy(xpath = "//select[@class='uui-form-element']/option[text()='Yellow']")
    private WebElement colorBut2;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li")
    private List<WebElement> logs;

    public DifferentElementsPage(WebDriver webDriver) {
        super(webDriver);
    }


    public List<WebElement> getCheckBoxes() {
        return checkBoxes;
    }

    public List<WebElement> getRadioBoxes() {
        return radioBoxes;
    }

    public WebElement getColorBut1() {
        return colorBut1;
    }

    public WebElement getColorBut2() {
        return colorBut2;
    }

    public List<WebElement> getLogs() {
        return logs;
    }
}
