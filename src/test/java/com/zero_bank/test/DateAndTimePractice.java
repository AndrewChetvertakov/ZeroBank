package com.zero_bank.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAndTimePractice {
    public static void main(String[] args) {
        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("dd-MM-yyyy : "+df2.format(new Date()));
        Date date = new Date();
        System.out.println("dd-MM-yyyy : "+ df1.format(date));
    }
}
