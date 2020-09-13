package com.online_education.weather;

import com.online_education.weather.command.CreateWeatherCommand;
import com.online_education.weather.command.GetWeatherCommand;
import javax.inject.Inject;

/** The handler to manage aws lambda routes */
public class WeatherServiceHandler {
  @Inject CreateWeatherCommand createWeatherCommand;
  @Inject GetWeatherCommand getWeatherCommand;

  public WeatherServiceHandler() {
    DaggerWeatherComponent.create().inject(this);
  }

  public ApiGatewayResponse handleCreateWeather(ApiGatewayRequest request) {
    try {
      return createWeatherCommand.execute(request);
    } catch (Exception e) {
      return new ApiGatewayResponse(500, "create weather failed");
    }
  }

  public ApiGatewayResponse handleGetWeather(ApiGatewayRequest request) {
    try {
      return getWeatherCommand.execute(request);
    } catch (Exception e) {
      return new ApiGatewayResponse(500, "get weather failed");
    }
  }
}
