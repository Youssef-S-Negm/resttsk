package com.youssef.resttsk.dao;

import com.youssef.resttsk.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseRepositoryImpl implements CourseRepository {

    private final List<Course> courses;
    private long courseId; // an attribute to avoid ID collision

    public CourseRepositoryImpl(List<Course> courses) {
        this.courses = courses;
        this.courseId = courses.size();
    }

    @Override
    public Course findById(long id) {
        Course result = null;

        for(Course course : courses) {
            if (course.getId() == id) {
                result = course;
                break;
            }
        }

        return result;
    }

    @Override
    public Course addCourse(Course course) {
        course.setId(++courseId);
        courses.add(course);

        return course;
    }

    @Override
    public void updateCourse(Course course) {
        for (int i = 0; i < courses.size(); i++) {
            Course currentCourse = courses.get(i);

            if (currentCourse.getId() == course.getId()) {
                courses.set(i, course);
                break;
            }
        }
    }

    @Override
    public void deleteCourse(Course course) {
        for (int i = 0; i < courses.size(); i++) {
            Course currentCourse = courses.get(i);

            if (currentCourse.getId() == course.getId()) {
                courses.remove(i);
                break;
            }
        }
    }

    @Override
    public List<Course> findAll() {
        return courses;
    }
}
