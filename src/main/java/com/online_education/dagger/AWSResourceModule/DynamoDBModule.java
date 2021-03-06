package com.online_education.dagger.AWSResourceModule;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import javax.inject.Inject;
import javax.inject.Singleton;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import dagger.Module;
import dagger.Provides;

/**
 * @author fangboyang
 */
@Module
public class DynamoDBModule {
  @Provides
  @Singleton
  DynamoDB dynamoDB() {
    return new DynamoDB(AmazonDynamoDBClientBuilder.defaultClient());
  }

  @Provides
  @Singleton
  AmazonDynamoDB amazonDynamoDB() {
    return AmazonDynamoDBClientBuilder.defaultClient();
  }

  @Provides
  @Singleton
  @Inject
  DynamoDBMapper dynamoDBMapper(AmazonDynamoDB dynamoDB) {
    return new DynamoDBMapper(dynamoDB);
  }
}
