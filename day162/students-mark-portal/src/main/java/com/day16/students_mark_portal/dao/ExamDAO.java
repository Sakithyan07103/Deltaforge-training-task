package com.day16.students_mark_portal.dao;

import com.day16.students_mark_portal.model.Exams;
import com.day16.students_mark_portal.model.Students;
import com.day16.students_mark_portal.repo.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ExamDAO {
    @Autowired
    ExamRepository examRepository;

    public Exams save(Exams exams) {
        return examRepository.save(exams);
    }

    public boolean existsById(int id) {
        return examRepository.existsById(id);
    }

    public List<Exams> findAll() {
        return examRepository.findAll();
    }

    public Optional<Exams> findById(int id) {
        return examRepository.findById(id);
    }

    public void deleteById(int id) {
        examRepository.deleteById(id);
    }
}
