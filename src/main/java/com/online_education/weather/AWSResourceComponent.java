/**
 * Copyright (C) 2020 Urban Compass, Inc.
 */
package com.online_education.weather;

import javax.inject.Singleton;

import com.online_education.dagger.AWSResourceModule.DynamoDBModule;
import dagger.Component;

/**
 * @author fangboyang
 */
@Singleton
@Component (modules = DynamoDBModule.class)
interface AWSResourceComponent {
  void inject(WeatherEventLambda weatherEventLambda);
  void inject(WeatherQueryLambda weatherQueryLambda);
}
