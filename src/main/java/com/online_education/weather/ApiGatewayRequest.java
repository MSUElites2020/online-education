package com.online_education.weather;

import java.util.HashMap;
import java.util.Map;

public class ApiGatewayRequest {
  public String body;
  public Map<String, String> queryStringParameters = new HashMap<>();
}
