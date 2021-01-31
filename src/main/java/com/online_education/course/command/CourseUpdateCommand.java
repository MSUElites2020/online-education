package com.online_education.course.command;/**
 * Copyright (C) 2021 Urban Compass, Inc.
 */

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
public class CourseUpdateCommand {
  private ObjectMapper objectMapper;
  private CourseDao courseDao;

  @Inject
  public CourseUpdateCommand(ObjectMapper objectMapper, CourseDao courseDao) {
    this.objectMapper = objectMapper;
    this.courseDao = courseDao;
  }

  public ApiGatewayResponse execute(ApiGatewayRequest request) throws IOException {
    final Course course = objectMapper.readValue(request.body, Course.class);
    log.info("Updating course " + course.toString());
    courseDao.update(course);
    return new ApiGatewayResponse(200, course.getId());
  }
}
