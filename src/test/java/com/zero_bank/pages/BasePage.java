package com.zero_bank.pages;

import com.zero_bank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public static volatile Boolean isLoggedIn = false;

    protected static final String ACCOUNT_ACTIVITY_PAGE = "Account Activity";
    protected static final String ACCOUNT_SUMMARY_PAGE = "Account Summary";
    protected static final String LANDING_PAGE = "Landing Page";
    protected static final String LOGIN_PAGE = "Login Page";
    protected static final String TRANSFER_FUNDS_PAGE = "Transfer Funds";
    protected static final String PAY_BILLS_PAGE = "Pay Bills";
    protected static final String MY_MONEY_MAP_PAGE = "My Money Map";
    protected static final String ONLINE_STATEMENTS_PAGE = "Online Statements";
    protected static final String HELP_PAGE = "Help";
    protected static final String FREE_ACCESS_TO_ONLINE_BANKING_PAGE = "Free Access to Online Banking";
    protected static final String FEEDBACK_PAGE = "Contact Us";

    protected static final String SETTINGS_DROPDOWN = "Settings";
    protected static final String USERNAME_DROPDOWN = "Username";
    protected static final String SIGN_IN_BUTTON = "signInButton";
    protected static final String ZERO_BANK_BUTTON = "Zero Bank";
    protected static final String MY_PROFILE_BUTTON = "My Profile";
    protected static final String LOGOUT_BUTTON = "Logout";

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

//                "Transfer Funds"
                default:
                    System.out.println("BasePage --> pageObjectFactory --> Invalid parameter.");
                    System.out.println("NullPointer from pageObjectFactory");
                    throw new NullPointerException();
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
                throw new NoSuchElementException();
        }
    }

    public void clickOnAnyButtonOnAnyPage(String page, String button) {
        pageObjectFactory(page).clickOnSomething(button);
    }

    protected static final List<String> titles = new ArrayList<>();
    protected static final List<String> urls = new ArrayList<>();

    private List<String> populateTitles() {
        if (titles.isEmpty()) {
            titles.addAll(Arrays.asList(
                    "Zero - Account Activity",
                    "Zero - Account Summary",
                    "Zero - Personal Banking - Loans - Credit Cards",
                    "Zero - Log in",
                    "Zero - Transfer Funds",
                    "Zero - Pay Bills",
                    "Zero - My Money Map",
                    "Zero - Online Statements",
                    "Zero - Help",
                    "Zero - Free Access to Online Banking",
                    "Zero - Contact Us"));
        }
        return titles;
    }

    private List<String> populateUrls() {
        if (urls.isEmpty()) {
            urls.addAll(Arrays.asList(
                    "http://zero.webappsecurity.com/bank/account-activity.html",
                    "http://zero.webappsecurity.com/bank/account-summary.html",
                    "http://zero.webappsecurity.com/",
                    "http://zero.webappsecurity.com/login.html",
                    "http://zero.webappsecurity.com/bank/transfer-funds.html",
                    "http://zero.webappsecurity.com/bank/pay-bills.html",
                    "http://zero.webappsecurity.com/bank/money-map.html",
                    "http://zero.webappsecurity.com/bank/online-statements.html",
                    "http://zero.webappsecurity.com/help.html",
                    "http://zero.webappsecurity.com/online-banking.html",
                    "http://zero.webappsecurity.com/feedback.html"));
        }
        return urls;
    }

    public String navigationHelperTitles(String page) {
        String title;
        switch (page) {
            case ACCOUNT_ACTIVITY_PAGE:
                title = populateTitles().get(0);
                break;
            case ACCOUNT_SUMMARY_PAGE:
                title = populateTitles().get(1);
                break;
            case LANDING_PAGE:
                title = populateTitles().get(2);
                break;
            case LOGIN_PAGE:
                title = populateTitles().get(3);
                break;
            case TRANSFER_FUNDS_PAGE:
                title = populateTitles().get(4);
                break;
            case PAY_BILLS_PAGE:
                title = populateTitles().get(5);
                break;
            case MY_MONEY_MAP_PAGE:
                title = populateTitles().get(6);
                break;
            case ONLINE_STATEMENTS_PAGE:
                title = populateTitles().get(7);
                break;
            case HELP_PAGE:
                title = populateTitles().get(8);
                break;
            case FREE_ACCESS_TO_ONLINE_BANKING_PAGE:
                title = populateTitles().get(9);
                break;
            case FEEDBACK_PAGE:
                title = populateTitles().get(10);
                break;
            default:
                System.out.println("IllegalArgumentException --> BasePage --> navigationHelperTitles() --> wrong parameter");
                throw new IllegalArgumentException();
        }
        return title;
    }

    public String navigationHelperUrls(String page) {
        String url;
        switch (page) {
            case ACCOUNT_ACTIVITY_PAGE:
                url = populateUrls().get(0);
                break;
            case ACCOUNT_SUMMARY_PAGE:
                url = populateUrls().get(1);
                break;
            case LANDING_PAGE:
                url = populateUrls().get(2);
                break;
            case LOGIN_PAGE:
                url = populateUrls().get(3);
                break;
            case TRANSFER_FUNDS_PAGE:
                url = populateUrls().get(4);
                break;
            case PAY_BILLS_PAGE:
                url = populateUrls().get(5);
                break;
            case MY_MONEY_MAP_PAGE:
                url = populateUrls().get(6);
                break;
            case ONLINE_STATEMENTS_PAGE:
                url = populateUrls().get(7);
                break;
            case HELP_PAGE:
                url = populateUrls().get(8);
                break;
            case FREE_ACCESS_TO_ONLINE_BANKING_PAGE:
                url = populateUrls().get(9);
                break;
            case FEEDBACK_PAGE:
                url = populateUrls().get(10);
                break;
            default:
                System.out.println("IllegalArgumentException --> BasePage --> navigationHelperUrls() --> wrong parameter");
                throw new IllegalArgumentException();
        }
        return url;
    }

}
