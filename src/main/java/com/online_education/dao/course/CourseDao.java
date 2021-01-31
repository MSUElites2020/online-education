package com.online_education.dao.course;

/**
 * @auther fansun
 */
public interface CourseDao {
  void create(Course course);
  Course get(String id);
  void update(Course course);
}
