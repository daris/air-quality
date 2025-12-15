package com.example.airquality.pjpapi;

import com.example.airquality.pjpapi.dto.PjpStationResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class PjpApiService {
    public PjpStationResponse getStations() {
        RestClient restClient = RestClient.builder().baseUrl("https://api.gios.gov.pl/pjp-api").build();

        return restClient
                .get()
                .uri("/v1/rest/station/findAll")
                .retrieve()
                .body(PjpStationResponse.class);
    }
}
