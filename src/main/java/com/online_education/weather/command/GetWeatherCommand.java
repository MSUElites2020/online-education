package com.online_education.weather.command;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.online_education.model.ApiGatewayRequest;
import com.online_education.model.ApiGatewayResponse;
import com.online_education.weather.WeatherEvent;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;

public class GetWeatherCommand {
  private final ObjectMapper objectMapper;
  private final AmazonDynamoDB dynamoDB;
  private final String tableName = System.getenv("LOCATIONS_TABLE");

  private static final String DEFAULT_LIMIT = "50";

  @Inject
  public GetWeatherCommand(
      ObjectMapper objectMapper,
      AmazonDynamoDB dynamoDB) {
    this.objectMapper = objectMapper;
    this.dynamoDB = dynamoDB;
  }

  public ApiGatewayResponse execute(ApiGatewayRequest request) throws IOException {
    final String limitParam =
        request.getQueryStringParameters() == null
            ? DEFAULT_LIMIT
            : request.getQueryStringParameters().getOrDefault("limit", DEFAULT_LIMIT);
    final int limit = Integer.parseInt(limitParam);

    final ScanRequest scanRequest = new ScanRequest().withTableName(tableName).withLimit(limit);
    final ScanResult scanResult = dynamoDB.scan(scanRequest);

    final List<WeatherEvent> events =
        scanResult.getItems().stream()
            .map(
                item ->
                    WeatherEvent.builder()
                        .locationName(item.get("locationName").getS())
                        .temperature(Double.parseDouble(item.get("temperature").getN()))
                        .timestamp(Long.parseLong(item.get("timestamp").getN()))
                        .longitude(Double.parseDouble(item.get("longitude").getN()))
                        .latitude(Double.parseDouble(item.get("latitude").getN()))
                        .build())
            .collect(Collectors.toList());

    final String json = objectMapper.writeValueAsString(events);

    return ApiGatewayResponse.builder().statusCode(200).body(json).build();
  }
}
