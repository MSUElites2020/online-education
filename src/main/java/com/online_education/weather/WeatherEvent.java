package com.online_education.weather;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class WeatherEvent {
    private String locationName;
    private Double temperature;
    private Long timestamp;
    private Double longitude;
    private Double latitude;
}
