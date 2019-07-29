package com.tavisca.training.practice;

import java.util.HashMap;

public class GalaxyTransaction {

    public HashMap<String,String> wordToRomanMap=new HashMap<>();
    public HashMap<String,Double> tokenToValueMap = new HashMap<>();
    public Validation validation=new Validation();



    public void populateWordToRomanMap(String input) {

        WordToRomanParser wordToRomanParser=new WordToRomanParser();
       String[] wordAndRoman=wordToRomanParser.parse(input);

       String word=wordAndRoman[0];
       String romanNumber=wordAndRoman[1];

       if(wordToRomanMap.containsKey(word)&&wordToRomanMap.get(word)!=romanNumber)
       {
           try {
                throw new RuntimeException();
           }
           catch (Exception e)
           {
               throw e;
           }
       }
       else
           wordToRomanMap.put(word,romanNumber);
    }

    public String[] calculateValueOfToken(String input) {

        StatementToTokenAndCreditsParser parser=new StatementToTokenAndCreditsParser();
        String[] tokenSplits=parser.parseToTokenAndCredits(input);
        String tokenType=tokenSplits[1];
        String numberOfTokens=tokenSplits[0];
        String numberOfCredits=tokenSplits[2];

        Converter converter=new Converter();

        String romanNumeral=converter.convertWordToRoman(numberOfTokens,wordToRomanMap);
        int arabicNumeral=converter.convertRomanToArabic(romanNumeral);

        double valueOfToken =Double.parseDouble(numberOfCredits)/arabicNumeral;


        return new String[]{tokenType,Double.toString(valueOfToken)};

    }

    public void populateTokenToValueMap(String input) {

        String[] splits=calculateValueOfToken(input);
        String tokenType=splits[0];
        Double valueOfToken=Double.parseDouble(splits[1]);
        tokenToValueMap.put(tokenType,valueOfToken);

    }


    public String findArabicEquivalent(String input) {

        QuestionParser parser=new QuestionParser();
        String localNumerals = parser.parseDirectQuestion(input);

        Converter converter=new Converter();

        String romanNumerals=converter.convertWordToRoman(localNumerals,wordToRomanMap);


        int arabicNumerals =converter.convertRomanToArabic(romanNumerals);

        return localNumerals +" is " + arabicNumerals;

    }

    public String findValueOfToken(String input) {

        QuestionParser parser=new QuestionParser();
        String[] localNumeralsAndTokenType = parser.parseTokenValueQuestion(input);

        String localNumerals=localNumeralsAndTokenType[0];
        String tokenType=localNumeralsAndTokenType[1];

        Converter converter=new Converter();

        String romanNumerals=converter.convertWordToRoman(localNumerals,wordToRomanMap);
        int arabicNumerals=converter.convertRomanToArabic(romanNumerals);

        double valueOfToken=tokenToValueMap.get(tokenType);

        double finalValueOfToken = arabicNumerals*valueOfToken;

        return localNumerals +" "+tokenType+" is "+finalValueOfToken+" Credits";
    }
}
