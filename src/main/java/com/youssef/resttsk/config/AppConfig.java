package com.youssef.resttsk.config;

import com.youssef.resttsk.util.CourseRecommender;
import com.youssef.resttsk.util.FirstCourseRecommender;
import com.youssef.resttsk.util.SecondCourseRecommender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

    @Bean
    @Primary
    public CourseRecommender mainCourseRecommender() {
        return new FirstCourseRecommender();
    }

    @Bean
    public CourseRecommender secondaryCourseRecommender() {
        return new SecondCourseRecommender();
    }
}
