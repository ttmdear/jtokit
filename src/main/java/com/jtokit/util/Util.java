package com.jtokit.util;

import java.time.LocalDateTime;

public class Util {
    private Util() {

    }

    public static boolean empty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static boolean empty(LocalDateTime value) {
        return value == null;
    }

    public static boolean notEmpty(String value) {
        return !empty(value);
    }

    public static boolean isNegative(Integer value) {
        return value != null && value < 0;
    }
}
