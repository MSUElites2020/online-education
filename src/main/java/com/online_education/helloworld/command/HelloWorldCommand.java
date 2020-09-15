package com.online_education.helloworld.command;

import com.online_education.model.ApiGatewayResponse;
import javax.inject.Inject;

/**
 * @auther fangboyang
 */
public class HelloWorldCommand {

  @Inject
  public HelloWorldCommand() {
  }

  // The request can be self defined java object
  public ApiGatewayResponse execute(String request) {
    return ApiGatewayResponse.builder().body(request + " received.").statusCode(200).build();
  }
}
