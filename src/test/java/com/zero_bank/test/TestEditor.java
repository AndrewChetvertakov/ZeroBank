package com.zero_bank.test;

public class TestEditor {
    public static void main(String[] args) {




        String story = "Account\tsummary\n" +
                "Account\tsummary\tpage\tshould\thave\tthe\ttitle\tZero\t– Account\tsummary.\tAccount\n" +
                "summary\tpage\tshould\thave\tto\tfollowing\taccount\ttypes:\tCash\tAccounts,\tInvestment\n" +
                "Accounts,\tCredit\tAccounts,\tLoan\tAccounts.\tCredit\tAccounts table\tmust\thave\tcolumns\n" +
                "Account,\tCredit\tCard and\tBalance.";

        System.out.println(story.replace("\t", " "));

    }
}