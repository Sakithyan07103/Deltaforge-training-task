package com.day14.students_mark_portal.service;

import com.day14.students_mark_portal.dao.StudentDao;
import com.day14.students_mark_portal.model.Students;
import com.day14.students_mark_portal.service.serviceinterface.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao dao;

    public Students createStudent(String name, int roll) {
        Students std = new Students();
        std.setStdName(name);
        std.setStdRoll(roll);
        return dao.save(std);
    }

    public List<Students> getAllStudents() {
        return dao.findAll();
    }

    public Optional<Students> getStudentById(int id) {
        return Optional.ofNullable(dao.findById(id).orElseThrow(() -> new RuntimeException(id + "is not found")));
    }
}
