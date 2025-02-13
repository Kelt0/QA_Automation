package hw4.tests.ex2;

import hw3.data.TestData;
import hw4.pages.DifferentElementPage;
import hw4.steps.DifferentElementsPageSteps;
import hw4.steps.LoggedInHomePageSteps;
import hw4.tests.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestEx2 extends BaseClass {
    private DifferentElementPage differentElementPage;
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
        differentElementPage = LoggedInHomePageSteps.servOpen(loginPage);
        Assert.assertEquals(differentElementPage.getTitle(), TestData.DIFTITLE);
    }

    public void selectChBx(){
        DifferentElementsPageSteps.checkBxVar(differentElementPage);
    }

    public void selectRadio(){
        DifferentElementsPageSteps.radioVar(differentElementPage);
    }

    public void selectColor(){
        DifferentElementsPageSteps.colorVar(differentElementPage);
    }
    public void logsCheck(){
        DifferentElementsPageSteps.logVar(differentElementPage);
    }
    public void closeBr(){
        webDriver.close();
    }
}
