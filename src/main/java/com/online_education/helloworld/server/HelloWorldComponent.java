package com.online_education.helloworld.server;

import dagger.Component;
import javax.inject.Singleton;

/** @auther fangboyang hehehe */
@Singleton
@Component
public interface HelloWorldComponent {
  void inject(HelloWorldServiceHandler helloWorldServiceHandler);
}
