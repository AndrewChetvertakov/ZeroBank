package com.zero_bank.test;

import com.zero_bank.utilities.Driver;
import org.junit.Test;

public class TestTwo {

    @Test
    public void something(){

        Driver.getDriver();
        String emptyTitle = Driver.getDriver().getTitle();
        System.out.println("emptyTitle:" + emptyTitle);

        Driver.getDriver().get("https://www.amazon.com/");
        String amazonTitle = Driver.getDriver().getTitle();
        System.out.println(amazonTitle);

        Driver.closeDriver();

    }

}
