package hw2.ex2;

import hw2.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestEx2 extends BaseClass {
    @Test
    public void assertsForExTwo(){
        //5.Open menu Service
        webDriver.findElement(By.xpath("//a[@class = 'dropdown-toggle']")).click();
        webDriver.findElement(By.xpath("//a[@href = 'different-elements.html']")).click();
        //6. Select checkboxes
        List<WebElement> chbx = webDriver.findElements(By.xpath("//input[@type = 'checkbox']"));
        chbx.get(0).click();
        chbx.get(2).click();
        //7. Select radio
        List<WebElement> radio = webDriver.findElements(By.xpath("//input[@type='radio']"));
        radio.get(3).click();
        //8. Select in dropdown
        webDriver.findElement(By.xpath("//select[@class='uui-form-element']")).click();
        webDriver.findElement(By.xpath("//select[@class='uui-form-element']/option[text()='Yellow']")).click();
        //9. Log assert
        List<WebElement> logs = webDriver.findElements(By.xpath("//ul[@class='panel-body-list logs']/li"));
        List<String> strlog = new ArrayList<>();
        for (int i = 0; i < logs.size(); i++) {
            logs.get(i).isDisplayed();
        }
        for (int i = 0; i < logs.size(); i++) {
            strlog.add(logs.get(i).getText());
        }
        Assert.assertTrue(strlog.get(0).contains("Yellow"));
        Assert.assertTrue(strlog.get(1).contains("Selen"));
        Assert.assertTrue(strlog.get(2).contains("Wind"));
        Assert.assertTrue(strlog.get(3).contains("Water"));
        //10. Close browser
//        webDriver.close();
    }
}
