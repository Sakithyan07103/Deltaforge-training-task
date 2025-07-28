package com.day16.students_mark_portal.dao;

import com.day16.students_mark_portal.model.Students;
import com.day16.students_mark_portal.model.Subjects;
import com.day16.students_mark_portal.repo.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class SubjectDAO {

    @Autowired
    SubjectRepository subjectRepository;

    public Subjects save(Subjects students) {
        return subjectRepository.save(students);
    }

    public boolean existsById(int id) {
        return subjectRepository.existsById(id);
    }

    public List<Subjects> findAll() {
        return subjectRepository.findAll();
    }

    public Optional<Subjects> findById(int id) {
        return subjectRepository.findById(id);
    }

    public void deleteById(int id) {
        subjectRepository.deleteById(id);
    }
}
