package hw5.steps;

import hw5.contexts.TestContexts;
import hw5.pages.DifferentElementPage;
import hw5.pages.HomePage;
import hw5.pages.LoginPage;
import hw5.pages.UserTablePage;

public class AbstractStep {
    protected HomePage homePage;
    protected LoginPage loggedInHomePage;
    protected DifferentElementPage differentElementsPage;
    protected UserTablePage userTablePage;


    protected AbstractStep() {
        loggedInHomePage = new LoginPage(TestContexts.getInstance().getDriver());
        differentElementsPage = new DifferentElementPage(TestContexts.getInstance().getDriver());
        userTablePage = new UserTablePage(TestContexts.getInstance().getDriver());
    }
}
