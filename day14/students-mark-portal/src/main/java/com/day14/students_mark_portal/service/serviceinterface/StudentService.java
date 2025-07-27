package com.day14.students_mark_portal.service.serviceinterface;

import com.day14.students_mark_portal.model.Students;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public Students createStudent(String name, int roll);
    public List<Students> getAllStudents();
    public Optional<Students> getStudentById(int id);
}
