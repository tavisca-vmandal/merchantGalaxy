package com.tavisca.training.practice;

public class Validation {


    public Boolean threeTimesRomanSuccessionValidator(String romanNumeral) {

        if(romanNumeral.contains("III")||romanNumeral.contains("XXX")||romanNumeral.contains("CCC")||romanNumeral.contains("MMMM"))
            return true;
        else
            return false;
    }


    public boolean roman_I_SubtractionValidator(String romanNumeral) {

       int index=romanNumeral.indexOf('I');
       System.out.println(index+ " char at "+romanNumeral.charAt(index+1));

       if(index==(romanNumeral.length()-1))
           return true;

       if((romanNumeral.charAt(index+1)=='V'||romanNumeral.charAt(index+1)=='X'||romanNumeral.charAt(index+1)=='I'))
       {
           while(true)
           {
               index=romanNumeral.indexOf('I',index+1);

               if(index==-1) {
                   break;
               }
               if(index==(romanNumeral.length()-1))
                   return true;

               if((romanNumeral.charAt(index+1)=='V'||romanNumeral.charAt(index+1)=='X'||romanNumeral.charAt(index+1)=='I'))
               {
                   continue;
               }
               else
                   return false;
           }
           return true;
       }
       else
        return false;

    }

    public boolean roman_X_SubtractionValidator(String romanNumeral) {
        int index=romanNumeral.indexOf('X');
        System.out.println(index+ " char at "+romanNumeral.charAt(index+1));

        if(index==(romanNumeral.length()-1))

            return true;

        if((romanNumeral.charAt(index+1)=='L'||romanNumeral.charAt(index+1)=='X'||romanNumeral.charAt(index+1)=='C'))
        {
            while(true)
            {
                index=romanNumeral.indexOf('X',index+1);

                if(index==-1) {
                    break;
                }
                if(index==(romanNumeral.length()-1))
                    return true;

                if((romanNumeral.charAt(index+1)=='L'||romanNumeral.charAt(index+1)=='X'||romanNumeral.charAt(index+1)=='C'))
                {
                    continue;
                }
                else
                    return false;
            }
            return true;
        }
        else
            return false;

    }

    public boolean roman_C_SubtractionValidator(String romanNumeral) {
        int index=romanNumeral.indexOf('C');
        System.out.println(index+ " char at "+romanNumeral.charAt(index+1));

        if(index==(romanNumeral.length()-1))

            return true;

        if((romanNumeral.charAt(index+1)=='D'||romanNumeral.charAt(index+1)=='M'||romanNumeral.charAt(index+1)=='C'))
        {
            while(true)
            {
                index=romanNumeral.indexOf('C',index+1);

                if(index==-1) {
                    break;
                }
                if(index==(romanNumeral.length()-1))
                    return true;

                if((romanNumeral.charAt(index+1)=='D'||romanNumeral.charAt(index+1)=='M'||romanNumeral.charAt(index+1)=='C'))
                {
                    continue;
                }
                else
                    return false;
            }
            return true;
        }
        else
            return false;

    }
}
