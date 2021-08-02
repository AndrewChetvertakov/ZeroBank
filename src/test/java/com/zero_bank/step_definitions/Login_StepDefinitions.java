package com.zero_bank.step_definitions;

import com.zero_bank.utilities.Driver;
import com.zero_bank.pages.*;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class Login_StepDefinitions {

    BasePage page;

    @When("user logs out of application")
    public void user_logs_out_of_application() {
        page = BasePage.pageObjectFactory("Login Page");
        ((LoginPage) page).performLogOut();
    }

    @Then("{string} should be displayed on {string}")
    public void shouldBeDisplayedOn(String element, String pageName) {
        page = BasePage.pageObjectFactory(pageName);
        boolean result = page.getElement(element).isDisplayed();
        page.clearObjects();
        Assert.assertTrue(result);
    }

    /**
     * This method generates random username and password with specified length
     * And attempts to log in with random credentials
     */
    @When("user tries to login with invalid information")
    public void userTriesToLoginWithInvalidInformation() {
        page = BasePage.pageObjectFactory("Login Page");
        String expectedTitle = page.navigationHelperTitles("Login Page");
        String username = ((LoginPage) page).randomLetters(8);
        String password = ((LoginPage) page).randomLetters(8);
        ((LoginPage) page).performLogin(username, password);
        boolean result = ((LoginPage) page).errorMessageIsDisplayed();
        String actualTitle = Driver.getDriver().getTitle();
        page.clearObjects();
        Assert.assertTrue(result);
        Assert.assertEquals("Titles mismatch!", expectedTitle, actualTitle);
    }

    @When("user tries to login without entering credentials")
    public void userTriesToLoginWithoutEnteringCredentials() {
        page = BasePage.pageObjectFactory("Login Page");
        String expectedTitle = page.navigationHelperTitles("Login Page");
        ((LoginPage) page).performLogin("", "");
        boolean result = ((LoginPage) page).errorMessageIsDisplayed();
        String actualTitle = Driver.getDriver().getTitle();
        page.clearObjects();
        Assert.assertTrue(result);
        Assert.assertEquals("Titles mismatch!", expectedTitle, actualTitle);
    }

    /**
     *
     * @param typeOfTest "Correct"   or   "Invalid"   or    "Blank"
     * @param username - CorrectUN         random              ""
     * @param password - CorrectPass       random              ""
     */
    @And("user login to the application with {string} credentials: {string} and {string}")
    public void userLoginToTheApplicationWithCredentialsAnd(String typeOfTest, String username, String password) {
        BasePage page;
        page = BasePage.pageObjectFactory("Login Page");
        switch (typeOfTest) {
            case "Invalid":
                username = ((LoginPage) page).randomLetters(8);
                password = ((LoginPage) page).randomLetters(8);
                break;
            case "Correct":
                break;
            case "Blank":
                username = "";
                password = "";
                break;
        }

        ((LoginPage) page).performLogin(username, password);
        if(typeOfTest.equals("Correct")) { ((LoginPage) page).resolveUnsecureConnections(); }
        page.clearObjects();
    }
    @And("user login to the application successfully")
    public void userLoginToTheApplicationWithCorrectCredentials(){
        userLoginToTheApplicationWithCredentialsAnd("Correct" , "username", "password");
    }

}
