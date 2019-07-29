package com.tavisca.training.practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConversionTest {

    @Test
    void canConvertWordsToRomanEquivalent()
    {
        GalaxyTransaction galaxyObject=new GalaxyTransaction();
        galaxyObject.populateWordToRomanMap("glob is I");
        galaxyObject.populateWordToRomanMap("prok is V");
        galaxyObject.populateWordToRomanMap("pish is X");
        galaxyObject.populateWordToRomanMap("tegj is L");
        Converter converter=new Converter();
        assertEquals("IVX", converter.convertWordToRoman("glob prok pish",galaxyObject.wordToRomanMap));
        assertEquals("XLII", converter.convertWordToRoman("pish tegj glob glob",galaxyObject.wordToRomanMap));
        assertEquals("XXX", converter.convertWordToRoman("pish pish pish",galaxyObject.wordToRomanMap));
    }

    @Test
    void canConvertOrderedRomanNumeralsToArabicNumerals()
    {
        Converter converter=new Converter();
        assertEquals(2006,converter.convertRomanToArabic("MMVI"));
    }

    @Test
    void canConvertUnorderedRomanNumeralsToArabicNumerals()
    {
        Converter converter=new Converter();
        assertEquals(1944,converter.convertRomanToArabic("MCMXLIV"));
    }
}
