package number.printer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.lang3.exception.ExceptionUtils;

public class NumberToRomanNumeral {

    private static final Logger logger = LogManager.getLogger("NumberToRomanNumeral");

    private static final String[] until20 = { "", "I","II",
        "III","IV", "V","VI","VII","VIII","IX",  
        "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII",
        "XVIII", "XIX"};
    private static final String[] wordsx10 = { "", "X","XX","XXX",
        "XL","L","LX","LXX", "LXXX","XC" };
    private static final String[] hundred = { "", "C", "CC", "CCC", 
        "CD", "D", "DC", "DCC", "DCCC", "CM" };

    public static String convertNumberToRomanNumeral(int number) throws Exception {

        logger.info("number: " + number);

        String out = "";

        if (number > 3999 || number < 1)
            throw new Exception("expected range 1 : 3999 got " + number);

        String numberStr = number + "";
        if (numberStr.length() == 4) {

            if (new String(""+numberStr.charAt(0)).equals("1"))
                out += "M";
            else if (new String(""+numberStr.charAt(0)).equals("2"))
                out += "MM";
            else if (new String(""+numberStr.charAt(0)).equals("3"))
                out += "MMM";

            String a = hundred[Integer.parseInt(""+numberStr.charAt(1))];
            out += a;

            out = get99Part(numberStr, out);

        } else if (numberStr.length() == 3) {

            String a = hundred[Integer.parseInt(""+numberStr.charAt(0))];
            out += a;

            out = get99Part(numberStr, out);

        } else if (numberStr.length() == 2) {

            out = get99Part(numberStr, out);

        } else if (numberStr.length() == 1) {

            out = until20[number];

        }

        return out;

    }

    private static String get99Part(String numberStr, String out) {

        int startPos = numberStr.length() - 2;
        int endPos = startPos + 1;

        if (Integer.parseInt(""+numberStr.charAt(startPos))>1) {
            String b = wordsx10[Integer.parseInt(""+numberStr.charAt(startPos))];
            out += b.equals("") ? b : b;
            String b1 = until20[Integer.parseInt(""+numberStr.charAt(endPos))];
            out += b1;
        } else {
            String c = until20[Integer.parseInt(""+numberStr.charAt(startPos)+numberStr.charAt(endPos))];
            out += c.equals("") ? c : c;
        }

        return out;

    }

}

