package com.day16.students_mark_portal.service.impls;

import com.day16.students_mark_portal.dao.StudentDAO;
import com.day16.students_mark_portal.dto.StudentsDTO;
import com.day16.students_mark_portal.model.Students;
import com.day16.students_mark_portal.service.serviceinterface.StudentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDAO studentDAO;

    public Students createStudent(StudentsDTO studentsDTO) {
        Students std = new Students();
        std.setStdName(studentsDTO.getStdName());
        std.setStdRoll(studentsDTO.getStdRoll());
        return studentDAO.save(std);
    }

    public List<Students> getAllStudents() {
        return studentDAO.findAll();
    }

    public Students getStudentById(int id) {
        return studentDAO.findById(id).orElseThrow(() ->
                new RuntimeException(id + "is not found"));
    }

    public Students getStudentByName(String stdName) {
        return studentDAO.findByStdName(stdName).orElseThrow(() ->
                new EntityNotFoundException("No named called " + stdName));
    }

    public Students updateStudent(StudentsDTO studentsDTO) {
        Optional<Students> students = studentDAO.findById(studentsDTO.getStdId());

        if (students.isPresent()) {
            Students std = students.get();
            std.setStdId(studentsDTO.getStdId());
            std.setStdName(studentsDTO.getStdName());
            std.setStdRoll(std.getStdRoll());

            return studentDAO.save(std);
        } else {
            return studentDAO.findById(studentsDTO.getStdId()).orElseThrow(() ->
                    new EntityNotFoundException(studentsDTO.getStdId() + "is not found, can't be updated"));
        }
    }

    public boolean deleteStudent(int id) {
        if (studentDAO.existsById(id)) {
            studentDAO.deleteById(id);
            return true;
        } else {
            throw new EntityNotFoundException(id + " is not found, can't be deleted");
        }
    }




}
