package com.jtokit.time;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RealTimeProvider implements TimeProvider {

    @Override
    public LocalDateTime getDateTime() {
        return LocalDateTime.now();
    }

    @Override
    public LocalDate getDate() {
        return LocalDate.now();
    }
}
