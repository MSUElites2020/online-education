package com.online_education.user.server;
import com.amazonaws.services.lambda.runtime.Context;
import com.online_education.model.ApiGatewayRequest;
import com.online_education.model.ApiGatewayResponse;
import com.online_education.user.command.UserCreateCommand;
import com.online_education.user.command.UserGetCommand;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent.DynamodbStreamRecord;
import com.online_education.user.command.UserRegisterCommand;
import com.online_education.user.command.UserUpdateCommand;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserServiceHandler {
  @Inject
  UserRegisterCommand userRegisterCommand;
  @Inject
  UserCreateCommand userCreateCommand;
  @Inject
  UserUpdateCommand userUpdateCommand;
  @Inject
  UserGetCommand userGetCommand;

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

  public ApiGatewayResponse handleUserCreate(ApiGatewayRequest request) {
    try {
      return userCreateCommand.execute(request);
    } catch (Exception e) {
      return new ApiGatewayResponse(500, "Create user failed " + e.getMessage());
    }
  }

  public ApiGatewayResponse handleUserUpdate(ApiGatewayRequest request) {
    try {
      return userUpdateCommand.execute(request);
    } catch (Exception e) {
      return new ApiGatewayResponse(500, "Update user failed " + e.getMessage());
    }
  }

  public ApiGatewayResponse handleUserGet(ApiGatewayRequest request) {
    try {
      return userGetCommand.execute(request);
    } catch (Exception e) {
      return new ApiGatewayResponse(500, "Get user failed " + e.getMessage() + " " + request.queryStringParameters.get("userName"));
    }
  }

  public String indexStudent(DynamodbEvent ddbEvent, Context context) {
    for (DynamodbStreamRecord record : ddbEvent.getRecords()){
      log.info(record.getEventID());
      log.info(record.getEventName());
      log.info(record.getDynamodb().toString());
    }
    return "Successfully processed " + ddbEvent.getRecords().size() + " records.";
  }
}
