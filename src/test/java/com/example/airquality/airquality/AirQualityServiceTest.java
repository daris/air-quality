package com.example.airquality.airquality;

import com.example.airquality.pjpapi.PjpApiService;
import com.example.airquality.pjpapi.dto.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AirQualityServiceTest {
    @Mock
    private AirQualityStationRepository airQualityStationRepository;

    @Mock
    private PjpApiService pjpApiService;

    @Mock
    private AirQualityPjpStationMapper airQualityPjpStationMapper;

    @InjectMocks
    private AirQualityService airQualityService;

    @Test
    public void testFetchData() {
        // given
        ArrayList<PjpStationDto> stations = new ArrayList<>();
        PjpStationDto pjpStationDto = getPjpStationDto();
        stations.add(pjpStationDto);
        PjpStationResponse stationResponse = new PjpStationResponse(stations);
        when(pjpApiService.getStations()).thenReturn(stationResponse);

        AqIndexResponse aqIndexResponse = new AqIndexResponse(getAqIndexDto());
        when(pjpApiService.getIndex(anyInt())).thenReturn(aqIndexResponse);
        AirQualityStation airQualityStation = new AirQualityStation();
        when(airQualityPjpStationMapper.toEntity(pjpStationDto, aqIndexResponse)).thenReturn(airQualityStation);

        // when
        airQualityService.fetchData();

        // then
        ArgumentCaptor<AirQualityStation> captor = ArgumentCaptor.forClass(AirQualityStation.class);
        verify(airQualityStationRepository, times(1)).save(captor.capture());

        assertEquals(airQualityStation, captor.getValue());
    }

    private static PjpStationDto getPjpStationDto() {
        return new PjpStationDto(
                11,
                "DsCzerStraza",
                "Czerniawa",
                "50.912475",
                "15.312190",
                142,
                "Czerniawa",
                "Świeradów-Zdrój",
                "lubański",
                "DOLNOŚLĄSKIE",
                "ul. Strażacka 7"
        );
    }

    public static AqIndexDto getAqIndexDto() {
        return new AqIndexDto(
                11,
                "2024-01-15T12:00:00Z",
                2,
                AqIndexCategory.GOOD,
                "2024-01-15T10:00:00Z",

                // SO2
                "2024-01-15T11:30:00Z",
                1,
                AqIndexCategory.VERY_GOOD,
                "2024-01-15T10:30:00Z",

                // NO2
                "2024-01-15T11:30:00Z",
                2,
                AqIndexCategory.GOOD,
                "2024-01-15T10:30:00Z",

                // PM10
                "2024-01-15T11:30:00Z",
                3,
                AqIndexCategory.MODERATE,
                "2024-01-15T10:30:00Z",

                // PM2.5
                "2024-01-15T11:30:00Z",
                2,
                AqIndexCategory.GOOD,
                "2024-01-15T10:30:00Z",

                // O3
                "2024-01-15T11:30:00Z",
                1,
                AqIndexCategory.VERY_GOOD,
                "2024-01-15T10:30:00Z",

                true,
                "PM10"
        );
    }

}