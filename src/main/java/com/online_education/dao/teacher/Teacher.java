package com.online_education.dao.teacher;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import java.util.List;
import lombok.Data;

/**
 * @auther fansun
 */
@DynamoDBTable(tableName = "teacher")
@Data
public class Teacher {
  @DynamoDBHashKey(attributeName = "user_name")
  private String userName;
  private String name;
  private String region;
  private String email;
  private String phoneNumber;
  private String imageUrl;
  private List<String> courseList;
}
