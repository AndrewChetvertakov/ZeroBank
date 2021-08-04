package com.zero_bank.step_definitions;

import com.zero_bank.utilities.Driver;
import com.zero_bank.pages.*;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.zero_bank.pages.BasePage.*;

public class Login_StepDefinitions {

    BasePage page;

    /** This method will perform log out of the application
     * Precondition: user has to be logged in, or Exception happens */
    @When("user logs out of application")
    public void user_logs_out_of_application() {
        page = BasePage.pageObjectFactory(LOGIN_PAGE);
        ((LoginPage) page).performLogOut();
        page.clearObjects();
    }

    /** Dynamic method to assert specified element.isDisplayed on specified page
     *  @param element - name of element for getElement() method
     *  @param pageName - name of page to get an object from pageFactory()   */
    @Then("{string} should be displayed on {string}")
    public void shouldBeDisplayedOn(String element, String pageName) {
        page = BasePage.pageObjectFactory(pageName);
        WebElement webElement = page.getElement(element);
        page.wait.until(ExpectedConditions.visibilityOf(webElement));
        boolean result = webElement.isDisplayed();
        page.clearObjects();
        Assert.assertTrue(result);
    }

    /** This method generates random username and password with specified length
     *  And attempts to log in with these generated credentials
     *  And does an assertion through title comparison */
    @When("user tries to login with invalid information")
    public void userTriesToLoginWithInvalidInformation() {
        page = BasePage.pageObjectFactory(LOGIN_PAGE);
        String expectedTitle = page.navigationHelperTitles(LOGIN_PAGE);
        String username = ((LoginPage) page).randomLetters(8);
        String password = ((LoginPage) page).randomLetters(8);
        ((LoginPage) page).performLogin(username, password);
        boolean result = ((LoginPage) page).errorMessageIsDisplayed();
        String actualTitle = Driver.getDriver().getTitle();
        page.clearObjects();
        Assert.assertTrue(result);
        Assert.assertEquals("Titles mismatch!", expectedTitle, actualTitle);
    }

    /** This method attempts to login with empty username and password
     *  And does an assertion through title comparison */
    @When("user tries to login without entering credentials")
    public void userTriesToLoginWithoutEnteringCredentials() {
        page = BasePage.pageObjectFactory(LOGIN_PAGE);
        String expectedTitle = page.navigationHelperTitles(LOGIN_PAGE);
        ((LoginPage) page).performLogin("", "");
        boolean result = ((LoginPage) page).errorMessageIsDisplayed();
        String actualTitle = Driver.getDriver().getTitle();
        page.clearObjects();
        Assert.assertTrue(result);
        Assert.assertEquals("Titles mismatch!", expectedTitle, actualTitle);
    }

    /** This method does positive or negative login depending on parameter typeOfTest
     * @param typeOfTest "Correct"   or   "Invalid"   or    "Blank"
     * @param username - CorrectUN         random              ""
     * @param password - CorrectPass       random              ""
     */
    @And("user login to the application with {string} credentials: {string} and {string}")
    public void userLoginToTheApplicationWithCredentialsAnd(String typeOfTest, String username, String password) {
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

    /** Wrapper method for successful login with "username" and "password" credentials   */
    @And("user login to the application successfully")
    public void userLoginToTheApplicationWithCorrectCredentials(){
        userLoginToTheApplicationWithCredentialsAnd("Correct" , "username", "password");
    }

}
