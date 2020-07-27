package com.fitbitsample.util;

public class StringUtil {
    public static boolean isEmpty(String s) {
        return s == null || s.isEmpty();
    }

    public static String multilineString(String... lines) {
        StringBuilder sb = new StringBuilder();
        for (String s : lines) {
            sb.append(s);
            sb.append('\n');
        }
        return sb.toString();
    }

    public static String capitalizeFirstLetter(String text) {
        StringBuilder str = new StringBuilder();
        String[] tokens = text.split("\\s");// Can be space,comma or hyphen
        for (String token : tokens) {
            str.append(Character.toUpperCase(token.charAt(0))).append(token.substring(1)).append(" ");
        }
        return str.toString().trim();
    }


}