package com.day14.students_mark_portal.controller;

import com.day14.students_mark_portal.model.Students;
import com.day14.students_mark_portal.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/std")
public class StudentController {
    @Autowired
    StudentServiceImpl service;

    @PostMapping("")
    public Students createStudent(@RequestBody Students students) {
        return service.createStudent(students.getStdName() , students.getStdRoll());
    }

    @GetMapping("")
    public List<Students> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Students> getStudentById(@PathVariable int id) {
        return service.getStudentById(id);
    }
}
