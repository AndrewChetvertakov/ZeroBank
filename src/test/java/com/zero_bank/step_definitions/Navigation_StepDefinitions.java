package com.zero_bank.step_definitions;

import com.zero_bank.pages.BasePage;
import com.zero_bank.utilities.Driver;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.zero_bank.pages.BasePage.*;

public class Navigation_StepDefinitions {

    BasePage page;

    /** This method works as a redirect
     *  Precondition: user must be logged into the application
     *  Only works on account pages so far
     * @param pageName - is used to retrieve expected title and click respective page button     */
    @When("user navigates to {string} page")
    public void user_navigates_to_page(String pageName) {
        page = BasePage.pageObjectFactory(pageName);
        String currentTitle = Driver.getDriver().getTitle();
        String expectedTitle = page.navigationHelperTitles(pageName);
        if(!currentTitle.equals(expectedTitle)){
            page = BasePage.pageObjectFactory(ACCOUNT_SUMMARY_PAGE);
            page.clickOnSomething(pageName);
            page.wait.until(ExpectedConditions.titleContains(page.navigationHelperTitles(pageName)));
            page.wait.until(ExpectedConditions.visibilityOf(page.getElement(ZERO_BANK_BUTTON)));
        }
        Assert.assertEquals("Titles mismatch!",
                page.navigationHelperTitles(pageName), Driver.getDriver().getTitle());
        page.clearObjects();
    }

    /**
     * This method is used to Navigate to any page by getting a URL
     * should be used as a precondition to log into application mostly
     * fails to navigate to account pages if user is not logged in
     * URLs are mapped at BasePage
     * @param pageName <-- constant String from BasePage to call page object and url     */
    @When("user navigates to {string} url")
    public void userNavigatesToUrl(String pageName) {
        page = BasePage.pageObjectFactory(LOGIN_PAGE);
        Driver.getDriver().get(page.navigationHelperUrls(pageName));
        page.clearObjects();
    }
}
