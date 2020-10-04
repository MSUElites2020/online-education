package com.online_education.user.server;

import com.online_education.dagger.AWSResourceModule.DynamoDBModule;
import com.online_education.dagger.ObjectMapperModule;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = {DynamoDBModule.class, ObjectMapperModule.class})
public interface UserComponent {
  void inject(UserServiceHandler userServiceHandler);
}
