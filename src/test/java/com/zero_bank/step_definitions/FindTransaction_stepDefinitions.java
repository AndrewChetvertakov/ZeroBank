package com.zero_bank.step_definitions;

import com.zero_bank.pages.*;
import com.zero_bank.utilities.*;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.*;
import java.util.stream.Collectors;

import static com.zero_bank.pages.AccountActivityPage.*;

public class FindTransaction_stepDefinitions {

    BasePage page;

    /** This method clicks on any WebElement on any page:
     * @param button - name of WebElement exactly as a String constant from POM for .getElement()
     * @param pageName - name of any page exactly as a String constant from Pom for .pageObjectFactory() */
    @When("the user clicks/accesses {string} tab/link/button on {string} page")
    public void the_user_enters_date_range_from_to(String button, String pageName) {
        page = BasePage.pageObjectFactory(pageName);
        WebElement element = page.getElement(button);
        page.wait.until(ExpectedConditions.visibilityOf(element));
        page.clickOnAnyButtonOnAnyPage(pageName, button);
        page.clearObjects();
    }

    /** This method fills in date range into "Dates" and "to" fields:
     * @param start - starting date (this param goes to "Dates" field)
     * @param end - end date (this param goes to "to" field"     */
    @When("the user enters date range from {string} to {string}")
    public void theUserEntersDateRangeFromTo(String start, String end) {
        page = BasePage.pageObjectFactory(ACCOUNT_ACTIVITY_PAGE);
        ((AccountActivityPage) page).fillInDates(start, end);
        page.clickOnSomething(FIND);
        page.clearObjects();
    }

    /** This method collects all the dates from transactions table and asserts
     * that the dates are in a given range between start and end:
     * @param start - starting date
     * @param end - ending date     */
    @Then("results table should only show transactions dates between {string} to {string}")
    public void resultsTableShouldOnlyShowTransactionsDatesBetweenTo(String start, String end) {
        page = BasePage.pageObjectFactory(ACCOUNT_ACTIVITY_PAGE);
        Assert.assertTrue(((AccountActivityPage) page).checkRangeOfDates(start, end));
        page.clearObjects();
    }

    /**
     * This method will select a specified value on specified page from specified select
     * @param visibleText - text of select option to choose
     * @param selectWebElement - WebElement of <select> type
     * @param pageName - name of page that actions are performed at     */
    @When("user selects value {string} from {string} on {string} page")
    public void userSelectsValueFromOnPage(String visibleText, String selectWebElement, String pageName){
        page = BasePage.pageObjectFactory(pageName);
        BrowserUtils.selectOptions(page.getElement(selectWebElement), visibleText);
        page.clearObjects();
    }


    /** This method calculates number of values from Withdrawal/Deposit tables and returns boolean for assertion
     *  @param condition - is used to specify >=  or == type of comparison
     *  @param numberOfTransactions - expected value for assertion
     *  @param depostOrWithdrawal - type of column to perform assertion on     */
    @And("results table should show {string} {int} results under {string}")
    public void resultsTableShouldShowResultsUnder(String condition, int numberOfTransactions, String depostOrWithdrawal) {
        page = BasePage.pageObjectFactory(ACCOUNT_ACTIVITY_PAGE);
        int i = depostOrWithdrawal.equals("Deposit") ? 3 : 4;  //"Deposit" - 3 and "Withdrawal" - 4
        List<String>  listOfTransactions = Driver.getDriver().findElements(By.xpath(
        "//div[contains(@id, 'filtered_')]/table/thead/tr/th/../../following-sibling::tbody/tr/td[" + i + "]"))
              .stream().map(WebElement::getText)
              .filter(text -> !text.equals(""))
              .collect(Collectors.toList());
        boolean result = false;
        if(condition.equals("at least")) result = listOfTransactions.size() >= numberOfTransactions;
        else if(condition.equals("only")) result = listOfTransactions.size() == numberOfTransactions;
        else System.out.println("Wrong condition in feature file!");
        Assert.assertTrue(result);
        page.clearObjects();
        listOfTransactions.clear();
    }

    //TODO finish the method to assert dates are sorted
    @And("the results should be sorted by most recent date")
    public void theResultsShouldBeSortedByMostRecentDate() {
//        finish THIS
        page = BasePage.pageObjectFactory(ACCOUNT_SUMMARY_PAGE);
        ((AccountActivityPage) page).checkIfDatesAreSorted();
        page.clearObjects();
    }

    /** This method will send argument to description field
     * on Account Activity page and Find Transactions tab
     * @param description - keyword to search by description     */
    @When("user enters description {string}")
    public void userEntersDescription(String description) {
        page = BasePage.pageObjectFactory(ACCOUNT_ACTIVITY_PAGE);
        page.getElement(DESCRIPTION_FIELD).clear();
        page.getElement(DESCRIPTION_FIELD).sendKeys(description);
        page.clearObjects();
    }

    /** This methid will assert search results on
     * Account Activity page and Find Transactions table
     * @param expectedResult - expected result     */
    @Then("results table should only show results containing {string} keyword")
    public void resultsTableShouldOnlyShowResultsContainingKeyword(String expectedResult) {
        page = BasePage.pageObjectFactory(ACCOUNT_ACTIVITY_PAGE);
        List<String>  listOfTransactions = Driver.getDriver().findElements(By.xpath(
            "//div[contains(@id, 'filtered_')]/table/thead/tr/th/../../following-sibling::tbody/tr/td[2]"))
            .stream().map(WebElement::getText)
            .filter(text -> !text.equals(""))
            .collect(Collectors.toList());
        for (String each : listOfTransactions) {
            Assert.assertTrue(each.contains(expectedResult));
        }
        if(listOfTransactions.isEmpty()) {
            Assert.assertTrue(true); // <--if list is empty and loop doesn't run
            System.out.println("No matching search results found.");
        }
    }


}
