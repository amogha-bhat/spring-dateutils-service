package com.localization.date.service;

import com.localization.date.model.entity.DateLocalizationEntity;
import com.localization.date.model.response.ImmutableLocalizationResponseEntity;
import com.localization.date.model.response.LocalizationResponseEntity;
import com.localization.date.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DateLocalizationService {

    @Autowired
    private DateUtils dateUtils;

    public Map<String, LocalizationResponseEntity<DateLocalizationEntity>> format(Map<String, DateLocalizationEntity> request) {
        return request.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        e2 -> ImmutableLocalizationResponseEntity.<DateLocalizationEntity>builder()
                                .formattedValue(dateUtils.format(e2.getValue()))
                                .localizationEntity(e2.getValue()).build()));
    }
}
