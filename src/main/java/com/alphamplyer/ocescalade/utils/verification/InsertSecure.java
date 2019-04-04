package com.alphamplyer.ocescalade.utils.verification;

public class InsertSecure {

    public static String check(String str) {
        str = str.replaceAll("&", "&amp;")
        .replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\"", "&quot;")
            .replaceAll("'", "&#039;").replaceAll("/", "&#x2F;");

        return str;
    }
}
