package com.zero_bank.step_definitions;

import com.zero_bank.pages.AccountActivityPage;
import com.zero_bank.pages.AccountSummaryPage;
import com.zero_bank.pages.LandingPage;
import com.zero_bank.pages.LoginPage;
import com.zero_bank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindTransaction_stepDefinitions {

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    LoginPage loginPage;
    AccountSummaryPage accountSummaryPage;
    AccountActivityPage accountActivityPage;


    @And("user login to the application")
    public void userLoginToTheApplication() {
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnSomething("signInButton");

        loginPage = new LoginPage();
        loginPage.performLogin("username", "password");
        loginPage.resolveUnsecureConnections();
    }

    @When("the user clicks {string} tab on {string} page")
    public void the_user_enters_date_range_from_to(String button, String page) {
        accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.clickOnAnyButtonOnAnyPage(page, button);
    }


    @When("the user enters date range from {string} to {string}")
    public void theUserEntersDateRangeFromTo(String start, String end) {
        accountActivityPage = new AccountActivityPage();
        accountActivityPage.fillInDates(start, end);
        accountActivityPage.clickOnSomething("Find");
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void resultsTableShouldOnlyShowTransactionsDatesBetweenTo(String start, String end) {
        Assert.assertTrue(accountActivityPage.checkRangeOfDates(start, end));
    }

    @And("the results should be sorted by most recent date")
    public void theResultsShouldBeSortedByMostRecentDate() {
//        finish THIS
        accountActivityPage.checkIfDatesAreSorted();


    }
}
