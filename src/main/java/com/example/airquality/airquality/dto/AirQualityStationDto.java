package com.example.airquality.airquality.dto;

import com.example.airquality.airquality.AirQualityIndex;

public record AirQualityStationDto(
        String cityName,
        AirQualityIndex overallIndex,
        AirQualityIndex so2Index,
        AirQualityIndex no2Index,
        AirQualityIndex pm10Index,
        AirQualityIndex pm25Index,
        AirQualityIndex o3Index
) {
}
