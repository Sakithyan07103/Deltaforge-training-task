package com.day20.Student_Marks_Portal.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentsDTO {
    private int stdId;
    private String stdName;
    private int stdRoll;
}
