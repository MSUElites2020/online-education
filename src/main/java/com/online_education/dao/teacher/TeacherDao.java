package com.online_education.dao.teacher;

import java.util.List;

/**
 * @auther fansun
 */
public interface TeacherDao {
  void create(Teacher teacher);
  Teacher get(String userName);
  void update(Teacher teacher);
  List<Teacher> scan();
}
