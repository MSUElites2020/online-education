package com.online_education.user.server;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent.DynamodbStreamRecord;
import com.online_education.user.command.IndexStudentCommand;
import com.online_education.user.command.UserRegisterCommand;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserServiceHandler {
  @Inject
  UserRegisterCommand userRegisterCommand;
  @Inject
  IndexStudentCommand indexStudentCommand;

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

  public String indexStudent(DynamodbEvent ddbEvent, Context context) {
    indexStudentCommand.handleDynamoDBEvent(ddbEvent);
    for (DynamodbStreamRecord record : ddbEvent.getRecords()){
      log.info(record.getEventID());
      log.info(record.getEventName());
      log.info(record.getDynamodb().toString());
    }
    return "Successfully processed " + ddbEvent.getRecords().size() + " records.";
  }
}
