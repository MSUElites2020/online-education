package com.online_education.user.command;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.online_education.dao.teacher.Teacher;
import com.online_education.dao.teacher.TeacherDao;
import com.online_education.model.ApiGatewayRequest;
import com.online_education.model.ApiGatewayResponse;
import java.io.IOException;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;

/**
 * @auther fansun
 */
@Slf4j
public class TeacherCreateCommand {
  private ObjectMapper objectMapper;
  private TeacherDao teacherDao;

  @Inject
  public TeacherCreateCommand(ObjectMapper objectMapper, TeacherDao teacherDao) {
    this.objectMapper = objectMapper;
    this.teacherDao = teacherDao;
  }

  public ApiGatewayResponse execute(ApiGatewayRequest request) throws IOException {
    final Teacher teacher = objectMapper.readValue(request.body, Teacher.class);
    log.info("Creating teacher " + teacher.toString());
    teacherDao.create(teacher);
    return new ApiGatewayResponse(200, teacher.getUserName());
  }
}
