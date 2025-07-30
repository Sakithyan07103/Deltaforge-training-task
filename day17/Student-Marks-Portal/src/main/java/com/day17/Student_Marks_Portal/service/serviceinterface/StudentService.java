package com.day17.Student_Marks_Portal.service.serviceinterface;


import com.day17.Student_Marks_Portal.dto.StudentsDTO;
import com.day17.Student_Marks_Portal.model.Students;

import java.util.List;

public interface StudentService {
    public Students createStudent(StudentsDTO studentsDTO);

     List<Students> getAllStudents();

    public Students getStudentById(int id);
}
