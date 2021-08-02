package com.zero_bank.test;

public class TestEditor {
    public static void main(String[] args) {




        String story = " Pay\tBills\n" +
                "Account\tActivity\tpage\tshould\thave\tthe\ttitle\tZero\t– Pay\tBills.\tWhen\tuser\tcompletes\ta\n" +
                "successful\tPay\toperation,\tThe\tpayment\twas\tsuccessfully\tsubmitted.\tshould\tbe\n" +
                "displayed.\tWhen\tuser\ttries\tto\tmake\ta\tpayment\twithout\tentering\tthe\tamount\tor\tdate,\n" +
                "Please\tfill\tout\tthis\tfield\tmessage! should\tbe\tdisplayed.\n" +
                "Amount\tfield\tshould\tnot\taccept\talphabetical\tor\tspecial\tcharacters.\tDate\tfield\tshould\n" +
                "not\taccept\talphabetical\tcharacters.\n" +
                "NOTE:\t.\tFor\tthe\tdate\tinput\tfield\tyou\tcan\tjust\tuse\tsendKeys.\tNo\tneed\tto\tclick\ton\tthe\tdate\tnavigator.";

        System.out.println(story.replace("\t", " "));

    }
}