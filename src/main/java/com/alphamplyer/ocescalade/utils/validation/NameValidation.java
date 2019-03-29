package com.alphamplyer.ocescalade.utils.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidation implements Validation {

    @Override
    public boolean valid(String stringToValidate) {

        String regex = "[a-zA-Z]([- ',.a-zA-Z]{0,23}[a-zA-Z])?";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(stringToValidate);

        return matcher.matches();
    }
}
