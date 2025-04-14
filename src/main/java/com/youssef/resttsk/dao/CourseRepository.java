package com.youssef.resttsk.dao;

import com.youssef.resttsk.entity.Course;

import java.util.List;

public interface CourseRepository {

    Course findById(long id);

    void addCourse(Course course);

    void updateCourse(Course course);

    void deleteCourse(Course course);

    List<Course> findAll();

}
