package com.example.airquality.airquality;

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
        airQualityStation.setOverallIndex(airQualityIndexMapper.map(aqIndexResponse.aqIndex().indexCategory()));
        airQualityStation.setSo2Index(airQualityIndexMapper.map(aqIndexResponse.aqIndex().so2Category()));
        airQualityStation.setNo2Index(airQualityIndexMapper.map(aqIndexResponse.aqIndex().no2Category()));
        airQualityStation.setPm10Index(airQualityIndexMapper.map(aqIndexResponse.aqIndex().pm10Category()));
        airQualityStation.setPm25Index(airQualityIndexMapper.map(aqIndexResponse.aqIndex().pm25Category()));
        airQualityStation.setO3Index(airQualityIndexMapper.map(aqIndexResponse.aqIndex().o3Category()));

        return airQualityStation;
    }
}
