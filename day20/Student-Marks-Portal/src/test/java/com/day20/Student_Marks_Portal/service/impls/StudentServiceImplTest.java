package com.day20.Student_Marks_Portal.service.impls;

import com.day20.Student_Marks_Portal.dao.StudentDAO;
import com.day20.Student_Marks_Portal.dto.StudentsDTO;
import com.day20.Student_Marks_Portal.model.Students;
import com.day20.Student_Marks_Portal.service.impls.StudentServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


class StudentServiceImplTest {

    @Mock
    private StudentDAO studentDAO;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Test
    void createStudentSuccessfully() {
        StudentsDTO dto = new StudentsDTO();
        dto.setStdName("John");
        dto.setStdRoll(101);

        Students student = new Students();
        student.setStdName("John");
        student.setStdRoll(101);

        Mockito.when(studentDAO.save(Mockito.any(Students.class))).thenReturn(student);

        Students result = studentService.createStudent(dto);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(dto.getStdName(), result.getStdName());
        Assertions.assertEquals(dto.getStdRoll(), result.getStdRoll());
    }

    @Test
    void getAllStudentsSuccessfully() {
        Students student1 = new Students();
        student1.setStdId(1);
        student1.setStdName("Alice");

        Students student2 = new Students();
        student2.setStdId(2);
        student2.setStdName("Bob");

        List<Students> studentList = Arrays.asList(student1, student2);

        Mockito.when(studentDAO.findAll()).thenReturn(studentList);

        List<Students> result = studentService.getAllStudents();

        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals("Alice", result.get(0).getStdName());
        Assertions.assertEquals("Bob", result.get(1).getStdName());
    }

    @Test
    void getStudentByIdSuccessfully() {
        Students student = new Students();
        student.setStdId(1);
        student.setStdName("Charlie");

        Mockito.when(studentDAO.findById(1)).thenReturn(Optional.of(student));

        Students result = studentService.getStudentById(1);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.getStdId());
        Assertions.assertEquals("Charlie", result.getStdName());
    }

    @Test
    void getStudentByIdThrowsWhenNotFound() {
        Mockito.when(studentDAO.findById(1)).thenReturn(Optional.empty());

        RuntimeException thrown = Assertions.assertThrows(
                RuntimeException.class,
                () -> studentService.getStudentById(1)
        );

        Assertions.assertTrue(thrown.getMessage().contains("1is not found"));
    }

    @Test
    void getStudentByNameSuccessfully() {
        Students student = new Students();
        student.setStdId(1);
        student.setStdName("David");

        Mockito.when(studentDAO.findByStdName("David")).thenReturn(Optional.of(student));

        Students result = studentService.getStudentByName("David");

        Assertions.assertNotNull(result);
        Assertions.assertEquals("David", result.getStdName());
    }

    @Test
    void getStudentByNameThrowsWhenNotFound() {
        Mockito.when(studentDAO.findByStdName("Eve")).thenReturn(Optional.empty());

        EntityNotFoundException thrown = Assertions.assertThrows(
                EntityNotFoundException.class,
                () -> studentService.getStudentByName("Eve")
        );

        Assertions.assertTrue(thrown.getMessage().contains("No named called Eve"));
    }

    @Test
    void updateStudentSuccessfully() {
        StudentsDTO dto = new StudentsDTO();
        dto.setStdId(1);
        dto.setStdName("Frank");
        dto.setStdRoll(202);

        Students existing = new Students();
        existing.setStdId(1);

        Mockito.when(studentDAO.findById(1)).thenReturn(Optional.of(existing));
        Mockito.when(studentDAO.save(Mockito.any(Students.class))).thenReturn(existing);

        Students result = studentService.updateStudent(dto);

        Assertions.assertNotNull(result);
        Assertions.assertEquals("Frank", result.getStdName());
        Assertions.assertEquals(202, result.getStdRoll());
    }

    @Test
    void updateStudentThrowsWhenNotFound() {
        StudentsDTO dto = new StudentsDTO();
        dto.setStdId(1);
        dto.setStdName("George");
        dto.setStdRoll(303);

        Mockito.when(studentDAO.findById(1)).thenReturn(Optional.empty());

        ResponseStatusException thrown = Assertions.assertThrows(
                ResponseStatusException.class,
                () -> studentService.updateStudent(dto)
        );

        Assertions.assertTrue(thrown.getReason().contains("1 is not found, can't be updated"));
    }

    @Test
    void deleteStudentSuccessfully() {
        Mockito.when(studentDAO.existsById(1)).thenReturn(true);

        boolean result = studentService.deleteStudent(1);

        Assertions.assertTrue(result);
        Mockito.verify(studentDAO).deleteById(1);
    }

    @Test
    void deleteStudentThrowsWhenNotFound() {
        Mockito.when(studentDAO.existsById(1)).thenReturn(false);

        EntityNotFoundException thrown = Assertions.assertThrows(
                EntityNotFoundException.class,
                () -> studentService.deleteStudent(1)
        );

        Assertions.assertTrue(thrown.getMessage().contains("1 is not found, can't be deleted"));
    }
}
