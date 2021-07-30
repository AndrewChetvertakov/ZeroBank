package com.zero_bank.pages;

import com.zero_bank.utilities.ConfigurationReader;
import com.zero_bank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    protected static final String ACCOUNT_ACTIVITY_PAGE = "Account Activity";
    protected static final String ACCOUNT_SUMMARY_PAGE = "Account Summary";
    protected static final String LANDING_PAGE = "Landing Page";
    protected static final String LOGIN_PAGE = "Login Page";
    protected static final String TRANSFER_FUNDS_PAGE = "Transfer Funds";
    protected static final String PAY_BILLS_PAGE = "Pay Bills";
    protected static final String MY_MONEY_MAP_PAGE = "My Money Map";
    protected static final String ONLINE_STATEMENTS_PAGE = "Online Statements";
    protected static final String HELP_PAGE = "Help";
    protected static final String FREE_ACCESS_TO_ONLINE_BANKING = "Free Access to Online Banking";
    protected static final String FEEDBACK = "Contact Us";

    @FindBy(xpath = "//a[text()='Zero Bank' and @href='/index.html']")
    protected WebElement zeroBankButton;

    BasePage myPage;

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);


    protected abstract void clickOnSomething(String button);


    public void navigateToPage(String pageName) {

        if (!Driver.getDriver().getTitle().equals(navigationHelper(pageName)[0])) {

            switch (pageName) {
                case LANDING_PAGE:
                    //check if title is empty or nothing or null -> do driver.get();
                    //else click zeroBankButton button
                    Driver.getDriver().get(ConfigurationReader.getProperty("zeroBank"));
                    break;

                case ACCOUNT_ACTIVITY_PAGE:
                case ACCOUNT_SUMMARY_PAGE:
                case LOGIN_PAGE:
                    Driver.getDriver().findElement(By.xpath("//a[text()='" + pageName + "']")).click();
                    String title = pageName.split(" ")[1].toLowerCase();
                    wait.until(ExpectedConditions.urlContains(title));
                    break;

                default:
                    System.out.println("Cannot execute navigate to " + pageName + ". Wrong parameter");
                    System.out.println("Fix --> BasePage --> navigateToPage(String pageName) method.");
            }
        }
    }

    public void clickOnAnyButtonOnAnyPage(String page, String button) {

        switch (page) {
            case ACCOUNT_ACTIVITY_PAGE:
                myPage = new AccountActivityPage();
                myPage.clickOnSomething(button);
                break;
            case ACCOUNT_SUMMARY_PAGE:
                myPage = new AccountSummaryPage();
                myPage.clickOnSomething(button);
                break;
            case LANDING_PAGE:
                myPage = new LandingPage();
                myPage.clickOnSomething(button);
                break;
            case LOGIN_PAGE:
                myPage = new LoginPage();
                myPage.clickOnSomething(button);
                break;
            default:
                System.out.println("BasePage --> returnPageInstance --> Invalid parameter.");
        }
    }

    public String[] navigationHelper(String page) {

        String[] titleAndUrl = new String[2];

        switch (page) {
            case ACCOUNT_ACTIVITY_PAGE:
                titleAndUrl[0] = "Zero - Account Activity";
                titleAndUrl[1] = "http://zero.webappsecurity.com/bank/account-summary.html";
                break;
            case ACCOUNT_SUMMARY_PAGE:
                titleAndUrl[0] = "Zero - Account Summary";
                titleAndUrl[1] = "http://zero.webappsecurity.com/bank/account-summary.html";
                break;
            case LANDING_PAGE:
                titleAndUrl[0] = "Zero - Personal Banking - Loans - Credit Cards";
                titleAndUrl[1] = "http://zero.webappsecurity.com/index.html";
                break;
            case LOGIN_PAGE:
                titleAndUrl[0] = "Zero - Log in";
                titleAndUrl[1] = "http://zero.webappsecurity.com/login.html";
                break;
            case TRANSFER_FUNDS_PAGE:
                titleAndUrl[0] = "Zero - Transfer Funds";
                titleAndUrl[1] = "http://zero.webappsecurity.com/bank/transfer-funds.html";
                break;
            case PAY_BILLS_PAGE:
                titleAndUrl[0] = "Zero - Pay Bills";
                titleAndUrl[1] = "http://zero.webappsecurity.com/bank/pay-bills.html";
                break;
            case MY_MONEY_MAP_PAGE:
                titleAndUrl[0] = "Zero - My Money Map";
                titleAndUrl[1] = "http://zero.webappsecurity.com/bank/money-map.html";
                break;
            case ONLINE_STATEMENTS_PAGE:
                titleAndUrl[0] = "Zero - Online Statements";
                titleAndUrl[1] = "http://zero.webappsecurity.com/bank/online-statements.html";
                break;
            case HELP_PAGE:
                titleAndUrl[0] = "Zero - Help";
                titleAndUrl[1] = "http://zero.webappsecurity.com/help.html";
                break;
            case FREE_ACCESS_TO_ONLINE_BANKING:
                titleAndUrl[0] = "Zero - Free Access to Online Banking";
                titleAndUrl[1] = "http://zero.webappsecurity.com/online-banking.html";
                break;
            case FEEDBACK:
                titleAndUrl[0] = "Zero - Contact Us";
                titleAndUrl[1] = "http://zero.webappsecurity.com/feedback.html";
                break;
            default: titleAndUrl[0] = titleAndUrl[1] = "BasePage --> navigationHelper() --> wrong parameter";
                System.out.println("BasePage --> navigationHelper() --> wrong parameter");
        }


        return titleAndUrl;
    }


}
