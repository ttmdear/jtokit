package com.jtokit.collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MapUtil {
    private MapUtil() {

    }

    public static <K, V> Map<K, V> unmodifiable(Map<? extends K, ? extends V> m) {
        return Collections.unmodifiableMap(m);
    }

    public static <K, T> Map<K, T> map() {
        return new HashMap<>();
    }
}
