package com.day20.Student_Marks_Portal.service.impls;


import com.day20.Student_Marks_Portal.dao.StudentDAO;
import com.day20.Student_Marks_Portal.data_factory.StudentTestDataFactory;
import com.day20.Student_Marks_Portal.dto.StudentsDTO;
import com.day20.Student_Marks_Portal.model.Students;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @Mock
    private StudentDAO studentDAO;

    @InjectMocks
    private StudentServiceImpl studentService;

    private Students student;
    private StudentsDTO studentDTO;

    @BeforeEach
    void setUp() {
        student = StudentTestDataFactory.createDefaultStudent();
        studentDTO = StudentsDTO.builder()
                .stdId(1)
                .stdName("John")
                .stdRoll(101)
                .build();
    }

    @Test
    void test_CreateStudent_Successfully() {
        when(studentDAO.save(any(Students.class))).thenReturn(student);

        Students result = studentService.createStudent(studentDTO);

        assertNotNull(result);
        assertEquals(student.getStdId(), result.getStdId());
        assertEquals("John", result.getStdName());

        verify(studentDAO, times(1)).save(any(Students.class));
    }

    @Test
    void test_GetAllStudents_Successfully() {
        List<Students> studentsList = Collections.singletonList(student);

        when(studentDAO.findAll()).thenReturn(studentsList);

        List<Students> resultList = studentService.getAllStudents();

        assertEquals(1, resultList.size());
        assertEquals("John", resultList.get(0).getStdName());

        verify(studentDAO, times(1)).findAll();
    }

    @Test
    void test_GetStudentById_Successfully() {
        when(studentDAO.findById(1)).thenReturn(Optional.of(student));

        Students result = studentService.getStudentById(1);

        assertNotNull(result);
        assertEquals(1, result.getStdId());

        verify(studentDAO, times(1)).findById(1);
    }

    @Test
    void test_GetStudentById_NotFound() {
        when(studentDAO.findById(99)).thenReturn(Optional.empty());

        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> studentService.getStudentById(99)
        );

        assertFalse(thrown.getMessage().contains("No student with ID number: 99"));
    }

    @Test
    void test_GetStudentByName_Successfully() {
        when(studentDAO.findByStdName("John")).thenReturn(Optional.of(student));

        Students result = studentService.getStudentByName("John");

        assertNotNull(result);
        assertEquals("John", result.getStdName());

        verify(studentDAO, times(1)).findByStdName("John");
    }

    @Test
    void test_GetStudentByName_NotFound() {
        when(studentDAO.findByStdName("Unknown")).thenReturn(Optional.empty());

        EntityNotFoundException thrown = assertThrows(
                EntityNotFoundException.class,
                () -> studentService.getStudentByName("Unknown")
        );

        assertFalse(thrown.getMessage().contains("No student with name: Unknown"));
    }

    @Test
    void test_UpdateStudent_Successfully() {
        when(studentDAO.findById(1)).thenReturn(Optional.of(student));
        when(studentDAO.save(any(Students.class))).thenReturn(student);

        Students result = studentService.updateStudent(studentDTO);

        assertNotNull(result);
        assertEquals("John", result.getStdName());
        assertEquals(101, result.getStdRoll());

        verify(studentDAO, times(1)).save(any(Students.class));
    }

    @Test
    void test_UpdateStudent_StudentNotFound() {
        when(studentDAO.findById(1)).thenReturn(Optional.empty());

        ResponseStatusException thrown = assertThrows(
                ResponseStatusException.class,
                () -> studentService.updateStudent(studentDTO)
        );

        assertFalse(thrown.getMessage().contains("No student with ID number: 1"));
    }

    @Test
    void test_DeleteStudent_Successfully() {
        when(studentDAO.existsById(1)).thenReturn(true);

        boolean result = studentService.deleteStudent(1);

        assertTrue(result);
        verify(studentDAO, times(1)).deleteById(1);
    }

    @Test
    void test_DeleteStudent_StudentNotFound() {
        when(studentDAO.existsById(1)).thenReturn(false);

        EntityNotFoundException thrown = assertThrows(
                EntityNotFoundException.class,
                () -> studentService.deleteStudent(1)
        );

        assertTrue(thrown.getMessage().contains("1 is not found, can't be deleted"));
    }
}
