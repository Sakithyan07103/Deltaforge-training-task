package com.day20.Student_Marks_Portal.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubjectsDTO {
    private int subId;
    private String subName;
}
