package com.jtokit.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class TransformUtil {

    private TransformUtil() {

    }

    public static <T, R> List<R> map(List<T> input, Function<T, R> func) {
        List<R> mapped = new ArrayList<>(input.size());

        for (T t : input) {
            mapped.add(func.apply(t));
        }

        return mapped;
    }
}
