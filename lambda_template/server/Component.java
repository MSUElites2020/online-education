package com.online_education.${SERVICE_NAME}.server;

import dagger.Component;
import javax.inject.Singleton;

/** @auther fangboyang */
@Singleton
@Component
public interface ${SERVICE_CLASS_NAME}Component {
  void inject(${SERVICE_CLASS_NAME}ServiceHandler ${SERVICE_NAME}ServiceHandler);
}
