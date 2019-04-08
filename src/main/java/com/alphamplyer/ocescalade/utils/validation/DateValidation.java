package com.alphamplyer.ocescalade.utils.validation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateValidation implements Validation {

    public final static String DATE_FORMAT = "dd/MM/yyyy";

    @Override
    public boolean valid(String stringToValidate) {

        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(stringToValidate);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static java.sql.Date convertStringToTimestamp(String str_date) {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            java.util.Date date = df.parse(str_date);
            return new java.sql.Date(date.getTime());
        } catch (ParseException e) {
            System.out.println("Failed to convert date with the format " + DATE_FORMAT + " : " + str_date);
            return null;
        }
    }
}
