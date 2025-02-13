package hw4.steps;

import hw3.data.TestData;
import hw4.pages.DifferentElementPage;
import hw4.pages.AbstractPage;
import hw4.pages.DifferentElementPage;
import hw4.pages.LoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DifferentElementsPageSteps {
    @Step("select checkboxes")
    public static void checkBxVar(DifferentElementPage page){
        page.getCheckBoxes().get(0).click();
        page.getCheckBoxes().get(2).click();
    }

    @Step("Select radio")
    public static void radioVar(DifferentElementPage page){
        page.getRadioBoxes().get(3).click();
    }

    @Step("Select dropdown")
    public static void colorVar(DifferentElementPage page){
        page.getColorBut1().click();
        page.getColorBut2().click();
    }

    @Step("Log assert")
    public static void logVar(DifferentElementPage page){
        for (int i = 0; i < page.getLogs().size(); i++) {
            page.getLogs().get(i).isDisplayed();
        }
        Assert.assertTrue(page.getLogs().get(0).getText().contains("Yellow"));
        Assert.assertTrue(page.getLogs().get(1).getText().contains("Selen"));
        Assert.assertTrue(page.getLogs().get(2).getText().contains("Wind"));
        Assert.assertTrue(page.getLogs().get(3).getText().contains("Water"));
    }

}
