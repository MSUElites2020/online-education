package com.online_education.dao.student;

import dagger.Binds;
import dagger.Module;

/**
 * @auther fangboyang
 */
@Module
public abstract class StudentDaoModule {
  @Binds
  abstract StudentDao studentDaoImpl(StudentDaoImpl studentDao);
}
