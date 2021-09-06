package com.zero_bank.test;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLink {


    //   http://te.dev.secureci.com/Exercise1.html%22



    @Test
    public static void test  () throws IOException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver = new ChromeDriver(options);

        driver.get("http://te.dev.secureci.com/Exercise1.html%22");

        List<WebElement> elements = driver.findElements(By.xpath("//area"));

        for (int i = 0; i < elements.size(); i++) {

            String url = elements.get(i).getAttribute("href");

            URL link = new URL(url);

            HttpURLConnection connection = (HttpURLConnection) link.openConnection();

            System.out.println(connection.getResponseCode());

            if (connection.getResponseCode() >= 400 && connection.getResponseCode() < 500){
                System.out.println(elements.get(i).getAttribute("alt"));
                System.out.println(elements.get(i).getAttribute("href"));
                break;
            }

        }

    }
}
