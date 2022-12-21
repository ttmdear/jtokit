package com.jtokit.util;

import java.util.HashMap;
import java.util.Map;

public class Flags {
    private Map<String, Boolean> flags = new HashMap<>();

    public void set(String name, boolean value) {
        flags.put(name, value);
    }

    public boolean is(String name) {
        //noinspection ConstantConditions
        return flags.getOrDefault(name, false);
    }

    public boolean isNo(String name) {
        return !is(name);
    }

    public void clean() {
        flags = new HashMap<>();
    }

    public void set(String name) {
        flags.put(name, true);
    }
}
