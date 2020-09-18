package com.online_education.finance.server;

import com.online_education.finance.command.HelloWorldCommand;
import com.online_education.model.ApiGatewayRequest;
import com.online_education.model.ApiGatewayResponse;
import javax.inject.Inject;

public class FinanceServiceHandler {
  @Inject HelloWorldCommand helloWorldCommand;

  public FinanceServiceHandler() {
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
