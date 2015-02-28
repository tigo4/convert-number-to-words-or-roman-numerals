package number.printer;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.lang3.exception.ExceptionUtils;

public class NumberToRomanNumeralTest {

    private static final Logger logger = LogManager.getLogger("NumberToRomanNumeralTest");

    @Test
    public void rangeTest() throws Exception {

        logger.info("%%%%%%%%%% rangeTest %%%%%%%%%");

        boolean result1 = false;
        boolean result2 = false;

        try {
            NumberToRomanNumeral.convertNumberToRomanNumeral(0);
        } catch (Exception e) {
            logger.info("===== ok " + e.getMessage());
            result1 = true;
        }

        try {
            NumberToRomanNumeral.convertNumberToRomanNumeral(4000);
        } catch (Exception e) {
            logger.info("===== ok " + e.getMessage());
            result2 = true;
        }

        if (result1 != true || result2 != true)
            throw new Exception("range test failed");
            
    }

    /*
    @Test
    public void length1Test() throws Exception {

        logger.info("%%%%%%%%%% length1Test %%%%%%%%%");

        String word = NumberToRomanNumeral.convertNumberToRomanNumeral(1);
        String expected = "One";
        logger.info("===== word -" + word + "-");
        logger.info("===== expected -" + expected + "-");
        assertTrue(word.equals(expected));

        word = NumberToRomanNumeral.convertNumberToRomanNumeral(5);
        expected = "Five";
        logger.info("===== word -" + word + "-");
        logger.info("===== expected -" + expected + "-");
        assertTrue(word.equals(expected));

        word = NumberToRomanNumeral.convertNumberToRomanNumeral(9);
        expected = "Nine";
        logger.info("===== word -" + word + "-");
        logger.info("===== expected -" + expected + "-");
        assertTrue(word.equals(expected));

    }

    @Test
    public void length2Test() throws Exception {

        logger.info("%%%%%%%%%% length2Test %%%%%%%%%");

        String word = NumberToRomanNumeral.convertNumberToRomanNumeral(10);
        String expected = "Ten";
        logger.info("===== word -" + word + "-");
        logger.info("===== expected -" + expected + "-");
        assertTrue(word.equals(expected));

        word = NumberToRomanNumeral.convertNumberToRomanNumeral(11);
        expected = "Eleven";
        logger.info("===== word -" + word + "-");
        logger.info("===== expected -" + expected + "-");
        assertTrue(word.equals(expected));

        word = NumberToRomanNumeral.convertNumberToRomanNumeral(99);
        expected = "Ninety nine";
        logger.info("===== word -" + word + "-");
        logger.info("===== expected -" + expected + "-");
        assertTrue(word.equals(expected));

        word = NumberToRomanNumeral.convertNumberToRomanNumeral(25);
        expected = "Twenty five";
        logger.info("===== word -" + word + "-");
        logger.info("===== expected -" + expected + "-");
        assertTrue(word.equals(expected));

    }
    */

    @Test
    public void length3Test() throws Exception {

        logger.info("%%%%%%%%%% length3Test %%%%%%%%%");

        String word = NumberToRomanNumeral.convertNumberToRomanNumeral(999);
        String expected = "CMXCIX";
        logger.info("===== word -" + word + "-");
        logger.info("===== expected -" + expected + "-");
        assertTrue(word.equals(expected));

        word = NumberToRomanNumeral.convertNumberToRomanNumeral(555);
        expected = "DLV";
        logger.info("===== word -" + word + "-");
        logger.info("===== expected -" + expected + "-");
        assertTrue(word.equals(expected));

    }

    @Test
    public void length4Test() throws Exception {

        logger.info("%%%%%%%%%% length4Test %%%%%%%%%");

        String word = NumberToRomanNumeral.convertNumberToRomanNumeral(1974);
        String expected = "MCMLXXIV";
        logger.info("===== word -" + word + "-");
        logger.info("===== expected -" + expected + "-");
        assertTrue(word.equals(expected));

        word = NumberToRomanNumeral.convertNumberToRomanNumeral(2999);
        expected = "MMCMXCIX";
        logger.info("===== word -" + word + "-");
        logger.info("===== expected -" + expected + "-");
        assertTrue(word.equals(expected));

    }

}

