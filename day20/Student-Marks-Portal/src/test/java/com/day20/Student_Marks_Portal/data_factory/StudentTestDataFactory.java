package com.day20.Student_Marks_Portal.data_factory;

import com.day20.Student_Marks_Portal.model.Students;

public class StudentTestDataFactory {

    public static Students createStudent(int id, String name, int roll) {
        Students student = new Students();
        student.setStdId(id);
        student.setStdName(name);
        student.setStdRoll(roll);
        return student;
    }

    public static Students createDefaultStudent() {
        return createStudent(1, "John Doe", 101);
    }
}
