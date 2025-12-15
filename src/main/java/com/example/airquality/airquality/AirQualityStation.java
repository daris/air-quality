package com.example.airquality.airquality;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class AirQualityStation {
    @Id
    @GeneratedValue
    UUID id;

    String city;
}
