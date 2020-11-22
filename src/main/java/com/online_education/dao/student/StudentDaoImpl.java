package com.online_education.dao.student;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import javax.inject.Inject;

/**
 * @auther fangboyang
 */
public class StudentDaoImpl implements StudentDao {

  private DynamoDBMapper dynamoDBMapper;

  @Inject
  public StudentDaoImpl(DynamoDBMapper dynamoDBMapper) {
    this.dynamoDBMapper = dynamoDBMapper;
  }

  @Override
  public void create(Student student) {
    dynamoDBMapper.save(student);
  }

  @Override
  public Student get(String userName) {
    return dynamoDBMapper.load(Student.class, userName);
  }

  @Override
  public void update(Student student) {
    DynamoDBMapperConfig dynamoDBMapperConfig = new DynamoDBMapperConfig.Builder()
        .withConsistentReads(DynamoDBMapperConfig.ConsistentReads.CONSISTENT)
        .withSaveBehavior(DynamoDBMapperConfig.SaveBehavior.UPDATE)
        .build();
    dynamoDBMapper.save(student, dynamoDBMapperConfig);
  }
}
