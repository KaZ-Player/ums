package com.example.ums.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ums.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}