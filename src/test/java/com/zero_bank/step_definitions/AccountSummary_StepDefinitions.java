package com.zero_bank.step_definitions;

import com.zero_bank.pages.BasePage;
import com.zero_bank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.zero_bank.pages.AccountSummaryPage.*;

public class AccountSummary_StepDefinitions {

    BasePage page;

    /** This method asserts current title of current page versus expected title from Cukes parameter
     * @param paramPage - name of the Page for expected title retrieval
     * @param expectedTitle - expected title from Cukes parameter     */
    @Then("{string} page title should be {string}")
    public void page_title_should_be(String paramPage, String expectedTitle) {
        BasePage page = BasePage.pageObjectFactory(paramPage);
        String actualTitle = Driver.getDriver().getTitle();
        page.wait.until(ExpectedConditions.titleContains(expectedTitle));
        Assert.assertEquals("Titles mismatch", expectedTitle, actualTitle);
        page.clearObjects();
    }

    /** This method checks if all the elements from Cukes parameter are displayed on the page
     * @param expectedAccountTypes - List of expected values that are displayed    */
    @Then("Account summary page should have to following account types:")
    public void account_summary_page_should_have_to_following_account_types(List<String> expectedAccountTypes) {
        page = BasePage.pageObjectFactory(ACCOUNT_SUMMARY_PAGE);
        page.wait.until(ExpectedConditions.visibilityOf(page.getElement(RANDOM_DIV)));
        for (String expectedAccountType : expectedAccountTypes) {
            WebElement element = Driver.getDriver().findElement(By.xpath("//h2[text()='" + expectedAccountType + "']"));
            System.out.println(element.getText() + " is displayed? -> " + element.isDisplayed());
            Assert.assertTrue(element.isDisplayed());
            page.clearObjects();
        }
    }

    /** This method checks if all the elements from Cukes parameter are displayed on the page
     * @param columns - List of expected values that are displayed     */
    @Then("Credit Accounts table must have columns:")
    public void credit_accounts_table_must_have_columns(List<String> columns) {
        page = BasePage.pageObjectFactory(ACCOUNT_SUMMARY_PAGE);
        page.wait.until(ExpectedConditions.visibilityOf(page.getElement(RANDOM_DIV)));
        for (String column : columns) {
            WebElement element = Driver.getDriver()
                .findElement(By.xpath("(//table[@class='table'])[3]//th[contains(text(), '" + column + "')]"));
            System.out.println(element.getText() + " is displayed? -> " + element.isDisplayed());
            Assert.assertTrue(element.isDisplayed());
            page.clearObjects();
        }
    }

}
