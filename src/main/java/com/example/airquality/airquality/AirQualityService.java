package com.example.airquality.airquality;

import com.example.airquality.airquality.dto.AirQualityStationDto;
import com.example.airquality.pjpapi.PjpApiService;
import com.example.airquality.pjpapi.dto.PjpStationDto;
import com.example.airquality.pjpapi.dto.PjpStationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AirQualityService {
    private final AirQualityPjpStationMapper airQualityPjpStationMapper;
    private final AirQualityStationRepository airQualityStationRepository;
    private final PjpApiService pjpApiService;
    private final AirQualityStationMapper airQualityStationMapper;

    public List<AirQualityStationDto> getStations() {
        return airQualityStationRepository.findAll()
                .stream()
                .map(airQualityStationMapper::toDto)
                .toList();
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
