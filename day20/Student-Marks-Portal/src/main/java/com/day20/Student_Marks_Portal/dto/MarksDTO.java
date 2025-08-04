package com.day20.Student_Marks_Portal.dto;

import lombok.Data;

@Data
public class MarksDTO {
    private int id;

    private int studentId;

    private int subjectId;

    private int examsId;

    private int score;
}
