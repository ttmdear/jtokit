package com.jtokit.counter;

public class IntCounter implements Counter<Integer> {

    private Integer value = 0;

    @Override
    public Integer increase() {
        return ++value;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public void reset() {
        value = 0;
    }
}
