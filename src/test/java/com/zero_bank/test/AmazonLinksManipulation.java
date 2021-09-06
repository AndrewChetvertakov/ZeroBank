package com.zero_bank.test;

import com.zero_bank.utilities.Driver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AmazonLinksManipulation {

    @Test
    public void test_one(){
        Driver.getDriver().get("https://www.amazon.com/");
        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//a"));
//        for (WebElement each : elements){
//            System.out.println(each.getAttribute("href"));
//        }

        List<String> links = elements.stream()
                                     .map(WebElement::getText)
                                     .filter(text -> !text.isEmpty())
                                     .filter(text -> text.contains("Amazon"))
                                     .filter(this::longerThanTen)
                                     .collect(Collectors.toList());


        links.forEach(System.out::println);

        links.forEach(link -> Assert.assertFalse(link.isEmpty()));

        List<String> texts = new ArrayList<>();

        for (WebElement each : elements){
            String el = each.getText();
            if(!el.isEmpty() && el.contains("Amazon")){
                texts.add(el);
            }
        }






        Driver.closeDriver();
    }
    public boolean longerThanTen(String str){
        return str.length() > 20;
    }

    public List<Integer> doubling(List<Integer> nums) {
        List <Integer> nums1 = nums.stream().map(e->e*2).collect(Collectors.toList());
        return nums1;
    }

}
