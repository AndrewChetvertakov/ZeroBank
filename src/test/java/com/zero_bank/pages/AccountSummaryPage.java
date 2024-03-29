package com.zero_bank.pages;

import com.zero_bank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class AccountSummaryPage extends BasePage{

    public AccountSummaryPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public static final String ACCOUNT_SUMMARY_LINK = ACCOUNT_SUMMARY_PAGE;
    public static final String ACCOUNT_ACTIVITY_LINK = ACCOUNT_ACTIVITY_PAGE;
    public static final String TRANSFER_FUNDS_LINK = TRANSFER_FUNDS_PAGE;
    public static final String PAY_BILLS_LINK = PAY_BILLS_PAGE;
    public static final String MY_MONEY_MAP_LINK = MY_MONEY_MAP_PAGE;
    public static final String ONLINE_STATEMENTS_LINK = ONLINE_STATEMENTS_PAGE;
    public static final String RANDOM_DIV = "Random Div";

    @FindBy (xpath = "//div[@class='span12']")
    public WebElement randomDiv;

    @FindBy (xpath = "//a[contains(@href, 'account-summary')]")
    private WebElement accountSummaryLink;

    @FindBy (xpath = "//li[@id='account_activity_tab']/a")
    private WebElement accountActivityLink;

    @FindBy (xpath = "//a[contains(@href, 'transfer-funds.html')]")
    private WebElement transferFundsLink;

    @FindBy (xpath = "//a[contains(@href, 'pay-bills')]")
    private WebElement payBillsLink;

    @FindBy (xpath = "//a[contains(@href, 'money-map')]")
    private WebElement myMoneyMapLink;

    @FindBy (xpath = "//a[contains(@href, 'online-statements')]")
    private WebElement onlineStatementsLink;

    public WebElement getElement(String clickable){
        switch(clickable){
            case ACCOUNT_SUMMARY_LINK : return accountSummaryLink;
            case ACCOUNT_ACTIVITY_LINK : return accountActivityLink;
            case TRANSFER_FUNDS_LINK : return transferFundsLink;
            case PAY_BILLS_LINK : return payBillsLink;
            case MY_MONEY_MAP_LINK : return myMoneyMapLink;
            case ONLINE_STATEMENTS_LINK : return onlineStatementsLink;
            case LANDING_PAGE : return zeroBankButton;
            case RANDOM_DIV: return randomDiv;
            default:
                return super.getElement(clickable);
        }
    }

    public void clickOnSomething(String clickable){
        getElement(clickable).click();
    }

}
