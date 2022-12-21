package com.jtokit.action;

import java.util.HashMap;
import java.util.Map;

public class Errors {
    private final Map<String, String> errors = new HashMap<>();

    public static Errors empty() {
        Errors errors = new Errors();
        return errors;
    }

    public static Errors of(String key, String value) {
        Errors errors = new Errors();
        errors.errors.put(key, value);
        return errors;
    }

    public boolean notEmpty() {
        return !errors.isEmpty();
    }

    public boolean noErrors() {
        return errors.isEmpty();
    }

    public void put(String key, String value) {
        errors.put(key, value);
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}
