package com.alphamplyer.ocescalade.utils.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecimalValidation implements Validation {

    @Override
    public boolean valid(String stringToValidate) {

        String regex = "^\\d*\\.\\d+|\\d+\\.\\d*$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(stringToValidate);

        return matcher.matches();
    }
}
