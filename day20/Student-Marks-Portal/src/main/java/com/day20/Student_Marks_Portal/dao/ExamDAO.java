package com.day20.Student_Marks_Portal.dao;


import com.day20.Student_Marks_Portal.model.Exams;
import com.day20.Student_Marks_Portal.repo.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
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
