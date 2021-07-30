package com.zero_bank.pages;

import com.zero_bank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    protected static final String SUBMIT_BUTTON = "Submit";
    private static final String ADVANCED_LINK = "Advanced";
    private static final String PROCEED_LINK = "Proceed";

    public WebElement getElement(String clickable){
        switch (clickable){
            case SUBMIT_BUTTON: return submitButton;
            case ADVANCED_LINK: return advanced;
            case PROCEED_LINK: return proceedLink;
            default: return super.getElement(clickable);
//                System.out.println("LoginPage --> getElement() --> wrong input");
//                System.out.println("NullPointerException --> getElement() --> invalid parameter: " + clickable);
        }
//        return null;
    }


    @Override
    public void clickOnSomething(String button) {
        getElement(button).click();
    }

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

    public void resolveUnsecureConnections(){
        wait.until(ExpectedConditions.visibilityOf(advanced));
        clickOnSomething(ADVANCED_LINK);
        wait.until(ExpectedConditions.visibilityOf(proceedLink));
        clickOnSomething(PROCEED_LINK);
    }

    public void performLogin(String username, String password){
        loginFiled.sendKeys(username);
        passwordField.sendKeys(password);
        clickOnSomething("Submit");
        isLoggedIn = true;
    }

    public void performLogOut(){
        clickOnSomething(ZERO_BANK_BUTTON);
        clickOnSomething(USERNAME_DROPDOWN);
        wait.until(ExpectedConditions.visibilityOf(getElement(LOGOUT_BUTTON)));
        clickOnSomething(LOGOUT_BUTTON);
        isLoggedIn = false;


    }


}
