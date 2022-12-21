package com.jtokit.util;

import java.util.List;
import java.util.stream.Collectors;

public class Labelable<T> {
    private T value;
    private String label;

    public Labelable(T value, String label) {
        this.value = value;
        this.label = label;
    }

    public static <T> Labelable<T> of(T value, String label) {
        return new Labelable<>(value, label);
    }

    public static List<Labelable<String>> of(List<String> planNames) {
        return planNames.stream()
            .map(s -> of(s, s)).collect(Collectors.toList());
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        return value.equals(o);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}

