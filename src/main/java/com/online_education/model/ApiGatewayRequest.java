package com.online_education.model;

import java.util.HashMap;
import java.util.Map;
import lombok.Builder;
import lombok.Data;

public class ApiGatewayRequest {
    public String body;
    public Map<String, String> queryStringParameters = new HashMap<>();
}
