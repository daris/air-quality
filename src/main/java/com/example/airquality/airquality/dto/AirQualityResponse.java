package com.example.airquality.airquality.dto;

import java.util.List;

public record AirQualityResponse(List<AirQualityStationDto> stations) {
}
