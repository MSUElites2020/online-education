package com.online_education.weather;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ApiGatewayResponse {

    public ApiGatewayResponse() {
    }

    private Integer statusCode;
    private String body;
}
