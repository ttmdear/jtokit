package com.jtokit.util;

public class ExceptionUtil {
    private ExceptionUtil() {

    }

    public static void throwIllegalState() {
        throw new IllegalStateException();
    }

    public static void throwIllegalState(String message) {
        throw new IllegalStateException(message);
    }

    public static void throwIllegalStateIf(boolean value) {
        if (value) throw new IllegalStateException();
    }

    public static void throwIllegalStateIf(boolean value, String message) {
        if (value) throw new IllegalStateException(message);
    }
}
