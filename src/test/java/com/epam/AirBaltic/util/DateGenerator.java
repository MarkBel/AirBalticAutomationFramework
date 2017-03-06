package com.epam.AirBaltic.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Kseniya_Kunda on 3/6/2017.
 */
public class DateGenerator {


    private static Calendar requiredDate;

    public static String getDate(int daysAmount) {
        requiredDate = Calendar.getInstance();
        requiredDate.setTime(new Date());
        requiredDate.add(Calendar.DATE, daysAmount);
        int year = requiredDate.get(Calendar.YEAR);
        int month = requiredDate.get(Calendar.MONTH);
        int day = requiredDate.get(Calendar.DAY_OF_MONTH);
        return String.format("%02d.%02d.%04d", day, month + 1, year);


    }
}
