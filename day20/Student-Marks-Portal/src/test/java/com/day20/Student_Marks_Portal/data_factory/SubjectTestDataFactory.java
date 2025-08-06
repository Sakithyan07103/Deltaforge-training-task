package com.day20.Student_Marks_Portal.data_factory;

import com.day20.Student_Marks_Portal.model.Subjects;

public class SubjectTestDataFactory {

    public static Subjects createSubject(int id, String name) {
        Subjects subject = new Subjects();
        subject.setSubId(id);
        subject.setSubName(name);
        return subject;
    }

    public static Subjects createDefaultSubject() {
        return createSubject(1, "Mathematics");
    }
}
