package com.epam.AirBaltic.util;

import java.text.Format;
import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 * Created by Kseniya_Kunda on 3/6/2017.
 */
public class DateGenerator {

    public static String getDate(Integer daysAmount) {
        Calendar requiredDate = Calendar.getInstance();
        requiredDate.add(Calendar.DATE, daysAmount);
        Format desiredPattern = new SimpleDateFormat("dd.MM.yyyy");
        return desiredPattern.format(requiredDate.getTime());
    }

    public static String getTimeStamp() {
        Calendar requiredDate = Calendar.getInstance();
        Format desiredPattern = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        return desiredPattern.format(requiredDate.getTime());
    }
}
