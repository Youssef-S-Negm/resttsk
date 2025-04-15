package com.youssef.resttsk.util;

import com.youssef.resttsk.entity.Course;

import java.util.ArrayList;
import java.util.List;

public class SecondCourseRecommender implements CourseRecommender {

    private final ArrayList<Course> courses = new ArrayList<>(2);

    public SecondCourseRecommender() {
        courses.add(new Course(3, "Introduction to Kotlin"));
        courses.add(new Course(4, "Introduction to AI and machine learning"));
    }

    @Override
    public List<Course> recommendedCourses() {
        return courses;
    }

}
