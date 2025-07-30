package com.day17.Student_Marks_Portal.mapper;


import com.day17.Student_Marks_Portal.dto.StudentsDTO;
import com.day17.Student_Marks_Portal.model.Students;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentsMapper {

    StudentsDTO toStudentsDTO(Students student);

    List<StudentsDTO> toStudentsDTO(List<Students> students);

    Students toStudentsEntity(StudentsDTO studentsDto);
}
