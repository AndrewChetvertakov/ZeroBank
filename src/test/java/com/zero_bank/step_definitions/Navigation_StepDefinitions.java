package com.zero_bank.step_definitions;

import com.zero_bank.pages.BasePage;
import com.zero_bank.utilities.Driver;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Navigation_StepDefinitions {

    BasePage page;

    @When("user navigates to {string} page")
    public void user_navigates_to_page(String pageName) {
        page = BasePage.pageObjectFactory(pageName);
        String currentTitle = Driver.getDriver().getTitle();
        String expectedTitle = page.navigationHelperTitles(pageName);
            if(!currentTitle.equals(expectedTitle)){
                page = BasePage.pageObjectFactory("Account Summary");
                page.clickOnSomething(pageName);
                page.wait.until(ExpectedConditions.titleContains(page.navigationHelperTitles(pageName)));
                page.wait.until(ExpectedConditions.visibilityOf(page.getElement("Zero Bank")));
            }
        Assert.assertEquals("Titles mismatch!",
        page.navigationHelperTitles(pageName), Driver.getDriver().getTitle());
    }

    /**
     * This method is used to Navigate to any page by getting a URL
     * should be used as a precondition to loginto application
     * URLs are mapped at BasePage
     * @param pageName <-- constant String from BasePage to call page object and url
     */
    @When("user navigates to {string} url")
    public void userNavigatesToUrl(String pageName) {
        page = BasePage.pageObjectFactory("Login Page");
        Driver.getDriver().get(page.navigationHelperUrls(pageName));
        page.clearObjects();
    }
}
