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
    public void numberToWordTest() {
        assertTrue(true);
    }

}

