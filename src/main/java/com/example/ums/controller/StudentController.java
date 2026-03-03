package com.example.ums.controller;

import org.springframework.web.bind.annotation.*;
import com.example.ums.service.StudentService;
import com.example.ums.entity.Student;
import java.util.List;  // <- обязательно импортировать

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        return studentService.save(student);
    }

    @PostMapping("/{studentId}/courses/{courseId}")
    public Student assign(@PathVariable Long studentId,
                          @PathVariable Long courseId) {
        return studentService.assignCourse(studentId, courseId);
    }

    @GetMapping("/{id}")
    public Student get(@PathVariable Long id) {
        return studentService.getById(id);
    }

    // Вот правильный getAll
    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }
}