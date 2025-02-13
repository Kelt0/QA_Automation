package hw2.ex1;

import hw2.BaseClass;
import hw2.data.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestEx1 extends BaseClass {
    @Test
    public void assertsForExOne() {
        //5.Assert head elements
        WebElement home = webDriver.findElement(By.xpath("//a[contains(text(), \"Home\")]"));
        WebElement contactForm = webDriver.findElement(By.xpath("//a[contains(text(), \"Contact form\")]"));
        WebElement service = webDriver.findElement(By.xpath("//a[contains(text(), \" Service                        \")]"));
        WebElement metalsAndColors = webDriver.findElement(By.xpath("//a[contains(text(), \"Metals & Colors\")]"));
        List<WebElement> headel = List.of(home, contactForm, service, metalsAndColors);
        for (int i = 0; i < headel.size(); i++) {
            Assert.assertEquals(headel.get(i).getText(), TestData.HEADELEMENTS.get(i));
        }
        //6.Assert 4 images
        List<WebElement> images = webDriver.findElements(By.cssSelector("div.benefit-icon"));
        for (int i = 0; i < 4; i++) {
            images.get(i).isDisplayed();
        }
        //7.Assert 4 text under icons
        List<WebElement> texts = webDriver.findElements(By.xpath("//span[@class = 'benefit-txt']"));
        for (int i = 0; i < 4; i++) {
            texts.get(i).isDisplayed();
            Assert.assertEquals(texts.get(i).getText(), TestData.TEXTUNDERICONS.get(i));
        }
        //8. Assert that there is iframe with frame button is exist
        webDriver.switchTo().frame("frame");
        List<WebElement> iframeCheck = webDriver.findElements(By.xpath("//span[@id='button-frame']"));
        for (int i = 0; i < 1; i++) {
            iframeCheck.get(i).isDisplayed();
        }
        //9. Assert that there is frame button exist
        List<WebElement> iframeCheck2 = webDriver.findElements(By.xpath("//input[@class = 'btn btn-info']"));
        for (int i = 0; i < 1; i++) {
            iframeCheck2.get(i).isDisplayed();
        }
        //10. Back to the original page
        webDriver.switchTo().defaultContent();
        //11. Assert 5 texts in the left section
        WebElement leftHome = webDriver.findElement(By.xpath("//span[text()='Home']"));
        WebElement leftContactForm = webDriver.findElement(By.xpath("//span[text()='Contact form']"));
        WebElement leftService = webDriver.findElement(By.xpath("//span[text()='Service']"));
        WebElement leftMetalAndColors = webDriver.findElement(By.xpath("//span[text()='Metals & Colors']"));
        WebElement leftElementsPacks = webDriver.findElement(By.xpath("//span[text()='Elements packs']"));
        List<WebElement> leftel = List.of(leftHome, leftContactForm, leftService, leftMetalAndColors, leftElementsPacks);
        for (int i = 0; i < leftel.size(); i++) {
            Assert.assertEquals(leftel.get(i).getText(), TestData.LEFTELEMENTS.get(i));
        }
        //12. Close browser
        webDriver.close();
    }
}
