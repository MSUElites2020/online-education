package com.online_education.helloworld.server;

import com.online_education.helloworld.command.HelloWorldCommand;
import com.online_education.model.ApiGatewayRequest;
import com.online_education.model.ApiGatewayResponse;
import javax.inject.Inject;

/** @auther fangboyang */
public class ${ServiceName}ServiceHandler {
  @Inject ${ServiceName}Command helloWorldCommand;

  public ${ServiceName}ServiceHandler() {
    DaggerHelloWorldComponent.create().inject(this);
  }

  public ApiGatewayResponse handleHelloWorld(ApiGatewayRequest request) {
    try {
      return helloWorldCommand.execute(request);
    } catch (Exception e) {
      return new ApiGatewayResponse(500, "Hello world failed!");
    }
  }
}
