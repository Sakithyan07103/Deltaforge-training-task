package com.day20.Student_Marks_Portal.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MarksDTO {
    private int id;
    private int studentId;
    private int subjectId;
    private int examsId;
    private int score;
}
