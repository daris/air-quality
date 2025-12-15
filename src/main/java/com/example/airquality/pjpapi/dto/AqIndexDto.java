package com.example.airquality.pjpapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AqIndexDto(

    @JsonProperty("Identyfikator stacji pomiarowej")
    Integer stationId,

    @JsonProperty("Data wykonania obliczeń indeksu")
    String calculationDate,

    @JsonProperty("Wartość indeksu")
    Integer indexValue,

    @JsonProperty("Nazwa kategorii indeksu")
    AqIndexCategory indexCategory,

    @JsonProperty("Data danych źródłowych, z których policzono wartość indeksu dla wskaźnika st")
    String sourceDataDate,

    // SO2
    @JsonProperty("Data wykonania obliczeń indeksu dla wskaźnika SO2")
    String so2CalculationDate,

    @JsonProperty("Wartość indeksu dla wskaźnika SO2")
    Integer so2IndexValue,

    @JsonProperty("Nazwa kategorii indeksu dla wskażnika SO2")
    AqIndexCategory so2Category,

    @JsonProperty("Data danych źródłowych, z których policzono wartość indeksu dla wskaźnika SO2")
    String so2SourceDataDate,

    // NO2
    @JsonProperty("Data wykonania obliczeń indeksu dla wskaźnika NO2")
    String no2CalculationDate,

    @JsonProperty("Wartość indeksu dla wskaźnika NO2")
    Integer no2IndexValue,

    @JsonProperty("Nazwa kategorii indeksu dla wskażnika NO2")
    AqIndexCategory no2Category,

    @JsonProperty("Data danych źródłowych, z których policzono wartość indeksu dla wskaźnika NO2")
    String no2SourceDataDate,

    // PM10
    @JsonProperty("Data wykonania obliczeń indeksu dla wskaźnika PM10")
    String pm10CalculationDate,

    @JsonProperty("Wartość indeksu dla wskaźnika PM10")
    Integer pm10IndexValue,

    @JsonProperty("Nazwa kategorii indeksu dla wskażnika PM10")
    AqIndexCategory pm10Category,

    @JsonProperty("Data danych źródłowych, z których policzono wartość indeksu dla wskaźnika PM10")
    String pm10SourceDataDate,

    // PM2.5
    @JsonProperty("Data wykonania obliczeń indeksu dla wskaźnika PM2.5")
    String pm25CalculationDate,

    @JsonProperty("Wartość indeksu dla wskaźnika PM2.5")
    Integer pm25IndexValue,

    @JsonProperty("Nazwa kategorii indeksu dla wskażnika PM2.5")
    AqIndexCategory pm25Category,

    @JsonProperty("Data danych źródłowych, z których policzono wartość indeksu dla wskaźnika PM2.5")
    String pm25SourceDataDate,

    // O3
    @JsonProperty("Data wykonania obliczeń indeksu dla wskaźnika O3")
    String o3CalculationDate,

    @JsonProperty("Wartość indeksu dla wskaźnika O3")
    Integer o3IndexValue,

    @JsonProperty("Nazwa kategorii indeksu dla wskażnika O3")
    AqIndexCategory o3Category,

    @JsonProperty("Data danych źródłowych, z których policzono wartość indeksu dla wskaźnika O3")
    String o3SourceDataDate,

    // Meta
    @JsonProperty("Status indeksu ogólnego dla stacji pomiarowej")
    Boolean overallIndexStatus,

    @JsonProperty("Kod zanieczyszczenia krytycznego")
    String criticalPollutantCode

) {}
