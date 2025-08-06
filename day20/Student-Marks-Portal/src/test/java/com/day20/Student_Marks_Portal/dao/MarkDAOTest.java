package com.day20.Student_Marks_Portal.dao;

import com.day20.Student_Marks_Portal.data_factory.MarksTestDataFactory;
import com.day20.Student_Marks_Portal.model.Marks;
import com.day20.Student_Marks_Portal.repo.MarkRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class MarkDAOTest {
    private MarkRepository markRepository;
    private MarkDAO markDAO;

    @BeforeEach
    void setUp() {
        markRepository = mock(MarkRepository.class);
        markDAO = new MarkDAO();
        var markRepoField = MarkDAO.class.getDeclaredFields()[0];
        markRepoField.setAccessible(true);
        try {
            markRepoField.set(markDAO, markRepository);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void test_Save() {
        Marks mark = MarksTestDataFactory.createDefaultMarks();

        when(markRepository.save(any(Marks.class))).thenReturn(mark);

        Marks resultMark = markDAO.save(mark);

        assertNotNull(resultMark);
        assertEquals(1, resultMark.getId());
    }

    @Test
    void test_FinaAll() {
        Marks marks1 = MarksTestDataFactory.createDefaultMarks();
        Marks marks2 = MarksTestDataFactory.createDefaultMarks();
        when(markRepository.findAll()).thenReturn(Arrays.asList(marks1, marks2));

        List<Marks> markList = markDAO.findAll();
        Assertions.assertEquals(2, markList.size());
        verify(markRepository, times(1)).findAll();
    }



    @Test
    void test_ExistById() {
        when(markRepository.existsById(1)).thenReturn(true);

        boolean exist = markDAO.existsById(1);

        assertTrue(exist);
        verify(markRepository, times(1)).existsById(1);
    }

    @Test
    void test_FindById_Found() {
        Marks marks = MarksTestDataFactory.createDefaultMarks();

        when(markRepository.findById(1)).thenReturn(Optional.of(marks));

        Optional<Marks> result = markDAO.findById(1);
        assertTrue(result.isPresent());
        assertEquals(1, result.get().getId());
        verify(markRepository, times(1)).findById(1);
    }

    @Test
    void test_FindById_NotFound() {
        when(markRepository.findById(1)).thenReturn(Optional.empty());

        Optional<Marks> result = markDAO.findById(1);

        assertFalse(result.isPresent());
        verify(markRepository, times(1)).findById(1);
    }

    void test_DeleteById() {
        doNothing().when(markRepository).deleteById(1);

        markDAO.deleteById(1);

        verify(markRepository, times(1)).deleteById(1);
    }
}