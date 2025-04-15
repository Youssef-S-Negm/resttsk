package com.youssef.resttsk.dao;

import com.youssef.resttsk.entity.Course;
import com.youssef.resttsk.exception.EntityNotFoundException;
import com.youssef.resttsk.util.CourseRecommender;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepositoryImpl implements CourseRepository {

    private final CourseRecommender primaryCourseRecommender;
    private final CourseRecommender secondaryCourseRecommender;
    private final List<Course> allCourses;
    private long courseId; // an attribute to avoid ID collision

    public CourseRepositoryImpl(CourseRecommender primaryCourseRecommender,
                                @Qualifier("secondaryCourseRecommender") CourseRecommender secondaryCourseRecommender) {
        this.primaryCourseRecommender = primaryCourseRecommender;
        this.secondaryCourseRecommender = secondaryCourseRecommender;
        this.allCourses = new ArrayList<>();

        allCourses.addAll(primaryCourseRecommender.recommendedCourses());
        allCourses.addAll(secondaryCourseRecommender.recommendedCourses());

        this.courseId = allCourses.size();
    }

    @Override
    public Course findById(long id) {
        Course result = null;

        for(Course course : allCourses) {
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
        allCourses.add(course);
        primaryCourseRecommender.recommendedCourses().add(course);

        System.out.println(primaryCourseRecommender.recommendedCourses());

        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        Course updatedCourse = updatePrimaryCourses(course);

        if (updatedCourse == null) {
            updatedCourse = updateSecondaryCourses(course);
        }

        if (updatedCourse != null) {
            updateAllCourses(course);
        }

        return updatedCourse;
    }

    private Course updatePrimaryCourses(Course course) {
        List<Course> primaryCourses = primaryCourseRecommender.recommendedCourses();

        for (int i = 0; i < primaryCourses.size(); i++) {
            Course currentCourse = primaryCourses.get(i);

            if (currentCourse.getId() == course.getId()) {
                primaryCourses.set(i, course);
                return course;
            }
        }

        return null;
    }

    private Course updateSecondaryCourses(Course course) {
        List<Course> secondaryCourses = secondaryCourseRecommender.recommendedCourses();

        for (int i = 0; i < secondaryCourses.size(); i++) {
            Course currentCourse = secondaryCourses.get(i);

            if (currentCourse.getId() == course.getId()) {
                secondaryCourses.set(i, course);
                return course;
            }
        }

        return null;
    }

    private void updateAllCourses(Course course) {
        for (int i = 0; i < allCourses.size(); i++) {
            if (course.getId() == allCourses.get(i).getId()) {
                allCourses.set(i, course);
                break;
            }
        }
    }

    @Override
    public void deleteCourse(Course course) {
        Course deletedCourse = deleteFromPrimaryCourses(course);

        if (deletedCourse == null) {
            deletedCourse = deleteFromSecondaryCourses(course);
        }

        if (deletedCourse != null) {
            deleteFromAllCourses(course);
        }
    }

    private Course deleteFromPrimaryCourses(Course course) {
        List<Course> primaryCourses = primaryCourseRecommender.recommendedCourses();

        for (int i = 0; i < primaryCourses.size(); i++) {
            if (primaryCourses.get(i).getId() == course.getId()) {
                primaryCourses.remove(i);
                return course;
            }
        }

        return null;
    }

    private Course deleteFromSecondaryCourses(Course course) {
        List<Course> secondaryCourses = secondaryCourseRecommender.recommendedCourses();

        for (int i = 0; i < secondaryCourses.size(); i++) {
            if (secondaryCourses.get(i).getId() == course.getId()) {
                secondaryCourses.remove(i);
                return course;
            }
        }

        return null;
    }

    private void deleteFromAllCourses(Course course) {
        for (int i = 0; i < allCourses.size(); i++) {
            if (allCourses.get(i).getId() == course.getId()) {
                allCourses.remove(i);
                break;
            }
        }
    }

    @Override
    public List<Course> findAll() {
        return allCourses;
    }
}
