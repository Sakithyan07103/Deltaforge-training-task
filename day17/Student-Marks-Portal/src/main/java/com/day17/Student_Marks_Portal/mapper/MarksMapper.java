package com.day16.students_mark_portal.mapper;

import com.day16.students_mark_portal.dto.MarksDTO;
import com.day16.students_mark_portal.model.Marks;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MarksMapper {

    MarksDTO toMarksDTO(Marks mark);

    List<MarksDTO> toMarksDTOs(List<Marks> marks);

    Marks toMark(MarksDTO marksDTO);

    List<Marks> toMarks(List<MarksDTO> marksDTOS);

}
