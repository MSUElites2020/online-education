/**
 * Copyright (C) 2020 Urban Compass, Inc.
 */
package com.online_education.dagger.AWSResourceModule;

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
}
