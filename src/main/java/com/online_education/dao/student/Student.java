package com.online_education.dao.student;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Builder;
import lombok.Data;

/**
 * @auther fangboyang
 */
@DynamoDBTable(tableName = "Student")
@Data
@Builder
public class Student {
  @DynamoDBHashKey(attributeName = "user_name")
  private String userName;
}
