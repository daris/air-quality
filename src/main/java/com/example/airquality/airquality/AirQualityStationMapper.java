package com.example.airquality.airquality;

import com.example.airquality.airquality.dto.AirQualityStationDto;
import org.springframework.stereotype.Component;

@Component
public class AirQualityStationMapper {
    public AirQualityStationDto toDto(AirQualityStation airQualityStation) {
        return new AirQualityStationDto(
                airQualityStation.getCity(),
                airQualityStation.getOverallIndex(),
                airQualityStation.getSo2Index(),
                airQualityStation.getNo2Index(),
                airQualityStation.getPm10Index(),
                airQualityStation.getPm25Index(),
                airQualityStation.getO3Index()
        );
    }
}
