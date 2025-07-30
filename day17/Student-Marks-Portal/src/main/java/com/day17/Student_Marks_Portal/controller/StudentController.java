package com.day17.Student_Marks_Portal.controller;


import com.day17.Student_Marks_Portal.dto.StudentsDTO;
import com.day17.Student_Marks_Portal.model.Students;
import com.day17.Student_Marks_Portal.service.impls.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
