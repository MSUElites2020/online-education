package com.online_education.hello_world.server;

import com.online_education.hello_world.command.HelloWorldCommand;
import com.online_education.model.ApiGatewayResponse;
import javax.inject.Inject;

/**
 * @auther fangboyang
 */
public class HelloWorldServiceHandler {
  @Inject
  HelloWorldCommand helloWorldCommand;

  public HelloWorldServiceHandler() {
    DaggerHelloWorldComponent.create().inject(this);
  }

  public ApiGatewayResponse handleHelloWorld(String request) {
    try {
      return helloWorldCommand.execute(request);
    } catch (Exception e) {
      return new ApiGatewayResponse(500, "Hello world failed!");
    }
  }
}
