package com.online_education.server;

import com.online_education.model.ApiGatewayRequest;
import com.online_education.model.ApiGatewayResponse;

public interface Command {
  ApiGatewayResponse execute(ApiGatewayRequest request);
}
