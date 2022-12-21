package com.jtokit.util;

import javax.annotation.Nonnull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {
    public static final int SECONDS_IN_DAY = 60 * 60 * 24;
    public static final int SECONDS_IN_HOUR = 60 * 60;
    public static final int SECONDS_IN_MINUTE = 60;
    public static final int SECONDS_1MINUTE = 60;

    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private TimeUtil() {

    }

    public static Date date(String s) {
        try {
            return DATE_FORMATTER.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Long timestamp(LocalDateTime lct) {
        if (lct == null) {
            return null;
        }

        return Instant.from(lct.atZone(ZoneId.systemDefault())).getEpochSecond();
    }

    public static Long timestamp(LocalDate ld) {
        if (ld == null) {
            return null;
        }

        return ld.atStartOfDay(ZoneId.systemDefault()).toEpochSecond();
    }

    @Nonnull
    public static Date date() {
        return new Date();
    }

    @Nonnull
    public static LocalDate ld(Calendar calendar) {
        return ldt(calendar).toLocalDate();
    }

    @Nonnull
    public static LocalDateTime ldt() {
        return LocalDateTime.now();
    }

    public static LocalDateTime ldt(Long timestamp) {
        return LocalDateTime.ofEpochSecond(timestamp, 0, OffsetDateTime.now().getOffset());
    }

    public static LocalDateTime ldt(float timestamp) {
        return LocalDateTime.ofEpochSecond(Float.valueOf(timestamp).longValue(), 0, OffsetDateTime.now().getOffset());
    }

    public static LocalDateTime ldt(String dateTime) {
        return LocalDateTime.parse(dateTime);
    }

    public static LocalDateTime ldt(Calendar calendar) {
        return LocalDateTime.ofInstant(calendar.toInstant(), calendar.getTimeZone().toZoneId());
    }

    public static Date plusSeconds(Date date, Integer time) {
        return new Date(date.getTime() + time * 1000);
    }

    public static LocalDateTime plusSeconds(LocalDateTime lct, Integer time) {
        return lct.plusSeconds(time);
    }

    public static LocalDateTime plusSeconds(LocalDateTime lct, Long time) {
        return lct.plusSeconds(time);
    }

    public static LocalDateTime minusSeconds(LocalDateTime lct, Long time) {
        return lct.minusSeconds(time);
    }

    public static LocalDateTime minusSeconds(LocalDateTime lct, Integer time) {
        return lct.minusSeconds(time);
    }

    public static Integer minutesToSeconds(int minutes) {
        return minutes * 60;
    }

    public static Integer seconds() {
        return Long.valueOf(new Date().getTime() / 1000L).intValue();
    }

    public static Integer seconds(Date date) {
        return Long.valueOf(date.getTime() / 1000L).intValue();
    }

    public static Integer secondsFrom(Date date) {
        return seconds() - seconds(date);
    }

    public static Long secondsFrom(LocalDateTime lct) {
        return ChronoUnit.SECONDS.between(lct, LocalDateTime.now());
    }

    public static Long secondsBetween(LocalDateTime lctA, LocalDateTime lctB) {
        return ChronoUnit.SECONDS.between(lctA, lctB);
    }

    public static Integer secondsTo(Date date) {
        return seconds(date) - seconds();
    }

    public static Long secondsTo(LocalDateTime lct) {
        return ChronoUnit.SECONDS.between(LocalDateTime.now(), lct);
    }

    public static int secondsToMinutes(Integer timer) {
        return timer / 60;
    }

    public static Calendar calendar(LocalDateTime ldt) {
        Date date = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar;
    }

    public static Date date(Calendar calendar) {
        return calendar.getTime();
    }

    public static Calendar calendar() {
        return Calendar.getInstance();
    }

    public static LocalDateTime withTime(LocalDateTime ldt, int hour, int minute, int second) {
        return ldt.withHour(hour).withMinute(minute).withSecond(second);
    }

    public static LocalDateTime withEndOfDay(LocalDateTime ldt) {
        return withTime(ldt, 23, 59, 59);
    }

    public static LocalDate withEndOfYear(LocalDate ld) {
        return ld.withMonth(12).withDayOfMonth(31);
    }

    public static LocalDateTime withBeginOfDay(LocalDateTime ldt) {
        return withTime(ldt, 0, 0, 0);
    }

    public static LocalDate withBeginOfMonth(LocalDate ld) {
        return ld.withDayOfMonth(1);
    }

    public static boolean between(LocalDateTime time, LocalDateTime startAt, LocalDateTime endAt) {
        return (time.isEqual(startAt) || time.isAfter(startAt)) && (time.isEqual(endAt) || time.isBefore(endAt));
    }
}
