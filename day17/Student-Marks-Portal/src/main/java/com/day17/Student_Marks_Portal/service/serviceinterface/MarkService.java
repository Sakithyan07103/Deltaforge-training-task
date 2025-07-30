package com.day16.students_mark_portal.service.serviceinterface;

import com.day16.students_mark_portal.dto.MarksDTO;
import com.day16.students_mark_portal.model.Marks;

import java.util.List;

public interface MarkService {
    public Marks createMarks(MarksDTO marksDTO);

    public List<Marks> getAllMarks();

    public Marks getMarksById(int id);

    public Marks updateMarks(MarksDTO marksDTO);

    public boolean deleteMarks(int id);
}
