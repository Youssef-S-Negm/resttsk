package com.youssef.resttsk.service;

import com.youssef.resttsk.dao.CourseRepository;
import com.youssef.resttsk.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course findById(long id) {
        return courseRepository.findById(id);
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.addCourse(course);
    }

    @Override
    public void updateCourse(Course course) {
        courseRepository.updateCourse(course);
    }

    @Override
    public void deleteCourse(long id) {
        Course course = courseRepository.findById(id);

        courseRepository.deleteCourse(course);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }
}
