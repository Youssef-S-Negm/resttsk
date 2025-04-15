package com.youssef.resttsk.util;

import com.youssef.resttsk.entity.Course;

import java.util.ArrayList;
import java.util.List;

public class FirstCourseRecommender implements CourseRecommender {

    private ArrayList<Course> courses = new ArrayList<>(2);

    public FirstCourseRecommender() {
        courses.add(new Course(1, "Introduction to Java Programming"));
        courses.add(new Course(2, "Introduction to Spring framework"));
    }

    @Override
    public List<Course> recommendedCourses() {
        return courses;
    }
}
