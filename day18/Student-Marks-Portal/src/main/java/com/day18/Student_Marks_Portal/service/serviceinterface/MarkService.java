package com.day18.Student_Marks_Portal.service.serviceinterface;


import com.day18.Student_Marks_Portal.dto.MarksDTO;
import com.day18.Student_Marks_Portal.model.Marks;

import java.util.List;

public interface MarkService {
    public Marks createMarks(MarksDTO marksDTO);

    public List<Marks> getAllMarks();

    public Marks getMarksById(int id);

    public Marks updateMarks(MarksDTO marksDTO);

    public boolean deleteMarks(int id);
}
