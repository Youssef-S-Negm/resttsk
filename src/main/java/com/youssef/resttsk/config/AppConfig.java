package com.youssef.resttsk.config;

import com.youssef.resttsk.entity.Course;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public List<Course> courses() {
        return List.of(
                new Course(1, "Introduction to Java Programming"),
                new Course(2, "Introduction to Spring Boot"),
                new Course(3, "Introduction to AI and Machine Learning"),
                new Course(4, "Introduction to Kotlin")
        );
    }
}
