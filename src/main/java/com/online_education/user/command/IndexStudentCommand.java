package com.online_education.user.command;

import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent.DynamodbStreamRecord;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RestHighLevelClient;

/** @auther fangboyang */
@Slf4j
public class IndexStudentCommand {

  private RestHighLevelClient restHighLevelClient;
  private ObjectMapper objectMapper;
  private static final String INSERT = "insert";
  private static final String MODIFY = "modify";

  @Inject
  public IndexStudentCommand(RestHighLevelClient restHighLevelClient, ObjectMapper objectMapper) {
    this.restHighLevelClient = restHighLevelClient;
    this.objectMapper = objectMapper;
  }

  public void handleDynamoDBEvent(DynamodbEvent dynamodbEvent) {
    for (DynamodbStreamRecord record : dynamodbEvent.getRecords()) {
      String jsonString;
      try {
        jsonString = objectMapper.writeValueAsString(record.getDynamodb().getNewImage());
      } catch (JsonProcessingException e) {
        log.error("Failed to convert new image to json string", e);
      }
      if (record.getEventName().toLowerCase().equals(INSERT)) log.info(record.getEventID());
      log.info(record.getEventName());
      log.info(record.getDynamodb().toString());
    }
  }
}
