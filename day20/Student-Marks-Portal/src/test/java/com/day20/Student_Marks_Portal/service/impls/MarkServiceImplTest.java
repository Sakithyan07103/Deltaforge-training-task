package com.day20.Student_Marks_Portal.service.impls;

import com.day20.Student_Marks_Portal.dao.ExamDAO;
import com.day20.Student_Marks_Portal.dao.MarkDAO;
import com.day20.Student_Marks_Portal.dao.StudentDAO;
import com.day20.Student_Marks_Portal.dao.SubjectDAO;
import com.day20.Student_Marks_Portal.dto.MarksDTO;
import com.day20.Student_Marks_Portal.model.Exams;
import com.day20.Student_Marks_Portal.model.Marks;
import com.day20.Student_Marks_Portal.model.Students;
import com.day20.Student_Marks_Portal.model.Subjects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class MarkServiceImplTest {

    @Mock
    MarkDAO markDAO;

    @Mock
    StudentDAO studentDAO;

    @Mock
    SubjectDAO subjectDAO;

    @Mock
    ExamDAO examDAO;

    @InjectMocks
    MarkServiceImpl markService;

    @Test
    void createMarksShouldCreateMarksSucsessfully() {
        MarksDTO marksDTO = new MarksDTO();
        marksDTO.setId(1);
        marksDTO.setExamsId(1);
        marksDTO.setSubjectId(2);
        marksDTO.setStudentId(3);
        marksDTO.setScore(75);

        Exams exam = new Exams();
        exam.setExamId(1);

        Subjects subjects = new Subjects();
        subjects.setSubId(2);

        Students students = new Students();
        students.setStdId(3);

        Marks marks = new Marks();
        marks.setId(1);
        marks.setExams(exam);
        marks.setSubjects(subjects);
        marks.setStudents(students);
        marks.setScore(75);

        Mockito.when(studentDAO.findById(3)).thenReturn(Optional.of(students));
        Mockito.when(subjectDAO.findById(2)).thenReturn(Optional.of(subjects));
        Mockito.when(examDAO.findById(1)).thenReturn(Optional.of(exam));
        Mockito.when(markDAO.save(Mockito.any(Marks.class))).thenReturn(marks);

        Marks mark = markService.createMarks(marksDTO);

        Assertions.assertEquals(marks.getId(), mark.getId());
    }

    @Test
    void getAllMArks() {

        Students students = new Students();
        students.setStdId(1);

        Subjects subjects = new Subjects();
        subjects.setSubId(2);

        Exams exams = new Exams();
        exams.setExamId(1);

        Marks marks1 = new Marks();
        marks1.setId(1);
        marks1.setStudents(students);
        marks1.setExams(exams);
        marks1.setSubjects(subjects);

        Marks marks2 = new Marks();
        marks2.setId(2);
        marks2.setStudents(students);
        marks2.setExams(exams);
        marks2.setSubjects(subjects);

        List<Marks> getAllMarksList = Arrays.asList(marks1, marks2);

        Mockito.when(markDAO.findAll()).thenReturn(getAllMarksList);

        List<Marks> resultList = markService.getAllMarks();

        Assertions.assertEquals(getAllMarksList.size(), resultList.size());
        Assertions.assertEquals(marks1.getId(), resultList.get(0).getId());
        Assertions.assertEquals(marks2.getId(), resultList.get(1).getId());
        Assertions.assertEquals(students.getStdId(), resultList.get(0).getStudents().getStdId());
        Assertions.assertEquals(students.getStdId(), resultList.get(1).getStudents().getStdId());
        Assertions.assertEquals(subjects.getSubId(), resultList.get(0).getSubjects().getSubId());
        Assertions.assertEquals(subjects.getSubId(), resultList.get(1).getSubjects().getSubId());
        Assertions.assertEquals(exams.getExamId(), resultList.get(0).getExams().getExamId());
        Assertions.assertEquals(exams.getExamId(), resultList.get(1).getExams().getExamId());
    }
}