package com.jtokit.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NullUtil {
    private NullUtil() {

    }

    public static <T> T nonNull(T value) {
        return Objects.requireNonNull(value);
    }

    public static <T> T nonNull(T value, T defaultValue) {
        if (value != null) {
            return value;
        } else {
            return defaultValue;
        }
    }

    public static String nonNull(String value) {
        if (value != null) {
            return value;
        } else {
            return "";
        }
    }

    public static <T> List<T> nonNull(List<T> value) {
        if (value != null) {
            return value;
        } else {
            return new ArrayList<>();
        }
    }
}
