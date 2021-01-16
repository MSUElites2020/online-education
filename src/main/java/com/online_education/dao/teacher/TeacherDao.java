package com.online_education.dao.teacher;


/**
 * @auther fansun
 */
public interface TeacherDao {
  void create(Teacher teacher);
  Teacher get(String userName);
  void update(Teacher teacher);
}
