package com.online_education.dao.course;/**
 * Copyright (C) 2021 Urban Compass, Inc.
 */

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig.SaveBehavior;
import javax.inject.Inject;

/**
 * @auther fansun
 */
public class CourseDaoImpl implements CourseDao {
  private DynamoDBMapper dynamoDBMapper;

  @Inject
  public CourseDaoImpl(DynamoDBMapper dynamoDBMapper) {
    this.dynamoDBMapper = dynamoDBMapper;
  }

  @Override
  public void create(Course course) {
    dynamoDBMapper.save(course);
  }

  @Override
  public Course get(String id) {
    return dynamoDBMapper.load(Course.class, id);
  }

  @Override
  public void update(Course course) {
    DynamoDBMapperConfig dynamoDBMapperConfig = new DynamoDBMapperConfig.Builder()
        .withConsistentReads(DynamoDBMapperConfig.ConsistentReads.CONSISTENT)
        .withSaveBehavior(SaveBehavior.UPDATE_SKIP_NULL_ATTRIBUTES)
        .build();
    dynamoDBMapper.save(course, dynamoDBMapperConfig);
  }
}
