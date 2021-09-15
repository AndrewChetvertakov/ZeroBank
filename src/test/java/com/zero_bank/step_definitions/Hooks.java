package com.zero_bank.step_definitions;

import com.zero_bank.utilities.DBUtils;
import com.zero_bank.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before("@db")
    public void dbHook() {
        System.out.println("creating database connection");
        DBUtils.createConnection();
    }

    @After("@db")
    public void afterDbHook() {
        System.out.println("closing database connection");
        DBUtils.destroy();
    }

    @Before("@UI")
    public void setUp() {
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void takeSceenshot_andTearDown(Scenario scenario){
//        scenario.isFailed(); <--- tracks Scenario progress kinda

        if(scenario.isFailed()) {
                /*
                Line below takes screenshot and stores it as byte Array
                Scenarios fail when Assert.assert.... fails!
                this will also work with testNG somehow
                Screenshot will be embedded into our report
                */
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            //Saves byte[] to a file with scenario Name
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        System.out.println("Teardown steps are being applied");

        Driver.getDriver().manage().deleteAllCookies();
//        SessionId session =((ChromeDriver) Driver.getDriver()).getSessionId();
//        System.out.println("Session id: " + session.toString());
        Driver.closeDriver();
    }

//    @Before
//    public void start(){
//
//    }

}
