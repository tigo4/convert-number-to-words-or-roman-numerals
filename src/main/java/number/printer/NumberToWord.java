package number.printer;

public class NumberToWord {

    public static String convertNumberToWord(int number) throws Exception {
        if (number > 3999 || number < 1)
            throw new Exception("expected range 1 : 3999 got " + number);
        return null;
    }

}

