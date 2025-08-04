package com.day20.Student_Marks_Portal.repo;

import com.day20.Student_Marks_Portal.model.Exams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exams, Integer> {
}
