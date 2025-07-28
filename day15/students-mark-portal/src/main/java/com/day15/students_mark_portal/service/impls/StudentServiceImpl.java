package com.day15.students_mark_portal.service.impls;

import com.day15.students_mark_portal.dto.StudentsDTO;
import com.day15.students_mark_portal.repo.StudentRepository;
import com.day15.students_mark_portal.model.Students;
import com.day15.students_mark_portal.service.serviceinterface.StudentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository stdRepo;

    public Students createStudent(StudentsDTO studentsDTO) {
        Students std = new Students();
        std.setStdName(studentsDTO.getStdName());
        std.setStdRoll(studentsDTO.getStdRoll());
        return stdRepo.save(std);
    }

    public List<Students> getAllStudents() {
        return stdRepo.findAll();
    }

    public Students getStudentById(int id) {
        return stdRepo.findById(id).orElseThrow(() ->
                new RuntimeException(id + "is not found"));
    }

    public Students getStudentByName(String stdName) {
        return stdRepo.findByStdName(stdName).orElseThrow(() ->
                new EntityNotFoundException("No named called " + stdName));
    }

    public Students updateStudent(StudentsDTO studentsDTO) {
        Optional<Students> students = stdRepo.findById(studentsDTO.getStdId());

        if (students.isPresent()) {
            Students std = students.get();
            std.setStdId(studentsDTO.getStdId());
            std.setStdName(studentsDTO.getStdName());
            std.setStdRoll(std.getStdRoll());

            return stdRepo.save(std);
        } else {
            return stdRepo.findById(studentsDTO.getStdId()).orElseThrow(() ->
                    new EntityNotFoundException(studentsDTO.getStdId() + "is not found, can't be updated"));
        }
    }

    public boolean deleteStudent(int id) {
        if (stdRepo.existsById(id)) {
            stdRepo.deleteById(id);
            return true;
        } else {
            throw new EntityNotFoundException(id + " is not found, can't be deleted");
        }
    }




}
