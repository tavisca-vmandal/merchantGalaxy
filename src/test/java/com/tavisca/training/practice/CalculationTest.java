package com.tavisca.training.practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class CalculationTest {

    GalaxyTransaction gt;

    @BeforeEach
    void initialise()
    {
        gt =new GalaxyTransaction();

        gt.populateWordToRomanMap("glob is I");
        gt.populateWordToRomanMap("prok is V");
        gt.populateWordToRomanMap("pish is X");
        gt.populateWordToRomanMap("tegj is L");
        gt.populateWordToRomanMap("cray is C");
        gt.populateWordToRomanMap("drak is M");
        gt.populateWordToRomanMap("jaqa is D");


    }
    @Test
    void canCalculateValueOfToken()
    {

        assertArrayEquals(new String[]{"Silver","17.0"},gt.calculateValueOfToken("glob glob Silver is 34 Credits"));

    }

    @Test
    void canSolveDirectArabicConversionQuestion()
    {
        assertEquals("pish tegj glob glob is 42",gt.findArabicEquivalent("how much is pish tegj glob glob ?"));
    }

    @Test
    void canSolveValueOfTokenTypeQuestions()
    {
        gt.populateTokenToValueMap("glob glob Silver is 34 Credits");
        gt.populateTokenToValueMap("glob prok Gold is 57800 Credits");
        gt.populateTokenToValueMap("pish pish Iron is 3910 Credits");

        assertEquals("glob prok Iron is 782.0 Credits",gt.findValueOfToken("how many Credits is glob prok Iron ?"));

        assertEquals("glob prok Gold is 57800.0 Credits",gt.findValueOfToken("how many Credits is glob prok Gold ?"));
        assertEquals("glob prok Silver is 68.0 Credits",gt.findValueOfToken("how many Credits is glob prok Silver ?"));
    }
}

