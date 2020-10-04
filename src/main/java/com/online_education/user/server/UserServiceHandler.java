package com.online_education.user.server;
import com.amazonaws.services.lambda.runtime.Context;
import com.online_education.user.command.UserRegisterCommand;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Inject;

public class UserServiceHandler {
  @Inject
  UserRegisterCommand userRegisterCommand;

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
}
