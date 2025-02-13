package hw4.steps;
import hw4.pages.AbstractPage;
import hw4.pages.HomePage;
import hw4.pages.LoginPage;
import io.qameta.allure.Step;
import org.testng.Assert;

public class HomePageSteps {
    @Step("Check homepage title")
    public static void checkHomePageWithCorrectTitle(AbstractPage homepage, String expected){
        Assert.assertEquals(homepage.getTitle(), expected);
    }

    @Step("Login")
    public static LoginPage login(HomePage page){
        return page.logIn();
    }

}
