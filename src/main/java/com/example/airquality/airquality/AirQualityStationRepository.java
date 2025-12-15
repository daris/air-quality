package com.example.airquality.airquality;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AirQualityStationRepository extends JpaRepository<AirQualityStation, UUID> {
    Optional<AirQualityStation> findByCity(String city);
}
