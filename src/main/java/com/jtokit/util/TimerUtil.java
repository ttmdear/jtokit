package com.jtokit.util;

import java.util.function.Consumer;

public class TimerUtil {
    public static final int INTERVAL_SEC = 1000;

    private TimerUtil() {

    }

    public static void countdown(int from, int to, int interval, Consumer<CountdownState> on) {
        if (from <= to) {
            throw new IllegalArgumentException("From should be bigger then to.");
        }

        CountdownState state = new CountdownState();

        for (int i = from; i >= to; i--) {
            state.value = i;
            on.accept(state);
            ThreadUtil.sleep(interval);
        }
    }

    public static class CountdownState {
        int value;
        boolean stopped = false;

        public int getValue() {
            return value;
        }

        public void stop() {
            stopped = true;
        }
    }
}
