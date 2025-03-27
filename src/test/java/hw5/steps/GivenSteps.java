package hw5.steps;

import hw5.contexts.TestContexts;
import hw5.pages.HomePage;
import io.cucumber.java.en.Given;

public class GivenSteps {
    HomePage homePage = new HomePage(TestContexts.getInstance().getDriver());

    @Given("I open JDI GitHub site on {string}")
    public void openJdiGitHubSite(String pageName) {
        System.out.println("Opening JDI GitHub site on: " + pageName);
        if (pageName.equalsIgnoreCase("Home Page")) {
            homePage.openHomePage();
        } else {
            throw new IllegalArgumentException("Unknown page: " + pageName);
        }
    }

    @Given("I login as user Roman Iovlev")
    public void loginAsUser() {
        homePage.logIn();
    }
}
