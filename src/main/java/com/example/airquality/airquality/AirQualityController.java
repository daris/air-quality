package com.example.airquality.airquality;

import com.example.airquality.airquality.dto.AirQualityStationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/air-quality")
@RequiredArgsConstructor
public class AirQualityController {
    private final AirQualityService airQualityService;

    @GetMapping
    public List<AirQualityStationDto> listStations() {
        return airQualityService.getStations();
    }
}
