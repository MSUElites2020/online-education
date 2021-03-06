package com.online_education.user.server;

import com.online_education.dagger.AWSResourceModule.DynamoDBModule;
import com.online_education.search.ElasticSearchModule;
import com.online_education.dagger.ObjectMapperModule;
import com.online_education.dao.student.StudentDaoModule;
import com.online_education.dao.teacher.TeacherDaoModule;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(
    modules = {
      StudentDaoModule.class,
      TeacherDaoModule.class,
      ObjectMapperModule.class,
      DynamoDBModule.class,
      ElasticSearchModule.class
    })
public interface UserComponent {
  void inject(UserServiceHandler userServiceHandler);
}
