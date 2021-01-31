package com.online_education.course.server;

import com.online_education.dagger.AWSResourceModule.DynamoDBModule;
import com.online_education.dagger.ObjectMapperModule;
import com.online_education.dao.course.CourseDaoModule;
import dagger.Component;
import javax.inject.Singleton;

/**
 * @auther fansun
 */
@Singleton
@Component(modules = {
    CourseDaoModule.class,
    ObjectMapperModule.class,
    DynamoDBModule.class})
public interface CourseComponent {
  void inject(CourseServiceHandler courseServiceHandler);
}
