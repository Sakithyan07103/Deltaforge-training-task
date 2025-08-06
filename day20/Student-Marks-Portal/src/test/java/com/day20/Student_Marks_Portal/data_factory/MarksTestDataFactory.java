package com.day20.Student_Marks_Portal.data_factory;

import com.day20.Student_Marks_Portal.model.Marks;
import com.day20.Student_Marks_Portal.model.Exams;
import com.day20.Student_Marks_Portal.model.Students;
import com.day20.Student_Marks_Portal.model.Subjects;

public class MarksTestDataFactory {

    public static Marks createMarks(int id, Students student, Subjects subject, Exams exam, int score) {
        Marks mark = new Marks();
        mark.setId(id);
        mark.setStudents(student);
        mark.setSubjects(subject);
        mark.setExams(exam);
        mark.setScore(score);
        return mark;
    }

    public static Marks createDefaultMarks() {
        Students student = StudentTestDataFactory.createDefaultStudent();
        Subjects subject = SubjectTestDataFactory.createDefaultSubject();
        Exams exam = ExamTestDataFactory.createDefaultExam();
        return createMarks(1, student, subject, exam, 85);
    }
}
