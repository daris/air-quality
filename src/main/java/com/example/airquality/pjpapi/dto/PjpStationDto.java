package com.example.airquality.pjpapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PjpStationDto(

    @JsonProperty("Identyfikator stacji")
    Integer stationId,

    @JsonProperty("Kod stacji")
    String stationCode,

    @JsonProperty("Nazwa stacji")
    String stationName,

    @JsonProperty("WGS84 φ N")
    String latitude,

    @JsonProperty("WGS84 λ E")
    String longitude,

    @JsonProperty("Identyfikator miasta")
    Integer cityId,

    @JsonProperty("Nazwa miasta")
    String cityName,

    @JsonProperty("Gmina")
    String municipality,

    @JsonProperty("Powiat")
    String county,

    @JsonProperty("Województwo")
    String voivodeship,

    @JsonProperty("Ulica")
    String street
) {}