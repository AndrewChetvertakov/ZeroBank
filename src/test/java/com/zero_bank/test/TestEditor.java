package com.zero_bank.test;

public class TestEditor {
    public static void main(String[] args) {




        String story = "Feature:\tPurchase Foreign Currency\n" +
                "Scenario:\tAvailable\tcurrencies\n" +
                "Given the user accesses the Purchase\tforeign\tcurrency\tcash tab\n" +
                "Then\tfollowing\tcurrencies should\tbe\tavailable\n" +
                "|Australia\t(dollar) \t\t|\n" +
                "www.cybertekschool.com support@cybertekschool.com\n" +
                "6\n" +
                "|Canada\t(dollar) \t\t|\n" +
                "|Switzerland\t(franc) \t\t|\n" +
                "|China\t(yuan) \t\t|\n" +
                "|Denmark\t(krone) \t\t|\n" +
                "|Eurozone\t(euro) \t\t|\n" +
                "|Great\tBritain\t(pound)|\n" +
                "|Japan\t(yen) \t\t\t|\n" +
                "|Mexico\t(peso) \t\t|\n" +
                "|Norway\t(krone) \t\t|\n" +
                "|New\tZealand\t(dollar) |\n" +
                "|Singapore\t(dollar) \t\t\t\t\t\t|\n" +
                "Scenario:\tError\tmessage for\tnot\tselecting\tcurrency\n" +
                "Given the user accesses the Purchase\tforeign\tcurrency\tcash tab\n" +
                "When\tuser tries\tto\tcalculate\tcost\twithout\tselecting\ta\tcurrency\n" +
                "Then\terror\tmessage\tshould\tbe\tdisplayed\n" +
                "Scenario:\tError\tmessage for\tnot\tentering\tvalue\n" +
                "Given the user accesses the Purchase\tforeign\tcurrency\tcash tab\n" +
                "When\tuser tries\tto\tcalculate\tcost\twithout\tentering\ta\tvalue\n" +
                "Then error\tmessage\tshould\tbe\tdisplayed";

        System.out.println(story.replace("\t", " ").replace("“","\"").replace("”","\""));

    }
}