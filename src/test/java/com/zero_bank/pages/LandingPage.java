package com.zero_bank.pages;

import com.zero_bank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends BasePage{

    public LandingPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }



    private static final String SIGN_IN_BUTTON = "signInButton";
    private static final String ADVANCED_LINK = "Advanced";
    private static final String PROCEED_LINK = "Proceed";

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @FindBy(id = "signin_button")
    private WebElement signInButton;

    @FindBy (xpath = "//button[@id='details-button']")
    private WebElement advanced;

    @FindBy (xpath = "//a[@id='proceed-link']")
    private WebElement proceedLink;

    public void resolveUnsecureConnections(){
        wait.until(ExpectedConditions.visibilityOf(advanced));
//        advanced.click();
        clickOnSomething("Advanced");

        wait.until(ExpectedConditions.visibilityOf(proceedLink));
//        proceedLink.click();
        clickOnSomething("Proceed");

    }

    @Override
    public void clickOnSomething(String button) {
        switch (button){
            case SIGN_IN_BUTTON:
                signInButton.click();
                break;
            case ADVANCED_LINK:
                advanced.click();
                break;
            case PROCEED_LINK:
                proceedLink.click();
                break;
            case LANDING_PAGE:
                zeroBankButton.click();
                break;
            default:
                System.out.println("No such button --> void click method in FindTransactions Step_Definitions");
    }
    }

}
