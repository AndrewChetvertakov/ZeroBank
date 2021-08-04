package com.zero_bank.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class BrowserUtils {

    public static void selectOptions(WebElement element, String visibleText){
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    public static void sleep(int seconds){

        seconds = seconds*1000;
        try {Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int[] stringToIntArray(String date){
        String[] strings = date.split("-");
        int[] intArr = new int[strings.length];

        for (int i = 0; i < strings.length; i++) {
            intArr[i] = Integer.parseInt(strings[i]);
        }
    return intArr;
    }

    public static String generateStringNumber(int digits){
        int result = 0;
        int i = 0;
        Random random = new Random();
        while(i < digits){
            result = result * 10 + random.nextInt(9);
            i++;
        }
        return String.valueOf(result);
    }

    public static String generateDate(){
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        builder.append(20).append(random.nextInt(3)).append(random.nextInt(10)).append('-');
        builder.append(random.nextInt(2));
        if(Character.getNumericValue(builder.charAt(5) ) == 1) builder.append(random.nextInt(3));
        else builder.append(random.nextInt(9));
        builder.append('-');
        int comparison = Character.getNumericValue(builder.charAt(5))*10 + Character.getNumericValue(builder.charAt(6));
        int value = 0;
        switch(comparison) {
            case 1: case 3: case 5:
            case 7: case 8: case 10:
            case 12: value = random.nextInt(31) + 1;
                break;
            case 4: case 6: case 9: case 11:
                value = random.nextInt(29)+1; break;
            case 2: value = random.nextInt(27)+1; break;
        }
        if(value<10) builder.append(0).append(value);
        else builder.append(value);
        return new String(builder);
    }







}
