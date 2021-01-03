package com.online_education.user.command;/**
 * Copyright (C) 2020 Urban Compass, Inc.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.online_education.dao.student.Student;
import com.online_education.dao.student.StudentDao;
import com.online_education.model.ApiGatewayRequest;
import com.online_education.model.ApiGatewayResponse;
import java.io.IOException;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;

/**
 * @auther fansun
 */
@Slf4j
public class UserCreateCommand {
  private ObjectMapper objectMapper;
  private StudentDao studentDao;

  @Inject
  public UserCreateCommand(ObjectMapper objectMapper, StudentDao studentDao) {
    this.objectMapper = objectMapper;
    this.studentDao = studentDao;
  }

  public ApiGatewayResponse execute(ApiGatewayRequest request) throws IOException {
    final Student student = objectMapper.readValue(request.body, Student.class);
    log.info("Creating student " + student.toString());
    studentDao.create(student);
    return new ApiGatewayResponse(200, student.getUserName());
  }
}
