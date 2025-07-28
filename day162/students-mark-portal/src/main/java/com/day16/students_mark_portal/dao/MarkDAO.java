package com.day16.students_mark_portal.dao;

import com.day16.students_mark_portal.model.Marks;
import com.day16.students_mark_portal.repo.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MarkDAO {
    @Autowired
    MarkRepository markRepository;

    public Marks save(Marks marks) {
        return markRepository.save(marks);
    }

    public List<Marks> findAll() {
        return markRepository.findAll();
    }

    public Optional<Marks> findById(int id) {
        return markRepository.findById(id);
    }

    public void deleteById(int id) {
        markRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return markRepository.existsById(id);
    }
}
