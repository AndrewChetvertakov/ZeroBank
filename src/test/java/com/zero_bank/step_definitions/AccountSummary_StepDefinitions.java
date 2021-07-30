package com.zero_bank.step_definitions;

import com.zero_bank.pages.AccountSummaryPage;
import com.zero_bank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AccountSummary_StepDefinitions {

    AccountSummaryPage page = new AccountSummaryPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @Then("{string} page title should be {string}")
    public void page_title_should_be(String paramPage, String expectedTitle) {
        page.navigateToPage(paramPage);
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals("Titles mismatch", expectedTitle, actualTitle);
    }

    @Then("Account summary page should have to following account types:")
    public void account_summary_page_should_have_to_following_account_types(List<String> expectedAccountTypes) {
        wait.until(ExpectedConditions.visibilityOf(page.randomDiv));
        for (int i = 0; i < expectedAccountTypes.size(); i++) {
            WebElement element = Driver.getDriver().findElement(By.xpath("//h2[text()='"+expectedAccountTypes.get(i)+"']"));
            System.out.println(element.getText() + " is displayed? -> " + element.isDisplayed());
            Assert.assertTrue(element.isDisplayed());
        }
    }

    @Then("Credit Accounts table must have columns:")
    public void credit_accounts_table_must_have_columns(List<String> columns) {
        wait.until(ExpectedConditions.visibilityOf(page.randomDiv));
        for (int i = 0; i < columns.size(); i++) {
            WebElement element = Driver.getDriver().
                    findElement(By.xpath("(//table[@class='table'])[3]//th[contains(text(), '"+columns.get(i)+"')]"));
            System.out.println(element.getText() + " is displayed? -> " + element.isDisplayed());
            Assert.assertTrue(element.isDisplayed());
        }


    }


}
