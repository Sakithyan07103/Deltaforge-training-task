package com.day20.Student_Marks_Portal.controller;

import com.day20.Student_Marks_Portal.dto.MarksDTO;
import com.day20.Student_Marks_Portal.model.Exams;
import com.day20.Student_Marks_Portal.model.Marks;
import com.day20.Student_Marks_Portal.model.Students;
import com.day20.Student_Marks_Portal.model.Subjects;
import com.day20.Student_Marks_Portal.service.impls.MarkServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MarksController.class)
class MarksControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MarkServiceImpl markService;

    @Autowired
    private ObjectMapper objectMapper;

    private Marks marks;
    private MarksDTO marksDTO;

    @BeforeEach
    void setUp() {
        Students student = new Students();
        student.setStdId(3);

        Subjects subject = new Subjects();
        subject.setSubId(2);

        Exams exam = new Exams();
        exam.setExamId(1);

        marks = new Marks();
        marks.setId(1);
        marks.setStudents(student);
        marks.setSubjects(subject);
        marks.setExams(exam);
        marks.setScore(75);

        marksDTO = new MarksDTO();
        marksDTO.setId(1);
        marksDTO.setStudentId(3);
        marksDTO.setSubjectId(2);
        marksDTO.setExamsId(1);
        marksDTO.setScore(75);
    }

    @Test
    void Test_CreateMarks_Successfully() throws Exception {
        Mockito.when(markService.createMarks(Mockito.any(MarksDTO.class))).thenReturn(marks);

        mockMvc.perform(post("/mark")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(marksDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.students.stdId").value(3))
                .andExpect(jsonPath("$.subjects.subId").value(2))
                .andExpect(jsonPath("$.exams.examId").value(1))
                .andExpect(jsonPath("$.score").value(75.0));
    }

    @Test
    void Test_GetAllMarks_Successfully() throws Exception {
        List<Marks> marksList = Arrays.asList(marks);

        Mockito.when(markService.getAllMarks()).thenReturn(marksList);

        mockMvc.perform(get("/mark"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].students.stdId").value(3));
    }

    @Test
    void Test_GetMarksById_Successfully() throws Exception {
        Mockito.when(markService.getMarksById(1)).thenReturn(marks);

        mockMvc.perform(get("/mark/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.students.stdId").value(3));
    }

    @Test
    void Test_UpdateMarks_Successfully() throws Exception {
        Mockito.when(markService.updateMarks(Mockito.any(MarksDTO.class))).thenReturn(marks);

        mockMvc.perform(put("/mark")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(marksDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.students.stdId").value(3))
                .andExpect(jsonPath("$.subjects.subId").value(2))
                .andExpect(jsonPath("$.exams.examId").value(1))
                .andExpect(jsonPath("$.score").value(75.0));
    }

    @Test
    void Test_DeleteMarks_Successfully() throws Exception {
        Mockito.when(markService.deleteMarks(1)).thenReturn(true);

        mockMvc.perform(delete("/mark/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }
}
