package com.day15.students_mark_portal.dto;

import lombok.Data;

@Data
public class MarksDTO {
    private int id;

    private int studentId;

    private int subjectId;

    private int examsId;

    private int score;
}
