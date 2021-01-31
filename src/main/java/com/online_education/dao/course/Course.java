package com.online_education.dao.course;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import java.util.List;
import lombok.Data;

/**
 * @auther fansun
 */
@DynamoDBTable(tableName = "course")
@Data
public class Course {
  @DynamoDBHashKey(attributeName = "id")
  private String id;
  private String name;
  private String region;
  private String description;
  private String previewUrl;
  private String teacher;
  private List<String> student;
}
