package com.day16.students_mark_portal.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
