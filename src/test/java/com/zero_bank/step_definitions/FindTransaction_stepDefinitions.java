package com.zero_bank.step_definitions;

import com.zero_bank.pages.*;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FindTransaction_stepDefinitions {

    BasePage page;



    @When("the user clicks {string} tab on {string} page")
    public void the_user_enters_date_range_from_to(String button, String pageName) {
        page = BasePage.pageObjectFactory(pageName);
        WebElement element = page.getElement(button);
        page.wait.until(ExpectedConditions.visibilityOf(element));
        page.clickOnAnyButtonOnAnyPage(pageName, button);
        page.clearObjects();
    }


    @When("the user enters date range from {string} to {string}")
    public void theUserEntersDateRangeFromTo(String start, String end) {
        page = BasePage.pageObjectFactory("Account Activity");
        ((AccountActivityPage) page).fillInDates(start, end);
        ((AccountActivityPage) page).clickOnSomething("Find");
        page.clearObjects();
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void resultsTableShouldOnlyShowTransactionsDatesBetweenTo(String start, String end) {
        page = BasePage.pageObjectFactory("Account Activity");
        Assert.assertTrue(((AccountActivityPage) page).checkRangeOfDates(start, end));
        page.clearObjects();
    }

    @And("the results should be sorted by most recent date")
    public void theResultsShouldBeSortedByMostRecentDate() {
//        finish THIS
        page = BasePage.pageObjectFactory("Account Summary");
        ((AccountActivityPage) page).checkIfDatesAreSorted();
        page.clearObjects();

    }
}
