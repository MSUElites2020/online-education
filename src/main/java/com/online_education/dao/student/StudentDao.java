package com.online_education.dao.student;

/**
 * @auther fangboyang
 */
public interface StudentDao {
  void create(Student student);
  Student get(String userName);
  void update(Student student);
}
