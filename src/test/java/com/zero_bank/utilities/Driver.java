package com.zero_bank.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;

import java.util.concurrent.TimeUnit;

public class Driver {

    /* Creating the private constructor so this class's object is not reachable from outside. */
    private Driver() {
    }

    /*   Making our driver instance private so that it is not reachable from outside of the class
       Also we are making it static so that we can use it in a static method.
       We want it to run before everything else */
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    /*   Creating reusable utility method that will return same driver instance every time we call it. */
//    public static synchronized WebDriver getDriver(){   <--- first option

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {

            synchronized (Driver.class) {

                String browserType = ConfigurationReader.getProperty("browser");

//            depending on browser type we return the right browser...
                switch (browserType) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driverPool.set(new ChromeDriver());
                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                        driverPool.get().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driverPool.set(new FirefoxDriver());
                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                        driverPool.get().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
                        break;
                    case "chromeSSL":
                        //is used to by pass security issues (like at ZeroBank)
                        WebDriverManager.chromedriver().setup();
                        ChromeOptions capability = new ChromeOptions();
                        capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                        capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
                        driverPool.set(new ChromeDriver(capability));
                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                        break;
                    case "":
                }
            }
        }
        return driverPool.get();
    }

    /*
     This method makes sure we have some form of driver sesion or driver id has.
     Either null or not null it must exist.
      */
    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }

//    /*   Making our driver instance private so that it is not reachable from outside of the class
//   Also we are making it static so that we can use it in a static method.
//   We want it to run before everything else */
//    private static WebDriver driver;
//
//    /*   Creating reusable utility method that will return same driver instance every time we call it. */
//    public static WebDriver getDriver(){
//        if(driver == null){
//
//            String browserType = ConfigurationReader.getProperty("browser");
//
////            depending on browser type we return the right browser...
//            switch (browserType){
//                case "chrome":
//                    WebDriverManager.chromedriver().setup();
//                    driver = new ChromeDriver();
//                    driver.manage().window().maximize();
//                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//                    driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
//                    break;
//                case "firefox":
//                    WebDriverManager.firefoxdriver().setup();
//                    driver.manage().window().maximize();
//                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//                    driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
//                    break;
//                case "":
//
//            }
//
//        }
//
//
//
//        return driver;
//    }
//
//
//
//    /*   this method makes sure we have some form of driver session or
//       driver is either null or not null, it MUST exist. */
//    public static void closeDriver(){
//        if(driver != null){
//            driver.quit();
//            driver = null;
//        }
//    }


}
