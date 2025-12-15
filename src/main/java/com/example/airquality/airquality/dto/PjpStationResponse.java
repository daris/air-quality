package com.example.airquality.airquality.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record PjpStationResponse(
    @JsonProperty("Lista stacji pomiarowych")
    List<PjpStationDto> stations
) {}