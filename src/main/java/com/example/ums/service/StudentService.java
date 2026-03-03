package com.example.ums.service;

import org.springframework.stereotype.Service;
import com.example.ums.repository.*;
import com.example.ums.entity.*;
import java.util.List;   // ← ВАЖНО

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public StudentService(StudentRepository studentRepository,
                          CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public Student save(Student student) {
        if (student.getProfile() != null) {
            student.getProfile().setStudent(student);
        }
        return studentRepository.save(student);
    }

    public Student assignCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        Course course = courseRepository.findById(courseId).orElseThrow();

        student.getCourses().add(course);
        course.getStudents().add(student);

        return studentRepository.save(student);
    }

    public Student getById(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }
}