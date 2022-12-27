package com.jtokit.action;

import java.util.HashMap;
import java.util.Map;

public class Errors extends HashMap <String, String> {

    public static Errors empty() {
        Errors errors = new Errors();
        return errors;
    }

    public static Errors of(String key, String value) {
        Errors errors = new Errors();
        errors.put(key, value);
        return errors;
    }

    public boolean notEmpty() {
        return !isEmpty();
    }

    public boolean noErrors() {
        return isEmpty();
    }

    public Map<String, String> getErrors() {
        return this;
    }
}
