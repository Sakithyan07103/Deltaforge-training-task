package com.day19.Student_Marks_Portal.repo;

import com.day19.Student_Marks_Portal.model.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subjects, Integer> {
}
