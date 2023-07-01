package com.localization.date.controller;

import com.localization.date.model.entity.DateLocalizationEntity;
import com.localization.date.model.response.LocalizationResponseEntity;
import com.localization.date.service.DateLocalizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/dateUtils/v1")
public class DateLocalizationController {

    @Autowired
    private DateLocalizationService dateLocalizationService;

    @PostMapping("/format")
    public Map<String, LocalizationResponseEntity<DateLocalizationEntity>> dateUtils(@RequestBody Map<String, DateLocalizationEntity> requests) {
        return dateLocalizationService.format(requests);
    }
}
