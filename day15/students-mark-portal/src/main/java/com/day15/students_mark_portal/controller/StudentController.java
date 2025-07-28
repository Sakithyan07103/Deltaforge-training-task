package com.day15.students_mark_portal.controller;

import com.day15.students_mark_portal.dto.StudentsDTO;
import com.day15.students_mark_portal.mapper.StudentsMapper;
import com.day15.students_mark_portal.model.Students;
import com.day15.students_mark_portal.service.impls.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/std")
public class StudentController {
    @Autowired
    StudentServiceImpl studentService;

//    @Autowired
//    StudentsMapper studentsMapper;

    @PostMapping("")
    public Students createStudent(@RequestBody StudentsDTO studentsDTO) {
        return studentService.createStudent(studentsDTO);
    }

    @GetMapping("")
    public List<Students> getAllStudents() {
        List<Students> students = new ArrayList<>();
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Students getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/{stdName}")
    public Students getStudentByName(@PathVariable String stdName) {
        return studentService.getStudentByName(stdName);
    }

    @PutMapping("")
    public Students updateStudent(@RequestBody StudentsDTO studentsDTO) {
        return studentService.updateStudent(studentsDTO);
    }

    @DeleteMapping("/{id}")
    public boolean deleteStudent(@PathVariable int id) {
        return studentService.deleteStudent(id);
    }
}
