package com.zero_bank.step_definitions;

import com.github.javafaker.Faker;
import com.zero_bank.pages.*;
import com.zero_bank.utilities.*;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.*;
import java.util.stream.Collectors;

import static com.zero_bank.pages.PayBillsPage.*;

public class PayBills_StepDefinitions {

    BasePage page;

    /** This method asserts if a pop up message in case of invalid inputs is displayed on the Pay Bills page
     *  @param message - expected message text
     *  @param pageName - only works with Pay Bills page so far     */
    @Then("{string} message should pop up on {string} page")
    public void messageShouldPopUpOnPage(String message, String pageName) {
        page = BasePage.pageObjectFactory(pageName);
        String result = page.getElement(AMOUNT_INPUT_FIELD).getAttribute("validationMessage");
        Assert.assertEquals("Pop Up missing!!" ,message, result);
        page.clearObjects();
    }

    /** Inputs different information on different columns based on:
     *  @param operation - used to trigger 2 different conditions:
     *            successfull      missing info     */
    @When("user completes pay operation {string}")
    public void user_completes_pay_operation(String operation) {
        page = BasePage.pageObjectFactory(PAY_BILLS_PAGE);
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
        page = BasePage.pageObjectFactory(PAY_BILLS_PAGE);
        for (String key: data.keySet()) {
            WebElement element = Driver.getDriver().findElement(By.xpath("//*[contains(@id, 'np_new_payee_"+key+"')]"));
            element.sendKeys(data.get(key));
        }
        page.clearObjects();
    }

    /** This method parameterizes Currency fields and checkboxes depending on type of test
     * @param typeOfTransaction - "successfully" for positive test
     *                          - "without entering a value" for negative test
     *                          - "without selecting a currency" for negative test     */
    @When("user tries to calculate cost {string}")
    public void userTriesToCalculateCost(String typeOfTransaction) {
       page = BasePage.pageObjectFactory(PAY_BILLS_PAGE);
        switch(typeOfTransaction){
            case "successfully":
                ((PayBillsPage) page).purchaseForeignCurrencyParameterization("Hong Kong (dollar)", "22.5", SELECTED_CURRENCY_CHECKBOX);
                page.clickOnSomething(PURCHASE_CURRENCY_BUTTON);
                page.wait.until(ExpectedConditions.visibilityOf(page.getElement(FOREIGN_CURRENCY_SUCCESS_MESSAGE)));
                Assert.assertTrue(page.getElement(FOREIGN_CURRENCY_SUCCESS_MESSAGE).isDisplayed());
                break;
            case "without entering a value":
                ((PayBillsPage) page).purchaseForeignCurrencyParameterization("Sweden (krona)", "", US_DOLLAR_CHECKBOX);
                break;
            case "without selecting a currency":
                ((PayBillsPage) page).purchaseForeignCurrencyParameterization("Select One", "750", SELECTED_CURRENCY_CHECKBOX);
                break;
        }
    page.clearObjects();
    }

    /** This method pulls text from alert that pops up after missing a blue in Foreign Currency operations
     *  And Asserts the text against cucumber table
     * @param expectedAlertText - expected text from data table     */
    @Then("{string} alert should appear")
    public void alertShouldAppear(String expectedAlertText) {
        page = BasePage.pageObjectFactory(PAY_BILLS_PAGE);
        page.wait.until(ExpectedConditions.alertIsPresent());
        String result = Driver.getDriver().switchTo().alert().getText();
        Driver.getDriver().switchTo().alert().accept();
        Assert.assertEquals("Expected and Actual mismatch", result, expectedAlertText);
        page.clearObjects();
    }

    /** This method asserts text of all options from Currency Selection Dropdown against data table params
     * @param select - which select as String
     * @param expectedCurrencies - List<String> from cucumber data table     */
    @Then("{string} should have following currencies available:")
    public void shouldHaveFollowingCurrenciesAvailable(String select, List<String> expectedCurrencies) {
        page = BasePage.pageObjectFactory(PAY_BILLS_PAGE);
        page.wait.until(ExpectedConditions.visibilityOf(page.getElement(select)));
        List<String> actualCurrenciesTEXT = new Select(page.getElement(select))
                        .getOptions()
                        .stream()
                        .map(WebElement::getText)
                        .filter(txt -> !txt.equals("Select One"))
                        .collect(Collectors.toList());
        Assert.assertEquals(expectedCurrencies, actualCurrenciesTEXT);
        page.clearObjects();
    }
}
