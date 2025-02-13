package hw4.steps;

import hw4.data.TestData;
import hw4.pages.DifferentElementPage;
import hw4.pages.LoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;


public class LoggedInHomePageSteps {

    @Step("Assert username")
    public static void usernameAssert(LoginPage page, String expected){
        Assert.assertEquals(page.getUserName(), expected);
    }

    @Step("Head elements is displayed")
    public static void checkHeadElementsIsDisplayed(LoginPage page, int expectedNum){
        List<WebElement> headerElements = page.getHeadBut();
        Assert.assertEquals(headerElements.size(), expectedNum);
        for (int i = 0; i < 4; i++) {
            headerElements.get(i).isDisplayed();
        }
    }

    @Step("Assert head elements")
    public static void headElementsAssert(LoginPage page, List<String> expected){
        List<WebElement> headerElements = page.getHeadBut();
        for (int i = 0; i < 4; i++) {
            Assert.assertEquals(headerElements.get(i).getText(), expected.get(i));
        }
    }

    @Step("Are images displayed")
    public static void checkImages(LoginPage page, int expectedNum) {
        Assert.assertEquals(page.getImages().size(), expectedNum);
        for (int i = 0; i < 4; i++) {
            page.getImages().get(i).isDisplayed();
        }
    }

    @Step("Assert text below images")
    public static void checkBelTextImages(LoginPage page){
        List<WebElement> textBelImg = page.getTextBelImg();
        for (int i = 0; i < 4; i++) {
            Assert.assertEquals(textBelImg.get(i).getText(), TestData.TEXTUNDERICONS.get(i));
        }
    }

    @Step("Assert that there is the iframe")
    public static void isIFrameDisplayed(LoginPage page){
        Assert.assertTrue(page.getIframe().isDisplayed());
    }

    @Step("assert that there is the iframe button")
    public static void iFrameButExist(LoginPage page){
        Assert.assertTrue(page.getFrameBut().isDisplayed());
    }


    @Step("Check count of texts in the left section")
    public static void checkLeftFiveTexts(LoginPage page, int expectedNumberOfItems){
        List<WebElement> leftSectionItems = page.leftEl();
        Assert.assertEquals(leftSectionItems.size(), expectedNumberOfItems);

    }
    @Step("Assert 5 texts in the left section")
    public static void assertLeftFiveTexts(LoginPage page){
        List<WebElement> leftSectionItems = page.leftEl();
        for (int i = 0; i < page.leftEl().size(); i++) {
            Assert.assertEquals(leftSectionItems.get(i).getText(), TestData.LEFTELEMENTS.get(i));
        }
    }


    @Step("Open menu Service")
    public static DifferentElementPage servOpen(LoginPage page){
        return page.clickOnDifferentPageItem();
    }

}
