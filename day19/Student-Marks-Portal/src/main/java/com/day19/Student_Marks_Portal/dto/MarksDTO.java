package com.day19.Student_Marks_Portal.dto;

import com.day19.Student_Marks_Portal.validation.ValidScore;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MarksDTO {

    @NotNull(message = "Id cannot be null")
    private int id;

    @NotNull(message = "Student id cannot be null")
    private int studentId;

    @NotNull(message = "Subject id cannot be null")
    private int subjectId;

    @NotNull(message = "Exam id cannot be null")
    private int examsId;

    @NotNull(message = "score cannot be null")
    @ValidScore(message = "Score should not be a decimal values and should be less than 100")
    private int score;
}
