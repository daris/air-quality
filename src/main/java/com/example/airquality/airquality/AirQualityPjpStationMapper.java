package com.example.airquality.airquality;

import com.example.airquality.airquality.dto.PjpStationDto;
import org.springframework.stereotype.Component;

@Component
public class AirQualityPjpStationMapper {
    public AirQualityStation toEntity(PjpStationDto pjpStationDto) {
        AirQualityStation airQualityStation = new AirQualityStation();
        airQualityStation.setCity(pjpStationDto.cityName());
        return airQualityStation;
    }
}
