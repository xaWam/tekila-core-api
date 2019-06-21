/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaravir.tekila.base.entity;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Locale;

/**
 * @author sajabrayilov
 */
public class Util {
    public static Double parseAmountFromStringIntoDouble(String manats, String cents) {
        return Double.parseDouble(parseAmountFromString(manats, cents));
    }

    public static Long parseAmountFromStringIntoLong(String manats, String cents) {
        return Double.valueOf(parseAmountFromStringIntoDouble(manats, cents) * 100000).longValue();
    }

    private static String parseAmountFromString(String manats, String cents) {
        return (cents != null && !cents.isEmpty() && cents.length() == 2) ? manats + '.' + cents : manats;
    }

    public static String convertFromLongToString(long amount) {
        double am = amount / 100000d;

        DecimalFormat df = new DecimalFormat();
        df.setRoundingMode(RoundingMode.FLOOR);
        return String.format(Locale.US, "%.2f", am);
    }

    public static String[] convertFromLongToStringArray(long amount) {
        String am = convertFromLongToString(amount);

        if (am.contains(".") && am.lastIndexOf('.') < am.length() - 1) {
            return am.split("\\.");
        }

        return new String[]{am};
    }

    public static long convertFromDoubleToLong(double value) {
        return Float.valueOf(Double.valueOf(value).floatValue() * 100000).longValue();
    }

    public static boolean isLegalMacAddress(String mac) {
        byte counter = 0;
        for (int i = 0; i < mac.length(); i++) {
            if (mac.charAt(i) == '.') {
                counter++;
            }
        }
        return counter == 2;
    }
}
