package com.online_education.dao.teacher;/**
 * Copyright (C) 2021 Urban Compass, Inc.
 */

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig.SaveBehavior;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import java.util.List;
import javax.inject.Inject;

/**
 * @auther fansun
 */
public class TeacherDaoImpl implements TeacherDao {
  private DynamoDBMapper dynamoDBMapper;

  @Inject
  public TeacherDaoImpl(DynamoDBMapper dynamoDBMapper) {
    this.dynamoDBMapper = dynamoDBMapper;
  }

  @Override
  public void create(Teacher teacher) {
    dynamoDBMapper.save(teacher);
  }

  @Override
  public Teacher get(String userName) {
    return dynamoDBMapper.load(Teacher.class, userName);
  }

  @Override
  public void update(Teacher teacher) {
    DynamoDBMapperConfig dynamoDBMapperConfig = new DynamoDBMapperConfig.Builder()
        .withConsistentReads(DynamoDBMapperConfig.ConsistentReads.CONSISTENT)
        .withSaveBehavior(SaveBehavior.UPDATE_SKIP_NULL_ATTRIBUTES)
        .build();
    dynamoDBMapper.save(teacher, dynamoDBMapperConfig);
  }

  @Override
  public List<Teacher> scan() {
    return dynamoDBMapper.scan(Teacher.class, new DynamoDBScanExpression());
  }
}
