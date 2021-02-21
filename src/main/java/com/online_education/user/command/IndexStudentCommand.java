package com.online_education.user.command;

import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent.DynamodbStreamRecord;
import com.amazonaws.services.lambda.runtime.events.models.dynamodb.AttributeValue;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;
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

      String userName;
      String eventName = record.getEventName().toLowerCase();
      log.info("DynamoDB item: {}", record.getDynamodb().getNewImage());
      log.info("DynamoDB event type: {}", eventName);
      Map<String, AttributeValue> newImage = record.getDynamodb().getNewImage();
      switch (eventName) {
        case INSERT:
          userName = record.getDynamodb().getNewImage().get("user_name").getS();
          IndexRequest indexRequest =
              new IndexRequest(INDEX_NAME).id(userName).source(jsonString, XContentType.JSON);
          try {
            restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
          } catch (IOException e) {
            log.error("Failed to index {}", newImage, e);
            throw e;
          }
          log.info("Successfully indexed {}", newImage);
          break;
        case MODIFY:
          userName = record.getDynamodb().getNewImage().get("user_name").getS();
          UpdateRequest updateRequest =
              new UpdateRequest(INDEX_NAME, userName).doc(jsonString, XContentType.JSON);
          try{
            restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
          } catch (IOException e) {
            log.error("Failed to update {}", newImage, e);
            throw e;
          }
          log.info("Successfully updated {}", newImage);
          break;
        case REMOVE:
          // Getting newImage at removal will throw NPE, b/c there is no newImage.
          userName = record.getDynamodb().getOldImage().get("user_name").getS();
          try{
            restHighLevelClient.delete(new DeleteRequest(INDEX_NAME, userName), RequestOptions.DEFAULT);
          } catch (IOException e) {
            log.error("Failed to delete {}", newImage, e);
          }
          log.info("Successfully deleted {}", newImage);
          break;
        default:
      }

      log.info(record.getEventName());
      log.info(record.getDynamodb().toString());
    }
  }
}
