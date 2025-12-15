package com.example.airquality.airquality;

import com.example.airquality.pjpapi.dto.AqIndexCategory;
import org.springframework.stereotype.Component;

@Component
public class AirQualityIndexMapper {

    public AirQualityIndex map(AqIndexCategory category) {
        if (category == null) return AirQualityIndex.UNKNOWN;

        return switch (category) {
            case VERY_GOOD -> AirQualityIndex.VERY_GOOD;
            case GOOD -> AirQualityIndex.GOOD;
            case MODERATE -> AirQualityIndex.MODERATE;
            case SUFFICIENT -> AirQualityIndex.SUFFICIENT;
            case BAD -> AirQualityIndex.BAD;
            case VERY_BAD -> AirQualityIndex.VERY_BAD;
            default -> AirQualityIndex.UNKNOWN;
        };
    }
}