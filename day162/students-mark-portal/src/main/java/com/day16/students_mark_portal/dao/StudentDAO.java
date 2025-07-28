package com.day16.students_mark_portal.dao;

import com.day16.students_mark_portal.model.Students;
import com.day16.students_mark_portal.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class StudentDAO {

    @Autowired
    StudentRepository studentRepository;

    public Students save(Students students) {
        return studentRepository.save(students);
    }

    public boolean existsById(int id) {
        return studentRepository.existsById(id);
    }

    public List<Students> findAll() {
        return studentRepository.findAll();
    }

    public Optional<Students> findById(int id) {
        return studentRepository.findById(id);
    }

    public Optional<Students> findByStdName (String name) {
        return studentRepository.findByStdName(name);
    }

    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }
}
