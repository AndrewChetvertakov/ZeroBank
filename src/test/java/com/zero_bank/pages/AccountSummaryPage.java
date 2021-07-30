package com.zero_bank.pages;

import com.zero_bank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSummaryPage extends BasePage{

    public AccountSummaryPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

//    protected static final String ACCOUNT_ACTIVITY_PAGE = "Account Activity";

    protected static final String ACCOUNT_SUMMARY_LINK = "accountSummary";
    protected static final String ACCOUNT_ACTIVITY_LINK = "Account Activity";
    protected static final String TRANSFER_FUNDS_LINK = "transferFunds";
    protected static final String PAY_BILLS_LINK = "payBills";
    protected static final String MY_MONEY_MAP_LINK = "myMoneyMap";
    protected static final String ONLINE_STATEMENTS_LINK = "onlineStatements";

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

    public void clickOnSomething(String clickable){
        switch(clickable){
            case ACCOUNT_SUMMARY_LINK : accountSummaryLink.click(); break; // Account Activity
            case ACCOUNT_ACTIVITY_LINK : accountActivityLink.click(); break;
            case TRANSFER_FUNDS_LINK : transferFundsLink.click(); break;
            case PAY_BILLS_LINK : payBillsLink.click(); break;
            case MY_MONEY_MAP_LINK : myMoneyMapLink.click(); break;
            case ONLINE_STATEMENTS_LINK : onlineStatementsLink.click(); break;
            case LANDING_PAGE : zeroBankButton.click(); break;

            default:
                System.out.println("AccountSummaryPage --> clickOnSomething() --> wrong input");
        }
    }


}
