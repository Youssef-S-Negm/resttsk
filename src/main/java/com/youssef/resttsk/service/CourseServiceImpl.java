package com.youssef.resttsk.service;

import com.youssef.resttsk.dao.CourseRepository;
import com.youssef.resttsk.entity.Course;
import com.youssef.resttsk.exception.EntityNotFoundException;
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
        Course course = courseRepository.findById(id);

        if (course == null)
            throw new EntityNotFoundException("Couldn't find course id - " + id);

        return course;
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.addCourse(course);
    }

    @Override
    public void updateCourse(Course course) {
        Course updatedCourse = courseRepository.updateCourse(course);

        if (updatedCourse == null)
            throw new EntityNotFoundException("Couldn't find course id - " + course.getId());
    }

    @Override
    public void deleteCourse(long id) {
        Course course = courseRepository.findById(id);

        if (course == null)
            throw new EntityNotFoundException("Couldn't find course id - " + id);

        courseRepository.deleteCourse(course);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }
}
