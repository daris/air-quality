package com.example.airquality.pjpapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class PjpRestClientConfig {

    @Value("${pjpApi.baseUrl}")
    private String baseUrl;

    @Bean
    public RestClient pjpRestClient() {
        return RestClient.builder()
                         .baseUrl(baseUrl)
                         .build();
    }
}