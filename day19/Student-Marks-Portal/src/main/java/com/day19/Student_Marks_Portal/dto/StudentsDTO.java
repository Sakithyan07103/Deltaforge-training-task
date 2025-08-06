package com.day19.Student_Marks_Portal.dto;

import com.day19.Student_Marks_Portal.validation.SchoolEmail;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StudentsDTO {

    @NotNull(message = "Student id cannot be null")
    private int stdId;

    private String stdName;

    @NotNull(message = "Mail id cannot be null")
    @SchoolEmail(message = "Mail id should end with @ves.edu")
    private int stdEmail;
}
