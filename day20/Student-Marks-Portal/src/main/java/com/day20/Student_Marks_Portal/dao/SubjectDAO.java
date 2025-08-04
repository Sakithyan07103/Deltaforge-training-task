package com.day20.Student_Marks_Portal.dao;


import com.day20.Student_Marks_Portal.model.Subjects;
import com.day20.Student_Marks_Portal.repo.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
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
