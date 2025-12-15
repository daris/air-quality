package com.example.airquality.airquality;

import com.example.airquality.airquality.dto.AirQualityStationDto;
import com.example.airquality.pjpapi.dto.PjpStationDto;
import com.example.airquality.pjpapi.dto.PjpStationResponse;
import com.example.airquality.pjpapi.PjpApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AirQualityService {
    private final AirQualityPjpStationMapper airQualityPjpStationMapper;
    private final AirQualityStationRepository airQualityStationRepository;
    private final PjpApiService pjpApiService;

    public List<AirQualityStationDto> getStations() {
        var stations = new ArrayList<AirQualityStationDto>();
        stations.add(new AirQualityStationDto("Warszawa"));
        return stations;
    }

    public void fetchData() {
        PjpStationResponse pjpStationResponse = pjpApiService.getStations();

        for (PjpStationDto pjpStationDto : pjpStationResponse.stations()) {
            AirQualityStation airQualityStation = airQualityPjpStationMapper.toEntity(pjpStationDto);
            Optional<AirQualityStation> existingAirQuality = airQualityStationRepository.findByCity(airQualityStation.getCity());
            if (existingAirQuality.isPresent()) {
                airQualityStation.setId(existingAirQuality.get().getId());
                airQualityStationRepository.save(airQualityStation);
            } else {
                airQualityStationRepository.save(airQualityStation);
            }
        }
    }
}
