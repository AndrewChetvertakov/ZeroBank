package com.zero_bank.step_definitions;

import com.zero_bank.pages.LoginPage;
import io.cucumber.java.en.When;

public class Login_StepDefinitions {

    LoginPage page = new LoginPage();

    @When("user logs out of application")
    public void user_logs_out_of_application() {
        page.performLogOut();
    }

}
