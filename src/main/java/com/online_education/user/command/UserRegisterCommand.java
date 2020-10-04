
package com.online_education.user.command;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Inject;

public class UserRegisterCommand implements RequestStreamHandler {

  private ObjectMapper objectMapper;
  private DynamoDB dynamoDb;
  private String DYNAMODB_TABLE_NAME = "student";
  private Regions REGION = Regions.US_EAST_1;

  @Inject
  public UserRegisterCommand(ObjectMapper objectMapper, DynamoDB dynamoDb) {
    this.objectMapper = objectMapper;
    this.dynamoDb = dynamoDb;
  }

  @Override
  public void handleRequest(InputStream is, OutputStream os, Context context) throws IOException {

    JsonNode eventNode = objectMapper.readTree(is);  // convert event stream to Json Node format
    context.getLogger().log("Received: " + eventNode); // Just log the Json message

    // Insert one item into DynamoDb
    // First is the name in the DynamoDB, second is the name in the Json
    this.dynamoDb.getTable(DYNAMODB_TABLE_NAME)
        .putItem(
            new PutItemSpec().withItem(new Item()
                .withString("user_name", eventNode.get("userName").textValue())));

    context.getLogger().log("Returning: " + eventNode);  // Log after the insertion

    objectMapper.writeValue(os, eventNode);
  }

}
