package com.weather2;

import java.util.HashMap;
import java.util.Map;

public class ApiGatewayRequest {
    public String body;
    public Map<String, String> queryStringParameters = new HashMap<>();
}
