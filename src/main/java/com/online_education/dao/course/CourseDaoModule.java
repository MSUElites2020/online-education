package com.online_education.dao.course;

import dagger.Binds;
import dagger.Module;

/**
 * @auther fansun
 */
@Module
public abstract class CourseDaoModule {
  @Binds
  abstract CourseDao courseDaoImpl(CourseDaoImpl courseDao);
}
