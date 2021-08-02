package com.zero_bank.step_definitions;

import com.github.javafaker.Faker;
import com.zero_bank.pages.BasePage;
import com.zero_bank.pages.PayBillsPage;
import com.zero_bank.utilities.BrowserUtils;
import com.zero_bank.utilities.Driver;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PayBills_StepDefinitions {


    BasePage page;

    /**
     * Inputs different information on different columns based on:
     * @param operation - used to trigger 2 different conditions:
     *            successfull      missing info */
    @When("user completes pay operation {string}")
    public void user_completes_pay_operation(String operation) {
        page = BasePage.pageObjectFactory("Pay Bills");
        Faker faker = new Faker();
        switch (operation) {
            case "successfully":
                ((PayBillsPage) page).fillDataForPaySavedPayee("Bank of America", "Checking",
                    BrowserUtils.generateStringNumber(3),
                    BrowserUtils.generateStringNumber(3),
                    String.valueOf(faker.phoneNumber()));

            case "without entering the amount and date":
                ((PayBillsPage) page).fillDataForPaySavedPayee("Apple", "Credit Card",
                    "",
                    "",
                    String.valueOf(faker.phoneNumber()));
                break;

            case "without entering the date":
                ((PayBillsPage) page).fillDataForPaySavedPayee("Bank of America", "Checking",
                        BrowserUtils.generateStringNumber(3),
                        "",
                        String.valueOf(faker.phoneNumber()));
                break;

            case "without entering the amount":
                ((PayBillsPage) page).fillDataForPaySavedPayee("Bank of America", "Checking",
                        "",
                        BrowserUtils.generateStringNumber(3),
                        String.valueOf(faker.phoneNumber()));
                System.out.println(Driver.getDriver().getPageSource());
                break;

            default:
                System.out.println("Wrong type of operation input in PayBills_StepDefinitions switch");
        }

        page.clearObjects();
    }
}
