package com.zero_bank.utilities;

public class BrowserUtils {

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



//    "2012-09-01" to "2012-09-06"


}
