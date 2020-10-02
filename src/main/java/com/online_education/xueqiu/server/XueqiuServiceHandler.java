package com.online_education.xueqiu.server;

import com.online_education.xueqiu.command.HelloWorldCommand;
import com.online_education.model.ApiGatewayRequest;
import com.online_education.model.ApiGatewayResponse;
import javax.inject.Inject;

public class XueqiuServiceHandler {
  @Inject HelloWorldCommand helloWorldCommand;

  public XueqiuServiceHandler() {
    // Uncomment before use !!!
    // DaggerXueqiuComponent.create().inject(this);
  }

  public ApiGatewayResponse handleHelloWorld(ApiGatewayRequest request) {
    try {
      return helloWorldCommand.execute(request);
    } catch (Exception e) {
      return new ApiGatewayResponse(500, "Hello world failed!");
    }
  }
}
