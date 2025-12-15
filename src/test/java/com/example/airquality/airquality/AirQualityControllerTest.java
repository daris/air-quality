package com.example.airquality.airquality;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.wiremock.spring.ConfigureWireMock;
import org.wiremock.spring.EnableWireMock;
import org.wiremock.spring.InjectWireMock;

import static com.github.tomakehurst.wiremock.client.WireMock.okJson;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@EnableWireMock({
        @ConfigureWireMock(name = "pjp-service", port = 8081),
})
class AirQualityControllerTest {
    @Autowired
    MockMvc mockMvc;

    @InjectWireMock("pjp-service")
    WireMockServer mockPjpService;

    @Test
    void shouldReturnAirQualityStationDto() throws Exception {
        mockPjpService.stubFor(WireMock.get("/v1/rest/station/findAll")
                .willReturn(okJson("""
{
  "Lista stacji pomiarowych": [
    {
      "Identyfikator stacji": 11,
      "Kod stacji": "DsCzerStraza",
      "Nazwa stacji": "Czerniawa",
      "WGS84 φ N": "50.912475",
      "WGS84 λ E": "15.312190",
      "Identyfikator miasta": 142,
      "Nazwa miasta": "Czerniawa",
      "Gmina": "Świeradów-Zdrój",
      "Powiat": "lubański",
      "Województwo": "DOLNOŚLĄSKIE",
      "Ulica": "ul. Strażacka 7"
    }
  ]
}
""")));

        mockPjpService.stubFor(WireMock.get("/v1/rest/aqindex/getIndex/11")
                .willReturn(okJson("""
{
  "AqIndex": {
    "Identyfikator stacji pomiarowej": 11,
    "Data wykonania obliczeń indeksu": "2025-12-15 11:20:25",
    "Wartość indeksu": 1,
    "Nazwa kategorii indeksu": "Dobry",
    "Data danych źródłowych, z których policzono wartość indeksu dla wskaźnika st": "2025-12-15 11:00:00",
    "Data wykonania obliczeń indeksu dla wskaźnika SO2": "2025-12-15 11:20:25",
    "Wartość indeksu dla wskaźnika SO2": null,
    "Nazwa kategorii indeksu dla wskażnika SO2": null,
    "Data danych źródłowych, z których policzono wartość indeksu dla wskaźnika SO2": null,
    "Data wykonania obliczeń indeksu dla wskaźnika NO2": "2025-12-15 11:20:25",
    "Wartość indeksu dla wskaźnika NO2": 0,
    "Nazwa kategorii indeksu dla wskażnika NO2": "Bardzo dobry",
    "Data danych źródłowych, z których policzono wartość indeksu dla wskaźnika NO2": "2025-12-15 11:00:00",
    "Data wykonania obliczeń indeksu dla wskaźnika PM10": "2025-12-15 11:20:25",
    "Wartość indeksu dla wskaźnika PM10": 0,
    "Nazwa kategorii indeksu dla wskażnika PM10": "Bardzo dobry",
    "Data danych źródłowych, z których policzono wartość indeksu dla wskaźnika PM10": "2025-12-15 10:00:00",
    "Data wykonania obliczeń indeksu dla wskaźnika PM2.5": null,
    "Wartość indeksu dla wskaźnika PM2.5": null,
    "Nazwa kategorii indeksu dla wskażnika PM2.5": null,
    "Data danych źródłowych, z których policzono wartość indeksu dla wskaźnika PM2.5": null,
    "Data wykonania obliczeń indeksu dla wskaźnika O3": "2025-12-15 11:20:25",
    "Wartość indeksu dla wskaźnika O3": 1,
    "Nazwa kategorii indeksu dla wskażnika O3": "Dobry",
    "Data danych źródłowych, z których policzono wartość indeksu dla wskaźnika O3": "2025-12-15 11:00:00",
    "Status indeksu ogólnego dla stacji pomiarowej": true,
    "Kod zanieczyszczenia krytycznego": "PYL"
  }
}
""")));

        mockMvc.perform(get("/api/air-quality")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[0].cityName").value("Czerniawa"))
                .andExpect(jsonPath("$.[0].so2Index").value("UNKNOWN"))
                .andExpect(jsonPath("$.[0].no2Index").value("VERY_GOOD"))
                .andExpect(jsonPath("$.[0].pm10Index").value("VERY_GOOD"))
                .andExpect(jsonPath("$.[0].pm25Index").value("UNKNOWN"))
                .andExpect(jsonPath("$.[0].o3Index").value("GOOD"));
    }
}