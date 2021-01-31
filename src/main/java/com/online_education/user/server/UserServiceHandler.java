package com.online_education.user.server;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent.DynamodbStreamRecord;
import com.online_education.model.ApiGatewayRequest;
import com.online_education.model.ApiGatewayResponse;
import com.online_education.user.command.IndexStudentCommand;
import com.online_education.user.command.TeacherCreateCommand;
import com.online_education.user.command.TeacherGetCommand;
import com.online_education.user.command.TeacherUpdateCommand;
import com.online_education.user.command.UserCreateCommand;
import com.online_education.user.command.UserGetCommand;
import com.online_education.user.command.UserRegisterCommand;
import com.online_education.user.command.UserUpdateCommand;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserServiceHandler {
  @Inject UserRegisterCommand userRegisterCommand;
  @Inject UserCreateCommand userCreateCommand;
  @Inject UserUpdateCommand userUpdateCommand;
  @Inject UserGetCommand userGetCommand;
  @Inject TeacherCreateCommand teacherCreateCommand;
  @Inject TeacherUpdateCommand teacherUpdateCommand;
  @Inject TeacherGetCommand teacherGetCommand;
  @Inject IndexStudentCommand indexStudentCommand;

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
      return new ApiGatewayResponse(
          500,
          "Get user failed "
              + e.getMessage()
              + " "
              + request.queryStringParameters.get("userName"));
    }
  }

  public ApiGatewayResponse handleTeacherCreate(ApiGatewayRequest request) {
    try {
      return teacherCreateCommand.execute(request);
    } catch (Exception e) {
      return new ApiGatewayResponse(500, "Create teacher failed " + e.getMessage());
    }
  }

  public ApiGatewayResponse handleTeacherUpdate(ApiGatewayRequest request) {
    try {
      return teacherUpdateCommand.execute(request);
    } catch (Exception e) {
      return new ApiGatewayResponse(500, "Update teacher failed " + e.getMessage());
    }
  }

  public ApiGatewayResponse handleTeacherGet(ApiGatewayRequest request) {
    try {
      return teacherGetCommand.execute(request);
    } catch (Exception e) {
      return new ApiGatewayResponse(
          500,
          "Get teacher failed "
              + e.getMessage()
              + " "
              + request.queryStringParameters.get("userName"));
    }
  }

  public String indexStudent(DynamodbEvent ddbEvent, Context context) throws IOException {
    indexStudentCommand.handleDynamoDBEvent(ddbEvent);
    return "Successfully indexed " + ddbEvent.getRecords().size() + " records.";
  }
}
