package com.youssef.resttsk.service;

import com.youssef.resttsk.entity.Course;

import java.util.List;

public interface CourseService {

    Course findById(long id);

    Course addCourse(Course course);

    void updateCourse(Course course);

    void deleteCourse(long id);

    List<Course> findAll();

}
