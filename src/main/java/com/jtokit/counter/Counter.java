package com.jtokit.counter;

public interface Counter<T> {
    T increase();

    T getValue();

    void reset();
}
