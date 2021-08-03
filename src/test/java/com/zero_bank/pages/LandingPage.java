package com.zero_bank.pages;

import com.zero_bank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage{

    public LandingPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    private static final String HOME_BUTTON = "Account Activity";
    private static final String ONLINE_BANKING_BUTTON = "Account Summary";
    private static final String FEEDBACK_BUTTON = "Landing Page";

    @FindBy (xpath = "//strong[text()='Home']")
    private WebElement homeButton;

    @FindBy (xpath = "//strong[text()='Online Banking']")
    private WebElement onlineBankingButton;

    @FindBy (xpath = "//strong[text()='Feedback']")
    private WebElement feedBackButton;

    public WebElement getElement(String clickable){
        switch (clickable){
            case SIGN_IN_BUTTON: return signInButton;
            case HOME_BUTTON: return homeButton;
            case FEEDBACK_BUTTON: return feedBackButton;
            case ONLINE_BANKING_BUTTON: return onlineBankingButton;
            default:
                return super.getElement(clickable);
        }
    }

    @Override
    public void clickOnSomething(String button) {
        getElement(button).click();
    }

}
