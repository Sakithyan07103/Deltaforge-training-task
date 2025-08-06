package com.day20.Student_Marks_Portal.dao;

import com.day20.Student_Marks_Portal.data_factory.SubjectTestDataFactory;
import com.day20.Student_Marks_Portal.model.Subjects;
import com.day20.Student_Marks_Portal.repo.StudentRepository;
import com.day20.Student_Marks_Portal.repo.SubjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class SubjectDAOTest {

    private SubjectRepository subjectRepository;
    private SubjectDAO subjectDAO;

    @BeforeEach
    void test_SetUp() throws Exception {
        subjectRepository = mock(SubjectRepository.class);
        subjectDAO = new SubjectDAO();

        var subjectRepoField = SubjectDAO.class.getDeclaredFields()[0];
        subjectRepoField.setAccessible(true);

        try {
            subjectRepoField.set(subjectDAO, subjectRepository);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void test_SaveSubject() {
        Subjects subject = SubjectTestDataFactory.createDefaultSubject();
        when(subjectRepository.save(any(Subjects.class))).thenReturn(subject);

        Subjects savedSubject = subjectDAO.save(subject);

        assertNotNull(savedSubject);
        assertEquals(1, savedSubject.getSubId());
        verify(subjectRepository, times(1)).save(any(Subjects.class));
    }

    @Test
    void test_FindAllSubjects() {
        Subjects sub1 = SubjectTestDataFactory.createDefaultSubject();
        Subjects sub2 = SubjectTestDataFactory.createDefaultSubject();
        when(subjectRepository.findAll()).thenReturn(Arrays.asList(sub1, sub2));

        List<Subjects> resultList = subjectDAO.findAll();

        assertEquals(2, resultList.size());
        verify(subjectRepository, times(1)).findAll();
    }

    @Test
    void test_ExistsById_True() {
        when(subjectRepository.existsById(1)).thenReturn(true);

        boolean exists = subjectDAO.existsById(1);

        assertTrue(exists);
        verify(subjectRepository, times(1)).existsById(1);
    }

    @Test
    void test_ExistsById_False() {
        when(subjectRepository.existsById(2)).thenReturn(false);

        boolean exists = subjectDAO.existsById(2);

        assertFalse(exists);
        verify(subjectRepository, times(1)).existsById(2);
    }

    @Test
    void test_FindById_Present() {
        Subjects subject = SubjectTestDataFactory.createDefaultSubject();
        when(subjectRepository.findById(5)).thenReturn(Optional.of(subject));

        Optional<Subjects> result = subjectDAO.findById(5);

        assertTrue(result.isPresent());
        assertEquals(5, result.get().getSubId());
        verify(subjectRepository, times(1)).findById(5);
    }

    @Test
    void test_FindById_Empty() {
        when(subjectRepository.findById(10)).thenReturn(Optional.empty());

        Optional<Subjects> result = subjectDAO.findById(10);

        assertFalse(result.isPresent());
        verify(subjectRepository, times(1)).findById(10);
    }

    @Test
    void test_DeleteById() {
        doNothing().when(subjectRepository).deleteById(3);

        subjectDAO.deleteById(3);

        verify(subjectRepository, times(1)).deleteById(3);
    }
}
