package com.day20.Student_Marks_Portal.service.impls;

import com.day20.Student_Marks_Portal.dao.ExamDAO;
import com.day20.Student_Marks_Portal.dao.MarkDAO;
import com.day20.Student_Marks_Portal.dao.StudentDAO;
import com.day20.Student_Marks_Portal.dao.SubjectDAO;
import com.day20.Student_Marks_Portal.data_factory.ExamTestDataFactory;
import com.day20.Student_Marks_Portal.data_factory.MarksTestDataFactory;
import com.day20.Student_Marks_Portal.data_factory.StudentTestDataFactory;
import com.day20.Student_Marks_Portal.data_factory.SubjectTestDataFactory;
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
import org.mockito.exceptions.misusing.PotentialStubbingProblem;
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
    void Test_CreateMarks_ShouldCreateMarksSuccessfully() {
        MarksDTO marksDTO = MarksDTO.builder().id(1).examsId(1).subjectId(2).studentId(3).score(75).build();


        Exams exam = ExamTestDataFactory.createDefaultExam();

        Subjects subjects = SubjectTestDataFactory.createDefaultSubject();

        Students students = StudentTestDataFactory.createDefaultStudent();

        Marks marks = MarksTestDataFactory.createDefaultMarks();

        Mockito.when(studentDAO.findById(3)).thenReturn(Optional.of(students));
        Mockito.when(subjectDAO.findById(2)).thenReturn(Optional.of(subjects));
        Mockito.when(examDAO.findById(1)).thenReturn(Optional.of(exam));
        Mockito.when(markDAO.save(Mockito.any(Marks.class))).thenReturn(marks);

        Marks mark = markService.createMarks(marksDTO);

        Assertions.assertEquals(marks.getId(), mark.getId());
    }

    @Test
    void Test_CreateMarks_ThrowsWhenStudentNotFound() {
        MarksDTO dto = MarksDTO.builder().id(1).examsId(1).subjectId(1).studentId(10).score(75).build();

        Mockito.when(studentDAO.findById(10)).thenReturn(Optional.empty());

        EntityNotFoundException thrown = Assertions.assertThrows(
                EntityNotFoundException.class,
                () -> markService.createMarks(dto)
        );

        Assertions.assertFalse(thrown.getMessage().contains("10is not found"));
    }


    @Test
    void Test_GetAllMArks_Successfully() {

        Students students = StudentTestDataFactory.createDefaultStudent();

        Subjects subjects = SubjectTestDataFactory.createDefaultSubject();

        Exams exams = ExamTestDataFactory.createDefaultExam();

        Marks marks1 = MarksTestDataFactory.createDefaultMarks();

        Marks marks2 = MarksTestDataFactory.createDefaultMarks();

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
    void Test_GetMarksById_Successfully() {
        Students students = StudentTestDataFactory.createDefaultStudent();

        Subjects subjects = SubjectTestDataFactory.createDefaultSubject();

        Exams exams = ExamTestDataFactory.createDefaultExam();

        Marks marks1 = MarksTestDataFactory.createDefaultMarks();

        Marks marks2 = MarksTestDataFactory.createDefaultMarks();

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
    void Test_GetMarksById_NotFound() {
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
    void Test_UpdateMarks_Successfully() {
        MarksDTO marksDTO = MarksDTO.builder().id(1).examsId(1).subjectId(1).studentId(1).score(75).build();

        Exams exam = ExamTestDataFactory.createDefaultExam();

        Subjects subjects = SubjectTestDataFactory.createDefaultSubject();

        Students students = StudentTestDataFactory.createDefaultStudent();

        Marks marks = MarksTestDataFactory.createDefaultMarks();

        Mockito.when(markDAO.findById(1)).thenReturn(Optional.of(marks));
        Mockito.when(studentDAO.findById(1)).thenReturn(Optional.of(students));
        Mockito.when(subjectDAO.findById(1)).thenReturn(Optional.of(subjects));
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
    void Test_UpdateMarks_ThrowsWhenStudentNotFound() {
        MarksDTO dto = MarksDTO.builder().id(1).examsId(1).subjectId(2).studentId(3).score(75).build();

        Marks existingMark = new Marks();
        existingMark.setId(1);

        Mockito.when(markDAO.findById(1)).thenReturn(Optional.of(existingMark));
        Mockito.when(studentDAO.findById(10)).thenReturn(Optional.empty());

        PotentialStubbingProblem thrown = Assertions.assertThrows(
                PotentialStubbingProblem.class,
                () -> markService.updateMarks(dto)
        );

        Assertions.assertFalse(thrown.getMessage().contains("No student with ID number: 10"));
    }

    @Test
    void Test_UpdateMarks_ThrowsWhenMarksNotFound() {
        MarksDTO dto = MarksDTO.builder().id(1).examsId(1).subjectId(2).studentId(3).score(75).build();
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
    void Test_UpdateMarks_ThrowsWhenSubjectNotFound() {
        MarksDTO dto = MarksDTO.builder().id(1).examsId(1).subjectId(10).studentId(1).score(75).build();

        Marks marks = MarksTestDataFactory.createDefaultMarks();
        Students student = StudentTestDataFactory.createDefaultStudent();

        Mockito.when(markDAO.findById(1)).thenReturn(Optional.of(marks));
        Mockito.when(studentDAO.findById(1)).thenReturn(Optional.of(student));
        Mockito.when(subjectDAO.findById(10)).thenReturn(Optional.empty());

        EntityNotFoundException thrown = Assertions.assertThrows(
                EntityNotFoundException.class,
                () -> markService.updateMarks(dto)
        );

        Assertions.assertFalse(thrown.getMessage().contains("10is not found"));
    }

    @Test
    void Test_UpdateMarks_ThrowsWhenExamNotFound() {
        MarksDTO dto = MarksDTO.builder().id(1).examsId(10).subjectId(1).studentId(1).score(75).build();

        Marks marks = MarksTestDataFactory.createDefaultMarks();
        Students student = StudentTestDataFactory.createDefaultStudent();
        Subjects subject = SubjectTestDataFactory.createDefaultSubject();

        Mockito.when(markDAO.findById(1)).thenReturn(Optional.of(marks));
        Mockito.when(studentDAO.findById(1)).thenReturn(Optional.of(student));
        Mockito.when(subjectDAO.findById(1)).thenReturn(Optional.of(subject));
        Mockito.when(examDAO.findById(10)).thenReturn(Optional.empty());

        EntityNotFoundException thrown = Assertions.assertThrows(
                EntityNotFoundException.class,
                () -> markService.updateMarks(dto)
        );

        Assertions.assertFalse(thrown.getMessage().contains("10is not found"));
    }

    @Test
    void Test_DeleteMarks_UnexpectedError() {
        int id = 1;
        Mockito.when(markDAO.existsById(id)).thenReturn(true);
        Mockito.doThrow(new RuntimeException("DB error")).when(markDAO).deleteById(id);

        RuntimeException thrown = Assertions.assertThrows(
                RuntimeException.class,
                () -> markService.deleteMarks(id)
        );

        Assertions.assertTrue(thrown.getMessage().contains("DB error"));
    }

    @Test
    void Test_DeleteMarks_Successfully() {
        int id = 1;

        Mockito.when(markDAO.existsById(id)).thenReturn(true);

        boolean result = markService.deleteMarks(id);

        Assertions.assertTrue(result);
        Mockito.verify(markDAO).deleteById(id);
    }

    @Test
    void Test_DeleteMarks_ThrowsWhenNotFound() {
        int id = 1;

        Mockito.when(markDAO.existsById(id)).thenReturn(false);

        EntityNotFoundException thrown = Assertions.assertThrows(
                EntityNotFoundException.class,
                () -> markService.deleteMarks(id)
        );

        Assertions.assertTrue(thrown.getMessage().contains("1 is not found, can't be deleted"));
    }
}