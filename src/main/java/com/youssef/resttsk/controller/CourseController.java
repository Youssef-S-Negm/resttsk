package com.youssef.resttsk.controller;

import com.youssef.resttsk.entity.Course;
import com.youssef.resttsk.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.findAll();
    }

    @GetMapping("/{courseId}")
    public Course getCourseById(@PathVariable long courseId) {
        return courseService.findById(courseId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> createCourse(@RequestBody Course course) {
        Course addedCourse = courseService.addCourse(course);

        return entityWithLocation(addedCourse.getId());
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCourse(@RequestBody Course course) {
        courseService.updateCourse(course);
    }

    @DeleteMapping("/{courseId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable long courseId) {
        courseService.deleteCourse(courseId);
    }

    private ResponseEntity<Void> entityWithLocation(Object reference) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{itemId}")
                .buildAndExpand(reference)
                .toUri();

        return ResponseEntity.created(uri).build();
    }
}
