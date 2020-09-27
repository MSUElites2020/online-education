package com.online_education.user.server;

import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component
public interface UserComponent {
  void inject(UserServiceHandler userServiceHandler);
}
