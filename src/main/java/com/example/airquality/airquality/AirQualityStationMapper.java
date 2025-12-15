package com.example.airquality.airquality;

import com.example.airquality.airquality.dto.AirQualityStationDto;
import org.springframework.stereotype.Component;

@Component
public class AirQualityStationMapper {
    public AirQualityStationDto toDto(AirQualityStation airQualityStation) {
        return new AirQualityStationDto(
                airQualityStation.getCity()
        );
    }
}
