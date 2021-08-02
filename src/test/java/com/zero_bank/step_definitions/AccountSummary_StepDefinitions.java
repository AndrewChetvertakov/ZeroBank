package com.zero_bank.step_definitions;


import com.zero_bank.pages.AccountSummaryPage;
import com.zero_bank.pages.BasePage;
import com.zero_bank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AccountSummary_StepDefinitions {

    BasePage page;

    @Then("{string} page title should be {string}")
    public void page_title_should_be(String paramPage, String expectedTitle) {
        BasePage page = BasePage.pageObjectFactory(paramPage);
        page.clickOnSomething(paramPage);
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals("Titles mismatch", expectedTitle, actualTitle);
    }

    @Then("Account summary page should have to following account types:")
    public void account_summary_page_should_have_to_following_account_types(List<String> expectedAccountTypes) {
        page = BasePage.pageObjectFactory("Account Summary");
        page.wait.until(ExpectedConditions.visibilityOf(page.getElement("Random Div")));
        for (int i = 0; i < expectedAccountTypes.size(); i++) {
            WebElement element = Driver.getDriver().findElement(By.xpath("//h2[text()='"+expectedAccountTypes.get(i)+"']"));
            System.out.println(element.getText() + " is displayed? -> " + element.isDisplayed());
            Assert.assertTrue(element.isDisplayed());
            page.clearObjects();
        }
    }

    @Then("Credit Accounts table must have columns:")
    public void credit_accounts_table_must_have_columns(List<String> columns) {
        page = BasePage.pageObjectFactory("Account Summary");
        page.wait.until(ExpectedConditions.visibilityOf(page.getElement("Random Div")));
        for (int i = 0; i < columns.size(); i++) {
            WebElement element = Driver.getDriver().
            findElement(By.xpath("(//table[@class='table'])[3]//th[contains(text(), '"+columns.get(i)+"')]"));
            System.out.println(element.getText() + " is displayed? -> " + element.isDisplayed());
            Assert.assertTrue(element.isDisplayed());
            page.clearObjects();
        }


    }


    @Then("error message Login and or password are wrong should be displayed")
    public void errorMessageLoginAndOrPasswordAreWrongShouldBeDisplayed() {

    }
}
