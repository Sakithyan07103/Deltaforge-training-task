package com.day17.Student_Marks_Portal.repo;

import com.day17.Student_Marks_Portal.model.Exams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exams, Integer> {
}
