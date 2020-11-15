package com.online_education.user.server;

import com.online_education.dagger.AWSResourceModule.DynamoDBModule;
import com.online_education.dagger.ObjectMapperModule;
import com.online_education.dao.student.StudentDaoModule;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = {StudentDaoModule.class, ObjectMapperModule.class, DynamoDBModule.class})
public interface UserComponent {
  void inject(UserServiceHandler userServiceHandler);
}
