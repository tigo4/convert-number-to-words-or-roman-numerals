package number.printer;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.lang3.exception.ExceptionUtils;

public class NumberPrinterTest {

    private static final Logger logger = LogManager.getLogger("NumberPrinterTest");

    @Test
    public void numberPrinterTest() throws Exception {

        String convertionMode = System.getProperty("convertionMode");
        String numberToConvert = System.getProperty("numberToConvert");
        if (convertionMode == null) convertionMode = "false";
        if (numberToConvert == null) convertionMode = "false";
        // mvn ... -DconvertionMode=WORDS or -DconvertionMode=ROMAN
        // number: -DnumberToConvert
        // else the test is marked as skipped
        org.junit.Assume.assumeTrue(!convertionMode.equals("false"));

        logger.info("%%%%%%%%%% numberPrinterTest %%%%%%%%%");

        int number = Integer.parseInt(numberToConvert);

        String word = "";
        if (convertionMode.equals("WORDS")) {
            word = NumberToWord.convertNumberToWord(number);
            logger.info("===== WORDS test result -" + word + "-");
        } else if (convertionMode.equals("ROMAN")) {
            word = NumberToRomanNumeral.convertNumberToRomanNumeral(number);
            logger.info("===== ROMAN test result -" + word + "-");
        } else {
            throw new Exception("convertionMode: WORDS or ROMAN");
        }

    }

}

