package com.zero_bank.test;

import java.util.Random;

public class TestTwo {

    public static void main(String[] args) {

        System.out.println(generateDate());
        System.out.println(generateDate());
        System.out.println(generateDate());
        System.out.println(generateDate());
        System.out.println(generateDate());
        System.out.println(generateDate());
        System.out.println(generateDate());
        System.out.println(generateDate());
        System.out.println(generateDate());
        System.out.println(generateDate());
        System.out.println(generateDate());
        System.out.println(generateDate());
        System.out.println(generateDate());
        System.out.println(generateDate());
        System.out.println(generateDate());
        System.out.println(generateDate());
        System.out.println(generateDate());
        System.out.println(generateDate());
        System.out.println(generateDate());
        System.out.println(generateDate());
        System.out.println(generateDate());
        System.out.println(generateDate());

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
