package com.zero_bank.step_definitions;
import com.zero_bank.pages.AccountSummaryPage;
import com.zero_bank.pages.BasePage;
import com.zero_bank.pages.LoginPage;
import com.zero_bank.utilities.ConfigurationReader;
import com.zero_bank.utilities.Driver;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Navigation_StepDefinitions {

    AccountSummaryPage accountSummaryPage;

    @When("user navigates to {string} page")
    public void user_navigates_to_page(String pageName) {
        String currentTitle = Driver.getDriver().getTitle();
        accountSummaryPage = new AccountSummaryPage();

        if (currentTitle.isEmpty())
            Driver.getDriver().get(ConfigurationReader.getProperty("zeroBank"));

            // am I logged in??
            if(!BasePage.isLoggedIn){
                accountSummaryPage.clickOnAnyButtonOnAnyPage("Landing Page", "signInButton");
                accountSummaryPage.wait.until(ExpectedConditions.titleContains(accountSummaryPage.navigationHelperTitles("Login Page")));

                LoginPage loginPage = (LoginPage) accountSummaryPage.pageObjectFactory("Login Page");
                loginPage.performLogin("username", "password");

//                DISABLE IMPLICIT WAITS IF LOGGING IN TWICE PER SCENARIO TO SAVE EXECUTION TIME!!! (inside try catch)

                try {
                    loginPage.resolveUnsecureConnections();
                }catch (TimeoutException e){
                    System.out.println("Second login doesn't have to resolveUnsecureConnections! he-he");
                }
                accountSummaryPage.wait.until(ExpectedConditions.titleContains(accountSummaryPage.navigationHelperTitles("Account Summary")));

            }

            currentTitle = Driver.getDriver().getTitle();
            if(!currentTitle.equals(accountSummaryPage.navigationHelperTitles(pageName))){
            accountSummaryPage.clickOnSomething(pageName);
                accountSummaryPage.wait.until(ExpectedConditions.titleContains(accountSummaryPage.navigationHelperTitles(pageName)));
            }

            Assert.assertEquals("Titles mismatch!",
                    accountSummaryPage.navigationHelperTitles(pageName), Driver.getDriver().getTitle());
    }

}