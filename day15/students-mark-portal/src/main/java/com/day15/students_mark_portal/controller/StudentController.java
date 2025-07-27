package com.day15.students_mark_portal.controller;


import com.day15.students_mark_portal.model.Students;
import com.day15.students_mark_portal.service.impls.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/std")
public class StudentController {
    @Autowired
    StudentServiceImpl service;

    @PostMapping("/{name}/{roll}")
    public Students createStudent(@PathVariable String name, @PathVariable int roll) {
        return service.createStudent(name, roll);
    }

    @PostMapping("/{id}/{name}/{roll}")
    public Students createStudentWithId(@PathVariable int id, @PathVariable String name, @PathVariable int roll) {
        return service.createStudentWithId(id, name, roll);
    }

    @GetMapping("")
    public List<Students> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/id/{id}")
    public Optional<Students> getStudentById(@PathVariable int id) {
        return service.getStudentById(id);
    }

    @GetMapping("/name/{stdName}")
    public Optional<Students> getStudentByName(@PathVariable String stdName) {
        return service.getStudentByName(stdName);
    }

    @PutMapping("/{id}/{name}/{roll}")
    public Optional<Students> updateStudent(@PathVariable int id, @PathVariable String name, @PathVariable int roll) {
        return service.updateStudent(id, name, roll);
    }

    @DeleteMapping("/{id}")
    public boolean deleteStudent(@PathVariable int id) {
        return service.deleteStudent(id);
    }
}
