package com.example.airquality.airquality;

import com.example.airquality.airquality.dto.AirQualityStationDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirQualityService {
    public List<AirQualityStationDto> getStations() {
        var stations = new ArrayList<AirQualityStationDto>();
        stations.add(new AirQualityStationDto("Warszawa"));
        return stations;
    }
}
