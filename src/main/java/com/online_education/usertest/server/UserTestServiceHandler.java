package com.online_education.usertest.server;

import com.online_education.usertest.command.HelloWorldCommand;
import com.online_education.model.ApiGatewayRequest;
import com.online_education.model.ApiGatewayResponse;
import javax.inject.Inject;

public class UserTestServiceHandler {
  @Inject HelloWorldCommand helloWorldCommand;

  public UserTestServiceHandler() {
    // DaggerUserTestComponent.create().inject(this);
  }

  public ApiGatewayResponse handleHelloWorld(ApiGatewayRequest request) {
    try {
      return helloWorldCommand.execute(request);
    } catch (Exception e) {
      return new ApiGatewayResponse(500, "Hello world failed!");
    }
  }
}
