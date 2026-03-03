package com.example.ums.service;

import org.springframework.stereotype.Service;
import com.example.ums.repository.*;
import com.example.ums.entity.*;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course save(Course course) {
        return courseRepository.save(course);
    }

    public Course addLesson(Long courseId, Lesson lesson) {
        Course course = courseRepository.findById(courseId).orElseThrow();
        lesson.setCourse(course);
        course.getLessons().add(lesson);
        return courseRepository.save(course);
    }

    public Course getById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }
}