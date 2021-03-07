package com.online_education.user.command;

import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent.DynamodbStreamRecord;
import com.online_education.search.Indexer;
import java.io.IOException;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;

/** @auther fangboyang */
@Slf4j
public class IndexStudentCommand {
  private static final String INDEX_NAME = "student";
  private static final String USER_NAME = "user_name";
  private Indexer indexer;

  @Inject
  public IndexStudentCommand(Indexer indexer) {
    this.indexer = indexer;
  }

  public void handleDynamoDBEvent(DynamodbEvent dynamodbEvent) throws IOException {
    for (DynamodbStreamRecord record : dynamodbEvent.getRecords()) {
      indexer.updateSearchIndex(record, INDEX_NAME, USER_NAME);
    }
  }
}
