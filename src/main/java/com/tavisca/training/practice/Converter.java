package com.tavisca.training.practice;

import java.util.HashMap;

public class Converter {

    private final HashMap<Character,Integer> romanToArabicMap=new HashMap<>(){{

        put('I',1);
        put('V',5);
        put('X',10);
        put('L',50);
        put('C',100);
        put('D',500);
        put('M',1000);
    }};

    public String convertWordToRoman(String input, HashMap<String, String> wordToRomanMap) {
        
        StringBuilder roman=new StringBuilder();

        for (String s:input.split(" "))
        {
            roman.append(wordToRomanMap.get(s));
        }
        return roman.toString();
    }

    public int convertRomanToArabic(String romanNumeral) {
        int arabicNumeral=0;

        for(int i=0;i<romanNumeral.length();)
        {
            if(i==romanNumeral.length()-1)
            {
                arabicNumeral+=romanToArabicMap.get(romanNumeral.charAt(i));
                break;
            }
            if(romanToArabicMap.get(romanNumeral.charAt(i))>=romanToArabicMap.get(romanNumeral.charAt(i+1)))
            {
                arabicNumeral+=romanToArabicMap.get(romanNumeral.charAt(i));
                i++;
            }
            else
            {
                arabicNumeral+=romanToArabicMap.get(romanNumeral.charAt(i+1))-romanToArabicMap.get(romanNumeral.charAt(i));
                i=i+2;
            }
        }
        return arabicNumeral;
    }
}
