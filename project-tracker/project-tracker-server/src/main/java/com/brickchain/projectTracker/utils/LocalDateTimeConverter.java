package com.brickchain.projectTracker.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDateTime date) {
        Instant instant = Instant.from(date);
        return Date.from(instant);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Date value) {
        Instant instant = value.toInstant();
        return LocalDateTime.from(instant);
    }
}
