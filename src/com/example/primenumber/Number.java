package com.example.primenumber;

import java.util.regex.Pattern;

public class Number {
    private Pattern pattern = Pattern.compile("\\d+");
    private String strNumber;
    private Integer intNumber;

    public void setNumber(String number) {
        strNumber = number;
    }

    public boolean isPrime() {
        if (!isNumeric(strNumber))
            return false;

        intNumber = Integer.parseInt(strNumber);
        for(int i = 2; i <= intNumber / 2; i++)
            if (intNumber % i == 0)
                return false;

        return true;
    }

    private boolean isNumeric(String str) {
        if (str == null)
            return false;
        return pattern.matcher(str).matches();
    }
}
