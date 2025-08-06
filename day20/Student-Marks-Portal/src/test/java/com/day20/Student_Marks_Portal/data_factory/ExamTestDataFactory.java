package com.day20.Student_Marks_Portal.data_factory;

import com.day20.Student_Marks_Portal.model.Exams;

public class ExamTestDataFactory {

    public static Exams createExam(int id, String name) {
        Exams exam = new Exams();
        exam.setExamId(id);
        exam.setExamName(name);
        return exam;
    }

    public static Exams createDefaultExam() {
        return createExam(1, "Midterm Exam");
    }
}
