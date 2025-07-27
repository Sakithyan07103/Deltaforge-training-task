package com.day15.students_mark_portal.repo;

import com.day15.students_mark_portal.model.Exams;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exams, Integer> {
}
