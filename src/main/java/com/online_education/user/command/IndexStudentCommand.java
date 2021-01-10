package com.online_education.user.command;

import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;
import javax.inject.Inject;

/**
 * @auther fangboyang
 */
public class IndexStudentCommand {

  @Inject
  public IndexStudentCommand() {
  }

  public void handleDynamoDBEvent(DynamodbEvent dynamodbEvent) {

  }
}
