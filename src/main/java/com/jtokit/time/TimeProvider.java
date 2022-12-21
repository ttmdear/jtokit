package com.jtokit.time;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface TimeProvider {

    LocalDateTime getDateTime();

    LocalDate getDate();
}
