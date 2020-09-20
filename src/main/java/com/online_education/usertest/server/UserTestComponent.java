package com.online_education.usertest.server;

import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component
public interface UserTestComponent {
  void inject(UserTestServiceHandler usertestServiceHandler);
}
