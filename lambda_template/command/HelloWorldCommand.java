package com.online_education.${SERVICE_NAME}.command;

import com.online_education.model.ApiGatewayRequest;
import com.online_education.model.ApiGatewayResponse;
import com.online_education.server.Command;
import javax.inject.Inject;

public class HelloWorldCommand implements Command {

  @Inject
  public HelloWorldCommand() {
  }

  // The request can be self defined java object
  public ApiGatewayResponse execute(ApiGatewayRequest request) {
    String message = request.queryStringParameters == null ?
        "hello world" :
        request.queryStringParameters.getOrDefault("message", "hello");
    return ApiGatewayResponse.builder().body(message).statusCode(200).build();
  }
}
