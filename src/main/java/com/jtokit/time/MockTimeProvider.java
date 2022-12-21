package com.jtokit.time;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MockTimeProvider implements TimeProvider {

    private final LocalDateTime now;

    public MockTimeProvider(LocalDateTime now) {
        this.now = now;
    }

    @Override
    public LocalDateTime getDateTime() {
        return now;
    }

    @Override
    public LocalDate getDate() {
        return now.toLocalDate();
    }
}
