package hw5.steps;

import hw5.contexts.TestContexts;
import hw5.pages.DifferentElementPage;
import hw5.pages.UserTablePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThenSteps {
    DifferentElementPage differentElementsPage = new DifferentElementPage(TestContexts.getInstance().getDriver());
    UserTablePage userTablePage = new UserTablePage(TestContexts.getInstance().getDriver());

    @Then("There are {int} logs in Log section on Different Elements Page")
    public void thereAreLogsInLogSection(int expectedNumberOfLogs) {
        Assert.assertEquals(differentElementsPage.getLogs().size(), expectedNumberOfLogs);
    }

    @Then("There is {string} text in the row #{int}")
    public void thereAreTextsInTheRow(String expectedLogText, int i) {
        String currentLog = differentElementsPage.getLogs().get(i - 1).getText();
        Assert.assertTrue(currentLog.contains(expectedLogText));
    }

    @Then("{string} page should be opened")
    public void pageShouldBeOpened(String pageTitle) {
        String actualTitle = userTablePage.getTitle();
        Assert.assertEquals(actualTitle, pageTitle);
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void numberTypeDropdownsShouldBeDisplayedOnOnUserTablePage(int expectedNumberOfDropdowns) {
        Assert.assertEquals(userTablePage.getDropdowns().size(), expectedNumberOfDropdowns);
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void usernamesShouldBeDisplayedOnUserTablePage(int expectedNumberOfUsernames) {
        Assert.assertEquals(userTablePage.getUserNames().size(), expectedNumberOfUsernames);
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void descriptionTextsUnderImagesShouldBeDisplayedOnUserTablePage(int expectedNumberOfDescriptions) {
        Assert.assertEquals(userTablePage.getDescriptionsTexts().size(), expectedNumberOfDescriptions);
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxesShouldBeDisplayedOnUsersTablePage(int expectedNumberOfCheckboxes) {
        Assert.assertEquals(userTablePage.getCheckboxes().size(), expectedNumberOfCheckboxes);
    }

    @Then("User table should contain following values:")
    public void userTableShouldContainFollowingValues(DataTable dataTable) {
        List<Object> expectedTable = Collections.singletonList(dataTable.asList(List.class).subList(1, 6));
        List<List<String>> actualTable = new ArrayList<>();
        for (int i = 0; i < expectedTable.size(); i++) {
            actualTable.add(Arrays.asList(userTablePage.getNumbers().get(i),
                    userTablePage.getUserNames().get(i),
                    userTablePage.getDescriptionsTexts().get(i)));
        }
        Assert.assertEquals(actualTable, expectedTable);
    }

    @Then("droplist should contain values in column Type for user {string}")
    public void droplistShouldContainValuesInColumnTypeForUser(String user, DataTable dataTable) {
        List<String> expectedTable = dataTable.asList().subList(1, 4);
        List<String> actualTable = userTablePage.getDropdownTextsForUser(user);
        Assert.assertEquals(actualTable, expectedTable);
    }
}
