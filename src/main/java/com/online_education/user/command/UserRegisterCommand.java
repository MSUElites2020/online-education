
package com.online_education.user.command;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.online_education.dao.student.Student;
import com.online_education.dao.student.StudentDao;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserRegisterCommand implements RequestStreamHandler {

  private ObjectMapper objectMapper;
  private StudentDao studentDao;

  @Inject
  public UserRegisterCommand(ObjectMapper objectMapper, StudentDao studentDao) {
    this.objectMapper = objectMapper;
    this.studentDao = studentDao;
  }

  @Override
  public void handleRequest(InputStream is, OutputStream os, Context context) throws IOException {
    // TODO objectMapper should map directly to student instance
    JsonNode eventNode = objectMapper.readTree(is);  // convert event stream to Json Node format
    context.getLogger().log("Received: " + eventNode); // Just log the Json message

    String userName = eventNode.get("userName").textValue();
    Student student = new Student();
    student.setUserName(userName);
    studentDao.create(student);

    context.getLogger().log("Returning: " + eventNode);  // Log after the insertion

    objectMapper.writeValue(os, eventNode);
  }
}
