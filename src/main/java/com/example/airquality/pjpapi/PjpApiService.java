package com.example.airquality.pjpapi;

import com.example.airquality.pjpapi.dto.PjpStationResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class PjpApiService {
    @Value("${pjpApi.baseUrl}")
    String baseUrl;

    public PjpStationResponse getStations() {
        RestClient restClient = RestClient.builder().baseUrl(baseUrl).build();

        return restClient
                .get()
                .uri("/v1/rest/station/findAll")
                .retrieve()
                .body(PjpStationResponse.class);
    }
}
