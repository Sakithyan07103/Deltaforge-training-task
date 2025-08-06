package com.day20.Student_Marks_Portal.dao;

import com.day20.Student_Marks_Portal.data_factory.StudentTestDataFactory;
import com.day20.Student_Marks_Portal.model.Students;
import com.day20.Student_Marks_Portal.repo.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class StudentDAOTest {

    StudentRepository studentRepository;
    StudentDAO studentDAO;

    @BeforeEach
    void setUp() {
        studentRepository = mock(StudentRepository.class);
        studentDAO = new StudentDAO();

        var studentRepoField = StudentDAO.class.getDeclaredFields()[0];
        studentRepoField.setAccessible(true);

        try {
            studentRepoField.set(studentDAO, studentRepository);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void test_Save() {
        Students students = StudentTestDataFactory.createDefaultStudent();
        when(studentRepository.save(any(Students.class))).thenReturn(students);

        Students resultStudents = studentDAO.save(students);

        Assertions.assertNotNull(students);
        Assertions.assertEquals(1, resultStudents.getStdId());
    }

    @Test
    void test_FindAll() {
        Students students1 = StudentTestDataFactory.createDefaultStudent();
        Students students2 = StudentTestDataFactory.createDefaultStudent();
        when(studentRepository.findAll()).thenReturn(Arrays.asList(students1, students2));

        List<Students> studentList = studentDAO.findAll();

        Assertions.assertEquals(2, studentList.size());
        verify(studentRepository, times(1)).findAll();
    }

    void test_ExistById() {
        when(studentRepository.existsById(1)).thenReturn(true);

        boolean exist = studentDAO.existsById(1);

        Assertions.assertTrue(exist);
        verify(studentRepository, times(1)).existsById(1);
    }

    @Test
    void test_FindById_Found() {
        Students students = StudentTestDataFactory.createDefaultStudent();
        when(studentRepository.findById(1)).thenReturn(Optional.of(students));

        Optional<Students> studentsOptional = studentDAO.findById(1);

        Assertions.assertTrue(studentsOptional.isPresent());
        Assertions.assertEquals(1, studentsOptional.get().getStdId());
        verify(studentRepository, times(1)).findById(1);
    }

    @Test
    void test_FindById_NotFound() {
        when(studentRepository.findById(1)).thenReturn(Optional.empty());

        Optional<Students> studentsOptional = studentDAO.findById(1);

        Assertions.assertFalse(studentsOptional.isPresent());
        verify(studentRepository, times(1)).findById(1);
    }

    @Test
    void test_DeleteById() {
        doNothing().when(studentRepository).deleteById(1);

        studentDAO.deleteById(1);

        verify(studentRepository, times(1)).deleteById(1);
    }
}