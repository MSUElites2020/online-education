package com.online_education.course.command;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.online_education.dao.course.Course;
import com.online_education.dao.course.CourseDao;
import com.online_education.model.ApiGatewayRequest;
import com.online_education.model.ApiGatewayResponse;
import java.io.IOException;
import java.util.UUID;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;

/**
 * @auther fansun
 */
@Slf4j
public class CourseCreateCommand {
  private ObjectMapper objectMapper;
  private CourseDao courseDao;

  @Inject
  public CourseCreateCommand(ObjectMapper objectMapper, CourseDao courseDao) {
    this.objectMapper = objectMapper;
    this.courseDao = courseDao;
  }

  public ApiGatewayResponse execute(ApiGatewayRequest request) throws IOException {
    final Course course = objectMapper.readValue(request.body, Course.class);
    course.setId(UUID.randomUUID().toString());
    log.info("Creating course " + course.toString());
    courseDao.create(course);
    return new ApiGatewayResponse(200, course.getId());
  }
}
