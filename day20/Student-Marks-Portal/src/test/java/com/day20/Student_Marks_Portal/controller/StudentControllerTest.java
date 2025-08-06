package com.day20.Student_Marks_Portal.controller;

import com.day20.Student_Marks_Portal.data_factory.StudentTestDataFactory;
import com.day20.Student_Marks_Portal.dto.StudentsDTO;
import com.day20.Student_Marks_Portal.model.Students;
import com.day20.Student_Marks_Portal.service.impls.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentControllerTest {

    @Autowired
    private StudentController studentController;
    private StudentServiceImpl studentService;

    private Students student;
    private StudentsDTO studentDTO;

    @BeforeEach
    void setUp() {
        studentService = mock(StudentServiceImpl.class);
        studentController = new StudentController(studentService);

        student = StudentTestDataFactory.createDefaultStudent();
        studentDTO = StudentsDTO.builder().stdId(1).stdName("john").stdRoll(101).build();
    }

    @Test
    void test_CreateStudentSuccessfully() {
        when(studentService.createStudent(any(StudentsDTO.class))).thenReturn(student);

        Students result = studentController.createStudent(studentDTO);

        assertNotNull(result);
        assertEquals(1, result.getStdId());
        assertEquals("John", result.getStdName());
        assertEquals(101, result.getStdRoll());

        verify(studentService, times(1)).createStudent(studentDTO);
    }

    @Test
    void test_GetAllStudentsSuccessfully() {
        when(studentService.getAllStudents()).thenReturn(List.of(student));

        List<Students> resultList = studentController.getAllStudents();

        assertEquals(1, resultList.size());
        assertEquals("John", resultList.get(0).getStdName());

        verify(studentService, times(1)).getAllStudents();
    }

    @Test
    void test_GetStudentByIdSuccessfully() {
        when(studentService.getStudentById(1)).thenReturn(student);

        Students result = studentController.getStudentById(1);

        assertNotNull(result);
        assertEquals(1, result.getStdId());
        assertEquals("John", result.getStdName());

        verify(studentService, times(1)).getStudentById(1);
    }

    @Test
    void test_GetStudentByNameSuccessfully() {
        when(studentService.getStudentByName("John")).thenReturn(student);

        Students result = studentController.getStudentByName("John");

        assertNotNull(result);
        assertEquals("John", result.getStdName());

        verify(studentService, times(1)).getStudentByName("John");
    }

    @Test
    void test_UpdateStudentSuccessfully() {
        when(studentService.updateStudent(any(StudentsDTO.class))).thenReturn(student);

        Students result = studentController.updateStudent(studentDTO);

        assertNotNull(result);
        assertEquals(1, result.getStdId());
        assertEquals("John", result.getStdName());

        verify(studentService, times(1)).updateStudent(studentDTO);
    }

    @Test
    void test_DeleteStudentSuccessfully() {
        when(studentService.deleteStudent(1)).thenReturn(true);

        boolean deleted = studentController.deleteStudent(1);

        assertTrue(deleted);
        verify(studentService, times(1)).deleteStudent(1);
    }
}
