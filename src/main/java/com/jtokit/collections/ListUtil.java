package com.jtokit.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListUtil {
    private ListUtil() {

    }

    public static <T> List<T> unmodifiable(List<? extends T> list) {
        return Collections.unmodifiableList(list);
    }

    public static <T> List<T> moveBy(List<T> list, int index, int by) {
        if (by == 0 || list.size() <= 1) {
            return list;
        }

        int t = index + by;

        if (t < 0) t = 0;
        else if (t > list.size() - 1) t = list.size() - 1;

        if (t < index) {
            // E1
            // E2 - t
            // E3
            // E4
            // E5 - index
            // E6
            for (; (index - 1) >= t; index--) {
                T tmp = list.get(index - 1);

                list.set(index - 1, list.get(index));
                list.set(index, tmp);
            }
        } else if (t > index) {
            // E1
            // E2 - index
            // E3
            // E4
            // E5 - t
            // E6
            for (; (index + 1) <= t; index++) {
                T tmp = list.get(index + 1);

                list.set(index + 1, list.get(index));
                list.set(index, tmp);
            }
        }

        return list;
    }

    @SafeVarargs
    public static <T> List<T> list(T... a) {
        return Arrays.asList(a);
    }

    public static <T> T last(List<T> list) {
        return list.get(list.size() - 1);
    }

    public static <T> List<T> distinct(List<T> t) {
        return t.stream().distinct().collect(Collectors.toList());
    }

    public static <T> T lastMatch(List<T> list, Predicate<T> test) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (test.test(list.get(i))) {
                return list.get(i);
            }
        }

        return null;
    }

    public static <T> List<T> list() {
        return new ArrayList<>();
    }

    public static <T> List<T> limit(List<T> list, int number) {
        List<T> result = new ArrayList<>(number);

        if (list.isEmpty()) return list;

        int i = 0;
        for (T o : list) {
            result.add(o);
            i++;
            if (i >= number) {
                return result;
            }
        }

        return result;
    }

}
