package com.day20.Student_Marks_Portal.controller;

import com.day20.Student_Marks_Portal.dto.MarksDTO;
import com.day20.Student_Marks_Portal.model.Marks;
import com.day20.Student_Marks_Portal.service.impls.MarkServiceImpl;
import com.day20.Student_Marks_Portal.data_factory.MarksTestDataFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MarksControllerTest {

    @Autowired
    private MarkServiceImpl markService;
    private MarksController marksController;

    private Marks marks;
    private MarksDTO marksDTO;

    @BeforeEach
    void setUp() {
        markService = mock(MarkServiceImpl.class);
        marksController = new MarksController(markService);

        marks = MarksTestDataFactory.createDefaultMarks();

        marksDTO = MarksDTO.builder()
                .id(1)
                .studentId(3)
                .subjectId(2)
                .examsId(1)
                .score(75)
                .build();
    }

    @Test
    void test_CreateMarks_Successfully() {
        when(markService.createMarks(marksDTO)).thenReturn(marks);

        Marks result = marksController.createMarks(marksDTO);

        assertNotNull(result);
        assertEquals(1, result.getId());
        verify(markService, times(1)).createMarks(marksDTO);
    }

    @Test
    void test_GetAllMarks_Successfully() {
        List<Marks> mockList = List.of(marks);
        when(markService.getAllMarks()).thenReturn(mockList);

        List<Marks> result = marksController.getAllMarks();

        assertEquals(1, result.size());
        verify(markService, times(1)).getAllMarks();
    }

    @Test
    void test_GetMarksById_Successfully() {
        when(markService.getMarksById(1)).thenReturn(marks);

        Marks result = marksController.getMarksById(1);

        assertNotNull(result);
        assertEquals(1, result.getId());
        verify(markService, times(1)).getMarksById(1);
    }

    @Test
    void test_UpdateMarks_Successfully() {
        when(markService.updateMarks(marksDTO)).thenReturn(marks);

        Marks result = marksController.updateMarks(marksDTO);

        assertNotNull(result);
        assertEquals(1, result.getId());
        verify(markService, times(1)).updateMarks(marksDTO);
    }

    @Test
    void test_DeleteMarks_Successfully() {
        when(markService.deleteMarks(1)).thenReturn(true);

        boolean result = marksController.deleteMarks(1);

        assertTrue(result);
        verify(markService, times(1)).deleteMarks(1);
    }
}

