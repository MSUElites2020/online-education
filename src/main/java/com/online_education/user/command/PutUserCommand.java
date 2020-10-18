package com.online_education.user.command;/**
 * Copyright (C) 2020 Urban Compass, Inc.
 */

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.online_education.model.ApiGatewayRequest;
import com.online_education.model.ApiGatewayResponse;
import com.online_education.user.UserEvent;
import java.io.IOException;
import javax.inject.Inject;

/**
 * @auther fansun
 */
public class PutUserCommand {
  private ObjectMapper objectMapper;
  private DynamoDB dynamoDB;
  private final String tableName = System.getenv("LOCATIONS_TABLE");

  @Inject
  public PutUserCommand(DynamoDB dynamoDB, ObjectMapper objectMapper) {
    this.dynamoDB = dynamoDB;
    this.objectMapper = objectMapper;
  }

  public ApiGatewayResponse execute(ApiGatewayRequest request) throws IOException {
    final UserEvent userEvent = objectMapper.readValue(request.body, UserEvent.class);

    final Table table = dynamoDB.getTable(tableName);
    final Item item =
        new Item()
            .withPrimaryKey("user_name", userEvent.getUserName());
    table.putItem(item);

    return new ApiGatewayResponse(200, userEvent.getUserName());
  }
}
