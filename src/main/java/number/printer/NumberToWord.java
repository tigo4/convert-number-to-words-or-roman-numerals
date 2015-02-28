package number.printer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.lang3.exception.ExceptionUtils;

public class NumberToWord {

    private static final Logger logger = LogManager.getLogger("NumberToWord");

    private static final String[] until20 = { "", " one", " two", " three",
            " four", " five", " six", " seven", " eight", " nine", " ten",
            " eleven", " twelve", " thirteen", " fourteen", " fifteen",
            " sixteen", " seventeen", " eighteen", " nineteen" };

    private static final String[] wordsx10 = { "", " ten", " twenty",
            " thirty", " forty", " fifty", " sixty", " seventy", " eighty",            " ninety" };

    public static String convertNumberToWord(int number) throws Exception {

        logger.info("number: " + number);

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

            out = get99Part(numberStr, out, " and");

        } else if (numberStr.length() == 3) {

            String a = until20[Integer.parseInt(""+numberStr.charAt(0))];
            out += Character.toUpperCase(a.trim().charAt(0)) + a.trim().substring(1) + " hundred";

            out = get99Part(numberStr, out, " and");

        } else if (numberStr.length() == 2) {

            out = get99Part(numberStr, out, "");
            out = Character.toUpperCase(out.trim().charAt(0)) + out.trim().substring(1);

        }

        return out;

    }

    private static String get99Part(String numberStr, String out, String andWord) {

        int startPos = numberStr.length() - 2;
        int endPos = startPos + 1;

        if (Integer.parseInt(""+numberStr.charAt(startPos))>1) {
            String b = wordsx10[Integer.parseInt(""+numberStr.charAt(startPos))];
            out += b.equals("") ? b : andWord + b;
            String b1 = until20[Integer.parseInt(""+numberStr.charAt(endPos))];
            out += b1;
        } else {
            String c = until20[Integer.parseInt(""+numberStr.charAt(startPos)+numberStr.charAt(endPos))];
            out += c.equals("") ? c : andWord + c;
        }

        return out;

    }

}

