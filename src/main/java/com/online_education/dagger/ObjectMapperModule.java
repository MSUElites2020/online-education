package com.online_education.dagger;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class ObjectMapperModule {
  @Provides
  @Singleton
  ObjectMapper provideObjectMapper() {
    return new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }
}
