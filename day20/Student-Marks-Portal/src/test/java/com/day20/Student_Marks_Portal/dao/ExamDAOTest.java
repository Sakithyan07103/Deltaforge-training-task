package com.day20.Student_Marks_Portal.dao;

import com.day20.Student_Marks_Portal.data_factory.ExamTestDataFactory;
import com.day20.Student_Marks_Portal.model.Exams;
import com.day20.Student_Marks_Portal.repo.ExamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExamDAOTest {

    private ExamRepository examRepository;
    private ExamDAO examDAO;

    @BeforeEach
    void setUp() {
        examRepository = mock(ExamRepository.class);
        examDAO = new ExamDAO();
        var examRepoField = ExamDAO.class.getDeclaredFields()[0];
        examRepoField.setAccessible(true);
        try {
            examRepoField.set(examDAO, examRepository);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void test_Save() {
        Exams exam = ExamTestDataFactory.createDefaultExam();
        when(examRepository.save(any(Exams.class))).thenReturn(exam);

        Exams result = examDAO.save(exam);

        assertNotNull(result);
        assertEquals(1, result.getExamId());
        verify(examRepository, times(1)).save(exam);
    }

    @Test
    void test_ExistsById() {
        when(examRepository.existsById(1)).thenReturn(true);

        boolean exists = examDAO.existsById(1);

        assertTrue(exists);
        verify(examRepository, times(1)).existsById(1);
    }

    @Test
    void test_FindAll() {
        Exams exam1 = ExamTestDataFactory.createDefaultExam();
        Exams exam2 = ExamTestDataFactory.createDefaultExam();
        when(examRepository.findAll()).thenReturn(Arrays.asList(exam1, exam2));

        List<Exams> exams = examDAO.findAll();

        assertEquals(2, exams.size());
        verify(examRepository, times(1)).findAll();
    }

    @Test
    void test_FindById_Found() {
        Exams exam = ExamTestDataFactory.createDefaultExam();
        when(examRepository.findById(1)).thenReturn(Optional.of(exam));

        Optional<Exams> result = examDAO.findById(1);

        assertTrue(result.isPresent());
        assertEquals(1, result.get().getExamId());
        verify(examRepository, times(1)).findById(1);
    }


    @Test
    void test_FindById_NotFound() {
        when(examRepository.findById(1)).thenReturn(Optional.empty());

        Optional<Exams> result = examDAO.findById(1);

        assertFalse(result.isPresent());
        verify(examRepository, times(1)).findById(1);
    }

    @Test
    void test_DeleteById() {
        doNothing().when(examRepository).deleteById(1);

        examDAO.deleteById(1);

        verify(examRepository, times(1)).deleteById(1);
    }
}