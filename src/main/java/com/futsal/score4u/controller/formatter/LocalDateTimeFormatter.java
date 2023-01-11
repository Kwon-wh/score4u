package com.futsal.score4u.controller.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateTimeFormatter implements Formatter<LocalTime> {

    @Override
    public String print(LocalTime object, Locale locale) {
        return DateTimeFormatter.ofPattern("HH:mm").format(object);
    }
    @Override
    public LocalTime parse(String text, Locale locale) throws ParseException {
        return LocalTime.parse(text, DateTimeFormatter.ofPattern("HH:mm"));
    }
}
