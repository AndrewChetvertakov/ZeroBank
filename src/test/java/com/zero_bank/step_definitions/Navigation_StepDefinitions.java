package com.zero_bank.step_definitions;

import com.zero_bank.pages.AccountSummaryPage;
import com.zero_bank.utilities.Driver;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;


public class Navigation_StepDefinitions {

    public Navigation_StepDefinitions() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    AccountSummaryPage accountSummaryPage;

    @When("user navigates to {string} page")
    public void user_navigates_to_page(String pageName) {
        accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.navigateToPage(pageName);
    }


}
