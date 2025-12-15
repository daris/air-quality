package com.example.airquality.pjpapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AqIndexResponse(

    @JsonProperty("AqIndex")
    AqIndexDto aqIndex

) {}