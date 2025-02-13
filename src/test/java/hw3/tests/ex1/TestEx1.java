package hw3.tests.ex1;

import hw2.data.TestData;
import hw3.projectUtils.BeforeClass;
import hw3.tests.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

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
        toDefCont();
        //11. Assert 5 texts in the left section
        assertLeftSec();
        //12. Close browser
        closeBrowser();
    }
    public void assertHead(){
        for (int i = 0; i < 4; i++) {
        Assert.assertEquals(loginPage.getHeadBut().get(i).getText(), TestData.HEADELEMENTS.get(i));
        }
    }
    public void assertImages(){
        for (int i = 0; i < 4; i++) {
            loginPage.getImages().get(i).isDisplayed();
        }
    }
    public void assertTextBelImages(){
        for (int i = 0; i < 4; i++) {
            Assert.assertEquals(loginPage.getTextBelImg().get(i).getText(), TestData.TEXTUNDERICONS.get(i));
        }
    }
    public void checkIframe(){
        loginPage.getIframe().isDisplayed();
    }
    public void checkIframeBut(){
        webDriver.switchTo().frame("frame");
        loginPage.getFrameBut().isDisplayed();
    }
    public void toDefCont(){
        webDriver.switchTo().defaultContent();
    }
    public void assertLeftSec(){
        for (int i = 0; i < loginPage.leftEl().size(); i++) {
            Assert.assertEquals(loginPage.leftEl().get(i).getText(), TestData.LEFTELEMENTS.get(i));
        }
    }
    public void closeBrowser(){
        webDriver.close();
    }

}
