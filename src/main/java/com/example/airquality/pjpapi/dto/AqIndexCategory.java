package com.example.airquality.pjpapi.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum AqIndexCategory {

    VERY_GOOD("Bardzo dobry"),
    GOOD("Dobry"),
    MODERATE("Umiarkowany"),
    SUFFICIENT("Dostateczny"),
    BAD("Zły"),
    VERY_BAD("Bardzo zły"),
    UNKNOWN("Brak danych");

    private final String apiValue;

    AqIndexCategory(String apiValue) {
        this.apiValue = apiValue;
    }

    @JsonValue
    public String getApiValue() {
        return apiValue;
    }

    @JsonCreator
    public static AqIndexCategory fromValue(String value) {
        return Arrays.stream(values())
                .filter(c -> c.apiValue.equalsIgnoreCase(value))
                .findFirst()
                .orElse(UNKNOWN);
    }
}
