package com.example.ums.controller;

import org.springframework.web.bind.annotation.*;
import com.example.ums.service.CourseService;
import com.example.ums.entity.Course;
import com.example.ums.entity.Lesson;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public Course create(@RequestBody Course course) {
        return courseService.save(course);
    }

    @PostMapping("/{courseId}/lessons")
    public Course addLesson(@PathVariable Long courseId,
                            @RequestBody Lesson lesson) {
        return courseService.addLesson(courseId, lesson);
    }

    @GetMapping("/{id}")
    public Course get(@PathVariable Long id) {
        return courseService.getById(id);
    }
}