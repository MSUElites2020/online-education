/**
 * Copyright (C) 2020 Urban Compass, Inc.
 */
package com.online_education.user;

import com.online_education.dagger.AWSResourceModule.DynamoDBModule;
import com.online_education.dagger.ObjectMapperModule;
import dagger.Component;
import javax.inject.Singleton;

/**
 * @auther fansun
 */
@Singleton
@Component(modules = {DynamoDBModule.class, ObjectMapperModule.class})
public interface UserComponent {
  void inject(UserServiceHandler userServiceHandler);
}
