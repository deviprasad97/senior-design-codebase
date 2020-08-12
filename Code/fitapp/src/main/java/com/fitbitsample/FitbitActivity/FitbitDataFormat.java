package com.fitbitsample.FitbitActivity;

import android.util.Base64;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class FitbitDataFormat {

    public static String getEncodedValue(String text) {
        try {
            byte[] data = text.getBytes(StandardCharsets.UTF_8);
            return Base64.encodeToString(data, Base64.NO_WRAP);
        } catch (Exception ex) {
            return null;
        }
    }

    public static String convertDateFormat(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        try {
            return simpleDateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String capitalizeFirstLetter(String text) {
        StringBuilder str = new StringBuilder();
        String[] tokens = text.split("\\s");// Can be space,comma or hyphen
        for (String token : tokens) {
            str.append(Character.toUpperCase(token.charAt(0))).append(token.substring(1)).append(" ");
        }
        return str.toString().trim();
    }

    public static boolean isEmpty(String s) {
        return s == null || s.isEmpty();
    }


}
