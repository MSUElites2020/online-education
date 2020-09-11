package com.online_education.weather;

import java.io.IOException;

import javax.inject.Inject;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WeatherEventLambda {
  private final ObjectMapper objectMapper =
      new ObjectMapper()
          .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  @Inject
  DynamoDB dynamoDB;
  private final String tableName = System.getenv("LOCATIONS_TABLE");

  public ApiGatewayResponse handler(ApiGatewayRequest request) throws IOException {
    DaggerAWSResourceComponent.create().inject(this);
    final WeatherEvent
        weatherEvent = objectMapper.readValue(request.body, WeatherEvent.class);

    final Table table = dynamoDB.getTable(tableName);
    final Item item = new Item()
        .withPrimaryKey("locationName", weatherEvent.locationName)
        .withDouble("temperature", weatherEvent.temperature)
        .withLong("timestamp", weatherEvent.timestamp)
        .withDouble("longitude", weatherEvent.longitude)
        .withDouble("latitude", weatherEvent.latitude);
    table.putItem(item);

    return new ApiGatewayResponse(200, weatherEvent.locationName);
  }
}
