package com.jtokit.time;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeUtil {
    public static LocalDateTime MAX_DATE_TIME = LocalDateTime.of(9999, 12, 31, 23, 59);
    private static TimeProvider GLOBAL_TIME_PROVIDER = new RealTimeProvider();

    public static LocalDateTime getDateTime() {
        return requireGlobalTimeProvider().getDateTime();
    }

    public static LocalDate getDate() {
        return requireGlobalTimeProvider().getDate();
    }

    public static synchronized void setGlobalTimeProvider(TimeProvider timeProvider) {
        GLOBAL_TIME_PROVIDER = timeProvider;
    }

    private static TimeProvider requireGlobalTimeProvider() {
        if (GLOBAL_TIME_PROVIDER == null) {
            throw new IllegalStateException("There is not GLOBAL_TIME_PROVIDER set.");
        }

        return GLOBAL_TIME_PROVIDER;
    }
}
