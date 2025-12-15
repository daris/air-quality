package com.example.airquality.airquality;

import com.example.airquality.airquality.dto.AirQualityStationDto;
import com.example.airquality.airquality.dto.PjpStationDto;
import com.example.airquality.airquality.dto.PjpStationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AirQualityService {
    private final AirQualityPjpStationMapper airQualityPjpStationMapper;
    private final AirQualityStationRepository airQualityStationRepository;

    public List<AirQualityStationDto> getStations() {
        var stations = new ArrayList<AirQualityStationDto>();
        stations.add(new AirQualityStationDto("Warszawa"));
        return stations;
    }

    public void fetchData() {
        RestClient restClient = RestClient.builder().baseUrl("https://api.gios.gov.pl/pjp-api").build();

        PjpStationResponse pjpStationResponse = restClient
                .get()
                .uri("/v1/rest/station/findAll")
                .retrieve()
                .body(PjpStationResponse.class);

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
