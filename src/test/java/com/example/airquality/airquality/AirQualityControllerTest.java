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
  ],
  "totalPages": 15
}
""")));

        mockMvc.perform(get("/api/air-quality")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[0].cityName").value("Czerniawa"));
    }
}