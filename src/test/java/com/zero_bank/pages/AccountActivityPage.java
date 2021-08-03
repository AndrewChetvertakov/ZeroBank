package com.zero_bank.pages;

import com.zero_bank.utilities.BrowserUtils;
import com.zero_bank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class AccountActivityPage extends BasePage {

    public AccountActivityPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    protected static final String SHOW_TRANSACTIONS = "showTransactions";
    protected static final String FIND_TRANSACTIONS = "Find Transactions";
    private static final String FIND = "Find";
    private static final String TYPE_SELECT = "Type Select";
    private static final String DESCRIPTION_FIELD = "Description";
    private static final String NO_RESULTS_MESSAGE = "No Results Message";


    @FindBy (xpath = "//div[contains(text(), 'No results.')]")
    private WebElement noResultsMessage;

    @FindBy (id = "aa_description")
    private WebElement descriptionField;

    @FindBy (id = "aa_type")
    private WebElement typeSelect;

    @FindBy(xpath = "//input[@id='aa_fromDate']")
    private WebElement fromDate;

    @FindBy(xpath = "//input[@id='aa_toDate']")
    private WebElement toDate;

    @FindBy(xpath = "//button[text()='Find']")
    private WebElement findButton;

    @FindBy(linkText = "//a[text()='Show Transactions']")
    private WebElement showTransactions;

    @FindBy(xpath = "//a[text()='Find Transactions']")
    private WebElement findTransactions;

    @FindBy(xpath = "//div[contains(@id, 'filtered_transactions')]")
    private WebElement filteredTransactionsTableBackground;

    @FindBy(xpath = "//div[contains(@id, 'filtered_transactions')]/table/tbody/tr/td[1]")
    private List<WebElement> listOfDates;

    public void fillInDates(String start, String end) {
        fromDate.clear();
        fromDate.sendKeys(start);
        toDate.clear();
        toDate.sendKeys(end);
    }

    public WebElement getElement(String clickable){
        switch (clickable) {
            case FIND:
                return findButton;
            case SHOW_TRANSACTIONS:
                return showTransactions;
            case FIND_TRANSACTIONS:
                return findTransactions;
            case TYPE_SELECT:
                return typeSelect;
            case DESCRIPTION_FIELD:
                return descriptionField;
            case NO_RESULTS_MESSAGE:
                return noResultsMessage;
            default:
                super.getElement(clickable);
        }
        return null;
    }

    public void clickOnSomething(String clickable) {
        getElement(clickable).click();
    }

    public boolean checkRangeOfDates(String start, String end) {
        wait.until(ExpectedConditions.visibilityOf(filteredTransactionsTableBackground));
        List<String> strings = listOfDates
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        int[] startInt = BrowserUtils.stringToIntArray(start);
        int[] endInt = BrowserUtils.stringToIntArray(end);
        for (String string : strings) {
            int[] actual = BrowserUtils.stringToIntArray(string);
            for (int j = 0; j < 3; j++) {
                if (actual[j] < startInt[j] && actual[j] > endInt[j]) return false;
            }
        }
        return true;
    }

    public boolean checkIfDatesAreSorted(){
        List<String> strings = listOfDates
                .stream()
                .map(WebElement::getText).collect(Collectors.toList());

        System.out.println(strings);

/*
[2012-09-06, 2012-09-05, 2012-09-01]

        [2012-09-06, <- 6th September
         2012-09-05, <- 5th September
         2012-09-01] <- 1st September
 */


        return false;
    }



}
