package com.zero_bank.test;

public class TestEditor {
    public static void main(String[] args) {




        String story = "Add\tNew\tPayee.feature\n" +
                "Feature:\tAdd\tnew\tpayee\tunder\tpay\tbills\n" +
                "Scenario:\tAdd\ta\tnew\tpayee\n" +
                "Given Add New Payee tab\n" +
                "And creates\tnew\tpayee\tusing following\tinformation\t\n" +
                "|Payee\tName | The\tLaw\tOffices\tof\tHyde,\tPrice\t&\tScharks|\n" +
                "|Payee\tAddress | 100\tSame st,\tAnytown,\tUSA,\t10001 |\n" +
                "|Account | Checking |\n" +
                "|Payee\tdetails | XYZ\taccount |\n" +
                "Then message\tThe\tnew\tpayee\tThe\tLaw\tOffices\tof\tHyde,\tPrice\t&\tScharks\twas\t\n" +
                "successfully\tcreated. should\tbe\tdisplayed\n";

        System.out.println(story.replace("\t", " ").replace("“","\"").replace("”","\""));

    }
}