package com.online_education.course.server;

import com.online_education.course.command.CourseCreateCommand;
import com.online_education.course.command.CourseGetCommand;
import com.online_education.course.command.CourseUpdateCommand;
import com.online_education.model.ApiGatewayRequest;
import com.online_education.model.ApiGatewayResponse;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;

/**
 * @auther fansun
 */
@Slf4j
public class CourseServiceHandler {
  @Inject
  CourseCreateCommand courseCreateCommand;
  @Inject
  CourseUpdateCommand courseUpdateCommand;
  @Inject
  CourseGetCommand courseGetCommand;

  public CourseServiceHandler() {
    DaggerCourseComponent.create().inject(this);
  }

  public ApiGatewayResponse handleCourseCreate(ApiGatewayRequest request) {
    try {
      return courseCreateCommand.execute(request);
    } catch (Exception e) {
      return new ApiGatewayResponse(500, "Create course failed " + e.getMessage());
    }
  }

  public ApiGatewayResponse handleCourseUpdate(ApiGatewayRequest request) {
    try {
      return courseUpdateCommand.execute(request);
    } catch (Exception e) {
      return new ApiGatewayResponse(500, "Update course failed " + e.getMessage());
    }
  }

  public ApiGatewayResponse handleCourseGet(ApiGatewayRequest request) {
    try {
      return courseGetCommand.execute(request);
    } catch (Exception e) {
      return new ApiGatewayResponse(500, "Get course failed " + e.getMessage() + " " + request.queryStringParameters.get("id"));
    }
  }
}
