package com.online_education.search;

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

/**
 * @auther fangboyang
 */
@Slf4j
public class Indexer {
  private static final String INSERT = "insert";
  private static final String MODIFY = "modify";
  private static final String REMOVE = "remove";
  private RestHighLevelClient restHighLevelClient;
  private ObjectMapper objectMapper;

  @Inject
  public Indexer(
      RestHighLevelClient restHighLevelClient,
      ObjectMapper objectMapper) {
    this.restHighLevelClient = restHighLevelClient;
    this.objectMapper = objectMapper;
  }

  /**
   * Update elastic search inde
   * @param record the dynamoDB record to update
   * @param indexName the name of the index in elasticsearch
   * @param keyName the partition key name in dynamoDB record
   * */
  public void updateSearchIndex(
      DynamodbStreamRecord record,
      String indexName,
      String keyName) throws IOException {

    String jsonString = null;
    if (record.getDynamodb() != null) {
      try {
        jsonString = objectMapper.writeValueAsString(record.getDynamodb().getNewImage());
        log.info("json string: {}", jsonString);
      } catch (Exception e) {
        log.error("Failed to convert new image to json string", e);
        throw e;
      }
    }

    String id = record.getDynamodb().getKeys().get(keyName).getS();
    String eventName = record.getEventName().toLowerCase();
    log.info("DynamoDB item: {}", record.getDynamodb());
    log.info("DynamoDB event type: {}", eventName);

    switch (eventName) {
      case INSERT:
        IndexRequest indexRequest =
            new IndexRequest(indexName).id(id).source(jsonString, XContentType.JSON);
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
            new UpdateRequest(indexName, id).doc(jsonString, XContentType.JSON);
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
          restHighLevelClient.delete(new DeleteRequest(indexName, id), RequestOptions.DEFAULT);
        } catch (IOException e) {
          log.error("Failed to delete {}", id, e);
        }
        log.info("Successfully deleted {}", id);
        break;
      default:
    }
  }
}
