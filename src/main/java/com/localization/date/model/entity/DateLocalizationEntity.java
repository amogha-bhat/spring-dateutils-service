package com.localization.date.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;
import org.springframework.lang.Nullable;

import java.util.Calendar;
import java.util.Locale;

@Value.Immutable
@JsonDeserialize(as = ImmutableDateLocalizationEntity.class)
public interface DateLocalizationEntity extends LocalizationEntity {
    Calendar date();
    String format();
    Locale locale();
    @Nullable
    String[] weekdays();
    @Nullable
    String[] months();
}
