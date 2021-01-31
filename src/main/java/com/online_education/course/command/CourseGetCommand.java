package com.online_education.course.command;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.online_education.dao.course.Course;
import com.online_education.dao.course.CourseDao;
import com.online_education.model.ApiGatewayRequest;
import com.online_education.model.ApiGatewayResponse;
import java.io.IOException;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;

/**
 * @auther fansun
 */
@Slf4j
public class CourseGetCommand {
  private ObjectMapper objectMapper;
  private CourseDao courseDao;

  @Inject
  public CourseGetCommand(ObjectMapper objectMapper, CourseDao courseDao) {
    this.objectMapper = objectMapper;
    this.courseDao = courseDao;
  }

  public ApiGatewayResponse execute(ApiGatewayRequest request) throws IOException {
    String id = request.queryStringParameters.get("id");
    log.info("Retrieving course " + id);
    Course course = courseDao.get(id);
    return new ApiGatewayResponse(200, "return item is : " + objectMapper.writeValueAsString(course));
  }
}
