package com.day14.students_mark_portal.dao;

import com.day14.students_mark_portal.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Students, Integer> {
}
