package hw5.pages;

import hw5.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.NoSuchElementException;

public class DifferentElementPage extends AbstractPage {
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

    public DifferentElementPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement getCheckboxByText(String checkboxText) {
        for (WebElement element : checkBoxes) {
            String text = element.getAccessibleName();
            if (text.equals(checkboxText)) {
                return element;
            }
        }
        throw new NoSuchElementException("Element \"" + checkboxText + "\" can not be found");
    }

    public WebElement getRadioByText(String radioText) {
        for (WebElement element : radioBoxes) {
            String text = element.getAccessibleName();
            if (text.equals(radioText)) {
                return element;
            }
        }
        throw new NoSuchElementException("Element \"" + radioText + "\" can not be found");
    }

    public void clickOnCheckbox(String checkboxText) {
        getCheckboxByText(checkboxText).click();
    }

    public void clickOnRadioButton(String radioText) {
        getRadioByText(radioText).click();
    }



    public void selectColor(String color) {
        new Select(colorBut1).selectByVisibleText(color);
    }


    public List<WebElement> getLogs() {
        return logs;
    }
}
