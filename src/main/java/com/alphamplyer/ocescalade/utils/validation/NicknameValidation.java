package com.alphamplyer.ocescalade.utils.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NicknameValidation implements Validation {

    @Override
    public boolean valid(String stringToValidate) {

        String regex = "[a-zA-Z0-9_.-]{3,}";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(stringToValidate);

        return matcher.matches();
    }
}
