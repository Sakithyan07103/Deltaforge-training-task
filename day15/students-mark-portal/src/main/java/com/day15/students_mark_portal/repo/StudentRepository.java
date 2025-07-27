package com.day15.students_mark_portal.repo;

import com.day15.students_mark_portal.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Students, Integer> {
    Optional<Students> findStdBystdName(String stdName);
}
