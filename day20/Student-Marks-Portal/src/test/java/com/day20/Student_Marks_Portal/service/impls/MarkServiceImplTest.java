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
import jakarta.persistence.EntityNotFoundException;
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
    void createMarksShouldCreateMarksSuccessfully() {
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
    void getAllMArksSuccessfully() {

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

    @Test
    void getMarksByIdSuccessfully() {
        Students students = new Students();
        students.setStdId(1);

        Subjects subjects = new Subjects();
        subjects.setSubId(3);

        Exams exams = new Exams();
        exams.setExamId(2);

        Marks marks1 = new Marks();
        marks1.setId(1);
        marks1.setStudents(students);
        marks1.setSubjects(subjects);
        marks1.setExams(exams);
        marks1.setScore(95);

        Marks marks2 = new Marks();
        marks2.setId(2);
        marks2.setStudents(students);
        marks2.setSubjects(subjects);
        marks2.setExams(exams);
        marks2.setScore(85);

        Mockito.when(markDAO.findById(marks1.getId())).thenReturn(Optional.of(marks1));
        Mockito.when(markDAO.findById(marks2.getId())).thenReturn(Optional.of(marks2));

        Marks result1 = markService.getMarksById(marks1.getId());
        Marks result2 = markService.getMarksById(marks2.getId());

        Assertions.assertEquals(marks1.getId(), result1.getId());
        Assertions.assertEquals(marks2.getId(), result2.getId());
        Assertions.assertEquals(students.getStdId(), result1.getStudents().getStdId());
        Assertions.assertEquals(students.getStdId(), result2.getStudents().getStdId());
        Assertions.assertEquals(subjects.getSubId(), result1.getSubjects().getSubId());
        Assertions.assertEquals(subjects.getSubId(), result2.getSubjects().getSubId());
        Assertions.assertEquals(exams.getExamId(), result1.getExams().getExamId());
        Assertions.assertEquals(exams.getExamId(), result2.getExams().getExamId());
    }

    @Test
    void getMarksByIdNotFound() {
        int nonExistentId = 99;

        Mockito.when(markDAO.findById(nonExistentId)).thenReturn(Optional.empty());

        EntityNotFoundException thrown = Assertions.assertThrows(
                EntityNotFoundException.class,
                () -> markService.getMarksById(nonExistentId),
                "Expected getMarksById() to throw, but it didn't"
        );

        Assertions.assertTrue(thrown.getMessage().contains(nonExistentId + "is not found"));
    }


    @Test
    void updateMarksSuccessfully() {
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

        Mockito.when(markDAO.findById(1)).thenReturn(Optional.of(marks));
        Mockito.when(studentDAO.findById(3)).thenReturn(Optional.of(students));
        Mockito.when(subjectDAO.findById(2)).thenReturn(Optional.of(subjects));
        Mockito.when(examDAO.findById(1)).thenReturn(Optional.of(exam));
        Mockito.when(markDAO.save(Mockito.any(Marks.class))).thenReturn(marks);

        Marks markResult = markService.updateMarks(marksDTO);

        Assertions.assertNotNull(markResult);
        Assertions.assertEquals(marksDTO.getId(), markResult.getId());
        Assertions.assertEquals(marksDTO.getStudentId(), markResult.getStudents().getStdId());
        Assertions.assertEquals(marksDTO.getSubjectId(), markResult.getSubjects().getSubId());
        Assertions.assertEquals(marksDTO.getExamsId(), markResult.getExams().getExamId());
    }

    @Test
    void updateMarksThrowsWhenStudentNotFound() {
        MarksDTO dto = new MarksDTO();
        dto.setId(1);
        dto.setStudentId(10);
        dto.setSubjectId(20);
        dto.setExamsId(30);

        Marks existingMark = new Marks();
        existingMark.setId(1);

        Mockito.when(markDAO.findById(1)).thenReturn(Optional.of(existingMark));
        Mockito.when(studentDAO.findById(10)).thenReturn(Optional.empty());

        EntityNotFoundException thrown = Assertions.assertThrows(
                EntityNotFoundException.class,
                () -> markService.updateMarks(dto)
        );

        Assertions.assertTrue(thrown.getMessage().contains("No student with ID number: 10"));
    }

    @Test
    void updateMarksThrowsWhenMarksNotFound() {
        MarksDTO dto = new MarksDTO();
        dto.setId(1);
        dto.setStudentId(10);
        dto.setSubjectId(20);
        dto.setExamsId(30);

        Mockito.when(markDAO.findById(1)).thenReturn(Optional.empty());

        EntityNotFoundException thrown = Assertions.assertThrows(
                EntityNotFoundException.class,
                () -> markService.updateMarks(dto)
        );

        Assertions.assertTrue(thrown.getMessage().contains("1is not found, can't be updated"));
    }

    @Test
    void deleteMarksSuccessfully() {
        int id = 1;

        Mockito.when(markDAO.existsById(id)).thenReturn(true);

        boolean result = markService.deleteMarks(id);

        Assertions.assertTrue(result);
        Mockito.verify(markDAO).deleteById(id);
    }

    @Test
    void deleteMarksThrowsWhenNotFound() {
        int id = 1;

        Mockito.when(markDAO.existsById(id)).thenReturn(false);

        EntityNotFoundException thrown = Assertions.assertThrows(
                EntityNotFoundException.class,
                () -> markService.deleteMarks(id)
        );

        Assertions.assertTrue(thrown.getMessage().contains("1 is not found, can't be deleted"));
    }


}