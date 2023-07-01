package com.localization.date.utils;

import com.localization.date.constants.DateLocalizationConstants;
import com.localization.date.model.entity.DateLocalizationEntity;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;

import java.util.Locale;
import java.util.Map;

@Component
public class DateUtils {

    private static final Map<String, Integer> formats = Map.ofEntries(
            Map.entry(DateLocalizationConstants.SHORT, DateFormat.SHORT),
            Map.entry(DateLocalizationConstants.MEDIUM, DateFormat.MEDIUM),
            Map.entry(DateLocalizationConstants.LONG, DateFormat.LONG),
            Map.entry(DateLocalizationConstants.FULL, DateFormat.FULL)
    );

    private DateFormatSymbols buildSymbols(String[] weekdays, String[] months, Locale locale) {
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);
        if(weekdays !=null && weekdays.length == 7) {
            dateFormatSymbols.setWeekdays(ArrayUtils.addAll(new String[]{""}, weekdays));
        }

        if(months != null && months.length == 12) {
            dateFormatSymbols.setMonths(months);
        }
        return dateFormatSymbols;
    }

    public String format(DateLocalizationEntity dateLocalizationEntity) {
        String format = dateLocalizationEntity.format();
        if(formats.containsKey(dateLocalizationEntity.format())) {
            format = ((SimpleDateFormat) DateFormat.getDateInstance(
                    formats.get(dateLocalizationEntity.format()), dateLocalizationEntity.locale())).toPattern();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, dateLocalizationEntity.locale());
        simpleDateFormat.setDateFormatSymbols(buildSymbols(dateLocalizationEntity.weekdays(),
                dateLocalizationEntity.months(), dateLocalizationEntity.locale()));
        return simpleDateFormat.format(dateLocalizationEntity.date().getTime());
    }

}
