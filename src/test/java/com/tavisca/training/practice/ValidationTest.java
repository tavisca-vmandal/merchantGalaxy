package com.tavisca.training.practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidationTest {

    GalaxyTransaction g;
    Converter converter;


    @BeforeEach
    void initialise()
    {
        g=new GalaxyTransaction();

        g.populateWordToRomanMap("glob is V");
        g.populateWordToRomanMap("prok is I");
        g.populateWordToRomanMap("phis is X");
        g.populateWordToRomanMap("tegj is C");
        g.populateWordToRomanMap("cray is L");
        g.populateWordToRomanMap("drak is M");
        g.populateWordToRomanMap("jaqa is D");

        converter=new Converter();

    }
    @Test
    void roman_I_X_C_M_CanBeRepeatedUptoThreeTimesInSuccession()
    {
        String romanNumeral=converter.convertWordToRoman("prok prok prok",g.wordToRomanMap);
        String r=converter.convertWordToRoman("phis phis phis",g.wordToRomanMap);
        String r1=converter.convertWordToRoman("glob glob glob",g.wordToRomanMap);

        assertTrue(g.validation.threeTimesRomanSuccessionValidator(romanNumeral));
        assertTrue(g.validation.threeTimesRomanSuccessionValidator(r));
        assertFalse(g.validation.threeTimesRomanSuccessionValidator(r1));

    }

    @Test
    void roman_I_CanBeSubtractedFrom_V_and_X_only()
    {
        String romanNumeral=converter.convertWordToRoman("prok glob",g.wordToRomanMap);
        String r=converter.convertWordToRoman("prok tegj",g.wordToRomanMap);
        assertTrue(g.validation.roman_I_SubtractionValidator(romanNumeral));
    }

    @Test
    void roman_X_CanBeSubtractedFrom_L_and_C_only()
    {
        String romanNumeral=converter.convertWordToRoman("phis glob",g.wordToRomanMap);
        String r=converter.convertWordToRoman("phis cray",g.wordToRomanMap);

        assertTrue(g.validation.roman_X_SubtractionValidator(r));
        assertFalse(g.validation.roman_X_SubtractionValidator(romanNumeral));
    }

    @Test
    void roman_C_CanBeSubtractedFrom_D_and_M_only()
    {
        String romanNumeral=converter.convertWordToRoman("tegj glob",g.wordToRomanMap);
        String r=converter.convertWordToRoman("tegj drak glob",g.wordToRomanMap);

        assertTrue(g.validation.roman_C_SubtractionValidator(r));
        assertFalse(g.validation.roman_C_SubtractionValidator(romanNumeral));
    }

}
