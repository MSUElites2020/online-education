package com.online_education.user.command;/**
 * Copyright (C) 2021 Urban Compass, Inc.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.online_education.dao.teacher.Teacher;
import com.online_education.dao.teacher.TeacherDao;
import com.online_education.model.ApiGatewayRequest;
import com.online_education.model.ApiGatewayResponse;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;

/**
 * @auther fansun
 */
@Slf4j
public class TeacherScanCommand {
    private ObjectMapper objectMapper;
    private TeacherDao teacherDao;

    @Inject
    public TeacherScanCommand(ObjectMapper objectMapper, TeacherDao teacherDao) {
        this.objectMapper = objectMapper;
        this.teacherDao = teacherDao;
    }

    public ApiGatewayResponse execute(ApiGatewayRequest request) throws IOException {
        log.info("Scaning teachers");
        List<Teacher> teachers = teacherDao.scan();
        return new ApiGatewayResponse(200, "return item is : " + objectMapper.writeValueAsString(teachers));
    }
}
