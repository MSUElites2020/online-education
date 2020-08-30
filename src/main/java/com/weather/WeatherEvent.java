package com.weather;

public class WeatherEvent {
    public String locationName;
    public Double temperature;
    public Long timestamp;
    public Double longitude;
    public Double latitude;

    public WeatherEvent() {
    }

    public WeatherEvent(String locationName, Double temperature, Long timestamp, Double longitude, Double latitude) {
        this.locationName = locationName + "new change demo 08/30/2020 14:05";
        this.temperature = temperature;
        this.timestamp = timestamp;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
