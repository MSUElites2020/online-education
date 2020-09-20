package com.online_education.user.command;/**
 * Copyright (C) 2020 Urban Compass, Inc.
 */

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.CognitoEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.online_education.user.UserEvent;
import javax.inject.Inject;

/**
 * @auther fansun
 */
public class CreateUserCommand implements RequestHandler<UserEvent, UserEvent> {
  private ObjectMapper objectMapper;
  private DynamoDB dynamoDB;
  private final String tableName = System.getenv("student");

  @Inject
  public CreateUserCommand(DynamoDB dynamoDB, ObjectMapper objectMapper) {
    this.dynamoDB = dynamoDB;
    this.objectMapper = objectMapper;
  }

  @Override
  public UserEvent handleRequest(UserEvent event, Context context) {
    LambdaLogger logger = context.getLogger();
    try {
      logger.log("Start UserHandler");
      logger.log(event.getUserName());
      final Table table = dynamoDB.getTable(tableName);
      final Item item =
          new Item()
              .withPrimaryKey("user_name", event.getUserName());
      table.putItem(item);
    } catch(Exception e) {
      logger.log("Exception UserHandler with" + e);
    }
    return event;
  }
}
