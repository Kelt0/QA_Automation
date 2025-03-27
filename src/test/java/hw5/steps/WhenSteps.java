package hw5.steps;

import hw5.contexts.TestContexts;
import hw5.pages.DifferentElementPage;
import hw5.pages.LoginPage;
import hw5.pages.UserTablePage;
import io.cucumber.java.en.When;

public class WhenSteps {
    LoginPage loggedInHomePage = new LoginPage(TestContexts.getInstance().getDriver());
    DifferentElementPage differentElementsPage = new DifferentElementPage(TestContexts.getInstance().getDriver());
    UserTablePage userTablePage = new UserTablePage(TestContexts.getInstance().getDriver());

    @When("I click on {string} button in Header")
    public void click_on_button_in_Header(String linkText) {
        loggedInHomePage.clickOnServiceButton(linkText);
    }

    @When("I click on {string} button in Service dropdown")
    public void clickOnButtonInServiceDropdown(String itemInDropdown) {
        loggedInHomePage.clickOnALinkInHeader(itemInDropdown);
    }

    @When("I select {string} checkbox on Different Elements Page")
    public void selectCheckboxOnDifferentElementsPage(
            String checkboxText) {
        differentElementsPage.clickOnCheckbox(checkboxText);
    }

    @When("I select {string} radio on Different Elements Page")
    public void selectRadioOnDifferentElementsPage(String radioText) {
        differentElementsPage.clickOnRadioButton(radioText);
    }

    @When("I select {string} color in dropdown on Different Elements Page")
    public void selectColorInDropdownOnTheDifferentElementsPage(String color) {
        differentElementsPage.selectColor(color);
    }

    @When("I select 'vip' checkbox for {string}")
    public void selectVipCheckboxForUserOnUserTablePage(String user) {
        userTablePage.clickCheckboxForUser(user);
    }
}
