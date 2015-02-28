package number.printer;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.lang3.exception.ExceptionUtils;

public class NumberToWordTest {

    private static final Logger logger = LogManager.getLogger("NumberToWordTest");

    @Test
    public void rangeTest() throws Exception {

        boolean result1 = false;
        boolean result2 = false;

        try {
            NumberToWord.convertNumberToWord(0);
        } catch (Exception e) {
            logger.info("===== ok " + e.getMessage());
            result1 = true;
        }

        try {
            NumberToWord.convertNumberToWord(4000);
        } catch (Exception e) {
            logger.info("===== ok " + e.getMessage());
            result2 = true;
        }

        if (result1 != true || result2 != true)
            throw new Exception("range test failed");
            
    }

    @Test
    public void length4Test() throws Exception {

        String word = NumberToWord.convertNumberToWord(1000);
        String expected = "One thousand";
        logger.info("===== word -" + word + "-");
        logger.info("===== expected -" + expected + "-");
        assertTrue(word.equals(expected));

        word = NumberToWord.convertNumberToWord(1001);
        expected = "One thousand and one";
        logger.info("===== word -" + word + "-");
        logger.info("===== expected -" + expected + "-");
        assertTrue(word.equals(expected));

        word = NumberToWord.convertNumberToWord(1011);
        expected = "One thousand and eleven";
        logger.info("===== word -" + word + "-");
        logger.info("===== expected -" + expected + "-");
        assertTrue(word.equals(expected));

        word = NumberToWord.convertNumberToWord(1010);
        expected = "One thousand and ten";
        logger.info("===== word -" + word + "-");
        logger.info("===== expected -" + expected + "-");
        assertTrue(word.equals(expected));

        word = NumberToWord.convertNumberToWord(1009);
        expected = "One thousand and nine";
        logger.info("===== word -" + word + "-");
        logger.info("===== expected -" + expected + "-");
        assertTrue(word.equals(expected));

        word = NumberToWord.convertNumberToWord(1090);
        expected = "One thousand and ninety";
        logger.info("===== word -" + word + "-");
        logger.info("===== expected -" + expected + "-");
        assertTrue(word.equals(expected));

        word = NumberToWord.convertNumberToWord(1100);
        expected = "One thousand and one hundred";
        logger.info("===== word -" + word + "-");
        logger.info("===== expected -" + expected + "-");
        assertTrue(word.equals(expected));

        word = NumberToWord.convertNumberToWord(1101);
        expected = "One thousand and one hundred and one";
        logger.info("===== word -" + word + "-");
        logger.info("===== expected -" + expected + "-");
        assertTrue(word.equals(expected));

        word = NumberToWord.convertNumberToWord(1110);
        expected = "One thousand and one hundred and ten";
        logger.info("===== word -" + word + "-");
        logger.info("===== expected -" + expected + "-");
        assertTrue(word.equals(expected));

        word = NumberToWord.convertNumberToWord(1111);
        expected = "One thousand and one hundred and eleven";
        logger.info("===== word -" + word + "-");
        logger.info("===== expected -" + expected + "-");
        assertTrue(word.equals(expected));

        word = NumberToWord.convertNumberToWord(2345);
        expected = "Two thousand and three hundred and forty five";
        logger.info("===== word -" + word + "-");
        logger.info("===== expected -" + expected + "-");
        assertTrue(word.equals(expected));

    }

}

