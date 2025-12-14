package com.example.airquality.airquality;

import com.example.airquality.airquality.dto.AirQualityResponse;
import com.example.airquality.airquality.dto.AirQualityStationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/air-quality")
public class AirQualityController {

    @GetMapping
    public ResponseEntity<AirQualityResponse> listStations() {
        var stations = new ArrayList<AirQualityStationDto>();
        stations.add(new AirQualityStationDto("Warszawa"));
        return ResponseEntity.ok(new AirQualityResponse(stations));
    }
}
