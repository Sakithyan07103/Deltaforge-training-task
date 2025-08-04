package com.day20.Student_Marks_Portal.controller;

import com.day20.Student_Marks_Portal.dto.StudentsDTO;
import com.day20.Student_Marks_Portal.model.Students;
import com.day20.Student_Marks_Portal.service.impls.StudentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentServiceImpl studentService;

    @Autowired
    private ObjectMapper objectMapper;

    private Students student;
    private StudentsDTO studentDTO;

    @BeforeEach
    void setUp() {
        student = new Students();
        student.setStdId(1);
        student.setStdName("John");
        student.setStdRoll(101);

        studentDTO = new StudentsDTO();
        studentDTO.setStdId(1);
        studentDTO.setStdName("John");
        studentDTO.setStdRoll(101);
    }

    @Test
    void createStudentSuccessfully() throws Exception {
        Mockito.when(studentService.createStudent(Mockito.any(StudentsDTO.class))).thenReturn(student);

        mockMvc.perform(post("/std")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(studentDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.stdId").value(1))
                .andExpect(jsonPath("$.stdName").value("John"))
                .andExpect(jsonPath("$.stdRoll").value(101));
    }

    @Test
    void getAllStudentsSuccessfully() throws Exception {
        List<Students> studentList = Arrays.asList(student);

        Mockito.when(studentService.getAllStudents()).thenReturn(studentList);

        mockMvc.perform(get("/std"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].stdName").value("John"));
    }

    @Test
    void getStudentByIdSuccessfully() throws Exception {
        Mockito.when(studentService.getStudentById(1)).thenReturn(student);

        mockMvc.perform(get("/std/id/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.stdId").value(1))
                .andExpect(jsonPath("$.stdName").value("John"));
    }

    @Test
    void getStudentByNameSuccessfully() throws Exception {
        Mockito.when(studentService.getStudentByName("John")).thenReturn(student);

        mockMvc.perform(get("/std/name/John"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.stdName").value("John"))
                .andExpect(jsonPath("$.stdRoll").value(101));
    }

    @Test
    void updateStudentSuccessfully() throws Exception {
        Mockito.when(studentService.updateStudent(Mockito.any(StudentsDTO.class))).thenReturn(student);

        mockMvc.perform(put("/std")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(studentDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.stdId").value(1))
                .andExpect(jsonPath("$.stdName").value("John"))
                .andExpect(jsonPath("$.stdRoll").value(101));
    }

    @Test
    void deleteStudentSuccessfully() throws Exception {
        Mockito.when(studentService.deleteStudent(1)).thenReturn(true);

        mockMvc.perform(delete("/std/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }
}
