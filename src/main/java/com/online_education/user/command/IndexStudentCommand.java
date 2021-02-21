package com.online_education.user.command;

import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent.DynamodbStreamRecord;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

/** @auther fangboyang */
@Slf4j
public class IndexStudentCommand {

  private RestHighLevelClient restHighLevelClient;
  private ObjectMapper objectMapper;
  private static final String INSERT = "insert";
  private static final String MODIFY = "modify";
  private static final String REMOVE = "remove";
  private static final String INDEX_NAME = "student";
  private static final String USER_NAME = "user_name";

  @Inject
  public IndexStudentCommand(RestHighLevelClient restHighLevelClient, ObjectMapper objectMapper) {
    this.restHighLevelClient = restHighLevelClient;
    this.objectMapper = objectMapper;
  }

  public void handleDynamoDBEvent(DynamodbEvent dynamodbEvent) throws IOException {
    for (DynamodbStreamRecord record : dynamodbEvent.getRecords()) {
      String jsonString = null;
      try {
        jsonString = objectMapper.writeValueAsString(record.getDynamodb().getNewImage());
      } catch (Exception e) {
        log.error("Failed to convert new image to json string", e);
        throw e;
      }

      String userName = record.getDynamodb().getKeys().get(USER_NAME).getS();
      String eventName = record.getEventName().toLowerCase();
      log.info("DynamoDB item: {}", record.getDynamodb());
      log.info("DynamoDB event type: {}", eventName);

      switch (eventName) {
        case INSERT:
          IndexRequest indexRequest =
              new IndexRequest(INDEX_NAME).id(userName).source(jsonString, XContentType.JSON);
          try {
            restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
          } catch (IOException e) {
            log.error("Failed to index {}", jsonString, e);
            throw e;
          }
          log.info("Successfully indexed {}", jsonString);
          break;
        case MODIFY:
          UpdateRequest updateRequest =
              new UpdateRequest(INDEX_NAME, userName).doc(jsonString, XContentType.JSON);
          try{
            restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
          } catch (IOException e) {
            log.error("Failed to update {}", jsonString, e);
            throw e;
          }
          log.info("Successfully updated {}", jsonString);
          break;
        case REMOVE:
          try{
            restHighLevelClient.delete(new DeleteRequest(INDEX_NAME, userName), RequestOptions.DEFAULT);
          } catch (IOException e) {
            log.error("Failed to delete {}", userName, e);
          }
          log.info("Successfully deleted {}", userName);
          break;
        default:
      }

      log.info(record.getEventName());
      log.info(record.getDynamodb().toString());
    }
  }
}
