package com.day16.students_mark_portal.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
