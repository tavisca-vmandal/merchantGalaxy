package com.tavisca.training.practice;


public class WordToRomanParser {


    public String[] parse(String input) {

        String[] splits =input.split(" ");
        String word=splits[0];
        String romanNumber=splits[2];
        return (new String[]{word,romanNumber});
    }

}
