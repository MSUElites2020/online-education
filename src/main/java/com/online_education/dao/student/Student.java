package com.online_education.dao.student;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import java.util.List;
import lombok.Data;

/**
 * @auther fangboyang
 */
@DynamoDBTable(tableName = "student")
@Data
public class Student {
  @DynamoDBHashKey(attributeName = "user_name")
  private String userName;
  private String name;
  private String region;
  private String email;
  private String phoneNumber;
  private String imageUrl;
  private List<String> courseList;
}
