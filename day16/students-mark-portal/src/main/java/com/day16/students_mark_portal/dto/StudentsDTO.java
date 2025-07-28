package com.day16.students_mark_portal.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class StudentsDTO {
    private int stdId;

    private String stdName;

    private int stdRoll;

    public int getStdId() {
        return stdId;
    }

    public void setStdId(int stdId) {
        this.stdId = stdId;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public int getStdRoll() {
        return stdRoll;
    }

    public void setStdRoll(int stdRoll) {
        this.stdRoll = stdRoll;
    }
}
