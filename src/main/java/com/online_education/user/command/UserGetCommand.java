package com.online_education.user.command;/**
 * Copyright (C) 2020 Urban Compass, Inc.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.online_education.dao.student.Student;
import com.online_education.dao.student.StudentDao;
import com.online_education.model.ApiGatewayRequest;
import com.online_education.model.ApiGatewayResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import java.io.IOException;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;

/**
 * @auther fansun
 */

@Slf4j
public class UserGetCommand {
  private ObjectMapper objectMapper;
  private StudentDao studentDao;

  @Inject
  public UserGetCommand(ObjectMapper objectMapper, StudentDao studentDao) {
    this.objectMapper = objectMapper;
    this.studentDao = studentDao;
  }

  public ApiGatewayResponse execute(ApiGatewayRequest request) throws IOException {
    String userName = request.queryStringParameters.get("userName");
    log.info("Get userName" + userName);
    String auth = request.queryStringParameters.get("token");
    log.info("Get token" + auth);
    checkAuth(auth);
    log.info("Retrieving student " + userName);
    Student student = studentDao.get(userName);
    return new ApiGatewayResponse(200, "return item is : " + objectMapper.writeValueAsString(student));
  }

  private boolean checkAuth(String auth) {
    Claims claims = Jwts.parser()
        .parseClaimsJws(auth).getBody();
    log.info("Parse claims " + claims.toString());
    return true;
  }
}
