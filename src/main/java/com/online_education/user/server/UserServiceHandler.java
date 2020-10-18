package com.online_education.user.server;
import com.amazonaws.services.lambda.runtime.Context;
import com.online_education.model.ApiGatewayRequest;
import com.online_education.model.ApiGatewayResponse;
import com.online_education.user.command.PutUserCommand;
import com.online_education.user.command.UserRegisterCommand;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Inject;

public class UserServiceHandler {
  @Inject
  UserRegisterCommand userRegisterCommand;
  @Inject
  PutUserCommand putUserCommand;

  public UserServiceHandler() {
    DaggerUserComponent.create().inject(this);
  }

  public void handleUserRegister(InputStream is, OutputStream os, Context context) {
    try {
      userRegisterCommand.handleRequest(is, os, context);
    } catch (Exception ex) {
      context.getLogger().log(ex.getMessage());
    }
  }

  public ApiGatewayResponse handlePutUser(ApiGatewayRequest request) {
    try {
      return putUserCommand.execute(request);
    } catch (Exception e) {
      return new ApiGatewayResponse(500, "create user failed");
    }
  }
}
