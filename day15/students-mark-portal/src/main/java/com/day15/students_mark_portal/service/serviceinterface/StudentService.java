package com.day15.students_mark_portal.service.serviceinterface;

import com.day15.students_mark_portal.dto.StudentsDTO;
import com.day15.students_mark_portal.model.Students;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentService {
    public Students createStudent(StudentsDTO studentsDTO);

     List<Students> getAllStudents();

    public Students getStudentById(int id);
}
