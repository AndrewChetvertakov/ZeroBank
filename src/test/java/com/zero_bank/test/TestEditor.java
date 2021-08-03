package com.zero_bank.test;

public class TestEditor {
    public static void main(String[] args) {




        String story = "Scenario:\tType\n" +
                "Given\tthe\tuser\taccesses\tthe\tFind\tTransactions\ttab\n" +
                "And\tclicks\tsearch\n" +
                "Then\tresults\ttable\tshould\tshow\tat\tleast\tone\tresult\tunder\tDeposit\n" +
                "Then\tresults\ttable\tshould\tshow\tat\tleast\tone\tresult\tunder\tWithdrawal\n" +
                "When\tuser\tselects\ttype\t“Deposit”\n" +
                "Then\tresults\ttable\tshould\tshow\tat\tleast\tone\tresult\tunder\tDeposit\n" +
                "But\tresults\ttable\tshould\tshow\tno\tresult\tunder\tWithdrawal\n" +
                "When\tuser\tselects\ttype\t“Withdrawal”\n" +
                "Then\tresults\ttable\tshould\tshow\tat\tleast\tone\tresult\tunder\tWithdrawal\n" +
                "But\tresults\ttable\tshould\tshow\tno\tresult\tunder\tDeposit";

        System.out.println(story.replace("\t", " "));

    }
}