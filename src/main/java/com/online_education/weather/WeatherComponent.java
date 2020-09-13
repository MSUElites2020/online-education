package com.online_education.weather;

import com.online_education.dagger.AWSResourceModule.DynamoDBModule;
import com.online_education.dagger.ObjectMapperModule;
import dagger.Component;
import javax.inject.Singleton;

/**
 * @author fangboyang
 *
 * Dagger component to manage dependency injections for the weather service.
 */
@Singleton
@Component (modules = {DynamoDBModule.class, ObjectMapperModule.class})
interface WeatherComponent {
  void inject(WeatherServiceHandler weatherServiceHandler);
}
