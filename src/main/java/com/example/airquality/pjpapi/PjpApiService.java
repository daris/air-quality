package com.example.airquality.pjpapi;

import com.example.airquality.pjpapi.dto.AqIndexResponse;
import com.example.airquality.pjpapi.dto.PjpStationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class PjpApiService {
    private final RestClient restClient;

    public PjpStationResponse getStations() {
        return restClient
                .get()
                .uri("/v1/rest/station/findAll")
                .retrieve()
                .body(PjpStationResponse.class);
    }

    public AqIndexResponse getIndex(int stationId) {
        return restClient
                .get()
                .uri("/v1/rest/aqindex/getIndex/" + stationId)
                .retrieve()
                .body(AqIndexResponse.class);
    }
}
