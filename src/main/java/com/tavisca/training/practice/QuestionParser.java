package com.tavisca.training.practice;

public class QuestionParser {

    public String parseDirectQuestion(String input) {

        String[] questionSplits=input.split("is ");

        String localNumerals =questionSplits[1].substring(0,questionSplits[1].lastIndexOf(" "));

        return localNumerals;
    }

    public String[] parseTokenValueQuestion(String input) {

        String[] questionsSplit=input.split(" is ");

        String[] localNumeralAndTokenSplit=questionsSplit[1].split(" ");

        int length=localNumeralAndTokenSplit.length;
        String tokenType =localNumeralAndTokenSplit[length-2];

        StringBuilder localNumerals = new StringBuilder();

        for(int i=0;i<(length-2);i++)
        {
            localNumerals.append(localNumeralAndTokenSplit[i]);
            if(i!=length-3)
                localNumerals.append(" ");
        }

        return new String[]{localNumerals.toString(),tokenType};
    }
}
