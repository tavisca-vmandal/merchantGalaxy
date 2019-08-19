package com.tavisca.training.practice;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;


public class ClassificationParser {


    public static void main(String[] args) throws Exception
    {
        GalaxyTransaction galaxyObject=new GalaxyTransaction();
        BufferedReader reader;
        try {

            reader = new BufferedReader(new FileReader(
                    System.getProperty("user.dir")+"/main/java/com/tavisca/training/practice/InputFile"));

            String input = reader.readLine();

            while (input != null) {

                if(input.endsWith("I")||input.endsWith("V")||input.endsWith("X")||input.endsWith("C")||input.endsWith("L")||input.endsWith("D")||input.endsWith("M"))
                {

                    galaxyObject.populateWordToRomanMap(input);
                    input = reader.readLine();
                    continue;
                }
                else if(input.endsWith("Credits"))
                {

                    galaxyObject.populateTokenToValueMap(input);
                    input = reader.readLine();
                    continue;
                }
                else if(input.startsWith("how much is")&&input.endsWith("?"))
                {

                    System.out.println(galaxyObject.findArabicEquivalent(input));
                }
                else if(input.startsWith("how many Credits is")&&input.endsWith("?"))
                {

                    System.out.println(galaxyObject.findValueOfToken(input));
                }
                else
                {
                    System.out.println("I have no idea what you are talking about");
                }

                input = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
