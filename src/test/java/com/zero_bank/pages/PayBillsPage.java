package com.zero_bank.pages;

import com.zero_bank.utilities.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.Random;

public class PayBillsPage extends BasePage{

    public PayBillsPage(){
        PageFactory.initElements(Driver.getDriver(), this); }

    public static final String PAY_SAVED_PAYEE = "Pay Saved Payee";
    public static final String ADD_NEW_PAYEE = "Add New Payee";
    public static final String PURCHASE_FOREIGN_CURRENCY = "Purchase Foreign Currency Bank";

    public static final String PAYEE_SELECT = "Payee Select";
    public static final String ACCOUNT_SELECT = "Account Select";

    public static final String AMOUNT_INPUT_FIELD = "Amount";
    public static final String DATE_INPUT_FIELD = "Date";
    public static final String DESCRIPTION_INPUT_FIELD = "Description";
    public static final String PAYMENT_SUCCESS_MESSAGE = "The payment was successfully submitted.";
    public static final String NEW_PAYEE_CREATED_MESSAGE = "The new payee Pew was successfully created.";
    public static final String CALENDAR_POPUP = "Calendar";
    public static final String PAY_BUTTON = "Pay Button";
    public static final String ADD_BUTTON = "Add";

    @FindBy (id = "add_new_payee")
    private WebElement addButton;

    @FindBy (xpath = "//span[contains(text(), 'The payment was successfully submitted.')]")
    private WebElement paymentSuccessMessage;

    @FindBy (id = "alert_content")
    private WebElement newPayeeCreatedMessage;

    @FindBy (xpath = "//a[contains(text(), 'Pay Saved Payee')]")
    private WebElement paySavedPayee;

    @FindBy (xpath = "//a[contains(text(), 'Add New Payee')]")
    private WebElement addNewPayee;

    @FindBy (xpath = "//a[contains(text(), 'Purchase Foreign Currency')]")
    private WebElement purchaseForeignCurrency;

    @FindBy (xpath = "//select[@id='sp_payee']")
    private WebElement PayeeSelect;

    @FindBy (xpath = "//select[@id='sp_account']")
    private WebElement AccountSelect;

    @FindBy (xpath = "//input[@id='sp_amount']")
    private WebElement amountInputField;

    @FindBy (xpath = "//input[@id='sp_date']")
    private WebElement dateInputField;

    @FindBy (xpath = "//input[@id='sp_description']")
    private WebElement descriptionInputField;

    @FindBy (xpath = "//div[@id='ui-datepicker-div']")
    private WebElement calendar;

    @FindBy (xpath = "//input[@id='pay_saved_payees']")
    private WebElement payButton;

    public void clickOnSomething(String clickable){
        getElement(clickable).click();
    }

    public void clickOnAnyButtonOnAnyPage(String page, String button) {
        pageObjectFactory(page).clickOnSomething(button);
    }

    public WebElement getElement(String clickable) {
        switch (clickable) {
            case PAY_SAVED_PAYEE:
                return paySavedPayee;
            case ADD_NEW_PAYEE:
                return addNewPayee;
            case PURCHASE_FOREIGN_CURRENCY:
                return purchaseForeignCurrency;
            case PAYEE_SELECT:
                return PayeeSelect;
            case ACCOUNT_SELECT:
                return AccountSelect;
            case AMOUNT_INPUT_FIELD:
                return amountInputField;
            case DATE_INPUT_FIELD:
                return dateInputField;
            case DESCRIPTION_INPUT_FIELD:
                return descriptionInputField;
            case PAYMENT_SUCCESS_MESSAGE:
                return paymentSuccessMessage;
            case NEW_PAYEE_CREATED_MESSAGE:
                return newPayeeCreatedMessage;
            case CALENDAR_POPUP:
                return calendar;
            case PAY_BUTTON:
                return payButton;
            case ADD_BUTTON:
                return addButton;
            default:
                return super.getElement(clickable);
        }
    }

    public void fillDataForPaySavedPayee(String payeeSelValue, String accSelValue, String number, String date, String description) {
        BrowserUtils.selectOptions(getElement(PAYEE_SELECT), payeeSelValue);
        BrowserUtils.selectOptions(getElement(ACCOUNT_SELECT), accSelValue);
        getElement(AMOUNT_INPUT_FIELD).sendKeys(String.valueOf(number) + Keys.ENTER);
        getElement(DATE_INPUT_FIELD).sendKeys(date + Keys.ENTER);
        wait.until(ExpectedConditions.invisibilityOf(getElement(CALENDAR_POPUP)));
        getElement(DESCRIPTION_INPUT_FIELD).sendKeys(description + Keys.ENTER);
    }

    public int generateNumber(int length){
        int result = 0;
        int i = 0;
        int len = String.valueOf(length).length();
        while(i < len){
            result = result * 10 + length%10;
            length /= 10;
        }
        return result;
    }

    public String generateDate(){
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        builder.append(20).append(random.nextInt(3)).append(random.nextInt(10)).append('-');
        builder.append(random.nextInt(2));
        if(Character.getNumericValue(builder.charAt(5) ) == 1) builder.append(random.nextInt(3));
        else builder.append(random.nextInt(9));
        builder.append('-');
        int comparison = Character.getNumericValue(builder.charAt(5))*10 + Character.getNumericValue(builder.charAt(6));
        int value = 0;
        switch(comparison) {
            case 1: case 3: case 5:
            case 7: case 8: case 10:
            case 12: value = random.nextInt(31) + 1;
                break;
            case 4: case 6: case 9: case 11:
                value = random.nextInt(29)+1; break;
            case 2: value = random.nextInt(27)+1; break;
        }
        if(value<10) builder.append(0).append(value);
        else builder.append(value);
        return new String(builder);
    }





}
