package com.day20.Student_Marks_Portal.service.impls;

import com.day20.Student_Marks_Portal.dao.StudentDAO;
import com.day20.Student_Marks_Portal.dto.StudentsDTO;
import com.day20.Student_Marks_Portal.model.Students;
import com.day20.Student_Marks_Portal.service.serviceinterface.StudentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
            std.setStdName(studentsDTO.getStdName());
            std.setStdRoll(studentsDTO.getStdRoll());

            return studentDAO.save(std);
        } else {
            return studentDAO.findById(studentsDTO.getStdId()).orElseThrow(() ->
                    new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            studentsDTO.getStdId() + " is not found, can't be updated"
                    ));
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
