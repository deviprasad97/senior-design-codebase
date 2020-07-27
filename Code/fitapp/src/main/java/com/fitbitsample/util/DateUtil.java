package com.fitbitsample.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    public static String convertDateFormat(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        try {
            return simpleDateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}