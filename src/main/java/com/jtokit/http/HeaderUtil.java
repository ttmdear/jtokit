package com.jtokit.http;

import java.util.Base64;

public class HeaderUtil {

    private HeaderUtil() {

    }

    public static String encodeHttpBasic(String username, String password) {
        String creds = String.format("%s:%s", username, password);
        return "Basic " + Base64.getEncoder().encodeToString(creds.getBytes());
    }
}
