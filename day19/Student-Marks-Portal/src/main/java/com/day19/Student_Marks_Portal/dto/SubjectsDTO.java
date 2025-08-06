package com.day19.Student_Marks_Portal.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SubjectsDTO {

    @NotNull(message = "Subject id cannot be null")
    private int subId;
    private String subName;
}
