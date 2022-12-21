package com.jtokit.util;

public class CompareUtil {
    private CompareUtil() {

    }

    public static boolean eq(Object a, Object b) {
        //noinspection EqualsReplaceableByObjectsCall
        return (a == b) || (a != null && a.equals(b));
    }

    public static boolean neq(Object a, Object b) {
        //noinspection EqualsReplaceableByObjectsCall
        return !((a == b) || (a != null && a.equals(b)));
    }

    public static boolean anyNull(Object ...a) {
        for (Object o : a) {
            if (o == null) {
                return true;
            }
        }

        return false;
    }

    public static boolean nonNull(Object ...a) {
        for (Object o : a) {
            if (o == null) {
                return false;
            }
        }

        return true;
    }

    public static boolean positive(Integer value) {
        if (value == null) {
            return false;
        }

        return value > 0;
    }

    public static boolean inRange(long value, long a, long b) {
        return value >= a && value <= b;
    }

    public static boolean notEmpty(String value) {
        return !empty(value);
    }

    public static boolean empty(String value) {
        return value != null && !value.isEmpty();
    }
}
