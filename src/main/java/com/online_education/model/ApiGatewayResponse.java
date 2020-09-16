package com.online_education.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ApiGatewayResponse {
    private int statusCode;
    private String body;

    // The return value in lambda handler cannot accept builder
    public ApiGatewayResponse(int statusCode, String body) {
        this.statusCode = statusCode;
        this.body = body;
    }
}
