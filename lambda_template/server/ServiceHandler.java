package com.online_education.${SERVICE_NAME}.server;

import com.online_education.${SERVICE_NAME}.command.HelloWorldCommand;
import com.online_education.model.ApiGatewayRequest;
import com.online_education.model.ApiGatewayResponse;
import javax.inject.Inject;

public class ${SERVICE_CLASS_NAME}ServiceHandler {
  @Inject HelloWorldCommand helloWorldCommand;

  public ${SERVICE_CLASS_NAME}ServiceHandler() {
    // Dagger${SERVICE_CLASS_NAME}Component.create().inject(this);
  }

  public ApiGatewayResponse handleHelloWorld(ApiGatewayRequest request) {
    try {
      return helloWorldCommand.execute(request);
    } catch (Exception e) {
      return new ApiGatewayResponse(500, "Hello world failed!");
    }
  }
}
