package hw3.tests.ex2;

import hw3.data.TestData;
import hw3.tests.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import hw3.pages.DifferentElementsPage;

import java.util.ArrayList;
import java.util.List;

public class TestEx2 extends BaseClass {
    private DifferentElementsPage differentElementsPage;
    @Test
    public void assertsForExTwo(){
        //5.Open menu Service(different element pages)
        openServiceMenu();
        //6. Select checkboxes
        selectChBx();
        //7. Select radio
        selectRadio();
        //8. Select in dropdown
        selectColor();
        //9. Log assert
        logsCheck();
        //10. Close browser
        closeBr();
    }
    public void openServiceMenu(){
       differentElementsPage = loginPage.clickOnDifferentPageItem();
       Assert.assertEquals(differentElementsPage.getTitle(), TestData.DIFTITLE);
    }

    public void selectChBx(){
        differentElementsPage.getCheckBoxes().get(0).click();
        differentElementsPage.getCheckBoxes().get(2).click();
    }

    public void selectRadio(){
        differentElementsPage.getRadioBoxes().get(3).click();
    }

    public void selectColor(){
        differentElementsPage.getColorBut1().click();
        differentElementsPage.getColorBut2().click();
    }
    public void logsCheck(){
        for (int i = 0; i < differentElementsPage.getLogs().size(); i++) {
            differentElementsPage.getLogs().get(i).isDisplayed();
        }
            Assert.assertTrue(differentElementsPage.getLogs().get(0).getText().contains("Yellow"));
            Assert.assertTrue(differentElementsPage.getLogs().get(1).getText().contains("Selen"));
            Assert.assertTrue(differentElementsPage.getLogs().get(2).getText().contains("Wind"));
            Assert.assertTrue(differentElementsPage.getLogs().get(3).getText().contains("Water"));
    }
    public void closeBr(){
        webDriver.close();
    }
}
