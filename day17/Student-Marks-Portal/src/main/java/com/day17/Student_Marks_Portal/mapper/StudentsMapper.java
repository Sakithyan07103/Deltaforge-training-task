package com.day16.students_mark_portal.mapper;

import com.day16.students_mark_portal.dto.StudentsDTO;
import com.day16.students_mark_portal.model.Students;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentsMapper {

    StudentsDTO toStudentsDTO(Students student);

    List<StudentsDTO> toStudentsDTO(List<Students> students);

    Students toStudentsEntity(StudentsDTO studentsDto);
}
