package com.jtokit.action;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.HashMap;
import java.util.Map;

@ParametersAreNonnullByDefault
public class Error {

    private final Map<String, String> errors = new HashMap<>();

    private String message = "";

    public static Error empty() {
        return new Error();
    }

    public static Error of(String key, String value) {
        Error error = new Error();
        error.errors.put(key, value);
        return error;
    }

    public static Error of(Map<String, String> errors) {
        Error error1 = new Error();
        error1.errors.putAll(errors);
        return error1;
    }

    public static Error of(String message) {
        Error error = new Error();
        error.message = message;
        return error;
    }

    public boolean notEmpty() {
        return hasMessage() || !errors.isEmpty();
    }

    public boolean noErrors() {
        return !hasMessage() && !hasErrors();
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public String getMessage() {
        return message;
    }

    public boolean hasMessage() {
        return message != null && !message.isEmpty();
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public String put(String key, String value) {
        return errors.put(key, value);
    }
}
