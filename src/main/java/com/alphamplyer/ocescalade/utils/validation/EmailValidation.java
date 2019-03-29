package com.alphamplyer.ocescalade.utils.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation implements Validation {

    @Override
    public boolean valid(String stringToValidate) {

        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(stringToValidate);

        return matcher.matches();
    }
}
