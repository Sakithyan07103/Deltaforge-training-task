package com.day17.Student_Marks_Portal.dto;

import lombok.Data;

@Data
public class SubjectsDTO {
    private int subId;

    private String subName;

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }
}
