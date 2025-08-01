package com.day18.Student_Marks_Portal.repo;

import com.day18.Student_Marks_Portal.model.Marks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarkRepository extends JpaRepository<Marks, Integer> {
}
