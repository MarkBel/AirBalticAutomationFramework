package com.epam.AirBaltic.util;

import java.text.Format;
import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 * Created by Kseniya_Kunda on 3/6/2017.
 */
public class DateGenerator {


    private static Calendar requiredDate;

    public static String getDate(Integer daysAmount) {
        requiredDate = Calendar.getInstance();
        requiredDate.add(Calendar.DATE, daysAmount);
        Format desiredPattern = new SimpleDateFormat("dd.MM.yyyy");
        return desiredPattern.format(requiredDate.getTime());
    }
}
