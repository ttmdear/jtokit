package com.jtokit.util;

import com.jtokit.collections.Identifiable;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class ExtractUtil {
    private ExtractUtil() {

    }

    public static <T> List<T> filter(List<T> values, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();

        for (T t : values) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }

        return result;
    }

    public static <T> T find(List<T> values, Predicate<T> predicate) {
        for (T t : values) {
            if (predicate.test(t)) {
                return t;
            }
        }

        return null;
    }

    @Nonnull
    public static <T> T find(Collection<T> values, Predicate<T> predicate) {
        for (T t : values) {
            if (predicate.test(t)) {
                return t;
            }
        }

        return null;
    }

    public static <T> boolean exists(List<T> values, Predicate<T> predicate) {
        return find(values, predicate) != null;
    }

    public static <T extends Identifiable<?>> boolean existsById(List<T> values, Long id) {
        return findById(values, id) != null;
    }

    public static <T extends Identifiable<?>> T findById(List<T> value, Long id) {
        for (T t : value) {
            if (t.identifiableBy().equals(id)) return t;
        }

        return null;
    }

    @Nonnull
    public static <T extends Identifiable<?>> T findById(List<T> value, Integer id) {
        for (T t : value) {
            if (t.identifiableBy().equals(id)) return t;
        }

        return null;
    }

    public static <T extends Identifiable<?>> T findById(List<T> value, String id) {
        for (T t : value) {
            if (t.identifiableBy().equals(id)) return t;
        }

        return null;
    }

    public static <T extends Identifiable<?>> int findIndexById(List<T> value, Long id) {
        int i = 0;

        for (T t : value) {
            if (t.identifiableBy().equals(id)) return i;
            i++;
        }

        return -1;
    }

    public static <T extends Identifiable<?>> int findIndexById(List<T> value, Integer id) {
        int i = 0;

        for (T t : value) {
            if (t.identifiableBy().equals(id)) return i;
            i++;
        }

        return -1;
    }

    public static <T extends Identifiable<?>> T getById(List<T> value, Long id) {
        for (T t : value) {
            if (t.identifiableBy().equals(id)) return t;
        }

        throw new RuntimeException(String.format("Not found entity row with %s", id));
    }

    @Nonnull
    public static <T extends Identifiable<?>> T getById(@Nonnull List<T> value, @Nonnull Integer id) {
        for (T t : value) {
            if (t.identifiableBy().equals(id)) return t;
        }

        throw new RuntimeException(String.format("Not found entity row with %s", id));
    }

    public static <T> int findIndex(List<T> value, Predicate<T> predicate) {
        int i = 0;

        for (T t : value) {
            if (predicate.test(t)) return i;
            i++;
        }

        return -1;
    }

    public static <T extends Identifiable<?>> int getIndexById(List<T> value, Long id) {
        int i = 0;

        for (T t : value) {
            if (t.identifiableBy().equals(id)) {
                return i;
            }

            i++;
        }

        throw new RuntimeException(String.format("Not found entity row with %s", id));
    }

    public static <T extends Identifiable<?>> int getIndexById(List<T> value, Integer id) {
        int i = 0;

        for (T t : value) {
            if (t.identifiableBy().equals(id)) {
                return i;
            }

            i++;
        }

        throw new RuntimeException(String.format("Not found entity row with %s", id));
    }

    @Nonnull
    public static <T> T last(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }

        return list.get(list.size() - 1);
    }

    public static <T> T first(List<T> list) {
        if (list.isEmpty()) return null;

        return list.get(0);
    }
}
