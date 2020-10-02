package com.online_education.xueqiu.server;

import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component
public interface XueqiuComponent {
  void inject(XueqiuServiceHandler xueqiuServiceHandler);
}
