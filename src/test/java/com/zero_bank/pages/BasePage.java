package com.zero_bank.pages;

import com.zero_bank.utilities.Driver;
import com.zero_bank.utilities.NoElementDefinedException;
import com.zero_bank.utilities.PageNotDefinedException;
import com.zero_bank.utilities.UnknownParameterException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public static volatile Boolean isLoggedIn = false;

    public static final String ACCOUNT_ACTIVITY_PAGE = "Account Activity";
    public static final String ACCOUNT_SUMMARY_PAGE = "Account Summary";
    public static final String LANDING_PAGE = "Landing Page";
    public static final String LOGIN_PAGE = "Login Page";
    public static final String TRANSFER_FUNDS_PAGE = "Transfer Funds";
    public static final String PAY_BILLS_PAGE = "Pay Bills";
    public static final String MY_MONEY_MAP_PAGE = "My Money Map";
    public static final String ONLINE_STATEMENTS_PAGE = "Online Statements";
    public static final String HELP_PAGE = "Help";
    public static final String FREE_ACCESS_TO_ONLINE_BANKING_PAGE = "Free Access to Online Banking";
    public static final String FEEDBACK_PAGE = "Contact Us";

    public static final String SETTINGS_DROPDOWN = "Settings";
    public static final String USERNAME_DROPDOWN = "Username";
    public static final String SIGN_IN_BUTTON = "signInButton";
    public static final String ZERO_BANK_BUTTON = "Zero Bank";
    public static final String MY_PROFILE_BUTTON = "My Profile";
    public static final String LOGOUT_BUTTON = "Logout";

    public WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @FindBy(id = "signin_button")
    protected WebElement signInButton;

    @FindBy(xpath = "//a[text()='Zero Bank' and @href='/index.html']")
    protected WebElement zeroBankButton;

    @FindBy(xpath = "//a[contains(text(),'Settings')]/../../preceding-sibling::a")
    protected WebElement settingsButton;

    @FindBy(xpath = "//a[contains(text(),'My Profile')]/../../preceding-sibling::a")
    protected WebElement usernameButton;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    protected WebElement logOutButton;

    @FindBy(xpath = "//a[contains(text(),'My Profile')]")
    protected WebElement myProfileButton;

    public abstract void clickOnSomething(String button);

    public void clearObjects(){
        PAGE_OBJECT_MAP.clear();
    }

    private static final Map<String, BasePage> PAGE_OBJECT_MAP = new HashMap<>();

    public static BasePage pageObjectFactory(String page) {
        if (PAGE_OBJECT_MAP.containsKey(page)) return PAGE_OBJECT_MAP.get(page);
        else {
            switch (page) {
                case ACCOUNT_ACTIVITY_PAGE:
                    PAGE_OBJECT_MAP.put(page, new AccountActivityPage());
                    return PAGE_OBJECT_MAP.get(page);
                case ACCOUNT_SUMMARY_PAGE:
                    PAGE_OBJECT_MAP.put(page, new AccountSummaryPage());
                    return PAGE_OBJECT_MAP.get(page);
                case LANDING_PAGE:
                    PAGE_OBJECT_MAP.put(page, new LandingPage());
                    return PAGE_OBJECT_MAP.get(page);
                case LOGIN_PAGE:
                    PAGE_OBJECT_MAP.put(page, new LoginPage());
                    return PAGE_OBJECT_MAP.get(page);
                case PAY_BILLS_PAGE:
                    PAGE_OBJECT_MAP.put(page, new PayBillsPage());
                    return PAGE_OBJECT_MAP.get(page);
                default:
                    System.out.println("BasePage --> pageObjectFactory --> Invalid parameter: " + page);
                    System.out.println("PageNotDefinedException from pageObjectFactory");
                    throw new PageNotDefinedException(page);
            }
        }
    }

    public WebElement getElement(String clickable) {
        switch (clickable) {
            case ZERO_BANK_BUTTON:
                return zeroBankButton;
            case SETTINGS_DROPDOWN:
                return settingsButton;
            case USERNAME_DROPDOWN:
                return usernameButton;
            case MY_PROFILE_BUTTON:
                return myProfileButton;
            case LOGOUT_BUTTON:
                return logOutButton;
            default:
                System.out.println("BasePage --> getElement() --> wrong input " + clickable);
                System.out.println("NoSuchElementException --> getElement() --> invalid parameter: " + clickable);
                throw new NoElementDefinedException(clickable);
        }
    }

    public void clickOnAnyButtonOnAnyPage(String page, String button) {
        pageObjectFactory(page).clickOnSomething(button);
    }

    public String navigationHelperTitles(String page) {
        switch (page) {
            case ACCOUNT_ACTIVITY_PAGE:
                return "Zero - Account Activity";
            case ACCOUNT_SUMMARY_PAGE:
                return "Zero - Account Summary";
            case LANDING_PAGE:
                return "Zero - Personal Banking - Loans - Credit Cards";
            case LOGIN_PAGE:
                return "Zero - Log in";
            case TRANSFER_FUNDS_PAGE:
                return "Zero - Transfer Funds";
            case PAY_BILLS_PAGE:
                return "Zero - Pay Bills";
            case MY_MONEY_MAP_PAGE:
                return "Zero - My Money Map";
            case ONLINE_STATEMENTS_PAGE:
                return "Zero - Online Statements";
            case HELP_PAGE:
                return "Zero - Help";
            case FREE_ACCESS_TO_ONLINE_BANKING_PAGE:
                return "Zero - Free Access to Online Banking";
            case FEEDBACK_PAGE:
                return "Zero - Contact Us";
            default:
                System.out.println("UnknownParameterException --> BasePage --> navigationHelperTitles() --> wrong parameter " + page);
                throw new UnknownParameterException(page);
        }
    }

    public String navigationHelperUrls(String page) {
        switch (page) {
            case ACCOUNT_ACTIVITY_PAGE:
                return "http://zero.webappsecurity.com/bank/account-activity.html";
            case ACCOUNT_SUMMARY_PAGE:
                return "http://zero.webappsecurity.com/bank/account-summary.html";
            case LANDING_PAGE:
                return "http://zero.webappsecurity.com/";
            case LOGIN_PAGE:
                return "http://zero.webappsecurity.com/login.html";
            case TRANSFER_FUNDS_PAGE:
                return "http://zero.webappsecurity.com/bank/transfer-funds.html";
            case PAY_BILLS_PAGE:
                return "http://zero.webappsecurity.com/bank/pay-bills.html";
            case MY_MONEY_MAP_PAGE:
                return "http://zero.webappsecurity.com/bank/money-map.html";
            case ONLINE_STATEMENTS_PAGE:
                return "http://zero.webappsecurity.com/bank/online-statements.html";
            case HELP_PAGE:
                return "http://zero.webappsecurity.com/help.html";
            case FREE_ACCESS_TO_ONLINE_BANKING_PAGE:
                return "http://zero.webappsecurity.com/online-banking.html";
            case FEEDBACK_PAGE:
                return "http://zero.webappsecurity.com/feedback.html";
            default:
                System.out.println("UnknownParameterException --> BasePage --> navigationHelperUrls() --> wrong parameter: " + page);
                throw new UnknownParameterException(page);
        }
    }


}
