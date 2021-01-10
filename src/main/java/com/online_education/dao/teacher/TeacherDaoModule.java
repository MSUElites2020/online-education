package com.online_education.dao.teacher;

import dagger.Binds;
import dagger.Module;

/**
 * @auther fansun
 */
@Module
public abstract class TeacherDaoModule {
  @Binds
  abstract TeacherDao teacherDaoImpl(TeacherDaoImpl teacherDao);
}
