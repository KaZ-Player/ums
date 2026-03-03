package com.example.ums.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ums.entity.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}