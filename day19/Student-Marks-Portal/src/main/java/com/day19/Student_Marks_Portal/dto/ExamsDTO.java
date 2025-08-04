package com.day19.Student_Marks_Portal.dto;

import lombok.Data;

@Data
public class ExamsDTO {
    private int examId;

    private String examName;

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }
}
