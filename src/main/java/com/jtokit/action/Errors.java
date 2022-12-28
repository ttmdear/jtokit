package com.jtokit.action;

import java.util.HashMap;
import java.util.Map;

public class Errors extends HashMap <String, String> {

    private String message = "";

    public static Errors empty() {
        Errors errors = new Errors();
        return errors;
    }

    public static Errors of(String key, String value) {
        Errors errors = new Errors();
        errors.put(key, value);
        return errors;
    }

    public static Errors of(Map<String, String> errors) {
        Errors errors1 = new Errors();
        errors1.putAll(errors);
        return errors1;
    }

    public static Errors of(String message) {
        Errors errors = new Errors();
        errors.message = message;
        return errors;
    }

    public boolean notEmpty() {
        return hasMessage() || !isEmpty();
    }

    public boolean noErrors() {
        return !hasMessage() && !hasErrors();
    }

    public Map<String, String> getErrors() {
        return this;
    }

    public String getMessage() {
        return message;
    }

    public boolean hasMessage() {
        return message != null && !message.isEmpty();
    }

    public boolean hasErrors() {
        return !isEmpty();
    }
}
