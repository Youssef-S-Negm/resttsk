package com.youssef.resttsk.config;

import com.youssef.resttsk.entity.Course;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public List<Course> courses() {
        ArrayList<Course> courses = new ArrayList<>(4);

        courses.add(new Course(1, "Introduction to Java Programming"));
        courses.add(new Course(2, "Introduction to Spring Boot"));
        courses.add(new Course(3, "Introduction to AI and Machine Learning"));
        courses.add(new Course(4, "Introduction to Kotlin"));

        return courses;
    }
}
