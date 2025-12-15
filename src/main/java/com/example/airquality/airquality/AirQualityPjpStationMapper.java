package com.example.airquality.airquality;

import com.example.airquality.pjpapi.dto.AqIndexDto;
import com.example.airquality.pjpapi.dto.AqIndexResponse;
import com.example.airquality.pjpapi.dto.PjpStationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AirQualityPjpStationMapper {
    private final AirQualityIndexMapper airQualityIndexMapper;

    public AirQualityStation toEntity(PjpStationDto pjpStationDto, AqIndexResponse aqIndexResponse) {
        AirQualityStation airQualityStation = new AirQualityStation();
        airQualityStation.setCity(pjpStationDto.cityName());

        AqIndexDto aqIndexDto = aqIndexResponse.aqIndex();
        airQualityStation.setOverallIndex(airQualityIndexMapper.map(aqIndexDto.indexCategory()));
        airQualityStation.setSo2Index(airQualityIndexMapper.map(aqIndexDto.so2Category()));
        airQualityStation.setNo2Index(airQualityIndexMapper.map(aqIndexDto.no2Category()));
        airQualityStation.setPm10Index(airQualityIndexMapper.map(aqIndexDto.pm10Category()));
        airQualityStation.setPm25Index(airQualityIndexMapper.map(aqIndexDto.pm25Category()));
        airQualityStation.setO3Index(airQualityIndexMapper.map(aqIndexDto.o3Category()));

        return airQualityStation;
    }
}
