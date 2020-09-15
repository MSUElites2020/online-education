package com.online_education.model;

import java.util.HashMap;
import java.util.Map;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiGatewayRequest {
  private String body;
  private Map<String, String> queryStringParameters = new HashMap<>();
}
