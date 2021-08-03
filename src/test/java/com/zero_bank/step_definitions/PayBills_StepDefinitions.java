package com.zero_bank.step_definitions;

import com.github.javafaker.Faker;
import com.zero_bank.pages.*;
import com.zero_bank.utilities.*;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.util.Map;

public class PayBills_StepDefinitions {

    BasePage page;

    /** This method asserts if a pop up message in case of invalid inputs is displayed on the Pay Bills page
     *  @param message - expected message text
     *  @param pageName - only works with Pay Bills page so far     */
    @Then("{string} message should pop up on {string} page")
    public void messageShouldPopUpOnPage(String message, String pageName) {
        page = BasePage.pageObjectFactory(pageName);
        String result = page.getElement("Amount").getAttribute("validationMessage");
        Assert.assertEquals("Pop Up missing!!" ,message, result);
        page.clearObjects();
    }

    /** Inputs different information on different columns based on:
     *  @param operation - used to trigger 2 different conditions:
     *            successfull      missing info     */
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
                break;
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
            case "entering date as text":
                ((PayBillsPage) page).fillDataForPaySavedPayee("Bank of America", "Checking",
                        BrowserUtils.generateStringNumber(3),
                        "Thirtieth of September two thousand twenty one",
                        String.valueOf(faker.phoneNumber()));
                break;
            default:
                System.out.println("Wrong type of operation input in PayBills_StepDefinitions switch");
        }
        page.clearObjects();
    }

    /** This method fills in information for creating New Payee on Pay Bills page
     * @param data - Map<key, value> where key is used to concatenate locator of input field
     *             and value is used in sendkeys(value)     */
    @And("the user creates new payee using following information:")
    public void theUserCreatesNewPayeeUsingFollowingInformation(Map<String, String> data){
        page = BasePage.pageObjectFactory("Pay Bills");
        for (String key: data.keySet()) {
            WebElement element = Driver.getDriver().findElement(By.xpath("//*[contains(@id, 'np_new_payee_"+key+"')]"));
            element.sendKeys(data.get(key));
        }
        page.clearObjects();
    }

}
