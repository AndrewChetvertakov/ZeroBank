package com.zero_bank.pages;

import com.zero_bank.utilities.Driver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.*;

public class LoginPage extends BasePage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public static final String SUBMIT_BUTTON = "Submit";
    public static final String ADVANCED_LINK = "Advanced";
    public static final String PROCEED_LINK = "Proceed";
    public static final String INVALID_CREDENTIALS_MESSAGE = "Invalid Credentials Message";
    public static final String LOGIN_FIELD = "Login Field";
    public static final String PASSWORD_FIELD = "Password Field";

    @FindBy(id = "user_login")
    private WebElement loginFiled;

    @FindBy (id = "user_password")
    private WebElement passwordField;

    @FindBy (name = "submit")
    private WebElement submitButton;

    @FindBy (xpath = "//button[@id='details-button']")
    private WebElement advanced;

    @FindBy (xpath = "//a[@id='proceed-link']")
    private WebElement proceedLink;

    @FindBy (xpath = "//*[contains(text(), 'Login and/or password are wrong.')]")
    private WebElement errorMessage;

    @Override
    public void clickOnSomething(String button) {
        getElement(button).click();
    }

    public WebElement getElement(String clickable){
        switch (clickable){
            case SUBMIT_BUTTON: return submitButton;
            case ADVANCED_LINK: return advanced;
            case PROCEED_LINK: return proceedLink;
            case INVALID_CREDENTIALS_MESSAGE: return errorMessage;
            case LOGIN_FIELD: return loginFiled;
            case PASSWORD_FIELD: return passwordField;
            default: return super.getElement(clickable);
        }
    }

    /** This method resolves unsecure connection message,
     *  the message happens after every first login on a fresh browser     */
    public void resolveUnsecureConnections(){
        try {
            wait.until(ExpectedConditions.visibilityOf(advanced));
            clickOnSomething(ADVANCED_LINK);
            wait.until(ExpectedConditions.visibilityOf(proceedLink));
            clickOnSomething(PROCEED_LINK);
        }catch (TimeoutException e){
            System.out.println("Secure connections pop up did not happen");
        }
    }

    /** this method logs into the application with provided credemtials
     *  @param username - username
     *  @param password -password    */
    public void performLogin(String username, String password){
        loginFiled.sendKeys(username);
        passwordField.sendKeys(password);
        clickOnSomething("Submit");
    }

    /**
     * This method logs out of application,
     * only works if user is logged in     */
    public void performLogOut(){
        clickOnSomething(ZERO_BANK_BUTTON);
        clickOnSomething(USERNAME_DROPDOWN);
        wait.until(ExpectedConditions.visibilityOf(getElement(LOGOUT_BUTTON)));
        clickOnSomething(LOGOUT_BUTTON);
        isLoggedIn = false;
    }

    /** Helper method for negative login
     *  @return randomly generated String    */
    public boolean errorMessageIsDisplayed(){
        return errorMessage.isDisplayed();
    }
    public String randomLetters(int length){
        Random random = new Random();
        char[] randomUser = new char[random.nextInt(length) + 1];
        for (int i = 0; i < randomUser.length; i++) {
            randomUser[i] = (char) (random.nextInt(122) - 66);
        }
        return Arrays.toString(randomUser);
    }

}
