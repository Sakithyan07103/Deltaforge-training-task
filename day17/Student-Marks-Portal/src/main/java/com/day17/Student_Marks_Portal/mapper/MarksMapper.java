package com.day17.Student_Marks_Portal.mapper;


import com.day17.Student_Marks_Portal.dto.MarksDTO;
import com.day17.Student_Marks_Portal.model.Marks;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MarksMapper {

    MarksDTO toMarksDTO(Marks mark);

    List<MarksDTO> toMarksDTOs(List<Marks> marks);

    Marks toMark(MarksDTO marksDTO);

    List<Marks> toMarks(List<MarksDTO> marksDTOS);

}
