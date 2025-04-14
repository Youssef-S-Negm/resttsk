package com.youssef.resttsk.dao;

import com.youssef.resttsk.entity.Course;

import java.util.List;

public interface CourseRepository {

    Course findById(long id);

    Course addCourse(Course course);

    Course updateCourse(Course course);

    void deleteCourse(Course course);

    List<Course> findAll();

}
