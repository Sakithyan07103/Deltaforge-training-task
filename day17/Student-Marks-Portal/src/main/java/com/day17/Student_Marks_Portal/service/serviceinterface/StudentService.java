package com.day16.students_mark_portal.service.serviceinterface;

import com.day16.students_mark_portal.dto.StudentsDTO;
import com.day16.students_mark_portal.model.Students;

import java.util.List;

public interface StudentService {
    public Students createStudent(StudentsDTO studentsDTO);

     List<Students> getAllStudents();

    public Students getStudentById(int id);
}
