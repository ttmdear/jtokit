package com.jtokit.time;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Time {
    private static TimeProvider INSTANCE = new RealTimeProvider();

    public static LocalDateTime getDateTime() {
        return INSTANCE.getDateTime();
    }

    public static LocalDate getDate() {
        return INSTANCE.getDate();
    }

    public static void setTimeProvider(TimeProvider timeProvider) {
        INSTANCE = timeProvider;
    }
}
