package hw4.tests.ex1;

import hw4.data.TestData;
import hw4.steps.LoggedInHomePageSteps;
import hw4.tests.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestEx1 extends BaseClass {
    @Test
    public void assertsForExOne() {
        //5. assert head elements
        assertHead();
        //6. images are displayed
        assertImages();
        //7. assert text below images
        assertTextBelImages();
        //8. assert that there is the iframe
        checkIframe();
        //9. assert that there is the iframe button
        checkIframeBut();
        //10. Back to the original page
        checkDefCont();
        //11. Assert 5 texts in the left section
        assertLeftSec();
        //12. Close browser
        closeBrowser();
    }
    public void assertHead(){
        LoggedInHomePageSteps.checkHeadElementsIsDisplayed(loginPage, TestData.HEADELEMENTS.size());
        LoggedInHomePageSteps.headElementsAssert(loginPage, TestData.HEADELEMENTS);
    }
    public void assertImages(){
        LoggedInHomePageSteps.checkImages(loginPage, TestData.COUNTOFIMAGES);
    }
    public void assertTextBelImages(){
        LoggedInHomePageSteps.checkBelTextImages(loginPage);
    }
    public void checkIframe(){
        LoggedInHomePageSteps.isIFrameDisplayed(loginPage);
    }
    public void checkIframeBut(){
        webDriver.switchTo().frame(loginPage.getIframe());
        LoggedInHomePageSteps.iFrameButExist(loginPage);
        webDriver.switchTo().parentFrame();
    }
    public void checkDefCont(){
        String currentHandle = webDriver.getWindowHandle();
        Assert.assertEquals(originalHandle, currentHandle);
    }
    public void assertLeftSec(){
       LoggedInHomePageSteps.checkLeftFiveTexts(loginPage, TestData.LEFTELEMENTS.size());
       LoggedInHomePageSteps.assertLeftFiveTexts(loginPage);
    }
    public void closeBrowser(){
        webDriver.close();
    }
}
