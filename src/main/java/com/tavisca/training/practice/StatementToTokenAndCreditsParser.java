package com.tavisca.training.practice;

public class StatementToTokenAndCreditsParser {

    private String tokenType;
    private StringBuilder numberOfTokens;
    private String numberOfCredits;


    public String[] parseToTokenAndCredits(String input) {

        String[] tokenAndCreditsSplits =input.split(" is ");
        String numberOfTokensAndTokens=tokenAndCreditsSplits[0];
        String credits=tokenAndCreditsSplits[1];

        String[] numberOfTokensSplits=numberOfTokensAndTokens.split(" ");

        int length=numberOfTokensSplits.length;
        tokenType =numberOfTokensSplits[length-1];

        numberOfTokens=new StringBuilder();

        for(int i=0;i<(length-1);i++)
        {
            numberOfTokens.append(numberOfTokensSplits[i]);
            if(i!=length-2)
                numberOfTokens.append(" ");
        }

        String[] numberOfCreditsSplit=credits.split(" ");
        numberOfCredits=(numberOfCreditsSplit[0]);

        return new String[]{numberOfTokens.toString(),tokenType,numberOfCredits};
    }


}

