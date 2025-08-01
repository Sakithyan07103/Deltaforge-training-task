package com.day18.Student_Marks_Portal.service.impls;


import com.day18.Student_Marks_Portal.dao.ExamDAO;
import com.day18.Student_Marks_Portal.dao.MarkDAO;
import com.day18.Student_Marks_Portal.dao.StudentDAO;
import com.day18.Student_Marks_Portal.dao.SubjectDAO;
import com.day18.Student_Marks_Portal.dto.MarksDTO;
import com.day18.Student_Marks_Portal.model.Exams;
import com.day18.Student_Marks_Portal.model.Marks;
import com.day18.Student_Marks_Portal.model.Students;
import com.day18.Student_Marks_Portal.model.Subjects;
import com.day18.Student_Marks_Portal.service.serviceinterface.MarkService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarkServiceImpl implements MarkService {
    @Autowired
    MarkDAO markDAO;

    @Autowired
    StudentDAO studentDAO;

    @Autowired
    SubjectDAO subjectDAO;

    @Autowired
    ExamDAO examDAO;

    public Marks createMarks(MarksDTO marksDTO) {
        Students std = studentDAO.findById(marksDTO.getStudentId()).orElseThrow(() ->
                new EntityNotFoundException("No student with ID number: " + marksDTO.getStudentId()));
        Subjects sub = subjectDAO.findById(marksDTO.getSubjectId()).orElseThrow(() ->
                new EntityNotFoundException("No subject with ID number: " + marksDTO.getSubjectId()));
        Exams exam = examDAO.findById(marksDTO.getExamsId()).orElseThrow(() ->
                new EntityNotFoundException("No exam with ID number: " + marksDTO.getExamsId()));
        Marks mark = new Marks();
        mark.setStudents(std);
        mark.setSubjects(sub);
        mark.setExams(exam);
        mark.setScore(marksDTO.getScore());
        return markDAO.save(mark);
    }

    public List<Marks> getAllMarks() {
        return markDAO.findAll();
    }

    public Marks getMarksById(int id) {
        return markDAO.findById(id).orElseThrow(() -> new EntityNotFoundException(id + "is not found"));
    }

    public Marks updateMarks(MarksDTO marksDTO) {
        Optional<Marks> optMarks = markDAO.findById(marksDTO.getId());
        if (optMarks.isPresent()) {
            Marks mark = optMarks.get();

            Students std = studentDAO.findById(marksDTO.getStudentId()).orElseThrow(() ->
                    new EntityNotFoundException("No student with ID number: " + marksDTO.getStudentId()));
            Subjects sub = subjectDAO.findById(marksDTO.getSubjectId()).orElseThrow(() ->
                    new EntityNotFoundException("No subject with ID number: " + marksDTO.getSubjectId()));
            Exams exam = examDAO.findById(marksDTO.getExamsId()).orElseThrow(() ->
                    new EntityNotFoundException("No exam with ID number: " + marksDTO.getExamsId()));

            mark.setStudents(std);
            mark.setSubjects(sub);
            mark.setExams(exam);

            return markDAO.save(mark);
        } else {
            return markDAO.findById(marksDTO.getId()).orElseThrow(() ->
                    new EntityNotFoundException(marksDTO.getId() + "is not found, can't be updated"));
        }
    }

    public boolean deleteMarks(int id) {
        if (markDAO.existsById(id)) {
            markDAO.deleteById(id);
            return true;
        } else {
            throw new EntityNotFoundException(id + " is not found, can't be deleted");
        }
    }
}
