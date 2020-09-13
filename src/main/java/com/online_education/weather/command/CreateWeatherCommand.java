package com.online_education.weather.command;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.online_education.weather.ApiGatewayRequest;
import com.online_education.weather.ApiGatewayResponse;
import com.online_education.weather.WeatherEvent;
import java.io.IOException;
import javax.inject.Inject;

public class CreateWeatherCommand {
  private ObjectMapper objectMapper;
  private DynamoDB dynamoDB;
  private final String tableName = System.getenv("LOCATIONS_TABLE");

  @Inject
  public CreateWeatherCommand(DynamoDB dynamoDB, ObjectMapper objectMapper) {
    this.dynamoDB = dynamoDB;
    this.objectMapper = objectMapper;
  }

  public ApiGatewayResponse execute(ApiGatewayRequest request) throws IOException {
    final WeatherEvent weatherEvent = objectMapper.readValue(request.getBody(), WeatherEvent.class);

    final Table table = dynamoDB.getTable(tableName);
    final Item item =
        new Item()
            .withPrimaryKey("locationName", weatherEvent.getLocationName())
            .withDouble("temperature", weatherEvent.getTemperature())
            .withLong("timestamp", weatherEvent.getTimestamp())
            .withDouble("longitude", weatherEvent.getLatitude())
            .withDouble("latitude", weatherEvent.getLatitude());
    table.putItem(item);

    return ApiGatewayResponse.builder()
        .statusCode(200)
        .body(weatherEvent.getLocationName())
        .build();
  }
}
