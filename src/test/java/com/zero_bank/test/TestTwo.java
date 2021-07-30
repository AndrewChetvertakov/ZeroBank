package com.zero_bank.test;

import com.zero_bank.pages.AccountActivityPage;
import com.zero_bank.step_definitions.Navigation_StepDefinitions;
import com.zero_bank.utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.By;

public class TestTwo {

    @Test
    public void something(){

        Driver.getDriver().get("https://www.google.com/");
        System.out.println(Driver.getDriver().findElement(By.id("q")).isEnabled());

    }

}
