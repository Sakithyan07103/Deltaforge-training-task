package com.day20.Student_Marks_Portal.repo;

import com.day20.Student_Marks_Portal.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Students, Integer> {
    Optional<Students> findByStdName(String stdName);
}
