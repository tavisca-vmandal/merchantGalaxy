package com.tavisca.training.practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;



import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {

    @Test
    void  canParseWordToRomanNumeralStatements(){

        WordToRomanParser wordToRomanParser=new WordToRomanParser();
        assertArrayEquals(new String[]{"glob","I"},wordToRomanParser.parse("glob is I"));
        assertArrayEquals(new String[]{"prok","V"},wordToRomanParser.parse("prok is V"));
        assertArrayEquals(new String[]{"phis","X"},wordToRomanParser.parse("phis is X"));
        assertArrayEquals(new String[]{"tecg","L"},wordToRomanParser.parse("tecg is L"));

    }

    @Test
    void canParseStatementToNumberOfTokensAndValueCredits(){

        StatementToTokenAndCreditsParser statementToTokenAndCreditsParser=new StatementToTokenAndCreditsParser();
        assertArrayEquals(new String[]{"glob glob","silver","34"},statementToTokenAndCreditsParser.parseToTokenAndCredits("glob glob silver is 34 Credits"));
    }


    @Test
    void canMapWordToRomanNumerals()
    {

        GalaxyTransaction galaxyObject=new GalaxyTransaction();
        galaxyObject.populateWordToRomanMap("glob is I");
        galaxyObject.populateWordToRomanMap("prok is V");
        assertEquals("I",galaxyObject.wordToRomanMap.get("glob"));
        assertEquals("V",galaxyObject.wordToRomanMap.get("prok"));
    }

    @Test
    void canThrowExceptionToMultipleMappingOfWordToRomanNumerals()
    {
        assertThrows(Exception.class,()->{
            GalaxyTransaction galaxyObject=new GalaxyTransaction();
            galaxyObject.populateWordToRomanMap("glob is I");
            galaxyObject.populateWordToRomanMap("glob is V");});
    }


    @Test
    void canParseDirectArabicConversionQuestions()
    {
        QuestionParser questionParser=new QuestionParser();
        assertEquals("pish tegj glob glob",questionParser.parseDirectQuestion("how much is pish tegj glob glob ?"));
    }

    @Test
    void canParseTokenValueQuestions()
    {
        QuestionParser questionParse=new QuestionParser();
        assertArrayEquals(new String[]{"glob prok","Silver"},questionParse.parseTokenValueQuestion("how many Credits is glob prok Silver ?"));
    }
}

