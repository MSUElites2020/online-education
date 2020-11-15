package com.online_education.dao.student;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
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
}
