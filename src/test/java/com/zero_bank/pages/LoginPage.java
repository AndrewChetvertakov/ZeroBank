package com.zero_bank.pages;

import com.zero_bank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    protected static final String SUBMIT_BUTTON = "Submit";

    @Override
    public void clickOnSomething(String button) {
        switch (button){
            case SUBMIT_BUTTON: submitButton.click(); break;

            default:
                System.out.println("LoginPage --> clickOnSomething() --> wrong input");

        }
    }

    @FindBy(id = "user_login")
    private WebElement loginFiled;

    @FindBy (id = "user_password")
    private WebElement passwordField;

    @FindBy (name = "submit")
    private WebElement submitButton;

    public void performLogin(String username, String password){
        loginFiled.sendKeys(username);
        passwordField.sendKeys(password);
        clickOnSomething("Submit");
    }


}
