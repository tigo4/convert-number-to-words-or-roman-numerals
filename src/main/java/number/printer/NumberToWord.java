package number.printer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.lang3.exception.ExceptionUtils;

public class NumberToWord {

    private static final Logger logger = LogManager.getLogger("NumberToWord");

    public static String convertNumberToWord(int number) throws Exception {

        logger.info("number: " + number);

        String[] until20 = { "", " one", " two", " three", 
            " four", " five", " six", " seven", " eight", " nine", " ten", 
            " eleven", " twelve", " thirteen", " fourteen", " fifteen", 
            " sixteen", " seventeen", " eighteen", " nineteen" };

        String[] wordsx10 = { "", " ten", " twenty", 
            " thirty", " forty", " fifty", " sixty", " seventy", " eighty",            " ninety" };

        String out = "";

        if (number > 3999 || number < 1)
            throw new Exception("expected range 1 : 3999 got " + number);

        String numberStr = number + "";
        if (numberStr.length() == 4) {

            if (new String(""+numberStr.charAt(0)).equals("1"))
                out += "One thousand";
            else if (new String(""+numberStr.charAt(0)).equals("2"))
                out += "Two thousand";
            else if (new String(""+numberStr.charAt(0)).equals("3"))
                out += "Three thousand";

            String a = until20[Integer.parseInt(""+numberStr.charAt(1))];
            out += a.equals("") ? a : " and" + a + " hundred";

            if (Integer.parseInt(""+numberStr.charAt(2))>1) {
                String b = wordsx10[Integer.parseInt(""+numberStr.charAt(2))];
                out += b.equals("") ? b : " and" + b;
                String b1 = until20[Integer.parseInt(""+numberStr.charAt(3))];
                out += b1;
            } else {
                String c = until20[Integer.parseInt(""+numberStr.charAt(2)+numberStr.charAt(3))];
                out += c.equals("") ? c : " and" + c;
            }

        }

        return out;

    }

}

